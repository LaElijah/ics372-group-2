# ICS 372-02 — Brew & Byte Group Repository
**Object-Oriented Design and Implementation · Fall 2026**
Benjamin Cassidy · Metropolitan State University

---

This is your group's repository for the Brew & Byte coffee shop POS system. Two things live here: the **design artifact trail** in `docs/` and the **application source code** in `src/`. Both tracks are part of the final project submission — a clean, complete `docs/` history carries as much weight as working code. The `docs/` trail is also graded on a weekly basis (see **Weekly Grading** below) — it isn't only reviewed once, at the end, as part of the final project.

---

## Repository Structure

```
docs/
    week-XX/
        group-artifact-1.md
        group-artifact-2.md
    resources/
        mermaid-cheatsheet.md
        markdown-cheatsheet.md
    templates/
        group-artifact-template.md
src/
    main/
        java/edu/metrostate/oodi/coffeeshop/
        resources/edu/metrostate/oodi/coffeeshop/
build.gradle.kts
settings.gradle.kts
```

---

## Design Artifacts — docs/week-XX/

Every class session that produces a group artifact gets a folder in `docs/`. One folder per week, one file per folder.

**Folder naming:** `week-02`, `week-03`, ..., `week-14`. Zero-padded, lowercase, hyphenated. Exact match — grading scripts look for this string.

**File names:** `group-artifact-1.md` and `group-artifact-2.md` — one per round, always inside the week folder. Both files are expected every week.

**Every artifact is markdown — no exceptions.** `.md`, never `.docx`, never `.pdf`, never a screenshot or exported image. Diagrams are Mermaid code blocks inside the `.md` file, not attached images. A file in the wrong format is treated the same as a missing file: zero. See `docs/resources/markdown-cheatsheet.md`.

### What a complete group artifact includes

- A class diagram in Mermaid
- The key design decisions you made this session, with stated rationale for each
- Alternatives you considered and why you chose against them
- Open questions you deferred, named explicitly with a sentence about why

That last point matters. Deferred decisions are expected and fine — the problem is always bigger than one class session. Unnamed deferred decisions are not fine. If you chose not to model something, say so and say why. "We didn't model Dock as a class because none of our current use cases require dock-level tracking — flagged as a likely Week 6 addition" is good. Silence is not.

### Weekly Grading

**Weekly group submissions are worth 20 points per week — 11 weeks total (weeks 2–4, 6–14), 220 points overall.** `group-artifact-1.md` and `group-artifact-2.md` are graded together as a single weekly grade, not separately. Every member of the group receives the same grade for that week's submission — this is a group grade, not split by individual contribution (individual accountability for the same session is captured separately, in each person's own design log).

The rubric is the same kind used for individual design logs: it rewards reasoning, not correctness. A wrong design with clearly stated alternatives and rationale scores higher than a clean diagram with no explanation behind it. Concretely, a strong week's submission:

- States the decisions made, not just the final diagram — *why* did the group land here, not just *where* did it land
- Names at least one alternative that was considered and explains why it was rejected
- Explicitly calls out anything deferred, with a reason (see the example above)
- Reads as the group's actual reasoning that session, not a cleaned-up summary written after the fact

A missing artifact at either commit checkpoint (before the break, before class ends) is a zero for that half of the week's grade. There is no late submission and no makeup. Note this is stricter than the deadline on individual design logs, which get until 11:59pm the same night — group artifacts stay tied to the in-class checkpoints because `group-artifact-1.md` specifically needs to exist before the debrief that follows it.

### Artifact schedule

| Week | Date   | Artifact focus                                   |
| ---: | :----- | :----------------------------------------------- |
|    2 | Sep 3  | Domain model — entities, state, behavior         |
|    3 | Sep 10 | Interfaces, abstract classes, Iterator            |
|    4 | Sep 17 | Use case diagram, class diagram, sequence        |
|    6 | Oct 1  | Conceptual class diagram                         |
|    7 | Oct 8  | Software class diagram — responsibilities, stubs |
|    8 | Oct 15 | Customer view design + Singleton                 |
|   10 | Oct 29 | Generics and inheritance hierarchy               |
|   11 | Nov 5  | Observer and Decorator                           |
|   12 | Nov 12 | Factory and Strategy                             |
|   13 | Nov 19 | MVC audit, manager view, and Facade              |
|   14 | Dec 3  | LSP audit, persistence design, retrospective     |

---

## Source Code — src/

All Java source lives under `src/main/java/edu/metrostate/oodi/coffeeshop/`. FXML view files go in `src/main/resources/edu/metrostate/oodi/coffeeshop/`.

**Do not reorganize the package structure without a group decision.** Renaming packages mid-project breaks imports across the whole codebase. If the structure needs to change, discuss it, make the decision in class, and do it in one coordinated commit.

Java version: **25**. JavaFX is managed via Gradle.

---

## Building and Running

```bash
# Build
./gradlew build

# Run the application
./gradlew run

# Build a JAR
./gradlew jar

# Clean build outputs
./gradlew clean
```

Java 25 must be on your PATH. Run `java -version` to confirm before your first build. If you're on Windows, use `gradlew.bat` instead of `./gradlew`.

---

## Commit Expectations

**Round 1 artifact committed before the break. Round 2 artifact committed before class ends.**

`group-artifact-1.md` should be committed before the break — it's the synthesis from the first group discussion. Committing it at the break keeps it honest and gives the debrief something to work from.

`group-artifact-2.md` is due before you leave. If the group is still in discussion when time is called, commit what you have. A partial artifact with honest open questions is better than nothing — and better than committing late.

Every group member should appear in the commit history regularly. If one person is doing all the typing on a given night, the rest should push small corrections, add comments, or at minimum co-author commits. Commit history is reviewed as part of the final project grade — a history with one name on everything raises questions about individual contribution.

Commit messages should be meaningful: `week-08: add customer view class diagram and Singleton decision` is good. `update` is not.

---

## Final Project Submission

Due **December 10, 2026 at 11:59pm**.

The submission is the state of the `main` branch at that time. It must include:

- A working application — `./gradlew run` launches without errors, all three views (customer, barista, manager) are functional
- JSON persistence — state saved on exit, restored on startup
- The complete `docs/` design artifact trail, weeks 2–14
- All design patterns correctly implemented: Observer, Decorator, Factory, Strategy, Singleton, Facade

The design trail is not a separate report. It's what you built week by week in class, and it has already earned weekly grades along the way (see **Weekly Grading** above). The final project review of `docs/` isn't re-grading each week — it's assessing whether the trail holds together as a coherent whole and reflects the application you actually built.

---

## Before You Commit

Every artifact should be ready to read — not a filled-in template with the scaffolding left in.

- **Delete all placeholder text.** Template files contain prompts and comment markers. Remove them. The artifact should read as a document, not as a form with answers inserted.
- **Fill in the heading correctly.** Each artifact file should open with the group number, all member names, the week, and the round. A file with `[Group Name] | Week XX` still in the heading is incomplete.
- **All group members' names must appear on every artifact.** If I open a file and cannot tell which group produced it, I cannot grade it.
- **Commit message must identify the week and round.** `week-04: add use case diagram and sequence diagram decisions` is good. `update` or `added file` is not.
- **Preview your rendering.** A wrong Mermaid fence tag or a broken table can look fine locally and still render wrong on GitHub. Check the actual GitHub page before the deadline — a diagram that fails to render is graded the same as a missing diagram.

---

## Resources

`docs/resources/mermaid-cheatsheet.md` has the Mermaid syntax you'll use most in diagrams. `docs/resources/markdown-cheatsheet.md` covers markdown formatting and the file-format rule.

`docs/week-01/` contains an example group artifact written for a different domain. Use it as a reference for the format and depth expected — not as a model for your content.
