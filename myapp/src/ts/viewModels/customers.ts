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

type D = {
  "custId":number,"firstName":string,"middleName":string,"lastName":string,
  "gender":string,"dob":string,"martialStatus":string,"income":number,
  "occupation":string, "cibilScore":number, "mobileNo":number, "email":string,
  "address":string,"status":boolean}
type K = D["custId"];


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


   public handleClick = async (event: Event) => {
    const row = 
    {
      custId : this.custId(),
      firstName : this.firstName(),
      middleName : this.middleName(),
      lastName : this.lastName(),
      gender : this.gender(),
      dob : this.dob(),
      martialStatus : this.maritalStatus(),
      income : this.income(),
      occupation : this.occupation(),
      cibilScore : this.cibilScore(),
      mobileNo : this.mobileNo(),
      email : this.email(),
      address : this.address(),
      status : false
    };
    console.log(row);


    // this.clickedButton((event.currentTarget as HTMLElement).id);
    // return true;
    // let elementName = (event.currentTarget as HTMLElement).tagName;
    // // alert("Congrats "+elementName+",\nYour Name : "+this.firstName()+"\nYour Salary : "+this.salary()+"\ndate and time : "+this.datetime()+"\npassword : "+this.password()+"\nare you human : "+this.human()+"\nyour experience : "+this.exp());
    
    // let id = parseInt(this.firstName());
    // let URL = 'https://jsonplaceholder.typicode.com/users/'+id;
    // let res = await fetch(URL);
    // let jsonData = await res.json();
    // //display name, username, email, street, suite in the web page body
    // console.log(jsonData);
    // let { name, username, email, address, phone, website, company } = jsonData;
    // let { street, suite } = address;

    // let displayData = `
    //     Name : ${name}<br>
    //     Username : ${username}<br>
    //     Email : ${email}<br>
    //     Street : ${street}, <br>
    //     Suite : ${suite} <br>
    //     Phone: ${phone} <br>
    //     website: ${website} <br>

    // `;
    // let userInfoDiv = document.getElementById('user-info');
    // if (userInfoDiv) {
    //     userInfoDiv.innerHTML = displayData;
    // }
  };


}

export = CustomersViewModel;
