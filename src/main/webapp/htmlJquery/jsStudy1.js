const btn1 = document.querySelector("#btn1")  //document.getElementById("btn1");
const buttons = document.querySelectorAll(".buttons");

btn1.addEventListener('click',()=>{
    console.log(11);
})

for(let button of buttons){
    button.addEventListener('click',()=>{
        console.log(22);
    })
}
