package day2

class Position(var x: Int, var y: Int) {
  override def toString: String = s"Position($x, $y)"
}

object Solution {
  private val Keys: Array[Array[Char]] = Array(
    Array('1', '2', '3'),
    Array('4', '5', '6'),
    Array('7', '8', '9'),
  )

  private val KeysPartTwo: Array[Array[Char]] = Array(
    Array(' ', ' ', '1', ' ', ' '),
    Array(' ', '2', '3', '4', ' '),
    Array('5', '6', '7', '8', '9'),
    Array(' ', 'A', 'B', 'C', ' '),
    Array(' ', ' ', 'D', ' ', ' ')
  )

  private class Solution {
    def run(instructions: List[List[Char]],
            keys: Array[Array[Char]] = Keys,
            initPosition: Array[Int] = Array(1, 1)): String = {
      require(initPosition.length == 2)

      val code = new StringBuilder("")
      val position = new Position(x = initPosition(0), y = initPosition(1))

      instructions.foreach(row => {
        row.foreach {
          case 'L' =>
            val newPos = position.x - 1
            if (newPos >= 0 && keys(position.y)(newPos) != ' ') {
              position.x = newPos
            }
          case 'R' =>
            val newPos = position.x + 1
            if (newPos < keys(position.y).length && keys(position.y)(newPos) != ' ') {
              position.x = newPos
            }
          case 'D' =>
            val newPos = position.y + 1
            if (newPos < keys.length && keys(newPos)(position.x) != ' ') {
              position.y = newPos
            }
          case 'U' =>
            val newPos = position.y - 1
            if (newPos >= 0 && keys(newPos)(position.x) != ' ') {
              position.y = newPos
            }
        }

        val currentKey = keys(position.y)(position.x)
        code append currentKey
      })

      code.toString
    }

    def functionalRun(instructions: List[List[Char]],
                      keys: Array[Array[Char]] = Keys,
                      initPosition: Array[Int] = Array(1, 1)): String = {
      var position = new Position(x = initPosition(0), y = initPosition(1))

      instructions.foldLeft("")(
        (total: String, row: List[Char]) => {
          row.foreach((char: Char) => {
            val newPos = char match {
              case 'L' =>
                val newPosX = position.x - 1

                if (newPosX >= 0 && keys(position.y)(newPosX) != ' ') {
                  new Position(x = newPosX, y = position.y)
                } else {
                  position
                }
              case 'R' =>
                val newPosX = position.x + 1

                if (newPosX < keys(position.y).length && keys(position.y)(newPosX) != ' ') {
                  new Position(x = newPosX, y = position.y)
                } else {
                  position
                }
              case 'D' =>
                val newPosY = position.y + 1

                if (newPosY < keys.length && keys(newPosY)(position.x) != ' ') {
                  new Position(x = position.x, y = newPosY)
                } else {
                  position
                }
              case 'U' =>
                val newPosY = position.y - 1

                if (newPosY >= 0 && keys(newPosY)(position.x) != ' ') {
                  new Position(x = position.x, y = newPosY)
                } else {
                  position
                }
            }

            position = newPos
          })
          total + keys(position.y)(position.x)
        })
    }
  }

  def run(input: List[List[Char]]): String =
    (new Solution).run(input)

  def run2(input: List[List[Char]]): String =
    (new Solution).run(input, keys = KeysPartTwo, initPosition = Array(0, 2))

  def kindaFunctionalButNotReally(input: List[List[Char]]): String =
    (new Solution).functionalRun(input)

  def kindaFunctionalButNotReally2(input: List[List[Char]]): String =
    (new Solution).functionalRun(input, keys = KeysPartTwo, initPosition = Array(0, 2))
}
