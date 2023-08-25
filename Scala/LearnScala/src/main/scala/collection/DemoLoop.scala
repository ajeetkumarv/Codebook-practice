package collection

object DemoLoop extends App {

  val vector = Vector()
  val something = for {
    n <- 1 to 5 if n %2 == 0
    m <- 1 to 5
  } yield (n * m)

  println(something)
}
