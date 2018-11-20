import Cards.Cards

object Chapter6 extends App {
  println(Conversions.gallonsToLiters(2.12))

  var point = Point(2, 3)
  println(Cards.carreau)

  def isRed(card: Cards): Boolean = {
    card == Cards.coeur || card == Cards.carreau
  }

}

object Conversions {
  def inchesToCentimeters(inches: Double) = {
    var centimeters = inches * 2.54
    centimeters
  }

  def gallonsToLiters(gallons: Double) = {
    var liters = gallons * 3.78541
    liters
  }

  def milesToKilometers(miles: Double) = {
    var meters = miles * 1.60934
    meters
  }
}

abstract class UnitConversion {
  def convert(precision: Double): Double
}

object InchesToCentimeters extends UnitConversion {
  override def convert(inches: Double): Double = inches * 2.54
}

object GallonsToLiters extends UnitConversion {
  override def convert(gallons: Double): Double = gallons * 3.78541
}

object MilesToKilometers extends UnitConversion {
  override def convert(miles: Double): Double = miles * 1.60934
}

object Origin extends java.awt.Point

class Point private(val x: Int, val y: Int)

object Point {
  def apply(x: Int, y: Int): Unit = {
    new Point(x, y)
  }
}

object Cards extends Enumeration {
  type Cards = Cards.Value
  val pique = Value("♠")
  val trefle = Value("♣")
  val coeur = Value("♥")
  val carreau = Value("♦")

}

object RGB extends Enumeration {
  type RGB = Value
  val Black = Value(0x000000)
  val White = Value(0xffffff)
  val Red = Value(0xff0000)
  val Lime = Value(0x00ff00)
  val Blue = Value(0x0000ff)
  val Yellow = Value(0xffff00)
  val Cyan = Value(0x00ffff)
  val Magenta = Value(0xff00ff)
}