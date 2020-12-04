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

public class InserisciGiocatore extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4871388245355308251L;
	
	private JTextField CodT;
	private JTextField Nome;
	private JTextField Cognome;
	private JTextField Ruolo;
	private JTextField Stipendio;
	private JTextField numero;
	private JTextField squadra;
	private JLabel n1;
	private JLabel n2;
	private JLabel n3;
	private JLabel n4;
	private JLabel n5;
	private JLabel n6;
	private JLabel n7;
	private JPanel pannello;
	private JButton bottone;

	public InserisciGiocatore(Connection con)
	{
		CodT = new JTextField(20);
		Nome = new JTextField(20);
		Cognome = new JTextField(20);
		Ruolo = new JTextField(20);
		Stipendio = new JTextField(20);
		numero = new JTextField(20);
		squadra = new JTextField(20);
		n1 = new JLabel("Inserisci codice tesserato:");
		n2 = new JLabel("Inserisci nome:");
		n3 = new JLabel("Inserisci cognome:");
		n4 = new JLabel("Inserisci ruolo:");
		n5 = new JLabel("Inserisci stipendio:");
		n6 = new JLabel("Inserisci numero maglia: *");
		n7 = new JLabel("Inserisci codice squadra: *");
		pannello = new JPanel();
		bottone = new JButton("Invia");
		
		
		bottone.addActionListener(
									new ActionListener()
									{
										public void actionPerformed(ActionEvent ev)
										{
											try 
											{
												if(numero.getText().equals("") && !squadra.getText().equals(""))
												{
												PreparedStatement query = (PreparedStatement) con.prepareStatement
														(
																"INSERT INTO Giocatore(CodT,Nome,Cognome,Ruolo,Stipendio,NumMaglia,CodS)\n"+
																"value('"+CodT.getText()+"','"+Nome.getText()+"','"+Cognome.getText()+"','"+Ruolo.getText()+"','"+Stipendio.getText()+"',null,'"+squadra.getText()+"');"							
														);
												query.executeUpdate();
												JOptionPane.showMessageDialog(null, "Inserimento effettuato con successo.");
												InserisciGiocatore.this.setVisible(false);
												}
												
												if(!numero.getText().equals("") && squadra.getText().equals(""))
												{
												PreparedStatement query = (PreparedStatement) con.prepareStatement
														(
																"INSERT INTO Giocatore(CodT,Nome,Cognome,Ruolo,Stipendio,NumMaglia,CodS)\n"+
																"value('"+CodT.getText()+"','"+Nome.getText()+"','"+Cognome.getText()+"','"+Ruolo.getText()+"','"+Stipendio.getText()+"','"+numero.getText()+"',null);"							
														);
												query.executeUpdate();
												JOptionPane.showMessageDialog(null, "Inserimento effettuato con successo.");
												InserisciGiocatore.this.setVisible(false);
												}
												
												if(numero.getText().equals("") && squadra.getText().equals(""))
												{
												PreparedStatement query = (PreparedStatement) con.prepareStatement
														(
																"INSERT INTO Giocatore(CodT,Nome,Cognome,Ruolo,Stipendio,NumMaglia,CodS)\n"+
																"value('"+CodT.getText()+"','"+Nome.getText()+"','"+Cognome.getText()+"','"+Ruolo.getText()+"','"+Stipendio.getText()+"',null,null);"							
														);
												query.executeUpdate();
												JOptionPane.showMessageDialog(null, "Inserimento effettuato con successo.");
												InserisciGiocatore.this.setVisible(false);
												}
												
												if(!numero.getText().equals("") && !squadra.getText().equals(""))
												{
												PreparedStatement query = (PreparedStatement) con.prepareStatement
														(
																"INSERT INTO Giocatore(CodT,Nome,Cognome,Ruolo,Stipendio,NumMaglia,CodS)\n"+
																"value('"+CodT.getText()+"','"+Nome.getText()+"','"+Cognome.getText()+"','"+Ruolo.getText()+"','"+Stipendio.getText()+"','"+numero.getText()+"','"+squadra.getText()+"');"							
														);
												query.executeUpdate();
												JOptionPane.showMessageDialog(null, "Inserimento effettuato con successo.");
												InserisciGiocatore.this.setVisible(false);
												}


											}
											catch (Exception e)
											{
												JOptionPane.showMessageDialog(null, "Errore nell'inserimento, riprova.");
											}
					}
				}
				);
		
		
		pannello.add(n1);
		pannello.add(CodT);
		pannello.add(n2);
		pannello.add(Nome);
		pannello.add(n3);
		pannello.add(Cognome);
		pannello.add(n4);
		pannello.add(Ruolo);
		pannello.add(n5);
		pannello.add(Stipendio);
		pannello.add(n6);
		pannello.add(numero);
		pannello.add(n7);
		pannello.add(squadra);
		pannello.add(bottone);
		
		this.add(pannello);
	}
}
