package Modifica;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ModificaFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4297136928491473137L;

	private JComboBox<String> combo;
	private JComboBox<String> combo1;
	private JPanel pannello;
	private JButton modifica1;
	private JButton modifica2;
	private JButton modifica3;
	private JButton modifica4;
	private JButton modifica5;
	private JButton modifica6;
	private JButton modifica7;
	private JButton modifica8;
	private JButton modifica9;
	private JButton modifica10;
	private JButton modifica11;
	private JButton modifica12;

	private JTextField text;
	private JTextField text1;
	private JLabel n;
	private JLabel n1;
	private JLabel n2;
	private JLabel n3;
	private JTextField text2;
	private JLabel n4;

	public ModificaFrame(Connection con) {
		combo = new JComboBox<String>();
		pannello = new JPanel();
		modifica1 = new JButton("Modifica");
		modifica2 = new JButton("Modifica");
		modifica3 = new JButton("Modifica");
		modifica4 = new JButton("Modifica");
		modifica5 = new JButton("Modifica");
		modifica6 = new JButton("Modifica");
		modifica7 = new JButton("Modifica");
		modifica8 = new JButton("Modifica");
		modifica9 = new JButton("Modifica");
		modifica10 = new JButton("Modifica");
		modifica11 = new JButton("Modifica");
		modifica12 = new JButton("Modifica");

		text = new JTextField(20);
		text1 = new JTextField(20);
		n1 = new JLabel("Inserisci il codice della tabella selezionata: ");
		n = new JLabel("Scegli la tabella:");
		n2 = new JLabel("Seleziona campo da modificare:");
		n3 = new JLabel("Inserisci nuovo valore:");
		combo1 = new JComboBox<String>();
		text2 = new JTextField(20);
		n4 = new JLabel("Inserisci il codice attuale del torneo: ");

		combo.addItem("-----");
		combo.addItem("Squadra");
		combo.addItem("Giocatore");
		combo.addItem("Allenatore");
		combo.addItem("Partita");
		combo.addItem("Torneo");
		combo.addItem("Arbitro");
		combo.addItem("Campionato");
		combo.addItem("Stadio");
		combo.addItem("Dirigenza");
		combo.addItem("Formazione");
		combo.addItem("Infortunio");
		combo.addItem("Campionato");

		combo.addItem("Iscrizione torneo");

		n1.setVisible(false);
		text.setVisible(false);
		n2.setVisible(false);
		combo1.setVisible(false);
		n3.setVisible(false);
		text1.setVisible(false);
		modifica1.setVisible(false);
		modifica2.setVisible(false);
		modifica3.setVisible(false);
		modifica4.setVisible(false);
		modifica5.setVisible(false);
		modifica6.setVisible(false);
		modifica7.setVisible(false);
		modifica8.setVisible(false);
		modifica9.setVisible(false);
		modifica10.setVisible(false);
		modifica11.setVisible(false);
		modifica12.setVisible(false);

		text2.setVisible(false);
		n4.setVisible(false);

		pannello.add(n);
		pannello.add(combo);
		pannello.add(n1);
		pannello.add(text);
		pannello.add(n2);
		pannello.add(combo1);
		pannello.add(n3);
		pannello.add(text1);
		pannello.add(n4);
		pannello.add(text2);
		pannello.add(modifica1);
		pannello.add(modifica2);
		pannello.add(modifica3);
		pannello.add(modifica4);
		pannello.add(modifica5);
		pannello.add(modifica6);
		pannello.add(modifica7);
		pannello.add(modifica8);
		pannello.add(modifica9);
		pannello.add(modifica10);
		pannello.add(modifica11);
		pannello.add(modifica12);

		combo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				combo1.removeAllItems();

				n1.setVisible(true);
				text.setVisible(true);
				n2.setVisible(true);
				combo1.setVisible(true);
				n3.setVisible(true);
				text1.setVisible(true);

				if (combo.getSelectedItem().equals("Giocatore")) {

					n1.setVisible(true);
					text.setVisible(true);
					n2.setVisible(true);
					combo1.setVisible(true);
					n3.setVisible(true);
					text1.setVisible(true);
					modifica1.setVisible(true);
					modifica2.setVisible(false);
					modifica3.setVisible(false);
					modifica4.setVisible(false);
					modifica5.setVisible(false);
					modifica6.setVisible(false);
					modifica7.setVisible(false);
					text2.setVisible(false);
					n4.setVisible(false);

					combo1.addItem("-----");
					combo1.addItem("CF");
					combo1.addItem("Nome");
					combo1.addItem("Cognome");
					combo1.addItem("Ruolo");
					combo1.addItem("Stipendio");
					combo1.addItem("NumMaglia");
					combo1.addItem("CodS");

					modifica1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ev) {
							try {
								PreparedStatement query = (PreparedStatement) con
										.prepareStatement("UPDATE Giocatore SET " + combo1.getSelectedItem() + "='"
												+ text1.getText() + "' WHERE CF='" + text.getText() + "';");
								query.executeUpdate();
								JOptionPane.showMessageDialog(null, "Modifica effettuata con successo.");
								ModificaFrame.this.setVisible(false);
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Errore nella modifica, riprova.");
							}
						}
					});

				}

				if (combo.getSelectedItem().equals("Squadra")) {
					n1.setVisible(true);
					text.setVisible(true);
					n2.setVisible(true);
					combo1.setVisible(true);
					n3.setVisible(true);
					text1.setVisible(true);
					modifica1.setVisible(false);
					modifica2.setVisible(true);
					modifica3.setVisible(false);
					modifica4.setVisible(false);
					modifica5.setVisible(false);
					modifica6.setVisible(false);
					modifica7.setVisible(false);

					text2.setVisible(false);
					n4.setVisible(false);

					combo1.addItem("-----");
					combo1.addItem("CodS");
					combo1.addItem("NomeS");
					combo1.addItem("CodC");

					modifica2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ev) {
							try {
								PreparedStatement query = (PreparedStatement) con
										.prepareStatement("UPDATE Squadra SET " + combo1.getSelectedItem() + "='"
												+ text1.getText() + "' WHERE CodS='" + text.getText() + "';");
								query.executeUpdate();
								JOptionPane.showMessageDialog(null, "Modifica effettuata con successo.");
								ModificaFrame.this.setVisible(false);
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Errore nella modifica, riprova.");
							}
						}
					});

				}

				if (combo.getSelectedItem().equals("Allenatore")) {
					n1.setVisible(true);
					text.setVisible(true);
					n2.setVisible(true);
					combo1.setVisible(true);
					n3.setVisible(true);
					text1.setVisible(true);
					modifica1.setVisible(false);
					modifica2.setVisible(false);
					modifica3.setVisible(true);
					modifica4.setVisible(false);
					modifica5.setVisible(false);
					modifica6.setVisible(false);
					modifica7.setVisible(false);
					text2.setVisible(false);
					n4.setVisible(false);

					combo1.addItem("-----");
					combo1.addItem("CF");
					combo1.addItem("Nome");
					combo1.addItem("Cognome");
					combo1.addItem("Stipendio");
					combo1.addItem("CodS");

					modifica3.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ev) {
							try {
								PreparedStatement query = (PreparedStatement) con
										.prepareStatement("UPDATE Allenatore SET " + combo1.getSelectedItem() + "='"
												+ text1.getText() + "' WHERE CF='" + text.getText() + "';");
								query.executeUpdate();
								JOptionPane.showMessageDialog(null, "Modifica effettuata con successo.");
								ModificaFrame.this.setVisible(false);
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Errore nella modifica, riprova.");
							}

						}
					});
				}

				if (combo.getSelectedItem().equals("Partita")) {
					n1.setVisible(true);
					text.setVisible(true);
					n2.setVisible(true);
					combo1.setVisible(true);
					n3.setVisible(true);
					text1.setVisible(true);
					modifica1.setVisible(false);
					modifica2.setVisible(false);
					modifica3.setVisible(false);
					modifica4.setVisible(true);
					modifica5.setVisible(false);
					modifica6.setVisible(false);
					modifica7.setVisible(false);
					text2.setVisible(false);
					n4.setVisible(false);

					combo1.addItem("-----");
					combo1.addItem("CodP");
					combo1.addItem("CodSCasa");
					combo1.addItem("CodSTrasferta");
					combo1.addItem("Data");
					combo1.addItem("GoalCasa");
					combo1.addItem("GoalTrasferta");
					combo1.addItem("NGiorn");

					modifica4.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ev) {
							try {
								PreparedStatement query = (PreparedStatement) con
										.prepareStatement("UPDATE Partita SET " + combo1.getSelectedItem() + "='"
												+ text1.getText() + "' WHERE CodP='" + text.getText() + "';");
								query.executeUpdate();
								JOptionPane.showMessageDialog(null, "Modifica effettuata con successo.");
								ModificaFrame.this.setVisible(false);
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Errore nella modifica, riprova.");
							}
						}
					});
				}

				if (combo.getSelectedItem().equals("Torneo")) {
					n1.setVisible(true);
					text.setVisible(true);
					n2.setVisible(true);
					combo1.setVisible(true);
					n3.setVisible(true);
					text1.setVisible(true);
					modifica1.setVisible(false);
					modifica2.setVisible(false);
					modifica3.setVisible(false);
					modifica4.setVisible(false);
					modifica5.setVisible(true);
					modifica6.setVisible(false);
					modifica7.setVisible(false);
					text2.setVisible(false);
					n4.setVisible(false);

					combo1.addItem("-----");
					combo1.addItem("CodT");
					combo1.addItem("NomeT");

					modifica5.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ev) {
							try {
								PreparedStatement query = (PreparedStatement) con
										.prepareStatement("UPDATE Torneo SET " + combo1.getSelectedItem() + "='"
												+ text1.getText() + "' WHERE CodT='" + text.getText() + "';");
								query.executeUpdate();
								JOptionPane.showMessageDialog(null, "Modifica effettuata con successo.");
								ModificaFrame.this.setVisible(false);
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Errore nella modifica, riprova.");
							}
						}
					});
				}

				if (combo.getSelectedItem().equals("Arbitro")) {
					n1.setVisible(true);
					text.setVisible(true);
					n2.setVisible(true);
					combo1.setVisible(true);
					n3.setVisible(true);
					text1.setVisible(true);
					modifica1.setVisible(false);
					modifica2.setVisible(false);
					modifica3.setVisible(false);
					modifica4.setVisible(false);
					modifica5.setVisible(false);
					modifica6.setVisible(true);
					modifica7.setVisible(false);
					text2.setVisible(false);
					n4.setVisible(false);

					combo1.addItem("-----");
					combo1.addItem("CodAr");
					combo1.addItem("Nome");
					combo1.addItem("Cognome");
					combo1.addItem("Tipologia");

					modifica6.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ev) {
							try {
								PreparedStatement query = (PreparedStatement) con
										.prepareStatement("UPDATE Arbitro SET " + combo1.getSelectedItem() + "='"
												+ text1.getText() + "' WHERE CodAr='" + text.getText() + "';");
								query.executeUpdate();
								JOptionPane.showMessageDialog(null, "Modifica effettuata con successo.");
								ModificaFrame.this.setVisible(false);
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Errore nella modifica, riprova.");
							}
						}
					});
				}

				if (combo.getSelectedItem().equals("Campionato")) {
					n1.setVisible(true);
					text.setVisible(true);
					n2.setVisible(true);
					combo1.setVisible(true);
					n3.setVisible(true);
					text1.setVisible(true);
					modifica1.setVisible(false);
					modifica2.setVisible(false);
					modifica3.setVisible(false);
					modifica4.setVisible(false);
					modifica5.setVisible(false);
					modifica6.setVisible(false);
					modifica7.setVisible(true);
					text2.setVisible(false);
					n4.setVisible(false);

					combo1.addItem("-----");
					combo1.addItem("CodC");
					combo1.addItem("NomeC");

					modifica7.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ev) {
							try {
								PreparedStatement query = (PreparedStatement) con
										.prepareStatement("UPDATE Campionato SET " + combo1.getSelectedItem() + "='"
												+ text1.getText() + "' WHERE CodC='" + text.getText() + "';");
								query.executeUpdate();
								JOptionPane.showMessageDialog(null, "Modifica effettuata con successo.");
								ModificaFrame.this.setVisible(false);
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Errore nella modifica, riprova.");
							}
						}
					});
				}

				if (combo.getSelectedItem().equals("Stadio")) {
					n1.setVisible(true);
					text.setVisible(true);
					n2.setVisible(true);
					combo1.setVisible(true);
					n3.setVisible(true);
					text1.setVisible(true);
					modifica1.setVisible(false);
					modifica2.setVisible(false);
					modifica3.setVisible(false);
					modifica4.setVisible(false);
					modifica5.setVisible(false);
					modifica6.setVisible(false);
					modifica7.setVisible(false);
					modifica8.setVisible(true);
					modifica9.setVisible(false);
					modifica10.setVisible(false);
					modifica11.setVisible(false);
					modifica12.setVisible(false);
					text2.setVisible(false);
					n4.setVisible(false);

					combo1.addItem("-----");
					combo1.addItem("CodST");
					combo1.addItem("CostoBigl");
					combo1.addItem("PostiDisp");
					combo1.addItem("PostiOcc");

					modifica8.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ev) {
							try {
								PreparedStatement query = (PreparedStatement) con
										.prepareStatement("UPDATE Stadio SET " + combo1.getSelectedItem() + "='"
												+ text1.getText() + "' WHERE CodST='" + text.getText() + "';");
								query.executeUpdate();
								JOptionPane.showMessageDialog(null, "Modifica effettuata con successo.");
								ModificaFrame.this.setVisible(false);
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Errore nella modifica, riprova.");
							}
						}
					});
				}

				if (combo.getSelectedItem().equals("Dirigenza")) {
					n1.setVisible(true);
					text.setVisible(true);
					n2.setVisible(true);
					combo1.setVisible(true);
					n3.setVisible(true);
					text1.setVisible(true);
					modifica1.setVisible(false);
					modifica2.setVisible(false);
					modifica3.setVisible(false);
					modifica4.setVisible(false);
					modifica5.setVisible(false);
					modifica6.setVisible(false);
					modifica7.setVisible(false);
					modifica8.setVisible(false);
					modifica9.setVisible(true);
					modifica10.setVisible(false);
					modifica11.setVisible(false);
					modifica12.setVisible(false);
					text2.setVisible(false);
					n4.setVisible(false);

					combo1.addItem("-----");
					combo1.addItem("CodDir");
					combo1.addItem("CodT");
					combo1.addItem("Sede");
					combo1.addItem("NomeDir");
					combo1.addItem("Durata");

					modifica9.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ev) {
							try {
								PreparedStatement query = (PreparedStatement) con
										.prepareStatement("UPDATE Dirigenza SET " + combo1.getSelectedItem() + "='"
												+ text1.getText() + "' WHERE CodDir='" + text.getText() + "';");
								query.executeUpdate();
								JOptionPane.showMessageDialog(null, "Modifica effettuata con successo.");
								ModificaFrame.this.setVisible(false);
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Errore nella modifica, riprova.");
							}
						}
					});
				}

				if (combo.getSelectedItem().equals("Formazione")) {
					n1.setVisible(true);
					text.setVisible(true);
					n2.setVisible(true);
					combo1.setVisible(true);
					n3.setVisible(true);
					text1.setVisible(true);
					modifica1.setVisible(false);
					modifica2.setVisible(false);
					modifica3.setVisible(false);
					modifica4.setVisible(false);
					modifica5.setVisible(false);
					modifica6.setVisible(false);
					modifica7.setVisible(false);
					modifica8.setVisible(false);
					modifica9.setVisible(false);
					modifica10.setVisible(true);
					modifica11.setVisible(false);
					modifica12.setVisible(false);
					text2.setVisible(false);
					n4.setVisible(false);

					combo1.addItem("-----");
					combo1.addItem("CodF");
					combo1.addItem("NomeSquadra");
					combo1.addItem("Modulo");
					combo1.addItem("Sostituti");

					modifica10.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ev) {
							try {
								PreparedStatement query = (PreparedStatement) con
										.prepareStatement("UPDATE Formazione SET " + combo1.getSelectedItem() + "='"
												+ text1.getText() + "' WHERE CodF='" + text.getText() + "';");
								query.executeUpdate();
								JOptionPane.showMessageDialog(null, "Modifica effettuata con successo.");
								ModificaFrame.this.setVisible(false);
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Errore nella modifica, riprova.");
							}
						}
					});
				}

				if (combo.getSelectedItem().equals("Infortunio")) {
					n1.setVisible(true);
					text.setVisible(true);
					n2.setVisible(true);
					combo1.setVisible(true);
					n3.setVisible(true);
					text1.setVisible(true);
					modifica1.setVisible(false);
					modifica2.setVisible(false);
					modifica3.setVisible(false);
					modifica4.setVisible(false);
					modifica5.setVisible(false);
					modifica6.setVisible(false);
					modifica7.setVisible(false);
					modifica8.setVisible(false);
					modifica9.setVisible(false);
					modifica10.setVisible(false);
					modifica11.setVisible(true);
					modifica12.setVisible(false);
					text2.setVisible(false);
					n4.setVisible(false);

					combo1.addItem("-----");
					combo1.addItem("CodInf");
					combo1.addItem("CodT");
					combo1.addItem("Tipologia");
					combo1.addItem("Gravita");
					combo1.addItem("MedicoCurante");

					modifica11.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ev) {
							try {
								PreparedStatement query = (PreparedStatement) con
										.prepareStatement("UPDATE Infortunio SET " + combo1.getSelectedItem() + "='"
												+ text1.getText() + "' WHERE CodInf='" + text.getText() + "';");
								query.executeUpdate();
								JOptionPane.showMessageDialog(null, "Modifica effettuata con successo.");
								ModificaFrame.this.setVisible(false);
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Errore nella modifica, riprova.");
							}
						}
					});
				}

				if (combo.getSelectedItem().equals("Iscrizione torneo")) {
					n1.setVisible(true);
					text.setVisible(true);
					n2.setVisible(true);
					combo1.setVisible(true);
					n3.setVisible(true);
					text1.setVisible(true);
					modifica1.setVisible(false);
					modifica2.setVisible(false);
					modifica3.setVisible(false);
					modifica4.setVisible(false);
					modifica5.setVisible(false);
					modifica6.setVisible(false);
					modifica7.setVisible(false);
					modifica8.setVisible(false);
					modifica9.setVisible(false);
					modifica10.setVisible(false);
					modifica11.setVisible(false);
					modifica12.setVisible(true);

					text2.setVisible(true);
					n4.setVisible(true);

					combo1.addItem("-----");
					combo1.addItem("CodS");
					combo1.addItem("CodT");

					modifica12.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ev) {
							try {
								PreparedStatement query = (PreparedStatement) con
										.prepareStatement("UPDATE PartecipaT SET " + combo1.getSelectedItem() + "='"
												+ text1.getText() + "' WHERE CodS='" + text.getText() + "' AND CodT='"
												+ text2.getText() + "';");
								query.executeUpdate();
								JOptionPane.showMessageDialog(null, "Modifica effettuata con successo.");
								ModificaFrame.this.setVisible(false);
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Errore nella modifica, riprova.");
							}
						}
					});
				}

			}
		});

		this.add(pannello, BorderLayout.CENTER);
	}

}
