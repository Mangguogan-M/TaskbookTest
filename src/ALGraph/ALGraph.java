/**  
* <p>Title: ALGraph.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) May 5, 2019</p>  
* @author 马坤  
* @date May 5, 2019  
* @version 1.0  
*/
package ALGraph;

//无向图的邻接表类
class ALGraph {
	private int vexNum, arcNum;// 图的当前顶点数和边数
	private VNode[] vexs;// 顶点

	public ALGraph() {
		this(0, 0, null);
	}

	public ALGraph(int vexNum, int arcNum, VNode[] vexs) {
		this.vexNum = vexNum;
		this.arcNum = arcNum;
		this.vexs = vexs;
	}

	public int getArcNum() {
		return arcNum;
	}

	public void setArcNum(int arcNum) {
		this.arcNum = arcNum;
	}

	public int getVexNum() {
		return vexNum;
	}

	public void setVexNum(int vexNum) {
		this.vexNum = vexNum;
	}

	public VNode[] getVexs() {
		return vexs;
	}

	public void setVexs(VNode[] vexs) {
		this.vexs = vexs;
	}

	// 返回v表示结点的值， 0 <= v < vexNum
	public Object getVex(int v) throws Exception {
		if (v < 0 && v >= vexNum)
			throw new Exception("第" + v + "个顶点不存在!");
		return vexs[v].getData();
	}

	// 返回v的第一个邻接点，若v没有邻接点则返回-1， 0 <= v < vexnum
	public int firstAdjVex(int v) throws Exception {
		if (v < 0 && v >= vexNum)
			throw new Exception("第" + v + "个顶点不存在!");
		VNode vex = vexs[v];
		if (vex.getFirstArc() != null)
			return vex.getFirstArc().getAdjVex();
		else
			return -1;
	}

	// 返回v相对于w的下一个邻接点，若w是v的最后一个邻接点，则返回-1，其中0≤v, w<vexNum
	public int nextAdjVex(int v, int w) throws Exception {
		if (v < 0 && v >= vexNum)
			throw new Exception("第" + v + "个顶点不存在!");
		VNode vex = vexs[v];
		ArcNode arcvw = null;
		for (ArcNode arc = vex.getFirstArc(); arc != null; arc = arc.getNextArc())
			if (arc.getAdjVex() == w) {
				arcvw = arc;
				break;
			}
		if (arcvw != null && arcvw.getNextArc() != null)
			return arcvw.getNextArc().getAdjVex();
		else
			return -1;
	}

	// 邻接表的输出
	public void displayALGraph() {
		for (int i = 0; i < vexs.length; i++) {
			System.out.print(vexs[i].getData().toString() + ":");
			ArcNode p = vexs[i].getFirstArc();
			while (p != null) {
				System.out.print(p.getAdjVex() + "  ");
				p = p.getNextArc();
			}
			System.out.println();
		}
	}
}
