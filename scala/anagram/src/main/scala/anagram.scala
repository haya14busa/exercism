class Anagram(word: String) {
  val length = word.length
  // val wordCount = new Phrase(word).wordCount
  val charCnt = new CharCount(word.toLowerCase).charCount.toList.sorted

  def matches(candidates: Seq[String]): Seq[String] =  {
    val uniqueCandidates = candidates.toSet.toList
    uniqueCandidates.toSet.toList.filter{
      (x: String) => (new CharCount(x.toLowerCase).charCount.toList.sorted == charCnt)
    }
  }
}

// Helper
class CharCount(word: String) {
  // val word = phrase.split("""\s|[:,.!&@$%^]""").filter(_ != "").map(_.toLowerCase)
  val chars   = word.toList
  val charSet = word.toSet
  val charCnt = for {
    char <- charSet.toSeq
  } yield chars.count(_ == char)

  val charCount = charSet.zip(charCnt).toMap

}

object Anagram {
  def main(args: Array[String]) {
    val detector = new Anagram("ant")
    val anagrams = detector.matches(Seq("tan", "stand", "at"))
    // println(anagrams)
    val a = new CharCount("ant").charCount.toList.sorted
    val b = new CharCount("tan").charCount.toList.sorted
    println(a == b)
    println("run")
  }
}
