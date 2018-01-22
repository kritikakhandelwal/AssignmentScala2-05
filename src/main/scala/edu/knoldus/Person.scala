
package edu.knoldus
import java.io._

import org.json4s.DefaultFormats
import org.json4s.jackson.Serialization.write
import org.apache.log4j.Logger

import scala.io.Source

@SerialVersionUID(1100)
class PersonDetails( val name: String, val age: Int, @transient val day: String,val address: PersonAddress,val salary: Float,
                     @transient val luckyNo: Int)  extends Serializable


class PersonAddress(val street: String,val houseNo: Int)  extends Serializable

object PersonInformation extends App {
  implicit val formats = DefaultFormats

  val log = Logger.getLogger(getClass)
  val name = "Kritika"
  val age = 24
  val day = "Friday"
  val street = "Kasturba Gandhi Marg"
  val houseNo = 1891
  val salary = 12000
  val luckyNum: Int = 7
  val detailsOfPerson = new PersonDetails(name = name, age = age, day = day,
    address = new PersonAddress(street = street, houseNo = houseNo), salary, luckyNum)

  val writeMyFile = new PrintWriter(new File("details.txt"))
  val detailsOfPersonJSON = write(detailsOfPerson)
  writeMyFile.write(detailsOfPersonJSON)
  writeMyFile.close()
  Source.fromFile("details.txt").foreach(data => print(data))
}
