import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
public class Main {
	public static void main(String[]args) {
		fenetre fen = new fenetre();
		FiFo f = new FiFo(fen);
		ThreadProducteur Prod = new ThreadProducteur(f);
		ThreadConsommateur Conso = new ThreadConsommateur(f);
		Prod.start();
		Conso.start();
		(new Scanner(System.in)).nextLine();
	  }
}
