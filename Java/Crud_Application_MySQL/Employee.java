import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.text.ParseException;
import java.util.Calendar;

public class Employee extends Variables
{


private double salary = 0.0;
private char sex = ' ';
private boolean jobstatus = false;   
private int age = 0, birthyear = 0, currentyear = 0;
private String firstname = null, lastname = null, datebirth = null, agestr = null, salarystr = null, sexstr = null, jobstatusstr = null;
private String datebirthstring = null;
private Date datebirthselect = null;
private String sexselect = null;
private String levelofeducation = null;
private String taskidstr = null;
private int taskid = 0;

@Override
public void Insert() throws SQLException

{
    
    checker = false;
    
    while(!checker)
    
    {
        
    System.out.print("\nGive me your firstname : ");
    firstname = input.nextLine();
    System.out.print("\nGive me your lastname : ");
    lastname = input.nextLine();
    
    if(!(firstname.length() <= 50) || !(lastname.length() <= 50) || firstname.matches(".*\\d.*") || lastname.matches(".*\\d.*"))
    
    {
        
     System.out.println("\nYou passed max length of firstname and lastname OR firstname and lastname must have only characters.");
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
        
        System.out.print("\nGive me your age : ");
        agestr = input.nextLine();
        
        try
        
        {

            age = Integer.parseInt(agestr);
            
            if(age >= 18)
            
            {
                
            checker = true;
            }
            
            else
            
            {
                
            System.out.println("\nInvalid input. Please enter a positive integer greater than/or equal to 18.");
            
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
        
    System.out.print("\nGive me your sex : ");
    sexstr = input.nextLine();
    
    sex = sexstr.toUpperCase().charAt(0);
    
    if((!(sex == 'M') && !(sex == 'F') && !(sex == 'N')) || sexstr.length() != 1)
    
    {
        
     System.out.println("\nGive me valid sex (M / F / N)");
     checker = false;
    
    }
    
    else
    
    {
        
    checker = true;
    
    }
    
    }
    
    checker = false;
    
    while(!checker)
    
    {
        
    System.out.print("\nGive me your birth date : ");
    datebirth = input.nextLine();
    
    try
    
    {
        
        utildate = formatter.parse(datebirth);
        Calendar cal = Calendar.getInstance();
        cal.setTime(utildate);
        birthyear = cal.get(Calendar.YEAR);
        currentyear = Calendar.getInstance().get(Calendar.YEAR);
        
        if(age == currentyear - birthyear)
        
        {
            
        checker = true;
        
        }
        
        else
        
        {
            
        System.out.println("\nDate birth is not valid with the age you gave.");
        
        }
        
    } 
    
    catch (ParseException e) 
    
    {
        
        System.out.println("\nInvalid date format. Please use format -> (yyyy-MM-dd).");
        
    }
    
    }
    
    sqldate = new java.sql.Date(utildate.getTime());
    
     
    checker = false;
    
    while(!checker)
    
    {
        
    System.out.print("\nGive me your level of education (N/A / 4 / 5 / 6 / 7 / 8) : ");
    levelofeducation = input.nextLine();
    
    if(!(levelofeducation.toUpperCase().equals("N/A")) && !(levelofeducation.equals("4")) && !(levelofeducation.equals("5"))
    && !(levelofeducation.equals("6")) && !(levelofeducation.equals("7")) && !(levelofeducation.equals("8")))
    
    {
        
     System.out.println("\nPlease give a valid level of education (N/A / 4 / 5 / 6 / 7 / 8).");
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

        System.out.print("\nGive me your salary : ");
        salarystr = input.nextLine();
        
        try
        
        {
            
            salary = Double.parseDouble(salarystr);
            
            if(salary >= 1000.0)
            
            {
            
            jobstatus = true;    
            checker = true;
            
            }
            else if (salary == 0.0)
            {
            
            jobstatus = false;    
            checker = true;
            
            }
            else
            
            {
                
            System.out.println("\nInvalid input. Please enter a positive double that is greater than/or equal to 1000.0 or 0.0.");
            
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
                
            System.out.print("\nPlease give the departmentid : ");
            departmentidstr = input.nextLine().trim();
            
            if(departmentidstr.isEmpty() || departmentidstr.equalsIgnoreCase("NULL")) 
            
            {
                
             checker = true;
             break; 
             
             } 
             
    try 
    
    {
        departmentid = Integer.parseInt(departmentidstr);
        
        if (departmentid <= 0) 
        
        {
            System.out.println("\nInvalid input. Please enter a positive integer greater than 0.");
            checker = false; 
        } 
        
        else 
        
        {
            checker = true;
        }
    } 
    
    catch (NumberFormatException e) 
    
    {
        System.out.println("\nInvalid input. Please enter a valid integer.");
        
    }

            sql = "SELECT COUNT(*) AS TotalRows FROM Department WHERE Id = ?;";

            try (Connection conn = getConnection();java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) 
            
            {
              
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
    //return;
    
}

}

 checker = false;
            
            while(!checker)
            {
                
            System.out.print("\nPlease give the taskid : ");
            taskidstr = input.nextLine().trim();
            
            if(taskidstr.isEmpty() || taskidstr.equalsIgnoreCase("NULL")) 
            
            {
                
             checker = true;
             break; 
             
             } 
             
    try 
    
    {
        taskid = Integer.parseInt(taskidstr);
        
        if (taskid <= 0) 
        
        {
            System.out.println("\nInvalid input. Please enter a positive integer greater than 0.");
            checker = false; 
        } 
        
        else 
        
        {
            checker = true;
        }
    } 
    
    catch (NumberFormatException e) 
    
    {
        System.out.println("\nInvalid input. Please enter a valid integer.");
        
    }

            sql = "SELECT COUNT(*) AS TotalRows FROM Task WHERE Id = ?;";

            try (Connection conn = getConnection();java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) 
            
            {
              
              pstmt.setInt(1, taskid);
              
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
    //return;
    
}

}

    System.out.println("\nInformation : " + firstname.substring(0, 1).toUpperCase() + firstname.substring(1/*, firstname.length()*/).toLowerCase() + 
    ", " + lastname.substring(0, 1).toUpperCase() + lastname.substring(1/*, lastname.length()*/).toLowerCase() + ", " + age + ", " + sex + ", " + 
    datebirth + ", " + jobstatus + ", " + levelofeducation.toUpperCase() + ", " + salary + ", " + departmentid + ", " + taskid);
        
    sql = "INSERT INTO Information (Firstname, Lastname, Age, Sex, Datebirth, Jobstatus, Levelofeducation, Salary, Departmentid, Taskid) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);COMMIT;";
    
    try (Connection conn = getConnection(); java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) 
    
    {
        
    pstmt.setString(1, firstname.substring(0, 1).toUpperCase() + firstname.substring(1/*, firstname.length()*/).toLowerCase());
    pstmt.setString(2, lastname.substring(0, 1).toUpperCase() + lastname.substring(1/*, lastname.length()*/).toLowerCase());
    pstmt.setInt(3, age);
    pstmt.setString(4, String.valueOf(sex));
    pstmt.setDate(5, sqldate);
    pstmt.setBoolean(6, jobstatus);
    pstmt.setString(7, levelofeducation);
    pstmt.setDouble(8, salary);   
    
    if (departmentidstr.isEmpty() || departmentidstr.equalsIgnoreCase("NULL")) 
     
    {
        
    pstmt.setNull(9, java.sql.Types.INTEGER);
    
    }
    
    else 
    {
        
        pstmt.setInt(9, departmentid);
    }
    
    if (taskidstr.isEmpty() || taskidstr.equalsIgnoreCase("NULL")) 
     
    {
        
    pstmt.setNull(10, java.sql.Types.INTEGER);
    
    }
    
    else 
    {
        
        pstmt.setInt(10, taskid);
    }

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
            
            sql = "SELECT COUNT(*) AS TotalRows FROM Information WHERE Id = ?;";

            try (Connection conn = getConnection();java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) 
            
            {
    
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
        
    System.out.print("\nGive me your firstname : ");
    firstname = input.nextLine();
    System.out.print("\nGive me your lastname : ");
    lastname = input.nextLine();
    
    if(!(firstname.length() <= 50) || !(lastname.length() <= 50) || firstname.matches(".*\\d.*") || lastname.matches(".*\\d.*"))
    
    {
        
     System.out.println("\nYou passed max length of firstname and lastname OR firstname and lastname must have only characters.");
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
        
        System.out.print("\nGive me your age : ");
        agestr = input.nextLine();
        
        try
        
        {
            
            age = Integer.parseInt(agestr);
            
            if(age >= 18)
            
            {
                
            checker = true;
            
            }
            
            else
            
            {
                
            System.out.println("\nInvalid input. Please enter a positive integer greater than/or equal to 18.");
            
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
        
    System.out.print("\nGive me your sex : ");
    sexstr = input.nextLine();
    
    sex = sexstr.toUpperCase().charAt(0);
    
    if((!(sex == 'M') && !(sex == 'F') && !(sex == 'N')) || sexstr.length() != 1)
    
    {
        
     System.out.println("\nGive me valid sex (M / F / N)");
     checker = false;
    
    }
    
    else
    
    {
        
    checker = true;
    
    }
    
    }
    
    checker = false;
    
    while(!checker)
    
    {
        
    System.out.print("\nGive me your birth date : ");
    datebirth = input.nextLine();
    
    try 
    
    {
        
        utildate = formatter.parse(datebirth);
        Calendar cal = Calendar.getInstance();
        cal.setTime(utildate);
        birthyear = cal.get(Calendar.YEAR);
        currentyear = Calendar.getInstance().get(Calendar.YEAR);
        
        if(age == currentyear - birthyear)
        
        {
            
        checker = true;
        
        }
        
        else
        
        {
            
        System.out.println("\nDate birth is not valid with the age you gave.");
        
        }
        
    } 
    
    catch (ParseException e) 
    
    {
        
        System.out.println("\nInvalid date format. Please use format -> (yyyy-MM-dd).");
        
    }
    
    }
    
    sqldate = new java.sql.Date(utildate.getTime());
    
    checker = false;
    
    while(!checker)
    
    {
        
    System.out.print("\nGive me your level of education (N/A / 4 / 5 / 6 / 7 / 8) : ");
    levelofeducation = input.nextLine();
    
    if(!(levelofeducation.toUpperCase().equals("N/A")) && !(levelofeducation.equals("4")) && !(levelofeducation.equals("5"))
    && !(levelofeducation.equals("6")) && !(levelofeducation.equals("7")) && !(levelofeducation.equals("8")))
    
    {
        
     System.out.println("\nPlease give a valid level of education (N/A / 4 / 5 / 6 / 7 / 8).");
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
        
        System.out.print("\nGive me your salary : ");
        salarystr = input.nextLine();
        
        try
        
        {
            
            salary = Double.parseDouble(salarystr);
            
            if(salary >= 1000.0)
            
            {
                
            jobstatus = true;
            checker = true;
            
            
            }
            
            else if (salary == 0.0)
            
            {
            
            jobstatus = false;
            checker = true;    
            
            }
            
            else
            
            {
                
            System.out.println("\nInvalid input. Please enter a positive double greater than/or equal to 1000.0 or 0.0.");
            
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
                
            System.out.print("\nPlease give the departmentid : ");
            departmentidstr = input.nextLine();
            
             if(departmentidstr.isEmpty() || departmentidstr.equalsIgnoreCase("NULL")) 
            
            {
                
             checker = true;
             break; 
             
             } 
            
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
    
    checker = false;
            
            while(!checker)
            {
                
            System.out.print("\nPlease give the taskid : ");
            taskidstr = input.nextLine().trim();
            
            if(taskidstr.isEmpty() || taskidstr.equalsIgnoreCase("NULL")) 
            
            {
                
             checker = true;
             break; 
             
             } 
             
    try 
    
    {
        taskid = Integer.parseInt(taskidstr);
        
        if (taskid <= 0) 
        
        {
            System.out.println("\nInvalid input. Please enter a positive integer greater than 0.");
            checker = false; 
        } 
        
        else 
        
        {
            checker = true;
        }
    } 
    
    catch (NumberFormatException e) 
    
    {
        System.out.println("\nInvalid input. Please enter a valid integer.");
        
    }

            sql = "SELECT COUNT(*) AS TotalRows FROM Task WHERE Id = ?;";

            try (Connection conn = getConnection();java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) 
            
            {
              
              pstmt.setInt(1, taskid);
              
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
    //return;
    
}

}

    System.out.println("\nInformation : " + firstname.substring(0, 1).toUpperCase() + firstname.substring(1/*, firstname.length()*/).toLowerCase() + 
    ", " + lastname.substring(0, 1).toUpperCase() + lastname.substring(1/*, lastname.length()*/).toLowerCase() + ", " + age + ", " + sex + ", " + 
    datebirth + ", " + jobstatus + ", " + levelofeducation.toUpperCase() + ", " + salary + ", " + departmentid + ", " + taskid);

        sql = "UPDATE Information SET Firstname = ?, Lastname = ?, Age = ?, Sex = ?, Datebirth = ?, Jobstatus = ?, Levelofeducation = ?, Salary = ?, Departmentid = ?, Taskid = ? WHERE Id = ?;COMMIT;";
        
        try (Connection conn = getConnection(); java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) 
        
        {
            pstmt.setString(1, firstname.substring(0, 1).toUpperCase() + firstname.substring(1/*, firstname.length()*/).toLowerCase());
            pstmt.setString(2, lastname.substring(0, 1).toUpperCase() + lastname.substring(1/*, lastname.length()*/).toLowerCase());
            pstmt.setInt(3, age);
            pstmt.setString(4, String.valueOf(sex));
            pstmt.setDate(5, sqldate);
            pstmt.setBoolean(6, jobstatus);
            pstmt.setString(7, levelofeducation);
            pstmt.setDouble(8, salary);
            if (departmentidstr.isEmpty() || departmentidstr.equalsIgnoreCase("NULL")) 
     
    {
        
    pstmt.setNull(9, java.sql.Types.INTEGER);
    
    }
    
    else
    
    {
        
        pstmt.setInt(9, departmentid);
        
    }
    
    if (taskidstr.isEmpty() || taskidstr.equalsIgnoreCase("NULL")) 
     
    {
        
    pstmt.setNull(10, java.sql.Types.INTEGER);
    
    }
    
    else
    
    {
        
        pstmt.setInt(10, taskid);
        
    }
    
            pstmt.setInt(11, id);
            rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) 
            
            {
                
                System.out.println("\nInformation updated successfully.");
            } 
            
            else 
            
            {
                
                System.out.println("\nNo record/records found with the provided id.");
                
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

    sql = "DELETE FROM Information WHERE Id = ?;COMMIT;";
    
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
            
            System.out.println("\nNo record/records found with the provided id.");
            
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
    
    sql = "CALL Information();";
    
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
            firstname = rs.getString("Firstname");
            lastname = rs.getString("Lastname");
            age = rs.getInt("Age");
            sexselect = rs.getString("Sex");
            datebirthselect = rs.getDate("Datebirth");
            jobstatus = rs.getBoolean("Jobstatus");
            levelofeducation = rs.getString("Levelofeducation");
            salary = rs.getDouble("Netsalary");
            departmentid = rs.getInt("Departmentid");
            taskid = rs.getInt("Taskid");
            datebirthstring = formatter.format(datebirthselect);
            System.out.println("Id : " + id +
                               ", Firstname : " + firstname +
                               ", Lastname : " + lastname +
                               ", Age : " + age +
                               ", Sex : " + sexselect +
                               ", Datebirth : " + datebirthstring +
                               ", Jobstatus : " + jobstatus +
                               ", Levelofeducation : " + levelofeducation +
                               ", Salary : " + salary +
                               ", Departmentid : " + departmentid +
                               ", Taskid : " + taskid);
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