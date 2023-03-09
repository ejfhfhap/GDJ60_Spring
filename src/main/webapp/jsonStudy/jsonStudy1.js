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


let getProductLists = ()=> {
    let result = $.get('https://dummyjson.com/products',await,(response)=>{
        let result;
        for(let item of response.products){
            console.log(item);
            result = '<div class="card" style="width: 18rem;">';
            result += ' <img src="' + item.thumbnail +'" class="card-img-top" alt="...">';
            result += '<div class="card-body">';
            result += '<h5 class="card-title">'+ item.title +'</h5>'
            result += '<p class="card-text">' + item.description +'</p>'
            result += '<a href="#" class="btn btn-primary detail" data-product-id="'+ item.id+ '">'+ item.price +'$</a>'
            result += '</div>'
            result += '</div>'
        }
        console.log(result);
        return result;
    })
    console.log(result);
    return result;
}
$('#productList').append(getProductLists());

$('#productList').on('click','.detail',(e)=>{
    console.log($(e.target).attr('data-product-id'))
})
