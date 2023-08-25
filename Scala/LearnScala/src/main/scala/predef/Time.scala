package predef

class Time(val hour: Int, val min: Int) {

  require(0 <= hour && hour < 24, "Hour shoud be between 0 and 23")
  require(0 <= min && min < 60, "Min should be between 0 and 59")

  override def toString = s"Time(hour=$hour, min=$min)"
}

object RunTime extends App {
  val t1 = new Time(20,2)
  val t2 = new Time(1, -1)
}