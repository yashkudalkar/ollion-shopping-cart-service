# OLLION Shopping Cart Microservice

Simple RESTful API for a shopping cart using Java. The API will
manage the cart items for an e-commerce platform and calculate the total price at
checkout.

Requirements
1. API Functions:
- /cart/items to add items to the cart.
- /cart/items/{itemId} to remove items from the cart.
- /cart/checkout to calculate and return the total price of items in the
  cart.
2. Item Structure:
- Each item should have an id, name, price, and quantity.
3. Data Storage:
- Use an in-memory data structure to store cart items; no need for a
  database.
4. Validation:
- Ensure that item quantities and prices are always positive integers.
5. Error Handling:
- Properly handle cases like deleting an item that doesn’t exist.
