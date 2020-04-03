public class Text {
	public static void main(String args[]) {
		Map<String, String> aMap = new Map<String, String>();
		aMap.set("China", "ÖÐ¹ú");
		System.out.println(aMap.get());
		Map<Integer, String> bMap = new Map<Integer, String>();
		bMap.set(21, "10101");
		System.out.println(bMap.get());
	}
}
