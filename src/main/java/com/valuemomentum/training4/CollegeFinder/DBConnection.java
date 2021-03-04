package com.valuemomentum.training4.CollegeFinder;

import java.sql.*;

public class DBConnection 
{
	static Connection con;
    public static Connection getConnection() 
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college_finder","root","98765");
            return con;
        }
        catch(Exception e) 
        {
            System.out.println(e);
            return null;
        }
    }
    public void closeConnection()throws SQLException
    {
        con.close();
    }

    
}


