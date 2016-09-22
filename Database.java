/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appliedjavaassignment;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
public class Database {
    static final String conString="jdbc:sqlserver://localhost:1433;" + 
            "databaseName=JavaProject;user=sa;password=stanley;";
   static  Connection connection =null;
  static Statement statement =null;
 static  ResultSet resultSet = null;
    public static void connect(){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(conString);
            
        }
         catch( SQLException sqlException){
          sqlException.printStackTrace();
      }
        catch (ClassNotFoundException cE) {
            System.out.println("Class Not Found Exception: "+ cE.toString());
        }
    }
    public static void insert(){
        connect();
        try{
       statement= connection.createStatement();
        String text = Insert.statement.getText();
        statement.executeUpdate(text);
        Insert.label2.setText("Execution was sucessful !");
        Insert.p2.setVisible(true);
        Insert.statement.setText("");
        }
        catch(SQLException ee){
            ee.printStackTrace();
        }
        finally{
            disconnect();
        }
    }
    public static void read(){
        connect(); 
        
        try{
          statement= connection.createStatement();
          resultSet= statement.executeQuery(ReadData.statement.getText()); 
            ResultSetMetaData metaData = resultSet.getMetaData();
             int numberOfColumns = metaData.getColumnCount();
             String[]column = new String[numberOfColumns];
             for(int k =0;k<numberOfColumns;k++){
                 column[k]=metaData.getColumnName(k+1);
                 ReadData.dm.addColumn(column[k]);
             }
             Object[] row=new Object[numberOfColumns];
             while(resultSet.next()){
                 for(int i =0;i<numberOfColumns;i++){
                     row[i]=resultSet.getString(i+1);
                     
                 }
                 ReadData.dm.addRow(row);
             }
             ReadData.jt.setModel(ReadData.dm);
            
             ReadData.panel7.setVisible(true);
        }
        catch(SQLException ee){
            ee.printStackTrace();
        }
        finally{
            disconnect();
        }
    }
    public static  void disconnect(){
        
            try{
                connection.close();
               
                
            }
            catch(Exception e){
              e.printStackTrace();
          }
        
        }
        
    
}
