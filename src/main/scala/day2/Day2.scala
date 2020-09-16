package day2

import base.Day
import scala.io.Source

object Day2 extends Day {
  override def run(): (String, String) = {
    val input = Source
      .fromResource("day2.txt")
      .mkString
      .split("\n")
      .toList
      .map(_.toList)

    (Solution.run(input), Solution.run2(input))
  }
}
