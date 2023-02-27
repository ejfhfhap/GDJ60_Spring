const update = document.getElementById("update");
const deletee = document.getElementById("delete");
const frm = document.getElementById("frm");

update.addEventListener('click',()=>{
    frm.action = "./update";
    frm.method = "get";
    frm.submit();
})

deletee.addEventListener('click',()=>{
    let check = confirm('정말 삭제?')
    if(check){
        frm.action = "./delete";
        frm.method = "post";
        frm.submit();
    }
})
