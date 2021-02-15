package Query;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.plaf.synth.SynthOptionPaneUI;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Inserimento.InserisciPartita;
import Inserimento.InserisciSquadra;

public class QueryFrame extends JFrame {
	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 3478903542834318161L;

	private JComboBox<String> query;
	private JTextArea area;
	private JPanel pannello;
	private JButton info;

	private JScrollPane pane;
	private Font font;
	private JFrame frame;

	// query4
	private JFrame frame2;
	private JTextField textfield;
	private JButton bottone;
	private JLabel label;
	private JPanel pannello2;
	// query 8
	private JFrame frame4;
	private JTextField textfield4;
	private JButton bottone4;
	private JLabel label5;
	private JLabel label6;
	private JPanel pannello4;
	// query 18
	private JFrame frame3;
	private JTextField textfield3;
	private JButton bottone3;
	private JLabel label3;
	private JLabel label4;
	private JPanel pannello3;
	// query 24
	private JFrame frame5;
	private JPanel pannello5;
	private JComboBox<String> Campionati;
	private JTextArea textarea;
	private JComboBox<String> Squadre;
	private JComboBox<String> Squadre2;
	private JLabel ScrittaCasa;
	private JLabel ScrittaOspite;
	private JButton bottone6;

	private JButton classifica;
	// claasifica
	private JFrame frame6;
	private JPanel pannello6;
	private JTextArea area2;

	public QueryFrame(Connection con) {

		pannello = new JPanel();
		frame = new JFrame();
		ImageIcon immagine = new ImageIcon(getClass().getResource("/pallone.jpg"));
		frame.setIconImage(immagine.getImage());
		area = new JTextArea(30, 30);
		pane = new JScrollPane(area);
		query = new JComboBox<String>();
		info = new JButton("Info");
		font = new Font("Arial", Font.PLAIN, 13);

		// query 4
		frame2 = new JFrame("Ricerca");
		ImageIcon immagine2 = new ImageIcon(getClass().getResource("/pallone.jpg"));
		frame2.setIconImage(immagine2.getImage());
		textfield = new JTextField("", 10);
		bottone = new JButton("Invia");
		label = new JLabel("Inserisci la lettera da cercare");
		pannello2 = new JPanel();

		// query 18
		frame3 = new JFrame("Ricerca");
		ImageIcon immagine3 = new ImageIcon(getClass().getResource("/pallone.jpg"));
		frame3.setIconImage(immagine3.getImage());
		textfield3 = new JTextField("", 10);
		bottone3 = new JButton("Invia");
		label3 = new JLabel("Inserisci la data da cercare");
		label4 = new JLabel("(AAAA-MM-GG)");
		pannello3 = new JPanel();

		// query 8
		frame4 = new JFrame("Ricerca");
		ImageIcon immagine4 = new ImageIcon(getClass().getResource("/pallone.jpg"));
		frame4.setIconImage(immagine4.getImage());
		textfield4 = new JTextField("", 10);
		bottone4 = new JButton("Invia");
		label5 = new JLabel("Inserisci il modulo");
		label6 = new JLabel("(N-N-N)");
		pannello4 = new JPanel();

		// query 24
		frame5 = new JFrame("Gioca");
		ImageIcon immagine5 = new ImageIcon(getClass().getResource("/pallone.jpg"));
		frame5.setIconImage(immagine5.getImage());
		ScrittaCasa = new JLabel("Seleziona squadra casa: ");
		ScrittaOspite = new JLabel("Seleziona squadra ospite: ");
		Campionati = new JComboBox<String>();
		textarea = new JTextArea();
		pannello5 = new JPanel();
		Squadre = new JComboBox<String>();
		Squadre2 = new JComboBox<String>();
		bottone6 = new JButton("Seleziona");

		classifica = new JButton("Classifica");
		frame6 = new JFrame("Classifica");
		ImageIcon immagine6 = new ImageIcon(getClass().getResource("/pallone.jpg"));
		frame6.setIconImage(immagine6.getImage());
		pannello6 = new JPanel();
		area2 = new JTextArea(30, 30);

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
		query.addItem("Query 14");
		query.addItem("Query 15");
		query.addItem("Query 16");
		query.addItem("Query 17");
		query.addItem("Query 18");
		query.addItem("Query 19");
		query.addItem("Query 20");
		query.addItem("Query 21");
		query.addItem("Query 22");
		query.addItem("Query 23");
		query.addItem("Query 24");

		Campionati.addItem("Serie A");
		Campionati.addItem("Ligue 1");
		Campionati.addItem("Premier League");
		Campionati.addItem("Liga BBVA");
		Campionati.addItem("Bundesliga");
		Campionati.addItem("Eredivisie");

		query.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ev) {
				area.setText("");
				if (query.getSelectedItem().equals("Query 1")) {

					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery(
								"SELECT a.Nome,a.Cognome,s.NomeS " + "from Allenatore a, Squadra s, Campionato c "
										+ "where a.CodS=s.CodS " + "AND s.CodC=c.CodC " + "AND c.NomeC=\"Serie A\"");
						while (result.next()) {
							String Nome = result.getString("a.Nome");

							String Cognome = result.getString("a.Cognome");

							String NomeS = result.getString("s.NomeS");

							area.append("-Nome allenatore: \n" + Nome + "\n\n-Cognome allenatore: \n" + Cognome
									+ "\n\n-Nome squadra: \n" + NomeS + "\n\n------------------------------\n\n");
						}
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Query 2")) {

					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery(
								"select s1.NomeS AS Casa,p.GoalCasa,s2.NomeS AS Trasferta,p.GoalTrasferta,p.Data "
										+ "from Squadra s1,Squadra s2, Partita p "
										+ "where s1.codS=p.CodSCasa AND s2.codS=p.CodSTrasferta AND p.Data > '2020-01-01' "
										+ "AND p.Data < '2021-01-01' ORDER BY p.Data");

						while (result.next()) {
							String Casa = result.getString("Casa");

							int GoalCasa = result.getInt("p.GoalCasa");

							String Trasferta = result.getString("Trasferta");

							int GoalTrasferta = result.getInt("GoalTrasferta");

							String data = result.getString("p.Data");

							area.append("-Partita: \n" + Casa + " " + GoalCasa + " " + "-" + " " + Trasferta + " "
									+ GoalTrasferta + "\n\n-Data: \n" + data
									+ "\n\n------------------------------\n\n");
						}
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Query 3")) {

					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery("select g.Nome,g.Cognome "
								+ "from Giocatore g, Squadra s " + "where s.nomeS=\"Napoli\"" + "AND s.codS=g.codS");
						while (result.next()) {
							String Nome = result.getString("g.Nome");

							String Cognome = result.getString("g.Cognome");

							area.append("-Nome giocatore: \n" + Nome + "\n\n-Cognome giocatore: \n" + Cognome
									+ "\n\n------------------------------\n\n");
						}
					} catch (Exception e) {
						e.printStackTrace();
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Query 4")) {

					frame2.setSize(250, 150);
					frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame2.setLocation(600, 350);
					pannello2.add(label);
					pannello2.add(textfield);
					pannello2.add(bottone);
					frame2.add(pannello2);
					frame2.setVisible(true);
					textfield.setText("");

					bottone.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ev) {
							try {
								frame2.setVisible(false);
								area.setText("");

								Statement query = con.createStatement();
								ResultSet result = query.executeQuery("select g.nome,g.cognome " + "from Giocatore g "
										+ "where g.cognome like '" + textfield.getText() + "%'");
								while (result.next()) {
									String Nome = result.getString("g.Nome");

									String Cognome = result.getString("g.Cognome");

									area.append("-Nome giocatore: \n" + Nome + "\n\n-Cognome giocatore: \n" + Cognome
											+ "\n\n------------------------------\n\n");

								}
							} catch (Exception e) {
								area.append("Errore nell'interrogazione");
							}
						}

					}

					);
				}

				if (query.getSelectedItem().equals("Query 5")) {

					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery("select s.nomeS "
								+ "from Squadra s, Torneo t, PartecipaT p " + "where s.codS=p.codS "
								+ "AND p.codT=t.codT " + "AND t.NomeT=\"Champions League\"" + "AND s.codS not in " + "("
								+ "select s.codS " + "from Squadra s, Torneo t, PartecipaT p " + "where s.codS=p.codS "
								+ "AND p.codT=t.codT " + "AND t.NomeT=\"Europa League\"" + ")");
						while (result.next()) {
							String NomeS = result.getString("s.NomeS");

							area.append("-Nome squadra: \n" + NomeS + "\n\n------------------------------\n\n");
						}
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Query 6")) {

					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery("select c.nomeC,COUNT(p.CodSCasa) AS numsquadre "
								+ "from Partita p, Campionato c, Squadra s " + "where c.codC=s.codC "
								+ "AND s.codS=p.CodSCasa " + "AND p.goalCasa > 2 " + "AND p.ngiorn is not null "
								+ "Group By c.nomeC");
						while (result.next()) {
							String NomeC = result.getString("c.nomeC");

							int numsquadre = result.getInt("numsquadre");

							area.append("-Nome campionato: \n" + NomeC + "\n\n-Numero di squadre: \n" + numsquadre
									+ "\n\n------------------------------\n\n");
						}
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Query 7")) {

					try {
						Statement query = con.createStatement();
						ResultSet result = query
								.executeQuery("select Nome, Cognome, Tipologia " + "from arbitro " + "where CodAr in ( "
										+ "select CodAr " + "from partita " + "where GoalCasa > GoalTrasferta "
										+ "group by (CodAr) " + "having count(CodP)<3" + ");");

						while (result.next()) {
							String Nome = result.getString("Nome");
							String Cognome = result.getString("Cognome");
							String Tipologia = result.getString("Tipologia");

							area.append("-Nome Arbitro: " + Nome + "\n-Cognome Arbitro: " + Cognome + "\n-Tipologia: "
									+ Tipologia + "\n\n");
						}
					} catch (Exception e) {

						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Query 8")) {

					frame4.setSize(250, 150);
					frame4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame4.setLocation(600, 350);
					pannello4.add(label5);
					pannello4.add(label6);
					pannello4.add(textfield4);
					pannello4.add(bottone4);
					frame4.add(pannello4);
					frame4.setVisible(true);
					textfield4.setText("");

					bottone4.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ev) {
							try {

								frame4.setVisible(false);
								area.setText("");

								Statement query = con.createStatement();
								ResultSet result = query.executeQuery("SELECT s.nomeS AS NomeSquadra "
										+ "from Squadra s "
										+ "where CodS in ( "
										      + "select p.CodSCasa "
										      + "from Squadra s inner join Partita p on s.CodS=p.CodSCasa inner join Formazione f on  p.CodFCasa=f.CodF "
										    + "where f.Modulo ='"+textfield4.getText()+"'"
										      + "group by p.CodSCasa "
										      +") or CodS in ( "
										+ "select p.CodSTrasferta "
										+ "from Squadra s inner join Partita p on s.CodS=p.CodSTrasferta inner join Formazione f on p.CodFTrasferta=f.CodF "
										+ "where f.Modulo ='"+textfield4.getText()+"'"
										+ "group by p.CodSTrasferta )");

								while (result.next()) {

									String NomeS = result.getString("NomeSquadra");

									area.append("-Nome squadra: \n" + NomeS + "\n\n");
								}
							} catch (Exception e) {
								area.append("Errore nell'interrogazione");
								e.printStackTrace();
							}
						}
					});
				}

				if (query.getSelectedItem().equals("Query 9")) {

					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery("select s.NomeS,COUNT(g.CodT) AS numatt "
								+ "from Squadra s, Giocatore g " + "where s.codS=g.codS "
								+ "AND g.ruolo= \"Attaccante\"" + "group by s.nomeS " + "having numatt > 2");
						while (result.next()) {

							String NomeS = result.getString("s.NomeS");

							int numatt = result.getInt("numatt");

							area.append("-Nome squadra: \n" + NomeS + "\n\n-Numero di giocatori attaccanti: \n" + numatt
									+ "\n\n------------------------------\n\n");
						}
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Query 10")) {

					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery(
								"SELECT s.NomeS, count(t.NomeT) AS Ntornei " + "FROM Squadra s, Torneo t, partecipat p "
										+ "WHERE t.CodT = p.CodT AND s.CodS = p.CodS AND s.codS IN ( "
										+ "SELECT s.codS " + "FROM Squadra s, partecipat p " + "WHERE s.CodS = p.CodS "
										+ "GROUP BY (s.codS) " + "HAVING count(p.CodT) > 2 ) " + "GROUP BY (s.NomeS)");

						while (result.next()) {
							String nomeSquadra = result.getString("s.NomeS");
							int numTornei = result.getInt("NTornei");

							area.append("- " + nomeSquadra + ": " + numTornei + "\n\n");
						}
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Query 11")) {

					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery("select g.Cognome, g.Nome " + "from Giocatore g "
								+ "where g.numMaglia is NULL " + "AND g.codS is NOT NULL ");
						while (result.next()) {

							String Nome = result.getString("g.Nome");

							String Cognome = result.getString("g.Cognome");

							area.append("\n-Nome giocatore: \n" + Nome + "\n\n-Cognome giocatore: \n" + Cognome
									+ "\n\n------------------------------\n\n");
						}
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Query 12")) {

					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery(
								"select s.CodS,s.NomeS " + "from Squadra s " + "where s.CodS like 'ita%'");

						while (result.next()) {
							String CodS = result.getString("s.CodS");

							String NomeS = result.getString("s.NomeS");

							area.append("-Nome Squadra: \n" + NomeS + "\n\n-Codice Squadra: \n" + CodS
									+ "\n\n------------------------------\n\n");
						}
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Query 13")) {

					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery(
								"select s1.NomeS AS Casa,p.GoalCasa,s2.NomeS AS Trasferta,p.GoalTrasferta "
										+ "from Squadra s1,Squadra s2, Partita p " + "where s1.codS=p.CodSCasa "
										+ "AND s2.codS=p.CodSTrasferta " + "AND p.data >'2020-01-01' "
										+ "AND p.data <'2021-01-01' ");
						while (result.next()) {
							String Casa = result.getString("Casa");

							String Trasferta = result.getString("Trasferta");

							int goalCasa = result.getInt("p.GoalCasa");

							int goalTrasferta = result.getInt("p.GoalTrasferta");

							area.append(Casa + " " + goalCasa + " - " + goalTrasferta + " " + Trasferta
									+ "\n\n------------------------------\n\n");

						}
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Query 14")) {

					try {
						Statement query = con.createStatement();
						ResultSet result = query
								.executeQuery("SELECT s.NomeS AS Nome, s.GoalFatti AS goalFatti, c.NomeC AS nomeCamp "
										+ "FROM Squadra s, Campionato c " + "WHERE c.CodC = s.CodC "
										+ "Order By c.CodC, goalFatti DESC ");

						while (result.next()) {

							String Nome = result.getString("Nome");

							int goalFatti = result.getInt("goalFatti");

							String nomeCamp = result.getString("nomeCamp");

							area.append("-Classifica Campionato: \n\n" + nomeCamp + "\n\n" + Nome + " = " + goalFatti
									+ " " + "\n\n------------------------------\n\n");

						}
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Query 15")) {

					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery(
								"Select s1.NomeS AS Casa,p.GoalCasa,s2.NomeS AS Trasferta,p.GoalTrasferta "
										+ "From Squadra s1,Squadra s2, Partita p "
										+ "where s1.codS=p.CodSCasa AND s2.codS=p.CodSTrasferta AND p.GoalCasa < p.GoalTrasferta ");
						while (result.next()) {
							String Casa = result.getString("Casa");

							int goalCasa = result.getInt("p.GoalCasa");

							String Trasferta = result.getString("Trasferta");

							int goalTrasferta = result.getInt("p.GoalTrasferta");

							area.append("-Partita: \n\n" + Casa + " " + goalCasa + " - " + goalTrasferta + " "
									+ Trasferta + "\n\n------------------------------\n\n");

						}
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Query 16")) {

					try {
						Statement query = con.createStatement();
						ResultSet result = query
								.executeQuery("select s1.NomeS AS Casa,s2.NomeS AS Trasferta, CodST AS NomeStadio "
										+ "from Squadra s1,Squadra s2, Partita p " + "where s1.codS=p.CodSCasa "
										+ "AND s2.codS=p.CodSTrasferta ");

						while (result.next()) {
							String Casa = result.getString("Casa");

							String Trasferta = result.getString("Trasferta");

							String NomeStadio = result.getString("NomeStadio");

							area.append("-Partita: \n\n" + Casa + " - " + Trasferta + "\n\n" + "-Stadio: \n\n"
									+ NomeStadio + "\n\n------------------------------\n\n");
						}
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Query 17")) {

					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery("select CodST, PostiDisp, PostiOcc " + "from Stadio s ");

						while (result.next()) {
							String CodST = result.getString("CodST");

							int postiDisp = result.getInt("postiDisp");

							int postiOcc = result.getInt("postiOcc");

							area.append("-Nome Stadio: \n" + CodST + "\n\n-Numero di posti disponibili: \n" + postiDisp
									+ "\n\n-Numero di posti occupati: \n" + postiOcc
									+ "\n\n------------------------------\n\n");
						}
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Query 18")) {

					frame3.setSize(250, 150);
					frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame3.setLocation(600, 350);
					pannello3.add(label3);
					pannello3.add(label4);
					pannello3.add(textfield3);
					pannello3.add(bottone3);
					frame3.add(pannello3);
					frame3.setVisible(true);
					textfield3.setText("");

					bottone3.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent ev) {
							try {
								frame3.setVisible(false);
								area.setText("");

								Statement query = con.createStatement();
								ResultSet result = query.executeQuery("SELECT s.NomeS, a.data, a.Luogo "
										+ "FROM Squadra s, Allenamento a " + "WHERE s.CodS = a.CodS " + "AND a.data ='"
										+ textfield3.getText() + "'");

								while (result.next()) {
									String NomeS = result.getString("s.NomeS");

									Date data = result.getDate("a.data");

									String luogo = result.getString("a.Luogo");

									area.append("-Nome Squadra: \n" + NomeS + "\n\n-Data allenamento: \n" + data
											+ "\n\n-Luogo allenamento: \n" + luogo
											+ "\n\n------------------------------\n\n");

								}
							} catch (Exception e) {
								area.append("Errore nell'interrogazione");
							}
						}

					}

					);
				}

				if (query.getSelectedItem().equals("Query 19")) {

					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery(
								"SELECT a.Nome AS NomeAr, a.Cognome AS CognomeAr, s1.NomeS AS SquadraCasa, s2.NomeS AS SquadraTrasferta "
										+ "FROM Arbitro a, Partita p, Squadra s1, Squadra s2 "
										+ "WHERE a.CodAr = p.CodAr " + "AND p.CodSCasa = s1.CodS "
										+ "AND p.CodSTrasferta = s2.CodS ");

						while (result.next()) {
							String SquadraCasa = result.getString("SquadraCasa");
							String SquadraTrasferta = result.getString("SquadraTrasferta");
							String NomeAr = result.getString("NomeAr");
							String CognomeAr = result.getString("CognomeAr");

							area.append("-Partita: \n" + SquadraCasa + " - " + SquadraTrasferta + "\n\n" + "Arbitro: \n"
									+ "Nome: " + NomeAr + "\n\n" + "Cognome: " + CognomeAr
									+ "\n\n------------------------------\n\n");
						}
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Query 20")) {

					try {
						Statement query = con.createStatement();
						ResultSet result = query
								.executeQuery("SELECT g.nome AS Nome, g.cognome AS Cognome, i.tipologia AS Tipologia "
										+ "FROM Giocatore g, Infortunio i "
										+ "WHERE g.CodT = i.CodT AND i.gravita = 'alta'");

						while (result.next()) {
							String Nome = result.getString("Nome");
							String Cognome = result.getString("Cognome");
							String Tipologia = result.getString("Tipologia");

							area.append("-Giocatore: \n" + "Nome: " + Nome + "\n\n" + "Cognome: " + Cognome + "\n\n"
									+ "Tipologia: " + Tipologia + "\n\n------------------------------\n\n");
						}
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Query 22")) {

					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery(
								"SELECT a.Nome AS Nome, a.cognome AS Cognome, d.Durata AS DurataContratto "
										+ "FROM Allenatore a, Dirigenza d "
										+ "WHERE a.CodT = d.CodT AND d.Durata > 365 ");

						while (result.next()) {
							String Nome = result.getString("Nome");
							String Cognome = result.getString("Cognome");
							String DurataContratto = result.getString("DurataContratto");

							area.append("-Allenatore: \n" + "Nome: " + Nome + "\n\n" + "Cognome: " + Cognome + "\n\n"
									+ "Durata Contratto: " + DurataContratto
									+ "\n\n------------------------------\n\n");
						}
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Query 21")) {

					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery(
								"SELECT s1.NomeS AS Casa, p.GoalCasa, s2.NomeS AS Trasferta, p.GoalTrasferta, MAX(p.Ncartellini) AS Ncartellini, AR.Nome AS NomeArbitro, AR.Cognome AS CognomeArbitro "
										+ "FROM Squadra s1, Squadra s2, Partita p " + "INNER JOIN Arbitro AR "
										+ "ON p.CodAr = AR.CodAr "
										+ "WHERE s1.CodS = P.CodSCasa AND s2.CodS = p.CodSTrasferta");

						while (result.next()) {
							String Casa = result.getString("Casa");

							int GoalCasa = result.getInt("GoalCasa");

							String Trasferta = result.getString("Trasferta");

							int GoalTrasferta = result.getInt("GoalTrasferta");

							String NomeArbitro = result.getString("NomeArbitro");

							String COGNOMEARBITRO = result.getString("CognomeArbitro");

							int Ncartellini = result.getInt("Ncartellini");

							area.append("-Partita: \n" + Casa + " " + GoalCasa + " " + "-" + " " + Trasferta + " "
									+ GoalTrasferta + "\n\n" + "-Arbitro: \n" + NomeArbitro + " " + "-" + " "
									+ COGNOMEARBITRO + "\n\n-N° Cartellini: \n" + Ncartellini + "\n"
									+ "\n------------------------------\n\n");
						}
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Query 23")) {

					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery(
								"SELECT s1.NomeS AS Casa, s2.NomeS AS Trasferta, f.Modulo AS ModCasa, f2.Modulo AS ModTrasferta "
										+ "FROM Squadra s1, Squadra s2, Partita p, Formazione f, Formazione f2 "
										+ "WHERE s1.CodS = p.CodSCasa AND s2.CodS = p.CodSTrasferta AND f.CodF = p.CodFCasa AND f2.CodF = p.CodFTrasferta");

						while (result.next()) {

							String Casa = result.getString("Casa");

							String Trasferta = result.getString("Trasferta");

							String ModCasa = result.getString("ModCasa");

							String ModTrasferta = result.getString("ModTrasferta");

							area.append("-Partita: \n" + Casa + " " + ModCasa + " " + "-" + " " + Trasferta + " "
									+ ModTrasferta + "\n\n" + "\n------------------------------\n\n");
						}
					} catch (Exception e) {

						area.append("Errore nell'interrogazione");
					}
				}
				if (query.getSelectedItem().equals("Query 24")) {

					frame5.setSize(230, 200);
					frame5.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame5.setLocation(600, 350);
					pannello5.add(Campionati);
					pannello5.add(ScrittaCasa);
					pannello5.add(Squadre);
					pannello5.add(ScrittaOspite);
					pannello5.add(Squadre2);
					pannello5.add(bottone6);
					textarea.setVisible(true);
					pannello5.add(textarea);
					frame5.add(pannello5);
					frame5.setVisible(true);

					Campionati.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent ev) {
							try {
								// frame5.setVisible(false);
								area.setText("");

								if (Campionati.getSelectedItem().equals("Serie A")) {
									area.setText("");
									Squadre.removeAllItems();
									Squadre2.removeAllItems();

									Statement query = con.createStatement();
									ResultSet result = query.executeQuery("SELECT *" + "FROM Campionato c, Squadra s "
											+ "WHERE c.CodC = s.CodC " + "AND c.NomeC = 'Serie A'");

									while (result.next()) {

										String NomeS = result.getString("NomeS");
										Squadre.addItem(NomeS);
										Squadre2.addItem(NomeS);

									}

								}

								if (Campionati.getSelectedItem().equals("Premier League")) {
									area.setText("");
									Squadre.removeAllItems();
									Squadre2.removeAllItems();

									Statement query = con.createStatement();
									ResultSet result = query.executeQuery("SELECT * " + "FROM Campionato c, Squadra s "
											+ "WHERE c.CodC = s.CodC " + "AND c.NomeC = 'Premier League'");

									while (result.next()) {

										String NomeS = result.getString("NomeS");
										Squadre.addItem(NomeS);
										Squadre2.addItem(NomeS);

									}
								}

								if (Campionati.getSelectedItem().equals("Ligue 1")) {
									area.setText("");
									Squadre.removeAllItems();
									Squadre2.removeAllItems();

									Statement query = con.createStatement();
									ResultSet result = query.executeQuery("SELECT *" + "FROM Campionato c, Squadra s "
											+ "WHERE c.CodC = s.CodC " + "AND c.NomeC = 'Ligue 1'");

									while (result.next()) {

										String NomeS = result.getString("NomeS");
										Squadre.addItem(NomeS);
										Squadre2.addItem(NomeS);

									}

								}

								if (Campionati.getSelectedItem().equals("Liga BBVA")) {
									area.setText("");
									Squadre.removeAllItems();
									Squadre2.removeAllItems();

									Statement query = con.createStatement();
									ResultSet result = query.executeQuery("SELECT *" + "FROM Campionato c, Squadra s "
											+ "WHERE c.CodC = s.CodC " + "AND c.NomeC = 'Liga BBVA'");

									while (result.next()) {

										String NomeS = result.getString("NomeS");
										Squadre.addItem(NomeS);
										Squadre2.addItem(NomeS);

									}

								}

								if (Campionati.getSelectedItem().equals("Bundesliga")) {
									area.setText("");
									Squadre.removeAllItems();
									Squadre2.removeAllItems();

									Statement query = con.createStatement();
									ResultSet result = query.executeQuery("SELECT *" + "FROM Campionato c, Squadra s "
											+ "WHERE c.CodC = s.CodC " + "AND c.NomeC = 'Bundesliga'");

									while (result.next()) {

										String NomeS = result.getString("NomeS");
										Squadre.addItem(NomeS);
										Squadre2.addItem(NomeS);

									}

								}

								if (Campionati.getSelectedItem().equals("Eredivisie")) {
									area.setText("");
									Squadre.removeAllItems();
									Squadre2.removeAllItems();

									Statement query = con.createStatement();
									ResultSet result = query.executeQuery("SELECT *" + "FROM Campionato c, Squadra s "
											+ "WHERE c.CodC = s.CodC " + "AND c.NomeC = 'Eredivisie'");

									while (result.next()) {

										String NomeS = result.getString("NomeS");
										Squadre.addItem(NomeS);
										Squadre2.addItem(NomeS);

									}

								}

								bottone6.addActionListener(new ActionListener() {

									public void actionPerformed(ActionEvent ev) {

										if (Squadre.getSelectedItem() == Squadre2.getSelectedItem()) {
											JOptionPane.showMessageDialog(null,
													"Errore," + "selezionare due squadre diverse.");
										} else {
											Random generatore = new Random();

											String casa = (String) Squadre.getSelectedItem();
											String ospite = (String) Squadre2.getSelectedItem();

											ArrayList<String> formazioni = new ArrayList<String>();

											ArrayList<String> stadi = new ArrayList<String>();

											ArrayList<String> arbitri = new ArrayList<String>();

											try {
												// query per l'arbitro per l'insert
												Statement queryarbitro = con.createStatement();
												ResultSet resultarbitro = queryarbitro
														.executeQuery("Select a.CodAr " + "From Arbitro a ");

												while (resultarbitro.next()) {
													arbitri.add(resultarbitro.getString("CodAr"));

												}

											} catch (Exception e) {
												System.out.println("Errore arbitro");
											}

											try {
												// query per la formazione per l'insert
												Statement queryform = con.createStatement();
												ResultSet resultform = queryform
														.executeQuery("SELECT CodF " + "FROM formazione ");

												while (resultform.next()) {
													formazioni.add(resultform.getString("CodF"));
												}

											} catch (Exception e) {
												System.out.println("Errore formazione");
											}

											try {
												// query per stadi per l'insert
												Statement querystadio = con.createStatement();
												ResultSet resultstadio = querystadio
														.executeQuery("SELECT s.CodST " + "FROM Stadio s ");

												while (resultstadio.next()) {
													stadi.add(resultstadio.getString("CodST"));

												}

											} catch (Exception e) {
												System.out.println("Errore arbitro");
											}

											int numero = 16;
											for (int i = 16; i <= 100000; i++) {
												numero++;
											}
											// generatori numeri per l'insert
											int codprandom = generatore.nextInt(numero + 16);
											int goalcasarandom = generatore.nextInt(5);
											int goaltrasfertarandom = generatore.nextInt(5);
											int giornatarandom = generatore.nextInt(36) + 1;
											int cartellinirandom = generatore.nextInt(22);
											String arbitrorandom = arbitri.get(generatore.nextInt(arbitri.size()));
											String stadiorandom = stadi.get(generatore.nextInt(stadi.size()));
											String formcasarandom = formazioni
													.get(generatore.nextInt(formazioni.size()));
											String formospiterandom = formazioni
													.get(generatore.nextInt(formazioni.size()));

											// stampa nell jtextarea della partita generata
											area.setText("part" + codprandom + "\n " + casa + ": " + goalcasarandom
													+ " " + "-" + " " + ospite + ": " + goaltrasfertarandom + "\n"
													+ "N° Giornata: " + giornatarandom + "\n" + "N° Cartellini: "
													+ cartellinirandom + "\n" + "Arbitro: " + arbitrorandom + "\n"
													+ "Stadio: " + stadiorandom + "\n" + "Formazione Casa: "
													+ formcasarandom + "\n" + "Formazione Ospite: " + formospiterandom);
											try {

												// query per codice casa per l'insert
												String CodS = null;
												Statement querycasa = con.createStatement();
												ResultSet resultcasa = querycasa.executeQuery(
														"SELECT s.CodS " + "FROM Squadra s " + "WHERE s.NomeS = '"
																+ Squadre.getSelectedItem() + "'");

												while (resultcasa.next()) {

													CodS = resultcasa.getString("CodS");
												}

												// query per codice ospite per l'insert
												String CodS2 = null;
												Statement queryospite = con.createStatement();
												ResultSet resultospite = queryospite.executeQuery(
														"SELECT s.CodS " + "FROM Squadra s " + "WHERE s.NomeS = '"
																+ Squadre2.getSelectedItem() + "'");

												while (resultospite.next()) {

													CodS2 = resultospite.getString("CodS");
												}

												PreparedStatement queryinsert = (PreparedStatement) con
														.prepareStatement(
																"INSERT INTO Partita(CodP,CodSCasa,CodSTrasferta,Data,GoalCasa,GoalTrasferta,NGiorn,NCartellini,CodAr,CodST,CodFCasa,CodFTrasferta)"
																		+ "value('part" + codprandom + "','" + CodS
																		+ "','" + CodS2 + "','2020-01-15',"
																		+ goalcasarandom + "," + goaltrasfertarandom
																		+ "," + giornatarandom + "," + cartellinirandom
																		+ ",'" + arbitrorandom + "','" + stadiorandom
																		+ "','" + formcasarandom + "','"
																		+ formospiterandom + "');");
												queryinsert.executeUpdate();

											} catch (Exception e) {

												System.out.println("Errore");
											}

										}
									}
								});

							} catch (Exception e) {
								System.out.println("Errore");

							}

						}

					});
				}
			}

		});
		info.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ev) {

				JPanel middlePanel = new JPanel();

				// create the middle panel components

				JTextArea display = new JTextArea(1600, 5800);
				JScrollPane scroll = new JScrollPane(display);
				scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				TextArea listaQuery = new TextArea();

				// Lista query nel pannello info
				listaQuery.setText("1)  Elencare il nome di tutti gli allenatori che allenano in 'Serie A'.\n"
						+ "2)  Elencare tutte le partite dell'anno 2020 ordinate per data.\n"
						+ "3)  Elencare tutti i giocatori della squadra 'Napoli'.\n"
						+ "4)  Elencare i giocatori il cui cognome inizia con una lettera presa in input.\n"
						+ "5)  Elencare le squadre che hanno partecipato al torneo 'Champions League' ma non 'Europa League'.\n"
						+ "6)  Per ogni campionato, contare le squadre che hanno effettuato partite in casa, in cui hanno segnato almeno tre gol.\n"
						+ "7)  Determinare tutti gli arbitri che hanno arbitrato meno di 3 partite in cui la squadra di casa ha vinto.\n"
						+ "8)  Restituire il nome di un squadra con un determinato modulo preso in input.\n"
						+ "9)  Determinare le squadre che hanno almeno tre giocatori attaccanti.\n"
						+ "10) Restituire l'elenco delle squadre che hanno partecipato ad almeno 2 tornei.\n"
						+ "11) Elencare i giocatori che non hanno un numero di maglia e che non sono svincolati.\n"
						+ "12) Stampa tutte le squadre di 'Serie A'.\n" + "13) Elencare le partite dell'anno 2020.\n"
						+ "14) Elencare una classifica di tutte le squadre dei maggiori campionati europei in ordine di goal fatti.\n"
						+ "15) Elencare le squadre che hanno vinto almeno un partita in trasferta.\n"
						+ "16) Elencare in quale stadio viene disputata una singola partita.\n"
						+ "17) Visualizzare i posti disponibili e i posti occupati di uno stadio.\n"
						+ "18) Elencare tutte le squadre che hanno effettuato un allenamento in una precisa data e in quale luogo.\n"
						+ "19) Elencare tutti gli arbitri impegnati in una competizione calcistica.\n"
						+ "20) Elencare tutti i giocatori che hanno subito un infortunio con gravità maggiore rispetto agli altri\n"
						+ "21) Visualizzare l’arbitro che ha ammonito più giocatori.\n"
						+ "22) Elencare tutti gli allenatori che hanno un contratto con una durata maggiore di 1 anno.\n"
						+ "23) Visualizzare il modulo della singola partita disputata.\n"
						+ "24) Generazione randomica di un partita in base alle squadre selezionate dall'utente.\n"
						+ "25) Classifica runtime in base al campionato selezionato.\n");
				listaQuery.setFont(font);
				listaQuery.setEditable(false);
				// Add Textarea in to middle panel
				middlePanel.add(scroll);

				middlePanel.add(display);

				frame.add(middlePanel);
				frame.add(listaQuery);
				frame.pack();
				frame.setLocation(800, 250);
				frame.setSize(710, 320);
				frame.setTitle("Info Query");
				frame.setVisible(true);

				display.setLineWrap(true);
				display.setWrapStyleWord(true);

			}

		});

		classifica.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ev) {
				frame6.setSize(300, 400);
				frame6.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame6.setLocation(600, 350);
				pannello6.add(Campionati);
				area2.setVisible(true);
				area2.setEditable(false);
				pannello6.add(area2);
				frame6.add(pannello6);
				frame6.setVisible(true);

				try {
					PreparedStatement queryclasvit = (PreparedStatement) con
							.prepareStatement("UPDATE campionato.Squadra SET Punti = Punti + '3'" + "WHERE Punti in ("
									+ "SELECT Punti " + "FROM Partita "
									+ "WHERE Squadra.CodS = Partita.CodSCasa AND Partita.GoalCasa > Partita.GoalTrasferta "
									+ ")" + " OR " + "Punti in (" + "SELECT Punti " + "FROM Partita "
									+ "WHERE Squadra.CodS = Partita.CodSTrasferta AND Partita.GoalCasa < Partita.GoalTrasferta );");
					queryclasvit.executeUpdate();
				} catch (Exception e) {
					System.out.println("Errore query classifica vittoria");

				}

				try {
					PreparedStatement queryclasspar = (PreparedStatement) con.prepareStatement(
							"UPDATE campionato.Squadra s1, campionato.Squadra s2 SET s1.Punti = s1.Punti + '1'"
									+ "WHERE s1.Punti in (" + "SELECT s1.Punti " + "FROM Partita "
									+ "WHERE s1.CodS = Partita.CodSCasa AND s2.CodS = Partita.CodSTrasferta AND Partita.GoalCasa = Partita.GoalTrasferta )");
					queryclasspar.executeUpdate();

				} catch (Exception e) {
					System.out.println("Errore query pareggio casa");
					e.printStackTrace();
				}
				try {
					PreparedStatement queryclasspartrasf = (PreparedStatement) con.prepareStatement(
							"UPDATE campionato.Squadra s1, campionato.Squadra s2 SET s2.Punti = s2.Punti + '1'"
									+ "WHERE s2.Punti in (" + "SELECT s2.Punti " + "FROM Partita "
									+ "WHERE s1.CodS = Partita.CodSCasa AND s2.CodS = Partita.CodSTrasferta AND Partita.GoalCasa = Partita.GoalTrasferta );");

					queryclasspartrasf.executeUpdate();

				} catch (Exception e) {
					System.out.println("Errore query pareggio trasferta");

				}

				Campionati.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent ev) {

						try {
							Statement stampaclassifica = con.createStatement();
							ResultSet resultstampa = stampaclassifica.executeQuery("SELECT s.NomeS, s.Punti "
									+ "FROM Campionato c, Squadra s " + "WHERE c.CodC = s.CodC and c.NomeC ='"
									+ Campionati.getSelectedItem() + "'" + "ORDER BY s.Punti DESC ");
							area2.setText("");
							while (resultstampa.next()) {

								String nomeS = resultstampa.getString("NomeS");
								int punti = resultstampa.getInt("Punti");

								area2.append("------- " + nomeS + " : " + punti + "\n\n");

							}
						} catch (Exception e) {
							System.out.println("Errore stampa");
						}
					}
				});
			}

		});

		pane.setAlignmentY(getHeight());
		pannello.add(query);
		pannello.add(info);
		pannello.add(classifica);
		area.setEditable(false);
		this.add(pannello, BorderLayout.NORTH);
		this.add(pane);

		/*
		 * classe per far uscire una sola textArea della lista query System.exit(0)
		 * quando un azione termina windowEvent riceve l'azione del clic sulla x e
		 * quindi della chiusura della finestra
		 */

		class prepareGUI {

			public prepareGUI() {
				frame.addWindowListener(new WindowAdapter() {

					public void windowClosing(WindowEvent windowEvent) {
						System.exit(0);
					}
				});
			}
		}

	}
}
