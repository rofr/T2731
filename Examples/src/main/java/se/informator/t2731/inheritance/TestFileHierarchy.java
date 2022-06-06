package se.informator.t2731.inheritance;

public class TestFileHierarchy {

	public static void main(String[] args){
	    File f = new File ("MyFile"); 		 // File reference to File
	  	File tf = new TextFile("MyTextFile"); // File reference to TextFile	  	
	  	File xmlf = new XMLFile("MyXMLFile"); // File reference to XMLFile
	  	
	  	String test = "This is just a test";
	  	byte[] byteArray = test.getBytes();
	  	
	  	f.write(byteArray);		// File.write(...)
	  	tf.write(byteArray);	// Overridden TextFile.write(...)
	  	
	  	int n = tf.getSize(); 	// Inherited File.getSize()
	  	System.out.println(tf.getFilename()+ " holds "+ n + " chars");	  	

	  	String xmlFileName = xmlf.getFilename(); // inherited File.getFilename()
	  	System.out.println("XML file: "+xmlFileName);
	}
}
