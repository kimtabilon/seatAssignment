import java.io.*;
import java.util.*;
import java.util.HashMap; // import the HashMap class
import java.util.HashSet; // Import the HashSet class

// Import the ArrayList class and the Iterator class
import java.util.Iterator;


class SeatAssignment
{

 public static void main(String ar[])
 {
  	// HashMap<String, String> seats = new HashMap<String, String>();
  	HashMap<String, String> assigned = new HashMap<String, String>();

  	HashSet<String> bcs = new HashSet<String>();
  	HashSet<String> bcns = new HashSet<String>();
  	HashSet<String> es = new HashSet<String>();
  	HashSet<String> ens = new HashSet<String>();

    bcs.add("1"); bcs.add("2"); bcs.add("3"); bcs.add("4"); bcs.add("5");
    bcns.add("6"); bcns.add("7"); bcns.add("8"); bcns.add("9"); bcns.add("10"); 
    es.add("11"); es.add("12"); es.add("13"); es.add("14"); es.add("15");
    ens.add("16"); ens.add("17"); ens.add("18"); ens.add("19"); ens.add("20");


    for(int i=0;i<30;i++) {
    	System.out.println();
    	System.out.println("AVAILABLE SEAT#");
	    System.out.println("Business Class : Smoking");
	    for (String s : bcs) {
		    System.out.print(s+", ");
		}

		System.out.println();
		System.out.println("Business Class : No Smoking");
	    for (String s : bcns) {
		    System.out.print(s+", ");
		}
		System.out.println();
		System.out.println("Economy Class : Smoking");
	    for (String s : es) {
		    System.out.print(s+", ");
		}
		System.out.println();
		System.out.println("Economy Class : No Smoking");
	    for (String s : ens) {
		    System.out.print(s+", ");
		}

		Scanner sc=new Scanner(System.in);
		System.out.println();
		System.out.println("--------------------------");
		
		System.out.println("Enter Seat#:");
		String seat=sc.nextLine();
		boolean seatValid = true;

		if(bcs.contains(seat)) {
			System.out.println("You selected [Business Class Smoking] Seat "+seat);
			bcs.remove(seat);
		} else if (bcns.contains(seat)) {
			System.out.println("You selected [Business Class No Smoking] Seat "+seat);
			bcns.remove(seat);
		} else if (es.contains(seat)) {
			System.out.println("You selected [Economy Class Smoking] Seat "+seat);
			es.remove(seat);
		} else if (ens.contains(seat)) {
			System.out.println("You selected [Economy Class No Smoking] Seat "+seat);
			ens.remove(seat);
		} else {
			System.out.println("Seat# "+seat+" is not available!");
			seatValid = false;
		}

		if(seatValid) {
			System.out.println("Enter Passenger Name:");
			String passenger=sc.nextLine();
			if(passenger!="") {
				assigned.put(seat, passenger);
			}
		}
		System.out.println("Press enter to continue...");
		String cont=sc.nextLine();
		
		System.out.print("\033[H\033[2J");
		System.out.flush();
		
		System.out.println("PASSENGERS");
	    assigned.entrySet().stream().forEach(a -> {
            System.out.println("seat# "+a.getKey()+" : "+a.getValue());
        });
		
		System.out.println("");
		System.out.println("**************************");
    }
 }
}