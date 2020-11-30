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

public class InserisciInfortunio extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4871388245355308251L;

	private JTextField CodInf;
	private JTextField CodT;
	private JTextField Tipologia;
	private JTextField Gravita;
	private JTextField MedicoCurante;
	private JLabel n1;
	private JLabel n2;
	private JLabel n3;
	private JLabel n4;
	private JLabel n5;
	private JPanel pannello;
	private JButton bottone;

	public InserisciInfortunio(Connection con) {
		CodInf = new JTextField(20);
		CodT = new JTextField(20);
		Tipologia = new JTextField(20);
		Gravita = new JTextField(20);
		MedicoCurante = new JTextField(20);
		n1 = new JLabel("Inserisci codice infortunio:");
		n2 = new JLabel("Inserisci nome giocatore:");
		n3 = new JLabel("Inserisci tipologia:");
		n4 = new JLabel("Inserisci gravita:");
		n5 = new JLabel("Inserisci medico curante:");
		pannello = new JPanel();
		bottone = new JButton("Invia");

		bottone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
					PreparedStatement query = (PreparedStatement) con
							.prepareStatement("INSERT INTO Infortunio(CodInf,CodT,Tipologia,Gravita,MedicoCurante)\n" + "value('"
									+ CodInf.getText() + "','" + CodT.getText() + "','"
									+ Tipologia.getText() + "','" + Gravita.getText() + "','" + MedicoCurante.getText() + "');");
					query.executeUpdate();
					JOptionPane.showMessageDialog(null, "Inserimento effettuato con successo.");
					InserisciInfortunio.this.setVisible(false);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Errore nell'inserimento, riprova.");
				}
			}
		});

		pannello.add(n1);
		pannello.add(CodInf);
		pannello.add(n2);
		pannello.add(CodT);
		pannello.add(n3);
		pannello.add(Tipologia);
		pannello.add(n4);
		pannello.add(Gravita);
		pannello.add(n5);
		pannello.add(MedicoCurante);
		pannello.add(bottone);
		

		this.add(pannello);
	}
}
