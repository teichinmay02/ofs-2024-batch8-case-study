/**
 * @license
 * Copyright (c) 2014, 2024, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */


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
import "oj-c/button";  
import "knockout";
import "ojs/ojknockout";
import { whenDocumentReady } from 'ojs/ojbootstrap';
import { MessageBannerItem, MessageBannerElement } from 'ojs/ojmessagebanner';
import MutableArrayDataProvider = require('ojs/ojmutablearraydataprovider');
import ArrayDataProvider = require("ojs/ojarraydataprovider");
import { RESTDataProvider } from 'ojs/ojrestdataprovider';
import 'ojs/ojformlayout';
import 'ojs/ojinputtext';
import 'ojs/ojknockout';
import 'ojs/ojmessagebanner';
import 'ojs/ojbutton';
import "ojs/ojswitch";

import "ojs/ojknockout";
import "ojs/ojcheckboxset";
import "ojs/ojlabel";
import "ojs/ojformlayout";



  import { ojDialog } from "ojs/ojdialog";
  import { ojButtonEventMap } from "ojs/ojbutton";

// type D = {
//   "custId":number,"firstName":string,"middleName":string,"lastName":string,
//   "gender":string,"dob":string,"martialStatus":string,"income":number,
//   "occupation":string, "cibilScore":number, "mobileNo":number, "email":string,
//   "address":string,"status":boolean}




class CustomersViewModel {

  custId : ko.Observable<string> | ko.Observable<any>;
  firstName : ko.Observable<string> | ko.Observable<any>;
  middleName : ko.Observable<string> | ko.Observable<any>;
  lastName : ko.Observable<string> | ko.Observable<any>;
  gender : ko.Observable<string> | ko.Observable<any>;
  dob : ko.Observable<string> | ko.Observable<any>;
  maritalStatus : ko.Observable<string> | ko.Observable<any>;
  income : ko.Observable<number> | ko.Observable<any>;
  occupation : ko.Observable<string> | ko.Observable<any>;
  cibilScore : ko.Observable<number> | ko.Observable<any>;
  mobileNo : ko.Observable<number> | ko.Observable<any>;
  email : ko.Observable<string> | ko.Observable<any>;
  address : ko.Observable<string> | ko.Observable<any>;
  status : ko.Observable<boolean> | ko.Observable<any>;


  URL = "http://localhost:8080/customers/adddata";
  constructor() 
  {
    this.custId = ko.observable(null);
    this.firstName = ko.observable(null);
    this.middleName = ko.observable(null);
    this.lastName = ko.observable(null);
    this.gender = ko.observable(null);
    this.dob = ko.observable(null);
    this.maritalStatus = ko.observable(null);
    this.income = ko.observable(null);
    this.occupation = ko.observable(null);
    this.cibilScore = ko.observable(null);
    this.mobileNo = ko.observable(null);
    this.email = ko.observable(null);
    this.address = ko.observable(null);
    this.status = ko.observable(null);
  }


   public handleClick = async () => {
    let rowData = 
    {
      custId : this.custId(),
      firstName : this.firstName(),
      middleName : this.middleName(),
      lastName : this.lastName(),
      gender : this.gender(),
      dob : this.dob(),
      maritalStatus : this.maritalStatus(),
      income : this.income(),
      occupation : this.occupation(),
      cibilScore : this.cibilScore(),
      mobileNo : this.mobileNo(),
      email : this.email(),
      address : this.address(),
      status : false
    };
    const row = JSON.stringify(rowData);
    console.log(row);

    

    const request = new Request(this.URL, {
      headers: new Headers({
        "Content-type": "application/json; charset=UTF-8",
      }),
      body: row,
      method: "POST",
    });


    try 
    {
      const response = await fetch(request);
      console.log('request is initalized');
      const addedCustomer = await response.json();
      console.log('reponse is initialized');
      console.log("Customer added:", addedCustomer);
      alert("data added");
      window.location.href = "http://localhost:8000/?ojr=about";
    } catch (error) {
      console.error("Error adding customer:", error);
    }
  };



}

export = CustomersViewModel;
