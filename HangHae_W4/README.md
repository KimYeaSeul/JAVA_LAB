## 회원가입, 로그인, 댓글 작성/수정/삭제 기능이 추가된 나만의 블로그 백엔드 서버 만들기

### 🛠Enviroment
- JAVA JDK 11
- Spring 2.7.2
- AWS RDS MySQL 8


🗂 Libraries
- spring-boot-starter-web
- spring-boot-stater-security
- spring-boot-starter-data-jpa
- h2
- mysql-connector-java
- lombok
- jjwt-api
- jjwt-impl
- jjwt-jackson
- springfox-swagger2
- springfox-swagger-ui

### ERD
![스크린샷 2022-08-05 오후 12 21 49](https://user-images.githubusercontent.com/35164102/183032084-36ef8cf3-9b0c-4253-a15c-7a80199dfdd3.png)

### swagger(API)
[http://3.34.47.86/swagger]
![스크린샷 2022-08-05 오후 3 37 42](https://user-images.githubusercontent.com/35164102/183031837-b34397eb-feae-4eab-a75a-0fdf7bd0ab14.png)


### 추가로 작업해야할 사항
- response 보완 -> join시 필요한 정보만 가지고 올수 있도록
- Filter jwt 쪽 예외처리 -> Service단 처럼 throw newe exception(); 하면 안된다.
- TestCode 짜보기 (중요!)
- 연관관계 맵핑 : 양방향 해보기
- 도커로 배포해보기
