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
	private JFrame Check_F;
	private JLabel imglogo, FMent, SMent;
	private JTextField FDay, FTime;
	private JButton BCheck;
	private Icon logo;
	private MemberDAO2 dao;
	private String ID, ReDay;

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public Check(String ID) {
		this.ID = ID;
		Check_F = new JFrame("예약 확인");
		dao = new MemberDAO2();
		ReDay = dao.Day(ID).substring(0, 10);

		Check_F.setSize(550, 550);
		Check_F.setLayout(null);
		Check_F.setResizable(false); // 프레임 사이즈 변경 불가
		Check_F.setLocationRelativeTo(null); // 프레임 중앙에 놓기
		Check_F.getContentPane().setBackground(Color.white);

		logo = new ImageIcon("C:\\Users\\Class01\\Desktop\\logo.png");
		imglogo = new JLabel(logo);
		imglogo.setBounds(75, 71, 400, 130);

		FMent = new JLabel("예약일정을 안내 드립니다.");
		FMent.setBounds(134, 227, 285, 29);
		FMent.setFont(new Font("맑은 고딕", 0, 24));

		FDay = new JTextField(ReDay);
		FDay.setBounds(160, 271, 240, 29);
		FDay.setFont(new Font("맑은 고딕", 0, 24));
		FDay.setEditable(false);
		FDay.setBackground(Color.white);

		FTime = new JTextField(dao.Time(ID));
		FTime.setBounds(160, 310, 240, 29);
		FTime.setFont(new Font("맑은 고딕", 0, 24));
		FTime.setEditable(false);
		FTime.setBackground(Color.white);

		SMent = new JLabel("상기 일자에 뵙겠습니다.");
		SMent.setBounds(150, 364, 265, 29);
		SMent.setFont(new Font("맑은 고딕", 0, 24));

		BCheck = new JButton("확인");
		BCheck.setBounds(193, 426, 164, 50);
		BCheck.setFont(new Font("맑은 고딕", 0, 24));
		BCheck.setContentAreaFilled(false);
		BCheck.addActionListener(this);

		Check_F.add(imglogo);
		Check_F.add(FMent);
		Check_F.add(FDay);
		Check_F.add(FTime);
		Check_F.add(SMent);
		Check_F.add(BCheck);

		Check_F.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("확인")) {
			Check_F.dispose();
		}
	}
}