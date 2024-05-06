package classes;
import java.util.Scanner;
import java.util.Arrays;

class  ReservationDAO
{
	TourDAO dao = new TourDAO();
	TourDB db = new TourDB ();
	UserAPI userAPI = new UserAPI();
	TourDTO[] hotelDTO = dao.hotelSet();
	TourDTO[] planeDTO = dao.planeSet();
	
	Scanner sc = new Scanner(System.in);

	int unitMoney = 10000;

//국내호텔 예약 프로세스-------------------------------------------------------------------------
	void hotelLoReservation(){
		while(true){
			System.out.print("\n\t\t^ 호텔선택 [돌아가기 : Q] : ");
			String choice = sc.nextLine();
			if (choice.equalsIgnoreCase("Q")){
				System.out.println("\n\t\t^ 숙소예약 메뉴로 돌아갑니다.\n");
				return;
			}
			if(choice.length()==0){
				System.out.print("\n\t\t^ 공백이 입력되었습니다.\t\n");
				continue;
			}
			if(choice.length()==0){
				System.out.print("\n\t\t^ 공백이 입력되었습니다.\t\n");
				continue;
			}
			char hotel = choice.charAt(0);
			if(hotel < 48 || hotel > 51){// 호텔순서 인덱스
				System.out.print("\n\t\t^ 1 ~ 4 번호만 입력해주세요.\t\n");
				continue;
			}
			System.out.print("\n\t\t^ 몇일 예약할지 날짜를 입력해주세요 : ");
			String day = sc.nextLine();
			
			if(day.length()==0){
				System.out.print("\n\t\t^ 공백이 입력되었습니다.\t\n");	
				continue;
			}
			else if(day.length() !=0){
				for(int i = 0; i < day.length(); i++){
					char[] ch1 = choice.toCharArray();
					char[] ch = day.toCharArray();
					if(ch1[i] < 48 || ch1[i] > 57){// 호텔순서 인덱스
						System.out.print("\n\t\t^ 숫자만 입력해주세요.\t\n");
						break;
					}
					if(ch[i] < 48 || ch[i] > 57){// 날짜 인덱스
						System.out.print("\n\t\t^ 숫자만 입력해주세요.\t\n");
						break;
					}else{
						int idx =Integer.parseInt(choice)-1;
						int temp = Integer.parseInt(day);

						System.out.printf("\n\t\t^ %s의 %s일의 예약 가격은 %,d원입니다.\n",
						hotelDTO[idx].getName(),day,
						((HotelDTO)hotelDTO[idx]).getPay()*unitMoney*temp);
						break;
					}
				}
			}
		}
	}//hotelLoReservation() end

//해외호텔 예약 프로세스-------------------------------------------------------------------------
	
	void hotelFoReservation(){
		dao.hotelSet();
		while(true){
			System.out.print("\n\t\t^ 호텔선택 [돌아가기 : Q] : ");
			String choice = sc.nextLine();
			if (choice.equalsIgnoreCase("Q")){
				System.out.println("\n\t\t^ 숙소예약 메뉴로 돌아갑니다.\n");
				return;
			}
			if(choice.length()==0){
				System.out.print("\n\t\t^ 공백이 입력되었습니다.\t\n");
				continue;
			}
			char hotel = choice.charAt(0);
			if(hotel < 48 || hotel > 50){// 호텔순서 인덱스
				System.out.print("\n\t\t^ 1 ~ 3 번호만 입력해주세요.\t\n");
				continue;
			}
			System.out.print("\n\t\t^ 몇일 예약할지 날짜를 입력해주세요 : ");
			String day = sc.nextLine();
			
			if(day.length()==0){
				System.out.print("\n\t\t^ 공백이 입력되었습니다.\t\n");	
				continue;
			}
			else if(day.length() !=0){
				for(int i = 0; i < day.length(); i++){
					char[] ch1 = choice.toCharArray();
					char[] ch = day.toCharArray();
					if(ch1[i] < 48 || ch1[i] > 57){// 호텔순서 인덱스
						System.out.print("\n\t\t^ 숫자만 입력해주세요.\t\n");
						break;
					}
					if(ch[i] < 48 || ch[i] > 57){// 날짜 인덱스
						System.out.print("\n\t\t^ 숫자만 입력해주세요.\t\n");
						break;
					}else{
						int idx =Integer.parseInt(choice)+3;
						int temp = Integer.parseInt(day);
						System.out.printf("\n\t\t^ %s의 %s일의 예약 가격은 %,d원입니다.\n",
						hotelDTO[idx].getName(),day,
						((HotelDTO)hotelDTO[idx]).getPay()*unitMoney*temp);
						break;							
					}
				}
			}
		}
	}//hotelFoReservation() end

//해외호텔 예약취소 프로세스--------------------------------------------------------------------
	double charge = 0.1;	// 취소 수수료를 구하기위한 정수값
	void hotelFoCancel(){
		while(true){
			System.out.print("\n\t\t^ 호텔선택 [돌아가기 : Q] : ");
			String choice = sc.nextLine();
			if (choice.equalsIgnoreCase("Q")){
				System.out.println("\n\t\t^ 숙소예약 메뉴로 돌아갑니다.\n");
				return;
			}
			if(choice.length()==0){
				System.out.print("\n\t\t^ 공백이 입력되었습니다.\t\n");
				continue;
			}
			char hotel = choice.charAt(0);
			if(hotel < 48 || hotel > 50){// 호텔순서 인덱스
				System.out.print("\n\t\t^ 1 ~ 3 번호만 입력해주세요.\t\n");
				continue;
			}
			else if(choice.length() != 0){
				for(int i = 0; i < choice.length(); i++){
					char[] ch1 = choice.toCharArray();
					if(ch1[i] < 48 || ch1[i] > 57){// 호텔순서 인덱스
						System.out.print("\n\t\t^ 숫자만 입력해주세요.\t\n");
						break;
					}else{
						int idx =Integer.parseInt(choice)+3;
						System.out.printf("\n\t\t^ %s의 예약취소가격은 원가의 20프로인 %,.0f원입니다.\n",
						hotelDTO[idx].getName(),
						((HotelDTO)hotelDTO[idx]).getPay()*unitMoney*charge*2);
						break;
					}
				}
			}
		}
	}//hotelCancel() end

//국내호텔 예약취소 프로세스--------------------------------------------------------------------
	void hotelLoCancel(){
		while(true){
			System.out.print("\n\t\t^ 호텔선택 [돌아가기 : Q] : ");
			String choice = sc.nextLine();
			if (choice.equalsIgnoreCase("Q")){
				System.out.println("\n\t\t^ 숙소예약 메뉴로 돌아갑니다.\n");
				return;
			}
			if(choice.length()==0){
				System.out.print("\n\t\t^ 공백이 입력되었습니다.\t\n");
				continue;
			}
			char hotel = choice.charAt(0);
			if(hotel < 48 || hotel > 51){// 호텔순서 인덱스
				System.out.print("\n\t\t^ 1 ~ 4 번호만 입력해주세요.\t\n");
				continue;
			}
			else if(choice.length() != 0){
				for(int i = 0; i < choice.length(); i++){
					char[] ch1 = choice.toCharArray();
					if(ch1[i] < 48 || ch1[i] > 57){// 호텔순서 인덱스
						System.out.print("\n\t\t^ 숫자만 입력해주세요.\t\n");
						break;
					}else{
						int idx =Integer.parseInt(choice)-1;
							System.out.printf("\n\t\t^ %s의 예약취소가격은 원가의 20프로인 %,.0f원입니다.\n",
							hotelDTO[idx].getName(),
							((HotelDTO)hotelDTO[idx]).getPay()*unitMoney*charge*2);
							break;	
					}
				}
			}
		}
	}//hotelLoCancel() end

//국내 항공예약 프로세스-------------------------------------------------------------------------
	void planeLoReservation(){
		while(true){
			System.out.print("\n\t\t^ 항공사선택 [돌아가기 : Q] : ");
			String choice = sc.nextLine();
			if (choice.equalsIgnoreCase("Q")){
				System.out.println("\n\t\t^ 항공예약 메뉴로 돌아갑니다.\n");
				return;
			}if(choice.length()==0){
				System.out.print("\n\t\t^ 공백이 입력되었습니다.\t\n");
				continue;
			}else if(choice.length() != 0){
				for(int i = 0; i < choice.length(); i++){
					char[] ch1 = choice.toCharArray();
					if(ch1[i] < 48 || ch1[i] > 57){
						System.out.print("\n\t\t^ 숫자만 입력해주세요.\t\n");
						break;
					}
				}
			}
			int idx =Integer.parseInt(choice)-1;
			planeChk(idx);
			System.out.print("\n\t\t^ 메뉴를 선택하세요 [ Q : 돌아가기] : ");
			String choice2 = sc.nextLine();
			if (choice2.equalsIgnoreCase("Q")){
				System.out.println("\n\t\t^ 항공예약 메뉴로 돌아갑니다.\n");
				return;
			}if(choice2.length() >1&& choice2.length()==0){
				System.out.print("\n\t\t^  한글자만 입력해주세요 .\t\n");
				continue;
			}
			if(choice2.length() == 1){
				char ch = choice2.charAt(0);
				if(ch < 48 || ch > 51){
					System.out.print("\n\t\t^ 1 ~ 3 번호만 입력해주세요.\t\n");
					break;
				}
				if (ch == 49){
					System.out.printf("\n\t\t^ %s의 편도(출발) 예약 가격 :  %,d원입니다.\n\n",
					planeDTO[idx].getName(),
					((PlaneDTO)planeDTO[idx]).getTakeOff()*unitMoney);
					continue;
				}if (ch == 50){
					System.out.printf("\n\t\t^ %s의 편도(도착) 예약 가격 :  %,d원입니다.\n\n",
					planeDTO[idx].getName(),
					((PlaneDTO)planeDTO[idx]).getLanding()*unitMoney);
					continue;
				}if (ch == 50){
					System.out.printf("\n\t\t^ %s의 왕복 예약 가격 :  %,d원입니다.\n\n",
					planeDTO[idx].getName(),
					planeDTO[idx].payChk()*unitMoney);
					continue;
				}
			}
		}
	}// planeLoReservation() end

//해외 항공예약 프로세스-------------------------------------------------------------------------
	void planeFoReservation(){
		while(true){
			System.out.print("\n\t\t^ 항공사선택 [돌아가기 : Q] : ");
			String choice = sc.nextLine();
			if (choice.equalsIgnoreCase("Q")){
				System.out.println("\n\t\t^ 항공예약 메뉴로 돌아갑니다.\n");
				return;
			}if(choice.length()==0){
				System.out.print("\n\t\t^ 공백이 입력되었습니다.\t\n");
				continue;
			}else if(choice.length() != 0){
				for(int i = 0; i < choice.length(); i++){
					char[] ch1 = choice.toCharArray();
					if(ch1[0] < 48 || ch1[0] > 50){
						System.out.print("\n\t\t^ 1~ 2 번호만 입력해주세요.\t\n");
						break;
					}
				}
			}
			int idx =Integer.parseInt(choice)+2;
			planeChk(idx);
			System.out.print("\n\t\t^ 메뉴를 선택하세요 [ Q : 돌아가기] : ");
			String choice2 = sc.nextLine();
			if (choice2.equalsIgnoreCase("Q")){
				System.out.println("\n\t\t^ 항공예약 메뉴로 돌아갑니다.\n");
				return;
			}if(choice2.length() >1&& choice2.length()==0){
				System.out.print("\n\t\t^  한글자만 입력해주세요 .\t\n");
				continue;
			}
			if(choice2.length() == 1){
				char ch = choice2.charAt(0);
				if(ch < 48 || ch > 51){
					System.out.print("\n\t\t^ 1 ~ 3 번호만 입력해주세요.\t\n");
					break;
				}
				if (ch == 49){
					System.out.printf("\n\t\t^ %s의 편도(출발) 예약 가격 :  %,d원입니다.\n\n",
					planeDTO[idx].getName(),
					((PlaneDTO)planeDTO[idx]).getTakeOff()*unitMoney);
					continue;
				}if (ch == 50){
					System.out.printf("\n\t\t^ %s의 편도(도착) 예약 가격 :  %,d원입니다.\n\n",
					planeDTO[idx].getName(),
					((PlaneDTO)planeDTO[idx]).getLanding()*unitMoney);
					continue;
				}if (ch == 50){
					System.out.printf("\n\t\t^ %s의 왕복 예약 가격 :  %,d원입니다.\n\n",
					planeDTO[idx].getName(),
					planeDTO[idx].payChk()*unitMoney);
					continue;
				}
			}
		}
	}// planeFoReservation() end

	void planeChk(int idx){
			userAPI.mLine('=',70);
			System.out.printf("\n\t\t^ %s 항공사의 예약 선택표\n\n",planeDTO[idx].getName());
			userAPI.mLine('=',70);
			System.out.println("\n\t\t1. 편도 출발권 예약\n\n");
			System.out.println("\t\t2. 편도 도착권 예약\n\n");
			System.out.println("\t\t3. 왕복권 예약\n\n");
			System.out.println("\t\tQ. 돌아가기\n");
			userAPI.mLine('=',70);
	}//planeChk(int idx) end

//항공 예약취소 프로세스-------------------------------------------------------------------------
	void planeLoCancel(){
		while(true){
			System.out.print("\n\t\t^ 항공사선택 [돌아가기 : Q] : ");
			String choice = sc.nextLine();
			if (choice.equalsIgnoreCase("Q")){
				System.out.println("\n\t\t^ 항공예약 메뉴로 돌아갑니다.\n");
				return;
			}
			if(choice.length()==0){
				System.out.print("\n\t\t^ 공백이 입력되었습니다.\t\n");
				continue;
			}else if(choice.length() != 0){
				for(int i = 0; i < choice.length(); i++){
					char[] ch1 = choice.toCharArray();
					if(ch1[0] < 48 || ch1[0] > 51){
						System.out.print("\n\t\t^ 1 ~3번호만 입력해주세요.\t\n");
						break;
					}
				}
			}
			int idx =Integer.parseInt(choice)-1;
			pCancleChk(idx);
			System.out.print("\n\t\t^ 메뉴를 선택하세요 [ Q : 돌아가기] : ");
			String choice2 = sc.nextLine();
			if (choice2.equalsIgnoreCase("Q")){
				System.out.println("\n\t\t^ 항공예약 메뉴로 돌아갑니다.\n");
				return;
			}if(choice2.length() >1&& choice2.length()==0){
				System.out.print("\n\t\t^  한글자만 입력해주세요 .\t\n");
				continue;
			}
			
			if(choice2.length() == 1){
				char ch = choice2.charAt(0);
				if(ch < 48 || ch > 51){
					System.out.print("\n\t\t^ 1 ~ 3 번호만 입력해주세요.\t\n");
					break;
				}
				if (ch == 49){
					System.out.printf("\n\t\t^ %s의 편도(출발) 예약 취소가격은 원가의 10프로인 %,.0f원입니다.\n\n",
					planeDTO[idx].getName(),
					((PlaneDTO)planeDTO[idx]).getTakeOff()*unitMoney*charge);
					continue;
				}if (ch == 50){
					System.out.printf("\n\t\t^ %s의 편도(도착) 예약 취소가격은 원가의 10프로인 %,.0f원입니다.\n\n",
					planeDTO[idx].getName(),
					((PlaneDTO)planeDTO[idx]).getLanding()*unitMoney*charge);
					continue;
				}if (ch == 50){
					System.out.printf("\n\t\t^ %s의 왕복 예약 취소가격은 원가의 10프로인 %,.0f원입니다.\n\n",
					planeDTO[idx].getName(),
					planeDTO[idx].payChk()*unitMoney*charge);
					continue;
				}
			}
		}
	}// planeLoCancel() end

		void planeFoCancel(){
		while(true){
			System.out.print("\n\t\t^ 항공사선택 [돌아가기 : Q] : ");
			String choice = sc.nextLine();
			if (choice.equalsIgnoreCase("Q")){
				System.out.println("\n\t\t^ 항공예약 메뉴로 돌아갑니다.\n");
				return;
			}
			if(choice.length()==0){
				System.out.print("\n\t\t^ 공백이 입력되었습니다.\t\n");
				continue;
			}else if(choice.length() != 0){
				for(int i = 0; i < choice.length(); i++){
					char[] ch1 = choice.toCharArray();
					if(ch1[0] < 48 || ch1[0] > 50){
						System.out.print("\n\t\t^ 1 ~ 2 번호만 입력해주세요.\t\n");
						break;
					}
				}
			}
			int idx =Integer.parseInt(choice)+2;
			pCancleChk(idx);
			System.out.print("\n\t\t^ 메뉴를 선택하세요 [ Q : 돌아가기] : ");
			String choice2 = sc.nextLine();
			if (choice2.equalsIgnoreCase("Q")){
				System.out.println("\n\t\t^ 항공예약 메뉴로 돌아갑니다.\n");
				return;
			}if(choice2.length() >1&& choice2.length()==0){
				System.out.print("\n\t\t^  한글자만 입력해주세요 .\t\n");
				continue;
			}
			if(choice2.length() == 1){
				char ch = choice2.charAt(0);
				if(ch < 48 || ch > 51){
					System.out.print("\n\t\t^ 1 ~ 3 번호만 입력해주세요.\t\n");
					break;
				}
				if (ch == 49){
					System.out.printf("\n\t\t^ %s의 편도(출발) 예약 취소가격은 원가의 10프로인 %,.0f원입니다.\n\n",
					planeDTO[idx].getName(),
					((PlaneDTO)planeDTO[idx]).getTakeOff()*unitMoney*charge);
					continue;
				}if (ch == 50){
					System.out.printf("\n\t\t^ %s의 편도(도착) 예약 취소가격은 원가의 10프로인 %,.0f원입니다.\n\n",
					planeDTO[idx].getName(),
					((PlaneDTO)planeDTO[idx]).getLanding()*unitMoney*charge);
					continue;
				}if (ch == 50){
					System.out.printf("\n\t\t^ %s의 왕복 예약 취소가격은 원가의 10프로인 %,.0f원입니다.\n\n",
					planeDTO[idx].getName(),
					planeDTO[idx].payChk()*unitMoney*charge);
					continue;
				}
			}
		}
	}// planeFoCancel() end

	void pCancleChk(int idx){
		userAPI.mLine('=',70);
		System.out.printf("\n\t\t^ %s 항공사의 취소선택표\n\n",planeDTO[idx].getName());
		userAPI.mLine('=',70);
		System.out.println("\n\t\t1. 편도 출발권 예약취소\n\n");
		System.out.println("\t\t2. 편도 도착권 예약취소\n\n");
		System.out.println("\t\t3. 왕복권 예약취소\n\n");
		System.out.println("\t\tQ. 돌아가기\n");
		userAPI.mLine('=',70);
	}//pCancleChk(int idx) end

}
