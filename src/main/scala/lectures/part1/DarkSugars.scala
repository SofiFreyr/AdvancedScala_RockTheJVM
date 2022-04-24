package lectures.part1

import scala.util.Try

object DarkSugars {

  /** syntax sugar #1: methods with single param */
  def singleArgMethod(arg: Int): String = s"$arg little ducks"

  val description = singleArgMethod {
    // write some complex code
    42
  }

  val aTryInstance = Try { // similar to Java try {...}
    throw new RuntimeException
  }

  List(1,2,3).map{ x =>
    x + 1
  }

  /** syntax sugar #2: single abstract method */
  trait Action {
    def act(x: Int): Int
  }

  val anInstance: Action = new Action {
    override def act(x: Int): Int = x + 1
  }

  val aFunkyInstance: Action = (x: Int) => x + 1 // a lot of magic

  // example: Runnables
  val aThread = new Thread(new Runnable {
    override def run(): Unit = println("Hello Scala")
  })

  val aSweeterThread = new Thread(() => println("Sweet, Scala!"))

  abstract class AnAbstractType {
    def implemented: Int = 23
    def unimplemented(a: Int): Unit
  }

  val anAbstractInstance: AnAbstractType = (a: Int) => println("sweet")

  /** syntax sugar #3: the :: and #:: methods are special */

  val prependedList = 2 :: List(3,4)
  // 2.::(List(3,4) xxx
  // List(3,4).::(2)
  // ?!

  // scala spec: last character decides associativity of method
  1 :: 2 :: 3 :: List(4,5)
  List(4,5).::(3).::(2).::(1)

  class MyStream[T] {
    def -->:(value: T): MyStream[T] = this
  }
  val myStream = 1 -->: 2 -->: 3 -->: new MyStream[Int]


  /** syntax sugar #4: multi-word method naming*/

  class DumbBoy(name: String) {
    def `and then said`(misoginy: String):Unit = println(s"$name said $misoginy")
  }

  val jason = new DumbBoy("Jason") `and then said` "I'm gonna trash teen girls in my Scala course"

  /** syntax sugar #5: infix types */

  class Composite[A, B]
  val composite: Int Composite String = ???

  class  -->[A, B]
  val towards: Int --> String = ???

  /** syntax sugar #6: update() is very special, much like apply() */

  val anArray: Array[Int] = Array(1,2,3)
  anArray(2) = 7 // rewritten to anArray.update(2, 7)
  // used in mutable collections
  // remember apply() and update() !

  /** syntax sugar %7: setters for mutable containers */

  class Mutable {
    private var internalMember: Int = 0 // private for OO incapsulation
    def member: Int = internalMember // "getter"
    def member_=(value: Int): Unit =
      internalMember = value
  }

  val aMutableContainer = new Mutable
  aMutableContainer.member = 42 // rewritten as aMutableContainer.member_=(42)



  def main(args: Array[String]): Unit = {

  }
}
