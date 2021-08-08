package hotel.model.dto;

public class ReservationManagement {
	/** ���� ���� ��ȣ */
	private String reservationNumber;

	/** ���� �� ����*/
	private Customer reservationCustomer;

	/** ����  ����*/
	private Room reservationRoom;

	/** ���� ����*/
	private PayInfo payinfo;

	/** �Խ� ��¥ */
	private String checkinDate;

	/** ��� ��¥ */
	private String checkoutDate;

	/**���� �� ���� */
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
		builder.append("[���� ��ȣ]");
		builder.append(reservationNumber);
		builder.append(", [���� ��]");
		builder.append(reservationCustomer);
		builder.append(",\t [����]");
		builder.append(reservationRoom);
		builder.append(",\t [����]");
		builder.append(payinfo);
		builder.append(",\t [�Խ� ��¥]");
		builder.append(checkinDate);
		builder.append(",\t [��� ��¥]");
		builder.append(checkoutDate);
		builder.append(",\t [���� �� ����] ");
		builder.append(reservationDetail);
		return builder.toString();
	}

}
