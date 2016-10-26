package com.redbadger.robots.model

import com.redbadger.robots.instructions.{MoveForward, TurnLeft, TurnRight}

case class Robot(initialPosition: RobotPosition, instructionString: String)(implicit world: World) {

  import Robot._
  require(instructionString.length > 0, NO_INSTRUCTIONS_MSG)
  require(instructionString.length < INSTRUCTION_STRING_MAX_SIZE, MAX_INSTRUCTION_SIZE_MSG)
  require(instructionString.matches("[LRF]+"), INVALID_INSTRUCTION_MSG)

  private var position = initialPosition
  def currentPosition = position

  def executeInstructions: RobotPosition = {
    for (char <- instructionString if !currentPosition.lost) char match {
      case 'L' => position = TurnLeft.execute(position)
      case 'R' => position = TurnRight.execute(position)
      case 'F' => position = MoveForward.execute(position)
    }
    currentPosition
  }
}

object Robot {
  val INSTRUCTION_STRING_MAX_SIZE = 100

  val NO_INSTRUCTIONS_MSG = "The robot was given no instructions"
  val MAX_INSTRUCTION_SIZE_MSG = "The robot cannot be given more than 100 instructions"
  val INVALID_INSTRUCTION_MSG = "The robot was given invalid instructions"
}