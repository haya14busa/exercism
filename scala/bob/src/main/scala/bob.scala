class Bob {
  private def hasLower(s: String): Boolean = s.exists(_.isLower)
  private def hasUpper(s: String): Boolean = s.exists(_.isUpper)

  // Do not have lowercase letters and contains uppercase chars at the same time
  private def isShouting(str: String) = ! hasLower(str) && hasUpper(str)
  private def isQuestion(str: String) = str.endsWith("?")
  private def isSilent(str: String)   = str.forall(_.isWhitespace)

  def hey(message: String): String = {
    message match {
      case s if isShouting(s) => "Woah, chill out!"
      case s if isQuestion(s) => "Sure."
      case s if isSilent(s)   => "Fine. Be that way!"
      case _                  => "Whatever."
    }
  }
}

