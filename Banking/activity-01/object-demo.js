import { question } from "readline-sync";
import { Employee } from "./employee.js";
import fs from 'fs';
import readline from "readline-sync";


let emp1Id = readline.question("Enter Id : ");
let emp1Name = readline.question("Enter Name : ");
let emp1Salary = readline.question("Enter Salary : ");

let emp1 = new Employee(emp1Id,emp1Name,emp1Salary);
emp1.display();

const employeeData = {
    id: emp1.id,
    name: emp1.name,
    salary: emp1.salary
  };


  const appendToJsonFile = (filePath, newData) => {
    fs.readFile(filePath, (err, data) => {
      let existingEmployees = [];
  
      if (!err) {
        existingEmployees = JSON.parse(data);
      }
  
      const updatedEmployees = existingEmployees.concat(newData);
  
      fs.writeFile(filePath, JSON.stringify(updatedEmployees, null, 2), (err) => {
        if (err) {
          console.error('Error writing to file:', err);
        } else {
          console.log('Employee data saved to employees.json');
        }
      });
    });
  };
appendToJsonFile('employees.json', employeeData);