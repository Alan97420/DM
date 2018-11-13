import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
public class fenetre extends JFrame {
	
	protected JLabel txt;
	protected JLabel prodTxt;
	protected JLabel consTxt;
	
	public fenetre() {
		this.setTitle("Ma première fenêtre Java");
	    this.setSize(500, 500);
	    this.setLocationRelativeTo(null);               
	 
	    //Instanciation d'un objet JPanel
	    JPanel pan = new JPanel();
	    //Définition de sa couleur de fond
	    pan.setBackground(Color.ORANGE);        
	    //On prévient notre JFrame que notre JPanel sera son content pane
	    
	    	txt = new JLabel("File : <>");
	    	pan.add(txt);
	    	prodTxt = new JLabel();
	    	pan.add(prodTxt);
	    	consTxt = new JLabel();
	    	pan.add(consTxt);
	    	
		
	    	this.setContentPane(pan);
	    this.setVisible(true);
	  }
	
	public void Update(List<Integer> l, int k, boolean add)
	{
		String str = "<";
		for(int i = 0; i<l.size() ;i++) {
			str += Integer.toString(l.get(i));
			str += (i + 1 < l.size())?" , ":"";
		}
		str += ">";
		txt.setText(str);
		
		if(add) {
			prodTxt.setText("L'élément "+Integer.toString(k)+" a été ajouté.");
		}
		else {
			consTxt.setText("L'élément "+Integer.toString(k)+" a été supprimé.");
		}
		//this.repaint();
	}
	

}
