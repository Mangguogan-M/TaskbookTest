package Chapter.fanxing;

public class GeneMethodDemo {

	public static void main(String[] args) {
		NewPoint<Integer, Integer> p1 = new NewPoint<Integer, Integer>();
		p1.setX(10);
		p1.setY(20);
		p1.printPoint(p1.getX(), p1.getY());
		NewPoint<Double, String> p2 = new NewPoint<Double, String>();
		p2.setX(25.4);
		p2.setY("¶«¾­180¶È¡£");
		p2.printPoint(p2.getX(), p2.getY());
	}

}
