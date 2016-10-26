package com.redbadger.robots.model

import scala.collection.mutable

case class World(maxX: Int, maxY: Int) {

  import World._
  require(maxX > 0 && maxY > 0, MAX_WORLD_SIZE_MSG)
  require(maxX < WORLD_MAX_SIZE && maxY < WORLD_MAX_SIZE, MAX_WORLD_SIZE_MSG)

  // The "scent" of robots that fell off the world.
  private val scentedPositions: mutable.Set[(Int, Int)] = mutable.Set()

  def hasScent(position: RobotPosition) = scentedPositions contains (position.x, position.y)

  def addScent(position: RobotPosition) = scentedPositions add (position.x, position.y)

  def executeRobots(robots: List[Robot]) = robots.map(_.executeInstructions)
}

object World {

  def apply(sizeString: String): World = sizeString.trim.split(" ").toList match {
    case List(x, y) => World(x.toInt, y.toInt)
    case _ => throw new IllegalArgumentException(INVALID_WORLD_MSG)
  }

  val WORLD_MAX_SIZE = 50

  val MIN_WORLD_SIZE_MSG = "The world size needs to be at least 1 on each axis"
  val MAX_WORLD_SIZE_MSG = "The world cannot be more than 50 in each axis"
  val INVALID_WORLD_MSG = "A valid world needs a max x and y"
}