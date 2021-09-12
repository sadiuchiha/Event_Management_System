
public class TableMaker {
	
	String[] header;
	Object[] contents;
	
	public TableMaker() {
		
	}
	
	public TableMaker(String[] header, Object[] contents) {
		
		this.header = header;
		this.contents = contents;
		
	}
	
	public String[] getHeader() {
		return header;
	}

	public void setHeader(String[] header) {
		this.header = header;
	}

	public Object[] getContents() {
		return contents;
	}

	public void setContents(Object[] contents) {
		this.contents = contents;
	}

}
