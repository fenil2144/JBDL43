package Session3;

class ThreadA extends Thread{
	
	public void run() {
		System.out.println("ThreadA "+Thread.currentThread());
		for(int i=20;i>0;i--) {
			System.out.println("ThreadA class with i = "+i);
		}
	}
}

class ThreadRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println("ThreadRunnable "+Thread.currentThread());
		for(int i=20;i>0;i--) {
			System.out.println("ThreadRunnable class with i = "+i);
		}
	}
	
}

public class ThreadBasicExample {
	
	public static void main(String args[]) {
		System.out.println("Main "+Thread.currentThread());
		
		ThreadA threadAObj = new ThreadA();
		threadAObj.start();
		
		ThreadRunnable threadObj = new ThreadRunnable();
		Thread t1 = new Thread(threadObj);
		t1.start();
		threadObj.run();
		
	}
	
}
