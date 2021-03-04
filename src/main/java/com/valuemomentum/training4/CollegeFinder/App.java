package com.valuemomentum.training4.CollegeFinder;

import java.sql.*;
import java.util.*;

public class App 
{
	public static void main( String[] args ) throws SQLException
	{
		System.out.println("  _    _                                                                                              _    _           _    _ ");
		System.out.println("_| |__| |____________________________________________________________________________________________| |__| |_________| |__| |____");
		System.out.println("|        				                 COLLEGE FINDER       			                 	          |");
		System.out.println("|  _    _    _    _    _    _    _            PROGESSIONAL COLLEGE MANAGEMENT SYSTEM 	           _   _   _   _   _   _    _     |");
		System.out.println("| |_|  |_|  |_|  |_|  |_|  |_|  |_|    ______________________________________________________     |_| |_| |_| |_| |_| |_|  |_|    |");
		System.out.println("|				      ||           GATEWAY TO FIND YOUR COLLEGE            ||	                  	          |");
		System.out.println("|_____________________________________||___||_________________________________________||___||_____________________________________| \n");  
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.print("\r\n"
					+ ">>A.Admin Login                               	         >>B.Student Login           				      >> C.Exit\n>>");

			char option=sc.next().charAt(0);

			switch(option)
			{
			case 'A': AdminPortal obj = new AdminPortal(); break;

			case 'B': StudentPortal obj1 = new StudentPortal(); break;

			case 'C': System.out.println("\nThank you for Using College Finder! Have a Good Day!");  System.exit(0); break;

			default : System.out.println("\nInvalid Selection");break;
			}//end switch
		}// end while
	}//end main
}//end class
