package Cancellazione;

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

public class RemoveFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6477157825190965592L;

	private JComboBox<String> combo;
	private JComboBox<String> combo1;
	private JTextField text;
	private JTextField textorn;
	private JButton elimina1;
	private JButton elimina2;
	private JButton elimina3;
	private JButton elimina4;
	private JButton elimina5;
	private JButton elimina6;
	private JButton elimina7;
	private JButton elimina8;
	private JButton elimina9;
	private JButton elimina10;
	private JButton elimina11;
	private JButton elimina12;
	private JButton elimina13;

	private JPanel pannello;
	private JLabel n1;
	private JLabel n2;
	private JLabel n3;
	private JLabel n4;

	public RemoveFrame(Connection con) {
		combo = new JComboBox<String>();
		elimina1 = new JButton("Elimina");
		elimina2 = new JButton("Elimina");
		elimina3 = new JButton("Elimina");
		elimina4 = new JButton("Elimina");
		elimina5 = new JButton("Elimina");
		elimina6 = new JButton("Elimina");
		elimina7 = new JButton("Elimina");
		elimina8 = new JButton("Elimina");
		elimina9 = new JButton("Elimina");
		elimina10 = new JButton("Elimina");
		elimina11 = new JButton("Elimina");
		elimina12 = new JButton("Elimina");
		elimina13 = new JButton("Elimina");

		pannello = new JPanel();
		n1 = new JLabel("Scegli la tabella: ");
		combo1 = new JComboBox<String>();
		text = new JTextField(20);
		n2 = new JLabel("Seleziona il campo: ");
		n3 = new JLabel("Inserisci il valore del campo da cancellare: ");
		n4 = new JLabel("Inserisci il codice del torneo: ");
		textorn = new JTextField(20);

		combo.addItem("-----");
		combo.addItem("Squadra");
		combo.addItem("Giocatore");
		combo.addItem("Allenatore");
		combo.addItem("Partita");
		combo.addItem("Torneo");
		combo.addItem("Campionato");
		combo.addItem("Arbitro");
		combo.addItem("Stadio");
		combo.addItem("Dirigenza");
		combo.addItem("Formazione");
		combo.addItem("Infortunio");
		combo.addItem("Allenamento");

		combo.addItem("Iscrizione torneo");

		pannello.add(n1);
		pannello.add(combo);

		pannello.add(n2);
		pannello.add(combo1);
		pannello.add(n3);
		pannello.add(text);
		pannello.add(n4);
		pannello.add(textorn);
		pannello.add(elimina1);
		pannello.add(elimina2);
		pannello.add(elimina3);
		pannello.add(elimina4);
		pannello.add(elimina5);
		pannello.add(elimina6);
		pannello.add(elimina7);
		pannello.add(elimina8);
		pannello.add(elimina9);
		pannello.add(elimina10);
		pannello.add(elimina11);
		pannello.add(elimina12);
		pannello.add(elimina13);

		n2.setVisible(false);
		combo1.setVisible(false);
		n3.setVisible(false);
		text.setVisible(false);
		textorn.setVisible(false);
		n4.setVisible(false);
		elimina1.setVisible(false);
		elimina2.setVisible(false);
		elimina3.setVisible(false);
		elimina4.setVisible(false);
		elimina5.setVisible(false);
		elimina6.setVisible(false);
		elimina7.setVisible(false);
		elimina8.setVisible(false);
		elimina9.setVisible(false);
		elimina10.setVisible(false);
		elimina11.setVisible(false);
		elimina12.setVisible(false);
		elimina13.setVisible(false);

		combo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				combo1.removeAllItems();

				n2.setVisible(false);
				combo1.setVisible(false);
				n3.setVisible(false);
				text.setVisible(false);
				textorn.setVisible(false);
				n4.setVisible(false);
				elimina1.setVisible(false);
				elimina2.setVisible(false);
				elimina3.setVisible(false);
				elimina4.setVisible(false);
				elimina5.setVisible(false);
				elimina6.setVisible(false);
				elimina7.setVisible(false);
				elimina8.setVisible(false);
				elimina9.setVisible(false);
				elimina10.setVisible(false);
				elimina11.setVisible(false);
				elimina12.setVisible(false);
				elimina13.setVisible(false);

				if (combo.getSelectedItem().equals("Squadra")) {
					n2.setVisible(true);
					combo1.setVisible(true);
					n3.setVisible(true);
					text.setVisible(true);
					n4.setVisible(false);
					textorn.setVisible(false);
					elimina1.setVisible(true);
					elimina2.setVisible(false);
					elimina3.setVisible(false);
					elimina4.setVisible(false);
					elimina5.setVisible(false);
					elimina6.setVisible(false);
					elimina7.setVisible(false);
					elimina8.setVisible(false);
					elimina9.setVisible(false);
					elimina10.setVisible(false);
					elimina11.setVisible(false);
					elimina12.setVisible(false);
					elimina13.setVisible(false);

					combo1.addItem("-----");
					combo1.addItem("CodS");
					combo1.addItem("NomeS");
					combo1.addItem("CodC");

					elimina1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ev) {
							try {
								PreparedStatement query = (PreparedStatement) con
										.prepareStatement("delete from Squadra where " + combo1.getSelectedItem() + "='"
												+ text.getText() + "';");
								query.executeUpdate();
								JOptionPane.showMessageDialog(null, "Cancellazione effettuata con successo.");
								RemoveFrame.this.setVisible(false);
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Errore nella cancellazione, riprova.");
							}
						}
					});
				}

				if (combo.getSelectedItem().equals("Giocatore")) {
					n2.setVisible(true);
					combo1.setVisible(true);
					n3.setVisible(true);
					text.setVisible(true);
					n4.setVisible(false);
					textorn.setVisible(false);
					elimina1.setVisible(false);
					elimina2.setVisible(true);
					elimina3.setVisible(false);
					elimina4.setVisible(false);
					elimina5.setVisible(false);
					elimina6.setVisible(false);
					elimina7.setVisible(false);
					elimina8.setVisible(false);
					elimina9.setVisible(false);
					elimina10.setVisible(false);
					elimina11.setVisible(false);
					elimina12.setVisible(false);
					elimina13.setVisible(false);

					combo1.addItem("-----");
					combo1.addItem("CodT");
					combo1.addItem("Nome");
					combo1.addItem("Cognome");
					combo1.addItem("Ruolo");
					combo1.addItem("Stipendio");
					combo1.addItem("NumMaglia");
					combo1.addItem("CodS");

					elimina2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ev) {
							try {
								PreparedStatement query = (PreparedStatement) con
										.prepareStatement("delete from Giocatore where " + combo1.getSelectedItem()
												+ "='" + text.getText() + "';");
								query.executeUpdate();
								JOptionPane.showMessageDialog(null, "Cancellazione effettuata con successo.");
								RemoveFrame.this.setVisible(false);
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Errore nella cancellazione, riprova.");
							}
						}
					});
				}

				if (combo.getSelectedItem().equals("Allenatore")) {
					n2.setVisible(true);
					combo1.setVisible(true);
					n3.setVisible(true);
					text.setVisible(true);
					n4.setVisible(false);
					textorn.setVisible(false);
					elimina1.setVisible(false);
					elimina2.setVisible(false);
					elimina3.setVisible(true);
					elimina4.setVisible(false);
					elimina5.setVisible(false);
					elimina6.setVisible(false);
					elimina7.setVisible(false);
					elimina8.setVisible(false);
					elimina9.setVisible(false);
					elimina10.setVisible(false);
					elimina11.setVisible(false);
					elimina12.setVisible(false);
					elimina13.setVisible(false);

					combo1.addItem("-----");
					combo1.addItem("CodT");
					combo1.addItem("Nome");
					combo1.addItem("Cognome");
					combo1.addItem("Stipendio");
					combo1.addItem("CodS");

					elimina3.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ev) {
							try {
								PreparedStatement query = (PreparedStatement) con
										.prepareStatement("delete from Allenatore where " + combo1.getSelectedItem()
												+ "='" + text.getText() + "';");
								query.executeUpdate();
								JOptionPane.showMessageDialog(null, "Cancellazione effettuata con successo.");
								RemoveFrame.this.setVisible(false);
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Errore nella cancellazione, riprova.");
							}
						}
					});
				}

				if (combo.getSelectedItem().equals("Partita")) {
					n2.setVisible(true);
					combo1.setVisible(true);
					n3.setVisible(true);
					text.setVisible(true);
					n4.setVisible(false);
					textorn.setVisible(false);
					elimina1.setVisible(false);
					elimina2.setVisible(false);
					elimina3.setVisible(false);
					elimina4.setVisible(true);
					elimina5.setVisible(false);
					elimina6.setVisible(false);
					elimina7.setVisible(false);
					elimina8.setVisible(false);
					elimina9.setVisible(false);
					elimina10.setVisible(false);
					elimina11.setVisible(false);
					elimina12.setVisible(false);
					elimina13.setVisible(false);

					combo1.addItem("-----");
					combo1.addItem("CodP");
					combo1.addItem("CodSCasa");
					combo1.addItem("CodSTrasferta");
					combo1.addItem("Data");
					combo1.addItem("GoalCasa");
					combo1.addItem("GoalTrasferta");
					combo1.addItem("NGiorn");

					elimina4.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ev) {
							try {
								PreparedStatement query = (PreparedStatement) con
										.prepareStatement("delete from Partita where " + combo1.getSelectedItem() + "='"
												+ text.getText() + "';");
								query.executeUpdate();
								JOptionPane.showMessageDialog(null, "Cancellazione effettuata con successo.");
								RemoveFrame.this.setVisible(false);
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Errore nella cancellazione, riprova.");
							}
						}
					});
				}

				if (combo.getSelectedItem().equals("Torneo")) {
					n2.setVisible(true);
					combo1.setVisible(true);
					n3.setVisible(true);
					text.setVisible(true);
					n4.setVisible(false);
					textorn.setVisible(false);
					elimina1.setVisible(false);
					elimina2.setVisible(false);
					elimina3.setVisible(false);
					elimina4.setVisible(false);
					elimina5.setVisible(true);
					elimina6.setVisible(false);
					elimina7.setVisible(false);
					elimina8.setVisible(false);
					elimina9.setVisible(false);
					elimina10.setVisible(false);
					elimina11.setVisible(false);
					elimina12.setVisible(false);
					elimina13.setVisible(false);

					combo1.addItem("-----");
					combo1.addItem("CodT");
					combo1.addItem("NomeT");

					elimina5.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ev) {
							try {
								PreparedStatement query = (PreparedStatement) con
										.prepareStatement("delete from Torneo where " + combo1.getSelectedItem() + "='"
												+ text.getText() + "';");
								query.executeUpdate();
								JOptionPane.showMessageDialog(null, "Cancellazione effettuata con successo.");
								RemoveFrame.this.setVisible(false);
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Errore nella cancellazione, riprova.");
							}
						}
					});
				}

				if (combo.getSelectedItem().equals("Arbitro")) {
					n2.setVisible(true);
					combo1.setVisible(true);
					n3.setVisible(true);
					text.setVisible(true);
					n4.setVisible(false);
					textorn.setVisible(false);
					elimina1.setVisible(false);
					elimina2.setVisible(false);
					elimina3.setVisible(false);
					elimina4.setVisible(false);
					elimina5.setVisible(false);
					elimina6.setVisible(true);
					elimina7.setVisible(false);
					elimina8.setVisible(false);
					elimina9.setVisible(false);
					elimina10.setVisible(false);
					elimina11.setVisible(false);
					elimina12.setVisible(false);
					elimina13.setVisible(false);

					combo1.addItem("-----");
					combo1.addItem("CodAr");
					combo1.addItem("Nome");
					combo1.addItem("Cognome");
					combo1.addItem("Tipologia");

					elimina6.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ev) {
							try {
								PreparedStatement query = (PreparedStatement) con
										.prepareStatement("delete from Arbitro where " + combo1.getSelectedItem() + "='"
												+ text.getText() + "';");
								query.executeUpdate();
								JOptionPane.showMessageDialog(null, "Cancellazione effettuata con successo.");
								RemoveFrame.this.setVisible(false);
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Errore nella cancellazione, riprova.");
							}
						}
					});
				}

				if (combo.getSelectedItem().equals("Campionato")) {
					n2.setVisible(true);
					combo1.setVisible(true);
					n3.setVisible(true);
					text.setVisible(true);
					n4.setVisible(false);
					textorn.setVisible(false);
					elimina1.setVisible(false);
					elimina2.setVisible(false);
					elimina3.setVisible(false);
					elimina4.setVisible(false);
					elimina5.setVisible(false);
					elimina6.setVisible(false);
					elimina7.setVisible(true);
					elimina8.setVisible(false);
					elimina9.setVisible(false);
					elimina10.setVisible(false);
					elimina11.setVisible(false);
					elimina12.setVisible(false);
					elimina13.setVisible(false);

					combo1.addItem("-----");
					combo1.addItem("CodC");
					combo1.addItem("NomeC");

					elimina7.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ev) {
							try {
								PreparedStatement query = (PreparedStatement) con
										.prepareStatement("delete from Campionato where " + combo1.getSelectedItem()
												+ "='" + text.getText() + "';");
								query.executeUpdate();
								JOptionPane.showMessageDialog(null, "Cancellazione effettuata con successo.");
								RemoveFrame.this.setVisible(false);
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Errore nella cancellazione, riprova.");
							}
						}
					});
				}

				if (combo.getSelectedItem().equals("Stadio")) {
					n2.setVisible(true);
					combo1.setVisible(true);
					n3.setVisible(true);
					text.setVisible(true);
					n4.setVisible(false);
					textorn.setVisible(false);
					elimina1.setVisible(false);
					elimina2.setVisible(false);
					elimina3.setVisible(false);
					elimina4.setVisible(false);
					elimina5.setVisible(false);
					elimina6.setVisible(false);
					elimina7.setVisible(false);
					elimina8.setVisible(true);
					elimina9.setVisible(false);
					elimina10.setVisible(false);
					elimina11.setVisible(false);
					elimina12.setVisible(false);
					elimina13.setVisible(false);

					combo1.addItem("-----");
					combo1.addItem("CodST");
					combo1.addItem("CostoBigl");
					combo1.addItem("PostiDisp");
					combo1.addItem("PostiOcc");

					elimina8.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ev) {
							try {
								PreparedStatement query = (PreparedStatement) con
										.prepareStatement("delete from Stadio where " + combo1.getSelectedItem() + "='"
												+ text.getText() + "';");
								query.executeUpdate();
								JOptionPane.showMessageDialog(null, "Cancellazione effettuata con successo.");
								RemoveFrame.this.setVisible(false);
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Errore nella cancellazione, riprova.");
							}
						}
					});
				}

				if (combo.getSelectedItem().equals("Dirigenza")) {
					n2.setVisible(true);
					combo1.setVisible(true);
					n3.setVisible(true);
					text.setVisible(true);
					n4.setVisible(false);
					textorn.setVisible(false);
					elimina1.setVisible(false);
					elimina2.setVisible(false);
					elimina3.setVisible(false);
					elimina4.setVisible(false);
					elimina5.setVisible(false);
					elimina6.setVisible(false);
					elimina7.setVisible(false);
					elimina8.setVisible(false);
					elimina9.setVisible(true);
					elimina10.setVisible(false);
					elimina11.setVisible(false);
					elimina12.setVisible(false);
					elimina13.setVisible(false);

					combo1.addItem("-----");
					combo1.addItem("CodDir");
					combo1.addItem("CodT");
					combo1.addItem("Sede");
					combo1.addItem("NomeDir");
					combo1.addItem("Durata");

					elimina9.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ev) {
							try {
								PreparedStatement query = (PreparedStatement) con
										.prepareStatement("delete from Dirigenza where " + combo1.getSelectedItem()
												+ "='" + text.getText() + "';");
								query.executeUpdate();
								JOptionPane.showMessageDialog(null, "Cancellazione effettuata con successo.");
								RemoveFrame.this.setVisible(false);
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Errore nella cancellazione, riprova.");
							}
						}
					});
				}

				if (combo.getSelectedItem().equals("Formazione")) {
					n2.setVisible(true);
					combo1.setVisible(true);
					n3.setVisible(true);
					text.setVisible(true);
					n4.setVisible(false);
					textorn.setVisible(false);
					elimina1.setVisible(false);
					elimina2.setVisible(false);
					elimina3.setVisible(false);
					elimina4.setVisible(false);
					elimina5.setVisible(false);
					elimina6.setVisible(false);
					elimina7.setVisible(false);
					elimina8.setVisible(false);
					elimina9.setVisible(false);
					elimina10.setVisible(true);
					elimina11.setVisible(false);
					elimina12.setVisible(false);
					elimina13.setVisible(false);

					combo1.addItem("-----");
					combo1.addItem("CodF");
					combo1.addItem("NomeSquadra");
					combo1.addItem("Modulo");
					combo1.addItem("Sostituti");

					elimina10.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ev) {
							try {
								PreparedStatement query = (PreparedStatement) con
										.prepareStatement("delete from Formazione where " + combo1.getSelectedItem()
												+ "='" + text.getText() + "';");
								query.executeUpdate();
								JOptionPane.showMessageDialog(null, "Cancellazione effettuata con successo.");
								RemoveFrame.this.setVisible(false);
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Errore nella cancellazione, riprova.");
							}
						}
					});
				}

				if (combo.getSelectedItem().equals("Infortunio")) {
					n2.setVisible(true);
					combo1.setVisible(true);
					n3.setVisible(true);
					text.setVisible(true);
					n4.setVisible(false);
					textorn.setVisible(false);
					elimina1.setVisible(false);
					elimina2.setVisible(false);
					elimina3.setVisible(false);
					elimina4.setVisible(false);
					elimina5.setVisible(false);
					elimina6.setVisible(false);
					elimina7.setVisible(false);
					elimina8.setVisible(false);
					elimina9.setVisible(false);
					elimina10.setVisible(false);
					elimina11.setVisible(true);
					elimina12.setVisible(false);
					elimina13.setVisible(false);

					combo1.addItem("-----");
					combo1.addItem("CodInf");
					combo1.addItem("CodT");
					combo1.addItem("Tipologia");
					combo1.addItem("Gravita");
					combo1.addItem("MedicoCurante");

					elimina11.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ev) {
							try {
								PreparedStatement query = (PreparedStatement) con
										.prepareStatement("delete from Infortunio where " + combo1.getSelectedItem()
												+ "='" + text.getText() + "';");
								query.executeUpdate();
								JOptionPane.showMessageDialog(null, "Cancellazione effettuata con successo.");
								RemoveFrame.this.setVisible(false);
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Errore nella cancellazione, riprova.");
							}
						}
					});
				}

				if (combo.getSelectedItem().equals("Allenamento")) {
					n2.setVisible(true);
					combo1.setVisible(true);
					n3.setVisible(true);
					text.setVisible(true);
					n4.setVisible(false);
					textorn.setVisible(false);
					elimina1.setVisible(false);
					elimina2.setVisible(false);
					elimina3.setVisible(false);
					elimina4.setVisible(false);
					elimina5.setVisible(false);
					elimina6.setVisible(false);
					elimina7.setVisible(false);
					elimina8.setVisible(false);
					elimina9.setVisible(false);
					elimina10.setVisible(false);
					elimina11.setVisible(false);
					elimina12.setVisible(true);
					elimina13.setVisible(false);

					combo1.addItem("-----");
					combo1.addItem("CodAll");
					combo1.addItem("Luogo");
					combo1.addItem("Data");
					combo1.addItem("CodS");

					elimina12.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ev) {
							try {
								PreparedStatement query = (PreparedStatement) con
										.prepareStatement("delete from Allenamento where " + combo1.getSelectedItem()
												+ "='" + text.getText() + "';");
								query.executeUpdate();
								JOptionPane.showMessageDialog(null, "Cancellazione effettuata con successo.");
								RemoveFrame.this.setVisible(false);
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Errore nella cancellazione, riprova.");
							}
						}
					});
				}

				if (combo.getSelectedItem().equals("Iscrizione torneo")) {
					n2.setVisible(false);
					combo1.setVisible(false);
					n3.setVisible(true);
					text.setVisible(true);
					n4.setVisible(true);
					textorn.setVisible(true);
					elimina1.setVisible(false);
					elimina2.setVisible(false);
					elimina3.setVisible(false);
					elimina4.setVisible(false);
					elimina5.setVisible(false);
					elimina6.setVisible(false);
					elimina7.setVisible(false);
					elimina8.setVisible(false);
					elimina9.setVisible(false);
					elimina10.setVisible(false);
					elimina11.setVisible(false);
					elimina12.setVisible(false);
					elimina13.setVisible(true);

					elimina13.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ev) {
							try {
								PreparedStatement query = (PreparedStatement) con
										.prepareStatement("delete from PartecipaT where CodS='" + text.getText()
												+ "' AND CodT='" + textorn.getText() + "';");
								query.executeUpdate();
								JOptionPane.showMessageDialog(null, "Cancellazione al torneo effettuata con successo.");
								RemoveFrame.this.setVisible(false);
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Errore nella cancellazione, riprova.");
							}
						}
					});
				}

			}
		});

		this.add(pannello);
	}
}
