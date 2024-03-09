The unshift() method in JavaScript is used to add one or more elements to the beginning of an existing array. Here's a breakdown with an example:

Functionality:

It modifies the original array by inserting the provided elements at the front.
It accepts one or more arguments which become the new elements at the beginning.
It returns the new length of the array after the elements are inserted.
Example:

JavaScript
const fruits = ["apple", "banana"];

// Add "orange" to the beginning of the fruits array
const newLength = fruits.unshift("orange");

console.log(fruits); // Output: ["orange", "apple", "banana"]
console.log(newLength); // Output: 3 (new length of the array)
