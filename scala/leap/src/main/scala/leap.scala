class Year(year: Int) {
  def isLeap(): Boolean =
    (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0)
}

object Year {
  def apply(year: Int) = new Year(year)
}
