package hotel.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import hotel.exception.DuplicateException;
import hotel.exception.NotExistException;
import hotel.model.HotelReservationModelVirtualDB;
import hotel.model.RoomDB;
import hotel.model.dto.Customer;
import hotel.model.dto.ReservationManagement;
import hotel.model.dto.Room;
import log4jtest.LogTest;

public class ReservationManagementService {
	private static ReservationManagementService instance = new ReservationManagementService();
	
	private HotelReservationModelVirtualDB ReservaionData = HotelReservationModelVirtualDB.getInstance();
	
	private RoomDB roomData = RoomDB.getInstance();
	
	private ReservationManagementService() {};
	
	public static ReservationManagementService getInstance() {
		return instance;
	}
	
	/**
	 * ���  ���� ���� �˻�(��ȯ)
	 * 
	 * @return ��� ReservationList
	 */
	public ArrayList<ReservationManagement> getReservationList() {
		return ReservaionData.getReservationList();
	}

	/** 
	 * ���� ��ȣ�� �˻� - reservation ��ȯ
	 * 
	 * @param reservationNumber ���� ��ȣ
	 * @return ReservationManagement �˻��� ���� ��ȣ, �˻��ϰ��� �ϴ� ���� ��ȣ�� ���� ��� null ��ȯ
	 */
	public ReservationManagement getReservation(String reservationNumber) {
		ArrayList<ReservationManagement> reservationList = ReservaionData.getReservationList();
		
		for(ReservationManagement reservation : reservationList) {
			if(reservation.getReservationNumber().equals(reservationNumber)) {
				return reservation;
			}
		}
		
		return null;
	}
	
	/** 
	 * room state ��ȯ
	 * 
	 * @param roomNo ���ǹ�ȣ
	 * @return room state ���� �Ұ��ϸ�  1, ���� �����ϸ� 0, ������ ã�� �� ������ -1 ��ȯ
	 */
	public int getRoom(int roomNo) {
		ArrayList<Room> rooms = roomData.getRoomList();
		int count = rooms.size();
		
		for(int i = 0; i < count; i++) {
			if(rooms.get(i).getRoomNo() == roomNo) {
				return rooms.get(i).getState();
			}
		}
		
		return -1;
	}
	
	/**
	 * ���ο� ���� ���� �߰� 
	 * ���� �����ϰ��� �ϴ� ���� ��ȣ�� �̹� ������ ��� DuplicateException ���� �߻�
	 * 
	 * @param newReservation   �����ϰ��� �ϴ� ���ο� ���� ����
	 * @throws DuplicateException
	 */
	public void reservationInsert(ReservationManagement newReservation) throws DuplicateException{
		int state = getRoom(newReservation.getReservationRoom().getRoomNo());
		
		if(state == 1) {
			throw new DuplicateException("�ش� ������ �̹� ����� �����Դϴ�");
		}else if(state == 0) {
			ReservaionData.insertReservation(newReservation);
			newReservation.getReservationRoom().setState(1);
		}else {
			throw new DuplicateException("�ش� ������ ���� �����Դϴ�");
		}
	}

	/**
	 * Reservation�� �� ���� ���� - ���� ��ȣ�� �˻��ؼ� �ش� ���� ��ȣ�� �� ���� ����
	 * �����ϰ��� �ϴ� ���� ��ȣ�� �������� ���� ��� NotExistException �߻�
	 * 
	 * @param reservationNumber �����ȣ
	 * @param customer ��
	 * @throws NotExistException
	 */
	public void projectCustomerUpdate(String reservationNumber, Customer customer) throws NotExistException{
		ReservationManagement reservation = getReservation(reservationNumber);
		
		if(reservation == null) {
			throw new NotExistException("�ش� ���� ��ȣ�� �������� �ʽ��ϴ�");
		}else {
			reservation.setReservationCustomer(customer);
			LogTest.customerUpdateCheck("Success", reservationNumber, customer);
		}
	}
	
	/**
	 * Reservation�� ���� ���� ���� - ���� ��ȣ�� �˻��ؼ� �ش� ���� ��ȣ�� ���� ���� ����
	 * �����ϰ��� �ϴ� ���� ��ȣ�� �������� ���� ��� NotExistException �߻�
	 * 
	 * @param reservationNumber �����ȣ
	 * @param room ����
	 * @throws NotExistException
	 */
	public void projectRoomUpdate(String reservationNumber, Room room) throws NotExistException{
		ReservationManagement reservation = getReservation(reservationNumber);
		
		if(room.getState() != 0) {
			throw new NotExistException("�ش� ������ �̹� ����� �����Դϴ�");
		}else {
			reservation.getReservationRoom().setState(0);
			reservation.setReservationRoom(room);
			reservation.getReservationRoom().setState(1);
			LogTest.roomUpdateCheck("Success", reservationNumber, room);
		}
	}
	
	/**
	 * Reservation ���� - ���� ��ȣ�� �ش��ϴ� ������Ʈ ����
	 * 
	 * @param reservationNumber �����ϰ��� �ϴ� ���� ��ȣ
	 * @throws NotExistException
	 */
	public void reservationDelete(String reservationNumber) throws NotExistException{
		ReservationManagement reservation = getReservation(reservationNumber);
		if(reservation == null) {
			throw new NotExistException("�����ϰ��� �ϴ� ���������� �������� �ʽ��ϴ�");
		}else {
			getReservationList().remove(reservation);
		}
	}
}
