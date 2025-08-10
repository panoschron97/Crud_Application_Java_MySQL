import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.text.ParseException;
import java.util.Calendar;

public class Task extends Variables
{

@Override
public void Insert() throws SQLException

{
    
    checker = false;
    
    while(!checker)
    
    {
        
    System.out.print("\nGive me your taskname : ");
    taskname = input.nextLine();
    
    if(!(taskname.length() <= 50) || taskname.matches(".*\\d.*"))
    
    {
        
     System.out.println("\nYou passed max length of taskname OR taskname must have only characters.");
     checker = false;
    
    }
    
    else
    
    {
        
    checker = true;
    
    }
    
    }
    
    checker = false;
    
     while (!checker)
     
    { 

        System.out.print("\nGive me your costtask : ");
        costtaskstr = input.nextLine();
        
        try
        
        {
            
            costtask = Double.parseDouble(costtaskstr);
            
            if(costtask >= 1000000.00)
            
            {
            
              
            checker = true;
            
            }
   
            else
            
            {
                
            System.out.println("\nInvalid input. Please enter a positive double that is greater than/or equal to 1000000.00.");
            
            }
            
        }
        
        catch (NumberFormatException e)
        
        {
            
         System.out.println("\nInvalid input. Please enter a valid double.");
         
        }
        
    }
    
    checker = false;
    
    while(!checker)
    
    {
        
    System.out.print("\nGive me your start date : ");
    startdate = input.nextLine();
    
    System.out.print("\nGive me your end date : ");
    enddate = input.nextLine();
    
    try
    
    {
        
        utildate = formatter.parse(startdate);
        utildate2 = formatter.parse(enddate);
        /*Calendar cal = Calendar.getInstance();
        cal.setTime(utildate);
        birthyear = cal.get(Calendar.YEAR);
        currentyear = Calendar.getInstance().get(Calendar.YEAR);*/
        
        if(utildate.compareTo(utildate2) <= 0)
        
        {
            
        checker = true;
        
        }
        
        else
        
        {
            
        System.out.println("\nstartdate should be less than/equal to endate.");
        
        }
        
    } 
    
    catch (ParseException e) 
    
    {
        
        System.out.println("\nInvalid date format. Please use format -> (yyyy-MM-dd).");
        
    }
    
    }
    
    sqldate = new java.sql.Date(utildate.getTime());
    
    sqldate2 = new java.sql.Date(utildate2.getTime());
    
      checker = false;
            
            while(!checker)
            {
                
            System.out.print("\nPlease give the departmentid : ");
            departmentidstr = input.nextLine();
            
            departmentid = Integer.parseInt(departmentidstr);
                
            if(departmentid <= 0 )
            
            {
            
            System.out.println("\nInvalid input. Please enter a positive integer greater than 0.");
            checker = false;
            
            }
            
            else
            
            {
            
            checker = true;
                
            }
            
            }
            
            sql = "SELECT COUNT(*) AS TotalRows FROM Department WHERE Id = ?;";

            try (Connection conn = getConnection();java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
             pstmt.setInt(1, departmentid);
    
            try (java.sql.ResultSet rs = pstmt.executeQuery()) 
            
            {
        
            if (rs.next()) 
            
            {
                
            total = rs.getInt("TotalRows");
            
            /*if (total == 0) 
            
            {
                System.out.println("\nNo record/records found.");
                //return;
                
            }*/ 
            
        }
        
    }
    
} 

catch (SQLException e) 

{
    
    System.out.println("\nError retrieving record/records : " + e.getMessage());
    return;
    
}

    System.out.println("\nInformation : " + taskname.substring(0, 1).toUpperCase() + taskname.substring(1/*, taskname.length()*/).toLowerCase() 
    + ", " + costtask + ", " + startdate + ", " + enddate + ", " + departmentid);
        
    sql = "INSERT INTO Task (Taskname, Costtask, Startdate, Enddate, Departmentid) VALUES (?, ?, ?, ?, ?);COMMIT;";
    
    try (Connection conn = getConnection(); java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) 
    
    {
        
    pstmt.setString(1, taskname.substring(0, 1).toUpperCase() + taskname.substring(1/*, taskname.length()*/).toLowerCase());
    pstmt.setDouble(2, costtask);
    pstmt.setDate(3, sqldate);
    pstmt.setDate(4, sqldate2);
    pstmt.setInt(5, departmentid);
    pstmt.executeUpdate();
    System.out.println("\nInformation inserted successfully.");
    
    }
    
    catch (SQLException e) 
    
    {
    
    System.out.println("\nError inserting record/records : " + e.getMessage());

    }
    
}

@Override
public void Update() throws SQLException

{
    
    checker = false;
     
     while (!checker)
     
    {
        
        try
        
        {
            
            while(!checker)
            {
                
            System.out.print("\nEnter the id of the record to update : ");
            idstr = input.nextLine();
            
            id = Integer.parseInt(idstr);
                
            if(id <= 0 )
            
            {
            
            System.out.println("\nInvalid input. Please enter a positive integer greater than 0.");
            checker = false;
            
            }
            
            else
            
            {
            
            checker = true;
                
            }
            
            }
            
            checker = false;
            
            sql = "SELECT COUNT(*) AS TotalRows FROM Task WHERE Id = ?;";

            try (Connection conn = getConnection();java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
             pstmt.setInt(1, id);
    
            try (java.sql.ResultSet rs = pstmt.executeQuery()) 
            
            {
        
            if (rs.next()) 
            
            {
                
            total = rs.getInt("TotalRows");
            
            if (total == 0) 
            
            {
                System.out.println("\nNo record/records found.");
                return;
                
            } 
            
            else 
            
            {
                
                System.out.println("\nNumber of record/records with id : " + id + " has " + total + " total row/rows.");
                
            }
            
        }
        
    }
    
} 

catch (SQLException e) 

{
    
    System.out.println("\nError retrieving record/records : " + e.getMessage());
    return;
    
}
            
            if(id > 0)
            
            {
                
            checker = true;
            
            }
            
            else
            
            {
                
            System.out.println("\nInvalid input. Please enter a positive integer greater than 0.");
            
            }
            
        }
        catch (NumberFormatException e)
        
        {
            
            System.out.println("\nInvalid input. Please enter a valid integer.");
            
        }
        
    }

      
    checker = false;
    
    while(!checker)
    
    {
        
    System.out.print("\nGive me your taskname : ");
    taskname = input.nextLine();
    
    if(!(taskname.length() <= 50) || taskname.matches(".*\\d.*"))
    
    {
        
     System.out.println("\nYou passed max length of taskname OR taskname must have only characters.");
     checker = false;
    
    }
    
    else
    
    {
        
    checker = true;
    
    }
    
    }
    
    checker = false;
    
     while (!checker)
     
    { 

        System.out.print("\nGive me your costtask : ");
        costtaskstr = input.nextLine();
        
        try
        
        {
            
            costtask = Double.parseDouble(costtaskstr);
            
            if(costtask >= 1000000.00)
            
            {
            
              
            checker = true;
            
            }
   
            else
            
            {
                
            System.out.println("\nInvalid input. Please enter a positive double that is greater than/or equal to 1000000.00.");
            
            }
            
        }
        
        catch (NumberFormatException e)
        
        {
            
         System.out.println("\nInvalid input. Please enter a valid double.");
         
        }
        
    }
    
    checker = false;
    
    while(!checker)
    
    {
        
    System.out.print("\nGive me your start date : ");
    startdate = input.nextLine();
    
    System.out.print("\nGive me your end date : ");
    enddate = input.nextLine();
    
    try
    
    {
        
        utildate = formatter.parse(startdate);
        utildate2 = formatter.parse(enddate);
        /*Calendar cal = Calendar.getInstance();
        cal.setTime(utildate);
        birthyear = cal.get(Calendar.YEAR);
        currentyear = Calendar.getInstance().get(Calendar.YEAR);*/
        
        if(utildate.compareTo(utildate2) <= 0)
        
        {
            
        checker = true;
        
        }
        
        else
        
        {
            
        System.out.println("\nstartdate should be less than/equal to endate.");
        
        }
        
    } 
    
    catch (ParseException e) 
    
    {
        
        System.out.println("\nInvalid date format. Please use format -> (yyyy-MM-dd).");
        
    }
    
    }
    
    sqldate = new java.sql.Date(utildate.getTime());
    
    sqldate2 = new java.sql.Date(utildate2.getTime());
    
      checker = false;
            
            while(!checker)
            {
                
            System.out.print("\nPlease give the departmentid : ");
            idstr = input.nextLine();
            
            departmentid = Integer.parseInt(idstr);
                
            if(departmentid <= 0 )
            
            {
            
            System.out.println("\nInvalid input. Please enter a positive integer greater than 0.");
            checker = false;
            
            }
            
            else
            
            {
            
            checker = true;
                
            }
            
            }
            
            sql = "SELECT COUNT(*) AS TotalRows FROM Department WHERE Id = ?;";

            try (Connection conn = getConnection();java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
             pstmt.setInt(1, departmentid);
    
            try (java.sql.ResultSet rs = pstmt.executeQuery()) 
            
            {
        
            if (rs.next()) 
            
            {
                
            total = rs.getInt("TotalRows");
            
            /*if (total == 0) 
            
            {
                System.out.println("\nNo record/records found.");
                //return;
                
            }*/ 
            
        }
        
    }
    
} 

catch (SQLException e) 

{
    
    System.out.println("\nError retrieving record/records : " + e.getMessage());
    return;
    
}

    System.out.println("\nInformation : " + taskname.substring(0, 1).toUpperCase() + taskname.substring(1/*, taskname.length()*/).toLowerCase() 
    + ", " + costtask + ", " + startdate + ", " + enddate + ", " + departmentid);
        
        sql = "UPDATE Task SET Taskname = ?, Costtask = ?, Startdate = ?, Enddate = ?, Departmentid = ? WHERE Id = ?;COMMIT;";
        
        try (Connection conn = getConnection(); java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) 
        
        {
            
        pstmt.setString(1, taskname.substring(0, 1).toUpperCase() + taskname.substring(1/*, taskname.length()*/).toLowerCase());
        pstmt.setDouble(2, costtask);
        pstmt.setDate(3, sqldate);
        pstmt.setDate(4, sqldate2);
        pstmt.setInt(5, departmentid);
        pstmt.setInt(6, id);
        rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) 
            
            {
                
                System.out.println("\nInformation updated successfully.");
            } 
            
            else 
            
            {
                
                System.out.println("\nNo record/records found.");
                
            }
            
        }
        
        catch (SQLException e) 
        
        {
            
            System.out.println("\nError updating record/records : " + e.getMessage());
            return;
        }
    
}

@Override
public void Delete()

{
    
    checker = false;
     
     while (!checker)
     
    {
        
        System.out.print("\nEnter the id of the record to delete : ");
        idstr = input.nextLine();
        
        try
        
        {
            
            id = Integer.parseInt(idstr);
            
            if(id > 0)
            
            {
                
            checker = true;
            
            }
            
            else
            
            {
                
            System.out.println("\nInvalid input. Please enter a positive integer greater than 0.");
            
            }
            
        }
        
        catch (NumberFormatException e)
        
        {
            
            System.out.println("\nInvalid input. Please enter a valid integer.");
            
        }
        
    }

    sql = "DELETE FROM Task WHERE Id = ?;COMMIT;";
    
    try (Connection conn = getConnection(); java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) 
    
    {
        pstmt.setInt(1, id);
        rowsAffected = pstmt.executeUpdate();
        
        if (rowsAffected > 0) 
        
        {
            
            System.out.println("\nInformation deleted successfully.");
        } 
        
        else 
        
        {
            
            System.out.println("\nNo record/records found.");
            
        }
        
    } 
    
    catch (SQLException e) 
    
    {
        
        System.out.println("\nError deleting record/records : " + e.getMessage());
        
    }
    
}

@Override
public void Select() throws SQLException 

{
    
    hasrecords = false;
    
    sql = "SELECT * FROM Task ORDER BY Id ASC;";
    
    try (Connection conn = getConnection();
         java.sql.Statement stmt = conn.createStatement();
         java.sql.ResultSet rs = stmt.executeQuery(sql)) 
         
         {
        
        System.out.println("\n--- Record/Records in the information table ---");
        System.out.println();
        
        while (rs.next()) 
        
        {
            hasrecords = true;
            id = rs.getInt("Id");
            taskname = rs.getString("Taskname");
            costtask = rs.getDouble("Netcosttask");
            startdateselect = rs.getDate("Startdate");
            enddateselect = rs.getDate("Enddate");
            departmentid = rs.getInt("Departmentid");
            System.out.println("Id : " + id +
                               ", Taskname : " + taskname + ", Costtask : " + costtask + ", Startdate : " + startdateselect + ", Enddate : " + enddateselect + ", Departmentid : " + departmentid);
        }
        
        if (!hasrecords) 
        
        {
            
            System.out.println("No record/records found.");
            
        }
        
    } 
    
    catch (SQLException e) 
    
    {
        
        System.out.println("\nError retrieving record/records : " + e.getMessage());
        
    }
    
}    

}