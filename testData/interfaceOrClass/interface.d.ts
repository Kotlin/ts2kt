interface JQueryAjaxSettings {
    optionalVarAsAny?: any;
    optionalVarAsBool?: boolean;
    optionalFunction? (jqXHR: string, settings: JQueryAjaxSettings): any;
    varAsAny: any;
    varAsBool: boolean;
    method0 ();
    method1 (jqXHR: string): string;
    method2 (jqXHR: string, settings: JQueryAjaxSettings): boolean;
}