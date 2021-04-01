var employeeDetailsDict = {};
var registrationNumber = 1000 + Object.keys(allemployees).length;


function verifyName(name) {
  var re = /\d/;
  if (!re.test(name) && name.length > 2) return true;
  else return false;
}

function verifyEmail(email) {
  var re = /^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
  return re.test(email);
}

function verifyPassword(password) {
  var re = /^([a-zA-Z0-9@*#]{8,})$/;
  return re.test(password);
}

function ConfirmPassword(password) {
  if (password === employeeDetailsDict["password"]) return true;
  return false;
}

function verifyPhone(phone) {
  var re = /^([1-9]{1})([0-9]{1})([0-9]{6,})$/;
  return re.test(phone);
}

function getEmployeeValue(event) {
  event.preventDefault();
  if (event.target.id == "Name") {
    if (verifyName(event.target.value)) {
      employeeDetailsDict[event.target.id] = event.target.value;
      document.getElementById("Name").classList.add("collapsed");
      document.getElementById("gender").classList.remove("collapsed");
      document.getElementById("employee-head").innerHTML =
        "Hi " +
        employeeDetailsDict["Name"] +
        ", Please select your gender: <br><br>";
    } else {
      document.getElementById("employee-head").innerHTML =
        "Hi, Please enter valid name <br><br>";
    }
  } else if (event.target.name == "gender") {
    if (document.getElementById("male").checked) {
      employeeDetailsDict[event.target.name] = "male";
    } else if (document.getElementById("female").checked) {
      employeeDetailsDict[event.target.name] = "female";
    } else if (document.getElementById("other").checked) {
      employeeDetailsDict[event.target.name] = "other";
    }
    document.getElementById("gender").classList.add("collapsed");
    document.getElementById("email").classList.remove("collapsed");
    document.getElementById("email").focus();
    document.getElementById("employee-head").innerHTML =
      "Hi " + employeeDetailsDict["Name"] + ", Please enter email: <br><br>";
  } else if (event.target.id == "email") {
    if (verifyEmail(event.target.value)) {
      console.log("");
      employeeDetailsDict[event.target.id] = event.target.value;
      document.getElementById("email").classList.add("collapsed");
      document.getElementById("password").classList.remove("collapsed");
      document.getElementById("password").focus();
      document.getElementById("employee-head").innerHTML =
        "Hi " +
        employeeDetailsDict["Name"] +
        ", Please enter password: <br><br>";
    } else {
      document.getElementById("employee-head").innerHTML =
        "Hi" +
        employeeDetailsDict["Name"] +
        ", Please enter valid email <br><br>";
    }
  } else if (event.target.id == "password") {
    if (verifyPassword(event.target.value)) {
      employeeDetailsDict[event.target.id] = event.target.value;
      document.getElementById("password").classList.add("collapsed");
      document
        .getElementById("confirm_password")
        .classList.remove("collapsed");
      document.getElementById("confirm_password").focus();
      document.getElementById("employee-head").innerHTML =
        "Hi " +
        employeeDetailsDict["Name"] +
        ", Please confirm password: <br><br>";
    } else {
      document.getElementById("employee-head").innerHTML =
        "Hi" +
        employeeDetailsDict["Name"] +
        ",Please enter a strong password <br><br>";
    }
  } else if (event.target.id == "confirm_password") {
    if (ConfirmPassword(event.target.value)) {
      employeeDetailsDict[event.target.id] = event.target.value;
      document.getElementById("confirm_password").classList.add("collapsed");
      document.getElementById("phone").classList.remove("collapsed");
      document.getElementById("phone").focus();
      document.getElementById("employee-head").innerHTML =
        "Hi " +
        employeeDetailsDict["Name"] +
        ", Please enter your phone number: <br><br>";
    } else {
      document.getElementById("employee-head").innerHTML =
        "Hi" +
        employeeDetailsDict["Name"] +
        ",your password mismathced, please try again <br><br>";
    }
  } else if (event.target.id == "phone") {
    if (verifyPhone(event.target.value)) {
      employeeDetailsDict[event.target.id] = event.target.value;
      document.getElementById("phone").classList.add("collapsed");
      closeEmployee();
    } else {
      document.getElementById("employee-head").innerHTML =
        "Hi" +
        employeeDetailsDict["Name"] +
        ",enter correct phone number, please try again <br><br>";
    }
  }

  // console.log(employeeDetailsDict);
}
