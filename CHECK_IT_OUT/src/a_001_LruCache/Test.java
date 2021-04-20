package a_001_LruCache;

public class Test {

	public static void main(String[] args) {
		
		LRUCache lru = new LRUCache(3);

		lru.put(1, 10);
		lru.put(2, 20);
		lru.put(3, 30);
		lru.printCache();
		lru.put(4, 40);
		lru.printCache();
		System.out.println(lru.get(2));
		lru.printCache();
		lru.put(5, 50);
		lru.printCache();
		lru.put(2, 21);
		lru.printCache();

	}

}
