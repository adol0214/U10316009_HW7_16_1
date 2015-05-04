import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TestImageIcon extends JFrame {

	JButton jbtRefresh = new JButton("Refresh");

	Shuffle poker = new Shuffle();

	JPanel panel = new JPanel();
	
	JLabel pic1;
	JLabel pic2;
	JLabel pic3;
	JLabel pic4;
	
  public TestImageIcon() {

	poker.add(jbtRefresh);
	//設定畫面的初始情況
	panel.setLayout(new GridLayout(1, 4));
	panel.add(pic1);
	panel.add(pic2);
	panel.add(pic3);
	panel.add(pic4);
	
	this.add(panel, BorderLayout.CENTER);
	this.add(jbtRefresh, BorderLayout.SOUTH);
	
	//設定按按鍵後的情況
	jbtRefresh.addActionListener(new ActionListener(){ 
	      @Override 
	      public void actionPerformed(ActionEvent e) {
			panel.remove(pic1);
			panel.remove(pic2);
			panel.remove(pic3);
			panel.remove(pic4);
	        poker.refresh();
			panel.add(pic1);
			panel.add(pic2);
			panel.add(pic3);
			panel.add(pic4);
			panel.repaint();
	      }
	    }
	);
	
  }

  /** Main method */
  public static void main(String[] args) {
	  TestImageIcon frame = new TestImageIcon();
	  frame.setTitle("U10316009");
	  frame.setSize(500, 250);
	  frame.setLocationRelativeTo(null); // Center the frame
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  frame.setVisible(true);
	}
 
	
	class Shuffle extends JButton{
		
		ImageIcon poker1;
		ImageIcon poker2;
		ImageIcon poker3;
		ImageIcon poker4;
		
		int[] deck = new int[52];
		
		public Shuffle(){
			refresh();
		}
		
		public void refresh(){
			poker1 = null;
			poker2 = null;
			poker3 = null;
			poker4 = null;
			// Initialize cards
			for (int i = 0; i < deck.length; i++)
				deck[i] = i + 1;
    
			// Shuffle the cards
			for (int i = 0; i < deck.length; i++) {
				// Generate an index randomly
				int index = (int)(Math.random() * deck.length);
				int temp = deck[i];
				deck[i] = deck[index]; 
				deck[index] = temp;
			}

			// Display the first four cards
			
			poker1= new ImageIcon("card/" + deck[0]+".png");
			poker2= new ImageIcon("card/" + deck[1]+".png");
			poker3= new ImageIcon("card/" + deck[2]+".png");
			poker4= new ImageIcon("card/" + deck[3]+".png");
			pic1 = new JLabel(poker1);
			pic2 = new JLabel(poker2);
			pic3 = new JLabel(poker3);
			pic4 = new JLabel(poker4);
		}
	}
}
