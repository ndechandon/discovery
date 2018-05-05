package repositories

import scala.util.{Success, Try}

trait Repository[T, ID] {

  def load(id: ID): Try[T]

  def store(e: T): Try[ID]


}