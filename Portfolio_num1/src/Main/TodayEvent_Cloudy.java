package Main;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TodayEvent_Cloudy {
	private JFrame toEvt;
	private JLabel weather;
	private Icon logo;

	public TodayEvent_Cloudy() {
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
				"<html><center>오늘의 날씨 : 구름<br><br><br>오늘의 추천 : 솜사탕 하이볼<br><br>구름이 몽실몽실<br>술잔에도 몽실몽실<br><br>솜사탕 하이볼 10% 할인합니다.</center></html>");
		weather.setFont(new Font("맑은 고딕", 0, 24));
		weather.setBounds(105, 273, 367, 320);

		toEvt.add(imglogo);
		toEvt.add(weather);
		toEvt.setVisible(true);
		toEvt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}