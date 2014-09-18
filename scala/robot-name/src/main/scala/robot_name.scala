class Robot {
  private val oldNames = scala.collection.mutable.ListBuffer.empty[String]

  def reset(): String = {
    this.name = generateName()
    this.name
  }
  var name = generateName()

  private def generateName(): String = {
    val r = new scala.util.Random
    val prefix = r.shuffle(('A' to 'X').toList).take(2).mkString
    val digits = r.shuffle((0 to 9).toList).take(3).mkString
    val newName = prefix + digits
    if (this.oldNames contains newName)
      this.generateName()
    else {
      oldNames += newName
      newName
    }
  }
}
