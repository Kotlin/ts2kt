type I = {
    foo(): string
}
type J = {
    foo(): string
}
type K = {
    bar(): number
}

declare function f(a: I, b: J, c: I): K

declare var x: I;
declare var y: I;
declare var z: J;