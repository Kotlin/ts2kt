declare interface Baz

declare interface Bar

declare class FooBar<T extends Bar> {
    varT: T;
    withoutArgumentsReturnsT(): T;
    withOneT(a: T): T;
    returnsB<B extends Baz>(a: any): B;
    withManyArguments<A extends T, B extends Baz>(a: A, b: B): T;
}
