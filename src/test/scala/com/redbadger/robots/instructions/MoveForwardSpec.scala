package com.redbadger.robots.instructions

import com.redbadger.robots.model.{RobotPosition, World}
import org.scalatest.{FlatSpec, Matchers}

class MoveForwardSpec extends FlatSpec with Matchers {

  it should "move North when far from edge" in {
    implicit val world = World("3 3")
    val start = RobotPosition("1 1 N")
    val end = MoveForward.execute(start)
    end.x should equal(start.x)
    end.y should equal(start.y + 1)
    end.orientation should equal(start.orientation)
    end.lost should equal(false)
    world.hasScent(end) should equal(false)
  }

  it should "move South when far from edge" in {
    implicit val world = World("3 3")
    val start = RobotPosition("1 1 S")
    val end = MoveForward.execute(start)
    end.x should equal(start.x)
    end.y should equal(start.y - 1)
    end.orientation should equal(start.orientation)
    end.lost should equal(false)
    world.hasScent(end) should equal(false)
  }

  it should "move East when far from edge" in {
    implicit val world = World("3 3")
    val start = RobotPosition("1 1 E")
    val end = MoveForward.execute(start)
    end.x should equal(start.x + 1)
    end.y should equal(start.y)
    end.orientation should equal(start.orientation)
    end.lost should equal(false)
    world.hasScent(end) should equal(false)
  }

  it should "move West when far from edge" in {
    implicit val world = World("3 3")
    val start = RobotPosition("1 1 W")
    val end = MoveForward.execute(start)
    end.x should equal(start.x - 1)
    end.y should equal(start.y)
    end.orientation should equal(start.orientation)
    end.lost should equal(false)
    world.hasScent(end) should equal(false)
  }

  it should "fall off world if it moves beyond North edge" in {
    implicit val world = World("3 3")
    val start = RobotPosition("2 3 N")
    val end = MoveForward.execute(start)
    end.x should equal(start.x)
    end.y should equal(start.y)
    end.orientation should equal(start.orientation)
    end.lost should equal(true)
    world.hasScent(end) should equal(true)
  }

  it should "fall off world if it moves beyond South edge" in {
    implicit val world = World("3 3")
    val start = RobotPosition("2 0 S")
    val end = MoveForward.execute(start)
    end.x should equal(start.x)
    end.y should equal(start.y)
    end.orientation should equal(start.orientation)
    end.lost should equal(true)
    world.hasScent(end) should equal(true)
  }

  it should "fall off world if it moves beyond East edge" in {
    implicit val world = World("3 3")
    val start = RobotPosition("3 2 E")
    val end = MoveForward.execute(start)
    end.x should equal(start.x)
    end.y should equal(start.y)
    end.orientation should equal(start.orientation)
    end.lost should equal(true)
    world.hasScent(end) should equal(true)
  }

  it should "fall off world if it moves beyond West edge" in {
    implicit val world = World("3 3")
    val start = RobotPosition("0 2 W")
    val end = MoveForward.execute(start)
    end.x should equal(start.x)
    end.y should equal(start.y)
    end.orientation should equal(start.orientation)
    end.lost should equal(true)
    world.hasScent(end) should equal(true)
  }

  it should "not fall off world if it moves beyond North edge with scent" in {
    implicit val world = World("3 3")
    val start = RobotPosition("2 3 N")
    val endA = MoveForward.execute(start)
    world.hasScent(endA) should equal(true)

    val endB = MoveForward.execute(start)

    endB.x should equal(start.x)
    endB.y should equal(start.y)
    endB.orientation should equal(start.orientation)
    endB.lost should equal(false)
  }

  it should "fall off world if it moves beyond North edge with scent in different location" in {
    implicit val world = World("3 3")
    val startA = RobotPosition("2 3 N")
    val endA = MoveForward.execute(startA)
    world.hasScent(endA) should equal(true)

    val startB = RobotPosition("1 3 N")
    val endB = MoveForward.execute(startB)

    endB.x should equal(startB.x)
    endB.y should equal(startB.y)
    endB.orientation should equal(startB.orientation)
    endB.lost should equal(true)
    world.hasScent(endA) should equal(true)
    world.hasScent(endB) should equal(true)
  }

  it should "not fall off world if it moves beyond South edge with scent" in {
    implicit val world = World("3 3")
    val start = RobotPosition("2 0 S")
    val endA = MoveForward.execute(start)
    world.hasScent(endA) should equal(true)

    val endB = MoveForward.execute(start)

    endB.x should equal(start.x)
    endB.y should equal(start.y)
    endB.orientation should equal(start.orientation)
    endB.lost should equal(false)
  }

  it should "fall off world if it moves beyond South edge with scent in different location" in {
    implicit val world = World("3 3")
    val startA = RobotPosition("2 0 S")
    val endA = MoveForward.execute(startA)
    world.hasScent(endA) should equal(true)

    val startB = RobotPosition("1 0 S")
    val endB = MoveForward.execute(startB)

    endB.x should equal(startB.x)
    endB.y should equal(startB.y)
    endB.orientation should equal(startB.orientation)
    endB.lost should equal(true)
    world.hasScent(endA) should equal(true)
    world.hasScent(endB) should equal(true)
  }

  it should "not fall off world if it moves beyond East edge with scent" in {
    implicit val world = World("3 3")
    val start = RobotPosition("3 2 E")
    val endA = MoveForward.execute(start)
    world.hasScent(endA) should equal(true)

    val endB = MoveForward.execute(start)

    endB.x should equal(start.x)
    endB.y should equal(start.y)
    endB.orientation should equal(start.orientation)
    endB.lost should equal(false)
  }

  it should "fall off world if it moves beyond East edge with scent in different location" in {
    implicit val world = World("3 3")
    val startA = RobotPosition("3 2 E")
    val endA = MoveForward.execute(startA)
    world.hasScent(endA) should equal(true)

    val startB = RobotPosition("3 1 E")
    val endB = MoveForward.execute(startB)

    endB.x should equal(startB.x)
    endB.y should equal(startB.y)
    endB.orientation should equal(startB.orientation)
    endB.lost should equal(true)
    world.hasScent(endA) should equal(true)
    world.hasScent(endB) should equal(true)
  }

  it should "not fall off world if it moves beyond West edge with scent" in {
    implicit val world = World("3 3")
    val start = RobotPosition("0 2 W")
    val endA = MoveForward.execute(start)
    world.hasScent(endA) should equal(true)

    val endB = MoveForward.execute(start)

    endB.x should equal(start.x)
    endB.y should equal(start.y)
    endB.orientation should equal(start.orientation)
    endB.lost should equal(false)
  }

  it should "fall off world if it moves beyond West edge with scent in different location" in {
    implicit val world = World("3 3")
    val startA = RobotPosition("0 2 W")
    val endA = MoveForward.execute(startA)
    world.hasScent(endA) should equal(true)

    val startB = RobotPosition("0 1 W")
    val endB = MoveForward.execute(startB)

    endB.x should equal(startB.x)
    endB.y should equal(startB.y)
    endB.orientation should equal(startB.orientation)
    endB.lost should equal(true)
    world.hasScent(endA) should equal(true)
    world.hasScent(endB) should equal(true)
  }

  it should "throw NullPointer if no position is provided" in {
    implicit val world = World("3 3")
    intercept [NullPointerException] {
      MoveForward.execute(null)
    }
  }

  it should "throw MatchError if non-existent orientation is provided" in {
    implicit val world = World("3 3")
    intercept [MatchError] {
      MoveForward.execute(RobotPosition("1 1 A"))
    }
  }
}
