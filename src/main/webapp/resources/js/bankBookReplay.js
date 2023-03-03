const submit = document.getElementById('submit');
const bookNumber = document.getElementById('bookNumber');
const contents = document.getElementById('contents');
const commentList = document.getElementById('commentList');

function getList(pageNum){
    let xhttp = new XMLHttpRequest();
    xhttp.open('GET','/bankBookComment/getCommentList?bookNumber=' + bookNumber.value);
    xhttp.send();
    xhttp.onreadystatechange = () =>{
        if(xhttp.readyState == XMLHttpRequest.DONE && xhttp.status == 200){
            console.log(xhttp.responseText);
            commentList.innerHTML = xhttp.responseText.trim();
        }
    }
}
getList();

submit.addEventListener('click',()=>{
    let xhttp = new XMLHttpRequest();
    xhttp.open('POST','/bankBookComment/add');
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("bookNumber=" + bookNumber.value +"&contents=" +contents.value);

    console.log(contents.value);
    xhttp.onreadystatechange = ()=>{
        if(xhttp.readyState == XMLHttpRequest.DONE && xhttp.status == 200){
            console.log(xhttp.responseText);
            if(xhttp.responseText.trim()){
                alert("등록 성공하였습니다");
                contents.value = "";
                getList();
            }else{
                alert("등록 실패");
            }
        }
    }
})

commentList.addEventListener('click',(e)=>{
    let element = e.target;
    console.log(element.classList);
    if(element.classList.contains('pageNumGroup')){
        let page = element.getattribute('data-board-page');
//pagenum 넘겨줘서 받기만 하면됨
    }
})