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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MatchCodeFrame extends JFrame {

	static MatchCodeFrame frame = new MatchCodeFrame();
	private JPanel contentPane;
	private JTextField enterCodeTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MatchCodeFrame frame = new MatchCodeFrame();
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
	public MatchCodeFrame() {
		setResizable(false);
		
		ImageIcon icon = new ImageIcon("src/resource/logo-social.png");
		
		setTitle("Setup Code");
		setIconImage(icon.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel enterCodeLabel = new JLabel("Enter Code");
		enterCodeLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		enterCodeLabel.setBounds(93, 107, 76, 13);
		contentPane.add(enterCodeLabel);
		
		enterCodeTextField = new JTextField();
		enterCodeTextField.setBounds(179, 99, 96, 33);
		contentPane.add(enterCodeTextField);
		enterCodeTextField.setColumns(10);
		
		JButton verifyButton = new JButton("Verify");
		verifyButton.setFocusable(false);
		verifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String code = enterCodeTextField.getText();
				
				if(e.getSource() == verifyButton) {
					
					if(matchCode(code)) {
						
						JOptionPane.showMessageDialog(frame, "The code has been matched!");
						
						setVisible(false);
						ChangePasswordFrame nextFrame = new ChangePasswordFrame();
						nextFrame.setVisible(true);
						
						
					} else if(code.isEmpty()) {
						
						JOptionPane.showMessageDialog(frame, "There is no code!","Code not found", JOptionPane.ERROR_MESSAGE);
						
					} else 
						
						JOptionPane.showMessageDialog(frame, "The code you entered is wrong.", "Code Mismatch", JOptionPane.ERROR_MESSAGE);
					
				}
				
			}
		});
		verifyButton.setBounds(225, 153, 96, 21);
		contentPane.add(verifyButton);
		
		JButton backToForgotPasswordButton = new JButton("Back");
		backToForgotPasswordButton.setFocusable(false);
		backToForgotPasswordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == backToForgotPasswordButton) {
					
					setVisible(false);
					ForgotPasswordFrame pastFrame = new ForgotPasswordFrame();
					pastFrame.setVisible(true);
				}
			}
		});
		backToForgotPasswordButton.setBounds(108, 153, 96, 21);
		contentPane.add(backToForgotPasswordButton);
		
		JLabel resendCodeLabel = new JLabel("Resend code?");
		resendCodeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				resendCodeLabel.setForeground(Color.blue);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				resendCodeLabel.setForeground(Color.black);

			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//re-sent code to the email.
				String code = ForgotPasswordFrame.generateCode();	
				ForgotPasswordFrame.setAuthCode(code);
				
				//Send an email of the code to that specific email.
				try {
					MailUtility.sendForgetPasswordMail(ForgotPasswordFrame.getAuthEmail());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		resendCodeLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		resendCodeLabel.setBounds(305, 107, 107, 13);
		contentPane.add(resendCodeLabel);
	}
	
	public static boolean matchCode(String code) {
		
		// pull code which was send to email from server.
		
		//for test
		
		String authCode = ForgotPasswordFrame.getAuthCode();
		
		return code.equals(authCode);
	}

}
