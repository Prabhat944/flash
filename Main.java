package Reservation;
import java.util.Scanner;
public class Main {
	static void addPassenger(String[][] matrix,boolean[][] flag) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Add a Passenger");
		System.out.println("Enter name of Passenger");
		String name=sc.next(); // input from user customer name
		System.out.println("Choose a seat using row and column separate by space ");
		int row=sc.nextInt(); //input from user row
		int col=sc.nextInt(); //input from user column
		System.out.println("Row = "+row);
		System.out.println("Column = "+col);
		
		//check if seat is available or not
		if(!flag[row][col]) 
		{
			System.out.println("This seat is not available");
			System.out.println("Plese choose other seat");
			addPassenger(matrix,flag);
		}
		
		//check if valid input is present
		if(row>0 && col>0) 
		{
			matrix[row][col]="*"+row+"-"+col+":"+name+"*";
	    	flag[row][col]=false;
	    	table(matrix,flag);
	    	
	    	System.out.println("You have succesfully reserved a seat !");
		    	
       }
		//check if input is out of reservation table condition
		else if(row<1 || col<1 || row>9 || col>4) 
		{
			System.out.println("please enter a valid seat number");
			addPassenger(matrix,flag);
		}
	   else 
	   {
		   return;
		   
	   }
		System.out.println("Do you want to reserve another seat (y/n)");
		
		char z=sc.next().charAt(0);
		if(z=='y' ) 
		{
			addPassenger(matrix,flag);
		}
		else {
			return;
		}
		
	}
	static void removePassenger(String[][] matrix,boolean[][] flag) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Remove a Passenger");
		System.out.println("press 1:By Passenger Name");
		System.out.println("press 2:By Passenger seat number");
		System.out.println("press 3:Back menu");
		int user=sc.nextInt();
		if(user==1) {
			System.out.println("Enter name of passenger");
			String name=sc.next();
			for(int row=1;row<=9;row++) {
				for(int col=1;col<=4;col++) {
					if(matrix[row][col].endsWith(name+"*")) {
						matrix[row][col]="*seat"+row+"-"+col+"*";
						flag[row][col]=true;
						break;
					}
				}
			}
			System.out.println("You have successfully remove reservation of "+name);
			table(matrix,flag);
			
		}
		else if(user==2) 
		{
		System.out.println("Enter seat using row and column separate by space");
		int row=sc.nextInt(); //input from user row
		int col=sc.nextInt(); //input from user column
		System.out.println("Row = "+row);
		System.out.println("Column = "+col);
		matrix[row][col]="*seat"+row+"-"+col+"*";
		flag[row][col]=true;
		System.out.println("You have successfully remove reservation from seat"+row+"-"+col);
		System.out.println();
		table(matrix,flag);
		}
		else if(user==3) 
		{
			return;
		}
		else 
		{
			System.out.println("Please enter a valid key");
			removePassenger(matrix,flag);
		}
		System.out.println("Do you want to remove more passsenger(y/n)");
		char input=sc.next().charAt(0);
		if(input=='y') removePassenger(matrix,flag);
		else if(input=='n') return;
		
	}
	static void table(String[][] matrix,boolean[][] flag) {
		System.out.println("\t\t"+"Reservation Table");
		System.out.println("**********************************************************");
		for(int row=1;row<=9;row++) 
		{
		    
		    for(int col=1;col<=4;col++) 
		    {
		    	if(!flag[row][col]) {
		    		System.out.print(matrix[row][col]+"\t");
		    	}
		    	else {
		    	matrix[row][col]="*seat"+row+"-"+col+"*";
		    	System.out.print(matrix[row][col]+"\t");
		    	}
		    }
		    System.out.println();
		}
		System.out.println("**********************************************************");
	}
	static void exit() {
		System.out.println("Thank you for using our Service");
		System.out.println("Have a nice day");
		
	}
	static boolean isFull(boolean[][] flag) {
		boolean res=true;
		for(int row=1;row<=9;row++) {
			for(int col=1;col<=4;col++) {
				if(flag[row][col]==true) {
					res=false;
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("\t \t Welcome to Reservation System");
		System.out.println();
		String matrix[][] = new String[10][5];//2d array
		boolean flag[][] = new boolean[10][5];//2d array
		for(int row=1;row<=9;row++) 
		{
			for(int col=1;col<=4;col++) 
			{
				flag[row][col]=true;
			}
		}
		//for reservation table
		table(matrix,flag);
		
		while(true) 
		{
			if(isFull(flag)) 
			{
				System.out.println("Reservation is full");
				exit();
				break;
			}
			System.out.println("press 1:Add Passenger");   // add a passenger
			System.out.println("press 2:Remove Passenger"); //remove a passenger
			System.out.println("press 3:Exit");
			int input=sc.nextInt();
			if(input==1) {
				addPassenger(matrix,flag);
				continue;
			}
			if(input==2) {
				removePassenger(matrix,flag);
				continue;
			}
			if(input==3) {
			exit();
			break;
			}
			else {
				System.out.println("Please enter a valid key");
				continue;
			}
			
		}
    }
	
	
}

