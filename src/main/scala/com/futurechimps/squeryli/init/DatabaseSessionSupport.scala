package com.futurechimps.squeryli.init

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.scalatra.Handler
import org.squeryl.Session
import org.squeryl.SessionFactory
import scala.util.DynamicVariable

trait DatabaseSessionSupport extends Handler {
  val dbSession = new DynamicVariable[Session](null)
  abstract override def handle(req: HttpServletRequest, res: HttpServletResponse) {
    dbSession.withValue(SessionFactory.newSession) {
      dbSession.value.bindToCurrentThread
      try {
        super.handle(req, res)
      } finally {
        dbSession.value.close
        dbSession.value.unbindFromCurrentThread
      }
    }
  }
}