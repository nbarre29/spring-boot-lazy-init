-> in this code we are overriding the toString method for the person object. In JavaScript, the toString method is a default method inherited by all objects from the Object prototype. By defining a toString method within the person object, you are providing a custom implementation for the toString method specific to instances of the person object.

This kind of custom toString method can be useful for providing a human-readable representation of your object 

const person = {
  firstName: 'Alice',
  lastName: 'Smith',
  toString() {
    return `Person(name: ${this.firstName} ${this.lastName})`;
  },
};

console.log(person.toString()); // Person(name: Alice Smith)
