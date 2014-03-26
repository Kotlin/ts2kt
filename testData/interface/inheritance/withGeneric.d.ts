interface JQueryXHR extends XMLHttpRequest, JQueryPromise<any> {
    overrideMimeType(mimeType: string): any;
    abort(statusText?: string): void;
}