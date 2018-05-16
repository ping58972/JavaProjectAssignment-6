package edu.century.pa6;
/*******************************************************************************
 * Author		:	Nalonsone Danddank										   *
 * Class		:	CSCI 1082												   *
 * Due Date		:	04/17/2018												   *
 * Description 	:	Passenger class is defined  for getting the informations   *
 * 					from the passengers who input in the GUI. The class have   *
 * 					instance variables to store the passenger's first name,    *
 * 					last name and reservation.    							   *
 * *****************************************************************************/
import java.util.Date;

public class Passenger extends Reservation {
	//Initiate instance variables
	private String fName;
	private String lName;	
	//defeat constructor.
	public Passenger() {}
	//Constructor.
	public Passenger(String fName, String lName,
			String from, String to, Date departureDay,
			Date returnDay, String seat) {
		super();
		this.fName = fName;
		this.lName = lName;		
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	@Override
	public String toString() {
		return "First Name: "+ fName + 
				"\nLast Name: " + lName
				+ super.toString();
	}
}
