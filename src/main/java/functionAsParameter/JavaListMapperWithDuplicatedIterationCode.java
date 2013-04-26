package functionAsParameter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class JavaListMapperWithDuplicatedIterationCode implements ListMapper {

    public List<String> getUpperCasedStrings(final List<String> stringsToBeReturnedUpperCased) {
        final List<String> upperCasedStrings = new ArrayList<String>();
        for (String string : stringsToBeReturnedUpperCased) {
            upperCasedStrings.add(string.toUpperCase());
        }
        return Collections.unmodifiableList(upperCasedStrings);
    }

    public List<String> getLowerCasedStrings(final List<String> stringsToBeReturnedLowerCased) {
        final List<String> lowerCasedStrings = new ArrayList<String>();
        for (String string : stringsToBeReturnedLowerCased) {
            lowerCasedStrings.add(string.toLowerCase());
        }
        return Collections.unmodifiableList(lowerCasedStrings);
    }

    public List<Integer> getLengthsOfStrings(final List<String> stringsWithLengthsToBeReturned) {
        final List<Integer> lengthsOfStrings = new ArrayList<Integer>();
        for (String string : stringsWithLengthsToBeReturned) {
            lengthsOfStrings.add(string.length());
        }
        return Collections.unmodifiableList(lengthsOfStrings);
    }

    public List<Integer> getWithEachElementMultiplied(
        final List<Integer> integersToBeMultiplied, 
        final int factorToMultiplyEachElementWith
    ) {
        final List<Integer> products = new ArrayList<Integer>();//product=factor*factor
        for (Integer factor : integersToBeMultiplied) {
            products.add(factor * factorToMultiplyEachElementWith);
        }
        return Collections.unmodifiableList(products);
    }
}