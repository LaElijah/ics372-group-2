# Group Artifact - Week 8 Round 1
**Group:** 2
**Members present:** Elijah Allotey, Thomas Yang, Abenezer Aregay, Houreratou Bande
**Date:** 10/15/2026

---

## 1. Tonight's Prompt

## Checklist

Read this aloud in your room and check every box before you commit. **14 of tonight's 20 group points.** The other 6 are in the group redesign.

- [X] Step 1 has one row for every class-calls-class pair in all four use cases, each with exactly one of the five values under **How it gets it** **(3 pts)**
- [X] Every row of step 1 says where that object comes from **(2 pts)**
- [X] Step 2: every class in `model/` has the fields and constructor your table says, and `ShopSetup.java` creates every object the four use cases need **(4 pts)**
- [X] Step 3 has the last line of `./gradlew compileJava` **(1 pt)**
- [X] Sections 2 to 4 of the template say how you got here, where you disagreed, and what you're not sure about **(4 pts)**
- [X] Committed: `docs/week-08/group-artifact.md` and everything in `src/` **(required: nothing is graded without it)**

---

Each of your sketches decided, alone, how the classes in one use case get hold of what they call. Now you put those decisions together for the whole program and write them as code. Copy the steps below into **section 1 of your group artifact** and put each deliverable under the step that asked for it.

**Step 1: The wiring table.** One table for all four use cases. Start from your sketches. One row for every pair of a class and a class it calls, **once**, even if the pair shows up in several use cases. Where two sketches chose different values for the same pair, pick one, and put the disagreement in section 3.

Exactly these five columns. The example row is from the library and shows only the shape.

| Class | Calls | How it gets it | Where that object comes from | Use cases |
|---|---|---|---|---|
|Employee|Order|handed in on the call|The order object is passed as the order parameter to completeOrder(order)|UC-2| 
|Employee|Queue|reaches for it|Proposed static reference Queue.current|UC-2| 
|Employee|Sales|handed in when built|A sales object is passed to the Employee constructor and stored in a field|UC-3| 
|Employee|Order|handed in on the call|The Order object is passed as a parameter to the method that uses it like completeOrder(order)|UC-1,UC-2| 
|Ingredients|MenuItem|handed in when built|MenuItem objects are passed to the Ingredients constructor and stored in menuItems |UC-4| 
|OrderItem|MenuItem|nanded in when built|A MenuItem object is passed to the OrderItem constructor and stored in a field|UC-1| 
|Sales|Order|handed in when built|A list of Order objects is passed to the Sales constructor and stored in a field|UC-3|

- **How it gets it** is exactly one of the five values from the sketch handout: `handed in on the call`, `handed in when built`, `handed back by a call`, `makes its own`, `reaches for it`.
- **Where that object comes from** says who hands it in, which call hands it back, or who creates it. For `reaches for it`, name the `static` field or method.
- **Use cases** lists every use case the pair appears in.

**Step 2: The code.** In `src/main/java/edu/metrostate/oodi/brewandbyte/model/`, make your stubs match the table:

- **`handed in when built`:** a `private final` field of that type, and a constructor parameter that sets it.
- **`handed in on the call`:** the method that uses the object has it as a parameter. If the stub's signature doesn't, change the signature, and say so in section 2.
- **`handed back by a call`:** nothing to add, as long as the method that returns it has that return type.
- **`makes its own`:** the `new` goes in the constructor, and the result goes in a `private final` field.
- **`reaches for it`:** write the `static` field or `static` method it reaches through, on the class being reached.
- **Constructors only set fields.** Every other method body stays `throw new UnsupportedOperationException("Not implemented yet");`.

Then add **`ShopSetup.java`** to the same package. It has one method, `public static void main(String[] args)`. That method creates every object the four use cases need, connects them the way your table says, and ends with this line:

```java
System.out.println("Brew & Byte is set up.");
```

Leave the JavaFX files alone tonight.

**Step 3: It compiles.** Run `./gradlew compileJava`. Under step 3, paste the last line of its output in a code block. If it fails and you're out of time, paste the first error and one sentence on what it means.

BUILD SUCCESSFUL in 5s


Commit and push the artifact and the code together.

## Checklist

Check every box before you commit. **6 of tonight's 20 group points.**

- [X] Item 1 has the count from the regroup and names every class in it **(2 pts)**
- [X] Item 2: the test setup is written, follows the rule, and `./gradlew compileTestJava` succeeds **(3 pts)**
- [X] Item 3 has the new count and one sentence on why **(1 pt)**
- [X] Everything new is under `### After the regroup`, committed with your code **(required: nothing is graded without it)**

---

Don't start a new file or delete your first version's work. Put everything new under this heading at the very end of section 1:

### After the regroup

**The five rules from the regroup:**

1. **An object gets what it needs in one of five ways.** Handed in on the call, handed in when built, handed back by a call, makes its own, or reaches for it. The first three show up in a signature. Reaching for it doesn't.
2. **A constructor is a list of what a class needs.** If the class reaches for something, the list is wrong, and the next programmer believes it.
3. **"There's exactly one" is a claim about the business.** The shop has one menu. A test needs its own anyway. One menu in the shop is not the same as one `Menu` object in the program.
4. **Decide which one in one place.** `ShopSetup` decides for the shop. Each test's setup decides for that test. Nothing else should have to.
5. **Even when there really is exactly one, hand it in.** Then "exactly one" is decided once, in `ShopSetup`, and a test can hand in its own.

**1. The count, before.** Copy the line your group typed in chat during the regroup: the number and the class names.

1 class to class relationship being Ingredients calls MenuItem.

**2. Make the setup work.** Change the code so the setup can follow the rule, then write it.

The menu class was added to hold the coffee shop's menu items. ShopSetup creates the menu and passes it to Ingredients through its constructor. PlaceOrderTest creates its own menu with one latte and passes it to its own Ingredients object. It also creates an order containing one oat milk latte. It was compiled with ./gradlew compileTestJava.

- Every class in UC-1 gets what it calls **handed in**, when built or on the call. Nothing in UC-1 reaches for anything, and nothing in UC-1 makes its own copy of something another class also uses.
- Update `ShopSetup` so it still builds the shop.
- Write the setup in `src/test/java/edu/metrostate/oodi/brewandbyte/model/PlaceOrderTest.java`, inside this shape. Replace the comment with your setup, and leave the rest exactly as it is:

```java
package edu.metrostate.oodi.brewandbyte.model;

import org.junit.jupiter.api.Test;

class PlaceOrderTest {

    @Test
    void refusesAnItemThatCannotBeSold() {
        // Setup: a menu with one latte, oat milk out, an order for one oat milk latte.
    }
}
```

- `./gradlew compileTestJava` succeeds. Don't run the test; the method bodies are still stubs.

Do UC-1 first, and commit. Then, if there's time, do the same for anything else your code reaches for.

**3. The count, after.** A second test needs a menu with two items on it and nothing out. Starting from the code you just committed, how many classes, other than `ShopSetup`, would have to change before its setup could be written? Give the number, the class names (or `none`), and one sentence on why.

0 classes because no classes other than ShopSetup need to change because the test can create its own two MenuItem objects, put them in a Menu, and pass that menu to Ingredients using our existing constructors.

---

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


