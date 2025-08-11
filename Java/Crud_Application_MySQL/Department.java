import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;

public class Department extends Variables

{
    
private String departmentname = null;
private String companyidstr = null;
private int companyid = 0;
    
@Override
public void Insert() throws SQLException

{
    
    checker = false;
    
    while(!checker)
    
    {
        
    System.out.print("\nGive me your departmentname : ");
    departmentname = input.nextLine();
    
    if(!(departmentname.length() <= 50) || departmentname.matches(".*\\d.*"))
    
    {
        
     System.out.println("\nYou passed max length of departmentname OR departmentname must have only characters.");
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
                
            System.out.print("\nPlease give the companyid : ");
            companyidstr = input.nextLine();
            
            companyid = Integer.parseInt(companyidstr);
                
            if(companyid <= 0 )
            
            {
            
            System.out.println("\nInvalid input. Please enter a positive integer greater than 0.");
            checker = false;
            
            }
            
            else
            
            {
            
            checker = true;
                
            }
            
            }
            
            sql = "SELECT COUNT(*) AS TotalRows FROM Company WHERE Id = ?;";

            try (Connection conn = getConnection();java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
             pstmt.setInt(1, companyid);
    
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

    System.out.println("\nInformation : " + departmentname.substring(0, 1).toUpperCase() + departmentname.substring(1/*, departmentname.length()*/).toLowerCase() + ", " + companyid);
        
    sql = "INSERT INTO Department (Departmentname, Companyid) VALUES (?, ?);COMMIT;";
    
    try (Connection conn = getConnection(); java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) 
    
    {
        
    pstmt.setString(1, departmentname.substring(0, 1).toUpperCase() + departmentname.substring(1/*, departmentname.length()*/).toLowerCase());
    pstmt.setInt(2, companyid);
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
            
            sql = "SELECT COUNT(*) AS TotalRows FROM Department WHERE Id = ?;";

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
        
    System.out.print("\nGive me your departmentname : ");
    departmentname = input.nextLine();
    
    if(!(departmentname.length() <= 50) || departmentname.matches(".*\\d.*"))
    
    {
        
     System.out.println("\nYou passed max length of department OR department must have only characters.");
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
                
            System.out.print("\nPlease give the companyid : ");
            companyidstr = input.nextLine();
            
            companyid = Integer.parseInt(companyidstr);
                
            if(companyid <= 0 )
            
            {
            
            System.out.println("\nInvalid input. Please enter a positive integer greater than 0.");
            checker = false;
            
            }
            
            else
            
            {
            
            checker = true;
                
            }
            
            }
 
    System.out.println("\nInformation : " + departmentname.substring(0, 1).toUpperCase() + departmentname.substring(1/*, departmentname.length()*/).toLowerCase() + ", " + companyid);
        
        sql = "UPDATE Department SET Departmentname = ?, Companyid = ? WHERE Id = ?;COMMIT;";
        
        try (Connection conn = getConnection(); java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) 
        
        {
            pstmt.setString(1, departmentname.substring(0, 1).toUpperCase() + departmentname.substring(1/*, departmentname.length()*/).toLowerCase());
            pstmt.setInt(2, companyid);
            pstmt.setInt(3, id);
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

    sql = "DELETE FROM Department WHERE Id = ?;COMMIT;";
    
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
    
    sql = "CALL Department();";
    
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
            departmentname = rs.getString("Departmentname");
            companyid = rs.getInt("Companyid");
            System.out.println("Id : " + id +
                               ", Departmentname : " + departmentname + ", Companyid : " + companyid);
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