
package typestuff

// saving this as it infinite loops the compiler without a stack
// overflow

object Numbers {

  trait Nat {
    type dec <: Nat
  }


  class Zero extends Nat {
    
  }

  class Suc[T <: Nat] extends Nat {
    type dec = T
  }

  type one = Suc[Zero]
  type two = Suc[Suc[Zero]]

  class Equals[A, B >: A <: A]
  type ==[A <: Nat, B >: A <: A] = Equals[A,B]

  type t0 = one == Suc[Zero]

  // type level trampoline is what allows recursion? maybe?
/*
  trait Add {
    type Next <: Add
    type F[R <: Add] <: Nat
  }

  trait AddImpl[A <: Nat, B <: Nat] extends Add with Nat {
    type dec = AddImpl[A, B#dec]
    type Next = AddImpl[Suc[A], B#dec]
    type F[R <: Add] = R#F[R#Next]      
  }

  type t1 = AddImpl[Zero, Zero]#F[AddImpl[Zero,Zero]#Next]
*/
/*
  trait Recur[T] {
    type Next <: Recur
    type F[R <: Recur] <: T
  }

  trait Add extends Recur[Nat] {
    type Next = Int
    type F[R <: Recur] <: Nat = Int
  }
*/

//  type add[A <: Number, B <: Number] = A + B
//  type +[A <: Number, B <: Number] = add[Suc[A], B]


  // recursion?
  
  trait Recurse {
    type Next <: Recurse
    type X[R <: Recurse] <: Number
  }

  trait RecurseA extends Recurse {
    type Next = RecurseA
    type X[R <: Recurse] = R#X[R#Next]
  }
  
//  type tomega = RecurseA#X[RecurseA]

  


}

