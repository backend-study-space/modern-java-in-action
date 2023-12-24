동작 파라미터화 코드 전달하기

동작 파라미터화를 이용하면 자주 바뀌는 요구사항에 효과적으로 대응 가능

- 리스트의 모든 요소에 대해서 '어떤 동작'을 수행할 수 있음.
- 리스트 관련 작업을 끝낸 다음에 '어떤 다른 동작'을 수행할 수 있음.
- 에러가 발생하면 '정해진 어떤 다른 동작'을 수행할 수 있음.

# 2.1 변화하는 요구사항에 대응하기

## 첫 번째 시도 - 사과 필터링
```java
enum Color {
    RED, GREEN
}

public static List<Apple> filterGreenApples(List<Apple> inventory) {
    ArrayList<Apple> result = new ArrayList<>();
    
    for (Apple apple : inventory) {
        if (GREEN.equals(apple.getColor())) {
            result.add(apple);
        }
    }
    
    return result;
}
```

#### 변화에 대한 적절한 대응이 힘듬.

## 두 번째 시도 - 색을 파라미터화
```java
public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
    ArrayList<Apple> result = new ArrayList<>();
    
    for (Apple apple : inventory) {
        if (apple.getColor().equals(color)) {
            result.add(apple);
        }
    }
    
    return result;
}
```

#### '색깔'이라는 기준에는 유연한 코드 작성이 가능하지만, 만약 다른 필터링 기준이 생긴다면 마찬가지로 적절한 대응이 힘듬.

## 세 번째 시도 - 가능한 모든 속성으로 필터링
```java
public static List<Apple> filterAppes(List<Apple> inventory, Color color, int weight, boolean flag) {
    ArrayList<Apple> result = new ArrayList<>();
    
    for (Apple apple : inventory) {
        if ((flag && apple.getColor().equals(color)) ||
            (!flag && apple.getWeight() < weight)) {
            result.add(apple);
        }
    }
    
    return result;
}
```

#### 의미 불명의 파라미터, 요구사항이 바뀌었을 때 유연한 대처 불가능 등등의 많은 문제가 발생할 수 있는 코드

# 2.2 동작 파라미터화

### 변화하는 요구사항에 좀 더 유연하게 대응할 수 있는 방법
- 사과의 어떤 속성에 기초해서 boolean 값을 반환, 즉 <b>참 또는 거짓을 반환하는 Predicate 인터페이스 사용</b>
- 전략패턴 사용

### 전략패턴이란 ?

- 알고리즘을 캡슐화 후에, 런타임에 알고리즘을 선택하는 기법

## 네 번째 시도

- 해당 패키지의 DynamicParameter 클래스 참고

#### 전달한 ApplePredicate를 구현한 객체에 의해 filterApples 메서드의 동작이 결정된다. 즉 어떤 조건이 생기더라도 해당 인터페이스를 구현한 클래스의 메서드를 파라미터로 전달할 수 있기 때문에 유연한 코드 작성이 가능해진다.



