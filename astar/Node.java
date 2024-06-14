package astar;

public class Node {
    private Node Parent;
    private int f;
    private int g;
    private int h;

    private int x;
    private int y;

    public Node(Node parent, int f, int g, int h, int x, int y) {
        Parent = parent;
        this.f = f;
        this.g = g;
        this.h = h;
        this.x = x;
        this.y = y;
    }

    public Node getParent() {
        return Parent;
    }

    public int getF() {
        return f;
    }

    public int getG() {
        return g;
    }

    public int getH() {
        return h;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setParent(Node parent) {
        Parent = parent;
    }

    public void setF(int f) {
        this.f = f;
    }

    public void setG(int g) {
        this.g = g;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
