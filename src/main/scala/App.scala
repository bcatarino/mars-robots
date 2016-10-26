package example

import com.redbadger.robots.io.FileParser

object App {
  def main(args: Array[String]) {

    // Accepts an external file name. Otherwise, uses the sample file
    val filename = if (args.length == 1) args(0) else "sample.txt"

    val (world, robots) = FileParser.parse(filename)

    println(world)
    println(robots)

    println("Final Output")
    world.executeRobots(robots).foreach(println)
  }
}
