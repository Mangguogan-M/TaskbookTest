/**  
* <p>Title: TraverserALGraph.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) May 5, 2019</p>  
* @author 马坤  
* @date May 5, 2019  
* @version 1.0  
*/
package ALGraph;

import linkQueue.linkQueue;

//图的遍历类
class TraverserALGraph {
	private static boolean[] visited;// 访问标志数组

	// 对图G做深度优先遍历
	public static void DFSTraverse(ALGraph G) throws Exception {
		visited = new boolean[G.getVexNum()];
		for (int v = 0; v < G.getVexNum(); v++)
			// 访问标志数组初始化
			visited[v] = false;
		for (int v = 0; v < G.getVexNum(); v++)
			if (!visited[v])// 对尚未访问的顶点调用DFS
				DFS(G, v);
	}

	// 从第v个顶点出发递归地深度优先遍历图G
	public static void DFS(ALGraph G, int v) throws Exception {
		visited[v] = true;
		System.out.print(G.getVex(v).toString() + " ");// 访问第v个顶点
		for (int w = G.firstAdjVex(v); w >= 0; w = G.nextAdjVex(v, w))
			if (!visited[w])// 对v的尚未访问的邻接顶点w递归调用DFS
				DFS(G, w);
	}

	// 对图G做广度优先遍历
	public static void BFSTraverse(ALGraph G) throws Exception {
		visited = new boolean[G.getVexNum()];// 访问标志数组
		for (int v = 0; v < G.getVexNum(); v++)
			// 访问标志数组初始化
			visited[v] = false;
		for (int v = 0; v < G.getVexNum(); v++)
			if (!visited[v]) // v尚未访问
				BFS(G, v);
	}

	private static void BFS(ALGraph G, int v) throws Exception {
		visited[v] = true;
		System.out.print(G.getVex(v).toString() + " ");
		linkQueue Q = new linkQueue();// 辅助队列Q
		Q.EnQueue(v);// v入队列
		while (!Q.isEmpty()) {
			int u = (Integer) Q.DeQueue();// 队头元素出队列并赋值给u
			for (int w = G.firstAdjVex(u); w >= 0; w = G.nextAdjVex(u, w))
				if (!visited[w]) {// w为u的尚未访问的邻接顶点
					visited[w] = true;
					System.out.print(G.getVex(w).toString() + " ");
					Q.EnQueue(w);
					;
				}
		}
	}
}
