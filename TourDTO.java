package classes;

//부모 클래스
public class  TourDTO{
	private String no;
	private String name;
	private String nation;
	private String number;
	private String site;
	private String chk;

	int payChk(){
		return 0;
	}

	public TourDTO(){}
	public TourDTO(String no, String name, String nation, String number, String site, String chk){
		this.no = no;
		this.name = name;
		this.nation = nation;
		this.number = number;
		this.site = site;
		this.chk = chk;
	}
// getter
	public String getNo(){
	 return no;
	}

	public String getName(){
	 return name;
	}

	public String getNation(){
		 return nation;
		}
	
	public String getNumber(){
		 return number;
		}

	public String getSite(){
	 return site;
	}
	public String getChk(){
	 return chk;
	}

//setter
	void setNo(){
		this.no = no;
	}

	void setName(){
		this.name = name;
	}

	void setNation(){
			this.nation = nation;
		}

	void setNumber(){
			this.number = number;
		}

	void setSite(){
		this.site = site;
	}
	void setChk(){
		this.chk = chk;
	}
	
}
