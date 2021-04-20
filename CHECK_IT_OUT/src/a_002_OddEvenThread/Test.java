package a_002_OddEvenThread;

public class Test {

	public static void main(String[] args) {

		OddEven oddRunnable = new OddEven(1);
		OddEven evenRunnable = new OddEven(0);

		Thread t1 = new Thread(oddRunnable, "Thread-1");
		Thread t2 = new Thread(evenRunnable, "Thread-2");

		t1.start();
		t2.start();

	}

}
