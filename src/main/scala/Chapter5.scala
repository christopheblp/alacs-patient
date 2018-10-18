import scala.beans.BeanProperty
import scala.collection.mutable.ArrayBuffer

object Chapter5 extends App {

  val counter = new Counter
  counter.increment()
  counter.increment()

  val anotherCounter = new Counter
  println(anotherCounter.isLess(counter))

  val person = new Person("Uchiha", 23)
  println(person.age)

  val bankAccount = new BankAccount2(0)
  bankAccount.deposit(10)
  println(bankAccount.balance)

  val chatter = new Network
  val myFace = new Network

  val fred = chatter.join("Fred")
  val wilma = chatter.join("Wilma")
  fred.contacts += wilma

  val barney = myFace.join("Barney")
  //fred.contacts += barney

  val time = new Time(23, 9)
  val anotherTime = new Time(12, 5)

  println(time.before(anotherTime))

  val person3 = new Person2("Harry Kane")
  println(person3.firstname + " " + person3.lastname)

  val car = new Car("citroen", "c4", 2009)
  println(car.manufacturer)

}

class Network {

  class Member(val name: String) {
    val contacts = new ArrayBuffer[Member]
  }

  private val members = new ArrayBuffer[Member]

  def join(name: String) = {
    val m = new Member(name)
    members += m
    m
  }
}

class Counter(private var value: Int = 0) {

  def increment() {
    if (value + 1 == Int.MaxValue)
      throw new IllegalStateException("number has reached maximum value")
    else
      value += 1
  }

  def isLess(other: Counter) = value < other.value

}

class BankAccount2(private var amount: Int) {

  def deposit(money: Int) {
    amount -= money
  }

  def withdraw(money: Int) {
    amount += money;
  }

  def balance = amount

}

class Person(var name: String, var age: Int) {
  if (age < 0) age = 0
}

class Person2(str: String) {
  val firstname = str.split(" ")(0)
  val lastname = str.split(" ")(1)
}

class Time(private var hours: Int, private var minutes: Int) {

  if (hours < 0 || hours > 23)
    throw new Exception("Wrong value for hour")

  def before(other: Time): Boolean = {
    if (hours < other.hours)
      true
    else if (hours == other.hours && minutes < other.minutes)
      true
    else
      false
  }
}

class Time2(private var hours: Int, private var minutes: Int) {

  private val totalMinutes = hours * 60 + minutes

  if (hours < 0 || hours > 23)
    throw new Exception("Wrong value for hour")

  def before(other: Time2): Boolean = {
    totalMinutes < other.totalMinutes
  }
}

class Student(@BeanProperty var name: String = "", @BeanProperty var id: Long = 0) {}

class Car(val manufacturer: String, val model_name: String, val model_year: Int = -1
          , var license_plate: String = "") {}

class Employee(val name: String, var salary: Double) {
  def this() {
    this("John Q. Public", 0.0)
  }
}

class Employee2 {
  private var _name = "John Q. Public" // we add _ because we want a getter named "name"
  var salary = 0.0

  def this(n: String, s: Double) {
    this()
    _name = n
    salary = s
  }

  def name() = _name

}