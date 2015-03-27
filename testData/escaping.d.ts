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
    export module "as" {
        var _;
    }
    export module "break" {
        var _;
    }
    export module "class" {
        var _;
    }
    export module "continue" {
        var _;
    }
    export module "do" {
        var _;
    }
    export module "else" {
        var _;
    }
    export module "false" {
        var _;
    }
    export module "for" {
        var _;
    }
    export module "fun" {
        var _;
    }
    export module "if" {
        var _;
    }
    export module "in" {
        var _;
    }
    export module "is" {
        var _;
    }
    export module "null" {
        var _;
    }
    export module "object" {
        var _;
    }
    export module "package" {
        var _;
    }
    export module "return" {
        var _;
    }
    export module "super" {
        var _;
    }
    export module "this" {
        var _;
    }
    export module "This" {
        var _;
    }
    export module "throw" {
        var _;
    }
    export module "trait" {
        var _;
    }
    export module "true" {
        var _;
    }
    export module "try" {
        var _;
    }
    export module "typealias" {
        var _;
    }
    export module "val" {
        var _;
    }
    export module "var" {
        var _;
    }
    export module "when" {
        var _;
    }
    export module "while" {
        var _;
    }
}

// val var is as trait package object when typealias fun in This
// contains any of: $ \s
