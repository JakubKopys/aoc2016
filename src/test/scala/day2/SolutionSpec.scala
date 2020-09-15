package day2

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SolutionSpec extends AnyFlatSpec with Matchers {
  ".run method" should "return correct result" in {
    val input: List[List[Char]] =
      "ULL".toList :: "RRDDD".toList :: "LURDL".toList :: "UUUUD".toList :: Nil

    Solution.run(input) shouldEqual "1985"
  }

  ".run2 method" should "return correct result" in {
    val input: List[List[Char]] =
      "ULL".toList :: "RRDDD".toList :: "LURDL".toList :: "UUUUD".toList :: Nil

    Solution.run2(input) shouldEqual "5DB3"
  }
}
