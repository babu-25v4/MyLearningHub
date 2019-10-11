package datastructure;
/*In selection sort algorithm, we search for the lowest element and arrange it to the proper location. We swap the current element with the next lowest number.
 * The selection sort algorithm works in a very simple way. It maintains two subarray for the given array.
 * The subarray is already sorted.
 * And the second subarray is unsorted.
With every iteration of selection sort, an element is picked from the unsorted subarray and moved to the sorted subarray

Time Complexity
Best: ?(n^2)
Average: ?(n^2)
Worst: O(n^2)
*
*/

public class SelectionSort {

	public static void main(String[] args) {
		SelectionSort ss = new SelectionSort();

		int[] arr = {9,14,3,2,43,11,58,22};
		System.out.print("Before sort: ");
		for (int i : arr) {
			System.out.print(i+" ");
		}		
		System.out.println();
		ss.selectionSort(arr);
		System.out.print("After sort: ");
		for(int i=0; i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}

	public void selectionSort(int[] arr){  
		for (int i = 0; i < arr.length - 1; i++) {  
			int min = i;  
			for (int j = i + 1; j < arr.length; j++){  
				if (arr[j] < arr[min]){  
					min = j;
				}  
			}  
			int temp = arr[min];   
			arr[min] = arr[i];  
			arr[i] = temp;  
		}  
	}  

}
