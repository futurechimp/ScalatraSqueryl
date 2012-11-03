package com.futurechimps.squeryli.data

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.squeryl.Session
import org.squeryl.SessionFactory
import scala.util.DynamicVariable
import org.scalatra._

object DatabaseSessionSupport {
  val key = {
    val n = getClass.getName
    if (n.endsWith("$")) n.dropRight(1) else n
  }
}

trait DatabaseSessionSupport { this: ScalatraBase =>
  import DatabaseSessionSupport._

  def dbSession = request.get(key).orNull.asInstanceOf[Session]
  
  before() { 
    request(key) = SessionFactory.newSession 
    dbSession.bindToCurrentThread 
  }

  after() {
    dbSession.close
    dbSession.unbindFromCurrentThread
  }

}