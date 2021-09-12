import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class UserHomeMenu extends JFrame {

	AdminHomeMenu adminFrameCopy = new AdminHomeMenu();
	static JTable eventTable2;
	private JLabel homeLabel;
	private JLabel clubLabel;
	private JLabel memberLabel;
	private JLabel profileLabel;
	private JLabel logoutLabel;
	private JPanel clubPanel;
	private JPanel profilePanel;
	private JPanel homeSidePanel;
	private JLabel welcomeLabel;
	private JLabel UserLabel;
	static JLabel allRequestsLabel;
	static JLabel createEventLabel;
	static JLabel updateEventLabel;
	static JLabel removeEventLabel;
	private JPanel clubSidePanel;
	private JPanel memberSidePanel;
	private JPanel profileSidePanel;
	private JScrollPane profilePage;
	private JLabel Username;
	private JLabel firstNameLabel;
	private JLabel lastnameLabel;
	private JLabel emailLabel;
	private JTextField usernameTextField;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField emailTextField;
	private JLabel infoLabel;
	private JLabel updatePasswordLabel;
	private JLabel haveAdminLabel;
	private JLabel profileHeading;
	private JLabel memberHeading;
	private JPanel updatePasswordPanel;
	private JLabel newPasswordLabel;
	private JLabel confirmPasswordLabel;
	private JPasswordField confirmPasswordTextField;
	private JPasswordField newPasswordTextField;
	private JPanel makeAdminPanel;
	private MemberInfo user;
	private JScrollPane allEventScrollPane;
	private JTable allEventTable;
	static JLabel allEventsLabel;
	static JPanel allEventPanel;
	private JLabel clubListLabel;
	private JLabel clubMembersLabel;
	private JLabel leaveClubLabel;
	private JScrollPane clubScrollPane;
	private JTable allClubTable;
	private JButton joinClubButton;
	private JPanel clubMembersPanel;
	private JTable clubMemberTable;
	private JTextField passCodeTextField;
	private JPanel attendeesPanel;
	private static JTable attendeeEmailStatusTable;
	private JTable eventDisplayTable;
	private static JButton addAttendeeButton;
	private JLabel clubEventsLabel;
	private JPanel clubEventPanel;
	private JScrollPane clubEventScrollPane;
	private JTable clubEventTable;
	private JButton makeReportButton;
	private JPanel descriptionPanel;
	private JLabel descriptionLabel;
	private JScrollPane descriptionScrollPane;
	private static JTextArea descriptionTextArea;
	private JPanel clubDescriptionPanel;
	private JLabel clubDescriptionLabel;
	private JScrollPane clubDescriptionScrollPane;
	private static JTextArea clubDescriptionTextArea;
	static JPanel allEventRequestPanel;
	private JScrollPane eventRequestScrollPane;
	static JTable eventTable;
	private JPanel allRequestDescriptionPanel;
	private JLabel clubDescriptionLabel_1;
	private JScrollPane eventRequestDescriptionScrollPane;
	private static JTextArea eventRequestDescriptionTextArea;
	private JPanel allEventDescriptionPanel;
	private JLabel eventDescriptionLabel;
	private JScrollPane allEventDescriptionScrollPane;
	private static JTextArea eventDescriptionTextArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserHomeMenu frame = new UserHomeMenu(null);
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
	public UserHomeMenu(MemberInfo user) {
		this.user = user;
		
		ImageIcon logoImage = new ImageIcon("src/resource/weMeetLogo.png");
		setIconImage(logoImage.getImage());
		getContentPane().setBackground(SystemColor.activeCaption);
		setTitle("WeMeet");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1307, 762);

		JPanel menuPanel = new JPanel();
		menuPanel.setBorder(new LineBorder(new Color(0, 0, 128), 3));
		menuPanel.setBackground(SystemColor.activeCaption);

		JPanel LeftSideHomePanel = new JPanel();
		LeftSideHomePanel.setBackground(Color.LIGHT_GRAY);

		JPanel middlePanel = new JPanel();

		JPanel titlePanel = new JPanel();
		titlePanel.setBorder(new LineBorder(new Color(32, 178, 170), 7));
		titlePanel.setBackground(new Color(102, 205, 170));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(LeftSideHomePanel, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(titlePanel, GroupLayout.DEFAULT_SIZE, 1059, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(590)
							.addComponent(menuPanel, GroupLayout.PREFERRED_SIZE, 466, GroupLayout.PREFERRED_SIZE)
							)
						.addComponent(middlePanel, GroupLayout.PREFERRED_SIZE, 1059, Short.MAX_VALUE)))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addComponent(menuPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
					.addComponent(middlePanel, GroupLayout.PREFERRED_SIZE, 534, GroupLayout.PREFERRED_SIZE))
				.addComponent(LeftSideHomePanel, GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
		);
		LeftSideHomePanel.setLayout(new CardLayout(0, 0));

		homeSidePanel = new JPanel();
		homeSidePanel.setBackground(Color.LIGHT_GRAY);
		LeftSideHomePanel.add(homeSidePanel, "name_325461259392700");
		homeSidePanel.setLayout(null);

		welcomeLabel = new JLabel("Welcome!");
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setForeground(Color.DARK_GRAY);
		welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		welcomeLabel.setBounds(32, 84, 177, 13);
		homeSidePanel.add(welcomeLabel);

		UserLabel = new JLabel("User");
		UserLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		UserLabel.setHorizontalAlignment(SwingConstants.CENTER);
		UserLabel.setForeground(Color.DARK_GRAY);
		UserLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		UserLabel.setBounds(32, 107, 177, 28);
		homeSidePanel.add(UserLabel);

		allRequestsLabel = new JLabel("All Requests");
		allRequestsLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				allRequestsLabel.setForeground(new Color(0, 0, 139));
				allEventsLabel.setForeground(Color.DARK_GRAY);
				createEventLabel.setForeground(Color.DARK_GRAY);
				updateEventLabel.setForeground(Color.DARK_GRAY);
				removeEventLabel.setForeground(Color.DARK_GRAY);

				allEventPanel.setVisible(false);
				allEventRequestPanel.setVisible(true);


				loadRequestEventsList();
				clearEventRequestDescriptionTextArea();
				// loadEventsList();
			}
		});
		allRequestsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		allRequestsLabel.setForeground(new Color(0, 0, 139));
		allRequestsLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		allRequestsLabel.setBounds(32, 268, 177, 22);
		homeSidePanel.add(allRequestsLabel);

		createEventLabel = new JLabel("Create event");
		createEventLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				allRequestsLabel.setForeground(Color.DARK_GRAY);
				createEventLabel.setForeground(new Color(0, 0, 139));
				updateEventLabel.setForeground(Color.DARK_GRAY);
				removeEventLabel.setForeground(Color.DARK_GRAY);

				if (!Database.isInAClub(user.getUsername())) {

					int response = JOptionPane.showConfirmDialog(null,
							"It looks like you are not in a club, in order to make an event you need to be in one, Do you want to join one?",
							"Information", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (response == JOptionPane.YES_OPTION) {

						homeLabel.setForeground(Color.DARK_GRAY);
						clubLabel.setForeground(new Color(0, 0, 139));
						memberLabel.setForeground(Color.DARK_GRAY);
						profileLabel.setForeground(Color.DARK_GRAY);

						allEventRequestPanel.setVisible(false);
						clubPanel.setVisible(true);
						profilePanel.setVisible(false);

						homeSidePanel.setVisible(false);
						clubSidePanel.setVisible(true);
						memberSidePanel.setVisible(false);
						profileSidePanel.setVisible(false);

					}

				} else {
					// CreateEventFrame createEventFrame = new CreateEventFrame();
					// createEventFrame.setVisible(true);
					RequestEvent requestEventFrame = new RequestEvent();
					requestEventFrame.setUser(user);
					requestEventFrame.setVisible(true);
				}
			}
		});
		createEventLabel.setHorizontalAlignment(SwingConstants.CENTER);
		createEventLabel.setForeground(Color.DARK_GRAY);
		createEventLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		createEventLabel.setBounds(32, 351, 177, 22);
		homeSidePanel.add(createEventLabel);

		updateEventLabel = new JLabel("Update event");
		updateEventLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				allRequestsLabel.setForeground(Color.DARK_GRAY);
				allEventsLabel.setForeground(Color.DARK_GRAY);
				createEventLabel.setForeground(Color.DARK_GRAY);
				updateEventLabel.setForeground(new Color(0, 0, 139));
				removeEventLabel.setForeground(Color.DARK_GRAY);

				// get only 1 selected row, if more show message and if zero show another
				// message.
				int[] row = eventTable.getSelectedRows();

				if (row.length > 1) {

					JOptionPane.showMessageDialog(null, "Select 1 event at a time to update", "Information",
							JOptionPane.WARNING_MESSAGE);
					allRequestsLabel.setForeground(new Color(0, 0, 139));
					createEventLabel.setForeground(Color.DARK_GRAY);
					updateEventLabel.setForeground(Color.DARK_GRAY);
					removeEventLabel.setForeground(Color.DARK_GRAY);
				}
				if (row.length < 1) {

					JOptionPane.showMessageDialog(null, "No event is selected to update", "Information",
							JOptionPane.WARNING_MESSAGE);
					allRequestsLabel.setForeground(new Color(0, 0, 139));
					createEventLabel.setForeground(Color.DARK_GRAY);
					updateEventLabel.setForeground(Color.DARK_GRAY);
					removeEventLabel.setForeground(Color.DARK_GRAY);
				}

				else {

					// get the ID from the table

					DefaultTableModel model = (DefaultTableModel) eventTable.getModel();
					EventRequest eventReq = Database.getEventReq(user.getUsername(), (int) model.getValueAt(row[0], 1));

					if (eventReq.getApproval().equals("Approved")) {
						JOptionPane.showMessageDialog(null, "The event was already approved and cannot be changed",
								"Error", JOptionPane.WARNING_MESSAGE);

						allRequestsLabel.setForeground(new Color(0, 0, 139));
						createEventLabel.setForeground(Color.DARK_GRAY);
						updateEventLabel.setForeground(Color.DARK_GRAY);
						removeEventLabel.setForeground(Color.DARK_GRAY);

					}

					else if (eventReq.getApproval().equals("Denied")) {
						JOptionPane.showMessageDialog(null,
								"The event was denied and cannot be changed Make a new one!", "Error",
								JOptionPane.WARNING_MESSAGE);

						allRequestsLabel.setForeground(new Color(0, 0, 139));
						createEventLabel.setForeground(Color.DARK_GRAY);
						updateEventLabel.setForeground(Color.DARK_GRAY);
						removeEventLabel.setForeground(Color.DARK_GRAY);
					}

					else {

						// create UpdateRequest

						UpdateRequest updateEventFrame = new UpdateRequest(eventReq);
						updateEventFrame.setUser(user);
						updateEventFrame.setVisible(true);
						// pass event
					}
				}
			}
		});

		updateEventLabel.setHorizontalAlignment(SwingConstants.CENTER);
		updateEventLabel.setForeground(Color.DARK_GRAY);
		updateEventLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		updateEventLabel.setBounds(32, 400, 177, 13);
		homeSidePanel.add(updateEventLabel);

		removeEventLabel = new JLabel("Remove event");
		removeEventLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				allRequestsLabel.setForeground(Color.DARK_GRAY);
				allEventsLabel.setForeground(Color.DARK_GRAY);
				createEventLabel.setForeground(Color.DARK_GRAY);
				updateEventLabel.setForeground(Color.DARK_GRAY);
				removeEventLabel.setForeground(new Color(0, 0, 139));

				int[] row = eventTable.getSelectedRows();

				if (row.length > 1) {

					JOptionPane.showMessageDialog(null, "Select 1 request at a time to remove", "Information",
							JOptionPane.WARNING_MESSAGE);
					allRequestsLabel.setForeground(new Color(0, 0, 139));
					createEventLabel.setForeground(Color.DARK_GRAY);
					updateEventLabel.setForeground(Color.DARK_GRAY);
					removeEventLabel.setForeground(Color.DARK_GRAY);
				}
				if (row.length < 1) {

					JOptionPane.showMessageDialog(null, "No request is selected to remove", "Information",
							JOptionPane.WARNING_MESSAGE);
					allRequestsLabel.setForeground(new Color(0, 0, 139));
					createEventLabel.setForeground(Color.DARK_GRAY);
					updateEventLabel.setForeground(Color.DARK_GRAY);
					removeEventLabel.setForeground(Color.DARK_GRAY);
				}

				else {

					DefaultTableModel model = (DefaultTableModel) eventTable.getModel();
					int eventReqID = (int) model.getValueAt(row[0], 1);
					EventRequest eventReq = Database.getEventReq(user.getUsername(), (int) model.getValueAt(row[0], 1));

					if (eventReq.getApproval().equals("Approved")) {
						JOptionPane.showMessageDialog(null, "The event was already approved and cannot be removed!",
								"Error", JOptionPane.WARNING_MESSAGE);

						allRequestsLabel.setForeground(new Color(0, 0, 139));
						createEventLabel.setForeground(Color.DARK_GRAY);
						updateEventLabel.setForeground(Color.DARK_GRAY);
						removeEventLabel.setForeground(Color.DARK_GRAY);

					}

					else if (eventReq.getApproval().equals("Denied")) {
						JOptionPane.showMessageDialog(null,
								"The request was denied and cannot be changed. Make a new one!", "Error",
								JOptionPane.WARNING_MESSAGE);

						allRequestsLabel.setForeground(new Color(0, 0, 139));
						createEventLabel.setForeground(Color.DARK_GRAY);
						updateEventLabel.setForeground(Color.DARK_GRAY);
						removeEventLabel.setForeground(Color.DARK_GRAY);
					}

					else {

						// create UpdateRequest
						int response = JOptionPane.showConfirmDialog(null,
								"Are you sure you want to remove your pending request?", "Confirmation",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

						if (response == 0) {

							Database.removeEventRequest(user.getUsername(), eventReqID);
							allRequestsLabel.setForeground(new Color(0, 0, 139));
							createEventLabel.setForeground(Color.DARK_GRAY);
							updateEventLabel.setForeground(Color.DARK_GRAY);
							removeEventLabel.setForeground(Color.DARK_GRAY);
						}
						// pass event
					}
				}
				loadRequestEventsList();			}
		});
		removeEventLabel.setHorizontalAlignment(SwingConstants.CENTER);
		removeEventLabel.setForeground(Color.DARK_GRAY);
		removeEventLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		removeEventLabel.setBounds(32, 444, 177, 13);
		homeSidePanel.add(removeEventLabel);

		allEventsLabel = new JLabel("All Events");
		allEventsLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				allRequestsLabel.setForeground(Color.DARK_GRAY);
				allEventsLabel.setForeground(new Color(0, 0, 139));
				createEventLabel.setForeground(Color.DARK_GRAY);
				updateEventLabel.setForeground(Color.DARK_GRAY);
				removeEventLabel.setForeground(Color.DARK_GRAY);

				allEventPanel.setVisible(true);
				allEventRequestPanel.setVisible(false);
				
				loadEventsList();
				clearEventDetail();

			}
		});
		allEventsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		allEventsLabel.setForeground(Color.DARK_GRAY);
		allEventsLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		allEventsLabel.setBounds(32, 309, 177, 22);
		homeSidePanel.add(allEventsLabel);

		clubSidePanel = new JPanel();
		clubSidePanel.setBackground(Color.LIGHT_GRAY);
		LeftSideHomePanel.add(clubSidePanel, "name_326622622249300");
		clubSidePanel.setLayout(null);

		JLabel lblClubs = new JLabel("Clubs");
		lblClubs.setHorizontalAlignment(SwingConstants.CENTER);
		lblClubs.setFont(new Font("OCR A Extended", Font.BOLD, 25));
		lblClubs.setBounds(36, 53, 147, 39);
		clubSidePanel.add(lblClubs);

		clubListLabel = new JLabel("All Clubs");
		clubListLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				loadAllClubs();

				clubListLabel.setForeground(new Color(0, 0, 139));
				clubPanel.setVisible(true);

				if (Database.isInAClub(user.getUsername())) {

					clubListLabel.setForeground(new Color(0, 0, 139));
					clubMembersLabel.setForeground(Color.DARK_GRAY);
					leaveClubLabel.setForeground(Color.DARK_GRAY);
					clubEventsLabel.setForeground(Color.DARK_GRAY);


					clubPanel.setVisible(true);
					clubMembersPanel.setVisible(false);

				}

			}
		});
		clubListLabel.setHorizontalAlignment(SwingConstants.CENTER);
		clubListLabel.setForeground(new Color(0, 0, 139));
		clubListLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		clubListLabel.setBounds(36, 279, 177, 22);
		clubSidePanel.add(clubListLabel);

		clubMembersLabel = new JLabel("Club Members");
		clubMembersLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				if (Database.isInAClub(user.getUsername())) {

					clubPanel.setVisible(false);
					clubEventPanel.setVisible(false);


					loadClubMembers();

					clubListLabel.setForeground(Color.DARK_GRAY);
					clubMembersLabel.setForeground(new Color(0, 0, 139));
					leaveClubLabel.setForeground(Color.DARK_GRAY);
					clubEventsLabel.setForeground(Color.DARK_GRAY);

					
					clubMembersPanel.setVisible(true);

				}
			}
		});
		clubMembersLabel.setHorizontalAlignment(SwingConstants.CENTER);
		clubMembersLabel.setForeground(Color.GRAY);
		clubMembersLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		clubMembersLabel.setBounds(36, 367, 177, 22);
		clubSidePanel.add(clubMembersLabel);

		leaveClubLabel = new JLabel("Leave Club");
		leaveClubLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				if (Database.isInAClub(user.getUsername())) {

					clubListLabel.setForeground(Color.DARK_GRAY);
					clubMembersLabel.setForeground(Color.DARK_GRAY);
					leaveClubLabel.setForeground(new Color(0, 0, 139));
					clubEventsLabel.setForeground(Color.DARK_GRAY);


					int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to leave your club?",
							"Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (response == JOptionPane.YES_OPTION) {

						Database.removeMemberFromClub(user.getUsername(), Database.getClubName(user.getUsername()));

						clubListLabel.setForeground(new Color(0, 0, 139));
						clubMembersLabel.setForeground(Color.GRAY);
						leaveClubLabel.setForeground(Color.GRAY);
						clubEventsLabel.setForeground(Color.GRAY);


					} else {

						clubListLabel.setForeground(new Color(0, 0, 139));
						clubMembersLabel.setForeground(Color.DARK_GRAY);
						leaveClubLabel.setForeground(Color.DARK_GRAY);
						clubEventsLabel.setForeground(Color.DARK_GRAY);


						clubPanel.setVisible(true);
						clubMembersPanel.setVisible(false);
						clubEventPanel.setVisible(false);


					}
				}
			}
		});

		leaveClubLabel.setHorizontalAlignment(SwingConstants.CENTER);
		leaveClubLabel.setForeground(Color.GRAY);
		leaveClubLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		leaveClubLabel.setBounds(36, 412, 177, 22);
		clubSidePanel.add(leaveClubLabel);
		
		clubEventsLabel = new JLabel("Club Events");
		clubEventsLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				if (Database.isInAClub(user.getUsername())) {

					loadClubEventsList(clubEventTable);
					
					clubPanel.setVisible(false);
					clubMembersPanel.setVisible(false);
					clubEventPanel.setVisible(true);

					
					clubListLabel.setForeground(Color.DARK_GRAY);
					clubMembersLabel.setForeground(Color.DARK_GRAY);
					leaveClubLabel.setForeground(Color.DARK_GRAY);
					clubEventsLabel.setForeground(new Color(0, 0, 139));

					


				}
			}
		});
		clubEventsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		clubEventsLabel.setForeground(Color.GRAY);
		clubEventsLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		clubEventsLabel.setBounds(36, 323, 177, 22);
		clubSidePanel.add(clubEventsLabel);

		memberSidePanel = new JPanel();
		memberSidePanel.setBackground(Color.LIGHT_GRAY);
		LeftSideHomePanel.add(memberSidePanel, "name_326625620918800");
		memberSidePanel.setLayout(null);

		memberHeading = new JLabel("Members");
		memberHeading.setHorizontalAlignment(SwingConstants.CENTER);
		memberHeading.setForeground(Color.BLACK);
		memberHeading.setFont(new Font("OCR A Extended", Font.BOLD, 25));
		memberHeading.setBounds(53, 64, 122, 22);
		memberSidePanel.add(memberHeading);

		JLabel attendeesLabel = new JLabel("Attendees");
		attendeesLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				loadClubEventsList(eventDisplayTable);

				attendeesLabel.setForeground(new Color(0, 0, 139));
				attendeesPanel.setVisible(true);

			}
		});
		attendeesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		attendeesLabel.setForeground(Color.DARK_GRAY);
		attendeesLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		attendeesLabel.setBounds(10, 244, 203, 22);
		memberSidePanel.add(attendeesLabel);

		profileSidePanel = new JPanel();
		profileSidePanel.setBackground(Color.LIGHT_GRAY);
		LeftSideHomePanel.add(profileSidePanel, "name_326635336826700");
		profileSidePanel.setLayout(null);

		infoLabel = new JLabel("User Info");
		infoLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				infoLabel.setForeground(new Color(0, 0, 139));
				updatePasswordLabel.setForeground(Color.DARK_GRAY);
				haveAdminLabel.setForeground(Color.DARK_GRAY);

				profilePanel.setVisible(true);
				updatePasswordPanel.setVisible(false);
				makeAdminPanel.setVisible(false);

			}
		});
		infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		infoLabel.setForeground(new Color(0, 0, 139));
		infoLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		infoLabel.setBounds(21, 268, 177, 13);
		profileSidePanel.add(infoLabel);

		updatePasswordLabel = new JLabel("Update Password");
		updatePasswordLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				infoLabel.setForeground(Color.DARK_GRAY);
				updatePasswordLabel.setForeground(new Color(0, 0, 139));
				haveAdminLabel.setForeground(Color.DARK_GRAY);

				profilePanel.setVisible(false);
				updatePasswordPanel.setVisible(true);
				makeAdminPanel.setVisible(false);

			}
		});
		updatePasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		updatePasswordLabel.setForeground(Color.DARK_GRAY);
		updatePasswordLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		updatePasswordLabel.setBounds(10, 306, 203, 22);
		profileSidePanel.add(updatePasswordLabel);

		haveAdminLabel = new JLabel("Get Admin");
		haveAdminLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				infoLabel.setForeground(Color.DARK_GRAY);
				updatePasswordLabel.setForeground(Color.DARK_GRAY);
				haveAdminLabel.setForeground(new Color(0, 0, 139));

				profilePanel.setVisible(false);
				updatePasswordPanel.setVisible(false);
				makeAdminPanel.setVisible(true);

			}
		});
		haveAdminLabel.setHorizontalAlignment(SwingConstants.CENTER);
		haveAdminLabel.setForeground(Color.DARK_GRAY);
		haveAdminLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		haveAdminLabel.setBounds(10, 349, 203, 22);
		profileSidePanel.add(haveAdminLabel);

		profileHeading = new JLabel("Profile");
		profileHeading.setHorizontalAlignment(SwingConstants.CENTER);
		profileHeading.setForeground(Color.BLACK);
		profileHeading.setFont(new Font("OCR A Extended", Font.BOLD, 25));
		profileHeading.setBounds(21, 63, 168, 22);
		profileSidePanel.add(profileHeading);

		eventTable = new JTable();
		eventTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				int[] getSelectedRow = eventTable.getSelectedRows();

				if (getSelectedRow.length > 1)
					JOptionPane.showMessageDialog(null, "Select 1 event at a time to show details!", "Information",
							JOptionPane.WARNING_MESSAGE);

				else {

					DefaultTableModel eventModel = (DefaultTableModel) eventTable.getModel();
					int eventID = (int) eventModel.getValueAt(getSelectedRow[0], 1);
					loadEventRequestDetails(eventID);
					
				}
			}
		});
		eventTable.setColumnSelectionAllowed(false);
		eventTable.setCellSelectionEnabled(false);
		eventTable.setDefaultEditor(Object.class, null);
		eventTable.setRowSelectionAllowed(false);
		eventTable.setFont(new Font("Tahoma", Font.PLAIN, 13));

		DefaultTableModel model = new DefaultTableModel(new Object[][] {},
				new String[] { "Image", "EventRequestID", "EventName" });

		eventTable.setModel(model);

		loadRequestEventsList();
		middlePanel.setLayout(new CardLayout(0, 0));

		clubPanel = new JPanel();
		middlePanel.add(clubPanel, "name_324129821657700");

		clubScrollPane = new JScrollPane();

		joinClubButton = new JButton("Join Club");
		joinClubButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int[] rows = allClubTable.getSelectedRows();

				if (rows.length > 1) {

					JOptionPane.showMessageDialog(null, "Select 1 club!", "Information", JOptionPane.WARNING_MESSAGE);

				} else if (rows.length < 1) {

					JOptionPane.showMessageDialog(null, "No club is selected to join", "Information",
							JOptionPane.WARNING_MESSAGE);

				} else if (Database.isInAClub(user.getUsername())) {

					JOptionPane.showMessageDialog(null, "Cannot join more then 1 club!", "Information",
							JOptionPane.WARNING_MESSAGE);
				} else if (Database.madeAClubRequest(user)) {

					JOptionPane.showMessageDialog(null, "Request already sent wait for approval!", "Information",
							JOptionPane.WARNING_MESSAGE);
				}

				else {

					int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to join this club?",
							"Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (response == JOptionPane.YES_OPTION) {

						DefaultTableModel model = (DefaultTableModel) allClubTable.getModel();

						String clubName = (String) model.getValueAt(rows[0], 1);
						Database.addClubRequest(user, clubName);
						// Database.addMemberToClubList(user, clubName);

						// clubMembersLabel.setForeground(Color.DARK_GRAY);
						// leaveClubLabel.setForeground(Color.DARK_GRAY);
					}
				}

			}
		});
		joinClubButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		clubDescriptionPanel = new JPanel();
		clubDescriptionPanel.setBackground(Color.LIGHT_GRAY);
		
		clubDescriptionLabel = new JLabel("Description");
		clubDescriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		clubDescriptionLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 15));
		GroupLayout gl_clubDescriptionPanel = new GroupLayout(clubDescriptionPanel);
		gl_clubDescriptionPanel.setHorizontalGroup(
			gl_clubDescriptionPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 356, Short.MAX_VALUE)
				.addGroup(gl_clubDescriptionPanel.createSequentialGroup()
					.addGap(129)
					.addComponent(clubDescriptionLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(130))
		);
		gl_clubDescriptionPanel.setVerticalGroup(
			gl_clubDescriptionPanel.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 41, Short.MAX_VALUE)
				.addGroup(gl_clubDescriptionPanel.createSequentialGroup()
					.addContainerGap(15, Short.MAX_VALUE)
					.addComponent(clubDescriptionLabel)
					.addContainerGap())
		);
		clubDescriptionPanel.setLayout(gl_clubDescriptionPanel);
		
		clubDescriptionScrollPane = new JScrollPane();
		clubDescriptionScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		clubDescriptionScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GroupLayout gl_clubPanel = new GroupLayout(clubPanel);
		gl_clubPanel.setHorizontalGroup(
			gl_clubPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_clubPanel.createSequentialGroup()
					.addContainerGap(923, Short.MAX_VALUE)
					.addComponent(joinClubButton)
					.addGap(33))
				.addGroup(gl_clubPanel.createSequentialGroup()
					.addComponent(clubScrollPane, GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
					.addGroup(gl_clubPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(clubDescriptionPanel, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
						.addComponent(clubDescriptionScrollPane, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)))
		);
		gl_clubPanel.setVerticalGroup(
			gl_clubPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_clubPanel.createSequentialGroup()
					.addGroup(gl_clubPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_clubPanel.createSequentialGroup()
							.addComponent(clubDescriptionPanel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addComponent(clubDescriptionScrollPane, GroupLayout.PREFERRED_SIZE, 446, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(joinClubButton))
						.addComponent(clubScrollPane, GroupLayout.PREFERRED_SIZE, 487, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		
		clubDescriptionTextArea = new JTextArea();
		clubDescriptionTextArea.setLineWrap(true);
		clubDescriptionTextArea.setWrapStyleWord(true);
		clubDescriptionTextArea.setEditable(false);
		clubDescriptionScrollPane.setViewportView(clubDescriptionTextArea);

		allClubTable = new JTable();
		allClubTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				int[] getSelectedRow = allClubTable.getSelectedRows();

				if (getSelectedRow.length > 1)
					JOptionPane.showMessageDialog(null, "Select 1 club at a time to show details!", "Information",
							JOptionPane.WARNING_MESSAGE);

				else {

					DefaultTableModel eventModel = (DefaultTableModel) allClubTable.getModel();
					String clubName = (String) eventModel.getValueAt(getSelectedRow[0], 1);
					loadClubDetails(clubName);
				}

			}
		});
		allClubTable.setColumnSelectionAllowed(false);
		allClubTable.setCellSelectionEnabled(false);
		allClubTable.setDefaultEditor(Object.class, null);
		allClubTable.setRowSelectionAllowed(true);

		DefaultTableModel allClubTableModel = new DefaultTableModel(new Object[][] {}, new String[] { "IMG", "Name" });

		allClubTable.setModel(allClubTableModel);
		clubScrollPane.setViewportView(allClubTable);
		clubPanel.setLayout(gl_clubPanel);

		profilePanel = new JPanel();
		middlePanel.add(profilePanel, "name_324172924229000");

		profilePage = new JScrollPane();
		GroupLayout gl_profilePanel = new GroupLayout(profilePanel);
		gl_profilePanel.setHorizontalGroup(
			gl_profilePanel.createParallelGroup(Alignment.LEADING)
				.addComponent(profilePage, GroupLayout.DEFAULT_SIZE, 1059, Short.MAX_VALUE)
		);
		gl_profilePanel.setVerticalGroup(
			gl_profilePanel.createParallelGroup(Alignment.LEADING)
				.addComponent(profilePage, GroupLayout.PREFERRED_SIZE, 534, GroupLayout.PREFERRED_SIZE)
		);

		JPanel profile = new JPanel();
		profilePage.setViewportView(profile);
		profile.setLayout(null);

		Username = new JLabel("Username");
		Username.setBounds(154, 136, 177, 13);
		Username.setHorizontalAlignment(SwingConstants.CENTER);
		Username.setForeground(Color.DARK_GRAY);
		Username.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		profile.add(Username);

		firstNameLabel = new JLabel("First Name");
		firstNameLabel.setBounds(154, 190, 177, 13);
		firstNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		firstNameLabel.setForeground(Color.DARK_GRAY);
		firstNameLabel.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		profile.add(firstNameLabel);

		lastnameLabel = new JLabel("Last Name");
		lastnameLabel.setBounds(154, 243, 177, 13);
		lastnameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lastnameLabel.setForeground(Color.DARK_GRAY);
		lastnameLabel.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		profile.add(lastnameLabel);

		emailLabel = new JLabel("Email");
		emailLabel.setBounds(154, 290, 177, 13);
		emailLabel.setHorizontalAlignment(SwingConstants.CENTER);
		emailLabel.setForeground(Color.DARK_GRAY);
		emailLabel.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		profile.add(emailLabel);

		usernameTextField = new JTextField();
		usernameTextField.setBounds(341, 127, 260, 28);
		usernameTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		profile.add(usernameTextField);
		usernameTextField.setColumns(10);

		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(341, 181, 260, 28);
		firstNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		firstNameTextField.setColumns(10);
		profile.add(firstNameTextField);

		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(341, 234, 260, 28);
		lastNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lastNameTextField.setColumns(10);
		profile.add(lastNameTextField);

		emailTextField = new JTextField();
		emailTextField.setBounds(341, 281, 260, 28);
		emailTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		emailTextField.setColumns(10);
		profile.add(emailTextField);

		JButton infoUpdateButton = new JButton("Update");
		infoUpdateButton.setBounds(795, 440, 155, 28);
		infoUpdateButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String firstName = firstNameTextField.getText();
				String lastName = lastNameTextField.getText();
				String username = usernameTextField.getText();
				String email = emailTextField.getText();

				if (!RegisterFrame.verifyEmailAddress(email)) {

					JOptionPane.showMessageDialog(null, "Invalid email Address!", "Error", JOptionPane.ERROR_MESSAGE);
				}

				else if (emailOverride(email)) {

				}

				else if (!RegisterFrame.isValidUsername(username)) {

					JOptionPane.showMessageDialog(null, "The username should be longer then 6 character!", "Error",
							JOptionPane.ERROR_MESSAGE);

				}

				else if (!RegisterFrame.isNameValid(firstName)) {

					JOptionPane.showMessageDialog(null, "The first name is not valid!", "Error",
							JOptionPane.ERROR_MESSAGE);

				}

				else if (!RegisterFrame.isNameValid(lastName)) {

					JOptionPane.showMessageDialog(null, "The last name is not valid!", "Error",
							JOptionPane.ERROR_MESSAGE);

				} else {

					int response = JOptionPane.showConfirmDialog(null,
							"Are you sure you want to update your information?", "Confirmation",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (response == JOptionPane.YES_OPTION) {

						MemberInfo updatedInfo = new MemberInfo();
						updatedInfo.setFirstName(firstName);
						updatedInfo.setLastName(lastName);
						updatedInfo.setUsername(username);
						updatedInfo.setEmail(email);
						updatedInfo.setPassword(user.getPassword());
						;
						updatedInfo.setAdmin(user.getAdmin());
						updatedInfo.setMemberID(user.getMemberID());
						Database.updateMemberInfo(updatedInfo);
						setUser(updatedInfo);
						JOptionPane.showMessageDialog(null, "The User Information has been updated!", "Information",
								JOptionPane.INFORMATION_MESSAGE);

					}
				}
			}

			private boolean emailOverride(String email) {

				String tempEmail = user.getEmail();
				user.setEmail("");
				Database.updateEmail(user);

				if (Database.emailInUse(email)) {
					JOptionPane.showMessageDialog(null, "This email is already in use!", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

				user.setEmail(tempEmail);
				Database.updateEmail(user);

				return false;
			}

		});
		infoUpdateButton.setFocusable(false);
		infoUpdateButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		profile.add(infoUpdateButton);
		profilePanel.setLayout(gl_profilePanel);

		updatePasswordPanel = new JPanel();
		middlePanel.add(updatePasswordPanel, "name_3137723124400");
		updatePasswordPanel.setLayout(null);

		newPasswordLabel = new JLabel("New Password");
		newPasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		newPasswordLabel.setForeground(Color.DARK_GRAY);
		newPasswordLabel.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		newPasswordLabel.setBounds(160, 149, 177, 13);
		updatePasswordPanel.add(newPasswordLabel);

		confirmPasswordLabel = new JLabel("Confirm Password");
		confirmPasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		confirmPasswordLabel.setForeground(Color.DARK_GRAY);
		confirmPasswordLabel.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		confirmPasswordLabel.setBounds(147, 190, 190, 13);
		updatePasswordPanel.add(confirmPasswordLabel);

		confirmPasswordTextField = new JPasswordField();
		confirmPasswordTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		confirmPasswordTextField.setColumns(10);
		confirmPasswordTextField.setBounds(364, 181, 260, 28);
		updatePasswordPanel.add(confirmPasswordTextField);

		newPasswordTextField = new JPasswordField();
		newPasswordTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		newPasswordTextField.setColumns(10);
		newPasswordTextField.setBounds(364, 140, 260, 28);
		updatePasswordPanel.add(newPasswordTextField);

		JButton passwordUpdateButton = new JButton("Update");
		passwordUpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String newPass = newPasswordTextField.getText();
				String confirmPass = confirmPasswordTextField.getText();

				if (!RegisterFrame.isValidPassword(newPass)) {

					// does password match the requirement. need 1 uppercase 2 number and atleast 8
					// character long.

					JOptionPane.showMessageDialog(null,
							"The password needs to be of 1 uppercase, 2 number and atleast 8 characters!", "Error",
							JOptionPane.ERROR_MESSAGE);

				}

				if (!newPass.equals(confirmPass)) {

					// does password match with confirm password

					JOptionPane.showMessageDialog(null, "The new password and confirm password doesnt match!", "Error",
							JOptionPane.ERROR_MESSAGE);

				} else {

					int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to change your password?",
							"Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (response == JOptionPane.YES_OPTION) {

						MemberInfo updatedInfo = new MemberInfo();

						updatedInfo.setPassword(newPass);
						updatedInfo.setMemberID(user.getMemberID());
						Database.updatePassword(updatedInfo);

						JOptionPane.showMessageDialog(null, "The password has been updated!", "Information",
								JOptionPane.INFORMATION_MESSAGE);
					}

				}
			}
		});
		passwordUpdateButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordUpdateButton.setFocusable(false);
		passwordUpdateButton.setBounds(469, 243, 155, 28);
		updatePasswordPanel.add(passwordUpdateButton);

		makeAdminPanel = new JPanel();
		middlePanel.add(makeAdminPanel, "name_3867426941800");

		JLabel passCodeLabel = new JLabel("Passcode");
		passCodeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passCodeLabel.setForeground(Color.DARK_GRAY);
		passCodeLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));

		passCodeTextField = new JTextField();
		passCodeTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passCodeTextField.setColumns(10);

		JButton getAdminButton = new JButton("Get Admin");
		getAdminButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (passCodeTextField.getText().equals(""))
					JOptionPane.showMessageDialog(null, "The passcode field is empty!", "Error",
							JOptionPane.ERROR_MESSAGE);

				else if (Database.checkPasscodeForAdmin(passCodeTextField.getText())) {

					Database.passAdmin(user.getEmail());
					JOptionPane.showMessageDialog(null, "You are now an Admin, log in again to take effect!",
							"Confirmation", JOptionPane.INFORMATION_MESSAGE);

					dispose();

					LoginFrame lf = new LoginFrame();
					lf.getFrame().setVisible(true);

				} else {

					JOptionPane.showMessageDialog(null, "The passcode doesn't match!", "Error",
							JOptionPane.ERROR_MESSAGE);

				}

			}
		});
		getAdminButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		GroupLayout gl_makeAdminPanel = new GroupLayout(makeAdminPanel);
		gl_makeAdminPanel.setHorizontalGroup(gl_makeAdminPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_makeAdminPanel.createSequentialGroup().addGap(261).addGroup(gl_makeAdminPanel
						.createParallelGroup(Alignment.TRAILING)
						.addComponent(getAdminButton, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_makeAdminPanel.createSequentialGroup()
								.addComponent(passCodeLabel, GroupLayout.PREFERRED_SIZE, 137,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(passCodeTextField,
										GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(412, Short.MAX_VALUE)));
		gl_makeAdminPanel.setVerticalGroup(gl_makeAdminPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_makeAdminPanel.createSequentialGroup().addGap(178)
						.addGroup(gl_makeAdminPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(passCodeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(passCodeLabel, GroupLayout.PREFERRED_SIZE, 22,
										GroupLayout.PREFERRED_SIZE))
						.addGap(30)
						.addComponent(getAdminButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(271, Short.MAX_VALUE)));
		makeAdminPanel.setLayout(gl_makeAdminPanel);

		allEventPanel = new JPanel();
		middlePanel.add(allEventPanel, "name_1072140281400");

		allEventScrollPane = new JScrollPane();
		
		allEventDescriptionPanel = new JPanel();
		allEventDescriptionPanel.setBackground(Color.LIGHT_GRAY);
		
		eventDescriptionLabel = new JLabel("Description");
		eventDescriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		eventDescriptionLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 15));
		GroupLayout gl_allEventDescriptionPanel = new GroupLayout(allEventDescriptionPanel);
		gl_allEventDescriptionPanel.setHorizontalGroup(
			gl_allEventDescriptionPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 415, Short.MAX_VALUE)
				.addGroup(gl_allEventDescriptionPanel.createSequentialGroup()
					.addGap(129)
					.addComponent(eventDescriptionLabel, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
					.addGap(130))
		);
		gl_allEventDescriptionPanel.setVerticalGroup(
			gl_allEventDescriptionPanel.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 41, Short.MAX_VALUE)
				.addGroup(gl_allEventDescriptionPanel.createSequentialGroup()
					.addContainerGap(15, Short.MAX_VALUE)
					.addComponent(eventDescriptionLabel)
					.addContainerGap())
		);
		allEventDescriptionPanel.setLayout(gl_allEventDescriptionPanel);
		
		allEventDescriptionScrollPane = new JScrollPane();
		GroupLayout gl_allEventPanel = new GroupLayout(allEventPanel);
		gl_allEventPanel.setHorizontalGroup(
			gl_allEventPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_allEventPanel.createSequentialGroup()
					.addComponent(allEventScrollPane, GroupLayout.PREFERRED_SIZE, 620, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_allEventPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(allEventDescriptionPanel, GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
						.addComponent(allEventDescriptionScrollPane, GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)))
		);
		gl_allEventPanel.setVerticalGroup(
			gl_allEventPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(allEventScrollPane, GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
				.addGroup(gl_allEventPanel.createSequentialGroup()
					.addComponent(allEventDescriptionPanel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addComponent(allEventDescriptionScrollPane, GroupLayout.PREFERRED_SIZE, 492, GroupLayout.PREFERRED_SIZE)
					.addGap(19))
		);
		
		eventDescriptionTextArea = new JTextArea();
		allEventDescriptionScrollPane.setViewportView(eventDescriptionTextArea);

		allEventTable = new JTable();
		allEventTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				int[] getSelectedRow = allEventTable.getSelectedRows();

				if (getSelectedRow.length > 1)
					JOptionPane.showMessageDialog(null, "Select 1 event at a time to show Details!", "Information",
							JOptionPane.WARNING_MESSAGE);

				else {

					DefaultTableModel eventModel = (DefaultTableModel) allEventTable.getModel();
					int eventID = (int) eventModel.getValueAt(getSelectedRow[0], 1);
					String eventName = (String) eventModel.getValueAt(getSelectedRow[0], 2);

					System.out.println("Pressed: " + eventID + " " + eventName);
					System.out.println("Row value " + getSelectedRow[0]);

					loadEventDetail(eventID);

				}

				
			}
		});
		allEventTable.setColumnSelectionAllowed(false);
		allEventTable.setCellSelectionEnabled(false);
		allEventTable.setDefaultEditor(Object.class, null);
		allEventTable.setRowSelectionAllowed(true);

		DefaultTableModel allEventTableModel = new DefaultTableModel(new Object[][] {}, new String[] { "IMG", "EventID",
				"EventTitle" });

		allEventTable.setModel(allEventTableModel);

		loadEventsList();

		allEventScrollPane.setViewportView(allEventTable);
		allEventPanel.setLayout(gl_allEventPanel);

		clubMembersPanel = new JPanel();
		middlePanel.add(clubMembersPanel, "name_183791565446300");

		JScrollPane clubMembersScrollPane = new JScrollPane();
		GroupLayout gl_ClubMembersPanel = new GroupLayout(clubMembersPanel);
		gl_ClubMembersPanel.setHorizontalGroup(gl_ClubMembersPanel.createParallelGroup(Alignment.LEADING).addComponent(
				clubMembersScrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1059, Short.MAX_VALUE));
		gl_ClubMembersPanel.setVerticalGroup(gl_ClubMembersPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(clubMembersScrollPane, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE));

		clubMemberTable = new JTable();
		clubMemberTable.setColumnSelectionAllowed(false);
		clubMemberTable.setCellSelectionEnabled(false);
		clubMemberTable.setDefaultEditor(Object.class, null);
		clubMemberTable.setRowSelectionAllowed(true);

		DefaultTableModel clubMemberTableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Username", "FirstName", "LastName", "Email" });

		clubMemberTable.setModel(clubMemberTableModel);

		clubMembersScrollPane.setViewportView(clubMemberTable);
		clubMembersPanel.setLayout(gl_ClubMembersPanel);

		attendeesPanel = new JPanel();
		middlePanel.add(attendeesPanel, "name_121392887243600");

		JButton loadAttendeesFromDatabaseButton = new JButton("Load All Attendees From Database");
		loadAttendeesFromDatabaseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int[] getSelectedRow = eventDisplayTable.getSelectedRows();

				if (getSelectedRow.length < 1)
					JOptionPane.showMessageDialog(null, "No event is selected to add attendees to the Table!",
							"Information", JOptionPane.WARNING_MESSAGE);

				else if (getSelectedRow.length > 1)
					JOptionPane.showMessageDialog(null, "Select 1 event at a time to add attendee!", "Information",
							JOptionPane.WARNING_MESSAGE);

				else {

					DefaultTableModel eventModel = (DefaultTableModel) eventDisplayTable.getModel();
					int eventID = (int) eventModel.getValueAt(getSelectedRow[0], 1);
					String eventName = (String) eventModel.getValueAt(getSelectedRow[0], 2);

					System.out.println("Loading to table of " + eventName + " " + eventID);

					loadEventAttendeesFromDatabase(eventID, eventName);

				}

			}
		});
		loadAttendeesFromDatabaseButton.setFont(new Font("Tahoma", Font.BOLD, 10));

		JScrollPane emailAndStatusScrollPane = new JScrollPane();

		JButton deleteAttendeeButton = new JButton("Delete Attendee");
		deleteAttendeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int[] rows = attendeeEmailStatusTable.getSelectedRows();
				int[] eventSelected = eventDisplayTable.getSelectedRows();

				System.out.println(eventSelected[0]);
				System.out.println(eventSelected.length);

				DefaultTableModel attendeeModel = (DefaultTableModel) attendeeEmailStatusTable.getModel();

				if (rows.length < 1)
					JOptionPane.showMessageDialog(null, "No attendee is selected to remove!", "Information",
							JOptionPane.WARNING_MESSAGE);

				else {

					int response = JOptionPane.showConfirmDialog(null,
							"Are you sure you want to remove " + rows.length + " attendee?", "Confirmation",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (response == JOptionPane.YES_OPTION) {

						for (int i = 0; i < rows.length; i++) {

							String email = (String) attendeeModel.getValueAt(rows[i] - i, 0);
							int eventID = (int) eventDisplayTable.getValueAt(eventSelected[0], 1);
							String eventName = (String) eventDisplayTable.getValueAt(eventSelected[0], 2);

							System.out.println("Deleting " + email + " from " + eventID + " " + eventName);

							Database.removeAttendee(email, eventID, eventName);
							attendeeModel.removeRow(rows[i] - i);

						}
					}

				}

			}
		});
		deleteAttendeeButton.setFont(new Font("Tahoma", Font.BOLD, 10));

		JButton clearAttendeesButton = new JButton("Clear Attendees");
		clearAttendeesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int[] eventSelected = eventDisplayTable.getSelectedRows();

				System.out.println(eventSelected[0]);

				DefaultTableModel attendeeModel = (DefaultTableModel) attendeeEmailStatusTable.getModel();

				if (eventSelected.length < 1)
					JOptionPane.showMessageDialog(null, "Select a event to clear!", "Information",
							JOptionPane.WARNING_MESSAGE);

				else if (eventSelected.length > 1)
					JOptionPane.showMessageDialog(null, "Choose only 1 event to clear!", "Information",
							JOptionPane.WARNING_MESSAGE);

				else {

					int response = JOptionPane.showConfirmDialog(null,
							"Are you sure you want to clear the attendee table?", "Confirmation",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (response == JOptionPane.YES_OPTION) {

						int eventID = (int) eventDisplayTable.getValueAt(eventSelected[0], 1);
						String eventName = (String) eventDisplayTable.getValueAt(eventSelected[0], 2);

						System.out.println("Clearing " + eventName + " " + eventID);
						System.out.println("Row value " + eventSelected[0]);

						Database.removeAllAttendee(eventID, eventName);

						loadEventAttendees(eventID, eventName);

					}

				}
			}
		});
		clearAttendeesButton.setFont(new Font("Tahoma", Font.BOLD, 10));

		addAttendeeButton = new JButton("Add Attendees");
		addAttendeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int[] getSelectedRow = eventDisplayTable.getSelectedRows();

				if (getSelectedRow.length < 1)
					JOptionPane.showMessageDialog(null, "No event is selected to add attendee to the Table!",
							"Information", JOptionPane.WARNING_MESSAGE);

				else if (getSelectedRow.length > 1)
					JOptionPane.showMessageDialog(null, "Select 1 event at a time to add attendee!", "Information",
							JOptionPane.WARNING_MESSAGE);

				else {

					DefaultTableModel eventModel = (DefaultTableModel) eventDisplayTable.getModel();
					int eventID = (int) eventModel.getValueAt(getSelectedRow[0], 1);
					String eventName = (String) eventModel.getValueAt(getSelectedRow[0], 2);

					Event event = new Event();
					event.setEventID(eventID);
					event.setEventName(eventName);

					AttendeeAdderFrame aaf = new AttendeeAdderFrame(event);
					aaf.setVisible(true);
					loadEventAttendees(eventID, eventName);
				}

			}
		});
		addAttendeeButton.setFont(new Font("Tahoma", Font.BOLD, 10));

		JButton sendInviteToEventButton = new JButton("Send Invite");
		sendInviteToEventButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int[] getSelectedRow = attendeeEmailStatusTable.getSelectedRows();
				int[] getSelectedEventRow = eventDisplayTable.getSelectedRows();
				int eventID = (int) eventDisplayTable.getValueAt(getSelectedEventRow[0], 1);
				String eventName = (String) eventDisplayTable.getValueAt(getSelectedEventRow[0], 2);
				int numMail = 0;


				if (getSelectedEventRow.length < 1)
					JOptionPane.showMessageDialog(null, "Select an event to show attendees to whom you want to send mail to!",
							"Information", JOptionPane.WARNING_MESSAGE);
				
				else if (getSelectedRow.length < 1)
					JOptionPane.showMessageDialog(null, "No attendees is selected to send mail to!!",
							"Information", JOptionPane.WARNING_MESSAGE);
				
				else {

					
					Event event = Database.getEvent(eventID);
					
					for (int i = 0; i < getSelectedRow.length; i++) {

						String email = (String) attendeeEmailStatusTable.getValueAt(getSelectedRow[i], 0);
				
						System.out.println("Sending mail to " + email + " regarding " + eventName + " event");

						try {
							
							MailUtility.sendInviteMail(email, event);
							Database.updateInviteStatus(email, eventID, eventName);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							
							numMail++;
							
						}
					}
					
					if(numMail > 0) JOptionPane.showMessageDialog(null, numMail + " mails didn't receive invitation!",
							"Information", JOptionPane.WARNING_MESSAGE);
					
					else JOptionPane.showMessageDialog(null,"Invitation was sent successfully!",
							"Information", JOptionPane.INFORMATION_MESSAGE);
				
					loadEventAttendees(eventID, eventName);


				}
				
			
				
			
			}
		});
		sendInviteToEventButton.setFont(new Font("Tahoma", Font.BOLD, 10));

		JButton sendInviteAllButton = new JButton("Send Invite All");
		sendInviteAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	int[] getSelectedEventRow = eventDisplayTable.getSelectedRows();
				
				int eventID = (int) eventDisplayTable.getValueAt(getSelectedEventRow[0], 1);
				String eventName = (String) eventDisplayTable.getValueAt(getSelectedEventRow[0], 2);
				String emails = "";
				

				if (getSelectedEventRow.length < 1)
					JOptionPane.showMessageDialog(null, "Select an event to send mail of to!",
							"Information", JOptionPane.WARNING_MESSAGE);
				
				else if(Database.checkInvited(eventID, eventName)) {
					

					int response = JOptionPane.showConfirmDialog(null,
							"Are you sure you want to resent mail again to attendees?", "Confirmation",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (response == JOptionPane.YES_OPTION) {

						Event event = Database.getEvent(eventID);
						
						try {
							
							ArrayList<String> emailList = Database.getAllEmail(eventID, eventName);

							
							for(int i = 0; i < emailList.size(); i++) {
								
								if(i == emailList.size() - 1) {
									
									emails += emailList.get(i);
								}
								else
								emails += emailList.get(i) + ", ";
								
							}
							
							MailUtility.sendInviteMail(emails, event);
							Database.updateAllInviteStatus(eventID, eventName);
							loadEventAttendees(eventID, eventName);

							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
				}
				
				else {
					
					Event event = Database.getEvent(eventID);
					
					try {
						
						ArrayList<String> emailList = Database.getAllLoadedEmail(eventID, eventName);
						
						for(int i = 0; i < emailList.size(); i++) {
							
							if(i == emailList.size() - 1) {
								
								emails += emailList.get(i);
							}
							else
								
							emails += emailList.get(i) + ", ";
							
						}

						MailUtility.sendInviteMail(emails, event);
						Database.updateAllInviteStatus(eventID, eventName);
						loadEventAttendees(eventID, eventName);


					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			
			}
		});
		sendInviteAllButton.setFont(new Font("Tahoma", Font.BOLD, 10));

		JScrollPane eventScrollPanel = new JScrollPane();
		
		descriptionPanel = new JPanel();
		descriptionPanel.setBackground(Color.LIGHT_GRAY);
		
		descriptionLabel = new JLabel("Description");
		descriptionLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 15));
		GroupLayout gl_descriptionPanel = new GroupLayout(descriptionPanel);
		gl_descriptionPanel.setHorizontalGroup(
			gl_descriptionPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 347, Short.MAX_VALUE)
				.addGroup(gl_descriptionPanel.createSequentialGroup()
					.addGap(129)
					.addComponent(descriptionLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(130))
		);
		gl_descriptionPanel.setVerticalGroup(
			gl_descriptionPanel.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 41, Short.MAX_VALUE)
				.addGroup(gl_descriptionPanel.createSequentialGroup()
					.addContainerGap(15, Short.MAX_VALUE)
					.addComponent(descriptionLabel)
					.addContainerGap())
		);
		descriptionPanel.setLayout(gl_descriptionPanel);
		
		descriptionScrollPane = new JScrollPane();
		descriptionScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		descriptionScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		GroupLayout gl_attendeesPanel = new GroupLayout(attendeesPanel);
		gl_attendeesPanel.setHorizontalGroup(
			gl_attendeesPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_attendeesPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_attendeesPanel.createSequentialGroup()
						.addGap(120)
						.addComponent(loadAttendeesFromDatabaseButton, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
						.addGap(40)
						.addComponent(deleteAttendeeButton, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
						.addGap(20)
						.addComponent(clearAttendeesButton, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(addAttendeeButton, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(sendInviteToEventButton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(sendInviteAllButton, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGroup(gl_attendeesPanel.createSequentialGroup()
						.addComponent(emailAndStatusScrollPane, GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
						.addComponent(eventScrollPanel, GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
						.addGroup(gl_attendeesPanel.createParallelGroup(Alignment.TRAILING)
							.addComponent(descriptionPanel, GroupLayout.PREFERRED_SIZE, 357, Short.MAX_VALUE)
							.addComponent(descriptionScrollPane, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE))))
		);
		gl_attendeesPanel.setVerticalGroup(
			gl_attendeesPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_attendeesPanel.createSequentialGroup()
					.addGroup(gl_attendeesPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(emailAndStatusScrollPane, GroupLayout.PREFERRED_SIZE, 487, GroupLayout.PREFERRED_SIZE)
						.addComponent(eventScrollPanel, GroupLayout.PREFERRED_SIZE, 487, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_attendeesPanel.createSequentialGroup()
							.addComponent(descriptionPanel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addComponent(descriptionScrollPane, GroupLayout.PREFERRED_SIZE, 444, GroupLayout.PREFERRED_SIZE)))
					.addGap(16)
					.addGroup(gl_attendeesPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_attendeesPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(deleteAttendeeButton)
							.addComponent(loadAttendeesFromDatabaseButton))
						.addComponent(clearAttendeesButton)
						.addComponent(addAttendeeButton)
						.addComponent(sendInviteToEventButton)
						.addComponent(sendInviteAllButton))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		descriptionTextArea = new JTextArea();
		descriptionTextArea.setLineWrap(true);
		descriptionTextArea.setWrapStyleWord(true);
		descriptionTextArea.setEditable(false);
		descriptionScrollPane.setViewportView(descriptionTextArea);

		eventDisplayTable = new JTable();
		eventDisplayTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				int[] getSelectedRow = eventDisplayTable.getSelectedRows();

				if (getSelectedRow.length > 1)
					JOptionPane.showMessageDialog(null, "Select 1 event at a time to to show attendees", "Information",
							JOptionPane.WARNING_MESSAGE);

				else {

					DefaultTableModel eventModel = (DefaultTableModel) eventDisplayTable.getModel();
					int eventID = (int) eventModel.getValueAt(getSelectedRow[0], 1);
					String eventName = (String) eventModel.getValueAt(getSelectedRow[0], 2);

					System.out.println("Pressed: " + eventID + " " + eventName);
					System.out.println("Row value " + getSelectedRow[0]);

					loadEventAttendees(eventID, eventName);

				}

			}
		});
		eventDisplayTable.setColumnSelectionAllowed(false);
		eventDisplayTable.setCellSelectionEnabled(false);
		eventDisplayTable.setDefaultEditor(Object.class, null);
		eventDisplayTable.setRowSelectionAllowed(true);

		DefaultTableModel eventModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Image", "EventID", "EventName" });

		eventDisplayTable.setModel(eventModel);
		eventScrollPanel.setViewportView(eventDisplayTable);

		attendeeEmailStatusTable = new JTable();
		attendeeEmailStatusTable.setColumnSelectionAllowed(false);
		attendeeEmailStatusTable.setCellSelectionEnabled(false);
		attendeeEmailStatusTable.setDefaultEditor(Object.class, null);
		attendeeEmailStatusTable.setRowSelectionAllowed(true);

		DefaultTableModel attendeeEmailStatusTableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Email", "Status" });

		attendeeEmailStatusTable.setModel(attendeeEmailStatusTableModel);
		emailAndStatusScrollPane.setViewportView(attendeeEmailStatusTable);
		attendeesPanel.setLayout(gl_attendeesPanel);
		
		clubEventPanel = new JPanel();
		middlePanel.add(clubEventPanel, "name_124600233893700");
		
		clubEventScrollPane = new JScrollPane();
		
		makeReportButton = new JButton("Make Report");
		makeReportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int[] selectedEvent = clubEventTable.getSelectedRows();
				
	
				if(selectedEvent.length < 1) {
					
					JOptionPane.showMessageDialog(null, "Select an event to make report of!", "Error", JOptionPane.ERROR_MESSAGE);
					
				} else if(selectedEvent.length > 1) {
					
					JOptionPane.showMessageDialog(null, "Select only 1 event to make report of!", "Error", JOptionPane.ERROR_MESSAGE);

				} else {

					int eventID = (int) clubEventTable.getValueAt(selectedEvent[0], 1);
					Event event = Database.getEvent(eventID);
					
					CreateReportFrame eventReport = new CreateReportFrame("forEvent", user);
					eventReport.setEvent(event);
					eventReport.setVisible(true);
					


				}
			}
		});
		makeReportButton.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		GroupLayout gl_clubEventPanel = new GroupLayout(clubEventPanel);
		gl_clubEventPanel.setHorizontalGroup(
			gl_clubEventPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(clubEventScrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1059, Short.MAX_VALUE)
				.addGroup(gl_clubEventPanel.createSequentialGroup()
					.addContainerGap(867, Short.MAX_VALUE)
					.addComponent(makeReportButton, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addGap(46))
		);
		gl_clubEventPanel.setVerticalGroup(
			gl_clubEventPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_clubEventPanel.createSequentialGroup()
					.addComponent(clubEventScrollPane, GroupLayout.PREFERRED_SIZE, 484, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(makeReportButton, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(11, Short.MAX_VALUE))
		);
		
		clubEventTable = new JTable();
		clubEventTable.setColumnSelectionAllowed(false);
		clubEventTable.setCellSelectionEnabled(false);
		clubEventTable.setDefaultEditor(Object.class, null);
		clubEventTable.setRowSelectionAllowed(true);
		
		DefaultTableModel clubEventTableModel = new DefaultTableModel(new Object[][] {}, new String[] {"Image", "EventID", "EventName"});
		
		clubEventTable.setModel(clubEventTableModel);
		clubEventScrollPane.setViewportView(clubEventTable);
		clubEventPanel.setLayout(gl_clubEventPanel);
		
		allEventRequestPanel = new JPanel();
		middlePanel.add(allEventRequestPanel, "name_80358929612700");
		
		eventRequestScrollPane = new JScrollPane();
		
		allRequestDescriptionPanel = new JPanel();
		allRequestDescriptionPanel.setBackground(Color.LIGHT_GRAY);
		
		clubDescriptionLabel_1 = new JLabel("Description");
		clubDescriptionLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		clubDescriptionLabel_1.setFont(new Font("OCR A Extended", Font.PLAIN, 15));
		GroupLayout gl_allRequestDescriptionPanel = new GroupLayout(allRequestDescriptionPanel);
		gl_allRequestDescriptionPanel.setHorizontalGroup(
			gl_allRequestDescriptionPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 415, Short.MAX_VALUE)
				.addGroup(gl_allRequestDescriptionPanel.createSequentialGroup()
					.addGap(129)
					.addComponent(clubDescriptionLabel_1, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
					.addGap(130))
		);
		gl_allRequestDescriptionPanel.setVerticalGroup(
			gl_allRequestDescriptionPanel.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 41, Short.MAX_VALUE)
				.addGroup(gl_allRequestDescriptionPanel.createSequentialGroup()
					.addContainerGap(15, Short.MAX_VALUE)
					.addComponent(clubDescriptionLabel_1)
					.addContainerGap())
		);
		allRequestDescriptionPanel.setLayout(gl_allRequestDescriptionPanel);
		
		eventRequestDescriptionScrollPane = new JScrollPane();
		GroupLayout gl_allEventRequestPanel = new GroupLayout(allEventRequestPanel);
		gl_allEventRequestPanel.setHorizontalGroup(
			gl_allEventRequestPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_allEventRequestPanel.createSequentialGroup()
					.addComponent(eventRequestScrollPane, GroupLayout.PREFERRED_SIZE, 644, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_allEventRequestPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(allRequestDescriptionPanel, GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
						.addComponent(eventRequestDescriptionScrollPane, GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)))
		);
		gl_allEventRequestPanel.setVerticalGroup(
			gl_allEventRequestPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(eventRequestScrollPane, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
				.addGroup(gl_allEventRequestPanel.createSequentialGroup()
					.addComponent(allRequestDescriptionPanel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addComponent(eventRequestDescriptionScrollPane, GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE))
		);
		
		eventRequestDescriptionTextArea = new JTextArea();
		eventRequestDescriptionTextArea.setLineWrap(true);
		eventRequestDescriptionTextArea.setWrapStyleWord(true);
		eventRequestDescriptionTextArea.setEditable(false);
		eventRequestDescriptionScrollPane.setViewportView(eventRequestDescriptionTextArea);
		
		eventRequestScrollPane.setViewportView(eventTable);
		allEventRequestPanel.setLayout(gl_allEventRequestPanel);
		titlePanel.setLayout(null);

		JLabel titleLabel = new JLabel("WeMeet Event Management System");
		titleLabel.setFont(new Font("OCR A Extended", Font.BOLD, 30));
		titleLabel.setBounds(286, 10, 579, 57);
		titlePanel.add(titleLabel);
		menuPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 5));

		homeLabel = new JLabel("Home");
		homeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				moveToHomeTab();
				loadEventsList();
				loadRequestEventsList();
				clearEventRequestDescriptionTextArea();
			}

		
		});
		homeLabel.setForeground(new Color(0, 0, 139));
		homeLabel.setBackground(Color.WHITE);
		homeLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		menuPanel.add(homeLabel);

		clubLabel = new JLabel("Clubs");
		clubLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				
				if (Database.isInAClub(user.getUsername())) {
					
					clubMembersLabel.setForeground(Color.DARK_GRAY);
					leaveClubLabel.setForeground(Color.DARK_GRAY);
					clubEventsLabel.setForeground(Color.DARK_GRAY);
					
				} else {
					
					clubMembersLabel.setForeground(Color.GRAY);
					leaveClubLabel.setForeground(Color.GRAY);
					clubEventsLabel.setForeground(Color.GRAY);


				}
				
				clearClubDescriptionTextArea();
				loadAllClubs();
				gotToClubTab();
			

			}
			
			private void gotToClubTab() {
				
				homeLabel.setForeground(Color.DARK_GRAY);
				clubLabel.setForeground(new Color(0, 0, 139));
				memberLabel.setForeground(Color.DARK_GRAY);
				profileLabel.setForeground(Color.DARK_GRAY);
				clubListLabel.setForeground(new Color(0, 0, 139));

				allEventRequestPanel.setVisible(false);
				allEventPanel.setVisible(false);
				clubPanel.setVisible(true);
				profilePanel.setVisible(false);
				attendeesPanel.setVisible(false);
				
				
				homeSidePanel.setVisible(false);
				clubSidePanel.setVisible(true);
				memberSidePanel.setVisible(false);
				profileSidePanel.setVisible(false);
				
			}
		});
		clubLabel.setForeground(Color.DARK_GRAY);
		clubLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		menuPanel.add(clubLabel);

		memberLabel = new JLabel("Members");
		memberLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				loadClubEventsList(eventDisplayTable);
				clearDescriptionTextArea();


				homeLabel.setForeground(Color.DARK_GRAY);
				clubLabel.setForeground(Color.DARK_GRAY);
				memberLabel.setForeground(new Color(0, 0, 139));
				profileLabel.setForeground(Color.DARK_GRAY);
				attendeesLabel.setForeground(new Color(0, 0, 139));

				attendeesPanel.setVisible(true);
				allEventRequestPanel.setVisible(false);
				allEventPanel.setVisible(false);
				clubPanel.setVisible(false);
				profilePanel.setVisible(false);
				clubMembersPanel.setVisible(false);
				clubEventPanel.setVisible(false);


				homeSidePanel.setVisible(false);
				clubSidePanel.setVisible(false);
				memberSidePanel.setVisible(true);
				profileSidePanel.setVisible(false);

			}
		});
		memberLabel.setForeground(Color.DARK_GRAY);
		memberLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		menuPanel.add(memberLabel);

		profileLabel = new JLabel("Profile");
		profileLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				homeLabel.setForeground(Color.DARK_GRAY);
				clubLabel.setForeground(Color.DARK_GRAY);
				memberLabel.setForeground(Color.DARK_GRAY);
				profileLabel.setForeground(new Color(0, 0, 139));

				allEventRequestPanel.setVisible(false);
				allEventPanel.setVisible(false);
				clubPanel.setVisible(false);
				profilePanel.setVisible(true);
				clubEventPanel.setVisible(false);


				homeSidePanel.setVisible(false);
				clubSidePanel.setVisible(false);
				memberSidePanel.setVisible(false);
				profileSidePanel.setVisible(true);
				attendeesPanel.setVisible(false);


			}
		});
		profileLabel.setForeground(Color.DARK_GRAY);
		profileLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		menuPanel.add(profileLabel);

		logoutLabel = new JLabel("Log Out");
		logoutLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", "Confirmation",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

				if (response == JOptionPane.YES_OPTION) {

					homeLabel.setForeground(Color.DARK_GRAY);
					clubLabel.setForeground(Color.DARK_GRAY);
					memberLabel.setForeground(Color.DARK_GRAY);
					profileLabel.setForeground(Color.DARK_GRAY);
					logoutLabel.setForeground(new Color(0, 0, 139));

					dispose();
					LoginFrame.getFrame().setVisible(true);

				} else {

					homeLabel.setForeground(new Color(0, 0, 139));
					clubLabel.setForeground(Color.DARK_GRAY);
					memberLabel.setForeground(Color.DARK_GRAY);
					profileLabel.setForeground(Color.DARK_GRAY);
					logoutLabel.setForeground(Color.DARK_GRAY);

				}

			}
		});
		logoutLabel.setForeground(Color.DARK_GRAY);
		logoutLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		menuPanel.add(logoutLabel);
		getContentPane().setLayout(groupLayout);
		moveToHomeTab();
		
	}



	private void moveToHomeTab() {
		
		// Moves to Home tab while disabling other tabs and panels
		homeLabel.setForeground(new Color(0, 0, 139));
		clubLabel.setForeground(Color.DARK_GRAY);
		memberLabel.setForeground(Color.DARK_GRAY);
		profileLabel.setForeground(Color.DARK_GRAY);

		allRequestsLabel.setForeground(new Color(0, 0, 139));
		allEventsLabel.setForeground(Color.DARK_GRAY);
		createEventLabel.setForeground(Color.DARK_GRAY);
		updateEventLabel.setForeground(Color.DARK_GRAY);
		removeEventLabel.setForeground(Color.DARK_GRAY);

		allEventRequestPanel.setVisible(true);
		clubPanel.setVisible(false);
		profilePanel.setVisible(false);
		allEventPanel.setVisible(false);
		clubMembersPanel.setVisible(false);
		clubEventPanel.setVisible(false);
		attendeesPanel.setVisible(false);
		
		homeSidePanel.setVisible(true);
		clubSidePanel.setVisible(false);
		memberSidePanel.setVisible(false);
		profileSidePanel.setVisible(false);
	}
	

	private void loadClubMembers() {
		// TODO Auto-generated method stub

		String clubName = Database.getClubName(user.getUsername());

		ArrayList<MemberInfo> clubMemList = Database.getClubMembers(clubName);
		String[] header = { "Username", "FirstName", "LastName", "Email" };

		DefaultTableModel model = new DefaultTableModel(new Object[][] {}, header);

		for (MemberInfo mem : clubMemList) {

			// DefaultTableModel model = (DefaultTableModel) HomeMenu.eventTable.getModel();
			// ImageIcon image = new ImageIcon(new
			// ImageIcon(event.getImg()).getImage().getScaledInstance(150, 150,
			// Image.SCALE_SMOOTH));
			model.addRow(new Object[] { mem.getUsername(), mem.getFirstName(), mem.getLastName(), mem.getEmail() });

		}

		clubMemberTable.setModel(model);
		// allClubTable.setRowHeight(300);
		// allClubTable.getColumnModel().getColumn(0).setCellRenderer(new
		// ImageRenderer(300));
		// allClubTable.getColumnModel().getColumn(2).setCellRenderer(new
		// MultipleLineRenderer());

	}

	public void removeSelectedRows(JTable table) {
		DefaultTableModel model = (DefaultTableModel) eventTable.getModel();

		int[] rows = table.getSelectedRows();

		if (rows.length != 0) {

			int response = JOptionPane.showConfirmDialog(null,
					"Are you sure you want to remove " + rows.length + " item?", "Confirmation",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

			if (response == JOptionPane.YES_OPTION) {

				for (int i = 0; i < rows.length; i++) {

					// System.out.println(rows[i]);
					int eventID = (int) model.getValueAt(rows[i] - i, 1);
					Database.removeEventRequest(user.getUsername(), eventID);
					model.removeRow(rows[i] - i);

				}
			}

			allRequestsLabel.setForeground(new Color(0, 0, 139));
			createEventLabel.setForeground(Color.DARK_GRAY);
			updateEventLabel.setForeground(Color.DARK_GRAY);
			removeEventLabel.setForeground(Color.DARK_GRAY);

		} else {

			JOptionPane.showMessageDialog(null, "Select events to remove!", "Information", JOptionPane.WARNING_MESSAGE);
			allRequestsLabel.setForeground(new Color(0, 0, 139));
			createEventLabel.setForeground(Color.DARK_GRAY);
			updateEventLabel.setForeground(Color.DARK_GRAY);
			removeEventLabel.setForeground(Color.DARK_GRAY);

		}

	}

	public static void loadEventAttendeesFromDatabase(int eventID, String eventName) {
		// checks attendee_Event Table from database and loads the email and status.

		System.out.println("Load method Triggered : " + eventName + " " + eventID);

		ArrayList<Object[]> attendeeList = Database.getAttendees();

		for (Object[] user : attendeeList) {

			// System.out.println((String)user[0]);
			Database.addAttendeeToEvent((String) user[0], eventID, eventName);
		}

		loadEventAttendees(eventID, eventName);
	}

	public static void loadEventAttendees(int eventID, String eventName) {
		// checks attendee_Event Table from database and loads the email and status.

		ArrayList<Object[]> attendeeList = Database.getAttendees(eventID, eventName);

		String[] header = { "Email", "Status" };

		DefaultTableModel attendeeTableModel = new DefaultTableModel(new Object[][] {}, header);

		for (Object[] user : attendeeList) {

			attendeeTableModel.addRow(user);

		}

		attendeeEmailStatusTable.setModel(attendeeTableModel);
		loadEventDetails(eventID);

	}

	public void loadRequestEventsList() {

		ArrayList<EventRequest> eventList = Database.getUserEventRequests(user.getUsername());
		String[] header = { "Image", "EventRequestID", "EventName" };

		DefaultTableModel model = new DefaultTableModel(new Object[][] {}, header);

		for (EventRequest event : eventList) {

			// DefaultTableModel model = (DefaultTableModel) HomeMenu.eventTable.getModel();
			// ImageIcon image = new ImageIcon(new
			// ImageIcon(event.getImg()).getImage().getScaledInstance(150, 150,
			// Image.SCALE_SMOOTH));
			model.addRow(new Object[] {
					
					event.getImg(), event.getEventID(), event.getEventName()
					
			});

		}

		eventTable.setModel(model);
		eventTable.setRowHeight(300);
		eventTable.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer(300));

	}

	public void loadEventsList() {

		ArrayList<Event> eventList = Database.getAllEvents();
		String[] header = { "Image", "EventID", "EventTitle" };

		DefaultTableModel model = new DefaultTableModel(new Object[][] {}, header);

		for (Event event : eventList) {


			model.addRow(new Object[] {event.getImg(), event.getEventID(), event.getEventName()} );

		}

		allEventTable.setModel(model);
		allEventTable.setRowHeight(150);
		allEventTable.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer(150));

	}
	
	public void loadClubEventsList(JTable table ) {
		
		ArrayList<Event> eventList = Database.getClubEvents(Database.getClubName(user.getUsername())); 
		String[] header = { "Image","EventID", "EventName", };

		DefaultTableModel model = new DefaultTableModel(new Object[][] {}, header);

		for (Event event : eventList) {

			// DefaultTableModel model = (DefaultTableModel) HomeMenu.eventTable.getModel();
			// ImageIcon image = new ImageIcon(new
			// ImageIcon(event.getImg()).getImage().getScaledInstance(150, 150,
			// Image.SCALE_SMOOTH));
			model.addRow(new Object[] {event.getImg(), event.getEventID(), event.getEventName()});

		}

		table.setModel(model);
		table.setRowHeight(200);
		table.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer(200));

	}
	
	

	private void loadAllClubs() {
		// Loads all clubs in a list

		ArrayList<Club> clubList = Database.getAllClubs();
		String[] header = { "Image", "Name" };

		DefaultTableModel model = new DefaultTableModel(new Object[][] {}, header);

		for (Club club : clubList) {

			model.addRow(new Object[] { club.getImg(), club.getName() });

		}

		allClubTable.setModel(model);
		allClubTable.setRowHeight(300);
		allClubTable.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer(300));

	}


	/*
	protected void loadEventDisplayTable() {
		// displays event table

		String clubName = Database.getClubName(user.getUsername());
		
		ArrayList<Event> eventList = Database.getClubEvents(clubName);
		String[] header = { "Image", "EventID", "EventName" };

		DefaultTableModel model = new DefaultTableModel(new Object[][] {}, header);

		for (Event event : eventList) {


			model.addRow(new Object[] {

					event.getImg(), event.getEventID(), event.getEventName()

			});

		}

		eventDisplayTable.setModel(model);
		eventDisplayTable.setRowHeight(150);
		eventDisplayTable.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer(150));
		eventDisplayTable.getColumnModel().getColumn(2).setCellRenderer(new MultipleLineRenderer());
	//	eventDisplayTable.getColumnModel().getColumn(3).setCellRenderer(new MultipleLineRenderer());

	}	*/
	
	protected static void loadEventRequestDetails(int eventID) {
		// set Description of selected Event Request
		
		EventRequest event = Database.getEventReq(eventID);
		eventRequestDescriptionTextArea.setText((String)event.getDetails() + "\nApproval: " + event.getApproval());
		
	}
	
	protected void loadEventDetail(int eventID) {
		// Set description of the selected event
		
		Event event = Database.getEvent(eventID);
		eventDescriptionTextArea.setText((String)event.getDetails()); 
		
	}
	
	protected static void loadEventDetails(int eventID) {
		// Set description of the selected event	
		//setText
		Event event = Database.getEvent(eventID);
		descriptionTextArea.setText((String)event.getDetails()); 
		
		
	}
	
	protected static void loadClubDetails(String clubName) {
		// Set description of the selected Club
		// setText
		Club club = Database.getClub(clubName);
		clubDescriptionTextArea.setText((String) club.getDescription() + "\nNumber of Member: " + club.getNumMembers());

	}
	
	public static void clearEventRequestDescriptionTextArea() {

		eventRequestDescriptionTextArea.setText("");

	}
	
	public static void clearClubDescriptionTextArea() {

		clubDescriptionTextArea.setText("");

	}
	
	public static void clearDescriptionTextArea() {
		
		descriptionTextArea.setText(""); 

	}
	
	public static void clearEventDetail() {
		
		eventDescriptionTextArea.setText("");
	}
	
	public void setUser(MemberInfo user) {

		UserLabel.setText(user.getUsername());
		firstNameTextField.setText(user.getFirstName());
		lastNameTextField.setText(user.getLastName());
		usernameTextField.setText(user.getUsername());
		emailTextField.setText(user.getEmail());
		this.user = user;
	}

	// Renders image when called
	private class ImageRenderer implements TableCellRenderer {

		int scale;

		public ImageRenderer(int scale) {

			this.scale = scale;
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {

			byte[] photoName = (byte[]) value;
			ImageIcon imageIcon = new ImageIcon(
					new ImageIcon(photoName).getImage().getScaledInstance(this.scale, this.scale, Image.SCALE_DEFAULT));
			JLabel label = new JLabel(imageIcon);
			label.setOpaque(true);

			if (isSelected) {

				label.setBackground(table.getSelectionBackground());

				if (hasFocus)
					label.setBorder(new LineBorder(new Color(65, 105, 225)));

			} else {

				// label.setOpaque(false);
				label.setBackground(table.getBackground());
				label.setBorder(new LineBorder(table.getBackground()));

			}

			return label;
		}

	}


	private class MultipleLineRenderer implements TableCellRenderer {

		JLabel text = new JLabel();

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {


			if (value == null)
				return null;
			// text.setText(value != null ? value.toString() : "");
			text.setText((String) value);
			text.setToolTipText(value != null ? value.toString() : "");
			text.setOpaque(true);

			if (isSelected) {

				text.setBackground(table.getSelectionBackground());

				if (hasFocus)
					text.setBorder(new LineBorder(new Color(65, 105, 225)));

			} else {

				text.setBackground(table.getBackground());
				text.setBorder(new LineBorder(table.getBackground()));

			}

			return text;
		}

	}
}
