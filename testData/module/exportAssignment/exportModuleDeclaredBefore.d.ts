// based on semver.d.ts
declare module SemverModule {
    var something;
}

//TODO: drop empty module
declare module "semver" {
    export = SemverModule;
}
