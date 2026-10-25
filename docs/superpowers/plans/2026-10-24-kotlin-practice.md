# Kotlin Practice Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox syntax for tracking.

**Goal:** Build the approved dual-mode Kotlin learning project and study-record REST API.
**Architecture:** One Gradle project with examples, exercises and application packages. Exercise tests are explicitly tagged and separately executable.
**Tech Stack:** Kotlin 2.3.21 / Spring Boot 4.1.2 / Java 21 / Gradle Wrapper / MVC / Data JDBC / H2 / JUnit.
**Spec:** ../specs/2026-10-24-kotlin-practice-design.md

## Global Constraints
- Use the user's requested path and preserve existing files; baseline directory was empty, not a Git repository.
- Default build passes; exerciseTest deliberately fails until the learner completes TODO bodies.
- API supports CRUD, status change and filtering with input validation.
- Match examples/exercises function contracts and tests topic by topic.

## Review Focus
- Empty and whitespace titles must yield 400 and persist nothing.
- Missing records must yield 404 for reads and all mutations.
- Malformed JSON, missing fields and invalid enum names must yield 400.
- Updating content preserves status and changing status persists it.
- Empty collections, nulls and casts have explicit expected outcomes in language tests.

### Task 1: Language learning harness
Files: build.gradle.kts; examples/<topic>/*.kt; exercises/<topic>/*.kt; matching test packages; JavaGreeter.java.
Interfaces: matching public object functions and result types in both packages.
- [x] Generate tagged test contracts and TODO function stubs for both modes.
- [x] Run gradlew.bat test: expect NotImplementedError in reference stubs.
- [x] Replace only examples TODO bodies with reference implementations.
- [x] Run language tests: expect success; exerciseTest: expect documented TODO failures.

### Task 2: Study record REST API
Files: application/{model,repository,service,controller}/*.kt; application.properties; schema.sql; StudyRecordApiTest.kt.
Interfaces: StudyRecord(id,title,description,status); routes specified in design.
- [x] Create real MVC/JDBC integration tests including all Review Focus API cases.
- [x] Run API tests without controller: expect route assertions to fail with 404.
- [x] Implement DTO validation, immutable data model, repository, transactional service, controller and 404 mapping.
- [x] Run complete default tests and bootJar: expect exit 0.

### Task 3: Learning guide and delivery
Files: README.md; docs/COVERAGE.md; docs/API.http; docs/LEARNING_PATH.md.
- [x] Link each topic and problem to official docs, test commands and Spring application points.
- [x] Record exact validation counts, intentional exercise failures and scope exclusions.
- [x] Independently review build routing and API behavior before delivery.
