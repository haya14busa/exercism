class PhoneNumber(phoneNumber: String) {

  private def toPhoneNumber(phoneNumber: String): String = {
    phoneNumber.filter(isNumber(_)) match {
      case x if x.length == 11 && x.startsWith("1") => x.drop(1)
      case x if x.length < 10 || 10 < x.length => "0000000000" // invalid
      case x => x
    }
  }

  val number    = toPhoneNumber(phoneNumber)
  val areaCode  = number.substring(0, 3)

  private val firstCode = number.substring(3, 6)
  private val lastCode  = number.substring(6, 10)
  override def toString = s"($areaCode) $firstCode-$lastCode"

  private def isNumber(char: Char) = {
    try {
      char.toString.toInt
      true
    } catch {
      case ex: NumberFormatException => false
    }
  }



}
