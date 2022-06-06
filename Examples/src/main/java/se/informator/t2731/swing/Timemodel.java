/*
	Filename     : Timemodel.java
	Programmer   : Kjell H Carlsson
	Last Updated : 2006-10-09
*/

package se.informator.t2731.swing;

public final class Timemodel {

	public final static int HOUR_MAX=23;
	public final static int HOUR_MIN=0;

	public final static int MIN_MAX=59;
	public final static int MIN_MIN=0;

	public final static int SEC_MAX=59;
	public final static int SEC_MIN=0;

	// attributes
	private int hour, min, sec;

	// default constructor
	public Timemodel(){
		this(12, 0, 0);
	}

	// overloaded constructor
	public Timemodel(int h, int m, int s){
		hour=h;
		min=m;
		sec=s;
	}

	// overloaded constructor
	public Timemodel(Timemodel t){
		this(t.hour, t.min, t.sec);
	}

	// getter methods
	public int getHour(){
		return hour;
	}
	public int getMin(){
		return min;
	}
	public int getSec(){
		return sec;
	}

	// show object data
	public String toString(){
		return ""+hour+":"+ min+":"+ sec;
	}

	// calculate previous Time value
	public Timemodel last(){

		Timemodel tempTime=new Timemodel(this);

		// tick backwards
		tempTime.sec--;

		// adjust min if needed
		if(tempTime.sec<SEC_MIN){
			tempTime.sec=SEC_MAX;
			tempTime.min--;
			// adjust hour if needed
			if(tempTime.min<MIN_MIN){
				tempTime.min=MIN_MAX;
				tempTime.hour--;
				tempTime.hour=(tempTime.hour<HOUR_MIN)? HOUR_MAX: tempTime.hour;
			}
		}
		return tempTime;
	}

	// calculate next Time value
	public Timemodel next(){

		Timemodel tempTime=new Timemodel(this);

		// tick forwards
		tempTime.sec++;

		// adjust min if needed
		if(tempTime.sec>SEC_MAX){
			tempTime.sec=SEC_MIN;
			tempTime.min++;
			// adjust hour if needed
			if(tempTime.min>MIN_MAX){
				tempTime.min=MIN_MIN;
				tempTime.hour++;
				tempTime.hour=(tempTime.hour>HOUR_MAX)? HOUR_MIN: tempTime.hour;
			}
		}
		return tempTime;
	}

	// check if a Time value is within limits returns false if ok
	public boolean check(){
		boolean logic=false;

		if(sec>SEC_MAX || sec<SEC_MIN){
			logic=true;
		}
		if(min>MIN_MAX || min<MIN_MIN){
			logic=true;
		}
		if(hour>HOUR_MAX || hour<HOUR_MIN){
			logic=true;
		}
		return logic;
	}
}
