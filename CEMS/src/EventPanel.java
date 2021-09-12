import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;



import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EventPanel extends JPanel {

	
	static JTextArea descriptionTextArea;
	static JTable eventTable;
	
	/**
	 * Create the panel.
	 */
	public EventPanel() {
		
		
		
		JScrollPane homeScrollPane = new JScrollPane();
		
		JScrollPane eventDescriptionScrollPane = new JScrollPane();
		
		JPanel eventDescriptionPanel = new JPanel();
		eventDescriptionPanel.setBackground(Color.LIGHT_GRAY);
		
		JLabel eventDescriptionLabel = new JLabel("Description");
		eventDescriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		eventDescriptionLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 15));
		GroupLayout gl_eventDescriptionPanel = new GroupLayout(eventDescriptionPanel);
		gl_eventDescriptionPanel.setHorizontalGroup(
			gl_eventDescriptionPanel.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 472, Short.MAX_VALUE)
				.addGroup(gl_eventDescriptionPanel.createSequentialGroup()
					.addGap(142)
					.addComponent(eventDescriptionLabel, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
					.addGap(117))
		);
		gl_eventDescriptionPanel.setVerticalGroup(
			gl_eventDescriptionPanel.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 41, Short.MAX_VALUE)
				.addGroup(gl_eventDescriptionPanel.createSequentialGroup()
					.addContainerGap(15, Short.MAX_VALUE)
					.addComponent(eventDescriptionLabel)
					.addContainerGap())
		);
		eventDescriptionPanel.setLayout(gl_eventDescriptionPanel);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(homeScrollPane, GroupLayout.PREFERRED_SIZE, 587, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(eventDescriptionPanel, GroupLayout.PREFERRED_SIZE, 472, GroupLayout.PREFERRED_SIZE)
						.addComponent(eventDescriptionScrollPane, GroupLayout.PREFERRED_SIZE, 472, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(homeScrollPane, GroupLayout.PREFERRED_SIZE, 534, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(eventDescriptionPanel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addComponent(eventDescriptionScrollPane, GroupLayout.PREFERRED_SIZE, 493, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		eventTable = new JTable();
		
		 setEventTableToEventList(eventTable);		
		
		homeScrollPane.setViewportView(eventTable);
		
		descriptionTextArea = new JTextArea();
		descriptionTextArea.setLineWrap(true);
		descriptionTextArea.setWrapStyleWord(true);
		descriptionTextArea.setEditable(false);
		eventDescriptionScrollPane.setViewportView(descriptionTextArea);
		setLayout(groupLayout);

	}
	

	private void setEventTableToEventList(JTable table) {
		// converts the table to eventList
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			
					int[] getSelectedRow = table.getSelectedRows();

					if (getSelectedRow.length > 1)
						JOptionPane.showMessageDialog(null, "Select 1 event at a time to show description!", "Information",
								JOptionPane.WARNING_MESSAGE);

					else {

						DefaultTableModel eventModel = (DefaultTableModel) table.getModel();
						int eventID = (int) eventModel.getValueAt(getSelectedRow[0], 1);
						String eventName = (String) eventModel.getValueAt(getSelectedRow[0], 2);

						System.out.println("Pressed: " + eventID + " " + eventName);
						System.out.println("Row value " + getSelectedRow[0]);

						loadEventDetails(eventID);
					}

				}
			
		});
		table.setColumnSelectionAllowed(false);
		table.setCellSelectionEnabled(false);
		table.setDefaultEditor(Object.class, null);
		table.setRowSelectionAllowed(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));

		DefaultTableModel eventTableModel = new DefaultTableModel(new Object[][] {}, new String[] { "IMG", "EventID",
				"EventTittle" });

		table.setModel(eventTableModel);
	}

	protected static void loadEventDetails(int eventID) {
		// Set description of the selected event
		//setText
		Event event = Database.getEvent(eventID);
		descriptionTextArea.setText((String)event.getDetails()); 
		
		
	}
	
	protected static void clearDetails() {
		// Set description of the selected event
		//setText
		descriptionTextArea.setText(""); 
		
		
	}
	
	public static void loadEventsList() {

		ArrayList<Event> eventList = Database.getAllEvents();
		String[] header = { "Image", "EventID", "EventTitle"};

		DefaultTableModel model = new DefaultTableModel(new Object[][] {}, header);

		for (Event event : eventList) {

			model.addRow(new Object[] { event.getImg(), event.getEventID(), event.getEventName() });

		}

		eventTable.setModel(model);
		eventTable.setRowHeight(150);
		eventTable.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer(150));

	}
	
	public static JTable getEventTable() {
		return eventTable;
	}

	public static void setEventTable(JTable eventTable) {
		EventPanel.eventTable = eventTable;
	}



	// Renders image when called
	private static class ImageRenderer implements TableCellRenderer {

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
