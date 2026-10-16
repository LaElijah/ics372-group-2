# Group Artifact - Week 8 Round 1
**Group:** 2
**Members present:** Elijah Allotey, Thomas Yang, Abenezer Aregay, Houreratou Bande
**Date:** 10/15/2026

---

## 1. Tonight's Prompt

## Checklist

Read this aloud in your room and check every box before you commit. **14 of tonight's 20 group points.** The other 6 are in the group redesign.

- [ ] Step 1 has one row for every class-calls-class pair in all four use cases, each with exactly one of the five values under **How it gets it** **(3 pts)**
- [ ] Every row of step 1 says where that object comes from **(2 pts)**
- [ ] Step 2: every class in `model/` has the fields and constructor your table says, and `ShopSetup.java` creates every object the four use cases need **(4 pts)**
- [ ] Step 3 has the last line of `./gradlew compileJava` **(1 pt)**
- [ ] Sections 2 to 4 of the template say how you got here, where you disagreed, and what you're not sure about **(4 pts)**
- [ ] Committed: `docs/week-08/group-artifact.md` and everything in `src/` **(required: nothing is graded without it)**

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

Commit and push the artifact and the code together.


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


