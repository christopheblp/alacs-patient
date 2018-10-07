import java.time.LocalDate

object Chapter2 extends App {

  def countdown(n: Int): Unit = {
    for (i <- n to(0, -1))
      println(i)
  }

  def productUnicode(x: String): Long = {
    var product: Long = 1
    for (c <- x)
      product *= c
    product
  }

  def productUnicodeWithoutLoop(x: String): Long = {
    x.map(_.toLong).product
  }

  def product(word: String): Long = {
    if (word.length == 0)
      1
    else
      word.head.toLong * product(word.tail)
  }

  def power(x: Int, n: Int): Long = {
    if (n == 0)
      1
    else if (n % 2 != 0 && n > 0)
      x * power(x, n - 1)
    else if (n % 2 == 0 && n > 0)
      power(x, n / 2) * power(x, n / 2)
    else
      1 / power(x, -n)
  }

  println("Hello, world!")
  println(productUnicode("Hello"))
  countdown(6)
}

/*implicit class DateInterpolator(val sc: StringContext) extends AnyVal {
   def date(args: Any*): LocalDate = {
     LocalDate.of(args(0).toString.toInt, args(1).toString.toInt, args(1).toString.toInt)
   }
 }*/
