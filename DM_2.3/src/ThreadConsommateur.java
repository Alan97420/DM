import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class ThreadConsommateur extends Thread {
	public FiFo f;
	public ThreadConsommateur( FiFo f) {
		this.f=f;
		this.setDaemon(true);
	}

	   public void run() {
		      System.out.println("Consumer Started");
		      while(true) {
		      try {
		    	  	
		    	  		f.remover();
		            Thread.currentThread();
					Thread.sleep(900);
		         } catch (Exception ex) {
		            ex.printStackTrace();
		         }
		      }
	   }
}