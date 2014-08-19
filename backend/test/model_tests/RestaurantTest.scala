package model_tests

import org.specs2.mutable._
import play.api.db.DB
import play.api.Play.current
import anorm._
import play.api.test._
import play.api.test.Helpers._
import models._

class RestaurantTest extends Specification {

  "save method for Restaurant" should {
    "be applied without errors" in {
      running(FakeApplication(additionalConfiguration = inMemoryDatabase())) {
        val restaurant = new Restaurant("rafla", "koirapolku 3", "helsinki", 40700, "08:00-:18:00")
        val id = restaurant.save()
        id should not be (null)
      }
    }
  }

  "getById method for Restaurant" should {
    "be applied without errors" in {
      running(FakeApplication(additionalConfiguration = inMemoryDatabase())) {
        val restaurant = new Restaurant("rafla", "koirapolku 3", "helsinki", 40700, "08:00-:18:00")
        val id = restaurant.save()
        restaurant.getById(id.get, "Restaurant") should not be (null)
      }
    }
  }

  "deleteFromDB method for Restaurant" should {
    "be applied without errors" in {
      running(FakeApplication(additionalConfiguration = inMemoryDatabase())) {
        val restaurant = new Restaurant("rafla", "koirapolku 3", "helsinki", 40700, "08:00-:18:00")
        val id = restaurant.save()
        restaurant.getById(id.get, "Restaurant") should not be (null)
        restaurant.deleteFromDB(id.get, "Restaurant") shouldEqual 1
      }
    }
  }

}