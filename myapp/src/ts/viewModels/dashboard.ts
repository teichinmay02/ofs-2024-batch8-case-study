
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
  button2Text: string;
  clickedButton: ko.Observable<string>;
  human: ko.Observable<boolean> | ko.Observable<any>;
  city: ko.Observable<string> | ko.Observable<any>;
  email: ko.Observable<string> | ko.Observable<any>;
  phone: ko.Observable<string> | ko.Observable<any>;
  website: ko.Observable<string> | ko.Observable<any>;
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
    this.button2Text = "Button 2";
    this.clickedButton = ko.observable("(None clicked yet)");
    this.human = ko.observable(null);
    this.city = ko.observable(null);
    this.email = ko.observable(null);
    this.phone = ko.observable(null);
    this.website = ko.observable(null);
  }

  public handleClick = async (event: Event) => {
    // this.clickedButton((event.currentTarget as HTMLElement).id);
    // return true;
    let elementName = (event.currentTarget as HTMLElement).tagName;
    //alert("Congrats "+elementName+",\nYour Name : "+this.firstName()+"\nYour Salary : "+this.salary()+"\ndate and time : "+this.datetime()+"\npassword : "+this.password()+"\nare you human : "+this.human()+"\nyour experience : "+this.exp());
    
    let id = parseInt(this.firstName());
    let URL = 'https://jsonplaceholder.typicode.com/users/'+id;
    let res = await fetch(URL);
    let jsonData = await res.json();
    this.firstName(jsonData['name']);
    this.city(jsonData['address']['city']);
    this.email(jsonData['email']);
    this.phone(jsonData['phone']);
    this.website(jsonData['website']);
    //display name, username, email, street, suite in the web page body
    console.log(jsonData);
    let { name, username, email, address, phone, website, company } = jsonData;
    let { street, suite } = address;

    let displayData = `
        Name : ${name}<br>
        Username : ${username}<br>
        Email : ${email}<br>
        Street : ${street}, <br>
        Suite : ${suite} <br>
        Phone: ${phone} <br>
        website: ${website} <br>

    `;
    let userInfoDiv = document.getElementById('user-info');
    if (userInfoDiv) {
        userInfoDiv.innerHTML = displayData;
    }
  };

}



Bootstrap.whenDocumentReady().then(() => {
  ko.applyBindings(new DashboardViewModel(), document.getElementById("div1"));
});


export = DashboardViewModel;