import java.util.Scanner; 
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

/*import java.util.ArrayList;*/

public abstract class Variables implements Modifymethods, Displaymethods
{

protected Scanner input = new Scanner(System.in);
protected SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
protected boolean checker = false;

protected String sql = null;
protected Date utildate = null;
protected java.sql.Date sqldate = null;

protected String departmentidstr = null;
protected int departmentid = 0;

protected String idstr = null;
protected int id = 0, rowsAffected = 0;
protected int total = 0;

protected boolean hasrecords = false;

protected String url = null;
protected String user = null;
protected String password = null;

public Connection getConnection() throws SQLException 

{
    url = "jdbc:mysql://localhost:3306/Application?allowMultiQueries=true";
    user = "root";
    password = "27031997";
    return DriverManager.getConnection(url, user, password);
    
}

/*public abstract void Insert() throws SQLException;
public abstract void Update() throws SQLException;
public abstract void Delete() throws SQLException;
public abstract void Select() throws SQLException;*/

}