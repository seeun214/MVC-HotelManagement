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
				System.out.println("============================== �޴��� �������ּ���. ============================== ");
				System.out.println("1) ��ü ���� ���� �˻� \t 2) ���� ���� ���� �˻� \t 3) ������ ���� ���� �˻�  \t 4) �α� ��� �˻� \t 5) ���� \t 0) �ý��� ����");
				int inputNum = Integer.parseInt(br.readLine());
			
				if(inputNum == 1) {
					System.out.println("==============================  ��ü ���� ���� �˻� ============================== ");
					controller.getReservationList();
				}else if(inputNum == 2){
					System.out.println("==============================  �����ȣ�� ���� ���� �˻� ==============================");
					System.out.println("�����ȣ�� �Է����ּ���.");
					String reservationNum = br.readLine();
					controller.getReservation(reservationNum);
				}else if(inputNum == 3){
					System.out.println("==============================  ������ ���� ���� �˻� ============================== ");
					controller.allReservationState();
				}else if(inputNum == 4){
					System.out.println("==============================  �α� ��� �˻�  ============================== ");
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
					System.out.println("============================== ���� ==============================");
					System.out.println("\n01. ��� ���೻�� �˻� ");
					controller.getReservationList();
					
					System.out.println("\n02. '01a'��� �����ȣ�� ���೻�� �˻� ");
					controller.getReservation("01a");
					
					System.out.println("\n03. �������ϴ� �����ȣ �˻� ");
					controller.getReservation("04d");
					
					//'04d' ��� �����ȣ ���� �����ؼ� ���� �� �˻�
					System.out.println("\n04. '04d'��� ���ο� �������� ���� ��  ��� ���೻�� �˻�");
					ReservationManagement newReservation = new ReservationManagement("04d", 
							new Customer("�ڼ���", "010-777-7777", "shon@company.com", 1),
							roomList.get(1), 
							new PayInfo("2021-07-15", roomList.get(1).getRoomPrice(), "cash"),
							"2021-07-20", "2021-07-22", "������ �̿� ����, ���� ����");
					System.out.println("\n04-1. ���� �� �������� �˻�");
					controller.getReservationList();
					
					System.out.println("\n04-2. ���� ����� ��������");
					controller.insertReservation(newReservation);
					
					System.out.println("\n04-3. ���� �� �˻�");
					controller.getReservationList();
					
					System.out.println("\n04-3. �̹� ����� ���� ������ �õ��� ��ȿ�� ������ ���ռ� ����");
					controller.insertReservation(newReservation);
					
					//���� ������ ��ȿ�� ó�� ���� ����
					System.out.println("\n05. �ǹ̾��� �������� null��  ���� �õ� �� ��ȿ�� ������ ���ռ� ���� ");
					controller.insertReservation(null);
					
					//�����ϴ� '04d' ���೻���� ������ ������Ʈ �� ���� ���� �˻�
					System.out.println("\n06. �����ϴ� '04d' ���� ��ȣ�� �� ���� ���� �� ������ ���� �˻� ");
					System.out.println("06-1. ���� �� ���� ��ȣ �˻�");
					controller.getReservation("04d");
					controller.updateReservationCustomer("04d", new Customer("�ڼ���", "010-999-3999", "seeun@company.com",2));
					
					System.out.println("\n06-2. ���� �� ���� ��ȣ �˻�");
					controller.getReservation("04d");
					
					//�����ϴ� '04d' ���೻���� �������� ������Ʈ �� ���� ���� �˻�
					System.out.println("\n07. �����ϴ� '04d' ���� ���� �� ������ ���� �˻� ");
					System.out.println("07-1. ���� �� ���೻�� �˻�");
					controller.getReservation("04d");
					
					System.out.println("\n07-2. ���� ���� �� ���೻�� �˻�");
					controller.updateReservationRoom("04d", roomList.get(5));
					controller.getReservation("04d");
					
					System.out.println("\n07-3. �ǹ̾��� �������� null�� ���� ���� ���� �õ� �� ��ȿ�� ������ ���ռ� ���� ");
					controller.updateReservationRoom("04d", null);
					
					//'01a' �����ȣ ���� �� �˻�
					System.out.println("\n08. '01a' ���೻�� ���� �� ������ ���� ��ȣ �˻� ");
					System.out.println("08-1. ������ ���೻�� �˻�");
					controller.getReservation("01a");
					
					System.out.println("\n08-2. ��ҵ� ���೻�� �˻�");
					controller.deleteReservation("01a");
					
					System.out.println("\n08-3. ���� �� ���೻��  �˻� ");
					controller.getReservation("01a");
					
					System.out.println("\n08-4. ������ ���೻�� ���� ��õ� �� ��ȿ�� ������ ���ռ� ����");
					controller.deleteReservation("01a");
					
					//���� ���� �˻�
					System.out.println("\n09-1. ��� ������ ���� ����");
					controller.allReservationState();
				}else if(inputNum == 0){
					esc = "esc";
				}else {
					System.out.println("\n��ȣ�� �߸� �Է��ϼ̽��ϴ�\n");
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