 public class EventRequest extends Event {
    	
    	String approved;
    	String MadeBy;

		public EventRequest() {
    		
    	}
    	
		public EventRequest(int eID, byte[] address, String title, String description, String start, String end, String cost, String loc) {
    		super(eID,address,title,description,start,end,cost,loc);
    		
    	}
		
		public EventRequest(int eID, byte[] address, String title, String description, String start, String end, String cost, String loc, String apr) {
    		super(eID,address,title,description,start,end,cost,loc);
    		this.approved = apr;
    		this.setDetails();
    		//this.details = (this.getEventName() + "<br>"+ this.getEventDescription() +"<br>Starts: "+ this.getStartTime() + "<br>Ends: " + this.getEndTime() + "<br>Cost: $" + this.getEventCost() + "<br>Located: " + this.getLocation());
    		
    	}
	
		public String getApproval() {
			return approved;
		}


		public void setApproved(String approved) {
			this.approved = approved;
		}
		
		public String getMadeBy() {
			return MadeBy;
		}

		public void setMadeBy(String madeBy) {
			MadeBy = madeBy;
		}

		
		public Object[] getRequestRow() {
	    	
	    	Object[] row = {this.getImg(),this.getEventID(),this.details, this.approved};
	    	
	    	return row;
	    	
	    }
		
		public static void main(String[] args) {
			
			EventRequest event = new EventRequest(1,null,"Event","Description","startTime","endTime","10","Location","Approved");
			
			//System.out.println((String)(this.getEventName() + "\n\n"+ this.getEventDescription() +"\nDuration: "+ this.getStartTime() + " - " + this.getEndTime() + "\nCost: $" + this.getEventCost() + "\nLocated: " + this.getLocation()))
			
		}
    }