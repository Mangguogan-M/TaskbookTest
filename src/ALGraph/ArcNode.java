/**  
* <p>Title: ArcNode.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) May 5, 2019</p>  
* @author ����  
* @date May 5, 2019  
* @version 1.0  
*/
package ALGraph;

//ͼ���ڽӱ�洢��ʾ�еĻ������
class ArcNode {
	private int adjVex;// �û���ָ��Ķ���λ��
	private ArcNode nextArc;// ָ����һ����

	public ArcNode() {
		this(-1, null);
	}

	public ArcNode(int adjVex) {
		this(adjVex, null);
	}

	public ArcNode(int adjVex, ArcNode nextArc) {
		this.adjVex = adjVex;
		this.nextArc = nextArc;
	}

	public ArcNode getNextArc() {
		return nextArc;
	}

	public int getAdjVex() {
		return adjVex;
	}

	public void setAdjVex(int adjVex) {
		this.adjVex = adjVex;
	}

	public void setNextArc(ArcNode nextArc) {
		this.nextArc = nextArc;
	}
}
