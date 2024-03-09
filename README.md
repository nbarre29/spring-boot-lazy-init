Here are the various methods to remove elements from an array in JavaScript:

1. Pop()

Removes the last element from the array.
Modifies the original array.
Returns the removed element.
JavaScript
const numbers = [1, 2, 3, 4, 5];
const removedElement = numbers.pop();
console.log(numbers);  // Output: [1, 2, 3, 4]
console.log(removedElement);  // Output: 5
Use code with caution.
2. Shift()

Removes the first element from the array.
Modifies the original array.
Returns the removed element.
JavaScript
const numbers = [1, 2, 3, 4, 5];
const removedElement = numbers.shift();
console.log(numbers);  // Output: [2, 3, 4, 5]
console.log(removedElement);  // Output: 1
Use code with caution.
3. Splice()

Removes elements at a specific index or a range of indexes.
Modifies the original array.
Returns the removed elements as a new array.
JavaScript
const numbers = [1, 2, 3, 4, 5];
// Remove the element at index 2
const removedElements = numbers.splice(2, 1);
console.log(numbers);  // Output: [1, 2, 4, 5]
console.log(removedElements);  // Output: [3]

// Remove elements from index 1 to index 3
numbers.splice(1, 3);
console.log(numbers);  // Output: [1, 5]
Use code with caution.
4. Filter()

Creates a new array with elements that pass a test.
Does not modify the original array.
Doesn't return the removed elements.
JavaScript
const numbers = [1, 2, 3, 4, 5];
const filteredNumbers = numbers.filter(number => number % 2 !== 0);
console.log(numbers);  // Output: [1, 2, 3, 4, 5] (original array unchanged)
console.log(filteredNumbers);  // Output: [1, 3, 5]
Use code with caution.
5. Delete operator

Sets an element at a specific index to undefined.
Modifies the original array.
Does not change the array's length.
Use with caution as it can lead to unexpected results (e.g., for...in loops might still iterate over undefined elements).
JavaScript
const numbers = [1, 2, 3, 4, 5];
delete numbers[2];
console.log(numbers);  // Output: [1, 2, undefined, 4, 5]
Use code with caution.
Choosing the appropriate method:

Use pop() or shift() to remove elements from the end or beginning, respectively.
Use splice() for more control over index-based removal.
Use filter() to create a new array based on a condition without modifying the original.
Use the delete operator carefully, considering its potential drawbacks.
