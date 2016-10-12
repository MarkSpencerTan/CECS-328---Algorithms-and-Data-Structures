
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Baseball {

	public static void main(String[] args) throws FileNotFoundException {
		HashMap<String, Integer> hmap = new HashMap(909);
		Scanner scan = new Scanner(new File("players_homeruns.csv"));
		while (scan.hasNext()){
			String line = scan.nextLine();
			String[] key = line.split(",");
			int value = Integer.parseInt(line.split(",")[1]);
			hmap.insert(key[0], value);
		}
		String name="";
		Scanner scan1 = new Scanner(System.in);
		while(name!="exit"){
			System.out.println("Enter player name: ");
			String player = scan1.nextLine();
			if(player=="exit"){
				break;
			}
			else if(hmap.containsKey(player)){
				System.out.print(player+" Home Runs: "+hmap.find(player)+"\n");
			}
			else
				System.out.println("Player is not in the list, try again.\n");
		}
	}
}
