/**********************************************************
 * Program Name   : Building Info
 * Author         : Taylor Pitman
 * Date           : October 12, 2022
 * Course/Section : CSC 112 301
 * Program Description:	this program adds room objects to an array
 *	of room objects. it also makes sure the array doesnt overflow
 *	and formats a display page of all the information from all the
 * 	rooms.
 *
 * Methods:
 * -------
 * BuildingInfo - constructor, initializes room array and variables
 * addRoom 	    - this will add a RoomInfo object to the array of objects
 * getCount     - returns the amount of rooms that have been created
 * toString     - displays array as a string
 **********************************************************/

public class BuildingInfo
{
    //class constants

    //class variables
	private String buildingName;	 //chosen name of the building
	private int numRooms;			 //created room count
  	private int maxRooms;			 //size of the array
  	private RoomInfo[] roomArray;

   /**********************************************************
	* Method Name    : BuildingInfo
	* Author         : Taylor Pitman
	* Date           : October 12, 2022
	* Course/Section : CSC-112-301
	* Method Description: this method initializes the number of rooms
	* created, the max rooms, building name and array of rooms
	*
	* BEGIN BuildingInfo
	*	initialize information given by driver class
	*	initialize room array
	* END BuildingInfo
	**********************************************************/

	public BuildingInfo (int roomMax, String name)
	{
		//local constants

		//local variables

		/********************   Start main method  *****************/

		//initialize information given by main
    	maxRooms = roomMax;
   		numRooms = 0;
   		buildingName = name;

   		//initialize room array
		roomArray = new RoomInfo[maxRooms];

	} //END BuildingInfo

   /**********************************************************
	* Method Name    : addRoom
	* Author         : Taylor Pitman
	* Date           : October 12, 2022
	* Course/Section : CSC-112-301
	* Method Description: this method adds a created room to the room
	*	array if there's room in the array.
	*
	* BEGIN addRoom
	*	IF(the number of rooms is valid)
	*		set room to correct index in array
	*		add one to number of rooms
	*		set confirmation to true
	*	END IF
	*	return confirmation
	* END addRoom
	**********************************************************/

	public boolean addRoom (RoomInfo newRoom)
	{
		//local constants

		//local variables
   		boolean didAdd = false;

		/********************   Start addRoom method  *****************/

    	//IF(the number of rooms is valid)
    	if (numRooms < maxRooms)
   		{
			//set room to correct index in array
      		roomArray[numRooms] = newRoom;

      		//add one to number of rooms
     		numRooms++;

     		//set confirmation to true
   	  		didAdd = true;

   		}//END if

		//return confirmation
    	return didAdd;

	}//END addRoom

	/**********************************************************
	* Method Name    : getCount
	* Author         : Taylor Pitman
	* Date           : October 12, 2022
	* Course/Section : CSC-112-301
	* Method Description: this method returns the number of rooms
	* in the array
	*
	* BEGIN getCount
	*	return number of rooms
	*END getCount
	**********************************************************/

	public int getCount ()
	{
		//local constants

		//local variables

		/********************   Start getCount method  *****************/

		//return number of rooms
		return numRooms;

	}//END getCount

	/**********************************************************
	* Method Name    : getRoom
	* Author         : Taylor Pitman
	* Date           : October 12, 2022
	* Course/Section : CSC-112-301
	* Method Description: this method returns the specific room
	*	object based on the index number it takes in as a parameter
	*
	* BEGIN getRoom
	*	return number of rooms
	* END getRoom
	**********************************************************/

	public RoomInfo getRoom (int index)
	{
		//local constants

		//local variables

		/********************   Start getCount method  *****************/

		//return room
		return roomArray[index];

	}//END getCount

	/**********************************************************
	* Method Name    : toString
	* Author         : Taylor Pitman
	* Date           : October 12, 2022
	* Course/Section : CSC-112-301
	* Method Description: This method displays the array of rooms as a string
	*
	* BEGIN toString
	*	initialize title
	*	initialize header
	*	FOR (index of array is less than amount of rooms)
	*		set count to 1 more than the index
	*		initialize array string
	*	END FOR
	*	initialize final string
	*	return final string
	* END toString
	**********************************************************/

	public String toString ()
	{
		//local constants

		//local variables
		String 	title;				// output screen title
   		String 	arrayStr = "";		// where array is stored as a string
   		String 	finalString;		// final string that is outputed
   		String  header;				// header for list of rooms
   		String  headerStars;		// stars to emphasize header
   		String   count;				// corrected count for user

		/********************   Start toString method  *****************/

		//initialize title
		title = "\n\n\n" + Util.setLeft(47,"Current Rooms in: ") +
						   Util.setRight(5,buildingName);

		//initialize header
		headerStars = Util.setLeft(19,"******************************************" +
									  "******************************************");
		header = Util.setLeft(19,"Count") + "\t\tRoom Number" + "\t\tRoom Capacity" +
				 "\t\tAvailable (Y/N)";

		//FOR (index is less than the amount of rooms)
		for (int index = 0; index <= numRooms; index++)
		{
			//set count to 1 more that index
			count = index + 1 + ")";

			//initialize array string
			arrayStr += "\n\n" + (Util.setLeft(21,count) +  roomArray[index] + "\n");

		}//END FOR

		//intialize final string
		finalString = title + "\n\n" + headerStars + "\n" + header +
					   "\n" + headerStars + "\n\n" + arrayStr;

		//return final string
		return finalString;

	}//END toString

}// END BuildingInfo