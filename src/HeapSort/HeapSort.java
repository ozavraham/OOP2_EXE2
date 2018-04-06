package HeapSort;

public class HeapSort {
	
	static int heapSize=0;
	
	public static <T extends Comparable<T>> void sort(T[] array) {
		buildHeap(array);
		for (int i=array.length ; i>1 ; i--) {
			swap(array, 1, i);
			HeapSort.heapSize = HeapSort.heapSize-1; 
			Heapify(array, 1);
		}
	}
	
	private static <T extends Comparable<T>> void buildHeap(T[] array) {
		heapSize = array.length;
		for (int i=array.length/2 ; i>=1 ; i--) {
			Heapify(array, i);
		}
	}
	
	private static <T extends Comparable<T>> void Heapify(T[] array, int i) {
		int leftSon = i*2;
		int rightSon = (2*i)+2;
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
