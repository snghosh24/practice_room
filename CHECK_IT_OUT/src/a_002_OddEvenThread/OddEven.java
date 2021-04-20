package a_002_OddEvenThread;

public class OddEven implements Runnable {

	public int range = 20;
	static int start = 1;
	int remainder;
	static Object lock = new Object();

	OddEven(int remainder) {
		this.remainder = remainder;
	}

	@Override
	public void run() {

		while (start < range) {
			synchronized (lock) {
				while (start % 2 != remainder) {
					try {
						lock.wait();
						Thread.sleep(500);
					} catch (InterruptedException ie) {

					}
				}

				System.out.println(Thread.currentThread().getName() + " :" + start);
				start++;
				lock.notifyAll();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {

				}

			}
		}
	}

}
