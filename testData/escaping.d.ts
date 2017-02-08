declare var val: any;
// declare var var: boolean;
declare var $foo: boolean;
declare function bar$(ba$z: number);
declare function fun();
interface This {
    when: string;
    typealias: number;
    typeof: number;
    in(object: Foo);
}
declare class is<interface> {
    as: number;
    package(a): boolean;
}

declare module "This" {
    export var $foo: boolean;
    export function bar$(ba$z: number);
}

declare module when {
    export var $: boolean;
    export function package(as: number): $tring;
}

// val var is as interface package object when typealias fun in This
// contains any of: $ \s
