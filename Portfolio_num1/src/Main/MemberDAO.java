package Main;

import java.sql.*;
import java.util.*;

public class MemberDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String user = "c##firstproj";
	String password = "firstproj";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

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