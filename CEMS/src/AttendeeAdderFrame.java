import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AttendeeAdderFrame extends JFrame {

	private JPanel contentPane;
	Event event;
	JTextArea attendeesTextArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AttendeeAdderFrame frame = new AttendeeAdderFrame(null);
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
	public AttendeeAdderFrame(Event event) {

		this.event = event;
		setTitle("Add Attendee");
		ImageIcon logoImage = new ImageIcon("src/resource/weMeetLogo.png");
		setIconImage(logoImage.getImage());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 705, 501);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new LineBorder(new Color(123, 104, 238), 4));
		setContentPane(contentPane);

		JLabel addAttendeeLabel = new JLabel("Add Attendees");
		addAttendeeLabel.setForeground(Color.DARK_GRAY);
		addAttendeeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addAttendeeLabel.setFont(new Font("OCR A Extended", Font.BOLD, 25));

		JLabel attendeeLabel = new JLabel("Attendee");
		attendeeLabel.setFont(new Font("OCR A Extended", Font.BOLD, 15));

		JButton addButton = new JButton("Add Button");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String emailAddressList = attendeesTextArea.getText();
				ArrayList<String> emailList = getEmailList(emailAddressList);

				if(emailList.size() > 0) {
					
					for(String email: emailList) {
						
						Database.addAttendeeToEvent(email, event.getEventID(), event.getEventName());
						
					}
					
					AdminHomeMenu.loadEventAttendees(event.getEventID(), event.getEventName());
					dispose();
				}
			}

			private ArrayList<String> getEmailList(String emailAddressList) {
				// TODO Auto-generated method stub

				ArrayList<String> emailList = new ArrayList<String>();
				CharSequence comma = ",";
				CharSequence space = " ";

				if (emailAddressList.contains(comma))
					JOptionPane.showMessageDialog(null, "Wrong Format: Email cannot be seperated by comma!", "Error",
							JOptionPane.ERROR_MESSAGE);
				else if (emailAddressList.contains(space))
					JOptionPane.showMessageDialog(null, "Wrong Format: Email cannot be seperated by space!", "Error",
							JOptionPane.ERROR_MESSAGE);
				else if (emailAddressList.equals(""))
					JOptionPane.showMessageDialog(null, "The field is empty!", "Error",
							JOptionPane.ERROR_MESSAGE);
				else {
					int startIndex = 0;
					int endIndex = 0;

					for (int i = 0; i < emailAddressList.length(); i++) {

						if (emailAddressList.charAt(i) == '\n') {

							endIndex = i;

							emailList.add(emailAddressList.substring(startIndex, endIndex));
							startIndex = i;

						}

						if (i == emailAddressList.length() - 1) {

							endIndex = i + 1;
							emailList.add(emailAddressList.substring(startIndex, endIndex));
						}

					}
				}
				return emailList;
			}
		});
		addButton.setFont(new Font("OCR A Extended", Font.BOLD, 15));

		JScrollPane attendeeScrollPane = new JScrollPane();

		JLabel lblNewLabel = new JLabel("Email format:");

		JLabel lblNewLabel_1 = new JLabel("example1@email.com");

		JLabel lblNewLabel_1_1 = new JLabel("example2@email.com");

		JLabel lblNewLabel_1_2 = new JLabel("example3@email.com");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(addButton))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(67)
								.addComponent(attendeeLabel, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(attendeeScrollPane, GroupLayout.DEFAULT_SIZE, 369,
												Short.MAX_VALUE)
										.addComponent(addAttendeeLabel, GroupLayout.DEFAULT_SIZE, 369,
												Short.MAX_VALUE))))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 112,
										Short.MAX_VALUE)))
				.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup().addGap(29).addComponent(addAttendeeLabel)
						.addPreferredGap(ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(attendeeScrollPane, GroupLayout.PREFERRED_SIZE, 143,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel).addGap(10)
										.addComponent(lblNewLabel_1).addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblNewLabel_1_1).addGap(4).addComponent(lblNewLabel_1_2)))
						.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(163).addComponent(attendeeLabel)))
				.addPreferredGap(ComponentPlacement.RELATED, 28, GroupLayout.PREFERRED_SIZE).addComponent(addButton)
				.addGap(120)));

		attendeesTextArea = new JTextArea();
		attendeeScrollPane.setViewportView(attendeesTextArea);
		contentPane.setLayout(gl_contentPane);
	}
}
