
let xhttp = new XMLHttpRequest();
xhttp.open('GET', './notice/listTop');
xhttp.send();

xhttp.onreadystatechange = ()=> {
    if(xhttp.readyState == XMLHttpRequest.DONE && xhttp.status == 200){
        console.log(xhttp.responseText);
        const noticeList = document.getElementById('noticeList');
        noticeList.innerHTML = xhttp.responseText.trim();
    }
}
