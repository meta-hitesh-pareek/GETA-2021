

/* Question 1*/
CREATE DATABASE zipcode;
use zipcode;

CREATE TABLE states(
    state_number int primary key auto_increment,
    state_name varchar(100) not null unique
);

CREATE TABLE cities(
    city_no int primary key auto_increment,
    city_name varchar(100),
    state_number int not null,
    foreign key (state_number)
        references states (state_number)
);

CREATE TABLE zipcodes(
    zipcode int primary key not null,
    city_no int not null,
    foreign key (city_no)
        references cities (city_no)
);

INSERT INTOstates(state_name) VALUES ("Rajasthan");
INSERT INTOstates(state_name) VALUES ("Bihar");
INSERT INTOstates(state_name) VALUES ("Hariyana");
INSERT INTOstates(state_name) VALUES ("UP");
INSERT INTOstates(state_name) VALUES ("Maharashtra");

INSERT INTOcities(city_name,state_number) VALUES("Jaipur",1);
INSERT INTOcities(city_name,state_number) VALUES("Patna",2);
INSERT INTOcities(city_name,state_number) VALUES("Aakhera",3);
INSERT INTOcities(city_name,state_number) VALUES("Luckhnow",4);
INSERT INTOcities(city_name,state_number) VALUES("Mumbai",5);

INSERT INTOzipcodes VALUES(302019,1);
INSERT INTOzipcodes VALUES(302349,2);
INSERT INTOzipcodes VALUES(343339,3);
INSERT INTOzipcodes VALUES(346349,4);
INSERT INTOzipcodes VALUES(345649,5);


SELECT
    zipcodes.zipcode, states.state_name, cities.city_name
FROM
    zipcodes
        JOIN
    cities ON zipcodes.city_no = cities.city_no
        JOIN
    states ON states.state_number = cities.state_number;
