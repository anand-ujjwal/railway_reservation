package serial_data;
/*
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Details {
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	train_details();
    	passenger_details();

	}

    public static void train_details()
    {Scanner sc=new Scanner(System.in);
    //	System.out.println("Enter the train number=");
    //	int trainNumber=sc.nextInt();
    	System.out.println("\nEnter train name=");
    	String trainName=sc.nextLine();
    	System.out.println("\nEnter date of journey= in dd-MM-yyyy");
    	//Google the results to insert dates
    	String date = sc.next();
    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    	Date date2=null;
    	try {
    	    //Parsing the String
    	    date2 = dateFormat.parse(date);
    	} catch (ParseException e) {
    	    // TODO Auto-generated catch block
    	    e.printStackTrace();
    	}
    	System.out.println(date2);
    	System.out.println("\nEnter the number of bearths");
    	int bearths=sc.nextInt();
    	System.out.println("\nStation FROM=");
    	String stationFrom=sc.nextLine();
    	System.out.println("\nStation TO=");
    	String stationTo=sc.nextLine();
    	System.out.println("\nBoarding at=");
    	String boardingAt=sc.nextLine();
    	System.out.println("\nReservation upto=");
    	String reservationUpto=sc.nextLine();
    }
    
    public static void passenger_details()
    {Scanner sc=new Scanner(System.in);
    	int numberOfPassengers;int serial=0;
    	System.out.println("\nENter the number of passengers that you want to reserve(Max 6 allowed");
    	numberOfPassengers=sc.nextInt();
    	if(numberOfPassengers<=6)
    	{
    		for(int i=0;i<numberOfPassengers;i++)
    		{	serial++;
    			System.out.println("\nEnter name=");
    			String name=sc.nextLine();
    			System.out.println("\nEnter Sex M/F=");
    			String sex=sc.nextLine();
    			System.out.println("\nEnter the age=");
    			int age=sc.nextInt();
    			System.out.println("\nENter Concession/TravelAuthority Number=");
    			int concessionNumber=sc.nextInt();
    			System.out.println("\nLower/Upper=");
    			String bearthChoice=sc.nextLine();
    			System.out.println("\nVeg/Non-veg=");
    			String foodChoice=sc.nextLine();
    			
    		}
    	}
    }
}
*/