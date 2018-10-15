package com
package horstmann
package impatient

object Chapter7B extends App {

  println(FromCom.value)
  println(FromHorstmann.value)
  println(FromImpatient.value)

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
