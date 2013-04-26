package implementingInterface;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

//  SBT-command: test-only implementingInterface.LineReaderTest
public class LineReaderTest {

    private final static List<LineReaderFactory> LINE_READER_FACTORIES = Arrays.asList(
        new LineReaderFactoryBufferedReaderJava(),
        new LineReaderFactoryRandomAccessFileJava(),
        new LineReaderFactoryBufferedReaderScala(),
        new LineReaderFactoryRandomAccessFileScala()
    );

    @Test
    public void verifyThatAllExpectedLinesInFileCanBeReadByAllLineReaders() throws IOException {
        for (LineReaderFactory lineReaderFactory : LINE_READER_FACTORIES) {
            verifyThatAllExpectedLinesInFileCanBeReadByLineReader(lineReaderFactory);
        }
    }

    private void verifyThatAllExpectedLinesInFileCanBeReadByLineReader(
        final LineReaderFactory lineReaderFactory
    ) throws IOException
    {
        final LineReader lineReader = lineReaderFactory.createLineReader(tempFile);
        assertEquals(FILE_CONTENT_LINE_1, lineReader.readLine());
        assertEquals(FILE_CONTENT_LINE_2, lineReader.readLine());
        assertEquals(FILE_CONTENT_LINE_3, lineReader.readLine());
        assertNull(lineReader.readLine());
    }

    @BeforeClass
    public static void beforeClass() throws IOException {
        tempFile = File.createTempFile("LineReaderTest", "");

        FileUtils.writeLines(
            tempFile,
            Arrays.asList(
                FILE_CONTENT_LINE_1,
                FILE_CONTENT_LINE_2,
                FILE_CONTENT_LINE_3
            )
        );
    }

    @AfterClass
    public static void afterClass() throws IOException {
        tempFile.delete();
    }

    private static File tempFile;

    private final static String FILE_CONTENT_LINE_1 = "Row 1";
    private final static String FILE_CONTENT_LINE_2 = "Row 2";
    private final static String FILE_CONTENT_LINE_3 = "Row 3";
}