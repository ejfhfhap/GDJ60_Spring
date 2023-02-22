const d1 = document.getElementById("d1");
const add = document.getElementById("add");
const h11 = document.getElementById('h11');
const result = document.getElementById("result");


let deleteCount = 0;

add.addEventListener("click",()=>{
    let d = document.createElement('div');
    let btn = document.createElement('button')
    let n = document.createTextNode('DELETE');
    let attr = document.createAttribute('class');
    let id = document.createAttribute('id');

    let data = document.createAttribute('data-div-id');
    data.value = "del" + deleteCount;
    
    id.value = "del" + deleteCount++;
    attr.value = 'dels';

    btn.setAttributeNode(attr);
    btn.setAttributeNode(data);
    btn.setAttributeNode(id);
    btn.appendChild(n);
    d.appendChild(btn);

    result.append(d);

})



result.addEventListener("click",(e)=>{
    // console.log(e.currentTarget,e.target);
    // console.log(e.target.classList.contains("dels"));
   // console.log(e)
    console.log(e.target);

    if(e.target.classList.contains("dels")){     
        let id = document.getElementById(e.target.getAttribute('data-div-id'));
        id.remove();

        console.log("이주형");
    }
    
})