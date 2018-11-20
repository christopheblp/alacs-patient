import java.awt.geom.Ellipse2D

object Chapter10 extends App {

  var savingAccount = new SavingAccount with ConsoleLogger
  savingAccount.withdraw(2.13)

  val savingAccount2 = new SavingAccount with TimestampLogger with ShortLogger
  val savingAccount3 = new SavingAccount with ShortLogger with TimestampLogger

  savingAccount2.withdraw(2.3)
  savingAccount3.withdraw(101.0)

  val egg = new Ellipse2D.Double(5, 10, 20, 30) with RectangleLike

  println(egg)
  egg.translate(10, -10)
  println(egg)
  egg.grow(10, 20)
  println(egg)

  /*val x1 = new OrderedPoint(1, 2)
  val x2 = new OrderedPoint(2, 3)*/

  //println(x1 < x2)

  val test = new Message with CryptoLogger

  println(test.log(""))

}

trait Logger {
  def log(msg: String)

  def info(msg: String) {
    log(s"INFO: $msg")
  }

  def warn(msg: String) {
    log(s"WARN: $msg")
  }

  def severe(msg: String) {
    log(s"SEVERE: $msg")
  }
}

trait ConsoleLogger extends Logger {
  def log(msg: String) {
    println(msg)
  }
}

class Account {
  var balance: Double = 100.0
}

abstract class SavingAccount extends Account with ConsoleLogger with ShortLogger {
  var interest = 0.0

  def withdraw(amount: Double): Unit = {
    if (amount > balance) severe("Insufficient funds")
    else {
      balance -= amount
      log("Transaction totally completed !")
    }
  }
}

trait TimestampLogger extends ConsoleLogger {
  override def log(msg: String): Unit = {
    super.log(s"${java.time.Instant.now()} $msg")
  }
}

trait ShortLogger extends ConsoleLogger {
  val maxLength = 15

  // abstract override because Logger has an abstract log method
  override def log(msg: String): Unit = {
    super.log(
      if (msg.length <= maxLength) msg else s"${msg.substring(0, maxLength - 3)}..."
    )
  }
}

trait LoggedException extends Exception with ConsoleLogger {
  def log() {
    log(getMessage)
  }
}

class UnappyException extends LoggedException {
  override def getMessage() = "arggh!"
}

trait RectangleLike {

  def getX(): Double

  def getY(): Double

  def getWidth(): Double

  def getHeight(): Double

  def setFrame(x: Double, y: Double, width: Double, height: Double)

  def translate(dx: Double, dy: Double) = {
    setFrame(getX() + dx, getY() + dy, getWidth(), getHeight())
  }

  def grow(dx: Double, dy: Double) = {
    setFrame(getX() - dx, getY() - dy, getWidth() + 2 * dx, getHeight() + 2 * dy)
  }

}

class OrderedPoint(x: Int, y: Int) extends Point(x, y) with math.Ordered[Point] {
  override def compare(that: Point): Int = {
    if (this.x < that.x || this.x == that.x && this.y < that.y)
      1
    else if (this.x == that.x && this.y == that.y)
      0
    else
      1
  }
}

class Message extends Logger {
  override def log(msg: String): Unit = println("Buenos dias")
}


trait CryptoLogger extends Logger {
  var key: Int = 3

  def encrypt(message: String) = {
    super.log(message.map(c => (c.toInt + key).toChar).mkString)
  }
}


