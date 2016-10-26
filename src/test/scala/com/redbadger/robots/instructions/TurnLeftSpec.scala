package com.redbadger.robots.instructions

import com.redbadger.robots.model.{Robot, RobotPosition, World}
import org.scalatest.{FlatSpec, Matchers}

class TurnLeftSpec extends FlatSpec with Matchers {

  implicit val world = World("5 5")

  it should "turn West when facing North and remain in same place" in {
    val start = RobotPosition("1 1 N")
    val end = TurnLeft.execute(start)
    end.x should equal(start.x)
    end.y should equal(start.y)
    end.orientation should equal(RobotPosition.W)
  }

  it should "turn South when facing West and remain in same place" in {
    val start = RobotPosition("1 1 W")
    val end = TurnLeft.execute(start)
    end.x should equal(start.x)
    end.y should equal(start.y)
    end.orientation should equal(RobotPosition.S)
  }

  it should "turn East when facing South and remain in same place" in {
    val start = RobotPosition("1 1 S")
    val end = TurnLeft.execute(start)
    end.x should equal(start.x)
    end.y should equal(start.y)
    end.orientation should equal(RobotPosition.E)
  }

  it should "turn North when facing East and remain in same place" in {
    val start = RobotPosition("1 1 E")
    val end = TurnLeft.execute(start)
    end.x should equal(start.x)
    end.y should equal(start.y)
    end.orientation should equal(RobotPosition.N)
  }

  it should "throw NullPointer if no position is provided" in {
    intercept [NullPointerException] {
      TurnLeft.execute(null)
    }
  }

  it should "throw MatchError if non-existent orientation is provided" in {
    intercept [MatchError] {
      TurnLeft.execute(RobotPosition("1 1 A"))
    }
  }
}
