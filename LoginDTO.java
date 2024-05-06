package classes;

public class LoginDTO{
	private String id;
	private String pwd;

	public LoginDTO(){}
	public LoginDTO(String id, String pwd){
		this.id = id;
		this.pwd = pwd;
	}

// getter
	public String getId(){
		return id;
		}
	public String getPwd(){
		return pwd;
	}

//setter
	void setId(String id){
		this.id = id;
	}
	void setPwd(String pwd){
		this.pwd = pwd;
	}
}
