package com.redbadger.robots.model

import org.scalatest.{FlatSpec, Matchers}

class RobotSpec extends FlatSpec with Matchers {

  implicit val world = World("4 4")

  it should "throw IllegalArgumentException for empty instruction string" in {
    val exception = intercept [IllegalArgumentException] {
      Robot(RobotPosition("1 2 E"), "")
    }
    assert(exception.getMessage === "requirement failed: " + Robot.NO_INSTRUCTIONS_MSG)
  }

  it should "throw IllegalArgumentException for instruction string too long" in {
    val exception = intercept [IllegalArgumentException] {
      Robot(RobotPosition("1 2 E"), "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL")
    }
    assert(exception.getMessage === "requirement failed: " + Robot.MAX_INSTRUCTION_SIZE_MSG)
  }

  it should "throw IllegalArgumentException for illegal characters in instruction" in {
    val exception = intercept [IllegalArgumentException] {
      Robot(RobotPosition("1 2 E"), "ALR")
    }
    assert(exception.getMessage === "requirement failed: " + Robot.INVALID_INSTRUCTION_MSG)
  }

  it should "return final position after executing all movements in string" in {
    val finalPosition = Robot(RobotPosition("1 2 E"), "RLRLRLFF").executeInstructions
    finalPosition.orientation should equal(RobotPosition.E)
    finalPosition.x should equal(3)
    finalPosition.y should equal(2)
    finalPosition.lost should equal(false)
  }

  it should "stop execution if error occurs" in {
    val finalPosition = Robot(RobotPosition("1 2 E"), "FFFFFFFF").executeInstructions
    finalPosition.orientation should equal(RobotPosition.E)
    finalPosition.x should equal(4)
    finalPosition.y should equal(2)
    finalPosition.lost should equal(true)
  }
}
