package functionAsParameter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class JavaListMapperImplementationWithStrategies implements ListMapper {

    private interface ElementMappingStrategy<T, U> {
        U getMappedValue(T value);
    }

    private <T, U> List<U> getMappedList(
        final List<T> elementsToBeMapped,
        final ElementMappingStrategy<T, U> elementMappingStrategy
    ) {
        final List<U> returnedElements = new ArrayList<U>();
        final Iterator<T> iterator = elementsToBeMapped.iterator();
        while(iterator.hasNext()) {
            returnedElements.add(elementMappingStrategy.getMappedValue(iterator.next()));
        }
        return Collections.unmodifiableList(returnedElements);
    }

    public List<String> getUpperCasedStrings(final List<String> stringsToBeReturnedUpperCased) {
        return getMappedList(
            stringsToBeReturnedUpperCased,
            new ElementMappingStrategy<String,String>() {
                public String getMappedValue(final String value) {
                    return value.toUpperCase();
                }
            }
        );
    }

    public List<String> getLowerCasedStrings(final List<String> stringsToBeReturnedLowerCased) {
        return getMappedList(
            stringsToBeReturnedLowerCased,
            new ElementMappingStrategy<String,String>() {
                public String getMappedValue(final String value) {
                    return value.toLowerCase();
                }
            }
        );
    }

    public List<Integer> getLengthsOfStrings(List<String> stringsWithLengthsToBeReturned) {
        return getMappedList(
            stringsWithLengthsToBeReturned,
            new ElementMappingStrategy<String, Integer>() {
                public Integer getMappedValue(final String value) {
                    return value.length();
                }
            }
        );
    }

    public List<Integer> getWithEachElementMultiplied(
        final List<Integer> integersToBeMultiplied,
        final int factorToMultiplyEachElementWith
    ) {
        return getMappedList(
            integersToBeMultiplied,
            new ElementMappingStrategy<Integer, Integer>() {
                public Integer getMappedValue(final Integer value) {
                    return factorToMultiplyEachElementWith * value;
                }
            }
        );
    }

}