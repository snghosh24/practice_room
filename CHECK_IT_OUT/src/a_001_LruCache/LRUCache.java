package a_001_LruCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	final Node head = new Node();
	final Node tail = new Node();

	int capacity;
	Map<Integer, Node> map;

	public LRUCache(int capacity) {

		this.capacity = capacity;
		map = new HashMap<>();

		head.next = tail;
		tail.prev = head;
	}

	// Node will be added always after head
	private void addNode(Node node) {

		Node head_next = head.next;

		head.next = node;
		node.prev = head;

		node.next = head_next;
		head_next.prev = node;
	}

	// Node will be removed from LinkedList
	private void removeNode(Node node) {

		node.next.prev = node.prev;
		node.prev.next = node.next;
	}

	// On get and override put, Node will be moved to head as most recent used node
	private void moveToHead(Node node) {

		this.removeNode(node);
		this.addNode(node);

	}

	// Least recent node will be moved out once size> capacity
	private Node popTail() {

		Node temp = tail.prev;
		this.removeNode(temp);
		return temp;
	}

	// call of get() means node is recently used
	public int get(int key) {

		Node node = map.get(key);
		if (node == null) {
			return -1;
		}

		this.moveToHead(node);
		return node.val;
	}

	// call of put() means node is recently used in case of new value/override value
	public void put(int key, int value) {

		Node node = map.get(key);
		if (node != null) {
			node.val = value;
			this.moveToHead(node);
		} else {
			if (map.size() == capacity) {
				Node temp = this.popTail();
				map.remove(temp.key);

			}

			Node newNode = new Node();
			newNode.key = key;
			newNode.val = value;

			this.addNode(newNode);
			map.put(key, newNode);
		}

	}

	public void printCache() {

		Node curr = tail.prev;

		System.out.println("---------");
		while (curr != head) {

			System.out.print(curr.val + "|");
			curr = curr.prev;
		}
		System.out.println();
		System.out.println("---------");
		System.out.println();

	}

}
