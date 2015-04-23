package module1

import java.sql.DriverManager
import scala.slick.driver.H2Driver.simple._
import scala.slick.jdbc.StaticQuery.interpolation
import xitrum.Action
import xitrum.annotation.GET
import java.sql.Connection
import scala.slick.jdbc.{ GetResult, StaticQuery => Q }
import Q._

@GET("dbc")
class dbc extends Action {
  def execute() {
    val db = Database.forURL("jdbc:postgresql://localhost:5432/test2",
      driver = "org.postgresql.Driver", user = "postgres", password = "1848")
    val testbd = db.withSession { implicit session =>
      val rows = sql"select id, version from test2".as[(Int, String)].list
      respondText(rows.mkString(" \n "))
    }
  }
}
