let vehicleDetails = {};
class Vehicle {

  constructor() {
    this.company;
    this.type;
    this.number;
    this.empId;
    this.identification;
  }
  submitOnEnter = (event) => {
    if (event.which === 13 && !event.shiftKey) {
      vehicleDetails[event.target.id] = event.target.value;
      document.getElementById("identification").classList.add("collapsed");
      closeVehicle();
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