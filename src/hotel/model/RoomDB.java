package hotel.model;

import java.util.ArrayList;

import hotel.model.dto.Room;

public class RoomDB {
	private static RoomDB instance = new RoomDB();
	private ArrayList<Room> roomList = new ArrayList<>();
	
	private RoomDB() {
		roomList.add(new Room(101, 2, 100000, "standard", 0));
		roomList.add(new Room(102, 2, 100000, "standard", 0));
		roomList.add(new Room(201, 3, 150000, "suite", 0));
		roomList.add(new Room(202, 4, 200000, "superior", 0));
		roomList.add(new Room(301, 5, 300000, "deluxe", 0));
		roomList.add(new Room(302, 5, 300000, "deluxe", 0));
	}
	
	public static RoomDB getInstance() {
		return instance;
	}

	public ArrayList<Room> getRoomList() {
		return roomList;
	}

	public void insertRoom(Room newRoom) {
		roomList.add(newRoom);
	}
	
}
