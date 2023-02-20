let ar = [1,2,3];
ar.push(4);
ar.push(10);

// 마지막 값 삭제하면서 값을 담음
let last = ar.pop(); 
// 첫번재 값 삭제하면서 값을 담음
let first = ar.shift(); 

for(let i = 0;i<ar.length;i++){
    console.log(i);
}

console.log("first : " + first);
console.log('last : ' + last);

// 정렬
ar.sort();
// 거꾸로
ar.reverse();

// ar에 2값이 포함되는지 확인 true false
console.log(ar.includes(2));

alert("heelo");