package coinpurse;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class StatusObserver extends JFrame implements Observer {

	private JTextArea textArea;
	private JProgressBar progressBar;
	private final int FONT_SIZE = 40;
	public StatusObserver() {
		this.setTitle("Purse Status");
	}
	
	public void update(Observable subject, Object info) {
		Purse purse = new Purse(0);
		if (subject instanceof Purse) {
			purse = (Purse) subject;
			if (purse.isFull()) textArea.setText("FULL");
			else if (purse.count() == 0) textArea.setText("EMPTY");
			else textArea.setText(purse.count() + "/" + purse.getCapacity());
			progressBar.setMinimum(0);
			progressBar.setMaximum(purse.getCapacity());
			progressBar.setValue(purse.count());
		}
	}
	
	private void initComponents() {
		textArea = new JTextArea(2, 10);
		progressBar = new JProgressBar();
		textArea.setText("EMPTY");
		textArea.setFont(new Font(Font.DIALOG, Font.PLAIN, FONT_SIZE));
		
		this.add(textArea, BorderLayout.NORTH);
		this.add(progressBar, BorderLayout.SOUTH);
		this.pack();
	}
	
	public void run() {
		initComponents();
		this.setVisible(true);
	}
}
