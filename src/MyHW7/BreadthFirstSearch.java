package MyHW7;

public class BreadthFirstSearch {
    public static void main(String[] args) {
        GraphBread graphBread = new GraphBread();

        graphBread.addVertex('A');
        graphBread.addVertex('B');
        graphBread.addVertex('C');
        graphBread.addVertex('D');
        graphBread.addVertex('E');

        graphBread.addEdge(0, 1);
        graphBread.addEdge(1, 2);
        graphBread.addEdge(0, 3);
        graphBread.addEdge(3, 4);

        graphBread.bfs();

    }
}
class GraphBread {

    private final int MAX_VERTS=20;
    private VertexDepth vertexList[];
    private int adjMat[][];
    private int nVerts;
    private QueueBread theQueue;

    public GraphBread(){
        vertexList=new VertexDepth[MAX_VERTS];
        adjMat=new int[MAX_VERTS][MAX_VERTS];
        nVerts=0;
        for(int j=0;j<MAX_VERTS;j++)
            for(int k=0;k<MAX_VERTS;k++)
                adjMat[j][k]=0;
        theQueue=new QueueBread();
    }


    public void addVertex(char lab){
        vertexList[nVerts++]=new VertexDepth(lab);
    }

    public void addEdge(int start,int end){
        adjMat[start][end]=1;
        adjMat[end][start]=1;
    }

    public void displayVertex(int v){
        System.out.println(vertexList[v].label);
    }

    public int getAdjUnvisitedVertex(int v){
        for(int j=0;j<nVerts;j++)
            if(adjMat[v][j]==1 && vertexList[j].wasVisited==false)
                return j;
        return -1;
    }

    public void bfs(){
        vertexList[0].wasVisited=true;
        displayVertex(0);
        theQueue.insert(0);
        int v2;

        while(!theQueue.isEmpty()){
            int v1=theQueue.remove();
            while((v2=getAdjUnvisitedVertex(v1))!=-1){
                vertexList[v2].wasVisited=true;
                displayVertex(v2);
                theQueue.insert(v2);
            }
        }

        for(int j=0;j<nVerts;j++)
            vertexList[j].wasVisited=false;
    }

}
 class QueueBread {

    private final int SIZE=20;
    private int[] queueArray;
    private int front ;
    private int rear;

    public QueueBread(){
        queueArray = new int[SIZE];
        front=0;
        rear=-1;
    }

    public void insert(int j){
        if(rear==(SIZE-1))
            rear=-1;
        queueArray[++rear]=j;
    }

    public int remove(){
        int temp=queueArray[front++];
        if(front==SIZE)
            front=0;
        return temp;
    }

    public boolean isEmpty(){
        return (rear+1==front ||(front+SIZE-1==rear));
    }

}
class VertexBread {
    public char label;
    public boolean wasVisited;

    public VertexBread(char lab){
        label=lab;
        wasVisited=false;
    }
}

