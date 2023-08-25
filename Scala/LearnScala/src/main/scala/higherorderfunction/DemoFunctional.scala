package higherorderfunction

object DemoFunctional extends App {

  def f(n: Int): Int = {
    n + 1
  }

  val s = List(1,21,13,40,5)

  var s1 = s.map((n: Int) => n + 1)
  s1 = s.map(n => n + 1)
  s1 = s.map(_ + 1)

  println(s1)

  // like val name: String = "Apple, so this is how we tell it's a function
  val funVal: Int => Int = number => number + 1
  println(s.map(funVal).map(f))

}

