package hotel.model.dto;

public class ReservationManagement {
	/** 예약 고유 번호 */
	private String reservationNumber;

	/** 예약 고객 정보*/
	private Customer reservationCustomer;

	/** 객실  정보*/
	private Room reservationRoom;

	/** 결제 정보*/
	private PayInfo payinfo;

	/** 입실 날짜 */
	private String checkinDate;

	/** 퇴실 날짜 */
	private String checkoutDate;

	/**예약 상세 내용 */
	private String reservationDetail;

	public ReservationManagement() {
		super();
	}
	
	public ReservationManagement(String reservationNumber, Customer reservationCustomer, Room reservationRoom,
			PayInfo payinfo, String checkinDate, String checkoutDate, String reservationDetail) {
		super();
		this.reservationNumber = reservationNumber;
		this.reservationCustomer = reservationCustomer;
		this.reservationRoom = reservationRoom;
		this.payinfo = payinfo;
		this.checkinDate = checkinDate;
		this.checkoutDate = checkoutDate;
		this.reservationDetail = reservationDetail;
	}

	public String getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(String reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

	public Customer getReservationCustomer() {
		return reservationCustomer;
	}

	public void setReservationCustomer(Customer reservationCustomer) {
		this.reservationCustomer = reservationCustomer;
	}

	public Room getReservationRoom() {
		return reservationRoom;
	}

	public void setReservationRoom(Room reservationRoom) {
		this.reservationRoom = reservationRoom;
	}

	public PayInfo getPayinfo() {
		return payinfo;
	}

	public void setPayinfo(PayInfo payinfo) {
		this.payinfo = payinfo;
	}

	public String getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(String checkinDate) {
		this.checkinDate = checkinDate;
	}

	public String getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(String checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public String getReservationDetail() {
		return reservationDetail;
	}

	public void setReservationDetail(String reservationDetail) {
		this.reservationDetail = reservationDetail;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[예약 번호]");
		builder.append(reservationNumber);
		builder.append(", [예약 고객]");
		builder.append(reservationCustomer);
		builder.append(",\t [객실]");
		builder.append(reservationRoom);
		builder.append(",\t [결제]");
		builder.append(payinfo);
		builder.append(",\t [입실 날짜]");
		builder.append(checkinDate);
		builder.append(",\t [퇴실 날짜]");
		builder.append(checkoutDate);
		builder.append(",\t [예약 상세 내용] ");
		builder.append(reservationDetail);
		return builder.toString();
	}

}
