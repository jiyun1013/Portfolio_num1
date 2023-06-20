package Main;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Customer extends WindowAdapter implements ActionListener {
	private JFrame mypage;
	private JButton logOut, repwd, unregister, reservation, event, check, change;
	private Icon logo;

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public Customer() {
		mypage = new JFrame("마이페이지");
	}

	public void startFrame() {
		mypage.setSize(760, 745);
		mypage.setLayout(null);
		mypage.setResizable(false);
		mypage.setLocationRelativeTo(null);
		mypage.getContentPane().setBackground(Color.white);

		logo = new ImageIcon("C:\\Users\\Class01\\Desktop\\logo.png");
		JLabel imglogo = new JLabel(logo);
		imglogo.setBounds(178, 161, 400, 130);

		logOut = new JButton("로그아웃");
		logOut.setBounds(22, 13, 127, 35);
		logOut.setContentAreaFilled(false);
		logOut.addActionListener(this);

		repwd = new JButton("비밀번호 변경");
		repwd.setBounds(464, 13, 127, 35);
		repwd.setContentAreaFilled(false);
		repwd.addActionListener(this);

		unregister = new JButton("회원 탈퇴");
		unregister.setBounds(595, 13, 127, 35);
		unregister.setContentAreaFilled(false);
		unregister.addActionListener(this);

		reservation = new JButton("예약하기");
		reservation.setBounds(106, 387, 235, 102);
		reservation.setContentAreaFilled(false);
		reservation.setFont(new Font("맑은 고딕", 0, 24));
		reservation.addActionListener(this);

		event = new JButton("오늘의 이벤트");
		event.setBounds(417, 387, 235, 102);
		event.setContentAreaFilled(false);
		event.setFont(new Font("맑은 고딕", 0, 24));
		event.addActionListener(this);

		check = new JButton("예약 확인");
		check.setBounds(106, 522, 235, 102);
		check.setContentAreaFilled(false);
		check.setFont(new Font("맑은 고딕", 0, 24));
		check.addActionListener(this);

		change = new JButton("예약 변경");
		change.setBounds(417, 522, 235, 102);
		change.setContentAreaFilled(false);
		change.setFont(new Font("맑은 고딕", 0, 24));
		change.addActionListener(this);

		mypage.add(logOut);
		mypage.add(repwd);
		mypage.add(unregister);
		mypage.add(imglogo);
		mypage.add(reservation);
		mypage.add(event);
		mypage.add(check);
		mypage.add(change);

		mypage.setVisible(true);
	}

	public static void main(String[] args) {
		Customer mypage = new Customer();
		mypage.startFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("로그아웃")) {
			Login Lo = new Login();
			Lo.startFrame();
			mypage.dispose();
		}
		
		if(e.getActionCommand().equals("오늘의 이벤트")) {
			TodayEvent_Sun TE = new TodayEvent_Sun();
			TE.startFrame();
		}
		
		if(e.getActionCommand().equals("예약하기")) {
			Reservation Rn = new Reservation();
			Rn.startFrame();
		}
	}
}