package uncheckedExceptions

class SqlAppenderImplementedWithScala extends SqlAppender {

    def addSqlWhereClausePartWith_IN_Statement_WITH_DeclaredCheckedException(
      appendable: Appendable, 
      columnName: String,
      values: java.util.List[String]
    ): Unit = {
      appendable.append(" ")
      appendable.append(columnName)
      appendable.append(" IN (")
      var i: Int = 0
      while (i < values.size) {
        {
          if (i > 0) {
            appendable.append(",")
          }
          appendable.append("'")
          appendable.append(values.get(i))
          appendable.append("'")
        }
        i += 1;
      }
      appendable.append(") ")
    }

    def addSqlWhereClausePartWith_IN_Statement_withOUT_DeclaredCheckedException(
        appendable: Appendable,
        columnName: String,
        values: java.util.List[String]
    ): Unit = {
      addSqlWhereClausePartWith_IN_Statement_WITH_DeclaredCheckedException(appendable, columnName, values)
    }

 }