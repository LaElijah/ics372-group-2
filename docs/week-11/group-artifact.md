## Group Artifact - Week 11
**Group:** 2
**Members present:** Elijah Allotey, Thomas Yang, Abenezer Aregay, Houreratou Bande
**Date:** 11/5/2026

## Checklist

Read this aloud in your room and check every box before you commit. **14 of tonight's 20 group points.** The other 6 are in the group redesign.

- [ ] Step 1 has one row for every pair of a calling method and a class it calls in your UC-2 code, each with `yes` or `no` under **Part of the job?** **(4 pts)**
- [ ] Step 2: alternative flow 5a and step 7 have real bodies, each reaching the person through a class of its own in `view`; every call your table marks `no` tells a listener through an interface in `model`; nothing in `model` imports anything from `view` **(5 pts)**
- [ ] Step 3 has the last line of `./gradlew test` **(1 pt)**
- [ ] Sections 2 to 4 of the template say how you got here, where you disagreed, and what you're not sure about **(4 pts)**
- [ ] Committed: `docs/week-11/group-artifact.md` and everything in `src/` **(required: nothing is graded without it)**

---

## 1. Tonight's Prompt

The case paid for its design. Now do UC-2's alternative flow 5a (the low-stock warning) and step 7 (calling the number) in **your own code**, the better way. Open `week-11-use-cases.md` and your group's UC-2 sequence diagram in `docs/design/use-cases.md`.

Copy the steps below into **section 1 of your group artifact** and put each deliverable under the step that asked for it.

**Step 1: The calls table.** One row for every pair of a calling method and a class it calls in UC-2: from the method that completes an order, and from anything it calls on the way to the warning or the number. Include the screens you're about to add. Each pair goes in **once**.

Exactly these four columns. The example row is from the library and shows only the shape.

Called from | Class it calls | What for | Part of the job? |
|---|---|---|---|
| Queue.displayNextOrder | --- |showing barista the order details as text| yes |
| Queue.completeOrder | Order | consume ingredients and marks order as complete | yes |
| Order.markComplete | --- |  | yes |
| Order.consumeIngredients | Ingredients |showing barista the order details as text| yes |
| Queue.remove(0) | --- | removes order from queue | yes | 
| Order.getConfirmationNumber | --- | prints confirmation number | no |

- **Called from** is `ClassName.methodName`.
- **Part of the job?** is `yes` if the order isn't really complete until this happens, and `no` if the order would be complete without it and this only happens because the order was completed.

**Step 2: The code.** In `src/main/java/edu/metrostate/oodi/brewandbyte/`:

- UC-2's alternative flow 5a gets a real body, and its `UnsupportedOperationException` goes. If your ingredients have no low-stock level yet, add one, and set it for each ingredient where `ShopSetup` builds them.
- Step 7 gets a real body. Nothing in `model` prints the number.
- The warning and the number each reach the person through **a class of its own** in a new package, `view`, at `src/main/java/edu/metrostate/oodi/brewandbyte/view/`. Each one's method prints to the console, and stands in for a screen.
- **Every row your table marks `no` tells a listener.** An interface in `model` with a method for what happened; a `private` list of them, and a method to add one, on the class that tells them; the screen class implements the interface. Every row marked `yes` stays a direct call.
- `ShopSetup` builds the screens and adds each one to the class that tells it.
- When you're done, this prints nothing: `grep -rn "brewandbyte.view" src/main/java/edu/metrostate/oodi/brewandbyte/model`
- If a change stops a test compiling, fix the test.
- Leave pricing alone, and leave the JavaFX files alone.

**If your group's UC-2 doesn't run yet**, do step 2 against the case's classes instead, written as Java under step 2 in this file, and skip step 3.

**Step 3: It runs.** Run `./gradlew test`. Under step 3, paste the last line of its output in a code block. If it fails and you're out of time, paste the first error and one sentence on what it means.

Commit and push the artifact and the code together.

    
---

## Checklist

Check every box before you commit. **6 of tonight's 20 group points.**

- [ ] Item 1 names each thing the regroup showed that your code did, and what you changed, or says `none` **(1 pt)**
- [ ] Item 2: the barista's screen prints the queue when an order is placed and when one is completed, as a listener added in `ShopSetup`, and `./gradlew test` succeeds **(3 pts)**
- [ ] Item 3 lists every existing file you changed to add it, with one sentence on why, beside the case's count from your sketches **(2 pts)**
- [ ] Everything new is under `### After the regroup`, committed with your code **(required: nothing is graded without it)**

---

Don't start a new file or delete your first version's work. Put everything new under this heading at the very end of section 1:

### After the regroup

**The rules from tonight:**

1. **Do the job, then tell.** The class where something happens does its own job, then tells whoever asked to be told. It doesn't know who they are, so the model never imports the view.
2. **A new listener is free. A new event costs one edit, once,** in the class where it happens. (Open/Closed.)
3. **The model owns the interface; the view implements it.** The dependency points from the screen to the model. (Dependency Inversion.)
4. **An interface is for whoever implements it.** A listener that has to leave a method empty is implementing an interface that wasn't written for it. (Interface Segregation.)
5. **The subject is the class that knows it happened.** Each class tells its own listeners about what it knows.
6. **Not everything is a listener.** If the job isn't done without it, call it. Listeners are told in no promised order, and one that throws stops the rest, so telling goes last.
7. **The listener list belongs to the subject.** A method to add one, never a getter, and `ShopSetup` is the one place that adds them.

**1. What the regroup showed.** For each of rules 3 to 7 that your code broke, say where in one line, and fix it. If none, write `none`.

**2. The barista's screen.** Add it: a class in `view` that prints every order in the queue, oldest first, each time an order is placed and each time one is completed. It's a listener, added in `ShopSetup`, and it gets the queue's orders the way your group decided in Week 10. `./gradlew test` succeeds.

**3. What it cost.** List every file you already had that you changed to add the barista's screen, with one sentence on why each one had to change. If there were none, write `none`. Beside it, copy the case's total from your sketches: `The case: N files`.

    

## 2. How We Got Here

*What did the problem require? What did you look at first? Walk through the reasoning that led to what you produced, not just what you decided but why. This section carries more weight than any other, because the deciding is the part being graded.*

[Your response here]

---

## 3. Where We Disagreed

*Did any group members have a different approach? Name the disagreement, give both positions, and say how you resolved it or that you are deliberately leaving it open. If everyone agreed immediately, say so, but think carefully first: name the decision that could most plausibly have gone the other way and say why it did not.*

[Your response here]

---

## 4. What We're Not Sure About

*What might be wrong about this? What could break later? What are you choosing to leave unresolved for now, and why is it safe to defer?*

[Your response here]

