package Main;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TodayEvent_Cloudy extends WindowAdapter {
	private JFrame ToEvt;
	private JLabel Weather, Ment;
	private Icon logo;

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public TodayEvent_Cloudy() {
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
				"<html><center>오늘의 날씨 : 구름<br><br><br>오늘의 추천 : 솜사탕 하이볼<br><br>구름이 몽실몽실<br>술잔에도 몽실몽실<br><br>솜사탕 하이볼 10% 할인합니다.</center></html>");
		Weather.setFont(new Font("맑은 고딕", 0, 24));
		Weather.setBounds(105, 273, 367, 320);

		ToEvt.add(imglogo);
		ToEvt.add(Weather);
		ToEvt.setVisible(true);
	}
}