package lectures.part1

import scala.annotation.tailrec
import scala.util.Try

object Recap extends App {

  val aCondition: Boolean = false
  val aConditionedVal = if (aCondition) 42 else 65

  // instructions vs expressions
  val aCodeBlock = {
    if (aCondition) 54
    56
  }

  // Unit = void
  val theUnit = println("Hello Scala")

  // functions
  def aFunction(x: Int): Int = x + 1

  // recursion: stack and tail
  @tailrec
  def factorial(n: Int, acc: Int): Int = {
    if(n <= 0) acc
    else factorial(n - 1, n * acc)
  }

  // object-oriented programming

  class Animal
  class Dog extends Animal
  val aDog: Animal = new Dog // subtyping polymorphism

  trait Carnivore {
    def eat(a: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    override def eat(a: Animal): Unit = println("Crunch")
  }

  val aCrock = new Crocodile
  aCrock.eat(aDog)
  aCrock eat aDog // natural language

  1 + 2
  1.+(2) // equal

  // anonymous classes
  val aCarnivore = new Carnivore {
    override def eat(a: Animal): Unit = println("new crunch")
  }

  // generics
  abstract class MyList[+A] // variance and variance problems in THIS course
  // singleton objects and companions
  object MyList

  // case classes -- serializable, all parameters are field, has companion object with .apply
  case class Person(name: String, age: Int)

  // exceptions and try/catch/finally

  val throwsException = throw new RuntimeException // is of type Nothing
  val aPotentialFailure = try {
    throw new RuntimeException
  } catch {
    case e: Exception => "I caught an exception"
  } finally {
    println("some logs")
  }

  // packaging and imports
  /* Scala is more OOP than languages like Java */
  //________

  /** functional programming */
  val incrementer = new Function[Int, Int] {
    override def apply(v1: Int): Int = v1 + 1
  }
  incrementer(1)

  val anonymousIncrementer = (x: Int) => x + 1 // also a Function 1
  List(1,2,3).map(anonymousIncrementer) // HOF (higher order function)

  // for-comprehension
  val pairs = for {
    num <- List(1,2,3)  // if condition
    char <- List("a","b","c")
  } yield num + "-" + char

  // Scala collections: Seqs, Arrays, Lists, Verctors, Maps, Tuples
  val aMap = Map(
    "Daniel" -> 789,
    "Jess" -> 666
  )

  // "collections": Option, Try
  val anOption = Some(2)
  val aTry = Try(3)

  // pattern matching
  val x = 2
  val order = x match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => x + "th"
  }

  val bob = Person("Bob", 22)
  val greeting = bob match {
    case Person(name, _ ) => s"Hello I'm $name"
  }


}
