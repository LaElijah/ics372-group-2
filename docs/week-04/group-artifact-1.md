# Group Artifact — Week 4 Round 1
**Group:** 2
**Members present:** Thomas, Elijah, Abenezer, Ray
**Date:** 09-17-26

---

## 1. Tonight's Prompt

Produce both use cases in full, in the call-and-response format: precondition, main flow, at least two alternative flows each, postcondition. You each have one drafted, so the time goes on merging, on the steps somebody wrote too coarsely, and on the alternative flows.



### Customer 

Precondition: is the customer viewing the menu and is willing to place an order. Queue for orders is ready.

Postcondition: The order is submitted/ sent to barista queue and customer has received a confirmation number.


| Actor Action | System Response |
|---|---|
| 1. Customer starts order | |
| 2. The customer will select an item from the menu | |
| | 3. The system will show available menu items with its price |
| 4. The customer will pick quantity and other options | |
| | 5. The system will add said items to the order and show the updated order |
|  6. The customer makes sure the order is correct and make any necessary changes ||
| |7. The system will show the fully updated order and its price| 
|  8. The customer pays and places the order ||
| |9. The system will submit the order to the queue while providing a confirmation number for the customer |




### Alternative

 A1 At step 4 — A selected item is not available anymore

| Actor Action | System Response |
|---|---|
| 4a. The customer selects an item that isn't available anymore | |
| | 4b. The system prompts that its no longer available |


A2 at step 8 -  A payment was failed

Actor Action | System Response |
|---|---|
|  |  8a. Customer payment fails and order not sent through|
| 8b. Customer can attempt again or cancel order|  |
| | 8c. if payment verified then continue to 9 and if not go back to 8a |
|


### Barista

Precondition: The Barista having at least one order in queue
Postcondition: The Order has been completed, and removed from the queue and is ready for pick up

| Actor Action | System Response |
|---|---|
| 1. Barista starts an order  | |
| 2. Barista taps order for more info | |
|  3. Barista marks a partial item for completion | |
| 4.Barista marks order as fully complete | |
| | 5. The system registers order as completed |
| | 6. Order is marked ready for pickup |




### Alternative 


A1 at step 4 - System updates state to RECALLED (mistake or customer wants a change)

| Actor Action | System Response |
|---|---|
| 4a. Barista marks order as recalled | |
|  | 4b. System updates state to RECALLED|
|  4c. Barista resubmits order  | |
|  | 4d. System updates recalled order|
| 4e. Barista marks order as fully complete. | |
| |4f. System updates state to COMPLETE |



A2 at step 1 - Assumes there are any orders to complete
 
| Actor Action | System Response |
|---|---|
|  1a. Barista waits for an order  | |
|  | 1b. System displays old orders |



---

## 2. How We Got Here

 For customer we started with two similar ideas for customer but the differences were mainly in depth. One had mentioned payment, butdid not mention order updates and quantity in depth. For Barista the ideas were very similar in how they saw the process. Most of the actions were done by the actor. 

---

## 3. Where We Disagreed

The main disagree was not really a disagreement but how customer was done by the two people in our group.  One had focused on the details of the step like updates and price total, but did not do payment verification as a step. We decided to take the best of both. Adding to the more detailed diagram and adding customer payment.

---

## 4. What We're Not Sure About

We did struggle with having making our diagrams work with each other at the start. We understood the steps but our formats were slightly different. We honestly did have similar flows in the end. 
