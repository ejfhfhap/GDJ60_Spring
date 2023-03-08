const btnAdd = document.getElementById("btnAdd");
const fileList = document.getElementById("fileList");
// const fileBtn = document.getElementById('fileBtn');

let addCount = 0;
let maxCount = 3;
let parm = "addFiles";
let index = 0;

function setName(p){
    parm = p;
}

function setMax(count){
    maxCount = count;
}
function setCount(count){
    addCount = count;
}
function addFileBtn(cnt){
    for(let i = 0;i<cnt;i++){
        let child = '<div class="mb-3" id="files' + index +'">';
                child = child + '<input type ="file" class="form-control" name="' +parm + '">';
                child = child + '<button class="del" type="button" data-file-index="files' +index+ '">X</button>';
                child = child + '</div>';
        $('#fileList').append(child);
        addCount++;
        index++;
    }
}
$("#fileList").on('click','.del',(e)=>{
    $(e.target.parentNode).remove();
    addCount--;
    index++;
})
$('#btnAdd').click(()=>{
    if(addCount < maxCount){
        console.log('버튼 이벤트 작동!!');
        addFileBtn(1);
    }else{
        alert(maxCount + '개 갯수초과');
    }
})
$('.deleteCheck').click((e)=>{
    console.log(e.target.checked);
    if(e.target.checked == true){
        let okCheck = confirm('정말 삭제 하시겠습니까?');
        if(okCheck){
           addCount--;
        }else{
            e.target.checked = false;
        }
    }else{
        if(addCount >= maxCount){
            index--;
            addCount--;
            $('#files' + index).remove();
        }
        addCount++;
    }
})



// btnAdd.addEventListener("click",()=>{
//     if(addCount < maxCount){

//         let div = document.createElement('div');
//         let divClass = document.createAttribute('class');
//         divClass.value = 'mb-3';
//         let divId = document.createAttribute('id');
//         divId.value = 'files' + addCount;
//         div.setAttributeNode(divClass);
//         div.setAttributeNode(divId);

//         let input = document.createElement('input');

//         let inputType = document.createAttribute('type');
//         inputType.value = 'file';
//         let inputClass = document.createAttribute('class');
//         inputClass.value = 'form-control';
//         let inputName = document.createAttribute('name');
//         inputName.value = parm;

//         input.setAttributeNode(inputType);
//         input.setAttributeNode(inputClass);
//         input.setAttributeNode(inputName);

//         fileList.append(div);
//         div.append(input);

//         // x 버튼 추가하기
//         let button = document.createElement('button');
//         let type = document.createAttribute('type');
//         type.value = "button";
//         let parentId = document.createAttribute('data-file-index');
//         parentId.value = 'files' + addCount;
//         button.setAttributeNode(parentId);
//         button.setAttributeNode(type);
//         button.innerHTML = 'X';

//         div.append(button);
//         addCount++;
//     }else{
//         alert("한번만 누르세요");
//     }
// })
// fileList.addEventListener('click',(e)=>{
//     console.log(e.target.getAttribute('data-file-index'))
//     let parentId = document.getElementById(e.target.getAttribute('data-file-index'));
//     let fileId = document.getElementById(e.target.id);
//     if(parentId != null){
//         e.target.parentNode.remove();
//       //  parentId.remove();
//         addCount--;
//     }
// })