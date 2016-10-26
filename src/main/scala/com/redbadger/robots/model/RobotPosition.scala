package com.redbadger.robots.model

import com.redbadger.robots.model.RobotPosition.Orientation

case class RobotPosition(x: Int, y: Int, orientation: Orientation, lost: Boolean) {
  override def toString = s"$x $y $orientation" + (if (lost) " LOST" else "")
}

object RobotPosition {
  sealed trait Orientation
  case object N extends Orientation
  case object S extends Orientation
  case object E extends Orientation
  case object W extends Orientation

  val INVALID_POSITION_MSG = "A valid robot position needs x, y and orientation"

  def apply(x: Int, y: Int, orientation: Orientation): RobotPosition = RobotPosition(x, y, orientation, false)

  def apply(str: String): RobotPosition = str.trim.split(" ").toList match {
    case List(x, y, orientationStr) => RobotPosition(x.toInt, y.toInt, orientation(orientationStr))
    case _ => throw new IllegalArgumentException(INVALID_POSITION_MSG)
  }

  private def orientation(orientationStr: String) = orientationStr match {
    case "N" => N
    case "S" => S
    case "E" => E
    case "W" => W
  }
}