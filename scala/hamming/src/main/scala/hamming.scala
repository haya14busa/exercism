object Hamming {
  def compute(str1: String, str2: String): Int = {
    (0 until Math.min(str1.length, str2.length)).foldLeft(0) { (distance, idx) =>
      if (str1(idx) != str2(idx)) 1 + distance else distance
    }
  }
}
