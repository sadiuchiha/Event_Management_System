
/* Contributers
 * 
 * Sukhpreet Kaur
 * Hardeep Singh
 * Hardeep Tattla
 * MD Masudur Rahman
 * 
 * (Last Update : 08/04/2021)
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginFrame implements ActionListener {
	
	static JFrame logInFrame;
	static JLabel successLabel;
	static JLabel headLabel;
	static JLabel userLabel;
	static JLabel passwordLabel;
	static JTextField userText;
	static JPasswordField passwordText;
	static JButton loginButton;
	static JButton createAccountButton;
	static JPanel mainPanel;
	static JPanel redPanel;
	static JPanel bluePanel;


	
	public static void main(String[] args) {
	
		JFrame thisFrame = getFrame();
		thisFrame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// action list -> login, register.
		
		String email = userText.getText();						//stores Text from Textfield
		String password = passwordText.getText();
		//System.out.println(user + " " + password);
		
		if(e.getSource() == createAccountButton) {
			
			logInFrame.setVisible(false);
			//LogInFrame.dispose();
			RegisterFrame regFrame = new RegisterFrame();
			
			regFrame.setVisible(true);
			
			
		} else if(e.getSource() == loginButton) {
			
			if(credentialMatch(email,password)) {

			
				if(Database.isAdmin(email)) {
					AdminHomeMenu adminHomeMenu = new AdminHomeMenu();
					MemberInfo currentUser = Database.getMemberInfo(email);
					adminHomeMenu.setUser(currentUser);
					adminHomeMenu.setVisible(true);
					logInFrame.setVisible(false);
					
				} else {
					
					MemberInfo currentUser = Database.getMemberInfo(email);
					UserHomeMenu userHomeMenu = new UserHomeMenu(currentUser);	
					userHomeMenu.setUser(currentUser);
					userHomeMenu.setVisible(true);
					logInFrame.setVisible(false);
					
				}
				
			} else {
			
				JOptionPane.showMessageDialog(logInFrame, "The username or password didn't match. Try again with different username/password.");
				
			}	
		}
		
	}
	
	public boolean credentialMatch(String email, String password) {		// matches user and password with server if found return true 
		//check server for credential match
				
		return Database.emailPassMatched(email, password);
	}
	
	public static JFrame getFrame() {		// Gets whole frame of the loginFrame and returns it.
		
		Database.createDatabase();
		Database.createMembersTable();
		
		mainPanel = new JPanel();
		mainPanel.setBounds(140, 0, 500, 500);
		ImageIcon image1 = new ImageIcon("src/resource/logo-social.png");
		ImageIcon image2 = new ImageIcon("src/resource/nintendo.jpg");
		
		Border border = BorderFactory.createLineBorder(Color.ORANGE,5);
		
		logInFrame = new JFrame();
		
		//ImageIcon image1 = new ImageIcon(logInFrame.getClass().getClassLoader().getResource("resource/logo-social.png"));
		//ImageIcon image2 = new ImageIcon(logInFrame.getClass().getClassLoader().getResource("resource/nintendo.jpg"));

		logInFrame.setSize(800,538);
		logInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		logInFrame.setResizable(false);
		logInFrame.setTitle("Login Here");
		logInFrame.setIconImage(image1.getImage());
		logInFrame.getContentPane().setLayout(null);
		//frame.getContentPane().setBackground(new Color(0,0,0));
		
		mainPanel.setLayout(null);
		
		
		headLabel = new JLabel("Welcome! Sign in here");
		headLabel.setIcon(image2);
		headLabel.setHorizontalTextPosition(JLabel.CENTER); //text position horizontally
		headLabel.setVerticalTextPosition(JLabel.BOTTOM);	//text position vertically
		headLabel.setBounds(78,10,350,350);
		headLabel.setForeground(Color.DARK_GRAY); //text color
		headLabel.setFont(new Font("MV Boli", Font.BOLD, 30)); // font, type, text height
		//headLabel.setOpaque(true);
		//headLabel.setVerticalAlignment(JLabel.CENTER);		//This will keep the object in position even when window size change
		//headLabel.setHorizontalAlignment(JLabel.CENTER);
		headLabel.setIconTextGap(10);
		mainPanel.add(headLabel);
		mainPanel.setBorder(border);
		
		userLabel = new JLabel("Email");
		userLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		userLabel.setBounds(137,370,53,25);		//x(left to right), y(top to bottom), width, height.
		mainPanel.add(userLabel);
		
		userText = new JTextField(20);
		userText.setBounds(180,370,165,25);
		mainPanel.add(userText);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordLabel.setBounds(110,400,80,25);
		mainPanel.add(passwordLabel);
			
		passwordText = new JPasswordField(20);
		passwordText.setBounds(180,400,165,25);
		mainPanel.add(passwordText);
		
		loginButton = new JButton("Log In");
		loginButton.setBounds(146,430, 114,20);
		loginButton.setFocusable(false);
		loginButton.addActionListener( new LoginFrame());
		mainPanel.add(loginButton);
		
		createAccountButton = new JButton("Create Account");
		createAccountButton.setBounds(265, 430, 126, 20);
		createAccountButton.setFocusable(false);
		createAccountButton.addActionListener( new LoginFrame());
		mainPanel.add(createAccountButton);
		
		successLabel = new JLabel("");
		successLabel.setBounds(180,50,80,25);
		mainPanel.add(successLabel);

		mainPanel.setBackground(Color.gray);
		redPanel = new JPanel();
		redPanel.setBounds(0, 0, 140, 500);
		redPanel.setBackground(Color.RED);
		bluePanel = new JPanel();
		bluePanel.setBounds(640, 0, 150, 500);
		bluePanel.setBackground(Color.BLUE);
		
		logInFrame.getContentPane().add(mainPanel);
		
		JLabel forgotPasswordLabel = new JLabel("Forgot password?");
		
		forgotPasswordLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				forgotPasswordLabel.setForeground(Color.BLUE);	//forgot password color changes when cursor enters
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				forgotPasswordLabel.setForeground(Color.BLACK);  //forgot password color reverts when cursor exits
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				ForgotPasswordFrame forgotPasswordFrame = new ForgotPasswordFrame();
				forgotPasswordFrame.setVisible(true);			//ForgetPasswordframe pops up on mouse click
				logInFrame.setVisible(false);					//LogInFrame goes away
				
			}
		});
		
		
		forgotPasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		forgotPasswordLabel.setBounds(192, 448, 132, 28);
		mainPanel.add(forgotPasswordLabel);
		logInFrame.getContentPane().add(redPanel);
		logInFrame.getContentPane().add(bluePanel);

		logInFrame.setVisible(true);

		return logInFrame;
	}
}
