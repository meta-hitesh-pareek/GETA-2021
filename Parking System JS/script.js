var allemployees = {};
var allVehicles = [];

function showEmployee() {
  if (document.getElementById("employeeForm").classList.contains("collapsed")) {
    document.getElementById("employeeForm").classList.remove("collapsed");
    document.getElementById("Name").classList.remove("collapsed");
    document.getElementById("Name").focus();
    document.getElementById("employee-head").innerHTML =
      "Hi, Please enter your name: <br><br>";
  }
}

function closeEmployee() {
  allemployees[registrationNumber] = employeeDetailsDict;
  document.getElementById("employeeForm").classList.add("collapsed");
  document.getElementById("employee-head").innerHTML =
    "Registration number: " + registrationNumber;
  document.getElementById("vehicle-form").classList.remove("collapsed");
  document.getElementById("vehicle-head").innerHTML = "Enter vehicle name ";
  document.getElementById("company").classList.remove("collapsed");
  document.getElementById("company").focus();
}

function closeVehicle() {

  allVehicles.push(vehicleDetails);
  document.getElementById("vehicle-form").classList.add("collapsed");
  document.getElementById("identification").classList.add("collapsed");
  document.getElementById("vehicle-head").innerHTML =
    "Employee id: " + vehicleDetails["empId"];
  
  var vehicleTypes = document.getElementById("vehicles").children;
  for(i in vehicleTypes ){
    console.log(vehicleTypes[i].id , vehicleDetails["type"])
    if(vehicleTypes[i].id == vehicleDetails["type"]){
      vehicleTypes[i].classList.add("d-flex");
      break;
    }
  }
  document.getElementById("pricing").classList.remove("collapsed")
}
