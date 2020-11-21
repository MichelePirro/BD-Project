package Connection;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mysql.jdbc.Connection;

import Cancellazione.RemoveFrame;
import Inserimento.InserisciFrame;
import Modifica.ModificaFrame;
import Query.QueryFrame;
import Query.QueryProva;

public class Operazioni extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8920671283714245179L;
	
	private JButton query;
	private JButton inserisci;
	private JButton modifica;
	private JButton cancella;
	private JButton prova;
	private JPanel pannello;
	private ImageIcon img;
	private JLabel immag;
	
	public Operazioni(Connection con)
	{
	
		
		query = new JButton("Query");
		inserisci = new JButton("Inserisci");
		modifica = new JButton("Modifica");
		cancella = new JButton("Cancella");
		prova = new JButton("Prova");
		pannello = new JPanel();
		immag = new JLabel(img);
		
		pannello.add(query);
		pannello.add(inserisci);
		pannello.add(modifica);
		pannello.add(cancella);
		pannello.add(immag);
		pannello.add(prova);
		
		query.addActionListener(
									new ActionListener()
									{
										public void actionPerformed(ActionEvent ev) 
										{
											
											JFrame frame = new QueryFrame(con);
											
											frame.setSize(400,570);
											frame.setTitle("Query");
											frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
											
											frame.setVisible(true);
											frame.setLocation(550,150);
											frame.setResizable(false);
										}
									}
								);
		
		
		inserisci.addActionListener(
									new ActionListener()
									{
											public void actionPerformed(ActionEvent ev) 
											{
						
												JFrame frame = new InserisciFrame(con);
						
												frame.setSize(410,270);
												frame.setTitle("Inserimento");
												frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						
												frame.setVisible(true);
												frame.setLocation(600,250);
												frame.setResizable(false);
											}
										}
									);
		
		modifica.addActionListener(
										new ActionListener()
										{
											public void actionPerformed(ActionEvent ev) 
											{
	
												JFrame frame = new ModificaFrame(con);
	
												frame.setSize(320,280);
												frame.setTitle("Modifica");
												frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
												frame.setVisible(true);
												frame.setLocation(600,250);
												
												frame.setResizable(false);
											}
										}
									);
		
		cancella.addActionListener(
										new ActionListener()
										{
											public void actionPerformed(ActionEvent ev) 
											{

												JFrame frame = new RemoveFrame(con);

												frame.setSize(310,210);
												frame.setTitle("Cancella");
												frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

												frame.setVisible(true);
												frame.setLocation(600,250);
						
												frame.setResizable(false);
											}
										}
									);
		
		
		prova.addActionListener(
									new ActionListener()
									{
										public void actionPerformed(ActionEvent ev) 
										{
						
											JFrame frame = new QueryProva(con);
						
											frame.setSize(400,570);
											frame.setTitle("Query di prova");
											frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						
											frame.setVisible(true);
											frame.setLocation(550,150);
											frame.setResizable(false);
										}
									}
								);
		
		pannello.setBackground(Color.LIGHT_GRAY);
		this.add(pannello, BorderLayout.CENTER);
	}

}
