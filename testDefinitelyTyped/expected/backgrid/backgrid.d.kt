// OUT:
// WRONG DECLARATIONS -- manu non-exported declarations
package backgrid

module
public object Backgrid {
    public trait GridOptions {
        public var columns: Array<Column>
        public var collection: Backbone.Collection<Backbone.Model>
        public var header: Header
        public var body: Body
        public var row: Row
        public var footer: Footer
    }
    public trait ColumnAttr {
        public var name: String
        public var cell: String
        public var headerCell: String
        public var label: String
        public var sortable: Boolean
        public var editable: Boolean
        public var renderable: Boolean
        public var formater: String
    }
}
