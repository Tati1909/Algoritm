package MyHW7;

class StackGraph {
    private int maxSize;
    private int[] stackArr;
    private int top;

    public StackGraph(int size) {
        this.maxSize = size;
        this.stackArr = new int[size];
        this.top = -1;
    }

    public void push(int i) {
        stackArr[++top] = i;
    }

    public int pop() {
        return stackArr[top--];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public int peek() {
        return stackArr[top];
    }
}

class VertexDepth {
    public char label;
    public boolean wasVisited;

    public VertexDepth(char label) {
        this.label = label;
        this.wasVisited = false;
    }
}

class GraphDepth {
    private final int MAX_VERTS = 32;
    private VertexDepth[] vertexList;
    private int adjMat[][];
    private int size;
    private StackGraph stack;

    public GraphDepth() {
        stack = new StackGraph(MAX_VERTS);
        vertexList = new VertexDepth[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        size = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
    }

    //проверка смежности верншин
    private int getAdjUnVisitedVertex(int ver) {
        for (int j = 0; j < size; j++) {
            if (adjMat[ver][j] == 1 && vertexList[j].wasVisited == false) {
                return j;
            }
        }
        return -1;
    }

    //метод обхода в глубину
    public void dfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        stack.push(0);

        while (!stack.isEmpty()) {
            int v = getAdjUnVisitedVertex(stack.peek());
            if (v == -1)
                stack.pop();
            else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                stack.push(v);
            }
        }

        for (int j = 0; j < size; j++) {
            vertexList[j].wasVisited = false;
        }
    }

    public void addVertex(char lab) {
        vertexList[size++] = new VertexDepth(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.println(vertexList[v].label);
    }
}

public class DepthFirstWalk {
    public static void main(String[] args) {
        GraphDepth theGraph = new GraphDepth();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');

        theGraph.addEdge(0, 1);
        theGraph.addEdge(1, 2);
        theGraph.addEdge(0, 3);
        theGraph.addEdge(3, 4);

        theGraph.dfs();


    }
}
