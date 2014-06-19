class School {

  // XXX: mutable
  var db:Map[Int, Seq[String]] = Map()

  def add(student: String, grade: Int) = {
    db.get(grade) match {
      case Some(students) =>
        db = db + (grade -> (students :+ student))
      case _  =>
        db = db + (grade -> Seq(student))
    }
  }

  def grade(grade: Int) = {
    db.getOrElse(grade, Seq())
  }

  def sorted = {
    db.keys.toList.sorted.map(key => (key -> db(key).sorted)).toMap
  }
}
