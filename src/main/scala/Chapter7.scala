import scala.collection.JavaConverters.mapAsScalaMapConverter
package com {

  object FromCom {
    val value = 1
  }

  package horstmann {

    object FromHorstmann {
      val value = 2
    }

    package impatient {

      object FromImpatient {
        val value = 3
      }

    }

  }

}


package game {
  package com {

    object puzzler {
      println("Qu'est ce qui est jaune et qui attend ?")
    }

  }

}

package object random {
  private var seed = 0
  val a = 1664525
  val b = 1013904223
  val n = 32

  def nextInt(): Int = {
    val next = (seed * a * b) % Math.pow(2, n)
    next.toInt
  }

  def nextDouble(): Double = {
    val next = (seed * a * b) % Math.pow(2, n)
    next
  }

  def setSeed(seed: Int): Unit = {
    this.seed = seed
  }
}

/**
  * private[com] makes definition package-private, meaning it is visible within
  * the same package and all sub-packages.
  */
package com {

  object Test {
    private[com] def giveRaise(rate: Double): Unit = {
      rate * 2.13
    }
  }

  object Test2 {
    println(Test.giveRaise(4))
  }

  package com2 {

    object Main {
      println(Test.giveRaise(3))
    }

  }

}

import java.util.{HashMap => JavaHashMap}

import scala.collection.mutable.{HashMap => ScalaHashMap}

object Test3 {
  def convertMap(map: JavaHashMap[Int, String]) = {
    val scalaMap = new ScalaHashMap[Int, String]
    for ((k, v) <- map.asScala)
      scalaMap += (k -> v)
    scalaMap
  }
}

import java.lang.System._

object Test4 extends App {
  val username = getProperty("user.name")
  var password = ""
  do {
    println("Enter a password")
    password = Console.readLine
  } while (!(password.equals("secret")))
  println("Congrats")
}