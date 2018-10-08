import java.util.Scanner

import scala.collection.JavaConverters._
import scala.collection.convert.WrapAsScala.`deprecated mapAsScalaMap`
import scala.collection.mutable

object Chapter4 extends App {

  val map1 = Map("Alice" -> 10.0, "Bob" -> 3.0, "Harry" -> 10.0)

  for ((k, v) <- map1)
    println(k + " " + v)

  def discount(m: Map[String, Double]): Map[String, Double] = {
    for ((k, v) <- m) yield (k, v - (v * 10) / 100)
  }

  val map2 = discount(map1)

  for ((k, v) <- map2) println(k + " " + v)

  def countWordsFromFileWithMutableMap(file: String) = {
    val map = mutable.Map[String, Int]()
    val in = new Scanner(new java.io.File("chapter4.txt"))
    while (in.hasNext()) {
      var tmpVal = in.next()
      map(tmpVal) = map.getOrElse(tmpVal, 0) + 1
    }
    map
  }

  def countWordsFromFileWithImmutableMap(file: String) = {
    var newMap = Map[String, Int]()
    val in = new Scanner(new java.io.File("chapter4.txt"))
    while (in.hasNext()) {
      var tmpVal = in.next()
      newMap += (tmpVal -> (newMap.getOrElse(tmpVal, 0) + 1))
    }
    newMap
  }

  def countWordsFromFileWithSortedMap(file: String) = {
    val map = mutable.SortedMap[String, Int]()
    val in = new Scanner(new java.io.File("chapter4.txt"))
    while (in.hasNext()) {
      var tmpVal = in.next()
      map(tmpVal) = map.getOrElse(tmpVal, 0) + 1
    }
    map
  }

  def countWordsFromFileWithTreeMap(file: String) = {
    val map = new java.util.TreeMap[String, Int]()
    val in = new Scanner(new java.io.File("chapter4.txt"))
    while (in.hasNext()) {
      var tmpVal = in.next()
      map(tmpVal) = map.getOrElse(tmpVal, 0) + 1
    }
    map
  }

  def mapDays = {
    val map = mutable.LinkedHashMap[String, Int]("Monday" -> java.util.Calendar.MONDAY)
    map +=
      ("Tuesday" -> java.util.Calendar.TUESDAY
        , "Wednesday" -> java.util.Calendar.WEDNESDAY
        , "Thursday" -> java.util.Calendar.THURSDAY
        , "Friday" -> java.util.Calendar.FRIDAY
        , "Saturday" -> java.util.Calendar.SATURDAY
        , "Sunday" -> java.util.Calendar.SUNDAY)
    map
  }


  val resultMap = countWordsFromFileWithImmutableMap("chapter4.txt")
  for ((k, v) <- resultMap) println(k + " " + v)
  // or
  //println(resultMap.mkString(" "))

  def printJavaProperties {
    val map: collection.Map[String, String] = System.getProperties.asScala
    var max = map.keySet.map(x => x.length).max
    for ((key, value) <- map) println(key.padTo(max, ' ') + " | " + value)
  }

  printJavaProperties

  def minmax(values: Array[Int]) = {
    (values.min, values.max)
  }

  def lteqgt(values: Array[Int], v: Int) = {
    (values.count(_ < v), values.count(_ == v), values.count(_ >= v))
  }

  println(minmax(Array(1, 5, 17, 38, -7, 289, 356)))
  println(lteqgt(Array(2, 3, 3, 3, 312, 16, 7, 0, -1, -126, -5), 3))
}