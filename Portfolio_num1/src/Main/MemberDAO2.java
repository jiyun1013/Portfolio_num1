package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class MemberDAO2 {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String user = "c##firstproj";
	String password = "firstproj";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	// 예약하기
	public void Reslist(String ID, String GDay, String GTime, String GPeople, String GMemo) {
		ArrayList<MemberVo> Reslist = new ArrayList<MemberVo>();
		System.out.println(ID);
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.\n");
			Statement stmt = conn.createStatement();

			String query = "SELECT COUNT(*) FROM CUSTOMER WHERE RES_DAY = '" + GDay + "' AND RES_TIME = '" + GTime
					+ "'";
			System.out.println("SQL : " + query);

			String Nquery = "INSERT INTO CUSTOMER VALUES ('" + ID + "', TO_DATE('" + GDay + "', 'YYYY-MM-DD'), '"
					+ GTime + "', '" + GPeople + "', " + "'" + GMemo + "', '')";

			rs = stmt.executeQuery(query);
			while (rs.next()) {
				System.out.println(rs.getInt("COUNT(*)"));

				if (rs.getInt("COUNT(*)") < 4) {
					System.out.println(Nquery);
					boolean b = stmt.execute(Nquery);
					if (!b) {
						System.out.println("Insert success.\n");
						FinalRe FR = new FinalRe(ID);
						break;
					} else {
						System.out.println("Insert fail.\n");
					}
				} else {
					JOptionPane.showMessageDialog(null, "해당 시간대의 예약이 마감되었습니다. 다시 선택해주세요.");
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	// 예약 변경
	public void ChReser(String ID, String CDay, String CTime, String CMemo) {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.\n");
			Statement stmt = conn.createStatement();

			String query = "SELECT COUNT(*) FROM CUSTOMER WHERE RES_DAY = '" + CDay + "' AND RES_TIME = '" + CTime
					+ "'";
			System.out.println("SQL : " + query);

			String Cquery = "UPDATE CUSTOMER SET RES_DAY = (TO_DATE('" + CDay + "', 'YYYY-MM-DD')), RES_TIME = '"
					+ CTime + "', RES_REMEMO ='" + CMemo + "' WHERE CMS_ID = '" + ID + "'";

			rs = stmt.executeQuery(query);
			while (rs.next()) {
				System.out.println(rs.getInt("COUNT(*)"));

				if (rs.getInt("COUNT(*)") < 4) {
					System.out.println(Cquery);
					boolean b = stmt.execute(Cquery);
					if (!b) {
						System.out.println("Insert success.\n");
						FinalRe FR = new FinalRe(ID);
						break;
					} else {
						System.out.println("Insert fail.\n");
					}
				} else {
					JOptionPane.showMessageDialog(null, "해당 시간대의 예약이 마감되었습니다. 다시 선택해주세요.");
				}
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	// 고객 예약 상태 확인
	public int ReChe(String ID) {
		int cnt = 0;
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.\n");
			Statement stmt = conn.createStatement();

			String Nquery = "SELECT COUNT(*) FROM CUSTOMER WHERE CMS_ID = '" + ID + "'";
			System.out.println("SQL : " + Nquery);

			rs = stmt.executeQuery(Nquery);
			rs.next();
			System.out.println("rs.getInt(\"COUNT(*)\") : " + rs.getInt("COUNT(*)"));
			cnt = rs.getInt("COUNT(*)");
			System.out.println("cnt: " + cnt);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return cnt;
	}

	// 예약 확인-날짜
	public String Day(String ID) {
		String Day = "";
		try {
			connDB();

			String Squery = "SELECT RES_DAY FROM CUSTOMER WHERE CMS_ID = '" + ID + "'";
			System.out.println("SQL : " + Squery);

			rs = stmt.executeQuery(Squery);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());

			if (rs.getRow() == 0) {
				System.out.println("0 row selected");
			} else {
				System.out.println(rs.getRow() + "row selected");
				rs.previous();
				while (rs.next()) {
					Day = rs.getString("RES_DAY");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Day;
	}

	// 예약 확인 - 시간
	public String Time(String ID) {
		String Time = "";
		try {
			connDB();

			String Squery = "SELECT RES_TIME FROM CUSTOMER WHERE CMS_ID = '" + ID + "'";
			System.out.println("SQL : " + Squery);

			rs = stmt.executeQuery(Squery);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());

			if (rs.getRow() == 0) {
				System.out.println("0 row selected");
			} else {
				System.out.println(rs.getRow() + "row selected");
				rs.previous();
				while (rs.next()) {
					Time = rs.getString("RES_TIME");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Time;
	}

	// 예약 취소
	public void ReCancle(String ID) {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.\n");
			Statement stmt = conn.createStatement();

			String Cquery = "DELETE FROM CUSTOMER WHERE CMS_ID = '" + ID + "'";
			System.out.println(Cquery);

			boolean b = stmt.execute(Cquery);
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

	// 사장 예약확인
	public ArrayList<MemberVo2> ManagerCheck(String Day) {
		String ID = "", Time = "", People = "", Memo = "", ReMemo = "";
		ArrayList<MemberVo2> Result = new ArrayList<MemberVo2>();
		try {
			connDB();

			String Mquery = "SELECT CMS_ID, RES_TIME, RES_PEOPLE, RES_MEMO, RES_REMEMO FROM CUSTOMER WHERE RES_DAY ='"
					+ Day + "' ORDER BY RES_TIME";
			System.out.println("SQL : " + Mquery);

			rs = stmt.executeQuery(Mquery);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());

			if (rs.getRow() == 0) {
				System.out.println("0 row selected");
			} else {
				System.out.println(rs.getRow() + "row selected");
				rs.beforeFirst();
				while (rs.next()) {
					ID = rs.getString("CMS_ID");
					Time = rs.getString("RES_TIME");
					People = rs.getString("RES_PEOPLE");
					Memo = rs.getString("RES_MEMO");
					ReMemo = rs.getString("RES_REMEMO");
					MemberVo2 data = new MemberVo2(ID, Time, People, Memo, ReMemo);
					Result.add(data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result;
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