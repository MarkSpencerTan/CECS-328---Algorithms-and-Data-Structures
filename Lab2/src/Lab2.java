import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lab2 {
	public static void main(String[] args) throws IOException {
		//Prompts the user for a binary file to open
		Scanner scan = new Scanner(System.in);
		while(true){
		System.out.println("Enter file name to be opened: ");
		String filename = scan.nextLine();
		//Makes the original
		for(int i =0 ; i<12;i++){
		int[] ISoriginal = readFile(filename);
		int[] QSoriginal = ISoriginal;
	
		long startTime = System.nanoTime();
		insertionSort(ISoriginal);
		long endTime = System.nanoTime();
		long runTime = endTime - startTime;
		//System.out.println(filename+ " Insertion Sorted : " + Arrays.toString(ISoriginal));
		System.out.println("Insertion Sort time: "+runTime+"ms");
		
		startTime = System.currentTimeMillis();
		//quickSort(QSoriginal, 0, QSoriginal.length-1);
		endTime = System.currentTimeMillis();
		runTime = endTime - startTime;
		//System.out.println(filename+ " Quick Sorted : " + Arrays.toString(QSoriginal));
		//System.out.println("Quick Sort time: "+runTime+"ns");
		}}
	}
	
	public static int[] readFile(String filename) throws IOException{
		DataInputStream in = new DataInputStream(new FileInputStream(filename));
		int asize = in.readInt();
		int[] array = new int[asize];
	    for (int index=0 ; in.available()>0 ; index++) {
	    	int a = in.readInt();
	        array[index]=a;
	    }
	    in.close();
	    return array;
	}
	public static void insertionSort(int[] array) throws IOException{
		for(int i =1;i<array.length;i++){
			int j, unsorted = array[i];
			for( j = i-1; j>=0; j--){
				if (array[j] > unsorted){
					array[j+1]=array[j];
					array[j]=unsorted;
				}
				else
					break;
			}
		}
		return;
	} 
	//overload for quick sort
	public static void insertionSort(int[] array, int left, int right) throws IOException{
		for(int i =left+1;i<right;i++){
			int j, unsorted = array[i];
			for( j = i-1; j>=0; j--){
				if (array[j] > unsorted){
					array[j+1]=array[j];
					array[j]=unsorted;
				}
				else
					break;
			}
		}
		return;
	} 
	
	public static void quickSort(int[] array, int left, int right) throws IOException{
		if(right-left <=5){
			insertionSort(array, left, right);
		}
		if(left < right){
			int pivotIndex = findPivotIndex(array, left, right);
			int p = partition(array, left, right, pivotIndex );
			quickSort(array, left, p-1);
			quickSort(array, p+1, right);
		}
	}
	public static int partition(int[] array, int left, int right, int pivotIndex){
		int pivotValue = array[pivotIndex];
		swap(array, pivotIndex, right);
		//partition the array. if an element is smaller than pivot,
		//swap it to the next position in the store
		int store=left;
		for(int i = left; i < right; i++){
			if(array[i] < pivotValue){
				swap(array, store, i);
				store++;
			}
		}
		swap(array , right, store);
		return store;
	}
	
	public static int findPivotIndex(int[] array, int left, int right){
		//calculates median of 3 pivot value
		int middle = left + (right-left)/2;
		int pivot  = Math.max(Math.min(array[left],array[middle]), 
				Math.min(Math.max(array[left],array[middle]),array[right]));

		if(pivot == array[left])
			return left;
		else if(pivot == array[right])
			return right;
		else
			return middle;
	}
	
	public static void swap(int[] array, int index1, int index2){
		int temp = array[index1];
		array[index1]= array[index2];
		array[index2]=temp;
	}
	
	public static void writeOriginal(String filename) throws IOException{
		 int[] a ={4,10,-4,0,3};
		 DataOutputStream os = new DataOutputStream(new FileOutputStream(filename));
		 for(int i=0;i<a.length;i++){
			 os.writeInt(a[i]);
		 }
		 os.close();
	}
	public static void writeSorted(String filename) throws IOException{
		 int[] a = new int[100000];
		 DataOutputStream os = new DataOutputStream(new FileOutputStream(filename));
		 os.writeInt(100000);
		 for(int i=1;i<=a.length;i++){
			 os.writeInt(i);
		 }
		 os.close();
	}
	public static void writeRandom(String filename) throws IOException{
		 int[] a = new int[100000];
		 Random rand = new Random();
		 DataOutputStream os = new DataOutputStream(new FileOutputStream(filename));
		 os.writeInt(100000); 
		 for(int i=0;i<a.length;i++){
			 os.writeInt(rand.nextInt(2001)-1000);
		 }
		 os.close();
	}
	public static void writeReverse(String filename) throws IOException{
		 int[] a = new int[100000];
		 DataOutputStream os = new DataOutputStream(new FileOutputStream(filename));
		 os.writeInt(100000);
		 for(int i=a.length;i>0;i--){
			 os.writeInt(i);
		 }
		 os.close();
	}
	public static void smallReverse(String filename) throws IOException{
		 int[] a = new int[20];
		 DataOutputStream os = new DataOutputStream(new FileOutputStream(filename));
		 os.writeInt(20);
		 for(int i=a.length;i>0;i--){
			 os.writeInt(i);
		 }
		 os.close();
	}

}
