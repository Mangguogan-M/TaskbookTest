/**  
* <p>Title: ArcNode.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) May 5, 2019</p>  
* @author 马坤  
* @date May 5, 2019  
* @version 1.0  
*/
package ALGraph;

//图的邻接表存储表示中的弧结点类
class ArcNode {
	private int adjVex;// 该弧所指向的顶点位置
	private ArcNode nextArc;// 指向下一条弧

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
