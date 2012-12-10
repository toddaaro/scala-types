
package typestuff

object Booleans {

  trait Boolean

  class True extends Boolean

  class False extends Boolean

  class BooleanEqual[A <: Boolean, B <: A] extends True

  class IfTrue[A <: True, B]
    
  type mt = True
  type mf = False

  type t0 = BooleanEqual[True, BooleanEqual[False,False]]

  type t1 = IfTrue[t0, False]
  
  type t2 = BooleanEqual[True, t0]

  //type t3 = BooleanEqual[BooleanEqual[True,True], BooleanEqual[False,False]]

  class Equals[A, B >: A <: A]
  type ==[A, B >: A <: A] = Equals[A,B]

  type t4 = Int == Int

}
