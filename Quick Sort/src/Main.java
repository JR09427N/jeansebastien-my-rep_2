import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random rand = new Random();
		
		int[] a = new int[10];
		
		for(int i = 0; i < a.length; i++) {
			a[i] = rand.nextInt(100);
		}
		
		System.out.println("Before:\n");
		printArray(a);
		
		quickSort(a, 0, a.length - 1);
		
		System.out.println("After:\n");
		printArray(a);
	}
	
	
	public static void printArray(int[] a) {
		String start = "[";
		for(int i = 0; i < a.length; i++) {
			if(i != a.length - 1) {
				start += a[i] + ", ";
			} else {
				start += a[i] + "]";
			}
		}
		System.out.println(start + "\n");
	}
	
	public static void quickSort(int[] array, int lowIndex, int highIndex) {
		if(lowIndex >= highIndex) {
			return;
		}
		
		int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
		int pivot = array[pivotIndex];
		swap(array, highIndex, pivotIndex);
		
		int leftPointer = partition(array, lowIndex, highIndex, pivot);
		
		quickSort(array, lowIndex, leftPointer - 1);
		quickSort(array, leftPointer + 1, highIndex);
	}

	private static int partition(int[] array, int lowIndex, int highIndex, int pivot) {
		int leftPointer = lowIndex;
		int rightPointer = highIndex;
		
		while(leftPointer < rightPointer) {
			
			while(array[leftPointer] <= pivot && leftPointer < rightPointer) {
				leftPointer++;
			}
			
			while(array[rightPointer] >= pivot && leftPointer < rightPointer) {
				rightPointer--;
			}
			
			swap(array, leftPointer, rightPointer);
		}
	
		swap(array, leftPointer, highIndex);
		return leftPointer;
	}
	
	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
