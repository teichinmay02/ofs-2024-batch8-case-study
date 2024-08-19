import * as ko from 'knockout';
import "oj-c/input-text";
import 'oj-c/input-number';
import 'oj-c/input-password';
import 'oj-c/form-layout';
import "oj-c/button";
import "ojs/ojselectsingle";
import ArrayDataProvider = require("ojs/ojarraydataprovider");
import "ojs/ojknockout";
import { whenDocumentReady } from "ojs/ojbootstrap";

type Customer = {
    firstName: string;
    lastName: string;
    email: string;
    gender: string;
    mobile: number;
    address: string;
    pan: string;
    aadhar: number;
    loginId: string;
    password: string;
    age: number;
};

class aboutViewModel {
    readonly selectVal = ko.observable('Male');
    private readonly browsers = [
        { value: "Male", label: "Male" },
        { value: "Female", label: "Female" },
        { value: "Others", label: "Transgender" },
        { value: "Others", label: "Non-Binary" },
        { value: "Others", label: "Others" },
    ];
    readonly browsersDP = new ArrayDataProvider(this.browsers, {
        keyAttributes: "value",
    });
    // Observables for user input
    inputFirstName = ko.observable<string>("");
    inputLastName = ko.observable<string>("");
    inputEmail = ko.observable<string>("");
    inputMobile = ko.observable<number | null>(null);
    inputAddress = ko.observable<string>("");
    inputPan = ko.observable<string>("");
    inputAadhar = ko.observable<number | null>(null);
    inputLoginId = ko.observable<string>("");
    inputPassword = ko.observable<string>("");
    inputAge = ko.observable<number | null>(null);

    // API URL
    private apiUrl = "http://localhost:8080/customerapi/customers";

    // Method to handle form submission
    addRow = async () => {
        // Create the customer object from input observables
        const customer: Customer = {
            firstName: this.inputFirstName(),
            lastName: this.inputLastName(),
            email: this.inputEmail(),
            gender: this.selectVal(),
            mobile: this.inputMobile() ?? 0, // Default to 0 if null
            address: this.inputAddress(),
            pan: this.inputPan(),
            aadhar: this.inputAadhar() ?? 0, // Default to 0 if null
            loginId: this.inputLoginId(),
            password: this.inputPassword(),
            age: this.inputAge() ?? 0, // Default to 0 if null
        };

        // Create and send request to REST service to add the customer
        const request = new Request(this.apiUrl, {
            headers: new Headers({
                "Content-Type": "application/json; charset=UTF-8",
            }),
            body: JSON.stringify(customer),
            method: "POST",
        });

        try {
            const response = await fetch(request);
            if (!response.ok) throw new Error("Network response was not ok.");
            const addedCustomer = await response.json();
            console.log("Customer added:", addedCustomer);
            // Clear input fields after adding
            this.clearInputs();
            window.location.href = "http://localhost:8000/?ojr=incidents";
        } catch (error) {
            console.error("Error adding customer:", error);
        }
    };

    // Method to check if the form is valid
    isFormValid = ko.pureComputed(() => {
        const valid = this.inputFirstName().trim() !== "" &&
            this.inputLastName().trim() !== "" &&
            this.inputEmail().trim() !== "" &&
            this.selectVal().trim() !== "" &&
            this.inputMobile() !== 0 &&
            this.inputAddress().trim() !== "" &&
            this.inputPan().trim() !== "" &&
            this.inputAadhar() !== 0 &&
            this.inputLoginId().trim() !== "" &&
            this.inputPassword().trim() !== "" &&
            this.inputAge() !== 0;
        console.log("Form Valid:", valid);
        return valid;
    });

    // Method to clear all input fields
    clearInputs = () => {
        this.inputFirstName("");
        this.inputLastName("");
        this.inputEmail("");
        this.selectVal("");
        this.inputMobile(null);
        this.inputAddress("");
        this.inputPan("");
        this.inputAadhar(null);
        this.inputLoginId("");
        this.inputPassword("");
        this.inputAge(null);
    };
}

// Initialize ViewModel and apply bindings
// ko.applyBindings(new aboutViewModel());
whenDocumentReady().then(() => {
    ko.applyBindings(new aboutViewModel(), document.getElementById("div1"));
});
export = aboutViewModel;