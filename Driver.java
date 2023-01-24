/**********************************************************
 * Program Name   : Driver
 * Author         : Taylor
 * Date           : 10-12-2022
 * Course/Section : CSC 112-301
 * Program Description: create an application that will keep track of
 *	information about mulitple meeting rooms in a building.
 *  you will need to store the room designation (i.e. W214), seating capacity,
 *	availability, name of person who reserved the room. the program will
 *	provide the user with the following options: reserve room, release room,
 *	display room info, quit program.
 *
 * Methods:
 * -------
 * main 	  		- allows a user to create, reserve, release and view a room
 * displayMenu 		- displays menu options to the output screen
 * reserveRoom 		- displays whether or not reservation was successfull
 * releaseRoom 		- displays whether or not release was successfull
 * displayRoom		- displays all room information to output screen
 * createRoom		- creates new room object
 * createBuilding 	- creates array of rooms (building object)
 * addRoom			- displays if adding a room to the array was successful
 **********************************************************/

import java.util.Scanner;

public class Driver
{
   /**********************************************************
    * Method Name    : main
    * Author         : Taylor Pitman
 	* Date           : 10-12-2022
 	* Course/Section : CSC-112-301
    * Method Description: this method welcomes the user, allows them to
    * 	create and customize a building and room and then reserve, release
    *	and view the rooms created.
    *
    *BEGIN main
    *	display welcome message
    *	call create building method
    *	clear screen
    *	display create room message
    *	call add room method
    *	clear screen
    *	call display menu method
    *	prompt input or quit
    *	clear screen
    *	WHILE(input is not quit)
	*		SWITCH(input)
	*			CASE create room
	*				clear screen
	*				call add room method
	*   	   		break statement
	*   	  	CASE reserve room
	*				call reserve room method
	*   	   		break statement
	*   	   	CASE display rooms
	*				call display room method
	*   	   		break statement
	*   	    DEFAULT
	*   	    	display error
	*   	    	display pause message
	*			END SWITCH
    *		clear screen
    *		call display menu method
    *		prompt input or quit
    *	END WHILE
    *END main
    **********************************************************/

	public static void main (String [] args)
	{
		//local constants
		final int QUIT    = -1;
		final int CREATE  =  1;
		final int RESERVE =  2;
		final int RELEASE =  3;
		final int DISPLAY =  4;

		//local variables
		int chosenOption;		//chosen case for menu
		String rmNumber;		//chosen number for room
		int rmCapacity;			//chosen capacity for room
		Scanner scan  		    = new Scanner(System.in);
		RoomInfo room 			= new RoomInfo("", 0);
    	BuildingInfo building	= new BuildingInfo(0, "");

		/********************   Start main method  *****************/

		//display welcome message
		System.out.println ("\n\n" + Util.setLeft(40, "Welcome, Create a Building to get Started"));

		//call create building method
	 	building = createBuilding();

	 	//clear screen
	 	Util.cls();

		//display create room message
		System.out.println("\n\n" + Util.setLeft(49,"Create Your First Room"));

		//call add room method
    	addRoom(building, room);

    	//clear screen
    	Util.cls();

		//call display menu method
		displayMenu();

		//prompt input or quit
		System.out.print("\n" + Util.setLeft(46,"Choose an option or quit[-1]: "));
		chosenOption = scan.nextInt();

		//clear screen
		Util.cls();

		//WHILE (input is not quit)
		while (chosenOption != QUIT)
		{
			//SWITCH (input)
			switch(chosenOption)
			{
				//CASE create room
				case CREATE:

					//clear screen
					Util.cls();

					//call add room method
          			addRoom(building, room);

					//break statement
					break;

				//CASE reserve room
				case RESERVE:

					//call reserve room method
					reserveRoom(building, room);

					//break statement
					break;

				//CASE display room
				case RELEASE:

					//call release room method
					releaseRoom(building, room);

					//break statement
					break;

				//CASE release room
				case DISPLAY:

					//call display room method
					displayRoom(building);

					//break statement
					break;

				//DEFAULT
				default:

					//display error
					System.out.print("ERROR: Input not valid");

					//display pause message
					System.out.print("\n\n\n" + Util.setLeft(44,"********************************") 	 +
		       						 "\n\n"   + Util.setLeft(44,"  Press enter to continue....   ")  	 +
		       						 "\n\n"   +	Util.setLeft(44,"********************************"));
       				scan.nextLine();

			}//END SWITCH

			//clear screen
			Util.cls();

			//display menu method
			displayMenu();

			//prompt input or quit
			System.out.print("\n" + Util.setLeft(46,"Choose an option or quit[-1]: "));
			chosenOption = scan.nextInt();

		}//END WHILE

  	}//END main

   /**********************************************************
	* Method Name    : displayMenu
	* Author         : Taylor Pitman
	* Date           : 10-12-2022
	* Course/Section : CSC 112-301
	* Method Description: this method is a print statement that
	* displays the user's options to the console.
	*
	* BEGIN displayMenu
	*	display menu options
	* END displaymenu
	*********************************************************/

	 public static void displayMenu ()
	{
		//local constants

		//local variables

		/********************   Start main method  *****************/

		//display menu options
		System.out.println("\n\n\n" + Util.setLeft(53, "********************"));
		System.out.println(			  Util.setLeft(61,"Menu"));
		System.out.print  (Util.setLeft(53, "********************"));
		System.out.println("\n"     + Util.setLeft(53, "* [1] Create  Room *")  +
						   "\n"     + Util.setLeft(53, "* [2] Reserve Room *")  +
						   "\n"	    + Util.setLeft(53, "* [3] Release Room *")  +
						   "\n"     + Util.setLeft(53, "* [4] View   Rooms *"));
		System.out.println(Util.setLeft(53,"********************"));

	}//END displayMenu

   /**********************************************************
	* Method Name    : reserveRoom
	* Author         : Taylor Pitman
	* Date           : 10-12-2022
	* Course/Section : CSC 112-301
	* Method Description: this method communicates with the Roominfo
	*	class to reserve a room(if valid) and then displays the result
	*	to the user
	*
	*BEGIN reserveRoom
	*	clear screen
	*	display array of rooms
	*	get number of rooms in building
	*	prompt for which room the user wants
	*	FOR(count less than the number of rooms)
	*		IF(room chosen is count)
	*			initialize new room to correct room in array
	*		END IF
	*		increase index by one
	*	END FOR
	*	buffer for error
	*	clear screen
	*	prompt for reservation name
	*	IF reserve room is true
	*		display sucessfull message
	*	ELSE
	*		display error
	*	END IF
	*	display pause message
	*END reserveRoom
	**********************************************************/

	public static void reserveRoom(BuildingInfo newBuilding, RoomInfo newRoom)
	{
		//local constants

		//local variables
		String  resName;	//chosen name to put on room reservation
		int    numRooms;	//number of rooms in building so far
		int	 roomChoice;	//room that user wants to reserve
		int	  index = 0;	//index of array of rooms
		Scanner scan = new Scanner(System.in);

		/********************   Start main method  *****************/

		//clear screen
		Util.cls();

		//display array of rooms
		System.out.println(newBuilding);

		//get number of rooms in building
		numRooms = newBuilding.getCount();

		//prompt for which room
		System.out.print("\n\n" + Util.setLeft(19,"Enter which room you'd like to reserve (1-" + numRooms + "): "));
		roomChoice = scan.nextInt();

		//FOR (count being less than the number of rooms)
		for (int count = 1; count < numRooms; count++)
		{
			//IF(room chosen is count)1
			if(roomChoice == count)

				//initialize new room to correct room in array
				newRoom = newBuilding.getRoom(index);

			//END IF

			//increase index by one
			index++;

		}//END FOR

		//buffer for error
		scan.nextLine();

		//clear screen
		Util.cls();

		//prompt for reservation name
		System.out.print("\n\n\n\n" + Util.setLeft(47,"Enter a reservation name: "));
		resName = scan.nextLine();

		//IF reserve room is true
		if(newRoom.reserveRoom(resName))

			//display successfull message
			System.out.println("\n\n\n" + Util.setLeft(47,"Your reservation was successful!") +
							   "\n"     + Util.setLeft(47,"It is under the name") + Util.setRight(12,": " + resName));

		//ELSE error
		else

			//display error
			System.out.println("\n\n\n" + Util.setLeft(48,"ERROR: Room is occupied"));

		//END IF

		//display pause message
		System.out.print("\n\n\n" + Util.setLeft(47,"********************************") 	 +
		       			 "\n\n"   + Util.setLeft(47,"  Press enter to continue...."   )  	 +
		       			 "\n\n"   +	Util.setLeft(47,"********************************"));
       	scan.nextLine();

	}//END reserveRoom

	/**********************************************************
	* Method Name    : displayRoom
	* Author         : Taylor Pitman
	* Date           : 10-12-2022
	* Course/Section : CSC 211-301
	* Method Description: this method takes all the information
	*	about the rooms and displays it on the screen for the user
	*
	*BEGIN displayRoom
	*	clear screen
	*	display building
	*	display pause message
	*END displayRoom
	**********************************************************/

	public static void displayRoom(BuildingInfo newBuilding)
	{
		//local constants

		//local variables
		Scanner scan = new Scanner(System.in);

		/********************   Start main method  *****************/

		//clear screen
		Util.cls();

		//display building
		System.out.println("\n\n" + newBuilding);

		//display pause message
		System.out.print("\n\n\n" + Util.setLeft(44,"********************************") 	 +
		       			 "\n\n"   + Util.setLeft(44,"  Press enter to continue...."   )  	 +
		       			 "\n\n"   +	Util.setLeft(44,"********************************"));
       	scan.nextLine();

	}//END displayRoom

	/**********************************************************
	* Method Name    : releaseRoom
	* Author         : Taylor Pitman
	* Date           : 10-12-2022
	* Course/Section : CSC 112-301
	* Method Description: this method displays to the user whether or
	* or not the room they inputed has been released.
	*
	*BEGIN releaseRoom
	*	clear screen
	*	display array of rooms
	*	get number of rooms in building
	*	prompt for which room the user wants
	*	FOR(count less than the number of rooms)
	*		IF(room chosen is count)
	*			initialize new room to correct room in array
	*		END IF
	*		increase index by one
	*	END FOR
	*	buffer for error
	*	clear screen
	*	prompt for reservation name
	*	IF reserve room is true
	*		display sucessfull message
	*	ELSE
	*		display error
	*	END IF
	*	display pause message
	*END releaseRoom
	**********************************************************/

	public static void releaseRoom(BuildingInfo newBuilding, RoomInfo newRoom)
	{
		//local constants

		//local variables
		String  resName;	//chosen name for reservation
		int    numRooms;	//number of rooms in building so far
		int	 roomChoice;	//room that user wants to reserve
		int	  index = 0;	//current index of array
		Scanner scan = new Scanner(System.in);

		/********************   Start main method  *****************/

		//clear screen
		Util.cls();

		//display array
		System.out.println(newBuilding);

		//get number of rooms in building
		numRooms = newBuilding.getCount();

		//prompt for which room the user wants
		System.out.print(Util.setLeft(19, "Enter which room you'd like to release (1 - " + numRooms + "): "));
		roomChoice = scan.nextInt();

		//FOR (count being less than the number of rooms)
		for (int count = 1; count < numRooms; count++)
		{
			//IF(room chosen is count)
			if(roomChoice == count)

				//initialize new room to correct room in array
				newRoom = newBuilding.getRoom(index);

			//END IF

			//increase index by one
			index++;

		}//END FOR

		//buffer for error
		scan.nextLine();

		//clear screen
		Util.cls();

		//prompt reservation name
		System.out.print("\n\n\n" + Util.setLeft(47,"Enter name room is reservered under: "));
		resName = scan.nextLine();

		//IF reserve room is true
		if(newRoom.releaseRoom(resName))

			//display successfull message
			System.out.println("\n\n" + Util.setLeft(47,"Your release was successful!"));

		//ELSE
		else

			//display error
			System.out.println("\n\n\n" + Util.setLeft(47,"ERROR: Room does not exit"));

		//END IF

		//display pause message
		System.out.print("\n\n\n" + Util.setLeft(47,"********************************") 	 +
		       			 "\n\n"   + Util.setLeft(47,"  Press enter to continue...."   )  	 +
		       			 "\n\n"   +	Util.setLeft(47,"********************************"));
       	scan.nextLine();

	}//END releaseRoom

	/**********************************************************
	* Method Name    : createRoom
	* Author         : Taylor Pitman
	* Date           : 09/29/2022
	* Course/Section : CSC 112-301
	* Method Description: This method creates and returns a new room object
	* and displays it's success to the user.
	*
	*BEGIN createRoom
	*	prompt for room number
	*	prompt for room capacity
	*	initialize room object
	*	display successful message
	*	prompt pause
	*	return room object
	*END createRoom
	**********************************************************/

	public static RoomInfo createRoom ()
	{
		//local constants

		//local variables
		String rmNumber;						//number chosen for room
		int rmCapacity;							//number chosen for room capacity
		Scanner scan = new Scanner(System.in);
		RoomInfo newRoom;

		/********************   Start main method  *****************/

		//prompt for room number
		System.out.print("\n\n" + Util.setLeft(41,"Enter a room number") + Util.setRight(21,": "));
		rmNumber = scan.nextLine();

		//prompt for room capacity
		System.out.print("\n" + Util.setLeft(41,"Enter the max occupancy for this room : "));
		rmCapacity = scan.nextInt();

		//initialize room object
		newRoom = new RoomInfo(rmNumber, rmCapacity);

		//return room object
		return newRoom;

	}//END createRoom

 	/**********************************************************
	* Method Name    : addRoom
	* Author         : Taylor Pitman
	* Date           : 10-12-2022
	* Course/Section : CSC 112-301
	* Method Description: this method creates and returns a building object
	* and displays it's success to the user.
	*
	*BEGIN addRoom
	*	call create room method
	*	IF(add room is valid)
	*		display successfull message
	*	ELSE error
	*		display error
	*	END IF
	*	return building
	*END addRoom
	**********************************************************/

	public static BuildingInfo addRoom(BuildingInfo newBuilding, RoomInfo newRoom)
	{
		//local constants

		//local variables
    	Scanner scan = new Scanner(System.in);

		/********************   Start main method  *****************/

		//call create room method
		newRoom = createRoom();

		//IF(add room is valid)
		if(newBuilding.addRoom(newRoom))

			//display successfull message
			System.out.println("\n\n\n" + Util.setLeft(45,"New room added to the building"));

		//ELSE error
		else

			//display error
			System.out.println("\n\n\n" + Util.setLeft(48,"ERROR: Building is Full!"));

		//END IF

	 	//display pause message
		System.out.print("\n\n\n" + Util.setLeft(44,"********************************") 	 +
		       			 "\n\n"   + Util.setLeft(44,"  Press enter to continue...."   )  	 +
		       			 "\n\n"   +	Util.setLeft(44,"********************************"));
       	scan.nextLine();

		//return building
		return newBuilding;

	}//END addRoom

 	/**********************************************************
	* Method Name    : createBuilding
	* Author         : Taylor Pitman
	* Date           : 10-12-2022
	* Course/Section : CSC 112-301
	* Method Description: this method creates and returns a building object
	* and displays it's success to the user.
	*
	*BEGIN createBuilding
	*	prompt for building name
	*	prompt for amount of rooms
	*	initialize building
	*	display successful message
	*	prompt pause
	*	return building
	*END createBuilding
	**********************************************************/

	public static BuildingInfo createBuilding()
	{
		//local constants
		final int MAX_ROOMS;

		//local variables
		String buildingName;					//name of building
		Scanner scan = new Scanner(System.in);
		BuildingInfo newBuilding;

		/********************   Start main method  *****************/

		//prompt for building name
		System.out.print("\n\n" + Util.setLeft(40,"What is the name of your building?: "));
		buildingName = scan.nextLine();

		//prompt for amount of rooms
		System.out.print("\n" + Util.setLeft(40,"How many rooms are in your building?: "));
		MAX_ROOMS = scan.nextInt();

		//initialize building
		newBuilding = new BuildingInfo(MAX_ROOMS, buildingName);

		//display successful message
		System.out.println("\n\n\n" + Util.setLeft(47,"Building has been Created!"));

		//prompt pause
		System.out.print("\n\n\n" + Util.setLeft(44,"********************************") 	 +
		       			 "\n\n"   + Util.setLeft(44,"  Press enter to continue...."   )  	 +
		       			 "\n\n"   +	Util.setLeft(44,"********************************"));
       	scan.nextLine();
       	scan.nextLine();

		//return building
		return newBuilding;

	} //end createBuilding

} //end roomInfo