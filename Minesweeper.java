import java.io.*;
import java.util.*;
import java.util.HashMap; // import the HashMap class
import java.util.HashSet; // Import the HashSet class

// Import the ArrayList class and the Iterator class
import java.util.Iterator;


class Minesweeper
{

 public static void main(String ar[]) {
 	int matrix = 5;

 	HashSet<String> bomb = new HashSet<String>();
 	HashSet<String> active = new HashSet<String>();

 	boolean exploded = false;

 	bomb.add("1,2");
 	bomb.add("2,4");
 	bomb.add("2,5");
 	bomb.add("3,3");
 	bomb.add("5,4");

 	for(int i=0;i<50;i++) {
	 	System.out.println("    1   2   3   4   5 ");
	 	System.out.println("   ------------------- ");
	 	for (int row=1; row<=matrix; row++) {
	 		System.out.print(row+" |");
	 		for (int column=1; column<=matrix; column++) {
	 			if(active.contains(row+","+column)) {
	 				System.out.print(" 1 |");
	 			} else {
	 				if(exploded && bomb.contains(row+","+column)) {
	 					System.out.print(" x |");
	 				} else {
	 					System.out.print("   |");
	 				}
	 			}
	 		}
	 		System.out.println("");
	 		System.out.println("   ------------------- ");
	 	}

	 	if(exploded) { 
	 		System.out.println("Opps, Bomb Exploded. G A M E O V E R");
	 		break; 
	 	}

	 	Scanner sc=new Scanner(System.in);

	 	System.out.println("Enter Row:");
		int irow=sc.nextInt();

		System.out.println("Enter Column:");
		int icolumn=sc.nextInt();

		Scanner sc2=new Scanner(System.in);

		if( irow<=matrix 
		&& irow>=1  
		&& icolumn<=matrix  
		&& icolumn>=1 
		) {
			if(active.contains(irow+","+icolumn)) {
				System.out.println("Already selected. Enter to continue");
				String already=sc2.nextLine();
			} else {
				if(bomb.contains(irow+","+icolumn)) {
					exploded=true;
				} else {
					active.add(irow+","+icolumn);
					// checking bombs for hints
					boolean sorround = false;
					int count = 0;	
					if(bomb.contains((irow+1)+","+(icolumn+1))) {sorround = true; count++;}
					if(bomb.contains((irow-1)+","+(icolumn-1))) {sorround = true; count++;}
					if(bomb.contains((irow-1)+","+(icolumn+1))) {sorround = true; count++;}
					if(bomb.contains((irow+1)+","+(icolumn-1))) {sorround = true; count++;}
					if(bomb.contains(irow+","+(icolumn+1))) {sorround = true; count++;}
					if(bomb.contains((irow+1)+","+icolumn)) {sorround = true; count++;}
					if(bomb.contains(irow+","+(icolumn-1))) {sorround = true; count++;}
					if(bomb.contains((irow-1)+","+icolumn)) {sorround = true; count++;}
					
					if(sorround) {
						System.out.println("HINT : Soround "+count+" bomb/s. Enter to continue");
						String hint=sc2.nextLine();
					}
						
				}
				
			}

		} else {
			System.out.println("Invalid input for row/column. Enter to continue");
			String invalid=sc2.nextLine();
		}

	 	System.out.print("\033[H\033[2J");
		System.out.flush();
 	}

 }

}