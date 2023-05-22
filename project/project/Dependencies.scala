import sbt._
object Dependencies {

  object Versions {
    val munit = "0.7.29"
    val sbtDependencyUpdates = "1.2.7"
    val sbtHeader = "5.9.0"
    val circe = "0.14.5"
  }

  object Compile {
    val munit = "org.scalameta" %% "munit" % Versions.munit
    val circe = "io.circe" %% "circe-core" % Versions.circe
    val circeGeneric = "io.circe" %% "circe-generic" % Versions.circe
    val circeParser = "io.circe" %% "circe-parser" % Versions.circe
  }

  object SbtPlugins {
    val sbtDependencyUpdates =
      "org.jmotor.sbt" % "sbt-dependency-updates" % Versions.sbtDependencyUpdates
    val sbtHeader = "de.heikoseeberger" % "sbt-header" % Versions.sbtHeader
  }

  object Test {}

  lazy val dependencies =
    Seq(Compile.munit, SbtPlugins.sbtDependencyUpdates, SbtPlugins.sbtHeader)

}
