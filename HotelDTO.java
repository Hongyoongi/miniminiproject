package classes;

//자식클래스
public class HotelDTO extends TourDTO {
	private int pay;

	int payChk(){
		return pay;
	}

	public HotelDTO(){}
	public HotelDTO(String no, String name, String nation, String number, String site,String chk, int pay){
		super(no, name, nation, number, site, chk);
		this.pay = pay;
	}

	//getter
	public int getPay(){
		return pay;
	}
	
	//setter
	public void setPay(int pay){
		this.pay = pay;
	}
}
