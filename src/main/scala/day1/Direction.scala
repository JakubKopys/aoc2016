package day1

abstract class Direction {
  def move(m: Movement): (Direction, Point)
}

class North extends Direction {
  def move(m: Movement): (Direction, Point) = {
    m match {
      case Left(_, distance)  => (new West, new Point(distance, 0))
      case Right(_, distance) => (new East, new Point(-distance, 0))
    }
  }
}

class East extends Direction {
  def move(m: Movement): (Direction, Point) = {
    m match {
      case Left(_, distance)  => (new North, new Point(0, distance))
      case Right(_, distance) => (new South, new Point(0, -distance))
    }
  }
}

class West extends Direction {
  def move(m: Movement): (Direction, Point) = {
    m match {
      case Left(_, distance)  => (new South, new Point(0, -distance))
      case Right(_, distance) => (new North, new Point(0, distance))
    }
  }
}

class South extends Direction {
  def move(m: Movement): (Direction, Point) = {
    m match {
      case Left(_, distance)  => (new East, new Point(distance, 0))
      case Right(_, distance) => (new West, new Point(distance, 0))
    }
  }
}
