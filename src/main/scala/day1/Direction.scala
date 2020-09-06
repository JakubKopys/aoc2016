package day1

abstract class Direction {
  def move(m: Movement): (Direction, Point)
}

class North extends Direction {
  def move(m: Movement): (Direction, Point) = {
    if (m.isRight) {
      return (new East, new Point(m.distance, 0))
    }
    (new West, new Point(-m.distance, 0))
  }
}

class East extends Direction {
  def move(m: Movement): (Direction, Point) = {
    if (m.isRight) {
      return (new South, new Point(0, -m.distance))
    }
    (new North, new Point(0, m.distance))
  }
}

class West extends Direction {
  def move(m: Movement): (Direction, Point) = {
    if (m.isRight) {
      return (new North, new Point(0, m.distance))
    }
    (new South, new Point(0, -m.distance))
  }
}

class South extends Direction {
  def move(m: Movement): (Direction, Point) = {
    if (m.isRight) {
      return (new West, new Point(-m.distance, 0))
    }
    (new East, new Point(m.distance, 0))
  }
}
