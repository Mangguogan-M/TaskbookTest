/**  
* <p>Title: Graph.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) May 18, 2019</p>  
* @author ����  
* @date May 18, 2019  
* @version 1.0  
*/ 
package Graph;

import java.util.Scanner;

public class Graph<T> {
	protected final int MAXSIZE = 10;//�ڽӾ�����Ա�ʾ����󶨵���
	protected final int MAX = 999;//������,��ʾû����ϵ
	protected T[] V;//������Ϣ
	protected int[][] arcs;//�ڽӾ���
	protected int e;//����
	protected int n;//������
	public Graph() {
		V = (T[]) new Object[MAXSIZE];
		arcs = new int [MAXSIZE][MAXSIZE];
	}
	
	public void CreateAdj() {//��������ͼ���ڽӾ���
		int i, j, k;
		T v1, v2;
		Scanner scanner = new Scanner(System.in);
		System.out.println("������ͼ�Ķ�����������:");
		System.out.print("������ n=");
		n = scanner.nextInt();
		System.out.print("����: e=");
		e = scanner.nextInt();
		System.out.print("������ͼ�Ķ�����Ϣ:");
		String str = scanner.next();
		for (i = 0; i < n; i++) {
			V[i] = (T)(Object)str.charAt(i);//���춥����Ϣ
			for (i = 0; i < n; i++) {
				for (j = 0; j < n; j++) {
					arcs[i][j] = 0;//��ʼ���ڽӾ���
				}
			}
		}
		System.out.print("������ͼ�ıߵ���Ϣ:");
		System.out.println();
		for (k = 0; k < e; k++) {
			int w;
			System.out.print("�������" + (k+1) + "���ߵ������˵�:");
			str = scanner.next();//������һ���ߵ���������
			v1 = (T)(Object)str.charAt(0);
			v2 = (T)(Object)str.charAt(1);
			System.out.print("Ȩֵ:");
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
		System.out.println("ͼ���ڽӾ����ʾ:");
		for (i = 0; i < n; i++) {
			for(j = 0; j < n; j++) {
				System.out.print("  "+ arcs[i][j]);
			}
			System.out.println();
		}
	}
}


