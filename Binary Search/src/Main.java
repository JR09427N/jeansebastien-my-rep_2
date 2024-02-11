public class Main {

	public static void main(String[] args) {
		int[] array = {1, 2, 4, 5, 7, 9, 11, 34, 91, 103};
		//int[] array = {4, 6, 13, 34, 47, 48, 54, 78, 85, 88};
		
		int n = 4;
		
		System.out.println("n is at index " + binarySearch(array, 0, array.length, n));
	}
	
	private static int binarySearch(int[] array, int lowIndex, int highIndex, int n) {
		
		if(lowIndex >= highIndex) {
			return -1;
		}
		
		int middleIndex = (lowIndex + highIndex) / 2;
		
		if(n == array[middleIndex]) {
			return middleIndex;
		}
		
		if(n > array[middleIndex]) {
			lowIndex = array[middleIndex] +1;
		}
		
		if(n < array[middleIndex]) {
			highIndex = array[middleIndex] -1;
		}
		
		return binarySearch(array, lowIndex, highIndex, n);
	}
}
