package se.informator.t2731.intro;

public class Hello {

  public static void main(String[] args) {
	  
	  if(args.length > 0){
		  String temp = args[0];
		  System.out.println("Hello " + temp + "!");
	  }
	  else{
		  System.out.println("Hello World!");		  
	  }
  }
  
}