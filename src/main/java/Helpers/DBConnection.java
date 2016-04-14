package Helpers;

import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author TTT
 */
public class DBConnection
{
    public static DBConnection getInstance() {
        return NewDbConnectionHolder.INSTANCE;
    }
    
    private static class NewDbConnectionHolder {

        private static final DBConnection INSTANCE = new DBConnection();
    }
    private Statement statement;
    private Connection sqlConnection;
    
    public DBConnection()
    {
        init();
    }
    
    /**
     * selects all from the tableName and puts this in a table
     * @param tableName user input for table name
     * @return table used for fullhouse_db
     */
    public TableModel getTableFromDb(String tableName)
    {
        ResultSet r;
        try {
            r = statement.executeQuery("SELECT * FROM `INF-G`." + tableName);
            return buildTableModel(r);
            
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    private static DefaultTableModel buildTableModel(ResultSet rs)
        throws SQLException {

    ResultSetMetaData metaData = rs.getMetaData();

    // names of columns
    Vector<String> columnNames = new Vector<String>();
    int columnCount = metaData.getColumnCount();
    for (int column = 1; column <= columnCount; column++) {
        columnNames.add(metaData.getColumnName(column));
    }

    // data of the table
    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    while (rs.next()) {
        Vector<Object> vector = new Vector<Object>();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            vector.add(rs.getObject(columnIndex));
        }
        data.add(vector);
    }

    return new DefaultTableModel(data, columnNames);

}
    
    private void init(){
    
       try{
        
        Class.forName("com.mysql.jdbc.Driver");//try connecting
        sqlConnection = DriverManager.getConnection(
                "jdbc:mysql://wilmardenouden.nl:3306/INF-G","inf-g", "pass12345"
                );
        }
        catch(Exception e){
            System.out.println("Failed to get connection");//if connection failed with an exceptions
            e.printStackTrace();
        }
       finally
       {
           try {
               System.out.println("finished trying to connect to the database. Connected? : " + !sqlConnection.isClosed());//check if the connection failed without exception.
               statement = sqlConnection.createStatement();

           } catch (SQLException ex) {
               Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }
    
    public void sendQuery(String query)
    {
        try {
            if(!sqlConnection.isClosed())
                statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Statement getStatement() {
        return statement;
    }
    
    public void close(ResultSet rs){
        
        if(rs !=null){
            try{
               rs.close();
            }
            catch(Exception e){}
            
        }
    }
    
     public void close(java.sql.Statement stmt){
        
        if(stmt !=null){
            try{
               stmt.close();
            }
            catch(Exception e){}
        
        }
    }
     
  public void destroy(){
  
    if(sqlConnection !=null){
    
         try{
               sqlConnection.close();
            }
            catch(Exception e){}
        
        
    }
  }
}