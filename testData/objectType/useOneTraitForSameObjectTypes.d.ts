declare var foo: {
    bar(a): number;
    baz;
    boo: string;
    show: (overrideChecks: boolean) => void;
    [s: string]: any;
};

declare var bar: {
    bar(a): number;
    baz;
    boo: string;
    show: (anotherOverrideChecks: boolean) => void;
    [s: string]: any;
};

declare var baz: {
    bar(a): number;
    baz;
    boo: string;
    show: (flag: boolean) => void;
    [s: string]: number;
};

declare interface Interface {
    bar: {
        bar(a): number;
        baz;
        boo: string;
        show: (bbb: boolean) => void;
        [s: string]: any;
    };

    baz: {
        bar(a): number;
        baz;
        boo: string;
        show: (d: boolean) => void;
        [s: string]: number;
    };
}
