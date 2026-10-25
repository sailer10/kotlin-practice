# Kotlin Practice

Kotlin 공식 자료를 바탕으로 **완성 예제 → 직접 풀이 → Spring 적용** 순서로 학습하는 프로젝트입니다.

- Kotlin 2.3.21 · Spring Boot 4.1.2 · JDK 21 · Gradle Wrapper
- Spring MVC · Spring Data JDBC · H2 · JUnit
- 15개 주제, 85개 완성 예제와 85개 TODO 연습 문제

## 실행

PowerShell에서 프로젝트 디렉터리로 이동한 뒤 실행하세요. JDK 21의 java가 PATH에 있거나 JAVA_HOME이 설정되어 있어야 합니다.
최초 실행에는 Gradle과 Maven Central 의존성을 다운로드할 인터넷 연결이 필요합니다.

```powershell
.\gradlew.bat test
.\gradlew.bat exerciseTest
.\gradlew.bat exerciseTest --tests "*exercises.basics.*"
.\gradlew.bat bootRun
.\gradlew.bat build
```

- `test`, `check`, `build`: 완성 예제와 Spring API 테스트를 실행합니다.
- `exerciseTest`: TODO 문제만 실행하며 **처음에는 의도적으로 실패**합니다. 이 실패는 프로젝트 빌드 오류가 아닙니다.
- 연습 문제의 함수 시그니처와 테스트를 유지하고 TODO 본문을 구현하세요. 보조 타입은 제공됩니다.
- 문제 테스트는 예제 테스트와 같은 계약을 검증하지만 `exercises` 구현을 직접 호출합니다.
- macOS/Linux에서는 `./gradlew`를 사용합니다.

## 구성

```text
src/main/kotlin/com/example/kotlinpractice/
  examples/       완성 예제와 한국어 문법 설명
  exercises/      같은 주제·함수 계약의 TODO 문제
  application/    controller / service / repository / model
src/main/java/    Java ↔ Kotlin 연동 예제
src/test/kotlin/  각 패키지에 대응하는 테스트
```

## 학습 자료

1. [Kotlin Tour](https://kotlinlang.org/docs/kotlin-tour-welcome.html)
2. [Basic syntax](https://kotlinlang.org/docs/basic-syntax.html)
3. [Kotlin Koans](https://kotlinlang.org/docs/koans.html)
4. [Spring Boot Kotlin 공식 튜토리얼](https://kotlinlang.org/docs/jvm-get-started-spring-boot.html)

자체 작성 예제이며 공식 Koans의 문제나 정답을 복제하지 않았습니다.

- [문법 범위와 문제 목록](docs/COVERAGE.md)
- [처음부터 따라가는 학습 순서와 진도표](docs/LEARNING_PATH.md)
- [API 요청 예시](docs/API.http)
- [검증 결과](docs/VERIFICATION.md)

## 학습 기록 API

기본 주소: `http://localhost:8080/api/study-records`

| 메서드 | 경로 | 동작 |
|---|---|---|
| POST | `/api/study-records` | 생성: 201, Location 헤더 |
| GET | `/api/study-records` | ID 오름차순 목록 |
| GET | `/api/study-records?status=COMPLETED` | 상태별 목록 |
| GET | `/api/study-records/{id}` | 단건 조회 |
| PUT | `/api/study-records/{id}` | 제목·설명 전체 교체, 상태 유지 |
| PATCH | `/api/study-records/{id}/status` | 상태 변경 |
| DELETE | `/api/study-records/{id}` | 삭제: 204 |

```powershell
$body = @{title = 'Null safety'; description = 'safe call과 Elvis 연습'} | ConvertTo-Json
Invoke-RestMethod -Method Post -Uri 'http://localhost:8080/api/study-records' -ContentType 'application/json; charset=utf-8' -Body ([System.Text.Encoding]::UTF8.GetBytes($body))
Invoke-RestMethod -Uri 'http://localhost:8080/api/study-records'
```

제목은 공백 불가·최대 120자이며 저장 시 앞뒤 공백을 제거합니다. 설명은 nullable·최대 2000자입니다.
상태는 `TODO`, `IN_PROGRESS`, `COMPLETED`이며 기본값은 `TODO`입니다. 상태 전이는 자유롭게 가능합니다.
잘못된 입력은 400, 없는 ID는 404를 반환합니다.

H2는 메모리 DB이므로 애플리케이션을 재시작하면 데이터가 초기화됩니다. 학습용 로컬 API이며 인증 기능은 없습니다.
Kotlin/JVM 안정 문법의 주요 범주를 다룹니다. 모든 표준 라이브러리 API·타 플랫폼·실험 기능은 범위에 포함하지 않습니다.

