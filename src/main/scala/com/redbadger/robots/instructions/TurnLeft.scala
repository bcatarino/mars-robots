package com.redbadger.robots.instructions

import com.redbadger.robots.model.RobotPosition._
import com.redbadger.robots.model.{RobotPosition, World}

object TurnLeft extends Instruction {
  override def execute(position: RobotPosition)(implicit world: World): RobotPosition = position.orientation match {
    case N => position.copy(orientation = W)
    case W => position.copy(orientation = S)
    case S => position.copy(orientation = E)
    case E => position.copy(orientation = N)
  }
}