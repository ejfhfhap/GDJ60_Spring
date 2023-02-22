const btnAdd = document.getElementById("btnAdd");
const fileList = document.getElementById("fileList");

let addCount = 0;
let maxCount = 3;
let parm = "pic";

function setName(p){
    parm = p;
}

function setMax(count){
    maxCount = count;
}
btnAdd.addEventListener("click",()=>{
    if(addCount < maxCount){
        let fieldset = document.createElement('fieldset');
        let fieldClass = document.createAttribute('class');
        fieldClass.value ='col-2';
        
        fieldset.setAttributeNode(fieldClass);

        let legend = document.createElement('legend');
        let legendClass = document.createAttribute('class');
        legendClass.value ='shadow-lg p-3 mb-5 bg-body-tertiary rounded';
        let legendText = document.createTextNode('파일선택');

        legend.setAttributeNode(legendClass);
        legend.appendChild(legendText);

        let div = document.createElement('div');
        let divClass = document.createAttribute('class');
        divClass.value = 'form-floating';
        div.setAttributeNode(divClass);

        let input = document.createElement('input');

        let inputType = document.createAttribute('type');
        inputType.value = 'file';
        let inputClass = document.createAttribute('class');
        inputClass.value = 'form-control';
        let inputId = document.createAttribute('id');
        inputId.value = 'files';
        let inputName = document.createAttribute('name');
        inputName.value = parm;

        input.setAttributeNode(inputType);
        input.setAttributeNode(inputClass);
        input.setAttributeNode(inputId);
        input.setAttributeNode(inputName);

        let label = document.createElement('label');

        let labelFor = document.createAttribute('for');
        labelFor.value = 'files';
        let labelText = document.createTextNode('이미지');
        label.setAttributeNode(labelFor);
        label.appendChild(labelText);

        fileList.append(fieldset);
        fieldset.append(legend);
        fieldset.append(div);
        div.append(input);
        div.append(label);
        addCount++;
    
    }else{
        alert("한번만 누르세요");
    }
})