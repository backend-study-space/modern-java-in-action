# 3.5 형식 검사, 형식 추론, 제약

람다 표현식 자체에는 람다가 어떤 함수형 인터페이스를 구현하고 있는지 정보가 포함되어있지 않다.

### 3.5.1 형식 검사

```java
List<Apple> heavierThan150g 
        = filter(inventory, (Apple apple) -> apple.getWeight() > 150);
```

- context를 이용한 타입 추론
  1. filter 메서드의 선언 확인
  2. filter 메서드의 두 번째 파라미터로 Predicate 형식을 기대함.
  3. Predicate 인터페이스의 test 메서드를 구현 한 람다식은 Apple을 받아서, boolean을 반환 함.
  

### 3.5.2 같은 람다, 다른 함수형 인터페이스

#### 특별한 void 호환 규칙

- 람다의 바디에 일반 표현식이 있으면 void를 반환하는 함수 디스크립터와 호환 됨.
- ex) ```Consumer<String> p = s -> list.add(s);``` << Consumer는 void 반환값을 갖지만 호환 되는 예시

### 3.5.3 형식 추론

자바 컴파일러는 람다 표현식이 사용된 context를 이용해서 람다 표현식과 관련된 함수형 인터페이스를 추론 함.

같은 논리로 컴파일러는 람다의 시그니처를 추론할 수 있음. 람다식의 파라미터의 타입을 추론할 수 있기 때문에 타입 생략 가능

```java
Comparator<Apple> c 
        = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

Comparator<Apple> c
        = (a1, a2) -> a1.getWeight().compareTo(a2.getWeight()); // 형식 추론
```

### 3.5.4 지역 변수 사용

람다 표현식에서는 자유 변수(파라미터로 넘겨진 변수가 아닌 외부에서 정의된 변수)를 활용할 수 있음. 이를 <b>람다 캡처링</b>이라고 함.

```java
int portNumber = 1337;
Runnable r = () -> System.out.println(portNumber);
```

* 지역변수는 변경될 수 없음. final로 선언하거나 의도적으로 변경 불가
  - 람다에서는 지역 변수에 바로 접근할 수 없기때문에, 지역변수의 값을 복제해서 사용함.
  - 따라서 복사본의 값이 바뀌지 않아야 하므로 지역 변수에는 한 번만 값을 할당해야 함.




