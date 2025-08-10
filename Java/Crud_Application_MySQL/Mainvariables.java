import java.util.Scanner;

public abstract class Mainvariables
{
    
    protected static Scanner input = new Scanner(System.in);
    protected static boolean checker = false;
    protected static boolean repetation = true;
    protected static final String username = "panos";
    protected static final String password = "chron";
    protected static int triestologin = 2;
    protected static String user = null, pass = null, choice = null; 
    protected static Company company = new Company();
    protected static Department department = new Department();
    protected static Task task = new Task();
    protected static Employee employee = new Employee();

}