name := "hello-docker"

version := "0.1"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http-experimental" % "2.4.3",
  "org.scalatest" %% "scalatest" % "3.0.0-M15" % "test"
)

