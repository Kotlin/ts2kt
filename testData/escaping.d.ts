declare var val: any;
//declare var var: boolean;
declare var $foo: boolean;
declare function bar$(ba$z: number);
declare function fun();
interface This {
    when: string;
    typealias: number;
    in(object: Foo);
}
declare class is<trait> {
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

declare module AllKeywords {
    export module "as" {}
    export module "break" {}
    export module "class" {}
    export module "continue" {}
    export module "do" {}
    export module "else" {}
    export module "false" {}
    export module "for" {}
    export module "fun" {}
    export module "if" {}
    export module "in" {}
    export module "is" {}
    export module "null" {}
    export module "object" {}
    export module "package" {}
    export module "return" {}
    export module "super" {}
    export module "this" {}
    export module "This" {}
    export module "throw" {}
    export module "trait" {}
    export module "true" {}
    export module "try" {}
    export module "typealias" {}
    export module "val" {}
    export module "var" {}
    export module "when" {}
    export module "while" {}
}

// val var is as trait package object when typealias fun in This
// contains any of: $ \s
