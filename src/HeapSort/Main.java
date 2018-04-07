package HeapSort;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean isValidInput = false;
		boolean isDone = false;
		Scanner read = new Scanner(System.in);
		System.out.println("Welcome to HeapSort Generic Exercise!");
		System.out.println("Please choose from the following:");
		System.out.println("1. Integer array");
		System.out.println("2. String array");
		System.out.println("-1 to Exit.");
		do {
			int choise = read.nextInt();
			if (choise==1) {
				int size = getSize();
				Integer[] array = new Integer[size+1];
				System.out.println("You have chosen Integer!");
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
				else isDone=false;
			}

			else if (choise==2) {
				int size = getSize();
				String[] array = new String[size+1];
				System.out.println("You have chosen String!");
				for (int i=1 ; i<=size ; i++) {
					System.out.printf("Please enter value for place number %d: ", i);
					array[i] = read.next();
				}
				System.out.println("Your input:");
				printArr(array);
				sort(array);
				isDone=false;				
				System.out.println("Choose again from the previous menu:");

			}
			else if (choise==-1) {
				System.out.println("Exiting... Goodbye.");
				isDone=true;
			}
			else {
				isValidInput = false;
				System.out.println("Invalid input!");
				System.out.println("Choose again from the following:");
				System.out.println("1. Integer array");
				System.out.println("2. String array");
				System.out.println("-1 to Exit.");
			}
		} while (!isValidInput && !isDone);
		read.close();
	}

	public static int getSize() { //java.util.InputMismatchException
		Scanner read = new Scanner (System.in);
		System.out.println("Enter the size of the array you desire:");
		int size = read.nextInt();
		return size;
	}

	public static <T extends Comparable<T>> void sort(T[] array) {
		System.out.println("The array before the sort:");
		printArr(array);
		HeapSort.sort(array);
		System.out.println("The array after the sort:");
		printArr(array);
	}
	
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
	
	public static boolean confirmInput() {
		try {
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
		catch (InputMismatchException e) {
			System.out.println("Invalid Input!");
			System.out.println("Please try again!");
			confirmInput();
		}
		return true;
	}

}
