const inputId = document.getElementById("inputId");
const inputPw1 = document.getElementById("inputPw1");
const inputPw2 = document.getElementById("inputPw2");
const inputName = document.getElementById("inputName");
const inputPhone = document.getElementById("inputPhone");
const inputEmail = document.getElementById("inputEmail");
const inputAddress = document.getElementById("inputAddress");
const btn = document.getElementById("btn");
const formBtn = document.getElementById("formBtn")

const idMsg = document.getElementById("idMsg");
const pwMsg = document.getElementById("pwMsg");
const rePwMsg = document.getElementById("rePwMsg");
const nameMsg = document.getElementById("nameMsg");
const phoneMsg = document.getElementById("phoneMsg");
const emailMsg = document.getElementById("emailMsg");
const addressMsg = document.getElementById("addressMsg");

let check = [0,0,0,0,0,0,0];

console.log(1231999);

inputId.addEventListener("blur",()=>{
    // 비어있으면 안됨 tag추가
    let id = inputId.value;
    if(id.length == 0){
        check[0] = 0;
        idMsg.innerText="값을 넣어주세요";
        idMsg.classList.add("redResult");
        idMsg.classList.remove("blueResult");

    }else{
        check[0] = 1;
        idMsg.innerText="올바른 값 입니다";
        idMsg.classList.add("blueResult");
        idMsg.classList.remove("redResult")
    }
})
inputPw1.addEventListener("keyup",()=>{
    // 6글자에서 12글자 사이로 하기
    // 비어있으면 안됨
    let pw1 = inputPw1.value;
    if(pw1.length < 6 || pw1.length >12){
        pwMsg.innerText="6~12글자 사이"
        check[1] = 0;
    }else{
        pwMsg.innerText="";
        check[1] = 1;
    }
})

inputPw2.addEventListener("blur",()=>{
    // 위 비번과 비교
    if(inputPw1.value != inputPw2.value){
        rePwMsg.innerText = "같은 비번"
        check[2] = 0;
    }else{
        rePwMsg.innerText = ""
        check[2] = 1;
    }
})

// blur 안먹힘 만약에 js코드 넣으면?
inputPw1.addEventListener("change",()=>{
    inputPw2.focus();
    inputPw2.blur();
})

inputName.addEventListener("blur",()=>{
    let name1 = inputName.value;
    if(name1 == ""){
        nameMsg.innerText = "값을 넣어주세요";
        check[3] = 0;
    }else{
        nameMsg.innerText = "";
        check[3] = 1;
    }
})
//-------------------
inputPhone.addEventListener("blur",()=>{
    let phone = inputPhone.value;
    if(phone == ""){
        phoneMsg.innerText = "값을 넣어주세요";
        check[4] = 0;
    }else{
        phoneMsg.innerText = ""
        check[4] = 1;
    }
})
inputEmail.addEventListener("blur",()=>{
    let email = inputEmail.value;
    if(email == ""){
        emailMsg.innerText = "값을 넣어주세요";
        check[5] = 0;
    }else{
        emailMsg.innerText = "";
        check[5] = 1;
    }
})
inputAddress.addEventListener("blur",()=>{
    let address = inputAddress.value;
    if(address == ""){
        addressMsg.innerText = "값을 넣어주세요"
        check[6] = 0;
    }else{
        addressMsg.innerText="";
        check[6] = 1;
    }
})
btn.addEventListener("click",()=>{
    console.log(check)
    if(!check.includes(0)){
        // btn.type = "submit";
        formBtn.submit()
    }else{
        btn.type = "button";
    }

  //  formBtn.submit()
    console.log(btn.type + 1);
})