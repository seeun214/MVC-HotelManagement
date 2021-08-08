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
	 * 모든  예약 내역 검색(반환)
	 * 
	 * @return 모든 ReservationList
	 */
	public ArrayList<ReservationManagement> getReservationList() {
		return ReservaionData.getReservationList();
	}

	/** 
	 * 예약 번호로 검색 - reservation 반환
	 * 
	 * @param reservationNumber 예약 번호
	 * @return ReservationManagement 검색된 예약 번호, 검색하고자 하는 예약 번호가 없을 경우 null 반환
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
	 * room state 반환
	 * 
	 * @param roomNo 객실번호
	 * @return room state 예약 불가하면  1, 예약 가능하면 0, 객실을 찾을 수 없으면 -1 반환
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
	 * 새로운 예약 내역 추가 
	 * 새로 저장하고자 하는 예약 번호가 이미 존재할 경우 DuplicateException 예외 발생
	 * 
	 * @param newReservation   저장하고자 하는 새로운 예약 내역
	 * @throws DuplicateException
	 */
	public void reservationInsert(ReservationManagement newReservation) throws DuplicateException{
		int state = getRoom(newReservation.getReservationRoom().getRoomNo());
		
		if(state == 1) {
			throw new DuplicateException("해당 객실은 이미 예약된 객실입니다");
		}else if(state == 0) {
			ReservaionData.insertReservation(newReservation);
			newReservation.getReservationRoom().setState(1);
		}else {
			throw new DuplicateException("해당 객실은 없는 객실입니다");
		}
	}

	/**
	 * Reservation의 고객 정보 수정 - 예약 번호로 검색해서 해당 예약 번호의 고객 정보 수정
	 * 수정하고자 하는 예약 번호가 존재하지 않을 경우 NotExistException 발생
	 * 
	 * @param reservationNumber 예약번호
	 * @param customer 고객
	 * @throws NotExistException
	 */
	public void projectCustomerUpdate(String reservationNumber, Customer customer) throws NotExistException{
		ReservationManagement reservation = getReservation(reservationNumber);
		
		if(reservation == null) {
			throw new NotExistException("해당 예약 번호는 존재하지 않습니다");
		}else {
			reservation.setReservationCustomer(customer);
			LogTest.customerUpdateCheck("Success", reservationNumber, customer);
		}
	}
	
	/**
	 * Reservation의 객실 정보 수정 - 예약 번호로 검색해서 해당 예약 번호의 객실 정보 수정
	 * 수정하고자 하는 예약 번호가 존재하지 않을 경우 NotExistException 발생
	 * 
	 * @param reservationNumber 예약번호
	 * @param room 객실
	 * @throws NotExistException
	 */
	public void projectRoomUpdate(String reservationNumber, Room room) throws NotExistException{
		ReservationManagement reservation = getReservation(reservationNumber);
		
		if(room.getState() != 0) {
			throw new NotExistException("해당 객실은 이미 예약된 객실입니다");
		}else {
			reservation.getReservationRoom().setState(0);
			reservation.setReservationRoom(room);
			reservation.getReservationRoom().setState(1);
			LogTest.roomUpdateCheck("Success", reservationNumber, room);
		}
	}
	
	/**
	 * Reservation 삭제 - 예약 번호로 해당하는 프로젝트 삭제
	 * 
	 * @param reservationNumber 삭제하고자 하는 예약 번호
	 * @throws NotExistException
	 */
	public void reservationDelete(String reservationNumber) throws NotExistException{
		ReservationManagement reservation = getReservation(reservationNumber);
		if(reservation == null) {
			throw new NotExistException("삭제하고자 하는 예약정보는 존재하지 않습니다");
		}else {
			getReservationList().remove(reservation);
		}
	}
}
