Changes Made:

The updateCartItem function now updates both the quantity and calculates the total totalPrice for the item.
We use shoppingCart[itemIndex].quantity * shoppingCart[itemIndex].price to calculate the total price based on the updated quantity and the item's price.

const shoppingCart = [
  { id: 1, name: 'Apples', quantity: 2, price: 1.0 },
  { id: 2, name: 'Bananas', quantity: 3, price: 0.75 },
  { id: 3, name: 'Milk', quantity: 1, price: 3.5 },
];

// Function to update cart item with quantity and calculate total price
function updateCartItem(id, newQuantity) {
  const itemIndex = shoppingCart.findIndex((item) => item.id === id);

  if (itemIndex !== -1) {
    // Item found, update quantity and calculate total price
    shoppingCart[itemIndex].quantity = Math.max(newQuantity, 0);
    shoppingCart[itemIndex].totalPrice =
      shoppingCart[itemIndex].quantity * shoppingCart[itemIndex].price;
  } else {
    console.log(`Item with ID ${id} not found in cart.`);
  }
}

// Function to remove an item from the cart
function removeCartItem(id) {
  const itemIndex = shoppingCart.findIndex((item) => item.id === id);

  if (itemIndex !== -1) {
    // Item found, remove it using splice
    shoppingCart.splice(itemIndex, 1);
  } else {
    console.log(`Item with ID ${id} not found in cart.`);
  }
}

// Example usage: Update quantity and calculate price for Apples (1 item)
updateCartItem(1, 10);

// Example usage: Remove item with ID 2 (Bananas)
removeCartItem(2);

console.log(shoppingCart); // Updated cart after modifications


[
  { id: 1, name: 'Apples', quantity: 10, price: 1, totalPrice: 10 },
  { id: 3, name: 'Milk', quantity: 1, price: 3.5 }
]
