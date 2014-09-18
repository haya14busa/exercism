import scala.annotation.tailrec

class Robot {
  private val usednames = scala.collection.mutable.ListBuffer.empty[String]

  def reset(): String = {
    this.name = generateName()
    this.name
  }
  var name = generateName()

  @tailrec
  private def generateName(): String = {
    val r = new scala.util.Random
    val prefix = r.shuffle(('A' to 'X').toList).take(2).mkString
    val digits = r.shuffle((0 to 9).toList).take(3).mkString
    val newName = prefix + digits
    if (this.usednames contains newName)
      this.generateName()
    else {
      this.usednames += newName
      newName
    }
  }
}
