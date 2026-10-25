# Kotlin practice design — approved in conversation

Goal: Kotlin 공식 문서 기반의 완성 예제와 TODO 연습 문제를 한 Spring Boot 프로젝트에서 학습한다.
Target: C:\Users\Seil\Workspaces\Study\kotlin-practice
Stack: Kotlin 2.3.21, Spring Boot 4.1.2, JDK 21, Gradle Kotlin DSL / Wrapper, MVC, Data JDBC, H2, JUnit.
Approaches: examples-only is insufficient for active practice; exercises-only lacks a readable reference.
Decision: separate examples and exercises packages with corresponding tests; a third application package applies language features to a study-record REST API.
API: CRUD /api/study-records; PATCH /{id}/status; optional status filter; 201+Location on creation; 204 deletion; 400 invalid input; 404 absent ID.
Data: title required/nonblank/max120, description nullable/max2000; statuses TODO, IN_PROGRESS, COMPLETED. H2 memory database resets on application restart.
Tests: normal test excludes exercise tag; exerciseTest includes only exercise tag and initially fails with NotImplementedError.
Scope: JVM stable language feature categories plus selected standard-library patterns, Java interop and coroutine library basics.
Non-goals: claiming every grammar production or stdlib function is covered; JS/Native/Wasm/Multiplatform; preview compiler flags; authentication and deployment.
Learning structure: matching 15 topic packages, documentation links, problem descriptions, independently derived assertions, Spring usage map.

