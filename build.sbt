import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.1",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Hello",
    libraryDependencies += scalaTest % Test
  ).enablePlugins(JavaAppPackaging)

// add your sbt-docker settings here
packageName in Docker := "docker-minimal-seed"
dockerExposedPorts := Seq(5000)

