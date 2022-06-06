package se.informator.t2731.inheritance;

public class XMLFile extends File{
	
	public XMLFile(String name){
		super(name, "xml");
	}
	
	@Override
	public void write(byte[] byteArray){
		int tagCount = 0;
		// convert byteArray to <tag>value</tag>
		setSize(getSize() + tagCount);
	}
}
