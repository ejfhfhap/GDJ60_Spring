const submit = document.getElementById('submit');
const bookNumber = document.getElementById('bookNumber');
const contents = document.getElementById('contents');
const commentList = document.getElementById('commentList');

function getList(page){
    let xhttp = new XMLHttpRequest();
    xhttp.open('GET','/bankBookComment/getCommentList?bookNumber=' + bookNumber.value + "&page=" + page);
    xhttp.send();
    xhttp.onreadystatechange = () =>{
        if(xhttp.readyState == XMLHttpRequest.DONE && xhttp.status == 200){
            console.log(xhttp.responseText);
            commentList.innerHTML = xhttp.responseText.trim();
        }
    }
}
// 최초 1회 실행
getList(1);

// 댓글 페이지 관리
commentList.addEventListener('click',(e)=>{

    let page = e.target.getattribute('data-board-page');
    if(page != null){
        getList(page);
    }
})

// 등록 버튼 관리
submit.addEventListener('click',()=>{
    let xhttp = new XMLHttpRequest();
    xhttp.open('POST','/bankBookComment/add');
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("bookNumber=" + bookNumber.value +"&contents=" +contents.value);

    console.log(contents.value);
    xhttp.onreadystatechange = ()=>{
        if(xhttp.readyState == XMLHttpRequest.DONE && xhttp.status == 200){
            console.log(xhttp.responseText);
            if(xhttp.responseText.trim() == '1'){
                alert("등록 성공하였습니다");
                contents.value = "";
                getList(1);
            }else{
                alert("등록 실패");
            }
        }
    }
})
