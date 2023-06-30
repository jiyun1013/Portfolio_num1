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
	private JFrame FinalR;
	private JLabel Da, Ti, Ment;
	private JTextField TDa, TTi;
	private Icon logo;
	private String ID, RDay;
	private MemberDAO2 dao;

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public FinalRe(String ID) {
		this.ID = ID;
		dao = new MemberDAO2();
		RDay = dao.Day(ID).substring(0, 10);
		
		FinalR = new JFrame("예약하기");
		FinalR.setSize(550, 770);
		FinalR.setLayout(null);
		FinalR.setResizable(false); // 프레임 사이즈 변경 불가
		FinalR.setLocationRelativeTo(null); // 프레임 중앙에 놓기
		FinalR.getContentPane().setBackground(Color.white);

		logo = new ImageIcon("C:\\Users\\Class01\\Desktop\\logo.png");
		JLabel imglogo = new JLabel(logo);
		imglogo.setBounds(75, 45, 400, 130);
		
		Da = new JLabel("날짜");
		Da.setBounds(128, 215, 50, 29);
		Da.setFont(new Font("맑은 고딕", 0, 23));
		TDa = new JTextField(RDay);
		TDa.setBounds(214, 210, 214, 38);
		TDa.setFont(new Font("맑은 고딕", 0, 23));
		TDa.setEditable(false);
		TDa.setBackground(Color.white);

		Ti = new JLabel("시간");
		Ti.setBounds(128, 271, 50, 29);
		Ti.setFont(new Font("맑은 고딕", 0, 24));
		TTi = new JTextField(dao.Time(ID));
		TTi.setBounds(214, 262, 214, 38);
		TTi.setFont(new Font("맑은 고딕", 0, 23));
		TTi.setEditable(false);
		TTi.setBackground(Color.white);

		Ment = new JLabel(
				"<html><center>상기 일정으로 예약이 완료되었습니다.<br><br>예약은 이래와 고객님의 소중한 약속입니다.<br>꼭 지켜주세요.<br><br>예약 취소는 하루 전까지 가능합니다.<br><br>예약시간 30분 경과 시 예약이<br>자동 취소됨을 안내드립니다.<br><br>감사합니다.</center></html>");
		Ment.setBounds(76, 360, 395, 295);
		Ment.setFont(new Font("맑은 고딕", 0, 20));

		FinalR.add(imglogo);
		FinalR.add(Ment);
		FinalR.add(TTi);
		FinalR.add(Da);
		FinalR.add(TDa);
		FinalR.add(Ti);

		FinalR.setVisible(true);
	}
}