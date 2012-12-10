
package typestuff

object Main {

  import Booleans._
  import Nat._

  def main(args: Array[String]) {

    // do stuff

  }

  implicitly[ True && False || Not[False] =:= True ]

  implicitly[ Succ[Zero]#Add[Succ[Zero]] =:= Succ[Succ[Zero]] ]

  implicitly [ Zero#Equals[Zero] =:= True ]

//  implicitly [ Succ[Succ[Zero]]#Equals[Zero#Add[Succ[Zero]]] =:= False ]

  implicitly [ Succ[Zero]#Equals[Succ[Zero]] => True ]

}

