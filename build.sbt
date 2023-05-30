/*
 * Copyright 2023 Xebia Functional
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import Dependencies.Compile._

import java.net.URL
ThisBuild / publish / skip := true
ThisBuild / scalaVersion := "3.2.2"
ThisBuild / organization := "com.xebia"
ThisBuild / versionScheme := Some("early-semver")

lazy val commonSettings = Seq(
  organizationName := "Xebia Functional",
  startYear := Some(2023),
  organizationHomepage := Some(new URL("https://www.47deg.com/"))
)
ThisBuild / version := "0.1.5-SNAPSHOT"

lazy val root = project
  .in(file("."))
  .settings(commonSettings)
  .settings(
    name := "munit-snap-root",
    publish / skip := true
  )
  .aggregate(`munit-snap`)

lazy val `munit-snap` = project
  .in(file("./munit-snap"))
  .settings(commonSettings)
  .settings(
    name := "munit-snap",
    autoAPIMappings := true,
    publish / skip := false,
    libraryDependencies += munit,
    libraryDependencies += circe,
    libraryDependencies += circeGeneric,
    libraryDependencies += circeParser
  )

ThisBuild / organization := "com.xebia"
ThisBuild / homepage := Some(
  url("https://github.com/xebia-functional/munit-snap")
)
ThisBuild / developers := List(
  Developer(
    "xebia-functional",
    "Xebia Functional",
    "functional-ops@xebia.com",
    url("https://www.47deg.com/")
  )
)
ThisBuild / licenses := List(
  "Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")
)
ThisBuild / githubWorkflowTargetTags ++= Seq("v*")
ThisBuild / githubWorkflowPublishTargetBranches :=
  Seq(RefPredicate.StartsWith(Ref.Tag("v")))
ThisBuild / githubWorkflowPublish := Seq(
  WorkflowStep.Sbt(
    List("ci-release"),
    env = Map(
      "PGP_PASSPHRASE" -> "${{ secrets.PGP_PASSPHRASE }}",
      "PGP_SECRET" -> "${{ secrets.PGP_SECRET }}",
      "SONATYPE_PASSWORD" -> "${{ secrets.XEB_SONATYPE_PASSWORD }}",
      "SONATYPE_USERNAME" -> "${{ secrets.XEB_SONATYPE_USERNAME }}"
    )
  )
)
