package implementingInterface;

import java.io.File;
public interface LineReaderFactory {
    LineReader createLineReader(File file);
}