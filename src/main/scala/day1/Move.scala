package day1

sealed abstract class Move(val direction: Char, val distance: Int) {
  override def toString: String = s"Movement($direction, $distance)"
}

case class Left(
    override val direction: Char = 'L',
    override val distance: Int,
) extends Move(direction, distance)

case class Right(
    override val direction: Char = 'R',
    override val distance: Int,
) extends Move(direction, distance)

object Move {
  def fromString(str: String): Move = {
    str(0) match {
      case 'L' => Left(distance = str.substring(1).toInt)
      case 'R' => Right(distance = str.substring(1).toInt)
      case _   => throw new Exception("Unknown movement")
    }
  }
}
