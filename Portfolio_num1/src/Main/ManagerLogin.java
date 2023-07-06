package Main;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class ManagerLogin implements ActionListener {
	private JFrame mLogin_f;
	private JTextField mLo_Id;
	private JPasswordField mLo_Pwd;
	private JButton mBLogin;
	private Icon logo;

	public ManagerLogin() {
		mLogin_f = new JFrame("관리자용 로그인");
	}

	public void startFrame() {
		mLogin_f.setSize(1000, 600); // 프레임 사이즈 정하기
		mLogin_f.setLayout(null);
		mLogin_f.setResizable(false); // 프레임 사이즈 변경 불가
		mLogin_f.setLocationRelativeTo(null); // 프레임 중앙에 놓기
		mLogin_f.getContentPane().setBackground(Color.white); // 필드 안만들고 색상 흰색으로 바꾸기

		logo = new ImageIcon("C:\\Users\\Class01\\Desktop\\logo.png");
		JLabel imglogo= new JLabel(logo);
		imglogo.setBounds(288, 97, 400, 130);

		Label lid = new Label("아이디");
		lid.setBounds(157, 271, 104, 54);
		lid.setFont(new Font("맑은 고딕", 0, 36));
		mLo_Id = new JTextField();
		mLo_Id.setBounds(318, 271, 368, 54);
		mLo_Id.setFont(new Font("맑은 고딕", 0, 36));

		Label lpwd = new Label("비밀번호");
		lpwd.setBounds(128, 345, 142, 54);
		lpwd.setFont(new Font("맑은 고딕", 0, 36));
		mLo_Pwd = new JPasswordField();
		mLo_Pwd.setBounds(318, 345, 368, 54);
		mLo_Pwd.setFont(new Font("맑은 고딕", 0, 36));

		mBLogin = new JButton("Login");
		mBLogin.setBounds(729, 271, 150, 130);
		mBLogin.setFont(new Font("맑은 고딕", 0, 36));
		mBLogin.addActionListener(this);
		mBLogin.setContentAreaFilled(false);

		mLogin_f.add(lid);
		mLogin_f.add(mLo_Id);
		mLogin_f.add(lpwd);
		mLogin_f.add(mLo_Pwd);
		mLogin_f.add(mBLogin);
		mLogin_f.add(imglogo);

		mLogin_f.setVisible(true); // 프레임 보이게하기
		mLogin_f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		ManagerLogin MLo_f = new ManagerLogin();
		MLo_f.startFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(mLo_Id.getText() + mLo_Pwd.getText());

		String strId = mLo_Id.getText();
		String strPd = mLo_Pwd.getText();

			if (strId.equals("admin") && strPd.equals("admin1013")) {
				MainCalendar MaCal = new MainCalendar();
				mLogin_f.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "아이디 혹은 비밀번호가 일치하지 않습니다.", " ERROR", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
