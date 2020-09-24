//Scope
// let : block scope
// var : function scope

//add new properties
var person = { name: 'Marcelo'}
person.age = 3

console.log(person);

//no allow changes and new properties
var person = { name: 'Marcelo'}
Object.freeze(person)
person.age = 3

console.log(person);


// allow remove/change values in properties but NO new properties
var person = { name: 'Marcelo'}
Object.seal(person)
person.age = 3
person.name = 'Marcelo -> Change'

console.log(person);

//other way to do above is
var person = { name: 'Marcelo'}
Object.defineProperty(person, 'age', {
    value:8,
    writable:false
})

person.name = 'Marcelo -> Change'
person.age = 99
console.log(person);