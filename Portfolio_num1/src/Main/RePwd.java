package Main;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class RePwd extends WindowAdapter implements ActionListener {
	private JFrame RePd;
	private JLabel Pwd, NPwd, RNPwd;
	private JTextField TPwd, TNPwd, TRNPwd;
	private JButton Change;
	private MemberDAO dao;
	private String ID, id;

	public RePwd(String ID) {
		this.ID = ID;
		id = ID;
		RePd = new JFrame("비밀번호 변경");
		dao = new MemberDAO();

		RePd.setSize(650, 555);
		RePd.setLayout(null);
		RePd.setResizable(false); // 프레임 사이즈 변경 불가
		RePd.setLocationRelativeTo(null); // 프레임 중앙에 놓기
		RePd.getContentPane().setBackground(Color.white);

		Pwd = new JLabel("현재 비밀번호");
		Pwd.setBounds(52, 68, 155, 29);
		Pwd.setFont(new Font("맑은 고딕", 0, 24));
		TPwd = new JTextField();
		TPwd.setBounds(279, 57, 300, 50);
		TPwd.setFont(new Font("맑은 고딕", 0, 24));

		NPwd = new JLabel("새 비밀번호");
		NPwd.setBounds(52, 172, 128, 29);
		NPwd.setFont(new Font("맑은 고딕", 0, 24));
		TNPwd = new JTextField();
		TNPwd.setBounds(279, 161, 300, 50);
		TNPwd.setFont(new Font("맑은 고딕", 0, 24));

		RNPwd = new JLabel("새 비밀번호 확인");
		RNPwd.setBounds(52, 276, 185, 29);
		RNPwd.setFont(new Font("맑은 고딕", 0, 24));
		TRNPwd = new JTextField();
		TRNPwd.setBounds(279, 265, 300, 50);
		TRNPwd.setFont(new Font("맑은 고딕", 0, 24));

		Change = new JButton("변경");
		Change.setBounds(241, 388, 164, 50);
		Change.setFont(new Font("맑은 고딕", 0, 24));
		Change.addActionListener(this);
		Change.setContentAreaFilled(false);

		RePd.add(Pwd);
		RePd.add(TPwd);
		RePd.add(NPwd);
		RePd.add(TNPwd);
		RePd.add(RNPwd);
		RePd.add(TRNPwd);
		RePd.add(Change);
		
		RePd.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("변경")) {
			dao.RePwd(ID); //아이디 값을 보냄
			System.out.println(dao.RePwd(ID)); //아이디값이 기존 비밀번호 값으로 변경되어 리턴됨(값변경)
			if (TPwd.getText().equals(dao.RePwd(id))) {
				if(TNPwd.getText().equals(TRNPwd.getText())) {
					String pwd = TNPwd.getText();
					dao.ReNewPwd(id, pwd);
					JOptionPane.showMessageDialog(null, "비밀번호 변경이 완료되었습니다.\n다시 로그인 시 새 비밀번호를 입력해주세요.");
					RePd.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "새 비밀번호와 확인이 일치하지 않습니다.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "현재 비밀번호가 일치하지 않습니다.");

			}
		}
	}
}