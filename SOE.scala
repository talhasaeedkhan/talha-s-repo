
object SOE {
  def main(args: Array[String]): Unit = {
    print("Enter Number");

    var x=scala.io.StdIn.readInt()
    val prime = List.range(2, x+1)
    println("All prime numbers less than "+x+  " are:")
    println(SOE(prime))

  }


  def SOE(list1: List[Int])={
    def remove(list2:List[Int]): List[Int] =
      if (list2.isEmpty) list2
      else list2.head :: remove(list2.tail filter(_% list2.head !=0))
    remove(list1)

  }
}
