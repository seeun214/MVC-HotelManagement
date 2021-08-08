package hotel.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import hotel.controller.ReservationManagementController;
import hotel.model.RoomDB;
import hotel.model.dto.Customer;
import hotel.model.dto.PayInfo;
import hotel.model.dto.ReservationManagement;
import hotel.model.dto.Room;

public class StartView {
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ReservationManagementController controller = ReservationManagementController.getInstance();
		RoomDB room = RoomDB.getInstance();
		ArrayList<Room> roomList = room.getRoomList();
		String esc = null;
	
		
		try {
			while(esc == null) {
				System.out.println("============================== 메뉴를 선택해주세요. ============================== ");
				System.out.println("1) 전체 예약 내역 검색 \t 2) 단일 예약 내역 검색 \t 3) 객실의 예약 상태 검색  \t 4) 로그 기록 검색 \t 5) 예시 \t 0) 시스템 끄기");
				int inputNum = Integer.parseInt(br.readLine());
			
				if(inputNum == 1) {
					System.out.println("==============================  전체 예약 내역 검색 ============================== ");
					controller.getReservationList();
				}else if(inputNum == 2){
					System.out.println("==============================  예약번호로 예약 내역 검색 ==============================");
					System.out.println("예약번호를 입력해주세요.");
					String reservationNum = br.readLine();
					controller.getReservation(reservationNum);
				}else if(inputNum == 3){
					System.out.println("==============================  객실의 예약 상태 검색 ============================== ");
					controller.allReservationState();
				}else if(inputNum == 4){
					System.out.println("==============================  로그 기록 검색  ============================== ");
					try{
				        
						File file = new File("C:\\20210628_lab\\88.log\\hotel.log");
				
						FileReader file_reader = new FileReader(file);
				        int cur = 0;
				        while((cur = file_reader.read()) != -1){
				            System.out.print((char)cur);
				        }
				        file_reader.close();
				        }catch (FileNotFoundException e) {
				            e.getStackTrace();
				        }catch(IOException e){
				            e.getStackTrace();
				        }
				}else if(inputNum == 5){
					System.out.println("============================== 예시 ==============================");
					System.out.println("\n01. 모든 예약내역 검색 ");
					controller.getReservationList();
					
					System.out.println("\n02. '01a'라는 예약번호의 예약내역 검색 ");
					controller.getReservation("01a");
					
					System.out.println("\n03. 미존재하는 예약번호 검색 ");
					controller.getReservation("04d");
					
					//'04d' 라는 예약번호 새로 생성해서 저장 및 검색
					System.out.println("\n04. '04d'라는 새로운 예약정보 저장 후  모든 예약내역 검색");
					ReservationManagement newReservation = new ReservationManagement("04d", 
							new Customer("박세은", "010-777-7777", "shon@company.com", 1),
							roomList.get(1), 
							new PayInfo("2021-07-15", roomList.get(1).getRoomPrice(), "cash"),
							"2021-07-20", "2021-07-22", "수영장 이용 가능, 조식 포함");
					System.out.println("\n04-1. 저장 전 예약정보 검색");
					controller.getReservationList();
					
					System.out.println("\n04-2. 새로 저장된 예약정보");
					controller.insertReservation(newReservation);
					
					System.out.println("\n04-3. 저장 후 검색");
					controller.getReservationList();
					
					System.out.println("\n04-3. 이미 저장된 예약 재저장 시도후 유효성 검증의 적합성 검증");
					controller.insertReservation(newReservation);
					
					//저장 로직의 유효성 처리 로직 검증
					System.out.println("\n05. 의미없는 데이터인 null로  저장 시도 후 유효성 로직의 적합성 검증 ");
					controller.insertReservation(null);
					
					//존재하는 '04d' 예약내역의 고객정보 업데이트 및 갱신 내용 검색
					System.out.println("\n06. 존재하는 '04d' 예약 번호의 고객 정보 변경 후 수정한 내용 검색 ");
					System.out.println("06-1. 수정 전 예약 번호 검색");
					controller.getReservation("04d");
					controller.updateReservationCustomer("04d", new Customer("박세은", "010-999-3999", "seeun@company.com",2));
					
					System.out.println("\n06-2. 수정 후 예약 번호 검색");
					controller.getReservation("04d");
					
					//존재하는 '04d' 예약내역의 객실정보 업데이트 및 갱신 내용 검색
					System.out.println("\n07. 존재하는 '04d' 객실 변경 후 수정한 내용 검색 ");
					System.out.println("07-1. 수정 전 예약내역 검색");
					controller.getReservation("04d");
					
					System.out.println("\n07-2. 객실 변경 후 예약내역 검색");
					controller.updateReservationRoom("04d", roomList.get(5));
					controller.getReservation("04d");
					
					System.out.println("\n07-3. 의미없는 데이터인 null로 객실 정보 수정 시도 후 유효성 로직의 적합성 검증 ");
					controller.updateReservationRoom("04d", null);
					
					//'01a' 예약번호 삭제 후 검색
					System.out.println("\n08. '01a' 예약내역 삭제 후 삭제한 예약 번호 검색 ");
					System.out.println("08-1. 삭제전 예약내역 검색");
					controller.getReservation("01a");
					
					System.out.println("\n08-2. 취소된 예약내역 검색");
					controller.deleteReservation("01a");
					
					System.out.println("\n08-3. 삭제 후 예약내역  검색 ");
					controller.getReservation("01a");
					
					System.out.println("\n08-4. 삭제된 예약내역 삭제 재시도 후 유효성 로직의 적합성 검증");
					controller.deleteReservation("01a");
					
					//객실 상태 검색
					System.out.println("\n09-1. 모든 객실의 예약 상태");
					controller.allReservationState();
				}else if(inputNum == 0){
					esc = "esc";
				}else {
					System.out.println("\n번호를 잘못 입력하셨습니다\n");
				}
				
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}