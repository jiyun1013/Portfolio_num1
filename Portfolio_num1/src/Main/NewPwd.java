package Main;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class NewPwd implements ActionListener {
	private JFrame nPwd;
	private JLabel newPwd, reNewPwd;
	private JTextField fNewPwd, fReNewPwd;
	private JButton ok;
	private MemberDAO dao;
	private String ID;

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public NewPwd(String ID) {
		this.ID = ID;
		dao = new MemberDAO();
		nPwd = new JFrame("비밀번호 재설정");
		nPwd.setSize(600, 400);
		nPwd.setLayout(null);
		nPwd.setResizable(false);
		nPwd.setLocationRelativeTo(null);
		nPwd.getContentPane().setBackground(Color.white);

		newPwd = new JLabel("신규 비밀번호");
		newPwd.setBounds(43, 66, 155, 29);
		newPwd.setFont(new Font("맑은 고딕", 0, 24));
		fNewPwd = new JTextField();
		fNewPwd.setBounds(217, 55, 325, 50);
		fNewPwd.setFont(new Font("맑은 고딕", 0, 24));

		reNewPwd = new JLabel("비밀번호 확인");
		reNewPwd.setBounds(43, 137, 155, 29);
		reNewPwd.setFont(new Font("맑은 고딕", 0, 24));
		fReNewPwd = new JTextField();
		fReNewPwd.setBounds(217, 126, 325, 50);
		fReNewPwd.setFont(new Font("맑은 고딕", 0, 24));

		ok = new JButton("비밀번호 설정");
		ok.setBounds(200, 240, 200, 50);
		ok.setFont(new Font("맑은 고딕", 0, 24));
		ok.setContentAreaFilled(false);
		ok.addActionListener(this);

		nPwd.add(newPwd);
		nPwd.add(fNewPwd);
		nPwd.add(reNewPwd);
		nPwd.add(fReNewPwd);
		nPwd.add(ok);

		nPwd.setVisible(true);
		nPwd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String NP = fNewPwd.getText();
		String RP = fReNewPwd.getText();

		if (e.getActionCommand().equals("비밀번호 설정")) {
			if (NP.equals(RP)) {
				dao.NewPwd(ID, NP);
				JOptionPane.showMessageDialog(null, "비밀번호 변경이 완료되었습니다.");
				nPwd.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "신규 비밀번호와 확인이 일치하지 않습니다.");
			}
		}
	}
}