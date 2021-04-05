export { };
let vehicleDetails = {};
let allVehicles = [];

export class Vehicle {
  company: string;
  type: string;
  number: string;
  empId: number;
  identification: string;

  constructor() {
    this.company;
    this.type;
    this.number;
    this.empId;
    this.identification;
  }
  closeVehicle = () => {

    allVehicles.push(vehicleDetails);
    document.getElementById("vehicle-form").classList.add("collapsed");
    document.getElementById("identification").classList.add("collapsed");
    document.getElementById("vehicle-head").innerHTML =
      "Employee id: " + vehicleDetails["empId"];

    let vehicleTypes = document.getElementById("vehicles").children;
    for (let i in vehicleTypes) {
      console.log(vehicleTypes[i].id, vehicleDetails["type"])
      if (vehicleTypes[i].id == vehicleDetails["type"]) {
        vehicleTypes[i].classList.add("d-flex");
        break;
      }
    }
    document.getElementById("pricing").classList.remove("collapsed")
  }
  submitOnEnter = (event) => {
    if (event.which === 13 && !event.shiftKey) {
      vehicleDetails[event.target.id] = event.target.value;
      document.getElementById("identification").classList.add("collapsed");
      this.closeVehicle();
    }
  }
  getVehicleValue = (event) => {
    if (event.target.id == "company") {
      vehicleDetails[event.target.id] = event.target.value;
      document.getElementById("company").classList.add("collapsed");
      document.getElementById("type").classList.remove("collapsed");
      document.getElementById("vehicle-head").innerHTML =
        "Which vehicle do you have ?";
    } else if (event.target.id == "type") {
      if (event.target.value != "") {
        vehicleDetails[event.target.id] = event.target.value;
        document.getElementById("type").classList.add("collapsed");
        document.getElementById("number").classList.remove("collapsed");
        document.getElementById("vehicle-head").innerHTML =
          "Enter vehicle number ";
        document.getElementById("number").focus();
      }
    } else if (event.target.id == "number") {

      vehicleDetails[event.target.id] = event.target.value;
      document.getElementById("number").classList.add("collapsed");
      document.getElementById("empId").classList.remove("collapsed");
      document.getElementById("vehicle-head").innerHTML =
        "Enter employee id ";
      document.getElementById("empId").focus();

    } else if (event.target.id == "empId") {

      vehicleDetails[event.target.id] = event.target.value;
      document.getElementById("empId").classList.add("collapsed");
      document.getElementById("identification").classList.remove("collapsed");
      document.getElementById("vehicle-head").innerHTML =
        "Enter vehicle identification ";
      document.getElementById("identification").focus();
    } else if (event.target.id == "identification") {
      this.submitOnEnter(event);
    }
  }
}