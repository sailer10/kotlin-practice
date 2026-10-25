# 문법 범위와 문제 목록

Kotlin 2.3.21/JVM 기준 15개 주제, 85개 완성 예제 및 대응 연습 문제.

각 항목은 함수 계약과 테스트를 포함한다. 보조 타입은 문제 풀이용으로 제공하며 TODO 함수 본문을 완성한다.

## 범위의 한계

- 이 목록은 학습 주제 체크리스트이며 언어 문법의 모든 조합이나 모든 표준 라이브러리 API를 증명하는 목록이 아니다.
- KDoc, 패키지, import, 접근 제한자와 어노테이션은 여러 예제 및 Spring 코드에서 함께 사용한다.
- contracts, context parameters, context-sensitive resolution, explicit backing fields 등 preview/experimental 기능은 기본 빌드에서 제외한다.
- expect/actual, dynamic, external, C/Objective-C interop 등 타 플랫폼·멀티플랫폼 기능은 제외한다.
- 코루틴은 suspend 언어 기능과 kotlinx.coroutines 라이브러리를 구분하여 학습한다.
- compiler가 거부하는 코드는 실행 소스에 넣지 않고 학습 가이드에서 실험한다.

## 공식 기준

- https://kotlinlang.org/docs/keyword-reference.html
- https://kotlinlang.org/docs/whatsnew22.html
- https://kotlinlang.org/docs/whatsnew23.html

## 01. Basics
- 공식 문서: https://kotlinlang.org/docs/basic-syntax.html
- 예제: `src/main/kotlin/com/example/kotlinpractice/examples/basics/Basics.kt`
- 문제: `src/main/kotlin/com/example/kotlinpractice/exercises/basics/Basics.kt`
- 검증: `gradlew.bat exerciseTest --tests "*exercises.basics.*"`

- `variables`: val, var, const, 타입 추론과 복합 대입
- `numbers`: 정수·실수·unsigned 리터럴과 명시적 변환
- `strings`: Char, 이스케이프, 문자열 템플릿
- `rawString`: 여러 줄 문자열과 trimMargin
- `arrays`: 배열과 원시 타입 배열
- `bits`: 비트 연산 shl, or, and

## 02. ControlFlow
- 공식 문서: https://kotlinlang.org/docs/control-flow.html
- 예제: `src/main/kotlin/com/example/kotlinpractice/examples/controlflow/ControlFlow.kt`
- 문제: `src/main/kotlin/com/example/kotlinpractice/exercises/controlflow/ControlFlow.kt`
- 검증: `gradlew.bat exerciseTest --tests "*exercises.controlflow.*"`

- `max`: if 표현식
- `classify`: when, is, 스마트 캐스트, guard 조건
- `ranges`: ..<, step, downTo
- `loops`: for, while, do while, break, continue
- `labels`: 라벨과 return@forEach
- `nonLocalJump`: inline 람다에서 비지역 break와 continue

## 03. Nullability
- 공식 문서: https://kotlinlang.org/docs/null-safety.html
- 예제: `src/main/kotlin/com/example/kotlinpractice/examples/nullability/Nullability.kt`
- 문제: `src/main/kotlin/com/example/kotlinpractice/exercises/nullability/Nullability.kt`
- 검증: `gradlew.bat exerciseTest --tests "*exercises.nullability.*"`

- `length`: nullable, safe call, Elvis
- `cast`: 안전한 형 변환 as?
- `smartCast`: !is와 조기 반환을 통한 스마트 캐스트
- `required`: throw 표현식, Nothing
- `asserted`: !!의 성공과 실패를 안전한 테스트로 관찰
- `strictCast`: 명시적 형 변환 as

## 04. Functions
- 공식 문서: https://kotlinlang.org/docs/functions.html
- 예제: `src/main/kotlin/com/example/kotlinpractice/examples/functions/Functions.kt`
- 문제: `src/main/kotlin/com/example/kotlinpractice/exercises/functions/Functions.kt`
- 검증: `gradlew.bat exerciseTest --tests "*exercises.functions.*"`

- `arguments`: 기본 인자, 이름 있는 인자, 단일 표현식 함수
- `varargs`: vararg, spread 연산자
- `extensions`: 확장 함수와 확장 프로퍼티
- `infix`: infix 함수
- `local`: 지역 함수
- `tailRecursion`: tailrec와 require

## 05. Functional
- 공식 문서: https://kotlinlang.org/docs/lambdas.html
- 예제: `src/main/kotlin/com/example/kotlinpractice/examples/functional/Functional.kt`
- 문제: `src/main/kotlin/com/example/kotlinpractice/exercises/functional/Functional.kt`
- 검증: `gradlew.bat exerciseTest --tests "*exercises.functional.*"`

- `transform`: 함수 타입, 고차 함수, trailing lambda, it
- `closure`: 클로저와 캡처 변수
- `references`: 함수 참조와 프로퍼티 참조
- `anonymous`: 익명 함수의 지역 return
- `receiver`: 수신 객체가 있는 함수 타입
- `inlineReturn`: inline과 비지역 return
- `inlineModifiers`: noinline과 crossinline

## 06. Classes
- 공식 문서: https://kotlinlang.org/docs/classes.html
- 예제: `src/main/kotlin/com/example/kotlinpractice/examples/classes/Classes.kt`
- 문제: `src/main/kotlin/com/example/kotlinpractice/exercises/classes/Classes.kt`
- 검증: `gradlew.bat exerciseTest --tests "*exercises.classes.*"`

- `inheritance`: abstract, open, override, protected, super, 인터페이스 기본 구현
- `constructors`: 주·부 생성자, init, private set, companion object
- `nested`: 중첩 클래스, inner, this@Outer
- `anonymousObject`: object 선언과 object 표현식
- `localClass`: 지역 클래스와 바깥 변수 캡처

## 07. Modeling
- 공식 문서: https://kotlinlang.org/docs/data-classes.html
- 예제: `src/main/kotlin/com/example/kotlinpractice/examples/modeling/Modeling.kt`
- 문제: `src/main/kotlin/com/example/kotlinpractice/exercises/modeling/Modeling.kt`
- 검증: `gradlew.bat exerciseTest --tests "*exercises.modeling.*"`

- `data`: data class, copy, 구조 분해, 값 동등성
- `enums`: enum class, entries, valueOf, ordinal
- `sealed`: sealed interface, data object, exhaustive when
- `valueClass`: value class와 @JvmInline
- `sam`: fun interface와 SAM 변환
- `aliases`: 최상위·중첩 typealias
- `equality`: ==, ===, !==

## 08. Properties
- 공식 문서: https://kotlinlang.org/docs/delegated-properties.html
- 예제: `src/main/kotlin/com/example/kotlinpractice/examples/properties/Properties.kt`
- 문제: `src/main/kotlin/com/example/kotlinpractice/exercises/properties/Properties.kt`
- 검증: `gradlew.bat exerciseTest --tests "*exercises.properties.*"`

- `accessors`: 커스텀 접근자와 backing field
- `lateinit`: lateinit와 isInitialized
- `lazy`: lazy 위임과 최초 접근 초기화
- `observable`: observable, 람다 매개변수 생략 _
- `vetoable`: vetoable
- `customDelegate`: 커스텀 getValue/setValue 위임
- `mapDelegate`: Map 프로퍼티 위임
- `interfaceDelegate`: 인터페이스 구현 위임 by

## 09. Generics
- 공식 문서: https://kotlinlang.org/docs/generics.html
- 예제: `src/main/kotlin/com/example/kotlinpractice/examples/generics/Generics.kt`
- 문제: `src/main/kotlin/com/example/kotlinpractice/exercises/generics/Generics.kt`
- 검증: `gradlew.bat exerciseTest --tests "*exercises.generics.*"`

- `variance`: 선언 지점 out/in 공변·반공변
- `projections`: 사용 지점 out과 star projection
- `reified`: inline reified 타입 검사
- `bounds`: where 다중 상한
- `definitelyNonNull`: T & Any 확실한 비-null 타입
- `underscore`: 타입 인자 _ 추론

## 10. Operators
- 공식 문서: https://kotlinlang.org/docs/operator-overloading.html
- 예제: `src/main/kotlin/com/example/kotlinpractice/examples/operators/Operators.kt`
- 문제: `src/main/kotlin/com/example/kotlinpractice/exercises/operators/Operators.kt`
- 검증: `gradlew.bat exerciseTest --tests "*exercises.operators.*"`

- `arithmetic`: plus, minus, unaryMinus, inc, componentN
- `indexed`: get/set, invoke, contains, iterator
- `comparison`: compareTo 비교 관례

## 11. Collections
- 공식 문서: https://kotlinlang.org/docs/collections-overview.html
- 예제: `src/main/kotlin/com/example/kotlinpractice/examples/collections/Collections.kt`
- 문제: `src/main/kotlin/com/example/kotlinpractice/exercises/collections/Collections.kt`
- 검증: `gradlew.bat exerciseTest --tests "*exercises.collections.*"`

- `pipeline`: filter, map, distinct, sorted
- `grouping`: Map, Pair, groupBy
- `aggregate`: fold, reduce, sumOf와 함수 참조
- `partition`: partition과 구조 분해 가능한 Pair
- `sequence`: 지연 시퀀스와 무한 시퀀스 제한
- `builder`: 컬렉션 builder
- `operations`: Set, mutable 컬렉션, flatMap, associateWith
- `predicates`: any, all, none, !in

## 12. ScopeAndExceptions
- 공식 문서: https://kotlinlang.org/docs/scope-functions.html
- 예제: `src/main/kotlin/com/example/kotlinpractice/examples/scopeandexceptions/ScopeAndExceptions.kt`
- 문제: `src/main/kotlin/com/example/kotlinpractice/exercises/scopeandexceptions/ScopeAndExceptions.kt`
- 검증: `gradlew.bat exerciseTest --tests "*exercises.scopeandexceptions.*"`

- `scope`: let, run, with, apply, also
- `take`: takeIf와 takeUnless
- `exception`: try 표현식, catch, finally
- `result`: Result와 runCatching
- `resources`: use와 자원 해제

## 13. Dsl
- 공식 문서: https://kotlinlang.org/docs/type-safe-builders.html
- 예제: `src/main/kotlin/com/example/kotlinpractice/examples/dsl/Dsl.kt`
- 문제: `src/main/kotlin/com/example/kotlinpractice/exercises/dsl/Dsl.kt`
- 검증: `gradlew.bat exerciseTest --tests "*exercises.dsl.*"`

- `build`: @DslMarker, 수신 객체 람다, 타입 안전 builder
- `multiDollar`: multi-dollar 문자열 보간
- `expressionReturn`: 명시적 반환 타입 표현식 본문에서 return

## 14. Interop
- 공식 문서: https://kotlinlang.org/docs/java-interop.html
- 예제: `src/main/kotlin/com/example/kotlinpractice/examples/interop/Interop.kt`
- 문제: `src/main/kotlin/com/example/kotlinpractice/exercises/interop/Interop.kt`
- 검증: `gradlew.bat exerciseTest --tests "*exercises.interop.*"`

- `javaCall`: Java 호출, 플랫폼 타입을 nullable로 경계 처리
- `javaCallsKotlin`: @JvmStatic, @JvmOverloads, @JvmField
- `reflection`: annotation class, target, retention, ::class, reflection
- `aliasImport`: import as 별칭과 Java Locale

## 15. Coroutines
- 공식 문서: https://kotlinlang.org/docs/coroutines-overview.html
- 예제: `src/main/kotlin/com/example/kotlinpractice/examples/coroutines/Coroutines.kt`
- 문제: `src/main/kotlin/com/example/kotlinpractice/exercises/coroutines/Coroutines.kt`
- 검증: `gradlew.bat exerciseTest --tests "*exercises.coroutines.*"`

- `concurrent`: suspend, coroutineScope, async/await, delay
- `launch`: launch, Job, join
- `flow`: Flow builder, emit와 중간·최종 연산
- `cancel`: 코루틴 시작, 협력적 취소와 finally 정리를 순서대로 관찰
- `channel`: Channel, send, 순회 수신, close
