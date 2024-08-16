
/**
 * @license
 * Copyright (c) 2014, 2024, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */
// import "ojs/ojknockout";
import * as AccUtils from "../accUtils";
import * as ko from "knockout";
import "oj-c/input-text";
import "ojs/ojknockout";
import "oj-c/input-number";
import * as Bootstrap from "ojs/ojbootstrap";
import Message = require("ojs/ojmessaging");
import 'oj-c/input-password';
import "ojs/ojlabel";
import "ojs/ojformlayout";
import "ojs/ojdatetimepicker";
import { IntlConverterUtils } from "ojs/ojconverterutils-i18n";
import "ojs/ojslider";
import "ojs/ojswitch";


class DashboardViewModel 
{
  firstName: ko.Observable<string> | ko.Observable<any>;
  salary : ko.Observable<number> | ko.Observable<any>;
  error: Message[];
  warning: Message[];
  info: Message[];
  confirmation: Message[];
  password: ko.Observable<string> | ko.Observable<any>;
  cpassword: ko.Observable<string> | ko.Observable<any>;
  datetime : ko.Observable<string> | ko.Observable<any>;
  exp : ko.Observable<number> | ko.Observable<any>;
  // password: ko.Observable<string> | ko.Observable<any>;
  
  constructor() 
  {
    this.firstName = ko.observable(null);
    this.salary = ko.observable(null);
    // this.password = ko.observable(null);
    this.error = [{ summary: "summary", detail: "detail", severity: "error" }];
    this.warning = [
      { summary: "summary", detail: "detail", severity: "warning" },
    ];
    this.info = [{ summary: "summary", detail: "detail", severity: "info" }];
    this.confirmation = [
      { summary: "summary", detail: "detail", severity: "confirmation" },
    ];

    this.password = ko.observable(null);
    this.cpassword = ko.observable(null);
    this.datetime = ko.observable(
      IntlConverterUtils.dateToLocalIso(new Date(2024, 7, 16))
    );
    this.exp = ko.observable(0);
    
  }

  getSliderValue(): number {
    return this.exp(); // Access the current value of the slider
  }
}


const viewModel = new DashboardViewModel();
console.log("Current slider value:", viewModel.getSliderValue());


Bootstrap.whenDocumentReady().then(() => {
  ko.applyBindings(new DashboardViewModel(), document.getElementById("div1"));
});


export = DashboardViewModel;