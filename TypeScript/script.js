let emp;
let vehicle;
let pass;
import {
    Employee
} from './Employee.js';
import {
    Pass
} from './Pass.js';
import {
    Vehicle
} from './Vehicle.js';
const showEmployee = function () {
    if (document.getElementById("employeeForm").classList.contains("collapsed")) {
        document.getElementById("employeeForm").classList.remove("collapsed");
        document.getElementById("Name").classList.remove("collapsed");
        document.getElementById("Name").focus();
        document.getElementById("employee-head").innerHTML =
            "Hi, Please enter your name: <br><br>";
        emp = new Employee(2);
        vehicle = new Vehicle();
        pass = new Pass(Math.random());
    }
};
let startEmployeeProcess = function (event) {
    emp.getEmployeeValue(event);
};
let startVehicleProcess = function (event) {
    vehicle.getVehicleValue(event);
};
let getPrice = function (event) {
    pass.getPrice(event);
};
let conversion = function (event) {
    pass.conversion(event);
};
let generatePass = function () {
    pass.generatePass();
};
document.querySelector("#employee-head").addEventListener("click", showEmployee);
document.querySelector("#Name").addEventListener("change", startEmployeeProcess);
document.querySelector("#male").addEventListener("click", startEmployeeProcess);
document.querySelector("#female").addEventListener("click", startEmployeeProcess);
document.querySelector("#other").addEventListener("change", startEmployeeProcess);
document.querySelector("#email").addEventListener("change", startEmployeeProcess);
document.querySelector("#password").addEventListener("change", startEmployeeProcess);
document.querySelector("#confirm_password").addEventListener("change", startEmployeeProcess);
document.querySelector("#phone").addEventListener("change", startEmployeeProcess);
document.querySelector("#company").addEventListener("change", startVehicleProcess);
document.querySelector("#empId").addEventListener("change", startVehicleProcess);
document.querySelector("#number").addEventListener("change", startVehicleProcess);
document.querySelector("#type").addEventListener("change", startVehicleProcess);
document.querySelector("#identification").addEventListener("keypress", startVehicleProcess);
document.querySelector("#cyclePrice").addEventListener("change", getPrice);
document.querySelector("#cyclePrice").addEventListener("change", getPrice);
document.querySelector("#currency").addEventListener("change", conversion);
document.querySelector(".purchaseButton").addEventListener("click", generatePass);