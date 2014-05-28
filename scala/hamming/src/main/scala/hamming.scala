object Hamming {
  def compute(str1: String, str2: String): Int = {
    val minLength = Math.min(str1.length, str2.length)
    var hammingDistance = 0
    for(i <- 0 to minLength - 1) {
      if (str1(i) != str2(i)) hammingDistance += 1
    }
    return hammingDistance
  }
}
