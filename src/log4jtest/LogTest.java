package log4jtest;

import org.apache.log4j.Logger;

import hotel.model.dto.Customer;
import hotel.model.dto.ReservationManagement;
import hotel.model.dto.Room;

public class LogTest {
		
		static Logger logger = Logger.getLogger("log4jtest.LogTest");
		
		//예약 확정 로그 기록 메소드
		public static void reservationCheck(String message, ReservationManagement newReservation) {
			if(message.equals("Success")){   
				logger.info("****새로운 예약이 들어왔습니다. 확인해주세요.****      --->추가된 예약 내역: " +newReservation);		
			}
		}
		
		//예약 취소 로그 기록 메소드
		public static void reservationCancelCheck(String message, String reservationNum) {
			
			if(message.equals("Success")){ 
				logger.info("**** 예약번호 "+reservationNum+"의 예약이 취소되었습니다. 확인해주세요****" );		
			}
		}
		
		//고객 정보 변경 로그 기록 메소드
		public static void customerUpdateCheck(String message,String reservationNum, Customer customer) {
			if(message.equals("Success")){ 
				logger.info("**** 예약번호"+reservationNum+ "의 '고객'정보가 수정되었습니다. 확인해주세요.****   --->수정된 고객님 정보: " +"'"+customer+"'");		
			}
		}

		//객실 정보 변경 로그 기록 메소드
		public static void roomUpdateCheck(String message,String reservationNum, Room room) {
			if(message.equals("Success")){   
				logger.info("**** 예약번호"+reservationNum+ "의 '객실'정보가 수정되었습니다. 확인해주세요.****      --->수정된 객실 정보: " +"'"+room+"'");		
			}
		}
}
