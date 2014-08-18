package models
import anorm._
import play.api.db.DB
import play.api.Play.current

trait Model {

  /*
   * returns model by id
   */
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

  /*
   * Insert a model into db and return an id value if it was successful
   * Needs to be implemented in every model
   */
  def insertIntoDB(model: Model)

  /*
   * Deletes object from db and returns amount of deleted lines
   */
  def deleteFromDB(id: Int, table: String) {
    DB.withConnection { implicit c =>
      val result: Int = SQL(f"delete from $table%s where id = $id%d").executeUpdate()
    }
  }
}