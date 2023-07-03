package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FinalRe extends WindowAdapter {
	private JFrame finalR;
	private JLabel da, ti, ment;
	private JTextField tDa, tTi;
	private Icon logo;
	private String ID, rDay;
	private MemberDAO2 dao;

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public FinalRe(String ID) {
		this.ID = ID;
		dao = new MemberDAO2();
		rDay = dao.Day(ID).substring(0, 10);
		
		finalR = new JFrame("예약하기");
		finalR.setSize(550, 770);
		finalR.setLayout(null);
		finalR.setResizable(false); // 프레임 사이즈 변경 불가
		finalR.setLocationRelativeTo(null); // 프레임 중앙에 놓기
		finalR.getContentPane().setBackground(Color.white);

		logo = new ImageIcon("C:\\Users\\Class01\\Desktop\\logo.png");
		JLabel imglogo = new JLabel(logo);
		imglogo.setBounds(75, 45, 400, 130);
		
		da = new JLabel("날짜");
		da.setBounds(128, 215, 50, 29);
		da.setFont(new Font("맑은 고딕", 0, 23));
		tDa = new JTextField(rDay);
		tDa.setBounds(214, 210, 214, 38);
		tDa.setFont(new Font("맑은 고딕", 0, 23));
		tDa.setEditable(false);
		tDa.setBackground(Color.white);

		ti = new JLabel("시간");
		ti.setBounds(128, 271, 50, 29);
		ti.setFont(new Font("맑은 고딕", 0, 24));
		tTi = new JTextField(dao.Time(ID));
		tTi.setBounds(214, 262, 214, 38);
		tTi.setFont(new Font("맑은 고딕", 0, 23));
		tTi.setEditable(false);
		tTi.setBackground(Color.white);

		ment = new JLabel(
				"<html><center>상기 일정으로 예약이 완료되었습니다.<br><br>예약은 이래와 고객님의 소중한 약속입니다.<br>꼭 지켜주세요.<br><br>예약 취소는 하루 전까지 가능합니다.<br><br>예약시간 30분 경과 시 예약이<br>자동 취소됨을 안내드립니다.<br><br>감사합니다.</center></html>");
		ment.setBounds(76, 360, 395, 295);
		ment.setFont(new Font("맑은 고딕", 0, 20));

		finalR.add(imglogo);
		finalR.add(ment);
		finalR.add(tTi);
		finalR.add(da);
		finalR.add(tDa);
		finalR.add(ti);

		finalR.setVisible(true);
	}
}