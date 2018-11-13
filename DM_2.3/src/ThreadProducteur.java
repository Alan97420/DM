import java.util.List;
import java.util.concurrent.*;
public class ThreadProducteur extends Thread {
	public FiFo f;
	public ThreadProducteur(FiFo f) {
		this.f = f;
		this.setDaemon(true);
	}
	
	 public void run() {
	      System.out.println("Producteur Commence");
	      try {
	         while(true) {
	        		 int v =(int)(Math.random()*(100-1+1)+1);
	        		 f.adder(v);
	        		 Thread.currentThread();
				 Thread.sleep(300);
	         }
	      } catch (Exception ex) {
	         ex.printStackTrace();
	      }
	 }    
}
