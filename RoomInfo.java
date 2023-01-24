/**********************************************************
 * Program Name   : Room Info
 * Author         : Taylor Pitman
 * Date           : October 12, 2022
 * Course/Section : CSC 112 301
 * Program Description:  this program is the blue print to a room
 *	object. the room object can become unavailable if reserved, and
 *	released and become available again.
 *
 * Methods:
 * -------
 * RoomInfo    - constructer method, initializes room number, availability and capacity
 * reserveRoom - returns boolean representing a valid/invalid room reservation
 * releaseRoom - returns boolean representing a valid/invalid room release
 * toString    - converts data being displayed to a string
 **********************************************************/

public class RoomInfo
{
    //class constants

    //class variables
    private String  roomNumber;			//number to locate room
	private int 	rmCapacity;			//chosen capacity of the room
    private boolean rmAvailable;		//represents if the room has already been reserved
    private String  resName;			//name of person who is reserving the room

   /**********************************************************
	* Method Name    : roomInfo
	* Author         : Taylor Pitman
	* Date           : October 12, 2022
	* Course/Section : CSC-211-301
	* Method Description: This method initializes the availability of the room,
	* room capacity, room number, and reservation name
	*
	*BEGIN roomInfo
	*	initialize class variables
	*END roomInfo
	**********************************************************/

	public RoomInfo (String rmNumber, int maxCapacity)
	{
		//local constants

		//local variables

		/********************   Start main method  *****************/

		//initialize variables
		roomNumber  = rmNumber;
		rmCapacity  = maxCapacity;
		rmAvailable = true;
		resName 	= "";

	}//END RoomInfo

   /**********************************************************
	* Method Name    : reserveRoom
	* Author         : Taylor Pitman
	* Date           : October 12, 2022
	* Course/Section : CSC-211-301
	* Method Description: This method reserves the room if
	*	it is available.
	*
	*BEGIN reserveRoom
	*	IF (room availability is true)
	*		set reservation name to input
	*		set room availibility to false
	*		set reserve to true
	*	ELSE
	*		set reserve to false
	*	END IF
	*	return reserve
	*END reserveRoom
	**********************************************************/

	public boolean reserveRoom (String reservationName)
	{
		//local constants

		//local variables
		boolean didReserve = false;		//whether or not room was successfully reserved

		/********************   Start main method  *****************/

		//IF (room availability is true)
		if (rmAvailable)
		{
			//set reservation name to input
			resName = reservationName;

			//set room availability to false
			rmAvailable = false;

			//set reserve to true
			didReserve = true;

		}//END IF

		//return didReserve
		return didReserve;

	}//END reserveRoom

   /**********************************************************
	* Method Name    : releaseRoom
	* Author         : Taylor Pitman
	* Date           : October 12, 2022
	* Course/Section : CSC-211-301
	* Method Description: This method releases the room if
	*	it is unavailable
	*
	*BEGIN releaseRoom
	*	IF(availibilty is false and name matches reservation name)
	*		set room availibility to available
	*		set release to true
	*		set reservation name to null string
	*	END IF
	*	return release
	*END releaseRoom
	**********************************************************/

	public boolean releaseRoom (String name)
	{
		//local constants

		//local variables
		boolean didRelease = false;		//whether or not release was sucessfull

		/********************   Start main method  *****************/

		//IF(availibilty is false and name matches reservation name)
		if(rmAvailable == false && name.equals(resName))
		{
			//set availibility to available
			rmAvailable = true;

			//set release to true
			didRelease = true;

			//set reservation name to null string
			resName = "";

		}//END IF

		//return release
		return didRelease;

	}//END releaseRoom

   /**********************************************************
	* Method Name    : toString
	* Author         : Taylor Pitman
	* Date           : October 12, 2022
	* Course/Section : CSC-211-301
	* Method Description: This method converts all displayed data
	*	to a string
	*
	*BEGIN toString
	*	IF(room is available)
	*		set availability to yes
	*	END IF
	*	initialize title string
	*	convert capacity to string
	*	initialize final string
	*	return final string
	*END toString
	**********************************************************/

	public String toString()
	{
		//local constants

		//local variables
		String strCapacity;			//string of integer of room capacity
		String finalString;			//string containing all neccessary information
		String available = "N";		//availability of room as a string

		/********************   Start main method  *****************/

		//IF(room is available)
		if(rmAvailable)

			//initialize available to yes
			available = "Y";

		//END IF

		//convert capacity to string
		strCapacity = "" + rmCapacity;

		//initialize final string
		finalString = Util.setLeft(21,roomNumber) + "\t\t\t" + Util.setLeft(5,strCapacity)  + "\t\t\t"  + Util.setRight(7,available);

		//return final string
		return finalString;

	}//END toString

}//END RoomInfo
