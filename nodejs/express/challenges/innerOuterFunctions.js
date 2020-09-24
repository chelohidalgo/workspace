var num =4;
function outer(){
    var num = 2;
    function inner(){
        num++;
        var num =3;
        console.log(num);
    }
    inner();
}
outer();