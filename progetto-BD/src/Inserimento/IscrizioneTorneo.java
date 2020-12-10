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

public class IscrizioneTorneo extends JFrame {

	private static final long serialVersionUID = -8712115776147084860L;

	private JLabel codicet;
	private JLabel codices;
	private JTextField tcodice;
	private JTextField scodice;
	private JButton bottone;
	private JPanel pannello;

	public IscrizioneTorneo(Connection con) {
		codicet = new JLabel("Inserisci codice torneo:");
		tcodice = new JTextField(20);
		codices = new JLabel("Inserisci codice squadra da iscrivere:");
		scodice = new JTextField(20);
		bottone = new JButton("Iscrivi");
		pannello = new JPanel();

		bottone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
					PreparedStatement query = (PreparedStatement) con
							.prepareStatement("INSERT INTO PartecipaT(CodS,CodT)\n" + "value('" + scodice.getText()
									+ "','" + tcodice.getText() + "');");
					query.executeUpdate();
					JOptionPane.showMessageDialog(null, "Iscrizione effettuata con successo.");
					IscrizioneTorneo.this.setVisible(false);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Errore nell'inserimento, riprova.");
				}
			}
		});

		pannello.add(codicet);
		pannello.add(tcodice);
		pannello.add(codices);
		pannello.add(scodice);
		pannello.add(bottone);

		this.add(pannello, BorderLayout.CENTER);
	}
}
