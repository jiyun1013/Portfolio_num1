package Main;

public class MemberVo {
	private String id, password, CI;

	public MemberVo() {	}

	public MemberVo(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}
	
	public MemberVo(String CI) {
		this.CI = CI;
	}
	
	public void setCI(String CI) {
		
	}
	
	public String getCI() {
		return CI;
	}
}