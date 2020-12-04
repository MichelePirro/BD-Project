package Inserimento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class InserisciStadio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4871388245355308251L;

	private JTextField CodSt;
	private JTextField CostoBigl;
	private JTextField PostiDisp;
	private JTextField PostiOcc;
	private JLabel n1;
	private JLabel n2;
	private JLabel n3;
	private JLabel n4;
	private JPanel pannello;
	private JButton bottone;

	public InserisciStadio(Connection con) {
		CodSt = new JTextField(20);
		CostoBigl = new JTextField(20);
		PostiDisp = new JTextField(20);
		PostiOcc = new JTextField(20);
		n1 = new JLabel("Inserisci nome Stadio:");
		n2 = new JLabel("Inserisci costo biglietto:");
		n3 = new JLabel("Inserisci posti disponibili:");
		n4 = new JLabel("Inserisci posti occupati:");
		pannello = new JPanel();
		bottone = new JButton("Invia");

		bottone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
					PreparedStatement query = (PreparedStatement) con
							.prepareStatement("INSERT INTO Stadio(CodSt,CostoBigl,PostiDisp,PostiOcc)\n" + "value('"
									+ CodSt.getText() + "','" + CostoBigl.getText() + "','" + PostiDisp.getText()
									+ "','" + PostiOcc.getText() + "');");
					query.executeUpdate();
					JOptionPane.showMessageDialog(null, "Inserimento effettuato con successo.");
					InserisciStadio.this.setVisible(false);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Errore nell'inserimento, riprova.");
				}
			}
		});

		pannello.add(n1);
		pannello.add(CodSt);
		pannello.add(n2);
		pannello.add(CostoBigl);
		pannello.add(n3);
		pannello.add(PostiDisp);
		pannello.add(n4);
		pannello.add(PostiOcc);
		pannello.add(bottone);

		this.add(pannello);
	}
}
