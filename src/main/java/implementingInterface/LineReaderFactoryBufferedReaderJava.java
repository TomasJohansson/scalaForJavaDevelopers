package implementingInterface;

import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.Reader;

public final class LineReaderFactoryBufferedReaderJava implements LineReaderFactory {

    public LineReader createLineReader(final File file)  {
        try {
            return new BufferedReaderLineReader(new FileReader(file));
        } catch (FileNotFoundException e) {	
            throw new RuntimeException(e);
        }
    }

	private final static class BufferedReaderLineReader extends BufferedReader implements LineReader {
        public BufferedReaderLineReader(final Reader in)  {
            super(in);
        }
    }
    
}