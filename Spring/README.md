# **Spring Boot**

### Spring Boot를 공부하기 위해 생성한 레포지토리

<br><br>

## **Library**

---

- spring-boot-starter-web

    - spring-boot-starter-tomcat : 톰캣(웹서버)

    - spring-webmvc : 스프링 웹 MVC

- spring-boot-starter-thymeleaf : 타임리프 템플릿 (View)

- spring-boot-starter : 스프링 부트 + 스프링 코어 + 로깅

    - spring-boot

    - spring-core

    - spring-boot-starter-logging

        - logback, slf4j 사용

<br><br>

## **application.yml**

---

- 대부분의 어플리케이션에서 설정과 관련된 변수들은 보통 파일에다가 쓰고 읽어오는 방식을 채택

- yaml을 사용하여 Spring Boot 설정

<br>

실제 개발을 진행할 때, 개발 중일 때의 Profile과 배포할때의 Profile이 다르기 때문에 분리해야할 필요가 있음

## **"---" 로 분리**
<br>

    spring :
    profiles:
        active: dev # 적용할 환경 선택

    --- # 구분선

    spring:
    profiles: dev

    server :
    port : 8080

    --- # 구분선

    spring:
    profiles: deploy

    server :
    port : 8000

<br><br>

## **templates에 있는 파일 읽기**

---

- static 에 있는 정적 파일을 읽는 것은 문제가 되지 않음

- 하지만 templates 폴더에서 정적 파일을 관리하게 된다면 문제가 발생

- 