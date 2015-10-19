import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


public class LifeInAMetro2 {

	private int          distances[];
    private Set<Integer> settled;
    private Set<Integer> unsettled;
    private int          number_of_nodes;
    private int          adjacencyMatrix[][];
 
    public LifeInAMetro2(int number_of_nodes)
    {
        this.number_of_nodes = number_of_nodes;
        distances = new int[number_of_nodes + 1];
        settled = new HashSet<Integer>();
        unsettled = new HashSet<Integer>();
        adjacencyMatrix = new int[number_of_nodes + 1][number_of_nodes + 1];
    }
 
    public void dijkstra_algorithm(int adjacency_matrix[][], int source)
    {
        int evaluationNode;
        for (int i = 1; i <= number_of_nodes; i++)
            for (int j = 1; j <= number_of_nodes; j++)
                adjacencyMatrix[i][j] = adjacency_matrix[i][j];
 
        for (int i = 1; i <= number_of_nodes; i++)
        {
            distances[i] = Integer.MAX_VALUE;
        }
 
        unsettled.add(source);
        distances[source] = 0;
        while (!unsettled.isEmpty())
        {
            evaluationNode = getNodeWithMinimumDistanceFromUnsettled();
            unsettled.remove(evaluationNode);
            settled.add(evaluationNode);
            evaluateNeighbours(evaluationNode);
        }
    }
    
    private int getNodeWithMinimumDistanceFromUnsettled()
    {
        int min;
        int node = 0;
 
        Iterator<Integer> iterator = unsettled.iterator();
        node = iterator.next();
        min = distances[node];
        for (int i = 1; i <= distances.length; i++)
        {
            if (unsettled.contains(i))
            {
                if (distances[i] <= min)
                {
                    min = distances[i];
                    node = i;
                }
            }
        }
        return node;
    }
 
    private void evaluateNeighbours(int evaluationNode)
    {
        int edgeDistance = -1;
        int newDistance = -1;
 
        for (int destinationNode = 1; destinationNode <= number_of_nodes; destinationNode++)
        {
            if (!settled.contains(destinationNode))
            {
                if (adjacencyMatrix[evaluationNode][destinationNode] != Integer.MAX_VALUE)
                {
                    edgeDistance = adjacencyMatrix[evaluationNode][destinationNode];
                    newDistance = distances[evaluationNode] + edgeDistance;
                    if (newDistance < distances[destinationNode])
                    {
                        distances[destinationNode] = newDistance;
                    }
                    unsettled.add(destinationNode);
                }
            }
        }
    }
	public static void main(String[] args) {
		int adjacency_matrix[][];
		int traversing_nodes[];
        int number_of_edges;
        int nodes_to_be_traversed;
        int source = 0, destination = 0;
        Scanner in = new Scanner(System.in);
        try
        {
            
            number_of_edges = in.nextInt();
            nodes_to_be_traversed = in.nextInt();
            traversing_nodes = new int[nodes_to_be_traversed];
            adjacency_matrix = new int[number_of_edges + 1][number_of_edges + 1];
 
            System.out.println("Enter the Weighted Matrix for the graph");
            for (int i = 1; i <= number_of_edges; i++)
            {
                
                int v1 = in.nextInt();
                int v2 = in.nextInt();
                adjacency_matrix[v1][v2] = 2500;
                adjacency_matrix[v2][v1] = 2500;
                
                
            }

            for(int x=0;x<number_of_edges+1;x++){
            	for(int y=0;y<number_of_edges;y++){
            		if(adjacency_matrix[x][y] != 2500){
            			adjacency_matrix[x][y] = Integer.MAX_VALUE;
            		}
            	}
            }
            System.out.println("Enter the source ");
            source = 0; 
            System.out.println("Enter the destination ");
            destination = 5;
 
            LifeInAMetro2 dijkstrasAlgorithm = new LifeInAMetro2(number_of_edges);
            dijkstrasAlgorithm.dijkstra_algorithm(adjacency_matrix, source);
 
            System.out.println("The Shorted Path from " + source + " to " + destination + " is: ");
            for (int i = 1; i <= dijkstrasAlgorithm.distances.length - 1; i++)
            {
                if (i == destination)
                    System.out.println(source + " to " + i + " is "
                            + dijkstrasAlgorithm.distances[i]);
            }
        } catch (InputMismatchException inputMismatch)
        {
            System.out.println("Wrong Input Format");
        }
        in.close();


	}

}
