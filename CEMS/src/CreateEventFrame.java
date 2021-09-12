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

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DropTarget;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.TransferHandler;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.SwingConstants;

public class CreateEventFrame extends JFrame {

	private JPanel contentPane;
	private JTextField titleTextField;
	private JTextField eventCostTextField;
	private JTextArea locationTextArea;
	private JFormattedTextField startTimeJFTextField;
	private JFormattedTextField endTimeJFTextField;
	private JLabel dropImageLabel;
	private String droppedImgAddress = "";
	private JTextArea descriptionTextArea;
	private JComboBox startTimeComboBox;
	private JComboBox endTimeComboBox;
	private JComboBox startTimeAmPmComboBox;
	private JComboBox endTimeAmPmComboBox;
	private MemberInfo user;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateEventFrame frame = new CreateEventFrame();
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
	public CreateEventFrame() {
		
		ImageIcon logoImage = new ImageIcon("src/resource/weMeetLogo.png");
		setIconImage(logoImage.getImage());
		setTitle("Create Event");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 958, 496);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				// connectToDragDrop();
				// modifyLabel();

			}
		});
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel addEventPanel = new JPanel();
		addEventPanel.setLayout(null);
		addEventPanel.setBorder(new LineBorder(new Color(0, 191, 255), 7));
		addEventPanel.setBackground(Color.CYAN);

		JLabel addEventLabel = new JLabel("Add event details");
		addEventLabel.setFont(new Font("OCR A Extended", Font.BOLD, 30));
		addEventLabel.setBounds(313, 25, 335, 57);
		addEventPanel.add(addEventLabel);

		JLabel addTitleLabel = new JLabel("Title");
		addTitleLabel.setFont(new Font("OCR A Extended", Font.BOLD, 15));

		titleTextField = new JTextField();
		titleTextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		titleTextField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();

		JLabel startTimeLabel = new JLabel("Start Time");
		startTimeLabel.setFont(new Font("OCR A Extended", Font.BOLD, 15));

		JLabel endTimeLabel = new JLabel("End Time");
		endTimeLabel.setFont(new Font("OCR A Extended", Font.BOLD, 15));

		JLabel eventCostLabel = new JLabel("Event Cost");
		eventCostLabel.setFont(new Font("OCR A Extended", Font.BOLD, 15));

		JButton addEventButton = new JButton("Add Event");
		addEventButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == addEventButton) {

					// get img
					// get Title
					// get Description
					// get Start Time
					// get End Time
					// get Event cost
					// get location

					String missingReq = "";
					boolean hasValidTime = true;
					boolean hasImgAddress = true;
					boolean hasTitle = true;
					boolean hasDescription = true;
					boolean hasEventCost = true;
					boolean hasLocation = true;
					boolean hasStartTime = true;
					boolean hasEndTime = true;
					boolean hasStartTimeAmPm = true;
					boolean hasEndTimeAmPm = true;

					String imgAddress = droppedImgAddress;
					String title = titleTextField.getText();
					String description = descriptionTextArea.getText();
					String startTime = (String) startTimeComboBox.getSelectedItem();
					String startTimeAmPm = (String) startTimeAmPmComboBox.getSelectedItem();
					String endTime = (String) endTimeComboBox.getSelectedItem();
					String endTimeAmPm = (String) endTimeAmPmComboBox.getSelectedItem();
					String startDateTime = startTimeJFTextField.getText() + " " + startTime + startTimeAmPm;
					String endDateTime = endTimeJFTextField.getText() + " " + endTime + endTimeAmPm;
					String eventCost = eventCostTextField.getText();
					String location = locationTextArea.getText();

					// check any of the fields are empty

					if (imgAddress.equals("")) {

						missingReq = missingReq + "[Image] ";
						hasImgAddress = false;
					}

					if (title.equals("")) {

						missingReq = missingReq + "[Title] ";
						hasTitle = false;
					}

					if (description.equals("")) {

						missingReq = missingReq + "[Descrition] ";
						hasDescription = false;
					}

					if (startTime.equals("Select Time")) {

						missingReq = missingReq + "[Start time] ";
						hasStartTime = false;

					}

					if (endTime.equals("Select Time")) {

						missingReq = missingReq + "[End time] ";
						hasEndTime = false;
					}

					if (startTimeAmPm.equals("")) {

						missingReq = missingReq + "[Start time Am or Pm] ";
						hasStartTimeAmPm = false;
					}

					if (endTimeAmPm.equals("")) {

						missingReq = missingReq + "[End Am or Pm] ";
						hasEndTimeAmPm = false;
					}

					if (eventCost.equals("")) {

						missingReq = missingReq + "[Event Cost] ";
						hasEventCost = false;
					}

					if (location.equals("")) {

						missingReq = missingReq + "[Location] ";
						hasLocation = false;
					}

					
					
					
					if(!isNumber(eventCost)) {
						
						JOptionPane.showMessageDialog(null, "Please enter numbers for event cost!", "Error", JOptionPane.ERROR_MESSAGE);
						hasEventCost = false;

					}
					
					else if (missingReq.length() > 0) {

						// give warning on an empty field

						JOptionPane.showMessageDialog(null, "The following field's { " + missingReq + "}\nare missing!",
								"Missing Fields", JOptionPane.ERROR_MESSAGE);

						// cmp start time and end time, if whether they are valid
					} else if (!validTimeSet(startTimeJFTextField.getText(), endTimeJFTextField.getText(),
							startTime + startTimeAmPm, endTime + endTimeAmPm)) {

						hasValidTime = false;
						JOptionPane.showMessageDialog(null, "The end time is greater than start time!", "Time set",
								JOptionPane.ERROR_MESSAGE);

						
					} else if (!afterCurrentDate(startTimeJFTextField.getText(),startTime + startTimeAmPm)) {
						
						hasValidTime = false;
						JOptionPane.showMessageDialog(null, "The start time needs to greater than current time!", "Time set",
								JOptionPane.ERROR_MESSAGE);
						
					}

					// if not empty and time is valid
					// add directly to the table

					if (hasImgAddress && hasTitle && hasDescription && hasStartTime && hasEndTime && hasStartTimeAmPm
							&& hasEndTimeAmPm && hasEventCost && hasLocation && hasValidTime) {

						
						int costInt = Integer.parseInt(eventCost);
						eventCost = Integer.toString(costInt);
						
						// Make a Table element

						
						
						
						//********************************************************************************
						//Adjustment:- setting image to byte[] instead of direct address.**********
						
						FileInputStream imgFile = null;
						File image = new File(imgAddress);
						
						try {
							
							imgFile = new FileInputStream(image);
							
							Database.addEvent(title, description, startDateTime, endDateTime, eventCost, location,
									imgFile, user);
							
							byte[] img = imgFile.readAllBytes();
						
						
						

						DefaultTableModel model = (DefaultTableModel) AdminHomeMenu.eventTable.getModel();

						model.addRow(new Object[] {

								img, Database.getSizeEvent() , title, description, startDateTime, endDateTime,
								eventCost, location

						});		

						
						//**************************************************************************
						//********************************************************************************
						AdminHomeMenu.eventTable.setModel(model);
						AdminHomeMenu.eventTable.setRowHeight(150);
						AdminHomeMenu.eventTable.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());
						AdminHomeMenu.homePanel.loadEventsList();

						// Add to the row
						// check for existing table in mySql if doesn't exist create one
						// Then add the same row to the mySql server

						JOptionPane.showMessageDialog(null, "The event has been added!", "Information",
								JOptionPane.INFORMATION_MESSAGE);

						// dispose();
						AdminHomeMenu.allEventsLabel.setForeground(new Color(0, 0, 139));
						AdminHomeMenu.createEventLabel.setForeground(Color.DARK_GRAY);
						AdminHomeMenu.updateEventLabel.setForeground(Color.DARK_GRAY);
						AdminHomeMenu.removeEventLabel.setForeground(Color.DARK_GRAY);
						
						
						dispose();
						
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				
					}

					// System.out.println(missingReq.length());
					// System.out.println(imgAddress + "\n\n");
					// System.out.println(title + "\n");
					// System.out.println(description);
					// System.out.println(startDateTime);
					// System.out.println(endDateTime);
					// System.out.println(eventCost);
					// System.out.println(location);

					// System.out.println();

					// dialog box for confirmation

					// Parse them into Event class
					//

				}
			}
		});
		addEventButton.setFocusable(false);
		addEventButton.setFont(new Font("OCR A Extended", Font.BOLD, 15));

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AdminHomeMenu.allEventsLabel.setForeground(new Color(0, 0, 139));
				AdminHomeMenu.createEventLabel.setForeground(Color.DARK_GRAY);
				AdminHomeMenu.updateEventLabel.setForeground(Color.DARK_GRAY);
				AdminHomeMenu.removeEventLabel.setForeground(Color.DARK_GRAY);
				//AdminHomeMenu
				dispose();
			}
		});
		cancelButton.setFocusable(false);
		cancelButton.setFont(new Font("OCR A Extended", Font.BOLD, 15));

		eventCostTextField = new JTextField();
		eventCostTextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		eventCostTextField.setColumns(10);

		JLabel locationLabel = new JLabel("Location");
		locationLabel.setFont(new Font("OCR A Extended", Font.BOLD, 15));

		locationTextArea = new JTextArea();
		locationTextArea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		locationTextArea.setColumns(10);

		startTimeJFTextField = new JFormattedTextField();
		startTimeJFTextField.setValue(new Date());
		startTimeJFTextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		startTimeJFTextField.setColumns(10);

		endTimeJFTextField = new JFormattedTextField();
		endTimeJFTextField.setValue(new Date());
		endTimeJFTextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		endTimeJFTextField.setColumns(10);

		CalendarWindow startTimeCalender = new CalendarWindow();
		startTimeCalender.setUndecorated(true);
		startTimeCalender.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				// TODO Auto-generated method stub

				if (evt.getPropertyName().equals("selectedDate")) {

					java.util.Calendar cal = (java.util.Calendar) evt.getNewValue();
					Date selDate = cal.getTime();

					startTimeJFTextField.setValue(selDate);

				}

			}
		});

		CalendarWindow endTimeCalender = new CalendarWindow();
		endTimeCalender.setUndecorated(true);
		endTimeCalender.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				// TODO Auto-generated method stub

				if (evt.getPropertyName().equals("selectedDate")) {

					java.util.Calendar cal = (java.util.Calendar) evt.getNewValue();
					Date selDate = cal.getTime();

					endTimeJFTextField.setValue(selDate);

				}

			}
		});

		JButton startTimeButton = new JButton("New button");
		startTimeButton.setFocusable(false);
		startTimeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				startTimeCalender.setLocation(startTimeJFTextField.getLocationOnScreen().x,
						startTimeJFTextField.getLocationOnScreen().y + startTimeJFTextField.getHeight());

				Date selectedDate = (Date) startTimeJFTextField.getValue();
				startTimeCalender.resetSelection(selectedDate);

				startTimeCalender.setVisible(true);

			}
		});

		JButton endTimeButton = new JButton("New button");
		endTimeButton.setFocusable(false);
		endTimeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				endTimeCalender.setLocation(endTimeJFTextField.getLocationOnScreen().x,
						endTimeJFTextField.getLocationOnScreen().y + endTimeJFTextField.getHeight());

				Date selectedDate = (Date) endTimeJFTextField.getValue();
				endTimeCalender.resetSelection(selectedDate);

				endTimeCalender.setVisible(true);
			}
		});

		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("OCR A Extended", Font.BOLD, 15));

		startTimeComboBox = new JComboBox();
		startTimeComboBox.setModel(new DefaultComboBoxModel(new String[] { "Select Time", "1:00", "1:15", "1:30",
				"1:45", "2:00", "2:15", "2:30", "2:45", "3:00", "3:15", "3:30", "3:45", "4:00", "4:15", "4:30", "4:45",
				"5:00", "5:15", "5:30", "5:45", "6:00", "6:15", "6:30", "6:45", "7:00", "7:15", "7:30", "7:45", "8:00",
				"8:15", "8:30", "8:45", "9:00", "9:15", "9:30", "9:45", "10:00", "10:15", "10:30", "10:45", "11:00",
				"11:15", "11:30", "11:45", "12:00", "12:15", "12:30", "12:45" }));

		startTimeAmPmComboBox = new JComboBox();
		startTimeAmPmComboBox.setModel(new DefaultComboBoxModel(new String[] { "", "PM", "AM" }));

		endTimeComboBox = new JComboBox();
		endTimeComboBox.setModel(new DefaultComboBoxModel(new String[] { "Select Time", "1:00", "1:15", "1:30", "1:45",
				"2:00", "2:15", "2:30", "2:45", "3:00", "3:15", "3:30", "3:45", "4:00", "4:15", "4:30", "4:45", "5:00",
				"5:15", "5:30", "5:45", "6:00", "6:15", "6:30", "6:45", "7:00", "7:15", "7:30", "7:45", "8:00", "8:15",
				"8:30", "8:45", "9:00", "9:15", "9:30", "9:45", "10:00", "10:15", "10:30", "10:45", "11:00", "11:15",
				"11:30", "11:45", "12:00", "12:15", "12:30", "12:45" }));

		endTimeAmPmComboBox = new JComboBox();
		endTimeAmPmComboBox.setModel(new DefaultComboBoxModel(new String[] { "", "PM", "AM" }));

		JLabel imgLabel = new JLabel("Image");
		imgLabel.setFont(new Font("OCR A Extended", Font.BOLD, 15));

		JPanel imageHolderPanel = new JPanel();
		imageHolderPanel.setTransferHandler(new TransferHandler() {

			@Override
			public boolean canImport(JComponent comp, DataFlavor[] transferFlavors) {

				return true;
			}

			@Override
			public boolean importData(JComponent comp, Transferable t) {

				try {

					List<File> files = (List<File>) t.getTransferData(DataFlavor.javaFileListFlavor);

					for (File file : files) {

						ImageIcon icon = new ImageIcon(file.getPath());
						dropImageLabel.setIcon(icon);
						dropImageLabel.setText("");
						droppedImgAddress = file.getPath();

					}

				} catch (UnsupportedFlavorException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return true;
			}

		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(addEventPanel, GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(20).addGroup(gl_contentPane
						.createParallelGroup(Alignment.TRAILING)
						.addComponent(addTitleLabel, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDescription, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
						.addComponent(imgLabel, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(imageHolderPanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(titleTextField, GroupLayout.PREFERRED_SIZE, 173,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 267,
										Short.MAX_VALUE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
								.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
												.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
														.addGroup(gl_contentPane.createSequentialGroup().addGap(47)
																.addComponent(startTimeLabel, GroupLayout.DEFAULT_SIZE,
																		97, Short.MAX_VALUE)
																.addGap(19))
														.addGroup(gl_contentPane.createSequentialGroup()
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(endTimeLabel, GroupLayout.PREFERRED_SIZE,
																		95, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)))
												.addGroup(gl_contentPane.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(eventCostLabel, GroupLayout.PREFERRED_SIZE, 98,
																GroupLayout.PREFERRED_SIZE)
														.addGap(18)))
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(startTimeJFTextField)
														.addComponent(eventCostTextField, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(endTimeJFTextField, GroupLayout.DEFAULT_SIZE, 147,
																Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(startTimeButton,
																		GroupLayout.PREFERRED_SIZE, 31,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(startTimeComboBox,
																		GroupLayout.PREFERRED_SIZE, 97,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(startTimeAmPmComboBox,
																		GroupLayout.PREFERRED_SIZE, 47,
																		GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(endTimeButton, GroupLayout.PREFERRED_SIZE,
																		31, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(endTimeComboBox,
																		GroupLayout.PREFERRED_SIZE, 97,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(endTimeAmPmComboBox,
																		GroupLayout.PREFERRED_SIZE, 47,
																		GroupLayout.PREFERRED_SIZE))))
										.addGroup(gl_contentPane.createSequentialGroup().addGap(66)
												.addComponent(locationLabel, GroupLayout.PREFERRED_SIZE, 79,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18).addComponent(locationTextArea, GroupLayout.PREFERRED_SIZE,
														328, GroupLayout.PREFERRED_SIZE)))
								.addContainerGap())
								.addGroup(Alignment.TRAILING,
										gl_contentPane.createSequentialGroup().addGap(236)
												.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 111,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18).addComponent(addEventButton).addGap(53)))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addComponent(addEventPanel, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(titleTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(addTitleLabel))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(startTimeJFTextField, GroupLayout.PREFERRED_SIZE, 22,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(startTimeLabel, GroupLayout.PREFERRED_SIZE, 16,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(startTimeButton)
								.addComponent(startTimeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(startTimeAmPmComboBox, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 137,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
														.addComponent(endTimeLabel, GroupLayout.PREFERRED_SIZE, 16,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(endTimeJFTextField, GroupLayout.PREFERRED_SIZE,
																22, GroupLayout.PREFERRED_SIZE)
														.addComponent(endTimeButton)
														.addComponent(endTimeComboBox, GroupLayout.PREFERRED_SIZE, 19,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(endTimeAmPmComboBox, GroupLayout.PREFERRED_SIZE,
																19, GroupLayout.PREFERRED_SIZE))
												.addGap(22)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
														.addComponent(eventCostTextField, GroupLayout.PREFERRED_SIZE,
																22, GroupLayout.PREFERRED_SIZE)
														.addComponent(eventCostLabel, GroupLayout.PREFERRED_SIZE, 16,
																GroupLayout.PREFERRED_SIZE))
												.addGap(22)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
														.addComponent(locationTextArea, GroupLayout.PREFERRED_SIZE, 65,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(locationLabel, GroupLayout.PREFERRED_SIZE, 16,
																GroupLayout.PREFERRED_SIZE))))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 25,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(addEventButton))
										.addComponent(imageHolderPanel, GroupLayout.PREFERRED_SIZE, 75,
												GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(38)
								.addComponent(lblDescription, GroupLayout.PREFERRED_SIZE, 16,
										GroupLayout.PREFERRED_SIZE)
								.addGap(139)
								.addComponent(imgLabel, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
				.addGap(40)));
		imageHolderPanel.setLayout(null);

		dropImageLabel = new JLabel("Drop Image file here");
		dropImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dropImageLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dropImageLabel.setBounds(0, 0, 267, 75);
		imageHolderPanel.add(dropImageLabel);

		descriptionTextArea = new JTextArea();
		descriptionTextArea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane.setViewportView(descriptionTextArea);
		contentPane.setLayout(gl_contentPane);
	}

	public static boolean isNumber(String eventCost) {
		// checks whether a number or not
		
		for(int i = 0; i < eventCost.length(); i++) {
			
			if((eventCost.charAt(i) < '0') || (eventCost.charAt(i) > '9') ) return false;
			
		}
		
		return true;
	}

	public static boolean afterCurrentDate(String startDate, String startHour) {
		// Whether the date and time is after current time.
		
		Date date = new Date();
		int currentYear = date.getYear() + 1900;
		int currentMonth = date.getMonth() + 1;
		int currentDay = date.getDate();
		int currentHour = (date.getHours()) * 100;
				
		System.out.println(currentYear + " " + currentMonth + " " + currentDay + " " + currentHour);
		
		int startTimeYear = whichYear(startDate);
		int startTimeMonth = whichMonth(startDate.substring(0, 3));
		int startTimeDay = whichDay(startDate);
		int startTimeHour = whichHour(startHour);
		
		System.out.println(startTimeYear + " " + startTimeMonth + " " + startTimeDay + " " + startTimeHour);

		if (currentYear > startTimeYear)
			return false;
		else if (currentYear == startTimeYear) {

			if (currentMonth > startTimeMonth)
				return false;
			else if (currentMonth == startTimeMonth) {

				if (currentDay > startTimeDay)
					return false;
				else if (currentDay == startTimeDay) {

					if (currentHour > startTimeHour)
						return false;

				}

			}
		}

		return true;
		
	}

	public static boolean validTimeSet(String startDate, String endDate, String startHour, String endHour) {

		int startTimeYear = whichYear(startDate);
		int startTimeMonth = whichMonth(startDate.substring(0, 3));
		int startTimeDay = whichDay(startDate);
		int startTimeHour = whichHour(startHour);
		int endTimeYear = whichYear(endDate);
		int endTimeMonth = whichMonth(endDate.substring(0, 3));
		;
		int endTimeDay = whichDay(endDate);
		int endTimeHour = whichHour(endHour);

		// int totalStartTimeDays = (startTimeYear * 365) + ()

		// System.out.println("Start Time : " + startTimeYear + " " + startTimeMonth + "
		// " + startTimeDay + " " + startTimeHour + " End Time : " + endTimeYear + " " +
		// endTimeMonth + " " + endTimeDay + " " + endTimeHour);

		if (endTimeYear < startTimeYear)
			return false;
		else if (endTimeYear == startTimeYear) {

			// System.out.println("Year same");

			if (endTimeMonth < startTimeMonth)
				return false;
			else if (endTimeMonth == startTimeMonth) {

				// System.out.println("Month same");

				if (endTimeDay < startTimeDay)
					return false;
				else if (endTimeDay == startTimeDay) {

					// System.out.println("Day same");

					if (endTimeHour < startTimeHour)
						return false;

				}

			}
		}

		return true;

	}

	public static int whichMonth(String month) {

		if (month.equals("Jan"))
			return 1;
		if (month.equals("Feb"))
			return 2;
		if (month.equals("Mar"))
			return 3;
		if (month.equals("Apr"))
			return 4;
		if (month.equals("May"))
			return 5;
		if (month.equals("Jun"))
			return 6;
		if (month.equals("Jul"))
			return 7;
		if (month.equals("Aug"))
			return 8;
		if (month.equals("Sep"))
			return 9;
		if (month.equals("Oct"))
			return 10;
		if (month.equals("Nov"))
			return 11;
		if (month.equals("Dec"))
			return 12;

		return 0;

	}

	public static int whichYear(String date) {

		
		//Gap error By default while no change made
		
		
		String yearS = date.substring(date.length() - 4);
		int year = Integer.parseInt(yearS);

		return year;
	}

	public static int whichDay(String date) {

		int day = 0;

		if (date.length() == 11)
			day = Integer.parseInt(date.substring(4, 5));

		if (date.length() == 12)
			day = Integer.parseInt(date.substring(4, 6));

		return day;

	}

	public static int whichHour(String hour) {

		int tHour = 0;

		if (hour.length() == 6) {

			tHour = Integer.parseInt(hour.substring(0, 1) + hour.substring(2, 4));

			if (hour.substring(hour.length() - 2).equals("PM"))
				tHour += 1200;

		} else if (hour.length() == 7) {

			tHour = Integer.parseInt(hour.substring(0, 2) + hour.substring(3, 5));

			if (hour.substring(hour.length() - 2).equals("PM"))
				tHour += 1200;
		}

		return tHour;
	}
/*	
	public void loadEventsList() {

		ArrayList<Event> eventList = Database.getAllEvents();
		String[] header = { "Image", "EventID", "EventTitle", "EventDescription", "Starttime", " EndTime", "EventCost",
				"Location" };

		DefaultTableModel model = new DefaultTableModel(new Object[][] {}, header);

		for (Event event : eventList) {

			// DefaultTableModel model = (DefaultTableModel) HomeMenu.eventTable.getModel();
			// ImageIcon image = new ImageIcon(new
			// ImageIcon(event.getImg()).getImage().getScaledInstance(150, 150,
			// Image.SCALE_SMOOTH));
			model.addRow(event.getRow());

		}

		AdminHomeMenu.eventTable.setModel(model);
		AdminHomeMenu.eventTable.setRowHeight(150);
		AdminHomeMenu.eventTable.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());

	}
	*/
	public MemberInfo getUser() {
		return user;
	}

	public void setUser(MemberInfo user) {
		this.user = user;
	}



	// Renders image when called
	private class ImageRenderer implements TableCellRenderer {

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {

			byte[] photoName = (byte[]) value;
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(photoName).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));

			return new JLabel(imageIcon);
		}

	}
	private class MultipleLineRenderer implements TableCellRenderer {

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {

			JLabel text = new JLabel();
			text.setText("<html>" + (String)value + "</html>");
			text.setVerticalTextPosition(JLabel.TOP);


			return text;
		}

	}

}
