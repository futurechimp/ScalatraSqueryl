package com.futurechimps.squeryli.models

import org.squeryl.PrimitiveTypeMode._
import org.squeryl.Schema
import org.squeryl.annotations.Column
import org.squeryl.Query
import org.squeryl.KeyedEntity
import org.squeryl.PersistenceStatus


/**
 * An article in the blog.
 */
class Article(val id: Long, val title: String, val body: String) 
	extends KeyedEntity[Long] 
	with PersistenceStatus { 
  
  def this() = this(0, "default title", "default body")
}


/**
 * A user of the site.
 */
class User(val id: Long, val firstName: String, val lastName: String, val email: Option[String]) 
	extends KeyedEntity[Long] 
	with PersistenceStatus {

  def this() = this(0, "foo", "bar", Some("string"))
}



object BlogDb extends Schema {
  
  val articles = table[Article]("articles")
  val users = table[User]("users")

  on(articles)(a => declare(
    a.id is(autoIncremented)))
    
  on(users)(u => declare(
    u.id is(autoIncremented)))
  
}