import java.util.{Calendar, GregorianCalendar}
import scala.annotation.tailrec

class Meetup(month: Int, year: Int) {
  private def firstday(DAY_OF_WEEK: Int): Int = {
    @tailrec
    def loop(day: Int): Int = {
      val d = new GregorianCalendar(year, month-1, day)
      if (d.get(Calendar.DAY_OF_WEEK) == DAY_OF_WEEK) day
      else loop(day + 1)
    }
    loop(1)
  }

  private def lastday(DAY_OF_WEEK: Int): Int = {
    @tailrec
    def loop(day: Int): Int = {
      val d = new GregorianCalendar(year, month-1, day)
      if (d.get(Calendar.DAY_OF_WEEK) == DAY_OF_WEEK &&
          d.get(Calendar.DAY_OF_MONTH) == day) // make sure it's correct
        day
      else loop(day - 1)
    }
    loop(31)
  }

  def teenth(DAY_OF_WEEK: Int) = {
    @tailrec
    def loop(day: Int): Int = {
      if (day < 13) loop(day + 7)
      else day
    }
    new GregorianCalendar(year, month-1, loop(firstday(DAY_OF_WEEK)))
  }

  def first(DAY_OF_WEEK: Int)  = new GregorianCalendar(year, month-1, firstday(DAY_OF_WEEK))
  def second(DAY_OF_WEEK: Int) = new GregorianCalendar(year, month-1, firstday(DAY_OF_WEEK) + 7)
  def third(DAY_OF_WEEK: Int)  = new GregorianCalendar(year, month-1, firstday(DAY_OF_WEEK) + 7 * 2)
  def fourth(DAY_OF_WEEK: Int) = new GregorianCalendar(year, month-1, firstday(DAY_OF_WEEK) + 7 * 3)
  def last(DAY_OF_WEEK: Int)   = new GregorianCalendar(year, month-1, lastday(DAY_OF_WEEK))

}

object Meetup {
  def apply(month: Int, year: Int) = new Meetup(month, year)

  val Sun = Calendar.SUNDAY
  val Mon = Calendar.MONDAY
  val Tue = Calendar.TUESDAY
  val Wed = Calendar.WEDNESDAY
  val Thu = Calendar.THURSDAY
  val Fri = Calendar.FRIDAY
  val Sat = Calendar.SATURDAY
}
