import java.sql.*;
public class DBConnect {
    Connection conn=null;
    public DBConnect() throws Exception
    {
        Class.forName("oracle.jdbc.OracleDriver");
        conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE",
                "hr","hr");
        
    }
    public void QueryExecuter(String sql) throws Exception
    {
    Statement stat = conn.createStatement();
    stat.execute(sql);
    stat.close();
    conn.close();
    }
  public ResultSet QueryReturner(String sql) throws Exception
  {
      Statement stat = conn.createStatement();
      ResultSet rs = stat.executeQuery(sql);
      return rs;
  }
}
