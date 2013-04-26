package implementingInterface;

import java.io.IOException;
import java.io.PrintStream;

public class ConsolePrinterRefactored {
//    public final void printAllLines(final RandomAccessFile randomAccessFile)
//            throws IOException
//        {
//            String line;
//            while( (line = randomAccessFile.readLine()) != null) {
//                printRow(SOME_HYPHENS);
//                printRow(line);
//                printRow(line.toUpperCase());
//                printRow(line.toLowerCase());
//                printRow(SOME_HYPHENS);
//            }
//        }
//
//
//        public final void printAllLines(final BufferedReader bufferedReader)
//            throws IOException
//        {
//            String line;
//            while( (line = bufferedReader.readLine()) != null) {
//                printRow(SOME_HYPHENS);
//                printRow(line);
//                printRow(line.toUpperCase());
//                printRow(line.toLowerCase());
//                printRow(SOME_HYPHENS);
//            }
//        }
	
		// The above methods (with duplication) have now been removed, and replaced with the following method 
        public final void printAllLines(
                final LineReader lineReader
            )
                throws IOException
            {
                String line;
                while( (line = lineReader.readLine()) != null) {
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
        
        ConsolePrinterRefactored() {
            this(System.out);
        }
        
        ConsolePrinterRefactored(final PrintStream printStream) {
            this.printStream = printStream;
        }
        
        private final PrintStream printStream;

}
