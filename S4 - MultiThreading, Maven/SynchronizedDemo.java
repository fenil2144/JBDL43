package Session4;

class Sender {
	public synchronized void send(String msg) {
		System.out.println("\n"+msg+" sent");
	}
}

class ThreadSend extends Thread{
	
	private String msg;
	Sender sender;
	
	ThreadSend(String msg,Sender sender){
		this.msg = msg;
		this.sender= sender;
	}
	
	public void run() {
		sender.send(msg);
	}
}
public class SynchronizedDemo {
	
	public static void main(String args[]) {
		
		Sender send = new Sender();
		
		ThreadSend s1 = new ThreadSend("Hi ", send);
		ThreadSend s2 = new ThreadSend("Bye ", send);
		
		s1.start();
		s2.start();
	}
	
	

}
