package se.informator.t2731.date;

import java.io.*;
import java.util.*;

public class JavaDateFileSupport {

	/**
	 * This method stores a List of JavaDate objects into a textfile
	 * @param dates the collection to store
	 * @param filename the name of the file to create and store data in
	 */
	// try with resources will automatically close the opened resource
	public static void storeTextCollection(List<JavaDate> dates, String filename){

		try(PrintWriter pw = new PrintWriter(new FileWriter(filename))){		
			for(JavaDate date : dates){
				pw.println(date.toString());					
			}
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}

	}

	/**
	 * This method reads a List of JavaDate objects from a textfile
	 * @param filename the name of the file to create and store data in
	 * @return a List of JavaDate objects that has been read from file
	 */
	public static List<JavaDate> readTextCollection(String filename){

		List<JavaDate> dateList = new ArrayList<JavaDate>();

		try (BufferedReader br = new BufferedReader(new FileReader(filename))){

			while(br.ready()){
				String entry = br.readLine();
				JavaDate temp = new JavaDate(entry);
				dateList.add(temp);
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}

		return dateList;
	}


	/**
	 * This method stores a List of JavaDate objects into a binary file
	 * @param dates the collection to store
	 * @param filename the name of the file to create and store data in
	 */
	public static void storeBinaryDates(List<JavaDate> dates, String filename){

		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))){

			for(JavaDate jd : dates){
				dos.writeInt(jd.getYear());
				dos.writeInt(jd.getMonth());
				dos.writeInt(jd.getDay());				
			}
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}

	}


	/**
	 * This method reads a List of JavaDate objects from a binary file
	 * @param filename the name of the file to create and store data in
	 * @return a List of JavaDate objects that has been read from file
	 */
	public static List<JavaDate> readBinaryDates(String filename){

		List<JavaDate> tmpList = new ArrayList<JavaDate>();

		try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))){

			while(dis.available() != 0){
				int tmpYear = dis.readInt();
				int tmpMonth = dis.readInt();
				int tmpDay = dis.readInt();

				JavaDate temp = new JavaDate(tmpYear, tmpMonth, tmpDay);
				tmpList.add(temp);
			}
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}

		return tmpList;		
	}


	/**
	 * This method stores a List of JavaDate objects into a serialized file
	 * @param dates the collection to store
	 * @param filename the name of the file to create and store data in
	 */
	public static void storeObjectDates(List<JavaDate> dates, String filename){

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
			oos.writeObject(dates);
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}

	}


	/**
	 * This method reads a List of JavaDate objects from a serialized file
	 * @param filename the name of the file to create and store data in
	 * @return a List of JavaDate objects that has been read from file
	 */
	@SuppressWarnings("unchecked")
	public static List<JavaDate> readObjectDates(String filename){

		List<JavaDate> tmpList = new ArrayList<JavaDate>();

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
			tmpList = (ArrayList<JavaDate>)ois.readObject();	
		} 
		catch(IOException|ClassNotFoundException|ClassCastException e){
			e.printStackTrace();
		}	

		return tmpList;		
	}	

}
