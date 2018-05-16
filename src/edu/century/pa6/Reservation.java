package edu.century.pa6;
/*******************************************************************************
 * Author		:	Nalonsone Danddank										   *
 * Class		:	CSCI 1082												   *
 * Due Date		:	04/17/2018												   *
 * Description 	:	Reservation class is defined to be the base class for 	   *
 * 					Passenger class and getting the informations from the 	   *
 * 					passengers who input in the GUI. The class have instance   *
 * 					variables to store the reservation's details including:    *
 * 					seat, from, to, departure date, and return date.		   *
 * *****************************************************************************/
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {
	//Initiate instance variables
	private String from;
	private String to;
	private Date departureDay;
	private Date returnDay;
	private String seat;
	//defeat constructor.
	public Reservation() {}
	//Constructor.
	public Reservation(String from, String to, Date departureDay, 
			Date returnDay, String seat) {
		super();
		this.from = from;
		this.to = to;
		this.departureDay = departureDay;
		this.returnDay = returnDay;
		this.seat = seat;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Date getDepartureDay() {
		return departureDay;
	}
	//transform the Date class to a simple form string.
	public String getDepartureString(){
		return new SimpleDateFormat("MM/dd/yyyy")
				.format(departureDay);
	}
	//transform the string date from input to the Date class.
	public void setDepartureDay(String sDay) {
		try{
		this.departureDay = new SimpleDateFormat(
				"MM/dd/yyyy").parse(sDay);
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	public Date getReturnDay() {
		return returnDay;
	}
	//transform the string date from input to the Date class.
	public String getReturnString() {
		return new SimpleDateFormat("MM/dd/yyyy")
				.format(returnDay);
	}
	//transform the string date from input to the Date class.
	public void setReturnDay(String sDay) {
		try{
			this.returnDay = new SimpleDateFormat(
					"MM/dd/yyyy").parse(sDay);
			}catch(Exception e) {
				System.err.println(e.getMessage());
			}
		
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	@Override
	public String toString() {
		return  "\nSeat: "+ seat+"\nFrom: "+ from +"\nTo: "+ to
				+ "\nDeparture: "+ getDepartureString()
				+ "\nReturn: " + getReturnString()+"\n";
	}
}
