package Main;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Login extends WindowAdapter implements ActionListener {
	private JFrame Login_f;
	private JTextField Lo_Id;
	private JPasswordField Lo_Pwd;
	private JButton bLogin, newMem, findId, findPwd;
	private MemberDAO dao;
	private Icon logo;
	private String ID;

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public Login() {
		dao = new MemberDAO();
		Login_f = new JFrame("로그인");
	}

	public void startFrame() {
		Login_f.setSize(1000, 600); // 프레임 사이즈 정하기
		Login_f.setLayout(null);
		Login_f.setResizable(false); // 프레임 사이즈 변경 불가
		Login_f.setLocationRelativeTo(null); // 프레임 중앙에 놓기
		Login_f.getContentPane().setBackground(Color.white); // 필드 안만들고 색상 흰색으로 바꾸기

		logo = new ImageIcon("C:\\Users\\Class01\\Desktop\\logo.png");
		JLabel imglogo = new JLabel(logo);
		imglogo.setBounds(288, 97, 400, 130);

		Label lid = new Label("아이디");
		lid.setBounds(157, 271, 104, 54);
		lid.setFont(new Font("맑은 고딕", 0, 36));
		Lo_Id = new JTextField();
		Lo_Id.setBounds(318, 271, 368, 54);
		Lo_Id.setFont(new Font("맑은 고딕", 0, 36));

		Label lpwd = new Label("비밀번호");
		lpwd.setBounds(128, 345, 142, 54);
		lpwd.setFont(new Font("맑은 고딕", 0, 36));
		Lo_Pwd = new JPasswordField();
		Lo_Pwd.setBounds(318, 345, 368, 54);
		Lo_Pwd.setFont(new Font("맑은 고딕", 0, 36));

		bLogin = new JButton("Login");
		bLogin.setBounds(729, 271, 150, 130);
		bLogin.setFont(new Font("맑은 고딕", 0, 36));
		bLogin.addActionListener(this);
		bLogin.setContentAreaFilled(false);

		newMem = new JButton("회원가입");
		newMem.setBounds(203, 470, 134, 42);
		newMem.setFont(new Font("맑은 고딕", 0, 24));
		newMem.setBorderPainted(false); // 테두리 투명
		newMem.setContentAreaFilled(false); // 배경색 투명
		newMem.addActionListener(this);

		findId = new JButton("아이디 찾기");
		findId.setBounds(410, 470, 177, 42);
		findId.setFont(new Font("맑은 고딕", 0, 24));
		findId.setBorderPainted(false);
		findId.setContentAreaFilled(false);
		findId.addActionListener(this);

		findPwd = new JButton("비밀번호 찾기");
		findPwd.setBounds(655, 470, 210, 42);
		findPwd.setFont(new Font("맑은 고딕", 0, 24));
		findPwd.setBorderPainted(false);
		findPwd.setContentAreaFilled(false);
		findPwd.addActionListener(this);

		Login_f.add(lid);
		Login_f.add(Lo_Id);
		Login_f.add(lpwd);
		Login_f.add(Lo_Pwd);
		Login_f.add(bLogin);
		Login_f.add(newMem);
		Login_f.add(findId);
		Login_f.add(findPwd);
		Login_f.add(imglogo);

		Login_f.setVisible(true); // 프레임 보이게하기
		Login_f.addWindowListener(this);
	}

	public static void main(String[] args) {
		Login Lo_f = new Login();
		Lo_f.startFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(Lo_Id.getText() + Lo_Pwd.getText());

		String strId = Lo_Id.getText();

		ArrayList<MemberVo> list = dao.list(strId);

		for (int i = 0; i < list.size(); i++) {
			MemberVo data = (MemberVo) list.get(i);
			String id = data.getId();
			String pwd = data.getPassword();

			System.out.println("==>" + id + " : " + pwd);

			if (Lo_Pwd.getText().equals(pwd)) {
				ID = strId;
				
				Customer cuPage = new Customer(ID);
				
				Login_f.setVisible(false);

			} else {
				JOptionPane.showMessageDialog(null, "아이디 혹은 비밀번호가 일치하지 않습니다.", " ERROR", JOptionPane.WARNING_MESSAGE);
			}
		}

		if (e.getActionCommand().equals("회원가입")) {
			NewMember nM = new NewMember();
			nM.startFrame();
		}

		if (e.getActionCommand().equals("아이디 찾기")) {
			FindId FI = new FindId();
			FI.startFrame();
		}

		if (e.getActionCommand().equals("비밀번호 찾기")) {
			FindPwd FP = new FindPwd();
		}

	}
}