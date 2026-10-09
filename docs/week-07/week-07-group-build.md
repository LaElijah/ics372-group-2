# Week 7: Group Build
### ICS372 | Object-Oriented Design and Implementation

**30 minutes, then 20 more after the checkpoint.** Commit to `docs/week-07/group-artifact.md`.

## Checklist

Read this aloud in your room and check every box before you commit. **14 of tonight's 20 group points.** The other 6 are in the group redesign.

- [ ] Step 1 has a row for each of the six jobs, in order **(3 pts)**
- [ ] Every row has exactly one class under **Owner we chose** **(3 pts)**
- [ ] Every row says what data the job needs and which class holds it **(3 pts)**
- [ ] Step 2 lists every job with no honest owner, or says `- None.` **(1 pt)**
- [ ] Sections 2 to 4 of the template say how you got here, where you disagreed, and what you're not sure about **(4 pts)**
- [ ] Committed to `docs/week-07/group-artifact.md` **(required: nothing is graded without it)**

Don't change your class diagram yet. The table is your *before*.

---

Each of your sketches made the same kinds of decisions alone: which class answers whether an item can be sold, which class knows a price, which class uses up ingredients. Now you put those decisions side by side and choose **one owner for every job.** Copy the steps below into **section 1 of your group artifact** and put each deliverable under the step that asked for it.

**Groups of three:** spend your first ten minutes drawing UC-4 together, following the rules in the individual sketch handout, and put that diagram under step 1.

**Step 1: The responsibility table.** A table with exactly these seven columns and one row for each of the six jobs below. The example row is from the library and shows only the shape.

| Job | UC-1 | UC-2 | UC-3 | UC-4 | Owner we chose | Data it needs, and the class that holds it |
|---|---|---|---|---|---|---|
| Find a book by its title | `Catalog.findByTitle()` | - | proposed: `Library.search()` | - | `Catalog` | the list of every book: `Catalog` |

The six jobs, in this order:

1. Say whether a menu item can be sold right now
2. Say what an item costs as the customer configured it
3. Say what an item uses up, its customizations included
4. Use up the ingredients for a completed order
5. Know which order is next
6. Count how many of each menu item sold today

How to fill the cells:

- **UC-1 through UC-4:** the method that did this job in that person's diagram, written `Class.method()`. If it was a `MISSING` proposal, write `proposed:` before it. If the job doesn't happen in that use case, write a dash.
- **Owner we chose:** exactly one class.
- **Data it needs:** what the job has to know, and which class in your model holds that today.

**Step 2: Jobs with no honest owner.** A job has no honest owner when no class in your model holds the data it needs. One line each:

- `Job: <the job>. It needs: <the data>. No class has it because: <why>.`

If every job has an owner that holds its data, write `- None.`
