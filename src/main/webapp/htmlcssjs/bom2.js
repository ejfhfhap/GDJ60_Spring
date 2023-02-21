const btn = document.getElementById("btn");

btn.addEventListener("click",()=>{
    const r1 = document.getElementById("r1").value;
    const s1 = document.getElementById("s1").value;


    let insert = "";
    for(let i = 0;i<r1;i++){
        insert+="<tr>"
        for(let j = 0;j<s1;j++){
            insert+="<td></td>"
        }
        insert+="</tr>"
    }

    const table = document.getElementById("table");
    table.innerHTML = insert;
})

const btn1 = document.getElementById("btn1");
btn1.addEventListener("click",()=>{
    
    const options = document.getElementsByClassName("options");
    for(let i = 0;i<options.length;i++){
        // option[i]만 쓰면 element 한줄 전부 가져오는거임
        // console.log(options[i].value);

        // 이건 안됨
        // if(options[i].getAttribute("selected")){
        //     console.log(options[i].value);
        // }

        if(options[i].selected){
            console.log(options[i].value);
        }
    }

})

const btn2 = document.getElementById("btn2");
btn2.addEventListener("click",()=>{

    const options1 = document.getElementsByClassName("options1");
    for(let i = 0;i<options1.length;i++){
        if(options1[i].checked){
            console.log(options1[i].value);
        }
    }
})