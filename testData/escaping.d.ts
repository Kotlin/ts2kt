declare var val: any;
//declare var var: boolean;
declare var $foo: boolean;
declare function bar$ (ba$z: number);
declare function fun ();
declare function is (trait: string): string;
declare function as (package: string): boolean;
interface This {
    when: string;
    type: number;
    in(object: Foo);
}

// val var is as trait package object when type fun in This
// contains any of: $ \s
