declare class JQueryXHR extends JQueryPromise<any> implements XMLHttpRequest {
    overrideMimeType(mimeType: string): any;
    abort(statusText?: string): void;
}
