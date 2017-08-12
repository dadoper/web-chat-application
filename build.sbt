name := """WebChatApplication"""

version := "2.6.x"

scalaVersion := "2.12.2"

lazy val root = (project in file("."))
  .enablePlugins(PlayJava)
  .disablePlugins(PlayFilters)

libraryDependencies += "org.webjars" % "flot" % "0.8.3"
libraryDependencies += "org.webjars" % "bootstrap" % "3.3.6"

libraryDependencies += guice
libraryDependencies += ws

libraryDependencies += "org.assertj" % "assertj-core" % "3.6.2" % Test
libraryDependencies += "org.awaitility" % "awaitility" % "2.0.0" % Test

// Needed to make JUnit report the tests being run
testOptions in Test := Seq(Tests.Argument(TestFrameworks.JUnit, "-a", "-v"))
