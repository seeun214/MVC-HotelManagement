package hotel.model.dto;

public class Room {
	/** 객실 번호 */
	private int roomNo;
	
	/** 최대 인원 */
	private int maxCount;
	
	/** 객실 가격 */
	private int roomPrice;
	
	/** 객실 종류 */
	private String roomType;
	
	/** 객실 예약 여부 */
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
		builder.append("[번호]");
		builder.append(roomNo);
		builder.append(", [최대 인원]");
		builder.append(maxCount);
		builder.append(", [가격]");
		builder.append(roomPrice);
		builder.append(", [종류]");
		builder.append(roomType);
		
		return builder.toString();
	}
	
}
