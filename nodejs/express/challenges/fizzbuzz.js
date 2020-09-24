/*
const metodoA = (iteration) => {

    if (iteration <= 100) {
        metodoValidate(iteration);

        //console.log(iteration);
        //iteration = iteration + 1;
        metodoA(++iteration);
    } else {
        return;
    }
}

const metodoValidate = (number)=>{
    if(number % 3 === 0 && number % 5 === 0){
        console.log('fizzbuzz');
    } else if(number % 3 === 0){
        console.log('fizz');
    } else if(number % 5 === 0){
        console.log('buzz');
    } else {
        console.log(number);
    }

}

console.log(metodoA(1));
*/

for (var num = 1; num <= 100; num++) {
    console.log(num % 3 == 0 && num % 5 == 0 ? 'FizzBuzz' : (num % 3 == 0 ? 'Fizz' : (num % 5 == 0 && num % 3 != 0 ? 'Buzz' : num)));
  }