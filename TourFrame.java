package classes;
import java.util.Scanner;

public class TourFrame {
//객체생성-------------------------------------------------------------------------		
		UserAPI userAPI = new UserAPI();
		TourDAO dao = new TourDAO();
		LoginDTO[] dto = dao.dtoSet();
		ReservationDAO reDAO = new ReservationDAO();
		TourDTO[] hotelDTO = dao.hotelSet();
		TourDTO[] planeDTO = dao.planeSet();
		
//메인 화면-------------------------------------------------------------------------
	void intro(){
			userAPI.mLine('=',70);
			System.out.println("\n\t\t\t <<숙박 / 항공 예약 시스템>>\t\t\n");
			userAPI.mLine('=',70);
			System.out.println("\t\t\t1. 숙박시설 예약\n\n");
			System.out.println("\t\t\t2. 항공권 예약\n\n");
			System.out.println("\t\t\t3. 여행자 편의\n\n");
			System.out.println("\t\t\tQ. 로그아웃\n");
			userAPI.mLine('=',70);
		}
		Scanner sc = new Scanner(System.in);
		
//선택지 로직-----------------------------------------------------------------------
		void printSelect(){
			while(true){
				System.out.println("\n\t\t^ "+dto[idIdx].getId()  +"님 로그인확인 \n");
				intro();
				System.out.print("\t\t 메뉴 선택 : ");
				String choice = sc.nextLine();
				if(choice.equalsIgnoreCase("Q")){
					System.out.println("\n\t\t^ 로그아웃합니다.\n");
					return;
				}
				else if(choice.length()==0){
					System.out.print("\n\t\t^ 공백이 입력되었습니다.\t\n");
					System.out.println();
					continue;
				}
				else if(choice.length() >1){
					System.out.println("\n\t\t^한자리수만 입력하세요.\n");
					continue;
				}
				int num = Integer.parseInt(choice);
				if(choice.length() == 1){
					if(choice.charAt(0)<49 || choice.charAt(0)>51){ 
						System.out.println("\n\t\t ^1 ~ 3 사이의 메뉴번호를 선택하세요.\n");
						continue;
					}
					else{
						switch(num){
							case 1 :
							hotelSetMenu();
							break;
							case 2:
							planeSetMenu();
							break;
							case 3:
							System.out.print("\n\t\t <<시스템 구현중입니다>>\n\n");
							System.out.print("\n\t\t 메뉴 선택 [ Q : 돌아가기] : ");
							String input3 = sc.nextLine();
							System.out.println();
							if (input3.equalsIgnoreCase("Q")){
								System.out.println("\n\t\t^ 메인메뉴로 돌아갑니다.\n");
								continue;
							} 
						}
					}
				}
			}				
		}

//숙소예약창------------------------------------------------------------------------
		void hotelPrint(){
			System.out.println("\n\t\t>> 숙소 예약창으로 이동합니다\t\t\n");
			userAPI.mLine('-',70);
			System.out.println("\n\t\t\t<<"+dto[idIdx].getId()  +"님 숙소 예약>>\t\t\n");
			userAPI.mLine('-',70);
			System.out.println("\n\t\t\t1. 국내 숙소 예약\n\n");
			System.out.println("\t\t\t2. 해외 숙소 예약\n\n");
			System.out.println("\t\t\tQ. 메인메뉴로 돌아가기\n");
			userAPI.mLine('-',70);
		}

//항공예약창------------------------------------------------------------------------
		void planePrint(){
			System.out.println("\n\t\t>> 항공권 예약창으로 이동합니다\t\t\n");
			userAPI.mLine('-',70);
			System.out.println("\n\t\t<<"+dto[idIdx].getId()  +"님 항공권 예약>>\t\t\n");;
			userAPI.mLine('-',70);
			System.out.println("\n\t\t1. 국내 항공권 예약\n\n");
			System.out.println("\t\t2. 해외 항공권 예약\n\n");
			System.out.println("\t\tQ. 메인메뉴로 돌아가기\n");
			userAPI.mLine('-',70);
		}

//숙소 예약로직---------------------------------------------------------------------
	void hotelSetMenu(){
		while(true){
			hotelPrint();
			System.out.print("\t\t 메뉴 선택 : ");
			String input1 = sc.nextLine();
			System.out.println();
			if(input1.equalsIgnoreCase("Q")){
					System.out.println("\n\t\t^ 메인 메뉴로 돌아갑니다.\n");
					return;
			}else if(input1.length()==0){
				System.out.print("\n\t\t^ 공백이 입력되었습니다.\t\n");
				System.out.println();
				continue;
			}else if(input1.length() >1){
				System.out.println("\n\t\t^한자리수만 입력하세요.\n");
				continue;
			}
			int num = Integer.parseInt(input1);
			if(input1.length() == 1){
				if(input1.charAt(0)<49 || input1.charAt(0)>50){ 
					System.out.println("\n\t\t ^1 ~ 2 사이의 메뉴번호를 선택하세요.\n");
					continue;
			}else{ 
				switch(num){
					case 1 :
						logHotel();
						break;					
					case 2:
						forHotel();
						break;
					}// switch end
				}
			}
		}
	}//hotelSetMenu() end	

//국내호텔 예약창------------------------------------------------------------------
	int idIdx = 0;		// 아이디  인덱스를 받아오기위한 MV
	int flag = 0;		// 아이디 인덱스를 확인하기 위한 boolean형태의 int
	
	void logHotel(){
		while(true){
			dao.printLoHotel();
			System.out.print("\n\t\t^ 메뉴선택 [Q : 돌아가기] : ");
			String hotelIn = sc.nextLine();
			if (hotelIn.equalsIgnoreCase("Q")){
				System.out.println("\n\t\t^ 숙소예약 메뉴로 돌아갑니다.\n");
				return;
			}else if(hotelIn.length()==0){
				System.out.print("\n\t\t^ 공백이 입력되었습니다.\t\n");
				System.out.println();
				continue;
			}else if(hotelIn.length() >1){
				System.out.println("\n\t\t^한자리수만 입력하세요.\n");
				continue;
			}
			int num = Integer.parseInt(hotelIn);
			if(hotelIn.length() == 1){
				if(hotelIn.charAt(0)<49 || hotelIn.charAt(0)>51){ 
					System.out.println("\n\t\t ^1 ~ 3 사이의 메뉴번호를 선택하세요.\n");
					continue;
				}else{
					switch(num){
						case 1 :
							reDAO.hotelLoReservation();
							break;
						case 2 :
							reDAO.hotelLoCancel();
							break;
						case 3 :
							System.out.println("\t\t^문의사항 남기기 시스템을을 종료합니다.\n");
							break;
					}
				}
			}
		}
	}	//logHotel() end

//해외호텔 예약창------------------------------------------------------------------
	void forHotel(){
		while(true){
			dao.printFoHotel();
			System.out.print("\n\t\t^ 메뉴선택 [Q : 돌아가기] : ");
			String hotelIn = sc.nextLine();
			if (hotelIn.equalsIgnoreCase("Q")){
				System.out.println("\n\t\t^ 숙소예약 메뉴로 돌아갑니다.\n");
				return;
			}else if(hotelIn.length()==0){
				System.out.println("\n\t\t^ 공백이 입력되었습니다.\t\n");
				System.out.println();
				continue;
			}else if(hotelIn.length() >1){
				System.out.println("\n\t\t^ 한자리수만 입력하세요.\n");
				continue;
			}
			int num = Integer.parseInt(hotelIn);
			if(hotelIn.length() == 1){
				if(hotelIn.charAt(0)<49 || hotelIn.charAt(0)>51){ 
					System.out.println("\n\t\t ^1 ~ 3 사이의 메뉴번호를 선택하세요.\n");
					continue;
				}else{
					switch(num){
						case 1 :
							reDAO.hotelFoReservation();
							break;
						case 2 :
							reDAO.hotelFoCancel();
							break;
						case 3 :
							System.out.println("\t\t^문의사항 남기기 시스템을 종료합니다.\n");
							break;
					}
				}
			}
		}
	}//forHotel() end

//항공 예약로직---------------------------------------------------------------------
	void planeSetMenu(){	
		while(true){
			planePrint();
			System.out.print("\t\t 메뉴 선택 : ");
			String input2 = sc.nextLine();
			System.out.println();
			if (input2.equalsIgnoreCase("Q")){
				System.out.println("\t\t^ 메인메뉴로 돌아갑니다.\n");
				return;
			}else if(input2.length()==0){
				System.out.print("\t\t^ 공백이 입력되었습니다.\t\n");
				System.out.println();
				continue;
			}else if(input2.length() >1){
				System.out.println("\t\t^한자리수만 입력하세요.\n");
				continue;
			}
			int num = Integer.parseInt(input2);
			if(input2.length() == 1){
				if(input2.charAt(0)<49 || input2.charAt(0)>50){ 
					System.out.println("\n\t\t ^1 ~ 2 사이의 메뉴번호를 선택하세요.\n");
					continue;
				}else{ 
					switch(num){
					case 1 :
						logPlane();
						break;
					case 2:
						forPlane();
						break;
					}// switch end
				}
			}
		}
	}//hotelSetMenu() end

//국내항공 예약창------------------------------------------------------------------
	void logPlane(){
		while(true){	
			dao.printLoPlane();
			System.out.print("\n\t\t^ 메뉴선택 [Q : 돌아가기] : ");
			String planeIn = sc.nextLine();
			if (planeIn.equalsIgnoreCase("Q")){
				System.out.println("\n\t\t^ 항공예약 메뉴로 돌아갑니다.\n");
				return;
			}else if(planeIn.length()==0){
				System.out.print("\t\t^ 공백이 입력되었습니다.\t\n");
				System.out.println();
				continue;
			}else if(planeIn.length() >1){
				System.out.println("\t\t^한자리수만 입력하세요.\n");
				continue;
			}
			int num = Integer.parseInt(planeIn);
			if(planeIn.length() == 1){
				if(planeIn.charAt(0)<49 || planeIn.charAt(0)>51){ 
					System.out.println("\n\t\t ^1 ~ 3 사이의 메뉴번호를 선택하세요.\n");
					continue;
				}else{
					switch(num){
						case 1 :
							reDAO.planeLoReservation();
							break;
						case 2 :
							reDAO.planeFoCancel();
							break;
						case 3 :
							System.out.println("\t\t^문의사항 남기기 시스템을을 종료합니다.");
							break;
					}
				}
			}
		}
	}//logPlane() end
	
//해외항공 예약창------------------------------------------------------------------
	void forPlane(){
		while(true){
			dao.printFoPlane();
			System.out.print("\n\t\t^ 메뉴선택 [Q : 돌아가기] : ");
			String planeIn = sc.nextLine();
			if (planeIn.equalsIgnoreCase("Q")){
				System.out.println("\n\t\t^ 항공예약 메뉴로 돌아갑니다.\n");
				return;
			}else if(planeIn.length()==0){
				System.out.print("\t\t^ 공백이 입력되었습니다.\t\n");
				System.out.println();
				continue;
			}else if(planeIn.length() >1){
				System.out.println("\t\t^한자리수만 입력하세요.\n");
				continue;
			}
			int num = Integer.parseInt(planeIn);
			if(planeIn.length() == 1){
				if(planeIn.charAt(0)<49 || planeIn.charAt(0)>51){ 
					System.out.println("\n\t\t ^1 ~ 3 사이의 메뉴번호를 선택하세요.\n");
					continue;
				}else{
					switch(num){
						case 1 :
							reDAO.planeFoReservation();
							break;
						case 2 :
							reDAO.planeFoCancel();
							break;
						case 3 :
							System.out.println("\t\t^문의사항 남기기 시스템을 종료합니다.");
							break;
					}
				}
			}
		}
	}//forPlane() end
	
//로그인 로직-----------------------------------------------------------------------
	void printLogin(){
		System.out.println("\n\t로그인이 필요한 서비스 입니다\n");
		while(true){
			System.out.print("\n\t아이디를 입력해주세요 [ 종료 : exit] : ");
			String inId = sc.nextLine();

			if(inId.equalsIgnoreCase("exit")){
					System.out.println("\n\t>시스템을 종료합니다\n");
					System.exit(0);
			}
			flag = 1;
			idIdx = flag(inId);
			for(int idx = 0; idx <dto.length; idx++){
				System.out.print("\n\t비밀번호를 입력해주세요 : ");
				String inPwd = sc.nextLine();
				if(inId.equalsIgnoreCase(dto[idIdx].getId())){
					if(inPwd.equals(dto[idIdx].getPwd())){	
						printSelect();
						return;
					}else{
						System.out.println("\n\t^ 비밀번호를 확인해주세요 \n");
						break;
					}
				}else {
						System.out.println("\n\t^ 아이디를 확인해주세요 \n");
						break;
				}
			}
		}// for end		
	}// printLogin() end
			
	int flag(String inId){
		for(int i = 0; i < dto.length; i++){
			if(inId.equalsIgnoreCase(dto[i].getId())){
				flag = 1;
				idIdx = i;
			}
		}
		return idIdx;
	}// int flag(String inId) end

//프로그램 전제 구성도 출력--------------------------------------------------------
	void printMain(){
		while(true){
			intro();
			printLogin();
		}
	}
}
