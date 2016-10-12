import java.util.Random;
import java.util.Scanner;

public class Lab1 {
	public static int seed;
	public static int size; 
	public static double startTime=0;
	public static double endTime=0;
	public static double time;
	
	//main program
		public static void mymain(String[] args) {
			int choice=0;
			int[] array;
			while(choice!=1){
				System.out.println("Enter choice: \n"
								+ "1)Quit the program\n"
								+ "2)Time Freddy's Algorithm\n"
								+ "3)Time Susie's Algorithm\n"
								+ "4)Time Johnny's Algorithm\n"
								+ "5)Time Sally's Algorithm\n");
				Scanner scan = new Scanner(System.in);
				choice = scan.nextInt();
				switch(choice){
				case 1: 
					break;
				case 2:
					inputValues();
					array = randArray(seed,size);
					System.out.println("Max Array Sum: "+Freddy(array));
					break;
				case 3:
					inputValues();
					array = randArray(seed,size);
					System.out.println("Max Array Sum: "+Susie(array));
					break;
				case 4:
					inputValues();
					array = randArray(seed,size);
					System.out.println("Max Array Sum: "+Johnny(array, 0, (size == 0 ? 0 : size - 1)));
					break;
				case 5:
					inputValues();
					array = randArray(seed,size);
					System.out.println("Max Array Sum: "+Sally(array));
					break;
				default:
					System.out.println("Incorrect input. Try again");
					break;
				}
				scan.close();
			}	
		}
		public static int[] randArray(int seed, int size){
			Random rand = new Random(seed);
			int[] a = new int[size];
			for(int i = 0;i<size;i++){
				a[i]=rand.nextInt(201)-100;
			}
			return a;
		}
		
		public static void inputValues(){
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter Seed: ");
			seed = scan.nextInt();
			System.out.println("Enter array size: ");
			size = scan.nextInt();
		}
	
	//main for analysis
	public static void main(String[] args) {
		int[] array = randArray(1,1000000);
		int[] array1 = randArray(1,2000000);
		int[] array2 = randArray(1,50000000);
		
		//dummy loop to stabilize java timers
		for(int i=0;i<5;i++){
			Johnny(array, 0, (array.length == 0 ? 0 : array.length - 1) );

		}
		time=0;
		System.out.println("-- Dummy Loop End --");

		//finds time averages for the selected algorithm
		for(int i=0;i<10;i++){
			Johnny(array, 0, (array.length == 0 ? 0 : array.length - 1) );
		}
		System.out.println("Average Johnny Algorithm time with n=1000000: "+time/10.0+"ms");
		
		time=0;
		for(int i=0;i<10;i++){
			Johnny(array1, 0, (array1.length == 0 ? 0 : array1.length - 1) );
		}
		System.out.println("Average Johnny Algorithm time with n=2000000: "+time/10.0+"ms");
		
		time=0;
		for(int i=0;i<10;i++){
			Johnny(array2, 0, (array2.length == 0 ? 0 : array2.length - 1) );
		}
		System.out.println("Average Johnny Algorithm time with n=50000000: "+time/10.0+"ms");

	}
	
	
	//test main
	public static void testmain(String[] args) {
		int[] a={};
		int[] a1 = {1,-1,3,-20,5,-5,7,8,9,10};
		int[] a2 = {4,1,-1,3,-20,5,-5,7,8,9,10};
		int[] a3 =  new int[0];
		int[] a4 =  {-1,-2,-3,-4,-5,-6,-7,-10,-15,-3};
		int[] a5 =  {0,0,0,0,0,0,0,0,0,0};
		int[] a6 =  {1,2,3,4,5,6,7,8,9,10};

		for(int i=1;i<=6;i++){
			System.out.print("\nTest Case "+i);
			if(i==1){
				a=a1; 
				System.out.println(" expected max sum: 34");
			}
			if(i==2){
				a=a2; 
				System.out.println(" expected max sum: 34");
			}
			if(i==3){
				a=a3; 
				System.out.println(" expected max sum: 0");
			}
			if(i==4){
				a=a4; 
				System.out.println(" expected max sum: 0");
			}
			if(i==5){
				a=a5; 
				System.out.println(" expected max sum: 0");
			}
			if(i==6){
				a=a6;
				System.out.println(" expected max sum: 55");
			}
			System.out.println("Maxsum = "+Freddy(a));
			System.out.println("Maxsum = "+Susie(a));
			System.out.println("Maxsum = "+Johnny(a, 0, (a.length == 0 ? 0 : a.length - 1) ));		
			System.out.println("Maxsum = "+Sally(a));
		}
	
	}
	
	//4 Sub array Algorithms
	public static int Freddy(int a[]){
		startTime = System.currentTimeMillis();
		int maxSum = 0;
		for (int i = 0; i < a.length; i++){
			for (int j = i; j < a.length; j++){
				int thisSum = 0;
				for(int k = i;k<=j;k++){
					thisSum+=a[k];
				}
				if(thisSum > maxSum)
					maxSum = thisSum;
			}
		}
		endTime = System.currentTimeMillis();
		double runTime = endTime - startTime;
		time += runTime; //this line is for analysis - to keep track of avg runtime
		System.out.println("Algorithm time: "+runTime+"ms");
		return maxSum;
	}
	
	public static int Susie(int a[]){
		startTime = System.currentTimeMillis();
		int maxSum = 0;
		for (int i=0;i<a.length;i++){
			int thisSum = 0;
			for(int j = i; j<a.length;j++){
				thisSum+= a[j];
				if(thisSum > maxSum)
					maxSum = thisSum;
			}
		}
		endTime = System.currentTimeMillis();
		double runTime = endTime - startTime;
		time += runTime;
		System.out.println("Algorithm time: "+runTime+"ms");
		return maxSum;
	}
	
	public static int Johnny(int a[], int left, int right){
		if(left==0 && right ==a.length-1)
			startTime = System.currentTimeMillis();
		if (left == right) {
			if(left==0 && right==0)
				return 0;
			else if(a[left] > 0)
				return a[left];
			return 0;
		}
		int center = (left+right)/2;
		int maxLeftSum = Johnny(a, left, center);
		int maxRightSum = Johnny(a, center+1, right);
		
		int maxLeftBorderSum = 0, leftBorderSum =0;
		for(int i = center;i >= left; i--){
			leftBorderSum+=a[i];
			if(leftBorderSum > maxLeftBorderSum)
				maxLeftBorderSum = leftBorderSum;
		}
		int maxRightBorderSum = 0, rightBorderSum=0;
		for(int i = center +1; i <=right; i++){
			rightBorderSum += a[i];
			if(rightBorderSum > maxRightBorderSum){
				maxRightBorderSum = rightBorderSum;
			}
		}
		if(left==0 && right==a.length-1){
			endTime   = System.currentTimeMillis();
			double runTime = endTime - startTime;
			time += runTime;
			System.out.println("Algorithm time: "+runTime+"ms");
		}
		return max3(maxLeftSum, maxRightSum, maxLeftBorderSum + maxRightBorderSum);
	}
	
	public static int max3(int left, int right, int both){
		if (left >= right && left >= both)
			return left;
		else if (right >= left && right >=both)
			return right;
		else 
			return both;
	}
	
	public static int Sally(int a[]){
		startTime = System.currentTimeMillis();
		int maxSum = 0, thisSum=0;
		for(int i =0; i<a.length;i++){
			thisSum += a[i];
			if(thisSum > maxSum)
				maxSum = thisSum;
			else if (thisSum <0)
				thisSum =0;
		}
		endTime = System.currentTimeMillis();
		double runTime = endTime - startTime;
		time += runTime;
		System.out.println("Algorithm time: "+runTime+"ms");
		return maxSum;
	}

}
