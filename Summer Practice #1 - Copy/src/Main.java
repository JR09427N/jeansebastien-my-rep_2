import java.util.Random;

public class Main {
	static Random rand = new Random();
	
	public static void main(String[] args) {
		int[] array = new int[10];
		
		for(int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(array.length);
		}
		
		System.out.print("Before: ");
		printArray(array);
		
		bubbleSort(array);
		
		System.out.print("After:  ");
		printArray(array);
	}
	
	private static void printArray(int[] array) {
		String start = "[";
		
		for(int i = 0; i < array.length; i++) {
			if(i != array.length -1) {
				start += array[i] + ", ";
			}
			
			else {
				start += array[i] + "]";
			}
		}
		
		System.out.println(start);
	}
	
	private static void bubbleSort(int[] array) {
		boolean hasSwapped = true;
		
		while(hasSwapped == true) {
			hasSwapped = false;
			
			for(int i = 0; i < array.length -1; i++) {
				
				if(i > i +1) {
					hasSwapped = true;
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
				}
				
			}
		}
	}
}
