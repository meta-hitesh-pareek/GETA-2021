let allemployees = {};
let allVehicles = [];
let emp;

const showEmployee = () => {
  if (document.getElementById("employeeForm").classList.contains("collapsed")) {
    document.getElementById("employeeForm").classList.remove("collapsed");
    document.getElementById("Name").classList.remove("collapsed");
    document.getElementById("Name").focus();
    document.getElementById("employee-head").innerHTML =
      "Hi, Please enter your name: <br><br>";
    emp = new Employee(2);
    vehicle = new Vehicle();
  }
};

const closeVehicle = () => {

  allVehicles.push(vehicleDetails);
  document.getElementById("vehicle-form").classList.add("collapsed");
  document.getElementById("identification").classList.add("collapsed");
  document.getElementById("vehicle-head").innerHTML =
    "Employee id: " + vehicleDetails["empId"];

  let vehicleTypes = document.getElementById("vehicles").children;
  for (i in vehicleTypes) {
    console.log(vehicleTypes[i].id, vehicleDetails["type"])
    if (vehicleTypes[i].id == vehicleDetails["type"]) {
      vehicleTypes[i].classList.add("d-flex");
      break;
    }
  }
  document.getElementById("pricing").classList.remove("collapsed")
}

const startEmployeeProcess = (event) => {
  emp.getEmployeeValue(event);
};

const startVehicleProcess = (event) => {
  vehicle.getVehicleValue(event);
}