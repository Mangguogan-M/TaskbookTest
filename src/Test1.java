public class Test1 {
	public static void main(String[] args) {
		long starTime = System.currentTimeMillis();
		int sum = 0;
		int n = 1000;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 < n; j2++) {
					sum = i + j + j2;
				}
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println(sum);
		System.out.println("程序运行时间：" + (endTime - starTime) + "ms");
	}
}
