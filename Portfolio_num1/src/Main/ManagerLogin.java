package Main;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class ManagerLogin extends WindowAdapter implements ActionListener {
	private JFrame MLogin_f;
	private JTextField MLo_Id;
	private JPasswordField MLo_Pwd;
	private JButton MbLogin;
	private MemberDAO dao;
	private Icon logo;

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public ManagerLogin() {
		dao = new MemberDAO();
		MLogin_f = new JFrame("관리자용 로그인");
	}

	public void startFrame() {
		MLogin_f.setSize(1000, 600); // 프레임 사이즈 정하기
		MLogin_f.setLayout(null);
		MLogin_f.setResizable(false); // 프레임 사이즈 변경 불가
		MLogin_f.setLocationRelativeTo(null); // 프레임 중앙에 놓기
		MLogin_f.getContentPane().setBackground(Color.white); // 필드 안만들고 색상 흰색으로 바꾸기

		logo = new ImageIcon("C:\\Users\\Class01\\Desktop\\logo.png");
		JLabel imglogo= new JLabel(logo);
		imglogo.setBounds(288, 97, 400, 130);

		Label lid = new Label("아이디");
		lid.setBounds(157, 271, 104, 54);
		lid.setFont(new Font("맑은 고딕", 0, 36));
		MLo_Id = new JTextField();
		MLo_Id.setBounds(318, 271, 368, 54);
		MLo_Id.setFont(new Font("맑은 고딕", 0, 36));

		Label lpwd = new Label("비밀번호");
		lpwd.setBounds(128, 345, 142, 54);
		lpwd.setFont(new Font("맑은 고딕", 0, 36));
		MLo_Pwd = new JPasswordField();
		MLo_Pwd.setBounds(318, 345, 368, 54);
		MLo_Pwd.setFont(new Font("맑은 고딕", 0, 36));

		MbLogin = new JButton("Login");
		MbLogin.setBounds(729, 271, 150, 130);
		MbLogin.setFont(new Font("맑은 고딕", 0, 36));
		MbLogin.addActionListener(this);
		MbLogin.setContentAreaFilled(false);

		MLogin_f.add(lid);
		MLogin_f.add(MLo_Id);
		MLogin_f.add(lpwd);
		MLogin_f.add(MLo_Pwd);
		MLogin_f.add(MbLogin);
		MLogin_f.add(imglogo);

		MLogin_f.setVisible(true); // 프레임 보이게하기
		MLogin_f.addWindowListener(this);
	}

	public static void main(String[] args) {
		ManagerLogin MLo_f = new ManagerLogin();
		MLo_f.startFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(MLo_Id.getText() + MLo_Pwd.getText());

		String strId = MLo_Id.getText();

		ArrayList<MemberVo> list = dao.list(strId);

		for (int i = 0; i < list.size(); i++) {
			MemberVo data = (MemberVo) list.get(i);
			String id = data.getId();
			String pwd = data.getPassword();

			System.out.println("==>" + id + " : " + pwd);

			if (MLo_Pwd.getText().equals(pwd)) {
				MainCalendar MaCal = new MainCalendar();
				MLogin_f.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "아이디 혹은 비밀번호가 일치하지 않습니다.", " ERROR", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}