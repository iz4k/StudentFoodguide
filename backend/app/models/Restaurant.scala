package models
import anorm._
import play.api.db.DB
import play.api.Play.current

case class Restaurant(name: String, address: String, city: String, postalCode: Int,
  openingHours: String) extends Model {

  /*
   * Insert restaurant into database, returns id.
   */
  def save(): Option[Long] = {
    DB.withConnection { implicit connection =>
      val id: Option[Long] = SQL("insert into Restaurant(name, address, city, postal_code, opening_hours) values ({name},{address},{city},{postalCode},{openingHours})")
        .on('name -> this.name, 'address -> this.address, 'city -> this.city, 'postalCode -> this.postalCode, 'openingHours -> this.openingHours).executeInsert()
      return id

    }
  }

}