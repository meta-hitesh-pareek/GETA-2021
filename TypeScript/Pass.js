let price;
let currency;
export let allTickets = [];
export class Pass {
    constructor(passNumber) {
        this.getPrice = (event) => {
            price = event.target.value;
            alert(`you choose ${price}`);
        };
        this.conversion = function (event) {
            let html;
            currency = event.target.value;
            if (currency == "Yen") {
                let priceInYen = price * 1.51;
                html = "¥" + priceInYen;
            } else if (currency == "Dollar") {
                let priceInDollar = price * 0.0136631;
                html = "$" + priceInDollar;
            }
        };
        this.generatePass = function () {
            allTickets.push(new Pass(Math.random()));
            this.total = price;
            alert("Successfully generated pass");
            location.reload();
        };
        this.passNumber = passNumber;
    }
}