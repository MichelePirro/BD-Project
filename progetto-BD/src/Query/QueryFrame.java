package Query;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.mysql.jdbc.Connection;

public class QueryFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3478903542834318161L;
	
	private JComboBox<String> query;
	private JTextArea area;
	private JPanel pannello;
	private JButton info;
	private JScrollPane pane;
	private Font font;
	
	public QueryFrame(Connection con)
	{		
		pannello = new JPanel();
		area = new JTextArea(30,30);
		pane = new JScrollPane(area);
		query = new JComboBox<String>();
		info = new JButton("Info");
		font = new Font("Arial", Font.PLAIN,13);
		
		query.addItem("-----");
		query.addItem("Query 1");
		query.addItem("Query 2");
		query.addItem("Query 3");
		query.addItem("Query 4");
		query.addItem("Query 5");
		query.addItem("Query 6");
		query.addItem("Query 7");
		query.addItem("Query 8");
		query.addItem("Query 9");
		query.addItem("Query 10");
		query.addItem("Query 11");
		query.addItem("Query 12");
		query.addItem("Query 13");

		
		query.addActionListener
		(
		new ActionListener()
		{

		public void actionPerformed(ActionEvent ev)
		{
			area.setText("");
		if(query.getSelectedItem().equals("Query 1"))
		{
			
			try 
			{
				Statement query = con.createStatement();
				ResultSet result = query.executeQuery
						(
						"SELECT a.Nome,a.Cognome,s.NomeS\r\n" + 
						"from Allenatore a, Squadra s, Campionato c\r\n" + 
						"where a.CodS=s.CodS\r\n" + 
						"AND s.CodC=c.CodC\r\n" + 
						"AND c.NomeC=\"Serie A\""
						);
				while (result.next())
				{
					String Nome = result.getString("a.Nome");
					
					String Cognome = result.getString("a.Cognome");
					
					String NomeS = result.getString("s.NomeS");
					
					area.append("-Nome allenatore: \n"+Nome+"\n\n-Cognome allenatore: \n"+Cognome+"\n\n-Nome squadra: \n"+NomeS+"\n\n------------------------------\n\n");
				}
			}
			catch (Exception e)
			{
				area.append("Errore nell'interrogazione");
			}
		}
		
		if(query.getSelectedItem().equals("Query 2"))
		{
			
			try 
			{
				Statement query = con.createStatement();
				ResultSet result = query.executeQuery
						(
						"select p.codP,p.Data\r\n" + 
						"from partita p\r\n" + 
						"where p.Data > '2016-12-31'\r\n" + 
						"AND p.Data < '2018-01-01'\r\n" + 
						"ORDER BY p.Data"
						);
				while (result.next())
				{
					String codp = result.getString("p.codP");
					
					String data = result.getString("p.Data");
					
					area.append("-Codice partita: \n"+codp+"\n\n-Data: \n"+data+"\n\n------------------------------\n\n");
				}
			}
			catch (Exception e)
			{
				area.append("Errore nell'interrogazione");
			}
		}
		
		if(query.getSelectedItem().equals("Query 3"))
		{
			
			try 
			{
				Statement query = con.createStatement();
				ResultSet result = query.executeQuery
						(
						"select g.Nome,g.Cognome\r\n" + 
						"from Giocatore g, Squadra s\r\n" + 
						"where s.nomeS=\"Milan\" \r\n" + 
						"AND s.codS=g.codS"
						);
				while (result.next())
				{
					String Nome = result.getString("g.Nome");
					
					String Cognome = result.getString("g.Cognome");
					
					area.append("-Nome giocatore: \n"+Nome+"\n\n-Cognome giocatore: \n"+Cognome+"\n\n------------------------------\n\n");
				}
			}
			catch (Exception e)
			{
				area.append("Errore nell'interrogazione");
			}
		}
		
		if(query.getSelectedItem().equals("Query 4"))
		{
			
			try 
			{
				Statement query = con.createStatement();
				ResultSet result = query.executeQuery
						(
						"select g.nome,g.cognome\r\n" + 
						"from Giocatore g\r\n" + 
						"where g.cognome like 'C%'"
						);
				while (result.next())
				{
					String Nome = result.getString("g.Nome");
					
					String Cognome = result.getString("g.Cognome");
					
					area.append("-Nome giocatore: \n"+Nome+"\n\n-Cognome giocatore: \n"+Cognome+"\n\n------------------------------\n\n");
				}
			}
			catch (Exception e)
			{
				area.append("Errore nell'interrogazione");
			}
		}
		
		if(query.getSelectedItem().equals("Query 5"))
		{
			
			try 
			{
				Statement query = con.createStatement();
				ResultSet result = query.executeQuery
						(
						"select s.nomeS\r\n" + 
						"from Squadra s, Torneo t, PartecipaT p\r\n" + 
						"where s.codS=p.codS\r\n" + 
						"AND p.codT=t.codT\r\n" + 
						"AND t.NomeT=\"Champions League\"\r\n" + 
						"AND s.codS not in\r\n" + 
						"		(\r\n" + 
						"			select s.codS\r\n" + 
						"			from Squadra s, Torneo t, PartecipaT p\r\n" + 
						"			where s.codS=p.codS\r\n" + 
						"			AND p.codT=t.codT\r\n" + 
						"			AND t.NomeT=\"Europa League\"	\r\n" + 
						"		)"
						);
				while (result.next())
				{
					String NomeS = result.getString("s.NomeS");
					
					area.append("-Nome squadra: \n"+NomeS+"\n\n------------------------------\n\n");
				}
			}
			catch (Exception e)
			{
				area.append("Errore nell'interrogazione");
			}
		}	
		
		if(query.getSelectedItem().equals("Query 6"))
		{
			
			try 
			{
				Statement query = con.createStatement();
				ResultSet result = query.executeQuery
						(
						"select c.nomeC,COUNT(p.CodSCasa) AS numsquadre\r\n" + 
						"from Partita p, Campionato c, Squadra s\r\n" + 
						"where c.codC=s.codC\r\n" + 
						"AND s.codS=p.CodSCasa\r\n" + 
						"AND p.goalCasa > 2\r\n" + 
						"AND p.ngiorn is not null\r\n" + 
						"Group By c.nomeC"
						);
				while (result.next())
				{
					String NomeC = result.getString("c.nomeC");
					
					int numsquadre = result.getInt("numsquadre");
					
					area.append("-Nome campionato: \n"+NomeC+"\n\n-Numero di squadre: \n"+numsquadre+"\n\n------------------------------\n\n");
				}
			}
			catch (Exception e)
			{
				area.append("Errore nell'interrogazione");
			}
		}	
		
		if(query.getSelectedItem().equals("Query 7"))
		{
			
			try 
			{
				Statement query = con.createStatement();
				ResultSet result = query.executeQuery
						(
						"select N.nomeS\r\n" + 
						"from N\r\n" + 
						"where N.numtor = \r\n" + 
						"		(\r\n" + 
						"			select MAX(N.numtor)\r\n" + 
						"			from N\r\n" + 
						"		);\r\n" + 
						""
						);
				while (result.next())
				{
					String NomeS = result.getString("N.NomeS");
					
					area.append("-Nome squadra: \n"+NomeS+"\n\n");
				}
			}
			catch (Exception e)
			{
				area.append("Errore nell'interrogazione");
			}
		}
		
		if(query.getSelectedItem().equals("Query 8"))
		{
			
			try 
			{
				Statement query = con.createStatement();
				ResultSet result = query.executeQuery
						(
						"select S.NomeS\r\n" + 
						"from S\r\n" + 
						"where S.sommastip =\r\n" + 
						"			(\r\n" + 
						"				select MIN(S.sommastip)\r\n" + 
						"				from S\r\n" + 
						"			);"
						);
				while (result.next())
				{
					String NomeS = result.getString("S.NomeS");
					
					area.append("-Nome squadra: \n"+NomeS+"\n\n");
				}
			}
			catch (Exception e)
			{
				area.append("Errore nell'interrogazione");
			}
		}	
		
		if(query.getSelectedItem().equals("Query 9"))
		{
			
			try 
			{
				Statement query = con.createStatement();
				ResultSet result = query.executeQuery
						(
						"select s.NomeS,COUNT(g.cf) AS numatt\r\n" + 
						"from Squadra s, Giocatore g\r\n" + 
						"where s.codS=g.codS\r\n" + 
						"AND g.ruolo=\"Attaccante\"\r\n" + 
						"group by s.nomeS\r\n" + 
						"having numatt > 2"
						);
				while (result.next())
				{
					String NomeS = result.getString("s.NomeS");
					
					int numatt = result.getInt("numatt");
					
					area.append("-Nome squadra: \n"+NomeS+"\n\n-Numero di giocatori attaccanti: \n"+numatt+"\n\n------------------------------\n\n");
				}
			}
			catch (Exception e)
			{
				area.append("Errore nell'interrogazione");
			}
		}
		
		if(query.getSelectedItem().equals("Query 10"))
		{
			
			try 
			{
				Statement query = con.createStatement();
				ResultSet result = query.executeQuery
						(
						"select count(s.codS) AS numsquadre\r\n" + 
						"\r\n" + 
						"from Squadra s\r\n" + 
						"where not exists (\r\n" + 
						"\r\n" + 
						"			select *\r\n" + 
						"\r\n" + 
						"                    	from Torneo t\r\n" + 
						"			where not exists (\r\n" + 
						"\r\n" + 
						"						select *\r\n" + 
						"\r\n" + 
						"						from Partecipat p\r\n" + 
						"                                        	where p.codS=s.codS\r\n" + 
						"\r\n" + 
						"                                        	and p.codT=t.codT\r\n" + 
						"	\r\n" + 
						"					)\r\n" + 
						"		);"
						);
				while (result.next())
				{	
					int numsquadre = result.getInt("numsquadre");
					
					area.append("-Numero di squadre: \n"+numsquadre+"\n\n------------------------------\n\n");
				}
			}
			catch (Exception e)
			{
				area.append("Errore nell'interrogazione");
			}
		}
		
		if(query.getSelectedItem().equals("Query 10"))
		{
			
			try 
			{
				Statement query = con.createStatement();
				ResultSet result = query.executeQuery
						(
						"select s.NomeS \r\n" + 
						"\r\n" + 
						"from Squadra s\r\n" + 
						"where not exists (\r\n" + 
						"\r\n" + 
						"			select *\r\n" + 
						"\r\n" + 
						"                    	from Torneo t\r\n" + 
						"			where not exists (\r\n" + 
						"\r\n" + 
						"						select *\r\n" + 
						"\r\n" + 
						"						from Partecipat p\r\n" + 
						"                                        	where p.codS=s.codS\r\n" + 
						"\r\n" + 
						"                                        	and p.codT=t.codT\r\n" + 
						"	\r\n" + 
						"					)\r\n" + 
						"		);"
						);
				while (result.next())
				{	
					String nomes = result.getString("s.NomeS");
					
					area.append("-Nome Squadra: \n"+nomes+"\n\n------------------------------\n\n");
				}
			}
			catch (Exception e)
			{
				area.append("Errore nell'interrogazione");
			}
		}
		
		if(query.getSelectedItem().equals("Query 11"))
		{
			
			try 
			{
				Statement query = con.createStatement();
				ResultSet result = query.executeQuery
						(
						"select g.Cognome, g.Nome\r\n" + 
						"from Giocatore g\r\n" + 
						"where g.nummaglia is NULL\r\n" + 
						"AND g.codS is NOT NULL"
						);
				while (result.next())
				{	
					String Cognome = result.getString("g.Cognome");
					
					String Nome = result.getString("g.Nome");
					
					area.append("-Cognome giocatore: \n"+Cognome+"\n\n-Nome giocatore: \n"+Nome+"\n\n------------------------------\n\n");
				}
			}
			catch (Exception e)
			{
				area.append("Errore nell'interrogazione");
			}
		}
		
		if(query.getSelectedItem().equals("Query 12"))
		{
			
			try 
			{
				Statement query = con.createStatement();
				ResultSet result = query.executeQuery
						(
								"select s.CodS,s.NomeS\r\n" + 
										"from Squadra s\r\n" + 
										"where s.CodS like 'ita%'"	
						);
				while (result.next())
				{	
					String CodS = result.getString("s.CodS");
					
					String NomeS = result.getString("s.NomeS");
					
					area.append("-Nome Squadra: \n"+NomeS+"\n\n-Codice Squadra: \n"+CodS+"\n\n------------------------------\n\n");
				}
			}
			catch (Exception e)
			{
				area.append("Errore nell'interrogazione");
			}
		}
		
		if(query.getSelectedItem().equals("Query 13"))
		{
			
			try 
			{
				Statement query = con.createStatement();
				ResultSet result = query.executeQuery
						(
						"select s1.NomeS AS Casa,p.GoalCasa,s2.NomeS AS Trasferta,p.GoalTrasferta\r\n" + 
						"\r\n" + 
						"from Squadra s1,Squadra s2, Partita p\r\n" + 
						"\r\n" + 
						"where s1.codS=p.CodSCasa\r\n" + 
						"\r\n" + 
						"AND s2.codS=p.CodSTrasferta\r\n" + 
						"\r\n" + 
						"AND p.data >'2017-12-31'\r\n" + 
						"\r\n" + 
						"AND p.data <'2019-01-01' "
						);
				while (result.next())
				{	
					String Casa = result.getString("Casa");
					
					String Trasferta = result.getString("Trasferta");
					
					int goalCasa = result.getInt("p.GoalCasa");
					
					int goalTrasferta = result.getInt("p.GoalTrasferta");
					
					area.append(Casa+" "+goalCasa+" - "+goalTrasferta+" "+Trasferta+"\n\n------------------------------\n\n");
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

		info.addActionListener(
									new ActionListener()
									{
										public void actionPerformed(ActionEvent ev)
										{
											JFrame frame = new JFrame();
											JPanel pannello = new JPanel();
											JLabel label1 = new JLabel("1) Elencare il nome di tutti gli allenatori che militano in \"Serie A\".(Nome,Cognome,NomeSquadra);												");
											JLabel label2 = new JLabel("2) Elencare tutte le partite dell'anno 2017 ordinate per data.(codpartita,data);																");
											JLabel label3 = new JLabel("3) Elencare tutti i giocatori della squadra \"Milan\".(Nome,Cognome);																			");
											JLabel label4 = new JLabel("4) Elencare i giocatori il cui cognome inizia con \"C\".(Nome,Cognome);																			");
											JLabel label5 = new JLabel("5) Elencare le squadre che hanno partecipato al torneo \"Champions League\" ma non \"Europa League\".(NomeSquadra);								");
											JLabel label6 = new JLabel("6) Per ogni campionato, contare le squadre che hanno effettuato partite in casa, 																");
											JLabel labelx = new JLabel("in cui hanno segnato almeno 3 gol.(NomeCampionato,NumSquadre); 																					");
											JLabel label7 = new JLabel("7) Determinare la squadra che ha partecipato a più tornei.(NomeSquadra);																		");
											JLabel label8 = new JLabel("8) Determinare la squadra di \"Serie A\" in cui la somma degli stipendi dei giocatori è la più bassa.(NomeSquadra);								");
											JLabel label9 = new JLabel("9) Determinare le squadre che hanno almeno 3 giocatori attaccanti.(NomeSquadra, numatt);														");
											JLabel label10 = new JLabel("10) Restituire il numero di squadre che hanno partecipato a tutti i tornei.(numsquadre);														");
											JLabel label11 = new JLabel("11) Elencare i giocatori che non hanno un numero di maglia e che non sono svincolati.(Nome,Cognome);											");
											JLabel label12 = new JLabel("12) Stampa tutte le squadre di serie A. (NomeS,CodS);																							");
											JLabel label13 = new JLabel("13) Elencare le partite dell’anno 2018.(NomeCasa,GoalCasa,NomeOspite,GoalOspite).																");
											
											label1.setFont(font);
											label2.setFont(font);
											label3.setFont(font);
											label4.setFont(font);
											label5.setFont(font);
											label6.setFont(font);
											labelx.setFont(font);
											label7.setFont(font);
											label8.setFont(font);
											label9.setFont(font);
											label10.setFont(font);
											label11.setFont(font);
											label12.setFont(font);
											label13.setFont(font);

											
											
											pannello.add(label1);
											pannello.add(label2);
											pannello.add(label3);
											pannello.add(label4);
											pannello.add(label5);
											pannello.add(label6);
											pannello.add(labelx);
											pannello.add(label7);
											pannello.add(label8);
											pannello.add(label9);
											pannello.add(label10);
											pannello.add(label11);
											pannello.add(label12);
											pannello.add(label13);

											
											pannello.setBackground(Color.WHITE);
											
											frame.add(pannello);
											
											frame.setSize(710,340);
											frame.setTitle("Info Query");
											frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
											frame.setVisible(true);
											frame.setLocation(600,250);
										}
									}								
								);
		
		pannello.add(query);
		pannello.add(info);
		area.setEditable(false);
		this.add(pannello, BorderLayout.NORTH);
		this.add(pane);
		
	}
}
