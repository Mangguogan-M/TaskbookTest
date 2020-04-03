
public class Map <K, V>{//指定类型参数
	K k;
	V v;
	public void set(K key, V value) {
		k = key;
		v = value;
	}
	public V get() {
		return v;
	}
}
