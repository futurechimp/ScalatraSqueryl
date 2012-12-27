organization := "com.futurechimps"

name := "scalatra-squeryl"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.9.2"

classpathTypes ~= (_ + "orbit")

seq(webSettings :_*)

libraryDependencies ++= Seq(
  "org.scalatra" % "scalatra" % "2.2.0-RC2",
  "org.scalatra" % "scalatra-scalate" % "2.2.0-RC2",
  "org.scalatra" % "scalatra-specs2" % "2.2.0-RC2" % "test",
  "ch.qos.logback" % "logback-classic" % "1.0.6" % "runtime",
  "org.eclipse.jetty" % "jetty-webapp" % "8.1.7.v20120910" % "container",
  "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" % "container;provided;test" artifacts (Artifact("javax.servlet", "jar", "jar")),
  "org.squeryl" %% "squeryl" % "0.9.5-2", 
  "mysql" % "mysql-connector-java" % "5.1.10",
  "c3p0" % "c3p0" % "0.9.1.2"
)

resolvers += "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"

