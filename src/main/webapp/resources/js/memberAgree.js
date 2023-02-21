const allAgree = document.getElementById("checkAll");
const options = document.getElementsByClassName("options")
const joinBtn = document.getElementById("joinBtn")

allAgree.addEventListener("click",function(){
    for(let i = 0;i<options.length;i++){
        options[i].checked = this.checked;
    }
})

for(let i = 0;i<options.length;i++){
    options[i].addEventListener("click",()=>{
        if(!options[i].checked){
            allAgree.checked = false;
        }

        let count = 0;
        for(let j = 0;j<options.length;j++){
            if(options[j].checked)count++;
        }
        if(count == options.length){
            allAgree.checked = true;
        }
    })
}


joinBtn.addEventListener("click",()=>{
    console.log(allAgree.checked)

    if(allAgree.checked){
        location.href = "./memberJoin";
    }else{
        alert("약관에 동의해 주세요")
    }
})

const btn  = document.getElementById("btn");
btn.addEventListener("click",()=>{
        var x = document.getElementById("abc");
        x.className = "show";
        setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);

})