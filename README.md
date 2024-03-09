// Function to remove an item from the cart and update total price
function removeCartItem(id) {
  const itemIndex = shoppingCart.findIndex(item => item.id === id);

  if (itemIndex !== -1) {
    // Item found, remove it and update total price
    const removedItem = shoppingCart.splice(itemIndex, 1)[0]; // Get removed item details
    totalPrice -= removedItem.quantity * removedItem.price; // Subtract removed item's price
    console.log(`Item "${removedItem.name}" removed. Updated total price: ${totalPrice.toFixed(2)}`);
  } else {
    console.log(`Item with ID ${id} not found in cart.`);
  }
}
