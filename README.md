# 스프링 기반 멀티모듈 프로젝트 뼈대 구성 프로젝트
  ## 1. api <- 사용자 API 
  ## 2. admin <- 관리자  API
  ## 3. batch <- 통계 데이터 , 이벤트등 해당 날짜에 처리해야될 잡을 batch를 통해 작업
  ## 4. core <- 프로젝트 Core 부분  엔티티, 리포지토리, DTO, Mapper,Config,Util ,QueryDSL 등 api, admin에서 공통으로 사용할 리소스 위치
  ## 5. QueryDSL 모듈 추가
  
# 2023-11-07 리퀴베이스 모듈 추가

# 2023-11-08 추가내용
  ### 1. 리퀴베이스 리소스 접근시 중복리소스 감지 경고때문에 yml 파일 core 에서 각 모듈로 전파
     1-1 : application.yml 파일 각 모듈별 생성
     1-2 : core:application.yml 파일을 공통 리소스로 접근하도록 수정
     1-3 : admin, api,batch:application-모듈명.yml 파일을 생성해서 각각의 모듈별 DB분리 혹은 PORT 분리 설정 추가 할 수 있도록 수정

  ### 2. javax.persistence -> jakarta.persistence 참조로 의존성 변경함 (업데이트)
  
  ### 3.  실행시 활성화 프로파일 적용으로 가각의 모듈에서 자신의 설정파일 접근 가능하도록 수정
     3-1 :  자신만의 DB나, 설정이 필요한 경우 프로파일별 실행 가능하도록 수정함.

    
