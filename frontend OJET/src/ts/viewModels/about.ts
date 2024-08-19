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

import "oj-c/progress-bar";


  import { ojDialog } from "ojs/ojdialog";
  import { ojButtonEventMap } from "ojs/ojbutton";



class AboutViewModel {
  private readonly step = ko.observable(0);
  readonly progressValue = ko.pureComputed(() => {
    return Math.min(this.step(), 100);
  });
  email : ko.Observable<string> | ko.Observable<any>;
  password : ko.Observable<string> | ko.Observable<any>;
  //http://localhost:8080/login/authenticate?email=riz.lala@oracle.com&password=Jane_112
  

  constructor() {

    this.email = ko.observable(null);
    this.password = ko.observable(null);
    window.setInterval(() => {
      this.step((this.step() + 1) % 200);
    }, 30);
  }


  public handleClick = async () => {
 

    const email = this.email();
    const password = this.password();
    console.log(email);
    console.log(password);
    
    const URL = `http://localhost:8080/login/authenticate?email=${email}&password=${password}`;
    console.log(URL);

    fetch(URL)
    .then(response => {
      if (response.ok) {
          console.log("done login");
      }
      else
      {
        throw new Error('Network response was not ok');
      }
      
    })
    .then(data => {
      alert("suceess")
      console.log('Success:', data);
      window.location.href="http://localhost:8000/?ojr=incidents";
    })
    .catch(error => {
      console.error('Error:', error);
    });

    // try {
      
    // const response = await fetch(URL);
    // if (!response.ok) {
    //   throw new Error(`Response status: ${response.status}`);
    // }

    // const json = await response.json();
    // console.log(json);
    // } catch (error) {
    //   console.error(error);
    // }
    
  };

}

export = AboutViewModel;