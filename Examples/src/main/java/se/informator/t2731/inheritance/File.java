package se.informator.t2731.inheritance;

public class File {
	
	private String filename;
	private int size;
	
	public File(String name){
		this(name, "tmp");
	}
	
	public File(String name, String type){
		filename = name+"."+type;		
		System.out.println("File created: "+filename);
	}
	
	public String getFilename(){
		return filename;
	}
	
	public void write(byte[] byteArray){
		// write as is to file
		size += byteArray.length;
	}
	
	public int getSize(){
		return size;
	}
	protected void setSize(int newSize){
		size = newSize;
	}
}
