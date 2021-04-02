let price;
let currency;

 getPrice=(event)=> {
    price = event.target.value;
}

conversion=>(event)=>{
    var html;
    currency = event.target.value;
    if (currency == "Yen") {
        let priceInYen = price * 1.51;
        html = "¥" + priceInYen;
    } else if (currency == "Dollar") {
        let priceInDollar = price * 0.0136631;
        html = "$" + priceInDollar;
    }
}

 generatePass=>()=>{
    alert("Successfully generated pass");
    location.reload();
}