package Activities;

import java.util.Arrays;

public class Activity4 {

	static void ascendingsort(int array[]) {
		
		int size = array.length, i;
		for(i=1;i<size;i++) {
			int key = array[i];
			int j = i-1;
			while (j>=0 && key < array[j]) {
				array[j+1] = array[j];
				--j;
			}
			array[j+1] = key;
			
	}
}

public static void main(String arg[]) {
	int[] data = {9,5,1,4,3};
	ascendingsort(data);
	System.out.println("Sorted array in ascending order");
	System.out.println(Arrays.toString(data));
	
} 

}
