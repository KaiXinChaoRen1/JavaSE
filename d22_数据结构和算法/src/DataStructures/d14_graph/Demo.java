package DataStructures.d14_graph;

public class Demo {
    public static void main(String[] args) {
/*        //测试一把图是否创建ok
        int n = 5;                      //结点的个数
        String Vertexs[] = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(n);     //创建图对象
        for (String vertex : Vertexs) {   //循环的添加顶点
            graph.insertVertex(vertex);
        }
        //添加边
        graph.insertEdge(0, 1, 1); // A-B
        graph.insertEdge(0, 2, 1); //
        graph.insertEdge(1, 2, 1); //
        graph.insertEdge(1, 3, 1); //
        graph.insertEdge(1, 4, 1); //
        //显示一把邻结矩阵
        graph.showGraph();
        System.out.println("深度遍历");
       // graph.dfs(); // A->B->C->D->E
        System.out.println("广度优先!");
        graph.bfs(); // A->B->C->D-E */

        int n = 8;                      //结点的个数
        String Vertexs[] = {"1", "2", "3", "4", "5","6","7","8"};
        Graph graph = new Graph(n);     //创建图对象
        for (String vertex : Vertexs) {   //循环的添加顶点
            graph.insertVertex(vertex);
        }
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);
        //显示一把邻结矩阵
        graph.showGraph();
        System.out.println("深度优先");
        graph.dfs(); //1->2->4->8->5->3->6->7]
        System.out.println("广度优先!");
        graph.bfs(); // [1->2->3->4->5->6->7->8]*/
    }

}
