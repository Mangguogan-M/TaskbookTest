/**  
* <p>Title: ALGraph.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) May 5, 2019</p>  
* @author ����  
* @date May 5, 2019  
* @version 1.0  
*/
package ALGraph;

//����ͼ���ڽӱ���
class ALGraph {
	private int vexNum, arcNum;// ͼ�ĵ�ǰ�������ͱ���
	private VNode[] vexs;// ����

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

	// ����v��ʾ����ֵ�� 0 <= v < vexNum
	public Object getVex(int v) throws Exception {
		if (v < 0 && v >= vexNum)
			throw new Exception("��" + v + "�����㲻����!");
		return vexs[v].getData();
	}

	// ����v�ĵ�һ���ڽӵ㣬��vû���ڽӵ��򷵻�-1�� 0 <= v < vexnum
	public int firstAdjVex(int v) throws Exception {
		if (v < 0 && v >= vexNum)
			throw new Exception("��" + v + "�����㲻����!");
		VNode vex = vexs[v];
		if (vex.getFirstArc() != null)
			return vex.getFirstArc().getAdjVex();
		else
			return -1;
	}

	// ����v�����w����һ���ڽӵ㣬��w��v�����һ���ڽӵ㣬�򷵻�-1������0��v, w<vexNum
	public int nextAdjVex(int v, int w) throws Exception {
		if (v < 0 && v >= vexNum)
			throw new Exception("��" + v + "�����㲻����!");
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

	// �ڽӱ�����
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
