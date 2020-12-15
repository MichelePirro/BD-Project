import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import Connection.*;
import Query.QueryTotale;

public class Test {

	public static void main(String[] args) {
		JFrame frame = new Connetti();
		ImageIcon immagine = new ImageIcon(Test.class.getResource("/pallone.jpg"));
		frame.setIconImage(immagine.getImage());
		frame.setSize(680, 600);
		frame.setTitle("Campionato");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocation(500, 200);
		frame.setResizable(false);
	}

}
