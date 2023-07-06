package Main;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class FindPwd implements ActionListener {
	private JFrame fiPwF;
	private JLabel lI, lE;
	private JTextField fI, fE;
	private JButton findPwd;
	private String ID;
	private MemberDAO dao;

	public FindPwd() {
		dao = new MemberDAO();
		fiPwF = new JFrame("비밀번호 찾기");
		fiPwF.setSize(600, 400);
		fiPwF.setLayout(null);
		fiPwF.setResizable(false);
		fiPwF.setLocationRelativeTo(null);
		fiPwF.getContentPane().setBackground(Color.white);

		lI = new JLabel("아이디");
		lI.setBounds(45, 66, 75, 29);
		lI.setFont(new Font("맑은 고딕", 0, 24));
		fI = new JTextField();
		fI.setBounds(177, 55, 365, 50);
		fI.setFont(new Font("맑은 고딕", 0, 24));

		lE = new JLabel("이메일");
		lE.setBounds(45, 137, 75, 29);
		lE.setFont(new Font("맑은 고딕", 0, 24));
		fE = new JTextField();
		fE.setBounds(177, 126, 365, 50);
		fE.setFont(new Font("맑은 고딕", 0, 24));

		findPwd = new JButton("비밀번호 찾기");
		findPwd.setBounds(200, 240, 200, 50);
		findPwd.setFont(new Font("맑은 고딕", 0, 24));
		findPwd.setContentAreaFilled(false);
		findPwd.addActionListener(this);

		fiPwF.add(lI);
		fiPwF.add(fI);
		fiPwF.add(lE);
		fiPwF.add(fE);
		fiPwF.add(findPwd);

		fiPwF.setVisible(true);
		fiPwF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String strId = fI.getText();
		String strEm = fE.getText();
		ArrayList<MemberVo> Id = dao.Pwdlist(strId, strEm);
		System.out.println(Id);

		if (e.getActionCommand().equals("비밀번호 찾기")) {
			if (Id.size() == 0) {
				JOptionPane.showMessageDialog(null, "일치하는 정보가 없습니다.", " ERROR", JOptionPane.WARNING_MESSAGE);
			} else {
				MemberVo FDd = (MemberVo) Id.get(0);
				JOptionPane.showMessageDialog(null, "비밀번호를 다시 설정해주세요.");
				fiPwF.dispose();
				NewPwd nP = new NewPwd(strId);
			}
		}
	}
}