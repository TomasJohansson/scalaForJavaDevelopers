package implicitConversionExample

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.scalatest.junit.AssertionsForJUnit

import implicitConversionExample.StringExtensionWithSentenceMethods.stringToStringExtensionWithSentenceMethods

//  SBT-command: test-only implicitConversionExample.StringExtensionTest
class StringExtensionTest extends AssertionsForJUnit {

  private val sentenceWithWords = "My name is Tomas. What is your name?"

  @Before
  def before() {
    assertEquals(classOf[java.lang.String], sentenceWithWords.getClass())
  }

  @Test 
  def getFirstWordsIncludingIntermediateCharacters() {
    val firstThreeWords = sentenceWithWords.getFirstWordsIncludingIntermediateCharacters(3)

    assertEquals("My name is", firstThreeWords)
  }


  @Test
  def getWithFirstLetterInEachWordUppercasedAndTheRaestLowercased() {
    val firstLetterInEachWordUppercasedAndTheRestLowercased = sentenceWithWords.getWithFirstLetterInEachWordUppercasedAndTheRestLowercased()

    assertEquals("My Name Is Tomas. What Is Your Name?", firstLetterInEachWordUppercasedAndTheRestLowercased)
  }

  @Test
  def exampleCombiningBothUtilityMethods() {
    val firstTwoWordsWithUppercasedFirstLetter =
    		sentenceWithWords.getFirstWordsIncludingIntermediateCharacters(2).getWithFirstLetterInEachWordUppercasedAndTheRestLowercased()
    		
    assertEquals("My Name", firstTwoWordsWithUppercasedFirstLetter)
  }
}