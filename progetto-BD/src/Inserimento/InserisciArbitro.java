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

public class InserisciArbitro extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4871388245355308251L;

	private JTextField CodAr;
	private JTextField Nome;
	private JTextField Cognome;
	private JTextField Tipologia;
	private JLabel n1;
	private JLabel n2;
	private JLabel n3;
	private JLabel n4;
	private JPanel pannello;
	private JButton bottone;

	public InserisciArbitro(Connection con) {
		CodAr = new JTextField(20);
		Nome = new JTextField(20);
		Cognome = new JTextField(20);
		Tipologia = new JTextField(20);
		n1 = new JLabel("Inserisci codice Arbitro:");
		n2 = new JLabel("Inserisci nome:");
		n3 = new JLabel("Inserisci cognome:");
		n4 = new JLabel("Inserisci tipolgia:");
		pannello = new JPanel();
		bottone = new JButton("Invia");

		bottone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
					PreparedStatement query = (PreparedStatement) con
							.prepareStatement("INSERT INTO Arbitro(CodAr,Nome,Cognome,Tipologia)\n" + "value('"
									+ CodAr.getText() + "','" + Nome.getText() + "','"
									+ Cognome.getText() + "','" + Tipologia.getText() + "');");
					query.executeUpdate();
					JOptionPane.showMessageDialog(null, "Inserimento effettuato con successo.");
					InserisciArbitro.this.setVisible(false);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Errore nell'inserimento, riprova.");
				}
			}
		});

		pannello.add(n1);
		pannello.add(CodAr);
		pannello.add(n2);
		pannello.add(Nome);
		pannello.add(n3);
		pannello.add(Cognome);
		pannello.add(n4);
		pannello.add(Tipologia);
		pannello.add(bottone);
		

		this.add(pannello);
	}
}
