package springFromScala

object ScalaMainObject {

  def main(args: Array[String]): Unit = {
    // This scala object/method should not be needed but sometimes SBT does not seem to be able to detect Java main methods when executing the SBT "run" command ... 
    JavaMainClass.main(args)
  }

}