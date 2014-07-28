package ruandao.thread;

public class MyRunnable implements Runnable{

	public static void main(String[] args) {
		//new MyRunnable().run();
		//new MyRunnable().run();
		
		Thread t1 = new Thread(new MyRunnable());
		Thread t2 = new Thread(new MyRunnable());
		t1.start();
		t2.start();
	}

	private int count = 0;
	@Override
	public void run(){
		while(count < 10 ){
			count++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Count is: " + this.count );
		}
		count = 0;
	}

}
