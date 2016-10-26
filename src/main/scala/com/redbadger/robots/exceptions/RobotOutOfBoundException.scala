package com.redbadger.robots.exceptions

import com.redbadger.robots.model.RobotPosition

case class RobotOutOfBoundException(lastPosition: RobotPosition)
  extends Exception(s"Robot is out of bounds. His last position is $lastPosition")
