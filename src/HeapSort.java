public class HeapSort {

	static int heapSize=0;

	/*
	 * Sort Method
	 * HeapSort Implementation
	 * According to the algorithem learnd @ Data Structue class 1'st year
	 */
	public static <T extends Comparable<T>> void sort(T[] array) {
		// Sending the array to buildHeap
		buildHeap(array); 
		for (int i=array.length-1 ; i>1 ; i--) {
			swap(array, 1, i);
			HeapSort.heapSize = HeapSort.heapSize-1; 
			Heapify(array, 1);
		}
	}

	/*
	 * BuildHeap method
	 * Building the "Heap" from the original array
	 * Using Math.floorDiv to get the lower bound from the division
	 */
	private static <T extends Comparable<T>> void buildHeap(T[] array) {
		// If the array is with length 6 with free space at array[0]
		// Then the heapSize is -1
		HeapSort.heapSize = array.length-1; 
		for (int i=Math.floorDiv(heapSize, 2) ; i>=1 ; i--) {
			Heapify(array, i);
		}
	}

	/*
	 * Heaoify method
	 * Implemnt the Heapify action according to the Min Heap algorithm
	 */
	private static <T extends Comparable<T>> void Heapify(T[] array, int i) {
		// Getting the two sons of the node
		int leftSon = (i*2);
		int rightSon = (i*2)+1;
		// Locating int to save the largest position from them both
		int largest;
		// Starting to compare, make sure we are still in the bounderis of the array
		if (leftSon<=HeapSort.heapSize && array[leftSon].compareTo(array[i])>0) {
			largest = leftSon;
		}
		else {
			largest = i;
		}
		if (rightSon<=HeapSort.heapSize && array[rightSon].compareTo(array[largest])>0) {
			largest = rightSon;
		}
		// Makre sure its not the same node!
		if (largest!=i) {
			// Making the swap
			swap(array, i, largest);
			// Recursive calling
			Heapify(array, largest);
		}
	}

	/*
	 * Swap method
	 * Getting the array, the 2 position's needed to be swap
	 * Swapping the locations
	 */
	private static void swap(Object[] array, int i, int j) {
		Object temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
