ScalatraSqueryl
===============

This is a quick demonstration of [Squeryl](http://squeryl.org) integration with [Scalatra](http://scalatra.org). 

It doesn't do much in terms of functionality, but it can serve as an example of how to set up Scalatra with an object-relational mapper, integrate C3P0 connection pooling, and bootstrap the database connections into existence. 

It uses Scalatra 2.2's [ScalatraBootstrap](http://scalatra.org/2.2/guides/deployment/configuration.html) class to kick off the database connection.

To try it out, `git clone` the code and:

1. Launch [SBT](http://www.scala-sbt.org/).

```
./sbt
```

2. Run Jetty

```
container:start
```

3. Go to [http://localhost:8080/articles/create-db](http://localhost:8080/articles/create-db). This will create the database - you'll need a blank MySQL schema called "squeryltryout". You can change database creds in com.futurechimps.squeryli.init.DatabaseInit.

4. Learn more at http://www.scalatra.org/

5. Happy hacking!
