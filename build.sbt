import Dependencies.Compile._

import java.net.URL

ThisBuild / scalaVersion := "3.2.2"

lazy val commonSettings = Seq(
  organizationName := "Xebia Functional",
  startYear := Some(2023),
  licenses += ("Apache-2.0", new URL(
    "https://www.apache.org/licenses/LICENSE-2.0.txt"
  )),
  crossScalaVersions := Seq(
    "3.2.2",
    "3.2.1",
    "3.2.0",
    "3.1.3",
    "3.1.2",
    "3.1.1",
    "3.1.0",
    "3.0.2",
    "3.0.1",
    "3.0.0"
  ),
  organization := organizationName.value,
  organizationHomepage := Some(new URL("https://www.47deg.com/"))
)


lazy val root = project
  .in(file("."))
  .settings(commonSettings)
  .settings(
    name := "munit-snap-root",
    version := "0.1.0-SNAPSHOT",
    publish / skip := true
  ).aggregate(`munit-snap`)


lazy val `munit-snap` = project.in(file("./munit-snap")).settings(commonSettings).settings(
  name := "munit-snap",
  version := "0.1.0-SNAPSHOT",
  exportJars := true,
  autoAPIMappings := true,
  libraryDependencies += munit,
  libraryDependencies += circe,
  libraryDependencies += circeGeneric,
  libraryDependencies += circeParser
)
