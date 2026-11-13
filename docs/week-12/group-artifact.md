# Group Artifact - Week 12
**Group:** 2
**Members present:** Elijah Allotey, Thomas Yang, Abenezer Aregay, Houreratou Bande
**Date:** 11/12/2026

---

## 1. Tonight's Prompt

## Checklist

Read this aloud in your room and check every box before you commit. **14 of tonight's 20 group points.** The other 6 are in the second handout, after the break.

- [ ] Step 1 has one row for every method or field the search finds that knows anything about loyalty members or discounts, or says `none` **(3 pts)**
- [ ] Step 2: an interface in `model` for the pricing rule, one class that implements it for loyalty members and one for everyone else; `Order` is handed its rule and totals itself without asking whether anyone is a member; no class but the loyalty rule's knows what the discount is **(5 pts)**
- [ ] Step 3: `LoyaltyPricingTest` has both test methods, and step 3 has the last line of `./gradlew test` **(2 pts)**
- [ ] Sections 2 to 4 of the template say how you got here, where you disagreed, and what you're not sure about **(4 pts)**
- [ ] Committed: `docs/week-12/group-artifact.md` and everything in `src/` **(required: nothing is graded without it)**

---

The case paid for keeping its rule in three places. Now do requirement 2.8 in **your own code**, the better way.

- **2.8** Loyalty members get their discount automatically. They shouldn't have to ask.

Copy the steps below into **section 1 of your group artifact** and put each deliverable under the step that asked for it.

**Running commands.** Commands in this handout run in IntelliJ's terminal (**View > Tool Windows > Terminal**), which starts in your project folder. They're written the Mac way. On Windows in PowerShell, IntelliJ's default, type `.\gradlew` where this says `./gradlew`; in Command Prompt, type `gradlew`. Windows has no `grep`: use IntelliJ's **Find in Files** instead, as step 1 says.

**Before step 1: does it compile?** Run `./gradlew compileJava` from your project folder. If it fails, fixing it is your group's first job tonight, before anything else in this handout. Read the **first** error, not the last. If `module-info.java` has a `requires` line for JUnit or any other testing library, a test class is probably sitting under `src/main`. Move every test class to the same package under `src/test/java`, then delete that `requires` line: only the tests use those libraries. Nothing goes under this heading in your artifact; the second handout, after the break, checks the whole build.

**Step 1: Where the rule lives now.** Search your code. On a Mac or Linux, run this from your project folder:

```
grep -rn --include=*.java -i -E "loyal|discount|member" src/main
```

On Windows, or if you'd rather, use IntelliJ: **Edit > Find > Find in Files**. Type `loyal|discount|member`, turn on the regular expression option (the `.*` button), leave **Match case** off, choose **Directory**, and pick your `src/main` folder.

One row for every method the search finds, in a table with exactly these three columns. The example row is from the library and shows only the shape.

| Class and method | What it knows | Changes if the rule changes? |
|---|---|---|
| Customer.Customer | The created customers loyalty code | no |
| Customer.checkLoyalty | If the customer is a member | no |
| Customer (loyaltyStatus) | Stores the customer's loyalty status | no |
| ShopSetup.main() | Creates a customer with "Member" status | Yes |

- **Class and method** is `ClassName.methodName`. A field with no method around it gets a row too: write `ClassName (field)`.
- **Changes if the rule changes?** is `yes` or `no`.
- If the search finds nothing, write `none` under step 1 and move on.

**Step 2: The code.** In `src/main/java/edu/metrostate/oodi/brewandbyte/model/`:

- **The rule.** Use what your group recorded for 2.8 in `docs/design/open-questions.md`. If you recorded nothing, use 10 percent off the order's total, and leave 2.8 open.
- **One interface for the pricing rule.** Name it for what it does. It has one method, and that method answers how much comes off an order.
- **Two classes implement it:** one for loyalty members, and one for everyone else that takes nothing off.
- **`Order` is handed its rule** in its constructor, keeps it in a `private final` field, and uses it when it totals. Nothing in `Order` asks whether the customer is a member.
- **Which class chooses the rule is your call.** Put one sentence in section 2 of the template saying which class chooses it and why that one.
- If your code doesn't know whether a customer is a member yet, give the class that chooses the rule a way to know. A `boolean` is enough tonight.
- Delete any flag, setter or `if` that switched the discount on or off in `Order` or anywhere else. Every row your step 1 table marked `yes` should now be in the loyalty rule's class, or gone.
- If a change stops a test compiling, fix the test.
- Leave the JavaFX files alone until after the break.

**Step 3: The test.** In `src/test/java/edu/metrostate/oodi/brewandbyte/model/LoyaltyPricingTest.java`:

- `memberGetsTheDiscount()`: the setup builds its own menu item and an order with the loyalty rule handed in. The test checks the order's total against the number you work out by hand.
- `everyoneElsePaysFullPrice()`: the same order with the other rule. The test checks that the total is the full price.
- Neither test uses anything `ShopSetup` builds.

Run `./gradlew test`. Under step 3, paste the last line of its output in a code block. If it fails and you're out of time, paste the first error and one sentence on what it means.

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


