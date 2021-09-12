public class Event {    
    
	private byte[] img;
	private int eventID;
    private String eventTitle;
    private String eventDescription;
    private String startTime;
    private String endTime;
    private String eventCost;
    private String location;
    Object details;


    public Event() {
        
    }
    
    public Event(String title) {
    	
    	this.eventID = 1;
    	this.eventTitle = title;
    	this.eventDescription = "This is event making test. No drill going on here.";
    	this.startTime = "01/01/2222 8:00 Pm";
    	this.endTime = "01/01/2222 9:00 Pm";
    	this.eventCost = "10.10";
    	this.location = "Above the red cloud";
    	
    }
    
    public Event(int eID, byte[] address, String title, String description, String start, String end, String cost, String loc) {        
       
    	this.img = address;
    	this.eventID = eID;
        this.eventTitle = title;
        this.eventDescription = description;
        this.startTime = start;
        this.endTime = end;
        this.eventCost = cost;
        this.location = loc;
        setDetails();
    }
    
    public int getEventID() {
        return eventID;
    }
    
    public void setEventID(int id){
        this.eventID = id;
    }
    
    public String getEventName() {
        return eventTitle;
    }
    
    public void setEventName(String newEventName) {
        this.eventTitle = newEventName;
    }
    
    public String getEventDescription() {
        return eventDescription;
    }
    
    public void setEventDescription(String newEventDescription) {
        this.eventDescription = newEventDescription;
    }
    
    public String getStartTime() {
        return startTime;
    }
            
    public void setStartTime(String newStartDate) {
        this.startTime = newStartDate;
    }
    
    public String getEndTime() {
        return endTime;
    }
    
    public void setEndTime(String newEndDate) {
        this.endTime = newEndDate;
    }
    
    public String getEventCost() {
        return eventCost;
    }
    
    public void setEventCost(String newEventCost) {
        this.eventCost = newEventCost;
    } 
    
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] imgAddress) {
		this.img = imgAddress;
	}
	public Object getDetails() {
		return details;
	}

	public void setDetails() {
		this.details = (this.getEventName() + "\n\n"+ this.getEventDescription() +"\nStarts: "+ this.getStartTime() + "\nEnds: " + this.getEndTime() + "\nCost: $" + this.getEventCost() + "\nLocated: " + this.getLocation());
	}
    
    public Object[] getRow() {
    	
    	Object[] row = {this.img,this.eventID,this.eventTitle,this.eventDescription,this.startTime,this.endTime,this.eventCost,this.location};
    	
    	return row;
    	
    }
}
