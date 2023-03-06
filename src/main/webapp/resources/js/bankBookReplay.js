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
            commentList.innerHTML = xhttp.responseText.trim();
        }
    }
}
function deleteComment(num){
    let xhttp = new XMLHttpRequest();
    xhttp.open('POST','/bankBookComment/delete');
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("num=" + num);
    xhttp.onreadystatechange = ()=>{
        if(xhttp.readyState == XMLHttpRequest.DONE && xhttp.status == 200){
            let result = xhttp.responseText.trim();
            console.log(result);
        }
    }
}
function updateComment(num,content){
    let xhttp = new XMLHttpRequest();
    xhttp.open('POST','/bankBookComment/update');
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("num=" + num + "&contents=" + content);
    xhttp.onreadystatechange = ()=>{
        if(xhttp.readyState == XMLHttpRequest.DONE && xhttp.status == 200){
            let result = xhttp.responseText.trim();
            if(result > 0){
                alert("수정 성공!!");
            }else{
                alert("수정 실패..")
            }
            getList(1);
        }
    }
}
// 최초 1회 실행
getList(1);

// 댓글 페이지 관리
commentList.addEventListener('click',(e)=>{
    let page = e.target.getAttribute('data-board-page');
    console.log(e.target);

    if(page != null){
        e.preventDefault();
       // console.log(e.target);
        getList(page);
    }
    if(e.target.classList.contains('del')){
        let del= e.target.getAttribute('data-commentId-del');
        deleteComment(commentId);
        getList(1);
    }
    if(e.target.classList.contains('viewUpdateForm')){
        let commentNum = e.target.getAttribute('data-commentNum');       
        let contentInput = document.getElementById('content' + commentNum);
        console.log(contentInput);
        contentInput.firstChild.removeAttribute('readonly');

        let okBtn = document.createElement('button');
        let attr = document.createAttribute('class');
        attr.value = "btn btn-primary";
        okBtn.setAttributeNode(attr);
        okBtn.innerText = "확인";
        contentInput.append(okBtn);
        
        okBtn.addEventListener('click',()=>{
         //   console.log(contentInput.firstChild.value);
        //    console.log(commentNum);
            let content = contentInput.firstChild.value;
            updateComment(commentNum,content);
        })
    }

})

// 등록 버튼 관리
submit.addEventListener('click',()=>{
    let xhttp = new XMLHttpRequest();
    xhttp.open('POST','/bankBookComment/add');
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("bookNumber=" + bookNumber.value +"&contents=" +contents.value);

    xhttp.onreadystatechange = ()=>{
        if(xhttp.readyState == XMLHttpRequest.DONE && xhttp.status == 200){
         //   console.log(xhttp.responseText);
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
