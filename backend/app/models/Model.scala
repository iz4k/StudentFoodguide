package models
import anorm._
import play.api.db.DB
import play.api.Play.current

abstract class Model {

  def getById(id: Int, table: String) {
    
    val sqlQuery = SQL(
    f"""
    select name from $table%s t 
    where t.id = $id%d;
    """)
    
    DB.withConnection {
      implicit c =>
        val result: Boolean = sqlQuery.execute()
    }
  }

  def insertIntoDB(model: Model)

  def deleteFromDB(id: Int, table: String) {
    DB.withConnection { implicit c =>
      val result: Int = SQL(f"delete from $table%s where id = $id%d").executeUpdate()
    }
  }
}