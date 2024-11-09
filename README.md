
# 스프링 부트 멀티 모듈 프로젝트 구조

이 프로젝트는 사용자 및 관리자 API, 스케줄링 배치 작업, 그리고 공통 자원을 다루기 위해 멀티 모듈로 설계된 스프링 부트 기반 프로젝트입니다. 이 구조를 통해 API, 관리자, 배치, 그리고 핵심 기능들을 각각 모듈화하여 프로젝트를 효율적으로 관리할 수 있습니다.

## 프로젝트 모듈 개요

1. **api** - 사용자에게 제공되는 API 엔드포인트 및 비즈니스 로직을 처리하는 모듈입니다.

2. **admin** - 관리자 전용 API 엔드포인트와 관련 비즈니스 로직을 관리하는 모듈입니다.

3. **batch** - 통계 데이터 처리, 이벤트 관리 등 정해진 날짜 또는 주기에 따라 실행되어야 하는 배치 작업을 처리하는 모듈입니다.

4. **core** - 프로젝트의 핵심이 되는 공통 모듈로, `api`와 `admin` 모듈에서 공통으로 사용하는 자원들을 포함하고 있습니다. `core` 모듈에는 다음이 포함됩니다:
  - 엔티티
  - 리포지토리
  - DTO
  - 매퍼
  - 설정 파일
  - 유틸리티 클래스
  - QueryDSL 설정

## QueryDSL 설정

프로젝트는 동적 쿼리 생성을 위해 QueryDSL을 사용하도록 구성되었습니다. QueryDSL은 Java에서 SQL 쿼리를 생성할 때 타입 안정성과 가독성을 높여줍니다.

### 멀티 모듈 프로젝트에서 QueryDSL 설정 단계

1. **QueryDSL 의존성 추가**: `root` 모듈의 `build.gradle`에 다음 의존성을 추가합니다.

    ```groovy

    /* QueryDSL 라이브러리를 사용하는 모듈 리스트 */
    def querydslProjects = [
      project(":core"),
      project(":api"),
      project(":admin"),
      project(":batch")
    ]
    
    configure(querydslProjects) {
    
        apply plugin: "io.spring.dependency-management"
    
        dependencies {
            //Querydsl 추가
            implementation 'com.querydsl:querydsl-jpa:5.1.0:jakarta'
            annotationProcessor "com.querydsl:querydsl-apt:${dependencyManagement.importedProperties['querydsl.version']}:jakarta"
            annotationProcessor "jakarta.annotation:jakarta.annotation-api"
            annotationProcessor "jakarta.persistence:jakarta.persistence-api"
    
            compileOnly 'org.projectlombok:lombok'
            annotationProcessor 'org.projectlombok:lombok'
        }
    
        def generated = 'src/main/generated'
    
        sourceSets {
            main.java.srcDirs += [generated]
        }
    
        tasks.withType(JavaCompile).configureEach {
            options.generatedSourceOutputDirectory = file(generated)
        }
    
        clean.doLast {
            file(generated).deleteDir()
        }
    }
    ```

# 멀티 모듈 프로젝트 빌드 구성

이 문서는 `root build.gradle` 파일의 구성 개요를 제공하며, 다음과 같은 멀티 모듈 프로젝트 구조를 설명합니다:

- **api** - 사용자 API 모듈
- **admin** - 관리자 API 모듈
- **batch** - 통계 데이터, 이벤트 등 일정에 따라 실행되는 배치 작업 모듈
- **core** - 공통 자원 모듈로, 엔티티, 리포지토리, DTO, 매퍼, 설정, 유틸리티, QueryDSL 설정 등을 포함하여 `api`와 `admin` 모듈에서 공통으로 사용됩니다.

## Root build.gradle 구성 개요

### 1. 프로젝트 전반 설정

- **Spring Boot 및 Java 버전**:
  - 프로젝트는 Java 17(`JavaVersion.VERSION_17`)과 Spring Boot 버전 `3.1.4`를 사용합니다.
- **플러그인 및 의존성 관리**:
  - `io.spring.dependency-management`와 `org.springframework.boot` 플러그인을 적용하여 의존성을 관리하고 호환성을 보장합니다.

### 2. 루트 프로젝트 태스크 비활성화

루트 프로젝트에 불필요한 아티팩트가 생성되지 않도록 하기 위해 다음 태스크들이 비활성화되었습니다:
- **`build`** - 루트 레벨에서 빌드 디렉터리가 생성되지 않도록 설정합니다.
- **`assemble`** - 루트 레벨에서 어셈블리 태스크를 비활성화합니다.
- **`compileJava`** - 루트 프로젝트의 Java 컴파일을 비활성화합니다.
- **`bootJar` 및 `jar`** - 루트 프로젝트의 패키징 태스크를 비활성화합니다.

### 3. Core 모듈 특정 설정

- `core` 모듈의 `test` 태스크가 비활성화되어 불필요한 테스트 실행을 줄이고 빌드 시간을 단축합니다.

### 4. 서브프로젝트 공통 설정

모든 서브프로젝트에 다음 구성이 적용됩니다:
- **Java 17 호환성**:
  - 서브프로젝트는 `JavaVersion.VERSION_17`을 사용하도록 설정되어 있습니다.
- **Lombok 통합**:
  - `Lombok`을 모든 서브프로젝트에서 사용할 수 있도록 `compileOnly`와 `annotationProcessor` 설정에 추가되어 있습니다.
- **의존성**:
  - `jakarta.persistence-api:3.1.0`이 사용되어 최신 Jakarta Persistence API와 호환됩니다.
  - 다른 공통 의존성으로는 다음이 포함됩니다:
    - **Liquibase** - 데이터베이스 마이그레이션용
    - **MySQL Connector** - MySQL 데이터베이스 연결용
    - **Apache Commons** 라이브러리 - 추가 유틸리티 제공
    - **springdoc-openapi** - API 문서화를 위한 의존성
    - **spring-boot-starter-test** - 테스트용, JUnit Vintage는 제외됩니다.

### 5. QueryDSL 설정

QueryDSL은 동적 쿼리 생성을 위해 `core`, `api`, `admin`, `batch` 모듈에 설정되었습니다.

- **QueryDSL 소스 생성**:
  - 생성된 소스는 `src/main/generated` 디렉터리에 저장됩니다.
  - `clean` 태스크 실행 시 해당 디렉터리를 삭제하도록 구성합니다.

### 프로젝트 빌드 및 실행 방법

1. **프로젝트 빌드**:

   모든 모듈을 빌드하려면 다음 명령어를 사용하세요:

   ```bash
   ./gradlew clean build
   ```

2. **특정 모듈 실행**:

  - **API 모듈**: 사용자 전용 API를 시작하려면 다음 명령어를 사용하세요:

    ```bash
    ./gradlew :api:bootRun
    ```

  - **Admin 모듈**: 관리자 전용 API를 시작하려면 다음 명령어를 사용하세요:

    ```bash
    ./gradlew :admin:bootRun
    ```

  - **Batch 모듈**: 배치 처리 모듈을 시작하려면 다음 명령어를 사용하세요:

    ```bash
    ./gradlew :batch:bootRun
    ```

### 추가 사항

- **Core 모듈 의존성**:
  - 공통 자원에 접근하기 위해 `core` 모듈을 `api`와 `admin` 모듈의 의존성에 추가해야 합니다.

- **QueryDSL 클래스**:
  - 생성된 QueryDSL 클래스는 `src/main/generated`에 위치하여 쉽게 접근할 수 있습니다.

이 구성을 통해 멀티 모듈 스프링 부트 프로젝트를 효율적으로 관리할 수 있으며, 각 모듈의 역할을 독립적으로 수행하도록 돕습니다.


# Core 모듈 build.gradle 설정 설명

이 문서는 Core 모듈의 `build.gradle` 설정에 대한 설명을 제공합니다.

## 빌드 설정

- **bootJar 비활성화**: Core 모듈에서는 `bootJar` 태스크가 비활성화되어 있으며, 이는 Core 모듈이 실행 가능한 JAR 파일을 생성할 필요가 없기 때문입니다.
- **jar 활성화**: 일반 JAR 파일 생성을 위해 `jar` 태스크는 활성화되어 있습니다.

## 의존성 설정

- **JPA 의존성**:
  - `spring-boot-starter-data-jpa`를 통해 JPA 기반의 데이터 접근 기능을 제공합니다.
  - `jakarta.persistence-api:3.1.0`을 추가하여 최신 Jakarta Persistence API와의 호환성을 확보했습니다.

- **테스트 의존성**:
  - `spring-boot-starter-test`로 테스트 기능을 지원하며, JUnit 및 기타 테스트 유틸리티가 포함되어 있습니다.
  - `junit-jupiter-api`와 `mockito-core`를 추가하여 JUnit과 Mockito를 사용한 단위 테스트 및 목(mock) 테스트가 가능합니다.

- **Lombok**:
  - `Lombok`을 포함하여 getter, setter, builder 등의 코드 생성을 단순화합니다. 이를 위해 `compileOnly`와 `annotationProcessor`로 설정되어 있습니다.

- **MapStruct**:
  - `MapStruct`는 DTO와 엔티티 간의 매핑을 자동화하기 위해 사용되며, `mapstruct` 및 `mapstruct-processor`가 추가되어 있습니다.

- **Spring Boot Starter Validation**:
  - `spring-boot-starter-validation`을 통해 데이터 유효성 검사를 지원합니다.

- **Jackson**:
  - `jackson-databind`와 `jackson-datatype-jsr310`을 포함하여 JSON 직렬화 및 역직렬화 기능을 제공합니다. 특히 `jackson-datatype-jsr310`은 Java 8의 날짜와 시간을 처리하는 데 필요한 지원을 추가합니다.

이 설정을 통해 Core 모듈은 JPA 기반의 데이터 접근, 데이터 유효성 검사, DTO 매핑, JSON 처리, 최신 Jakarta Persistence API와 호환성, 그리고 Lombok을 통한 코드 간결화 기능을 제공합니다.


# Batch 모듈 build.gradle 설정 설명

이 문서는 Batch 모듈의 `build.gradle` 설정에 대한 설명을 제공합니다.

## 빌드 설정
- **bootJar 활성화**: API 모듈에서는 `bootJar` 태스크가 활성화되어 있어, 실행 가능한 Spring Boot 애플리케이션 JAR 파일을 생성할 수 있습니다.
- **jar 비활성화**: 일반 JAR 파일 생성은 필요하지 않으므로 `jar` 태스크는 비활성화되어 있습니다.

## 리소스 설정

- **리퀴베이스 설정을 위한 소스 세트**:
  -  아래 설정 제거함
  - ~~`../core/src/main/resources` 디렉터리를 API 모듈의 리소스 경로에 추가하여 `core` 모듈의 리소스를 사용할 수 있습니다.~~
  - ~~`exclude '**/db/changelog/**'` 설정을 통해 필요에 따라 특정 리소스를 제외할 수 있습니다.~~

## 의존성 설정

- **core 모듈 의존성**:
  - 공통 엔티티와 리포지토리를 사용하기 위해 `core` 모듈이 의존성으로 추가되어 있습니다.

- **Apache POI**:
  - `org.apache.poi:poi:5.3.0` 및 `org.apache.poi:poi-ooxml:5.3.0` 라이브러리를 포함하여 Excel 파일을 처리할 수 있습니다.

- **Spring Batch**:
  - `spring-boot-starter-batch` 의존성이 추가되어 스프링 배치 기능을 지원합니다.
  - `spring-batch-test`를 통해 배치 작업에 대한 테스트 기능을 사용할 수 있습니다.

- **JPA 의존성**:
  - `spring-boot-starter-data-jpa`를 통해 JPA 기반의 데이터 접근 기능을 제공합니다.

- **Apache Derby**:
  - `org.apache.derby:derby:10.17.1.0`이 포함되어 있어 임베디드 데이터베이스를 사용할 수 있습니다.

- **테스트 의존성**:
  - `spring-boot-starter-test` 의존성을 추가하여 JUnit 및 기타 테스트 유틸리티를 제공합니다.

이 설정을 통해 Batch 모듈은 스프링 배치 기능, Excel 파일 처리, JPA 기반 데이터 접근, 임베디드 데이터베이스, 그리고 테스트 기능을 활용할 수 있습니다.


# API 모듈 build.gradle 설정 설명

이 문서는 API 모듈의 `build.gradle` 설정에 대한 설명을 제공합니다.

## 빌드 설정

- **bootJar 활성화**: API 모듈에서는 `bootJar` 태스크가 활성화되어 있어, 실행 가능한 Spring Boot 애플리케이션 JAR 파일을 생성할 수 있습니다.
- **jar 비활성화**: 일반 JAR 파일 생성은 필요하지 않으므로 `jar` 태스크는 비활성화되어 있습니다.

## 리소스 설정

- **리퀴베이스 설정을 위한 소스 세트**:
  -  아래 설정 제거함
  - ~~`../core/src/main/resources` 디렉터리를 API 모듈의 리소스 경로에 추가하여 `core` 모듈의 리소스를 사용할 수 있습니다.~~
  - ~~`exclude '**/db/changelog/**'` 설정을 통해 필요에 따라 특정 리소스를 제외할 수 있습니다.~~

## 의존성 설정

- **core 모듈 의존성**:
  - 공통 엔티티와 리포지토리 등을 사용하기 위해 `core` 모듈이 의존성으로 추가되어 있습니다.

- **Apache POI**:
  - `org.apache.poi:poi:5.3.0` 및 `org.apache.poi:poi-ooxml:5.3.0` 라이브러리가 포함되어 있어 Excel 파일을 처리할 수 있습니다.

- **Spring Boot Starter Web**:
  - `spring-boot-starter-web` 의존성을 추가하여 웹 애플리케이션 및 REST API 기능을 제공합니다.

- **Spring Boot Starter Data JPA**:
  - `spring-boot-starter-data-jpa` 의존성을 통해 JPA를 사용한 데이터베이스 접근 기능을 제공합니다.

- **Lombok**:
  - `Lombok` 라이브러리가 포함되어 있어 getter, setter 등의 코드 생성을 단순화합니다. `compileOnly`와 `annotationProcessor`로 설정되어 있습니다.

- **Spring Boot Starter Test**:
  - `spring-boot-starter-test` 의존성으로 테스트 기능을 지원하며, JUnit 및 기타 테스트 유틸리티가 포함되어 있습니다.

이와 같은 설정을 통해 API 모듈은 `core` 모듈과의 연동, Apache POI를 통한 Excel 파일 처리, JPA를 통한 데이터베이스 접근, Lombok을 통한 코드 간결화 및 Spring Boot의 웹 및 테스트 기능을 사용할 수 있습니다.



# Admin 모듈 build.gradle 설정 설명

이 문서는 Admin 모듈의 `build.gradle` 설정에 대한 설명을 제공합니다.

## 빌드 설정

- **bootJar 활성화**: Admin 모듈에서는 `bootJar` 태스크가 활성화되어 있어, 실행 가능한 Spring Boot 애플리케이션 JAR 파일을 생성할 수 있습니다.
- **jar 비활성화**: 일반 JAR 파일 생성은 필요하지 않으므로 `jar` 태스크는 비활성화되어 있습니다.

## 리소스 설정

- **리퀴베이스 설정을 위한 소스 세트**:
  -  아래 설정 제거함
  - ~~`../core/src/main/resources` 디렉터리를 API 모듈의 리소스 경로에 추가하여 `core` 모듈의 리소스를 사용할 수 있습니다.~~
  - ~~`exclude '**/db/changelog/**'` 설정을 통해 필요에 따라 특정 리소스를 제외할 수 있습니다.~~

## 의존성 설정

- **core 모듈 의존성**:
  - 공통 엔티티와 리포지토리 등을 사용하기 위해 `core` 모듈이 의존성으로 추가되어 있습니다.

- **Apache POI**:
  - `org.apache.poi:poi:5.3.0` 및 `org.apache.poi:poi-ooxml:5.3.0` 라이브러리가 포함되어 있어 Excel 파일을 처리할 수 있습니다.

- **Spring Boot Starter Web**:
  - `spring-boot-starter-web` 의존성을 추가하여 웹 애플리케이션 및 REST API 기능을 제공합니다.

- **Spring Boot Starter Data JPA**:
  - `spring-boot-starter-data-jpa` 의존성을 통해 JPA를 사용한 데이터베이스 접근 기능을 제공합니다.

- **Lombok**:
  - `Lombok` 라이브러리가 포함되어 있어 getter, setter 등의 코드 생성을 단순화합니다. `compileOnly`와 `annotationProcessor`로 설정되어 있습니다.

- **Spring Boot Starter Test**:
  - `spring-boot-starter-test` 의존성으로 테스트 기능을 지원하며, JUnit 및 기타 테스트 유틸리티가 포함되어 있습니다.

이와 같은 설정을 통해 Admin 모듈은 `core` 모듈과의 연동, Apache POI를 통한 Excel 파일 처리, JPA를 통한 데이터베이스 접근, Lombok을 통한 코드 간결화 및 Spring Boot의 웹 및 테스트 기능을 사용할 수 있습니다.


# MySQL 데이터베이스 및 사용자 설정 가이드

이 가이드는 MySQL 데이터베이스와 사용자 계정을 특정 권한으로 생성하는 방법에 대한 단계별 설명을 제공합니다.

## 사전 준비 사항
- MySQL이 시스템에 설치되어 있고 MySQL 서버가 실행 중인지 확인하세요.
- 데이터베이스와 사용자 계정을 생성하기 위해 루트 사용자 비밀번호가 필요합니다.

## 데이터베이스 및 사용자 생성 단계

### 1단계: MySQL에 로그인
루트 사용자로 MySQL에 로그인하려면 터미널에서 다음 명령어를 실행하세요:

```bash
mysql -u root -p
```

루트 사용자 비밀번호를 입력하라는 메시지가 나타납니다.

### 2단계: 데이터베이스 생성
로그인한 후 새로운 데이터베이스를 생성합니다. 여기서는 `klaatus`라는 이름의 데이터베이스를 예제로 사용하겠습니다.

```sql
CREATE DATABASE klaatus;
```

### 3단계: 사용자 생성 및 권한 부여
이제 새로운 MySQL 사용자를 생성하고, 방금 생성한 데이터베이스에 대한 권한을 부여합니다. `klaatus`와 `1234`를 원하는 사용자 이름과 비밀번호로 대체하여 사용하세요.

```sql
CREATE USER 'klaatus'@'localhost' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON klaatus.* TO 'klaatus'@'localhost';
FLUSH PRIVILEGES;
```

이 명령어는 `klaatus`라는 사용자를 생성하고 `klaatus` 데이터베이스에 대한 모든 권한을 부여합니다.

### 4단계: MySQL에서 로그아웃
모든 작업이 완료되면 다음 명령어로 MySQL에서 로그아웃할 수 있습니다:

```sql
EXIT;
```

### 추가 참고 사항
- 사용자 및 데이터베이스 이름은 고유해야 하므로 필요에 따라 수정하세요.
- 생성한 사용자로 데이터베이스에 접속하려면 다음 명령어를 사용하세요:

```bash
mysql -u klaatus -p
```

비밀번호 입력 시 `1234`를 입력하여 로그인합니다.

## 문제 해결
- 문제가 발생할 경우 MySQL이 실행 중인지, 사용자가 데이터베이스와 사용자 생성을 위한 권한을 가지고 있는지 확인하세요.
- 사용자가 모든 호스트에서 접근할 수 있도록 하려면 `localhost`를 `%`로 변경할 수 있지만, 보안 위험이 있을 수 있습니다.

---

이 단계들을 완료하면 MySQL 데이터베이스와 사용자가 성공적으로 설정됩니다!




  
# 2023-11-07 리퀴베이스 모듈 추가

# 2023-11-08 추가내용
  ### 1. 리퀴베이스 리소스 접근시 중복리소스 감지 경고때문에 yml 파일 core 에서 각 모듈로 전파
     1-1 : application.yml 파일 각 모듈별 생성
     1-2 : core:application.yml 파일을 공통 리소스로 접근하도록 수정
     1-3 : admin, api,batch:application-모듈명.yml 파일을 생성해서 각각의 모듈별 DB분리 혹은 PORT 분리 설정 추가 할 수 있도록 수정

  ### 2. javax.persistence -> jakarta.persistence 참조로 의존성 변경함 (업데이트)
  
  ### 3.  실행시 활성화 프로파일 적용으로 가각의 모듈에서 자신의 설정파일 접근 가능하도록 수정
     3-1 :  자신만의 DB나, 설정이 필요한 경우 프로파일별 실행 가능하도록 수정함.

    
