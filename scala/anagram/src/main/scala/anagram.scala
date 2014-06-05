class Anagram(anagram: String) {
  def matches(candidates: Seq[String]): Seq[String] =  {
    candidates.filter( word => isAnagram(word) && ! isIdentical(word) )
  }

  private def isAnagram(word: String) = {
    word.toLowerCase.sorted == anagram.toLowerCase.sorted
  }

  private def isIdentical(word: String) = {
    word.toLowerCase == anagram.toLowerCase
  }
}
