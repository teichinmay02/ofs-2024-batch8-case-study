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



class AboutViewModel {

  email : ko.Observable<string> | ko.Observable<any>;
  password : ko.Observable<string> | ko.Observable<any>;
  
  URL = "http://localhost:8080/login/authenticate";

  constructor() {

    this.email = ko.observable(null);
    this.password = ko.observable(null);
  }

  public handleClick = async () => {
    let rowData = 
    {
      email : this.email(),
      password : this.password()
    };
    const row = JSON.stringify(rowData);
    console.log(row);

    

    // const request = new Request(this.URL, {
    //   headers: new Headers({
    //     "Content-type": "application/json; charset=UTF-8",
    //   }),
    //   body: row,
    //   method: "POST",
    // });

    try {
      const response = await fetch(this.URL, {
        headers: new Headers({
          "Content-Type": "application/json; charset=UTF-8",
        }),
        body: JSON.stringify(rowData),
        method: "POST",
      });

      if (!response.ok) {
        throw new Error('Network response was not ok ' + response.statusText);
      }

      const result = await response.json();
      console.log("Login successful:", result);
      
      // Handle successful login, e.g., store session, redirect, etc.
      alert("Login successful");
      window.location.href = "http://localhost:8000/?ojr=about";
    } catch (error) {
      console.error("Error during login:", error);
      alert("Login failed. Please check your credentials.");
    }
  };

}

export = AboutViewModel;