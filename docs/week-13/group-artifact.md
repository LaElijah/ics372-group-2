# Group Artifact - Week 13
**Group:** 2
**Members present:** [Full names, as they appear on the roster]
**Date:** [Date]

## Checklist

Read this aloud in your room and check every box before you commit. **14 of tonight's 20 group points.** The other 6 are in the second handout, after the break.

- [x ] Step 1 has a row for every class outside `model` that uses a model class **(3 pts)**
- [ ] Step 2: one class in `model` that the screens talk to, with a method for each of the three jobs; each method passes the job on; a price of zero or less and a name already on the menu are both refused with an `IllegalArgumentException` and a message; section 2 says which class keeps each rule and why **(5 pts)**
- [ ] Step 3: `ManagerJobsTest` has both test methods, and step 3 has the last line of `./gradlew test` **(2 pts)**
- [ ] Sections 2 to 4 of the template say how you got here, where you disagreed, and what you're not sure about **(4 pts)**
- [ ] Committed: `docs/week-13/group-artifact.md` and everything in `src/` **(required: nothing is graded without it)**

---

## 1. Tonight's Prompt


The case paid for keeping its rules in a controller. Now do it the better way in **your own code**, for the manager's jobs:

- **4.2** A manager can add a menu item, change the price of one, or take one off the menu.
- **2.1** A customer can look at the menu and see what's available and what it costs.

Copy the steps below into **section 1 of your group artifact** and put each deliverable under the step that asked for it.

**Running commands.** Commands in this handout run in IntelliJ's terminal (**View > Tool Windows > Terminal**), which starts in your project folder. They're written the Mac way. On Windows in PowerShell, IntelliJ's default, type `.\gradlew` where this says `./gradlew`. Windows has no `grep`: use IntelliJ's **Find in Files** instead, as step 1 says.

**Before step 1: does it compile, and is everything in its place?** Run `./gradlew test`. If it fails, fixing it is your group's first job tonight. Read the **first** error, not the last. If any class under `src/main` is in a package other than `model`, `view`, or the package that holds `Launcher`, move it there first (in IntelliJ, drag the file onto the package and let it fix the imports). Nothing goes under this heading in your artifact.

**Step 1: The audit.** Find every class outside `model` that uses a model class. On a Mac or Linux, run this from your project folder:

```
grep -rn --include=*.java "import .*brewandbyte\.model" src/main | grep -v "/model/"
```

On Windows, or if you'd rather, use IntelliJ: **Edit > Find > Find in Files**. Type `import .*brewandbyte\.model`, turn on the regular expression option (the `.*` button), choose **Directory**, and pick your `src/main` folder. Ignore every result from a file in the `model` folder.

One row for every class the search finds, in a table with exactly these three columns. The example row is from the library and shows only the shape.

| Class | Model classes it uses | Rules about the business in it |
|---|---|---|
| ManagerWarnings | Ingredient, LowStockListener | onLowStock: warn manager when a stock has reported low |
| BaristaScreen | Order, Queue, 'QueueListener' | onOrderPlaced & onOrderCompleted: refresh queue display on order updates, displayQueue: relist the queue on the screen |
| PickupBoard | Order, 'OrderCompletedListener' | onOrderCompleted: print the order completed and its confirmation number |

- **Class** is the class name, like `BrewAndByteController`.
- **Model classes it uses** is every model class it imports, separated by commas. An import ending in `.model.*` brings in the whole package: for that class, list every model class its code names.
- **Rules about the business in it** is each `if` or calculation in that class that decides something about the shop (a price, the menu, stock, an order, a discount), written as `methodName: the rule`, separated by semicolons. Reading what someone typed and deciding what to show aren't rules about the business. If there are none, write `none`.

Don't fix anything in step 1. Step 2, the second handout and the reconciliation will.

**Step 2: The facade.** In `src/main/java/edu/metrostate/oodi/brewandbyte/model/`:

- **One class that the screens talk to.** Name it yourself. It holds, as `private final` fields, the model objects it needs, handed to it in its constructor.
- **One public method for each of these three jobs,** named for the job:
  - add a menu item (4.2), taking the item's name and its price, plus anything else your menu item can't be built without
  - change an item's price (4.2), taking the item's name and the new price
  - hand out the menu's items, so a screen can show them (2.1)
- **Each method passes the job on** to the class that does it. If your model can't do one of these jobs yet, add a method for it to the class that holds the data first.
- **Two rules, both refused with an `IllegalArgumentException`** and a message a manager could read, like `"The price must be more than zero."`:
  - a price of zero or less, when an item is added and when a price is changed
  - a name that's already on the menu, when an item is added
- **Which class keeps each rule is your call.** In section 2 of the template, one sentence for each rule: which class keeps it, and why that one.
- If your menu item needs more than a name and a price to be built (a category, a size, ingredients), the add method takes them as parameters too. Keep it to what your constructor needs.
- If a change stops a test compiling, fix the test.
- Leave the JavaFX files alone until after the break.

**Step 3: The test.** In `src/test/java/edu/metrostate/oodi/brewandbyte/model/ManagerJobsTest.java`, two test methods. Each one's setup builds its own menu, anything else your facade takes, and the facade. Here's the shape of a test that checks a refusal, from the library:

```java
@Test
void refusesAHoldOnABookTheLibraryDoesNotHave() {
    Library library = new Library(new Catalog(), new MemberList());
    assertThrows(IllegalArgumentException.class, () -> library.placeHold("M1", "B99"));
}
```

`assertThrows` is imported from `org.junit.jupiter.api.Assertions`, like `assertEquals`.

- `addsAnItemToTheMenu()`: adds an item through the facade, then checks that the facade's items include one with that name and price.
- `refusesAPriceOfZero()`: checks that adding an item with a price of zero throws `IllegalArgumentException`, then checks that the facade hands out no items.
- No test builds a controller or a screen, checks anything printed, or uses anything `ShopSetup` builds.

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


