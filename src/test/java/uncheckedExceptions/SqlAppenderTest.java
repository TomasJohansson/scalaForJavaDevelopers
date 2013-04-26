package uncheckedExceptions;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.fail;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

//  SBT-command: test-only uncheckedExceptions.SqlAppenderTest
public class SqlAppenderTest {

    @Test
    public void testSqlAppenders() {
        testAppender(new SqlAppenderImplementedWithJava());
        testAppender(new SqlAppenderImplementedWithScala());
    }

    private void testAppender(final SqlAppender sqlAppender) {
        testSqlAppenderWithStringBuffer_WithOUT_DeclaredException(sqlAppender);
        testSqlAppenderWithStringBuffer_WITH_DeclaredException(sqlAppender);

        testSqlAppenderWithStringBuilder_WithOUT_DeclaredException(sqlAppender);
        testSqlAppenderWithStringBuilder_WITH_DeclaredException(sqlAppender);

        testSqlAppenderWithFileWriter_WithOUT_DeclaredException(sqlAppender);
        testSqlAppenderWithFileWriter_WITH_DeclaredException(sqlAppender);        
    }

    private void testSqlAppenderWithStringBuffer_WithOUT_DeclaredException(final SqlAppender sqlAppender) {
        final StringBuffer stringBuffer = new StringBuffer();
        sqlAppender.addSqlWhereClausePartWith_IN_Statement_withOUT_DeclaredCheckedException(stringBuffer, COUNTRY, LIST_OF_COUNTRY_VALUES);
        assertWithExpectedSqlPart(stringBuffer.toString());
    }

    private void testSqlAppenderWithStringBuilder_WithOUT_DeclaredException(final SqlAppender sqlAppender) {
        final StringBuilder stringBuilder = new StringBuilder();
        sqlAppender.addSqlWhereClausePartWith_IN_Statement_withOUT_DeclaredCheckedException(stringBuilder, COUNTRY, LIST_OF_COUNTRY_VALUES);
        assertWithExpectedSqlPart(stringBuilder.toString());
    }    

    private void testSqlAppenderWithStringBuilder_WITH_DeclaredException(final SqlAppender sqlAppender) {
        final StringBuilder stringBuilder = new StringBuilder();
        try {
            sqlAppender.addSqlWhereClausePartWith_IN_Statement_WITH_DeclaredCheckedException(stringBuilder, COUNTRY, LIST_OF_COUNTRY_VALUES);
            assertWithExpectedSqlPart(stringBuilder.toString());

        } catch (IOException e) {
            fail("When StringBuilder was used, an IOException should not have been thrown");
        }
    }

    private void testSqlAppenderWithStringBuffer_WITH_DeclaredException(final SqlAppender sqlAppender) {
        final StringBuffer stringBuffer = new StringBuffer();
        try {
            sqlAppender.addSqlWhereClausePartWith_IN_Statement_WITH_DeclaredCheckedException(stringBuffer, COUNTRY, LIST_OF_COUNTRY_VALUES);
            assertWithExpectedSqlPart(stringBuffer.toString());

        } catch (IOException e) {
            fail("When StringBuffer was used, an IOException should not have been thrown");
        }
    }    

    private void testSqlAppenderWithFileWriter_WithOUT_DeclaredException(final SqlAppender sqlAppender) {
        final File tempFile = createTempFile();
        try {
            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter(tempFile);
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            assertNotNull(fileWriter);

            try {
                sqlAppender.addSqlWhereClausePartWith_IN_Statement_withOUT_DeclaredCheckedException(fileWriter, COUNTRY, LIST_OF_COUNTRY_VALUES);
                fail("We should have got some exception since the file was closed");
            } catch (RuntimeException e) {  
                System.out.println("WithOUT DeclaredException , FileWriter Exception with implementing class: " + sqlAppender.getClass().getSimpleName() +  " , Exception class:" + e.getClass().getName());
            } catch (Exception e) {
                System.out.println("WithOUT DeclaredException , FileWriter Exception with implementing class: " + sqlAppender.getClass().getSimpleName() +  " , Exception class:" + e.getClass().getName());
            }
        } finally {
            tempFile.delete();
        }
    }

    private void testSqlAppenderWithFileWriter_WITH_DeclaredException(final SqlAppender sqlAppender) {
        final File tempFile = createTempFile();
        try {
            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter(tempFile);
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            assertNotNull(fileWriter);

            try {
                sqlAppender.addSqlWhereClausePartWith_IN_Statement_WITH_DeclaredCheckedException(fileWriter, COUNTRY, LIST_OF_COUNTRY_VALUES);
                fail("We should have got some exception since the file was closed");
            } catch (IOException e) {
                System.out.println("WITH    DeclaredException , FileWriter Exception with implementing class: " + sqlAppender.getClass().getSimpleName() +  " , Exception class:" + e.getClass().getName());
            }
        } finally {
            tempFile.delete();
        }
    }

    private File createTempFile() {
        try {
            File tempFile = File.createTempFile("testing", "testing");
            return tempFile;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static final String COUNTRY = "country";
    private static final String SWEDEN = "sweden";
    private static final String USA = "usa";
    private static final List LIST_OF_COUNTRY_VALUES = Arrays.asList(SWEDEN, USA);
    private final static String expectedSqlPartForTheTests = "country IN ('sweden','usa')";
    private void assertWithExpectedSqlPart(final String actualSqlPart) {
        assertEquals(expectedSqlPartForTheTests, actualSqlPart.trim());
    }
}