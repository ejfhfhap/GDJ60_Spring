const pl = document.getElementsByClassName("page-link");
const searchForm = document.getElementById("searchForm");
const page =document.getElementById("page");

for(let p of pl){
    p.addEventListener("click",(e)=>{
      //  e.preventDefault();
        console.log(p.getAttribute("data-board-page"));
        
        page.value = p.getAttribute("data-board-page");
        // submit 강제발생
        searchForm.submit();
    })
}