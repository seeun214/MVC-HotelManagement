package log4jtest;

import org.apache.log4j.Logger;

import hotel.model.dto.Customer;
import hotel.model.dto.ReservationManagement;
import hotel.model.dto.Room;

public class LogTest {
		
		static Logger logger = Logger.getLogger("log4jtest.LogTest");
		
		//���� Ȯ�� �α� ��� �޼ҵ�
		public static void reservationCheck(String message, ReservationManagement newReservation) {
			if(message.equals("Success")){   
				logger.info("****���ο� ������ ���Խ��ϴ�. Ȯ�����ּ���.****      --->�߰��� ���� ����: " +newReservation);		
			}
		}
		
		//���� ��� �α� ��� �޼ҵ�
		public static void reservationCancelCheck(String message, String reservationNum) {
			
			if(message.equals("Success")){ 
				logger.info("**** �����ȣ "+reservationNum+"�� ������ ��ҵǾ����ϴ�. Ȯ�����ּ���****" );		
			}
		}
		
		//�� ���� ���� �α� ��� �޼ҵ�
		public static void customerUpdateCheck(String message,String reservationNum, Customer customer) {
			if(message.equals("Success")){ 
				logger.info("**** �����ȣ"+reservationNum+ "�� '��'������ �����Ǿ����ϴ�. Ȯ�����ּ���.****   --->������ ���� ����: " +"'"+customer+"'");		
			}
		}

		//���� ���� ���� �α� ��� �޼ҵ�
		public static void roomUpdateCheck(String message,String reservationNum, Room room) {
			if(message.equals("Success")){   
				logger.info("**** �����ȣ"+reservationNum+ "�� '����'������ �����Ǿ����ϴ�. Ȯ�����ּ���.****      --->������ ���� ����: " +"'"+room+"'");		
			}
		}
}
