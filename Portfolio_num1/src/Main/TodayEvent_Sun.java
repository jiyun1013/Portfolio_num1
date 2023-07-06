package Main;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TodayEvent_Sun {
	private JFrame toEvt;
	private JLabel weather;
	private Icon logo;

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public TodayEvent_Sun() {
		toEvt = new JFrame("오늘의 이벤트");
		toEvt.setSize(550, 700);
		toEvt.setLayout(null);
		toEvt.setResizable(false);
		toEvt.setLocationRelativeTo(null);
		toEvt.getContentPane().setBackground(Color.white);

		logo = new ImageIcon("C:\\Users\\Class01\\Desktop\\logo.png");
		JLabel imglogo = new JLabel(logo);
		imglogo.setBounds(75, 81, 400, 130);

		weather = new JLabel(
				"<html><center>오늘의 날씨 : 해<br><br><br>오늘의 추천 : 크림치즈 곶감말이<br><br>해가 쨍한 기분 좋은 날<br>기분 좋은 계획으로 추천합니다.<br><br>크림치즈 곶감말이 10% 할인합니다.</center></html>");
		weather.setFont(new Font("맑은 고딕", 0, 24));
		weather.setBounds(72, 273, 409, 320);

		toEvt.add(imglogo);
		toEvt.add(weather);
		toEvt.setVisible(true);
		toEvt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}