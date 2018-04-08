package HeapSort;
import java.util.InputMismatchException;
import java.util.Scanner;

/* Generic HeapSort Implementation
 * Aviram Boniel & Oz Avraham
 * Object Oriented Programming 2
 */

public class Main {

	public static void main(String[] args) {
		// If the user is done, change to true and exit the while loop
		boolean isDone = false;
		Scanner read = new Scanner(System.in);
		// Displaying menu
		System.out.println("Welcome to HeapSort Generic Exercise!");
		System.out.println("Please choose from the following:");
		System.out.println("1. Integer array");
		System.out.println("2. String array");
		System.out.println("-1. to Exit.");
		// As long as the user ain't finished
		do {
			try {
				int choise = read.nextInt();
				if (choise==1) {
					int size = getSize();
					Integer[] array = new Integer[size+1];
					System.out.println("You have chosen Integer's array!");
					for (int i=1 ; i<=size ; i++) {
						System.out.printf("Please enter value for place number %d: ", i);
						array[i] = read.nextInt();
					}
					System.out.println("Your input:");
					printArr(array);
					if (confirmInput()) {
						sort(array);
						isDone=false;
						System.out.println("Choose again from the previous menu:");	
					}
					else {
						System.out.println("Nevermind... Try again!");
						System.out.println("Choose again from the previous menu:");
						isDone=false;
					}
				}
				else if (choise==2) {
					System.out.println("You have chosen String's array!");
					int size = getSize();
					String[] array = new String[size+1];
					for (int i=1 ; i<=size ; i++) {
						System.out.printf("Please enter value for place number %d: ", i);
						array[i] = read.next();
					}
					System.out.println("Your input:");
					printArr(array);
					if (confirmInput()) {
						sort(array);
						isDone=false;
						System.out.println("Choose again from the previous menu:");	
					}
					else {
						System.out.println("Nevermind... Try again!");
						System.out.println("Choose again from the previous menu:");
						isDone=false;
					}
				}
				else if (choise==-1) {
					System.out.println("Exiting... Goodbye.");
					isDone=true;
				}
				else throw new InputMismatchException();
			}
			// Catch if the input ain't from the allowed integers
			catch (InputMismatchException e) {
				System.out.println("Invalid input!");
				System.out.println("Choose again from the following:");
				System.out.println("1. Integer array");
				System.out.println("2. String array");
				System.out.println("-1. to Exit.");
				read.nextLine();
				isDone=false;
			}
		}while (!isDone);
		// Closing scanner
		read.close();
	}

	/*
	 * Getting the desired size for the array
	 * Throws InputMismatchException in case of illigeal input
	 */
	public static int getSize() throws InputMismatchException{ 
		Scanner read = new Scanner (System.in);
		System.out.println("Enter the size of the array you desire:");
		int size = read.nextInt();
		return size;
	}
	
	/*
	 * Getting the generic array
	 * Printing the original array, sending it to Sort @ HeapSort class and printing it after the HeapSort
	 */
	public static <T extends Comparable<T>> void sort(T[] array) {
		System.out.println("The array before the sort:");
		printArr(array);
		HeapSort.sort(array);
		System.out.println("The array after the sort:");
		printArr(array);
	}
	
	/*
	 * Simple 'for' loop to print the array
	 */
	public static <T> void printArr(T[] array) {
		System.out.print("[");
		for (int i=1 ; i<array.length ; i++) {
			if (i!=array.length-1) {
				System.out.print(array[i] + ", ");
			}
			else System.out.print(array[i]);
		}
		System.out.print("]");
		System.out.println();
	}

	/*
	 * Confirmation with the user that he want to continue
	 * Throws InputMismatchException in case of illigeal input
	 */
	public static boolean confirmInput() throws InputMismatchException{
		Scanner read = new Scanner(System.in);
		String input;
		boolean bool;
		System.out.println("Should we continue to sort? [Y/N]");
		input = read.next();
		input.toLowerCase();
		if (input.equals("y")) bool = true;
		else if (input.equals("n")) bool =false;
		else throw new InputMismatchException ();
		return bool;
	}

}
