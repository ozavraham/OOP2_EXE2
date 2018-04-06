package HeapSort;

public class HeapSort {
	
	public static <T extends Comparable<T>> void sort(T[] array) {
		buildHeap(array);
		for (int i=array.length ; i>1 ; i--) {
			swap(array, i, 0);
			Heapify(array, i);
		}
	}
	
	private static <T extends Comparable<T>> void buildHeap(T[] array) {
		
	}
	
	private static <T extends Comparable<T>> void Heapify(T[] array, int i) {
		
	}
	
	private static void swap(Object[] array, int i, int j) {
		Object temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
