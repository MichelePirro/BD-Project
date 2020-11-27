package Connection;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Connetti extends JFrame
{
	/**
	 * ciao mi chiamo marco
	 */
	private static final long serialVersionUID = 4055768966623676530L;
	
	private JButton connetti;
	private JLabel connect;
	private JPanel pannello;
	private JLabel img;
	private ImageIcon immagine;
	private Font font;
	
	public Connetti()
	{
		connetti = new JButton("Connetti");
		connect = new JLabel("Connetti al Database.   >>>");
		pannello = new JPanel();
		//immagine = new ImageIcon("C:/Users/mikel/OneDrive/Desktop/Universit�/Secondo Anno/Base Di Dati/ProgettoBD-ExtraCorso/progetto-BD/src/fotobuona.jpg");
		immagine = new ImageIcon(getClass().getResource("/fotobuona.jpg"));

		img = new JLabel(immagine);
		font = new Font("Arial", Font.BOLD,15);
		
		connetti.addActionListener(
										new ActionListener()
										{
											@Override
											public void actionPerformed(ActionEvent ev) 
											{
												Connection con = null ;
												try 
												{
													Class.forName("com.mysql.jdbc.Driver");
													String url = "jdbc:mysql://localhost:3306/Campionato?autoReconnect=true&useSSL=false";

													con = DriverManager.getConnection(url,"root","root");

													JOptionPane.showMessageDialog(null, "Connessione effettuata.");
													
													JFrame frame = new Operazioni((com.mysql.jdbc.Connection) con);
													
													frame.setSize(380,312);
													frame.setTitle("Operazioni");
													frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
													frame.setVisible(true);
													frame.setLocation(600,250);
													frame.setResizable(false);
													
													Connetti.this.setVisible(false);
												}
												catch(Exception e)
												{
													JOptionPane.showMessageDialog(null, "Connessione fallita.");
												}
											}
										}
									);
		
		connect.setFont(font);
		pannello.setBackground(Color.LIGHT_GRAY);
		pannello.add(img);
		pannello.add(connect);
		pannello.add(connetti);
		
		this.add(pannello);
	}
}
