
public class ClubRequest {

	String username;
	String firstName;
	String lastName;
	String email;
	String appliedTo;
	String approved;

	public ClubRequest() {

	}

	public ClubRequest(String username, String firstName, String lastName, String email, String appliedTo, String approved) {

		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.appliedTo = appliedTo;
		this.approved = approved;
	
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAppliedTo() {
		return appliedTo;
	}

	public void setAppliedTo(String appliedTo) {
		this.appliedTo = appliedTo;
	}

	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

	public Object[] getRow() {
		
		return new Object[] {this.username, this.firstName, this.lastName, this.email, this.appliedTo, this.approved};
	}
	
}
