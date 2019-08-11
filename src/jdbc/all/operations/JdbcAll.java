package jdbc.all.operations;
	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

	public class JdbcAll {

		public static void insert()
		{
			Scanner sc=new Scanner(System.in);
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/reservation?user=root&password=root");
				
				System.out.println("Enter pnr no-");
				int pnr=sc.nextInt();
				System.out.println("Enter the train number=");
			  	int trainNumber=sc.nextInt();
			  	//skip the newline
			  	sc.nextLine();
	    System.out.println("Enter train name=");
    	String trainName=sc.nextLine();
     	System.out.println("Enter date of journey= in dd-mm-yyyy");
    	String doj=sc.nextLine();
    	System.out.println("Enter the number of seat");
    	int seats=sc.nextInt();
    	//skip the newline 
    	sc.nextLine();
    	System.out.println("Station FROM=");
    	String stationFrom=sc.nextLine();
    	System.out.println("\nStation TO=");
    	String stationTo=sc.nextLine();
    	System.out.println("\nBoarding at=");
    	String boardingAt=sc.nextLine();
    	System.out.println("\nReservation upto=");
    	String reservationUpto=sc.nextLine();


				PreparedStatement ps=con.prepareStatement("insert into journey(pnr,train_number,train_name,doj,no_of_seat,from_station,to_station,booking_from,resv_upto) values (  ? , ? , ?  , ? , ? , ? , ? , ? , ? )");
				ps.setInt(1, pnr);
				ps.setInt(2, trainNumber);
				ps.setString(3, trainName);
				ps.setString(4, doj);
				ps.setInt(5, seats);
				ps.setString(6, stationFrom);
				ps.setString(7, stationTo);
				ps.setString(8, boardingAt);
				ps.setString(9, reservationUpto);
				int rs = ps.executeUpdate();
				System.out.println("Row number inserted==" +rs);
				
				
			}
			
	catch(Exception e)
			{
		e.printStackTrace();
			}
		}
	
		public static void delete()
		{
			Scanner sc=new Scanner(System.in);
			try
			{
			System.out.println("Enter the pnr number to delete recored-");
			String pnr=sc.nextLine();
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/reservation?user=root&password=root");
			PreparedStatement ps=con.prepareStatement("delete from journey where pnr=?");
			ps.setString(1, pnr);
			
			int rs=ps.executeUpdate();
			System.out.println("No. of record deleted=="+rs);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	
		public static void update()
		{
			Scanner sc=new Scanner(System.in);
			try
			{
				System.out.println("Enter the pnr number to update-");
				String pnr=sc.nextLine();
				System.out.println("Enter new DOJ--");
				String doj=sc.nextLine();
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/reservation?user=root&password=root");
				PreparedStatement ps=con.prepareStatement("update journey set doj= ? where pnr = ?");
				ps.setString(1, doj);
				ps.setString(2,pnr);
				
				int rs=ps.executeUpdate();
				System.out.println("No.of row updated==" + rs);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

		}
		
		public static void display()
		{
			try{  
				   Class.forName("com.mysql.jdbc.Driver");  
				   Connection con =DriverManager.getConnection("jdbc:mysql://localhost/reservation?user=root&password=root");  
				   Statement st= con.createStatement();  
				   ResultSet rs=st.executeQuery("select * from journey");  
				   System.out.println("Printing All Records of Journey:");
				   while(rs.next()){  
				    System.out.println(
				    		rs.getString("pnr") + ", "
				    		+ rs.getString(2) + ", "
				    		+ rs.getString(3) + ", "
				    		+ rs.getString(4) + ", "
				    		+ rs.getString(5) + ", "
				    		+ rs.getString(6) + ", "
				    		+ rs.getString(7) + ", "
				    		+ rs.getString(8) + ", "
				    		+ rs.getString(9) + ", "
				    		);  
				   }  
				  
				}catch(Exception ee){System.out.println(ee);}  
		}
	
		
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner sc=new Scanner(System.in);
		    while(true)
		    {
		    	System.out.println("Enter 1 to insert \nEnter 2 to delete\nEnter 3 to Update\nEnter 4 to Display all records\n");
		    	int choice=sc.nextInt();
		    	switch(choice)
		    	{
		    	case 1:
		    		insert();break;
		    	case 2:
		    		delete();break;
		    	case 3:
		    		update();break;
		    	case 4:
		    		display();break;
		    	
		    	}
		    }
			
		}

	}

	
