const list = document.getElementById("list");
const add = document.getElementById("add")

add.addEventListener("click",()=>{
    if(addCount == 0){
    // element = tag + attribute + content

    // element의 <li></li>를 만든거임
    let li = document.createElement('li');
    let button = document.createElement('button');

    // class 속성 만듬
    let attr = document.createAttribute('class');
    attr.value = 'btn';
    attr.value+=' bg';

    // click문자 만들어둠
    let text = document.createTextNode('click');

    // <li></li> 태그에 추가함 순서상관없음
    li.append(button);
    button.setAttributeNode(attr);
    button.appendChild(text);

    // 기존 내용 아래 추가
    list.append(li);
    // 기존 내용 위에 추가
    list.prepend(li);
    // 현재 태그 바론 위에 추가 (외부)
    list.before(li);
    // 현재 태그 바로 아래에 추가 (외부)
    list.after(li);
    
    }
})