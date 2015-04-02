// based on node-fibers.d.ts
interface Fiber_ {
    reset: () => any;
    run: (param?: any) => any;
    throwInto: (ex: any) => any;
}

declare module "fibers" {

    function Fiber(fn: Function): Fiber_;

    module Fiber {
        export var current: Fiber_;
        export function yield(value?: any): any
    }

    export = Fiber;
}
