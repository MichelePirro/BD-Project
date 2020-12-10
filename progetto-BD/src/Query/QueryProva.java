package Query;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

public class QueryProva extends JPanel {
	// dimensioni predefinite del pannello
	private static final int PREF_W = 600;
	private static final int PREF_H = 400;

	// variabili
	private JComboBox<String> query;
	private JTextArea area;
	private JTable table;
	private JScrollPane scroll;
	private JPanel panel;
	public static Connection con;

	// imposta la grandezza del pannello per adattare il frame
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(PREF_W, PREF_H);
	}

	// costruttore
	public QueryProva(Connection con) {

		// connessione
		QueryProva.con = con;
		// tabella
		table = new JTable();
		// text area
		area = new JTextArea(30, 30);
		area.setEditable(false);
		area.setVisible(true);
		// lista query
		query = new JComboBox<String>();

		initQueries();
		// sotto-pannello
		panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2));
		panel.add(table);
		scroll = new JScrollPane(table);
		panel.add(scroll);
		// pannello principale
		this.setLayout(new BorderLayout());
		this.add(query, BorderLayout.NORTH);
		this.add(panel);
	}

	private void initQueries() {
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
			@Override
			public void actionPerformed(ActionEvent ev) {
				area.setText("");
				if (query.getSelectedItem().equals("Squadra")) {
					table.removeAll();
					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery("SELECT * from Squadra;");
						while (result.next())
							resultSetToTable(result, table);
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Giocatore")) {
					table.removeAll();
					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery("SELECT * from Giocatore;");
						while (result.next())
							resultSetToTable(result, table);
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Allenatore")) {
					table.removeAll();
					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery("SELECT * from Allenatore;");
						while (result.next())
							resultSetToTable(result, table);
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Partita")) {
					table.removeAll();
					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery("SELECT * from Partita;");

						while (result.next())
							resultSetToTable(result, table);
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Torneo")) {
					table.removeAll();
					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery("SELECT * from Torneo;");
						while (result.next())
							resultSetToTable(result, table);
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Arbitro")) {
					table.removeAll();
					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery("SELECT * from Arbitro;");
						while (result.next())
							resultSetToTable(result, table);
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Campionato")) {
					table.removeAll();
					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery("SELECT * from Campionato;");
						while (result.next())
							resultSetToTable(result, table);
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Stadio")) {
					table.removeAll();
					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery("SELECT * from Stadio;");
						while (result.next())
							resultSetToTable(result, table);
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Dirigenza")) {
					table.removeAll();
					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery("SELECT * from Dirigenza;");
						while (result.next())
							resultSetToTable(result, table);
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Formazione")) {
					table.removeAll();
					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery("SELECT * from Formazione;");
						while (result.next())
							resultSetToTable(result, table);
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Infortunio")) {
					table.removeAll();
					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery("SELECT * from Infortunio;");
						while (result.next())
							resultSetToTable(result, table);
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Allenamento")) {
					table.removeAll();
					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery("SELECT * from Allenamento;");
						while (result.next())
							resultSetToTable(result, table);
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

				if (query.getSelectedItem().equals("Iscrizioni tornei")) {
					table.removeAll();
					try {
						Statement query = con.createStatement();
						ResultSet result = query.executeQuery("SELECT * from PartecipaT;");
						while (result.next())
							resultSetToTable(result, table);
					} catch (Exception e) {
						area.append("Errore nell'interrogazione");
					}
				}

			}
		});
	}

	private void resultSetToTable(ResultSet result, JTable table) throws SQLException {
		DefaultTableModel tableModel = new DefaultTableModel();
		ResultSetMetaData metaData = result.getMetaData();

		// intestazioni colonne
		int columnCount = metaData.getColumnCount();
		for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
			tableModel.addColumn(metaData.getColumnLabel(columnIndex));
		}

		Object[] row = new Object[columnCount];
		// dati tabella
		while (result.next()) {
			for (int i = 0; i < columnCount; i++)
				row[i] = result.getObject(i + 1);

			tableModel.addRow(row);
		}

		table.setModel(tableModel);
		table.setEnabled(false);

	}

	private static void createAndShowGui() {
		QueryProva query = new QueryProva(con);

		JFrame frame = new JFrame("Query Totale");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(query);
		frame.setLocation(540, 150);
		frame.pack();
		frame.setVisible(true);
	}

	public void show() {
		SwingUtilities.invokeLater(() -> createAndShowGui());
	}
}