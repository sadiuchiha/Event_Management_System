import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ForgotPasswordFrame extends JFrame {

	static ForgotPasswordFrame frame = new ForgotPasswordFrame();
	private JPanel contentPane;
	private JTextField emailTextField;
	private static String authCode;
	private static String authEmail;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPasswordFrame frame = new ForgotPasswordFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ForgotPasswordFrame() {
		setResizable(false);
		
		ImageIcon icon = new ImageIcon("src/resourse/logo-social.png");
		
		setTitle("Forgot password");
		setIconImage(icon.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel enterYourEmailLabel = new JLabel("Enter you email to send code");
		enterYourEmailLabel.setFont(new Font("MV Boli", Font.BOLD, 20));
		enterYourEmailLabel.setBounds(78, 51, 307, 25);
		contentPane.add(enterYourEmailLabel);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		emailLabel.setBounds(91, 136, 45, 25);
		contentPane.add(emailLabel);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(146, 136, 213, 25);
		contentPane.add(emailTextField);
		emailTextField.setColumns(10);
		
		JButton sendCodeButton = new JButton("Send Code");
		sendCodeButton.setFocusable(false);
		sendCodeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String email = emailTextField.getText();
				
				if(e.getSource() == sendCodeButton) {
					
					if(emailExist(email)) {
						
						//create an email code, save it
						String code = generateCode();	
						setAuthCode(code);
						setAuthEmail(email);
						
						//Send an email of the code to that specific email.
						try {
							MailUtility.sendForgetPasswordMail(email);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(frame, "The code has been send to the email.");
						
						//remove ForgotPasswordFrame
						setVisible(false);
						
						//Shift to matchCodeFrame
						MatchCodeFrame frame = new MatchCodeFrame();
						frame.setVisible(true);
						
						
					} else
						
						JOptionPane.showMessageDialog(frame, "This email does not exist or is not registered.", "Email not found", JOptionPane.ERROR_MESSAGE);
					
				}
				
			}
		});
		sendCodeButton.setBounds(251, 190, 108, 31);
		sendCodeButton.setFocusable(false);
		contentPane.add(sendCodeButton);
		
		JButton backToLoginButton = new JButton("Back");
		backToLoginButton.setFocusable(false);
		backToLoginButton.setBounds(132, 190, 108, 31);
		contentPane.add(backToLoginButton);
		
		ActionListener backToLogInButtonAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(e.getSource() == backToLoginButton) {
					
					setVisible(false);
					
					LoginFrame.getFrame().setVisible(true);
				}
				
			}
			
		};
		backToLoginButton.addActionListener(backToLogInButtonAction);
	}
	
	public static boolean emailExist(String email) {
			
		//email list pull required from server.
		
		return Database.emailInUse(email);
	}
	
	public static String generateCode() {
		
		String code = "" + (int)(Math.random() * 9999 + 1);
		
		if(code.length() == 1) code = "000" + code;
		if(code.length() == 2) code = "00" + code;
		if(code.length() == 3) code = "0" + code;
		
		return code;
	}
	
	public static String getAuthCode() {
		return authCode;
	}

	public static void setAuthCode(String authCode) {
		ForgotPasswordFrame.authCode = authCode;
	}

	public static String getAuthEmail() {
		
		return ForgotPasswordFrame.authEmail;
	}
	
	public static void setAuthEmail(String email) {
		
		ForgotPasswordFrame.authEmail = email;
	}

	
	
}
