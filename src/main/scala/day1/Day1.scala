package day1

import base.Day
import scala.io.Source

object Day1 extends Day {
  override def run(): Int = {
    val input = Source
      .fromResource("day1.txt")
      .mkString
      .split(", ")
      .toList

    Solution.run(input)
  }
}
