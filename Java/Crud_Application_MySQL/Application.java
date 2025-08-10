import java.sql.SQLException;
import java.util.Scanner;

public class Application extends Mainvariables

{

public static void main(String[] args) throws SQLException

{
    
    System.out.println("\nINFORMATION APPLICATION.");
    
    while(!checker)
    
    {
        
    System.out.print("\nGive me your username : ");
    user = input.nextLine();
    System.out.print("\nGive me your password : ");
    pass = input.nextLine();    
        
    if(!user.equals(username) || !pass.equals(password))
    
    {
        if(triestologin == 0)
        
        {
        System.out.println("\nExit, your tries are : " + triestologin);
        System.exit(0);
        
        }
        
        checker = false;
        System.out.println("\nWrong credentials. Try again. - you have " + triestologin + " tries left.");
        triestologin--;
        
    }
    
    else
    
    {
        
    checker = true;
    
    }
    
    }
    
    System.out.println("\nWelcome user " + username + " to the information application.");
    
    do 
    
    { 
             System.out.println("\nInformation application menu.");
             System.out.print("\nPress 01 to insert Company.");
             System.out.print("\nPress 02 to update Company.");
             System.out.print("\nPress 03 to delete Company.");
             System.out.print("\nPress 04 to select Company.");
             System.out.print("\nPress 05 to insert Department.");
             System.out.print("\nPress 06 to update Department.");
             System.out.print("\nPress 07 to delete Department.");
             System.out.print("\nPress 08 to select Department.");
             System.out.print("\nPress 09 to insert Task.");
             System.out.print("\nPress 10 to update Task.");
             System.out.print("\nPress 11 to delete Task.");
             System.out.print("\nPress 12 to select Task.");
             System.out.print("\nPress 13 to insert information.");
             System.out.print("\nPress 14 to update information.");
             System.out.print("\nPress 15 to delete information.");
             System.out.print("\nPress 16 to select information.");
             System.out.println("\nPress 17 to exit from application.");
        
        System.out.print("\nGive a choice between 1 - 17 : ");
        choice = input.nextLine();
        
        switch(choice)
        
        {
        
        case "01" : company.Insert(); break;
        case "02" : company.Update(); break;
        case "03" : company.Delete(); break;
        case "04" : company.Select(); break;
        case "05" : department.Insert(); break;
        case "06" : department.Update(); break;
        case "07" : department.Delete(); break;
        case "08" : department.Select(); break;
        case "09" : task.Insert(); break;
        case "10" : task.Update(); break;
        case "11" : task.Delete(); break;
        case "12" : task.Select(); break;
        case "13" : employee.Insert(); break;
        case "14" : employee.Update(); break;
        case "15" : employee.Delete(); break;
        case "16" : employee.Select(); break;
        case "17" : System.out.println("\nExit from application.");System.exit(0); break;
        default : System.out.println("\nPlease give a choice between 1 - 17."); break;
        
        }
        
    }
    
    while(repetation);

}

}