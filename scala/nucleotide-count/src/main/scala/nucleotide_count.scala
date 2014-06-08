class DNA(dna: String) {
  validateString(dna)

  private def validate(char: Char, isRNA: Boolean = false) = {
    char match {
      case 'A' | 'C' | 'G' | 'T'       if !isRNA =>
      case 'A' | 'C' | 'G' | 'T' | 'U' if  isRNA =>
      case _ => throw new IllegalArgumentException
    }
  }

  private def validateString(str: String, isRNA: Boolean = false) = {
    str.foreach(char => validate(char, isRNA))
  }

  def count(nucreotid: Char) = {
    validate(nucreotid, isRNA = true)
    dna.count(char => char == nucreotid)
  }

  val nucleotideCounts = {
    Map(
        'A' -> dna.count(_ == 'A')
      , 'C' -> dna.count(_ == 'C')
      , 'G' -> dna.count(_ == 'G')
      , 'T' -> dna.count(_ == 'T')
    )
  }
}
