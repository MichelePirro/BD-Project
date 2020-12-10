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

public class InserisciDirigenza extends JFrame {

	private static final long serialVersionUID = 4871388245355308251L;

	private JTextField CodDir;
	private JTextField CodT;
	private JTextField Sede;
	private JTextField NomeDir;
	private JTextField Durata;
	private JLabel n1;
	private JLabel n2;
	private JLabel n3;
	private JLabel n4;
	private JLabel n5;
	private JPanel pannello;
	private JButton bottone;

	public InserisciDirigenza(Connection con) {
		CodDir = new JTextField(20);
		CodT = new JTextField(20);
		Sede = new JTextField(20);
		NomeDir = new JTextField(20);
		Durata = new JTextField(20);
		n1 = new JLabel("Inserisci codice dirigenza:");
		n2 = new JLabel("Inserisci codice allenatore:");
		n3 = new JLabel("Inserisci sede:");
		n4 = new JLabel("Inserisci nome dirigenza:");
		n5 = new JLabel("Inserisci durata contratto in giorni:");
		pannello = new JPanel();
		bottone = new JButton("Invia");

		bottone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
					PreparedStatement query = (PreparedStatement) con
							.prepareStatement("INSERT INTO Dirigenza(CodDir,CodT,Sede,NomeDir,Durata)\n" + "value('"
									+ CodDir.getText() + "','" + CodT.getText() + "','" + Sede.getText() + "','"
									+ NomeDir.getText() + "','" + Durata.getText() + "');");
					query.executeUpdate();
					JOptionPane.showMessageDialog(null, "Inserimento effettuato con successo.");
					InserisciDirigenza.this.setVisible(false);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Errore nell'inserimento, riprova.");
				}
			}
		});

		pannello.add(n1);
		pannello.add(CodDir);
		pannello.add(n2);
		pannello.add(CodT);
		pannello.add(n3);
		pannello.add(Sede);
		pannello.add(n4);
		pannello.add(NomeDir);
		pannello.add(n5);
		pannello.add(Durata);
		pannello.add(bottone);

		this.add(pannello);
	}
}
