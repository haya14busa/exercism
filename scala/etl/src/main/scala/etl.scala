object ETL {
  def transform(old: Map[Int,Seq[String]]): Map[String,Int] =
    old flatMap { case (key, values) => values map (_.toLowerCase -> key) }
  // def transform(old: Map[Int,Seq[String]]): Map[String,Int] = {
  //   // The argument types of an anonymous function must be fully known. (SLS 8.5)
  //   old.flatMap { case (key, values) =>
  //       values map (v => Map(v.toLowerCase -> key))
  //   }.foldLeft[Map[String,Int]](Map())((x,y) => x ++ y)
  // }
}
