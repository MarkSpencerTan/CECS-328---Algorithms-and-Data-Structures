import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {
   public static void main(String[] args) throws FileNotFoundException{
      Scanner scan = new Scanner(new File("simpleGraph.txt"));
      System.out.println("Enter a file to open: simpleGraph.txt");

      WeightedGraph simpleGraph = new WeightedGraph(Character.getNumericValue(scan.nextLine().charAt(0)));
      //reads every line of the file and loads the graph with edges
      for(int i = 0; scan.hasNextLine() ; i++){
         Scanner line = new Scanner(scan.nextLine());
         while(line.hasNextInt()){
            int v2 = line.nextInt();
            double weight = line.nextInt();
            simpleGraph.addEdge(i, v2, weight);
         }
      }
      //User Menu
      int command = 0;
      Scanner source = new Scanner(System.in);
      Scanner menu = new Scanner(System.in);
      while(command != 4){
         System.out.println("" +
                 "\nCommands: \n" +
                 "1)Print out the graph\n" +
                 "2)Print Minimum Spanning Tree\n" +
                 "3)Print Shortest Paths (provide a source vertex)\n" +
                 "4)exit");
         command = menu.nextInt();
         switch(command) {
            case 1:
               simpleGraph.printGraph();
               break;
            case 2:
               WeightedGraph mst = simpleGraph.getMinimumSpanningTree();
               System.out.print("\n\nMinimum spanning tree:");
               mst.printGraph();
               break;
            case 3:
               System.out.println("Enter Source Vertex: ");
               int mSource = source.nextInt();
               double[] distances = simpleGraph.getShortestPathsFrom(mSource);
               for (int i = 0; i < distances.length; i++) {
                  System.out.print("\nDistance from " + mSource + " to " + i + ": " +
                          distances[i]);
               }
               break;
         }
      }
   }
}
