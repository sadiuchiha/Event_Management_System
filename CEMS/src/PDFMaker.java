import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.Line;

public class PDFMaker {

	String path = "C:\\";

	public PDFMaker() {

	}

	public PDFMaker(String path) {

		this.path = path + ".pdf";
	}

	public boolean createClubReport(Club club, MemberInfo user, String report) {

		String introText = "This report was made to show details of an event or club activities which may contain budget details, location, duration and description of the event. Furthermore"
				+ ", if the report is of events, will also show number of people attending. Else it will show club activity details and it's event list and total budget.\n\n"
				+ "1) Content: Right now you are on the Content page.\n" + "2) Club And it's details\n" + "3) Events And Activities\n"  + "4) Report\n";
		
		String reportMaker = "Made by: " + user.getLastName() + " " + user.getFirstName();
		String clubName = "\n" + club.getName() + "\n\n";
		String clubDescription = club.getDescription() + "\n";
		String numberOfMembers = "Currently the club consist of " + club.getNumMembers() + " members\n\n";
		
		Document document = new Document();
		
		//*****************************************************Fonts
		Font titleFont = new Font();
		titleFont.setStyle(Font.BOLD);
		titleFont.setColor(new BaseColor(0, 0, 55));
		titleFont.setSize(26);

		Font textFont = new Font();
		textFont.setColor(new BaseColor(0, 0, 0));
		textFont.setFamily("HELVITICA");
		textFont.setSize(15);

		Font textHeadingFont = new Font();
		textHeadingFont.setColor(new BaseColor(0, 0, 200));
		textHeadingFont.setStyle(Font.BOLD);
		textHeadingFont.setFamily("HELVITICA");
		textHeadingFont.setSize(22);
		
		Font textHeading2Font = new Font();
		textHeading2Font.setColor(new BaseColor(0, 200, 0));
		textHeading2Font.setStyle(Font.BOLD);
		textHeading2Font.setFamily("HELVITICA");
		textHeading2Font.setSize(22);
		//******************************************************
		
		try {

			PdfWriter.getInstance(document, new FileOutputStream(new File(getPath())));
			document.open();

			Rectangle imgHolder = new Rectangle(500, 1000);
			
			Rectangle clubLogoHolder = new Rectangle(250, 250);


			Image reportLogoImage = Image.getInstance("src/resource/logo.png");
			reportLogoImage.scaleToFit(imgHolder);
			reportLogoImage.setAlignment(Element.ALIGN_CENTER);
			document.add(reportLogoImage);

			Paragraph title = new Paragraph("\nWeMeet\n\n", titleFont);
			title.setAlignment(Element.ALIGN_CENTER);
			document.add(title);
			
			Paragraph contentHeading = new Paragraph("Content\n\n", textHeadingFont);
			contentHeading.setAlignment(Element.ALIGN_LEFT);
			document.add(contentHeading);
			
			Paragraph introductionText = new Paragraph(introText, textFont);
			introductionText.setAlignment(Element.ALIGN_LEFT);
			document.add(introductionText);
			
			Image clubLogoImage = Image.getInstance(club.getImg());
			clubLogoImage.scaleToFit(clubLogoImage);
			clubLogoImage.setAlignment(Element.ALIGN_CENTER);
			document.add(clubLogoImage);
			
			Paragraph clubNameText = new Paragraph(clubName, textHeading2Font);
			clubNameText.setAlignment(Element.ALIGN_LEFT);
			document.add(clubNameText);
			
			Paragraph clubDescriptionText = new Paragraph(clubDescription, textFont);
			clubDescriptionText.setAlignment(Element.ALIGN_LEFT);
			document.add(clubDescriptionText);
			
			Paragraph numberOfMembersText = new Paragraph(numberOfMembers, textFont);
			numberOfMembersText.setAlignment(Element.ALIGN_LEFT);
			document.add(numberOfMembersText);
			
			Paragraph eventHeading = new Paragraph("\n\n\nEvents\n\n", textHeadingFont);
			eventHeading.setAlignment(Element.ALIGN_LEFT);
			document.add(eventHeading);

			ArrayList<Event> eventList = Database.getClubEvents(club.getName());
			
			for(Event event : eventList) addEvent(document, event);				
			
			if (!report.equals("")) {

				Paragraph reportHeading = new Paragraph("Report\n\n", textHeadingFont);
				reportHeading.setAlignment(Element.ALIGN_LEFT);
				document.add(reportHeading);

				Paragraph reportText = new Paragraph(report + "\n\n", textFont);
				reportText.setAlignment(Element.ALIGN_LEFT);
				document.add(reportText);

			}

			Paragraph reportMakerText = new Paragraph(reportMaker, textFont);
			reportMakerText.setAlignment(Element.ALIGN_RIGHT);
			document.add(reportMakerText);

			document.close();

			return true;

		} catch (DocumentException | IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}

	}

	public boolean createEventReport(Event event, MemberInfo user, String report) {
		// Generates an event report pdf

		String introText = "This report was made to show details of an event or club activities which may contain budget details, location, duration and description of the event. Furthermore"
				+ ", if the report is of events, will also show number of people attending. Else it will show club activity details and it's event list and total budget.\n\n"
				+ "1) Content: Right now you are on the Content page.\n" + "2) Event\n" + "3) Report\n";

		String reportMaker = "Made by: " + user.getLastName() + " " + user.getFirstName();

		Document document = new Document();

		try {

			PdfWriter.getInstance(document, new FileOutputStream(new File(getPath())));
			document.open();

			Rectangle imgHolder = new Rectangle(500, 1000);

			Image reportLogoImage = Image.getInstance("src/resource/logo.png");
			reportLogoImage.scaleToFit(imgHolder);
			reportLogoImage.setAlignment(Element.ALIGN_CENTER);

			document.add(reportLogoImage);

			Font titleFont = new Font();
			titleFont.setStyle(Font.BOLD);
			titleFont.setColor(new BaseColor(0, 0, 55));
			titleFont.setSize(26);

			Font textFont = new Font();
			textFont.setColor(new BaseColor(0, 0, 0));
			textFont.setFamily("HELVITICA");
			textFont.setSize(15);

			Font textHeadingFont = new Font();
			textHeadingFont.setColor(new BaseColor(0, 0, 200));
			textHeadingFont.setStyle(Font.BOLD);
			textHeadingFont.setFamily("HELVITICA");
			textHeadingFont.setSize(22);

			Paragraph title = new Paragraph("\nWeMeet\n\n", titleFont);
			title.setAlignment(Element.ALIGN_CENTER);
			document.add(title);

			Paragraph contentHeading = new Paragraph("Content\n\n", textHeadingFont);
			contentHeading.setAlignment(Element.ALIGN_LEFT);
			document.add(contentHeading);

			Paragraph introductionText = new Paragraph(introText, textFont);
			introductionText.setAlignment(Element.ALIGN_LEFT);
			document.add(introductionText);

			Paragraph eventHeading = new Paragraph("\n\n\nEvent\n\n", textHeadingFont);
			eventHeading.setAlignment(Element.ALIGN_LEFT);
			document.add(eventHeading);

			addEvent(document, event);

			if (!report.equals("")) {

				Paragraph reportHeading = new Paragraph("Report\n\n", textHeadingFont);
				reportHeading.setAlignment(Element.ALIGN_LEFT);
				document.add(reportHeading);

				Paragraph reportText = new Paragraph(report + "\n\n", textFont);
				reportText.setAlignment(Element.ALIGN_LEFT);
				document.add(reportText);

			}

			Paragraph reportMakerText = new Paragraph(reportMaker, textFont);
			reportMakerText.setAlignment(Element.ALIGN_RIGHT);
			document.add(reportMakerText);

			document.close();

			return true;

		} catch (DocumentException | IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

			return false;
		}

	}

	public void addEvent(Document document, Event event) {
		// Adds an event section to the document

			String eventName = "\n\n" + event.getEventName() + "\n\n";

			String eventDetail = event.getEventDescription() + "\n\nStart Time: " + event.getStartTime() + "\nEndTime: "
					+ event.getEndTime() + "\nBudget: $" + event.getEventCost() + "\nLoaction: " + event.getLocation()
					+ "\n\n";

			String attendeeNumbers = "The number of people invited to the event is: "
					+ Database.getInvitedAttendees(event) + "\n\n";

			Font textFont = new Font();
			textFont.setColor(new BaseColor(0, 0, 0));
			textFont.setFamily("HELVITICA");
			textFont.setSize(15);

			Font textHeading2Font = new Font();
			textHeading2Font.setColor(new BaseColor(200, 0, 0));
			textHeading2Font.setStyle(Font.BOLD);
			textHeading2Font.setFamily("HELVITICA");
			textHeading2Font.setSize(16);

			Rectangle eventImgHolder = new Rectangle(400, 800);

			Image eventImage;
			Paragraph eventNameText = new Paragraph(eventName, textHeading2Font);
			Paragraph eventDetailText = new Paragraph(eventDetail, textFont);
			Paragraph numberOfPeopleText = new Paragraph(attendeeNumbers, textFont);

			try {

				eventImage = Image.getInstance(event.getImg());
				eventImage.scaleToFit(eventImgHolder);
				eventImage.setAlignment(Element.ALIGN_CENTER);

				
				
				document.add(eventImage);
				document.add(eventNameText);
				document.add(eventDetailText);
				document.add(numberOfPeopleText);

			} catch (IOException | DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		

	}

	// sets file path of the pdf to be made
	public void setPath(String path) {

		this.path = path;
	}

	public String getPath() {

		return this.path;
	}

	public static void main(String[] arg) {

		PDFMaker report = new PDFMaker();
		// report.createPDF();
	}

}
