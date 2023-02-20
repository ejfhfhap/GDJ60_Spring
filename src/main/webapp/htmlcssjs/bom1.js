const btn = document.getElementById("btn");
btn.addEventListener('click',function(){
    // 중간에 "" 쓰기때문에 양끝에 '' 로 함 
    c2.innerHTML = '<img src="../resources/images/hanna.jpg">'

});

const btn2 = document.getElementById("btn2")
btn2.addEventListener('click',function(){
    const c3 = document.getElementById("c3")
    console.log(c3.getAttribute("title"))
    console.log(c3.title)
})

const btn3 = document.getElementById("btn3");
btn3.addEventListener("click",function(){
    const c4 = document.getElementById("c4");
    console.log(c4.value);
    console.log(c4.getAttribute("value"));
})

let c1 = window.document.getElementById("c1")

console.log(c1)
// text만 가져옴
console.log(c1.innerText)
// 태그 속성 content 까지 가져옴
console.log(c1.innerHTML)

//c1.innerText = "change text";

let c2 = document.getElementById("c2")
console.log(c2.innerText)
console.log(c2.innerHTML)


