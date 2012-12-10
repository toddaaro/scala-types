
package typestuff

object Booleans {

  import Utils._

  trait Bool {
    type And[B <: Bool] <: Bool
    type Or[B <: Bool] <: Bool
    type Not <: Bool
    type If[IfTrue, IfFalse]
    type If2[T, IfTrue <: T, IfFalse <: T] <: T
  }

  class True extends Bool {
    type And[B <: Bool] = B
    type Or[B <: Bool] = True
    type Not = False
    type If[IfTrue, IfFalse] = IfTrue
    type If2[T, IfTrue <: T, IfFalse <: T] = IfTrue
  }

  class False extends Bool {
    type And[B <: Bool] = False
    type Or[B <: Bool] = B
    type Not = True
    type If[IfTrue, IfFalse] = IfTrue
    type If2[T, IfTrue <: T, IfFalse <: T] = IfFalse
  }

  type &&[A <: Bool, B <: Bool] = A#And[B]
  type ||[A <: Bool, B <: Bool] = A#Or[B]
  type Not[A <: Bool] = A#Not
  
  val True = new True
  val False = new False
  
  implicit val falseToBoolean = TypeToValue[False, Boolean](false)
  implicit val trueToBoolean = TypeToValue[True, Boolean](true)

}
