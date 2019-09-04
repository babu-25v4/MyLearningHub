package datastructure;

/*In bubble sort algorithm, array is traversed from first element to last element. 
Here, current element is compared with the next element. If current element is greater than the next element, it is swapped.*/

public class BubbleSortExample {
	
	public static void main(String[] args) {
		int arr[] ={3,60,35,2,45,320,5};
		BubbleSortExample bs = new BubbleSortExample();
		
		System.out.print("Array before sort: ");
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+", ");
		}
		System.out.println();
		bs.bubbleSort(arr);
		System.out.print("Array after sort: ");
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+", ");
		}
	}
	
	public void bubbleSort(int arr[]){
		int temp=0;
		for(int i=0; i<arr.length; i++){
			for(int j=1; j<(arr.length); j++){
				if(arr[j] < arr[j-1]){
					temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

}
