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

public class InserisciAllenamento extends JFrame {

	private static final long serialVersionUID = 4871388245355308251L;

	private JTextField CodAll;
	private JTextField Luogo;
	private JTextField Data;
	private JTextField CodS;
	private JLabel n1;
	private JLabel n2;
	private JLabel n3;
	private JLabel n4;
	private JPanel pannello;
	private JButton bottone;

	public InserisciAllenamento(Connection con) {
		CodAll = new JTextField(20);
		Luogo = new JTextField(20);
		Data = new JTextField(20);
		CodS = new JTextField(20);
		n1 = new JLabel("Inserisci Codice Allenamento:");
		n2 = new JLabel("Inserisci Luogo:");
		n3 = new JLabel("Inserisci Data:");
		n4 = new JLabel("Inserisci Codice Squadra:");
		pannello = new JPanel();
		bottone = new JButton("Invia");

		bottone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
					PreparedStatement query = (PreparedStatement) con.prepareStatement(
							"INSERT INTO Allenamento(CodAll,Luogo,Data,CodS)\n" + "value('" + CodAll.getText() + "','"
									+ Luogo.getText() + "','" + Data.getText() + "','" + CodS.getText() + "');");
					query.executeUpdate();
					JOptionPane.showMessageDialog(null, "Inserimento effettuato con successo.");
					InserisciAllenamento.this.setVisible(false);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Errore nell'inserimento, riprova.");
				}
			}
		});

		pannello.add(n1);
		pannello.add(CodAll);
		pannello.add(n2);
		pannello.add(Luogo);
		pannello.add(n3);
		pannello.add(Data);
		pannello.add(n4);
		pannello.add(CodS);
		pannello.add(bottone);

		this.add(pannello);
	}
}
