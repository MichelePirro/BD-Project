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

public class InserisciAllenatore extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4871388245355308251L;
	
	private JTextField cf;
	private JTextField Nome;
	private JTextField Cognome;
	private JTextField Stipendio;
	private JTextField squadra;
	private JLabel n1;
	private JLabel n2;
	private JLabel n3;
	private JLabel n4;
	private JLabel n5;
	private JPanel pannello;
	private JButton bottone;

	public InserisciAllenatore(Connection con)
	{
		cf = new JTextField(20);
		Nome = new JTextField(20);
		Cognome = new JTextField(20);
		Stipendio = new JTextField(20);
		squadra = new JTextField(20);
		n1 = new JLabel("Inserisci codice fiscale:");
		n2 = new JLabel("Inserisci squadra:");
		n3 = new JLabel("Inserisci nome:");
		n4 = new JLabel("Inserisci cognome:");
		n5 = new JLabel("Inserisci stipendio:");
		pannello = new JPanel();
		bottone = new JButton("Invia");
		
		
		bottone.addActionListener(
									new ActionListener()
									{
										public void actionPerformed(ActionEvent ev)
										{
											try 
											{
												PreparedStatement query = (PreparedStatement) con.prepareStatement
														(
																"INSERT INTO Allenatore(CF,CodS,Nome,Cognome,Stipendio)\n"+
																"value('"+cf.getText()+"','"+squadra.getText()+"','"+Nome.getText()+"','"+Cognome.getText()+"','"+Stipendio.getText()+"');"							
														);
												query.executeUpdate();
												JOptionPane.showMessageDialog(null, "Inserimento effettuato con successo.");
												InserisciAllenatore.this.setVisible(false);
											}
											catch (Exception e)
											{
												JOptionPane.showMessageDialog(null, "Errore nell'inserimento, riprova.");
											}
					}
				}
				);
		
		
		pannello.add(n1);
		pannello.add(cf);
		pannello.add(n2);
		pannello.add(squadra);
		pannello.add(n3);
		pannello.add(Nome);
		pannello.add(n4);
		pannello.add(Cognome);
		pannello.add(n5);
		pannello.add(Stipendio);
		pannello.add(bottone);
		
		this.add(pannello);
	}
}
