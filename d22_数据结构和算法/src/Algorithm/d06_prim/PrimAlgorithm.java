package Algorithm.d06_prim;

import java.util.Arrays;

public class PrimAlgorithm {
    public static void main(String[] args) {
        //测试看看图是否创建ok
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int n = data.length;
        //邻接矩阵的关系使用二维数组表示,10000这个大数，表示两个点不联通
        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000},};

        //创建MGraph对象
        MGraph graph = new MGraph(n);
        //创建一个MinTree对象
        MinTree minTree = new MinTree();
        minTree.createGraph(graph, n, data, weight);
/*        //展示一下看看
        minTree.showGraph(graph);*/
        //测试普利姆算法
        minTree.prim(graph, 3);   //不管从那个点开始，最后权值之和都相等
    }

}


//创建最小生成树
class MinTree {
    public void createGraph(MGraph graph, int n, char data[], int[][] weight) {
        int i, j;
        for (i = 0; i < n; i++) {
            graph.data[i] = data[i];                //初始化顶点数据
            for (j = 0; j < n; j++) {
                graph.weight[i][j] = weight[i][j];  //初始化邻接矩阵
            }
        }
    }

    //显示图的邻接矩阵
    public void showGraph(MGraph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * prim算法
     *
     * @param graph 图
     * @param v     表示从图的第几个顶点开始生成
     */
    public void prim(MGraph graph, int v) {
        int visited[] = new int[graph.n];       //visited[] 标记结点(顶点)是否被访问过
        visited[v] = 1;                 //把当前这个结点标记为已访问
        //h1 和 h2 记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000; //将 minWeight 初始成一个大数，后面在遍历过程中，会被替换
        for (int k = 1; k < graph.n; k++) {      //有n个顶点，我们需要生成n-1边，所以循环n-1次，每次找到一个权值最小的边

            //寻找已经访问过的结点和未访问过的结点间的权值最小的边
            for (int i = 0; i < graph.n; i++) {          // 遍历已经访问过的节点（i）
                for (int j = 0; j < graph.n; j++) {        //遍历还没有访问的节点（j）
                    //寻找已经访问过的结点和未访问过的结点间的权值最小的边
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            //退出循环说明找到了已经访问过的结点和未访问过的结点间的权值最小的边
            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + "> 权值:" + minWeight);
            visited[h2] = 1;          //将当前这个结点标记为已经访问
            minWeight = 10000;        //minWeight 重新设置为最大值 10000
        }

    }
}

class MGraph {
    int n; //表示图的节点个数
    char[] data;//存放结点数据,
    int[][] weight; //存放边，就是我们的邻接矩阵

    public MGraph(int n) {
        this.n = n;
        data = new char[n];
        weight = new int[n][n];
    }
}

