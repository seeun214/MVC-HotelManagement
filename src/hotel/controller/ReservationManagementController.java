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
	 * ���  ���� ���� �˻�
	 */
	public void getReservationList() {
		ArrayList<ReservationManagement> reservationList = service.getReservationList();
		
		if(reservationList.size() != 0) {
			EndView.projectListView(reservationList);	
		}else {
			EndView.messageView("���� ���� ������ �������� �ʽ��ϴ�.");
		}
	}

	/**
	 * ���� ��ȣ�� Ư�� ���� ���� �˻�
	 * 
	 * @param reservationNumber
	 */
	public void getReservation(String reservationNumber) {
		ReservationManagement reservation = service.getReservation(reservationNumber);
		
		if(reservation != null) {
			EndView.projectView(reservation);
		}else {
			EndView.messageView("�˻��� ������ �������� �ʽ��ϴ�");
		}
	}
	
	/**
	 * ���ο� ���� ���� ����
	 * 
	 * @param newReservation
	 */
	public void insertReservation(ReservationManagement newReservation){
		if(newReservation != null) {
			try {
				service.reservationInsert(newReservation);
				EndView.messageView("���� �Ϸ� - " + newReservation);
				LogTest.reservationCheck("Success", newReservation);
			}catch(DuplicateException e){
				FailView.failMessageView(e.getMessage());
			}
		}else {
			EndView.messageView("���� �����ϰ��� �ϴ� ���� ������ �����ϴ�. ��Ȯ�� �� �ּ���");
		}
	}
	
	/**
	 * �����ϴ� ���� ��ȣ�� �� ���� ���� 
	 * ���� ��ȣ�� �˻��ؼ� �ش��ϴ� �� ���� ����
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
			EndView.messageView("�����ϰ��� �ϴ� ���� ������ ��ȿ�մϴ�, �� Ȯ�� �� �ּ���");
		}
	}
	
	/** 
	 * �����ϴ� ���� ��ȣ�� ���� ���� ����
	 * ���� ��ȣ�� �˻��ؼ� �ش��ϴ� ���� ���� ����
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
			EndView.messageView("�����ϰ��� �ϴ� ���� ������ ��ȿ�մϴ�, �� Ȯ�� �� �ּ���");
		}
	}
	
	/** 
	 * ���� ��ȣ�� �ش��ϴ� ������Ʈ ����
	 * 
	 * @param reservationNumber
	 */
	public void deleteReservation(String reservationNumber) {
		if(reservationNumber != null) {
			try {
				service.reservationDelete(reservationNumber);
				EndView.messageView(reservationNumber + " ���� ��� �Ϸ� ");
				LogTest.reservationCancelCheck("Success", reservationNumber);
			}catch(NotExistException e) {
				FailView.failMessageView(e.getMessage());
//				e.printStackTrace();
			}	
		}else {
			EndView.messageView("�����ϰ��� �ϴ� �����ȣ�� �����ϴ�. �� Ȯ�� �� �ּ���");
		}
		
	}
	
	/** 
	 * ���� ���� ���� �˻�
	 * 
	 */
	public void allReservationState() {
		RoomDB roomState = RoomDB.getInstance();
		for(int i = 0; i < roomState.getRoomList().size(); i++) {
			if(roomState.getRoomList().get(i).getState() == 0) {
				System.out.println(roomState.getRoomList().get(i).getRoomNo() + "ȣ�� ������ �����մϴ�");
			}else {
				System.out.println(roomState.getRoomList().get(i).getRoomNo() + "ȣ�� ������ �� �� �����ϴ�");
				
			}
		}
	}
}
