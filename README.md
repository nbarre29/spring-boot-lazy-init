consider a more complex example where we use unshift() to dynamically add elements to an array based on certain conditions:

javascript
Copy code
// Original array
let fruits = ['banana', 'apple', 'orange'];

// Function to add a fruit to the beginning of the array only if it doesn't already exist
function addFruitIfNotExists(fruit) {
  if (!fruits.includes(fruit)) {
    fruits.unshift(fruit);
    console.log(`Added ${fruit} to the beginning of the array.`);
  } else {
    console.log(`${fruit} already exists in the array.`);
  }
}

// Initial array and length
console.log('Original Array:', fruits);
console.log('Array Length:', fruits.length);

// Add fruits to the beginning based on conditions
addFruitIfNotExists('apple');
addFruitIfNotExists('grape');
addFruitIfNotExists('kiwi');
addFruitIfNotExists('banana');

// Updated array and length
console.log('Updated Array:', fruits);
console.log('Array Length:', fruits.length);
In this example, the addFruitIfNotExists function checks if a given fruit already exists in the array using the includes() method. If the fruit is not present, it adds the fruit to the beginning of the array using unshift() and logs a message. If the fruit already exists, it logs a different message.

The output of this example would be:

sql
Copy code
Original Array: [ 'banana', 'apple', 'orange' ]
Array Length: 3
apple already exists in the array.
Added grape to the beginning of the array.
Added kiwi to the beginning of the array.
banana already exists in the array.
Updated Array: [ 'kiwi', 'grape', 'banana', 'apple', 'orange' ]
Array Length: 5
This demonstrates how unshift() can be used in a more complex scenario to modify an array dynamically based on certain conditions.





