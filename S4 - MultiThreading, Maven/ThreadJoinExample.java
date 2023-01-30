package Session4;


class ThreadJoining extends Thread{
	
	public void run() {
		for(int i=0;i<2;i++) {
			try {
				Thread.sleep(300);
				System.out.println("Current Thread: "+Thread.currentThread());
				if(Thread.currentThread().getName().equals("Thread-0"))
					throw new InterruptedException();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}
}
public class ThreadJoinExample {
	
	public static void main(String args[]) throws InterruptedException {
		
		ThreadJoining t1 = new ThreadJoining();
		ThreadJoining t2 = new ThreadJoining();
		ThreadJoining t3 = new ThreadJoining();
		
		t1.start();
		t2.start();

		
//		t1.setDaemon(true);
		
		System.out.println("Current thread "+Thread.currentThread().getName());
		t1.join();
		t2.join();
		t3.start();
		t3.join();
		System.out.println("Total Memory to JVM "+(Runtime.getRuntime().totalMemory()/(1024*1024))+ " MB");
	}

}
