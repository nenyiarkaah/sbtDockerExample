Packaging an Application using SBT and Docker: Simple Example

This is a very simple example on how to package your application 
into Docker container.   

Prerequisites: Docker and SBT

Docker Installation Instructions for all supported Platforms
https://docs.docker.com/engine/installation/

SBT Download instructions
http://www.scala-sbt.org/download.html

Steps

Add 
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.1.1")
to plugins.sbt

In build.sbt change lazy val root = (project in file(".")) to
lazy val root = (project in file(".")).enablePlugins(JavaAppPackaging)

Then add 

// add your sbt-docker settings here

packageName in Docker := "docker-minimal-seed"
dockerExposedPorts := Seq(5000)

Packaging and Running the Project

To package the app, you need to run a single command:

sbt docker:publishLocal

This will package your app into a Docker container and make it available for running with Docker.

After generating the container (step above), run the container:

docker run -dit -p 5000:5000 --name minimal-seed docker-minimal-seed:0.1.0-SNAPSHOT

You will get a response like this:

$ docker run -dit -p 5000:5000 --name minimal-seed docker-minimal-seed:0.1.0-SNAPSHOT
d75931eeebb2a97533dea0c706cc2b45d7c10e1723f5ef7908b5f3e514758526

This will run in the background (because of the -d switch) so you won't see

You should now see the app running on Kitematic(Beta)

Stop the container

To stop the container, run:

$ docker stop minimal-seed

If you prefer to remove the container rather than just stop it, 
just run docker rm instead of docker stop.
