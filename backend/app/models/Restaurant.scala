package models

case class Restaurant(name: String, address: String, city: String, 
    postalCode: Int, openingHours: String) extends Model {}
