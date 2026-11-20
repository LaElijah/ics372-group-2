# Group Artifact - Week 13
**Group:** 2
**Members present:** Elijah Allotey, Thomas Yang, Abenezer Aregay, Houreratou Bande
**Date:** 11/20/2026

## Checklist

Read this aloud in your room and check every box before you commit. **14 of tonight's 20 group points.** The other 6 are in the second handout, after the break.

- [x ] Step 1 has a row for every class outside `model` that uses a model class **(3 pts)**
- [ x] Step 2: one class in `model` that the screens talk to, with a method for each of the three jobs; each method passes the job on; a price of zero or less and a name already on the menu are both refused with an `IllegalArgumentException` and a message; section 2 says which class keeps each rule and why **(5 pts)**
- [x ] Step 3: `ManagerJobsTest` has both test methods, and step 3 has the last line of `./gradlew test` **(2 pts)**
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


---

- add a menu item (4.2): Kept by Menu due to it holding all menu items

- change an item's price (4.2): Kept by Menu due to it holding all menu items

- hand out the menu's items, so a screen can show them (2.1) : Kept by Menu due to it holding all menu items

---

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

```
 BUILD SUCCESSFUL in 6s
```
Commit and push the artifact and the code together.

    

---

## Checklist

Work down this list in order and check every box before you commit. **6 of tonight's 20 group points.**

**Item 1: What the regroup showed (1 pt)**
- [ ] Item 1 names each of rules 3, 5, 6 and 7 that your code broke, where, and what you changed, or says `none`

**Item 2: The manager's window (4 pts)**
- [x ] (a) `BrewAndByteController` is in the `controller` package, `module-info.java` has the second `opens` line, and the menu window opens as before
- [ x] (b) `ShopSetup` has a method that builds your facade
- [x ] (c) `manager.fxml` is next to `brew-and-byte.fxml`
- [x ] (d) `ManagerController` is in `controller`, and from `model` it imports only your facade and the class it reads
- [ x] (e) `BrewAndByteController` gets the menu from your facade
- [ x] (f) `start` builds one facade and hands it to both controllers
- [ ] `./gradlew run` opens both windows. In the manager's window, adding an item puts it in the list, adding it again shows a message, and a price of zero shows a message
- [ ] `./gradlew test` ends with `BUILD SUCCESSFUL`, and its last line is pasted under item 2
- [ ] The screenshot is committed at `docs/week-13/manager-window.png` and shows in the artifact
- [ ] Item 2 names everyone in the group who has opened both windows on their own computer

**Item 3: What the controllers know (1 pt)**
- [ ] Item 3 has a line for each class in `controller` with every model class it imports, and your step 1 answer from the sketch under them

**Committed (required: nothing is graded without it)**
- [ ] Everything new is under `### After the regroup`, committed and pushed with your code and the screenshot

---

**One person drives.** The driver shares their screen and types; everyone else reads along, catches mistakes and looks things up. Switch drivers between items if you like. Commands are written the Mac way; Week 12's Ready to Build On handout has the Windows forms and IntelliJ's Gradle window.

Don't start a new file or delete your first version's work. Put everything new under this heading at the very end of section 1:

### After the regroup

**The rules from tonight:**

1. **The model holds the shop's data and every rule about it,** and knows no screen.
2. **A controller turns what someone did into a call on the model,** then tells the view what to show. It holds no rule about the business.
3. **A rule lives in the class that holds the data it's about,** and refuses by throwing with a reason the controller can show.
4. **The screens talk to one class in the model, the facade:** one method for each job a person does, each passing the job on.
5. **A facade holds no rules of its own.**
6. **Reading what the facade hands back is fine. Changing goes through the facade.**
7. **There is one facade,** built once and handed to every controller.

**Item 1: What the regroup showed.** For each of rules 3, 5, 6 and 7 that your code broke, one bullet: where, and what you changed. If none, write `none`. Keep this short.

`none`

**Item 2: The manager's window.** Do these in order. Use your own names wherever this says `Shop` (your facade) or `MenuItem`.

**(a) A `controller` package.** In IntelliJ's Project window, right-click the package that holds `Launcher` and choose **New > Package**. Name it `controller`. Drag `BrewAndByteController` onto it and let IntelliJ fix the `package` line and the imports. Then:

- Open `src/main/resources/edu/metrostate/oodi/brewandbyte/brew-and-byte.fxml` and check that `fx:controller` is exactly `edu.metrostate.oodi.brewandbyte.controller.BrewAndByteController`. Fix it if IntelliJ didn't.
- In `src/main/java/module-info.java`, add this line under the `opens` line that's already there:

```java
    opens edu.metrostate.oodi.brewandbyte.controller to javafx.fxml;
```

Run `./gradlew run`. The menu window opens as it did last week. **Don't go on until it does;** the table at the end of this handout covers the usual problems. The FXML files stay where they are. Only the controller classes move.

**(b) A method that builds the facade.** In `ShopSetup`, add a `public static` method that builds the menu with your `buildMenu` method from last week, builds anything else your facade takes the way `ShopSetup` builds it now, and returns a new facade holding them.

**(c) The manager's FXML.** Create `src/main/resources/edu/metrostate/oodi/brewandbyte/manager.fxml`, next to `brew-and-byte.fxml`, with exactly this in it:

```xml
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.geometry.Insets?>
<?import javafx.scene.control.Button?>
<?import javafx.scene.control.Label?>
<?import javafx.scene.control.ListView?>
<?import javafx.scene.control.TextField?>
<?import javafx.scene.layout.HBox?>
<?import javafx.scene.layout.VBox?>

<VBox spacing="10.0" xmlns:fx="http://javafx.com/fxml"
      fx:controller="edu.metrostate.oodi.brewandbyte.controller.ManagerController">
  <padding>
    <Insets bottom="20.0" left="20.0" right="20.0" top="20.0"/>
  </padding>

  <Label text="Menu"/>
  <ListView fx:id="menuList" prefHeight="300.0"/>

  <Label text="Item name"/>
  <TextField fx:id="nameField"/>
  <Label text="Price, like 4.50"/>
  <TextField fx:id="priceField"/>

  <HBox spacing="10.0">
    <Button text="Add item" onAction="#onAddItem"/>
    <Button text="Change price" onAction="#onChangePrice"/>
  </HBox>

  <Label fx:id="messageLabel"/>
</VBox>
```

If your add method needs more than a name and a price, add a `Label` and a `TextField` for each extra value after the price field, in the same shape, with an `fx:id` of your choosing.

**(d) The manager's controller.** Create `ManagerController` in the `controller` package. Here is the shape, from the library, not from your code:

```java
public class CirculationController {
    @FXML
    private ListView<String> bookList;
    @FXML
    private TextField memberField;
    @FXML
    private TextField bookField;
    @FXML
    private Label messageLabel;

    private Library library;

    public void connect(Library library) {
        this.library = library;
        showBooks();
    }

    @FXML
    protected void onCheckOut() {
        try {
            library.checkOut(memberField.getText(), bookField.getText());
            messageLabel.setText("Checked out.");
            showBooks();
        } catch (IllegalArgumentException e) {
            messageLabel.setText(e.getMessage());
        }
    }

    private void showBooks() {
        bookList.getItems().clear();
        for (Book book : library.books()) {
            bookList.getItems().add(book.getTitle() + "    " + book.getCallNumber());
        }
    }
}
```

Yours has:

- Four fields with `@FXML` on the line above each, named exactly as the FXML's `fx:id`s: `menuList` (a `ListView<String>`), `nameField` and `priceField` (each a `TextField`), and `messageLabel` (a `Label`). Plus a field for each extra text field you added in (c).
- A field for your facade, and a `public void connect(...)` that takes your facade, keeps it, and shows the menu.
- Two methods with `@FXML` on them, named exactly `onAddItem` and `onChangePrice`. Each calls one method on your facade, puts a message in `messageLabel`, and shows the menu again. Each catches `IllegalArgumentException` and puts its message in `messageLabel`.
- One private method that shows the menu: clear `menuList`, then one line per item from your facade, its name and then its price, the way `BrewAndByteController` does it.
- Turn the price field's text into your price type in the controller: `Double.parseDouble(priceField.getText())` for a `double`, `new BigDecimal(priceField.getText())` for a `BigDecimal`, or `(int) Math.round(Double.parseDouble(priceField.getText()) * 100)` for whole cents. Text that isn't a number throws `NumberFormatException`, which is an `IllegalArgumentException`, so the same `catch` shows it.
- From `model`, it imports your facade and the class whose items it reads (like `MenuItem`), and nothing else. Your IDE will offer the JavaFX imports: `javafx.fxml.FXML`, `javafx.scene.control.Label`, `ListView` and `TextField`.

**(e) The counter's controller.** Change `BrewAndByteController.showMenu` to take your facade instead of the menu, and get the items from your facade. From `model`, it now imports your facade and the class it reads, and nothing else.

The application won't compile again until (f) is done. That's expected; finish (f) before you run it.

**(f) Both windows.** Replace the `start` method in `BrewAndByteApplication` with this, changing `Shop` and `buildShop` to your names. Import your facade and `ShopSetup` from `model`, both controllers from `controller`, and `javafx.stage.Stage`.

```java
    @Override
    public void start(Stage stage) throws IOException {
        Shop shop = ShopSetup.buildShop();

        FXMLLoader counterLoader = new FXMLLoader(BrewAndByteApplication.class.getResource("brew-and-byte.fxml"));
        Scene counterScene = new Scene(counterLoader.load(), 480, 640);
        BrewAndByteController counter = counterLoader.getController();
        counter.showMenu(shop);
        stage.setTitle("Brew & Byte");
        stage.setScene(counterScene);
        stage.show();

        FXMLLoader managerLoader = new FXMLLoader(BrewAndByteApplication.class.getResource("manager.fxml"));
        Scene managerScene = new Scene(managerLoader.load(), 480, 640);
        ManagerController manager = managerLoader.getController();
        manager.connect(shop);
        Stage managerStage = new Stage();
        managerStage.setTitle("Brew & Byte: Manager");
        managerStage.setScene(managerScene);
        managerStage.show();
    }
```

Run `./gradlew run`. Two windows open, one on top of the other: drag the manager's aside. In the manager's window, try all four of these:

1. Add an item with a new name and a price. It appears in the manager's list.
2. Add it again. The message says it's already on the menu.
3. Type an item's name and a price of `0`, and press **Change price**. The message says the price must be more than zero.
4. Change an item's price to a new one. The manager's list shows the new price.

The counter's window doesn't change when the manager adds an item. That isn't tonight's job; put it in section 4 if you like.

Run `./gradlew test`. Under item 2, paste its last line in a code block.

**The screenshot.** After step 4 above, save a screenshot of the manager's window as `docs/week-13/manager-window.png`, and put this line under item 2: `![Manager window](manager-window.png)`

**Last: everyone runs it.** Commit and push the artifact, the screenshot and the code together. Then everyone in the group runs `git pull` and starts the application on their own computer. The driver lists the names of everyone whose two windows opened under item 2, then commits and pushes once more. Anyone whose windows didn't open puts the first `Caused by` line of their error in section 4 of the template.

**Item 3: What the controllers know.** One line for each class in `controller`: its name, then every model class it imports, in this shape (from the library): `CirculationController: Library, Book`. Under them, copy your step 1 answer from your own sketch, in this shape: `The case: N new field(s), N copied`.

---

## If It Doesn't Run

Find the first line that starts with `Caused by`, then find it here.

| What you see | What it means | What to do |
|---|---|---|
| `does not export edu.metrostate.oodi.brewandbyte.controller to module javafx.fxml` | JavaFX can't build a controller in the new package | Step (a): add the second `opens` line to `module-info.java` |
| `ClassNotFoundException: edu.metrostate.oodi.brewandbyte.BrewAndByteController` | The FXML still names the controller's old package | Step (a): fix `fx:controller` in `brew-and-byte.fxml` |
| `ClassNotFoundException` naming `controller.ManagerController` | The class isn't in `controller`, or its name is spelled differently | It must be exactly `ManagerController`, in the `controller` package |
| `Location is not set` | `manager.fxml` wasn't found | The file must be exactly `src/main/resources/edu/metrostate/oodi/brewandbyte/manager.fxml` |
| `Error resolving onAction='#onAddItem'` or `'#onChangePrice'` | The FXML's button names a method the controller doesn't have | The method names must match exactly, with `@FXML` on the line above each |
| `NullPointerException` naming `menuList`, `nameField`, `priceField` or `messageLabel` | That field isn't connected to the FXML | The field's name must match its `fx:id` exactly, with `@FXML` on the line above it |
| `NullPointerException` naming your facade's field, when you press a button | `connect` was never called | Step (f): `start` calls `manager.connect(shop)` |
| `JavaFX runtime components are missing` | You started `BrewAndByteApplication` directly | Start `Launcher`, or use `./gradlew run` |
| `cannot find symbol` naming a controller, `ShopSetup`, your facade, `Stage` or `TextField` | A missing import | Click the red name and let IntelliJ add the import |
| Only one window opens | The manager's window opened exactly on top of the counter's | Drag the top window aside |
| The message says `For input string` | The price field isn't a number | Type a price like `4.50`. Your controller can catch `NumberFormatException` first and say something friendlier. |
| Nothing happens, no error (Mac) | The windows opened behind IntelliJ | Look for a Java icon in the Dock |

**Stuck for ten minutes on the same error?** Paste its first `Caused by` line in the main room's chat with your group number.


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


