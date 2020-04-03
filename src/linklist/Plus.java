package linklist;

import java.util.Scanner;

public class Plus {
	static <T extends Item> linkList<T> polyAdd(linkList<T> b1, linkList<T> b2){
		linkList<T> b3 = new linkList<T>();
		int i1 = 1;
		int i2 = 2;
		while(i1 <= b1.size() && i2 <= b2.size()) {
			T x1 = b1.value(i1), x2 = b2.value(i2);
			if (x1.compareTo(x2) < 0) {
				b3.add(x1, b3.size() + 1);
				i1++;
			}else if(x1.compareTo(x2) > 0){
				b3.add(x2, b3.size() + 1);
				i2++;
			}else {
				double y = x1.GetCoef() + x2.GetCoef();
				if (Math.abs(y) > 1.0E-6) {
					x1.Add(x2);
					b3.add(x1, b3.size() + 1);
				}
				i1++;
				i2++;
			}
		}
		while (i1 <= b1.size()) {
			b3.add(b1.value(i1), b3.size() + 1);
			i1++;
		}
		while (i2 <= b2.size()) {
			b3.add(b1.value(i2), b3.size() + 1);
			i2++;
		}
		return b3;
	}
	/*
	 * main类
	 */
	public static void main(String[] args) {
		linkList<Item> a = new linkList<>();
		linkList<Item> b = new linkList<>();
		Scanner input = new Scanner(System.in);
		double coef;
		int exp;
		int aSize;
		int bSize;
		System.out.println("请输入第一个多项式的项数：");
		aSize = input.nextInt();
		a.setLength(aSize);
		for (int i = 1; i <= aSize; i++) {
			System.out.println("请输入系数和指数：");
			coef = input.nextDouble();
			exp = input.nextInt();
			Item item = new Item(coef, exp);
			a.add(item, i);
		}
		
		System.out.println("请输入第二个多项式的项数：");
		bSize = input.nextInt();
		b.setLength(bSize);
		for (int i = 1; i <= bSize; i++) {
			System.out.println("请输入系数和指数：");
			coef = input.nextDouble();
			exp = input.nextInt();
			Item item = new Item(coef, exp);
			b.add(item, i);
		}
		
		int a1 = a.size();
		System.out.println(a1);
		int b1 = b.size();
		System.out.println(b1);
		
		linkList<Item> c = polyAdd(a, b);
		
		int c1 = c.size();
		System.out.println(c1);
//		Item result;
//		String str = "最后的结果：";
//		for (int i = 1; i <= (aSize>bSize?aSize:bSize); i++) {
//			result = c.value(i);
//			str += result.toString();
//			for (int j = 1; j < (aSize>bSize?aSize:bSize); j++) {
//				str += "+";
//			}
//		}
		
//		System.out.println(str);
		
//		c.nextOrder();
	}
}
