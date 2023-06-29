package Main;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TodayEvent_Rain extends WindowAdapter {
	private JFrame ToEvt;
	private JLabel Weather, Ment;
	private Icon logo;

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public TodayEvent_Rain() {
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
				"<html><center>오늘의 날씨 : 비<br><br><br>오늘의 추천 : 오꼬노미야끼<br><br>타닥타닥 오꼬노미야끼가 맛있게<br>익어가는 비 오는 날!<br><br>오꼬노미야끼 10% 할인합니다.</center></html>");
		Weather.setFont(new Font("맑은 고딕", 0, 24));
		Weather.setBounds(95, 273, 419, 320);

		ToEvt.add(imglogo);
		ToEvt.add(Weather);
		ToEvt.setVisible(true);
	}
}