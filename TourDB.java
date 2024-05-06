package classes;

public class TourDB 
{
	
	String hotelSet[][] = {{"1", "A호텔", "강원", "02-123-4567", "Ahotel.com","K"},
		{"2", "B호텔", "양양", "02-555-6789", "Bhotel.com","K"},
		{"3", "C호텔", "부산", "02-234-1234", "Chotel.com","K"},
		{"4", "D호텔", "서울", "02-999-8888", "Dhotel.com","K"},
		{"1", "X호텔", "일본", "02-123-4567", "Xhotel.com","F"},
		{"2", "Y호텔", "독일", "02-355-1332", "Yhotel.com","F"},
		{"3", "Z호텔", "미국", "02-888-7676", "Zhotel.com","F"},	
	};

	String planeSet[][] ={{"1", "AB-123","한국","02-444-5555","koreanair.com","K"},
		{"2", "BD-344","한국","02-777-7777","asianaair.com","K"},
		{"3", "YA-567","한국","02-111-1111","airseoul.com","K"},
		{"1", "JP-333","일본","02-666-6666","peach.com","F"},
		{"2", "AM-555","미국","02-999-9999","koreanair.com","F"}
	};

	int hotelpay[] = {10, 20, 15, 25, 17, 31, 40}; 
	int planepay[][] = {{20, 19}, {22, 20},{20, 22}, {30, 35}, {50, 60}};

	//고객 ID
	String[] id = {"CUST01","CUST02","CUST03","CUST04","CUST05"};
	
	//고객 비밀번호
	String[] pwd = {"1234","1234","1234","1234","1234"};

	
}