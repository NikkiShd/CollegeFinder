package com.valuemomentum.training4.CollegeFinder;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StudentPortal 
{
	Scanner sc = new Scanner(System.in);
	Connection con;
	Statement stmt;
	ResultSet rs;
	int pos=0;
	String str;

	StudentPortal() throws SQLException
	{
		con=DBConnection.getConnection();
		startPage();
	}

	void startPage()
	{
		while(true)
		{

			System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("|						    Welcome to Student's Portal			  			         |");
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
			System.out.print(">>1.Sign In                                              >>2.Sign Up                                                    >>0.Exit\n>> ");
			char c = sc.next().charAt(0);
			switch(c)
			{
			case '1' :
				boolean k2=loginCheckStudent();
				if(k2 == true)
				{
					studentStartPage();

				}//end if
				else
				{
					System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("\nIncorrect login Credentials / User Not Registered");
				}break;

			case '2' :regStudent(); break;

			case '0'  : 
				System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("\nThank you for Using College Finder! Have a Good Day!");  System.exit(0); break;

			default: 
				System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("\nInvalid Selection"); break; 

			}//end case B switch
		}//end case b while
	}

	private void studentStartPage() 
	{
		// TODO Auto-generated method stub
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
		System.out.print(">>1.Find your College                                    >>2.Manage Your Application                                    >>0.GoBack\n>>");
		char s=sc.next().charAt(0);
		switch(s)
		{
		case '1' : findyourCollege(); break;
		case '2' : manageApplication();break;
		case '0' : 
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("\nThank you for Using College Finder! Have a Good Day!"); System.out.println("You have Successfully Exited"); System.exit(0); break;
		default: 
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Invalid Selection");studentStartPage(); 
		}

	}

	public boolean loginCheckStudent() 
	{
		// TODO Auto-generated method stub
		boolean flag =false;
		while(true)
		{
			try
			{
				System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
				System.out.println(">>LOGIN PAGE\n");
				System.out.print("E-mail           : ");
				String str=sc.next();
				System.out.print("Password         : ");
				String str1=sc.next();
				con=DBConnection.getConnection();
				stmt=con.createStatement();
				rs = stmt.executeQuery("SELECT email_id , password FROM studentdetails");
				while(rs.next()) 
				{
					String name = rs.getString("email_id");
					String pass = rs.getString("password");

					if ((name.equals(str)) && (pass.equals(str1))) 
					{
						flag = true;
						System.out.println("\nYou have succesfully Logged In!");break;
					}//end if
				}//end while 
				rs.close();
				if(!flag)
				{
					System.out.println("Please enter valid Login Credentials");
				}
			} catch (Exception sql) { System.out.println(sql); }
			return flag;
		}
	}//end login student

	public void regStudent() 
	{
		// TODO Auto-generated method stub
		String email1="@gmail.com",email2="@yahoo.com";
		try
		{
			Connection con=DBConnection.getConnection();
			String sql="insert into studentdetails"+
					"(first_name,last_name, PASSWORD,email_id,mobile_number,gender,dob)"+
					"values(?,?,?,?,?,?,?)";
			stmt=con.createStatement();
			PreparedStatement pstmt=con.prepareStatement(sql);
			System.out.println("   ______________________________________________________________________________________________________________________________");
			System.out.println("==O______________________________________________________________________________________________________________________________O==");
			System.out.println("  |        	                       PROFESSIONAL COLLEGE MANAGEMENT SYSTEM- COLLEGE FINDER !            	                 |");
			System.out.println("  |                                    You have come to the best place to find your College!                                     |");
			System.out.println("  |                                        You are *register* away in finding Your College!                                      |");
			System.out.println("  |______________________________________________________________________________________________________________________________| ");

			System.out.println("\n>> SIGN UP : Fill in the Detils for User Registration\n");
			System.out.print("First Name        : ");
			String fname=sc.next();
			System.out.print("Last Name         : ");
			String lname=sc.next();

			while(true)
			{
				System.out.print("Gender (m/f)      : ");
				String gender=sc.next();
				if((gender.equals("m"))||(gender.equals("f")))
				{
					pstmt.setString(6, gender);
					break;
				}
				else
				{
					System.out.println("Invalid Input");
				}
			}
			while(true)
			{
				System.out.print("DOB (YYYY-MM-DD)  : ");
				String dob=sc.next();
				if(dob.length()==10)
				{
					boolean k1 = dobAvail(dob);
					if(k1 == true)
					{
						pstmt.setString(7, dob);
						break;
					}
					else
					{
						System.out.println("Enter valid Date of Birth");
					}
				}
				else
				{
					System.out.println("Enter Valid DOB in YYYY-MM-DD");
				}
			}
			while(true)
			{
				System.out.print("Mobile Number     : ");
				String mobile=sc.next();
				boolean k=phnoval(mobile);
				if(k==false)
				{
					//System.out.println("inside if");
					System.out.println("Enter valid Mobile Number");
				}
				else 
				{ 
					//System.out.println("inside else");
					pstmt.setString(5, mobile);break;}
			}

			while(true) 
			{
				System.out.print("E-mail            : ");
				String email=sc.next();
				for(int i=1;i<=email.length();i++)
				{
					char ch=email.charAt(i);
					if(ch=='@') 
					{
						pos=i;
						str=email.substring(pos,email.length());
						break;
					}

				}   
				if((str.equals(email1))||(str.equals(email2))) 
				{
					//input for database
					pstmt.setString(4,email);
					System.out.println("☑");
					break;
				}
				else 
				{
					System.out.println("Please enter a valid e-mail");
					email=" ";
				}

			}//end while
			while(true)
			{
				System.out.print("Password(8 char)  : ");
				String pass=sc.next();

				if(pass.length()==8) 
				{
					pstmt.setString(3,pass);
					//input for database
					System.out.println("☑");
					break;
				}
				else {
					System.out.println("Password can be atmost 8 characters long.");
					pass=" ";
				}
			}

			pstmt.setString(1,fname);
			pstmt.setString(2,lname);
			pstmt.executeUpdate();	
			System.out.println("User Registered Successfully !");
		}catch(Exception e) { System.out.println(e); }
	}

	private boolean dobAvail(String d1)
	{
		boolean status = false;
		if (checkDate(d1)) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
			dateFormat.setLenient(false);
			try {
				dateFormat.parse(d1);
				status = true;
			} catch (Exception e) {
				status = false;
			}
		}
		return status;
	}

	static boolean checkDate(String date) {
		String pattern = "([0-9]{4})\\-(0?[1-9]|1[0-2])\\-(0?[1-9]|[12][0-9]|3[01])";
		boolean flag = false;
		if (date.matches(pattern)) {
			flag = true;
		}
		return flag;
	}
	private boolean phnoval(String phno) 
	{ 
		Pattern p=Pattern.compile("(91)?[7-9][0-9]{9}");
		Pattern p1=Pattern.compile("(0)?[7-9][0-9]{9}");

		Matcher m=p.matcher(phno);
		Matcher m1=p1.matcher(phno);

		if ( ( m.find()&& m.group().equals(phno) ==true )|| (m1.find() && m1.group().equals(phno)==true) )
			return true;
		else return false;
		//return((m.find() && m.group().equals(phno)) OR (m1.find() && m1.group().equals(phno)) ) ;
	}


	public void findyourCollege() 
	{
		while(true) {
			// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
			System.out.println(">>Select the Stream in which you want search for colleges:\n");
			System.out.print(">>E.Engineering                                          >>M.Medical                                                    >>I.GoBack\n>>");
			char ch = sc.next().charAt(0);
			switch(ch)
			{
			case 'E' : 
				enggDetails();
				while(true)
				{
					System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
					System.out.print(">>1.Apply Now        					 >>0.GoBack    \n>> ");
					int op2=sc.nextInt();
					switch(op2)
					{
					case 1:  apply();			break;
					case 0:  findyourCollege(); break; 
					default: 
						System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
						System.out.println("\nInvalid Selection");break;
					}
				}
			case 'M' :
				medDetails();
				while(true)
				{
					System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
					System.out.print(">>1.Apply Now        					 >>0.GoBack    \n>> ");
					int op1=sc.nextInt();
					switch(op1)
					{
					case 1: apply(); break;
					case 0: findyourCollege(); break;
					default:
						System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
						System.out.println("\nInvalid Selection"); break;
					}
				}
			case 'I' : studentStartPage(); break;
			default  :
				System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("\nInvalid Selection"); break;
			} //end switch(ch)
		}//end while
	}//end method fyc

	private void enggDetails() 
	{
		try 
		{
			while(true)
			{

				con=DBConnection.getConnection();
				Statement stmt = con.createStatement();

				// System.out.println("Enter your State prefrence among the following:\n>>");
				System.out.print("State: ");
				String sqlm="Select distinct college_state from colleges where college_stream='Engineering' ";
				rs=stmt.executeQuery(sqlm);
				while(rs.next())
				{
					System.out.print(">>"+rs.getString(1)+" ");
				}
				System.out.print("\nEnter your State preference \n>>");
				Scanner sc3=new Scanner(System.in);  
				String state=sc3.nextLine();

				String sqln="Select count(*) from colleges where college_stream='Engineering' and college_state= '"+state+"' ;";
				rs=stmt.executeQuery(sqln);
				rs.next();
				int count=rs.getInt(1);

				if(count==0)
				{
					System.out.println("Enter valid state");
					enggDetails();
					break;

				}
				else 
				{
					rs=stmt.executeQuery("Select * from colleges where college_stream='Engineering' and college_state= '" +state+"'  ;");
					System.out.println("Engineering Colleges in "+state);
					System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("|C-ID    COLLEGE NAME                                                 CITY            STATE           BRANCH        RANK  CUTOFF|");
					System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
					while(rs.next())
					{
						System.out.printf("|%-7d %-60s %-15s %-15s %-15s %-4d %-4d |%n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7));
					}
					System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
					break;
				}//end else
			}//end while
		}catch (Exception e) {  e.printStackTrace(); } 

	}//end engg details

	public void medDetails() 
	{
		try 
		{
			while(true)
			{
				con=DBConnection.getConnection();
				Statement stmt = con.createStatement();

				System.out.print("State: ");
				String sqlm="Select distinct college_state from colleges where college_stream='Medical' ";
				rs=stmt.executeQuery(sqlm);
				while(rs.next())
				{
					System.out.print(">>"+rs.getString(1)+" ");
				}
				System.out.print("\nEnter your State preference \n>>");
				Scanner sc3=new Scanner(System.in);  
				String state=sc3.nextLine();


				String sqln="Select count(*) from colleges where college_stream='Medical' and college_state= '"+state+"' ;";
				rs=stmt.executeQuery(sqln);
				rs.next();
				int count=rs.getInt(1);

				if(count==0)
				{
					System.out.println("Enter valid state"); 
					medDetails(); break;

				}
				else 
				{
					//Statement stmt1 = con.createStatement();
					rs=stmt.executeQuery("Select * from colleges where college_stream='Medical' and college_state= '" +state+"'  ;");
					System.out.println("Engineering Colleges in "+state);
					System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("|C-ID    COLLEGE NAME                                                 CITY            STATE           BRANCH        RANK  CUTOFF|");
					System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
					while(rs.next())
					{
						System.out.printf("|%-7d %-60s %-15s %-15s %-15s %-4d %-4d |%n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7));
					}
					System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
					break;
				}
			}
		}catch (Exception e) {  e.printStackTrace(); } 
	}


	public void apply() 
	{
		Scanner sc = new Scanner(System.in);
		Connection con;
		Statement stmt;
		ResultSet rs;
		int  sid=0;
		try {
			con=DBConnection.getConnection();
			stmt=con.createStatement();
			System.out.print("Enter Id of the college you wish to Apply for:\n>>");
			int cid=sc.nextInt();
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("|C-ID    COLLEGE NAME                                                 CITY            STATE           BRANCH        RANK  CUTOFF|");
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
			ResultSet  rs1=stmt.executeQuery("Select * from colleges where college_id= '"+cid+"' ");
			while(rs1.next()) 
			{
				System.out.printf("|%-7d %-60s %-15s %-15s %-15s %-4d %-4d |%n",rs1.getInt(1),rs1.getString(2),rs1.getString(3),rs1.getString(4),rs1.getString(5),rs1.getInt(6),rs1.getInt(7));
			}
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------");

			System.out.print(">>1.Apply for above selected college                     >>2.Reselect                                                   >>0.GoBack\n>>");
			char ch=sc.next().charAt(0);
			switch(ch) {
			case '1' :try 
			{

				System.out.println("  _______________________________________________________________________________________________________________________________");
				System.out.println("==O______________________________________________________________________________________________________________________________O==");
				System.out.println("  |        	                              PROFESSIONAL COLLEGE MANAGEMENT SYSTEM 	                  	                 |");
				System.out.println("  |                                                       COLLEGE FINDER !                                                       |");
				System.out.println("  |                                 You are *Apply* away to get Admission in the best fit College!                               |");
				System.out.println("  |______________________________________________________________________________________________________________________________| ");

				String sql1="INSERT INTO application_details(application_sid,application_cid,first_name,last_name,email_id,House_Number,Street_name,city,state,zipcode,school_name,school_GPA,student_rank,STATUS) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement a1=con.prepareStatement(sql1);

				System.out.println(">> APPLICATION PORTAL : Fill in the Detils for procession your Application\n");
				System.out.println("PERSONAL DETAILS");
				System.out.print("First Name        : ");

				String firstname=sc.next();
				System.out.print("Last Name         : ");
				String lastname=sc.next();

				while(true)
				{
					System.out.print("Gender (m/f)      : ");
					String gender=sc.next();
					if((gender.equals("m"))||(gender.equals("f")))
					{
						break;
					}
					else
					{
						System.out.println("Invalid Input");
					}
				}
				while(true)
				{
					System.out.print("DOB(YYYY-MM-DD)   : ");
					String dob=sc.next();
					String s1 =dob.substring(6,9);
					boolean k1 = dobAvail(dob);
					if(k1 == true)
					{
						break;
					}
					else
					{
						System.out.println("Enter valid Date of Birth");
					}
				}

				System.out.println("\nCONTACT DETAILS");
				try 
				{

					// Email Id 
					while(true)
					{

						System.out.print("E-mail            : ");
						String email=sc.next();
						String email1="@gmail.com",email2="@yahoo.com";

						for(int i=1;i<=email.length();i++)
						{
							char ch1=email.charAt(i);
							if(ch1=='@') 
							{
								pos=i;
								str=email.substring(pos,email.length());
								break;
							}

						}   
						if((str.equals(email1))||(str.equals(email2))) 
						{
							//input for database
							con=DBConnection.getConnection();
							Statement stmt1 = con.createStatement();
							String sqle="SELECT count(email_id) FROM studentdetails where email_id='"+email+"';";
							rs=stmt1.executeQuery(sqle);
							rs.next();
							int count=rs.getInt(1);
							if(count==0)
							{ System.out.println("Enter valid email");}
							else 
							{ System.out.println("☑");
							a1.setString(5,email);
							Statement stmti=con.createStatement();
							ResultSet rsi=stmti.executeQuery("Select student_id from studentdetails where email_id= '"+email+"' ");
							while(rsi.next() ) {
								sid=rsi.getInt(1);
							}

							break; }

						}
						else 
						{
							System.out.println("Please enter a valid e-mail");
							email=" ";
						}

					}//end while

				}
				catch (Exception e)
				{  
					e.printStackTrace();
				} 

				while(true)
				{
					System.out.print("Mobile Number     : ");
					String mobile=sc.next();
					boolean k=phnoval(mobile);
					if(k==false)
					{
						//System.out.println("inside if");
						System.out.println("Enter valid Mobile Number");
					}
					else 
					{ 
						//System.out.println("inside else");
						//a1.setString(5, mobile);
						break;
					}
				}

				Scanner sc1 = new Scanner(System.in);

				System.out.println("\nAddress");
				System.out.print("House Number      : ");
				int houseno=sc1.nextInt();
				Scanner sc4 = new Scanner(System.in);
				System.out.print("Street            : ");
				String streetname=sc4.next();
				System.out.print("City/Town         : ");
				String city=sc.next();

				Scanner sc2 = new Scanner(System.in);
				System.out.print("State             : ");
				String state=sc2.next();

				while(true)
				{
					System.out.print("Pincode           : ");
					long zipcode=sc.nextInt();
					int c=0;
					long num = zipcode;
					while(num > 0)
					{
						long d = num % 10;
						c = c + 1;
						num = num / 10;
					}
					if(c == 6)
					{
						a1.setLong(10,zipcode);
						break;
					}
					else
					{
						System.out.println("Invalid Pincode");
						zipcode = 0;
					}
				}


				System.out.println("\nHIGHEST EDUCATION DETAILS");
				Scanner sc5 = new Scanner(System.in);
				System.out.println("School(12/equivalent)");
				System.out.print("School Name       : ");
				String school=sc5.nextLine();

				while(true)
				{
					Scanner sc3 = new Scanner(System.in);
					System.out.print("School CGPA       : ");
					float cgpa=sc3.nextFloat();
					if((cgpa>=5.0)&&(cgpa<=10.0))
					{
						a1.setFloat(12,cgpa);
						break;
					}
					else
					{
						System.out.println("Enter Valid CGPA!!");
					}
				}

				while(true)
				{

					System.out.println("Entrance Exam ");
					System.out.print("Exam Rank         : ");

					int rank=sc.nextInt();

					if((rank >= 1)&&(rank <= 10000))
					{
						a1.setInt(13, rank);
						break;
					}
					else
					{
						System.out.println("Enter Valid Rank");
					}
				}


				a1.setInt(1,sid);
				a1.setInt(2,cid);
				a1.setString(3,firstname);
				a1.setString(4,lastname);
				a1.setInt(6,houseno);
				a1.setString(7,streetname);
				a1.setString(8,city);
				a1.setString(9,state);
				a1.setString(11,school);
				a1.setString(14,"pending");

				a1.executeUpdate();

				System.out.println("\nYour Application is submitted succesfully!");

				Statement stmt1= con.createStatement();
				String sqln="Select application_id from application_details where application_sid='"+sid+"'";
				ResultSet rss=stmt1.executeQuery(sqln);
				rss.next();
				System.out.println("Your Application ID : "+rss.getInt(1)+" (Please remember for further use.)\n");
				checkStatus();
				break;
			}catch(Exception e) {System.out.println(e);}//end try catch

			case 2: apply();break;

			case 0:findyourCollege(); break;	

			default: System.out.println("Invalid Selection"); break;
			}//end switch
		}catch(Exception e) {System.out.println(e); }

	}//end apply

	private void checkStatus() {
		// TODO Auto-generated method stub
		System.out.print(">>1.Check Status					 >>0.GoBack\n>>");
		char cs=sc.next().charAt(0);
		switch(cs)
		{
		case '1': manageApplication();break;

		case '0': apply();		  break;

		default:
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("\nInvalid Selection");break;
		}

	}

	public void manageApplication() 
	{
		while(true) 
		{
			try 
			{

				System.out.print(">>Application ID: \n>>");
				int aid=sc.nextInt();
				Statement stmt11 = con.createStatement();
				String sqlm="Select status from application_details where application_id='"+aid+"'";
				ResultSet rss=stmt11.executeQuery(sqlm);
				rss.next();
				System.out.println("Status of Application "+aid+" is "+rss.getString(1));
				break;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Invalid");
				//e.printStackTrace();
			}
		}
	}

}//end class
