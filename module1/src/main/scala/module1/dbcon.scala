package ru.fgeo.ppam

import java.sql.DriverManager
import scala.slick.driver.H2Driver.simple._
import scala.slick.jdbc.StaticQuery.interpolation
import xitrum.Action
import xitrum.annotation.GET
import java.sql.Connection
import scala.slick.jdbc.{ GetResult, StaticQuery => Q }
import Q._
import scala.tools.cmd.Opt.Implicit

@GET("Data")
class DataConnect extends Action {

  def execute() {
    object connect { implicit class DataConnect
    val connect = Database.forURL("jdbc:postgresql://localhost:5432/test2",
      driver = "org.postgresql.Driver", user = "postgres", password = "1848")
    val testbd = connect.withSession { implicit session =>
      val rows = sql"select id, version from test2".as[(Int, String)].list
      respondText(rows.mkString(" \n "))
       }
   respondText(" 123 ") }
  }
}
