import javax.swing.JFrame;
import Connection.*;

public class Test {

	public static void main(String[] args) {
		JFrame frame = new Connetti();

		frame.setSize(540, 400);
		frame.setTitle("Campionato");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocation(600, 250);
		frame.setResizable(false);
	}

}
