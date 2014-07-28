package inModule

module
public object TypeScript {
    module
    public object Syntax {
        public trait IFactory {
            public fun sourceUnit(moduleElements: ISyntaxList, endOfFileToken: ISyntaxToken): SourceUnitSyntax
        }
        public class NormalModeFactory : IFactory {
            override fun sourceUnit(moduleElements: ISyntaxList, endOfFileToken: ISyntaxToken): SourceUnitSyntax = noImpl
        }
    }
}
