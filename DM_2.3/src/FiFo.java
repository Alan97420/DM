import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class FiFo {
	List<Integer> o;
	fenetre f;
	
	// constructeur 
	public FiFo(fenetre f) {
		this.f = f;
		this.o = new ArrayList<Integer>();
	}
	
	public synchronized void remover() throws InterruptedException {
		if (o.isEmpty())return;
		while (o.isEmpty())wait();
		Integer k = o.get(0);
		o.remove(0);
		f.Update(o,k,false);
	}
	public synchronized void adder( int p) throws InterruptedException {
		if (o.size()>19)return;
		o.add(p);
		notifyAll();
		f.Update(o,p,true);
	}
	

}
