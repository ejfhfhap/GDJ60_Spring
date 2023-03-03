const btn1 = document.querySelector('#btn1');
btn1.addEventListener('click',()=>{
    open("./new.html",'test','width=300,height=300,top=100,left=100');
    clearInterval(st);
})

// 일정한 시간이 지나면 딱 한번 실행 하는 것
setTimeout(() => {
    alert("gdg");
}, 1000);

// 일정한 시간마다 계속 반복하는 것
let st = setInterval(() => {
   console.log('interval') 
}, 1000);