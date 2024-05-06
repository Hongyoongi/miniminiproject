package classes;
import java.util.Scanner;
import java.util.Arrays;

public class TourDAO
{
//객체 생성----------------------------------------------------------------------------------
	TourDB db = new TourDB ();
	UserAPI userAPI = new UserAPI();
	TourDTO[] hotelDTO = new TourDTO[db.hotelSet.length];
	TourDTO[] planeDTO = new TourDTO[db.planeSet.length];
	LoginDTO[] dto = new LoginDTO[db.id.length];

//로그인 정보 끌어오기----------------------------------------------------------------------
	LoginDTO[] dtoSet(){
			for(int i = 0; i < db.id.length; i++){
				String id = db.id[i];
				String pwd = db.pwd[i];
				dto[i] = new LoginDTO(id, pwd);
			}
		return dto;
	}

//DB안에 있는 호텔정보 끌어오기-----------------------------------------------------------
	TourDTO[] hotelSet(){
		for(int idx = 0; idx < db.hotelSet.length; idx++){
			String no = db.hotelSet[idx][0];
			String name = db.hotelSet[idx][1];
			String nation  = db.hotelSet[idx][2];
			String number  = db.hotelSet[idx][3];
			String site = db.hotelSet[idx][4];
			String chk = db.hotelSet[idx][5];
			
			char[] ch = db.hotelSet[idx][5].toCharArray();
			if( ch[0] == 75){
				int pay = db.hotelpay[idx];
				hotelDTO[idx] = new HotelDTO(no, name, nation, number, site, chk, pay);
			}
			else{
				int pay = db.hotelpay[idx];
				hotelDTO[idx] = new HotelDTO(no, name, nation, number, site, chk, pay);
			}
		}
		return hotelDTO;
	}// hotelSet() end

//DB안에 있는 항공정보 끌어오기-----------------------------------------------------------
	TourDTO[] planeSet(){
		for(int idx = 0; idx < db.planeSet.length; idx++){
			String no = db.planeSet[idx][0];
			String name = db.planeSet[idx][1];
			String nation  = db.planeSet[idx][2];
			String number  = db.planeSet[idx][3];
			String site = db.planeSet[idx][4];
			String chk = db.planeSet[idx][5];
			
			char[] ch = db.planeSet[idx][5].toCharArray();
			if( ch[0] == 75){
				int takeOff = db.planepay[idx][0];
				int landing = db.planepay[idx][1];
				planeDTO[idx] = new PlaneDTO(no, name, nation, number, site, chk, takeOff, landing);
			}
			else{
				int takeOff = db.planepay[idx][0];
				int landing = db.planepay[idx][1];
				planeDTO[idx] = new PlaneDTO(no, name, nation, number, site, chk, takeOff, landing);
			}
		}
		return planeDTO;
	}//planeSet() end

//국내 호텔 리스트---------------------------------------------------------------------------
	int unitMoney = 10000;
	void printLoHotel(){
		userAPI.mLine('=',70);
		System.out.println("\n\t\t\t<<국내호텔 리스트>>\n");
		userAPI.mLine('=',70);
		System.out.println("\n번호\t호텔명\t나라명\t전화번호\t사이트\t\t가격");
		userAPI.mLine('-',70);
		for(int i = 0; i < db.hotelSet.length; i++){
			char ch = db.hotelSet[i][5].charAt(0);
			if( ch == 75){
				System.out.printf("%s\t%s\t%s\t%s\t%s\t%,d\n\n",
				hotelDTO[i].getNo(), 
				hotelDTO[i].getName(), 
				hotelDTO[i].getNation(), 
				hotelDTO[i].getNumber(),
				hotelDTO[i].getSite(),
				hotelDTO[i].payChk()*unitMoney);
			}
		}
		userAPI.mLine('-',70);
		System.out.println();
		System.out.println("\n\t\t\t1. 예약하기\n");
		System.out.println("\n\t\t\t2. 예약취소하기\n");
		System.out.println("\n\t\t\t3. 문의사항\n");
		userAPI.mLine('-',70);
	}//printLoHotel() end

//해외 호텔 리스트---------------------------------------------------------------------------
	void printFoHotel(){
		userAPI.mLine('=',70);
		System.out.println("\n\t\t\t<<해외호텔 리스트>>\n");
		userAPI.mLine('=',70);
		System.out.println("\n번호\t호텔명\t나라명\t전화번호\t사이트\t\t가격");
		userAPI.mLine('-',70);
		for(int i = 0; i < db.hotelSet.length; i++){
			char ch = db.hotelSet[i][5].charAt(0);
			if( ch == 70){
				System.out.printf("%s\t%s\t%s\t%s\t%s\t%,d\n\n",
				hotelDTO[i].getNo(), 
				hotelDTO[i].getName(), 
				hotelDTO[i].getNation(), 
				hotelDTO[i].getNumber(),
				hotelDTO[i].getSite(),
				hotelDTO[i].payChk()*unitMoney);
			}
		}
		userAPI.mLine('-',70);
		System.out.println();
		System.out.println("\n\t\t\t1. 예약하기\n");
		System.out.println("\n\t\t\t2. 예약취소하기\n");
		System.out.println("\n\t\t\t3. 문의사항\n");
		userAPI.mLine('-',70);
	}//printFoHotel()end

//국내 항공 리스트---------------------------------------------------------------------------
	void printLoPlane(){
		userAPI.mLine('=',70);
		System.out.println("\n\t\t\t<<국내항공 리스트>>\n");
		userAPI.mLine('=',70);
		System.out.println("\n번호\t항공명\t나라명\t전화번호\t사이트\t\t출발편\t도착편");
		userAPI.mLine('-',70);
		for(int i = 0; i < db.planeSet.length; i++){
			char ch = db.planeSet[i][5].charAt(0);
			if( ch == 75){
				System.out.printf("%s\t%s\t%s\t%s\t%s\t%,d\t%,d\n\n",
				planeDTO[i].getNo(), 
				planeDTO[i].getName(), 
				planeDTO[i].getNation(), 
				planeDTO[i].getNumber(),
				planeDTO[i].getSite(),
				((PlaneDTO)planeDTO[i]).getTakeOff()*unitMoney,
				((PlaneDTO)planeDTO[i]).getLanding()*unitMoney);
			}
		}
		userAPI.mLine('-',70);
		System.out.println();
		System.out.println("\n\t\t\t1. 예약하기\n");
		System.out.println("\n\t\t\t2. 예약취소하기\n");
		System.out.println("\n\t\t\t3. 문의사항\n");
		userAPI.mLine('-',70);
	}//printLoPlane() end

//해외 항공 리스트---------------------------------------------------------------------------
	void printFoPlane(){
		userAPI.mLine('=',70);
		System.out.println("\n\t\t\t<<해외항공 리스트>>\n");
		userAPI.mLine('=',70);
		System.out.println("\n번호\t항공명\t나라명\t전화번호\t사이트\t\t출발편\t도착편");
		userAPI.mLine('-',70);
		for(int i = 0; i < db.planeSet.length; i++){
			char ch = db.planeSet[i][5].charAt(0);
			if( ch == 70){
				System.out.printf("%s\t%s\t%s\t%s\t%s\t%,d\t%,d\n\n",
				planeDTO[i].getNo(), 
				planeDTO[i].getName(), 
				planeDTO[i].getNation(), 
				planeDTO[i].getNumber(),
				planeDTO[i].getSite(),
				((PlaneDTO)planeDTO[i]).getTakeOff()*unitMoney,
				((PlaneDTO)planeDTO[i]).getLanding()*unitMoney);
			}
		}
		userAPI.mLine('-',70);
		System.out.println();
		System.out.println("\n\t\t\t1. 예약하기\n");
		System.out.println("\n\t\t\t2. 예약취소하기\n");
		System.out.println("\n\t\t\t3. 문의사항\n");
		userAPI.mLine('-',70);
	}//printFoPlane() end
}
