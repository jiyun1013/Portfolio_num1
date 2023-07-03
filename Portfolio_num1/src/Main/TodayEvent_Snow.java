package Main;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TodayEvent_Snow extends WindowAdapter {
	private JFrame toEvt;
	private JLabel weather;
	private Icon logo;

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public TodayEvent_Snow() {
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
				"<html><center>오늘의 날씨 : 눈<br><br><br>오늘의 추천 : 오뎅탕<br><br>몸이 으슬으슬<br>따끈한 오뎅탕이 절실한 날!<br><br>오뎅탕 10% 할인합니다.</center></html>");
		weather.setFont(new Font("맑은 고딕", 0, 24));
		weather.setBounds(120, 273, 353, 320);

		toEvt.add(imglogo);
		toEvt.add(weather);
		toEvt.setVisible(true);
	}
}