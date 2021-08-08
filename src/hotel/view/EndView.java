package hotel.view;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import hotel.model.dto.ReservationManagement;

public class EndView {
	
	// Ư�� ���� ��ȣ�� ���� ���� ���
	public static void projectView(ReservationManagement reservation) {
		if (reservation != null) {
			System.out.println(reservation);
		} else {
			System.out.println("�ش� ������ �������� �ʽ��ϴ�.");
		}
	}

	// ��� ���� ���� ���
	public static void projectListView(ArrayList<ReservationManagement> allReservationList) {
		for (ReservationManagement reservation : allReservationList) {
			System.out.println(reservation);
		}
	}
	
	// ���ܰ� �ƴ� �ܼ� �޼��� ���
	public static void messageView(String message) {
		System.out.println(message);
	}
}
