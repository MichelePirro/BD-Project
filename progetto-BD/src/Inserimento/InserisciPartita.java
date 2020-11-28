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

public class InserisciPartita extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4871388245355308251L;
	
	private JTextField codp;
	private JTextField codcasa;
	private JTextField codtrasferta;
	private JTextField data;
	private JTextField goalcasa;
	private JTextField goaltrasferta;
	private JTextField ngior;
	private JLabel n1;
	private JLabel n2;
	private JLabel n3;
	private JLabel n4;
	private JLabel n5;
	private JLabel n6;
	private JLabel n7;
	private JPanel pannello;
	private JButton bottone;

	public InserisciPartita(Connection con)
	{
		codp = new JTextField(20);
		codcasa = new JTextField(20);
		codtrasferta = new JTextField(20);
		data = new JTextField(20);
		goalcasa = new JTextField(20);
		goaltrasferta = new JTextField(20);
		ngior = new JTextField(20);
		n1 = new JLabel("Inserisci codice partita:");
		n2 = new JLabel("Inserisci codice della squadra di casa:");
		n3 = new JLabel("Inserisci codice della squadra ospite:");
		n4 = new JLabel("Inserisci la data della partita:");
		n5 = new JLabel("Inserisci i goal della squadra di casa:");
		n6 = new JLabel("Inserisci i goal della squadra ospite:");
		n7 = new JLabel("Inserisci il numero di giornata se di campionato:*");
		pannello = new JPanel();
		bottone = new JButton("Invia");
		
		
		bottone.addActionListener(
									new ActionListener()
									{
										public void actionPerformed(ActionEvent ev)
										{
											try 
											{
												if(ngior.getText().equals(""))
												{
												PreparedStatement query = (PreparedStatement) con.prepareStatement
														(
																"INSERT INTO Partita(CodP,CodSCasa,CodSTrasferta,Data,GoalCasa,GoalTrasferta,NGiorn)\n"+
																"value('"+codp.getText()+"','"+codcasa.getText()+"','"+codtrasferta.getText()+"','"+data.getText()+"',"+goalcasa.getText()+","+goaltrasferta.getText()+",null);"							
														);
												query.executeUpdate();
												JOptionPane.showMessageDialog(null, "Inserimento effettuato con successo.");
												InserisciPartita.this.setVisible(false);
												}
												else
												{
													PreparedStatement query = (PreparedStatement) con.prepareStatement
															(
																	"INSERT INTO Partita(CodP,CodSCasa,CodSTrasferta,Data,GoalCasa,GoalTrasferta,NGiorn)\n"+
																	"value('"+codp.getText()+"','"+codcasa.getText()+"','"+codtrasferta.getText()+"','"+data.getText()+"',"+goalcasa.getText()+","+goaltrasferta.getText()+","+ngior.getText()+");"							
															);
													query.executeUpdate();
													JOptionPane.showMessageDialog(null, "Inserimento effettuato con successo.");
													InserisciPartita.this.setVisible(false);
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
		pannello.add(codp);
		pannello.add(n2);
		pannello.add(codcasa);
		pannello.add(n3);
		pannello.add(codtrasferta);
		pannello.add(n4);
		pannello.add(data);
		pannello.add(n5);
		pannello.add(goalcasa);
		pannello.add(n6);
		pannello.add(goaltrasferta);
		pannello.add(n7);
		pannello.add(ngior);
		pannello.add(bottone);
		
		this.add(pannello);
	}
}
