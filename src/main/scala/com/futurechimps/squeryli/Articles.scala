package com.futurechimps.squeryli

import org.scalatra._
import scalate.ScalateSupport
import com.futurechimps.squeryli.data.DatabaseInit
import com.futurechimps.squeryli.data.DatabaseSessionSupport
import com.futurechimps.squeryli.models.Article
import com.futurechimps.squeryli.models.User
import com.futurechimps.squeryli.models.BlogDb
import org.squeryl.PrimitiveTypeMode._
import java.util.Random
import java.util.Collections

class Articles extends ScalatraServlet 
	with DatabaseSessionSupport 
	with ScalateSupport 
	with MethodOverride
	with FlashMapSupport {

  get("/") {
    contentType = "text/html"
      
    val articles = from(BlogDb.articles)(select(_))
    ssp("articles/index", "articles" -> articles)
  }
  
  get("/new") { 
    contentType = "text/html"
      
    val article = new Article()
    ssp("/articles/new", "article" -> article)
  }
  
  post("/") {
    contentType = "text/html"
    
    val article = new Article(0, params("title"), params("body"))

    if(Article.create(article)) {
      flash("notice") = "Article successfully created"
      redirect("/articles")
    } else {
      flash("error") = "There were problems creating your article"
      ssp("articles/new", "article" -> article)
    }
  }

  get("/create-db") {
    contentType = "text/html"

    BlogDb.create
    redirect("/articles/new")
  }

  notFound {
	// Try to render a ScalateTemplate if no route matched
	findTemplate(requestPath) map { path =>
	  contentType = "text/html"
	  layoutTemplate(path)
	} orElse serveStaticResource() getOrElse resourceNotFound()
  }
  
}
