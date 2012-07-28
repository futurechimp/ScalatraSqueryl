package com.futurechimps.squeryli

import org.scalatra._
import scalate.ScalateSupport
import com.futurechimps.squeryli.init.DatabaseInit
import com.futurechimps.squeryli.init.DatabaseSessionSupport
import com.futurechimps.squeryli.models.Article
import com.futurechimps.squeryli.models.User
import com.futurechimps.squeryli.models.BlogDb
import org.squeryl.PrimitiveTypeMode._
import java.util.Random
import java.util.Collections

class Articles extends ScalatraServlet 
	with DatabaseInit 
	with DatabaseSessionSupport 
	with ScalateSupport 
	with MethodOverride {

  get("/") {
    contentType = "text/html"
    val articles = from(BlogDb.articles)(select(_))
    ssp("/index", "articles" -> articles)
  }
  
  get("/create-db") {
    BlogDb.create
  }
  
  get("/add-a-user") {
    contentType = "text/html"
    val firstNames = List("Ivan", "Dave", "Mikko", "Ross", "Jared", "Stefan", "Stefan")
    val lastNames = List("Porto Carrero", "Hrycyszyn", "Nylen", "Baker", "Armstrong", "De Boey", "Ollinger")
    val emails = List("ivan@ivan.org", "dave@dave.org", "miko2@mikko.org", "foo@blah.org", "super@super.org", "flap@flap.org", "fupser@fupser.org")
    val user = BlogDb.users.insert(new User(0, rand(firstNames), rand(lastNames), Some(rand(emails))))
    
  }
  
  get("/add-article") {
    val article = BlogDb.articles.insert(new Article(0, "Foo", "Bar body"))
  }

  notFound {
	// Try to render a ScalateTemplate if no route matched
	findTemplate(requestPath) map { path =>
	  contentType = "text/html"
	  layoutTemplate(path)
	} orElse serveStaticResource() getOrElse resourceNotFound()

	}
  
  def rand(list:List[String]):String = {
    Collections.shuffle(java.util.Arrays.asList(list:_*))
    list.head
  }
}
