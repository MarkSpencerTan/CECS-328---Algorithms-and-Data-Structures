import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lab1 {
	public static int seed;
	public static int size; 
	public static double startTime=0;
	public static double endTime=0;
	public static double time;
	
	//main program
		public static void main(String[] args) {
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