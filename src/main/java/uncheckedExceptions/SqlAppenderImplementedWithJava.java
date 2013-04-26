package uncheckedExceptions;

import java.io.IOException;
import java.util.List;

public class SqlAppenderImplementedWithJava implements SqlAppender {
    public void addSqlWhereClausePartWith_IN_Statement_WITH_DeclaredCheckedException(
        final Appendable appendable,
        final String columnName,
        final List<String> values
    )
        throws IOException
    {
        appendable.append(" ");
        appendable.append(columnName);
        appendable.append(" IN (");
        for (int i = 0; i < values.size(); i++) {
            if (i > 0) {
	        	appendable.append(",");
            }            
            appendable.append("'");
            appendable.append(values.get(i));
            appendable.append("'");
        }
        appendable.append(") ");    	
    }

    public void addSqlWhereClausePartWith_IN_Statement_withOUT_DeclaredCheckedException(
        final Appendable appendable,
        final String columnName,
        final List<String> values
    )
    {
        try {
            addSqlWhereClausePartWith_IN_Statement_WITH_DeclaredCheckedException(appendable, columnName, values);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}