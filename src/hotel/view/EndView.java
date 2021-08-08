package hotel.view;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import hotel.model.dto.ReservationManagement;

public class EndView {
	
	// 특정 예약 번호의 예약 내역 출력
	public static void projectView(ReservationManagement reservation) {
		if (reservation != null) {
			System.out.println(reservation);
		} else {
			System.out.println("해당 예약은 존재하지 않습니다.");
		}
	}

	// 모든 예약 내역 출력
	public static void projectListView(ArrayList<ReservationManagement> allReservationList) {
		for (ReservationManagement reservation : allReservationList) {
			System.out.println(reservation);
		}
	}
	
	// 예외가 아닌 단순 메세지 출력
	public static void messageView(String message) {
		System.out.println(message);
	}
}
