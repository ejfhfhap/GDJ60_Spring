const submit = document.getElementById('submit');
const bookNumber = document.getElementById('bookNumber');
const contents = document.getElementById('contents');
const commentList = document.getElementById('commentList');
const contentsConfirm = document.getElementById('contentsConfirm');
const modalClose = document.getElementById('modalClose');

// 댓글 리스트
function getList(page){

    fetch('/bankBookComment/getCommentList?bookNumber=' + bookNumber.value + "&page=" + page,{
        method:'GET',
    }).then((response)=>{
        return response.text();
    }).then((result)=>{
        result = result.trim();
        commentList.innerHTML = result;
    }).catch(()=>{
        alert('리스트 에러');
    })

    // let xhttp = new XMLHttpRequest();
    // xhttp.open('GET','/bankBookComment/getCommentList?bookNumber=' + bookNumber.value + "&page=" + page);
    // xhttp.send();
    // xhttp.onreadystatechange = () =>{
    //     if(xhttp.readyState == XMLHttpRequest.DONE && xhttp.status == 200){
    //         commentList.innerHTML = xhttp.responseText.trim();
    //     }
    // }
}
// 댓글 삭제
function deleteComment(num){

    fetch('/bankBookComment/delete',{
        method:'POST',
        headers: {"Content-type" : "application/x-www-form-urlencoded"},
        body: "num=" + num
    }).then((response)=>{
        return response.text();
    }).then((res)=>{
        res = res.trim();
        if(res > 0){
            alert('삭제 완료');
            getList(1);
        }else{
            alert('삭제 실패');
        }
    }).catch(()=>{
        alert("삭제 시 오류");
    })


    // let xhttp = new XMLHttpRequest();
    // xhttp.open('POST','/bankBookComment/delete');
    // xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    // xhttp.send("num=" + num);
    // xhttp.onreadystatechange = ()=>{
    //     if(xhttp.readyState == XMLHttpRequest.DONE && xhttp.status == 200){
    //         let result = xhttp.responseText.trim();
    //         console.log(result);
    //     }
    // }
}
// 댓글 수정
function updateComment(num,content){

    fetch('/bankBookComment/update',{
        method:'POST',
        headers: {"Content-type" : "application/x-www-form-urlencoded"},
        body:"num=" + num + "&contents=" + content
    }).then((response)=>{
        return response.text();
    }).then((res)=>{
        res = res.trim();
        if(res > 0){
            alert('업데이트 완료');
            getList(1);
        }else{
            alert('업데이트 실패');
        }
    }).catch(()=>{
        alert('업데이트 오류');
    })


    // let xhttp = new XMLHttpRequest();
    // xhttp.open('POST','/bankBookComment/update');
    // xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    // xhttp.send("num=" + num + "&contents=" + content);
    // xhttp.onreadystatechange = ()=>{
    //     if(xhttp.readyState == XMLHttpRequest.DONE && xhttp.status == 200){
    //         let result = xhttp.responseText.trim();
    //         if(result > 0){
    //             alert("수정 성공!!");
    //             getList(1);
    //             modalClose.click();
    //         }else{
    //             alert("수정 실패..")
    //         }
    //     }
    // }
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
        let contentsTextArea = document.getElementById("contentss");
        contentsTextArea.innerText = contentInput.innerText;
        contentsConfirm.setAttribute("data-comment-num",commentNum);
    }

})
contentsConfirm.addEventListener('click',()=>{
    console.log('update post contentsConfirm');
    let updateContents = document.getElementById("contentss").value;
    let num = contentsConfirm.getAttribute('data-comment-num');
    console.log(num,updateContents);
    updateComment(num,updateContents);
    
})

// 등록 버튼 관리
submit.addEventListener('click',()=>{

    // js에서 사용 할 가상의 폼태그
    const form = new FormData(); // <form></form>
    form.append('contents',contents.value); // <input type="text" name="contents" value="변수값">
    form.append('bookNumber',bookNumber.value); // <input type="text" name="bookNumber" value="변수값">


    fetch('/bankBookComment/add',{
        method:'POST',
      //  headers:{"Content-type" : "application/x-www-form-urlencoded"},
        body:form
        // body:"bookNumber=" + bookNumber.value +"&contents=" +contents.value
    }).then((response)=>{
        // response 응답 객체라고 보면됨  response.readyState response.status
        return response.text();
    }).then((res)=>{
        if(res.trim() == 1){
            alert("등록 성공하였습니다");
            contents.value = "";
            getList(1);
        }else{
            alert("등록 실패");
        }
    }).catch(()=>{
        console.log("등록 에러 발생");
    })

    // let xhttp = new XMLHttpRequest();
    // xhttp.open('POST','/bankBookComment/add');
    // xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    // xhttp.send("bookNumber=" + bookNumber.value +"&contents=" +contents.value);

    // xhttp.onreadystatechange = ()=>{
    //     if(xhttp.readyState == XMLHttpRequest.DONE && xhttp.status == 200){
    //      //   console.log(xhttp.responseText);
    //         if(xhttp.responseText.trim() == '1'){
    //             alert("등록 성공하였습니다");
    //             contents.value = "";
    //             getList(1);
    //         }else{
    //             alert("등록 실패");
    //         }
    //     }
    // }
})
