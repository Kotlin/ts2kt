'use strict';(function() {
  Array.isArray || (Array.isArray = function(d) {
    return"[object Array]" === Object.prototype.toString.call(d)
  });
  Function.prototype.bind || (Function.prototype.bind = function(d) {
    if(typeof this !== "function") {
      throw new TypeError("Function.prototype.bind - what is trying to be bound is not callable");
    }
    var h = Array.prototype.slice.call(arguments, 1), g = this, e = function() {
    }, a = function() {
      return g.apply(this instanceof e && d ? this : d, h.concat(Array.prototype.slice.call(arguments)))
    };
    e.prototype = this.prototype;
    a.prototype = new e;
    return a
  });
  Object.keys || (Object.keys = function(d) {
    var h = [], g = 0, e;
    for(e in d) {
      d.hasOwnProperty(e) && (h[g++] = e)
    }
    return h
  });
  Object.create || (Object.create = function(d) {
    function h() {
    }
    h.prototype = d;
    return new h
  });
  "function" !== typeof Object.getPrototypeOf && (Object.getPrototypeOf = "object" === typeof"test".__proto__ ? function(d) {
    return d.__proto__
  } : function(d) {
    return d.constructor.prototype
  })
})();
var Kotlin = {};
(function() {
  function d(a, b) {
    if(!(null == a || null == b)) {
      for(var c in b) {
        b.hasOwnProperty(c) && (a[c] = b[c])
      }
    }
  }
  function h(a) {
    for(var b = 0;b < a.length;b++) {
      if(g(a[b]) || a[b].$metadata$.type === Kotlin.TYPE.CLASS) {
        return a[b]
      }
    }
    return null
  }
  function g(a) {
    return null != a && null == a.$metadata$
  }
  function e(a, b, c) {
    for(var d = 0;d < b.length;d++) {
      if(!g(b[d])) {
        var f = c(b[d]), e;
        for(e in f) {
          if(f.hasOwnProperty(e) && (!a.hasOwnProperty(e) || a[e].$classIndex$ < f[e].$classIndex$)) {
            a[e] = f[e]
          }
        }
      }
    }
  }
  function a(a, b) {
    var c = {};
    c.baseClasses = null == a ? [] : Array.isArray(a) ? a : [a];
    c.baseClass = h(c.baseClasses);
    c.classIndex = Kotlin.newClassIndex();
    c.functions = {};
    c.properties = {};
    if(null != b) {
      for(var d in b) {
        if(b.hasOwnProperty(d)) {
          var f = b[d];
          f.$classIndex$ = c.classIndex;
          "function" === typeof f ? c.functions[d] = f : c.properties[d] = f
        }
      }
    }
    e(c.functions, c.baseClasses, function(a) {
      return a.$metadata$.functions
    });
    e(c.properties, c.baseClasses, function(a) {
      return a.$metadata$.properties
    });
    return c
  }
  function b() {
    var a = this.object_initializer$();
    Object.defineProperty(this, "object", {value:a});
    return a
  }
  function c(a, b) {
    if(g(a) || a.$metadata$.classIndex < b.$metadata$.classIndex) {
      return!1
    }
    var d = a.$metadata$.baseClasses, f;
    for(f = 0;f < d.length;f++) {
      if(d[f] === b) {
        return!0
      }
    }
    for(f = 0;f < d.length;f++) {
      if(c(d[f], b)) {
        return!0
      }
    }
    return!1
  }
  function f(a, b) {
    return function() {
      if(null !== b) {
        var c = b;
        b = null;
        c.call(a)
      }
      return a
    }
  }
  function i(a) {
    var b = {};
    if(null == a) {
      return b
    }
    for(var c in a) {
      a.hasOwnProperty(c) && ("function" === typeof a[c] ? b[c] = a[c] : Object.defineProperty(b, c, a[c]))
    }
    return b
  }
  var j = function() {
    return function() {
    }
  };
  Kotlin.TYPE = {CLASS:"class", TRAIT:"trait", OBJECT:"object"};
  Kotlin.classCount = 0;
  Kotlin.newClassIndex = function() {
    var a = Kotlin.classCount;
    Kotlin.classCount++;
    return a
  };
  Kotlin.createClass = function(c, f, e, g) {
    null == f && (f = j());
    d(f, g);
    c = a(c, e);
    c.type = Kotlin.TYPE.CLASS;
    e = null !== c.baseClass ? Object.create(c.baseClass.prototype) : {};
    Object.defineProperties(e, c.properties);
    d(e, c.functions);
    e.constructor = f;
    null != c.baseClass && (f.baseInitializer = c.baseClass);
    f.$metadata$ = c;
    f.prototype = e;
    Object.defineProperty(f, "object", {get:b, configurable:!0});
    return f
  };
  Kotlin.createObject = function(a, b, c) {
    a = new (Kotlin.createClass(a, b, c));
    a.$metadata$ = {type:Kotlin.TYPE.OBJECT};
    return a
  };
  Kotlin.createTrait = function(b, c, f) {
    var e = function() {
    };
    d(e, f);
    e.$metadata$ = a(b, c);
    e.$metadata$.type = Kotlin.TYPE.TRAIT;
    return e
  };
  Kotlin.isType = function(a, b) {
    return null == a || null == b ? !1 : a instanceof b ? !0 : g(b) || b.$metadata$.type == Kotlin.TYPE.CLASS ? !1 : c(a.constructor, b)
  };
  Kotlin.definePackage = function(a, b) {
    var c = i(b);
    return null === a ? {value:c} : {get:f(c, a)}
  };
  Kotlin.defineRootPackage = function(a, b) {
    var c = i(b);
    c.$initializer$ = null === a ? j() : a;
    return c
  };
  Kotlin.defineModule = function(a, b) {
    if(a in Kotlin.modules) {
      throw Error("Module " + a + " is already defined");
    }
    b.$initializer$.call(b);
    Object.defineProperty(Kotlin.modules, a, {value:b})
  }
})();
String.prototype.startsWith = function(d) {
  return 0 === this.indexOf(d)
};
String.prototype.endsWith = function(d) {
  return-1 !== this.indexOf(d, this.length - d.length)
};
String.prototype.contains = function(d) {
  return-1 !== this.indexOf(d)
};
(function() {
  function d(a) {
    return function() {
      throw new TypeError(void 0 !== a ? "Function " + a + " is abstract" : "Function is abstract");
    }
  }
  Kotlin.equals = function(a, b) {
    return null == a ? null == b : Array.isArray(a) ? Kotlin.arrayEquals(a, b) : "object" == typeof a && void 0 !== a.equals ? a.equals(b) : a === b
  };
  Kotlin.toString = function(a) {
    return null == a ? "null" : Array.isArray(a) ? Kotlin.arrayToString(a) : a.toString()
  };
  Kotlin.arrayToString = function(a) {
    return"[" + a.join(", ") + "]"
  };
  Kotlin.intUpto = function(a, b) {
    return new Kotlin.NumberRange(a, b)
  };
  Kotlin.intDownto = function(a, b) {
    return new Kotlin.Progression(a, b, -1)
  };
  Kotlin.modules = {};
  Kotlin.RuntimeException = Kotlin.createClass();
  Kotlin.NullPointerException = Kotlin.createClass();
  Kotlin.NoSuchElementException = Kotlin.createClass();
  Kotlin.IllegalArgumentException = Kotlin.createClass();
  Kotlin.IllegalStateException = Kotlin.createClass();
  Kotlin.UnsupportedOperationException = Kotlin.createClass();
  Kotlin.IOException = Kotlin.createClass();
  Kotlin.throwNPE = function() {
    throw new Kotlin.NullPointerException;
  };
  Kotlin.Iterator = Kotlin.createClass(null, null, {next:d("Iterator#next"), hasNext:d("Iterator#hasNext")});
  var h = Kotlin.createClass(Kotlin.Iterator, function(a) {
    this.array = a;
    this.size = a.length;
    this.index = 0
  }, {next:function() {
    return this.array[this.index++]
  }, hasNext:function() {
    return this.index < this.size
  }}), g = Kotlin.createClass(h, function(a) {
    this.list = a;
    this.size = a.size();
    this.index = 0
  }, {next:function() {
    return this.list.get(this.index++)
  }});
  Kotlin.Collection = Kotlin.createClass();
  Kotlin.Enum = Kotlin.createClass(null, function() {
    this.ordinal$ = this.name$ = void 0
  }, {name:function() {
    return this.name$
  }, ordinal:function() {
    return this.ordinal$
  }, toString:function() {
    return this.name()
  }});
  (function() {
    function a(a) {
      return this[a]
    }
    function b() {
      return this.values$
    }
    Kotlin.createEnumEntries = function(c) {
      var f = 0, e = [], d;
      for(d in c) {
        if(c.hasOwnProperty(d)) {
          var g = c[d];
          e[f] = g;
          g.ordinal$ = f;
          g.name$ = d;
          f++
        }
      }
      c.values$ = e;
      c.valueOf = a;
      c.values = b;
      return c
    }
  })();
  Kotlin.PropertyMetadata = Kotlin.createClass(null, function(a) {
    this.name = a
  });
  Kotlin.AbstractCollection = Kotlin.createClass(Kotlin.Collection, null, {size:function() {
    return this.$size
  }, addAll:function(a) {
    for(var a = a.iterator(), b = this.size();0 < b--;) {
      this.add(a.next())
    }
  }, isEmpty:function() {
    return 0 === this.size()
  }, iterator:function() {
    return new h(this.toArray())
  }, equals:function(a) {
    if(this.size() !== a.size()) {
      return!1
    }
    for(var b = this.iterator(), a = a.iterator(), c = this.size();0 < c--;) {
      if(!Kotlin.equals(b.next(), a.next())) {
        return!1
      }
    }
    return!0
  }, toString:function() {
    for(var a = "[", b = this.iterator(), c = !0, f = this.$size;0 < f--;) {
      c ? c = !1 : a += ", ", a += b.next()
    }
    return a + "]"
  }, toJSON:function() {
    return this.toArray()
  }});
  Kotlin.AbstractList = Kotlin.createClass(Kotlin.AbstractCollection, null, {iterator:function() {
    return new g(this)
  }, remove:function(a) {
    a = this.indexOf(a);
    -1 !== a && this.removeAt(a)
  }, contains:function(a) {
    return-1 !== this.indexOf(a)
  }});
  Kotlin.ArrayList = Kotlin.createClass(Kotlin.AbstractList, function() {
    this.array = [];
    this.$size = 0
  }, {get:function(a) {
    this.checkRange(a);
    return this.array[a]
  }, set:function(a, b) {
    this.checkRange(a);
    this.array[a] = b
  }, size:function() {
    return this.$size
  }, iterator:function() {
    return Kotlin.arrayIterator(this.array)
  }, add:function(a) {
    this.array[this.$size++] = a
  }, addAt:function(a, b) {
    this.array.splice(a, 0, b);
    this.$size++
  }, addAll:function(a) {
    for(var b = a.iterator(), c = this.$size, f = a.size();0 < f--;) {
      this.array[c++] = b.next()
    }
    this.$size += a.size()
  }, removeAt:function(a) {
    this.checkRange(a);
    this.$size--;
    return this.array.splice(a, 1)[0]
  }, clear:function() {
    this.$size = this.array.length = 0
  }, indexOf:function(a) {
    for(var b = 0, c = this.$size;b < c;++b) {
      if(Kotlin.equals(this.array[b], a)) {
        return b
      }
    }
    return-1
  }, toArray:function() {
    return this.array.slice(0, this.$size)
  }, toString:function() {
    return"[" + this.array.join(", ") + "]"
  }, toJSON:function() {
    return this.array
  }, checkRange:function(a) {
    if(0 > a || a >= this.$size) {
      throw new RangeError;
    }
  }});
  Kotlin.Runnable = Kotlin.createClass(null, null, {run:d("Runnable#run")});
  Kotlin.Comparable = Kotlin.createClass(null, null, {compareTo:d("Comparable#compareTo")});
  Kotlin.Appendable = Kotlin.createClass(null, null, {append:d("Appendable#append")});
  Kotlin.Closeable = Kotlin.createClass(null, null, {close:d("Closeable#close")});
  Kotlin.safeParseInt = function(a) {
    a = parseInt(a, 10);
    return isNaN(a) ? null : a
  };
  Kotlin.safeParseDouble = function(a) {
    a = parseFloat(a);
    return isNaN(a) ? null : a
  };
  Kotlin.arrayEquals = function(a, b) {
    if(a === b) {
      return!0
    }
    if(!Array.isArray(b) || a.length !== b.length) {
      return!1
    }
    for(var c = 0, f = a.length;c < f;c++) {
      if(!Kotlin.equals(a[c], b[c])) {
        return!1
      }
    }
    return!0
  };
  Kotlin.System = function() {
    var a = "", b = function(b) {
      void 0 !== b && (a = null === b || "object" !== typeof b ? a + b : a + b.toString())
    }, c = function(b) {
      this.print(b);
      a += "\n"
    };
    return{out:function() {
      return{print:b, println:c}
    }, output:function() {
      return a
    }, flush:function() {
      a = ""
    }}
  }();
  Kotlin.println = function(a) {
    Kotlin.System.out().println(a)
  };
  Kotlin.print = function(a) {
    Kotlin.System.out().print(a)
  };
  Kotlin.RangeIterator = Kotlin.createClass(Kotlin.Iterator, function(a, b, c) {
    this.start = a;
    this.end = b;
    this.increment = c;
    this.i = a
  }, {next:function() {
    var a = this.i;
    this.i += this.increment;
    return a
  }, hasNext:function() {
    return this.i <= this.end
  }});
  Kotlin.NumberRange = Kotlin.createClass(null, function(a, b) {
    this.start = a;
    this.end = b;
    this.increment = 1
  }, {contains:function(a) {
    return this.start <= a && a <= this.end
  }, iterator:function() {
    return new Kotlin.RangeIterator(this.start, this.end)
  }});
  Kotlin.Progression = Kotlin.createClass(null, function(a, b, c) {
    this.start = a;
    this.end = b;
    this.increment = c
  }, {iterator:function() {
    return new Kotlin.RangeIterator(this.start, this.end, this.increment)
  }});
  Kotlin.Comparator = Kotlin.createClass(null, null, {compare:d("Comparator#compare")});
  var e = Kotlin.createClass(Kotlin.Comparator, function(a) {
    this.compare = a
  });
  Kotlin.comparator = function(a) {
    return new e(a)
  };
  Kotlin.collectionsMax = function(a, b) {
    if(a.isEmpty()) {
      throw Error();
    }
    for(var c = a.iterator(), f = c.next();c.hasNext();) {
      var d = c.next();
      0 > b.compare(f, d) && (f = d)
    }
    return f
  };
  Kotlin.collectionsSort = function(a, b) {
    var c = void 0;
    void 0 !== b && (c = b.compare.bind(b));
    a instanceof Array && a.sort(c);
    for(var d = [], e = a.iterator();e.hasNext();) {
      d.push(e.next())
    }
    d.sort(c);
    c = 0;
    for(e = d.length;c < e;c++) {
      a.set(c, d[c])
    }
  };
  Kotlin.copyToArray = function(a) {
    for(var b = [], a = a.iterator();a.hasNext();) {
      b.push(a.next())
    }
    return b
  };
  Kotlin.StringBuilder = Kotlin.createClass(null, function() {
    this.string = ""
  }, {append:function(a) {
    this.string += a.toString()
  }, toString:function() {
    return this.string
  }});
  Kotlin.splitString = function(a, b, c) {
    return a.split(RegExp(b), c)
  };
  Kotlin.nullArray = function(a) {
    for(var b = [];0 < a;) {
      b[--a] = null
    }
    return b
  };
  Kotlin.numberArrayOfSize = function(a) {
    return Kotlin.arrayFromFun(a, function() {
      return 0
    })
  };
  Kotlin.charArrayOfSize = function(a) {
    return Kotlin.arrayFromFun(a, function() {
      return"\x00"
    })
  };
  Kotlin.booleanArrayOfSize = function(a) {
    return Kotlin.arrayFromFun(a, function() {
      return!1
    })
  };
  Kotlin.arrayFromFun = function(a, b) {
    for(var c = Array(a), d = 0;d < a;d++) {
      c[d] = b(d)
    }
    return c
  };
  Kotlin.arrayIndices = function(a) {
    return new Kotlin.NumberRange(0, a.length - 1)
  };
  Kotlin.arrayIterator = function(a) {
    return new h(a)
  };
  Kotlin.jsonFromTuples = function(a) {
    for(var b = a.length, c = {};0 < b;) {
      --b, c[a[b][0]] = a[b][1]
    }
    return c
  };
  Kotlin.jsonAddProperties = function(a, b) {
    for(var c in b) {
      b.hasOwnProperty(c) && (a[c] = b[c])
    }
    return a
  }
})();
Kotlin.assignOwner = function(d, h) {
  d.o = h;
  return d
};
(function() {
  function d(a) {
    return"string" == typeof a ? a : typeof a.hashCode == i ? (a = a.hashCode(), "string" == typeof a ? a : d(a)) : typeof a.toString == i ? a.toString() : "" + a
  }
  function h(a, b) {
    return a.equals(b)
  }
  function g(a, b) {
    return typeof b.equals == i ? b.equals(a) : a === b
  }
  function e(a) {
    return function(b) {
      if(null === b) {
        throw Error("null is not a valid " + a);
      }
      if("undefined" == typeof b) {
        throw Error(a + " must not be undefined");
      }
    }
  }
  function a(a, b, c, d) {
    this[0] = a;
    this.entries = [];
    this.addEntry(b, c);
    null !== d && (this.getEqualityFunction = function() {
      return d
    })
  }
  function b(a) {
    return function(b) {
      for(var c = this.entries.length, d, e = this.getEqualityFunction(b);c--;) {
        if(d = this.entries[c], e(b, d[0])) {
          switch(a) {
            case l:
              return!0;
            case p:
              return d;
            case q:
              return[c, d[1]]
          }
        }
      }
      return!1
    }
  }
  function c(a) {
    return function(b) {
      for(var c = b.length, d = 0, e = this.entries.length;d < e;++d) {
        b[c + d] = this.entries[d][a]
      }
    }
  }
  function f(b, c) {
    var d = b[c];
    return d && d instanceof a ? d : null
  }
  var i = "function", j = typeof Array.prototype.splice == i ? function(a, b) {
    a.splice(b, 1)
  } : function(a, b) {
    var c, d, e;
    if(b === a.length - 1) {
      a.length = b
    }else {
      c = a.slice(b + 1);
      a.length = b;
      d = 0;
      for(e = c.length;d < e;++d) {
        a[b + d] = c[d]
      }
    }
  }, k = e("key"), o = e("value"), l = 0, p = 1, q = 2;
  a.prototype = {getEqualityFunction:function(a) {
    return typeof a.equals == i ? h : g
  }, getEntryForKey:b(p), getEntryAndIndexForKey:b(q), removeEntryForKey:function(a) {
    return(a = this.getEntryAndIndexForKey(a)) ? (j(this.entries, a[0]), a[1]) : null
  }, addEntry:function(a, b) {
    this.entries[this.entries.length] = [a, b]
  }, keys:c(0), values:c(1), getEntries:function(a) {
    for(var b = a.length, c = 0, d = this.entries.length;c < d;++c) {
      a[b + c] = this.entries[c].slice(0)
    }
  }, containsKey:b(l), containsValue:function(a) {
    for(var b = this.entries.length;b--;) {
      if(a === this.entries[b][1]) {
        return!0
      }
    }
    return!1
  }};
  var r = function(b, c) {
    var e = this, g = [], h = {}, m = typeof b == i ? b : d, l = typeof c == i ? c : null;
    this.put = function(b, c) {
      k(b);
      o(c);
      var d = m(b), e, i = null;
      (e = f(h, d)) ? (d = e.getEntryForKey(b)) ? (i = d[1], d[1] = c) : e.addEntry(b, c) : (e = new a(d, b, c, l), g[g.length] = e, h[d] = e);
      return i
    };
    this.get = function(a) {
      k(a);
      var b = m(a);
      if(b = f(h, b)) {
        if(a = b.getEntryForKey(a)) {
          return a[1]
        }
      }
      return null
    };
    this.containsKey = function(a) {
      k(a);
      var b = m(a);
      return(b = f(h, b)) ? b.containsKey(a) : !1
    };
    this.containsValue = function(a) {
      o(a);
      for(var b = g.length;b--;) {
        if(g[b].containsValue(a)) {
          return!0
        }
      }
      return!1
    };
    this.clear = function() {
      g.length = 0;
      h = {}
    };
    this.isEmpty = function() {
      return!g.length
    };
    var n = function(a) {
      return function() {
        for(var b = [], c = g.length;c--;) {
          g[c][a](b)
        }
        return b
      }
    };
    this._keys = n("keys");
    this._values = n("values");
    this._entries = n("getEntries");
    this.values = function() {
      for(var a = this._values(), b = a.length, c = new Kotlin.ArrayList;b--;) {
        c.add(a[b])
      }
      return c
    };
    this.remove = function(a) {
      k(a);
      var b = m(a), c = null, d = f(h, b);
      if(d && (c = d.removeEntryForKey(a), null !== c && !d.entries.length)) {
        a: {
          for(a = g.length;a--;) {
            if(d = g[a], b === d[0]) {
              break a
            }
          }
          a = null
        }
        j(g, a);
        delete h[b]
      }
      return c
    };
    this.size = function() {
      for(var a = 0, b = g.length;b--;) {
        a += g[b].entries.length
      }
      return a
    };
    this.each = function(a) {
      for(var b = e._entries(), c = b.length, d;c--;) {
        d = b[c], a(d[0], d[1])
      }
    };
    this.putAll = function(a, b) {
      for(var c = a._entries(), d, f, g, h = c.length, j = typeof b == i;h--;) {
        d = c[h];
        f = d[0];
        d = d[1];
        if(j && (g = e.get(f))) {
          d = b(f, g, d)
        }
        e.put(f, d)
      }
    };
    this.clone = function() {
      var a = new r(b, c);
      a.putAll(e);
      return a
    };
    this.keySet = function() {
      for(var a = new Kotlin.ComplexHashSet, b = this._keys(), c = b.length;c--;) {
        a.add(b[c])
      }
      return a
    }
  };
  Kotlin.HashTable = r
})();
Kotlin.Map = Kotlin.createClass();
Kotlin.HashMap = Kotlin.createClass(Kotlin.Map, function() {
  Kotlin.HashTable.call(this)
});
Kotlin.ComplexHashMap = Kotlin.HashMap;
(function() {
  var d = Kotlin.createClass(Kotlin.Iterator, function(d, e) {
    this.map = d;
    this.keys = e;
    this.size = e.length;
    this.index = 0
  }, {next:function() {
    return this.map[this.keys[this.index++]]
  }, hasNext:function() {
    return this.index < this.size
  }}), h = Kotlin.createClass(Kotlin.Collection, function(d) {
    this.map = d
  }, {iterator:function() {
    return new d(this.map.map, Object.keys(this.map.map))
  }, isEmpty:function() {
    return 0 === this.map.$size
  }, contains:function(d) {
    return this.map.containsValue(d)
  }});
  Kotlin.PrimitiveHashMap = Kotlin.createClass(Kotlin.Map, function() {
    this.$size = 0;
    this.map = {}
  }, {size:function() {
    return this.$size
  }, isEmpty:function() {
    return 0 === this.$size
  }, containsKey:function(d) {
    return void 0 !== this.map[d]
  }, containsValue:function(d) {
    var e = this.map, a;
    for(a in e) {
      if(e.hasOwnProperty(a) && e[a] === d) {
        return!0
      }
    }
    return!1
  }, get:function(d) {
    return this.map[d]
  }, put:function(d, e) {
    var a = this.map[d];
    this.map[d] = void 0 === e ? null : e;
    void 0 === a && this.$size++;
    return a
  }, remove:function(d) {
    var e = this.map[d];
    void 0 !== e && (delete this.map[d], this.$size--);
    return e
  }, clear:function() {
    this.$size = 0;
    this.map = {}
  }, putAll:function(d) {
    var d = d.map, e;
    for(e in d) {
      d.hasOwnProperty(e) && (this.map[e] = d[e], this.$size++)
    }
  }, keySet:function() {
    var d = new Kotlin.PrimitiveHashSet, e = this.map, a;
    for(a in e) {
      e.hasOwnProperty(a) && d.add(a)
    }
    return d
  }, values:function() {
    return new h(this)
  }, toJSON:function() {
    return this.map
  }})
})();
Kotlin.Set = Kotlin.createClass(Kotlin.Collection);
Kotlin.PrimitiveHashSet = Kotlin.createClass(Kotlin.AbstractCollection, function() {
  this.$size = 0;
  this.map = {}
}, {contains:function(d) {
  return!0 === this.map[d]
}, add:function(d) {
  var h = this.map[d];
  this.map[d] = !0;
  if(!0 === h) {
    return!1
  }
  this.$size++;
  return!0
}, remove:function(d) {
  return!0 === this.map[d] ? (delete this.map[d], this.$size--, !0) : !1
}, clear:function() {
  this.$size = 0;
  this.map = {}
}, toArray:function() {
  return Object.keys(this.map)
}});
(function() {
  function d(h, g) {
    var e = new Kotlin.HashTable(h, g);
    this.add = function(a) {
      e.put(a, !0)
    };
    this.addAll = function(a) {
      for(var b = a.length;b--;) {
        e.put(a[b], !0)
      }
    };
    this.values = function() {
      return e._keys()
    };
    this.iterator = function() {
      return Kotlin.arrayIterator(this.values())
    };
    this.remove = function(a) {
      return e.remove(a) ? a : null
    };
    this.contains = function(a) {
      return e.containsKey(a)
    };
    this.clear = function() {
      e.clear()
    };
    this.size = function() {
      return e.size()
    };
    this.isEmpty = function() {
      return e.isEmpty()
    };
    this.clone = function() {
      var a = new d(h, g);
      a.addAll(e.keys());
      return a
    };
    this.equals = function(a) {
      if(null === a || void 0 === a) {
        return!1
      }
      if(this.size() === a.size()) {
        for(var b = this.iterator(), a = a.iterator();;) {
          var c = b.hasNext(), d = a.hasNext();
          if(c != d) {
            break
          }
          if(d) {
            if(c = b.next(), d = a.next(), !Kotlin.equals(c, d)) {
              break
            }
          }else {
            return!0
          }
        }
      }
      return!1
    };
    this.toString = function() {
      for(var a = "[", b = this.iterator(), c = !0;b.hasNext();) {
        c ? c = !1 : a += ", ", a += b.next()
      }
      return a + "]"
    };
    this.intersection = function(a) {
      for(var b = new d(h, g), a = a.values(), c = a.length, f;c--;) {
        f = a[c], e.containsKey(f) && b.add(f)
      }
      return b
    };
    this.union = function(a) {
      for(var b = this.clone(), a = a.values(), c = a.length, d;c--;) {
        d = a[c], e.containsKey(d) || b.add(d)
      }
      return b
    };
    this.isSubsetOf = function(a) {
      for(var b = e.keys(), c = b.length;c--;) {
        if(!a.contains(b[c])) {
          return!1
        }
      }
      return!0
    }
  }
  Kotlin.HashSet = Kotlin.createClass(Kotlin.Set, function() {
    d.call(this)
  });
  Kotlin.ComplexHashSet = Kotlin.HashSet
})();

