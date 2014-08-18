package models
import anorm._
import play.api.db.DB
import play.api.Play.current

case class Restaurant(name: String, address: String, city: String,
  postalCode: Int, openingHours: String) extends Model {

  /*
   * Insert restaurant into database, returns id.
   */
  def insertIntoDB(restaurant: Restaurant) {
    DB.withConnection { implicit c =>
      val id: Option[Long] = SQL("insert into Restaurant(name, address, city, postalCode, openingHours) values ({name},{address},{city},{postalCode},{openingHours}")
        .on('name -> restaurant.name, 'address -> restaurant.address, 'city -> restaurant.city, 'postalCode -> restaurant.postalCode, 'openingHours -> restaurant.openingHours).executeInsert()
    }
  }

}