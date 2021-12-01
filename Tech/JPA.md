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

## **4. 영속성 컨텍스트**

<br>

- 영속성 컨텍스트(PersistenceContext)란?

- Entity 생명주기

- 영속성 컨텍스트의 특징

- flush()

<br>

## **5. JPA Mapping**

<br>

- JPA의 Mapping (연관관계 / Proxy / Lazy 로딩 등)


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

<br>

## **4. 영속성 컨텍스트**

<br>

### **영속성(Persistence)**
소멸되지 않고 저장될 수 있는 데이터의 성질

<br>

### **영속성 컨텍스트란?**

<br>

 - Entity를 영구 저장하는 환경

 - EntityManager로 Entity를 저장하거나 조회하면 EntityManager는 영속성 컨텍스트에 Entity를 보관하고 관리

 - persist(entity) 는 단순히 Entity를 저장하는 것이 아닌 EntityManager를 사용해서 Entity를 영속성컨텍스트에 저장

 - 영속성 컨텍스트는 EntityManager를 생성할 때 하나 만들어짐

 - EntityManager를 통해서 영속성 컨텍스트에 접근할 수 있고, 영속성 컨텍스트 관리 가능

<br>

### **Entity의 생명주기**

<br>

- 비영속(new/transient) : 영속성 컨텍스트와 전혀 관계가 없는 상태

- 영속(managed) : 영속성 컨텍스트에 저장된 상태

- 준영속(detached) : 영속성 컨텍스트에 저장되었다가 분리된 상태

- 삭제(removed) : 삭제된 상태

<br>

### **영속성 컨텍스트의 특징**

<br>

- 영속성 컨텍스트는 반드시 식별자 값(@Id로 기본키와 매핑한 값)으로 구분 => 반드시 식별자값 있어야함

- 영속성 컨텍스트에서는 트랜잭션을 commit 하는 순간 영속성 컨텍스트에 새로 저장된 Entity를 데이터베이스에 반영, flush() 라고 함

<br>

**장점**

- **1차 캐시 (조회)**

    영속성 컨텍스트는 내부에 1차 캐시를 가지고 있음
    
    영속 상태의 Entity는 모두 이곳에 저자

    Map<@Id, Entity's Instance>

    key는 식별자 값이며, 영속성 컨텍스트에 데이터를 저장하고 조회하는 모든 기준은 데이터베이스의 기본 키

    find()를 호출했을 때, 먼저 1차 캐시에 데이터가 있는지 확인하고 없으면 데이터베이스에서 조회

<br>

- **동일성 보장**

    식별자가 같은 Entity Instance를 조회해서 다른 객체에 저장하고 동일성 비교를 하면 True

    처음에 find() 해서 데이터를 가져왔을 때, 1차 캐시에 저장

    두번째로 find() 해서 동일한 식별자의 데이터를 가져왔을 때는 1차 캐시에서 같은 Entity Instance를 반환하기 때문에 같음

    **성능상의 이점과 동일성 보장**

<br>

- **트랜잭션을 지원하는 쓰기 지연(등록)**

    EntityManager는 Transaction을 커밋하기 직전까지 데이터베이스에 Entity를 저장하지 않고 내부 쿼리 저장소에 쿼리를 모아둠

    Transaction을 커밋할 때, 모아둔 쿼리를 데이터베이스에 보냄 => **쓰기 지연**

    데이터를 저장하는 즉시 등록 쿼리를 데이터베이스에 보내는 방법이 있지만, 최종적으로 트랜잭션을 커밋해여 변경사항이 저장된다.

    쓰기 지연을 통해서 쿼리를 모아두고, 한번에 보냄으로 써 성능 최적화가 가능하다.

<br>

- **변경 감지(수정)**

    조회는 find, 저장은 persist를 사용했지만, 수정엔 update가 없음

    JPA는 Entity의 변경사항을 자동으로 반영하는 **변경 감지** 기능이 있음

    Entity를 영속성 컨텍스트에 보관할 때, 최초 상태를 복사해서 저장해 두는데, 이것을 Snapshot이라고 함

    그리고 flush() 시점에 Snapshot과 Entity를 비교해서 변경된 Entity를 찾음

    변경 감지는 영속성 컨텍스트가 관리하는 영속 상태의 Entity에만 적용

    그 외 상태의 Entity는 변경되어도 데이터베이스에 반영되지 않음

    변경된 Entity의 필드가 아닌 모든 필드를 update하는 쿼리 생성

    이로 얻을 수 있는 이점으로는 모든 필드를 사용함으로 써, 수정 쿼리가 항상 같기 때문에 어플리케이션 로딩 시점에 수정 쿼리를 미리 생성해두고 재사용 가능

    그리고 데이터베이스에 동일한 쿼리를 보냄으로 써, 이전에 한번 파싱한 쿼리를 재사용 가능

    컬럼이 대략 30개 이상이 되면 DynamicUpdate를 사용해서 변경된 필드만 update되게 할 수 있음

    하지면, 30개 이상의 컬럼이 존재한다는 것은 Table 설계에 책임이 제대로 분리되지 않았을 가능성 높음

<br>

- **지연 로딩**

    데이터를 조회할 때, 필요한 컬럼만을 조회함으로 써, 성능의 이점 가져옴

    즉, 데이터가 필요한 시점에, 필요한 데이터 만을 가져오는 것을 의미

    Entity 클래스의 필드에 fetch= FetchType.LAZY 를 부여함으로 서, 해당 필드는 지연로딩 하도록 설정 가능

    실제로 해당 필드를 get 할때, 데이터를 조회

    자주 사용하는 필드의 경우, Lazy를 하면 매번 쿼리가 두번씩 나감으로 써 성능상 손해

    즉시로딩 FetchType.EAGER을 사용

<br>

## **flush()**

<br>

- 영속성 컨텍스트를 데이터베이스에 반영 하는 것

- 동작 시기

    1. flush() 직접 호출
    
        EntityManager의 flush()를 직접 호출해서 강제로 flush

        테스트 도는 JPA를 함께 사용할 때를 제외하고 거의 사용 X
        

    2. Transaction.commit()시 자동 호출

        변경내용을 SQL로 전달하지 않고 Transaction만 commit 하게되면 어떤 데이터도 반영 X

        Transaction Commit 전에 꼭 Flush 호출해서 변경 내용 반영

        JPA 에서는 commit 만 수행할 경우를 에방하기 위해서 commit할 때, flush를 자동 호출

    3. JPQL 쿼리 실행 시 자동 호출

        데이터베이스에 넘어가지 않고 있는 영속된 Entity 에 대한 정보는 JPQL 같은 객체지향 쿼리를 사용해서 데이터베이스에서 Entity를 조회하게되면 영속된 Entity는 데이터베이스에 내용이 반영되있지 않기 때문에 쿼리 결과로 조회 X

        이를 방지하기 위해서 JPQL 쿼리 실행시, 영속된 Entity를 flush 해서 변경 내용을 데이터베이스에 반영하고 반영한 내용까지 쿼리결과에 포함시킨다.

        식별자를 기준으로 조회하는 find() 메소드는 플러시 실행 X

<br>

## **준영속**

<br>

- 준영속 상태의 Entity는 영속성 컨텍스트가 제공하는 기능을 사용할 수 없음

<br>

### **detach(entity)**

<br>

- 특정 Entity를 준영속 상태로 전환

- 호출하는 순간 해당 Entity는 1차 캐시부터 쓰기 지연 SQL 저장소까지 관련된 정보가 모두 제거

<br>

### **clear()**

<br>

- 해당하는 영속성 컨텍스트의 모든 Entity를 준영속 상태로 만드는 것

- 준영속 상태에서는 아무리 Entity의 필드를 변경해도 데이터베이스에 반영되지 않음

<br>

### **close()**

<br>

- 해당하는 영속성 컨텍스트를 종료하고, 영속 상태의 Entity를 모두 준영속 상태로 만드는 것

- 대부분 영속성 컨텍스트가 종료되어 Entity가 준영속 상태로 변함

- 개발자가 직접 준영속 상태로 만드는 일은 거의 없음

<br>

### **merge(entity)**

<br>

- 준영속 상태의 Entity를 다시 영속 상태로 변경하기 위해 사용

- **준영속 상태의 Entity를 받아서 새로운 영속 상태의 Entity를 반환**

- 이게 무슨말이나면, 영속 상태의 Entity를 준영속 상태로 변경하였다고 가정해보자.

- 준영속 상태의 Entity의 정보를 변경하고, 다시 영속상태로 바꾼다면?

- find() 할때처럼 동일한 식별자가 존재하는지 1차 캐시에서 확인 후 존재한다면 해당 데이터를, 존재하지 않는다면 데이터베이스를 조회해서 데이터를 가져오고 말그대로 merge(병합) 과정을 통해서 새로운 영속상태의 Entity를 만든다. 그렇기 때문에 준영속 상태로 돌아갔던 Entity와 새롭게 생성된 newEntity는 EntityManager에 contains를 사용해서 확인해보면 false,true가 나오며 기존의 Entity는 아직도 준영속 상태이고 새로 생성한 newEntity는 영속된 상태이다. 결국 서로 다른 Instance이기 때문에 기존의 Entity는 사용할 필요가 없다. 사용할 때는 기존의 Instance에 덮어쓰기(?) 해서 사용하는 것이 좋다.

- 비영속 상태의 Entity 또한 merge()가 가능하다.

<br>

## **5. JPA Mapping**

<br>

- JPA를 사용하면서 Entity와 Table 매핑은 가장 중요함

- Mapping Annotation을 지원하는데, 크게 4가지로 나뉨

    1. 객체와 테이블 매핑 : @Entity, @Table

    2. 기본키 매핑 : @Id

    3. 필드와 컬럼 매핑 : @Column

    4. 연관관계 매핑 : @ManyToOne, @JoinColumn

<br>

### **@Entity**

<br>

- @Entity를 사용해서 매핑할 클래스를 지정

- JPA가 관리

- 기본 생성자 필수

- final 클래스, enum, interface, inner 클래스 사용 X

<br>

**속성**

- name : JPA에서 사용할 Entity 이름 지정, 기본값은 해당 클래스명

<br>

### **@Table**

<br>

- Entity와 매핑할 Table 지정

- 생략하면 매핑한 Entity 이름을 Table 명으로 사용

<br>

**속성**

- name : 매핑할 Table 이름 (기본값은 Entity 명)

- catalog : catalog 기능이 있는 데이터베이스에서 catalog 매핑

- schema : schema 기능이 잇는 데이터베이스에서 schema를 매핑

<br>

### **@Id**

<br>

- 기본적으로 @Id 어노테이션만 사용하면, 기본키를 어플리케이션에서 직접 할당

- @GeneratedValue(strategy = GenerationType.타입) 을 통해서 기본키 생성 전략 변경 가능하며, 기본값은 데이터베이스마다 자동으로 선택되는 AUTO

- 키 생성 전략이 다양한 이유는 데이터베이스 벤더마다 지원하는 방식이 다르기 때문

<br>

### **@GeneratedValue(strategy = GenerateType.TYPE)**

<br>

- **IDENTITY**

    기본키 생성을 데이터베이스에 위임

    AUTO_INCREMENT

    이 전략을 사용하려면 데이터베이스로부터 기본 키값을 얻어오기 위해 추가 조회 발생

    무조건 INSERT를 한 후에 조회 가능 => **쓰기 지연 동작 X**

    JDBC3에 추가된 Statement.getGeneratedKeys()를 사용하면 데이터 저장과 동시에 생성된 기본 키값도 얻어올 수 있음

    Hibernate는 이것을 이용해서 한번만 통신

<br>

- **SEQUENCE**

    데이터베이스 시퀀스는 유일한 값을 순서대로 생성하는 데이터베이스 오브젝트

    이 시퀀스를 사용해서 기본 키 생성

    1. 시퀸스 생성 1 :  CREATE SEQUENCE "시퀀스 명" START WITH 1 INCREENT BY 1;

    2. 시퀀스 생성 2 : @SequenceGenerator 사용
    
            @SequenceGenerator(
                name = "Generator 명",
                sequenceName = "매핑할 데이터베이스 시퀀스 명",
                initialValue = 1, allocationSize = 1
            )

    3. GeneratedValue 속성에

            @GeneratedValue(
                strategy = "GenerationType.SEQUENCE,
                generator = "Generator 명"
            )

    <br>
    
    IDENTITY와 달리, persist를 호출하면 먼저 데이터베이스 시퀀스를 사용해서 식별자 조회

    조회한 식별자를 찾아서 Entity에 할당한 후에 Entity를 영속성 컨텍스트에 저장

<br>

- **TABLE**

    키 생성 전용 Table을 하나 만들고 이름과 값으로 사용할 컬럼을 만들어 데이터베이스 시퀀스를 흉내내는 전략

    Table을 사용하기 때문에 모든 데이터베이스에서 사용 가능

            @TableGenerator(
                name = "Generator 명",
                table = "테이블 명"
                pkColumnValue = "Key로 사용할 column명",
                allocationSize = "증가 값"
            )

    GeneratedValue 속성에

            @GeneratedValue(
                strategy = GenerationType.TABLE,
                generator = "Generator 명"
            )

<br>

### **@Column**

<br>

- 객체 필드를 컬럼에 매핑

- 가장 많이 사용되는 속성으로 name, nullable 이 있음

<br>

**속성**

- name : 필드와 매핑할 테이블의 컬럼 이름 (기본값은 필드명)

- nullable : null 값의 사용 여부를 설정 (기본값은 true)

- unique : @Table의 uniqueConstraints와 같지만, 한 컬럼에 간단히 유니크 제약조건을 걸 때 사용
    
    두 컬럼 이상을 사용해서 유니크 제약조건을 걸 때는 Table.uniqueConstraints를 사용

- length : 문자 길이 제약조건, String 에서만 사용

- precision : 소숫점을 포함한 전체 자릿수

- scale : 소수의 자릿수

    **BigDemical 타입에서 사용, precision과 scale은 float, double 타입에는 적용이 안되며, 아주 큰 숫자나 정밀한 소수를 다뤄야할 때 사용**

<br>

### **@Enumerated**

<br>

- enum 타입을 매핑할 때 사용

<br>

**속성**

- EnumType.STRING : enum 이름을 그대로 저장, 데이터 크기가 ORDINAL에 비해 크지만, enum 순서 변경 가능

- EnumType.ORDINAL : enum을 순서대로 숫자로 저장, 데이터 크기가 작은 대신 순서 변경 X

<br>

### **@Temporal**

<br>

- 날짜 타입 (Date, Calendar)을 매핑할 때 사용

<br>

**속성**

  필수로 지정해야함

- TemporalType.DATE

- TemporalType.TIME

- TemporalType.TIMESTAMP

<br>

### **@Transient**

<br>

- 매핑 하지 않음을 의미

- 데이터베이스에 저장, 조회하지 않고 임시적으로 어떤 겂을 보관하고 싶을 때 사용

<br>

### **@Access**

<br>

- JPA 가 Entity 데이터에 접근하는 방식을 지정

- 설정하지 않으면 @Id의 위치를 기준으로 접근 방식이 결정

- @Id 가 필드에 있으면 필드 접근, 프로퍼티 위에 있으면 프로퍼티 접근

<br>

**속성**

- AccessType.FIELD

- AccessType.PROPERTY