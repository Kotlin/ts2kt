/// <reference path="../../testDefinitelyTyped/DefinitelyTyped/jquery/jquery.d.ts" />

interface JQuery {
    foo()
    bar
}

interface JQueryStatic {
    [prop: string]: number;
    someField: string;
    optionalField?: any;
    (resourceId:string, hash?:any, callback?:Function): void;
}

