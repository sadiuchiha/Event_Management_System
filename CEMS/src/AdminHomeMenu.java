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
import java.awt.ScrollPane;

import javax.swing.AbstractCellEditor;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;

import java.awt.SystemColor;
import java.awt.TextArea;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileFilter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminHomeMenu extends JFrame {

	String report;
	private JLabel homeLabel;
	private JLabel requestsLabel;
	private JLabel clubLabel;
	private JLabel memberLabel;
	private JLabel profileLabel;
	private JLabel logoutLabel;
	private JPanel eventRequestTablePanel;
	private JPanel clubMemberPanel;
	private JPanel membersPanel;
	private JPanel profilePanel;
	private JPanel homeSidePanel;
	private JLabel welcomeLabel;
	private JLabel UserLabel;
	static JLabel allEventsLabel;
	static JLabel createEventLabel;
	static JLabel updateEventLabel;
	static JLabel removeEventLabel;
	private JPanel requestSidePanel;
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
	private JLabel passAdminLabel;
	private JLabel profileHeading;
	private JLabel memberHeading;
	private JLabel usersLabel;
	private JLabel eventRequestLabel;
	private JLabel clubRequestLabel;
	private JPanel updatePasswordPanel;
	private JLabel newPasswordLabel;
	private JLabel confirmPasswordLabel;
	private JPasswordField confirmPasswordTextField;
	private JPasswordField newPasswordTextField;
	private JPanel passAdminPanel;
	private MemberInfo user;
	private JPanel clubRequestTablePanel;
	private JScrollPane eventRequestScrollPanel;
	private JTable eventRequestTable;
	private JScrollPane clubRequestScrollPanel;
	private JButton acceptClubReqButton;
	private JButton denyClubRequestButton;
	private JTable clubRequestTable;
	private JTextField passAdminEmailTextField;
	static JTable allClubTable;
	static JLabel removeClub;
	static JLabel allClubs;
	static JLabel createClubLabel;
	static JPanel AllClubPanel;
	static JLabel attendeesLabel;
	private JTable membersTable;
	static JPanel attendeePanel;
	private JScrollPane emailAndStatusScrollPane;
	private JScrollPane eventScrollPanel;
	private static JTable attendeeEmailStatusTable;
	private JTable eventDisplayTable;
	private JButton addAttendeeButton;
	private JButton sendInviteToEventButton;
	private JButton sendInviteAllButton;
	private JLabel createReportLabel;
	private JLabel createEventReportLabel;
	private JLabel clubMembersLabel;
	private JPanel clubAndClubMemberPanel;
	private JTable clubListTable;
	private JTable clubMembersTable;
	private JPanel descriptionPanel;
	private static JTextArea clubDescriptionTextArea;
	private static JTextArea eventRequestTextArea;
	private static JTextArea eventDescriptionTextArea;
	static EventPanel homePanel = new EventPanel();
	static JTable eventTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHomeMenu frame = new AdminHomeMenu();
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
	public AdminHomeMenu() {

		ImageIcon logoImage = new ImageIcon("src/resource/weMeetLogo.png");
		setIconImage(logoImage.getImage());
		eventTable = homePanel.eventTable;
		getContentPane().setBackground(SystemColor.activeCaption);
		setTitle("Admin Home");
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
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup()
				.addComponent(LeftSideHomePanel, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup().addComponent(menuPanel,
								GroupLayout.PREFERRED_SIZE, 598, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING,
								groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup().addComponent(titlePanel,
														GroupLayout.DEFAULT_SIZE, 1059, Short.MAX_VALUE))
												.addGroup(groupLayout.createSequentialGroup().addComponent(middlePanel,
														GroupLayout.PREFERRED_SIZE, 1059, Short.MAX_VALUE)))))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
						.addComponent(menuPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
						.addComponent(middlePanel, GroupLayout.PREFERRED_SIZE, 534, GroupLayout.PREFERRED_SIZE))
				.addComponent(LeftSideHomePanel, GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE));
		LeftSideHomePanel.setLayout(new CardLayout(0, 0));

		homeSidePanel = new JPanel();
		homeSidePanel.setBackground(Color.LIGHT_GRAY);
		LeftSideHomePanel.add(homeSidePanel, "name_325461259392700");
		homeSidePanel.setLayout(null);

		welcomeLabel = new JLabel("Welcome!");
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setForeground(Color.BLACK);
		welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		welcomeLabel.setBounds(32, 84, 177, 22);
		homeSidePanel.add(welcomeLabel);

		UserLabel = new JLabel("User");
		UserLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		UserLabel.setHorizontalAlignment(SwingConstants.CENTER);
		UserLabel.setForeground(Color.BLACK);
		UserLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		UserLabel.setBounds(32, 107, 177, 30);
		homeSidePanel.add(UserLabel);

		allEventsLabel = new JLabel("All Events");
		allEventsLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				allEventsLabel.setForeground(new Color(0, 0, 139));
				createEventReportLabel.setForeground(Color.DARK_GRAY);
				createEventLabel.setForeground(Color.DARK_GRAY);
				updateEventLabel.setForeground(Color.DARK_GRAY);
				removeEventLabel.setForeground(Color.DARK_GRAY);

				homePanel.loadEventsList();
			}
		});
		allEventsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		allEventsLabel.setForeground(new Color(0, 0, 139));
		allEventsLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		allEventsLabel.setBounds(32, 268, 177, 22);
		homeSidePanel.add(allEventsLabel);

		createEventLabel = new JLabel("Create event");
		createEventLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				allEventsLabel.setForeground(Color.DARK_GRAY);
				createEventReportLabel.setForeground(Color.DARK_GRAY);
				createEventLabel.setForeground(new Color(0, 0, 139));
				updateEventLabel.setForeground(Color.DARK_GRAY);
				removeEventLabel.setForeground(Color.DARK_GRAY);

				CreateEventFrame createEventFrame = new CreateEventFrame();
				createEventFrame.setUser(user);
				createEventFrame.setVisible(true);

			}
		});
		createEventLabel.setHorizontalAlignment(SwingConstants.CENTER);
		createEventLabel.setForeground(Color.DARK_GRAY);
		createEventLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		createEventLabel.setBounds(32, 348, 177, 22);
		homeSidePanel.add(createEventLabel);

		updateEventLabel = new JLabel("Update event");
		updateEventLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				allEventsLabel.setForeground(Color.DARK_GRAY);
				createEventReportLabel.setForeground(Color.DARK_GRAY);
				createEventLabel.setForeground(Color.DARK_GRAY);
				updateEventLabel.setForeground(new Color(0, 0, 139));
				removeEventLabel.setForeground(Color.DARK_GRAY);

				// get only 1 selected row, if more show message and if zero show another
				// message.
				int[] row = eventTable.getSelectedRows();

				if (row.length > 1) {

					JOptionPane.showMessageDialog(null, "Select 1 event at a time to update", "Information",
							JOptionPane.WARNING_MESSAGE);
					allEventsLabel.setForeground(new Color(0, 0, 139));
					createEventReportLabel.setForeground(Color.DARK_GRAY);
					createEventLabel.setForeground(Color.DARK_GRAY);
					updateEventLabel.setForeground(Color.DARK_GRAY);
					removeEventLabel.setForeground(Color.DARK_GRAY);
				}
				if (row.length < 1) {

					JOptionPane.showMessageDialog(null, "No event is selected to update", "Information",
							JOptionPane.WARNING_MESSAGE);
					allEventsLabel.setForeground(new Color(0, 0, 139));
					createEventReportLabel.setForeground(Color.DARK_GRAY);
					createEventLabel.setForeground(Color.DARK_GRAY);
					updateEventLabel.setForeground(Color.DARK_GRAY);
					removeEventLabel.setForeground(Color.DARK_GRAY);
				}

				else {

					// get the events from the table

					DefaultTableModel model = (DefaultTableModel) eventTable.getModel();

					Event event = Database.getEvent((int) model.getValueAt(row[0], 1));
					// create UpdateEventFrame

					UpdateEventFrame updateEventFrame = new UpdateEventFrame(event);
					updateEventFrame.setVisible(true);
					// pass event

				}
			}
		});

		updateEventLabel.setHorizontalAlignment(SwingConstants.CENTER);
		updateEventLabel.setForeground(Color.DARK_GRAY);
		updateEventLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		updateEventLabel.setBounds(32, 391, 177, 22);
		homeSidePanel.add(updateEventLabel);

		removeEventLabel = new JLabel("Remove event");
		removeEventLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				allEventsLabel.setForeground(Color.DARK_GRAY);
				createEventLabel.setForeground(Color.DARK_GRAY);
				updateEventLabel.setForeground(Color.DARK_GRAY);
				createEventReportLabel.setForeground(Color.DARK_GRAY);
				removeEventLabel.setForeground(new Color(0, 0, 139));

				removeSelectedRows(eventTable);

			}
		});
		removeEventLabel.setHorizontalAlignment(SwingConstants.CENTER);
		removeEventLabel.setForeground(Color.DARK_GRAY);
		removeEventLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		removeEventLabel.setBounds(32, 433, 177, 22);
		homeSidePanel.add(removeEventLabel);

		createEventReportLabel = new JLabel("Create Report");
		createEventReportLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				int[] selectedEvent = eventTable.getSelectedRows();

				allEventsLabel.setForeground(Color.DARK_GRAY);
				createEventLabel.setForeground(Color.DARK_GRAY);
				updateEventLabel.setForeground(Color.DARK_GRAY);
				createEventReportLabel.setForeground(new Color(0, 0, 139));
				removeEventLabel.setForeground(Color.DARK_GRAY);

				if (selectedEvent.length < 1) {

					JOptionPane.showMessageDialog(null, "Select an event to make report of!", "Error",
							JOptionPane.ERROR_MESSAGE);

				} else if (selectedEvent.length > 1) {

					JOptionPane.showMessageDialog(null, "Select only 1 event to make report of!", "Error",
							JOptionPane.ERROR_MESSAGE);

				} else {

					int eventID = (int) eventTable.getValueAt(selectedEvent[0], 1);
					Event event = Database.getEvent(eventID);

					CreateReportFrame eventReport = new CreateReportFrame("forEvent", user);
					eventReport.setEvent(event);
					eventReport.setVisible(true);

				}

				allEventsLabel.setForeground(new Color(0, 0, 139));
				createEventLabel.setForeground(Color.DARK_GRAY);
				updateEventLabel.setForeground(Color.DARK_GRAY);
				createEventReportLabel.setForeground(Color.DARK_GRAY);
				removeEventLabel.setForeground(Color.DARK_GRAY);
			}
		});
		createEventReportLabel.setHorizontalAlignment(SwingConstants.CENTER);
		createEventReportLabel.setForeground(Color.DARK_GRAY);
		createEventReportLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		createEventReportLabel.setBounds(32, 307, 177, 22);
		homeSidePanel.add(createEventReportLabel);

		requestSidePanel = new JPanel();
		requestSidePanel.setBackground(Color.LIGHT_GRAY);
		LeftSideHomePanel.add(requestSidePanel, "name_326619715666700");
		requestSidePanel.setLayout(null);

		JLabel requestHeading = new JLabel("Requests");
		requestHeading.setForeground(Color.BLACK);
		requestHeading.setHorizontalAlignment(SwingConstants.CENTER);
		requestHeading.setFont(new Font("OCR A Extended", Font.BOLD, 25));
		requestHeading.setBounds(43, 53, 147, 39);
		requestSidePanel.add(requestHeading);

		eventRequestLabel = new JLabel("Event Requests");
		eventRequestLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				eventRequestLabel.setForeground(new Color(0, 0, 139));
				clubRequestLabel.setForeground(Color.DARK_GRAY);
				loadAllEventRequest();
				eventRequestTablePanel.setVisible(true);
				clubRequestTablePanel.setVisible(false);

			}
		});
		eventRequestLabel.setHorizontalAlignment(SwingConstants.CENTER);
		eventRequestLabel.setForeground(new Color(0, 0, 139));
		eventRequestLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		eventRequestLabel.setBounds(21, 264, 203, 22);
		requestSidePanel.add(eventRequestLabel);

		clubRequestLabel = new JLabel("Club Requests");
		clubRequestLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				eventRequestLabel.setForeground(Color.DARK_GRAY);
				clubRequestLabel.setForeground(new Color(0, 0, 139));

				loadAllClubRequest();

				clubRequestTablePanel.setVisible(true);
				eventRequestTablePanel.setVisible(false);

			}
		});
		clubRequestLabel.setHorizontalAlignment(SwingConstants.CENTER);
		clubRequestLabel.setForeground(Color.DARK_GRAY);
		clubRequestLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		clubRequestLabel.setBounds(21, 310, 203, 22);
		requestSidePanel.add(clubRequestLabel);

		clubSidePanel = new JPanel();
		clubSidePanel.setBackground(Color.LIGHT_GRAY);
		LeftSideHomePanel.add(clubSidePanel, "name_326622622249300");
		clubSidePanel.setLayout(null);

		JLabel lblClubs = new JLabel("Clubs");
		lblClubs.setForeground(Color.BLACK);
		lblClubs.setHorizontalAlignment(SwingConstants.CENTER);
		lblClubs.setFont(new Font("OCR A Extended", Font.BOLD, 25));
		lblClubs.setBounds(36, 53, 147, 39);
		clubSidePanel.add(lblClubs);

		createClubLabel = new JLabel("Create Club");
		createClubLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				allClubs.setForeground(Color.DARK_GRAY);
				createClubLabel.setForeground(new Color(0, 0, 139));
				removeClub.setForeground(Color.DARK_GRAY);
				createReportLabel.setForeground(Color.DARK_GRAY);

				CreateClubFrame createClubFrame = new CreateClubFrame();
				createClubFrame.setVisible(true);

			}
		});
		createClubLabel.setHorizontalAlignment(SwingConstants.CENTER);
		createClubLabel.setForeground(Color.DARK_GRAY);
		createClubLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		createClubLabel.setBounds(36, 347, 177, 22);
		clubSidePanel.add(createClubLabel);

		removeClub = new JLabel("Remove Club");
		removeClub.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				allClubs.setForeground(Color.DARK_GRAY);
				createClubLabel.setForeground(Color.DARK_GRAY);
				removeClub.setForeground(new Color(0, 0, 139));
				createReportLabel.setForeground(Color.DARK_GRAY);

				removeSelectedclub(allClubTable);
			}
		});
		removeClub.setHorizontalAlignment(SwingConstants.CENTER);
		removeClub.setForeground(Color.DARK_GRAY);
		removeClub.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		removeClub.setBounds(36, 391, 177, 22);
		clubSidePanel.add(removeClub);

		allClubs = new JLabel("All Clubs");
		allClubs.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				allClubs.setForeground(new Color(0, 0, 139));
				createClubLabel.setForeground(Color.DARK_GRAY);
				removeClub.setForeground(Color.DARK_GRAY);
				createReportLabel.setForeground(Color.DARK_GRAY);

				AllClubPanel.setVisible(true);

				loadAllClubs();
			}
		});
		allClubs.setHorizontalAlignment(SwingConstants.CENTER);
		allClubs.setForeground(new Color(0, 0, 139));
		allClubs.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		allClubs.setBounds(36, 259, 177, 22);
		clubSidePanel.add(allClubs);

		createReportLabel = new JLabel("Create Report");
		createReportLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				allClubs.setForeground(Color.DARK_GRAY);
				createClubLabel.setForeground(Color.DARK_GRAY);
				removeClub.setForeground(Color.DARK_GRAY);
				createReportLabel.setForeground(new Color(0, 0, 139));

				int[] getSelectedClub = allClubTable.getSelectedRows();

				if (getSelectedClub.length < 1) {

					JOptionPane.showMessageDialog(null, "No club is selected to make report of!", "Information",
							JOptionPane.WARNING_MESSAGE);

				} else if (getSelectedClub.length > 1) {

					JOptionPane.showMessageDialog(null, "Select only 1 Club to make report of!", "Information",
							JOptionPane.WARNING_MESSAGE);

				} else {

					Club club = Database.getClub((String) allClubTable.getValueAt(getSelectedClub[0], 1));

					CreateReportFrame eventReport = new CreateReportFrame("forClub", user);
					eventReport.setClub(club);
					eventReport.setVisible(true);
				}

				allClubs.setForeground(new Color(0, 0, 139));
				createClubLabel.setForeground(Color.DARK_GRAY);
				removeClub.setForeground(Color.DARK_GRAY);
				createReportLabel.setForeground(Color.DARK_GRAY);

			}
		});
		createReportLabel.setHorizontalAlignment(SwingConstants.CENTER);
		createReportLabel.setForeground(Color.DARK_GRAY);
		createReportLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		createReportLabel.setBounds(36, 303, 177, 22);
		clubSidePanel.add(createReportLabel);

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

		usersLabel = new JLabel("Users");
		usersLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				usersLabel.setForeground(new Color(0, 0, 139));
				attendeesLabel.setForeground(Color.DARK_GRAY);
				clubMembersLabel.setForeground(Color.DARK_GRAY);

				membersPanel.setVisible(true);
				attendeePanel.setVisible(false);
				clubMemberPanel.setVisible(false);

				loadUserList();

			}
		});
		usersLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usersLabel.setForeground(Color.DARK_GRAY);
		usersLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		usersLabel.setBounds(10, 244, 203, 22);
		memberSidePanel.add(usersLabel);

		attendeesLabel = new JLabel("Attendees");
		attendeesLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				loadEventDisplayTable();

				usersLabel.setForeground(Color.DARK_GRAY);
				attendeesLabel.setForeground(new Color(0, 0, 139));
				clubMembersLabel.setForeground(Color.DARK_GRAY);

				membersPanel.setVisible(false);
				attendeePanel.setVisible(true);
				clubMemberPanel.setVisible(false);

			}
		});
		attendeesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		attendeesLabel.setForeground(Color.DARK_GRAY);
		attendeesLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		attendeesLabel.setBounds(10, 287, 203, 22);
		memberSidePanel.add(attendeesLabel);

		clubMembersLabel = new JLabel("Club Members");
		clubMembersLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				usersLabel.setForeground(Color.DARK_GRAY);
				attendeesLabel.setForeground(Color.DARK_GRAY);
				clubMembersLabel.setForeground(new Color(0, 0, 139));

				clubMemberPanel.setVisible(true);
				membersPanel.setVisible(false);
				attendeePanel.setVisible(false);
				loadClubList();

			}
		});
		clubMembersLabel.setHorizontalAlignment(SwingConstants.CENTER);
		clubMembersLabel.setForeground(Color.DARK_GRAY);
		clubMembersLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		clubMembersLabel.setBounds(10, 327, 203, 28);
		memberSidePanel.add(clubMembersLabel);

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
				passAdminLabel.setForeground(Color.DARK_GRAY);

				profilePanel.setVisible(true);
				updatePasswordPanel.setVisible(false);
				passAdminPanel.setVisible(false);

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
				passAdminLabel.setForeground(Color.DARK_GRAY);

				profilePanel.setVisible(false);
				updatePasswordPanel.setVisible(true);
				passAdminPanel.setVisible(false);

			}
		});
		updatePasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		updatePasswordLabel.setForeground(Color.DARK_GRAY);
		updatePasswordLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		updatePasswordLabel.setBounds(10, 306, 203, 22);
		profileSidePanel.add(updatePasswordLabel);

		passAdminLabel = new JLabel("Pass Admin");
		passAdminLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				infoLabel.setForeground(Color.DARK_GRAY);
				updatePasswordLabel.setForeground(Color.DARK_GRAY);
				passAdminLabel.setForeground(new Color(0, 0, 139));

				profilePanel.setVisible(false);
				updatePasswordPanel.setVisible(false);
				passAdminPanel.setVisible(true);

			}
		});
		passAdminLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passAdminLabel.setForeground(Color.DARK_GRAY);
		passAdminLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		passAdminLabel.setBounds(10, 349, 203, 22);
		profileSidePanel.add(passAdminLabel);

		profileHeading = new JLabel("Profile");
		profileHeading.setHorizontalAlignment(SwingConstants.CENTER);
		profileHeading.setForeground(Color.BLACK);
		profileHeading.setFont(new Font("OCR A Extended", Font.BOLD, 25));
		profileHeading.setBounds(21, 63, 168, 22);
		profileSidePanel.add(profileHeading);

		homePanel.loadEventsList();
		middlePanel.setLayout(new CardLayout(0, 0));

		eventRequestTablePanel = new JPanel();
		middlePanel.add(eventRequestTablePanel, "name_324053608496100");

		eventRequestScrollPanel = new JScrollPane();

		JButton approveReqeustButton = new JButton("Approve");
		approveReqeustButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int[] rows = eventRequestTable.getSelectedRows();
				DefaultTableModel eventReqModel = (DefaultTableModel) eventRequestTable.getModel();

				if (rows.length < 1) {

					JOptionPane.showMessageDialog(null, "No event is selected to approve", "Information",
							JOptionPane.WARNING_MESSAGE);

				} else {

					int response = JOptionPane.showConfirmDialog(null,
							"Are you sure you want to approve " + rows.length + " event request?", "Confirmation",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (response == JOptionPane.YES_OPTION) {

						for (int i = 0; i < rows.length; i++) {

							System.out.println(rows[i]);
							int eventReqID = (int) eventReqModel.getValueAt(rows[i] - i, 1);

							Database.approveEventReq(eventReqID);

							EventRequest event = Database.getEventReq(eventReqID);
							Database.addEvent(event);
							Database.addEventAndCreators(event);
							eventReqModel.removeRow(rows[i] - i);

							loadAllEventRequest();
							homePanel.loadEventsList();
							clearEventRequestDescriptionTextArea();
						}
					}
				}

			}
		});

		JButton denyRequestButton = new JButton("Deny");
		denyRequestButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int[] rows = eventRequestTable.getSelectedRows();
				DefaultTableModel eventReqModel = (DefaultTableModel) eventRequestTable.getModel();

				if (rows.length < 1) {

					JOptionPane.showMessageDialog(null, "No event is selected to disapprove", "Information",
							JOptionPane.WARNING_MESSAGE);

				} else {

					int response = JOptionPane.showConfirmDialog(null,
							"Are you sure you want to disapprove " + rows.length + " event request?", "Confirmation",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (response == JOptionPane.YES_OPTION) {

						for (int i = 0; i < rows.length; i++) {

							// System.out.println(rows[i]);
							int eventReqID = (int) eventReqModel.getValueAt(rows[i] - i, 1);
							Database.denyEventReq(eventReqID);
							eventReqModel.removeRow(rows[i] - i);

							loadAllEventRequest();
							homePanel.loadEventsList();
							clearEventRequestDescriptionTextArea();

						}
					}
				}

			}
		});

		JScrollPane detailScrollPane = new JScrollPane();

		JPanel eventRequestDescriptionPanel = new JPanel();
		eventRequestDescriptionPanel.setBackground(Color.LIGHT_GRAY);

		JLabel eventRequestDescriptionLabel = new JLabel("Description");
		eventRequestDescriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		eventRequestDescriptionLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 15));
		GroupLayout gl_eventRequestDescriptionPanel = new GroupLayout(eventRequestDescriptionPanel);
		gl_eventRequestDescriptionPanel.setHorizontalGroup(
			gl_eventRequestDescriptionPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_eventRequestDescriptionPanel.createSequentialGroup()
					.addGap(139)
					.addComponent(eventRequestDescriptionLabel, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
					.addGap(120))
		);
		gl_eventRequestDescriptionPanel.setVerticalGroup(
			gl_eventRequestDescriptionPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_eventRequestDescriptionPanel.createSequentialGroup()
					.addGap(18)
					.addComponent(eventRequestDescriptionLabel)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		eventRequestDescriptionPanel.setLayout(gl_eventRequestDescriptionPanel);
		GroupLayout gl_eventRequestTablePanel = new GroupLayout(eventRequestTablePanel);
		gl_eventRequestTablePanel.setHorizontalGroup(gl_eventRequestTablePanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_eventRequestTablePanel.createSequentialGroup().addContainerGap(785, Short.MAX_VALUE)
						.addComponent(denyRequestButton, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(approveReqeustButton, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
						.addGap(40))
				.addGroup(Alignment.LEADING, gl_eventRequestTablePanel.createSequentialGroup()
						.addComponent(eventRequestScrollPanel, GroupLayout.PREFERRED_SIZE, 558,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_eventRequestTablePanel.createParallelGroup(Alignment.LEADING)
								.addComponent(detailScrollPane, GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
								.addComponent(eventRequestDescriptionPanel, GroupLayout.DEFAULT_SIZE, 495,
										Short.MAX_VALUE))));
		gl_eventRequestTablePanel.setVerticalGroup(gl_eventRequestTablePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_eventRequestTablePanel.createSequentialGroup().addGroup(gl_eventRequestTablePanel
						.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_eventRequestTablePanel.createSequentialGroup()
								.addComponent(eventRequestDescriptionPanel, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(detailScrollPane, GroupLayout.PREFERRED_SIZE, 440,
										GroupLayout.PREFERRED_SIZE))
						.addComponent(eventRequestScrollPanel, GroupLayout.PREFERRED_SIZE, 492,
								GroupLayout.PREFERRED_SIZE))
						.addGap(10)
						.addGroup(gl_eventRequestTablePanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(approveReqeustButton, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
								.addComponent(denyRequestButton, GroupLayout.PREFERRED_SIZE, 22,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));

		eventRequestTextArea = new JTextArea();
		eventRequestTextArea.setLineWrap(true);
		eventRequestTextArea.setWrapStyleWord(true);
		eventRequestTextArea.setEditable(false);
		detailScrollPane.setViewportView(eventRequestTextArea);

		eventRequestTable = new JTable();
		eventRequestTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				int[] getSelectedRow = eventRequestTable.getSelectedRows();

				if (getSelectedRow.length > 1)
					JOptionPane.showMessageDialog(null, "Select 1 event request at a time to show description!",
							"Information", JOptionPane.WARNING_MESSAGE);

				else {

					DefaultTableModel eventModel = (DefaultTableModel) eventRequestTable.getModel();
					int eventID = (int) eventModel.getValueAt(getSelectedRow[0], 1);
					String eventName = (String) eventModel.getValueAt(getSelectedRow[0], 2);

					System.out.println("Pressed: " + eventID + " " + eventName);
					System.out.println("Row value " + getSelectedRow[0]);

					loadEventRequestDetails(eventID);
				}

			}

		});
		eventRequestTable.setColumnSelectionAllowed(false);
		eventRequestTable.setCellSelectionEnabled(false);
		eventRequestTable.setDefaultEditor(Object.class, null);
		eventRequestTable.setRowSelectionAllowed(true);

		DefaultTableModel eventRequestTableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "IMG", "EventRequestID", "EventName" });

		eventRequestTable.setModel(eventRequestTableModel);

		loadAllEventRequest();

		eventRequestScrollPanel.setViewportView(eventRequestTable);
		eventRequestTablePanel.setLayout(gl_eventRequestTablePanel);

		clubMemberPanel = new JPanel();
		middlePanel.add(clubMemberPanel, "name_324129821657700");

		clubAndClubMemberPanel = new JPanel();

		JButton removeMemberButton = new JButton("Remove Member");
		removeMemberButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int[] rows = clubMembersTable.getSelectedRows();
				int[] clubs = clubListTable.getSelectedRows();

				String clubName = (String) clubListTable.getValueAt(clubs[0], 1);

				DefaultTableModel clubMemberTableModel = (DefaultTableModel) clubMembersTable.getModel();

				if (rows.length < 1) {

					JOptionPane.showMessageDialog(null, "No members is selected to remove", "Information",
							JOptionPane.WARNING_MESSAGE);

				} else {

					int response = JOptionPane.showConfirmDialog(null,
							"Are you sure you want to remove " + rows.length + " user from the club?", "Confirmation",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (response == JOptionPane.YES_OPTION) {

						for (int i = 0; i < rows.length; i++) {

							// System.out.println(rows[i]);
							String username = (String) clubMemberTableModel.getValueAt(rows[i] - i, 2);
							Database.removeMemberFromClub(username, clubName);
							clubMemberTableModel.removeRow(rows[i] - i);

							loadAllEventRequest();
							homePanel.loadEventsList();

						}
					}
				}

			}
		});
		removeMemberButton.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		GroupLayout gl_clubMemberPanel = new GroupLayout(clubMemberPanel);
		gl_clubMemberPanel
				.setHorizontalGroup(gl_clubMemberPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING,
								gl_clubMemberPanel.createSequentialGroup().addGap(870)
										.addComponent(removeMemberButton, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGap(116))
						.addGroup(gl_clubMemberPanel
								.createSequentialGroup().addComponent(clubAndClubMemberPanel,
										GroupLayout.PREFERRED_SIZE, 1061, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(72, Short.MAX_VALUE)));
		gl_clubMemberPanel.setVerticalGroup(gl_clubMemberPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_clubMemberPanel.createSequentialGroup()
						.addComponent(clubAndClubMemberPanel, GroupLayout.PREFERRED_SIZE, 490,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(removeMemberButton, GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE).addGap(9)));

		JScrollPane clubListScrollPane = new JScrollPane();
		JScrollPane clubMemberScrollPane = new JScrollPane();
		GroupLayout gl_clubAndClubMemberPanel = new GroupLayout(clubAndClubMemberPanel);
		gl_clubAndClubMemberPanel.setHorizontalGroup(gl_clubAndClubMemberPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_clubAndClubMemberPanel.createSequentialGroup()
						.addComponent(clubListScrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(clubMemberScrollPane, GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)));
		gl_clubAndClubMemberPanel.setVerticalGroup(gl_clubAndClubMemberPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(clubListScrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
				.addComponent(clubMemberScrollPane, GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE));

		clubMembersTable = new JTable();
		clubMembersTable.setColumnSelectionAllowed(false);
		clubMembersTable.setCellSelectionEnabled(false);
		clubMembersTable.setDefaultEditor(Object.class, null);
		clubMembersTable.setRowSelectionAllowed(true);

		DefaultTableModel clubMemberListTableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "FirstName", "LastName", "Username", "Email" });
		clubMembersTable.setModel(clubMemberListTableModel);

		clubMemberScrollPane.setViewportView(clubMembersTable);

		clubListTable = new JTable();
		clubListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				int[] selectedClub = clubListTable.getSelectedRows();

				if (selectedClub.length > 1)
					JOptionPane.showMessageDialog(null, "Select 1 Club at a time to show members of that club!",
							"Information", JOptionPane.WARNING_MESSAGE);

				else {

					DefaultTableModel clubListModel = (DefaultTableModel) clubListTable.getModel();
					String clubName = (String) clubListModel.getValueAt(selectedClub[0], 1);

					loadClubMembers(clubName);
				}

			}
		});
		clubListTable.setColumnSelectionAllowed(false);
		clubListTable.setCellSelectionEnabled(false);
		clubListTable.setDefaultEditor(Object.class, null);
		clubListTable.setRowSelectionAllowed(true);

		DefaultTableModel clubListTableModel = new DefaultTableModel(new Object[][] {}, new String[] { "Img", "Name" });
		clubListTable.setModel(clubListTableModel);

		clubListScrollPane.setViewportView(clubListTable);
		clubAndClubMemberPanel.setLayout(gl_clubAndClubMemberPanel);
		clubMemberPanel.setLayout(gl_clubMemberPanel);

		membersPanel = new JPanel();
		middlePanel.add(membersPanel, "name_324149415240600");

		JScrollPane membersScrollPane = new JScrollPane();
		GroupLayout gl_membersPanel = new GroupLayout(membersPanel);
		gl_membersPanel.setHorizontalGroup(gl_membersPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(membersScrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1059, Short.MAX_VALUE));
		gl_membersPanel.setVerticalGroup(gl_membersPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(membersScrollPane, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE));

		membersTable = new JTable();
		membersTable.setColumnSelectionAllowed(false);
		membersTable.setCellSelectionEnabled(false);
		membersTable.setDefaultEditor(Object.class, null);
		membersTable.setRowSelectionAllowed(true);

		DefaultTableModel membersTableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "MemberID", "Username", "FirstName", "LastName", "Email", "Club", "Admin" });
		membersTable.setModel(membersTableModel);

		membersScrollPane.setViewportView(membersTable);
		membersPanel.setLayout(gl_membersPanel);

		profilePanel = new JPanel();
		middlePanel.add(profilePanel, "name_324172924229000");

		profilePage = new JScrollPane();
		GroupLayout gl_profilePanel = new GroupLayout(profilePanel);
		gl_profilePanel.setHorizontalGroup(gl_profilePanel.createParallelGroup(Alignment.LEADING)
				.addComponent(profilePage, GroupLayout.PREFERRED_SIZE, 1059, GroupLayout.PREFERRED_SIZE));
		gl_profilePanel.setVerticalGroup(gl_profilePanel.createParallelGroup(Alignment.LEADING)
				.addComponent(profilePage, GroupLayout.PREFERRED_SIZE, 534, GroupLayout.PREFERRED_SIZE));

		JPanel profile = new JPanel();
		profilePage.setViewportView(profile);
		profile.setLayout(null);

		Username = new JLabel("Username");
		Username.setHorizontalAlignment(SwingConstants.CENTER);
		Username.setForeground(Color.DARK_GRAY);
		Username.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		Username.setBounds(154, 136, 177, 13);
		profile.add(Username);

		firstNameLabel = new JLabel("First Name");
		firstNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		firstNameLabel.setForeground(Color.DARK_GRAY);
		firstNameLabel.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		firstNameLabel.setBounds(154, 190, 177, 13);
		profile.add(firstNameLabel);

		lastnameLabel = new JLabel("Last Name");
		lastnameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lastnameLabel.setForeground(Color.DARK_GRAY);
		lastnameLabel.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		lastnameLabel.setBounds(154, 243, 177, 13);
		profile.add(lastnameLabel);

		emailLabel = new JLabel("Email");
		emailLabel.setHorizontalAlignment(SwingConstants.CENTER);
		emailLabel.setForeground(Color.DARK_GRAY);
		emailLabel.setFont(new Font("OCR A Extended", Font.BOLD, 18));
		emailLabel.setBounds(154, 290, 177, 13);
		profile.add(emailLabel);

		usernameTextField = new JTextField();
		usernameTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		usernameTextField.setBounds(341, 127, 260, 28);
		profile.add(usernameTextField);
		usernameTextField.setColumns(10);

		firstNameTextField = new JTextField();
		firstNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		firstNameTextField.setColumns(10);
		firstNameTextField.setBounds(341, 181, 260, 28);
		profile.add(firstNameTextField);

		lastNameTextField = new JTextField();
		lastNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lastNameTextField.setColumns(10);
		lastNameTextField.setBounds(341, 234, 260, 28);
		profile.add(lastNameTextField);

		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		emailTextField.setColumns(10);
		emailTextField.setBounds(341, 281, 260, 28);
		profile.add(emailTextField);

		JButton infoUpdateButton = new JButton("Update");
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
		infoUpdateButton.setBounds(795, 440, 155, 28);
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

		passAdminPanel = new JPanel();
		middlePanel.add(passAdminPanel, "name_3867426941800");

		JLabel passAdminEmailLabel = new JLabel("Email");
		passAdminEmailLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));

		passAdminEmailTextField = new JTextField();
		passAdminEmailTextField.setColumns(10);

		JButton passAdminButton = new JButton("Pass Admin");
		passAdminButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String email = passAdminEmailTextField.getText();

				if (email.equals(""))
					JOptionPane.showMessageDialog(null, "Enter an email to pass Admin", "Error",
							JOptionPane.ERROR_MESSAGE);

				else if (!RegisterFrame.verifyEmailAddress(email))
					JOptionPane.showMessageDialog(null, "Invalid email Address!", "Error", JOptionPane.ERROR_MESSAGE);

				else {

					Database.passAdmin(email);
				}

			}
		});
		passAdminButton.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		GroupLayout gl_passAdminPanel = new GroupLayout(passAdminPanel);
		gl_passAdminPanel.setHorizontalGroup(gl_passAdminPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_passAdminPanel.createSequentialGroup().addGap(288).addGroup(gl_passAdminPanel
						.createParallelGroup(Alignment.TRAILING).addComponent(passAdminButton)
						.addGroup(gl_passAdminPanel.createSequentialGroup()
								.addComponent(passAdminEmailLabel, GroupLayout.PREFERRED_SIZE, 72,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(passAdminEmailTextField, GroupLayout.PREFERRED_SIZE, 243,
										GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(448, Short.MAX_VALUE)));
		gl_passAdminPanel.setVerticalGroup(gl_passAdminPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_passAdminPanel.createSequentialGroup().addGap(157)
						.addGroup(gl_passAdminPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(passAdminEmailLabel, GroupLayout.PREFERRED_SIZE, 29,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(passAdminEmailTextField, GroupLayout.PREFERRED_SIZE, 28,
										GroupLayout.PREFERRED_SIZE))
						.addGap(36).addComponent(passAdminButton).addContainerGap(291, Short.MAX_VALUE)));
		passAdminPanel.setLayout(gl_passAdminPanel);

		clubRequestTablePanel = new JPanel();
		middlePanel.add(clubRequestTablePanel, "name_5126217564000");

		clubRequestScrollPanel = new JScrollPane();

		acceptClubReqButton = new JButton("Accept");
		acceptClubReqButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// aprroves

				int[] rows = clubRequestTable.getSelectedRows();

				if (rows.length != 0) {

					int response = JOptionPane.showConfirmDialog(null,
							"Are you sure you want to accept " + rows.length + " user?", "Confirmation",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (response == JOptionPane.YES_OPTION) {

						for (int i = 0; i < rows.length; i++) {

							// System.out.println(rows[i]);
							String email = (String) clubRequestTable.getModel().getValueAt(rows[i] - i, 3);
							String clubName = (String) clubRequestTable.getModel().getValueAt(rows[i] - i, 4);

							MemberInfo userFromRequest = Database.getMemberInfo(email);
							Database.addMemberToClubList(userFromRequest, clubName);
							Database.removeClubRequest(userFromRequest.getUsername());

							// Send mail for acceptance in the club

							((DefaultTableModel) clubRequestTable.getModel()).removeRow(rows[i] - i);
							loadAllClubs();

						}
					}
				}

				else {

					JOptionPane.showMessageDialog(null, "Select a row to accept!", "Information",
							JOptionPane.INFORMATION_MESSAGE);
				}

				// Database.addMemberToClubList(userFromRequest, clubName);

				// delete request
				// add to club -> increment clubmember
				// allow create event.

			}
		});

		denyClubRequestButton = new JButton("Deny");
		denyClubRequestButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int[] rows = clubRequestTable.getSelectedRows();

				if (rows.length != 0) {

					int response = JOptionPane.showConfirmDialog(null,
							"Are you sure you want to decline " + rows.length + " user?", "Confirmation",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (response == JOptionPane.YES_OPTION) {

						for (int i = 0; i < rows.length; i++) {

							// System.out.println(rows[i]);
							String email = (String) clubRequestTable.getModel().getValueAt(rows[i] - i, 3);
							String clubName = (String) clubRequestTable.getModel().getValueAt(rows[i] - i, 4);

							MemberInfo userFromRequest = Database.getMemberInfo(email);
							Database.removeClubRequest(userFromRequest.getUsername());

							// Send mail of decline join request

							((DefaultTableModel) clubRequestTable.getModel()).removeRow(rows[i] - i);

						}
					}
				}

				else {

					JOptionPane.showMessageDialog(null, "Select a row to decline!", "Information",
							JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});

		clubRequestTable = new JTable();
		clubRequestTable.setColumnSelectionAllowed(false);
		clubRequestTable.setCellSelectionEnabled(false);
		clubRequestTable.setDefaultEditor(Object.class, null);
		clubRequestTable.setRowSelectionAllowed(true);

		DefaultTableModel clubRequestTableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Username", "FirstName", "LastName", "Email", "AppliedTo", "Approved" });

		clubRequestTable.setModel(clubRequestTableModel);

		clubRequestScrollPanel.setViewportView(clubRequestTable);
		GroupLayout gl_clubRequestTablePanel = new GroupLayout(clubRequestTablePanel);
		gl_clubRequestTablePanel.setHorizontalGroup(gl_clubRequestTablePanel.createParallelGroup(Alignment.LEADING)
				.addComponent(clubRequestScrollPanel, GroupLayout.PREFERRED_SIZE, 1059, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_clubRequestTablePanel.createSequentialGroup().addGap(790)
						.addComponent(denyClubRequestButton, GroupLayout.PREFERRED_SIZE, 112,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(acceptClubReqButton, GroupLayout.PREFERRED_SIZE, 112,
								GroupLayout.PREFERRED_SIZE)));
		gl_clubRequestTablePanel.setVerticalGroup(gl_clubRequestTablePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_clubRequestTablePanel.createSequentialGroup()
						.addComponent(
								clubRequestScrollPanel, GroupLayout.PREFERRED_SIZE, 492, GroupLayout.PREFERRED_SIZE)
						.addGap(10)
						.addGroup(gl_clubRequestTablePanel.createParallelGroup(Alignment.LEADING)
								.addComponent(denyClubRequestButton, GroupLayout.PREFERRED_SIZE, 22,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(acceptClubReqButton, GroupLayout.PREFERRED_SIZE, 22,
										GroupLayout.PREFERRED_SIZE))));
		clubRequestTablePanel.setLayout(gl_clubRequestTablePanel);

		AllClubPanel = new JPanel();
		middlePanel.add(AllClubPanel, "name_60230077889300");

		JScrollPane allClubScrollPanel = new JScrollPane();

		JPanel clubDescriptionPanel = new JPanel();
		clubDescriptionPanel.setBackground(Color.LIGHT_GRAY);

		JLabel clubDescriptionLabel = new JLabel("Description");
		clubDescriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		clubDescriptionLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 15));
		GroupLayout gl_clubDescriptionPanel = new GroupLayout(clubDescriptionPanel);
		gl_clubDescriptionPanel.setHorizontalGroup(gl_clubDescriptionPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_clubDescriptionPanel.createSequentialGroup().addGap(139)
						.addComponent(clubDescriptionLabel, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
						.addGap(120)));
		gl_clubDescriptionPanel.setVerticalGroup(gl_clubDescriptionPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_clubDescriptionPanel.createSequentialGroup().addGap(18)
						.addComponent(clubDescriptionLabel).addContainerGap(18, Short.MAX_VALUE)));
		clubDescriptionPanel.setLayout(gl_clubDescriptionPanel);

		JScrollPane clubDescriptionScrollPane = new JScrollPane();
		GroupLayout gl_AllClubPanel = new GroupLayout(AllClubPanel);
		gl_AllClubPanel
				.setHorizontalGroup(gl_AllClubPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_AllClubPanel.createSequentialGroup()
								.addComponent(allClubScrollPanel, GroupLayout.PREFERRED_SIZE, 695,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_AllClubPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(clubDescriptionPanel, GroupLayout.DEFAULT_SIZE, 364,
												Short.MAX_VALUE)
										.addComponent(clubDescriptionScrollPane, GroupLayout.DEFAULT_SIZE, 364,
												Short.MAX_VALUE))));
		gl_AllClubPanel
				.setVerticalGroup(
						gl_AllClubPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(allClubScrollPanel, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
								.addGroup(gl_AllClubPanel.createSequentialGroup()
										.addComponent(clubDescriptionPanel, GroupLayout.DEFAULT_SIZE, 56,
												Short.MAX_VALUE)
										.addComponent(clubDescriptionScrollPane, GroupLayout.PREFERRED_SIZE, 472,
												GroupLayout.PREFERRED_SIZE)));

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

		allClubScrollPanel.setViewportView(allClubTable);
		AllClubPanel.setLayout(gl_AllClubPanel);

		attendeePanel = new JPanel();
		middlePanel.add(attendeePanel, "name_271831858432700");

		emailAndStatusScrollPane = new JScrollPane();

		eventScrollPanel = new JScrollPane();

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

		sendInviteToEventButton = new JButton("Send Invite");
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

		sendInviteAllButton = new JButton("Send Invite All");
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

		JButton clearAttendeesButton = new JButton("Clear Attendees");
		clearAttendeesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int[] eventSelected = eventDisplayTable.getSelectedRows();

				System.out.println(eventSelected[0]);

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

		JScrollPane descriptionScrollPane = new JScrollPane();
		descriptionScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		descriptionScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		descriptionPanel = new JPanel();
		descriptionPanel.setBackground(Color.LIGHT_GRAY);
		GroupLayout gl_attendeePanel = new GroupLayout(attendeePanel);
		gl_attendeePanel.setHorizontalGroup(gl_attendeePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_attendeePanel.createSequentialGroup()
						.addGroup(gl_attendeePanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_attendeePanel.createSequentialGroup().addGap(134)
										.addComponent(loadAttendeesFromDatabaseButton))
								.addComponent(emailAndStatusScrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										347, Short.MAX_VALUE))
						.addGroup(gl_attendeePanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_attendeePanel.createSequentialGroup()
										.addComponent(eventScrollPanel, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
										.addGroup(gl_attendeePanel.createParallelGroup(Alignment.TRAILING)
												.addComponent(descriptionScrollPane, GroupLayout.DEFAULT_SIZE, 304,
														Short.MAX_VALUE)
												.addComponent(descriptionPanel, GroupLayout.PREFERRED_SIZE, 344,
														Short.MAX_VALUE)))
								.addGroup(gl_attendeePanel.createSequentialGroup().addGap(25)
										.addComponent(deleteAttendeeButton, GroupLayout.PREFERRED_SIZE, 125,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(clearAttendeesButton, GroupLayout.PREFERRED_SIZE, 125,
												GroupLayout.PREFERRED_SIZE)
										.addGap(26).addComponent(addAttendeeButton).addGap(29)
										.addComponent(sendInviteToEventButton).addGap(28)
										.addComponent(sendInviteAllButton).addGap(27)))));
		gl_attendeePanel.setVerticalGroup(gl_attendeePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_attendeePanel.createSequentialGroup()
						.addGroup(gl_attendeePanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(eventScrollPanel, GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
								.addComponent(emailAndStatusScrollPane, GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
								.addGroup(gl_attendeePanel.createSequentialGroup()
										.addComponent(descriptionPanel, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)
										.addComponent(descriptionScrollPane, GroupLayout.PREFERRED_SIZE, 456,
												GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_attendeePanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(sendInviteAllButton).addComponent(sendInviteToEventButton)
								.addComponent(addAttendeeButton).addComponent(clearAttendeesButton)
								.addComponent(deleteAttendeeButton).addComponent(loadAttendeesFromDatabaseButton))
						.addGap(6)));

		eventDescriptionTextArea = new JTextArea();
		eventDescriptionTextArea.setLineWrap(true);
		eventDescriptionTextArea.setWrapStyleWord(true);
		eventDescriptionTextArea.setEditable(false);
		descriptionScrollPane.setViewportView(eventDescriptionTextArea);

		JLabel descriptionLabel = new JLabel("Description");
		descriptionLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 15));
		GroupLayout gl_descriptionPanel = new GroupLayout(descriptionPanel);
		gl_descriptionPanel
				.setHorizontalGroup(gl_descriptionPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_descriptionPanel
								.createSequentialGroup().addGap(129).addComponent(descriptionLabel,
										GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(130)));
		gl_descriptionPanel.setVerticalGroup(gl_descriptionPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_descriptionPanel.createSequentialGroup()
						.addContainerGap(12, Short.MAX_VALUE).addComponent(descriptionLabel).addContainerGap()));
		descriptionPanel.setLayout(gl_descriptionPanel);

		eventDisplayTable = new JTable();
		eventDisplayTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				int[] getSelectedRow = eventDisplayTable.getSelectedRows();

				if (getSelectedRow.length > 1)
					JOptionPane.showMessageDialog(null, "Select 1 event at a time to show attendees", "Information",
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
		attendeePanel.setLayout(gl_attendeePanel);

		middlePanel.add(homePanel, "name_87653730106600");
		titlePanel.setLayout(null);

		JLabel tittleLabel = new JLabel("WeMeet Event Management System");
		tittleLabel.setFont(new Font("OCR A Extended", Font.BOLD, 30));
		tittleLabel.setBounds(286, 10, 579, 57);
		titlePanel.add(tittleLabel);
		menuPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 5));

		homeLabel = new JLabel("Home");
		homeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				goToHomeTab();
				homePanel.clearDetails();			}
		});
		homeLabel.setForeground(new Color(0, 0, 139));
		homeLabel.setBackground(Color.WHITE);
		homeLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		menuPanel.add(homeLabel);

		requestsLabel = new JLabel("Requests");
		requestsLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				loadAllEventRequest();
				clearEventRequestDescriptionTextArea();



				eventRequestLabel.setForeground(new Color(0, 0, 139));
				clubRequestLabel.setForeground(Color.DARK_GRAY);

				homeLabel.setForeground(Color.DARK_GRAY);
				requestsLabel.setForeground(new Color(0, 0, 139));
				clubLabel.setForeground(Color.DARK_GRAY);
				memberLabel.setForeground(Color.DARK_GRAY);
				profileLabel.setForeground(Color.DARK_GRAY);

				homePanel.setVisible(false);
				// homeTableScrollPane.setVisible(false);
				eventRequestTablePanel.setVisible(true);
				clubMemberPanel.setVisible(false);
				membersPanel.setVisible(false);
				profilePanel.setVisible(false);
				AllClubPanel.setVisible(false);
				clubRequestTablePanel.setVisible(false);
				updatePasswordPanel.setVisible(false);
				passAdminPanel.setVisible(false);
				attendeePanel.setVisible(false);

				homeSidePanel.setVisible(false);
				requestSidePanel.setVisible(true);
				clubSidePanel.setVisible(false);
				memberSidePanel.setVisible(false);
				profileSidePanel.setVisible(false);

			}
		});
		requestsLabel.setForeground(Color.DARK_GRAY);
		requestsLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		menuPanel.add(requestsLabel);

		clubLabel = new JLabel("Clubs");
		clubLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				loadAllClubs();
				clearClubDescriptionTextArea();

				allClubs.setForeground(new Color(0, 0, 139));
				createClubLabel.setForeground(Color.DARK_GRAY);
				removeClub.setForeground(Color.DARK_GRAY);
				homeLabel.setForeground(Color.DARK_GRAY);
				requestsLabel.setForeground(Color.DARK_GRAY);
				clubLabel.setForeground(new Color(0, 0, 139));
				memberLabel.setForeground(Color.DARK_GRAY);
				profileLabel.setForeground(Color.DARK_GRAY);
				createReportLabel.setForeground(Color.DARK_GRAY);

				homePanel.setVisible(false);
				// homeTableScrollPane.setVisible(false);
				eventRequestTablePanel.setVisible(false);
				AllClubPanel.setVisible(true);
				membersPanel.setVisible(false);
				profilePanel.setVisible(false);
				clubRequestTablePanel.setVisible(false);
				attendeePanel.setVisible(false);
				clubMemberPanel.setVisible(false);

				homeSidePanel.setVisible(false);
				requestSidePanel.setVisible(false);
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

				loadUserList();
				clearEventDescriptionTextArea();
				goToMembersTab();

			}

			private void goToMembersTab() {
				// Takes to member Tab while disabling other tabs and panel.

				homeLabel.setForeground(Color.DARK_GRAY);
				requestsLabel.setForeground(Color.DARK_GRAY);
				clubLabel.setForeground(Color.DARK_GRAY);
				memberLabel.setForeground(new Color(0, 0, 139));
				usersLabel.setForeground(new Color(0, 0, 139));
				attendeesLabel.setForeground(Color.DARK_GRAY);
				profileLabel.setForeground(Color.DARK_GRAY);
				clubMembersLabel.setForeground(Color.DARK_GRAY);

				homePanel.setVisible(false);
				// homeTableScrollPane.setVisible(false);
				eventRequestTablePanel.setVisible(false);
				AllClubPanel.setVisible(false);
				membersPanel.setVisible(true);
				profilePanel.setVisible(false);
				clubRequestTablePanel.setVisible(false);
				updatePasswordPanel.setVisible(false);
				passAdminPanel.setVisible(false);
				attendeePanel.setVisible(false);
				clubMemberPanel.setVisible(false);

				homeSidePanel.setVisible(false);
				requestSidePanel.setVisible(false);
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

				goToProfilesTab();

			}

			private void goToProfilesTab() {
				// Switches to profile tab while disabling all other tabs and panel

				infoLabel.setForeground(new Color(0, 0, 139));
				updatePasswordLabel.setForeground(Color.DARK_GRAY);
				passAdminLabel.setForeground(Color.DARK_GRAY);

				homeLabel.setForeground(Color.DARK_GRAY);
				requestsLabel.setForeground(Color.DARK_GRAY);
				clubLabel.setForeground(Color.DARK_GRAY);
				memberLabel.setForeground(Color.DARK_GRAY);
				profileLabel.setForeground(new Color(0, 0, 139));

				homePanel.setVisible(false);
				// homeTableScrollPane.setVisible(false);
				eventRequestTablePanel.setVisible(false);
				AllClubPanel.setVisible(false);
				membersPanel.setVisible(false);
				profilePanel.setVisible(true);
				clubRequestTablePanel.setVisible(false);
				updatePasswordPanel.setVisible(false);
				passAdminPanel.setVisible(false);
				attendeePanel.setVisible(false);
				clubMemberPanel.setVisible(false);

				homeSidePanel.setVisible(false);
				requestSidePanel.setVisible(false);
				clubSidePanel.setVisible(false);
				memberSidePanel.setVisible(false);
				profileSidePanel.setVisible(true);

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
					requestsLabel.setForeground(Color.DARK_GRAY);
					clubLabel.setForeground(Color.DARK_GRAY);
					memberLabel.setForeground(Color.DARK_GRAY);
					profileLabel.setForeground(Color.DARK_GRAY);
					logoutLabel.setForeground(new Color(0, 0, 139));

					dispose();
					LoginFrame.getFrame().setVisible(true);

				} else {

					homeLabel.setForeground(new Color(0, 0, 139));
					requestsLabel.setForeground(Color.DARK_GRAY);
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
		goToHomeTab();

	}

	private void goToHomeTab() {
		// TODO Auto-generated method stub
		homeLabel.setForeground(new Color(0, 0, 139));
		requestsLabel.setForeground(Color.DARK_GRAY);
		clubLabel.setForeground(Color.DARK_GRAY);
		memberLabel.setForeground(Color.DARK_GRAY);
		profileLabel.setForeground(Color.DARK_GRAY);

		allEventsLabel.setForeground(new Color(0, 0, 139));
		createEventReportLabel.setForeground(Color.DARK_GRAY);
		createEventLabel.setForeground(Color.DARK_GRAY);
		updateEventLabel.setForeground(Color.DARK_GRAY);
		removeEventLabel.setForeground(Color.DARK_GRAY);

		homePanel.setVisible(true);
		// homeTableScrollPane.setVisible(true);
		eventRequestTablePanel.setVisible(false);
		clubMemberPanel.setVisible(false);
		membersPanel.setVisible(false);
		profilePanel.setVisible(false);
		AllClubPanel.setVisible(false);
		clubRequestTablePanel.setVisible(false);
		updatePasswordPanel.setVisible(false);
		passAdminPanel.setVisible(false);
		attendeePanel.setVisible(false);

		homeSidePanel.setVisible(true);
		requestSidePanel.setVisible(false);
		clubSidePanel.setVisible(false);
		memberSidePanel.setVisible(false);
		profileSidePanel.setVisible(false);
	}

	protected static void loadEventRequestDetails(int eventReqID) {
		// Set description of the selected event
		// setText
		EventRequest event = Database.getEventReq(eventReqID);
		eventRequestTextArea.setText(
				(String) event.getDetails() + "\nMade by: " + event.getMadeBy() + "\nApproval:" + event.getApproval());

	}

	protected static void loadEventDetails(int eventID) {
		// Set description of the selected event

		// setText
		Event event = Database.getEvent(eventID);
		eventDescriptionTextArea.setText((String) event.getDetails());

	}

	protected static void loadClubDetails(String clubName) {
		// Set description of the selected Club
		// setText
		Club club = Database.getClub(clubName);
		clubDescriptionTextArea.setText((String) club.getDescription() + "\nNumber of Member: " + club.getNumMembers());

	}

	public static void clearClubDescriptionTextArea() {

		clubDescriptionTextArea.setText("");

	}

	public static void clearEventRequestDescriptionTextArea() {

		eventRequestTextArea.setText("");

	}

	public static void clearEventDescriptionTextArea() {

		eventDescriptionTextArea.setText("");

	}

	protected void loadClubMembers(String clubName) {
		// Load Club Members

		ArrayList<MemberInfo> clubMemberList = Database.getClubMembers(clubName);

		DefaultTableModel model = new DefaultTableModel(new Object[][] {},
				new String[] { "FirstName", "LastName", "Username", "Email" });

		for (MemberInfo user : clubMemberList) {

			model.addRow(new Object[] { user.getFirstName(), user.getLastName(), user.getUsername(), user.getEmail() });

		}

		clubMembersTable.setModel(model);

	}

	protected void loadClubList() {
		// Loads all clubs in a list

		ArrayList<Club> clubList = Database.getAllClubs();
		String[] header = { "Image", "Name" };

		DefaultTableModel model = new DefaultTableModel(new Object[][] {}, header);

		for (Club club : clubList) {

			// DefaultTableModel model = (DefaultTableModel) HomeMenu.eventTable.getModel();
			// ImageIcon image = new ImageIcon(new
			// ImageIcon(event.getImg()).getImage().getScaledInstance(150, 150,
			// Image.SCALE_SMOOTH));
			model.addRow(new Object[] { club.getImg(), club.getName() });

		}

		clubListTable.setModel(model);
		clubListTable.setRowHeight(200);
		clubListTable.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer(200));

	}

	public void removeSelectedRows(JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		int[] rows = table.getSelectedRows();

		if (rows.length != 0) {

			int response = JOptionPane.showConfirmDialog(null,
					"Are you sure you want to remove " + rows.length + " item?", "Confirmation",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

			if (response == JOptionPane.YES_OPTION) {

				for (int i = 0; i < rows.length; i++) {

					// System.out.println(rows[i]);
					int eventID = (int) model.getValueAt(rows[i] - i, 1);
					String eventName = (String) model.getValueAt(rows[i], 2);
					Database.removeEvent(eventName, eventID);
					model.removeRow(rows[i] - i);

				}
			}

			allEventsLabel.setForeground(new Color(0, 0, 139));
			createEventLabel.setForeground(Color.DARK_GRAY);
			updateEventLabel.setForeground(Color.DARK_GRAY);
			removeEventLabel.setForeground(Color.DARK_GRAY);

			homePanel.clearDetails();

		} else {

			JOptionPane.showMessageDialog(null, "Select events to remove!", "Information", JOptionPane.WARNING_MESSAGE);
			allEventsLabel.setForeground(new Color(0, 0, 139));
			createEventLabel.setForeground(Color.DARK_GRAY);
			updateEventLabel.setForeground(Color.DARK_GRAY);
			removeEventLabel.setForeground(Color.DARK_GRAY);

		}

	}

	public void removeSelectedclub(JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		int[] rows = table.getSelectedRows();

		if (rows.length != 0) {

			int response = JOptionPane.showConfirmDialog(null,
					"Are you sure you want to remove " + rows.length + " club?", "Confirmation",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

			if (response == JOptionPane.YES_OPTION) {

				for (int i = 0; i < rows.length; i++) {

					// System.out.println(rows[i]);
					String name = (String) model.getValueAt(rows[i] - i, 1);
					Database.removeClub(name);
					Database.dropClubTable(name);
					Database.removeMembersFromClub(name);

					model.removeRow(rows[i] - i);

				}
			}

			allClubs.setForeground(new Color(0, 0, 139));
			createClubLabel.setForeground(Color.DARK_GRAY);
			removeClub.setForeground(Color.DARK_GRAY);

		} else {

			JOptionPane.showMessageDialog(null, "Select club to remove!", "Information", JOptionPane.WARNING_MESSAGE);
			allClubs.setForeground(new Color(0, 0, 139));
			createClubLabel.setForeground(Color.DARK_GRAY);
			removeClub.setForeground(Color.DARK_GRAY);

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

	public void loadUserList() {
		// Load all users in a list

		ArrayList<Object[]> userList = Database.getUserList();

		String[] header = { "MemberID", "Username", "FirstName", "LastName", "Email", "Club", "Admin" };

		DefaultTableModel memberTable = new DefaultTableModel(new Object[][] {}, header);

		for (Object[] user : userList) {

			memberTable.addRow(user);
		}

		membersTable.setModel(memberTable);
	}

	private void loadAllClubRequest() {
		// Loads all clubs in a list

		ArrayList<ClubRequest> clubRequestList = Database.getAllClubRequest();
		String[] header = { "Username", "FirstName", "LastName", "Email", "AppliedTo", "Approved" };

		DefaultTableModel clubReqModel = new DefaultTableModel(new Object[][] {}, header);

		for (ClubRequest club : clubRequestList) {

			clubReqModel.addRow(club.getRow());

		}

		clubRequestTable.setModel(clubReqModel);
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

	protected void loadEventDisplayTable() {
		// displays event table

		ArrayList<Event> eventList = Database.getAllEvents();
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
		// eventDisplayTable.getColumnModel().getColumn(3).setCellRenderer(new
		// MultipleLineRenderer());

	}

	private void loadAllEventRequest() {
		// Loads event request of all user

		ArrayList<EventRequest> eventList = Database.getAllEventRequests();
		String[] header = { "Image", "EventRequestID", "EventName" };

		DefaultTableModel model = new DefaultTableModel(new Object[][] {}, header);

		for (EventRequest event : eventList) {

			model.addRow(new Object[] { event.getImg(), event.getEventID(), event.getEventName() });

		}

		eventRequestTable.setModel(model);
		eventRequestTable.setRowHeight(300);
		eventRequestTable.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer(300));

	}

	public void setUser(MemberInfo user) {

		UserLabel.setText(user.getUsername());
		firstNameTextField.setText(user.getFirstName());
		lastNameTextField.setText(user.getLastName());
		usernameTextField.setText(user.getUsername());
		emailTextField.setText(user.getEmail());
		this.user = user;
	}

	// **************************** Not Used Yet *************//

	public static JTable addTableProperties(JTable table) {

		table.setColumnSelectionAllowed(false);
		table.setCellSelectionEnabled(false);
		table.setDefaultEditor(Object.class, null);
		table.setRowSelectionAllowed(true);

		return table;
	}
	// **************************** Not Used Yet *************//

	// File type Filter

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
