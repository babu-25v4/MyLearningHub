package datastructure;

public class LinearSearch {

	public static void main(String[] args) {
		int arr[] = {2, 5, 8, 10, 23, 34, 56, 65};
		int num = 23;
		LinearSearch ls = new LinearSearch();
		int index = ls.linearSearch(arr, num);
		if(index != -1){
			System.out.println("Number: "+num+", is present at index: "+index);
		}else{
			System.out.println("Number: "+num+", is present in the given array.");
		}		
	}
	
	public int linearSearch(int arr[], int searchNum){

		int arrLength = arr.length;
		for(int i=0; i<arrLength; i++){
			if(arr[i] == searchNum)
				return i;
		}		
		return -1;
	}

}
