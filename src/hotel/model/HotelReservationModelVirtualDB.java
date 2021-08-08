package hotel.model;

import java.util.ArrayList;

import hotel.model.dto.Customer;
import hotel.model.dto.PayInfo;
import hotel.model.dto.ReservationManagement;
import hotel.model.dto.Room;

public class HotelReservationModelVirtualDB {
	private static HotelReservationModelVirtualDB instance = new HotelReservationModelVirtualDB();
	private ArrayList<ReservationManagement> ReservationList = new ArrayList<ReservationManagement>();
	private RoomDB room = RoomDB.getInstance();
	private ArrayList<Room> roomList = room.getRoomList();
	private int[] roomState = new int[roomList.size()];

	private HotelReservationModelVirtualDB() {
		ReservationList.add(new ReservationManagement("01a", new Customer("마유진", "010-111-1111", "kimd@company.com", 2),
				    		roomList.get(0), new PayInfo("2021-04-03", roomList.get(0).getRoomPrice(), "cash"), 
				    		"2021-04-05", "2021-04-06", "조식 미포함"));
		roomList.get(0).setState(1);

		ReservationList.add(new ReservationManagement("02b", new Customer("곽형림", "010-222-2222", "shin@company.com", 3),
							roomList.get(3), new PayInfo("2021-03-31", roomList.get(3).getRoomPrice(), "creditcard"),
							"2021-04-01", "2021-04-03", "수영장 이용 가능, 조식 포함"));
		roomList.get(3).setState(1);
		
		ReservationList.add(new ReservationManagement("03c", new Customer("김지명", "010-333-3333", "lee@company.com", 4),
							roomList.get(4), new PayInfo("2021-08-03", roomList.get(4).getRoomPrice(), "naverpay"),
							"2021-08-05", "2021-08-07", "스파 가능, 조식 포함, 애견 동반"));
		roomList.get(4).setState(1);
		
	}

	public static HotelReservationModelVirtualDB getInstance() {
		return instance;
	}

	public ArrayList<ReservationManagement> getReservationList() {
		return ReservationList;
	}

	public void insertReservation(ReservationManagement newReservation) {
		ReservationList.add(newReservation);
	}
	
	public int[] getRoomState() {
		return roomState;
	}
}
