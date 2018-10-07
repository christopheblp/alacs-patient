import scala.collection.mutable.ArrayBuffer
import scala.util.{Random, Sorting}

object Chapter3 extends App {
  def randomArray(n: Int): Array[Int] = {
    val r = new Random
    val array = new Array[Int](n)
    for (i <- 0 until n) {
      array(i) = r.nextInt(n)
    }
    array
  }

  def swapAdjacentElement(array: Array[Int]): Unit = {
    for (i <- array.indices by 2) {
      var tmp = array(i)
      array(i) = array(i + 1)
      array(i + 1) = tmp
    }
  }

  def swapAdjacentElement2(array: Array[Int]) = {
    val newArray =
      for (i <- array.indices)
        yield array(
          if (i % 2 == 0)
            if (i + 1 == array.length)
              i
            else
              i + 1
          else
            i - 1
        )
    newArray
  }

  def rearrangeElements(array: Array[Int]): Array[Int] = {
    var positiveValueArray = array.filter(_ > 0)
    var othersValueArray = array.filter(_ <= 0)
    var rearrangedArray = positiveValueArray ++ othersValueArray
    rearrangedArray
  }

  val arrayNegativeElements = ArrayBuffer(1, -4, 8, 0, -4)

  def removeElements(array: ArrayBuffer[Int]): ArrayBuffer[Int] = {
    val negativeIndexes = for (i <- array.indices if array(i) < 0) yield i
    val indexes = negativeIndexes.drop(1)
    for (j <- indexes.indices.reverse)
      array.remove(indexes(j))
    array
  }


  val array = randomArray(10)
  println(array.mkString(", "))
  swapAdjacentElement(array)
  println(array.mkString(", "))
  val newArray = swapAdjacentElement2(array)
  println(newArray.mkString(", "))
  println(rearrangeElements(Array(1, -4, 8, 0, -4)).mkString(" ,"))

  val DoubleArray = Array(1.2, 2.4, 2.8, 3.9)
  println(DoubleArray.sum / DoubleArray.length)

  val array2 = Array(6, 2, 3, 1, 4, 5)
  Sorting.quickSort(array2)
  println(array2.reverse.mkString(", "))

  val arrayBuffer = ArrayBuffer(6, 2, 1, 3, 5, 4)
  val arrayBufferToArray = arrayBuffer.toArray
  Sorting.quickSort(arrayBufferToArray)
  println(arrayBufferToArray.reverse.mkString(", "))

  val duplicateArray = Array(2, 3, 3, 3, 4, 4, 5, 6, 6, 7, 7)
  println(duplicateArray.distinct.mkString(", "))

  val result = removeElements(arrayNegativeElements)
  println(result.mkString(", "))
  java.util.TimeZone.getAvailableIDs.filter(x => x.startsWith("America/")).sorted
}
