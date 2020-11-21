package Query;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.mysql.jdbc.Connection;

public class QueryProva extends JFrame 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3347886131317848991L;

	private JComboBox<String> query;
	private JTextArea area;
	private JPanel pannello;
	private JScrollPane pane;
	
	public QueryProva(Connection con)
	{
		pannello = new JPanel();
		area = new JTextArea(30,30);
		pane = new JScrollPane(area);
		query = new JComboBox<String>();
		
		query.addItem("-----");
		query.addItem("Squadra");
		query.addItem("Giocatore");
		query.addItem("Allenatore");
		query.addItem("Partita");
		query.addItem("Torneo");
		query.addItem("Campionato");
		query.addItem("Iscrizioni tornei");
		
		
		query.addActionListener(
									new ActionListener()
									{
										public void actionPerformed(ActionEvent ev)
										{
											area.setText("");
											
											if(query.getSelectedItem().equals("Squadra"))
											{
												
												try 
												{
													Statement query = con.createStatement();
													ResultSet result = query.executeQuery
															(
															"SELECT * from Squadra;"
															);
													area.append("CODS ----- NOMES ----- CODC\n\n");
													while (result.next())
													{
														String CodS= result.getString("CodS");
														
														String NomeS = result.getString("NomeS");
														
														String CodC = result.getString("CodC");
														
														area.append(CodS+" ----- "
																+ ""+NomeS+" ----- "+CodC+"\n\n");
													}
												}
												catch (Exception e)
												{
													area.append("Errore nell'interrogazione");
												}
											}
											
											
											if(query.getSelectedItem().equals("Giocatore"))
											{
												
												try 
												{
													Statement query = con.createStatement();
													ResultSet result = query.executeQuery
															(
															"SELECT * from Giocatore;"
															);
													area.append("CF ----- NOME ----- COGNOME ----- RUOLO ----- STIPENDIO ----- NUM.MAGLIA ----- CODS\n\n");
													while (result.next())
													{
														String CF = result.getString("CF");
														
														String Nome = result.getString("Nome");
														
														String Cognome = result.getString("Cognome");
														
														String Ruolo = result.getString("Ruolo");
														
														double Stipendio = result.getDouble("Stipendio");
														
														int nummaglia = result.getInt("NumMaglia");
														
														String CodS = result.getString("CodS");
														
														area.append(CF+" ----- "+Nome+" ----- "+Cognome+" ----- "+Ruolo+" ----- "+Stipendio+" ----- "+nummaglia+" ----- "+CodS+"\n\n");
													}
												}
												catch (Exception e)
												{
													area.append("Errore nell'interrogazione");
												}
											}
											
											
											if(query.getSelectedItem().equals("Allenatore"))
											{
												
												try 
												{
													Statement query = con.createStatement();
													ResultSet result = query.executeQuery
															(
															"SELECT * from Allenatore;"
															);
													area.append("CF ----- CODS ----- NOME ----- COGNOME ----- STIPENDIO\n\n");
													while (result.next())
													{
														String CF = result.getString("CF");
														
														String CodS = result.getString("CodS");
														
														String Nome = result.getString("Nome");
														
														String Cognome = result.getString("Cognome");
														
														double Stipendio = result.getDouble("Stipendio");
														
														area.append(CF+" ----- "+CodS+" ----- "+Nome+" ----- "+Cognome+" ----- "+Stipendio+"\n\n");
													}
												}
												catch (Exception e)
												{
													area.append("Errore nell'interrogazione");
												}
											}
											
											
											if(query.getSelectedItem().equals("Partita"))
											{
												
												try 
												{
													Statement query = con.createStatement();
													ResultSet result = query.executeQuery
															(
															"SELECT * from Partita;"
															);
													area.append("CODP ----- CODSCASA ----- CODSTRASFERTA ----- DATA ----- GOALCASA ----- GOALTRASFERTA ----- N.GIORN\n\n");
													while (result.next())
													{
														String CodP = result.getString("CodP");
														
														String CodSCasa = result.getString("CodSCasa");
														
														String CodSTrasferta = result.getString("CodSTrasferta");
														
														String data = result.getString("Data");
														
														int golc = result.getInt("GoalCasa");
														
														int golt = result.getInt("GoalTrasferta");
														
														int ngiorn = result.getInt("NGiorn");
														
														area.append(CodP+" ----- "+CodSCasa+" ----- "+CodSTrasferta+" ----- "+data+" ----- "+golc+" ----- "+golt+" ----- "+ngiorn+"\n\n");
													}
												}
												catch (Exception e)
												{
													area.append("Errore nell'interrogazione");
												}
											}
											
											
											if(query.getSelectedItem().equals("Torneo"))
											{
												
												try 
												{
													Statement query = con.createStatement();
													ResultSet result = query.executeQuery
															(
															"SELECT * from Torneo;"
															);
													area.append("CODT ----- NOMET\n\n");
													while (result.next())
													{
														String CodT= result.getString("CodT");
														
														String NomeT = result.getString("NomeT");
														
														area.append(CodT+" ----- "+NomeT+"\n\n");
													}
												}
												catch (Exception e)
												{
													area.append("Errore nell'interrogazione");
												}
											}
											
											
											if(query.getSelectedItem().equals("Campionato"))
											{
												
												try 
												{
													Statement query = con.createStatement();
													ResultSet result = query.executeQuery
															(
															"SELECT * from Campionato;"
															);
													area.append("CODC ----- NOMEC\n\n");
													while (result.next())
													{
														String CodC= result.getString("CodC");
														
														String NomeC = result.getString("NomeC");
														
														area.append(CodC+" ----- "+NomeC+"\n\n");
													}
												}
												catch (Exception e)
												{
													area.append("Errore nell'interrogazione");
												}
											}
											
											
											if(query.getSelectedItem().equals("Iscrizioni tornei"))
											{
												
												try 
												{
													Statement query = con.createStatement();
													ResultSet result = query.executeQuery
															(
															"SELECT * from PartecipaT;"
															);
													area.append("CODS ----- CODT\n\n");
													while (result.next())
													{
														String CodS= result.getString("CodS");
														
														String CodT = result.getString("CodT");
														
														area.append(CodS+" ----- "+CodT+"\n\n");
													}
												}
												catch (Exception e)
												{
													area.append("Errore nell'interrogazione");
												}
											}
											
											
										}
									}
								);
		
		
		pannello.add(query);
		area.setEditable(false);
		this.add(pannello, BorderLayout.NORTH);
		this.add(pane);
	}
}
