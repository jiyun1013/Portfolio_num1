package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Customer extends WindowAdapter implements ActionListener {
	private JFrame mypage;
	private JButton logOut, repwd, unregister, reservation, event, check, change;
	private Icon logo;
	private String ID;
	private JLabel welcome;
	private MemberDAO2 dao;
	private MemberDAO da;

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public Customer(String ID) {
		da = new MemberDAO();
		this.ID = ID;

		mypage = new JFrame("마이페이지");
		mypage.setSize(760, 745);
		mypage.setLayout(null);
		mypage.setResizable(false);
		mypage.setLocationRelativeTo(null);
		mypage.getContentPane().setBackground(Color.white);

		logo = new ImageIcon("C:\\Users\\Class01\\Desktop\\logo.png");
		JLabel imglogo = new JLabel(logo);
		imglogo.setBounds(178, 155, 400, 130);

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

		welcome = new JLabel(da.Name(ID) + "님 환영합니다!");
		welcome.setFont(new Font("맑은 고딕", 0, 24));
		welcome.setBounds(260, 325, 250, 30);

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
		mypage.add(welcome);

		mypage.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dao = new MemberDAO2();

		if (e.getActionCommand().equals("로그아웃")) {
			Login Lo = new Login();
			Lo.startFrame();
			mypage.dispose();
		}

		if (e.getActionCommand().equals("비밀번호 변경")) {
			RePwd rp = new RePwd(ID);
		}

		if (e.getActionCommand().equals("회원 탈퇴")) {
			Unregister ur = new Unregister(ID);
		}

		if (e.getActionCommand().equals("오늘의 이벤트")) {
			OpenApiWeather ApWe = new OpenApiWeather();
			ApWe.main(null);
		}

		if (e.getActionCommand().equals("예약하기")) {
			if (dao.ReChe(ID) == 0) {
				Reservation Rn = new Reservation(ID);
			} else {
				JOptionPane.showMessageDialog(null, "예약은 1회만 가능하오니 참고바랍니다.", " ERROR", JOptionPane.WARNING_MESSAGE);
			}
		}

		if (e.getActionCommand().equals("예약 변경")) {
			if (dao.ReChe(ID) == 0) {
				JOptionPane.showMessageDialog(null, "예약이 존재하지 않습니다.");
			} else {
				ReRes RR = new ReRes(ID);
			}
		}

		if (e.getActionCommand().equals("예약 확인")) {
			if (dao.ReChe(ID) == 1) {
				Check ch = new Check(ID);
			} else {
				JOptionPane.showMessageDialog(null, "예약이 존재하지 않습니다.");
			}
		}
	}
}