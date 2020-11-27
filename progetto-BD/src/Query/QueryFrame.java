package Query;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
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
import javax.swing.ScrollPaneConstants;

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
										    JPanel middlePanel = new JPanel ();
										   

										    // create the middle panel components

										    JTextArea display = new JTextArea ( 1600, 5800 );
										    display.setEditable ( false ); // set textArea non-editable
										    JScrollPane scroll = new JScrollPane ( display );
										    scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
										    
										    
										  										    
										    TextArea t = new TextArea();
										    t.setText("insert text when you want a new line add \nThen more text....\nThen more text....\nThen more text...."
										    		+ "\nThen more text....\nThen more text...."+ "\nThen more text....\nThen more text...."+ "\nThen more text....\nThen more text...."
										    		+ "\nThen more text....\nThen more text...."+ "\nThen more text....\nThen more text...."+ "\nThen more text....\nThen more text...."
										    		);
				 						    
										    //Add Textarea in to middle panel
										    middlePanel.add(scroll);
										    middlePanel.add(display);
										    
										   
										    

										    // My code
										    JFrame frame = new JFrame ();
										    frame.add ( middlePanel );
										    frame.add(t);
										    frame.pack ();
										    frame.setLocationRelativeTo ( null );
										    frame.setVisible ( true );
										    
										    display.setLineWrap(true);
										    display.setWrapStyleWord(true);
										    info.remove(info);
										    info.repaint();
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
