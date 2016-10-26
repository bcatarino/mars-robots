# Mars Robots by Bruno Catarino

Since a specific language was not a requirement, I decided to do it in Scala, to take advantage of some of its features.

## Required Software

If running in the console, sbt is needed: http://www.scala-sbt.org/0.13/docs/Setup.html

If running from an IDE, the Scala JDK needs to be available to the IDE (Intellij or Eclipse).

In any case, jre 8 is required.

## Running application

### IDE

Simply open the project on the IDE and run as you would run a java application.

### Console

> sbt run

uses the sample.txt file by default

> sbt "run [path_to_filename]"
Eg: sbt "run sample2.txt"

in case you want to run the application using an external file.

## Run Tests

> sbt test

## What I could have done with more time

Didn't really use a proper TDD approach and ended up not doing a proper test coverage, so that's something that could be improved: write more tests.