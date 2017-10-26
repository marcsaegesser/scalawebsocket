name := "scalawebsocket"

homepage := Some(url("https://github.com/marcsaegesser/scalawebsocket"))

licenses := Seq("Apache License 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0"))

organization := "org.saegesser"

version := "0.2.0-SNAPSHOT"

scalaVersion := "2.11.11"

crossScalaVersions := List("2.11.11", "2.12.4")

fork in Test := true

libraryDependencies ++= Seq(
  // "com.ning"      %  "async-http-client" % "1.9.40",
  "org.asynchttpclient" % "async-http-client" % "2.0.37",
  "org.scala-stm" %% "scala-stm"         % "0.8",

  //logging
  "com.typesafe.scala-logging" %% "scala-logging"   % "3.7.2",
  "ch.qos.logback"             %  "logback-classic" % "1.2.3",

  //jetty is used to setup test server
  "org.eclipse.jetty" % "jetty-server"    % "8.1.7.v20120910" % "test",
  "org.eclipse.jetty" % "jetty-websocket" % "8.1.7.v20120910" % "test",
  "org.eclipse.jetty" % "jetty-servlet"   % "8.1.7.v20120910" % "test",
  "org.eclipse.jetty" % "jetty-servlets"  % "8.1.7.v20120910" % "test",

  "org.scalatest" %% "scalatest" % "3.0.4" % "test"
)

publishMavenStyle := true

publishTo <<= version {
  (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

pomIncludeRepository := {
  _ => false
}

pomExtra := (
  <scm>
    <url>git@github.com:marcsaegesser/scalawebsocket.git</url>
    <connection>scm:git:git@github.com:marcsaegesser/scalawebsocket.git</connection>
  </scm>
  <developers>
    <developer>
      <id>marcsaegesser</id>
      <name>Marc Saegesser</name>
      <url>https://github.com/marcsaegesser</url>
    </developer>
    <developer>
      <id>pbuda</id>
      <name>Piotr Buda</name>
      <url>http://www.piotrbuda.eu</url>
    </developer>
  </developers>
)
