// OUT:
// WRONG
package atom

native
public trait Window {
// Should be extensions
    public var atom: AtomCore.IAtom
    public fun measure(description: String, fn: Function): Any
    public fun profile(description: String, fn: Function): Any
}
native
public trait `T$0` {
    public fun off(): Any
}
native
public trait `T$1` {
    public fun get(index: Number): IDisplayBufferMarker
    public fun set(index: Number, value: IDisplayBufferMarker): Unit
}
native
public trait `T$2` {
    public var id: Number
    public var softWrap: Boolean
    public var editorWidthInChars: Number
    public var scrollTop: Number
    public var scrollLeft: Number
    public var tokenizedBuffer: Any
}
native
public trait `T$3` {
    public var start: TextBuffer.IPoint
    public var end: TextBuffer.IPoint
}
native
public trait `T$4` {
    public var start: Array<Number>
    public var end: TextBuffer.IPoint
}
native
public trait `T$5` {
    public var row: Number
    public var col: Number
}
native
public trait `T$6` {
    public var start: `T$5`
    public var end: TextBuffer.IPoint
}
native
public trait `T$7` {
    public var start: TextBuffer.IPoint
    public var end: Array<Number>
}
native
public trait `T$8` {
    public var start: Array<Number>
    public var end: Array<Number>
}
native
public trait `T$9` {
    public var start: `T$5`
    public var end: Array<Number>
}
native
public trait `T$10` {
    public var start: TextBuffer.IPoint
    public var end: `T$5`
}
native
public trait `T$11` {
    public var start: Array<Number>
    public var end: `T$5`
}
native
public trait `T$12` {
    public var start: `T$5`
    public var end: `T$5`
}
native
public trait `T$13` {
    public var editor: IEditor
    public var marker: IDisplayBufferMarker
    public var id: Number
}
native
public trait `T$14` {
    public var id: Number
    public var softTabs: Boolean
    public var scrollTop: Number
    public var scrollLeft: Number
    public var displayBuffer: Any
}
native
public trait `T$15` {
    public var `type`: String
    public var editorId: Number
    public var invalidate: String
}
native
public trait `T$16` {
    public var path: Any
    public var buffers: Array<Any>
}
native
public trait `T$17` {
    public var paneContainer: Any
    public var fullScreen: Boolean
}
native
public trait `T$18` {
    public var bufferMarker: IMarker
    public var displayBuffer: IDisplayBuffer
}
module
public object AtomCore {
    public trait IWorkspaceViewStatic {
        public fun invoke(): IWorkspaceView
        public var version: Number
        public var configDefaults: Any
        public fun content(): Any
    }
    public trait IWorkspaceView : View {
        public var fullScreen: Boolean
        public fun open(uri: String, options: Any): Q.Promise<View>
        public fun openSync(uri: String, options: Any? = null): Any
        public fun saveActivePaneItem(): Any
        public fun saveActivePaneItemAs(): Any
        public fun saveAll(): Unit
        public fun destroyActivePaneItem(): Any
        public fun destroyActivePane(): Any
        public fun increaseFontSize(): Unit
        public fun decreaseFontSize(): Unit
        public fun initialize(model: IWorkspace): Any
        public fun initialize(view: View, args: Any): Unit
        public var model: IWorkspace
        public var panes: IPaneContainerView
        public fun getModel(): IWorkspace
        public fun installShellCommands(): Any
        public fun handleFocus(): Any
        public fun afterAttach(onDom: Any? = null): Any
        public fun confirmClose(): Boolean
        public fun updateTitle(): Any
        public fun setTitle(title: String): Any
        public fun getEditorViews(): Array<Any>
        public fun prependToTop(element: Any): Any
        public fun appendToTop(element: Any): Any
        public fun prependToBottom(element: Any): Any
        public fun appendToBottom(element: Any): Any
        public fun prependToLeft(element: Any): Any
        public fun appendToLeft(element: Any): Any
        public fun prependToRight(element: Any): Any
        public fun appendToRight(element: Any): Any
        public fun getActivePaneView(): IPaneView
        public fun getActiveView(): View
        public fun focusPreviousPaneView(): Any
        public fun focusNextPaneView(): Any
        public fun focusPaneViewAbove(): Any
        public fun focusPaneViewBelow(): Any
        public fun focusPaneViewOnLeft(): Any
        public fun focusPaneViewOnRight(): Any
        public fun eachPaneView(callback: (paneView: IPaneView) -> Any): `T$0`
        public fun getPaneViews(): Array<IPaneView>
        public fun eachEditorView(callback: (editorView: Any) -> Any): `T$0`
        public fun beforeRemove(): Any
        public fun command(eventName: String, handler: Function): Any
        public fun command(eventName: String, selector: Function, handler: Function): Any
        public fun command(eventName: String, options: Any, handler: Function): Any
        public fun command(eventName: String, selector: Function, options: Any, handler: Function): Any
        public var statusBar: StatusBar.IStatusBarView
    }
    public trait IPanes
    public trait IPaneView
    public trait IPaneContainerView
    public trait ITreeView
    public trait IGutterViewStatic {
        public fun invoke(): IGutterView
        public fun content(): Any
    }
    public trait IGutterView : View {
        public var firstScreenRow: Any
        public var lastScreenRow: Any
        public fun initialize(): Unit
        public fun initialize(view: View, args: Any): Unit
        public fun afterAttach(onDom: Any? = null): Any
        public fun beforeRemove(): Any
        public fun handleMouseEvents(e: JQueryMouseEventObject): Any
        public fun getEditorView(): Any
        public fun getEditor(): IEditor
        public fun getLineNumberElements(): HTMLCollection
        public fun getLineNumberElementsForClass(klass: String): NodeList
        public fun getLineNumberElement(bufferRow: Number): NodeList
        public fun addClassToAllLines(klass: String): Boolean
        public fun removeClassFromAllLines(klass: String): Boolean
        public fun addClassToLine(bufferRow: Number, klass: String): Boolean
        public fun removeClassFromLine(bufferRow: Number, klass: String): Boolean
        public fun updateLineNumbers(changes: Array<Any>, startScreenRow: Number? = null, endScreenRow: Number? = null): Any
        public fun prependLineElements(lineElements: Any): Unit
        public fun appendLineElements(lineElements: Any): Unit
        public fun removeLineElements(numberOfElements: Number): Unit
        public fun buildLineElements(startScreenRow: Any, endScreenRow: Any): Any
        public fun buildLineElementsHtml(startScreenRow: Any, endScreenRow: Any): Any
        public fun updateFoldableClasses(changes: Array<Any>): Any
        public fun removeLineHighlights(): Unit
        public fun addLineHighlight(row: Number, emptySelection: Boolean? = null): Any
        public fun highlightLines(): Boolean
    }
    public trait ICommandPanel
    public trait IDisplayBufferStatic {
        public fun invoke(_arg: Any? = null): IDisplayBuffer
    }
    public trait IDisplayBuffer {
        public var constructor: IDisplayBufferStatic
        public var verticalScrollMargin: Number
        public var horizontalScrollMargin: Number
        public var declaredPropertyValues: Any
        public var tokenizedBuffer: ITokenizedBuffer
        public var buffer: TextBuffer.ITextBuffer
        public var charWidthsByScope: Any
        public var markers: `T$1`
        public var foldsByMarkerId: Any
        public var maxLineLength: Number
        public var screenLines: Array<ITokenizedLine>
        public var rowMap: Any
        public var longestScreenRow: Number
        public var subscriptions: Array<Emissary.ISubscription>
        public var subscriptionsByObject: Any
        public var behaviors: Any
        public var subscriptionCounts: Any
        public var eventHandlersByEventName: Any
        public var pendingChangeEvent: Any
        public var softWrap: Boolean
        public fun serializeParams(): `T$2`
        public fun deserializeParams(params: Any): Any
        public fun copy(): IDisplayBuffer
        public fun updateAllScreenLines(): Any
        public fun emitChanged(eventProperties: Any, refreshMarkers: Boolean? = null): Any
        public fun updateWrappedScreenLines(): Any
        public fun setVisible(visible: Any): Any
        public fun getVerticalScrollMargin(): Number
        public fun setVerticalScrollMargin(verticalScrollMargin: Number): Number
        public fun getHorizontalScrollMargin(): Number
        public fun setHorizontalScrollMargin(horizontalScrollMargin: Number): Number
        public fun getHeight(): Any
        public fun setHeight(height: Any): Any
        public fun getWidth(): Any
        public fun setWidth(newWidth: Any): Any
        public fun getScrollTop(): Number
        public fun setScrollTop(scrollTop: Number): Number
        public fun getScrollBottom(): Number
        public fun setScrollBottom(scrollBottom: Number): Number
        public fun getScrollLeft(): Number
        public fun setScrollLeft(scrollLeft: Number): Number
        public fun getScrollRight(): Number
        public fun setScrollRight(scrollRight: Number): Number
        public fun getLineHeight(): Any
        public fun setLineHeight(lineHeight: Any): Any
        public fun getDefaultCharWidth(): Any
        public fun setDefaultCharWidth(defaultCharWidth: Any): Any
        public fun getScopedCharWidth(scopeNames: Any, char: Any): Any
        public fun getScopedCharWidths(scopeNames: Any): Any
        public fun setScopedCharWidth(scopeNames: Any, char: Any, width: Any): Any
        public fun setScopedCharWidths(scopeNames: Any, charWidths: Any): Any
        public fun clearScopedCharWidths(): Any
        public fun getScrollHeight(): Number
        public fun getScrollWidth(): Number
        public fun getVisibleRowRange(): Array<Number>
        public fun intersectsVisibleRowRange(startRow: Any, endRow: Any): Any
        public fun selectionIntersectsVisibleRowRange(selection: Any): Any
        public fun scrollToScreenRange(screenRange: Any): Any
        public fun scrollToScreenPosition(screenPosition: Any): Any
        public fun scrollToBufferPosition(bufferPosition: Any): Any
        public fun pixelRectForScreenRange(screenRange: TextBuffer.IRange): Any
        public fun getTabLength(): Number
        public fun setTabLength(tabLength: Number): Any
        public fun setSoftWrap(softWrap: Boolean): Boolean
        public fun getSoftWrap(): Boolean
        public fun setEditorWidthInChars(editorWidthInChars: Number): Any
        public fun getEditorWidthInChars(): Number
        public fun getSoftWrapColumn(): Number
        public fun lineForRow(row: Number): Any
        public fun linesForRows(startRow: Number, endRow: Number): Any
        public fun getLines(): Array<Any>
        public fun indentLevelForLine(line: Any): Any
        public fun bufferRowsForScreenRows(startScreenRow: Any, endScreenRow: Any): Any
        public fun createFold(startRow: Number, endRow: Number): IFold
        public fun isFoldedAtBufferRow(bufferRow: Number): Boolean
        public fun isFoldedAtScreenRow(screenRow: Number): Boolean
        public fun destroyFoldWithId(id: Number): Any
        public fun unfoldBufferRow(bufferRow: Number): Array<Any>
        public fun largestFoldStartingAtBufferRow(bufferRow: Number): Any
        public fun foldsStartingAtBufferRow(bufferRow: Number): Any
        public fun largestFoldStartingAtScreenRow(screenRow: Any): Any
        public fun largestFoldContainingBufferRow(bufferRow: Any): Any
        public fun outermostFoldsInBufferRowRange(startRow: Any, endRow: Any): Array<Any>
        public fun foldsContainingBufferRow(bufferRow: Any): Array<Any>
        public fun screenRowForBufferRow(bufferRow: Number): Number
        public fun lastScreenRowForBufferRow(bufferRow: Number): Number
        public fun bufferRowForScreenRow(screenRow: Number): Number
        public fun screenRangeForBufferRange(bufferRange: Array<TextBuffer.IPoint>): TextBuffer.IRange
        public fun screenRangeForBufferRange(bufferRange: TextBuffer.IRange): TextBuffer.IRange
        public fun screenRangeForBufferRange(bufferRange: `T$3`): TextBuffer.IRange
        public fun screenRangeForBufferRange(bufferRange: `T$4`): TextBuffer.IRange
        public fun screenRangeForBufferRange(bufferRange: `T$6`): TextBuffer.IRange
        public fun screenRangeForBufferRange(bufferRange: `T$7`): TextBuffer.IRange
        public fun screenRangeForBufferRange(bufferRange: `T$8`): TextBuffer.IRange
        public fun screenRangeForBufferRange(bufferRange: `T$9`): TextBuffer.IRange
        public fun screenRangeForBufferRange(bufferRange: `T$10`): TextBuffer.IRange
        public fun screenRangeForBufferRange(bufferRange: `T$11`): TextBuffer.IRange
        public fun screenRangeForBufferRange(bufferRange: `T$12`): TextBuffer.IRange
        public fun bufferRangeForScreenRange(screenRange: Array<TextBuffer.IPoint>): TextBuffer.IRange
        public fun bufferRangeForScreenRange(screenRange: TextBuffer.IRange): TextBuffer.IRange
        public fun bufferRangeForScreenRange(screenRange: `T$3`): TextBuffer.IRange
        public fun bufferRangeForScreenRange(screenRange: `T$4`): TextBuffer.IRange
        public fun bufferRangeForScreenRange(screenRange: `T$6`): TextBuffer.IRange
        public fun bufferRangeForScreenRange(screenRange: `T$7`): TextBuffer.IRange
        public fun bufferRangeForScreenRange(screenRange: `T$8`): TextBuffer.IRange
        public fun bufferRangeForScreenRange(screenRange: `T$9`): TextBuffer.IRange
        public fun bufferRangeForScreenRange(screenRange: `T$10`): TextBuffer.IRange
        public fun bufferRangeForScreenRange(screenRange: `T$11`): TextBuffer.IRange
        public fun bufferRangeForScreenRange(screenRange: `T$12`): TextBuffer.IRange
        public fun pixelRangeForScreenRange(screenRange: Array<TextBuffer.IPoint>, clip: Boolean? = null): TextBuffer.IRange
        public fun pixelRangeForScreenRange(screenRange: TextBuffer.IRange, clip: Boolean? = null): TextBuffer.IRange
        public fun pixelRangeForScreenRange(screenRange: `T$3`, clip: Boolean? = null): TextBuffer.IRange
        public fun pixelRangeForScreenRange(screenRange: `T$4`, clip: Boolean? = null): TextBuffer.IRange
        public fun pixelRangeForScreenRange(screenRange: `T$6`, clip: Boolean? = null): TextBuffer.IRange
        public fun pixelRangeForScreenRange(screenRange: `T$7`, clip: Boolean? = null): TextBuffer.IRange
        public fun pixelRangeForScreenRange(screenRange: `T$8`, clip: Boolean? = null): TextBuffer.IRange
        public fun pixelRangeForScreenRange(screenRange: `T$9`, clip: Boolean? = null): TextBuffer.IRange
        public fun pixelRangeForScreenRange(screenRange: `T$10`, clip: Boolean? = null): TextBuffer.IRange
        public fun pixelRangeForScreenRange(screenRange: `T$11`, clip: Boolean? = null): TextBuffer.IRange
        public fun pixelRangeForScreenRange(screenRange: `T$12`, clip: Boolean? = null): TextBuffer.IRange
        public fun pixelPositionForScreenPosition(screenPosition: TextBuffer.IPoint, clip: Boolean? = null): TextBuffer.IPoint
        public fun pixelPositionForScreenPosition(screenPosition: Array<Number>, clip: Boolean? = null): TextBuffer.IPoint
        public fun pixelPositionForScreenPosition(screenPosition: `T$5`, clip: Boolean? = null): TextBuffer.IPoint
        public fun screenPositionForPixelPosition(pixelPosition: Any): TextBuffer.IPoint
        public fun pixelPositionForBufferPosition(bufferPosition: Any): Any
        public fun getLineCount(): Number
        public fun getLastRow(): Number
        public fun getMaxLineLength(): Number
        public fun screenPositionForBufferPosition(bufferPosition: Any, options: Any): Any
        public fun bufferPositionForScreenPosition(bufferPosition: Any, options: Any): Any
        public fun scopesForBufferPosition(bufferPosition: Any): Any
        public fun bufferRangeForScopeAtPosition(selector: Any, position: Any): Any
        public fun tokenForBufferPosition(bufferPosition: Any): Any
        public fun getGrammar(): IGrammar
        public fun setGrammar(grammar: IGrammar): Any
        public fun reloadGrammar(): Any
        public fun clipScreenPosition(screenPosition: Any, options: Any): Any
        public fun findWrapColumn(line: Any, softWrapColumn: Any): Any
        public fun rangeForAllLines(): TextBuffer.IRange
        public fun getMarker(id: Number): IDisplayBufferMarker
        public fun getMarkers(): Array<IDisplayBufferMarker>
        public fun getMarkerCount(): Number
        public fun markScreenRange(range: TextBuffer.IRange, vararg args: Any): IDisplayBufferMarker
        public fun markBufferRange(range: TextBuffer.IRange, options: Any? = null): IDisplayBufferMarker
        public fun markScreenPosition(screenPosition: TextBuffer.IPoint, options: Any? = null): IDisplayBufferMarker
        public fun markBufferPosition(bufferPosition: TextBuffer.IPoint, options: Any? = null): IDisplayBufferMarker
        public fun destroyMarker(id: Number): Any
        public fun findMarker(params: Any? = null): IDisplayBufferMarker
        public fun findMarkers(params: Any? = null): Array<IDisplayBufferMarker>
        public fun translateToBufferMarkerParams(params: Any? = null): Any
        public fun findFoldMarker(attributes: Any): IMarker
        public fun findFoldMarkers(attributes: Any): Array<IMarker>
        public fun getFoldMarkerAttributes(attributes: Any? = null): Any
        public fun pauseMarkerObservers(): Any
        public fun resumeMarkerObservers(): Any
        public fun refreshMarkerScreenPositions(): Any
        public fun destroy(): Any
        public fun logLines(start: Number, end: Number): Array<Any>
        public fun handleTokenizedBufferChange(tokenizedBufferChange: Any): Any
        public fun updateScreenLines(startBufferRow: Any, endBufferRow: Any, bufferDelta: Number? = null, options: Any? = null): Any
        public fun buildScreenLines(startBufferRow: Any, endBufferRow: Any): Any
        public fun findMaxLineLength(startScreenRow: Any, endScreenRow: Any, newScreenLines: Any): Any
        public fun handleBufferMarkersUpdated(): Any
        public fun handleBufferMarkerCreated(marker: Any): Any
        public fun createFoldForMarker(maker: Any): IFold
        public fun foldForMarker(marker: Any): Any
    }
    public trait ICursorStatic {
        public fun invoke(arg: `T$13`): ICursor
    }
    public trait ICursor {
        public var screenPosition: Any
        public var bufferPosition: Any
        public var goalColumn: Any
        public var visible: Boolean
        public var needsAutoscroll: Boolean
        public var editor: IEditor
        public var marker: IDisplayBufferMarker
        public var id: Number
        public fun destroy(): Any
        public fun changePosition(options: Any, fn: Function): Any
        public fun getPixelRect(): Any
        public fun setScreenPosition(screenPosition: Any, options: Any? = null): Any
        public fun getScreenPosition(): TextBuffer.IPoint
        public fun getScreenRange(): TextBuffer.IRange
        public fun setBufferPosition(bufferPosition: Any, options: Any? = null): Any
        public fun getBufferPosition(): TextBuffer.IPoint
        public fun autoscroll(): Any
        public fun updateVisibility(): Any
        public fun setVisible(visible: Boolean): Any
        public fun isVisible(): Boolean
        public fun wordRegExp(arg: Any? = null): Any
        public fun isLastCursor(): Boolean
        public fun isSurroundedByWhitespace(): Boolean
        public fun isBetweenWordAndNonWord(): Boolean
        public fun isInsideWord(): Boolean
        public fun clearAutoscroll(): Unit
        public fun clearSelection(): Unit
        public fun getScreenRow(): Number
        public fun getScreenColumn(): Number
        public fun getBufferRow(): Number
        public fun getBufferColumn(): Number
        public fun getCurrentBufferLine(): String
        public fun moveUp(rowCount: Number, arg: Any? = null): Any
        public fun moveDown(rowCount: Number, arg: Any? = null): Any
        public fun moveLeft(arg: Any? = null): Any
        public fun moveRight(arg: Any? = null): Any
        public fun moveToTop(): Any
        public fun moveToBottom(): Unit
        public fun moveToBeginningOfScreenLine(): Unit
        public fun moveToBeginningOfLine(): Unit
        public fun moveToFirstCharacterOfLine(): Unit
        public fun moveToEndOfScreenLine(): Unit
        public fun moveToEndOfLine(): Unit
        public fun moveToBeginningOfWord(): Unit
        public fun moveToEndOfWord(): Unit
        public fun moveToBeginningOfNextWord(): Unit
        public fun moveToPreviousWordBoundary(): Unit
        public fun moveToNextWordBoundary(): Unit
        public fun getBeginningOfCurrentWordBufferPosition(options: Any? = null): TextBuffer.IPoint
        public fun getPreviousWordBoundaryBufferPosition(options: Any? = null): TextBuffer.IPoint
        public fun getMoveNextWordBoundaryBufferPosition(options: Any? = null): TextBuffer.IPoint
        public fun getEndOfCurrentWordBufferPosition(options: Any? = null): TextBuffer.IPoint
        public fun getBeginningOfNextWordBufferPosition(options: Any? = null): TextBuffer.IPoint
        public fun getCurrentWordBufferRange(options: Any? = null): TextBuffer.IPoint
        public fun getCurrentLineBufferRange(options: Any? = null): TextBuffer.IPoint
        public fun getCurrentParagraphBufferRange(): Any
        public fun getCurrentWordPrefix(): String
        public fun isAtBeginningOfLine(): Boolean
        public fun getIndentLevel(): Number
        public fun isAtEndOfLine(): Boolean
        public fun getScopes(): Array<String>
        public fun hasPrecedingCharactersOnLine(): Boolean
    }
    public trait ILanguageMode
    public trait ISelection {
        public var cursor: ICursor
        public var marker: IDisplayBufferMarker
        public var editor: IEditor
        public var initialScreenRange: Any
        public var wordwise: Boolean
        public var needsAutoscroll: Boolean
        public var retainSelection: Boolean
        public var subscriptionCounts: Any
        public fun destroy(): Any
        public fun finalize(): Any
        public fun clearAutoscroll(): Any
        public fun isEmpty(): Boolean
        public fun isReversed(): Boolean
        public fun isSingleScreenLine(): Boolean
        public fun getScreenRange(): TextBuffer.IRange
        public fun setScreenRange(screenRange: Any, options: Any): Any
        public fun getBufferRange(): TextBuffer.IRange
        public fun setBufferRange(bufferRange: Any, options: Any): Any
        public fun getBufferRowRange(): Array<Number>
        public fun autoscroll(): Unit
        public fun getText(): String
        public fun clear(): Boolean
        public fun selectWord(): TextBuffer.IRange
        public fun expandOverWord(): Any
        public fun selectLine(row: Any? = null): TextBuffer.IRange
        public fun expandOverLine(): Boolean
        public fun selectToScreenPosition(position: Any): Any
        public fun selectToBufferPosition(position: Any): Any
        public fun selectRight(): Boolean
        public fun selectLeft(): Boolean
        public fun selectUp(rowCount: Any? = null): Boolean
        public fun selectDown(rowCount: Any? = null): Boolean
        public fun selectToTop(): Any
        public fun selectToBottom(): Any
        public fun selectAll(): Any
        public fun selectToBeginningOfLine(): Any
        public fun selectToFirstCharacterOfLine(): Any
        public fun selectToEndOfLine(): Any
        public fun selectToBeginningOfWord(): Any
        public fun selectToEndOfWord(): Any
        public fun selectToBeginningOfNextWord(): Any
        public fun selectToPreviousWordBoundary(): Any
        public fun selectToNextWordBoundary(): Any
        public fun addSelectionBelow(): Any
        public fun getGoalBufferRange(): Any
        public fun addSelectionAbove(): Array<Any>
        public fun insertText(text: String, options: Any? = null): Any
        public fun normalizeIndents(text: String, indentBasis: Number): Any
        public fun indent(_arg: Any? = null): Any
        public fun indentSelectedRows(): Array<TextBuffer.IRange>
        public fun setIndentationForLine(line: String, indentLevel: Number): Any
        public fun backspace(): Any
        public fun backspaceToBeginningOfWord(): Any
        public fun backspaceToBeginningOfLine(): Any
        public fun delete(): Any
        public fun deleteToEndOfWord(): Any
        public fun deleteSelectedText(): Any
        public fun deleteLine(): Any
        public fun joinLines(): Any
        public fun outdentSelectedRows(): Array<Any>
        public fun autoIndentSelectedRows(): Any
        public fun toggleLineComments(): Any
        public fun cutToEndOfLine(maintainClipboard: Any): Any
        public fun cut(maintainClipboard: Any): Any
        public fun copy(maintainClipboard: Any): Any
        public fun fold(): Any
        public fun modifySelection(fn: () -> Any): Any
        public fun plantTail(): Any
        public fun intersectsBufferRange(bufferRange: Any): Any
        public fun intersectsWith(otherSelection: Any): Any
        public fun merge(otherSelection: Any, options: Any): Any
        public fun compare(otherSelection: Any): Any
        public fun getRegionRects(): Array<Any>
        public fun screenRangeChanged(): Any
    }
    public trait IEditor {
        public var deserializing: Boolean
        public var callDisplayBufferCreatedHook: Boolean
        public var registerEditor: Boolean
        public var buffer: TextBuffer.ITextBuffer
        public var languageMode: ILanguageMode
        public var cursors: Array<ICursor>
        public var selections: Array<ISelection>
        public var suppressSelectionMerging: Boolean
        public var softTabs: Boolean
        public var displayBuffer: IDisplayBuffer
        public var id: Number
        public var behaviors: Any
        public var declaredPropertyValues: Any
        public var eventHandlersByEventName: Any
        public var eventHandlersByNamespace: Any
        public var lastOpened: Number
        public var subscriptionCounts: Any
        public var subscriptionsByObject: Any
        public var subscriptions: Array<Emissary.ISubscription>
        public fun serializeParams(): `T$14`
        public fun deserializeParams(params: Any): Any
        public fun subscribeToBuffer(): Unit
        public fun subscribeToDisplayBuffer(): Unit
        public fun getViewClass(): Any
        public fun destroyed(): Unit
        public fun copy(): IEditor
        public fun getTitle(): String
        public fun getLongTitle(): String
        public fun setVisible(visible: Boolean): Unit
        public fun setScrollTop(scrollTop: Any): Unit
        public fun getScrollTop(): Number
        public fun setScrollLeft(scrollLeft: Any): Unit
        public fun getScrollLeft(): Number
        public fun setEditorWidthInChars(editorWidthInChars: Any): Unit
        public fun getSoftWrapColumn(): Number
        public fun getSoftTabs(): Boolean
        public fun setSoftTabs(softTabs: Boolean): Unit
        public fun getSoftWrap(): Boolean
        public fun setSoftWrap(softWrap: Any): Unit
        public fun getTabText(): String
        public fun getTabLength(): Number
        public fun setTabLength(tabLength: Any): Unit
        public fun clipBufferPosition(bufferPosition: Any): Unit
        public fun clipBufferRange(range: Any): Unit
        public fun indentationForBufferRow(bufferRow: Any): Unit
        public fun setIndentationForBufferRow(bufferRow: Any, newLevel: Any, _arg: Any): Unit
        public fun indentLevelForLine(line: Any): Number
        public fun buildIndentString(number: Any): String
        public fun save(): Unit
        public fun saveAs(filePath: Any): Unit
        public fun getPath(): String
        public fun getText(): String
        public fun setText(text: Any): Unit
        public fun getTextInRange(range: Any): Any
        public fun getLineCount(): Number
        public fun getBuffer(): TextBuffer.ITextBuffer
        public fun getUri(): String
        public fun isBufferRowBlank(bufferRow: Any): Boolean
        public fun isBufferRowCommented(bufferRow: Any): Unit
        public fun nextNonBlankBufferRow(bufferRow: Any): Unit
        public fun getEofBufferPosition(): TextBuffer.IPoint
        public fun getLastBufferRow(): Number
        public fun bufferRangeForBufferRow(row: Any, options: Any): TextBuffer.IRange
        public fun lineForBufferRow(row: Number): String
        public fun lineLengthForBufferRow(row: Number): Number
        public fun scan(): Any
        public fun scanInBufferRange(): Any
        public fun backwardsScanInBufferRange(): Any
        public fun isModified(): Boolean
        public fun shouldPromptToSave(): Boolean
        public fun screenPositionForBufferPosition(bufferPosition: Any, options: Any? = null): TextBuffer.IPoint
        public fun bufferPositionForScreenPosition(screenPosition: Any, options: Any? = null): TextBuffer.IPoint
        public fun screenRangeForBufferRange(bufferRange: Any): TextBuffer.IRange
        public fun bufferRangeForScreenRange(screenRange: Any): TextBuffer.IRange
        public fun clipScreenPosition(screenPosition: Any, options: Any): TextBuffer.IRange
        public fun lineForScreenRow(row: Any): ITokenizedLine
        public fun linesForScreenRows(start: Any? = null, end: Any? = null): Array<ITokenizedLine>
        public fun getScreenLineCount(): Number
        public fun getMaxScreenLineLength(): Number
        public fun getLastScreenRow(): Number
        public fun bufferRowsForScreenRows(startRow: Any, endRow: Any): Array<Any>
        public fun bufferRowForScreenRow(row: Any): Number
        public fun scopesForBufferPosition(bufferPosition: Any): Array<String>
        public fun bufferRangeForScopeAtCursor(selector: String): Any
        public fun tokenForBufferPosition(bufferPosition: Any): IToken
        public fun getCursorScopes(): Array<String>
        public fun insertText(text: String, options: Any? = null): Array<TextBuffer.IRange>
        public fun insertNewline(): Array<TextBuffer.IRange>
        public fun insertNewlineBelow(): Array<TextBuffer.IRange>
        public fun insertNewlineAbove(): Any
        public fun indent(options: Any? = null): Any
        public fun backspace(): Array<Any>
        public fun backspaceToBeginningOfWord(): Array<Any>
        public fun backspaceToBeginningOfLine(): Array<Any>
        public fun delete(): Array<Any>
        public fun deleteToEndOfWord(): Array<Any>
        public fun deleteLine(): Array<TextBuffer.IRange>
        public fun indentSelectedRows(): Array<Array<TextBuffer.IRange>>
        public fun outdentSelectedRows(): Array<Array<TextBuffer.IRange>>
        public fun toggleLineCommentsInSelection(): Array<TextBuffer.IRange>
        public fun autoIndentSelectedRows(): Array<Array<TextBuffer.IRange>>
        public fun normalizeTabsInBufferRange(bufferRange: Any): Any
        public fun cutToEndOfLine(): Array<Boolean>
        public fun cutSelectedText(): Array<Boolean>
        public fun copySelectedText(): Array<Boolean>
        public fun pasteText(options: Any? = null): Array<TextBuffer.IRange>
        public fun undo(): Array<Any>
        public fun redo(): Array<Any>
        public fun foldCurrentRow(): Any
        public fun unfoldCurrentRow(): Array<Any>
        public fun foldSelectedLines(): Array<Any>
        public fun foldAll(): Array<Any>
        public fun unfoldAll(): Array<Any>
        public fun foldAllAtIndentLevel(level: Any): Any
        public fun foldBufferRow(bufferRow: Any): Any
        public fun unfoldBufferRow(bufferRow: Any): Any
        public fun isFoldableAtBufferRow(bufferRow: Any): Boolean
        public fun createFold(startRow: Any, endRow: Any): IFold
        public fun destroyFoldWithId(id: Any): Any
        public fun destroyFoldsIntersectingBufferRange(bufferRange: Any): Any
        public fun toggleFoldAtBufferRow(bufferRow: Any): Any
        public fun isFoldedAtCursorRow(): Boolean
        public fun isFoldedAtBufferRow(bufferRow: Any): Boolean
        public fun isFoldedAtScreenRow(screenRow: Any): Boolean
        public fun largestFoldContainingBufferRow(bufferRow: Any): Boolean
        public fun largestFoldStartingAtScreenRow(screenRow: Any): Any
        public fun outermostFoldsInBufferRowRange(startRow: Any, endRow: Any): Array<Any>
        public fun moveLineUp(): Array<ISelection>
        public fun moveLineDown(): Array<ISelection>
        public fun duplicateLines(): Array<Array<Any>>
        public fun duplicateLine(): Array<Array<Any>>
        public fun mutateSelectedText(fn: (selection: ISelection) -> Any): Any
        public fun replaceSelectedText(options: Any, fn: (selection: String) -> Any): Any
        public fun getMarker(id: Number): IDisplayBufferMarker
        public fun getMarkers(): Array<IDisplayBufferMarker>
        public fun findMarkers(vararg args: Any): Array<IDisplayBufferMarker>
        public fun markScreenRange(vararg args: Any): IDisplayBufferMarker
        public fun markBufferRange(vararg args: Any): IDisplayBufferMarker
        public fun markScreenPosition(vararg args: Any): IDisplayBufferMarker
        public fun markBufferPosition(vararg args: Any): IDisplayBufferMarker
        public fun destroyMarker(vararg args: Any): Boolean
        public fun getMarkerCount(): Number
        public fun hasMultipleCursors(): Boolean
        public fun getCursors(): Array<ICursor>
        public fun getCursor(): ICursor
        public fun addCursorAtScreenPosition(screenPosition: Any): ICursor
        public fun addCursorAtBufferPosition(bufferPosition: Any): ICursor
        public fun addCursor(marker: Any): ICursor
        public fun removeCursor(cursor: Any): Array<ICursor>
        public fun addSelection(marker: Any, options: Any): ISelection
        public fun addSelectionForBufferRange(bufferRange: Any, options: Any): ISelection
        public fun setSelectedBufferRange(bufferRange: Any, options: Any): Any
        public fun setSelectedBufferRanges(bufferRanges: Any, options: Any): Any
        public fun removeSelection(selection: ISelection): Any
        public fun clearSelections(): Boolean
        public fun consolidateSelections(): Boolean
        public fun getSelections(): Array<ISelection>
        public fun getSelection(index: Number? = null): ISelection
        public fun getLastSelection(): ISelection
        public fun getSelectionsOrderedByBufferPosition(): Array<ISelection>
        public fun getLastSelectionInBuffer(): ISelection
        public fun selectionIntersectsBufferRange(bufferRange: Any): Any
        public fun setCursorScreenPosition(position: TextBuffer.IPoint, options: Any? = null): Any
        public fun getCursorScreenPosition(): TextBuffer.IPoint
        public fun getCursorScreenRow(): Number
        public fun setCursorBufferPosition(position: Any, options: Any? = null): Any
        public fun getCursorBufferPosition(): TextBuffer.IPoint
        public fun getSelectedScreenRange(): TextBuffer.IRange
        public fun getSelectedBufferRange(): TextBuffer.IRange
        public fun getSelectedBufferRanges(): Array<TextBuffer.IRange>
        public fun getSelectedText(): String
        public fun getTextInBufferRange(range: TextBuffer.IRange): String
        public fun setTextInBufferRange(range: TextBuffer.IRange, text: String): Any
        public fun getCurrentParagraphBufferRange(): TextBuffer.IRange
        public fun getWordUnderCursor(options: Any? = null): String
        public fun moveCursorUp(lineCount: Number? = null): Unit
        public fun moveCursorDown(lineCount: Number? = null): Unit
        public fun moveCursorLeft(): Unit
        public fun moveCursorRight(): Unit
        public fun moveCursorToTop(): Unit
        public fun moveCursorToBottom(): Unit
        public fun moveCursorToBeginningOfScreenLine(): Unit
        public fun moveCursorToBeginningOfLine(): Unit
        public fun moveCursorToFirstCharacterOfLine(): Unit
        public fun moveCursorToEndOfScreenLine(): Unit
        public fun moveCursorToEndOfLine(): Unit
        public fun moveCursorToBeginningOfWord(): Unit
        public fun moveCursorToEndOfWord(): Unit
        public fun moveCursorToBeginningOfNextWord(): Unit
        public fun moveCursorToPreviousWordBoundary(): Unit
        public fun moveCursorToNextWordBoundary(): Unit
        public fun moveCursors(fn: (cursor: ICursor) -> Any): Any
        public fun selectToScreenPosition(position: TextBuffer.IPoint): Any
        public fun selectRight(): Array<ISelection>
        public fun selectLeft(): Array<ISelection>
        public fun selectUp(rowCount: Number? = null): Array<ISelection>
        public fun selectDown(rowCount: Number? = null): Array<ISelection>
        public fun selectToTop(): Array<ISelection>
        public fun selectAll(): Array<ISelection>
        public fun selectToBottom(): Array<ISelection>
        public fun selectToBeginningOfLine(): Array<ISelection>
        public fun selectToFirstCharacterOfLine(): Array<ISelection>
        public fun selectToEndOfLine(): Array<ISelection>
        public fun selectToPreviousWordBoundary(): Array<ISelection>
        public fun selectToNextWordBoundary(): Array<ISelection>
        public fun selectLine(): Array<ISelection>
        public fun addSelectionBelow(): Array<ISelection>
        public fun addSelectionAbove(): Array<ISelection>
        public fun splitSelectionsIntoLines(): Array<Any>
        public fun transpose(): Array<TextBuffer.IRange>
        public fun upperCase(): Array<Boolean>
        public fun lowerCase(): Array<Boolean>
        public fun joinLines(): Array<Any>
        public fun selectToBeginningOfWord(): Array<ISelection>
        public fun selectToEndOfWord(): Array<ISelection>
        public fun selectToBeginningOfNextWord(): Array<ISelection>
        public fun selectWord(): Array<ISelection>
        public fun selectMarker(marker: Any): Any
        public fun mergeCursors(): Array<Number>
        public fun expandSelectionsForward(): Any
        public fun expandSelectionsBackward(fn: (selection: ISelection) -> Any): Array<ISelection>
        public fun finalizeSelections(): Array<Boolean>
        public fun mergeIntersectingSelections(): Any
        public fun preserveCursorPositionOnBufferReload(): Emissary.ISubscription
        public fun getGrammar(): IGrammar
        public fun setGrammar(grammer: IGrammar): Unit
        public fun reloadGrammar(): Any
        public fun shouldAutoIndent(): Boolean
        public fun transact(fn: Function): Any
        public fun beginTransaction(): ITransaction
        public fun commitTransaction(): Any
        public fun abortTransaction(): Array<Any>
        public fun inspect(): String
        public fun logScreenLines(start: Number, end: Number): Array<Any>
        public fun handleGrammarChange(): Unit
        public fun handleMarkerCreated(marker: Any): Any
        public fun getSelectionMarkerAttributes(): `T$15`
    }
    public trait IGrammar {
        public var scopeName: String
    }
    public trait IPane {
        public var items: Array<Any>
        public var activeItem: Any
        public fun serializeParams(): Any
        public fun deserializeParams(params: Any): Any
        public fun getViewClass(): Any
        public fun isActive(): Boolean
        public fun focus(): Unit
        public fun blur(): Unit
        public fun activate(): Unit
        public fun getPanes(): Array<IPane>
        public fun getItems(): Array<Any>
        public fun getActiveItem(): Any
        public fun getActiveEditor(): Any
        public fun itemAtIndex(index: Number): Any
        public fun activateNextItem(): Any
        public fun activatePreviousItem(): Any
        public fun getActiveItemIndex(): Number
        public fun activateItemAtIndex(index: Number): Any
        public fun activateItem(item: Any): Any
        public fun addItem(item: Any, index: Number): Any
        public fun addItems(items: Array<Any>, index: Number): Array<Any>
        public fun removeItem(item: Any, destroying: Any): Unit
        public fun moveItem(item: Any, newIndex: Number): Unit
        public fun moveItemToPane(item: Any, pane: IPane, index: Number): Unit
        public fun destroyActiveItem(): Boolean
        public fun destroyItem(item: Any): Boolean
        public fun destroyItems(): Array<Any>
        public fun destroyInactiveItems(): Array<Any>
        public fun destroy(): Unit
        public fun destroyed(): Array<Any>
        public fun promptToSaveItem(item: Any): Boolean
        public fun saveActiveItem(): Unit
        public fun saveActiveItemAs(): Unit
        public fun saveItem(item: Any, nextAction: Function): Unit
        public fun saveItemAs(item: Any, nextAction: Function): Unit
        public fun saveItems(): Array<Any>
        public fun itemForUri(uri: Any): Any
        public fun activateItemForUri(uri: Any): Any
        public fun copyActiveItem(): Unit
        public fun splitLeft(params: Any): IPane
        public fun splitRight(params: Any): IPane
        public fun splitUp(params: Any): IPane
        public fun splitDown(params: Any): IPane
        public fun split(orientation: String, side: String, params: Any): IPane
        public fun findLeftmostSibling(): IPane
        public fun findOrCreateRightmostSibling(): IPane
    }
    public trait ISerializationStatic<T> {
        public fun deserialize(data: ISerializationInfo): T
        public fun invoke(data: T): ISerialization
    }
    public trait ISerialization {
        public fun serialize(): ISerializationInfo
    }
    public trait ISerializationInfo {
        public var deserializer: String
    }
    public trait IBrowserWindow {
        public fun getPosition(): Array<Number>
        public fun getSize(): Array<Number>
    }
    public trait IAtomWindowDimentions {
        public var x: Number
        public var y: Number
        public var width: Number
        public var height: Number
    }
    public trait IProjectStatic {
        public fun pathForRepositoryUrl(repoUrl: String): String
        public fun invoke(arg: `T$16`? = null): IProject
    }
    public trait IProject {
        public var path: String
        public var rootDirectory: PathWatcher.IDirectory
        public fun serializeParams(): Any
        public fun deserializeParams(params: Any): Any
        public fun destroyed(): Any
        public fun destroyRepo(): Any
        public fun destroyUnretainedBuffers(): Any
        public fun getRepo(): IGit
        public fun getPath(): String
        public fun setPath(projectPath: String): Any
        public fun getRootDirectory(): PathWatcher.IDirectory
        public fun resolve(uri: String): String
        public fun relativize(fullPath: String): String
        public fun contains(pathToCheck: String): Boolean
        public fun open(filePath: String, options: Any? = null): Q.Promise<IEditor>
        public fun openSync(filePath: String, options: Any? = null): IEditor
        public fun getBuffers(): TextBuffer.ITextBuffer
        public fun isPathModified(filePath: String): Boolean
        public fun findBufferForPath(filePath: String): TextBuffer.ITextBuffer
        public fun bufferForPathSync(filePath: String): TextBuffer.ITextBuffer
        public fun bufferForPath(filePath: String): Q.Promise<TextBuffer.ITextBuffer>
        public fun bufferForId(id: Any): TextBuffer.ITextBuffer
        public fun buildBufferSync(absoluteFilePath: String): TextBuffer.ITextBuffer
        public fun buildBuffer(absoluteFilePath: String): Q.Promise<TextBuffer.ITextBuffer>
        public fun addBuffer(buffer: TextBuffer.ITextBuffer, options: Any? = null): Any
        public fun addBufferAtIndex(buffer: TextBuffer.ITextBuffer, index: Number, options: Any? = null): Any
        public fun scan(regex: Any, options: Any, iterator: Any): Q.Promise<Any>
        public fun replace(regex: Any, replacementText: Any, filePaths: Any, iterator: Any): Q.Promise<Any>
        public fun buildEditorForBuffer(buffer: Any, editorOptions: Any): IEditor
        public fun eachBuffer(vararg args: Any): Any
    }
    public trait IWorkspaceStatic {
        public fun invoke(): IWorkspace
    }
    public trait IWorkspace {
        public fun deserializeParams(params: Any): Any
        public fun serializeParams(): `T$17`
        public fun eachEditor(callback: Function): Unit
        public fun getEditors(): Array<IEditor>
        public fun open(uri: String, options: Any): Q.Promise<View>
        public fun openLicense(): Unit
        public fun openSync(uri: String, options: Any): Any
        public fun openUriInPane(uri: String, pane: Any, options: Any): Q.Promise<View>
        public fun reopenItemSync(): Any
        public fun registerOpener(opener: (urlToOpen: String) -> Any): Unit
        public fun unregisterOpener(opener: Function): Unit
        public fun getOpeners(): Any
        public fun getActivePane(): IPane
        public fun getPanes(): Any
        public fun saveAll(): Unit
        public fun activateNextPane(): Any
        public fun activatePreviousPane(): Any
        public var paneForUri: (uri: String) -> IPane
        public fun saveActivePaneItem(): Any
        public fun saveActivePaneItemAs(): Any
        public fun destroyActivePaneItem(): Any
        public fun destroyActivePane(): Any
        public fun getActiveEditor(): IEditor
        public fun increaseFontSize(): Unit
        public fun decreaseFontSize(): Unit
        public fun resetFontSize(): Unit
        public fun itemOpened(item: Any): Unit
        public fun onPaneItemDestroyed(item: Any): Unit
        public fun destroyed(): Unit
    }
    public trait IAtomSettings {
        public var appVersion: String
        public var bootstrapScript: String
        public var devMode: Boolean
        public var initialPath: String
        public var pathToOpen: String
        public var resourcePath: String
        public var shellLoadTime: Number
        public var windowState: String
    }
    public trait IAtomState {
        public var mode: String
        public var packageStates: Any
        public var project: Any
        public var syntax: Any
        public var version: Number
        public var windowDimensions: Any
        public var workspace: Any
    }
    public trait IDeserializerManager {
        public var deserializers: Function
        public var add: Function
        public var remove: Function
        public var deserialize: Function
        public var get: Function
    }
    public trait IConfig {
        public fun get(keyPath: String): Any
    }
    public trait IKeymapManager {
        public var defaultTarget: HTMLElement
    }
    public trait IPackageManager : Emissary.IEmitter  {
        public var packageDirPaths: Array<String>
        public var loadedPackages: Any
        public var activePackages: Any
        public var packageStates: Any
        public var packageActivators: Array<Any>
        public fun getApmPath(): String
        public fun getPackageDirPaths(): String
        public fun getPackageState(name: String): Any
        public fun setPackageState(name: String, state: Any): Unit
        public fun enablePackage(name: String): Any
        public fun disablePackage(name: String): Any
        public fun activate(): Unit
        public fun registerPackageActivator(activator: Any, types: Any): Unit
        public fun activatePackages(packages: Any): Unit
        public fun activatePackage(name: String): Unit
        public fun deactivatePackages(): Unit
        public fun deactivatePackage(name: String): Unit
        public fun getActivePackages(): Any
        public fun getActivePackage(name: String): Any
        public fun isPackageActive(name: String): Boolean
        public fun unobserveDisabledPackages(): Unit
        public fun observeDisabledPackages(): Unit
        public fun loadPackages(): Unit
        public fun loadPackage(nameOrPath: String): Unit
        public fun unloadPackages(): Unit
        public fun unloadPackage(name: String): Unit
        public fun getLoadedPackage(name: String): Any
        public fun isPackageLoaded(name: String): Boolean
        public fun getLoadedPackages(): Any
        public fun getLoadedPackagesForTypes(types: Any): Array<Any>
        public fun resolvePackagePath(name: String): String
        public fun isPackageDisabled(name: String): Boolean
        public fun hasAtomEngine(packagePath: String): Boolean
        public fun isBundledPackage(name: String): Boolean
        public fun getPackageDependencies(): Any
        public fun getAvailablePackagePaths(): Array<Any>
        public fun getAvailablePackageNames(): Array<Any>
        public fun getAvailablePackageMetadata(): Array<Any>
    }
    public trait IThemeManager
    public trait IContextMenuManager
    public trait IMenuManager
    public trait IClipboard
    public trait ISyntax
    public trait IWindowEventHandler
    public trait IAtomStatic : ISerializationStatic<IAtom> {
        public var version: Number
        public var loadSettings: IAtomSettings
        public fun loadOrCreate(mode: 'editor'): IAtom
        public fun loadOrCreate(mode: 'spec'): IAtom
        public fun loadOrCreate(mode: String): IAtom
        public fun loadState(mode: Any): Unit
        public fun getStatePath(mode: Any): String
        public fun getConfigDirPath(): String
        public fun getStorageDirPath(): String
        public fun getLoadSettings(): IAtomSettings
        public fun getCurrentWindow(): IBrowserWindow
        public fun getVersion(): String
        public fun isReleasedVersion(): Boolean
        public fun invoke(state: IAtomState): IAtom
    }
    public trait IAtom {
        public var constructor: IAtomStatic
        public var state: IAtomState
        public var mode: String
        public var deserializers: IDeserializerManager
        public var config: IConfig
        public var keymaps: IKeymapManager
        public var keymap: IKeymapManager
        public var packages: IPackageManager
        public var themes: IThemeManager
        public var contextManu: IContextMenuManager
        public var menu: IMenuManager
        public var clipboard: IClipboard
        public var syntax: ISyntax
        public var windowEventHandler: IWindowEventHandler
        public var subscribe: Function
        public var unsubscribe: Function
        public var loadTime: Number
        public var workspaceViewParentSelector: String
        public var project: IProject
        public var workspaceView: IWorkspaceView
        public var workspace: IWorkspace
        public var initialize: Function
        public var setBodyPlatformClass: Function
        public fun getCurrentWindow(): IBrowserWindow
        public var getWindowDimensions: Function
        public var setWindowDimensions: Function
        public var restoreWindowDimensions: Function
        public var storeWindowDimensions: Function
        public var getLoadSettings: Function
        public var deserializeProject: Function
        public var deserializeWorkspaceView: Function
        public var deserializePackageStates: Function
        public var deserializeEditorWindow: Function
        public var startEditorWindow: Function
        public var unloadEditorWindow: Function
        public var loadThemes: Function
        public var watchThemes: Function
        public var open: Function
        public var confirm: Function
        public var showSaveDialog: Function
        public var showSaveDialogSync: Function
        public var openDevTools: Function
        public var toggleDevTools: Function
        public var executeJavaScriptInDevTools: Function
        public var reload: Function
        public var focus: Function
        public var show: Function
        public var hide: Function
        public var setSize: Function
        public var setPosition: Function
        public var center: Function
        public var displayWindow: Function
        public var close: Function
        public var exit: Function
        public var inDevMode: Function
        public var inSpecMode: Function
        public var toggleFullScreen: Function
        public var setFullScreen: Function
        public var isFullScreen: Function
        public var getVersion: Function
        public var isReleasedVersion: Function
        public var getGitHubAuthTokenName: Function
        public var setGitHubAuthToken: Function
        public var getGitHubAuthToken: Function
        public var getConfigDirPath: Function
        public var saveSync: Function
        public fun getWindowLoadTime(): Number
        public var crashMainProcess: Function
        public var crashRenderProcess: Function
        public var beep: Function
        public var getUserInitScriptPath: Function
        public var requireUserInitScript: Function
        public var requireWithGlobals: Function
    }
    public trait IBufferedNodeProcessStatic {
        public fun invoke(arg: Any): IBufferedNodeProcess
    }
    public trait IBufferedNodeProcess : IBufferedProcess
    public trait IBufferedProcessStatic {
        public fun invoke(arg: Any): IBufferedProcess
    }
    public trait IBufferedProcess {
        public var process: Function
        public var killed: Boolean
        public var bufferStream: Function
        public var kill: Function
    }
    public trait IGitStatic {
        public fun invoke(path: Any, options: Any): IGit
    }
    public trait IGit
    public trait ITokenizedBuffer
    public trait ITokenizedLine
    public trait IToken
    public trait IFoldStatic {
        public fun invoke(displayBuffer: IDisplayBuffer, marker: IMarker): IFold
    }
    public trait IFold {
        public var id: Number
        public var displayBuffer: IDisplayBuffer
        public var marker: IMarker
    }
    public trait IDisplayBufferMarkerStatic {
        public fun invoke(_arg: `T$18`): IDisplayBufferMarker
    }
    public trait IDisplayBufferMarker : Emissary.IEmitter, Emissary.ISubscriber  {
        public var constructor: IDisplayBufferMarkerStatic
        public var id: Number
        public var bufferMarkerSubscription: Any
        public var oldHeadBufferPosition: TextBuffer.IPoint
        public var oldHeadScreenPosition: TextBuffer.IPoint
        public var oldTailBufferPosition: TextBuffer.IPoint
        public var oldTailScreenPosition: TextBuffer.IPoint
        public var wasValid: Boolean
        public var bufferMarker: IMarker
        public var displayBuffer: IDisplayBuffer
        public var globalPauseCount: Number
        public var globalQueuedEvents: Any
        public var subscriptions: Array<Emissary.ISubscription>
        public var subscriptionsByObject: Any
        public fun copy(attributes: Any? = null): IDisplayBufferMarker
        public fun getScreenRange(): TextBuffer.IRange
        public fun setScreenRange(screenRange: Any, options: Any): Any
        public fun getBufferRange(): TextBuffer.IRange
        public fun setBufferRange(bufferRange: Any, options: Any): Any
        public fun getPixelRange(): Any
        public fun getHeadScreenPosition(): TextBuffer.IPoint
        public fun setHeadScreenPosition(screenPosition: Any, options: Any): Any
        public fun getHeadBufferPosition(): TextBuffer.IPoint
        public fun setHeadBufferPosition(bufferPosition: Any): Any
        public fun getTailScreenPosition(): TextBuffer.IPoint
        public fun setTailScreenPosition(screenPosition: Any, options: Any): Any
        public fun getTailBufferPosition(): TextBuffer.IPoint
        public fun setTailBufferPosition(bufferPosition: Any): Any
        public fun plantTail(): Boolean
        public fun clearTail(): Boolean
        public fun hasTail(): Boolean
        public fun isReversed(): Boolean
        public fun isValid(): Boolean
        public fun isDestroyed(): Boolean
        public fun getAttributes(): Any
        public fun setAttributes(attributes: Any): Any
        public fun matchesAttributes(attributes: Any): Any
        public fun destroy(): Any
        public fun isEqual(other: IDisplayBufferMarker): Boolean
        public fun compare(other: IDisplayBufferMarker): Boolean
        public fun inspect(): String
        public fun destroyed(): Any
        public fun notifyObservers(_arg: Any): Any
    }
    public trait ITransaction
    public trait IMarker : Emissary.IEmitter 
    public trait ITaskStatic {
        public fun invoke(taskPath: Any): ITask
    }
    public trait ITask
}
native
module
public trait atom {
    public var `$`: `typeof spacePen.$` = noImpl
    public var `$$`: `typeof spacePen.$$` = noImpl
    public var `$$$`: `typeof spacePen.$$$` = noImpl
    public var BufferedNodeProcess: AtomCore.IBufferedNodeProcessStatic = noImpl
    public var BufferedProcess: AtomCore.IBufferedProcessStatic = noImpl
    public var Git: AtomCore.IGitStatic = noImpl
    public var Point: TextBuffer.IPointStatic = noImpl
    public var Range: TextBuffer.IRangeStatic = noImpl
    public class View : spacePen.View , Emissary.ISubscriber  {
        public fun subscribeWith(eventEmitter: Any, methodName: String, args: Any): Any = noImpl
        public fun addSubscription(subscription: Any): Any = noImpl
        public fun subscribe(eventEmitterOrSubscription: Any, vararg args: Any): Any = noImpl
        public fun subscribeToCommand(eventEmitter: Any, vararg args: Any): Any = noImpl
        public fun unsubscribe(`object`: Any? = null): Any = noImpl
    }
    public class EditorView(editor: AtomCore.IEditor) : View {
        public var vScrollMargin: Number = noImpl
        public var hScrollMargin: Number = noImpl
        public var lineHeight: Any = noImpl
        public var charWidth: Any = noImpl
        public var charHeight: Any = noImpl
        public var cursorViews: Array<Any> = noImpl
        public var selectionViews: Array<Any> = noImpl
        public var lineCache: Array<Any> = noImpl
        public var isFocused: Any = noImpl
        public var editor: AtomCore.IEditor = noImpl
        public var attached: Any = noImpl
        public var lineOverdraw: Number = noImpl
        public var pendingChanges: Array<Any> = noImpl
        public var newCursors: Array<Any> = noImpl
        public var newSelections: Array<Any> = noImpl
        public var redrawOnReattach: Any = noImpl
        public var bottomPaddingInLines: Number = noImpl
        public var active: Boolean = noImpl
        public var id: Number = noImpl
        public var gutter: AtomCore.IGutterView = noImpl
        public var overlayer: JQuery = noImpl
        public var scrollView: JQuery = noImpl
        public var renderedLines: JQuery = noImpl
        public var underlayer: JQuery = noImpl
        public var hiddenInput: JQuery = noImpl
        public var verticalScrollbar: JQuery = noImpl
        public var verticalScrollbarContent: JQuery = noImpl
        public fun initialize(editorOrOptions: AtomCore.IEditor): Unit = noImpl
        public fun initialize(editorOrOptions: `T$20`? = null): Unit = noImpl
        public fun initialize(editorOrOptions: Any): Unit = noImpl
        public fun bindKeys(): Unit = noImpl
        public fun getEditor(): AtomCore.IEditor = noImpl
        public fun getText(): String = noImpl
        public fun setText(text: String): Unit = noImpl
        public fun insertText(text: String, options: Any? = null): Array<TextBuffer.IRange> = noImpl
        public fun setHeightInLines(heightInLines: Number): Number = noImpl
        public fun setWidthInChars(widthInChars: Number): Number = noImpl
        public fun pageDown(): Unit = noImpl
        public fun pageUp(): Unit = noImpl
        public fun getPageRows(): Number = noImpl
        public fun setShowInvisibles(showInvisibles: Boolean): Unit = noImpl
        public fun setInvisibles(invisibles: `T$21`): Unit = noImpl
        public fun setShowIndentGuide(showIndentGuide: Boolean): Unit = noImpl
        public fun setPlaceholderText(placeholderText: String): Unit = noImpl
        public fun getPlaceholderText(): String = noImpl
        public fun checkoutHead(): Boolean = noImpl
        public fun configure(): Emissary.ISubscription = noImpl
        public fun handleEvents(): Unit = noImpl
        public fun handleInputEvents(): Unit = noImpl
        public fun bringHiddenInputIntoView(): JQuery = noImpl
        public fun selectOnMousemoveUntilMouseup(): Any = noImpl
        public fun afterAttach(onDom: Any): Any = noImpl
        public fun edit(editor: AtomCore.IEditor): Any = noImpl
        public fun getModel(): AtomCore.IEditor = noImpl
        public fun setModel(editor: AtomCore.IEditor): Any = noImpl
        public fun showBufferConflictAlert(editor: AtomCore.IEditor): Any = noImpl
        public fun scrollTop(scrollTop: Number, options: Any? = null): Any = noImpl
        public fun scrollBottom(scrollBottom: Number? = null): Any = noImpl
        public fun scrollLeft(scrollLeft: Number? = null): Number = noImpl
        public fun scrollRight(scrollRight: Number? = null): Any = noImpl
        public fun scrollToBottom(): Any = noImpl
        public fun scrollToCursorPosition(): Any = noImpl
        public fun scrollToBufferPosition(bufferPosition: Any, options: Any): Any = noImpl
        public fun scrollToScreenPosition(screenPosition: Any, options: Any): Any = noImpl
        public fun scrollToPixelPosition(pixelPosition: Any, options: Any): Any = noImpl
        public fun highlightFoldsContainingBufferRange(bufferRange: Any): Any = noImpl
        public fun saveScrollPositionForEditor(): Any = noImpl
        public fun toggleSoftTabs(): Any = noImpl
        public fun toggleSoftWrap(): Any = noImpl
        public fun calculateWidthInChars(): Number = noImpl
        public fun calculateHeightInLines(): Number = noImpl
        public fun getScrollbarWidth(): Number = noImpl
        public fun setSoftWrap(softWrap: Boolean): Any = noImpl
        public fun setFontSize(fontSize: Number): Any = noImpl
        public fun getFontSize(): Number = noImpl
        public fun setFontFamily(fontFamily: String? = null): Any = noImpl
        public fun getFontFamily(): String = noImpl
        public fun setLineHeight(lineHeight: Number): Any = noImpl
        public fun redraw(): Any = noImpl
        public fun splitLeft(): Any = noImpl
        public fun splitRight(): Any = noImpl
        public fun splitUp(): Any = noImpl
        public fun splitDown(): Any = noImpl
        public fun getPane(): Any = noImpl
        public fun remove(selector: Any, keepData: Any): Any = noImpl
        public fun beforeRemove(): Any = noImpl
        public fun getCursorView(index: Number? = null): Any = noImpl
        public fun getCursorViews(): Array<Any> = noImpl
        public fun addCursorView(cursor: Any, options: Any): Any = noImpl
        public fun removeCursorView(cursorView: Any): Any = noImpl
        public fun getSelectionView(index: Number? = null): Any = noImpl
        public fun getSelectionViews(): Array<Any> = noImpl
        public fun addSelectionView(selection: Any): Any = noImpl
        public fun removeSelectionView(selectionView: Any): Any = noImpl
        public fun removeAllCursorAndSelectionViews(): Array<Any> = noImpl
        public fun appendToLinesView(view: Any): Any = noImpl
        public fun scrollVertically(pixelPosition: Any, _arg: Any): Any = noImpl
        public fun scrollHorizontally(pixelPosition: Any): Any = noImpl
        public fun calculateDimensions(): Number = noImpl
        public fun recalculateDimensions(): Any = noImpl
        public fun updateLayerDimensions(): Any = noImpl
        public fun isHidden(): Boolean = noImpl
        public fun clearRenderedLines(): Unit = noImpl
        public fun resetDisplay(): Any = noImpl
        public fun requestDisplayUpdate(): Any = noImpl
        public fun updateDisplay(options: Any? = null): Any = noImpl
        public fun updateCursorViews(): Any = noImpl
        public fun shouldUpdateCursor(cursorView: Any): Any = noImpl
        public fun updateSelectionViews(): Array<Any> = noImpl
        public fun shouldUpdateSelection(selectionView: Any): Any = noImpl
        public fun syncCursorAnimations(): Array<Any> = noImpl
        public fun autoscroll(suppressAutoscroll: Any? = null): Array<Any> = noImpl
        public fun updatePlaceholderText(): Any = noImpl
        public fun updateRenderedLines(scrollViewWidth: Any): Any = noImpl
        public fun computeSurroundingEmptyLineChanges(change: Any): Any = noImpl
        public fun computeIntactRanges(renderFrom: Any, renderTo: Any): Any = noImpl
        public fun truncateIntactRanges(intactRanges: Any, renderFrom: Any, renderTo: Any): Any = noImpl
        public fun clearDirtyRanges(intactRanges: Any): Any = noImpl
        public fun clearLine(lineElement: Any): Any = noImpl
        public fun fillDirtyRanges(intactRanges: Any, renderFrom: Any, renderTo: Any): Any = noImpl
        public fun updatePaddingOfRenderedLines(): Any = noImpl
        public fun getFirstVisibleScreenRow(): Number = noImpl
        public fun getLastVisibleScreenRow(): Number = noImpl
        public fun isScreenRowVisible(): Boolean = noImpl
        public fun handleScreenLinesChange(change: Any): Any = noImpl
        public fun buildLineElementForScreenRow(screenRow: Any): Any = noImpl
        public fun buildLineElementsForScreenRows(startRow: Any, endRow: Any): Any = noImpl
        public fun htmlForScreenRows(startRow: Any, endRow: Any): Any = noImpl
        public fun htmlForScreenLine(screenLine: Any, screenRow: Any): Any = noImpl
        public fun buildIndentation(screenRow: Any, editor: Any): Any = noImpl
        public fun buildHtmlEndOfLineInvisibles(screenLine: Any): Any = noImpl
        public fun getEndOfLineInvisibles(screenLine: Any): Any = noImpl
        public fun lineElementForScreenRow(screenRow: Any): Any = noImpl
        public fun toggleLineCommentsInSelection(): Any = noImpl
        public fun pixelPositionForBufferPosition(position: Any): Any = noImpl
        public fun pixelPositionForScreenPosition(position: Any): Any = noImpl
        public fun positionLeftForLineAndColumn(lineElement: Any, screenRow: Any, screenColumn: Any): Any = noImpl
        public fun measureToColumn(lineElement: Any, tokenizedLine: Any, screenColumn: Any): Any = noImpl
        public fun getCharacterWidthCache(scopes: Any, char: Any): Any = noImpl
        public fun setCharacterWidthCache(scopes: Any, char: Any, `val`: Any): Any = noImpl
        public fun clearCharacterWidthCache(): Any = noImpl
        public fun pixelOffsetForScreenPosition(position: Any): Any = noImpl
        public fun screenPositionFromMouseEvent(e: Any): Any = noImpl
        public fun highlightCursorLine(): Any = noImpl
        public fun copyPathToClipboard(): Any = noImpl
        public fun buildLineHtml(_arg: Any): Any = noImpl
        public fun updateScopeStack(line: Any, scopeStack: Any, desiredScopes: Any): Any = noImpl
        public fun pushScope(line: Any, scopeStack: Any, scope: Any): Any = noImpl
        public fun popScope(line: Any, scopeStack: Any): Any = noImpl
        public fun buildEmptyLineHtml(showIndentGuide: Any, eolInvisibles: Any, htmlEolInvisibles: Any, indentation: Any, editor: Any, mini: Any): Any = noImpl
        public fun replaceSelectedText(replaceFn: (str: String) -> String): Any = noImpl
        public fun consolidateSelections(e: Any): Any = noImpl
        public fun logCursorScope(): Any = noImpl
        public fun logScreenLines(start: Any, end: Any): Any = noImpl
        public fun logRenderedLines(): Any = noImpl
        public class object {
            public var characterWidthCache: Any = noImpl
            public var configDefaults: Any = noImpl
            public var nextEditorId: Number = noImpl
            public fun content(params: Any): Unit = noImpl
            public fun classes(_arg: `T$19`? = null): String = noImpl
        }
    }
    public class ScrollView : View
    public trait ISelectListItem {
        public var eventName: String
        public var eventDescription: String
    }
    public class SelectListView : View {
        public var maxItems: Number = noImpl
        public var scheduleTimeout: Any = noImpl
        public var inputThrottle: Number = noImpl
        public var cancelling: Boolean = noImpl
        public var items: Array<Any> = noImpl
        public var list: JQuery = noImpl
        public var previouslyFocusedElement: JQuery = noImpl
        public fun initialize(): Any = noImpl
        public fun schedulePopulateList(): Number = noImpl
        public fun setItems(items: Array<Any>): Any = noImpl
        public fun setError(message: String? = null): Any = noImpl
        public fun setLoading(message: String? = null): Any = noImpl
        public fun getFilterQuery(): String = noImpl
        public fun populateList(): Any = noImpl
        public fun getEmptyMessage(itemCount: Any? = null, filteredItemCount: Any? = null): String = noImpl
        public fun setMaxItems(maxItems: Number): Unit = noImpl
        public fun selectPreviousItemView(): Any = noImpl
        public fun selectNextItemView(): Any = noImpl
        public fun selectItemView(view: Any): Any = noImpl
        public fun scrollToItemView(view: Any): Any = noImpl
        public fun getSelectedItemView(): Any = noImpl
        public fun getSelectedItem(): Any = noImpl
        public fun confirmSelection(): Any = noImpl
        public fun viewForItem(item: Any): JQuery = noImpl
        public fun confirmed(item: Any): Any = noImpl
        public fun getFilterKey(): Any = noImpl
        public fun focusFilterEditor(): Any = noImpl
        public fun storeFocusedElement(): Any = noImpl
        public fun restoreFocus(): Any = noImpl
        public fun cancelled(): Any = noImpl
        public fun cancel(): Any = noImpl
        public class object {
            public fun content(): Any = noImpl
        }
    }
    public var WorkspaceView: AtomCore.IWorkspaceViewStatic = noImpl
    public var Task: AtomCore.ITaskStatic = noImpl
    public var Workspace: AtomCore.IWorkspaceStatic = noImpl
    public class object : AtomCore.IAtom by noImpl: AtomCore.IAtom {

    }
}
native
public trait `T$19` {
    public var mini: Any?
}
native
public trait `T$20` {
    public var editor: AtomCore.IEditor
    public var mini: Any
    public var placeholderText: Any
}
native
public trait `T$21` {
    public var eol: String
    public var space: String
    public var tab: String
    public var cr: String
}
