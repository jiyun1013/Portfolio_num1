package Main;

public class MemberVo2 {
	private String ID, Time, People, Memo, ReMemo;
	
	public MemberVo2() { }
	
	public MemberVo2(String ID, String Time, String People, String Memo, String ReMemo) {
		this.ID = ID;
		this.Time = Time;
		this.People = People;
		this.Memo = Memo;
		this.ReMemo = ReMemo;
	}

	public String getID() {
		return ID;
	}

	public String getTime() {
		return Time;
	}

	public String getPeople() {
		return People;
	}
	
	public String getMemo() {
		return Memo;
	}
	
	public String getReMemo() {
		return ReMemo;
	}
}