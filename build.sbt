organization := "com.futurechimps"

name := "SquerylTryout"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.9.2"


seq(webSettings :_*)

libraryDependencies ++= Seq(
  "org.scalatra" % "scalatra" % "2.2.0-SNAPSHOT",
  "org.scalatra" % "scalatra-scalate" % "2.2.0-SNAPSHOT",
  "org.scalatra" % "scalatra-specs2" % "2.2.0-SNAPSHOT" % "test",
  "ch.qos.logback" % "logback-classic" % "1.0.9" % "runtime",
  "org.eclipse.jetty" % "jetty-webapp" % "8.1.8.v20121106" % "container;provided;test",
  "org.eclipse.jetty.orbit"    % "javax.servlet" % "3.0.0.v201112011016" % "container;provided;test" artifacts (Artifact("javax.servlet", "jar", "jar")),
  "org.squeryl" %% "squeryl" % "0.9.5-6", 
  "mysql" % "mysql-connector-java" % "5.1.22",
  "c3p0" % "c3p0" % "0.9.1.2"
)

resolvers += "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"

