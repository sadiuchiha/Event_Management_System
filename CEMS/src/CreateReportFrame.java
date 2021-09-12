import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileFilter;

import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class CreateReportFrame extends JFrame {

	private JPanel contentPane;
	private JTextArea reportTextArea;
	private static String savePath = "c:\\";
	private String reportType;
	private static Event event;
	private static Club club;
	private static MemberInfo user;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateReportFrame frame = new CreateReportFrame(null, null);
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
	public CreateReportFrame(String type, MemberInfo user) {
		
		this.reportType = type;
		this.user = user;
		
		ImageIcon logoImage = new ImageIcon("src/resource/weMeetLogo.png");
		setIconImage(logoImage.getImage());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 767, 575);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(50, 205, 50));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(30, 144, 255), 4));
		panel.setBackground(new Color(100, 149, 237));
		
		JLabel lblNewLabel = new JLabel("Report Message");
		lblNewLabel.setFont(new Font("OCR A Extended", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JScrollPane reportMessageScrollPane = new JScrollPane();
		
		JButton createReportButton = new JButton("Create Report");
		createReportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String report = reportTextArea.getText();
				 
				if(report.length() < 30) {
					
					int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to submit the report (Your report is shorter then 30 Characters!)?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					
					if(response == JOptionPane.YES_OPTION) {
						
						if(openDirectoryChooserToSavePDF(type, report)) dispose();

					}
					
				} else {
					
					int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to submit the report?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					
					if(response == JOptionPane.YES_OPTION) {
						
						if(openDirectoryChooserToSavePDF(type, report)) dispose();
	
					}
					
				}	
			}
		});
		createReportButton.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		
		JButton cancelButton = new JButton("Cancel Button");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				dispose();
			
			}
		});
		cancelButton.setFont(new Font("OCR A Extended", Font.BOLD, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(166)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(reportMessageScrollPane, GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
							.addGap(114))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
								.addGap(130))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(199, Short.MAX_VALUE)))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(265)
					.addComponent(cancelButton, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(createReportButton, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
					.addGap(145))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(31)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(91)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(reportMessageScrollPane, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(createReportButton, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		
		reportTextArea = new JTextArea();
		reportMessageScrollPane.setViewportView(reportTextArea);
		
		JLabel reportDetailLabel = new JLabel("Report Detail");
		reportDetailLabel.setBackground(new Color(0, 0, 128));
		reportDetailLabel.setHorizontalAlignment(SwingConstants.CENTER);
		reportDetailLabel.setForeground(new Color(0, 0, 128));
		reportDetailLabel.setFont(new Font("OCR A Extended", Font.BOLD, 25));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(72)
					.addComponent(reportDetailLabel, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
					.addGap(73))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(reportDetailLabel, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	
	
	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public static boolean openDirectoryChooserToSavePDF(String type, String report) {
		// Opens up directory to save file at choosen position.

			JFileChooser fileChooser = new JFileChooser(new File(savePath));
			fileChooser.setDialogTitle("Choose a location to save the report!");	
			fileChooser.setFileFilter(new FileTypeFilter(".pdf", "PDF File"));
			int result = fileChooser.showSaveDialog(null);
			boolean reportCreated = false;
			if (result == JFileChooser.APPROVE_OPTION) {

				
				savePath = fileChooser.getSelectedFile().getAbsolutePath();
				System.out.print(savePath);
				
				PDFMaker reportMaker = new PDFMaker(savePath);

				if (type.equals("forClub")) reportCreated = reportMaker.createClubReport(club, user, report);
				else reportCreated = reportMaker.createEventReport(event, user, report);

				if(reportCreated)  {JOptionPane.showMessageDialog(null, "The report was made successfully!", "Confirmation",
						JOptionPane.INFORMATION_MESSAGE);
							
				return true;
				}
			}
			
			return false;
	}
	
	public static class FileTypeFilter extends FileFilter {

		private final String extension;
		private final String description;

		public FileTypeFilter(String extension, String description) {

			this.extension = extension;
			this.description = description;
		}

		@Override
		public boolean accept(File file) {
			// Accepts file type

			if (file.isDirectory())
				return true;

			return file.getName().endsWith(this.extension);
		}

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return this.description + String.format(" (*%s", this.extension);
		}

	}
	
}
