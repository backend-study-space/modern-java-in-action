## 스트림이란?

### 데이터 처리 연산을 지원하도록 소스에서 추출된 연속된 요소

- 표현 계산식이 주를 이룸
- 데이터 제공 소스로부터 데이터를 소비함.
- 순차적 혹은 병렬로 수행 가능
- 스트림 연산끼리 연결해서 커다란 파이프라인을 구성할 수 있도록, <b>자신을 반환함.</b>
- 내부 반복 지원


## 5.2.1 스트림 슬라이싱

### TAKEWHILE, DROPWHILE

- 정렬되어 있는 데이터에서, 대소 비교의 경우에 특정 조건을 만족한다면 이후 필터링은 반복 작업을 중단함.

```java
List<Dish> slicedMenu1 = specialMenu.stream()
        .takeWhile(dish -> dish.getCalories() < 320)
        .collect(toList());
```

- DROPWHILE은 반대되는 값을 가져옴.