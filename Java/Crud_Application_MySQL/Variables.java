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

protected String firstname = null, lastname = null, datebirth = null, agestr = null, salarystr = null, sql = null, sexstr = null, jobstatusstr = null;
protected int age = 0, birthyear = 0, currentyear = 0;
protected Date utildate = null;
protected Date utildate2 = null;
protected double salary = 0.0;
protected char sex = ' ';
protected boolean jobstatus = false;
protected java.sql.Date sqldate = null;
protected java.sql.Date sqldate2 = null;

protected String idstr = null;
protected int id = 0, rowsAffected = 0;
protected int total = 0;

protected String datebirthstring = null;
protected boolean hasrecords = false;
protected String sexselect = null;
protected Date datebirthselect = null;
protected String levelofeducation = null;

protected int departmentid = 0;
protected int taskid = 0;

protected String companyname = null;

protected String departmentname = null;
protected String companyidstr = null;
protected int companyid = 0;

protected String taskidstr = null;
protected String departmentidstr = null;

protected String taskname = null;
protected double costtask = 0.0;
protected String costtaskstr = null;
protected String startdate = null;
protected String enddate = null;
protected Date startdateselect = null;
protected Date enddateselect = null;

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