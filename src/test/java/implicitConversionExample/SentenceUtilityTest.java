package implicitConversionExample;

import static implicitConversionExample.SentenceUtility.getFirstWordsIncludingIntermediateCharacters;
import static implicitConversionExample.SentenceUtility.getWithFirstLetterInEachWordUppercasedAndTheRestLowercased;
import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

//  SBT-command: test-only implicitConversionExample.SentenceUtilityTest
public class SentenceUtilityTest {

	private static final String sentenceWithWords = "My name is Tomas. What is your name?";

	@Test
	public void verify_getFirstWordsIncludingIntermediateCharacters() {
		final String firstThreeWords = SentenceUtility.getFirstWordsIncludingIntermediateCharacters(sentenceWithWords, 3);
		
		assertEquals(firstThreeWords, "My name is");
	}

	@Test
	public void verify_getWithFirstLetterInEachWordUppercasedAndTheRestLowercased() {
		final String firstLetterInEachWordUppercasedAndTheRestLowercased = 
				SentenceUtility.getWithFirstLetterInEachWordUppercasedAndTheRestLowercased(sentenceWithWords);
		
		assertEquals("My Name Is Tomas. What Is Your Name?", firstLetterInEachWordUppercasedAndTheRestLowercased);
	}

	@Test
	public void exampleCombiningBothUtilityMethods() {
		assertEquals(
			"My Name", 
			getWithFirstLetterInEachWordUppercasedAndTheRestLowercased(
				getFirstWordsIncludingIntermediateCharacters(sentenceWithWords, 2)
			)
		);
	}
}