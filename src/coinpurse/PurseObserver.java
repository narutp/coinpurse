package coinpurse;

import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class PurseObserver extends JFrame implements Observer{
	
	private JTextArea textArea;
	private int FONT_SIZE = 40;
	public PurseObserver() {
		this.setTitle("Purse Balance");
	}
	
	public void update(Observable subject, Object info) {
//		if (info != null) textArea.append(info + "\n");
		Purse purse = new Purse(0);
		if (subject instanceof Purse) {
			purse = (Purse) subject;
			int balance = (int) purse.getBalance();
//			textArea.append("Balance is: " + balance + "\n");
		}
		textArea.setText(purse.getBalance() + " " + purse.getCurrency());
	}
	
	private void initComponents() {
		textArea = new JTextArea(2, 10);
		textArea.setFont(new Font(Font.DIALOG, Font.PLAIN, FONT_SIZE));
		
		this.add(textArea);
		this.pack();
	}
	
	public void run() {
		initComponents();
		this.setVisible(true);
	}
}
