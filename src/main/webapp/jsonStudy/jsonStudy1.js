let getProductOne = (productId)=>{
    $.get('https://dummyjson.com/products/' + productId,(response)=>{
        console.log(productId);
        console.log(response); 
        console.log(JSON.stringify(response)); //json을 변환 해야함

    })
}

$('#btn').click(()=>{
    let productId = $('#productId').val();
    getProductOne(productId);
})


$.ajax({
    type:"GET",
    url:'https://dummyjson.com/products/'+1,
    success:(response)=>{
        console.log(response);
        console.log(typeof(response));
    },
    error:()=>{

    }
})

// let getProductLists = ()=> {
//     $.get('https://dummyjson.com/products',(response)=>{
//         for(let item of response.products){
//             let result;
//             result = '<div class="card" style="width: 18rem;">';
//             result += ' <img src="' + item.thumbnail +'" class="card-img-top" alt="...">';
//             result += '<div class="card-body">';
//             result += '<h5 class="card-title">'+ item.title +'</h5>'
//             result += '<p class="card-text">' + item.description +'</p>'
//             result += '<a href="#" class="btn btn-primary detail" data-product-id="'+ item.id+ '">'+ item.price +'$</a>'
//             result += '</div>'
//             result += '</div>'
//             $('#productList').append(result);
//         }
//         console.log(typeof(response));
//         response = JSON.stringify(response);
//         console.log(typeof(response));
//         response = JSON.parse(response);
//         console.log(typeof(response));
//     })
// }
// getProductLists();

$('#productList').on('click','.detail',(e)=>{
    console.log($(e.target).attr('data-product-id'))
})
