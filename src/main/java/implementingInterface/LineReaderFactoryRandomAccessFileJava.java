package implementingInterface;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class LineReaderFactoryRandomAccessFileJava implements LineReaderFactory {

    public LineReader createLineReader(final File file) {
        try {
            return new RandomAccessFileWrapper(new RandomAccessFile(file, "r"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private final static class RandomAccessFileWrapper implements LineReader {
        private final RandomAccessFile randomAccessFile;
        private RandomAccessFileWrapper(final RandomAccessFile randomAccessFile) {
            this.randomAccessFile = randomAccessFile;    
        }
        public String readLine() throws IOException {
            return randomAccessFile.readLine();
        }
    }
}
