# :cherry_blossom: 스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술
### 📁 폴더구조
```
src
├── main
│   ├── java
│   │   └── hello
│   │       └── hellospring
│   │           ├── HelloSpringApplication.java
                ├── domain
                    └── Member.java
                ├── repository
                    ├── MemberRepository.java
                    └── MemoryMemberRepository.java
│   │           └── controller
│   │               └── HelloController.java
│   └── resources
│       ├── application.properties
│       ├── static
│       │   ├── hello-static.html
│       │   └── index.html
│       └── templates
│           ├── hello-template.html
│           └── hello.html
└── test
    └── java
        └── hello
            └── hellospring
                ├── repository
                    └── MemoryMemberRepositoryTest.java
                └── HelloSpringApplicationTests.java
```
##### ```resources/static/index.html``` : welcome page
+ 도메인을 누르고 들어왔을 때 첫 화면
+ 자동으로 응용프로그램의 시작 페이지로 사용
+ [spring docs - welcome page](https://docs.spring.io/spring-boot/docs/current/reference/html/web.html#web.servlet.spring-mvc.welcome-page)

##### ```Controller```: 웹의 첫 진입점
+ ```@Controller``` Annotation
+ ```@RequestMapping(value="/test", method={RequestMethod.GET, RequestMethod.POST})```
    + 현재 클래스의 모든 메서드들의 기본적인 URL 경로 설정
    + ```@GetMapping("test")``` : GET 요청 축약형 표현
    + ```@PostMapping("test")``` : POST 요청 축약형 표현
+ ```Model``` : JSP에 컨트롤러에서 생성된 데이터를 담아서 전달하는 역할
+ String 타입으로 리턴할 경우 : 반환값은 파일이름을 의미한다.
    + ```viewResolver``` : 반환된 값(ex. name)을 템플릿을 매핑시켜준다. 
    + ```resources/templates/{name}.html``` 을 화면에 보여준다.
+ ```@ResponseBody``` : 컨트롤러의 반환값을 http 요청의 응답 body에 넣어준다.

##### ```Domain``` : 비즈니스 도메인 객체
+ 해결하고자 하는 문제의 영역 (ex) 회원, 댓글, 게시글 등

##### ```Repository```: 데이터베이스에 접근, 도메인 객체를 DB에 저장하고 관리
+ 현재 DB를 사용하지 않고 구현하여 Interface를 사용

#### Test Code 작성하기
+ ```@Test```
+ 각 테스트 메소드는 순서와 상관없어야 한다. 즉, 의존 관계가 없어야 한다.
