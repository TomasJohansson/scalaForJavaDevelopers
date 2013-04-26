package implicitConversionExample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceUtility {

    private final static String WORD_REG_EXP = "(\\w+)";
    private final static String NON_WORD_REG_EXP = "(\\W+)";
    private final static Pattern REGULAR_EXPRESSION_SEPARATING_WORDS_AND_NON_WORDS = Pattern.compile(WORD_REG_EXP + NON_WORD_REG_EXP);

    /**
     * Reused method, with an algorithm that initially was duplicated into the two other methods in this class,
     * but then was refactored into this common code.
     */
    private static String getSentenceWithFilteredOrTransformedWords(
        final String sentenceWithWords,
        final SentenceWordsFilterOrTransformer sentenceWordsFilterOrTransformer
    ) {
        final StringBuilder wordsIncludingIntermediateNonWordCharacters = new StringBuilder();
        final Matcher matcherForWordsAndNonWords = REGULAR_EXPRESSION_SEPARATING_WORDS_AND_NON_WORDS.matcher(sentenceWithWords + " ");
        while(matcherForWordsAndNonWords.find()) {
            final String word = matcherForWordsAndNonWords.group(1);
            final String nonWord = matcherForWordsAndNonWords.group(2);
            sentenceWordsFilterOrTransformer.populateStringBuilderWithPotentiallyTransformedWordsUnlessShouldBeIgnored(
                wordsIncludingIntermediateNonWordCharacters, word, nonWord
            );
        }
        return wordsIncludingIntermediateNonWordCharacters.toString().trim();
    }

    interface SentenceWordsFilterOrTransformer {
        void populateStringBuilderWithPotentiallyTransformedWordsUnlessShouldBeIgnored(
            StringBuilder stringBuilder,
            String word,
            String nonWord
        );
    }
    
    public static String getFirstWordsIncludingIntermediateCharacters(
        final String sentenceWithWords,
        final int numberOfWordsToReturn
    ) {
        return getSentenceWithFilteredOrTransformedWords(
            sentenceWithWords,
            new SentenceWordsFilterOrTransformer() {
                int numberOfWordsIncludedSoFar = 0;
                public void populateStringBuilderWithPotentiallyTransformedWordsUnlessShouldBeIgnored(
                    final StringBuilder wordsIncludingIntermediateCharacters,
                    final String word,
                    final String nonWord
                ) {
                    if(numberOfWordsIncludedSoFar >= numberOfWordsToReturn) {
                        // ignore the rest of the words, i.e. this filtering is the purpose of this implementation
                        return;
                    }
                    wordsIncludingIntermediateCharacters.append(word);
                    wordsIncludingIntermediateCharacters.append(nonWord);
                    numberOfWordsIncludedSoFar++;
                }
            }
        );
    }


    public static String getWithFirstLetterInEachWordUppercasedAndTheRestLowercased(final String sentenceWithWords) {
        return getSentenceWithFilteredOrTransformedWords(
            sentenceWithWords,
            new SentenceWordsFilterOrTransformer() {
                public void populateStringBuilderWithPotentiallyTransformedWordsUnlessShouldBeIgnored(
                    final StringBuilder wordsIncludingIntermediateCharacters,
                    final String word,
                    final String nonWord
                ) {
                    // this implementation of the interface will transform each word by making the first letter
                    // uppercased and the rest of the letters lowercased
                    wordsIncludingIntermediateCharacters.append(word.substring(0, 1).toUpperCase());
                    wordsIncludingIntermediateCharacters.append(word.substring(1).toLowerCase());
                    wordsIncludingIntermediateCharacters.append(nonWord);
                }
            }
        );

    }
}