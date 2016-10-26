package com.redbadger.robots.io

import com.redbadger.robots.model.{Robot, RobotPosition, World}

import scala.annotation.tailrec
import scala.io.Source

object FileParser {

  def parse(filename: String) = {

    val inputSource = Source.fromFile(filename)
    val lines = inputSource.getLines.filter(_.trim.length > 0).toList

    val worldStr :: operations = lines

    implicit val world = World(worldStr)
    val robots = generateRobots(operations, List.empty[Robot], world).reverse

    (world, robots)
  }

  @tailrec
  def generateRobots(operations: List[String], robots: List[Robot], world: World): List[Robot] = operations match {
    case Nil => robots
    case positionLine :: instructionsLine :: tail => generateRobots(tail, Robot(RobotPosition(positionLine), instructionsLine)(world) :: robots, world)
  }
}
