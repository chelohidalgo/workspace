var letters = ['1','2','3']

console.log(['start',...letters])

console.log([...letters,'end'])

console.log(['start',...letters,'end'])

console.log([letters,...'end'])

console.log([,...'end'])



var nums = [1,2,2,3]

console.log([new Set(nums)])

console.log([...new Set(nums)])