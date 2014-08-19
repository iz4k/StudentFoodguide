package models
import anorm._
import play.api.db.DB
import play.api.Play.current

trait Model {

  /*
   * returns model by id
   */
  def getById(id: Long, table: String) = {
    
    val sqlQuery = SQL(
    f"""
    select name from $table%s t 
    where t.id = $id%d;
    """)
    
    DB.withConnection {
      implicit c =>
        val restaurant = sqlQuery().map(row =>  row[String]("code") -> row[String]("name")).toList
    }
  }

  /*
   * Insert a model into db and return an id value if it was successful
   * Needs to be implemented in every model
   */
  def save():Option[Long]

  /*
   * Deletes object from db and returns amount of deleted lines
   */
  def deleteFromDB(id: Long, table: String):Int = {
    DB.withConnection { implicit c =>
      val result: Int = SQL(f"delete from $table%s where id = $id%d").executeUpdate()
      return result
    }
  }
}