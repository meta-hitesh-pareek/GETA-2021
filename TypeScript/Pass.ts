let price;
let currency;
export let allTickets: Pass[] = [];

export class Pass {

    total: number;
    empId: number;
    passNumber: number;

    constructor(passNumber: number) {
        this.passNumber = passNumber;
    }

    getPrice = (event) => {
        price = event.target.value;
        alert(`you choose ${price}`)
    }

    conversion = function (event) {
        let html;
        currency = event.target.value;
        if (currency == "Yen") {
            let priceInYen = price * 1.51;
            html = "¥" + priceInYen;
        } else if (currency == "Dollar") {
            let priceInDollar = price * 0.0136631;
            html = "$" + priceInDollar;
        }
    }

    generatePass = function () {
        allTickets.push(new Pass(Math.random()));
        this.total = price;
        alert("Successfully generated pass");
        location.reload();
    }
}