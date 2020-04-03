/**  
* <p>Title: Graph.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) May 18, 2019</p>  
* @author 马坤  
* @date May 18, 2019  
* @version 1.0  
*/ 
package Graph;

import java.util.Scanner;

public class Graph<T> {
	protected final int MAXSIZE = 10;//邻接矩阵可以表示的最大定点数
	protected final int MAX = 999;//在网中,表示没有联系
	protected T[] V;//顶点信息
	protected int[][] arcs;//邻接矩阵
	protected int e;//边数
	protected int n;//定点数
	public Graph() {
		V = (T[]) new Object[MAXSIZE];
		arcs = new int [MAXSIZE][MAXSIZE];
	}
	
	public void CreateAdj() {//创建无向图的邻接矩阵
		int i, j, k;
		T v1, v2;
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入图的定点数及变数:");
		System.out.print("定点数 n=");
		n = scanner.nextInt();
		System.out.print("变数: e=");
		e = scanner.nextInt();
		System.out.print("请输入图的定点信息:");
		String str = scanner.next();
		for (i = 0; i < n; i++) {
			V[i] = (T)(Object)str.charAt(i);//构造顶点信息
			for (i = 0; i < n; i++) {
				for (j = 0; j < n; j++) {
					arcs[i][j] = 0;//初始化邻接矩阵
				}
			}
		}
		System.out.print("请输入图的边的信息:");
		System.out.println();
		for (k = 0; k < e; k++) {
			int w;
			System.out.print("请输入第" + (k+1) + "条边的两个端点:");
			str = scanner.next();//请输入一条边的两个顶点
			v1 = (T)(Object)str.charAt(0);
			v2 = (T)(Object)str.charAt(1);
			System.out.print("权值:");
			w = scanner.nextInt();
			i = LocateVex(v1);
			j = LocateVex(v2);
			if (i >= 0 && j >= 0) {
				arcs[i][j] = w;
//				arcs[j][i] = 1;
			}
		}
	}
	
	public int LocateVex(T v) {
		int i;
		for (i = 0; i < n; i++) {
			if (V[i] == v) {
				return i;
			}
		}
		return -1;
	}
	
	public void DisplayAdjMatrix() {
		int i, j;
		System.out.println("图的邻接矩阵表示:");
		for (i = 0; i < n; i++) {
			for(j = 0; j < n; j++) {
				System.out.print("  "+ arcs[i][j]);
			}
			System.out.println();
		}
	}
}


