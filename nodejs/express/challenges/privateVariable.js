const test = () =>{
    var private = 'Hola mundo'
    return ()=>{
        //return private
        return ()=>{
            return private
        }
    }
    
}

const value = test()
const value2 = value()
console.log(value2())