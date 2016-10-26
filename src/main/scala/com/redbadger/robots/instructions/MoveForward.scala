package com.redbadger.robots.instructions

import com.redbadger.robots.model.RobotPosition._
import com.redbadger.robots.model.{RobotPosition, World}

object MoveForward extends Instruction {
  override def execute(position: RobotPosition)(implicit world: World): RobotPosition = position.orientation match {
    case N => move(position, _.y < world.maxY, _.copy(y = position.y + 1))
    case W => move(position, _.x > 0, _.copy(x = position.x - 1))
    case S => move(position, _.y > 0, _.copy(y = position.y - 1))
    case E => move(position, _.x < world.maxX, _.copy(x = position.x + 1))
  }

  private def move(position: RobotPosition, inBounds: RobotPosition => Boolean,
                   moveAction: RobotPosition => RobotPosition)(implicit world: World) = {
    if (inBounds(position)) {
      moveAction(position)
    } else if (world.hasScent(position)) {
      position
    } else {
      world.addScent(position)
      position.copy(lost = true)
    }
  }
}
