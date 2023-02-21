const d1 = document.getElementById("d1");
const input1 = document.getElementById("input1");
const input2 = document.getElementById("input2");
const input3 = document.getElementById("input3");
const btn = document.getElementById("btn");

d1.addEventListener("click",()=>{
    console.log("click")
})
d1.addEventListener("mouseenter",()=>{
    console.log("mouse enter")
})

// 키를 눌렀다 땠을때
input1.addEventListener("keyup",()=>{
    console.log("key up")
})
// 포커스 input 입력준비상태
input2.addEventListener("focus",()=>{
    console.log("focus")
})
// 포커스를 잃어버렸을때
input2.addEventListener("blur",()=>{
    console.log("blur")
})
// 원래 안에있던 값이 변경 되었을때 blur와 동시
input2.addEventListener("change",()=>{
    console.log("change")
})

// select, option에서 select선택해서 option 값 구해올 수 있음
input3.addEventListener("change",()=>{
    console.log(input3.value)
})

btn.onclick=()=>{
    // 이벤트 강제실행
    input2.focus();
}
