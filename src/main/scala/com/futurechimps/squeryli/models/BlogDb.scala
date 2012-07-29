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
class Article(val id: Long, val title: String, val body: String) extends ScalatraRecord { 
  
  def this() = this(0, "default title", "default body")
  
  // What I'd really like here for validations would be something like:
  // def validates {
  //   presenceOf("title")
  //   presenceOf("body")
  //   minimumLengthOf("body", 300) 
  // }
  
  
  def isValid = {
    if(this.title != "default title" && this.title != "" && this.title != null &&
       this.body != "default body" && this.body != "" && this.body != null) {
      true 
    } else {
      false
    }
  }
}


/**
 * A user of the site.
 */
class User(val id: Long, val firstName: String, val lastName: String, val email: Option[String]) 
	extends ScalatraRecord {

  def this() = this(0, "foo", "bar", Some("string"))
}


/**
 * The BlogDb object acts as a cross between a Dao and a Schema definition file.
 */
object BlogDb extends Schema {
  
  val articles = table[Article]("articles")
  val users = table[User]("users")

  on(articles)(a => declare(
    a.id is(autoIncremented)))
    
  on(users)(u => declare(
    u.id is(autoIncremented)))
  
}

trait ScalatraRecord extends KeyedEntity[Long] with PersistenceStatus {
  // and later, validation, probably...
}