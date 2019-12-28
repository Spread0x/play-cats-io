name := """play-scala-io"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.1"

libraryDependencies ++= Seq(
  "org.typelevel"            %% "cats-core"           % "2.1.0",
  "org.typelevel"            %% "cats-free"           % "2.0.0",
  "org.typelevel"            %% "cats-effect-laws"    % "2.0.0" % "test",
  "org.typelevel"            %% "cats-effect"         % "2.0.0",
  "org.typelevel"            %% "cats-tagless-macros" % "0.10",
  "com.softwaremill.macwire" %% "macros"              % "2.3.3" % Provided
)

scalacOptions ++= Seq(
  "-deprecation", // Emit warning and location for usages of deprecated APIs.
  "-encoding",
  "utf-8", //ok  Specify character encoding used by source files.
  "-explaintypes", // Explain type errors in more detail.
  "-feature", // Emit warning and location for usages of features that should be imported explicitly.
  "-language:existentials", // Existential types (besides wildcard types) can be written and inferred
  "-language:experimental.macros", // Allow macro definition (besides implementation and application)
  "-language:higherKinds", // Allow higher-kinded types
  "-language:implicitConversions", // Allow definition of implicit functions called views
  "-unchecked" // Enable additional warnings where generated code depends on assumptions.
)
addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.10.3")

scalacOptions in (Compile, console) ~= (_.filterNot(
  Set(
    "-Ywarn-unused:imports"
  )
))

scalacOptions in (Test, compile) ~= (_.filterNot(
  Set(
    "-Ywarn-unused:imports"
  )
))

//wartremoverErrors in (Compile, compile) ++= Warts.unsafe
//wartremoverExcluded ++= routes.in(Compile).value

scalafmtOnCompile := true

resolvers += Resolver.sonatypeRepo("releases")
