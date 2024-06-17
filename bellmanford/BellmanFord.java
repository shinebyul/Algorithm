package bellmanford2;

import java.util.Stack;

public class BellmanFord {
    Graph graph;
    final int INFINITY = Integer.MAX_VALUE;

    public BellmanFord(Graph graph) {
        this.graph = graph;
    }

    public void findPath(){
        int[][] vertices = graph.getVertices();
        int[][] edges = graph.getEdges();
        int n = vertices.length;

        // 거리 초기화
        for(int i=0;i<n;i++){
            if(i==0){
                vertices[i][0]=0;
            }else{
                vertices[i][0] = INFINITY;
            }
        }

        //최단경로 찾기
        for(int i=0;i<n-1;i++){
            for (int[] edge : edges) {
                int start = edge[0];
                int end = edge[1];
                int weight = edge[2];

                if(vertices[start][0]!=INFINITY && vertices[end][0] > vertices[start][0]+weight){
                    vertices[end][0]=vertices[start][0]+weight;
                    vertices[end][1]=start;
                }
            }
        }

        //음수 사이클 검사
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            int weight = edge[2];

            if(vertices[start][0]!=INFINITY && vertices[end][0] > vertices[start][0]+weight){
                System.out.println("음수 싸이클이 존재해 최단 경로를 찾을 수 없습니다.");
                return;
            }
        }
    }

    public void printPath(int e){//몇번 노드까지의 경로를 볼건지
        Stack<Integer> path = new Stack<Integer>();
        int[][] vertices = graph.getVertices();
        while(vertices[e][1]!=-1){
            path.push(e);
            e=vertices[e][1];
        }
        path.push(e);
        while(!path.isEmpty()){
            System.out.print(path.pop());
            if(path.isEmpty()) break;
            System.out.print(" -> ");
        }
    }
}
