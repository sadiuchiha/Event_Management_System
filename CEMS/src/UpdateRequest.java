import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

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

import javax.swing.SwingConstants;
import javax.swing.TransferHandler;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class UpdateRequest extends JFrame {

	private JPanel contentPane;
	private JTextField titleTextField;
	private JTextField eventCostTextField;
	private JFormattedTextField startTimeJFTextField;
	private JFormattedTextField endTimeJFTextField;
	private JTextArea descriptionTextArea;
	private JLabel dropImageLabel;
	private String droppedImgAddress = "";
	private static EventRequest selectedEvent = new EventRequest();
	private MemberInfo user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateRequest frame = new UpdateRequest(null);
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
	public UpdateRequest(EventRequest selectedEvent) {
		
		
		
		this.selectedEvent = selectedEvent;
		ImageIcon logoImage = new ImageIcon("src/resource/weMeetLogo.png");
		setIconImage(logoImage.getImage());
		setTitle("Update Event");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 958, 496);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(50, 205, 50));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel addEventPanel = new JPanel();
		addEventPanel.setLayout(null);
		addEventPanel.setBorder(new LineBorder(new Color(0, 100, 0), 7));
		addEventPanel.setBackground(new Color(0, 128, 0));

		JLabel updateEventLabel = new JLabel("Update event details");
		updateEventLabel.setFont(new Font("OCR A Extended", Font.BOLD, 30));
		updateEventLabel.setBounds(284, 25, 392, 57);
		addEventPanel.add(updateEventLabel);

		JLabel addTitleLabel = new JLabel("Title");
		addTitleLabel.setFont(new Font("OCR A Extended", Font.BOLD, 15));

		JLabel descriptionLabel = new JLabel("Description");
		descriptionLabel.setFont(new Font("OCR A Extended", Font.BOLD, 15));

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
		imageHolderPanel.setLayout(null);

		ImageIcon image = new ImageIcon(selectedEvent.getImg());

		dropImageLabel = new JLabel();
		dropImageLabel.setIcon(image);
		dropImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dropImageLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dropImageLabel.setBounds(0, 0, 267, 75);
		imageHolderPanel.add(dropImageLabel);

		titleTextField = new JTextField();
		titleTextField.setText(selectedEvent.getEventName());
		titleTextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		titleTextField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();

		JLabel startTimeLabel = new JLabel("Start Time");
		startTimeLabel.setFont(new Font("OCR A Extended", Font.BOLD, 15));

		JLabel endTimeLabel = new JLabel("End Time");
		endTimeLabel.setFont(new Font("OCR A Extended", Font.BOLD, 15));

		JLabel eventCostLabel = new JLabel("Event Cost");
		eventCostLabel.setFont(new Font("OCR A Extended", Font.BOLD, 15));

		CalendarWindow startTimeCalender = new CalendarWindow();
		startTimeCalender.setUndecorated(true);
		startTimeCalender.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				// TODO Auto-generated method stub

				if (evt.getPropertyName().equals("selectedDate")) {

					java.util.Calendar cal = (java.util.Calendar) evt.getNewValue();
					Date selDate = cal.getTime();

					startTimeJFTextField.setValue(getFormattedDate(selDate));

				}

			}
		});

		startTimeJFTextField = new JFormattedTextField();

		if (selectedEvent.getStartTime().charAt(5) == ',') {

			startTimeJFTextField.setValue(selectedEvent.getStartTime().substring(0, 11));

		} else {

			startTimeJFTextField.setValue(selectedEvent.getStartTime().substring(0, 12));

		}

		startTimeJFTextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		startTimeJFTextField.setColumns(10);

		eventCostTextField = new JTextField();
		eventCostTextField.setText(selectedEvent.getEventCost());
		eventCostTextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		eventCostTextField.setColumns(10);

		CalendarWindow endTimeCalender = new CalendarWindow();
		endTimeCalender.setUndecorated(true);
		endTimeCalender.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				// TODO Auto-generated method stub

				if (evt.getPropertyName().equals("selectedDate")) {

					java.util.Calendar cal = (java.util.Calendar) evt.getNewValue();
					Date selDate = cal.getTime();

					endTimeJFTextField.setValue(getFormattedDate(selDate));

				}

			}
		});

		endTimeJFTextField = new JFormattedTextField();

		if (selectedEvent.getEndTime().charAt(5) == ',') {

			endTimeJFTextField.setValue(selectedEvent.getStartTime().substring(0, 11));

		} else {

			endTimeJFTextField.setValue(selectedEvent.getStartTime().substring(0, 12));

		}

		endTimeJFTextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		endTimeJFTextField.setColumns(10);

		JButton startTimeButton = new JButton("New button");
		startTimeButton.setFocusable(false);
		startTimeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				startTimeCalender.setLocation(startTimeJFTextField.getLocationOnScreen().x,
						startTimeJFTextField.getLocationOnScreen().y + startTimeJFTextField.getHeight());

				Date selectedDate = new Date();// startTimeJFTextField.getValue();

				selectedDate = (Date) selectedDate;
				startTimeCalender.resetSelection(selectedDate);

				startTimeCalender.setVisible(true);

			}
		});

		JComboBox startTimeComboBox = new JComboBox();
		startTimeComboBox.setModel(new DefaultComboBoxModel(
				new String[] { getFormattedTime(selectedEvent.getStartTime()), "Select Time", "1:00", "1:15", "1:30",
						"1:45", "2:00", "2:15", "2:30", "2:45", "3:00", "3:15", "3:30", "3:45", "4:00", "4:15", "4:30",
						"4:45", "5:00", "5:15", "5:30", "5:45", "6:00", "6:15", "6:30", "6:45", "7:00", "7:15", "7:30",
						"7:45", "8:00", "8:15", "8:30", "8:45", "9:00", "9:15", "9:30", "9:45", "10:00", "10:15",
						"10:30", "10:45", "11:00", "11:15", "11:30", "11:45", "12:00", "12:15", "12:30", "12:45" }));

		JComboBox startTimeAmPmComboBox = new JComboBox();
		startTimeAmPmComboBox.setModel(new DefaultComboBoxModel(
				new String[] { getFormattedPMOrAM(selectedEvent.getStartTime()), "", "PM", "AM" }));

		JButton endTimeButton = new JButton("New button");
		endTimeButton.setFocusable(false);
		endTimeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				endTimeCalender.setLocation(endTimeJFTextField.getLocationOnScreen().x,
						endTimeJFTextField.getLocationOnScreen().y + endTimeJFTextField.getHeight());

				Date selectedDate = new Date(); // endTimeJFTextField.getValue();
				endTimeCalender.resetSelection(selectedDate);

				endTimeCalender.setVisible(true);
			}
		});

		JComboBox endTimeComboBox = new JComboBox();
		endTimeComboBox.setModel(new DefaultComboBoxModel(new String[] { getFormattedTime(selectedEvent.getEndTime()),
				"Select Time", "1:00", "1:15", "1:30", "1:45", "2:00", "2:15", "2:30", "2:45", "3:00", "3:15", "3:30",
				"3:45", "4:00", "4:15", "4:30", "4:45", "5:00", "5:15", "5:30", "5:45", "6:00", "6:15", "6:30", "6:45",
				"7:00", "7:15", "7:30", "7:45", "8:00", "8:15", "8:30", "8:45", "9:00", "9:15", "9:30", "9:45", "10:00",
				"10:15", "10:30", "10:45", "11:00", "11:15", "11:30", "11:45", "12:00", "12:15", "12:30", "12:45" }));

		JComboBox endTimeAmPmComboBox = new JComboBox();
		endTimeAmPmComboBox.setModel(new DefaultComboBoxModel(
				new String[] { getFormattedPMOrAM(selectedEvent.getEndTime()), "", "PM", "AM" }));

		JLabel locationLabel = new JLabel("Location");
		locationLabel.setFont(new Font("OCR A Extended", Font.BOLD, 15));

		JTextArea locationTextArea = new JTextArea();
		locationTextArea.setText(selectedEvent.getLocation());
		locationTextArea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		locationTextArea.setColumns(10);

		JButton updateEventButton = new JButton("Update Event");
		updateEventButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Check if anything was changed.
				// T^ -> Check if time was changed. F^ -> Do nothing and close window.
				// T^ -> Check if time is valid. F^ -> Do nothing with time.
				// T^ -> Collect All Event detail

				// Check if any field is left empty <T -> pop up message show the empty fields
				//

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

				// Gap error fix

				if (endTimeJFTextField.getText().charAt(endTimeJFTextField.getText().length() - 1) == ' ') {

					String endTimeWithoutGap = endTimeJFTextField.getText().substring(0,
							endTimeJFTextField.getText().length() - 1);
					endTimeJFTextField.setText(endTimeWithoutGap);

				}

				// ************

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

				if (selectedEvent.getImg().length == 0) {

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
				
				if (!CreateEventFrame.isNumber(eventCost)) {

					JOptionPane.showMessageDialog(null, "Please enter numbers for event cost!", "Error",
							JOptionPane.ERROR_MESSAGE);
					hasEventCost = false;

				}

				else if (missingReq.length() > 0) {

					// give warning on an empty field

					JOptionPane.showMessageDialog(null, "The following field's { " + missingReq + "}\nare missing!",
							"Missing Fields", JOptionPane.ERROR_MESSAGE);

					// cmp start time and end time, if whether they are valid
				} else if (!CreateEventFrame.validTimeSet(startTimeJFTextField.getText(), endTimeJFTextField.getText(),
						startTime + startTimeAmPm, endTime + endTimeAmPm)) {

					hasValidTime = false;
					JOptionPane.showMessageDialog(null, "The end time is greater than start time!", "Time set",
							JOptionPane.ERROR_MESSAGE);

				} else if (!CreateEventFrame.afterCurrentDate(startTimeJFTextField.getText(),
						startTime + startTimeAmPm)) {

					hasValidTime = false;
					JOptionPane.showMessageDialog(null, "The start time needs to greater than current time!",
							"Time set", JOptionPane.ERROR_MESSAGE);

				}

				if (didFieldsChanged(imgAddress, title, description, startDateTime, endDateTime, eventCost, location)) {

					if (hasImgAddress && hasTitle && hasDescription && hasStartTime && hasEndTime && hasStartTimeAmPm
							&& hasEndTimeAmPm && hasEventCost && hasLocation && hasValidTime) {

						int costInt = Integer.parseInt(eventCost);
						eventCost = Integer.toString(costInt);
						
						int response = JOptionPane.showConfirmDialog(null,
								"Are you sure you want to update this Event?", "Confirmation",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

						if (response == JOptionPane.YES_OPTION) {

							EventRequest updatedEvent = updateTable(imgAddress, title, description, startDateTime,
									endDateTime, eventCost, location);

							Database.updateEventRequestTable(user.getUsername(), updatedEvent);

							dispose();

						}
					}
				} else

					JOptionPane.showMessageDialog(null, "No change was made!", "Information",
							JOptionPane.INFORMATION_MESSAGE);

				UserHomeMenu.allRequestsLabel.setForeground(new Color(0, 0, 139));
				UserHomeMenu.createEventLabel.setForeground(Color.DARK_GRAY);
				UserHomeMenu.updateEventLabel.setForeground(Color.DARK_GRAY);
				UserHomeMenu.removeEventLabel.setForeground(Color.DARK_GRAY);
				UserHomeMenu.allEventsLabel.setForeground(Color.DARK_GRAY);

				UserHomeMenu.allEventRequestPanel.setVisible(true);
				UserHomeMenu.allEventPanel.setVisible(false);

				// if not empty and time is valid
				// add directly to the table
				// update database
			}

			private EventRequest updateTable(String imgAddress, String title, String description, String startDateTime,
					String endDateTime, String eventCost, String location) {
				// TODO Auto-generated method stub

				byte[] image = null;
				EventRequest updatedEvent = new EventRequest();

				updatedEvent.setEventID(selectedEvent.getEventID());
				updatedEvent.setEventName(title);
				updatedEvent.setEventDescription(description);
				updatedEvent.setStartTime(startDateTime);
				updatedEvent.setEndTime(endDateTime);
				updatedEvent.setEventCost(eventCost);
				updatedEvent.setLocation(location);
				updatedEvent.setDetails();

				if (!imgAddress.equals("")) {

					File file = new File(imgAddress);

					try {

						FileInputStream imgFile = new FileInputStream(file);
						image = imgFile.readAllBytes();
						updatedEvent.setImg(image);

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else {

					image = selectedEvent.getImg();
					updatedEvent.setImg(image);

				}

				DefaultTableModel model = (DefaultTableModel) UserHomeMenu.eventTable.getModel();

				for (int i = 0; i < model.getRowCount(); i++) {

					if ((int) model.getValueAt(i, 1) == selectedEvent.getEventID()) {

						model.setValueAt(image, i, 0);
						model.setValueAt(updatedEvent.getDetails(), i, 2);
						model.setValueAt("Pending", i, 3);

						UserHomeMenu.eventTable.setModel(model);
						UserHomeMenu.eventTable.setRowHeight(300);
						UserHomeMenu.eventTable.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());
						UserHomeMenu.eventTable.getColumnModel().getColumn(2)
								.setCellRenderer(new MultipleLineRenderer());
						UserHomeMenu.eventTable.getColumnModel().getColumn(3)
								.setCellRenderer(new MultipleLineRenderer());

						// System.out.println("Id-found with title:- " + model.getValueAt(i, 2) );

						// model.setValueAt(aValue, i, 1);

					}
				}

				return updatedEvent;
			}

			private boolean didFieldsChanged(String imgAddress, String title, String description, String startDateTime,
					String endDateTime, String eventCost, String location) {
				// TODO Auto-generated method stub

				if (!imgAddress.equals(""))
					return true;
				if (!title.equals(selectedEvent.getEventName()))
					return true;
				if (!description.equals(selectedEvent.getEventDescription()))
					return true;
				if (!startDateTime.equals(selectedEvent.getStartTime()))
					return true;
				if (!endDateTime.equals(selectedEvent.getEndTime()))
					return true;
				if (!eventCost.equals(selectedEvent.getEventCost()))
					return true;
				if (!location.equals(selectedEvent.getLocation()))
					return true;

				return false;
			}
		});
		updateEventButton.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		updateEventButton.setFocusable(false);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				UserHomeMenu.allRequestsLabel.setForeground(new Color(0, 0, 139));
				UserHomeMenu.createEventLabel.setForeground(Color.DARK_GRAY);
				UserHomeMenu.updateEventLabel.setForeground(Color.DARK_GRAY);
				UserHomeMenu.removeEventLabel.setForeground(Color.DARK_GRAY);
				UserHomeMenu.allEventsLabel.setForeground(Color.DARK_GRAY);

				UserHomeMenu.allEventRequestPanel.setVisible(true);
				UserHomeMenu.allEventPanel.setVisible(false);

				dispose();
			}
		});
		cancelButton.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		cancelButton.setFocusable(false);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(addEventPanel, GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(19).addGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(56)
								.addComponent(addTitleLabel, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
								.addGap(10)
								.addComponent(titleTextField, GroupLayout.PREFERRED_SIZE, 173,
										GroupLayout.PREFERRED_SIZE)
								.addGap(141)
								.addComponent(startTimeLabel, GroupLayout.PREFERRED_SIZE, 97,
										GroupLayout.PREFERRED_SIZE)
								.addGap(19)
								.addComponent(startTimeJFTextField, GroupLayout.PREFERRED_SIZE, 147,
										GroupLayout.PREFERRED_SIZE)
								.addGap(10)
								.addComponent(startTimeButton, GroupLayout.PREFERRED_SIZE, 31,
										GroupLayout.PREFERRED_SIZE)
								.addGap(6)
								.addComponent(startTimeComboBox, GroupLayout.PREFERRED_SIZE, 97,
										GroupLayout.PREFERRED_SIZE)
								.addGap(6).addComponent(startTimeAmPmComboBox, GroupLayout.PREFERRED_SIZE, 47,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(descriptionLabel, GroupLayout.PREFERRED_SIZE, 108,
												GroupLayout.PREFERRED_SIZE)
										.addGap(10)
										.addComponent(
												scrollPane, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
										.addGap(47)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup().addGap(17)
														.addComponent(endTimeLabel, GroupLayout.PREFERRED_SIZE, 95,
																GroupLayout.PREFERRED_SIZE))
												.addComponent(eventCostLabel, GroupLayout.PREFERRED_SIZE, 98,
														GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_contentPane.createSequentialGroup().addGap(19)
														.addComponent(locationLabel, GroupLayout.PREFERRED_SIZE, 79,
																GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(56)
										.addComponent(imgLabel, GroupLayout.PREFERRED_SIZE, 52,
												GroupLayout.PREFERRED_SIZE)
										.addGap(10).addComponent(imageHolderPanel, GroupLayout.PREFERRED_SIZE, 267,
												GroupLayout.PREFERRED_SIZE)))
								.addGap(4)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_contentPane.createSequentialGroup().addGap(4)
												.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 161,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
												.addComponent(updateEventButton, GroupLayout.PREFERRED_SIZE, 161,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(endTimeJFTextField, GroupLayout.PREFERRED_SIZE, 147,
														GroupLayout.PREFERRED_SIZE)
												.addGap(10)
												.addComponent(endTimeButton, GroupLayout.PREFERRED_SIZE, 31,
														GroupLayout.PREFERRED_SIZE)
												.addGap(6)
												.addComponent(endTimeComboBox, GroupLayout.PREFERRED_SIZE, 97,
														GroupLayout.PREFERRED_SIZE)
												.addGap(6).addComponent(endTimeAmPmComboBox, GroupLayout.PREFERRED_SIZE,
														47, GroupLayout.PREFERRED_SIZE))
										.addComponent(eventCostTextField, GroupLayout.PREFERRED_SIZE, 116,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(locationTextArea, GroupLayout.PREFERRED_SIZE, 328,
												GroupLayout.PREFERRED_SIZE))))
						.addGap(23)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addComponent(addEventPanel, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE).addGap(36)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(3).addComponent(addTitleLabel,
								GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(titleTextField, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(3).addComponent(startTimeLabel,
								GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(startTimeJFTextField, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(2).addComponent(startTimeButton))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(3).addComponent(startTimeComboBox,
								GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(3).addComponent(startTimeAmPmComboBox,
								GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(20).addComponent(descriptionLabel,
								GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(3)
								.addComponent(endTimeLabel, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addGap(29)
								.addComponent(eventCostLabel, GroupLayout.PREFERRED_SIZE, 16,
										GroupLayout.PREFERRED_SIZE)
								.addGap(27).addComponent(locationLabel, GroupLayout.PREFERRED_SIZE, 16,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
								.createParallelGroup(Alignment.LEADING)
								.addComponent(endTimeJFTextField, GroupLayout.PREFERRED_SIZE, 22,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(2).addComponent(endTimeButton))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(3).addComponent(endTimeComboBox,
										GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(3).addComponent(
										endTimeAmPmComboBox, GroupLayout.PREFERRED_SIZE, 19,
										GroupLayout.PREFERRED_SIZE)))
								.addGap(22)
								.addComponent(eventCostTextField, GroupLayout.PREFERRED_SIZE, 22,
										GroupLayout.PREFERRED_SIZE)
								.addGap(22).addComponent(locationTextArea, GroupLayout.PREFERRED_SIZE, 65,
										GroupLayout.PREFERRED_SIZE)))
				.addGap(6)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(15).addComponent(imgLabel,
								GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(imageHolderPanel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(50)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(updateEventButton, GroupLayout.PREFERRED_SIZE, 25,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 25,
												GroupLayout.PREFERRED_SIZE))))
				.addContainerGap(22, Short.MAX_VALUE)));

		descriptionTextArea = new JTextArea();
		descriptionTextArea.setText(selectedEvent.getEventDescription());
		scrollPane.setViewportView(descriptionTextArea);
		contentPane.setLayout(gl_contentPane);
	}

	public String getFormattedDate(Date time) {

		String notFormattedTime = time.toString();
		String formattedTime = "";

		formattedTime += notFormattedTime.substring(4, 10) + ", "
				+ notFormattedTime.substring(notFormattedTime.length() - 4, notFormattedTime.length());

		if (formattedTime.charAt(4) == '0') {

			formattedTime = formattedTime.substring(0, 4) + formattedTime.substring(5, formattedTime.length());
		}

		return formattedTime;
	}

	public String getFormattedTime(String time) {

		if (time.charAt(time.length() - 7) == ' ')
			return time.substring(time.length() - 6, time.length() - 2);

		else
			return time.substring(time.length() - 7, time.length() - 2);

	}

	public String getFormattedPMOrAM(String time) {

		return (time.charAt(time.length() - 2) == 'P' ? "PM" : "AM");
	}

	public static EventRequest getSelectedEvent() {
		return selectedEvent;
	}

	public static void setSelectedEvent(EventRequest selectedEvent) {
		UpdateRequest.selectedEvent = selectedEvent;
	}

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
			ImageIcon imageIcon = new ImageIcon(
					new ImageIcon(photoName).getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));

			return new JLabel(imageIcon);
		}

	}

	private class MultipleLineRenderer implements TableCellRenderer {

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {

			JLabel text = new JLabel();
			text.setText("<html>" + (String) value + "</html>");
			text.setVerticalTextPosition(JLabel.TOP);

			return text;
		}

	}
}
