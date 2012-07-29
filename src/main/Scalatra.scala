class Scalatra extends LifeCycle {

  implicit var system: ActorSystem = null
  override def init(context: ServletContext) {

    system = context.getOrElseUpdate(ActorSystemContextKey, ActorSystem(ActorSystemName)).asInstanceOf[ActorSystem]
    OAuth2Extension(system)

    context mount (new Articles, "/articles")
    context mount (new Users, "/users")
  }

  override def destroy(context: ServletContext) {
    system.synchronized {
      if (system != null && !system.isTerminated) {
        system.shutdown()
        system.awaitTermination(30 seconds)
      }
    }
  }
}