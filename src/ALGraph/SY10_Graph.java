/**  
* <p>Title: SY10_Graph.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) May 5, 2019</p>  
* @author 马坤  
* @date May 5, 2019  
* @version 1.0  
*/
package ALGraph;

//测试类
public class SY10_Graph {
	public static ALGraph generateALGraph() { // 创建如图10-1所示的无向图的邻接表
		ArcNode v01 = new ArcNode(1);
		ArcNode v02 = new ArcNode(2, v01);
		ArcNode v03 = new ArcNode(3, v02);
		VNode v0 = new VNode("v0", v03);

		ArcNode v10 = new ArcNode(0);
		ArcNode v12 = new ArcNode(2, v10);
		ArcNode v14 = new ArcNode(4, v12);
		VNode v1 = new VNode("v1", v14);

		ArcNode v20 = new ArcNode(0);
		ArcNode v21 = new ArcNode(1, v20);
		ArcNode v23 = new ArcNode(3, v21);
		ArcNode v24 = new ArcNode(4, v23);
		VNode v2 = new VNode("v2", v24);

		ArcNode v30 = new ArcNode(0);
		ArcNode v32 = new ArcNode(2, v30);
		ArcNode v34 = new ArcNode(4, v32);
		VNode v3 = new VNode("v3", v34);

		ArcNode v41 = new ArcNode(1);
		ArcNode v42 = new ArcNode(2, v41);
		ArcNode v43 = new ArcNode(3, v42);
		VNode v4 = new VNode("v4", v43);

		VNode[] vexs = { v0, v1, v2, v3, v4 };
		ALGraph G = new ALGraph(5, 16, vexs);
		return G;
	}

	public static void main(String[] args) throws Exception {
		ALGraph G = generateALGraph();
		G.displayALGraph();

		System.out.print("无向图的广度优先遍历序列为：");
		TraverserALGraph.BFSTraverse(G);
		System.out.println();
		System.out.print("无向图的深度优先遍历序列为：");
		TraverserALGraph.DFSTraverse(G);
		System.out.println();
	}
}
