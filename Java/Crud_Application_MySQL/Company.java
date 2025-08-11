import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;

public class Company extends Variables

{
    
private String companyname = null;
    
@Override
public void Insert() throws SQLException

{
    
    checker = false;
    
    while(!checker)
    
    {
        
    System.out.print("\nGive me your companyname : ");
    companyname = input.nextLine();
    
    if(!(companyname.length() <= 50) || companyname.matches(".*\\d.*"))
    
    {
        
     System.out.println("\nYou passed max length of companyname OR companyname must have only characters.");
     checker = false;
    
    }
    
    else
    
    {
        
    checker = true;
    
    }
    
    }

    System.out.println("\nInformation : " + companyname.toUpperCase());
        
    sql = "INSERT INTO Company (Companyname) VALUES (?);COMMIT;";
    
    try (Connection conn = getConnection(); java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) 
    
    {
        
    pstmt.setString(1, companyname.toUpperCase());
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
            
            sql = "SELECT COUNT(*) AS TotalRows FROM Company WHERE Id = ?;";

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
        
    System.out.print("\nGive me your companyname : ");
    companyname = input.nextLine();
    
    if(!(companyname.length() <= 50) || companyname.matches(".*\\d.*"))
    
    {
        
     System.out.println("\nYou passed max length of companyname OR companyname must have only characters.");
     checker = false;
    
    }
    
    else
    
    {
        
    checker = true;
    
    }
    
    }
 
    System.out.println("\nInformation : " + companyname.toUpperCase());
        
        sql = "UPDATE Company SET Companyname = ? WHERE Id = ?;COMMIT;";
        
        try (Connection conn = getConnection(); java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) 
        
        {
            pstmt.setString(1, companyname.toUpperCase());
            pstmt.setInt(2, id);
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

    sql = "DELETE FROM Company WHERE Id = ?;COMMIT;";
    
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
    
    sql = "CALL Company();";
    
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
            companyname = rs.getString("Companyname");
            System.out.println("Id : " + id +
                               ", Companyname : " + companyname);
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