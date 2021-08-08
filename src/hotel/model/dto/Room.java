package hotel.model.dto;

public class Room {
	/** ���� ��ȣ */
	private int roomNo;
	
	/** �ִ� �ο� */
	private int maxCount;
	
	/** ���� ���� */
	private int roomPrice;
	
	/** ���� ���� */
	private String roomType;
	
	/** ���� ���� ���� */
	private int state = 0;

	public Room() {}
	public Room(int roomNo, int maxCount, int roomPrice, String roomType, int state) {
		super();
		this.roomNo = roomNo;
		this.maxCount = maxCount;
		this.roomPrice = roomPrice;
		this.roomType = roomType;
		this.state = state;
	}
	
	public int getRoomNo() {
		return roomNo;
	}
	
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	
	public int getMaxCount() {
		return maxCount;
	}
	
	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}
	
	public int getRoomPrice() {
		return roomPrice;
	}
	
	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}
	
	public String getRoomType() {
		return roomType;
	}
	
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	public int getState() {
		return state;
	}
	
	public void setState(int state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[��ȣ]");
		builder.append(roomNo);
		builder.append(", [�ִ� �ο�]");
		builder.append(maxCount);
		builder.append(", [����]");
		builder.append(roomPrice);
		builder.append(", [����]");
		builder.append(roomType);
		
		return builder.toString();
	}
	
}
