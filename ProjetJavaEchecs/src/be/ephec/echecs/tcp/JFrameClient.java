package be.ephec.echecs.tcp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.ephec.echecs.gui.ApplicationClient;

public class JFrameClient extends JFrame {

	private JPanel contentPane;
	private ApplicationClient applicationClient;
	
	
	/*
	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameClient frame = new JFrameClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	/**
	 * Create the frame.
	 */
	public JFrameClient(ApplicationClient applicationClient) {
		this.applicationClient = applicationClient; 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setVisible(true);
		this.setTitle("Client");
		contentPane = new JPanelAccueilClient(applicationClient);
		setContentPane(contentPane);
	}

	
		
	}


