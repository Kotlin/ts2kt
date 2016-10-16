interface Foo {
    new(n: number): Bar
    methodWithOutArgs();
    methodWithString(s: string): string;
    methodWithManyArgs(n: number, settings: Bar): boolean;
}
