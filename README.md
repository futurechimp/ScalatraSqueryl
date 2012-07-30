This is a quick demonstration of Squeryl integration with Scalatra. 

It doesn't do much in terms of functionality, but it can serve as an example of how to set up Scalatra with an object-relational mapper, integrate C3P0 connection pooling, and bootstrap the database connections into existence. 

It uses Scalatra 2.1's new LifeCycle object to kick off the database connection (see http://www.scalatra.org/2.1/book/#Organizing_your_application).

To try it out, `git clone` the code and:

1. Launch [SBT](http://code.google.com/p/simple-build-tool).

```
./sbt
```

2. Run Jetty

```
container:start
```

3. Go to http://localhost:8080/articles/create-db. This will create the database - you'll need a blank MySQL schema called "squeryl-tryout". You can change database creds in com.futurechimps.squeryli.init.DatabaseInit.

4. Learn more at http://www.scalatra.org/stable/book.

5. Happy hacking!
