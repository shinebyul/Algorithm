package astar;

import com.sun.security.auth.NTDomainPrincipal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Astar {
    final Integer DEFAULT_COST = 10;
    final Integer DEFAULT_DIAGONAL_COST = 14;

    private Integer rowSize;
    private Integer colSize;

    private Integer[][] map;

    private Node start;
    private Node goal;

    private List<Node> openList;
    private List<Node> closedList;
    private Integer[][] route;

    public Astar(Integer[][] map, Node start, Node goal) {
        this.rowSize = map.length;
        this.colSize = map[0].length;
        this.map = map;
        this.start = start;
        this.goal = goal;
        this.openList = new ArrayList<>();
        this.closedList = new ArrayList<>();
        route = new Integer[10][10];
    }

    public Integer getRowSize() {
        return rowSize;
    }

    public Integer getColSize() {
        return colSize;
    }

    public Integer[][] getMap() {
        return map;
    }

    public Node getStart() {
        return start;
    }

    public Node getGoal() {
        return goal;
    }

    public List<Node> getOpenList() {
        return openList;
    }

    public List<Node> getClosedList() {
        return closedList;
    }


    public void findPath() {
        Node node = start;

//        int centerX = node.getX();
//            int centerY = node.getY();
//
//            setAdjacentNode(node, -1,1);
//            setAdjacentNode(node, -1,0);
//            setAdjacentNode(node, -1,-1);
//            setAdjacentNode(node, 0,1);
//            setAdjacentNode(node, 0,-1);
//            setAdjacentNode(node, 1,1);
//            setAdjacentNode(node, 1,0);
//            setAdjacentNode(node, 1,-1);

        while(node!=goal){
            int centerX = node.getX();
            int centerY = node.getY();

            int cal[][]={{-1,1},{-1,0},{-1,-1},{0,1},{0,-1},{1,1},{1,0},{1,-1}};

            for (int i=0;i< cal.length;i++){
                if(node.getX()+cal[i][0]==goal.getX() && node.getY()+cal[i][1]==goal.getY()){
                    goal.setParent(node);
                    node=goal;
                    break;
                }
                setAdjacentNode(node, cal[i][0],cal[i][1]);
            }

            if(node!=goal){
                node = popNodeFromOpenList();
                insertNodeIntoClosedList(node);
            }
        }
        System.out.println("print route");

        int i=0;
        for(int k=0;k<rowSize;k++){
            for(int j=0;j<colSize;j++){
                if(map[k][j]==3){
                    System.out.print("◼ ");
                }else if(start.getX()==k && start.getY()==j){
                    System.out.print("s ");
                }else if(goal.getX()==k && goal.getY()==j){
                    System.out.print("g ");
                }else if(isRoute(k,j)){
                    System.out.print("* ");
                }else{
                    System.out.print("□ ");
                }
            }
            System.out.println();
        }
    }
    public boolean isRoute(int k, int j){
        Node node = goal.getParent();
        while(node!=null){
            if(node.getX()==k && node.getY()==j){
                return true;
            }
            node = node.getParent();
        }
        return false;
    }

    public void insertNodeIntoOpenList(Node inputNode) { //h 오름차순으로 정렬하면서 삽입
        for (int i = 0; i < openList.size(); i++) {
            Node node = openList.get(i);
            if (inputNode.getH() <= node.getH()) {
                openList.add(i, inputNode);
                return;
            }
        }
        openList.add(inputNode);
    }

    public Node popNodeFromOpenList() { // h가 가장 작은 첫번째 노드를 반환
        Node node = openList.get(0);
        openList.remove(0);
        return node;
    }

    public void insertNodeIntoClosedList(Node inputNode) {
        closedList.add(inputNode);
    }

    public Node getNodeInOpenList(int x, int y) { // 위치가 x,y인 노드 반환, 없으면 null 반환 // 상속 받는 방법도 있음
        for (Node node : openList) {
            if (node.getX() == x && node.getY() == y) {
                return node;
            }
        }
        return null;
    }

    public Node getNodeInClosedList(int x, int y) { // 위치가 x,y인 노드 반환, 없으면 null 반환 // 상속 받는 방법도 있음
        for (Node node : closedList) {
            if (node.getX() == x && node.getY() == y) {
                return node;
            }
        }
        return null;
    }
    public void setAdjacentNode(Node centerNode, int x, int y) { //인접한 노드 설정
        int centerX = centerNode.getX();
        int centerY = centerNode.getY();

        if((centerX+x < 0 || centerY+y < 0) || (centerX+x > rowSize-1 || centerY+y > colSize-1)){
            return;
        }
        if((map[centerX+x][centerY+y]==3)){
            return;
        }
        if(getNodeInClosedList(centerX+x, centerY+y)!=null){
            return;
        }

        Node adjacentNode = getNodeInOpenList(centerX+x, centerY+y);
        if (adjacentNode == null) { // 인접 노드가 OpenList에 없는 경우
            int f;
            if (x != 0 && y != 0) { //대각선인 경우
                f = centerNode.getF() + DEFAULT_DIAGONAL_COST;
            } else { // 대각선이 아닌 경우
                f = centerNode.getF() + DEFAULT_COST;
            }
            // 새로운 노드 생성해서 openList에 넣기
            int g = getDistance(x, y);
            Node newNode = new Node(centerNode, f, g, f + g, centerX + x, centerY + y);
            insertNodeIntoOpenList(newNode);
        } else {// 인접 노드가 OpenList에 있는 경우
            int fOfcenterNode = centerNode.getF();
            if (x != 0 && y != 0) { //대각선인 경우
                //(center의 f + 14 < Node의 f )이면 node의 f 바꿔주기
                if (fOfcenterNode + DEFAULT_DIAGONAL_COST < adjacentNode.getF()) {
                    adjacentNode.setF(fOfcenterNode + DEFAULT_DIAGONAL_COST);
                    adjacentNode.setParent(centerNode);
                }
            } else { // 대각선이 아닌 경우
                //(center의 f + 10 < Node의 f )이면 node의 f 바꿔주기
                if (fOfcenterNode + DEFAULT_COST < adjacentNode.getF()) {
                    adjacentNode.setF(fOfcenterNode + DEFAULT_COST);
                    adjacentNode.setParent(centerNode);
                }
            }
        }
//        System.out.println("-------------------------------");
//        for (Node open : openList) {
//            System.out.println("[ " + open.getX() + " , " + open.getY() +" ]"+", "+open.getH());
//        }
    }

    public int getDistance(int x, int y) { // 도착지까지의 거리
        //x 이동
        int xCount = 0;
        if (x < goal.getX()) {
            while (x < goal.getX()) {
                x++;
                xCount+=10;
            }
        } else {
            while (x > goal.getX()) {
                x--;
                xCount+=10;
            }
        }
        //y 이동
        int yCount = 0;
        if (y < goal.getY()) {
            while (y < goal.getY()) {
                y++;
                yCount+=10;
            }
        } else {
            while (y > goal.getY()) {
                y--;
                yCount+=10;
            }
        }
        return xCount+yCount-10;
    }

}
