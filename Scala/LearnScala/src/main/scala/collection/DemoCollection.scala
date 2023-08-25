package collection

object DemoCollection extends App {

  val v = Vector(1,2,3,4,5,6,7,8,9,10)
  val s = Set(1,2,3)

  val v0 = 0 +: v

  println(v)
  println(s)

  val value: Map[Boolean, Vector[Int]] = v.groupBy(i => i % 2 == 0)

  println(value)
}
