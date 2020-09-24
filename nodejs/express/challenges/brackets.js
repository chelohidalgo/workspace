function BracketMatcher(str) {
	let open = str.replace(/[^(]/g, "");
    let close = str.replace(/[^)]/g, "");
    console.log('open', open)
    console.log('close', close)
	return (open.length === close.length) ? 1+' '+ open.length : 0; 
}
   
console.log(BracketMatcher('(soy) una() verg(a)'))

//var p = /\(|\)/g;

function test (){
    var re = /apples/gi;
var str = "Apples are round, and apples are juicy.";
var newstr = str.replace(re, "oranges");
console.log(newstr);
}

console.log(test())