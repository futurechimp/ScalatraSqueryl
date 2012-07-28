package com.futurechimps.squeryli.init

import com.mchange.v2.c3p0.ComboPooledDataSource
import org.scalatra.Initializable
import org.squeryl.adapters.MySQLAdapter
import org.squeryl.Session
import org.squeryl.SessionFactory
import org.squeryl.Schema

trait DatabaseInit extends Initializable {
  val databaseUsername = "root"
  val databasePassword = ""
  val databaseConnection = "jdbc:mysql://localhost:3306/squeryl-tryout"

  var cpds = new ComboPooledDataSource
  abstract override def initialize(config: Config) {
    cpds.setDriverClass("com.mysql.jdbc.Driver")
    cpds.setJdbcUrl(databaseConnection)
    cpds.setUser(databaseUsername)
    cpds.setPassword(databasePassword)

    cpds.setMinPoolSize(1)
    cpds.setAcquireIncrement(1)
    cpds.setMaxPoolSize(50)

    SessionFactory.concreteFactory = Some(() => connection)
    
    def connection = {
      Session.create(cpds.getConnection, new MySQLAdapter)
    }
  }
}



