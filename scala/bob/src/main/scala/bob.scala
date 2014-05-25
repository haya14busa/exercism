class Bob {
  private def hasLower(s: String): Boolean = s.exists(_.isLower)
  private def hasUpper(s: String): Boolean = s.exists(_.isUpper)

  def hey(message: String): String = {
    message match {
      // Do not have lowercase letters and contains uppercase chars at the same time
      case s if ! hasLower(s) && hasUpper(s) => "Woah, chill out!"
      case s if s.endsWith("?")              => "Sure."
      case s if s.forall(_.isWhitespace)     => "Fine. Be that way!"
      case _                                 => "Whatever."
    }
  }
}

