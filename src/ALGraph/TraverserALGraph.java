/**  
* <p>Title: TraverserALGraph.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) May 5, 2019</p>  
* @author ����  
* @date May 5, 2019  
* @version 1.0  
*/
package ALGraph;

import linkQueue.linkQueue;

//ͼ�ı�����
class TraverserALGraph {
	private static boolean[] visited;// ���ʱ�־����

	// ��ͼG��������ȱ���
	public static void DFSTraverse(ALGraph G) throws Exception {
		visited = new boolean[G.getVexNum()];
		for (int v = 0; v < G.getVexNum(); v++)
			// ���ʱ�־�����ʼ��
			visited[v] = false;
		for (int v = 0; v < G.getVexNum(); v++)
			if (!visited[v])// ����δ���ʵĶ������DFS
				DFS(G, v);
	}

	// �ӵ�v����������ݹ��������ȱ���ͼG
	public static void DFS(ALGraph G, int v) throws Exception {
		visited[v] = true;
		System.out.print(G.getVex(v).toString() + " ");// ���ʵ�v������
		for (int w = G.firstAdjVex(v); w >= 0; w = G.nextAdjVex(v, w))
			if (!visited[w])// ��v����δ���ʵ��ڽӶ���w�ݹ����DFS
				DFS(G, w);
	}

	// ��ͼG��������ȱ���
	public static void BFSTraverse(ALGraph G) throws Exception {
		visited = new boolean[G.getVexNum()];// ���ʱ�־����
		for (int v = 0; v < G.getVexNum(); v++)
			// ���ʱ�־�����ʼ��
			visited[v] = false;
		for (int v = 0; v < G.getVexNum(); v++)
			if (!visited[v]) // v��δ����
				BFS(G, v);
	}

	private static void BFS(ALGraph G, int v) throws Exception {
		visited[v] = true;
		System.out.print(G.getVex(v).toString() + " ");
		linkQueue Q = new linkQueue();// ��������Q
		Q.EnQueue(v);// v�����
		while (!Q.isEmpty()) {
			int u = (Integer) Q.DeQueue();// ��ͷԪ�س����в���ֵ��u
			for (int w = G.firstAdjVex(u); w >= 0; w = G.nextAdjVex(u, w))
				if (!visited[w]) {// wΪu����δ���ʵ��ڽӶ���
					visited[w] = true;
					System.out.print(G.getVex(w).toString() + " ");
					Q.EnQueue(w);
					;
				}
		}
	}
}
