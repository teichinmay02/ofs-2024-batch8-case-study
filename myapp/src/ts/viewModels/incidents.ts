/**
 * @license
 * Copyright (c) 2014, 2024, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */
import * as AccUtils from "../accUtils";
import * as ko from 'knockout';
import { RESTDataProvider } from 'ojs/ojrestdataprovider';
import 'ojs/ojknockout';
import 'ojs/ojtable';

type D = {"custId":number,"firstName":string,"lastName":string}
type K = D["custId"];
//type K = "id"
class IncidentsViewModel 
{
  dataprovider : RESTDataProvider<K,D>;
  constructor()
  {
    this.dataprovider = new RESTDataProvider({
      keyAttributes : 'id',
      url : 'http://localhost:8080/customers',
      transforms :{
        fetchFirst : {
        request : async (options) => {
          const url = new URL(options.url);
          return new Request(url.href);
        },
        response : async ({body}) => {
          let data = body;
          console.log(data);
          return {data};
        }
        }
      }
    });
  }
}

export = IncidentsViewModel;
