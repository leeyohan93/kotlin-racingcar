# kotlin-racingcar

## 2단계 - 문자열 계산기

### 기능 요구 사항

- 사용자가 입력한 문자열 값에 따라 사칙 연산을 수행할 수 있는 계산기를 구현해야 한다.
- 문자열 계산기는 사칙 연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
- 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

### 도메인 모델

- `문자열 계산기(StringCalculator)`
    - [X] 문자열을 입력 받아 사칙 연산을 수행한다.
- `수식 생성(ExpressionFactory)`
    - [X] 문자열을 입력 받아 `수식(Expression)`을 생성할 수 있다.
    - [X] 올바르지 않은 수식의 문자열 입력 시 예외가 발생한다.
- '수식 문자열 분리 전략(SeparationStrategy)'
    - 하나의 문자열을 받아 여러 개의 문자열로 분리할 수 있다.
    - 구현체: OneSpaceSeparationStrategy
- `수식(Expression)`
    - `수식(Expression)`은 여러 개의 숫자와 `연산자(Operator)`로 이루어진다.
    - [X] 숫자의 개수가 `연산자(Operator)`의 개수보다 1만큼 큰 수식을 생성할 수 있다.
    - [X] 숫자의 개수가 `연산자(Operator)`의 개수보다 1만큼 크지 않은 경우 예외를 발생한다.
    - [X] 사칙연산에 대한 연산식을 계산할 수 있다.
- `연산자(Operator)`
    - [X] 연산자 기호가 없는 경우 예외가 발생한다.
    - [X] 연산자 기호를 통해 연산자를 찾을 수 있다.
    - [X] 두 개의 숫자를 입력 받아 사칙연산을 수행할 수 있다.
    - [X] 나눗셈의 경우 0으로 나누는 경우 예외가 발생한다.

## 3단계 - 자동차 경주

### 기능 요구 사항

초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
- 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

### 프로그래밍 요구 사항

- 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
- 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
- UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.

### 도메인 모델

- `자동차 게임(RacingGame)`
    - `자동차(Car)`들과 횟수를 상태로 가진다.
    - [X] 주어진 횟수 동안 게임이 종료되지 않는다.
    - [X] 주어진 횟수가 지나면 게임이 종료된다
    - [X] 게임 보고서를 조회할 수 있다

- `게임 보고서(RacingGameReport)`
  - [ ] 자동차 경주 게임을 완료한 후 누가 우승했는지를 조회한다. 우승자는 한 명 이상일 수 있다.

- `랩 보고서(LapReport)`
  - [X] 랩의 우승자를 조회한다. 우승자는 한 명 이상일 수 있다.

- `자동차들(Cars)`
    - `자동차(Car)` 목록을 상태로 가진다
    - [X] 이동 전략이 true 이면 자동차들이 전진한다
    - [X] 이동 전략이 false 이면 자동차들이 멈춰있는다
    - [X] 자동차들의 위치 정보를 제공한다

- `자동차(Car)`
    - `위치(Location)`와  상태로 가진다
    - ~~[X] 주어진 값이 4에서 9 사이면 전진한다~~
    - ~~[X] 주어진 값이 0에서 3 사이면 멈춰있는다~~
    - ~~[X] 값이 0 미만 10 초과이면 IllegalArgumentException 예외가 발생한다~~
    - [X] 이동 전략이 true 이면 전진한다
    - [X] 이동 전략이 false 이면 멈춰있는다

- `이동 전략(MovingStrategy)`
    - 자동차의 이동 여부를 결정한다

- `위치(Location)`
    - [X] 위치 값이 0 미만일 경우 예외를 발생한다
    - [X] 위치 값에서 전진하면 위치 값이 1 증가한다
    - [X] 같은 위치 값을 가질 경우 동등성을 보장한다
    - [X] 두 `위치(Location)`를 비교할 수 있다

- `자동차 이름(CarName)`
  - [X] 자동차 이름은 5자를 초과할 수 없다
  - [X] 자동차 이름은 빈 문자열일 수 없다
  - [X] 자동차 이름은 쉼표(,)를 기준으로 구분한다.
