package access

/**
 * Qualified Access Modifiers
 */
class Hello {
  // available only in package access
  private[access] val msg = "Hey"

  //availabe for this instance only
  //error: value sam in class Hello cannot be accessed as a member of Hello from class
  private[this] val msg2 = "Hi"

  //error: value sam is not a member of Hello
  private val msg3 = "Hello"

  lazy val lazyData = {
    println("I will not be initialized until first used")
    7
  }
}

object CallHello extends App {
  val h = new Hello

  println(h.msg)

  def sample = "Sample"

}