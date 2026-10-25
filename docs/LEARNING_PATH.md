# Kotlin Practice 학습 순서

이 문서는 이 프로젝트를 처음 열었을 때부터 문법을 직접 구현하고 Spring API에서 활용하는 단계까지의 안내서입니다.
권장 흐름은 **기초 문법 → 함수·객체·컬렉션 → Spring API → 고급 문법**입니다.
문법별 전체 함수 목록은 [COVERAGE.md](COVERAGE.md)에서 확인할 수 있습니다.

## 1. 처음 시작할 때

PowerShell에서 프로젝트 경로로 이동한 뒤 기본 테스트를 실행합니다.

```powershell
Set-Location 'C:\Users\Seil\Workspaces\Study\kotlin-practice'
java -version
.\gradlew.bat test
```

JDK 21을 사용합니다. 최초 실행에는 Gradle과 의존성을 다운로드할 인터넷 연결이 필요합니다.
`test`는 완성 예제와 Spring API를 검증하며, 미완성 연습 문제는 실행하지 않습니다.
프로젝트 생성 당시의 검증 결과는 [VERIFICATION.md](VERIFICATION.md)에 기록되어 있습니다.

세 패키지의 역할부터 구분합니다.

| 패키지 | 역할 | 학습할 때 할 일 |
|---|---|---|
| `examples` | 완성된 문법 예제 | 실행 결과를 예측한 뒤 코드와 테스트를 읽습니다. |
| `exercises` | 같은 주제의 TODO 문제 | 직접 구현하고 대응 테스트를 통과시킵니다. |
| `application` | 문법을 적용한 Spring API | 요청이 저장되고 응답되는 흐름을 따라갑니다. |

## 2. 첫날은 이 파일부터 읽기

다음 네 파일을 차례로 엽니다.

1. [Basics.kt 완성 예제](../src/main/kotlin/com/example/kotlinpractice/examples/basics/Basics.kt): 먼저 `variables`, `strings`를 읽습니다.
2. [BasicsTest.kt 예제 테스트](../src/test/kotlin/com/example/kotlinpractice/examples/basics/BasicsTest.kt): 입력과 예상 결과가 어떻게 연결되는지 확인합니다.
3. [Basics.kt 연습 문제](../src/main/kotlin/com/example/kotlinpractice/exercises/basics/Basics.kt): 예제를 닫고 `variables`의 TODO 본문을 구현합니다.
4. [BasicsTest.kt 문제 테스트](../src/test/kotlin/com/example/kotlinpractice/exercises/basics/BasicsTest.kt): 구현이 충족해야 하는 조건을 확인합니다.

완성 예제와 자신의 구현을 각각 한 문제씩 실행할 수 있습니다.

```powershell
# 완성 예제의 variables 실행
.\gradlew.bat test --tests "com.example.kotlinpractice.examples.basics.BasicsTest.variables"

# 직접 구현한 variables 실행
.\gradlew.bat exerciseTest --tests "com.example.kotlinpractice.exercises.basics.BasicsTest.variables"

# 기초 주제 전체 연습 문제 실행
.\gradlew.bat exerciseTest --tests "*exercises.basics.*"
```

**첫날 완료 기준:** `variables`, `strings`를 스스로 설명하고 두 문제를 예제 없이 다시 구현할 수 있습니다.
`numbers`, `rawString`, `arrays`까지 진행하고, 비트 연산 `bits`는 이후 복습 때 살펴봐도 됩니다.

## 3. 매 주제에서 반복할 학습 방법

1. 아래 표에서 해당 주제의 완성 예제를 엽니다. 함수 위의 한국어 설명을 먼저 읽습니다.
2. 코드를 실행하기 전에 결과를 적어 보고, 대응하는 예제 테스트의 예상값과 비교합니다.
3. 예제를 닫고 같은 주제의 연습 문제에서 TODO 본문을 구현합니다.
4. 문제 테스트를 읽고, 한 함수 또는 한 주제만 실행합니다.
5. 막히면 테스트의 입력·반환 타입·예외 조건을 확인한 뒤 완성 예제를 참고합니다.
6. 통과하면 다른 입력 하나를 생각해 결과를 설명하고, 아래 체크박스를 표시합니다.

처음의 `kotlin.NotImplementedError`는 TODO 문제의 의도된 실패입니다.
반면 `compileKotlin` 또는 `compileTestKotlin`의 컴파일 오류는 먼저 수정해야 합니다.
주제별로 실행해도 소스 전체를 컴파일하므로 다른 파일에 문법 오류가 있으면 실행이 막힐 수 있습니다.
테스트의 예상값과 함수 시그니처를 유지하고 구현을 완성합니다. 보조 클래스는 문제 풀이용으로 제공되어 있습니다.

## 4. 기초부터 Spring 준비까지

아래 순서는 COVERAGE의 번호보다 학습 선행 관계를 우선한 권장 순서입니다.
한 주제에 한 학습 회차를 쓰되, 익숙하지 않으면 여러 회차로 나누어 진행합니다.

| 순서 | 주제와 파일 | 먼저 볼 함수·내용 | 다음 단계로 넘어갈 기준 |
|---|---|---|---|
| 1 | [Basics 예제](../src/main/kotlin/com/example/kotlinpractice/examples/basics/Basics.kt) · [문제](../src/main/kotlin/com/example/kotlinpractice/exercises/basics/Basics.kt) | `variables` → `strings` → `numbers` → `rawString` → `arrays` | `val`/`var`, 타입 추론, 문자열 보간, 배열을 설명합니다. |
| 2 | [Functions 예제](../src/main/kotlin/com/example/kotlinpractice/examples/functions/Functions.kt) · [문제](../src/main/kotlin/com/example/kotlinpractice/exercises/functions/Functions.kt) | `arguments` → `varargs` → `local` → `extensions` | 기본값·이름 있는 인자와 확장 함수를 직접 씁니다. `infix`, `tailRecursion`은 뒤에 복습합니다. |
| 3 | [ControlFlow 예제](../src/main/kotlin/com/example/kotlinpractice/examples/controlflow/ControlFlow.kt) · [문제](../src/main/kotlin/com/example/kotlinpractice/exercises/controlflow/ControlFlow.kt) | `max` → `ranges` → `loops` → `classify` | `if`/`when`의 반환값과 반복 범위를 예측합니다. `labels`, `nonLocalJump`는 7단계 뒤에 다시 봅니다. |
| 4 | [Nullability 예제](../src/main/kotlin/com/example/kotlinpractice/examples/nullability/Nullability.kt) · [문제](../src/main/kotlin/com/example/kotlinpractice/exercises/nullability/Nullability.kt) | `length` → `smartCast` → `cast` → `required` | `?.`, `?:`, `as?`를 선택할 수 있고 `!!`, `as`의 실패 조건을 설명합니다. |
| 5 | [Classes 예제](../src/main/kotlin/com/example/kotlinpractice/examples/classes/Classes.kt) · [문제](../src/main/kotlin/com/example/kotlinpractice/exercises/classes/Classes.kt) | 보조 타입 `Account` → `constructors` → `inheritance` → `nested` | 생성자·프로퍼티·인터페이스·상속·companion object를 구분합니다. |
| 6 | [Modeling 예제](../src/main/kotlin/com/example/kotlinpractice/examples/modeling/Modeling.kt) · [문제](../src/main/kotlin/com/example/kotlinpractice/exercises/modeling/Modeling.kt) | `data` → `enums` → `equality` → `sealed` | `data class`, `copy`, enum, 값 동등성과 참조 동등성을 설명합니다. |
| 7 | [Functional 예제](../src/main/kotlin/com/example/kotlinpractice/examples/functional/Functional.kt) · [문제](../src/main/kotlin/com/example/kotlinpractice/exercises/functional/Functional.kt) | `transform` → `closure` → `references` → `anonymous` → `receiver` | 람다와 함수 참조를 인자로 전달합니다. 이후 `inlineReturn`, `inlineModifiers`와 ControlFlow의 보류 항목을 읽습니다. |
| 8 | [Collections 예제](../src/main/kotlin/com/example/kotlinpractice/examples/collections/Collections.kt) · [문제](../src/main/kotlin/com/example/kotlinpractice/exercises/collections/Collections.kt) | `pipeline` → `grouping` → `partition` → `predicates` → 나머지 | `map`/`filter`/`groupBy`를 쓰고 List·Set·Map 및 Sequence의 차이를 설명합니다. |
| 9 | [ScopeAndExceptions 예제](../src/main/kotlin/com/example/kotlinpractice/examples/scopeandexceptions/ScopeAndExceptions.kt) · [문제](../src/main/kotlin/com/example/kotlinpractice/exercises/scopeandexceptions/ScopeAndExceptions.kt) | `scope` → `take` → `exception` → `result` → `resources` | `let`/`apply` 등의 반환값·수신 객체를 구분하고 예외 흐름을 읽습니다. |

주제별 실행 명령에서 패키지 이름만 바꿉니다.

```powershell
.\gradlew.bat exerciseTest --tests "*exercises.functions.*"
.\gradlew.bat exerciseTest --tests "*exercises.controlflow.*"
.\gradlew.bat exerciseTest --tests "*exercises.nullability.*"
.\gradlew.bat exerciseTest --tests "*exercises.classes.*"
.\gradlew.bat exerciseTest --tests "*exercises.modeling.*"
.\gradlew.bat exerciseTest --tests "*exercises.functional.*"
.\gradlew.bat exerciseTest --tests "*exercises.collections.*"
.\gradlew.bat exerciseTest --tests "*exercises.scopeandexceptions.*"
```

## 5. 배운 문법을 Spring 코드에 연결하기

기초 9개 주제를 공부한 뒤 이 단계로 옵니다. 프레임워크 어노테이션이 낯설어도 먼저 Kotlin 코드가 무엇을 반환하는지에 집중합니다.

### 읽을 파일 순서

| 순서 | 파일 | 확인할 질문 |
|---|---|---|
| 1 | [build.gradle.kts](../build.gradle.kts) | MVC·JDBC·H2 의존성은 어디에 있나요? `kotlin("plugin.spring")`은 Spring에 필요한 클래스를 어떻게 open 처리하나요? |
| 2 | [KotlinPracticeApplication.kt](../src/main/kotlin/com/example/kotlinpractice/KotlinPracticeApplication.kt) | 최상위 `main` 함수와 `*args`는 어떤 의미인가요? |
| 3 | [StudyRecord.kt](../src/main/kotlin/com/example/kotlinpractice/application/model/StudyRecord.kt) | `description`·`id`가 nullable인 이유는 무엇이며, `status`의 기본값은 무엇인가요? |
| 4 | [StudyRequests.kt](../src/main/kotlin/com/example/kotlinpractice/application/model/StudyRequests.kt) | 요청 객체와 저장 모델은 어떻게 다르며, `@field:NotBlank`는 어디에 적용되나요? |
| 5 | [StudyRecordRepository.kt](../src/main/kotlin/com/example/kotlinpractice/application/repository/StudyRecordRepository.kt) | `CrudRepository<StudyRecord, Long>`의 두 타입 인자는 무엇인가요? 처음에는 제네릭의 상세 규칙보다 타입의 역할을 확인합니다. |
| 6 | [StudyRecordService.kt](../src/main/kotlin/com/example/kotlinpractice/application/service/StudyRecordService.kt) | `list` → `get` → `create` → `update` → `changeStatus` → `delete` 순으로 읽고, `?.let`, `?: throw`, `copy`와 `normalizedTitle` 확장 프로퍼티를 찾습니다. |
| 7 | [StudyRecordController.kt](../src/main/kotlin/com/example/kotlinpractice/application/controller/StudyRecordController.kt) | HTTP 메서드가 어떤 서비스 함수로 이어지며, 생성 응답의 201·Location은 어디서 만드나요? |
| 8 | [ApiExceptionHandler.kt](../src/main/kotlin/com/example/kotlinpractice/application/controller/ApiExceptionHandler.kt) | 없는 ID와 정규화 후 빈 제목은 각각 어떤 오류 응답으로 바뀌나요? |
| 9 | [schema.sql](../src/main/resources/schema.sql) · [application.properties](../src/main/resources/application.properties) | 모델의 필드와 테이블 컬럼은 어떻게 연결되며, DB는 어디에 저장되나요? |
| 10 | [StudyRecordApiTest.kt](../src/test/kotlin/com/example/kotlinpractice/application/StudyRecordApiTest.kt) | 테스트가 실제 MVC·JDBC·H2를 통해 저장 결과, 입력 검증, 상태 보존을 어떻게 확인하나요? |

### 실제 요청을 보내며 확인하기

첫 번째 터미널에서 서버를 시작합니다.

```powershell
.\gradlew.bat bootRun
```

[API.http](API.http)의 요청을 지원하는 IDE에서 실행하거나, 별도의 PowerShell 터미널에서 아래처럼 요청합니다.
두 번째 터미널에서도 프로젝트 경로를 기준으로 작업합니다.

```powershell
$base = 'http://localhost:8080/api/study-records'
$body = @{ title = '  Kotlin functions  '; description = '이름 있는 인자와 기본값' } | ConvertTo-Json
$created = Invoke-RestMethod -Method Post -Uri $base -ContentType 'application/json; charset=utf-8' -Body ([System.Text.Encoding]::UTF8.GetBytes($body))
$created
Invoke-RestMethod -Uri "$base/$($created.id)"
```

이어서 API.http를 사용해 다음 순서로 살펴봅니다. 파일의 `@id`는 생성 응답의 실제 id로 바꿉니다.

1. 항목을 생성하고 제목 앞뒤 공백이 제거되었는지 확인합니다.
2. 목록과 단건 조회에서 같은 항목이 보이는지 확인합니다.
3. 상태를 `COMPLETED`로 바꾸고 상태별 목록을 조회합니다.
4. 제목·설명을 수정한 뒤 상태가 `COMPLETED`로 유지되는지 확인합니다.
5. 공백 제목 요청은 400, 없는 ID 조회는 404가 되는지 확인합니다.
6. 삭제 후 같은 ID를 조회하고 404를 확인합니다.

서버 종료는 실행 중인 터미널에서 `Ctrl+C`를 누릅니다.
메모리 H2 DB이므로 서버를 재시작하면 저장한 기록이 초기화됩니다.

API 테스트만 다시 실행하려면 아래 명령을 사용합니다.

```powershell
.\gradlew.bat test --tests "com.example.kotlinpractice.application.StudyRecordApiTest"
```

**Spring 단계 완료 기준:** POST 요청 하나가 Controller → Service → Repository → H2를 거쳐 응답되는 흐름을 설명하고,
본문 수정 시 상태를 보존하는 `copy` 코드를 직접 설명할 수 있습니다.

## 6. 고급 문법으로 확장하기

Spring 코드를 한 차례 읽은 뒤 다음 순서로 이어갑니다. 기초 단계에서 보류했던 함수도 함께 마무리합니다.

| 순서 | 주제와 파일 | 권장 학습 순서와 확인할 점 |
|---|---|---|
| 10 | [Properties 예제](../src/main/kotlin/com/example/kotlinpractice/examples/properties/Properties.kt) · [문제](../src/main/kotlin/com/example/kotlinpractice/exercises/properties/Properties.kt) | `accessors` → `lateinit` → `lazy` → `observable`/`vetoable` → `customDelegate`/`mapDelegate`/`interfaceDelegate`. 프로퍼티 위임과 인터페이스 위임을 구분합니다. |
| 11 | [Generics 예제](../src/main/kotlin/com/example/kotlinpractice/examples/generics/Generics.kt) · [문제](../src/main/kotlin/com/example/kotlinpractice/exercises/generics/Generics.kt) | 보조 타입 `Producer`/`Consumer`를 읽고 `variance` → `projections` → `bounds` → `reified` → 나머지를 봅니다. Functional의 `inlineModifiers`도 복습합니다. |
| 12 | [Operators 예제](../src/main/kotlin/com/example/kotlinpractice/examples/operators/Operators.kt) · [문제](../src/main/kotlin/com/example/kotlinpractice/exercises/operators/Operators.kt) | `Point`/`Bag` 선언 → `arithmetic` → `indexed` → `comparison`. `+`, `[]`, `in`, `()`가 어떤 함수 호출인지 설명합니다. |
| 13 | [Dsl 예제](../src/main/kotlin/com/example/kotlinpractice/examples/dsl/Dsl.kt) · [문제](../src/main/kotlin/com/example/kotlinpractice/exercises/dsl/Dsl.kt) | Functional의 `receiver` 복습 → `LessonBuilder` → `build`. 이어서 문자열·표현식 문법인 `multiDollar`, `expressionReturn`을 봅니다. |
| 14 | [Interop 예제](../src/main/kotlin/com/example/kotlinpractice/examples/interop/Interop.kt) · [문제](../src/main/kotlin/com/example/kotlinpractice/exercises/interop/Interop.kt) | `javaCall` → `javaCallsKotlin` → `aliasImport` → `reflection`. 호출 방향과 플랫폼 타입, JVM 어노테이션을 확인합니다. |
| 15 | [Coroutines 예제](../src/main/kotlin/com/example/kotlinpractice/examples/coroutines/Coroutines.kt) · [문제](../src/main/kotlin/com/example/kotlinpractice/exercises/coroutines/Coroutines.kt) | `launch` → `concurrent` → `cancel` → `flow` → `channel`. 취소 예제의 반환 순서는 시작 여부·취소 여부·finally 정리 여부입니다. |

Java 연동에서는 [공통 JavaGreeter](../src/main/java/com/example/kotlinpractice/interop/JavaGreeter.java),
[예제 JavaCaller](../src/main/java/com/example/kotlinpractice/examples/interop/JavaCaller.java),
[문제 JavaCaller](../src/main/java/com/example/kotlinpractice/exercises/interop/JavaCaller.java)도 함께 엽니다.
각 JavaCaller는 자기 패키지의 KotlinBridge를 호출합니다.

```powershell
.\gradlew.bat exerciseTest --tests "*exercises.properties.*"
.\gradlew.bat exerciseTest --tests "*exercises.generics.*"
.\gradlew.bat exerciseTest --tests "*exercises.operators.*"
.\gradlew.bat exerciseTest --tests "*exercises.dsl.*"
.\gradlew.bat exerciseTest --tests "*exercises.interop.*"
.\gradlew.bat exerciseTest --tests "*exercises.coroutines.*"
```

`suspend`는 언어 기능이고 `launch`, `async`, `Flow`, `Channel` 등은 kotlinx.coroutines 라이브러리의 기능입니다.
현재 Spring API는 MVC·JDBC 기반이며 코루틴 예제와 별도로 동작합니다.
코루틴을 학습했다고 현재 JDBC 호출이 자동으로 비동기·논블로킹으로 바뀌지는 않습니다.

## 7. 진도 체크리스트

- [ ] 기본 테스트를 실행하고 examples·exercises·application의 역할을 구분했다.
- [ ] Basics: 보류했던 `bits`까지 포함해 기초 문제를 마쳤다.
- [ ] Functions: `infix`, `tailRecursion`까지 포함해 함수 문제를 마쳤다.
- [ ] ControlFlow: `labels`, `nonLocalJump`까지 포함해 제어 흐름 문제를 마쳤다.
- [ ] Nullability: null 처리와 안전·강제 형 변환의 실패 조건을 설명했다.
- [ ] Classes: 생성자·상속·인터페이스·중첩 클래스 문제를 마쳤다.
- [ ] Modeling: `valueClass`, `sam`, `aliases`까지 포함해 모델링 문제를 마쳤다.
- [ ] Functional: inline·noinline·crossinline까지 설명했다.
- [ ] Collections: 컬렉션 변환과 지연 Sequence를 직접 구현했다.
- [ ] ScopeAndExceptions: 스코프 함수의 반환값과 예외 처리 흐름을 설명했다.
- [ ] Spring API 요청·저장·응답 흐름을 코드와 연결했다.
- [ ] Properties: 프로퍼티·인터페이스 위임 문제를 마쳤다.
- [ ] Generics: 변성·타입 투영·reified 문제를 마쳤다.
- [ ] Operators: 연산자와 대응 함수를 연결했다.
- [ ] Dsl: 수신 객체 람다로 builder를 구현했다.
- [ ] Interop: Java ↔ Kotlin 호출과 리플렉션 예제를 확인했다.
- [ ] Coroutines: 실행·동시 작업·취소·Flow·Channel을 구현했다.
- [ ] 전체 연습 문제를 통과시키고 기본 빌드도 성공시켰다.

모든 TODO를 구현한 뒤 아래 두 명령으로 마무리합니다.

```powershell
.\gradlew.bat exerciseTest
.\gradlew.bat build
```

전체 연습 문제 통과는 직접 구현한 문제의 검증이며, 기본 build 성공만으로 연습 문제까지 완료한 것은 아닙니다.
복습할 때는 COVERAGE에서 주제를 하나 고르고, 예제를 보지 않고 다시 구현하거나 새 입력의 결과를 설명합니다.

## 8. 컴파일 오류를 통해 추가로 확인할 것

IDE의 Kotlin scratch 파일 등 프로젝트 소스와 분리된 공간에서 다음 코드를 실험합니다.

- `val`에 값을 다시 대입하면 어떤 오류가 나는가?
- nullable 값에 바로 `.length`를 호출하면 무엇을 수정해야 하는가?
- `open`이 없는 클래스를 상속하면 어떤 오류가 나는가?
- `Producer<out T>`에 값을 받는 함수를 추가하면 왜 제한되는가?

실행 소스 안에서 실험했다면 오류 코드를 되돌린 뒤 테스트를 실행합니다.
이 학습 범위는 Kotlin/JVM 안정 기능의 주요 범주이며, 실험적 문법과 타 플랫폼 기능의 제외 항목은 COVERAGE를 참고합니다.
