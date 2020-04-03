package linklist;

public class Item implements Comparable<Item> {
	/*
	 * 系数
	 */
	private double coef;// 系数
	// 指数
	private int exp;

	public Item(double c, int e) {
		coef = c;
		exp = e;
	}

	public double GetCoef() {
		return coef;
	}

	public void setCoef(int coef) {
		this.coef = coef;
	}

	public int GetExp() {
		return exp;
	}

	public void setExpn(int exp) {
		this.exp = exp;
	}

	public void Add(Item x) {
		if (exp == x.exp)
			coef += x.coef;
	}

	public String toString() {
		return String.valueOf(coef) + "x^" + exp;
	}

	public int compareTo(Item other) {
		if (exp > other.exp)
			return 1;
		else if (exp < other.exp)
			return -1;
		else
			return 0;
	}
}
