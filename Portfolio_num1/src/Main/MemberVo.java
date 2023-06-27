package Main;

public class MemberVo {
	private String id, password, CI;

	public MemberVo() {	}

	//회원가입
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
	
	//아이디 찾기
	public MemberVo(String CI) {
		this.CI = CI;
	}
	
	public void setCI(String CI) {	}
	
	public String getCI() {
		return CI;
	}
}