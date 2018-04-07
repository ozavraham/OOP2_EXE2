package HeapSort;

public class HeapSort {

	static int heapSize=0;

	public static <T extends Comparable<T>> void sort(T[] array) {
		buildHeap(array);
		for (int i=array.length-1 ; i>1 ; i--) {
			swap(array, 1, i);
			HeapSort.heapSize = HeapSort.heapSize-1; 
			Heapify(array, 1);
		}
	}

	private static <T extends Comparable<T>> void buildHeap(T[] array) {
		// If the array is with length 6 with free space at array[0]
		// Then the heapSize is -1
		HeapSort.heapSize = array.length-1; 
		for (int i=Math.floorDiv(heapSize, 2) ; i>=1 ; i--) {
			Heapify(array, i);
		}
	}

	private static <T extends Comparable<T>> void Heapify(T[] array, int i) {
		int leftSon = (i*2);
		int rightSon = (i*2)+1;
		int largest;
		if (leftSon<=HeapSort.heapSize && array[leftSon].compareTo(array[i])>0) {
			largest = leftSon;
		}
		else {
			largest = i;
		}
		if (rightSon<=HeapSort.heapSize && array[rightSon].compareTo(array[largest])>0) {
			largest = rightSon;
		}
		if (largest!=i) {
			swap(array, i, largest);
			Heapify(array, largest);
		}
	}

	private static void swap(Object[] array, int i, int j) {
		Object temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
