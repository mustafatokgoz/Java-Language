/**
 * Class sorts  array with selection sort
 * @author mustafa
 *
 */
public class Sorting {
		/**
		 * Finding index of minimum element in array recursively
		 * @param arr
		 * @param index to stop
		 * @param min
		 * @param minindex
		 * @return
		 */
		public static int minindex(int arr[],int index,int min,int minindex) {
			if(index==arr.length) {
				return minindex;
			}
			if(arr[index]<min) {
				min=arr[index];
				minindex=index;
			}
			return minindex(arr,++index,min,minindex);
		}
		/**
		 * Sorts array with using minimum index recursively
		 * @param arr
		 * @param num
		 * @return
		 */
		public static int[] sort(int[] arr,int num) {
			int minindex;
			if(num==arr.length)
				return arr;
			minindex=minindex(arr,num,arr[num],num);
			int temp=arr[num];
			arr[num]=arr[minindex];
			arr[minindex]=temp;
			return sort(arr,num+1);
			
		}

}
