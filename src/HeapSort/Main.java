package HeapSort;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int choise;
		boolean isValidInput = false;
		Scanner read = new Scanner(System.in);
		System.out.println("Welcome to HeapSort Generic Exercise!");
		System.out.println("Please choose from the following:");
		System.out.println("1. Integer array");
		System.out.println("2. String array");
		System.out.println("-1 to Exit.");
		while (!isValidInput) {
			choise = read.nextInt();
			if (choise==1) {
				int size = getSize();
				Integer[] array = new Integer[size];
				for (int i=0 ; i<size ; i++) {
					System.out.println("Please enter value for place number " + i + ":");
					array[i] = read.nextInt();
				}
				System.out.println("Your input:");
				System.out.println(Arrays.toString(array));
				sort(array);
			}

			else if (choise==2) {
				int size = getSize();
				String[] array = new String[size];
				for (int i=0 ; i<size ; i++) {
					System.out.println("Please enter value for place number " + i + ":");
					array[i] = read.nextLine();
				}
				System.out.println("Your input:");
				System.out.println(Arrays.toString(array));
				sort(array);
			}
			else if (choise==-1) {
				System.out.println("Exiting... Goodbye.");
				System.exit(0);
			}
			else {
				isValidInput = false;
				System.out.println("Invalid input!");
				System.out.println("Choose again from the following:");
				System.out.println("1. Integer array");
				System.out.println("2. String array");
				System.out.println("-1 to Exit.");
			}
		}
	}

	public static int getSize() {
		Scanner read = new Scanner (System.in);
		System.out.println("Enter the size of the array you desire:");
		int size = read.nextInt();
		return size;
	}

	public static <T extends Comparable<T>> void sort(T[] array) {
		System.out.println("The array before the sort:");
		System.out.println(Arrays.toString(array));
		HeapSort.sort(array);
		System.out.println("The array after the sort:");
		System.out.println(Arrays.toString(array));
	}

}
