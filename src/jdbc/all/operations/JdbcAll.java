package jdbc.all.operations;

import java.io.PrintStream;
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

	public static void insertPassenger(int numberOfPassengers,int pnr)
	{
		Scanner sc=new Scanner(System.in);
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/reservation?user=root&password=root");
           
			//System.out.println("Enter pnr no-");
			//int pnr=sc.nextInt();
			//System.out.println("Enter the number of passengers=");
			//int noOfPassengers=sc.nextInt();
			//skip the newline
			//sc.nextLine();
			for(int i=0;i<numberOfPassengers;i++)
			{
				
			int serialNumber=i+1;
			System.out.println("Enter name of the passenger=");
			String name=sc.nextLine();
			System.out.println("Enter gender M/F=");
			String sex=sc.nextLine();
			System.out.println("Enter the age=");
			int age=sc.nextInt();
			//skip the newline 
			sc.nextLine();
			System.out.println("Concession number=");
			int concession=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter seat preference(UPPER/LOWER)=");
			String seat=sc.nextLine();
			sc.nextLine();
			System.out.println("Enter food preference(VEG/NON-VEG)=");
			String food=sc.nextLine();
			sc.nextLine();

			PreparedStatement ps=con.prepareStatement("insert into passenger(serial_numb,name,sex,age,concession,seat_pref,food_pref,pnr) values (  ? , ? , ?  , ? , ? , ? , ? , ?  )");
			ps.setInt(1, serialNumber);
			ps.setString(2, name);
			ps.setString(3, sex);
			ps.setInt(4, age);
			ps.setInt(5, concession);
			ps.setString(6, seat);
			ps.setString(7, food);
			ps.setInt(8, pnr);
			int rs = ps.executeUpdate();
			System.out.println("Row number inserted in passenger table==" +rs);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	public static void insertJourney()
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
			insertPassenger(seats,pnr);

		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void deleteJourney()
	{
		Scanner sc=new Scanner(System.in);
		try
		{
			System.out.println("Enter the pnr number to delete recored-");
			String pnr=sc.nextLine();

			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/reservation?user=root&password=root");
			PreparedStatement ps1=con.prepareStatement("delete from passenger where pnr=?");
			PreparedStatement ps=con.prepareStatement("delete from journey where pnr=?");
			ps1.setString(1, pnr);
			ps.setString(1, pnr);
			int rs1=ps1.executeUpdate();
			System.out.println("No. of record deleted from passenger table=="+rs1);
			int rs=ps.executeUpdate();
			System.out.println("No. of record deleted from journey table=="+rs);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void deletePassenger()
	{
		Scanner sc=new Scanner(System.in);
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/reservation?user=root&password=root");
			
			System.out.println("Enter the number of passengers that you want to delete=");
			int noOfPassenger=sc.nextInt();
			sc.nextLine();
			for(int i=0;i<noOfPassenger;i++)
			{
			System.out.println("Enter the pnr number to delete record-");
			String pnr=sc.nextLine();
			System.out.println("Enter the name of the passenger-");
			String name=sc.nextLine();
			System.out.println("Emter the age of passenger-");
			int age=sc.nextInt();
			PreparedStatement ps=con.prepareStatement("delete from passenger where pnr=? and name= ? and age = ? ");
			ps.setString(1, pnr);
			ps.setString(2,name);
			ps.setInt(3, age);
			int rs=ps.executeUpdate();
			System.out.println("No. of record deleted from journey table=="+rs);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	public static void updateJourney()
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

	public static void displayJourney()
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
public static void displayPassengers()
{
	try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost/reservation?user=root&password=root");  
		Statement st= con.createStatement();  
		ResultSet rs=st.executeQuery("select * from passenger");  
		System.out.println("Printing All Records of Passenger:");
		while(rs.next()){  
			System.out.println(
					rs.getString(1) + ", "
							+ rs.getString(2) + ", "
							+ rs.getString(3) + ", "
							+ rs.getString(4) + ", "
							+ rs.getString(5) + ", "
							+ rs.getString(6) + ", "
							+ rs.getString(7) + ", "
							+ rs.getString(8) + ", "
					);  
		}  

	}catch(Exception ee){System.out.println(ee);} 

}

public static void displayPnrRecord()
{ Scanner sc=new Scanner(System.in);
	try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost/reservation?user=root&password=root");  
		PreparedStatement ps= con.prepareStatement("select * from passenger inner join journey on passenger.pnr=journey.pnr where journey.pnr= ? "); 
		System.out.println("Enter pnr to display all the records");
		int pnr=sc.nextInt();
		ps.setInt(1, pnr);
		
		/*
		 * PreparedStatement ps=con.prepareStatement("update journey set doj= ? where pnr = ?");
			ps.setString(1, doj);
			ps.setString(2,pnr);

			int rs=ps.executeUpdate();
		 * 
		 */
		ResultSet rs=ps.executeQuery();  

		System.out.println("Printing All Records of the given PNR:");
		while(rs.next()){  
			System.out.println(
					rs.getString(1) + ", "
							+ rs.getString(2) + ", "
							+ rs.getString(3) + ", "
							+ rs.getString(4) + ", "
							+ rs.getString(5) + ", "
							+ rs.getString(6) + ", "
							+ rs.getString(7) + ", "
							+ rs.getString(8) + ", "+ rs.getString(10) + ", "+ rs.getString(11) + ", "+ rs.getString(12) + ", "
							+ rs.getString(13) + ", "+ rs.getString(14) + ", "+ rs.getString(15) + ", "+ rs.getString(16) + ", "+ rs.getString(17) 
					);  
		}  

	}catch(Exception e){e.printStackTrace();}
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("Enter 1 to insert booking details \nEnter 2 to cancel whole ticket\nEnter 3 to cancel a particular passenger \nEnter 4 to Update journey date\n"
					+ "Enter 5 to display PNR records\nEnter 6 to display all journey records from database\nEnter 7 to display all passenger records from database\nEnter 8 to exit\n ");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				insertJourney();break;
			case 2:
				deleteJourney();break;
			case 3:
				deletePassenger();break;
			case 4:
				updateJourney();break;
			case 5:
				displayPnrRecord();break;
			case 6:
				displayJourney();break;
			case 7:
				displayPassengers();break;
			case 8:return;

			}
		}

	}

}


