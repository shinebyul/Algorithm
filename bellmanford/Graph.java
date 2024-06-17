package bellmanford2;

public class Graph {
    private int[][] edges;
    private int[][] vertices;

    public Graph(int[][] edges, int[][] vertices) {
        this.edges = edges;
        this.vertices = vertices;
    }

    public int[][] getEdges() {
        return edges;
    }

    public int[][] getVertices() {
        return vertices;
    }
}
