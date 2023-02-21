const d1 = document.getElementById("d1");
function callback1(){
    console.log("collBack1")
}

let callback2 = ()=>{
    console.log("collBack2")
}

d1.addEventListener("click",callback2)
d1.addEventListener("click",()=>{

})







function f2(a, b){
    console.log(a+b);
}
f2(2,58);

let fun = function (){
    console.log("익명함수")
    return "haan"
    // 함수 자체를 담을수도 있고 return 1 할수도있음
}
fun()

function f3(fun){
    console.log("f3 : " + fun())
}
f3(fun)