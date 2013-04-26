package uncheckedExceptions;

import java.io.IOException;
import java.util.List;

public interface SqlAppender {
    void addSqlWhereClausePartWith_IN_Statement_WITH_DeclaredCheckedException(
        Appendable appendable,
        String columnName,
        List<String> values
    ) throws IOException;


    void addSqlWhereClausePartWith_IN_Statement_withOUT_DeclaredCheckedException(
        Appendable appendable,  
        String columnName,
        List<String> values
    );
}
