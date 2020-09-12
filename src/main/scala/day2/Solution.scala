package day2

class Position(var x: Int, var y: Int) {
  require(x >= 0 && x < 3)
  require(y >= 0 && x < 3)

  override def toString: String = s"Position($x, $y)"
}

object Solution {
  private val Keys: Array[Array[Int]] = Array(
    (1 to 3).toArray,
    (4 to 6).toArray,
    (7 to 9).toArray
  )

  private class Solution {
    def run(instructions: List[List[Char]]): String = {
      val code = new StringBuilder("")
      val position = new Position(1, 1)

      instructions.foreach(row => {
        row.foreach {
          case 'L' =>
            val newPos = position.x - 1
            if (newPos >= 0) position.x = newPos
          case 'R' =>
            val newPos = position.x + 1
            if (newPos < Keys(position.y).length) position.x = newPos
          case 'D' =>
            val newPos = position.y + 1
            if (newPos < Keys.length) position.y = newPos
          case 'U' =>
            val newPos = position.y - 1
            if (newPos >= 0) position.y = newPos
        }

        val currentKey = Keys(position.y)(position.x)
        code append currentKey
      })

      code.toString
    }
  }

  def run(input: List[List[Char]]): String = {
    (new Solution).run(input)
  }
}
