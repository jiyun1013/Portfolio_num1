package Main;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class FindPwd extends WindowAdapter implements ActionListener {
	private JFrame FiPwF;
	private JLabel FID, FEM;
	private JTextField TFID, TFEM;
	private JButton FindPwd;
	private String ID;
	private MemberDAO dao;

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public FindPwd() {
		dao = new MemberDAO();
		FiPwF = new JFrame("비밀번호 찾기");
		FiPwF.setSize(600, 400);
		FiPwF.setLayout(null);
		FiPwF.setResizable(false);
		FiPwF.setLocationRelativeTo(null);
		FiPwF.getContentPane().setBackground(Color.white);

		FID = new JLabel("아이디");
		FID.setBounds(45, 66, 75, 29);
		FID.setFont(new Font("맑은 고딕", 0, 24));
		TFID = new JTextField();
		TFID.setBounds(177, 55, 365, 50);
		TFID.setFont(new Font("맑은 고딕", 0, 24));

		FEM = new JLabel("이메일");
		FEM.setBounds(45, 137, 75, 29);
		FEM.setFont(new Font("맑은 고딕", 0, 24));
		TFEM = new JTextField();
		TFEM.setBounds(177, 126, 365, 50);
		TFEM.setFont(new Font("맑은 고딕", 0, 24));

		FindPwd = new JButton("비밀번호 찾기");
		FindPwd.setBounds(200, 240, 200, 50);
		FindPwd.setFont(new Font("맑은 고딕", 0, 24));
		FindPwd.setContentAreaFilled(false);
		FindPwd.addActionListener(this);

		FiPwF.add(FID);
		FiPwF.add(TFID);
		FiPwF.add(FEM);
		FiPwF.add(TFEM);
		FiPwF.add(FindPwd);

		FiPwF.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String strId = TFID.getText();
		String strEm = TFEM.getText();
		ID = strId;
		System.out.println(strId + " " + strEm);

		if (e.getActionCommand().equals("비밀번호 찾기")) {
			dao.Pwdlist(strId, strEm);
			if (strId.equals(strId) && strEm.equals(strEm)) {
				JOptionPane.showMessageDialog(null, "비밀번호를 다시 설정해주세요.");
				FiPwF.dispose();
				newPwd nP = new newPwd(ID);
			}
		}
	}
}