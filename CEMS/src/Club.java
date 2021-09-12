
public class Club {

	byte[] img;
	String name;
	String description;
	int numMembers;

	public Club(byte[] img, String name, String description, int numMembers) {

		this.img = img;
		this.name = name;
		this.description = description;
		this.numMembers = numMembers;

	}
	
	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNumMembers() {
		return numMembers;
	}

	public void setNumMembers(int numMembers) {
		this.numMembers = numMembers;
	}

	public Object[] getRow() {
		
		return new Object[] {this.img,this.name,this.description,this.numMembers};
	}
	
}
