package Main;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TodayEvent_Sun extends WindowAdapter {
	private JFrame ToEvt;
	private JLabel Weather, Ment;
	private Icon logo;

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public TodayEvent_Sun() {
		ToEvt = new JFrame("오늘의 이벤트");
		ToEvt.setSize(550, 700);
		ToEvt.setLayout(null);
		ToEvt.setResizable(false);
		ToEvt.setLocationRelativeTo(null);
		ToEvt.getContentPane().setBackground(Color.white);

		logo = new ImageIcon("C:\\Users\\Class01\\Desktop\\logo.png");
		JLabel imglogo = new JLabel(logo);
		imglogo.setBounds(75, 81, 400, 130);

		Weather = new JLabel(
				"<html><center>오늘의 날씨 : 해<br><br><br>오늘의 추천 : 크림치즈 곶감말이<br><br>해가 쨍한 기분 좋은 날<br>기분 좋은 계획으로 추천합니다.<br><br>크림치즈 곶감말이 10% 할인합니다.</center></html>");
		Weather.setFont(new Font("맑은 고딕", 0, 24));
		Weather.setBounds(72, 273, 409, 320);

		ToEvt.add(imglogo);
		ToEvt.add(Weather);
		ToEvt.setVisible(true);
	}
}