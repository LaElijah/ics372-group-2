# Group Artifact — Week 2 Round 2
**Group:** 2
**Members present:** Ray, Elijah, Thomas, Abenezer
**Date:** September 3, 2026

---

## Our Design

An order looks like an object with mostly empty fields save for the register (and possibly employee), the state of the order, and empty fields for the item, addons, etc.

The state of the order when the customer is building it: Drafting
The fields: 
  - RegisterID - ID from the register being used
  - OrderID - Generated ID

must exist 

The order requires a payment verification function to move forward.
The RegisterID and OrderID must stay the same 

but the fields for State will move to Pending, and the 
included item, addons, total price, customer name, and time placed will be filled. 

The state where its been submitted: Pending

The fields: 
  - RegisterID 
  - OrderID 
  - ItemID - ID that points to an Items information 
  - Customizations[] an array of itemIDs for addons 
  - CustomerName a string
  - TimePlaced a datetime object
must exist 

The order requires a isComplete() function to be used by the order view to be marked as complete and delivered to the customer. 

The fields TimeCompleted, and state would change, STATE would change to Completed. 
but the fields for RegisterID, OrderID, Item, Customizations, CustomerName, TimePlaced will stay the same.

The state where its been picked up: Complete
 At this point the order will be done and can be safely moved to 
 history. The final order would contain the following information 

RegisterID, OrderID, Item, Customizations, CustomerName, TimePlaced, State, TotalPrice


**Item**
What it knows: 
The Item knows details about a given inventory item, what can be customized, and the price of the item. 

What it does: 
The Item transfers information about the items price, customization, and details to its given entity. 



---


## How We Got Here

We were required to break down the order entity and delve deeper into how the state updated throughout the system as an order is finished. We decided to delve deeper in the state ide and specify the triggers as such: 

Drafted Triggers : customer triggers the drafted state when they start a order
Failed Triggers: When any error occurs, such as payment failure, errors during pending or complete (employee unable to complete order)
Pending Triggers: Payment is verified 
Complete Triggers: When employee marks the order as completed through order panel

We got here by discussing all the possible outcomes of an order at each stage, from the drafting of an order and possible failures of payment verification or some other issue, to the possible issue of an incomplete order by the employee for whatever reason for our fail states, and then finally a complete state for successful orders. 

---

## Where We Disagreed


An example in which we as a group disagreed was the inclusion of a customerID, we discussed that the inclusion of a customerID could be useful in the case of 2 orders with the same name, but we decided that since we already have an orderID, we could differentiate between them with our orderID without additional complexity. We also initially proposed that the orderID would be randomly generated however we ended up agreeing that we should have an incremented orderID so that we can have an orderly timeline of orders. We came to this conclusion by positing the idea of recycling orderIDs that may have been canceled, while we disagreed with the idea of recycling orderIDs, we kept the idea of incrementing ids from this idea.

---

## What We're Not Sure About

- Whats the best method to have the Inventory panel communicate with the kiosk? Should each kiosk entity subscribe to some topic the Inventory panel provides? or should it refresh for updates since its not a menu that would likely update during service, unless we include stock updates for out of stock items

- How should we sync order panels? should we also have order panels subscribe to a topic and then have each order panel update a single source of truth that all order panels have access to when a user modifies the order list? 


- For order, should we include a totalPrice attribute? or should we leave that as a calculated value? how do taxes affect our decision making here? 
- Should order just have empty or default values as it moves through the different processes of state? 
