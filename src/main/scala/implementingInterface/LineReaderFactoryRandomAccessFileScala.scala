package implementingInterface

import java.io.{File, RandomAccessFile}
class LineReaderFactoryRandomAccessFileScala extends LineReaderFactory {
  def createLineReader(file: File): LineReader = {
    val randomAccessFileWithLineReader = new RandomAccessFile(file, "r") with LineReader
    return randomAccessFileWithLineReader 
  }
}