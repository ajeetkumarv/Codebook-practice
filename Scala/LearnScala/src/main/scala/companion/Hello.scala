package companion

object Hello {
  private val defaultMsg = "Hello!"
}

/**
 * if a singletonobject and a class or trait share the same name,
 * package and file, they are called companions
 * Companions can access their private members
 * @param message
 */
class Hello(message: String = Hello.defaultMsg) {
  println(message)
}

//won't compile
//class NotCompanion(message: String = Hello.defaultMsg)
