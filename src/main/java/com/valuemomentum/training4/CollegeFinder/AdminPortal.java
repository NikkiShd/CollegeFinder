package com.valuemomentum.training4.CollegeFinder;

import java.sql.*;
import java.util.*;

public class AdminPortal 
{
	Scanner sc = new Scanner(System.in);
	Connection con;
	Statement stmt;
	ResultSet rs,rs2,rs1,rs3;

	AdminPortal() throws SQLException
	{
		con=DBConnection.getConnection();
		startPage();
	}

	private void startPage() 
	{
		// TODO Auto-generated method stub
		int k1=loginCheck();
		if(k1 == 1)
		{
			adminStartPage();
		}//end if
		else { 
			System.out.println("INCORRECT Username/Password");startPage();
		}

	}

	public int loginCheck() 
	{
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
		System.out.print(">> LOGIN PAGE \n\n");
		System.out.print("USER NAME : ");
		String str=sc.next();
		System.out.print("PASSWORD  : ");
		String str1=sc.next();
		if(str.equals("admin") && str1.equals("admin") )
		{System.out.println(); return 1;}
		else
		{System.out.println(); return 0; }
	}

	private void adminStartPage() 
	{
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("|						     Welcome to Admin's Portal							 |");
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
		System.out.print(">>1.Manage Colleges 	     				 >>2.Manage Application                                       >> 0. Exit\n>> ");
		char ch=sc.next().charAt(0);
		switch(ch)
		{
		// CASE FOR MANAGING THE COLLEGES
		case '1': manageColleges(); 		break;

		// CASE FOR MANAGING APPLICATIONS
		case '2': manageApplications(); 	break;

		case '0': 
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("\nThank you for Using College Finder! Have a Good Day!"); System.exit(0); break;

		default: 
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Invalid Selection");adminStartPage();break; 
		}//end case A switch	
	}


	public void manageColleges() 
	{
		while(true) {
			// TODO Auto-generated method stub
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
			System.out.print(">>1.Display College      >>2. Add College                >>3.Modify College             >> 4. Delete College          >>0.GoBack \n>>");
			char m=sc.next().charAt(0);
			switch(m)
			{
			case '1' : dispCollege();	 	break;
			case '2' : addCollege(); 		break;
			case '3' : modCollege(); 		break;
			case '4' : delCollege(); 		break;
			case '0' : adminStartPage(); 	break;
			default: 
				System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("\nInvalid Selection"); break;
			}
		}
	}

	public void manageApplications() 
	{
		while(true) 
		{
			// TODO Auto-generated method stub
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
			System.out.println(">>1.Display Applications				 >>2.Update Pending Applications  ");
			System.out.print(">>3.View Approved Applications                           >>4.View Rejected Applications	  			      >>0.GoBack\n>>");
			char a=sc.next().charAt(0);
			switch(a)
			{
			case '1' : dispAppl(); 			break;
			case '2' : updatePendingAppl();   break;
			case '3' : viewApprovedAppl(); 	break;
			case '4' : viewRejAppl(); 		break;
			case '0' : adminStartPage(); 		break;
			default: 
				System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("\nInvalid Selection"); break;
			}
		}
	}

	private void dispCollege() 
	{
		try 
		{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from colleges");
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("|C-ID    COLLEGE NAME                                                 CITY            STATE           BRANCH        RANK  CUTOFF|");
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
			while(rs.next())
			{
				System.out.printf("|%-7d %-60s %-15s %-15s %-15s %-4d %-4d |%n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7));
			}
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
		}
		catch(Exception e) {e.printStackTrace();}
	}

	private void addCollege() 
	{
		String sql_insert="Insert into Colleges(college_name,college_city, college_state, college_stream, college_rank, cutoff_rank) values(?,?,?,?,?,?)";
		try
		{
			Scanner sc2=new Scanner(System.in);
			con=DBConnection.getConnection();
			Statement stmt = con.createStatement();
			PreparedStatement ps=con.prepareStatement(sql_insert);
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
			System.out.println(">> ADD College : Fill in the Detils of New College for Registration \n");
			System.out.print("College Name      	    : ");
			String cn=sc2.nextLine();
			System.out.print("City             	    : ");
			String ccity=sc2.nextLine();
			System.out.print("State                       : ");
			String cstate=sc2.nextLine();
			System.out.print("Stream(Engineering/Medical) : ");
			String cstream=sc2.nextLine();
			System.out.print("Rank (On scale of 1-5) 	    : ");
			int crank=sc2.nextInt();
			System.out.print("Cut-Off Rank		    : ");
			int ccutoff=sc2.nextInt();

			ps.setString(1, cn);
			ps.setString(4, cstream);
			ps.setString(2, ccity);
			ps.setString(3, cstate);
			ps.setInt(5, crank);
			ps.setInt(6, ccutoff);

			int row=ps.executeUpdate();
			System.out.println("\nCollege Added Succesfully!");
		}
		catch(Exception e) {e.printStackTrace(); }

	}

	private void modCollege() 
	{
		while(true)
		{
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
			System.out.print(">>1.Modify College Rank   				 >>2.Modify Cut-Off 				              >>0.GoBack\n>>" );
			char a=sc.next().charAt(0);
			Statement stmt;
			switch(a) 
			{ 
			case '1':    
				try 
				{
					while(true)
					{
						con=DBConnection.getConnection();
						stmt=con.createStatement();
						System.out.print(">> Enter the ID of College whose Rank is to be Modified \n>>");
						int id=sc.nextInt();

						String sqln="Select count(*) from colleges where college_id= '"+id+"'";
						rs=stmt.executeQuery(sqln);
						rs.next();
						int count=rs.getInt(1);
						if(count==0)
						{
							System.out.println("\nInvalid College ID\n ");
						}
						else 
						{            
							String sql="UPDATE colleges " + "SET college_rank= ?  " + " WHERE college_id=?";
							System.out.print(">>Enter the new college rank\n>>");
							int rank=sc.nextInt();
							PreparedStatement mod=con.prepareStatement(sql);
							mod.setInt(1,rank);
							mod.setInt(2, id);
							mod.executeUpdate();
							System.out.println("\nCollege rank is modified !");
							break;
						}
					}
				}catch(Exception e) { e.printStackTrace(); }
				break;

			case '2' :  
				try 
				{
					while(true)
					{
						con=DBConnection.getConnection();
						stmt=con.createStatement();
						System.out.print(">> Enter the ID of College whose CutOff is to be Modified \n>>");
						int id=sc.nextInt();

						String sqln="Select count(*) from colleges where college_id= '"+id+"'";
						rs=stmt.executeQuery(sqln);
						rs.next();
						int count=rs.getInt(1);
						if(count==0)
						{
							System.out.println("\nInvalid College ID\n");
						}
						else 
						{ 

							String sql="UPDATE colleges "+ "SET cutoff_rank=?  "+" WHERE college_id=?";
							System.out.print(">>Enter the new cutoff rank\n>>");
							int cutoff=sc.nextInt();
							PreparedStatement mod=con.prepareStatement(sql);
							mod.setInt(1,cutoff);
							mod.setInt(2, id);
							mod.executeUpdate();
							System.out.println("\nCutoff rank is modified !");
							break;
						}
					}
				}catch(Exception e) {e.printStackTrace();  }
				break;
			case '0' : manageColleges(); break;

			default: System.out.println("Invalid choice");break;   
			}
		}//end while
	}

	private void delCollege() 
	{
		try
		{
			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			System.out.print(">>Enter College Id of the college to be deleted\n>>");
			Scanner sc=new Scanner(System.in);
			int id=sc.nextInt();
			String sql="Delete from colleges where college_id='"+id+"' ";
			int cnt = stmt.executeUpdate(sql);
			if(cnt>0) 
			{
				System.out.println("Record for CollegeID: "+ id +" is deleted. ");
			}
			else
			{
				System.out.println("There is no such College Id in database. Please re-enter");
				delCollege();
			}
			con.close();

		}
		catch(Exception e) { e.printStackTrace();}
	}

	private void dispAppl() 
	{
		try 
		{
			String sql="SELECT a.application_id, a.application_sid, a.application_cid , a.student_rank, c.cutoff_rank"
					+ " FROM application_details a INNER JOIN colleges c"
					+ " ON a.application_cid=c.college_id";
			stmt=con.createStatement();
			rs=stmt.executeQuery("Select * from application_details");
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("|AID SID CID FIRSTNAME  LASTNAME     EMAIL               HNo. ST.  CITY         STATE         PINCODE SCHOOLNAME           GPA   RANK  STATUS |");
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
			while(rs.next()) 
			{	
				System.out.printf( "|%-3d %-3d %-3d %-10s %-12s %-20s %-4d %-4s %-12s %-13s %-7d %-20s %-4d %-4d %-8s|%n",rs.getInt(1),+rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getInt(11),rs.getString(12),rs.getInt(13),rs.getInt(14),rs.getString(15));
			}
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
		}
		catch(Exception e) { e.printStackTrace(); }
	}//end dispappl

	private void updatePendingAppl() 
	{
		try 
		{
			stmt=con.createStatement();
			String sqln="Select count(*) from application_details where status='Pending'";
			rs=stmt.executeQuery(sqln);
			rs.next();
			int count=rs.getInt(1);
			if(count>0)
			{	
				rs1=stmt.executeQuery("Select * from application_details where status='Pending'");
				System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("|AID SID CID FIRSTNAME  LASTNAME     EMAIL               HNo. ST.  CITY         STATE         PINCODE SCHOOLNAME           GPA   RANK  STATUS |");
				System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
				while(rs1.next()) 
				{	
					System.out.printf( "|%-3d %-3d %-3d %-10s %-12s %-20s %-4d %-4s %-12s %-13s %-7d %-20s %-4d %-4d %-8s|%n",rs1.getInt(1),+rs1.getInt(2),rs1.getInt(3),rs1.getString(4),rs1.getString(5),rs1.getString(6),rs1.getInt(7),rs1.getString(8),rs1.getString(9),rs1.getString(10),rs1.getInt(11),rs1.getString(12),rs1.getInt(13),rs1.getInt(14),rs1.getString(15));
				}
				System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
			}
			else {
				System.out.println("Up-to-Date! No Pending Applications");
			}


			try {

				while(true) {

					Statement stmt1=con.createStatement();
					System.out.print(">>Select the Application Id of which you want to change status\n>>");
					int id=sc.nextInt();	
					String sql3="Select count(*) from application_details where application_id='"+id+"'";
					rs3=stmt1.executeQuery(sql3);
					rs3.next();
					int count1=rs3.getInt(1);
					if(count1==0) {
						System.out.println("Invalid  Id");
					}
					else {
						//Modifying application
						String sql="SELECT a.application_id, a.application_sid, a.application_cid , a.student_rank, c.cutoff_rank"
								+ " FROM application_details a INNER JOIN colleges c"
								+ " ON a.application_cid=c.college_id";

						rs2=stmt.executeQuery(sql);
						int srank = 0;
						int cutoff = 0;
						while(rs2.next())
						{
							srank=rs2.getInt(4);
							cutoff=rs2.getInt(5);				
						}

						if(srank<=cutoff) 
						{
							String sql2="Update application_details set status='Approved' where application_id= '"+id+"'";
							PreparedStatement a1=con.prepareStatement(sql2);
							a1.executeUpdate();
							System.out.println("Status Updated");
							break;
						}
						else 
						{
							String sql2="Update application_details set status='Rejected' where application_id= '"+id+"'";
							PreparedStatement a1=con.prepareStatement(sql2);
							a1.executeUpdate();
							System.out.println("Status Updated");
							break;
						}


					}
				}//end while
			}
			catch(Exception e) {e.printStackTrace();}
		}
		catch(Exception e){e.printStackTrace(); }
	}//endupdatepending app


	private void viewApprovedAppl() 
	{
		try 
		{
			stmt=con.createStatement();
			String sqln="Select count(*) from application_details where status='Approved'";
			rs=stmt.executeQuery(sqln);
			rs.next();
			int count=rs.getInt(1);
			if(count>0)
			{	
				String sql1= "Select * from application_details where status='Approved'";
				rs3=stmt.executeQuery(sql1);
				System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("|AID SID CID FIRSTNAME  LASTNAME     EMAIL               HNo. ST.  CITY         STATE         PINCODE SCHOOLNAME           GPA   RANK  STATUS |");
				System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
				while(rs3.next()) 
				{	
					System.out.printf( "|%-3d %-3d %-3d %-10s %-12s %-20s %-4d %-4s %-12s %-13s %-7d %-20s %-4d %-4d %-8s|%n",rs3.getInt(1),+rs3.getInt(2),rs3.getInt(3),rs3.getString(4),rs3.getString(5),rs3.getString(6),rs3.getInt(7),rs3.getString(8),rs3.getString(9),rs3.getString(10),rs3.getInt(11),rs3.getString(12),rs3.getInt(13),rs3.getInt(14),rs3.getString(15));
				}
				System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
			}else {System.out.println(" No Approved Applications !");}
		} catch(Exception e){e.printStackTrace();}
	}//end viewappl


	private void viewRejAppl() 
	{
		try 
		{
			stmt=con.createStatement();
			String sqln="Select count(*) from application_details where status='Rejected'";
			rs=stmt.executeQuery(sqln);
			rs.next();
			int count=rs.getInt(1);
			if(count>0)
			{	
				String sql= "Select * from application_details where status='Rejected'";
				rs1=stmt.executeQuery(sql);
				System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("|AID SID CID FIRSTNAME  LASTNAME     EMAIL               HNo. ST.  CITY         STATE         PINCODE SCHOOLNAME           GPA   RANK  STATUS |");
				System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
				while(rs1.next()) 
				{	
					System.out.printf( "|%-3d %-3d %-3d %-10s %-12s %-20s %-4d %-4s %-12s %-13s %-7d %-20s %-4d %-4d %-8s|%n",rs1.getInt(1),+rs1.getInt(2),rs1.getInt(3),rs1.getString(4),rs1.getString(5),rs1.getString(6),rs1.getInt(7),rs1.getString(8),rs1.getString(9),rs1.getString(10),rs1.getInt(11),rs1.getString(12),rs1.getInt(13),rs1.getInt(14),rs1.getString(15));
				}
				System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
			}else {System.out.println(" No Rejected Applications !");}
		}
		catch(Exception e) {e.printStackTrace();}
	}//end viewRej
}


