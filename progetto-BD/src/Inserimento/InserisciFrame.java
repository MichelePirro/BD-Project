package Inserimento;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mysql.jdbc.Connection;

public class InserisciFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6365727298703739561L;

	private JLabel text;
	private JButton squadra;
	private JButton giocatore;
	private JButton allenatore;
	private JButton partita;
	private JButton torneo;
	private JButton arbitro;
	private JButton campionato;
	private JButton stadio;
	private JButton dirigenza;
	private JButton formazione;
	private JButton infortunio;
	private JPanel pannello;
	private JButton iscrizione;
	private JPanel pannello1;
	private JPanel pannello2;
	private JLabel text1;

	public InserisciFrame(Connection con) {
		text = new JLabel("Clicca il campo che vuoi inserire.");
		text1 = new JLabel("Iscrivi una squadra ad un torneo.  >>>");

		squadra = new JButton("Squadra");
		giocatore = new JButton("Giocatore");
		allenatore = new JButton("Allenatore");
		partita = new JButton("Partita");
		torneo = new JButton("Torneo");
		arbitro = new JButton("Arbitro");
		campionato = new JButton("Campionato");
		stadio = new JButton("Stadio");
		dirigenza = new JButton("Dirigenza");
		formazione = new JButton("Formazione");
		infortunio = new JButton("Infortunio");
		iscrizione = new JButton("Iscrizione al torneo");

		pannello = new JPanel();
		pannello1 = new JPanel(new GridLayout(2, 3));
		pannello2 = new JPanel();

		pannello.add(text);

		pannello1.add(squadra);
		pannello1.add(giocatore);
		pannello1.add(allenatore);
		pannello1.add(partita);
		pannello1.add(torneo);
		pannello1.add(arbitro);
		pannello1.add(campionato);
		pannello1.add(stadio);
		pannello1.add(dirigenza);
		pannello1.add(formazione);
		pannello1.add(infortunio);

		pannello2.add(text1);
		pannello2.add(iscrizione);

		squadra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				JFrame frame = new InserisciSquadra(con);

				frame.setSize(250, 230);
				frame.setTitle("Inserimento");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				frame.setVisible(true);
				frame.setLocation(550, 150);
				frame.setResizable(false);
			}
		});

		giocatore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				JFrame frame = new InserisciGiocatore(con);

				frame.setSize(250, 420);
				frame.setTitle("Inserimento");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				frame.setVisible(true);
				frame.setLocation(550, 150);
				frame.setResizable(false);
			}
		});

		allenatore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				JFrame frame = new InserisciAllenatore(con);

				frame.setSize(250, 320);
				frame.setTitle("Inserimento");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				frame.setVisible(true);
				frame.setLocation(550, 150);
				frame.setResizable(false);
			}
		});

		partita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				JFrame frame = new InserisciPartita(con);

				frame.setSize(288, 410);
				frame.setTitle("Inserimento");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				frame.setVisible(true);
				frame.setLocation(550, 150);
				frame.setResizable(false);
			}
		});

		torneo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				JFrame frame = new InserisciTorneo(con);

				frame.setSize(288, 190);
				frame.setTitle("Inserimento");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				frame.setVisible(true);
				frame.setLocation(550, 150);
				frame.setResizable(false);
			}
		});

		arbitro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				JFrame frame = new InserisciArbitro(con);

				frame.setSize(250, 270);
				frame.setTitle("Inserimento");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				frame.setVisible(true);
				frame.setLocation(550, 150);
				frame.setResizable(false);
			}
		});

		campionato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				JFrame frame = new InserisciCampionato(con);

				frame.setSize(288, 190);
				frame.setTitle("Inserimento");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				frame.setVisible(true);
				frame.setLocation(550, 150);
				frame.setResizable(false);
			}
		});

		stadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				JFrame frame = new InserisciStadio(con);

				frame.setSize(250, 270);
				frame.setTitle("Inserimento");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				frame.setVisible(true);
				frame.setLocation(550, 150);
				frame.setResizable(false);
			}
		});

		dirigenza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				JFrame frame = new InserisciDirigenza(con);

				frame.setSize(250, 320);
				frame.setTitle("Inserimento");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				frame.setVisible(true);
				frame.setLocation(550, 150);
				frame.setResizable(false);
			}
		});

		formazione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				JFrame frame = new InserisciFormazione(con);

				frame.setSize(250, 270);
				frame.setTitle("Inserimento");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				frame.setVisible(true);
				frame.setLocation(550, 150);
				frame.setResizable(false);
			}
		});

		infortunio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				JFrame frame = new InserisciInfortunio(con);

				frame.setSize(250, 320);
				frame.setTitle("Inserimento");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				frame.setVisible(true);
				frame.setLocation(550, 150);
				frame.setResizable(false);
			}
		});

		iscrizione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				JFrame frame = new IscrizioneTorneo(con);

				frame.setSize(290, 190);
				frame.setTitle("Inserimento");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				frame.setVisible(true);
				frame.setLocation(550, 150);
				frame.setResizable(false);
			}
		});

		this.add(pannello, BorderLayout.NORTH);
		this.add(pannello1, BorderLayout.CENTER);
		this.add(pannello2, BorderLayout.PAGE_END);
	}
}
