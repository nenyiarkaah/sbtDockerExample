/**
  * Created by Nenyi on 18/03/2017.
  */
object main extends App {
  val list = List("This", "is", "a","test")
  list.foreach(a => {
    for (i <- 0 to 10) {println(a + " " + i)}
  })
}
