class Anagram(anagram: String) {
  val charCnt = new CharCount(anagram.toLowerCase).charCount.toList.sorted

  def matches(candidates: Seq[String]): Seq[String] =  {
    val uniqueCandidates = candidates.toSet.toList
    uniqueCandidates.toSet.toList.filter{
      (x: String) => (new CharCount(x.toLowerCase).charCount.toList.sorted == charCnt)
    }.filter {
      // Filter identcal words with triating case insensitive
      word => word.toLowerCase != anagram.toLowerCase
    }

  }
}

// Helper
class CharCount(word: String) {
  val chars   = word.toList
  val charSet = word.toSet
  val charCnt = for {
    char <- charSet.toSeq
  } yield chars.count(_ == char)

  val charCount = charSet.zip(charCnt).toMap
}
