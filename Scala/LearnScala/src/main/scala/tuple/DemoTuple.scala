package tuple

object DemoTuple extends App {

  val a = Tuple3(1,2, 5)

  val b = (1, "One")

  println(b._2)

  val c = 1 -> "ONE"
  val d = 1 -> "one" -> "ONE"

  println(c)
  println(d)
  println(Map(1 -> "A"))
}
