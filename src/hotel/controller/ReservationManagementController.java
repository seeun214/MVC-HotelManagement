package hotel.controller;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import hotel.exception.DuplicateException;
import hotel.exception.NotExistException;
import hotel.model.RoomDB;
import hotel.model.dto.Customer;
import hotel.model.dto.ReservationManagement;
import hotel.model.dto.Room;
import hotel.service.ReservationManagementService;
import hotel.view.EndView;
import hotel.view.FailView;
import log4jtest.LogTest;

public class ReservationManagementController {
	private static ReservationManagementController instance = new ReservationManagementController();
	private ReservationManagementService service = ReservationManagementService.getInstance();
	
	private ReservationManagementController() {};
	
	public static ReservationManagementController getInstance() {
		return instance;
	}

	/**
	 * 모든  예약 내역 검색
	 */
	public void getReservationList() {
		ArrayList<ReservationManagement> reservationList = service.getReservationList();
		
		if(reservationList.size() != 0) {
			EndView.projectListView(reservationList);	
		}else {
			EndView.messageView("현재 예약 내역이 존재하지 않습니다.");
		}
	}

	/**
	 * 예약 번호로 특정 예약 내역 검색
	 * 
	 * @param reservationNumber
	 */
	public void getReservation(String reservationNumber) {
		ReservationManagement reservation = service.getReservation(reservationNumber);
		
		if(reservation != null) {
			EndView.projectView(reservation);
		}else {
			EndView.messageView("검색한 예약은 존재하지 않습니다");
		}
	}
	
	/**
	 * 새로운 예약 내역 저장
	 * 
	 * @param newReservation
	 */
	public void insertReservation(ReservationManagement newReservation){
		if(newReservation != null) {
			try {
				service.reservationInsert(newReservation);
				EndView.messageView("예약 완료 - " + newReservation);
				LogTest.reservationCheck("Success", newReservation);
			}catch(DuplicateException e){
				FailView.failMessageView(e.getMessage());
			}
		}else {
			EndView.messageView("새로 저장하고자 하는 예약 정보가 없습니다. 재확인 해 주세요");
		}
	}
	
	/**
	 * 존재하는 예약 번호의 고객 정보 수정 
	 * 예약 번호로 검색해서 해당하는 고객 정보 수정
	 * 
	 * @param reservationName
	 * @param customer
	 */
	public void updateReservationCustomer(String reservationNumber, Customer customer) {
		if(customer != null) {
			try {
				service.projectCustomerUpdate(reservationNumber, customer);
			} catch (NotExistException e) {
				FailView.failMessageView(e.getMessage());
			}	
		}else {
			EndView.messageView("수정하고자 하는 객실 정보가 무효합니다, 재 확인 해 주세요");
		}
	}
	
	/** 
	 * 존재하는 예약 번호의 객실 정보 수정
	 * 예약 번호로 검색해서 해당하는 객실 정보 수정
	 * 
	 * @param reservationName
	 * @param room
	 */
	public void updateReservationRoom(String reservationNumber, Room room) {
		if(room != null) {
			try {
				service.projectRoomUpdate(reservationNumber, room);
			} catch (NotExistException e) {
				FailView.failMessageView(e.getMessage());
			}		
		}else {
			EndView.messageView("수정하고자 하는 객실 정보가 무효합니다, 재 확인 해 주세요");
		}
	}
	
	/** 
	 * 예약 번호로 해당하는 프로젝트 삭제
	 * 
	 * @param reservationNumber
	 */
	public void deleteReservation(String reservationNumber) {
		if(reservationNumber != null) {
			try {
				service.reservationDelete(reservationNumber);
				EndView.messageView(reservationNumber + " 예약 취소 완료 ");
				LogTest.reservationCancelCheck("Success", reservationNumber);
			}catch(NotExistException e) {
				FailView.failMessageView(e.getMessage());
//				e.printStackTrace();
			}	
		}else {
			EndView.messageView("삭제하고자 하는 예약번호가 없습니다. 재 확인 해 주세요");
		}
		
	}
	
	/** 
	 * 객실 예약 상태 검색
	 * 
	 */
	public void allReservationState() {
		RoomDB roomState = RoomDB.getInstance();
		for(int i = 0; i < roomState.getRoomList().size(); i++) {
			if(roomState.getRoomList().get(i).getState() == 0) {
				System.out.println(roomState.getRoomList().get(i).getRoomNo() + "호는 예약이 가능합니다");
			}else {
				System.out.println(roomState.getRoomList().get(i).getRoomNo() + "호는 예약을 할 수 없습니다");
				
			}
		}
	}
}
