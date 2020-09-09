package day1

class Point(val x: Int, val y: Int) {
  def +(that: Point): Point = new Point(x + that.x, y + that.y)
  def -(that: Point): Point = new Point(x - that.x, y - that.y)

  override def toString: String = s"Point($x, $y)"
}

class Position() {
  private var current = new Point(0, 0)
  private var direction: Direction = new North()

  def move(m: Movement): Unit = {
    val (dir, posChange) = direction.move(m)

    direction = dir
    current = current + posChange
  }

  def manhattanDistanceFromStart(): Int = {
    val start = new Point(0, 0)

    (current.x - start.x).abs + (current.y + start.y).abs
  }
}

object Solution {
  private class Solution {
    def run(input: List[String]): Int = {
      val position = new Position()
      val movements: List[Movement] = input.map(i => Movement.fromString(i))

      movements.foreach(movement => position.move(movement))

      position.manhattanDistanceFromStart()
    }
  }

  def run(input: List[String]): Int =
    (new Solution).run(input)
}
