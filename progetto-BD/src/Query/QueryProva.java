package Query;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.mysql.jdbc.Connection;

public class QueryProva extends JFrame {

	/**
	 * Query di prova
	 */
	private static final long serialVersionUID = 3347886131317848991L;

	private JComboBox<String> query;
	private JTextArea area;
	private JPanel pannello;
	private JScrollPane pane;

	public QueryProva(Connection con) {
		pannello = new JPanel();
		area = new JTextArea(30, 30);
		pane = new JScrollPane(area);
		query = new JComboBox<String>();

		query.addItem("-----");
		query.addItem("Squadra");
		query.addItem("Giocatore");
		query.addItem("Allenatore");
		query.addItem("Partita");
		query.addItem("Torneo");
		query.addItem("Arbitro");
		query.addItem("Campionato");
		query.addItem("Stadio");
		query.addItem("Dirigenza");
		query.addItem("Formazione");
		query.addItem("Infortunio");
		query.addItem("Allenamento");
		query.addItem("Iscrizioni tornei");

		query.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				area.setText("");

				if (query.getSelectedItem().equals("Squadra")) {

					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery("SELECT * from Squadra;");
						area.append("CODS ----- NOMES ----- CODC\n\n");
						while (result.next()) {
							String CodS = result.getString("CodS");

							String NomeS = result.getString("NomeS");

							String CodC = result.getString("CodC");

							area.append(CodS + " ----- " + "" + NomeS + " ----- " + CodC + "\n\n");
						}
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Giocatore")) {

					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery("SELECT * from Giocatore;");
						area.append(
								"CODT ----- NOME ----- COGNOME ----- RUOLO ----- STIPENDIO ----- NUM.MAGLIA ----- CODS\n\n");
						while (result.next()) {
							String CodT = result.getString("CodT");

							String Nome = result.getString("Nome");

							String Cognome = result.getString("Cognome");

							String Ruolo = result.getString("Ruolo");

							double Stipendio = result.getDouble("Stipendio");

							int nummaglia = result.getInt("NumMaglia");

							String CodS = result.getString("CodS");

							area.append(CodT + " ----- " + Nome + " ----- " + Cognome + " ----- " + Ruolo + " ----- "
									+ Stipendio + " ----- " + nummaglia + " ----- " + CodS + "\n\n");
						}
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Allenatore")) {

					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery("SELECT * from Allenatore;");
						area.append("CODT ----- CODS ----- NOME ----- COGNOME ----- STIPENDIO\n\n");
						while (result.next()) {
							String CodT = result.getString("CodT");

							String CodS = result.getString("CodS");

							String Nome = result.getString("Nome");

							String Cognome = result.getString("Cognome");

							double Stipendio = result.getDouble("Stipendio");

							area.append(CodT + " ----- " + CodS + " ----- " + Nome + " ----- " + Cognome + " ----- "
									+ Stipendio + "\n\n");
						}
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Partita")) {

					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery("SELECT * from Partita;");
						area.append(
								"CODP ----- CODSCASA ----- CODSTRASFERTA ----- DATA ----- GOALCASA ----- GOALTRASFERTA ----- N.GIORN ----- CODAR -----CODST -----CODF\n\n");
						while (result.next()) {
							String CodP = result.getString("CodP");

							String CodSCasa = result.getString("CodSCasa");

							String CodSTrasferta = result.getString("CodSTrasferta");

							String data = result.getString("Data");

							int golc = result.getInt("GoalCasa");

							int golt = result.getInt("GoalTrasferta");

							int ngiorn = result.getInt("NGiorn");

							String CodAr = result.getString("CodAr");

							String CodST = result.getString("CodST");

							String CodF = result.getString("CodF");

							area.append(CodP + " ----- " + CodSCasa + " ----- " + CodSTrasferta + " ----- " + data
									+ " ----- " + golc + " ----- " + golt + " ----- " + ngiorn + " ----- " + CodAr
									+ " ----- " + CodST + " ----- " + CodF + "\n\n");
						}
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Torneo")) {

					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery("SELECT * from Torneo;");
						area.append("CODT ----- NOMET\n\n");
						while (result.next()) {
							String CodT = result.getString("CodT");

							String NomeT = result.getString("NomeT");

							area.append(CodT + " ----- " + NomeT + "\n\n");
						}
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Arbitro")) {

					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery("SELECT * from Arbitro;");
						area.append("CODAR ----- NOME ----- COGNOME ----- TIPOLOGIA \n\n");
						while (result.next()) {

							String CodAr = result.getString("CodAr");

							String Nome = result.getString("Nome");

							String Cognome = result.getString("Cognome");

							String Tipologia = result.getString("Tipologia");

							area.append(
									CodAr + " ----- " + Nome + " ----- " + Cognome + " ----- " + Tipologia + "\n\n");
						}
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Campionato")) {

					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery("SELECT * from Campionato;");
						area.append("CODC ----- NOMEC\n\n");
						while (result.next()) {
							String CodC = result.getString("CodC");

							String NomeC = result.getString("NomeC");

							area.append(CodC + " ----- " + NomeC + "\n\n");
						}
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Stadio")) {

					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery("SELECT * from Stadio;");
						area.append("COST ----- COSTOBIGLIETTI ----- POSTIDISPONIBILI ----- POSTIOCCUPATI\n\n");
						while (result.next()) {
							String CodST = result.getString("CodST");

							String CostoBigl = result.getString("CostoBigl");

							String PostiDisp = result.getString("PostiDisp");

							String PostiOcc = result.getString("PostiOcc");

							area.append(CodST + " ----- " + CostoBigl + " ----- " + PostiDisp + " ----- " + PostiOcc
									+ "\n\n");
						}
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Dirigenza")) {

					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery("SELECT * from Dirigenza;");
						area.append("CODDIR -----CODT ----- SEDE ----- NOMEDIR ----- DURATA\n\n");
						while (result.next()) {
							String CodDir = result.getString("CodDir");

							String CodT = result.getString("CodT");

							String Sede = result.getString("Sede");

							String NomeDir = result.getString("NomeDir");

							int Durata = result.getInt("Durata");

							area.append(CodDir + " ----- " + CodT + " ----- " + Sede + " ----- " + NomeDir + " ----- "
									+ Durata + "\n\n");
						}
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Formazione")) {

					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery("SELECT * from Formazione;");
						area.append("CODF ----- NOMESQUADRA ----- MODULO ----- SOSTITUTI\n\n");
						while (result.next()) {
							String CodF = result.getString("CodF");

							String NomeSquadra = result.getString("NomeSquadra");

							String Modulo = result.getString("Modulo");

							int Sostituti = result.getInt("Sostituti");

							area.append(CodF + " ----- " + NomeSquadra + " ----- " + Modulo + " ----- " + Sostituti
									+ "\n\n");
						}
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Infortunio")) {

					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery("SELECT * from Infortunio;");
						area.append("CODINF ----- CODT ----- TIPOLOGIA ----- GRAVITA ----- MEDICOCURANTE\n\n");
						while (result.next()) {
							String CodInf = result.getString("CodInf");

							String CodT = result.getString("CodT");

							String Tipologia = result.getString("Tipologia");

							String Gravita = result.getString("Gravita");

							String MedicoCurante = result.getString("MedicoCurante");

							area.append(CodInf + " ----- " + CodT + " ----- " + Tipologia + " ----- " + Gravita
									+ " ----- " + MedicoCurante + "\n\n");
						}
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Allenamento")) {

					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery("SELECT * from Allenamento;");
						area.append("CODALL ----- LUOGO ----- DATA ----- CODS\n\n");
						while (result.next()) {
							String CodAll = result.getString("CodAll");

							String Luogo = result.getString("Luogo");

							Date Data = result.getDate("Data");

							String CodS = result.getString("CodS");

							area.append(CodAll + " ----- " + Luogo + " ----- " + Data + " ----- " + CodS + "\n\n");
						}
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Iscrizioni tornei")) {

					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery("SELECT * from PartecipaT;");
						area.append("CODS ----- CODT\n\n");
						while (result.next()) {
							String CodS = result.getString("CodS");

							String CodT = result.getString("CodT");

							area.append(CodS + " ----- " + CodT + "\n\n");
						}
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

			}
		});

		pannello.add(query);
		area.setEditable(false);
		this.add(pannello, BorderLayout.NORTH);
		this.add(pane);
	}
}
