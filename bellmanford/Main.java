package bellmanford2;

public class Main {
    public static void main(String[] args) {
        int[][] edges = {{0,1,8},{0,2,-2},{0,3,4},{2,1,7},{2,3,1},{1,4,-2},{2,4,3},{5,2,9},{3,5,5}};
        int[][] vertices = {{0,-1},{0,-1},{0,-1},{0,-1},{0,-1},{0,-1}};

        Graph graph = new Graph(edges,vertices);

        BellmanFord bellmanFord = new BellmanFord(graph);

        bellmanFord.findPath();

        for(int i=1;i<vertices.length;i++){
            System.out.print("0 to "+i+" : [ ");
            bellmanFord.printPath(i);
            System.out.print(" ]");
            System.out.println();
        }
    }
}
