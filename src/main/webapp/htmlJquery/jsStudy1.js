const btn1 = document.querySelector("#btn1")  //document.getElementById("btn1");
const buttons = document.querySelectorAll(".buttons");
const d1 = document.querySelector("#d1 > .buttons li")

let ar = [1,2,3];


ar.forEach((v,i, list)=>{
    console.log('v = ' + v + ' i = ' + i + ' ar : ' + list);
})


btn1.addEventListener('click',()=>{
    console.log(11);
})
// for(let button of buttons){
//     button.addEventListener('click',()=>{
//         console.log(22);
//     })
// }

console.log(buttons);
console.log(ar);

buttons.forEach((v,i)=>{
    v.addEventListener('click',()=>{
        console.log(i);
    })
})

console.log('1' + 1)