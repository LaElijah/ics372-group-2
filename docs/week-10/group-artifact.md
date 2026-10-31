# Group Artifact - Week 10
**Group:** 2
**Members present:** Elijah Allotey, Thomas Yang, Abenezer Aregay, Houreratou Bande
**Date:** 10/29/2026


## Checklist

Read this aloud in your room and check every box before you commit. **14 of tonight's 20 group points.** The other 6 are in the group redesign.

- [x] Step 1 has one row for every pair of a class and a collection it walks, in UC-2 and UC-3, each with exactly one of the five values under **What it gets** **(3 pts)**
- [x] Every row of step 1 says `yes` or `no` under **Could it change it?** **(2 pts)**
- [x] Step 2: every method UC-2 and UC-3 call has a real body, and completed orders are kept somewhere UC-3 finds them **(4 pts)**
- [x] Step 3 has the last line of `./gradlew compileJava` **(1 pt)**
- [X] Sections 2 to 4 of the template say how you got here, where you disagreed, and what you're not sure about **(4 pts)**
- [X] Committed: `docs/week-10/group-artifact.md` and everything in `src/` **(required: nothing is graded without it)**

---

## 1. Tonight's Prompt

---

Each of your sketches wrote one method alone and listed what it walks. Now you write every method the two use cases need, as real code. Copy the steps below into **section 1 of your group artifact** and put each deliverable under the step that asked for it.

**Step 1: The walk table.** One table for both use cases. Start from your sketches. One row for every pair of a class and a collection it walks, **once**, even if the pair shows up in both use cases. Where two sketches chose different values for the same pair, pick one, and put the disagreement in section 3.

Exactly these five columns. The example row is from the library and shows only the shape.

| Walks it | Whose collection | What it gets | Could it change it? | Use cases |
|---|---|---|---|---|
| Ingredients | Order's items | a read only view | no | UC-2|
| Ingredients | Order's customizations| a read only view| no | UC-2|                                                         
| Menu Items  | Menu | a read only view | no | UC-3|
| Order Items  | Order | a read only view | no | UC-3| 

- **What it gets** is exactly one of the five values from the sketch handout: `the collection itself`, `a copy`, `a read-only view`, `an iterator`, `the answer`.
- **Could it change it?** is `yes` or `no`, as in the sketch handout.
- **Use cases** lists every use case the pair appears in.

**Step 2: The code.** In `src/main/java/edu/metrostate/oodi/brewandbyte/model/`:

- Every method the UC-2 and UC-3 sequence diagrams call gets a real body: both main flows, and UC-3's alternative flow 2a. If your group has no diagram for one of them, work from `week-10-use-cases.md`, and list in section 4 what that diagram will need.
- UC-2's alternative flow 5a keeps its `throw new UnsupportedOperationException("Not implemented yet");`.
- UC-2 step 7, calling the customer's confirmation number, is a `System.out.println` of the number.
- When UC-2 takes an order out of the queue (step 6), it has to end up somewhere UC-3 can find it (step 2). Decide where, and say why in section 2.
- The code does what the table says. If a row says `a copy`, the owner's method returns a copy.
- Leave the JavaFX files alone tonight.

**Step 3: It compiles.** Run `./gradlew compileJava`. Under step 3, paste the last line of its output in a code block. If it fails and you're out of time, paste the first error and one sentence on what it means.

BUILD SUCCESSFUL in 637ms
    
---
## Checklist

Check every box before you commit. **6 of tonight's 20 group points.**

- [X] Item 1 has the count from the regroup and names every class in it **(2 pts)**
- [x] Item 2: nothing in UC-2 or UC-3 gets another class's collection itself, the updated walk table is in, and `./gradlew compileJava` succeeds **(3 pts)**
- [x] Item 3 has the new count and one sentence on why **(1 pt)**
- [x] Everything new is under `### After the regroup`, committed with your code **(required: nothing is graded without it)**

---

Don't start a new file or delete your first version's work. Put everything new under this heading at the very end of section 1:

### After the regroup

**The five rules from the regroup:**

1. **`private` protects the field, not the list it points to.** A getter that returns the list hands out the list.
2. **The owner keeps the rule.** The queue keeps 3.2, the order keeps 3.4, and whatever holds completed orders keeps 1.3. A class can keep a rule about its collection only if it's the only class that can change it.
3. **Another class can see a collection five ways:** the collection itself, a copy, a read-only view, an iterator, or the answer. Only the collection itself is sure to let the caller change it, and an iterator taken straight off the real list can still remove.
4. **Iterator: hand out something that walks it, not the thing it walks.** `implements Iterable<Order>`, over a read-only view.
5. **Hand out the least that does the job.** Often that's the answer.

**1. The count, before.** Copy the line your group typed in chat during the regroup: the number and the class names.

The count typed in chat during the regroup was 0 classes.

**2. The owner is the only one who can change it.**

- Copy your step 1 walk table under this item. Every row that says `the collection itself` changes to one of the other four values, and the code changes to match. Leave the original table above as it was.
- An owner that was handed its list in its constructor makes its own list instead, or keeps a copy of the one it was handed.
- If a change breaks code that UC-1 or UC-4 uses, fix that caller the same way.
- `./gradlew compileJava` succeeds. If `PlaceOrderTest` passed before the regroup, `./gradlew test` still passes it.

| Walks it | Whose collection | What it gets | Could it change it? | Use cases |
|---|---|---|---|---|
| Sales | Menu's menuItems | a read only view | no | UC-3|
| Sales | Order's items| a read only view| no | UC-3|                                                         
| Queue  | Order's Items | a read only view | no | UC-2|
| Order  | MenuItem's ingredients | a read only view | no | UC-2| 

Do the barista queue and the completed orders first, and commit. Then the lines of an order.

**3. The count, after.** Tomorrow the barista queue keeps its orders in a different kind of collection: an `ArrayDeque` if it uses a `List` now, or an `ArrayList` if it doesn't. Starting from the code you just committed, how many classes other than the queue's owner would have to change? Give the number, the class names (or `none`), and one sentence on why.

0 classes none, all the other classes interact with the Queue through its methods and Iterable<Order> rather than its internal collection type, so changing from LinkedList to ArrayDeque would not require changes to other classes.
    
---
## 2. How We Got Here

The first thing we did was review how our classes accessed collections owned by other classes. We wanted to make sure that each class remained responsible for controlling changes to its own collection. We examined classes like Queue, Sales, Order, Menu, and MenuItem to determine how their collections were accessed.

We used private fields, copies, and read only views to protect the collections. Queue was also updated to implement Iterable<Order> and return an iterator over an unmodifiable view of its pending orders.

This approach helped keep collection ownership within the class responsible for managing it. It also made our design more flexible because the internal collection type can change without requiring other classes to change.

---

## 3. Where We Disagreed

We didn't have any disagreements this week. We all agreed that each class should control changes to its own collection and that other classes should only receive the access they needed.

---

## 4. What We're Not Sure About

One thing we aren't sure about is whether or not our collection access methods will continue to work for future use cases. Our Queue implements Iterable<Order> so other classes can access pending orders without modifying the collection but future requirements might need additional methods for accessing and searching orders.

We also have methods that aren't fully implemented so we will need to make sure these methods work when a use case involving them shows up.


