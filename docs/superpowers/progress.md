# SDD ledger — plan: docs/superpowers/plans/2026-10-24-kotlin-practice.md
Ruling: Execute inline under the user's implementation authorization; no further design approval is needed.
Ruling: Use the requested empty non-Git directory; no worktree or commits apply.
Pre-flight: Language methods have paired example/exercise signatures; API tests consume only HTTP contracts.
Initializr: metadata advertised 4.1.2.RELEASE, which failed BOM resolution; canonical 4.1.2 generated successfully.
RED: default test executed 96 tests; 85 reference TODO failures and 10 absent-route failures; context smoke passed. JVM test-name restriction corrected using @DisplayName.


Review fixes: H2 quoted identifier mapped to STUDY_RECORDS; Unicode-title regression and cancellation lifecycle assertions first observed RED before fixes.
Ruling: Keep the documented 15-topic/85-method scope; cancellation returns three lifecycle flags instead of a single cancelled flag so actual execution and cleanup are observable.
Review refactor: JavaCaller is duplicated at the package boundary so examples and exercises invoke their own KotlinBridge. Shared JavaGreeter has no reference-package dependency.

Final: regraded cancellation mismatch as an educational correctness issue; observed RED before implementation and verified lifecycle flags GREEN.
Task 1: complete — 85 reference tests pass; 85 exercises fail only with NotImplementedError.
Task 2: complete — 11 API integration tests and context smoke pass.
Task 3: complete — guides, coverage checklist, HTTP examples and verification report delivered.
Final: default build success; 97/97 default tests; executable JAR passes 9 real HTTP checks and server stopped.
Final: scope rulings — authentication/deployment, concurrent-writer conflict policy, exhaustive grammar/stdlib and preview/multiplatform work remain outside this local learning project. No deferred minor code findings.
