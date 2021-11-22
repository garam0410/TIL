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

---

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

---

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

---

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

---

## **Spring Data JPA**

<br>

### **ORM**

<br>

- Object-Relational Mapping : 객체와 RDB 매핑, 객체와 DB의 테이블이 매핑을 이루는 것

- 객체가 데이터베이스의 테이블과 매핑 시키는 프레임워크

- 프로그램 복잡도를 줄이고 자바 객체와 쿼리를 분리할 수 있음

- 트랜잭션 처리나 기타 데이터 베이스 관련 작업을 편리하게 처리

- SQL Query가 아닌 직관적인 코드로 데이터 조작 가능

<br>

### **JPA**

<br>

- Java Persistence API

- Java에서 ORM을 사용하기 위한 인터페이스를 모두 모아둔 것

- 대표적으로 JPA를 구현한 구현체는 Hibernate

- 결국 인터페이스(Interface) 이기 때문에 구현체가 필요

<br>

### **Hibernate**

<br>

- JPA 인터페이스를 직접 구현한 라이브러리

<br><br>

## **JPA 장점**

<br>

- 생산성이 뛰어나고 유지보수가 용이

- 객체지향적인 코드로 인해 더 직관적이고 비즈니스 로직에 더 집중할 수 있게 도와줌

- SQL을 직접 작성하지 않고 객체를 사용하여 동작하기 때문에 유지보수가 간결하고 재사용성 증가

- 컬럼의 추가에 있어서 테이블이나 SQL 수정하는 과정이 많이 줄어듦

- 객체에 대한 코드를 별도로 작성하여 코드의 가독성도 증가

<br>

## **JPA 단점**

<br>

- 어려움

- JPA의 장점을 잘 살리는데 학습비용이 큼

- 복잡한 쿼리를 사용할때는 불리함

- 기존 데이터베이스 중심으로 되어 있는 환경에서는 JPA를 사용하기 어려움

- 잘못사용할 경우 실제 SQL 문을 작성하는 것보다 성능이 떨어질 수 있음

- 대용량 데이터 기반의 환경에서도 튜닝이 어려워 상대적으로 기존방식보다 성능이 떨어질 수 있음

<br>

## **Spring Data JPA 구현**

### **@Entity**

- JPA 의 시작

- 테이블과 매핑하 클래스에 @Entity Annotation을 붙여주는 것으로 JPA에게 해당 클래스는 데이터베이스와 매핑할 객체다 라는 것을 알려줌

- 중요 원칙 3가지

  - 기본 생성자 꼭 가지고 있기

  - final class, interface, enum, inner 클래스가 아닌 기본 클래스

  - 저장할 필드에 final을 사용하지 않을 것

<br>

### **@Table**

- Entity와 매핑할 테이블을 이름으로 직접 지정 ( @Table(name = "테이블명") )

- DDL 제약 조건 추가, 스키마 매핑, 카탈로그 매핑 기능 존재

<br>

### **@Id**

- 기본키 매핑

- Primary Key 매핑

<br>

### **@GeneratedValue**

- 기본 키의 다양한 생성 전략 명시 가능 ( @GeneratedValue(strategy = GenerationType.IDENTITY) )

- 기본키는 직접 할당과 자동 생성이 나뉜다

- IDENTITY : 기본키 생성을 데이터베이스에 위임 (JPA에서는 이거 사용)

- SEQUENCE : 데이터베이스 시퀸스를 이용해서 기본키 할당

- TABLE : 키 생성 테이블을 사용

<br>

### **@Column**

- 기본적으로 JPA에서 @Column을 명시하지 않으면 해당 필드의 이름으로 매핑

- 만약 실제 Table에서 기본키가 member_id 이고, Java Class 에서는 id로 쓰이는 경우, @Column(name = "") 속성을 이용하면 해결할 수 있음

- @Column(nullable = true), @Column(length = 400)

- nullable은 null 제약조건, length는 길이 제약조건

<br>

### **@ManyToOne**

- 다대일 매핑

- ex) OrderItem (다) : User (일)

- 보통 참조하는 Entity에 사용, 외래키를 가지고 있는 엔티티라고 생각하면 편함

- @ManyToOne(FatchType.EAGER)
  
  - 엔티티를 조회할 떄, 연관된 엔티티를 한번에 조회

  - 즉, 실제 객체가 사용되지 않더라도 조회

- @ManyToOne(FatchType.LAZY) => **권장**

  - 엔티티를 조회할 떄, 연관된 엔티티는 실제 사용시점에 조회

  - 즉, 실제 객체가 사용되는 시점까지 조회를 미룸

<br>

### **@OneToMany**

- 일대다 매핑

- User (일) : OrderItem (다)

- 보통 참조하는 엔티티에서 사용

- List Collection을 참조변수로 함

- @OneToMany(mappedBy = "")
  
  - 양방향 매핑에서 사용되는 개념

  - 양방향을 참조될 때, 참조당하는 엔티티에서 사용

  - mappedBy = "참조하는 엔티티에 있는 변수 이름" 으로 작성

  - 현재 자신의 참조가 해당 엔티티에 어떤 변수로 지정되었는지 JPA에 알려주기 위함

<br>

### **양방향과 단방향**

- ManyToOne만 존재한다면, 단방향 연관관계라고 함

- 단방향 연관관계가 객체지향적으로 훨씬 이득

- 하지만, 양방향을 사용해야하는 어쩔 수 없는 상황들이 생김

- **기억**

  - 양방향 연관관계가 될 떄, 왜래 키를 관리하고 있을 주체를 확실히 할 것

  - 왜래 키를 갖는 주체는 DB 테이블에 왜래 키가 있는 쪽으로 함

  - 외래 키를 갖는 쪽에서만 UPDATE와 INSERT를 수행, 없는 쪽은 SELECT만 수행

  

<br><br>

---
## **Spring Security**

<br>

- 보안 솔루션을 제공해주는 Spring 기반의 스프링 하위 프레임워크

- Spring Security가 제공해주는 보안 솔루션을 사용하면 개발자가 보안 관련 로직을 구성할 필요가 없어 편함

- 인증과 권한의 뜻을 알아야함

<br>

### **인증, 권한**

<br>

- 인증 : 자신이 '누구'라고 주장하는 사람을 정말 '누구'가 맞는지 확인하는 작업

- 권한 : 특정 부분에 접근할 수 있는지에 대한 여부를 확인하는 작업

<br>

Spring Security는 인증과 권한에 대한 부분을 Filter 흐름에 따라 처리하고 있다. Filter는 Dispatcher Servlet으로 가기 전에 적용되므로 가장 먼저 URL 요청을 받지만, Interceptor는 Dispatcher와 Controller 사이에 위치한다는 점에서 적용 시기의 차이가 있다. Spring Security는 보안과 관련해서 체계적으로 많은 옵션을 제공해주기 때문에 개발자 입장에서 일일이 보안관련 로직을 작성하지 않아도 된다는 장점이 있다.

<br>

### **Spring Security 모듈**

- SecurityContextHolder
  
  보안 주체의 세부정보를 포함하여 응용프로그램의 현재 보안 컨텍스트에대한 세부 정보가 저장

  SecurityContextHolder.MODE_INHERITABLETHREADLOCAL
  SecurityContextHolder.MODE_THREADLOCAL

<br>

- SecurityContext

  Authentication을 보관하는 역할을 하며, SecurityContext를 통해서 Authentication 객체를 꺼내올 수 있음

<br>

- Authentication

  현재 접근하는 주체의 정보와 권한을 담는 인터페이스

  Authentication 객체는 SecurityContext에 저장

  SecurityContextHolder를 통해서 SecurityContext에 접근
  
  SecurityContext를 통해서 Authentication에 접근

<br>

- UsernamePasswordAuthenticationToken

  Authentication을 Implements한 AbstractAuthenticationToken의 하위 클래스

  User의 ID가 Principal 역할을 하고, Password가 Credential의 역할을 함

  UsernamePasswordAuthenticationToken의 첫번째 생성자는 인증 전의 객체 생성

  UsernamePasswordAuthenticationToken의 두번쨰 생성자는 인증이 완료된 객체 생성
  
<br>

- AuthenticationProvider

  실제 인증에 대한 부분을 처리

  인증 전의 Authentication 객체를 받아서 인증이 완료된 객체를 반환하는 역할 수행

  AuthenticationProvider 인터페이스를 구현해서 Custom한 AuthenticationProvider를 작성하여 AuthenticationManager에 등록

<br>

- AuthenticationManager

  AuthenticationManager를 implements한 ProviderManager는 실제 인증 과정에 대한 로직을 가지고 있는 AuthenticationProvider를 List로 가지고 있으며, ProviderManager는 for문을 통햇 Provider를 조회하면서 Authenticate 처리를 수행
  
  ProviderManager에 직접 구현한 AuthenticationProvider를 등록하려면 WebSecurityConfigurerAdapter를 상속해 만든 SecurityConfig에서 할 수 있음

  WebSecurityConfigurerAdapter의 상위 클래스에서는 AuthenticationManager를 가지고 있기 때문에 직접 만든 AuthenticationProvider를 등록할 수 있음

<br>

- UserDetails

  인증에 성공하여 생성된 UserDetails 객체는 Authentication 객체를 구현한 UsernamePasswordAuthenticationToken을 생성하기 위해 사용

  UserDetails 인터페이스는 UserVO 모델에 UserDetails를 implements 하여 이를 처리하거나 UserDetailsVO에 UserDetails를 implements하여 처리할 수 있음

<br>

- UserDetailsService

  UserDetailsService 인터페이스는 UserDetails 객체를 반환하는 단하나의 메소드를 가지고 있음

  일반적으로 이를 구현할 클래스의 내부에 UserRepository를 주입받아 DB와 연결하여 처리

<br>

- PasswordEncoding

  AuthenticationManagerBuilder.userDetailsService().passwordEncoder()를 통해서 Password 암호화에 사용될 PasswordEncoder 구현체를 지정 가능

<br>

- GrantedAuthority

  현재 사용자가 가지고 있는 권한을 의미.

  ROLE_ADMIN 또는 ROLE_USER와 같이 ROLE_* 과 같은 형태로 사용

  보통 roles 라고 함

  UserDetailsService에 의해 불러올 수 있음

  특정 자원에 대한 권한이 있는지를 검사하여 접근 허용 여부를 결정

<br><br>

---

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