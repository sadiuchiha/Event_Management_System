import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ChangePasswordFrame extends JFrame {

	static ChangePasswordFrame frame = new ChangePasswordFrame();
	private JPanel contentPane;
	private JPasswordField newPasswordField;
	private JPasswordField confirmPasswordField;
	private JButton confirmButton;
	private JButton backToForgotPasswordFrame;
	private JLabel passwordRequirementLabel;
	private JLabel passwordAndConfirmPasswordDoesntMatchLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePasswordFrame frame = new ChangePasswordFrame();
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
	public ChangePasswordFrame() {							//contents of the whole Frame which includes button, label, textBox and its functions
		setResizable(false);

		ImageIcon icon = new ImageIcon("src/resource/logo-social.png");

		setTitle("Change Password");
		setIconImage(icon.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel newPasswordLabel = new JLabel("New Password");
		newPasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		newPasswordLabel.setBounds(90, 77, 106, 25);
		contentPane.add(newPasswordLabel);

		JLabel confirmPasswordLabel = new JLabel("Confirm Password");
		confirmPasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		confirmPasswordLabel.setBounds(70, 105, 126, 25);
		contentPane.add(confirmPasswordLabel);

		newPasswordField = new JPasswordField();
		newPasswordField.setBounds(206, 83, 153, 19);
		contentPane.add(newPasswordField);

		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setBounds(206, 110, 153, 19);
		contentPane.add(confirmPasswordField);

		confirmButton = new JButton("Confirm");
		confirmButton.setFocusable(false);
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean passwordReqMatches = true;
				boolean passwordEquals = true;

				passwordRequirementLabel.setVisible(false);
				passwordAndConfirmPasswordDoesntMatchLabel.setVisible(false);

				if (e.getSource() == confirmButton) {							//Checks for confirmButton click

					String newPassword = newPasswordField.getText();
					String confirmPassword = confirmPasswordField.getText();

					if (!RegisterFrame.isValidPassword(newPassword)) {			//Checks whether password is valid from RegisterFrame

						passwordRequirementLabel.setVisible(true);
						passwordReqMatches = false;

					}

					if (!newPassword.equals(confirmPassword)) {					//Are they equal?

						passwordAndConfirmPasswordDoesntMatchLabel.setVisible(true);
						passwordEquals = false;
					}

					if (passwordReqMatches && passwordEquals) {
						
						// Update password in database
						
						Database.updatePassword(newPassword);

						// change password in database.
						JOptionPane.showMessageDialog(frame, "The password has been changed successfully.","Confirmation", JOptionPane.INFORMATION_MESSAGE);

						setVisible(false);
						LoginFrame.getFrame().setVisible(true);

						// Password format
					}
				}
			}
		});
		confirmButton.setBounds(230, 191, 85, 30);
		contentPane.add(confirmButton);

		backToForgotPasswordFrame = new JButton("Back");
		backToForgotPasswordFrame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				ForgotPasswordFrame pastFrame = new ForgotPasswordFrame();
				pastFrame.setVisible(true);
			}
		});
		backToForgotPasswordFrame.setBounds(135, 191, 85, 30);
		contentPane.add(backToForgotPasswordFrame);

		passwordRequirementLabel = new JLabel(
				"Password needs to have atleast 8 Character, 2 number and 1 uppercase letter");
		passwordRequirementLabel.setForeground(Color.RED);
		passwordRequirementLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passwordRequirementLabel.setBounds(25, 140, 442, 13);
		passwordRequirementLabel.setVisible(false);
		contentPane.add(passwordRequirementLabel);

		passwordAndConfirmPasswordDoesntMatchLabel = new JLabel("Password and Confirm password does not match.");
		passwordAndConfirmPasswordDoesntMatchLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passwordAndConfirmPasswordDoesntMatchLabel.setForeground(Color.RED);
		passwordAndConfirmPasswordDoesntMatchLabel.setBounds(25, 163, 422, 13);
		passwordAndConfirmPasswordDoesntMatchLabel.setVisible(false);
		contentPane.add(passwordAndConfirmPasswordDoesntMatchLabel);
	}
}
