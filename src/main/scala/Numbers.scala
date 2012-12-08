
package typestuff

object Numbers {

  class True
  class False

  trait Number {
    type Equals[N <: Number]
    type Dec <: Number
  }

  class Zero extends Number {
    type Equals[N <: Number]
  }
  
  class Suc[T <: Number] extends Number {
    type Equals[N <: Number] = T#Equals[N#Dec]
    type Dec = T
  }

  //type t0 = Zero#Equals[Suc[Zero]]

  // doesn't inspect type parameters
  // class Equals[A <: Number, B <: A >: A]

  type one = Suc[Zero]
  type two = Suc[Suc[Zero]]

  type t0 = two#Equals[Suc[Suc[Suc[Zero]]]]

}

