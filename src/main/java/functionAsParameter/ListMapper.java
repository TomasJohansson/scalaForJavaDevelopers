package functionAsParameter;

import java.util.List;

public interface ListMapper {

    List<String> getUpperCasedStrings(List<String> stringsToBeReturnedUpperCased);

    List<String> getLowerCasedStrings(List<String> stringsToBeReturnedLowerCased);

    List<Integer> getLengthsOfStrings(List<String> stringsWithLengthsToBeReturned);

    List<Integer> getWithEachElementMultiplied(List<Integer> integersToBeMultiplied, int factorToMultiplyEachElementWith);
}
