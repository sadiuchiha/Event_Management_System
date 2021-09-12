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

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.TransferHandler;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class CreateClubFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nameTextField;
	private String droppedImgAddress;
	private JTextArea descriptionTextArea;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateClubFrame frame = new CreateClubFrame();
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
	public CreateClubFrame() {
		
		setTitle("Create");
		ImageIcon logoImage = new ImageIcon("src/resource/weMeetLogo.png");
		setIconImage(logoImage.getImage());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 642, 554);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel addEventPanel = new JPanel();
		addEventPanel.setLayout(null);
		addEventPanel.setBorder(new LineBorder(new Color(0, 191, 255), 7));
		addEventPanel.setBackground(new Color(64, 224, 208));
		
		JLabel createClubLabel = new JLabel("Create Club");
		createClubLabel.setHorizontalAlignment(SwingConstants.CENTER);
		createClubLabel.setFont(new Font("OCR A Extended", Font.BOLD, 30));
		createClubLabel.setBounds(134, 31, 366, 57);
		addEventPanel.add(createClubLabel);
		
		JLabel addNameLabel = new JLabel("Title");
		addNameLabel.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		
		nameTextField = new JTextField();
		nameTextField.setText((String) null);
		nameTextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nameTextField.setColumns(10);
		
		JLabel descriptionLabel = new JLabel("Description");
		descriptionLabel.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		
		JScrollPane descriptionScrollPane = new JScrollPane();
		
		JLabel imgLabel = new JLabel("Image");
		imgLabel.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		
		JPanel imageHolderPanel = new JPanel();
		imageHolderPanel.setLayout(null);
		
		
		
		JLabel dropImageLabel = new JLabel();
		dropImageLabel.setText("Drop Image");
		dropImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dropImageLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dropImageLabel.setBounds(0, 0, 267, 75);
		imageHolderPanel.add(dropImageLabel);
		
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

		
		JButton addClubButton = new JButton("Add Club");
		addClubButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String name = nameTextField.getText();
				String description = descriptionTextArea.getText();
				
				String error = "";
				
				if(name.equals("")) {
					
					
					error += "[Name]";
				}
				
				if(description.equals("")) {
					
					error += "[Description]";

				}
				
				if(droppedImgAddress.equals("")) {
					
					error += "[Image]";

				}

				if(!error.equals("")) JOptionPane.showMessageDialog(null, "The field (" + error + ") is missing!", "Error", JOptionPane.ERROR_MESSAGE);
				
				else {
				
				
				FileInputStream imgFile = null;
				File image = new File(droppedImgAddress);
				byte[] img = null;
				
				try {
					
					imgFile = new FileInputStream(image);
					img = imgFile.readAllBytes();
				} catch(Exception e1) {
					
					
				}
						
				Club club = new Club(img,name,description,0);
				
				Database.addClub(club);
				Database.createClubTable(club.getName());
				
				AdminHomeMenu.allClubs.setForeground(new Color(0, 0, 139));
				AdminHomeMenu.createClubLabel.setForeground(Color.DARK_GRAY);
				AdminHomeMenu.removeClub.setForeground(Color.DARK_GRAY);
				loadAllClubs();
				
				JOptionPane.showMessageDialog(null, "The new club has been added successfully!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
				
				dispose();
				
				}
				
			}
		});
		addClubButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton cancelbutton = new JButton("Cancel");
		cancelbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminHomeMenu.allClubs.setForeground(new Color(0, 0, 139));
				AdminHomeMenu.createClubLabel.setForeground(Color.DARK_GRAY);
				AdminHomeMenu.removeClub.setForeground(Color.DARK_GRAY);
				dispose();

				
			}
		});
		cancelbutton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(75)
							.addComponent(addNameLabel, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(19)
							.addComponent(descriptionLabel, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(descriptionScrollPane, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(75)
							.addComponent(imgLabel, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(imageHolderPanel, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE))
						.addComponent(addEventPanel, GroupLayout.PREFERRED_SIZE, 616, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(308, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(359, Short.MAX_VALUE)
					.addComponent(cancelbutton, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(addClubButton)
					.addGap(37))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(addEventPanel, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(addNameLabel, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addComponent(descriptionLabel, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(descriptionScrollPane, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
					.addGap(23)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(15)
							.addComponent(imgLabel, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(imageHolderPanel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(addClubButton)
						.addComponent(cancelbutton, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		
		 descriptionTextArea = new JTextArea();
		descriptionScrollPane.setViewportView(descriptionTextArea);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void loadAllClubs() {
		// Loads all clubs in a list
		
		ArrayList<Club> clubList = Database.getAllClubs();
		String[] header = { "Image", "Name", "description", "NumberOfMember" };

		DefaultTableModel model = new DefaultTableModel(new Object[][] {}, header);

		for (Club club : clubList) {

			// DefaultTableModel model = (DefaultTableModel) HomeMenu.eventTable.getModel();
			// ImageIcon image = new ImageIcon(new
			// ImageIcon(event.getImg()).getImage().getScaledInstance(150, 150,
			// Image.SCALE_SMOOTH));
			model.addRow(new Object[]{club.getImg(), club.getName(),club.getDescription(), club.getNumMembers()});

		}

		AdminHomeMenu.allClubTable.setModel(model);
		AdminHomeMenu.allClubTable.setRowHeight(300);
		AdminHomeMenu.allClubTable.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer(300));
		AdminHomeMenu.allClubTable.getColumnModel().getColumn(2).setCellRenderer(new MultipleLineRenderer());


		
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
