# Mermaid Diagram Cheat Sheet
## ICS372 — Object-Oriented Analysis, Design and Implementation

All diagrams go in a fenced code block in your markdown file:

````markdown
```mermaid
<diagram type>
  <diagram content>
```
````

---

## 1. Class Diagrams

### Basic syntax

```mermaid
classDiagram
  class Book {
    -String title
    -String isbn
    -boolean checkedOut
    +getTitle() String
    +isCheckedOut() boolean
    +checkout() void
  }
```

### Access modifiers

| Symbol | Meaning |
|---|---|
| `+` | public |
| `-` | private |
| `#` | protected |
| `~` | package |

### Field and method syntax

```
-fieldName : Type
+methodName(paramName : Type) ReturnType
+methodName() void
```

### Relationships

#### Association — "uses a"
A `Member` has a reference to zero or more `Book` objects.

```mermaid
classDiagram
  class Member {
    -String name
    -String memberId
  }
  class Book {
    -String title
    -String isbn
  }
  Member --> Book : borrows
```

#### Multiplicity on associations

```mermaid
classDiagram
  class Member {
    -String name
  }
  class Book {
    -String title
  }
  class Loan {
    -Date dueDate
  }
  Member "1" --> "0..*" Loan : has
  Loan "1" --> "1" Book : for
```

| Notation | Meaning |
|---|---|
| `1` | exactly one |
| `0..1` | zero or one |
| `0..*` or `*` | zero or more |
| `1..*` | one or more |
| `2..5` | between two and five |

#### Inheritance — "is a"
`PhysicalBook` and `EBook` are both types of `Book`.

```mermaid
classDiagram
  class Book {
    -String title
    -String isbn
    +getTitle() String
    +isAvailable() boolean
  }
  class PhysicalBook {
    -String shelfLocation
    +getShelfLocation() String
  }
  class EBook {
    -String downloadUrl
    +getDownloadUrl() String
  }
  Book <|-- PhysicalBook
  Book <|-- EBook
```

#### Interface implementation — "can act as"

```mermaid
classDiagram
  class Searchable {
    <<interface>>
    +search(query : String) List
    +getTitle() String
  }
  class Book {
    -String title
    -String isbn
    +search(query : String) List
    +getTitle() String
  }
  class Member {
    -String name
    -String memberId
    +search(query : String) List
    +getTitle() String
  }
  Searchable <|.. Book
  Searchable <|.. Member
```

#### Composition — "owns a" (part cannot exist without the whole)
A `Library` owns its `Catalog`. If the library is destroyed, the catalog is too.

```mermaid
classDiagram
  class Library {
    -String name
    +getCatalog() Catalog
  }
  class Catalog {
    -List~Book~ books
    +addBook(book : Book) void
    +findBook(isbn : String) Book
  }
  Library *-- Catalog
```

#### Aggregation — "has a" (part can exist independently)
A `Catalog` contains `Book` objects, but books exist independently.

```mermaid
classDiagram
  class Catalog {
    +addBook(book : Book) void
    +removeBook(isbn : String) void
  }
  class Book {
    -String title
    -String isbn
  }
  Catalog o-- Book
```

### Relationship symbols summary

| Symbol | Relationship | Read as |
|---|---|---|
| `<|--` | Inheritance | "extends" |
| `<|..` | Implementation | "implements" |
| `-->` | Association | "uses a" / "has a reference to" |
| `*--` | Composition | "owns a" |
| `o--` | Aggregation | "has a" |

### Abstract classes and interfaces

```mermaid
classDiagram
  class LoanableItem {
    <<abstract>>
    -String id
    -boolean available
    +getId() String
    +isAvailable() boolean
    +checkout()* void
    +returnItem()* void
  }
  class Printable {
    <<interface>>
    +print() void
  }
  LoanableItem <|-- Book
  LoanableItem <|-- Periodical
  Printable <|.. Book
```

---

## 2. Use Case Diagrams

```mermaid
flowchart LR
  subgraph Library System
    UC1([Search catalog])
    UC2([Borrow book])
    UC3([Return book])
    UC4([Place hold])
    UC5([Add book to catalog])
    UC6([Remove member])
    UC7([Generate overdue report])
  end

  Member((Member)) --> UC1
  Member --> UC2
  Member --> UC3
  Member --> UC4

  Librarian((Librarian)) --> UC1
  Librarian --> UC5
  Librarian --> UC6
  Librarian --> UC7
```

**Notes:**
- Actors are outside the system boundary box
- Use cases are inside
- Use `((ActorName))` for actors
- Use `([Use Case Name])` for use cases
- System boundary is the `subgraph` block

---

## 3. Sequence Diagrams

### Basic message passing

```mermaid
sequenceDiagram
  actor Member
  participant UI
  participant Library
  participant Catalog
  participant Book

  Member ->> UI: searchByTitle("Dune")
  UI ->> Library: findBook("Dune")
  Library ->> Catalog: search("Dune")
  Catalog -->> Library: book
  Library -->> UI: book
  UI -->> Member: display results
```

**Arrow types:**

| Arrow | Meaning |
|---|---|
| `->>` | Synchronous message (call) |
| `-->>` | Return / response |
| `-x` | Message that fails |
| `-)` | Asynchronous message |

### Activation bars
Show when an object is actively processing.

```mermaid
sequenceDiagram
  actor Member
  participant Library
  participant Book

  Member ->> +Library: borrowBook(memberId, isbn)
  Library ->> +Book: checkout()
  Book -->> -Library: confirmed
  Library -->> -Member: loan receipt
```

Use `+` before the participant to activate, `-` to deactivate.

### Conditional — alt/else

```mermaid
sequenceDiagram
  actor Member
  participant Library
  participant Book

  Member ->> Library: borrowBook(memberId, isbn)

  alt book is available
    Library ->> Book: checkout()
    Book -->> Library: confirmed
    Library -->> Member: loan created
  else book is checked out
    Library -->> Member: book unavailable
  end
```

### Optional block — opt

```mermaid
sequenceDiagram
  actor Member
  participant Library
  participant NotificationService

  Member ->> Library: returnBook(isbn)
  Library -->> Member: return confirmed

  opt hold exists for this book
    Library ->> NotificationService: notifyMember(holdMemberId)
    NotificationService -->> Library: notification sent
  end
```

### Loop

```mermaid
sequenceDiagram
  participant Librarian
  participant Library
  participant Book

  Librarian ->> Library: processOverdueItems()

  loop for each overdue loan
    Library ->> Book: markOverdue()
    Book -->> Library: updated
  end

  Library -->> Librarian: report complete
```

### Combining fragments

```mermaid
sequenceDiagram
  actor Member
  participant UI
  participant Library
  participant Book

  Member ->> UI: borrowBook(isbn)
  UI ->> Library: borrowBook(memberId, isbn)

  alt member account is valid
    loop for each book in request
      alt book is available
        Library ->> Book: checkout()
        Book -->> Library: confirmed
      else book unavailable
        Library -->> UI: notify unavailable
      end
    end
    Library -->> UI: loan summary
    UI -->> Member: receipt
  else member account suspended
    Library -->> UI: account suspended
    UI -->> Member: error message
  end
```

---

## 4. Common Mistakes

**Class diagram: arrow direction**
Arrows point from the dependent class to the class it depends on.
`Member --> Book` means Member depends on Book (Member has a reference to Book).
Not the other way around.

**Class diagram: inheritance vs implementation**
`<|--` is for `extends` (class to class).
`<|..` is for `implements` (class to interface). The dotted line is the hint — interfaces are dotted in UML.

**Multiplicity placement**
Multiplicity goes next to the class it describes.
`Member "1" --> "0..*" Loan` means one Member has zero or more Loans.
Read it left to right: one member, zero-to-many loans.

**Sequence diagram: return arrows**
A return arrow (`-->>`) is not optional. If a method returns something, show it.
If it returns void, you can omit it — but be consistent.

**Sequence diagram: participants vs actors**
Use `actor` for humans interacting with the system.
Use `participant` for objects and classes inside the system.

---

## 5. Putting It in Your Repository

Save your diagram as a `.md` file and commit it:

```
week-02-round-1-domain-model.md
```

Inside the file:

````markdown
# Domain Model — Week 2 Round 1

```mermaid
classDiagram
  ...
```
````

GitHub renders Mermaid diagrams automatically in markdown files.
You do not need to export images.
````
