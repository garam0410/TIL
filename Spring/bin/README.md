# **Spring Boot**

### Spring Boot를 공부하기 위해 생성한 레포지토리

<br>

### **동작과정**

Spring은 프로젝트가 처음 시작할 떄, @Controller, @Service, @Repository Annotation이 붙어 있으면, 스캔하여 Spring Bean으로 등록한다. 그리고 @Autowired Annotation 으로 의존 관계를 연결해주는 방식이다. @Component Annotation이 있으면 ComponentScan을 통해서 Spring Bean으로 자동 등록이 되며, @Controller, @Service, @Repository가 자동으로 등록되는 이유는 @Component Annotation을 포함하고 있기 대문이다. 이 작업은 오직 하나의 인스턴스를 생성하는 싱글톤 패턴을 사용하며, 싱글톤 패턴이기 때문에 같은 Spring Bean 이면 모두 같은 인스턴스라고 할 수 있다. **Spring 컨테이너에서 Bean이 관리된다** 라고 표현한다.

이때, Controller가 Service 클래스를 new ..Service(); 로 호출 하지 않고, Spring이 관리하는 Spring Service 객체를 받아서 사용 해야한다. 왜냐하면 여러 Controller 들이 Service를 사용할 수 있는데, 여러개를 생성할 필요 없이 공유하는 것이 좋기 때문이다. 

그래서 Controller 에 @Autowired Annotation을 붙임으로써, Spring은 저장하고 있는 Service 객체를 Controller가 생성될 떄 가져와 준다. 즉, 생성자에 @Autowired가 있으면 Spring이 연관된 객체를 Spring 컨테이너에서 찾아서 넣어주고, 이렇게 객체 의존관계를 외부에서 넣어주는 것을 DI(Dependency Injection) 의존성 주입이라고 한다. @Autowired로 Spring이 직접 주입해주는 것이다.

<br>

### **왜 @Controller, @Service, @Repository 일까?**

컨트롤러로 외부의 요청을 받고 서비스에서 비즈니스 로직을 만들고 레포지토리에서 데이터를 저장하는 정형화된 패턴이기 때문

<br>

### **의존성 주입**

<br>

- 필드 주입

    - 소스 수정이 쉽지 않으므로 권장하지 않음

<br>

- setter 주입

    - 생성은 생성자대로 되고 setter는 따로 실행되면서 의존성 주입 샐행

    - setter 주입은 public으로 누구나 접근 가능하기 때문에 누구나 변경할 수 있는 상황 발생

    - 이는 큰 문제가 될수 있으므로 권장되지 않는 방식

<br>

- 생성자 주입 (가장 많이 쓰임)

    - 가장 권장되는 방식

    - 생성자가 1개인 경우 @Autowired를 생략해도 주입이 가능하도록 편의 제공

    - 의존 관계가 실행중에 독적으로 변하는 경우는 거의 없기 때문에 권장

<br>

### **생성자 주입을 사용해야 하는 이유**

<br>

- 객체의 불변성 확보

    - 의존 관계 주입의 변경이 필요한 상황은 거의 없음

    - OOP 원칙 중 개방-폐쇄의 법칙을 위반하지 않도록 생성자 주입을 통해 변경의 가능성을 배제하고 불변성 보장

<br>

- 테스트 코드 작성

    - 실제 코드가 필드 주입으로 작성된 경우에는 순수 자바 코드로 단위 테스트를 작성하는 것이 불가능

<br>

- final 키워드 작성 가능

    - 생성자 주입을 사용하면 필드 객체에 final 키워드를 사용할 수 있으며, 컴파일 시점에 누락된 의존성 확인 가능

    - 다른 주입 방법들은 객체의 생성(생성자 호출) 이후에 호출 되므로 final 키워드 사용 불가

<br>

- 순환, 참조 에러 방지

    - 어프리케이션 구동 시점에 순환 참조 에러를 방지할 수 있다

    - StackOverFlow 방지

<br>

<br><br>

## **Library**

<br>

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

<br>

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

## **Web**

<br>

### **정적 컨텐츠(static)**

<br>

- 서버에서 특별한 작업 없이 파일을 웹브라우저에 보내주는 컨텐츠

-  기본적으로 "/**" 에 매핑

    - /resources/** 과 같음

    - application.yml 파일의 static-path-pattern으로 지정 가능


### **MVC**

<br>

- 템플릿 엔진 : 서버에서 변동사항을 동적으로 바꿔주는 컨텐츠 (jsp, php, Thymeleaf 등)

    - 해당 프로젝트에서는 Thymeleaf 사용

    - 파일 상단에 Thymeleaf 템플릿임을 표시

        - html xmlns:th="http://www.thymeleaf.org"

        - th:{type} = "${value}" 를 사용

        - model 에서 값을 꺼내 웹브라우저에 보여줌

        - 정보가 없다면, empty 출력

        <br>

- Model, View, Controller

    - model 1 : View에서 모든 것을 다하고 View와 Controller가 분리되어 있지 않은 형식

    -  model 2 : MVC 사용 (현재 많이 사용)

<br>

### **API**

<br>

- REST API

- 클라이언트와 통신할 때 사용

- JSON, XML

    - XML : 복잡하고 무거움

    - JSON : Key + Value 반환

<br>

---

### **일반적인 Web Application 구조**

<br>

    Controller -> Service -> Repository -> DB

          ↘         ↓          ↙  

                   Domain

    ------------------------------------------
    
    Controller : MVC 의 Controller

    Service : 비즈니스 로직 구현 (회원 중복 가입 불가 등)

    Repository : 데이터베이스에 접근, 도베인 객체를 DB에 저장하고 관리

    Domain : 비즈니스 도메인 객체 (회원, 주문 쿠폰 등 데이터베이스에 저장되고 관리)

<br>

### **Service, Repository 관계**

<br>

Repository는 Interface로 생성한다. 왜냐하면, 아직 데이터 저장소가 선정되지 않아서, 우선 Interface로 구현 클래스를 변경할 수 있도록 설계하는 것이다. DB는 아직 어떤것을 사용할 것이라고 확정짓지 않았기 떄문에 초기 개발 단계에서는 구현체로 가벼운 메모리 기반의 DB (Memory MemberRepository)를 사용하고 나중에 DB가 결정되면 쉽게 변경할 수 있도록 한다. 

<br>

## **Annotation**

<br>

### **@Autowired**

<br>

- 생성자에 @Autowired가 있으면 Spring이 연관된 객체를 Spring 컨테이너에 찾아서 넣어줌

- 이것을 의존성 주입(DI) 라고 함

- Spring이 관리하는 객체에서만 동작

<br>

### **@ResponseBody**

<br>

- HTTP의 body에 문자 내용을 직접 반환

- ViewResolver 대신에 HttpMessageConverter가 동작

- 기본 문자처리 : StringHttpMessageConverter

- 기본 객체처리 : MappingJackson2HttpMessageConverter