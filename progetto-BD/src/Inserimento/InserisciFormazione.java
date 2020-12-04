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

public class InserisciFormazione extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4871388245355308251L;

	private JTextField CodF;
	private JTextField Modulo;
	private JTextField Sostituti;
	private JLabel n1;
	private JLabel n3;
	private JLabel n4;
	private JPanel pannello;
	private JButton bottone;

	public InserisciFormazione(Connection con) {
		CodF = new JTextField(20);
		Modulo = new JTextField(20);
		Sostituti = new JTextField(20);
		n1 = new JLabel("Inserisci codice formazione:");
		n3 = new JLabel("Inserisci modulo:");
		n4 = new JLabel("Inserisci numero sostituti:");
		pannello = new JPanel();
		bottone = new JButton("Invia");

		bottone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
					PreparedStatement query = (PreparedStatement) con
							.prepareStatement("INSERT INTO Formazione(CodF,Modulo,Sostituti)\n" + "value('"
									+ CodF.getText() + "','" + Modulo.getText() + "','" + Sostituti.getText() + "');");
					query.executeUpdate();
					JOptionPane.showMessageDialog(null, "Inserimento effettuato con successo.");
					InserisciFormazione.this.setVisible(false);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Errore nell'inserimento, riprova.");
				}
			}
		});

		pannello.add(n1);
		pannello.add(CodF);
		pannello.add(n3);
		pannello.add(Modulo);
		pannello.add(n4);
		pannello.add(Sostituti);
		pannello.add(bottone);

		this.add(pannello);
	}
}
