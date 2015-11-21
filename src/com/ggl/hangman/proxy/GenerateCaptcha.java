package com.ggl.hangman.proxy;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.UUID;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.ggl.hangman.command.BookClickedCommand;
import com.ggl.hangman.command.ICategoryCommand;
import com.ggl.hangman.command.IMenuInvoker;
import com.ggl.hangman.command.IMenuReceiver;
import com.ggl.hangman.command.MenuCategoryInvoker;
import com.ggl.hangman.command.MovieClickedCommand;
import com.ggl.hangman.common.Hangman;
import com.ggl.hangman.common.Menu;
import com.ggl.hangman.observer.OptionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;

public class GenerateCaptcha extends JFrame implements ICaptchaGen, ActionListener{
	
	private JPanel contentPane;
	public JLabel gamename = new JLabel("HANGMAN..");
	public JLabel tagline = new JLabel("Save the World!");
	private OptionListener listen;
	public StringBuffer captchaStringBuffer = new StringBuffer();
	public StringBuilder captchaString = new StringBuilder(7);
	public String captcha = "Generate Captcha";
	JTextField captchaText = new JTextField(10);
	//JButton captchaButton=new JButton(captcha);
	JTextField inputCaptcha = new JTextField(10);
	JButton authenticateButton=new JButton("I am a human!");
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZaeioupvnhgdsbxztrk";
	static Random rnd = new Random();
	private final JLabel lblNewLabel = new JLabel("New label");
	private final JLabel lblNewLabel_1 = new JLabel("New label");
	

	@Override
	public String generate() {
		// TODO Auto-generated method stub
		
		for( int i = 0; i < 7; i++ ) 
		      captchaString.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		return captchaString.toString();
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerateCaptcha frame = new GenerateCaptcha();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public GenerateCaptcha() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 365);
		setTitle("Hangman");
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Font font = new Font("SansSerif", Font.BOLD, 15);
		Font font2=new Font("SansSerif",Font.BOLD,12);
		gamename.setForeground(Color.WHITE);
		gamename.setFont(new Font("SansSerif", Font.BOLD, 25));
		gamename.setBounds(157, 7, 230, 33);
		tagline.setForeground(Color.WHITE);
		tagline.setFont(new Font("SansSerif", Font.BOLD, 24));
		tagline.setBounds(313, 37, 201, 25);
		captchaText.setBackground(Color.ORANGE);
		
		contentPane.add(captchaText);
		
		getContentPane().add(gamename);
		getContentPane().add(tagline);
		
		captchaText.setText(generate());
		inputCaptcha.setBackground(Color.ORANGE);
		contentPane.add(inputCaptcha);
		authenticateButton.setBackground(Color.ORANGE);
		contentPane.add(authenticateButton);
		captchaText.setBounds(220,80,70,25);
		authenticateButton.setBounds(188, 161, 140, 25);
		inputCaptcha.setBounds(220,116,70,25);
		String dir1 = null;
		dir1=System.getProperty("user.dir");
		lblNewLabel.setIcon(new ImageIcon(dir1+"\\src\\Images\\Alien1.PNG"));
		lblNewLabel.setBounds(-29, 7, 191, 191);
		
		contentPane.add(lblNewLabel);
		lblNewLabel_1.setIcon(new ImageIcon(dir1+"\\src\\Images\\Alien2Stars.PNG"));
		lblNewLabel_1.setBounds(10, 0, 514, 416);
		
		contentPane.add(lblNewLabel_1);
		
		authenticateButton.addActionListener(this);
		

	}
	
	public void actionPerformed(ActionEvent e)
	
	{
		
			authenticate();
	
	}
	

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void authenticate() {
		// TODO Auto-generated method stub
		
		
		String str=inputCaptcha.getText();
		if(str.compareTo(captchaText.getText())==0)
		{
			Menu m = new Menu();
			m.setVisible(true);
		}
		}
	}
