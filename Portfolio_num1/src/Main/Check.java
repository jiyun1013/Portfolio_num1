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
import javax.swing.JTextField;

public class Check extends WindowAdapter implements ActionListener {
	private JFrame check_F;
	private JLabel imglogo, fMent, sMent;
	private JTextField fDay, fTime;
	private JButton bCheck;
	private Icon logo;
	private MemberDAO2 dao;
	private String ID, reDay;

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public Check(String ID) {
		this.ID = ID;
		check_F = new JFrame("예약 확인");
		dao = new MemberDAO2();
		reDay = dao.Day(ID).substring(0, 10);

		check_F.setSize(550, 550);
		check_F.setLayout(null);
		check_F.setResizable(false); // 프레임 사이즈 변경 불가
		check_F.setLocationRelativeTo(null); // 프레임 중앙에 놓기
		check_F.getContentPane().setBackground(Color.white);

		logo = new ImageIcon("C:\\Users\\Class01\\Desktop\\logo.png");
		imglogo = new JLabel(logo);
		imglogo.setBounds(75, 71, 400, 130);

		fMent = new JLabel("예약일정을 안내 드립니다.");
		fMent.setBounds(134, 227, 285, 29);
		fMent.setFont(new Font("맑은 고딕", 0, 24));

		fDay = new JTextField(reDay);
		fDay.setBounds(160, 271, 240, 29);
		fDay.setFont(new Font("맑은 고딕", 0, 24));
		fDay.setEditable(false);
		fDay.setBackground(Color.white);

		fTime = new JTextField(dao.Time(ID));
		fTime.setBounds(160, 310, 240, 29);
		fTime.setFont(new Font("맑은 고딕", 0, 24));
		fTime.setEditable(false);
		fTime.setBackground(Color.white);

		sMent = new JLabel("상기 일자에 뵙겠습니다.");
		sMent.setBounds(150, 364, 265, 29);
		sMent.setFont(new Font("맑은 고딕", 0, 24));

		bCheck = new JButton("확인");
		bCheck.setBounds(193, 426, 164, 50);
		bCheck.setFont(new Font("맑은 고딕", 0, 24));
		bCheck.setContentAreaFilled(false);
		bCheck.addActionListener(this);

		check_F.add(imglogo);
		check_F.add(fMent);
		check_F.add(fDay);
		check_F.add(fTime);
		check_F.add(sMent);
		check_F.add(bCheck);

		check_F.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("확인")) {
			check_F.dispose();
		}
	}
}