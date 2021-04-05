let allemployees = {};
let employeeDetailsDict = {};
let registrationNumber = 1000 + Object.keys(allemployees).length;
export class Employee {
    constructor(empid) {
        this.verifyName = (name) => {
            let re = /\d/;
            if (!re.test(name) && name.length > 2)
                return true;
            else
                return false;
        };
        this.verifyEmail = (email) => {
            let re = /^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
            return re.test(email);
        };
        this.verifyPassword = (password) => {
            let re = /^([a-zA-Z0-9@*#]{8,})$/;
            return re.test(password);
        };
        this.ConfirmPassword = (password) => {
            if (password === employeeDetailsDict["password"])
                return true;
            return false;
        };
        this.verifyPhone = (phone) => {
            let re = /^([1-9]{1})([0-9]{1})([0-9]{6,})$/;
            return re.test(phone);
        };
        this.closeEmployee = () => {
            allemployees[registrationNumber] = employeeDetailsDict;
            document.getElementById("employeeForm").classList.add("collapsed");
            document.getElementById("employee-head").innerHTML =
                "Registration number: " + registrationNumber;
            document.getElementById("vehicle-form").classList.remove("collapsed");
            document.getElementById("vehicle-head").innerHTML = "Enter vehicle name ";
            document.getElementById("company").classList.remove("collapsed");
            document.getElementById("company").focus();
        };
        this.getEmployeeValue = (event) => {
            event.preventDefault();
            if (event.target.id == "Name") {
                if (this.verifyName(event.target.value)) {
                    employeeDetailsDict[event.target.id] = event.target.value;
                    document.getElementById("Name").classList.add("collapsed");
                    document.getElementById("gender").classList.remove("collapsed");
                    document.getElementById("employee-head").innerHTML =
                        `HI ${employeeDetailsDict["Name"]} Please select your gender : <br><br>`;
                } else {
                    document.getElementById("employee-head").innerHTML =
                        "Hi, Please enter valid name <br><br>";
                }
            } else if (event.target.name == "gender") {
                if (document.getElementById("male").checked) {
                    employeeDetailsDict[event.target.name] = "male";
                } else if (document.getElementById("male").checked) {
                    employeeDetailsDict[event.target.name] = "female";
                } else if (document.getElementById("male").checked) {
                    employeeDetailsDict[event.target.name] = "other";
                }
                document.getElementById("gender").classList.add("collapsed");
                document.getElementById("email").classList.remove("collapsed");
                document.getElementById("email").focus();
                document.getElementById("employee-head").innerHTML =
                    `Hi ${employeeDetailsDict["Name"]} , Please enter email: <br><br>`;
            } else if (event.target.id == "email") {
                if (this.verifyEmail(event.target.value)) {
                    console.log("");
                    employeeDetailsDict[event.target.id] = event.target.value;
                    document.getElementById("email").classList.add("collapsed");
                    document.getElementById("password").classList.remove("collapsed");
                    document.getElementById("password").focus();
                    document.getElementById("employee-head").innerHTML =
                        `Hi ${employeeDetailsDict["Name"]} , Please enter password: <br><br>`;
                } else {
                    document.getElementById("employee-head").innerHTML =
                        `Hi ${employeeDetailsDict["Name"]} , Please enter valid email: <br><br>`;
                }
            } else if (event.target.id == "password") {
                if (this.verifyPassword(event.target.value)) {
                    employeeDetailsDict[event.target.id] = event.target.value;
                    document.getElementById("password").classList.add("collapsed");
                    document
                        .getElementById("confirm_password")
                        .classList.remove("collapsed");
                    document.getElementById("confirm_password").focus();
                    document.getElementById("employee-head").innerHTML =
                        `Hi ${employeeDetailsDict["Name"]} , Please confirm password: <br><br>`;
                } else {
                    document.getElementById("employee-head").innerHTML =
                        `Hi ${employeeDetailsDict["Name"]} , Please enter  strong password: <br><br>`;
                }
            } else if (event.target.id == "confirm_password") {
                if (this.ConfirmPassword(event.target.value)) {
                    employeeDetailsDict[event.target.id] = event.target.value;
                    document.getElementById("confirm_password").classList.add("collapsed");
                    document.getElementById("phone").classList.remove("collapsed");
                    document.getElementById("phone").focus();
                    document.getElementById("employee-head").innerHTML =
                        `Hi ${employeeDetailsDict["Name"]} , Please enter your phone number: <br><br>`;
                } else {
                    document.getElementById("employee-head").innerHTML =
                        `Hi ${employeeDetailsDict["Name"]} , Your password mismtched please try again <br><br>`;
                }
            } else if (event.target.id == "phone") {
                if (this.verifyPhone(event.target.value)) {
                    employeeDetailsDict[event.target.id] = event.target.value;
                    document.getElementById("phone").classList.add("collapsed");
                    this.closeEmployee();
                } else {
                    document.getElementById("employee-head").innerHTML =
                        `Hi ${employeeDetailsDict["Name"]} , Please enter Correct phone number: <br><br>`;
                }
            }
        };
        this.empid = empid;
        this.name;
        this.gender;
        this.email;
        this.password;
        this.confirm_password;
        this.phone;
    }
}