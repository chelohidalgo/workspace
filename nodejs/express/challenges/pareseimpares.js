const numbers = [1, 5, 8, 4, 2, 7, 12,67,45,-15,-66]

const order = (numbers) => {
    var arraySize = numbers.length
    var evenNumberPosition = 0
    var result = []
    numbers.forEach((element) => {
        element%2 == 0 ? result[evenNumberPosition] = element : result[arraySize-1] = element
        element%2 == 0 ? evenNumberPosition++ : arraySize-- 
    });
    return result
}

console.log(order(numbers))