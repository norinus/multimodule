### 스프링 기반 멀티모듈 프로젝트 뼈대 구성 프로젝트

* api <- 사용자 API 
* admin <- 관리자  API
* batch <- 통계 데이터 , 이벤트등 해당 날짜에 처리해야될 잡을 batch를 통해 작업
* core <- 프로젝트 Core 부분  엔티티, 리포지토리, DTO, Mapper,Config,Util 등 api, admin에서 공통으로 사용할 리소스 위치
