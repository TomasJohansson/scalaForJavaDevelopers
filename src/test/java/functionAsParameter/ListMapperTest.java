package functionAsParameter;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

//  SBT-command: test-only functionAsParameter.ListMapperTest
public final class ListMapperTest {

    private static List<ListMapper> listMappers = new ArrayList<ListMapper>();
    
    @BeforeClass
    public static void beforeClass() {
        listMappers.add(new JavaListMapperWithDuplicatedIterationCode());
        listMappers.add(new JavaListMapperImplementationWithStrategies());
        listMappers.add(new ScalaListMapperSimilarToJavaImplementationWithStrategies());
        listMappers.add(new ScalaListMapper());
    }

    @Test
    public void executeAllTestsForAllImplementations() {
        for (ListMapper listMapper : listMappers) {
            verifyLowerCasing(listMapper);
            verifyUpperCasing(listMapper);
            verifyLengthOfStrings(listMapper);
            verifyMultiplications(listMapper);
        }
    }

    private void verifyLowerCasing(final ListMapper listMapper) {
        final List<String> lowerCasedNames = listMapper.getLowerCasedStrings(NAMES);
        assertEquals(NAMES.size(), lowerCasedNames.size());
        assertEquals(NAME_1_TOMAS.toLowerCase(), lowerCasedNames.get(0));
        assertEquals(NAME_2_BO.toLowerCase(), lowerCasedNames.get(1));
        assertEquals(NAME_3_PER.toLowerCase(), lowerCasedNames.get(2));
        assertEquals(NAME_4_KARL.toLowerCase(), lowerCasedNames.get(3));
    }

    private void verifyUpperCasing(final ListMapper listMapper) {
        final List<String> upperCasedNames = listMapper.getUpperCasedStrings(NAMES);
        final String errorMessage = getErrorMessage(listMapper);
        assertNotNull(errorMessage, upperCasedNames);
        assertEquals(errorMessage, NAMES.size(), upperCasedNames.size());
        assertEquals(NAME_1_TOMAS.toUpperCase(), upperCasedNames.get(0));
        assertEquals(NAME_2_BO.toUpperCase(), upperCasedNames.get(1));
        assertEquals(NAME_3_PER.toUpperCase(), upperCasedNames.get(2));
        assertEquals(NAME_4_KARL.toUpperCase(), upperCasedNames.get(3));
    }

    private void verifyLengthOfStrings(final ListMapper listMapper) {
        final List<Integer> lengthsOfStrings = listMapper.getLengthsOfStrings(NAMES);
        final String errorMessage = getErrorMessage(listMapper);
        assertNotNull(errorMessage, lengthsOfStrings);
        assertEquals(errorMessage, NAMES.size(), lengthsOfStrings.size());
        assertEquals(NAME_1_TOMAS.length(), lengthsOfStrings.get(0).intValue());
        assertEquals(NAME_2_BO.length(), lengthsOfStrings.get(1).intValue());
        assertEquals(NAME_3_PER.length(), lengthsOfStrings.get(2).intValue());
        assertEquals(NAME_4_KARL.length(), lengthsOfStrings.get(3).intValue());
    }

    private void verifyMultiplications(ListMapper listMapper) {
        final List<Integer> result = listMapper.getWithEachElementMultiplied(Arrays.asList(3, 5, 7), 3);
        final String errorMessage = getErrorMessage(listMapper);
        assertNotNull(errorMessage, result);
        assertEquals(errorMessage, 3, result.size());
        assertEquals(errorMessage, 9, result.get(0).intValue());
        assertEquals(errorMessage, 15, result.get(1).intValue());
        assertEquals(errorMessage, 21, result.get(2).intValue());
    }

    private String getErrorMessage(ListMapper listMapper) {
        return "The failing implementation class was: " + listMapper.getClass().getName();
    }

    private final static String NAME_1_TOMAS = "Tomas";
    private final static String NAME_2_BO = "Bo";
    private final static String NAME_3_PER = "Per";
    private final static String NAME_4_KARL = "Karl";

    private final static List<String> NAMES = Arrays.asList(
        NAME_1_TOMAS,
        NAME_2_BO,
        NAME_3_PER,
        NAME_4_KARL
    );

}
