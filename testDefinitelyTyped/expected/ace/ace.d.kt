package ace

native
public trait `T$0` {
    public fun invoke(editor: Editor): KeyBinding
}
native
public trait `T$1` {
    public fun invoke(doc: Document, row: Number, column: Number): Anchor
}
native
public trait `T$2` {
    public fun invoke(tokenizer: Tokenizer, editor: Editor): BackgroundTokenizer
}
native
public trait `T$3` {
    public fun invoke(text: String? = null): Document
    public fun invoke(text: Array<String>? = null): Document
}
native
public trait `T$4` {
    public fun invoke(text: String, mode: TextMode? = null): IEditSession
    public fun invoke(content: String, mode: String? = null): IEditSession
    public fun invoke(text: Array<String>, mode: String? = null): IEditSession
}
native
public trait `T$5` {
    public fun invoke(renderer: VirtualRenderer, session: IEditSession? = null): Editor
}
native
public trait `T$6` {
    public fun invoke(session: Document, length: Number, pos: Number, others: String, mainClass: String, othersClass: String): PlaceHolder
    public fun invoke(session: IEditSession, length: Number, pos: Position, positions: Array<Position>): PlaceHolder
}
native
public trait `T$7` {
    public fun invoke(): IRangeList
}
native
public trait `T$8` {
    public fun fromPoints(pos1: Position, pos2: Position): Range
    public fun invoke(startRow: Number, startColumn: Number, endRow: Number, endColumn: Number): Range
}
native
public trait `T$9` {
    public fun invoke(): RenderLoop
}
native
public trait `T$10` {
    public fun invoke(parent: HTMLElement): ScrollBar
}
native
public trait `T$11` {
    public fun invoke(): Search
}
native
public trait `T$12` {
    public fun invoke(session: IEditSession): Selection
}
native
public trait `T$13` {
    public fun invoke(): Split
}
native
public trait `T$14` {
    public fun invoke(session: IEditSession, initialRow: Number, initialColumn: Number): TokenIterator
}
native
public trait `T$15` {
    public fun invoke(rules: Any, flag: String): Tokenizer
}
native
public trait `T$16` {
    public fun invoke(): UndoManager
}
native
public trait `T$17` {
    public fun invoke(container: HTMLElement, theme: String? = null): VirtualRenderer
}
module
public object AceAjax {
    public trait Delta {
        public var action: String
        public var range: Range
        public var text: String
        public var lines: Array<String>
    }
    public trait EditorCommand {
        public var name: String
        public var bindKey: Any
        public var exec: Function
    }
    public trait CommandManager {
        public var byName: Any
        public var commands: Any
        public var platform: String
        public fun addCommands(commands: Array<EditorCommand>): Unit
        public fun addCommand(command: EditorCommand): Unit
        public fun exec(name: String, editor: Editor, args: Any): Unit
    }
    public trait Annotation {
        public var row: Number
        public var column: Number
        public var text: String
        public var `type`: String
    }
    public trait TokenInfo {
        public var value: String
    }
    public trait Position {
        public var row: Number
        public var column: Number
    }

    // KeyBinding
    // merge interface and var with ObjectType with new %)

    public trait TextMode {
        public fun getTokenizer(): Any
        public fun toggleCommentLines(state: Any, doc: Any, startRow: Any, endRow: Any): Unit
        public fun getNextLineIndent(state: Any, line: Any, tab: Any): String
        public fun checkOutdent(state: Any, line: Any, input: Any): Boolean
        public fun autoOutdent(state: Any, doc: Any, row: Any): Unit
        public fun createWorker(session: Any): Any
        public fun createModeDelegates(mapping: Any): Unit
        public fun transformAction(state: Any, action: Any, editor: Any, session: Any, param: Any): Any
    }
    public trait Ace {
        public fun require(moduleName: String): Any
        public fun edit(el: String): Editor
        public fun edit(el: HTMLElement): Editor
        public fun createEditSession(text: Document, mode: TextMode): IEditSession
        public fun createEditSession(text: String, mode: TextMode): IEditSession
    }

    // Anchor
    // BackgroundTokenizer
    // Document

    public trait IEditSession {
        public var selection: Selection
        public var bgTokenizer: BackgroundTokenizer
        public var doc: Document
        public fun on(event: String, fn: (e: Any) -> Any): Unit
        public fun findMatchingBracket(position: Position): Unit
        public fun addFold(text: String, range: Range): Unit
        public fun getFoldAt(row: Number, column: Number): Any
        public fun removeFold(arg: Any): Unit
        public fun expandFold(arg: Any): Unit
        public fun unfold(arg1: Any, arg2: Boolean): Unit
        public fun screenToDocumentColumn(row: Number, column: Number): Unit
        public fun getFoldDisplayLine(foldLine: Any, docRow: Number, docColumn: Number): Any
        public fun getFoldsInRange(range: Range): Any
        public fun highlight(text: String): Unit
        public fun setDocument(doc: Document): Unit
        public fun getDocument(): Document
        public fun `$resetRowCache`(row: Number): Unit
        public fun setValue(text: String): Unit
        public fun setMode(mode: String): Unit
        public fun getValue(): String
        public fun getSelection(): Selection
        public fun getState(row: Number): String
        public fun getTokens(row: Number): Array<TokenInfo>
        public fun getTokenAt(row: Number, column: Number): TokenInfo
        public fun setUndoManager(undoManager: UndoManager): Unit
        public fun getUndoManager(): UndoManager
        public fun getTabString(): String
        public fun setUseSoftTabs(useSoftTabs: Boolean): Unit
        public fun getUseSoftTabs(): Boolean
        public fun setTabSize(tabSize: Number): Unit
        public fun getTabSize(): String
        public fun isTabStop(position: Any): Boolean
        public fun setOverwrite(overwrite: Boolean): Unit
        public fun getOverwrite(): Boolean
        public fun toggleOverwrite(): Unit
        public fun addGutterDecoration(row: Number, className: String): Unit
        public fun removeGutterDecoration(row: Number, className: String): Unit
        public fun getBreakpoints(): Array<Number>
        public fun setBreakpoints(rows: Array<Any>): Unit
        public fun clearBreakpoints(): Unit
        public fun setBreakpoint(row: Number, className: String): Unit
        public fun clearBreakpoint(row: Number): Unit
        public fun addMarker(range: Range, clazz: String, `type`: Function, inFront: Boolean): Unit
        public fun addMarker(range: Range, clazz: String, `type`: String, inFront: Boolean): Unit
        public fun addDynamicMarker(marker: Any, inFront: Boolean): Unit
        public fun removeMarker(markerId: Number): Unit
        public fun getMarkers(inFront: Boolean): Array<Any>
        public fun setAnnotations(annotations: Array<Annotation>): Unit
        public fun getAnnotations(): Any
        public fun clearAnnotations(): Unit
        public fun `$detectNewLine`(text: String): Unit
        public fun getWordRange(row: Number, column: Number): Range
        public fun getAWordRange(row: Number, column: Number): Any
        public fun setNewLineMode(newLineMode: String): Unit
        public fun getNewLineMode(): String
        public fun setUseWorker(useWorker: Boolean): Unit
        public fun getUseWorker(): Boolean
        public fun onReloadTokenizer(): Unit
        public fun `$mode`(mode: TextMode): Unit
        public fun getMode(): TextMode
        public fun setScrollTop(scrollTop: Number): Unit
        public fun getScrollTop(): Number
        public fun setScrollLeft(): Unit
        public fun getScrollLeft(): Number
        public fun getScreenWidth(): Number
        public fun getLine(row: Number): String
        public fun getLines(firstRow: Number, lastRow: Number): Array<String>
        public fun getLength(): Number
        public fun getTextRange(range: Range): String
        public fun insert(position: Position, text: String): Any
        public fun remove(range: Range): Any
        public fun undoChanges(deltas: Array<Any>, dontSelect: Boolean): Range
        public fun redoChanges(deltas: Array<Any>, dontSelect: Boolean): Range
        public fun setUndoSelect(enable: Boolean): Unit
        public fun replace(range: Range, text: String): Any
        public fun moveText(fromRange: Range, toPosition: Any): Range
        public fun indentRows(startRow: Number, endRow: Number, indentString: String): Unit
        public fun outdentRows(range: Range): Unit
        public fun moveLinesUp(firstRow: Number, lastRow: Number): Number
        public fun moveLinesDown(firstRow: Number, lastRow: Number): Number
        public fun duplicateLines(firstRow: Number, lastRow: Number): Number
        public fun setUseWrapMode(useWrapMode: Boolean): Unit
        public fun getUseWrapMode(): Boolean
        public fun setWrapLimitRange(min: Number, max: Number): Unit
        public fun adjustWrapLimit(desiredLimit: Number): Boolean
        public fun getWrapLimit(): Number
        public fun getWrapLimitRange(): Any
        public fun `$getDisplayTokens`(str: String, offset: Number): Unit
        public fun `$getStringScreenWidth`(str: String, maxScreenColumn: Number, screenColumn: Number): Array<Number>
        public fun getRowLength(row: Number): Number
        public fun getScreenLastRowColumn(screenRow: Number): Number
        public fun getDocumentLastRowColumn(docRow: Number, docColumn: Number): Number
        public fun getDocumentLastRowColumnPosition(docRow: Number, docColumn: Number): Number
        public fun getRowSplitData(): String
        public fun getScreenTabSize(screenColumn: Number): Number
        public fun screenToDocumentPosition(screenRow: Number, screenColumn: Number): Any
        public fun documentToScreenPosition(docRow: Number, docColumn: Number): Any
        public fun documentToScreenColumn(row: Number, docColumn: Number): Number
        public fun documentToScreenRow(docRow: Number, docColumn: Number): Unit
        public fun getScreenLength(): Number
    }

    // EditSession
    // Editor
    // PlaceHolder

    public trait IRangeList {
        public var ranges: Array<Range>
        public fun pointIndex(pos: Position, startIndex: Number? = null): Unit
        public fun addList(ranges: Array<Range>): Unit
        public fun add(ranges: Range): Unit
        public fun merge(): Array<Range>
        public fun substractPoint(pos: Position): Unit
    }
    public var RangeList: `T$7` = noImpl

    // Range
    // ScrollBar
    // Search
    // Selection
    // Split
    // TokenIterator
    // Tokenizer
    // UndoManager
    // VirtualRenderer
}
native
public var ace: AceAjax.Ace = noImpl
