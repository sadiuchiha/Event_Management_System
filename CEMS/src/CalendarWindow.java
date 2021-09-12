import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mindfusion.common.DateTime;
import com.mindfusion.scheduling.Calendar;

public class CalendarWindow extends JFrame {

	private JPanel contentPane;
	Calendar calendar = new Calendar();
	java.util.Calendar selectedDate = java.util.Calendar.getInstance();
	protected PropertyChangeSupport changeSupport;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalendarWindow frame = new CalendarWindow();
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
	public CalendarWindow() {
		
		ImageIcon logoImage = new ImageIcon("src/resource/weMeetLogo.png");
		setIconImage(logoImage.getImage());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 276, 202);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(calendar,BorderLayout.CENTER);
		setContentPane(contentPane);
		
		changeSupport = new PropertyChangeSupport(this);
		calendar.addMouseListener(new MouseAdapter() {	
			public void mouseClicked(MouseEvent e) {
				
				if(e.getClickCount() == 1) {
					
					
					calendar.getSelection().reset();
					DateTime pointedDate = calendar.getDateAt(e.getX(), e.getY());
					
					java.util.Calendar cal = java.util.Calendar.getInstance();
					cal.set(pointedDate.getYear(), pointedDate.getMonth() - 1, pointedDate.getDay());
					
					setSelectedDate(cal);
					
					dispose();
				}
				
			}
			
		});
		
		
	}
	
	public void resetSelection(Date date) {
		
		calendar.getSelection().reset();
		
		calendar.getSelection().set(new DateTime(date));
		
		calendar.setDate(new DateTime(date));
	}
	
	public java.util.Calendar getSelectedDate() {
		return selectedDate;
	}

	public void setSelectedDate(java.util.Calendar newDate) {

		java.util.Calendar oldDate = (java.util.Calendar)selectedDate.clone();
		selectedDate = newDate;
		
		changeSupport.firePropertyChange("selectedDate", oldDate, selectedDate);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener ) {
		
		changeSupport.addPropertyChangeListener(listener);
	}

}
