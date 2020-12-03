package Inserimento;

import java.awt.BorderLayout;
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

public class InserisciSquadra extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8712115776147084860L;

	private JLabel codice;
	private JLabel nome;
	private JLabel campionato;
	private JTextField tcodice;
	private JTextField tnome;
	private JTextField tcampionato;
	private JButton bottone;
	private JPanel pannello;

	public InserisciSquadra(Connection con) {
		codice = new JLabel("Inserisci codice squadra:");
		tcodice = new JTextField(20);
		nome = new JLabel("Inserisci nome squadra:");
		tnome = new JTextField(20);
		campionato = new JLabel("Inserisci codice del campionato:");
		tcampionato = new JTextField(20);
		bottone = new JButton("Invia");
		pannello = new JPanel();

		bottone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
					PreparedStatement query = (PreparedStatement) con
							.prepareStatement("INSERT INTO Squadra(CodS,NomeS,CodC)\n" + "value('" + tcodice.getText()
									+ "','" + tnome.getText() + "','" + tcampionato.getText() + "');");
					query.executeUpdate();
					JOptionPane.showMessageDialog(null, "Inserimento effettuato con successo.");
					InserisciSquadra.this.setVisible(false);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Errore nell'inserimento, riprova.");
				}
			}
		});

		pannello.add(codice);
		pannello.add(tcodice);
		pannello.add(nome);
		pannello.add(tnome);
		pannello.add(campionato);
		pannello.add(tcampionato);
		pannello.add(bottone);

		this.add(pannello, BorderLayout.CENTER);
	}
}
