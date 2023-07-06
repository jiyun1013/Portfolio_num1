package Main;

import java.sql.*;
import java.util.*;

//회원 정보 관리 멤버다오
public class MemberDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String user = "c##firstproj";
	String password = "firstproj";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	// 회원가입-아이디 중복 체크
	public ArrayList<MemberVo> Check(String id) {
		ArrayList<MemberVo> check = new ArrayList<MemberVo>();
		try {
			connDB();

			String query = "SELECT * FROM MEMBER";
			if (id != null) {
				query += " where CMS_ID =TRIM('" + id + "')";
			}
			System.out.println("SQL : " + query);

			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());

			if (rs.getRow() == 0) {
				System.out.println("0 row selected...");
			} else {
				System.out.println(rs.getRow() + "row selected...");
				rs.previous();
				while (rs.next()) {
					String ID = rs.getString("CMS_ID");
					System.out.println(ID);

					MemberVo data = new MemberVo(ID);
					check.add(data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	// 회원가입
	public void Newlist(String NewId, String NewPwd, String NewNm, String NewBt, String NewEm) {
		ArrayList<MemberVo> Newlist = new ArrayList<MemberVo>();
		System.out.println(NewId);
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.\n");
			Statement stmt = conn.createStatement();

			String Nquery = "INSERT INTO MEMBER VALUES ('" + NewId + "','" + NewPwd + "','" + NewNm + "','" + NewBt
					+ "', " + "'" + NewEm + "')";
			System.out.println(Nquery);

			boolean b = stmt.execute(Nquery);
			if (!b) {
				System.out.println("Insert success.\n");
			} else {
				System.out.println("Insert fail.\n");
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	// 로그인
	public ArrayList<MemberVo> list(String id) {
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		try {
			connDB();

			String query = "SELECT * FROM MEMBER";
			if (id != null) {
				query += " where CMS_ID =TRIM('" + id + "')";
			}
			System.out.println("SQL : " + query);

			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());

			if (rs.getRow() == 0) {
				System.out.println("0 row selected...");
			} else {
				System.out.println(rs.getRow() + "row selected...");
				rs.previous();
				while (rs.next()) {
					String sh = rs.getString("CMS_ID");
					String password = rs.getString("CMS_PWD");
					System.out.println(sh);
					System.out.println(password);

					MemberVo data = new MemberVo(sh, password);
					list.add(data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 아이디 찾기
	public ArrayList<MemberVo> Idlist(String name, String birthday, String Email) {
		ArrayList<MemberVo> Idlist = new ArrayList<MemberVo>();
		try {
			connDB();

			String Nquery = "SELECT * FROM MEMBER";
			if (name != null && birthday != null && Email != null) {
				Nquery += " WHERE NAME = TRIM('" + name + "')" + " AND BIRTHDAY = TRIM('" + birthday
						+ "') AND EMAIL = TRIM('" + Email + "')";
				System.out.println("SQL : " + Nquery);

				rs = stmt.executeQuery(Nquery);
				rs.last(); // 마지막으로 가는 것
				System.out.println("rs.getRow() : " + rs.getRow());

				if (rs.getRow() == 0) {
					System.out.println("0 row selected.....");
				} else {
					System.out.println(rs.getRow() + "row selected.....");
					rs.previous(); // 직전 위치로 가는 것
					while (rs.next()) {
						String Na = rs.getString("NAME");
						String Bi = rs.getString("BIRTHDAY");
						String Em = rs.getString("EMAIL");
						String CI = rs.getString("CMS_ID");
						System.out.println(CI);

						MemberVo NewCI = new MemberVo(CI);
						Idlist.add(NewCI);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Idlist;
	}

	// 비밀번호 찾기-조회
	public ArrayList<MemberVo> Pwdlist(String FindId, String FindEm) {
		ArrayList<MemberVo> Id = new ArrayList<MemberVo>();
		try {
			connDB();
			if (FindId != null && FindEm != null) {
				String Fquery = "SELECT CMS_ID FROM MEMBER WHERE CMS_ID = '" + FindId + "' AND EMAIL = '" + FindEm
						+ "'";
				System.out.println("SQL : " + Fquery);

				rs = stmt.executeQuery(Fquery);
				rs.last(); // 마지막으로 가는 것
				System.out.println("rs.getRow() : " + rs.getRow());

				if (rs.getRow() == 0) {
					System.out.println("0 row selected.....");
				} else {
					System.out.println(rs.getRow() + "row selected.....");
					rs.previous(); // 직전 위치로 가는 것
					while (rs.next()) {
						String CI = rs.getString("CMS_ID");

						MemberVo NewCI = new MemberVo(CI);
						Id.add(NewCI);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Id;
	}

	// 비밀번호 찾기-변경
	public void NewPwd(String ID, String NPwd) {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.\n");
			Statement stmt = conn.createStatement();

			String Nquery = "UPDATE MEMBER SET CMS_PWD = '" + NPwd + "' WHERE CMS_ID ='" + ID + "'";
			System.out.println("SQL : " + Nquery);

			boolean b = stmt.execute(Nquery);
			if (!b) {
				System.out.println("Change password");
			} else {
				System.out.println("Not");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	// 비밀번호 변경 : 기존 비밀번호 찾기
	public String RePwd(String ID) {
		String Pwd = "";
		try {
			connDB();

			String query = "SELECT CMS_PWD FROM MEMBER WHERE CMS_ID =TRIM('" + ID + "')";
			System.out.println("SQL : " + query);

			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());

			if (rs.getRow() == 0) {
				System.out.println("0 row selected...");
			} else {
				System.out.println(rs.getRow() + "row selected...");
				rs.previous();
				while (rs.next()) {
					Pwd = rs.getString("CMS_PWD");
					System.out.println(Pwd);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Pwd;
	}

	// 비밀번호 변경 : 새 비밀번호 설정하기
	public void ReNewPwd(String id, String pwd) {
		/*
		 * RePwd RI = new RePwd(id); 잘못 생각한 부분 RePwd RP = new RePwd(pwd); 이거 넣으면 창 하나씩 더
		 * 생김
		 */

		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.\n");
			Statement stmt = conn.createStatement();

			String Nquery = "UPDATE MEMBER SET CMS_PWD = '" + pwd + "'" + " WHERE CMS_ID ='" + id + "'";
			System.out.println(Nquery);

			boolean b = stmt.execute(Nquery);
			if (!b) {
				System.out.println("Insert success.\n");
			} else {
				System.out.println("Insert fail.\n");
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	// 탈퇴하기
	public void Unrelist(String ID) {
		ArrayList<MemberVo> Unrelist = new ArrayList<MemberVo>();

		Unregister Cc = new Unregister(ID);
		System.out.println(ID);

		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.\n");
			Statement stmt = conn.createStatement();

			String Nquery = "DELETE FROM MEMBER WHERE CMS_ID = '" + ID + "'";
			System.out.println(Nquery);

			boolean b = stmt.execute(Nquery);
			if (!b) {
				System.out.println("Insert success.\n");
			} else {
				System.out.println("Insert fail.\n");
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	//마이페이지 이름 출력
	public String Name(String ID) {
		String name = "";
		try {
			connDB();

			String query = "SELECT NAME FROM MEMBER WHERE CMS_ID = '" + ID + "'";
			System.out.println("SQL : " + query);

			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());

			if (rs.getRow() == 0) {
				System.out.println("0 row selected...");
			} else {
				System.out.println(rs.getRow() + "row selected...");
				rs.previous();
				while (rs.next()) {
					name = rs.getString("NAME");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return name;
	}

	private void connDB() {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.");
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			System.out.println("statement create success");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}