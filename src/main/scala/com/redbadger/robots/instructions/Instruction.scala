package com.redbadger.robots.instructions

import com.redbadger.robots.model.{RobotPosition, World}

// New instructions may be added by implementing the trait
trait Instruction {
  def execute(position: RobotPosition)(implicit world: World): RobotPosition
}
