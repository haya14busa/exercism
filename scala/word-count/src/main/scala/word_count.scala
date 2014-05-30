class Phrase(phrase: String) {
  val words = phrase.split("""\s|[:,.!&@$%^]""").filter(_ != "").map(_.toLowerCase)
  val wordsSet = words.toSet
  val wordsCnt = for {
    word <- wordsSet.toSeq
  } yield words.count(_ == word)

  val wordCount = wordsSet.zip(wordsCnt).toMap

}

object WordCount {
  def main(args: Array[String]) {
    val p1 = new Phrase("one fish two fish red fish blue fish")
    println("words:    " + p1.words.mkString(", "))
    println("wordsSet: " + p1.wordsSet)
    println("wordsCnt: " + p1.wordsCnt)
  }
}
