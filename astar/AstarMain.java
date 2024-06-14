package astar;

public class AstarMain {
    public static void main(String[] args) {
        Integer[][] map = {
                {0, 0, 1, 0, 0, 0, 3, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 3, 0, 2, 0},
                {0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        int rowLength = map.length;
        int colLength = map[0].length;

        Node start = null;
        Node goal = null;

        for(int i=0;i<rowLength;i++){
            for(int j=0;j<colLength;j++){
                if(map[i][j]==1){
                    start = new Node(null,0,0,0,i,j);
                }
                if(map[i][j]==2){
                   goal = new Node(null,0,0,0,i,j);
                }
            }
        }
        Astar astar = new Astar(map, start, goal);
        astar.insertNodeIntoClosedList(start);
        astar.findPath();

    }
}
