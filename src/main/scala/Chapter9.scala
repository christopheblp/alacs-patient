import java.io.PrintWriter

import scala.io.Source
import scala.sys.process._

object Chapter9 extends App {

  //  reverseLine("chapter4.txt")

  replaceTabBySpace("chapter4.txt")

  //  printUppercaseWordsFromFile("chapter4.txt")

  countClassFiles("/home/christophe")

  //"ls -al ..".!

  /*val source = Source.fromURL("http://mediatheques.valparisis.fr/").mkString

  for(word <- source.split("\\ "))
    println(word)*/
  /*
    val numPattern = """\d+""".r

    for (matchString <- numPattern.findAllIn("But shit it was 99,6 !"))
      println(matchString)*/

  def writeOnFile(filename: String) {
    val out = new PrintWriter(filename)
    for (i <- 1 to 100) out.println(i)
    out.close
  }

  def reverseLine(filename: String): Unit = {
    val source = Source.fromFile(filename).getLines.toArray[String].reverse
    val out = new PrintWriter(filename)
    source.foreach(out.println(_))
    out.close()
  }

  def replaceTabBySpace(filename: String): Unit = {
    val pattern = "\t".r
    val sourceText = Source.fromFile(filename).mkString
    pattern.replaceAllIn(sourceText, " ")
    println(sourceText)
  }

  def printUppercaseWordsFromFile(filename: String): Unit = {
    Source.fromFile(filename).mkString.split("\\s+").filter(_.length > 12).foreach(println(_))
  }

  def countClassFiles(directoryName: String): Unit = {
    println(("find " + directoryName + " -name *.class " #| " wc -l ").!!)
  }

}
