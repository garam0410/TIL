# **JPA**

## **1. JPA가 뭘까?**

<br>

- ORM(Object-Relational Mapping) 이란?

- JPA(Java Persistence API) 란?

- JPA의 장단점

- JPA를 사용해야하는 이유

<br>

## **2. JPA가 어떻게 돌아갈까?**

<br>

- JPA의 동작과정

<br>

## **3. JPA의 내부는 어떻게 생겼을까?**

<br>

- JPA의 구조

<br>

## **4. JPA Mapping (맞춰보자)**

<br>

- JPA의 Mapping (연관관계 / Proxy / Lazy 로딩 등)

<br>


7. 영속성(Persistence) 이란

8. JPA에서의 영속성(Persistence)

5. 영속성 컨텍스트 (cascade / Transaction 등)

<br>

---

<br>

## **1. JPA가 뭘까?**

<br>

### **ORM(Object-Relational Mapping)이란?**

<br>

- Object-Relational Mapping : 객체와 RDB 매핑, 객체와 DB의 테이블이 매핑을 이루는 것

- 객체가 데이터베이스의 테이블과 매핑 시키는 프레임워크

- 프로그램 복잡도를 줄이고 자바 객체와 쿼리를 분리할 수 있음

- 트랜잭션 처리나 기타 데이터 베이스 관련 작업을 편리하게 처리

- SQL Query가 아닌 직관적인 코드로 데이터 조작 가능

<br>

### **JPA(Java Persistenct API)란?**

<br>

- Java Persistence API

- Java에서 ORM을 사용하기 위한 인터페이스를 모두 모아둔 것

- JPA는 기술의 명세

- 대표적으로 JPA를 구현한 구현체는 Hibernate

- JPA는 특정 라이브러리가 아닌 인터페이스(Interface) 이기 때문에 구현체가 필요

- Java Application에서 관계형 데이터베이스를 어떻게 사용해야 하는지를 정의하는 한 방법

<br>

### **JPA의 장단점**
<br>

### 장점

<br>

- 생산성이 뛰어나고 유지보수가 용이

- 객체지향적인 코드로 인해 더 직관적이고 비즈니스 로직에 더 집중할 수 있게 도와줌

- SQL을 직접 작성하지 않고 객체를 사용하여 동작하기 때문에 유지보수가 간결하고 재사용성 증가

- 컬럼의 추가에 있어서 테이블이나 SQL 수정하는 과정이 많이 줄어듦

- 객체에 대한 코드를 별도로 작성하여 코드의 가독성도 증가

<br>

### 단점

<br>

- 어려움

- JPA의 장점을 잘 살리는데 학습비용이 큼

- 복잡한 쿼리를 사용할때는 불리함

- 기존 데이터베이스 중심으로 되어 있는 환경에서는 JPA를 사용하기 어려움

- 잘못사용할 경우 실제 SQL 문을 작성하는 것보다 성능이 떨어질 수 있음

- 대용량 데이터 기반의 환경에서도 튜닝이 어려워 상대적으로 기존방식보다 성능이 떨어질 수 있음

<br>

### **JPA를 사용해야하는 이유**

<br>

- 초기에는 JDBC API를 직접 사용하여 개발

- JDBC API를 직접 사용하여 개발하다가 MyBatis를 이용해서 SQL Mapper를 통해 JDBC 코드를 많이 줄일 수 있었음

- 하지만, 여전히 CRUD에 대해서 SQL을 반복적으로 작성해야함.

- 이 문제를 해결해주는 것이 ORM 이고, Java 진영의 ORM 표준인 JPA가 해답.

<br>

## **3. JPA의 내부는 어떻게 생겼을까?**

<br>

### **JPA의 구조**

<br>

**클래스**

<br>

EntityManager

- 인터페이스

- 객체에 대한 영속성 관리 작업을 진행

- Query 인스턴스를 생성하는 팩터리 처럼 작동

<br>

EntityManagerFactory

- EntityManager 클래스의 팩토리 클래스

- EntityManager 클래스의 인스턴스를 생성 및 관리

<br>

EntityTransaction

- EntityManager와 일대일 관계

- 각각의 EntityManager들의 작업은 EntityTransaction 클래스에 의해서 유지

<br>

Persistence

- EntityManagerFactory 인스턴스를 생성하는 정적(static) 메소드 가지고 있음

<br>

Entity

- 영속 객체

- 실제 데이터베이스에 기록될 객체

<br>

Query

- 인터페이스로서 각각의 JPA 벤더에 의해 구현

- 각 기준에 충족하는 관계형 객체를 얻음

<br>

Persistence가 EntityManagerFactory 인스턴스를 생성한다. 생성된 EntityManagerFactory가 EntityManager를 여러개 생성할 수 있다. 이 때, EntityManagerFactory와 EntityManager는 일대다 관계이다. 각각의 EntityManager는 EntityTransaction 인스턴스가 작동하는데 이때, EntityManager와 EntityTransaction은 일대일 관계이다. EntityManager는 여러개의 Query 객체를 관리하기 때문에 일대다관계이다. EntityManager는 여러개의 Entity 객체를 관리한다. 따라서 EntityManager와 Entity 객체는 일대다 관계이다. 