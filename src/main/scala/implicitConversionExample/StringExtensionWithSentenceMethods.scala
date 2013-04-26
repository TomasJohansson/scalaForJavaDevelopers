package implicitConversionExample


object StringExtensionWithSentenceMethods {
  implicit def stringToStringExtensionWithSentenceMethods(string: String) = {
    new StringExtensionWithSentenceMethods(string)
  }
}

class StringExtensionWithSentenceMethods(private val sentenceWithWords: String) 
{
  def getFirstWordsIncludingIntermediateCharacters(numberOfWords: Int): String = {
    SentenceUtility.getFirstWordsIncludingIntermediateCharacters(sentenceWithWords, numberOfWords)
  }
  def getWithFirstLetterInEachWordUppercasedAndTheRestLowercased(): String = {
    SentenceUtility.getWithFirstLetterInEachWordUppercasedAndTheRestLowercased(sentenceWithWords)
  }
}
