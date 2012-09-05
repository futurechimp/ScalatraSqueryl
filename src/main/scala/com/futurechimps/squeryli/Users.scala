package com.futurechimps.squeryli

import org.scalatra._
import scalate.ScalateSupport
import com.futurechimps.squeryli.data.DatabaseInit
import com.futurechimps.squeryli.data.DatabaseSessionSupport
import com.futurechimps.squeryli.models.Article
import com.futurechimps.squeryli.models.User
import com.futurechimps.squeryli.models.BlogDb
import org.squeryl.PrimitiveTypeMode._

class Users  extends ScalatraServlet 
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