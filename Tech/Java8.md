# **Java 8**

Java 8의 새로운 특징들을 정리

<br>

## **Lambda Expression (람다 표현식)**

<br>

- 메소드로 전달할 수 있는 함수를 단순한 문법으로 표기한 것

```java
public class LambdaExpression {
    public static void main(String[] args){
        noLambdaThread();
        lambdaThread();
    }

    public static void noLambdaThread(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("new thread");
            }
        });

        thread.start();
    }

    public static void lambdaThread(){
        Thread thread = new Thread(() -> System.out.println("new thread (lambda)"));

        thread.start();
    }
}
```

<br>

## **함수형 인터페이스**

<br>

- 단 하나의 추상 메서드를 갖는 인터페이스

- 위의 Runnable 인터페이스는 추상 메서드 run() 하나만 있기 때문에 함수형 인터페이스라고 할 수 있음

<br>

```java
public class FunctionalInterface{
    public static void main(String[] args){
        noFuncInterface();
        funcInterface();
    }

    public static void noFuncInterface(){
        Car car = new Car() {
            @Override
            public String drive(int driveLevel) {
                return driveLevel == 0 ? "" : "자동차가 " + driveLevel + "의 속도로 이동 중.";
            }
        };

        System.out.println(car.drive(10));
    }

    public static void funcInterface(){
        Car car = (i) -> i == 0 ? "" : "자동차가 " + i + "의 속도로 이동 중.";
        System.out.println(car.drive(0));
    }
}
```

<br>

## **Default Method (디폴트 메서드)**

<br>

- 기존의 인터페이스 구현체들의 변경 없이 공통적인 기능을 제공할 때 사용

- 인터페이스를 구현하면, 사용하지 않는 빈 메서드를 빈 상태로 구현하는 경험이 종종 있음

- 디폴트 메서드를 통해서 불필요한 코드를 줄일 수 있음

- 예를 들어, reverse()가 필요없는 HorseCar의 경우에 reverse() 메서드를 default로 구현함으로 써, 필요한 객체에서만 오버라이드해서 사용할 수 있음

<br>

```java
public interface Vehicle {
    void drive();

    default void reverse();

    default void fly(){
        System.out.println("Fly");
    }
}

```

<br>

```java
public class DefaultMethod {
    public static void main(String[] args){
        Bus bus = new Bus();
        Tax tax = new Tax();
        HorseCar horseCar = new HorseCar();

        bus.drive();
        tax.drive();
        horseCar.drive();

        bus.reverse();
        tax.reverse();

        bus.fly();
        tax.fly();
        horseCar.fly();
    }
}
```

<br>

## **Stream (스트림)**

<br>

- Collection을 멋지고 편리하게 처리하는 방법을 제공하는 API

- 병렬처리 제공, 직관적인 코드를 제공

- Collection에서 자주 사용되는 기능을 미리 제공하여 개발자가 불필요한 for문과 if문을 사용하지 않도록 함.

- Stream은 내부반복을 지원

- for 문이 없는 것이 아니라 보이지 않을 뿐이기 때문에, 성능이 중요한 서비스에서는 상황에 따라 외부 반복을 통해 구현하는 것이 이점을 얻을 수 있음

- 때에 따라서 잘 선택해야함

<br>

```java
    public static List<String> normalStream(List<Book> books){
        books.sort(Comparator.comparing(Book::getName));

        List<String> booksWrittenByNietzsche = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals("Friedrich Nietzsche")) {
                booksWrittenByNietzsche.add(book.getIsbn());
            }
        }

        return booksWrittenByNietzsche;
    }

    public static List<String> expertStream(List<Book> books){
        List<String> booksWrittenByNietzsche =
                books.stream()
                        .filter(book -> book.getAuthor().equals("Friedrich Nietzsche"))
                        .sorted(Comparator.comparing(Book::getName))
                        .map(Book::getIsbn)
                        .collect(Collectors.toList());

        return booksWrittenByNietzsche;
    }
```

### **특징**

<br>

- **파이프라이닝**

    - 메서드 체이닝으로 연결

    - filter(), sorted(), map(), collect()

    - Stream 객체끼리 연속으로 처리하면서 파이프라이닝이 되어, 최종적인 결과 값 반환

<br>

- **내부 반복 지원**

    - 코드 외부에서 for문을 사용하지 않고 filter() 처럼 내부에서 알아서 처리

    - 코드를 분석하는데 방해되는 요인을 줄이고, 비즈니스 로직 구현에만 충실한 코드 작성 가능

<br>

- **딱 한 번만 탐색**

    - Stream을 거치면 이전 상태로 돌아갈 수 없음

    - 연산 이전의 값을 저장하지 않고 연산된 값만 새롭게 반환 한다는 의미

    - filter() 다음에 sorted()를 호출 할때, 이미 저자 이름이 sorted 된 상태로 파라미터로 넘겨지게 되기 때문에 sorted 이전 값을 재사용해야 한다면, 변수에 저장해두고 사용해야 함

<br>

- **게으르게 동작**

    - 게으르다 -> 필요한 시점까지 실행을 미루다 동작

    - JPA의 Lazy Loading

    - 종료 연산이 반드시 있어야 실행 됨

<br>

- **중간 연산과 종료 연산**

    - 게으르게 동작하는 부분에는 중간 연산과 종료 연산 존재

    - Stream<T> 형태의 스트림의 반환 되면 중간 연산 : filter(), sorted()

    - 종료 연산 : foreach(), count(), collect()

<br>

## **Optional (옵셔널)**

<br>

- Java의 NPE(NullPointerException) 을 보완하고자 등장

- 기존에 if문을 활용한 null 방어 코드를 작성 하였다면, 그럴필요가 없어짐

<br>

### **주요 메서드**

<br>

**감싸는 메서드**

- **of(T)**

    파라미터로 받은 객체를 Optional로 감싸며, null이면 NPE 발생

- **ofNullable(T)**

    기본적으로 of()와 동일하나 파라미터가 null이면 빈 Optional 객체를 반환

- **empty()**

    빈 Optional을 반환

    Optional 의 중간 연산 중에 값이 null이 되면 내부적으로 이 메서드 호출

<br>

**중간 연산**

- **filter()**

    Stream의 filter와 동일

- **map()**

    Stream의 map와 동일

- **flatMap()**

    Optional안의 Optional이 있는 이중 구조일 때, 단일 구조로 변경하여 map의 기능을 수행

<br>

**종료 연산**

- **get()**

    Optional의 값을 반환

    빈 값이라면 NPE

- **orElse(T)**

    get()과 동일한 기능을 수행하지만, 값이 비어있다면 파라미터에서 제공하는 값 반환

- **orElseGet()**

    get()과 동일한 기능을 수행하지만, 값이 비어있다면 파라미터에서 제공하는 값을 반환

- **orElseThrow()**

    get과 동일한 기능을 수행하지만, 값이 비어있다면 파라미터에서 생성한 Exception을 발생

<br>

**기타 메서드**

- **isPresent()**

    Optional 값이 비어있다면 true, 아니면 false

- **ifPresent()**

    Optional 값이 비어있다면 파라미터 실행, 아니라면 false 반환