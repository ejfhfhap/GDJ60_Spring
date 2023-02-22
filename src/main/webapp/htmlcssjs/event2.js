const p1 = document.getElementById("p1"); // div tag
const b1 = document.getElementById("b1"); // button tag

const p2 = document.getElementById("p2"); // div tag
const b2 = document.getElementById("b2"); // button tag

const naver = document.getElementById("naver");

// 캡쳐링
b1.addEventListener("click",(e)=>{
    console.log("button click");
    console.log(e)
},true)

p1.addEventListener("click",(event)=>{
    console.log("div click")
    console.log(event)
   // event.stopPropagation();
},true)

// 버블링 default 값
b2.addEventListener("click",(e)=>{
    console.log("button click");
    console.log(e)
   // e.stopPropagation();
},false)

p2.addEventListener("click",(event)=>{
    console.log("div click")
    console.log(event)
    console.log("CurrentTagret ", event.currentTarget);
    console.log("tagret ", event.target);
},false)

naver.addEventListener("click",(e)=>{
    console.log("naver click");
    e.preventDefault();
})