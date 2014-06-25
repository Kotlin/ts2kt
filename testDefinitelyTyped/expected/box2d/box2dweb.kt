// OUT:
// WRONG
package box2dweb

module
// WRONG
public object Box2D.Common  {
    public class b2Color(rr: Number, gg: Number, bb: Number) {
        public var r: Number = noImpl
        public var g: Number = noImpl
        public var b: Number = noImpl
        public var color: Number = noImpl
        public fun Set(rr: Number, gg: Number, bb: Number): Unit = noImpl
    }
    public class b2Settings {
        public class object {
            public fun b2Assert(a: Boolean): Unit = noImpl
            public fun b2MixFriction(friction1: Number, friction2: Number): Number = noImpl
            public fun b2MixRestitution(restitution1: Number, restitution2: Number): Number = noImpl
            public var b2_aabbExtension: Number = noImpl
            public var b2_aabbMultiplier: Number = noImpl
            public var b2_angularSleepTolerance: Number = noImpl
            public var b2_angularSlop: Number = noImpl
            public var b2_contactBaumgarte: Number = noImpl
            public var b2_linearSleepTolerance: Number = noImpl
            public var b2_linearSlop: Number = noImpl
            public var b2_maxAngularCorrection: Number = noImpl
            public var b2_maxLinearCorrection: Number = noImpl
            public var b2_maxManifoldPoints: Number = noImpl
            public var b2_maxRotation: Number = noImpl
            public var b2_maxRotationSquared: Number = noImpl
            public var b2_maxTOIContactsPerIsland: Number = noImpl
            public var b2_maxTOIJointsPerIsland: Number = noImpl
            public var b2_maxTranslation: Number = noImpl
            public var b2_maxTranslationSquared: Number = noImpl
            public var b2_pi: Number = noImpl
            public var b2_polygonRadius: Number = noImpl
            public var b2_timeToSleep: Number = noImpl
            public var b2_toiSlop: Number = noImpl
            public var b2_velocityThreshold: Number = noImpl
            public var USHRT_MAX: Number = noImpl
            public var VERSION: String = noImpl
        }
    }
}
module
public object Box2D.Common.Math  {
    public class b2Mat22 {
        public var col1: b2Vec2 = noImpl
        public var col2: b2Vec2 = noImpl
        public fun Abs(): Unit = noImpl
        public fun AddM(m: b2Mat22): Unit = noImpl
        public fun Copy(): b2Mat22 = noImpl
        public fun GetAngle(): Number = noImpl
        public fun GetInverse(out: b2Mat22): b2Mat22 = noImpl
        public fun Set(angle: Number): Unit = noImpl
        public fun SetIdentity(): Unit = noImpl
        public fun SetM(m: b2Mat22): Unit = noImpl
        public fun SetVV(c1: b2Vec2, c2: b2Vec2): Unit = noImpl
        public fun SetZero(): Unit = noImpl
        public fun Solve(out: b2Vec2, bX: Number, bY: Number): b2Vec2 = noImpl
        public class object {
            public fun FromAngle(angle: Number): b2Mat22 = noImpl
            public fun FromVV(c1: b2Vec2, c2: b2Vec2): b2Mat22 = noImpl
        }
    }
    public class b2Mat33(c1: b2Vec3, c2: b2Vec3, c3: b2Vec3) {
        public var col1: b2Vec3 = noImpl
        public var col2: b2Vec3 = noImpl
        public var col3: b2Vec3 = noImpl
        public fun AddM(m: b2Mat33): Unit = noImpl
        public fun Copy(): b2Mat33 = noImpl
        public fun SetIdentity(): Unit = noImpl
        public fun SetM(m: b2Mat33): Unit = noImpl
        public fun SetVVV(c1: b2Vec3, c2: b2Vec3, c3: b2Vec3): Unit = noImpl
        public fun SetZero(): Unit = noImpl
        public fun Solve22(out: b2Vec2, bX: Number, bY: Number): b2Vec2 = noImpl
        public fun Solve33(out: b2Vec3, bX: Number, bY: Number, bZ: Number): b2Vec3 = noImpl
    }
    public class b2Math {
        public class object {
            public fun IsValid(x: Number): Boolean = noImpl
            public fun Dot(a: b2Vec2, b: b2Vec2): Number = noImpl
            public fun CrossVV(a: b2Vec2, b: b2Vec2): Number = noImpl
            public fun CrossVF(a: b2Vec2, s: Number): b2Vec2 = noImpl
            public fun CrossFV(s: Number, a: b2Vec2): b2Vec2 = noImpl
            public fun MulMV(A: b2Mat22, v: b2Vec2): b2Vec2 = noImpl
            public fun MulTMV(A: b2Mat22, v: b2Vec2): b2Vec2 = noImpl
            public fun MulX(T: b2Transform, v: b2Vec2): b2Vec2 = noImpl
            public fun MulXT(T: b2Transform, v: b2Vec2): b2Vec2 = noImpl
            public fun AddVV(a: b2Vec2, b: b2Vec2): b2Vec2 = noImpl
            public fun SubtractVV(a: b2Vec2, b: b2Vec2): b2Vec2 = noImpl
            public fun Distance(a: b2Vec2, b: b2Vec2): Number = noImpl
            public fun DistanceSquared(a: b2Vec2, b: b2Vec2): Number = noImpl
            public fun MulFV(s: Number, a: b2Vec2): b2Vec2 = noImpl
            public fun AddMM(A: b2Mat22, B: b2Mat22): b2Mat22 = noImpl
            public fun MulMM(A: b2Mat22, B: b2Mat22): b2Mat22 = noImpl
            public fun MulTMM(A: b2Mat22, B: b2Mat22): b2Mat22 = noImpl
            public fun Abs(a: Number): Number = noImpl
            public fun AbsV(a: b2Vec2): b2Vec2 = noImpl
            public fun AbsM(A: b2Mat22): b2Mat22 = noImpl
            public fun Min(a: Number, b: Number): Number = noImpl
            public fun MinV(a: b2Vec2, b: b2Vec2): b2Vec2 = noImpl
            public fun Max(a: Number, b: Number): Number = noImpl
            public fun MaxV(a: b2Vec2, b: b2Vec2): b2Vec2 = noImpl
            public fun Clamp(a: Number, low: Number, high: Number): Number = noImpl
            public fun ClampV(a: b2Vec2, low: b2Vec2, high: b2Vec2): b2Vec2 = noImpl
            public fun Swap(a: Any, b: Any): Unit = noImpl
            public fun Random(): Number = noImpl
            public fun RandomRange(lo: Number, hi: Number): Number = noImpl
            public fun NextPowerOfTwo(x: Number): Number = noImpl
            public fun IsPowerOfTwo(x: Number): Boolean = noImpl
            public var b2Vec2_zero: b2Vec2 = noImpl
            public var b2Mat22_identity: b2Mat22 = noImpl
            public var b2Transform_identity: b2Transform = noImpl
        }
    }
    public class b2Sweep {
        public var a: Number = noImpl
        public var a0: Number = noImpl
        public var c: b2Vec2 = noImpl
        public var c0: b2Vec2 = noImpl
        public var localCenter: b2Vec2 = noImpl
        public var t0: b2Vec2 = noImpl
        public fun Advance(t: Number): Unit = noImpl
        public fun Copy(): b2Sweep = noImpl
        public fun GetTransform(xf: b2Transform, alpha: Number): Unit = noImpl
        public fun Set(other: b2Sweep): Unit = noImpl
    }
    public class b2Transform(pos: b2Vec2, r: b2Mat22) {
        public var position: b2Vec2 = noImpl
        public var R: b2Mat22 = noImpl
        public fun GetAngle(): Number = noImpl
        public fun Initialize(pos: b2Vec2, r: b2Mat22): Unit = noImpl
        public fun Set(x: b2Transform): Unit = noImpl
        public fun SetIdentity(): Unit = noImpl
    }
    public class b2Vec2(x: Number? = null, y: Number? = null) {
        public var x: Number = noImpl
        public var y: Number = noImpl
        public fun Abs(): Unit = noImpl
        public fun Add(v: b2Vec2): Unit = noImpl
        public fun Copy(): b2Vec2 = noImpl
        public fun CrossFV(s: Number): Unit = noImpl
        public fun CrossVF(s: Number): Unit = noImpl
        public fun GetNegative(): b2Vec2 = noImpl
        public fun IsValid(): Boolean = noImpl
        public fun Length(): Number = noImpl
        public fun LengthSquared(): Number = noImpl
        public fun MaxV(b: b2Vec2): Unit = noImpl
        public fun MinV(b: b2Vec2): Unit = noImpl
        public fun MulM(A: b2Mat22): Unit = noImpl
        public fun Multiply(a: Number): Unit = noImpl
        public fun MulTM(A: b2Mat22): Unit = noImpl
        public fun NegativeSelf(): Unit = noImpl
        public fun Normalize(): Number = noImpl
        public fun Set(x: Number? = null, y: Number? = null): Unit = noImpl
        public fun SetV(v: b2Vec2): Unit = noImpl
        public fun SetZero(): Unit = noImpl
        public fun Subtract(v: b2Vec2): Unit = noImpl
        public class object {
            public fun Make(x: Number, y: Number): b2Vec2 = noImpl
        }
    }
    public class b2Vec3(x: Number? = null, y: Number? = null, z: Number? = null) {
        public var x: Number = noImpl
        public var y: Number = noImpl
        public var z: Number = noImpl
        public fun Add(v: b2Vec3): Unit = noImpl
        public fun Copy(): b2Vec3 = noImpl
        public fun GetNegative(): b2Vec3 = noImpl
        public fun Multiply(a: Number): Unit = noImpl
        public fun NegativeSelf(): Unit = noImpl
        public fun Set(x: Number? = null, y: Number? = null, z: Number? = null): Unit = noImpl
        public fun SetV(v: b2Vec3): Unit = noImpl
        public fun SetZero(): Unit = noImpl
        public fun Subtract(v: b2Vec3): Unit = noImpl
    }
}
module
public object Box2D.Collision  {
    public class b2AABB {
        public var lowerBound: Box2D.Common.Math.b2Vec2 = noImpl
        public var upperBound: Box2D.Common.Math.b2Vec2 = noImpl
        public fun Combine(aabb1: b2AABB, aabb2: b2AABB): Unit = noImpl
        public fun Contains(aabb: b2AABB): Boolean = noImpl
        public fun GetCenter(): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetExtents(): Box2D.Common.Math.b2Vec2 = noImpl
        public fun IsValid(): Boolean = noImpl
        public fun RayCast(output: b2RayCastOutput, input: b2RayCastInput): Boolean = noImpl
        public fun TestOverlap(other: b2AABB): Boolean = noImpl
        public class object {
            public fun Combine(aabb1: b2AABB, aabb2: b2AABB): b2AABB = noImpl
        }
    }
    public class b2ContactID {
        public var features: Features = noImpl
        public var Key: Number = noImpl
        public fun Copy(): b2ContactID = noImpl
        public fun Set(id: b2ContactID): Unit = noImpl
    }
    public class b2ContactPoint {
        public var friction: Number = noImpl
        public var id: b2ContactID = noImpl
        public var normal: Box2D.Common.Math.b2Vec2 = noImpl
        public var position: Box2D.Common.Math.b2Vec2 = noImpl
        public var restitution: Number = noImpl
        public var separation: Number = noImpl
        public var shape1: Shapes.b2Shape = noImpl
        public var shape2: Shapes.b2Shape = noImpl
        public var velocity: Box2D.Common.Math.b2Vec2 = noImpl
    }
    public class b2DistanceInput {
        public var proxyA: b2DistanceProxy = noImpl
        public var proxyB: b2DistanceProxy = noImpl
        public var transformA: Box2D.Common.Math.b2Transform = noImpl
        public var transformB: Box2D.Common.Math.b2Transform = noImpl
        public var useRadii: Boolean = noImpl
    }
    public class b2DistanceOutput {
        public var distance: Number = noImpl
        public var iterations: Number = noImpl
        public var pointA: Box2D.Common.Math.b2Vec2 = noImpl
        public var pointB: Box2D.Common.Math.b2Vec2 = noImpl
    }
    public class b2DistanceProxy {
        public var m_count: Number = noImpl
        public var m_radius: Number = noImpl
        public var m_vertices: Array<Box2D.Common.Math.b2Vec2> = noImpl
        public fun GetSupport(d: Box2D.Common.Math.b2Vec2): Number = noImpl
        public fun GetSupportVertex(d: Box2D.Common.Math.b2Vec2): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetVertex(index: Number): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetVertexCount(): Number = noImpl
        public fun Set(shape: Shapes.b2Shape): Unit = noImpl
    }
    public class b2DynamicTree {
        public fun CreateProxy(aabb: b2AABB, userData: Any): b2DynamicTreeNode = noImpl
        public fun DestroyProxy(proxy: b2DynamicTreeNode): Unit = noImpl
        public fun GetFatAABB(proxy: b2DynamicTreeNode): b2AABB = noImpl
        public fun GetUserData(proxy: b2DynamicTreeNode): Any = noImpl
        public fun MoveProxy(proxy: b2DynamicTreeNode, aabb: b2AABB, displacement: Box2D.Common.Math.b2Vec2): Boolean = noImpl
        public fun Query(callback: (proxy: b2DynamicTreeNode) -> Boolean, aabb: b2AABB): Unit = noImpl
        public fun RayCast(callback: (input: b2RayCastInput, proxy: b2DynamicTreeNode) -> Number, input: b2RayCastInput): Unit = noImpl
        public fun Rebalance(iterations: Number): Unit = noImpl
    }
    public class b2DynamicTreeBroadPhase : IBroadPhase {
        public fun CreateProxy(aabb: b2AABB, userData: Any): b2DynamicTreeNode = noImpl
        public fun DestroyProxy(proxy: b2DynamicTreeNode): Unit = noImpl
        public fun GetFatAABB(proxy: b2DynamicTreeNode): b2AABB = noImpl
        public fun GetProxyCount(): Number = noImpl
        public fun GetUserData(proxy: b2DynamicTreeNode): Any = noImpl
        public fun MoveProxy(proxy: b2DynamicTreeNode, aabb: b2AABB, displacement: Box2D.Common.Math.b2Vec2): Unit = noImpl
        public fun Query(callback: (proxy: b2DynamicTreeNode) -> Boolean, aabb: b2AABB): Unit = noImpl
        public fun RayCast(callback: (input: b2RayCastInput, proxy: b2DynamicTreeNode) -> Number, input: b2RayCastInput): Unit = noImpl
        public fun Rebalance(iterations: Number): Unit = noImpl
        public fun TestOverlap(proxyA: b2DynamicTreeNode, proxyB: b2DynamicTreeNode): Boolean = noImpl
        public fun UpdatePairs(callback: (userDataA: Any, userDataB: Any) -> Unit): Unit = noImpl
        public fun Validate(): Unit = noImpl
    }
    public class b2DynamicTreeNode
    public class b2Manifold {
        public var m_localPlaneNormal: Box2D.Common.Math.b2Vec2 = noImpl
        public var m_localPoint: Box2D.Common.Math.b2Vec2 = noImpl
        public var m_pointCount: Number = noImpl
        public var m_points: Array<b2ManifoldPoint> = noImpl
        public var m_type: Number = noImpl
        public fun Copy(): b2Manifold = noImpl
        public fun Reset(): Unit = noImpl
        public fun Set(m: b2Manifold): Unit = noImpl
        public class object {
            public var e_circles: Number = noImpl
            public var e_faceA: Number = noImpl
            public var e_faceB: Number = noImpl
        }
    }
    public class b2ManifoldPoint {
        public var m_id: b2ContactID = noImpl
        public var m_localpoint: Box2D.Common.Math.b2Vec2 = noImpl
        public var m_normalImpulse: Number = noImpl
        public var m_tangentImpulse: Number = noImpl
        public fun Reset(): Unit = noImpl
        public fun Set(m: b2ManifoldPoint): Unit = noImpl
    }
    public class b2OBB {
        public var center: Box2D.Common.Math.b2Vec2 = noImpl
        public var extents: Box2D.Common.Math.b2Vec2 = noImpl
        public var R: Box2D.Common.Math.b2Mat22 = noImpl
    }
    public class b2RayCastInput(p1: Box2D.Common.Math.b2Vec2? = null, p2: Box2D.Common.Math.b2Vec2? = null, maxFraction: Number? = null) {
        public var maxFraction: Number = noImpl
        public var p1: Box2D.Common.Math.b2Vec2 = noImpl
        public var p2: Box2D.Common.Math.b2Vec2 = noImpl
    }
    public class b2RayCastOutput {
        public var fraction: Number = noImpl
        public var normal: Box2D.Common.Math.b2Vec2 = noImpl
    }
    public class b2Segment {
        public var p1: Box2D.Common.Math.b2Vec2 = noImpl
        public var p2: Box2D.Common.Math.b2Vec2 = noImpl
        public fun Extend(aabb: b2AABB): Unit = noImpl
        public fun ExtendBackward(aabb: b2AABB): Unit = noImpl
        public fun ExtendForward(aabb: b2AABB): Unit = noImpl
        public fun TestSegment(lambda: Array<Number>, normal: Box2D.Common.Math.b2Vec2, segment: b2Segment, maxLambda: Number): Boolean = noImpl
    }
    public class b2SimplexCache {
        public var count: Number = noImpl
        public var indexA: Array<Number> = noImpl
        public var indexB: Array<Number> = noImpl
        public var metric: Number = noImpl
    }
    public class b2TOIInput {
        public var proxyA: b2DistanceProxy = noImpl
        public var proxyB: b2DistanceProxy = noImpl
        public var sweepA: Box2D.Common.Math.b2Sweep = noImpl
        public var sweepB: Box2D.Common.Math.b2Sweep = noImpl
        public var tolerance: Number = noImpl
    }
    public class b2WorldManifold {
        public var m_normal: Box2D.Common.Math.b2Vec2 = noImpl
        public var m_points: Array<Box2D.Common.Math.b2Vec2> = noImpl
        public fun Initialize(manifold: b2Manifold, xfA: Box2D.Common.Math.b2Transform, radiusA: Number, xfB: Box2D.Common.Math.b2Transform, radiusB: Number): Unit = noImpl
    }
    public class Features {
        public var flip: Number = noImpl
        public var incidentEdge: Number = noImpl
        public var incidentVertex: Number = noImpl
        public var referenceEdge: Number = noImpl
    }
    public trait IBroadPhase {
        public fun CreateProxy(aabb: b2AABB, userData: Any): b2DynamicTreeNode
        public fun DestroyProxy(proxy: b2DynamicTreeNode): Unit
        public fun GetFatAABB(proxy: b2DynamicTreeNode): b2AABB
        public fun GetProxyCount(): Number
        public fun GetUserData(proxy: b2DynamicTreeNode): Any
        public fun MoveProxy(proxy: b2DynamicTreeNode, aabb: b2AABB, displacement: Box2D.Common.Math.b2Vec2): Unit
        public fun Query(callback: (proxy: b2DynamicTreeNode) -> Boolean, aabb: b2AABB): Unit
        public fun RayCast(callback: (input: b2RayCastInput, proxy: b2DynamicTreeNode) -> Number, input: b2RayCastInput): Unit
        public fun Rebalance(iterations: Number): Unit
    }
}
module
public object Box2D.Collision.Shapes  {
    public class b2CircleShape(radius: Number? = null) : b2Shape {
        public fun ComputeAABB(aabb: b2AABB, xf: Box2D.Common.Math.b2Transform): Unit = noImpl
        public fun ComputeMass(massData: b2MassData, density: Number): Unit = noImpl
        public fun ComputeSubmergedArea(normal: Box2D.Common.Math.b2Vec2, offset: Number, xf: Box2D.Common.Math.b2Transform, c: Box2D.Common.Math.b2Vec2): Number = noImpl
        public fun Copy(): b2CircleShape = noImpl
        public fun GetLocalPosition(): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetRadius(): Number = noImpl
        public fun RayCast(output: b2RayCastOutput, input: b2RayCastInput, transform: Box2D.Common.Math.b2Transform): Boolean = noImpl
        public fun Set(other: b2CircleShape): Unit = noImpl
        public fun SetLocalPosition(position: Box2D.Common.Math.b2Vec2): Unit = noImpl
        public fun SetRadius(radius: Number): Unit = noImpl
        public fun TestPoint(xf: Box2D.Common.Math.b2Transform, p: Box2D.Common.Math.b2Vec2): Boolean = noImpl
    }
    public class b2EdgeChainDef {
        public var isALoop: Boolean = noImpl
        public var vertexCount: Number = noImpl
        public var vertices: Box2D.Common.Math.b2Vec2 = noImpl
    }
    public class b2EdgeShape(v1: Box2D.Common.Math.b2Vec2, v2: Box2D.Common.Math.b2Vec2) : b2Shape {
        public fun ComputeAABB(aabb: b2AABB, xf: Box2D.Common.Math.b2Transform): Unit = noImpl
        public fun ComputeMass(massData: b2MassData, density: Number): Unit = noImpl
        public fun ComputeSubmergedArea(normal: Box2D.Common.Math.b2Vec2, offset: Number, xf: Box2D.Common.Math.b2Transform, c: Box2D.Common.Math.b2Vec2): Number = noImpl
        public fun GetLength(): Number = noImpl
        public fun GetVertex1(): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetVertex2(): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetCoreVertex1(): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetCoreVertex2(): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetNormalVector(): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetDirectionVector(): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetCorner1Vector(): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetCorner2Vector(): Box2D.Common.Math.b2Vec2 = noImpl
        public fun Corner1IsConvex(): Boolean = noImpl
        public fun Corner2IsConvex(): Boolean = noImpl
        public fun GetFirstVertex(xf: Box2D.Common.Math.b2Transform): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetNextEdge(): b2EdgeShape = noImpl
        public fun GetPrevEdge(): b2EdgeShape = noImpl
        public fun Support(xf: Box2D.Common.Math.b2Transform, dX: Number, dY: Number): Box2D.Common.Math.b2Vec2 = noImpl
        public fun RayCast(output: b2RayCastOutput, input: b2RayCastInput, transform: Box2D.Common.Math.b2Transform): Boolean = noImpl
        public fun TestPoint(xf: Box2D.Common.Math.b2Transform, p: Box2D.Common.Math.b2Vec2): Boolean = noImpl
    }
    public class b2MassData {
        public var center: Box2D.Common.Math.b2Vec2 = noImpl
        public var I: Number = noImpl
        public var mass: Number = noImpl
    }
    public class b2PolygonShape : b2Shape {
        public fun ComputeAABB(aabb: b2AABB, xf: Box2D.Common.Math.b2Transform): Unit = noImpl
        public fun ComputeMass(massData: b2MassData, density: Number): Unit = noImpl
        public fun ComputeSubmergedArea(normal: Box2D.Common.Math.b2Vec2, offset: Number, xf: Box2D.Common.Math.b2Transform, c: Box2D.Common.Math.b2Vec2): Number = noImpl
        public fun Copy(): b2PolygonShape = noImpl
        public fun GetNormals(): Array<Box2D.Common.Math.b2Vec2> = noImpl
        public fun GetSupport(d: Box2D.Common.Math.b2Vec2): Number = noImpl
        public fun GetSupportVertex(d: Box2D.Common.Math.b2Vec2): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetVertexCount(): Number = noImpl
        public fun GetVertices(): Array<Box2D.Common.Math.b2Vec2> = noImpl
        public fun RayCast(output: b2RayCastOutput, input: b2RayCastInput, transform: Box2D.Common.Math.b2Transform): Boolean = noImpl
        public fun Set(other: b2Shape): Unit = noImpl
        public fun SetAsArray(vertices: Array<Box2D.Common.Math.b2Vec2>, vertexCount: Number? = null): Unit = noImpl
        public fun SetAsBox(hx: Number, hy: Number): Unit = noImpl
        public fun SetAsEdge(v1: Box2D.Common.Math.b2Vec2, b2: Box2D.Common.Math.b2Vec2): Unit = noImpl
        public fun SetAsOrientedBox(hx: Number, hy: Number, center: Box2D.Common.Math.b2Vec2? = null, angle: Number? = null): Unit = noImpl
        public fun SetAsVector(vertices: Array<Any>, vertexCount: Number? = null): Unit = noImpl
        public fun TestPoint(xf: Box2D.Common.Math.b2Transform, p: Box2D.Common.Math.b2Vec2): Boolean = noImpl
        public class object {
            public fun AsArray(vertices: Array<Box2D.Common.Math.b2Vec2>, vertexCount: Number? = null): b2PolygonShape = noImpl
            public fun AsBox(hx: Number, hy: Number): b2PolygonShape = noImpl
            public fun AsEdge(v1: Box2D.Common.Math.b2Vec2, b2: Box2D.Common.Math.b2Vec2): b2PolygonShape = noImpl
            public fun AsOrientedBox(hx: Number, hy: Number, center: Box2D.Common.Math.b2Vec2? = null, angle: Number? = null): b2PolygonShape = noImpl
            public fun AsVector(vertices: Array<Box2D.Common.Math.b2Vec2>, vertexCount: Number? = null): b2PolygonShape = noImpl
        }
    }
    public class b2Shape {
        public fun ComputeAABB(aabb: b2AABB, xf: Box2D.Common.Math.b2Transform): Unit = noImpl
        public fun ComputeMass(massData: b2MassData, density: Number): Unit = noImpl
        public fun ComputeSubmergedArea(normal: Box2D.Common.Math.b2Vec2, offset: Number, xf: Box2D.Common.Math.b2Transform, c: Box2D.Common.Math.b2Vec2): Number = noImpl
        public fun Copy(): b2Shape = noImpl
        public fun GetType(): Number = noImpl
        public fun RayCast(output: b2RayCastOutput, input: b2RayCastInput, transform: Box2D.Common.Math.b2Transform): Boolean = noImpl
        public fun Set(other: b2Shape): Unit = noImpl
        public fun TestPoint(xf: Box2D.Common.Math.b2Transform, p: Box2D.Common.Math.b2Vec2): Boolean = noImpl
        public class object {
            public var e_hitCollide: Number = noImpl
            public var e_missCollide: Number = noImpl
            public var startsInsideCollide: Number = noImpl
            public var e_unknownShape: Number = noImpl
            public var e_circleShape: Number = noImpl
            public var e_polygonShape: Number = noImpl
            public var e_edgeShape: Number = noImpl
            public var e_shapeTypeCount: Number = noImpl
            public fun TestOverlap(shape1: b2Shape, transform1: Box2D.Common.Math.b2Transform, shape2: b2Shape, transform2: Box2D.Common.Math.b2Transform): Boolean = noImpl
        }
    }
}
module
public object Box2D.Dynamics  {
    public class b2Body {
        public fun ApplyForce(force: Box2D.Common.Math.b2Vec2, point: Box2D.Common.Math.b2Vec2): Unit = noImpl
        public fun ApplyImpulse(impulse: Box2D.Common.Math.b2Vec2, point: Box2D.Common.Math.b2Vec2): Unit = noImpl
        public fun ApplyTorque(torque: Number): Unit = noImpl
        public fun CreateFixture(def: b2FixtureDef): b2Fixture = noImpl
        public fun CreateFixture2(shape: Box2D.Collision.Shapes.b2Shape, density: Number? = null): b2Fixture = noImpl
        public fun DestroyFixture(fixture: b2Fixture): Unit = noImpl
        public fun GetAngle(): Number = noImpl
        public fun GetAngularDamping(): Number = noImpl
        public fun GetAngularVelocity(): Number = noImpl
        public fun GetContactList(): Contacts.b2ContactEdge = noImpl
        public fun GetControllerList(): Controllers.b2ControllerEdge = noImpl
        public fun GetDefinition(): b2BodyDef = noImpl
        public fun GetFixtureList(): b2Fixture = noImpl
        public fun GetInertia(): Number = noImpl
        public fun GetJointList(): Joints.b2JointEdge = noImpl
        public fun GetLinearDamping(): Number = noImpl
        public fun GetLinearVelocity(): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetLinearVelocityFromLocalPoint(localPoint: Box2D.Common.Math.b2Vec2): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetLinearVelocityFromWorldPoint(worldPoint: Box2D.Common.Math.b2Vec2): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetLocalCenter(): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetLocalPoint(worldPoint: Box2D.Common.Math.b2Vec2): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetLocalVector(worldVector: Box2D.Common.Math.b2Vec2): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetMass(): Number = noImpl
        public fun GetMassData(data: Box2D.Collision.Shapes.b2MassData): Unit = noImpl
        public fun GetNext(): b2Body = noImpl
        public fun GetPosition(): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetTransform(): Box2D.Common.Math.b2Transform = noImpl
        public fun GetType(): Number = noImpl
        public fun GetUserData(): Any = noImpl
        public fun GetWorld(): b2World = noImpl
        public fun GetWorldCenter(): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetWorldPoint(localPoint: Box2D.Common.Math.b2Vec2): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetWorldVector(localVector: Box2D.Common.Math.b2Vec2): Box2D.Common.Math.b2Vec2 = noImpl
        public fun IsActive(): Boolean = noImpl
        public fun IsAwake(): Boolean = noImpl
        public fun IsBullet(): Boolean = noImpl
        public fun IsFixedRotation(): Boolean = noImpl
        public fun IsSleepingAllowed(): Boolean = noImpl
        public fun Merge(other: b2Body): Unit = noImpl
        public fun ResetMassData(): Unit = noImpl
        public fun SetActive(flag: Boolean): Unit = noImpl
        public fun SetAngle(angle: Number): Unit = noImpl
        public fun SetAngularDamping(angularDamping: Number): Unit = noImpl
        public fun SetAngularVelocity(omega: Number): Unit = noImpl
        public fun SetAwake(flag: Boolean): Unit = noImpl
        public fun SetBullet(flag: Boolean): Unit = noImpl
        public fun SetFixedRotation(fixed: Boolean): Unit = noImpl
        public fun SetLinearDamping(linearDamping: Number): Unit = noImpl
        public fun SetLinearVelocity(v: Box2D.Common.Math.b2Vec2): Unit = noImpl
        public fun SetMassData(massData: Box2D.Collision.Shapes.b2MassData): Unit = noImpl
        public fun SetPosition(position: Box2D.Common.Math.b2Vec2): Unit = noImpl
        public fun SetPositionAndAngle(position: Box2D.Common.Math.b2Vec2, angle: Number): Unit = noImpl
        public fun SetSleepingAllowed(flag: Boolean): Unit = noImpl
        public fun SetTransform(xf: Box2D.Common.Math.b2Transform): Unit = noImpl
        public fun SetType(`type`: Number): Unit = noImpl
        public fun SetUserData(data: Any): Unit = noImpl
        public fun Split(callback: (fixture: b2Fixture) -> Boolean): b2Body = noImpl
        public class object {
            public var b2_dynamicBody: Number = noImpl
            public var b2_kinematicBody: Number = noImpl
            public var b2_staticBody: Number = noImpl
        }
    }
    public class b2BodyDef {
        public var active: Boolean = noImpl
        public var allowSleep: Boolean = noImpl
        public var angle: Number = noImpl
        public var angularDamping: Number = noImpl
        public var angularVelocity: Number = noImpl
        public var awake: Boolean = noImpl
        public var bullet: Boolean = noImpl
        public var fixedRotation: Boolean = noImpl
        public var inertiaScale: Number = noImpl
        public var linearDamping: Number = noImpl
        public var linearVelocity: Box2D.Common.Math.b2Vec2 = noImpl
        public var position: Box2D.Common.Math.b2Vec2 = noImpl
        public var `type`: Number = noImpl
        public var userData: Any = noImpl
    }
    public class b2ContactFilter {
        public fun RayCollide(userData: Any): Boolean = noImpl
        public fun ShouldCollide(fixtureA: b2Fixture, fixtureB: b2Fixture): Boolean = noImpl
    }
    public class b2ContactImpulse {
        public var normalImpulses: Box2D.Common.Math.b2Vec2 = noImpl
        public var tangentImpulses: Box2D.Common.Math.b2Vec2 = noImpl
    }
    public class b2ContactListener {
        public fun BeginContact(contact: Contacts.b2Contact): Unit = noImpl
        public fun EndContact(contact: Contacts.b2Contact): Unit = noImpl
        public fun PostSolve(contact: Contacts.b2Contact, impulse: b2ContactImpulse): Unit = noImpl
        public fun PreSolve(contact: Contacts.b2Contact, oldManifold: Box2D.Collision.b2Manifold): Unit = noImpl
    }
    public class b2DebugDraw {
        public fun AppendFlags(flags: Number): Unit = noImpl
        public fun ClearFlags(flags: Number): Unit = noImpl
        public fun DrawCircle(center: Box2D.Common.Math.b2Vec2, radius: Number, color: Box2D.Common.b2Color): Unit = noImpl
        public fun DrawPolygon(vertices: Array<Box2D.Common.Math.b2Vec2>, vertexCount: Number, color: Box2D.Common.b2Color): Unit = noImpl
        public fun DrawSegment(p1: Box2D.Common.Math.b2Vec2, p2: Box2D.Common.Math.b2Vec2, color: Box2D.Common.b2Color): Unit = noImpl
        public fun DrawSolidCircle(center: Box2D.Common.Math.b2Vec2, radius: Number, axis: Box2D.Common.Math.b2Vec2, color: Box2D.Common.b2Color): Unit = noImpl
        public fun DrawSolidPolygon(vertices: Array<Box2D.Common.Math.b2Vec2>, vertexCount: Number, color: Box2D.Common.b2Color): Unit = noImpl
        public fun DrawTransform(xf: Box2D.Common.Math.b2Transform): Unit = noImpl
        public fun GetAlpha(): Number = noImpl
        public fun GetDrawScale(): Number = noImpl
        public fun GetFillAlpha(): Number = noImpl
        public fun GetFlags(): Number = noImpl
        public fun GetLineThickness(): Number = noImpl
        public fun GetSprite(): CanvasRenderingContext2D = noImpl
        public fun GetXFormScale(): Number = noImpl
        public fun SetAlpha(alpha: Number): Unit = noImpl
        public fun SetDrawScale(drawScale: Number): Unit = noImpl
        public fun SetFillAlpha(alpha: Number): Unit = noImpl
        public fun SetFlags(flags: Number): Unit = noImpl
        public fun SetLineThickness(lineThickness: Number): Unit = noImpl
        public fun SetSprite(canvas: CanvasRenderingContext2D): Unit = noImpl
        public fun SetXFormScale(xformScale: Number): Unit = noImpl
        public class object {
            public var e_aabbBit: Number = noImpl
            public var e_centerOfMassBit: Number = noImpl
            public var e_controllerBit: Number = noImpl
            public var e_jointBit: Number = noImpl
            public var e_pairBit: Number = noImpl
            public var e_shapeBit: Number = noImpl
        }
    }
    public class b2DestructionListener {
        public fun SayGoodbyeFixture(fixture: b2Fixture): Unit = noImpl
        public fun SayGoodbyeJoint(joint: Joints.b2Joint): Unit = noImpl
    }
    public class b2FilterData {
        public var categoryBits: Number = noImpl
        public var groupIndex: Number = noImpl
        public var maskBits: Number = noImpl
        public fun Copy(): b2FilterData = noImpl
    }
    public class b2Fixture {
        public fun GetAABB(): Box2D.Collision.b2AABB = noImpl
        public fun GetBody(): b2Body = noImpl
        public fun GetDensity(): Number = noImpl
        public fun GetFilterData(): b2FilterData = noImpl
        public fun GetFriction(): Number = noImpl
        public fun GetMassData(massData: Box2D.Collision.Shapes.b2MassData? = null): Box2D.Collision.Shapes.b2MassData = noImpl
        public fun GetNext(): b2Fixture = noImpl
        public fun GetRestitution(): Number = noImpl
        public fun GetShape(): Box2D.Collision.Shapes.b2Shape = noImpl
        public fun GetType(): Number = noImpl
        public fun GetUserData(): Any = noImpl
        public fun IsSensor(): Boolean = noImpl
        public fun RayCast(output: Box2D.Collision.b2RayCastOutput, input: Box2D.Collision.b2RayCastInput): Boolean = noImpl
        public fun SetDensity(density: Number): Unit = noImpl
        public fun SetFilterData(filter: Any): Unit = noImpl
        public fun SetFriction(friction: Number): Unit = noImpl
        public fun SetRestitution(restitution: Number): Unit = noImpl
        public fun SetSensor(sensor: Boolean): Unit = noImpl
        public fun SetUserData(data: Any): Unit = noImpl
        public fun TestPoint(p: Box2D.Common.Math.b2Vec2): Boolean = noImpl
    }
    public class b2FixtureDef {
        public var density: Number = noImpl
        public var filter: b2FilterData = noImpl
        public var friction: Number = noImpl
        public var isSensor: Boolean = noImpl
        public var restitution: Number = noImpl
        public var shape: Box2D.Collision.Shapes.b2Shape = noImpl
        public var userData: Any = noImpl
    }
    public class b2World(gravity: Box2D.Common.Math.b2Vec2, doSleep: Boolean) {
        public fun AddController(c: Controllers.b2Controller): Controllers.b2Controller = noImpl
        public fun ClearForces(): Unit = noImpl
        public fun CreateBody(def: b2BodyDef): b2Body = noImpl
        public fun CreateController(controller: Controllers.b2Controller): Controllers.b2Controller = noImpl
        public fun CreateJoint(def: Joints.b2JointDef): Joints.b2Joint = noImpl
        public fun DestroyBody(b: b2Body): Unit = noImpl
        public fun DestroyController(controller: Controllers.b2Controller): Unit = noImpl
        public fun DestroyJoint(j: Joints.b2Joint): Unit = noImpl
        public fun DrawDebugData(): Unit = noImpl
        public fun GetBodyCount(): Number = noImpl
        public fun GetBodyList(): b2Body = noImpl
        public fun GetContactCount(): Number = noImpl
        public fun GetContactList(): Contacts.b2Contact = noImpl
        public fun GetGravity(): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetGroundBody(): b2Body = noImpl
        public fun GetJointCount(): Number = noImpl
        public fun GetJointList(): Joints.b2Joint = noImpl
        public fun GetProxyCount(): Number = noImpl
        public fun IsLocked(): Boolean = noImpl
        public fun QueryAABB(callback: (fixutre: b2Fixture) -> Boolean, aabb: Box2D.Collision.b2AABB): Unit = noImpl
        public fun QueryPoint(callback: (fixture: b2Fixture) -> Boolean, p: Box2D.Common.Math.b2Vec2): Unit = noImpl
        public fun QueryShape(callback: (fixture: b2Fixture) -> Boolean, shape: Box2D.Collision.Shapes.b2Shape, transform: Box2D.Common.Math.b2Transform? = null): Unit = noImpl
        public fun RayCast(callback: (fixture: b2Fixture, point: Box2D.Common.Math.b2Vec2, normal: Box2D.Common.Math.b2Vec2, fraction: Number) -> Number, point1: Box2D.Common.Math.b2Vec2, point2: Box2D.Common.Math.b2Vec2): Unit = noImpl
        public fun RayCastAll(point1: Box2D.Common.Math.b2Vec2, point2: Box2D.Common.Math.b2Vec2): Array<b2Fixture> = noImpl
        public fun RayCastOne(point1: Box2D.Common.Math.b2Vec2, point2: Box2D.Common.Math.b2Vec2): b2Fixture = noImpl
        public fun RemoveController(c: Controllers.b2Controller): Unit = noImpl
        public fun SetBroadPhase(broadPhase: Box2D.Collision.IBroadPhase): Unit = noImpl
        public fun SetContactFilter(filter: b2ContactFilter): Unit = noImpl
        public fun SetContactListener(listener: b2ContactListener): Unit = noImpl
        public fun SetContinuousPhysics(flag: Boolean): Unit = noImpl
        public fun SetDebugDraw(debugDraw: b2DebugDraw): Unit = noImpl
        public fun SetDestructionListener(listener: b2DestructionListener): Unit = noImpl
        public fun SetGravity(gravity: Box2D.Common.Math.b2Vec2): Unit = noImpl
        public fun SetWarmStarting(flag: Boolean): Unit = noImpl
        public fun Step(dt: Number, velocityIterations: Number, positionIterations: Number): Unit = noImpl
        public fun Validate(): Unit = noImpl
        public class object {
            public var e_locked: Number = noImpl
            public var e_newFixture: Number = noImpl
        }
    }
}
module
public object Box2D.Dynamics.Contacts  {
    public class b2Contact {
        public fun FlagForFiltering(): Unit = noImpl
        public fun GetFixtureA(): b2Fixture = noImpl
        public fun GetFixtureB(): b2Fixture = noImpl
        public fun GetManifold(): Box2D.Collision.b2Manifold = noImpl
        public fun GetNext(): b2Contact = noImpl
        public fun GetWorldManifold(worldManifold: Box2D.Collision.b2WorldManifold): Unit = noImpl
        public fun IsContinuous(): Boolean = noImpl
        public fun IsEnabled(): Boolean = noImpl
        public fun IsSensor(): Boolean = noImpl
        public fun IsTouching(): Boolean = noImpl
        public fun SetEnabled(flag: Boolean): Unit = noImpl
        public fun SetSensor(sensor: Boolean): Unit = noImpl
    }
    public class b2ContactEdge {
        public var contact: b2Contact = noImpl
        public var next: b2ContactEdge = noImpl
        public var other: b2Body = noImpl
        public var prev: b2ContactEdge = noImpl
    }
    public class b2ContactResult {
        public var id: Box2D.Collision.b2ContactID = noImpl
        public var normal: Box2D.Common.Math.b2Vec2 = noImpl
        public var normalImpulse: Number = noImpl
        public var position: Box2D.Common.Math.b2Vec2 = noImpl
        public var shape1: Box2D.Collision.Shapes.b2Shape = noImpl
        public var shape2: Box2D.Collision.Shapes.b2Shape = noImpl
        public var tangentImpulse: Number = noImpl
    }
}
module
public object Box2D.Dynamics.Controllers  {
    public class b2Controller {
        public var m_bodyCount: Number = noImpl
        public var m_bodyList: b2ControllerEdge = noImpl
        public fun AddBody(body: b2Body): Unit = noImpl
        public fun Clear(): Unit = noImpl
        public fun Draw(debugDraw: b2DebugDraw): Unit = noImpl
        public fun GetBodyList(): b2ControllerEdge = noImpl
        public fun GetNext(): b2Controller = noImpl
        public fun GetWorld(): b2World = noImpl
        public fun RemoveBody(body: b2Body): Unit = noImpl
        public fun Step(step: Any): Unit = noImpl
    }
    public class b2ControllerEdge {
        public var body: b2Body = noImpl
        public var controller: b2Controller = noImpl
        public var nextBody: b2ControllerEdge = noImpl
        public var nextController: b2ControllerEdge = noImpl
        public var prevBody: b2ControllerEdge = noImpl
        public var prevController: b2ControllerEdge = noImpl
    }
    public class b2BuoyancyController : b2Controller {
        public var angularDrag: Number = noImpl
        public var density: Number = noImpl
        public var gravity: Box2D.Common.Math.b2Vec2 = noImpl
        public var linearDrag: Number = noImpl
        public var normal: Box2D.Common.Math.b2Vec2 = noImpl
        public var offset: Number = noImpl
        public var useDensity: Boolean = noImpl
        public var useWorldGravity: Boolean = noImpl
        public var velocity: Box2D.Common.Math.b2Vec2 = noImpl
    }
    public class b2ConstantAccelController : b2Controller {
        public var A: Box2D.Common.Math.b2Vec2 = noImpl
        public fun Step(step: Any): Unit = noImpl
    }
    public class b2ConstantForceController : b2Controller {
        public var A: Box2D.Common.Math.b2Vec2 = noImpl
        public fun Step(step: Any): Unit = noImpl
    }
    public class b2GravityController : b2Controller {
        public var G: Number = noImpl
        public var invSqr: Boolean = noImpl
        public fun Step(step: Any): Unit = noImpl
    }
    public class b2TensorDampingController : b2Controller {
        public var maxTimeStep: Number = noImpl
        public var T: Box2D.Common.Math.b2Mat22 = noImpl
        public fun SetAxisAligned(xDamping: Number, yDamping: Number): Unit = noImpl
        public fun Step(step: Any): Unit = noImpl
    }
}
module
public object Box2D.Dynamics.Joints  {
    public class b2Joint {
        public fun GetAnchorA(): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetAnchorB(): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetBodyA(): b2Body = noImpl
        public fun GetBodyB(): b2Body = noImpl
        public fun GetNext(): b2Joint = noImpl
        public fun GetReactionForce(inv_dt: Number): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetReactionTorque(inv_dt: Number): Number = noImpl
        public fun GetType(): Number = noImpl
        public fun GetUserData(): Any = noImpl
        public fun IsActive(): Boolean = noImpl
        public fun SetUserData(data: Any): Unit = noImpl
    }
    public class b2JointDef {
        public var bodyA: b2Body = noImpl
        public var bodyB: b2Body = noImpl
        public var collideConnected: Boolean = noImpl
        public var `type`: Number = noImpl
        public var userData: Any = noImpl
    }
    public class b2JointEdge {
        public var joint: b2Joint = noImpl
        public var next: b2JointEdge = noImpl
        public var other: b2Body = noImpl
        public var prev: b2JointEdge = noImpl
    }
    public class b2DistanceJoint : b2Joint {
        public fun GetAnchorA(): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetAnchorB(): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetDampingRatio(): Number = noImpl
        public fun GetFrequency(): Number = noImpl
        public fun GetLength(): Number = noImpl
        public fun GetReactionForce(inv_dt: Number): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetReactionTorque(inv_dt: Number): Number = noImpl
        public fun SetDampingRatio(ratio: Number): Unit = noImpl
        public fun SetFrequency(hz: Number): Unit = noImpl
        public fun SetLength(length: Number): Unit = noImpl
    }
    public class b2DistanceJointDef : b2JointDef {
        public var dampingRatio: Number = noImpl
        public var frequencyHz: Number = noImpl
        public var length: Number = noImpl
        public var localAnchorA: Box2D.Common.Math.b2Vec2 = noImpl
        public var localAnchorB: Box2D.Common.Math.b2Vec2 = noImpl
        public fun Initialize(bA: b2Body, bB: b2Body, anchorA: Box2D.Common.Math.b2Vec2, anchorB: Box2D.Common.Math.b2Vec2): Unit = noImpl
    }
    public class b2FrictionJoint : b2Joint {
        public var m_angularMass: Number = noImpl
        public var m_linearMass: Box2D.Common.Math.b2Mat22 = noImpl
        public fun GetAnchorA(): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetAnchorB(): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetMaxForce(): Number = noImpl
        public fun GetMaxTorque(): Number = noImpl
        public fun GetReactionForce(inv_dt: Number): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetReactionTorque(inv_dt: Number): Number = noImpl
        public fun SetMaxForce(force: Number): Unit = noImpl
        public fun SetMaxTorque(torque: Number): Unit = noImpl
    }
    public class b2FrictionJointDef : b2JointDef {
        public var localAnchorA: Box2D.Common.Math.b2Vec2 = noImpl
        public var localAnchorB: Box2D.Common.Math.b2Vec2 = noImpl
        public var maxForce: Number = noImpl
        public var maxTorque: Number = noImpl
        public fun Initialize(bA: b2Body, bB: b2Body, anchor: Box2D.Common.Math.b2Vec2): Unit = noImpl
    }
    public class b2GearJoint : b2Joint {
        public fun GetAnchorA(): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetAnchorB(): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetRatio(): Number = noImpl
        public fun GetReactionForce(inv_dt: Number): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetReactionTorque(inv_dt: Number): Number = noImpl
        public fun SetRatio(ratio: Number): Unit = noImpl
    }
    public class b2GearJointDef : b2JointDef {
        public var joint1: b2Joint = noImpl
        public var joint2: b2Joint = noImpl
        public var ratio: Number = noImpl
    }
    public class b2LineJoint : b2Joint {
        public fun EnableLimit(flag: Boolean): Unit = noImpl
        public fun EnableMotor(flag: Boolean): Unit = noImpl
        public fun GetAnchorA(): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetAnchorB(): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetJointSpeed(): Number = noImpl
        public fun GetJointTranslation(): Number = noImpl
        public fun GetLowerLimit(): Number = noImpl
        public fun GetMaxMotorForce(): Number = noImpl
        public fun GetMotorForce(): Number = noImpl
        public fun GetMotorSpeed(): Number = noImpl
        public fun GetReactionForce(inv_dt: Number): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetReactionTorque(inv_dt: Number): Number = noImpl
        public fun GetUpperLimit(): Number = noImpl
        public fun IsLimitEnabled(): Boolean = noImpl
        public fun IsMotorEnabled(): Boolean = noImpl
        public fun SetLimits(lower: Number, upper: Number): Unit = noImpl
        public fun SetMaxMotorForce(force: Number): Unit = noImpl
        public fun SetMotorSpeed(speed: Number): Unit = noImpl
    }
    public class b2LineJointDef : b2JointDef {
        public var enableLimit: Boolean = noImpl
        public var enableMotor: Boolean = noImpl
        public var localAnchorA: Box2D.Common.Math.b2Vec2 = noImpl
        public var localAnchorB: Box2D.Common.Math.b2Vec2 = noImpl
        public var localAxisA: Box2D.Common.Math.b2Vec2 = noImpl
        public var lowerTranslation: Number = noImpl
        public var maxMotorForce: Number = noImpl
        public var motorSpeed: Number = noImpl
        public var upperTranslation: Number = noImpl
        public fun Initialize(bA: b2Body, bB: b2Body, anchor: Box2D.Common.Math.b2Vec2, axis: Box2D.Common.Math.b2Vec2): Unit = noImpl
    }
    public class b2MouseJoint : b2Joint {
        public fun GetAnchorA(): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetAnchorB(): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetDampingRatio(): Number = noImpl
        public fun GetFrequency(): Number = noImpl
        public fun GetMaxForce(): Number = noImpl
        public fun GetReactionForce(inv_dt: Number): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetReactionTorque(inv_dt: Number): Number = noImpl
        public fun GetTarget(): Box2D.Common.Math.b2Vec2 = noImpl
        public fun SetDampingRatio(ratio: Number): Unit = noImpl
        public fun SetFrequency(hz: Number): Unit = noImpl
        public fun SetMaxForce(maxForce: Number): Unit = noImpl
        public fun SetTarget(target: Box2D.Common.Math.b2Vec2): Unit = noImpl
    }
    public class b2MouseJointDef : b2JointDef {
        public var dampingRatio: Number = noImpl
        public var frequencyHz: Number = noImpl
        public var maxForce: Number = noImpl
    }
    public class b2PrismaticJoint : b2Joint {
        public fun EnableLimit(flag: Boolean): Unit = noImpl
        public fun EnableMotor(flag: Boolean): Unit = noImpl
        public fun GetAnchorA(): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetAnchorB(): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetJointSpeed(): Number = noImpl
        public fun GetJointTranslation(): Number = noImpl
        public fun GetLowerLimit(): Number = noImpl
        public fun GetMotorForce(): Number = noImpl
        public fun GetMotorSpeed(): Number = noImpl
        public fun GetReactionForce(inv_dt: Number): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetReactionTorque(inv_dt: Number): Number = noImpl
        public fun GetUpperLimit(): Number = noImpl
        public fun IsLimitEnabled(): Boolean = noImpl
        public fun IsMotorEnabled(): Boolean = noImpl
        public fun SetLimits(lower: Number, upper: Number): Unit = noImpl
        public fun SetMaxMotorForce(force: Number): Unit = noImpl
        public fun SetMotorSpeed(speed: Number): Unit = noImpl
    }
    public class b2PrismaticJointDef : b2JointDef {
        public var enableLimit: Boolean = noImpl
        public var enableMotor: Boolean = noImpl
        public var localAnchorA: Box2D.Common.Math.b2Vec2 = noImpl
        public var localAnchorB: Box2D.Common.Math.b2Vec2 = noImpl
        public var localAxisA: Box2D.Common.Math.b2Vec2 = noImpl
        public var lowerTranslation: Number = noImpl
        public var maxMotorForce: Number = noImpl
        public var motorSpeed: Number = noImpl
        public var referenceAngle: Number = noImpl
        public var upperTranslation: Number = noImpl
        public fun Initialize(bA: b2Body, bB: b2Body, anchor: Box2D.Common.Math.b2Vec2, axis: Box2D.Common.Math.b2Vec2): Unit = noImpl
    }
    public class b2PullyJoint : b2Joint {
        public fun GetAnchorA(): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetAnchorB(): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetGroundAnchorA(): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetGroundAnchorB(): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetLength1(): Number = noImpl
        public fun GetLength2(): Number = noImpl
        public fun GetRatio(): Number = noImpl
        public fun GetReactionForce(inv_dt: Number): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetReactionTorque(inv_dt: Number): Number = noImpl
    }
    public class b2PullyJointDef : b2JointDef {
        public var groundAnchorA: Box2D.Common.Math.b2Vec2 = noImpl
        public var groundAnchorB: Box2D.Common.Math.b2Vec2 = noImpl
        public var lengthA: Number = noImpl
        public var lengthB: Number = noImpl
        public var localAnchorA: Box2D.Common.Math.b2Vec2 = noImpl
        public var localAnchorB: Box2D.Common.Math.b2Vec2 = noImpl
        public var maxLengthA: Number = noImpl
        public var maxLengthB: Number = noImpl
        public var ratio: Number = noImpl
        public fun Initialize(bA: b2Body, bB: b2Body, gaA: Box2D.Common.Math.b2Vec2, gaB: Box2D.Common.Math.b2Vec2, anchorA: Box2D.Common.Math.b2Vec2, anchorB: Box2D.Common.Math.b2Vec2): Unit = noImpl
    }
    public class b2RevoluteJoint : b2Joint {
        public fun EnableLimit(flag: Boolean): Unit = noImpl
        public fun EnableMotor(flag: Boolean): Unit = noImpl
        public fun GetAnchorA(): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetAnchorB(): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetJointAngle(): Number = noImpl
        public fun GetJointSpeed(): Number = noImpl
        public fun GetLowerLimit(): Number = noImpl
        public fun GetMotorSpeed(): Number = noImpl
        public fun GetMotorTorque(): Number = noImpl
        public fun GetReactionForce(inv_dt: Number): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetReactionTorque(inv_dt: Number): Number = noImpl
        public fun GetUpperLimit(): Number = noImpl
        public fun IsLimitEnabled(): Boolean = noImpl
        public fun IsMotorEnabled(): Boolean = noImpl
        public fun SetLimits(lower: Number, upper: Number): Unit = noImpl
        public fun SetMaxMotorTorque(torque: Number): Unit = noImpl
        public fun SetMotorSpeed(speed: Number): Unit = noImpl
    }
    public class b2RevoluteJointDef : b2JointDef {
        public var enableLimit: Boolean = noImpl
        public var enableMotor: Boolean = noImpl
        public var localAnchorA: Box2D.Common.Math.b2Vec2 = noImpl
        public var localAnchorB: Box2D.Common.Math.b2Vec2 = noImpl
        public var lowerAngle: Number = noImpl
        public var maxMotorTorque: Number = noImpl
        public var motorSpeed: Number = noImpl
        public var referenceAngle: Number = noImpl
        public var upperAngle: Number = noImpl
        public fun Initialize(bA: b2Body, bB: b2Body, anchor: Box2D.Common.Math.b2Vec2): Unit = noImpl
    }
    public class b2WeldJoint : b2Joint {
        public fun GetAnchorA(): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetAnchorB(): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetReactionForce(inv_dt: Number): Box2D.Common.Math.b2Vec2 = noImpl
        public fun GetReactionTorque(inv_dt: Number): Number = noImpl
    }
    public class b2WeldJointDef : b2JointDef {
        public var localAnchorA: Box2D.Common.Math.b2Vec2 = noImpl
        public var localAnchorB: Box2D.Common.Math.b2Vec2 = noImpl
        public var referenceAngle: Number = noImpl
        public fun Initialize(bA: b2Body, bB: b2Body, anchor: Box2D.Common.Math.b2Vec2): Unit = noImpl
    }
}
