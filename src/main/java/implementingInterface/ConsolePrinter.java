package implementingInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;

public class ConsolePrinter {

    public final void printAllLines(final RandomAccessFile randomAccessFile)
        throws IOException
    {
        String line;
        while( (line = randomAccessFile.readLine()) != null) {
            printRow(SOME_HYPHENS);
            printRow(line);
            printRow(line.toUpperCase());
            printRow(line.toLowerCase());
            printRow(SOME_HYPHENS);
        }
    }


    public final void printAllLines(final BufferedReader bufferedReader)
        throws IOException
    {
        String line;
        while( (line = bufferedReader.readLine()) != null) {
            printRow(SOME_HYPHENS);
            printRow(line);
            printRow(line.toUpperCase());
            printRow(line.toLowerCase());
            printRow(SOME_HYPHENS);
        }
    }

    private void printRow(String s) {
        printStream.println(s);
    }

    static final String SOME_HYPHENS = "---";
    
    ConsolePrinter() {
        this(System.out);
    }
    
    ConsolePrinter(final PrintStream printStream) {
        this.printStream = printStream;
    }
    
    private final PrintStream printStream;
}
