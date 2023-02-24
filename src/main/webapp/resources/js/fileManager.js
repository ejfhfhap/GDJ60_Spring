const btnAdd = document.getElementById("btnAdd");
const fileList = document.getElementById("fileList");
const fileBtn = document.getElementById('fileBtn');

let addCount = 0;
let maxCount = 3;
let parm = "files";

function setName(p){
    parm = p;
}

function setMax(count){
    maxCount = count;
}
btnAdd.addEventListener("click",()=>{
    if(addCount < maxCount){

        let div = document.createElement('div');
        let divClass = document.createAttribute('class');
        divClass.value = 'mb-3';
        let divId = document.createAttribute('id');
        divId.value = 'files' + addCount;
        div.setAttributeNode(divClass);
        div.setAttributeNode(divId);

        let input = document.createElement('input');

        let inputType = document.createAttribute('type');
        inputType.value = 'file';
        let inputClass = document.createAttribute('class');
        inputClass.value = 'form-control';
        // let inputId = document.createAttribute('id');
        // inputId.value = 'files'
        let inputName = document.createAttribute('name');
        inputName.value = parm;

        input.setAttributeNode(inputType);
        input.setAttributeNode(inputClass);
       // input.setAttributeNode(inputId);
        input.setAttributeNode(inputName);

        let label = document.createElement('label');

        let labelFor = document.createAttribute('for');
        labelFor.value = 'files';
        let labelText = document.createTextNode('이미지');
        label.setAttributeNode(labelFor);
        label.appendChild(labelText);

        fileBtn.append(div);
        div.append(input);
        div.append(label);


        // x 버튼 추가하기
        let button = document.createElement('button');
        let type = document.createAttribute('type');
        type.value = "button";
        let parentId = document.createAttribute('data-file-index');
        parentId.value = 'files' + addCount;
        button.setAttributeNode(parentId);
        button.setAttributeNode(type);
        let text = document.createTextNode('X');
        button.append(text);

        fileBtn.append(button);
    

        addCount++;
    }else{
        alert("한번만 누르세요");
    }
})
fileBtn.addEventListener('click',(e)=>{
    console.log(e.target.getAttribute('data-file-index'))
    let parentId = document.getElementById(e.target.getAttribute('data-file-index'));
    let fileId = document.getElementById(e.target.id);
    if(parentId != null){
        parentId.remove();
        e.target.remove();
        addCount--;
    }
})