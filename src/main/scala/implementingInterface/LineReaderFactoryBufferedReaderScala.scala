package implementingInterface

import java.io.{BufferedReader, File, FileReader}
class LineReaderFactoryBufferedReaderScala extends LineReaderFactory {
  def createLineReader(file: File): LineReader = {
    val bufferedReaderWithLineReader = new BufferedReader(new FileReader(file)) with LineReader
    return bufferedReaderWithLineReader
  }
}