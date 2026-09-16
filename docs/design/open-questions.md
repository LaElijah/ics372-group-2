# Open Questions — Group 2
### ICS372 | Fall 2026
**Members:** Thomas, Elijah, Abenezer, Ray
**Last updated:** 9/16/2026 — Added Open Questions


---

## 1 · Open

| # | The question | Why deferring is safe | Resolve by | Raised |
|---|---|---|---|---|
| 1 | What happens to an order if the system loses power while its in various states like submitted/paid for or being prepared | Designing the orders while not deciding exact recovery behavior is still plausible | Week 4 | Week 3 |


---

## 2 · Design Commitments Made Early

| # | What we decided | Why we wanted it | Revisit |
|---|---|---|---|
| 1 | We decided that combining several use cases like adding items and customizing items, and adding notes should be built into one use case as of now | We did this with the idea in mind that having this many use cases doing the roughly the same thing would be way too redundant | Week 6 |

---

## 3 · Requirements That Need a Decision

| # | Requirement(s) | The problem | The question we would send | What we are doing meanwhile | Settle by |
|---|---|---|---|---|---|
| 1 | 2.7, 3.4 | The problem is that the two goals that are warranted in these requirements directly conflict with each other. Requirement 2.7 states that a customer should be able to fix their order after placing it while 3.4 states that an order that has been placed can't be changed. | Should a customer be able to change their order whenever they want or should they have to ask the barista directly to fix the issue? | As of right now we using the use case Correct Placed Order which means customers should be able to fix their order whenever they want. This is how its going to be until more information is clarified | Week 4 |
| 2 | 3.7, 4.1 | The problem is that requirement 3.7 allows a barista to add menu items while 4.1 says only managers can modify the menu | If there are no available managers should barista's be able to add menu items or should only managers have that authority? | We are currently allowing both parties to be able to modify the menu with barista's having Add Menu Item and managers having Modify Menu until more information is given | Week 4 |


---

## 4 · Resolved


| # | The question | How it was resolved | Week |
|---|---|---|---|
| 1 | Which actions should warrant separate use cases | We combined use cases that were very close in action and tried contributing to the same goal. For example, our build and customize order use case was made by combining multiple quantity, modify order, add note, and build order. | Week 3 |
