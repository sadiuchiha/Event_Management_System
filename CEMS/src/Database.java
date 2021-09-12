import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {

	//Not a local server.
	
	private static String ipAddress;
	private static String JDBCDriver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://sql6.freemysqlhosting.net:3306";
	private static String user = "sql6404070";
	private static String password = "1pTvkeaRS6";
	private static String DBName = "sql6404070";

	static void createDatabase() { // Creates a database

		Connection conn = null;
		Statement createDB = null;

		String sql = "CREATE DATABASE IF NOT EXISTS " + DBName;

		try {
			Class.forName(JDBCDriver);

			conn = DriverManager.getConnection(url, user, password);
			createDB = conn.createStatement();
			createDB.executeUpdate(sql);
			
			conn.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (!url.substring(url.length() - DBName.length(), url.length()).equals(DBName)) {

			url += "/" + DBName;
		}
		
	}

	public static void createMembersTable() { // Creates memberTable for members who signs up

		Connection conn = null;
		Statement createMemTable = null;

		String sql = "CREATE TABLE IF NOT EXISTS memberInfo(memberID int(10) NOT NULL, FirstName VarChar(45) NOT NULL,"
				+ " LastName VarChar(45), Username VarChar(45), Email Varchar(45), Password VarChar(45), Admin VarChar(1), PRIMARY KEY(memberID))";

		try {

			conn = DriverManager.getConnection(url, user, password);
			createMemTable = conn.createStatement();
			createMemTable.executeUpdate(sql);

			conn.close();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void createEventTable() {

		String sql = "CREATE TABLE IF NOT EXISTS EventList(EventID INT(10) NOT NULL," + "Image LongBlob,"
				+ "Title Varchar(45)," + "Description Varchar(9000)," + "StartTime Varchar(45),"
				+ "EndTime Varchar(45)," + "EventCost VarChar(10)," + "Location VarChar(100), PRIMARY KEY(EventID))";

		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			Statement createTable = conn.createStatement();
			createTable.execute(sql);

			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void createEventsMadeByTable() {

		String sql = "CREATE TABLE IF NOT EXISTS EventsMadeBy(EventID INT(10) NOT NULL, EventName VarChar(45), MadeBy VarChar(45), Club VarChar(45), PRIMARY KEY(EventID))";

		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			Statement createTable = conn.createStatement();
			createTable.execute(sql);
			
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void createEventRequestTable() {

		String sql = "CREATE TABLE IF NOT EXISTS EventRequestList(EventReqID INT(10) NOT NULL," + "Image LongBlob,"
				+ "Title Varchar(45)," + "Description Varchar(9000)," + "StartTime Varchar(45),"
				+ "EndTime Varchar(45)," + "EventCost VarChar(10),"
				+ "Location VarChar(100), MadeBy VarChar(45), Approved VarChar(45), PRIMARY KEY(EventReqID))";

		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			Statement createTable = conn.createStatement();
			createTable.execute(sql);
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void createAttendeeEventTable(int eventID, String eventName) {

		eventName = eventName.replace(' ', '_');
		eventName = eventName.replace('-', '_');

		String sql = "CREATE TABLE IF NOT EXISTS " + eventName + eventID
				+ "_Attendees(Email VarChar(75), Status VarChar(45))";

		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			Statement createTable = conn.createStatement();
			createTable.execute(sql);
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void createAttendeeTable() {

		String sql = "CREATE TABLE IF NOT EXISTS Attendees(Email VarChar(75))";

		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			Statement createTable = conn.createStatement();
			createTable.execute(sql);
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void createEventRequestTable(String username) {

		String sql = "CREATE TABLE IF NOT EXISTS " + username + "_EventRequestList(EventReqID INT(10) NOT NULL,"
				+ "Image LongBlob," + "Title Varchar(45)," + "Description Varchar(9000)," + "StartTime Varchar(45),"
				+ "EndTime Varchar(45)," + "EventCost VarChar(10),"
				+ "Location VarChar(100), Approved VarChar(45), PRIMARY KEY(EventReqID))";

		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			Statement createTable = conn.createStatement();
			createTable.execute(sql);
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void createClubRequestTable() {

		String sql = "CREATE TABLE IF NOT EXISTS ClubRequestList(Username Varchar(45)," + "FirstName Varchar(45),"
				+ "LastName Varchar(45)," + "Email Varchar(45), AppliedTo VarChar(45), Approved VarChar(45))";

		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			Statement createTable = conn.createStatement();
			createTable.execute(sql);

			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void createClubListTable() {

		String sql = "CREATE TABLE IF NOT EXISTS ClubList(Image LongBlob," + "Name VarChar(45),"
				+ "Description Varchar(9000)," + "NumberOfMember Int(10))";

		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			Statement createTable = conn.createStatement();
			createTable.execute(sql);

			conn.close();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void createClubTable(String clubName) {

		clubName = clubName.replace(' ', '_');
		String sql = "CREATE TABLE IF NOT EXISTS " + clubName + "_Club(FirstName VarChar(45)," + "LastName VarChar(45),"
				+ "Username Varchar(45)," + "Email VarChar(45))";

		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			Statement createTable = conn.createStatement();
			createTable.execute(sql);
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void createMembersClubTable() { // Creates member club table for members.

		Connection conn = null;
		Statement createMemClub = null;

		String sql = "CREATE TABLE IF NOT EXISTS memberClub(memberID int(10) NOT NULL, FirstName VarChar(45) NOT NULL,"
				+ " LastName VarChar(45), Username VarChar(45), Email Varchar(45), Club VarChar(45), PRIMARY KEY(memberID))";

		try {

			conn = DriverManager.getConnection(url, user, password);
			createMemClub = conn.createStatement();
			createMemClub.executeUpdate(sql);
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void dropClubTable(String name) {

		name = name.replace(' ', '_');

		Connection conn = null;
		Statement deleteMemClub = null;

		String sql = "DROP TABLE " + DBName + "." + name + "_Club";

		try {

			conn = DriverManager.getConnection(url, user, password);
			deleteMemClub = conn.createStatement();
			deleteMemClub.executeUpdate(sql);
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void dropEventAttendeeTable(String eventName, int eventID) {

		eventName = eventName.replace(' ', '_');
		eventName = eventName.replace('-', '_');


		Connection conn = null;
		Statement deleteAttendeeTable = null;

		String sql = "DROP TABLE " + DBName + "." + eventName + eventID + "_Attendees";

		try {

			conn = DriverManager.getConnection(url, user, password);
			deleteAttendeeTable = conn.createStatement();
			deleteAttendeeTable.executeUpdate(sql);
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String registerNewUser(String username, String email, String firstName, String lastName,
			String memPassword) { // Register the new user information to memberInfo

		String msg = "";

		try {

			Connection conn = DriverManager.getConnection(url, user, password);

			Statement addUser = conn.createStatement();
			Statement checkID = conn.createStatement();

			ResultSet checkSize = checkID.executeQuery("SELECT count(Email) from memberInfo");
			int sizeOfRS = (checkSize.next()) ? checkSize.getInt("count(Email)") : 0;

			System.out.println("The size is " + sizeOfRS);

			addUser.executeUpdate(
					insertNewMember(sizeOfRS + 1, firstName, lastName, username, email, memPassword, "F")); // Admin is
																											// not
																											// given by
																											// default
																											// "F" or
																											// false

			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Registration successful.";
	}

	public static boolean usernameInUse(String username) {

		boolean usernameListIsEmpty = false;

		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			Statement checkUsernames = conn.createStatement();

			ResultSet usernameList = checkUsernames
					.executeQuery("SELECT Username from memberInfo WHERE Username = '" + username + "'");
			usernameListIsEmpty = usernameList.isBeforeFirst();
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return usernameListIsEmpty;
	}

	public static boolean emailInUse(String email) {

		boolean emailListIsEmpty = false;

		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			Statement checkEmail = conn.createStatement();

			ResultSet emailList = checkEmail.executeQuery("SELECT Email from memberInfo WHERE Email = '" + email + "'");
			emailListIsEmpty = emailList.isBeforeFirst();
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emailListIsEmpty;
	}

	public static String insertNewMember(int memberID, String fn, String ln, String username, String email,
			String password, String admin) {

		String sql = "insert into memberInfo (memberID, FirstName, LastName, Username, Email, Password, Admin) "
				+ "values ('" + memberID + "', '" + fn + "', '" + ln + "', '" + username + "', '" + email + "', '"
				+ password + "', '" + admin + "')";

		return sql;
	}

	public static void updatePassword(String newPassword) {

		String sql = "UPDATE " + DBName + "memberInfo set password = '" + newPassword + "' WHERE email = '"
				+ ForgotPasswordFrame.getAuthEmail() + "'";

		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			Statement updatePass = conn.createStatement();
			updatePass.executeUpdate(sql);

			conn.close();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void addClub(Club club) {

		createClubListTable();
		createClubTable(club.getName());

		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement insertClub = conn.prepareStatement(
					"INSERT into ClubList( Image, Name, Description, NumberOfMember) values (?,?,?,?)");

			insertClub.setBytes(1, club.getImg());
			insertClub.setString(2, club.getName());
			insertClub.setString(3, club.getDescription());
			insertClub.setInt(4, getSizeOfClub(club.getName()));
			insertClub.executeUpdate();
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void addEventRequest(String username, String title, String description, String startDate,
			String endDate, String eventCost, String location, byte[] imgFile) {

		createEventRequestTable(username);
		createEventRequestTable();

		int eventID = getSizeEventRequests() + 1;

		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement insertEvent = conn.prepareStatement("INSERT into " + username
					+ "_EventRequestList(EventReqID, Image, Title, Description, StartTime, EndTime, EventCost, Location, Approved) values (?,?,?,?,?,?,?,?,?)");
			insertEvent.setInt(1, eventID);
			insertEvent.setBytes(2, imgFile);
			insertEvent.setString(3, title);
			insertEvent.setString(4, description);
			insertEvent.setString(5, startDate);
			insertEvent.setString(6, endDate);
			insertEvent.setString(7, eventCost);
			insertEvent.setString(8, location);
			insertEvent.setString(9, "Pending");

			insertEvent.executeUpdate();

			insertEvent = conn.prepareStatement(
					"INSERT into EventRequestList(EventReqID, Image, Title, Description, StartTime, EndTime, EventCost, Location, MadeBy, Approved) values (?,?,?,?,?,?,?,?,?,?)");
			insertEvent.setInt(1, eventID);
			insertEvent.setBytes(2, imgFile);
			insertEvent.setString(3, title);
			insertEvent.setString(4, description);
			insertEvent.setString(5, startDate);
			insertEvent.setString(6, endDate);
			insertEvent.setString(7, eventCost);
			insertEvent.setString(8, location);
			insertEvent.setString(9, username);
			insertEvent.setString(10, "Pending");

			insertEvent.executeUpdate();
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void addEvent(String title, String description, String startDate, String endDate, String eventCost,
			String location, FileInputStream imgFile, MemberInfo userInfo) {

		createEventTable();
		int eventID = getSizeEvent() + 1;

		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement insertEvent = conn.prepareStatement(
					"INSERT into EventList(EventID, Image, Title, Description, StartTime, EndTime, EventCost, Location) values (?,?,?,?,?,?,?,?)");
			insertEvent.setInt(1, eventID);
			insertEvent.setBinaryStream(2, imgFile, imgFile.available());
			insertEvent.setString(3, title);
			insertEvent.setString(4, description);
			insertEvent.setString(5, startDate);
			insertEvent.setString(6, endDate);
			insertEvent.setString(7, eventCost);
			insertEvent.setString(8, location);

			insertEvent.executeUpdate();
			
			conn.close();


		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		createAttendeeEventTable(eventID, title);
		EventRequest event = new EventRequest();
		event.setEventName(title);
		event.setEventID(eventID);
		event.setMadeBy(userInfo.getUsername());
		addEventAndCreators(event);
		
		
	}

	public static void addAttendee(String email) {

		createAttendeeTable();

		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement insertEmail = conn.prepareStatement("INSERT into Attendees(Email) values (?)");
			insertEmail.setString(1, email);

			insertEmail.executeUpdate();
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Makesure to check before adding any duplicate
	public static void addAttendeeToEvent(String email, int eventID, String eventName) {

		createAttendeeTable();
		createAttendeeEventTable(eventID, eventName);

		eventName = eventName.replace(' ', '_');
		eventName = eventName.replace('-', '_');


		System.out.println("Initiate add!");

		if (!checkEmailInEventAttendeeExist(email, eventID, eventName)) {

			System.out.println(email);

			try {

				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement insertEmail = conn.prepareStatement(
						"INSERT into " + eventName + eventID + "_Attendees(Email, Status) values (?,?)");
				insertEmail.setString(1, email);
				insertEmail.setString(2, "Loaded");

				insertEmail.executeUpdate();
				
				conn.close();


			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (!attendeeExist(email))
			addAttendee(email);
	}
	
	public static void updateAllInviteStatus( int eventID, String eventName) {
		// Set status to Invited.
		
		eventName = eventName.replace(' ', '_');
		eventName = eventName.replace('-', '_');
		
		String status = "Invited";
		String sql = "UPDATE " + DBName + "." + eventName + eventID + "_Attendees SET Status = ?";
	
		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement updateRow = conn.prepareStatement(sql);
			updateRow.setString(1, status);

			updateRow.executeUpdate();
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void updateInviteStatus(String email, int eventID, String eventName) {
		// Set status to Invited.
		
		eventName = eventName.replace(' ', '_');
		eventName = eventName.replace('-', '_');
		
		String status = "Invited";
		String sql = "UPDATE " + DBName + "." + eventName + eventID + "_Attendees SET Status = ? WHERE Email = '" + email + "'";
	
		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement updateRow = conn.prepareStatement(sql);
			updateRow.setString(1, status);

			updateRow.executeUpdate();

			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<String> getAllEmail(int eventID, String eventName) {
		// gets all email
		
		eventName = eventName.replace(' ', '_');
		eventName = eventName.replace('-', '_');
		
		String sql = "SELECT email FROM " + DBName + "." + eventName + eventID + "_Attendees";
		ArrayList<String> emailList = new ArrayList<String>();
		String emails = "";
		
		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			Statement updateRow = conn.createStatement();

			ResultSet emailListSet = updateRow.executeQuery(sql);
			

			
			while(emailListSet.next()) {
				
				emailList.add(emailListSet.getString("Email"));
				
			}	
				conn.close();

				return emailList;
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return emailList;
	}
	
	public static ArrayList<String> getAllLoadedEmail(int eventID, String eventName) {
		// gets all email
		
		eventName = eventName.replace(' ', '_');
		eventName = eventName.replace('-', '_');
		
		String sql = "SELECT email FROM " + DBName + "." + eventName + eventID + "_Attendees WHERE Status = 'Loaded'";
		ArrayList<String> emailList = new ArrayList<String>();
		String emails = "";
		
		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			Statement updateRow = conn.createStatement();

			ResultSet emailListSet = updateRow.executeQuery(sql);
			

			
			while(emailListSet.next()) {
				
				emailList.add(emailListSet.getString("Email"));
				
			}
			
			
			conn.close();
				
				return emailList;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return emailList;
	}
	
	public static boolean checkInvited(int eventID, String eventName) {
		// Check whether mail was sent already to everyone in the mailList
		
		eventName = eventName.replace(' ', '_');
		eventName = eventName.replace('-', '_');
		
		String sql = "SELECT Status From " + DBName + "." + eventName + eventID + "_Attendees WHERE Status = 'Loaded'";

		String emails = "";
		
		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			Statement updateRow = conn.createStatement();

			ResultSet emailListSet = updateRow.executeQuery(sql);
			

			
			if(emailListSet.isBeforeFirst()) {
				
				conn.close();

				return false;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	

	public static void addEvent(EventRequest event) {

		createEventTable();
		int eventID = getSizeEvent() + 1;

		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement insertEvent = conn.prepareStatement(
					"INSERT into EventList(EventID, Image, Title, Description, StartTime, EndTime, EventCost, Location) values (?,?,?,?,?,?,?,?)");
			insertEvent.setInt(1, eventID);
			insertEvent.setBytes(2, event.getImg());
			insertEvent.setString(3, event.getEventName());
			insertEvent.setString(4, event.getEventDescription());
			insertEvent.setString(5, event.getStartTime());
			insertEvent.setString(6, event.getEndTime());
			insertEvent.setString(7, event.getEventCost());
			insertEvent.setString(8, event.getLocation());

			insertEvent.executeUpdate();
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void addClubRequest(MemberInfo member, String clubName) {

		createClubRequestTable();

		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement insertEvent = conn.prepareStatement(
					"INSERT into ClubRequestList(Username, FirstName, LastName, Email, AppliedTo, Approved) values (?,?,?,?,?,?)");
			insertEvent.setString(1, member.getUsername());
			insertEvent.setString(2, member.getFirstName());
			insertEvent.setString(3, member.getLastName());
			insertEvent.setString(4, member.getEmail());
			insertEvent.setString(5, clubName);
			insertEvent.setString(6, "Pending");

			insertEvent.executeUpdate();
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean madeAClubRequest(MemberInfo member) {

		createClubRequestTable();

		String sql = "SELECT Username from " + DBName + ".ClubRequestList WHERE Username = '" + member.getUsername()
				+ "'";
		boolean isIn = false;

		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			Statement stmt = conn.createStatement();
			ResultSet inClubCheck = stmt.executeQuery(sql);

			isIn = inClubCheck.next();
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isIn;

	}

	public static void addMemberToClubList(MemberInfo member, String clubName) {

		createMembersClubTable();

		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement insertEvent = conn.prepareStatement(
					"INSERT into memberClub(memberID, FirstName, LastName, Username, Email, Club) values (?,?,?,?,?,?)");
			insertEvent.setInt(1, member.getMemberID());
			insertEvent.setString(2, member.getFirstName());
			insertEvent.setString(3, member.getLastName());
			insertEvent.setString(4, member.getUsername());
			insertEvent.setString(5, member.getEmail());
			insertEvent.setString(6, clubName);

			insertEvent.executeUpdate();
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		updateNumOfMembers(clubName);

		addMemberToClub(member, clubName);

	}

	public static void addMemberToClub(MemberInfo member, String clubName) {

		createClubTable(clubName);

		clubName = clubName.replace(' ', '_');

		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement inserMember = conn.prepareStatement(
					"INSERT into " + clubName + "_Club( Username,FirstName, LastName, Email) values (?,?,?,?)");
			inserMember.setString(1, member.getUsername());
			inserMember.setString(2, member.getFirstName());
			inserMember.setString(3, member.getLastName());
			inserMember.setString(4, member.getEmail());

			inserMember.executeUpdate();
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int getSizeEvent() {

		String sql = "SELECT EventID from EventList WHERE EventID = (SELECT max(EventID) FROM EventList)";
		int sizeOfRS = 0;
		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			Statement getSize = conn.createStatement();

			ResultSet checkSize = getSize.executeQuery(sql);
			sizeOfRS = (checkSize.next()) ? checkSize.getInt("EventID") : 0;
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sizeOfRS;

	}

	public static int getSizeEventRequests() {

		String sql = "SELECT EventReqID from EventRequestList WHERE EventReqID = (SELECT max(EventReqID) FROM EventRequestList)";
		int sizeOfRS = 0;
		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			Statement insertEvent = conn.createStatement();

			ResultSet checkSize = insertEvent.executeQuery(sql);
			sizeOfRS = (checkSize.next()) ? checkSize.getInt("EventReqID") : 0;
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sizeOfRS;

	}

	public static int getSizeEventRequests(String username) {

		String sql = "SELECT EventReqID from " + username
				+ "_EventRequestList WHERE EventReqID = (SELECT max(EventReqID) FROM " + username
				+ "_EventRequestList)";
		int sizeOfRS = 0;
		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			Statement insertEvent = conn.createStatement();

			ResultSet checkSize = insertEvent.executeQuery(sql);
			sizeOfRS = (checkSize.next()) ? checkSize.getInt("EventReqID") : 0;
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sizeOfRS;

	}

	public static Event getEvent(int id) {

		String sql = "SELECT * from EventList Where EventID = " + id;
		Event event = new Event();

		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			Statement getEventRow = conn.createStatement();

			ResultSet eventList = getEventRow.executeQuery(sql);

			while (eventList.next()) {

				event.setEventName(eventList.getString("Title"));
				event.setEventID(eventList.getInt("EventID"));
				event.setEventDescription(eventList.getString("Description"));
				event.setStartTime(eventList.getString("StartTime"));
				event.setEndTime(eventList.getString("EndTime"));
				event.setEventCost(eventList.getString("EventCost"));
				event.setLocation(eventList.getString("Location"));
				event.setImg(eventList.getBytes("Image"));
				event.setDetails();
			
			}

			conn.close();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return event;

	}

	public static EventRequest getEventReq(String username, int id) {

		String sql = "SELECT * from " + username + "_EventRequestList Where EventReqID = " + id;
		EventRequest event = new EventRequest();

		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			Statement getEventRow = conn.createStatement();

			ResultSet eventList = getEventRow.executeQuery(sql);

			while (eventList.next()) {

				event.setEventName(eventList.getString("Title"));
				event.setEventID(eventList.getInt("EventReqID"));
				event.setEventDescription(eventList.getString("Description"));
				event.setStartTime(eventList.getString("StartTime"));
				event.setEndTime(eventList.getString("EndTime"));
				event.setEventCost(eventList.getString("EventCost"));
				event.setLocation(eventList.getString("Location"));
				event.setImg(eventList.getBytes("Image"));
				event.setApproved(eventList.getString("Approved"));

				event.setDetails();

			}
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return event;

	}

	public static EventRequest getEventReq(int id) {

		String sql = "SELECT * from EventRequestList Where EventReqID = " + id;
		EventRequest event = new EventRequest();

		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			Statement getEventRow = conn.createStatement();

			ResultSet eventList = getEventRow.executeQuery(sql);

			while (eventList.next()) {

				event.setEventName(eventList.getString("Title"));
				event.setEventID(eventList.getInt("EventReqID"));
				event.setEventDescription(eventList.getString("Description"));
				event.setStartTime(eventList.getString("StartTime"));
				event.setEndTime(eventList.getString("EndTime"));
				event.setEventCost(eventList.getString("EventCost"));
				event.setLocation(eventList.getString("Location"));
				event.setImg(eventList.getBytes("Image"));
				event.setMadeBy(eventList.getString("MadeBy"));
				event.setApproved(eventList.getString("Approved"));
				event.setDetails();

			}
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return event;

	}

	public static ArrayList<EventRequest> getAllEventRequests() {

		createEventRequestTable();

		ArrayList<EventRequest> eventList = new ArrayList<EventRequest>();

		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			Statement getEventRows = conn.createStatement();

			String sqlForGettingEventRequest = "SELECT * from EventRequestList";
			ResultSet eventListTable = getEventRows.executeQuery(sqlForGettingEventRequest);
			


			while (eventListTable.next()) {

				EventRequest event = new EventRequest(

						eventListTable.getInt("EventReqID"), eventListTable.getBytes("Image"),
						eventListTable.getString("Title"), eventListTable.getString("Description"),
						eventListTable.getString("StartTime"), eventListTable.getString("EndTime"),
						eventListTable.getString("EventCost"), eventListTable.getString("Location"),
						eventListTable.getString("Approved")

				);

				event.setMadeBy(eventListTable.getString("MadeBy"));

				if (event.getApproval().equals("Pending"))
					eventList.add(event);
			}
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return eventList;

	}

	public static ArrayList<EventRequest> getUserEventRequests(String username) {

		// Get all user Requests

		createEventRequestTable(username);

		String sql = "SELECT * from " + username + "_EventRequestList";
		ArrayList<EventRequest> eventList = new ArrayList<EventRequest>();

		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			Statement getEventRows = conn.createStatement();

			ResultSet eventListTable = getEventRows.executeQuery(sql);
			


			while (eventListTable.next()) {

				EventRequest event = new EventRequest(

						eventListTable.getInt("EventReqID"), eventListTable.getBytes("Image"),
						eventListTable.getString("Title"), eventListTable.getString("Description"),
						eventListTable.getString("StartTime"), eventListTable.getString("EndTime"),
						eventListTable.getString("EventCost"), eventListTable.getString("Location"),
						eventListTable.getString("Approved")

				);

				event.setMadeBy(username);

				eventList.add(event);

			}
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return eventList;
	}

	public static ArrayList<Event> getAllEvents() {

		createEventTable();

		String sql = "SELECT * from EventList";
		ArrayList<Event> eventList = new ArrayList<Event>();

		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			Statement getEventRows = conn.createStatement();

			ResultSet eventListTable = getEventRows.executeQuery(sql);
			


			while (eventListTable.next()) {

				Event event = new Event(

						eventListTable.getInt("EventID"), eventListTable.getBytes("Image"),
						eventListTable.getString("Title"), eventListTable.getString("Description"),
						eventListTable.getString("StartTime"), eventListTable.getString("EndTime"),
						eventListTable.getString("EventCost"), eventListTable.getString("Location")

				);

				eventList.add(event);

			}
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return eventList;

	}

	public static ArrayList<Club> getAllClubs() {
		// TODO Auto-generated method stub
		createClubListTable();

		String sql = "SELECT * from ClubList";
		ArrayList<Club> clubList = new ArrayList<Club>();

		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			Statement getClubRows = conn.createStatement();

			ResultSet clubListTable = getClubRows.executeQuery(sql);
			


			while (clubListTable.next()) {

				String clubName = clubListTable.getString("Name");
				updateNumOfMembers(clubName);

				System.out.println(clubName + " at get All Club");

				Club club = new Club(

						clubListTable.getBytes("Image"), clubName, clubListTable.getString("Description"),
						clubListTable.getInt("NumberOfMember")

				);

				System.out.println("Size: " + club.getNumMembers());

				clubList.add(club);

			}
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return clubList;
	}

	public static ArrayList<ClubRequest> getAllClubRequest() {
		// Gets all club request.

		createClubRequestTable();

		ArrayList<ClubRequest> clubReqList = new ArrayList<ClubRequest>();
		Connection conn;
		String sql = "Select * from ClubRequestList";

		try {

			conn = DriverManager.getConnection(url, user, password);
			Statement getRows = conn.createStatement();
			ResultSet allRows = getRows.executeQuery(sql);


			while (allRows.next()) {

				ClubRequest cr = new ClubRequest();
				cr.setUsername(allRows.getString("Username"));
				cr.setFirstName(allRows.getString("FirstName"));
				cr.setLastName(allRows.getString("LastName"));
				cr.setEmail(allRows.getString("Email"));
				cr.setAppliedTo(allRows.getString("AppliedTo"));
				cr.setApproved(allRows.getString("Approved"));

				clubReqList.add(cr);

			}
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return clubReqList;
	}

	public static ArrayList<MemberInfo> getClubMembers(String clubName) {
		// TODO Auto-generated method stub

		clubName = clubName.replace(' ', '_');

		ArrayList<MemberInfo> memberList = new ArrayList<MemberInfo>();
		Connection conn;
		String sql = "Select * from " + DBName + "." + clubName + "_Club";

		try {

			conn = DriverManager.getConnection(url, user, password);
			Statement getRows = conn.createStatement();
			ResultSet allRows = getRows.executeQuery(sql);


			while (allRows.next()) {

				MemberInfo cr = new MemberInfo();
				cr.setUsername(allRows.getString("Username"));
				cr.setFirstName(allRows.getString("FirstName"));
				cr.setLastName(allRows.getString("LastName"));
				cr.setEmail(allRows.getString("Email"));
				memberList.add(cr);

			}

			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return memberList;
	}

	public static ArrayList<Object[]> getUserList() {

		ArrayList<Object[]> memberList = new ArrayList<Object[]>();

		Connection conn;
		String sql = "Select * from " + DBName + ".memberInfo";

		try {

			conn = DriverManager.getConnection(url, user, password);
			Statement getRows = conn.createStatement();
			ResultSet allRows = getRows.executeQuery(sql);


			
			while (allRows.next()) {

				MemberInfo cr = new MemberInfo();
				cr.setUsername(allRows.getString("Username"));
				cr.setFirstName(allRows.getString("FirstName"));
				cr.setLastName(allRows.getString("LastName"));
				cr.setEmail(allRows.getString("Email"));
				cr.setMemberID(allRows.getInt("MemberID"));
				cr.setAdmin(allRows.getString("Admin"));

				String club = getClubName(cr.getUsername());

				memberList.add(new Object[] { cr.getMemberID(), cr.getUsername(), cr.getFirstName(), cr.getLastName(),
						cr.getEmail(), club, cr.getAdmin() });

			}
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return memberList;
	}

	public static ArrayList<Object[]> getAttendees() {
		// TODO Auto-generated method stub

		createAttendeeTable();

		ArrayList<Object[]> emailList = new ArrayList<Object[]>();

		Connection conn;
		String sql = "Select * from " + DBName + ".Attendees";

		try {

			conn = DriverManager.getConnection(url, user, password);
			Statement getRows = conn.createStatement();
			ResultSet allRows = getRows.executeQuery(sql);


			
			while (allRows.next()) {

				emailList.add(new Object[] { allRows.getString("Email"), "Loaded" });

			}
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emailList;
	}

	public static ArrayList<Object[]> getAttendees(int eventID, String eventName) {
		// TODO Auto-generated method stub

		createAttendeeEventTable(eventID, eventName);

		ArrayList<Object[]> emailList = new ArrayList<Object[]>();
		eventName = eventName.replace(' ', '_');
		eventName = eventName.replace('-', '_');

		Connection conn;
		String sql = "Select * from " + DBName + "." + eventName + eventID + "_Attendees";

		try {

			conn = DriverManager.getConnection(url, user, password);
			Statement getRows = conn.createStatement();
			ResultSet allRows = getRows.executeQuery(sql);


			
			while (allRows.next()) {

				emailList.add(new Object[] { allRows.getString("Email"), allRows.getString("Status") });

			}
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emailList;
	}

	public static void removeClubRequest(String username) {

		Connection conn;
		String sql = "DELETE from ClubRequestList WHERE Username = '" + username + "'";

		try {

			conn = DriverManager.getConnection(url, user, password);
			Statement removeRow = conn.createStatement();
			removeRow.execute(sql);
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void removeEventRequest(String username, int EventReqID) {

		Connection conn;
		String sql = "DELETE from " + username + "_EventRequestList WHERE EventReqID = " + EventReqID;
		String sql2 = "DELETE from EventRequestList WHERE EventReqID = " + EventReqID;

		try {

			conn = DriverManager.getConnection(url, user, password);
			Statement removeRow = conn.createStatement();
			removeRow.execute(sql);

			removeRow = conn.createStatement();
			removeRow.execute(sql2);
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void removeEventRequest(int EventReqID) {

		Connection conn;
		String sql = "DELETE from EventRequestList WHERE EventReqID = " + EventReqID;

		try {

			conn = DriverManager.getConnection(url, user, password);
			Statement removeRow = conn.createStatement();
			removeRow.execute(sql);
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void removeEvent(String eventName,int eventID) {

		Connection conn;
		String sql = "DELETE from EventList WHERE eventID = " + eventID;

		try {

			conn = DriverManager.getConnection(url, user, password);
			Statement removeRow = conn.createStatement();
			removeRow.execute(sql);
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dropEventAttendeeTable(eventName,eventID);
		deleteEventsFromMadeBy(eventID);

	}
	
	public static void deleteEventsFromMadeBy(int eventID) {
		
		Connection conn;
		String sql = "DELETE from EventsMadeBy WHERE eventID = " + eventID;

		try {

			conn = DriverManager.getConnection(url, user, password);
			Statement removeRow = conn.createStatement();
			removeRow.execute(sql);
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getClubName(String username) {

		String club = "None";

		Connection conn;
		String sql = "SELECT Club from memberClub WHERE Username = '" + username + "'";

		try {

			conn = DriverManager.getConnection(url, user, password);
			Statement getClubName = conn.createStatement();
			ResultSet clubName = getClubName.executeQuery(sql);
			


			while (clubName.next())
				club = clubName.getString("Club");
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return club;
	}

	public static void removeAttendee(String email, int eventID, String eventName) {
		// TODO Auto-generated method stub

		eventName = eventName.replace(' ', '_');
		eventName = eventName.replace('-', '_');

		System.out.println("Remove attendee from" + eventID + " " + eventName);

		Connection conn;
		String sql = "DELETE from " + DBName + "." + eventName + eventID + "_Attendees WHERE Email = '" + email + "'";

		try {

			conn = DriverManager.getConnection(url, user, password);
			Statement removeRow = conn.createStatement();
			removeRow.execute(sql);
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void removeAllAttendee(int eventID, String eventName) {
		// TODO Auto-generated method stub

		eventName = eventName.replace(' ', '_');
		eventName = eventName.replace('-', '_');

		Connection conn;
		String sql = "DELETE from " + DBName + "." + eventName + eventID + "_Attendees";

		try {

			conn = DriverManager.getConnection(url, user, password);
			Statement removeRow = conn.createStatement();
			removeRow.execute(sql);
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void removeClub(String name) {

		Connection conn;
		String sql = "DELETE from ClubList WHERE Name = '" + name + "'";

		try {

			conn = DriverManager.getConnection(url, user, password);
			Statement removeRow = conn.createStatement();
			removeRow.execute(sql);
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void removeMemberFromClub(String username) {

		Connection conn;
		String sql = "DELETE from memberClub WHERE Username = '" + username + "'";

		try {

			conn = DriverManager.getConnection(url, user, password);
			Statement removeRow = conn.createStatement();
			removeRow.execute(sql);
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void removeMembersFromClub(String clubName) {

		Connection conn;
		String sql = "DELETE from memberClub WHERE Club = '" + clubName + "'";

		try {

			conn = DriverManager.getConnection(url, user, password);
			Statement removeRows = conn.createStatement();
			removeRows.execute(sql);
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void removeMemberFromClub(String username, String club) {

		Connection conn;

		String clubName = club.replace(' ', '_');

		String sql = "DELETE from " + DBName + "." + clubName + "_Club WHERE Username = '" + username + "'";

		try {

			conn = DriverManager.getConnection(url, user, password);
			Statement removeRow = conn.createStatement();
			removeRow.execute(sql);
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		removeMemberFromClub(username);

		updateNumOfMembers(club);

		// decrementNumOfMembers(club);

	}

	public static void updateEventRequestTable(String username, EventRequest updatedEvent) {
		// TODO Auto-generated method stub

		Connection conn;
		try {

			conn = DriverManager.getConnection(url, user, password);
			PreparedStatement updateRow = conn.prepareStatement("UPDATE " + DBName + "." + username
					+ "_EventRequestList SET Image = ?, Title = ?, Description = ?, StartTime = ?, EndTime = ?, EventCost = ?, Location = ? WHERE EventReqID = "
					+ updatedEvent.getEventID());
			updateRow.setBytes(1, updatedEvent.getImg());
			updateRow.setString(2, updatedEvent.getEventName());
			updateRow.setString(3, updatedEvent.getEventDescription());
			updateRow.setString(4, updatedEvent.getStartTime());
			updateRow.setString(5, updatedEvent.getEndTime());
			updateRow.setString(6, updatedEvent.getEventCost());
			updateRow.setString(7, updatedEvent.getLocation());
			updateRow.executeUpdate();

			updateRow = conn.prepareStatement("UPDATE " + DBName + "."
					+ "EventRequestList SET Image = ?, Title = ?, Description = ?, StartTime = ?, EndTime = ?, EventCost = ?, Location = ? WHERE EventReqID = "
					+ updatedEvent.getEventID());
			updateRow.setBytes(1, updatedEvent.getImg());
			updateRow.setString(2, updatedEvent.getEventName());
			updateRow.setString(3, updatedEvent.getEventDescription());
			updateRow.setString(4, updatedEvent.getStartTime());
			updateRow.setString(5, updatedEvent.getEndTime());
			updateRow.setString(6, updatedEvent.getEventCost());
			updateRow.setString(7, updatedEvent.getLocation());
			updateRow.executeUpdate();
			
			conn.close();


			// System.out.println("Update Successful? " + updatedEvent.getEventID());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public static void updateEventTable(Event updatedEvent) {
		// TODO Auto-generated method stub

		Connection conn;
		try {

			conn = DriverManager.getConnection(url, user, password);
			PreparedStatement updateRow = conn.prepareStatement("UPDATE " + DBName
					+ ".EventList SET Image = ?, Title = ?, Description = ?, StartTime = ?, EndTime = ?, EventCost = ?, Location = ? WHERE EventID = "
					+ updatedEvent.getEventID());
			updateRow.setBytes(1, updatedEvent.getImg());
			updateRow.setString(2, updatedEvent.getEventName());
			updateRow.setString(3, updatedEvent.getEventDescription());
			updateRow.setString(4, updatedEvent.getStartTime());
			updateRow.setString(5, updatedEvent.getEndTime());
			updateRow.setString(6, updatedEvent.getEventCost());
			updateRow.setString(7, updatedEvent.getLocation());
			updateRow.executeUpdate();
			
			conn.close();


			// System.out.println("Update Successful? " + updatedEvent.getEventID());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public static void updateClubTable(Club club, String name) {
		// TODO Auto-generated method stub

		Connection conn;
		try {

			conn = DriverManager.getConnection(url, user, password);
			PreparedStatement updateRow = conn.prepareStatement("UPDATE " + DBName
					+ ".ClubList SET Image = ?, Name = ?, Description = ?, WHERE Name = '" + name + "'");

			updateRow.setBytes(1, club.getImg());
			updateRow.setString(2, club.getName());
			updateRow.setString(3, club.getDescription());

			updateRow.executeUpdate();

			conn.close();

			// System.out.println("Update Successful? " + updatedEvent.getEventID());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public static void updateNumOfMembers(String clubName) {

		// TODO Auto-generated method stub
		System.out.println(clubName);

		int size = getSizeOfClub(clubName);

		System.out.println(clubName + "Updating size " + size);
		Connection conn;
		try {

			conn = DriverManager.getConnection(url, user, password);
			PreparedStatement updateRow = conn.prepareStatement(
					"UPDATE " + DBName + ".ClubList SET NumberOfMember = ? WHERE Name = '" + clubName + "'");

			updateRow.setInt(1, size);

			updateRow.executeUpdate();
			
			conn.close();


			// System.out.println("Update Successful? " + updatedEvent.getEventID());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public static int getSizeOfClub(String clubName) {
		// gets the size of the club

		clubName = clubName.replace(' ', '_');

		String sql = "SELECT count(Username) from " + DBName + "." + clubName + "_Club";
		int sizeOfRS = 0;
		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			Statement getSize = conn.createStatement();

			ResultSet checkSize = getSize.executeQuery(sql);
			sizeOfRS = (checkSize.next()) ? checkSize.getInt("count(Username)") : 0;
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(clubName + " " + sizeOfRS);

		return sizeOfRS;
	}

	public static boolean emailPassMatched(String email, String pass) {

		boolean matched = false;
		String sql = "SELECT Username from " + DBName + ".memberInfo WHERE Email = '" + email + "' AND password = '"
				+ pass + "'";

		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			Statement checkEmailAndPassword = conn.createStatement();

			ResultSet usernameList = checkEmailAndPassword.executeQuery(sql);
			matched = usernameList.isBeforeFirst();
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return matched;
	}

	public static boolean attendeeExist(String email) {

		boolean found = false;

		String sql = "SELECT Email from " + DBName + ".Attendees WHERE Email = '" + email + "'";

		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			Statement checkEmail = conn.createStatement();

			ResultSet usernameList = checkEmail.executeQuery(sql);
			found = usernameList.isBeforeFirst();
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return found;
	}

	public static boolean checkEmailInEventAttendeeExist(String email, int eventID, String eventName) {

		boolean found = false;
		eventName = eventName.replace(' ', '_');
		eventName = eventName.replace('-', '_');

		// System.out.println(found);

		String sql = "SELECT email from " + DBName + "." + eventName + eventID + "_Attendees WHERE Email = '" + email
				+ "'";

		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			Statement checkEmail = conn.createStatement();

			ResultSet usernameList = checkEmail.executeQuery(sql);
			found = usernameList.isBeforeFirst();
			
			conn.close();

			// System.out.println(found);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return found;
	}

	public static String getUsername(String email) {

		String sql = "SELECT Username from " + DBName + ".memberInfo WHERE Email = '" + email + "'";
		String username = "";

		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			Statement usernames = conn.createStatement();

			ResultSet usernameList = usernames.executeQuery(sql);
			


			while (usernameList.next()) {

				username = usernameList.getString("Username");

			}
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return username;
	}

	public static MemberInfo getMemberInfo(String email) {

		MemberInfo member = new MemberInfo();

		String sql = "SELECT * from " + DBName + ".memberInfo WHERE Email = '" + email + "'";
		String username = "";

		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			Statement usernames = conn.createStatement();

			ResultSet memberInfo = usernames.executeQuery(sql);
			


			while (memberInfo.next()) {

				member.setMemberID(memberInfo.getInt("MemberID"));
				member.setFirstName(memberInfo.getString("FirstName"));
				member.setLastName(memberInfo.getString("LastName"));
				member.setUsername(memberInfo.getString("Username"));
				member.setPassword(memberInfo.getString("Password"));
				member.setAdmin(memberInfo.getString("Admin"));
				member.setEmail(memberInfo.getString("Email"));

			}
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return member;
	}

	public static void updateMemberInfo(MemberInfo updatedMember) {

		Connection conn;

		try {

			conn = DriverManager.getConnection(url, user, password);
			PreparedStatement updateInfo = conn.prepareStatement("UPDATE " + DBName
					+ ".memberInfo SET FirstName = ?, LastName = ?, Username = ?, Email = ?, Password = ? WHERE MemberID = "
					+ updatedMember.getMemberID());

			updateInfo.setString(1, updatedMember.getFirstName());
			updateInfo.setString(2, updatedMember.getLastName());
			updateInfo.setString(3, updatedMember.getUsername());
			updateInfo.setString(4, updatedMember.getEmail());
			updateInfo.setString(5, updatedMember.getPassword());

			updateInfo.executeUpdate();
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public static void updateEmail(MemberInfo updatedMember) {

		Connection conn;

		try {

			conn = DriverManager.getConnection(url, user, password);
			PreparedStatement updateInfo = conn.prepareStatement(
					"UPDATE " + DBName + ".memberInfo SET Email = ? WHERE MemberID = " + updatedMember.getMemberID());

			updateInfo.setString(1, updatedMember.getEmail());

			updateInfo.executeUpdate();
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public static void updatePassword(MemberInfo updatedMember) {

		Connection conn;

		try {

			conn = DriverManager.getConnection(url, user, password);
			PreparedStatement updateInfo = conn.prepareStatement("UPDATE " + DBName
					+ ".memberInfo SET Password = ? WHERE MemberID = " + updatedMember.getMemberID());

			updateInfo.setString(1, updatedMember.getPassword());

			updateInfo.executeUpdate();
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	// not in use
	public static void passAdmin(String email) {

		Connection conn;

		try {

			conn = DriverManager.getConnection(url, user, password);
			PreparedStatement updateInfo = conn
					.prepareStatement("UPDATE " + DBName + ".memberInfo SET Admin = ? WHERE email = '" + email + "'");

			updateInfo.setString(1, "T");

			updateInfo.executeUpdate();
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public static boolean isInAClub(String username) {
		// Checks whether the member is in a club.

		createMembersClubTable();

		String sql = "SELECT Username from " + DBName + ".memberClub WHERE Username = '" + username + "'";
		boolean isIn = false;

		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			Statement stmt = conn.createStatement();
			ResultSet inClubCheck = stmt.executeQuery(sql);

			isIn = inClubCheck.isBeforeFirst();
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isIn;
	}

	public static boolean isAdmin(String email) {

		String sql = "SELECT Admin from " + DBName + ".memberInfo WHERE Email = '" + email + "'";
		boolean isAdmin = false;

		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			Statement stmt = conn.createStatement();
			ResultSet adminCheck = stmt.executeQuery(sql);

			while (adminCheck.next()) {

				isAdmin = (adminCheck.getString("Admin").equals("T")) ? true : false;

			}
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isAdmin;
	}

	public static void approveEventReq(int eventReqID) {
		// Approve request

		Connection conn;
		String getUsernameSQL = "SELECT MadeBy From EventRequestList WHERE EventReqID = " + eventReqID;
		String username = "";

		try {

			conn = DriverManager.getConnection(url, user, password);
			PreparedStatement updateInfo = conn.prepareStatement(
					"UPDATE " + DBName + ".EventRequestList SET Approved = ? WHERE EventReqID = " + eventReqID);
			Statement getUsername = conn.createStatement();

			updateInfo.setString(1, "Approved");
			updateInfo.executeUpdate();

			ResultSet usernameCont = getUsername.executeQuery(getUsernameSQL);

			while (usernameCont.next())
				username = usernameCont.getString("MadeBy");

			PreparedStatement updateInfoOnUsernameTB = conn.prepareStatement("UPDATE " + DBName + "." + username
					+ "_EventRequestList SET Approved = ? WHERE EventReqID = " + eventReqID);
			updateInfoOnUsernameTB.setString(1, "Approved");
			updateInfoOnUsernameTB.executeUpdate();
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	public static void addEventAndCreators(EventRequest event) {

		createEventsMadeByTable();
		String clubName = getClubName(event.getMadeBy());
		event.setEventID(getSizeEvent());

		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement insertEvent = conn
					.prepareStatement("INSERT into EventsMadeBy(EventID, EventName, MadeBy, Club) values (?,?,?,?)");
			insertEvent.setInt(1, event.getEventID());
			insertEvent.setString(2, event.getEventName());
			insertEvent.setString(3, event.getMadeBy());
			insertEvent.setString(4, clubName);

			insertEvent.executeUpdate();
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void denyEventReq(int eventReqID) {
		// Approve request

		Connection conn;
		String getUsernameSQL = "SELECT MadeBy From EventRequestList WHERE EventReqID = " + eventReqID;
		String username = "";

		try {

			conn = DriverManager.getConnection(url, user, password);
			PreparedStatement updateInfo = conn.prepareStatement(
					"UPDATE " + DBName + ".EventRequestList SET Approved = ? WHERE EventReqID = " + eventReqID);
			Statement getUsername = conn.createStatement();

			updateInfo.setString(1, "Denied");
			updateInfo.executeUpdate();

			ResultSet usernameCont = getUsername.executeQuery(getUsernameSQL);

			while (usernameCont.next())
				username = usernameCont.getString("MadeBy");

			PreparedStatement updateInfoOnUsernameTB = conn.prepareStatement("UPDATE " + DBName + "." + username
					+ "_EventRequestList SET Approved = ? WHERE EventReqID = " + eventReqID);
			updateInfoOnUsernameTB.setString(1, "Denied");
			updateInfoOnUsernameTB.executeUpdate();
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	public static boolean checkPasscodeForAdmin(String text) {
		// TODO Auto-generated method stub
		return text.equals("passmeadmin");
	}

	public static Club getClub(String clubName) {
		// TODO Auto-generated method stub
		
		Club club = null;	
		String sql = "SELECT * from ClubList WHERE Name = '" + clubName + "'";

		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			Statement getClub = conn.createStatement();

			ResultSet clubInfo = getClub.executeQuery(sql);
			


			while (clubInfo.next()) {

				club = new Club(
						clubInfo.getBytes("Image"),
						clubInfo.getString("Name"),
						clubInfo.getString("Description"),
						clubInfo.getInt("NumberOfMember")
						);


			}
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return club;
	}

	public static ArrayList<Event> getClubEvents(String clubName) {
		// Get Club events list

		String sql = "SELECT EventID from EventsMadeBy WHERE Club = '" + clubName + "'";
		ArrayList<Event> eventList = new ArrayList<Event>();

		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			Statement getEventRows = conn.createStatement();

			ResultSet eventListTable = getEventRows.executeQuery(sql);
			


			while (eventListTable.next()) {

				Event event = getEvent(eventListTable.getInt("EventID"));
				System.out.println("Loaded club event: " + event.getEventName());
				eventList.add(event);

			}
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return eventList;
	}

	public static int getInvitedAttendees(Event event) {
		// Returns the number of attendees

		int numOfAttendees = 0;
		String eventName = event.getEventName();

		eventName = eventName.replace('-', '_');
		eventName = eventName.replace(' ', '_');

		String sql = "SELECT count(Status) from " + DBName + "." + eventName + event.getEventID() + "_Attendees WHERE Status = 'Invited'";

		try {

			Connection conn = DriverManager.getConnection(url, user, password);
			Statement getNumber = conn.createStatement();

			ResultSet num = getNumber.executeQuery(sql);
			


			while (num.next())
				numOfAttendees = num.getInt("count(Status)");
			
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return numOfAttendees;
	}
	
	public static void main(String[] args) {

		/*
		 * MemberInfo member = getMemberInfo("sadiuchiha@gmail.com");
		 * System.out.println(member.toString());
		 * 
		 * member.setEmail("sadi@gmail.com"); updateEmail(member); member =
		 * getMemberInfo("sadi@gmail.com"); System.out.println(member.toString());
		 * 
		 * member.setEmail("sadiuchiha@gmail.com"); updateEmail(member); member =
		 * getMemberInfo("sadiuchiha@gmail.com"); System.out.println(member.toString());
		 * 
		 * createEventRequestTable();
		 */
		// passAdmin("sadiuchiha@gmail.com");

		//System.out.println(getSizeOfClub("Normal Club"));
		
		String cost = "0000001203";
		int costInt = Integer.parseInt(cost);
		
		System.out.println(costInt);

	}

	

	

}
