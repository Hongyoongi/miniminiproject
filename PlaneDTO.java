package classes;

//자식클래스
public class PlaneDTO extends TourDTO {
	private int takeOff;
	private int landing;

	int payChk(){
		return takeOff + landing;
	}
	
	public PlaneDTO(){}
	public PlaneDTO(String no, String name, String nation, String number, String site,String chk, int takeOff, int landing){
		super(no, name, nation, number, site, chk);
		this.takeOff = takeOff;
		this.landing = landing;
		
	}

	//getter
	public int getTakeOff(){
		return takeOff;
	}
	public int getLanding(){
		return landing;
	}

	//setter
	public void setTakeOff(int takeOff){
		this. takeOff =  takeOff;
	}
	public void setLanding(int landing){
		this. landing = landing;
	}
}
