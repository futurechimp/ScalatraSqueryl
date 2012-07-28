package com.futurechimps.squeryli

import org.scalatra._
import scalate.ScalateSupport
import com.futurechimps.squeryli.init.DatabaseInit
import com.futurechimps.squeryli.init.DatabaseSessionSupport
import com.futurechimps.squeryli.models.Article
import com.futurechimps.squeryli.models.User
import com.futurechimps.squeryli.models.BlogDb
import org.squeryl.PrimitiveTypeMode._

class Users  extends ScalatraServlet 
	with DatabaseInit 
	with DatabaseSessionSupport 
	with ScalateSupport 
	with MethodOverride  {
  
  get("/") {
    contentType = "text/html"
    "users list here"
  }
  
  post("/"){
    contentType = "text/html"
    
  }
  
  get("/:id") {
    contentType = "text/html"
    
  }
  
  put("/:id") {
    contentType = "text/html"
    
  }
  
  delete("/:id") {
    contentType = "text/html"
    
  } 

}