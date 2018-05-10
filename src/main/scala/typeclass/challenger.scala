package typeclass

import typeclass.challenger.NumberLike

object challenger {

  import annotation.implicitNotFound

  @implicitNotFound("bleu")
  trait NumberLike[T] {
    def addition(a: T, b: T): T

    def soustraction(a: T, b: T): T

    def division(a: T, b: Int): T

    def multiplication(a: T, b: T): T

  }

}

object NumberLike {

  implicit object IntLike extends NumberLike[Int] {
    override def addition(a: Int, b: Int): Int = a + b

    override def division(a: Int, b: Int): Int = a / b

    override def multiplication(a: Int, b: Int): Int = a * b

    override def soustraction(a: Int, b: Int): Int = a - b

  }

  implicit object DoubleLike extends NumberLike[Double] {
    override def addition(a: Double, b: Double): Double = a + b

    override def division(a: Double, b: Int): Double = a / b

    override def multiplication(a: Double, b: Double): Double = a * b

    override def soustraction(a: Double, b: Double): Double = a - b
  }

}

object statistic {

  import typeclass.challenger.NumberLike
  def summe[T](xs: List[T])(implicit nl: NumberLike[T]): T = xs.foldLeft(xs.head)(nl.addition _)
  //def mean[T](xs: List[T]): T = implicitly[NumberLike[T]].division(xs.reduce(implicitly[NumberLike[T]].addition(_, _)), xs.size)

}

object main {

  def main(args: Array[String]): Unit = {
    println("hello")
    import typeclass.NumberLike._

    val list: List[Double] = List(0,1, 2, 3, 4, 5, 6, 7, 8)

    println(statistic.summe(list))

  }
}