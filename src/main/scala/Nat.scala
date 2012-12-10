
package typestuff

object Nat {

  import Booleans._

  // >:+
  trait TypeVisitor {
    type ResultType
  }

  trait Visitable[V <: TypeVisitor] {
    type Accept[V2 <: V] <: V2#ResultType
  }

  trait NatVisitor extends TypeVisitor {
    type VisitZero <: ResultType
    type VisitSucc[Pre <: Nat] <: ResultType
  }

  // end >:+

  sealed trait Nat {
    type Add[T <: Nat] <: Nat
    type Equals[N <: Nat] <: Bool
    type IsZero <: Bool
    type Accept[N <: NatVisitor] <: N#ResultType
    type Pre <: Nat
  }

  final class Zero extends Nat {
    type Add[N <: Nat] = N
    type Equals[N <: Nat] = N#IsZero
    type IsZero = True
    type Accept[N <: NatVisitor] = N#VisitZero
  }

  final class Succ[P <: Nat] extends Nat {
    type Add[N <: Nat] = Succ[P#Add[N]]
    type Equals[N <: Nat] = N#Accept[EqualsVisitor]
    type IsZero = False
    
    trait EqualsVisitor extends NatVisitor {
      type ResultType = Bool
      type VisitZero = False
      type VisitSucc[Pre <: Nat] = P#Equals[Pre]
    }

    type Accept[N <: NatVisitor] = N#VisitSucc[P]

  }

  

}
