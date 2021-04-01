var price;
var currency;

function getPrice(event){
    price = event.target.value;
}

function conversion(event){
    var html;
    currency = event.target.value;
    if(currency == "Yen"){
        var priceInYen = price * 1.51;
        html = "¥" + priceInYen;
    }else if(currency == "Dollar"){
        var priceInDollar = price * 0.0136631;
        html = "$" + priceInDollar;
    }
    
}
function generatePass(){
    alert("Successfully generated pass");
    location.reload();
}