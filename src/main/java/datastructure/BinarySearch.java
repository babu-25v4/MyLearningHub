package datastructure;

public class BinarySearch {

	public static void main(String[] args) {
		int arr[] = {2, 5, 8, 10, 23, 34, 56, 65};
		BinarySearch b = new BinarySearch();
		int searchNum = 56;
		int result = b.binarySearch(arr, searchNum);
		if(result != -1){
			System.out.println("Number: "+searchNum+", is present at index: " + result);
		}else{
			System.out.println("Number: "+searchNum+", is present in the array");
		}
	}

	public int binarySearch(int arr[], int num){

		int start = 0, end = arr.length-1;
		int mid;

		while(start <= end){
			mid = start + (end-start)/2;
			System.out.println("mid: "+mid);
			if(arr[mid]==num){
				return mid;
			}

			if(arr[mid]<num){
				start = mid+1;
			}else{
				end = mid-1;
			}
		}				
		return -1;
	}

}
