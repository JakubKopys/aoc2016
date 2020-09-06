package day1

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SolutionSpec extends AnyFlatSpec with Matchers {
  "The Solution Object" should "return correct result" in {
    Solution.run(List("R2", "L3")) shouldEqual 5
    Solution.run(List("R2", "R2", "R2")) shouldEqual 2
    Solution.run(List("R5", "L5", "R5", "R3")) shouldEqual 12
    Solution.run(List("R10")) shouldEqual 10
    Solution.run(List("R10", "L100")) shouldEqual 110
  }
}
