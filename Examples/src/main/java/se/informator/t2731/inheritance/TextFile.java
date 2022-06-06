package se.informator.t2731.inheritance;

public class TextFile extends File{
	
	public TextFile(String name){
		super(name, "txt");
	}
	
	@Override
	public void write(byte[] byteArray){
		int charCount = 0;
		// filter out non-writable chars	
		for(int i=0; i<byteArray.length; i++){
			if(Character.isLetterOrDigit(byteArray[i])){
				charCount++;
			}
		}
		setSize(super.getSize() + charCount);
	}
}
