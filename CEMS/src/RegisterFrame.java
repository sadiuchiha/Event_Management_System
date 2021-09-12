import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class RegisterFrame extends JFrame {

	static RegisterFrame frame = new RegisterFrame();
	private JPanel contentPane;
	private JTextField usernameTextField;
	private JTextField emailTextField;
	private JPasswordField passwordTextField;
	private JPasswordField confirmPasswordTextField;
	private JTextField lastNameTextField;
	private JTextField firstNameTextField;
	private JLabel usenameAlreadyInUseLabel;
	private JLabel emailAlreadyInUseLabel;
	private JLabel usernameNotValidLabel;
	private JLabel emailIsNotValidLabel;
	private JLabel passwordDoesNotMeetReqLabel;
	private JLabel passwordAndConfirmPasswordDoesNotMatchLabel;
	private JLabel firstNameValidLabel;
	private JLabel lastNameValidLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFrame frame = new RegisterFrame();
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
	public RegisterFrame() {								//contents of the whole Frame which includes button, label, textBox and its functions
		setResizable(false);

		ImageIcon logoImage = new ImageIcon("src/resource/weMeetLogo.png");
		setIconImage(logoImage.getImage());
		setTitle("Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 538);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel redPanel = new JPanel();
		redPanel.setBackground(Color.RED);
		redPanel.setBounds(0, 0, 150, 501);
		contentPane.add(redPanel);

		JPanel bluePanel = new JPanel();
		bluePanel.setBackground(Color.BLUE);
		bluePanel.setBounds(636, 0, 150, 501);
		contentPane.add(bluePanel);

		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(new LineBorder(Color.ORANGE, 4));
		mainPanel.setBackground(Color.GRAY);
		mainPanel.setBounds(151, 0, 484, 501);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);

		JLabel registerLabel = new JLabel("Register here");
		registerLabel.setFont(new Font("MV Boli", Font.BOLD, 20));
		registerLabel.setBounds(171, 55, 153, 33);
		mainPanel.add(registerLabel);

		JLabel usenameLabel = new JLabel("Username");
		usenameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		usenameLabel.setBounds(77, 191, 70, 13);
		mainPanel.add(usenameLabel);

		usernameTextField = new JTextField();
		usernameTextField.setBounds(157, 190, 127, 19);
		mainPanel.add(usernameTextField);
		usernameTextField.setColumns(10);

		JLabel emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		emailLabel.setBounds(111, 227, 36, 13);
		mainPanel.add(emailLabel);

		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		emailTextField.setBounds(157, 226, 127, 19);
		mainPanel.add(emailTextField);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordLabel.setBounds(86, 262, 67, 13);
		mainPanel.add(passwordLabel);

		passwordTextField = new JPasswordField();
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(157, 261, 127, 19);
		mainPanel.add(passwordTextField);

		JLabel confirmPasswordLabel = new JLabel("Confirm Password");
		confirmPasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		confirmPasswordLabel.setBounds(31, 298, 119, 13);
		mainPanel.add(confirmPasswordLabel);

		confirmPasswordTextField = new JPasswordField();
		confirmPasswordTextField.setColumns(10);
		confirmPasswordTextField.setBounds(157, 297, 127, 19);
		mainPanel.add(confirmPasswordTextField);

		JButton registerButton = new JButton("Register");
		registerButton.setFocusable(false);
		registerButton.setBounds(231, 368, 85, 21);
		registerButton.setFocusable(false);
		mainPanel.add(registerButton);

		ActionListener registerButtonAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String firstName = firstNameTextField.getText();
				String lastName = lastNameTextField.getText();
				String username = usernameTextField.getText();
				String email = emailTextField.getText();
				String password = passwordTextField.getText();
				String confirmPassword = confirmPasswordTextField.getText();

				if (e.getSource() == registerButton) {

					firstNameValidLabel.setVisible(false);
					lastNameValidLabel.setVisible(false);
					usernameNotValidLabel.setVisible(false);
					usenameAlreadyInUseLabel.setVisible(false);
					emailIsNotValidLabel.setVisible(false);
					emailAlreadyInUseLabel.setVisible(false);
					passwordDoesNotMeetReqLabel.setVisible(false);
					passwordAndConfirmPasswordDoesNotMatchLabel.setVisible(false);

					boolean successfullyMeetReq = false;
					boolean usernameInUse = false;
					boolean usernameIsValid = false;
					boolean emailInUse = false;
					boolean emailIsValid = false;
					boolean passwordMatchReq = true;
					boolean passwordAndConfirmPasswordMatch = true;
					boolean isFirstNameValid = false;
					boolean isLastNameValid = false;

					if (isNameValid(firstName)) {

						isFirstNameValid = true;

					} else {

						firstNameValidLabel.setVisible(true);

					}

					if (isNameValid(lastName)) {

						isLastNameValid = true;

					} else {

						lastNameValidLabel.setVisible(true);

					}

					if (isValidUsername(username)) {

						usernameIsValid = true;

					} else {

						usernameNotValidLabel.setVisible(true);
					}

					if (Database.usernameInUse(username) && usernameIsValid) {

						// is username already in use?
						
						System.out.println("The username is already in use.");
						usenameAlreadyInUseLabel.setVisible(true);
						usernameInUse = true;

					}

					//verifies whether the email is valid or not.
					if (verifyEmailAddress(email)) {

						emailIsValid = true;

					} else {

						emailIsNotValidLabel.setVisible(true);
					}

					if (Database.emailInUse(email) && emailIsValid) {

						// is email already in use

						System.out.println("The email is already in use.");
						emailAlreadyInUseLabel.setVisible(true);
						emailInUse = true;

					}

					if (!isValidPassword(password)) {

						// does password match the requirement. need 1 uppercase 2 number and atleast 8
						// character long.

						System.out.println("The password is not valid.");
						passwordDoesNotMeetReqLabel.setVisible(true);
						passwordMatchReq = false;

					}

					if (!password.equals(confirmPassword)) {

						// does password match with confirm password

						System.out.println("The password is not equal to confirm password.");
						passwordAndConfirmPasswordDoesNotMatchLabel.setVisible(true);
						passwordAndConfirmPasswordMatch = false;

					}

					if (isFirstNameValid && isLastNameValid && !usernameInUse && usernameIsValid && !emailInUse
							&& emailIsValid && passwordMatchReq && passwordAndConfirmPasswordMatch)
						successfullyMeetReq = true;

					// after all the above requirement meet.
					// upload details to database
					// registration complete

					// System.out.println(Database.registerNewUser(username, email, firstName,
					// lastName));

					if (successfullyMeetReq) {

						Database.registerNewUser(username, email, firstName, lastName, password);

						JOptionPane.showMessageDialog(frame, "Registration is complete!","Registration Message", JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
						LoginFrame.getFrame().setVisible(true);
					}

				}

			}

		};

		registerButton.addActionListener(registerButtonAction);

		JButton backToLoginButton = new JButton("Back");
		backToLoginButton.setFocusable(false);
		backToLoginButton.setBounds(136, 368, 85, 21);
		backToLoginButton.setFocusable(false);

		ActionListener backToLogInButtonAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (e.getSource() == backToLoginButton) {

					setVisible(false);

					LoginFrame.getFrame().setVisible(true);
				}

			}

		};
		backToLoginButton.addActionListener(backToLogInButtonAction);
		mainPanel.add(backToLoginButton);

		lastNameTextField = new JTextField();
		lastNameTextField.setColumns(10);
		lastNameTextField.setBounds(158, 158, 127, 19);
		mainPanel.add(lastNameTextField);

		JLabel lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lastNameLabel.setBounds(77, 159, 76, 13);
		mainPanel.add(lastNameLabel);

		firstNameTextField = new JTextField();
		firstNameTextField.setColumns(10);
		firstNameTextField.setBounds(158, 126, 127, 19);
		mainPanel.add(firstNameTextField);

		JLabel firstNameLabel = new JLabel("First Name");
		firstNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		firstNameLabel.setBounds(79, 127, 76, 13);
		mainPanel.add(firstNameLabel);

		usenameAlreadyInUseLabel = new JLabel("Username already in use");
		usenameAlreadyInUseLabel.setForeground(Color.RED);
		usenameAlreadyInUseLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		usenameAlreadyInUseLabel.setBounds(294, 193, 140, 13);
		usenameAlreadyInUseLabel.setVisible(false);
		mainPanel.add(usenameAlreadyInUseLabel);

		emailAlreadyInUseLabel = new JLabel("Email already in use");
		emailAlreadyInUseLabel.setForeground(Color.RED);
		emailAlreadyInUseLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		emailAlreadyInUseLabel.setBounds(294, 228, 111, 13);
		emailAlreadyInUseLabel.setVisible(false);
		mainPanel.add(emailAlreadyInUseLabel);

		passwordDoesNotMeetReqLabel = new JLabel("Password needs to have atleast 8 Character, 2 number and 1 uppercase letter");
		passwordDoesNotMeetReqLabel.setForeground(Color.RED);
		passwordDoesNotMeetReqLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passwordDoesNotMeetReqLabel.setBounds(41, 324, 443, 13);
		passwordDoesNotMeetReqLabel.setVisible(false);
		mainPanel.add(passwordDoesNotMeetReqLabel);

		passwordAndConfirmPasswordDoesNotMatchLabel = new JLabel("Password and Confirm password does not match. ");
		passwordAndConfirmPasswordDoesNotMatchLabel.setForeground(Color.RED);
		passwordAndConfirmPasswordDoesNotMatchLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passwordAndConfirmPasswordDoesNotMatchLabel.setBounds(40, 347, 381, 13);
		passwordAndConfirmPasswordDoesNotMatchLabel.setVisible(false);
		mainPanel.add(passwordAndConfirmPasswordDoesNotMatchLabel);

		emailIsNotValidLabel = new JLabel("Email is not valid");
		emailIsNotValidLabel.setForeground(Color.RED);
		emailIsNotValidLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		emailIsNotValidLabel.setBounds(294, 229, 163, 13);
		emailIsNotValidLabel.setVisible(false);
		mainPanel.add(emailIsNotValidLabel);

		usernameNotValidLabel = new JLabel("More then 6 character required");
		usernameNotValidLabel.setForeground(Color.RED);
		usernameNotValidLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		usernameNotValidLabel.setBounds(294, 193, 180, 13);
		usernameNotValidLabel.setVisible(false);
		mainPanel.add(usernameNotValidLabel);

		firstNameValidLabel = new JLabel("Enter a valid name");
		firstNameValidLabel.setForeground(Color.RED);
		firstNameValidLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		firstNameValidLabel.setBounds(295, 129, 110, 13);
		firstNameValidLabel.setVisible(false);
		mainPanel.add(firstNameValidLabel);

		lastNameValidLabel = new JLabel("Enter a valid name");
		lastNameValidLabel.setForeground(Color.RED);
		lastNameValidLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lastNameValidLabel.setBounds(295, 161, 110, 13);
		lastNameValidLabel.setVisible(false);
		mainPanel.add(lastNameValidLabel);
	}

	public static boolean isValidUsername(String username) {

		return username.length() >= 6;
	}

	public static boolean verifyEmailAddress(String email) {
		boolean result = true;
		try {
			InternetAddress emailAddr = new InternetAddress(email);
			emailAddr.validate();
		} catch (AddressException ex) {
			result = false;
		}
		return result;
	}

	public static boolean isValidPassword(String password) {

		if (password.length() < 8)
			return false;

		int charCount = 0;
		int numCount = 0;
		int uppercaseCount = 0;
		for (int i = 0; i < password.length(); i++) {

			char ch = password.charAt(i);

			if (isNumeric(ch))
				numCount++;
			else if (isLetter(ch))
				charCount++;
			else if (hasUppercase(ch))
				uppercaseCount++;
			else {}
				
		}

		return (charCount >= 2 && numCount >= 2 && uppercaseCount >= 1);
	}

	public static boolean isNameValid(String name) {

		int charCount = 0;
		int uppercaseCount = 0;

		if (name.length() == 0)
			return false;

		for (int i = 0; i < name.length(); i++) {

			char ch = name.charAt(i);

			if (isLetter(ch))
				charCount++;
			else if (hasUppercase(ch))
				uppercaseCount++;
			else
				return false;
		}

		return (charCount > 1 || uppercaseCount > 1);
	}

	public static boolean isLetter(char ch) {

		return (ch >= 'a' && ch <= 'z');
	}

	public static boolean hasUppercase(char ch) {

		return (ch >= 'A' && ch <= 'Z');
	}

	public static boolean isNumeric(char ch) {

		return (ch >= '0' && ch <= '9');
	}
}
