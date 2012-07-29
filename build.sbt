organization := "com.futurechimps"

name := "SquerylTryout"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.9.1"

seq(webSettings :_*)

libraryDependencies ++= Seq(
  "org.scalatra" % "scalatra" % "2.1.0-RC1",
  "org.scalatra" % "scalatra-scalate" % "2.1.0-RC1",
  "org.scalatra" % "scalatra-specs2" % "2.1.0-RC1" % "test",
  "ch.qos.logback" % "logback-classic" % "1.0.0" % "runtime",
  "org.eclipse.jetty" % "jetty-webapp" % "8.1.3.v20120416" % "container",
  "javax.servlet" % "javax.servlet-api" % "3.0.1" % "container;provided",
  "org.squeryl" %% "squeryl" % "0.9.5-2", 
  "mysql" % "mysql-connector-java" % "5.1.10",
  "c3p0" % "c3p0" % "0.9.1.2"
)

resolvers += "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"

ivyXML := <dependencies>
      <exclude org="org.eclipse.jetty.orbit" />
    </dependencies>