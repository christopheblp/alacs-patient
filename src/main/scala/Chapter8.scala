import scala.collection.mutable.ArrayBuffer

object Chapter8 extends App {

  val item = new SimpleItem(3.25, "Special gift")
  println(item.description)

  val creature = new Ant

  println(creature.env.size)

}

class BankAccount(initialBalance: Double) {
  private var balance = initialBalance

  def currentBalance = balance

  def deposit(amount: Double) = {
    balance += amount
    balance
  }

  def withdraw(amount: Double) = {
    balance -= amount
    balance
  }
}

class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {

  override def deposit(amount: Double) = {
    super.deposit(amount - 1.0)
  }

  override def withdraw(amount: Double) = {
    super.withdraw(amount - 1.0)
  }

}

abstract class Item {
  def price: Double

  def description: String
}

// no override keyword is required in the subclass when you define a field or method that was abstract in the superclass
class SimpleItem(val price: Double, val description: String) extends Item

class Bundle(var items: ArrayBuffer[Item] = new ArrayBuffer[Item]) extends Item {

  def price: Double = items.map(x => x.price).sum

  def addItem(item: Item) {
    items += item
  }

  def description: String = items.map(_.description).mkString(" ")
}

class Point(val x: Int, val y: Int)

class LabeledPoint(var label: String, x: Int, y: Int) extends Point(x, y)

abstract class Shape {
  def centerPoint: Point
}

class Rectangle(val top: Point, val bottom: Point) extends Shape {
  def centerPoint = new Point((top.x + bottom.y) / 2, (top.y + bottom.x) / 2)
}

class Circle(val centerPoint: Point, val radius: Int) extends Shape

class Square(cornerPoint: Point = new Point(0, 0), width: Int = 0) extends java.awt.Rectangle(cornerPoint.x, cornerPoint.y, width, width) {
  def this(width: Int) {
    this(new Point(0, 0), width)
  }
}

class Person3(val name: String) {
  override def toString = s"${getClass.getName}{name=$name}"
}

class SecretAgent(codename: String) extends Person3(codename) {
  override val name = "secret"
  override val toString = "secret"
}

class Creature {
  def range: Int = 10

  val env: Array[Int] = new Array[Int](range)
}

class Ant extends Creature {
  override val range = 2
}


