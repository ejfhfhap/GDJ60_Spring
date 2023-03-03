let car = {
    brand : 'AUM',
    price : 3000,
    info:function(){
        console.log(this.brand , this.price);
    }
}

// class Student{
//     na = '';
//     kor;
//     constructor(){
//     }
//     info(){
//         console.log(this.na, this.kor);
//     }
// }
class Student{
    #na = '';
    #kor;
    constructor(){

    }

    set na(na){
        this.#na = na;
    }
    get na(){
        return this.#na;
    }
    set kor(kor){
        this.#kor = kor;
    }
    get kor(){
        return this.#kor;
    }

    info(){
        console.log(this.#na, this.#kor);
    }

}

const bt1 =  document.querySelector('#btn1');
btn1.addEventListener('click',()=>{
    // car.info();
    // console.log(car.brand)
    // car.color = 'red';
    // // 멤버변수 메서드명 출력
    // for(let v in car){
    //     console.log(v);
    // }

    let s = new Student();
    s.na = 'hanna';
    s.kor = 100;
    //s.info();
    console.log(s.na + s.kor)
})