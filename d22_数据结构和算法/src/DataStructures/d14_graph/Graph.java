package DataStructures.d14_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 深度优先遍历具体代码实现存疑，小韩没讲明白
 */
public class Graph {

    private ArrayList<String> vertexList;       //存储顶点集合
    private int[][] edges;                      //存储图对应的邻结矩阵
    private int numOfEdges;                     //表示边的数目
    private boolean[] isVisited;                //定义给数组boolean[], 记录某个结点是否被访问，遍历方法会用到

    /**
     * 构造器
     *
     * @param n 顶点数
     */
    public Graph(int n) {
        edges = new int[n][n];                      //初始化邻接矩阵
        vertexList = new ArrayList<String>(n);      //初始化顶点集合
        numOfEdges = 0;                             //初始化边的数目（写不写都行，默认为零）
    }

    /**
     * 插入结点
     */
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 添加边
     *
     * @param v1     表示点的下标即第几个顶点
     * @param v2     第二个顶点对应的下标
     * @param weight 表示权值
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    /**
     * 得到某结点的第一个邻接结点的下标？
     *
     * @param index
     * @return 如果存在就返回对应的下标，否则返回-1
     */
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 若v1的v2邻接节点已经遍历完，调用此方法查找v1的v2往后的邻接节点
     */
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    /**
     * ？
     * private
     *
     * @param isVisited
     * @param i
     */
    private void dfs(boolean[] isVisited, int i) {
        System.out.print(getValueByIndex(i) + "->");     //首先我们访问该结点,输出
        isVisited[i] = true;                //将结点设置为已经访问
        int w = getFirstNeighbor(i);        //查找结点i的第一个邻接结点w？
        while (w != -1) {                   //说明有邻接节点
            if (!isVisited[w]) {            //如果没有被访问
                dfs(isVisited, w);          //递归访问
            }
            w = getNextNeighbor(i, w);      //走到这一步说明i的w邻接节点已经遍历完，查找i的w往后的邻接节点
        }
    }
    /**
     * RealDFS？
     * 对dfs 进行一个重载, 给所有节点都dfs一下子
     * 防止有不连通点？
     */
    public void dfs() {
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < getNumOfVertex(); i++) {        //遍历所有的结点，进行dfs[回溯]
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }
/*    //测试我们的图只从0开始深度遍历是否能遍历完
    public void dfs() {
        isVisited = new boolean[vertexList.size()];
        dfs(isVisited, 0);
    }*/



    /**
     * BFS
     * @param isVisited
     * @param i
     */
    private void bfs(boolean[] isVisited, int i) {
        int u; // 表示队列的头结点对应下标
        int w; // 邻接结点w
        LinkedList queue = new LinkedList();         //创建队列，记录结点访问的顺序

        System.out.print(getValueByIndex(i) + "=>"); //访问结点，输出结点信息
        isVisited[i] = true;        //标记为已访问
        queue.addLast(i);           //将结点加入队列

        while (!queue.isEmpty()) {                  //只要队列非空
            u = (Integer) queue.removeFirst();      //取出队列的头结点下标
            w = getFirstNeighbor(u);                //得到u的第一个邻接结点的下标 w
            while (w != -1) {                       //如果有邻接节点  （如果没有就推出该循环，走上一个循环判断队列是否空）
                if (!isVisited[w]) {                        //如果没有访问过
                    System.out.print(getValueByIndex(w) + "=>");  //输出
                    isVisited[w] = true;                    //标记已经访问
                    queue.addLast(w);                       //入队
                }
                w = getNextNeighbor(u, w); //以u为前驱点，找w后面的下一个邻结点
            }
        }

    }
    /**
     * RealBFS？
     * 对BFS 进行一个重载, 给所有节点都BFS一下子
     * 防止有不连通点？
     */
    public void bfs() {
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }

    //图中常用的方法
    //返回结点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    //得到边的数目
    public int getNumOfEdges() {
        return numOfEdges;
    }

    //返回结点i(下标)对应的数据，例如： 0->"A" 1->"B" 2->"C"
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //返回v1和v2的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    //显示图对应的矩阵
    public void showGraph() {
        for (int[] link : edges) {
            System.err.println(Arrays.toString(link));
        }
    }

}