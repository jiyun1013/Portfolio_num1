package Main;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class RePwd extends WindowAdapter implements ActionListener {
	private JFrame rePd;
	private JLabel pwd, newPwd, reNewPwd;
	private JTextField fPwd, fNewPwd, fReNewPwd;
	private JButton Change;
	private MemberDAO dao;
	private String ID, id;

	public RePwd(String ID) {
		this.ID = ID;
		id = ID;
		rePd = new JFrame("비밀번호 변경");
		dao = new MemberDAO();

		rePd.setSize(650, 555);
		rePd.setLayout(null);
		rePd.setResizable(false); // 프레임 사이즈 변경 불가
		rePd.setLocationRelativeTo(null); // 프레임 중앙에 놓기
		rePd.getContentPane().setBackground(Color.white);

		pwd = new JLabel("현재 비밀번호");
		pwd.setBounds(52, 68, 155, 29);
		pwd.setFont(new Font("맑은 고딕", 0, 24));
		fPwd = new JTextField();
		fPwd.setBounds(279, 57, 300, 50);
		fPwd.setFont(new Font("맑은 고딕", 0, 24));

		newPwd = new JLabel("새 비밀번호");
		newPwd.setBounds(52, 172, 128, 29);
		newPwd.setFont(new Font("맑은 고딕", 0, 24));
		fNewPwd = new JTextField();
		fNewPwd.setBounds(279, 161, 300, 50);
		fNewPwd.setFont(new Font("맑은 고딕", 0, 24));

		reNewPwd = new JLabel("새 비밀번호 확인");
		reNewPwd.setBounds(52, 276, 185, 29);
		reNewPwd.setFont(new Font("맑은 고딕", 0, 24));
		fReNewPwd = new JTextField();
		fReNewPwd.setBounds(279, 265, 300, 50);
		fReNewPwd.setFont(new Font("맑은 고딕", 0, 24));

		Change = new JButton("변경");
		Change.setBounds(241, 388, 164, 50);
		Change.setFont(new Font("맑은 고딕", 0, 24));
		Change.addActionListener(this);
		Change.setContentAreaFilled(false);

		rePd.add(pwd);
		rePd.add(fPwd);
		rePd.add(newPwd);
		rePd.add(fNewPwd);
		rePd.add(reNewPwd);
		rePd.add(fReNewPwd);
		rePd.add(Change);
		
		rePd.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("변경")) {
			dao.RePwd(ID); //아이디 값을 보냄
			System.out.println(dao.RePwd(ID)); //아이디값이 기존 비밀번호 값으로 변경되어 리턴됨(값변경)
			if (fPwd.getText().equals(dao.RePwd(id))) {
				if(fNewPwd.getText().equals(fReNewPwd.getText())) {
					String pwd = fNewPwd.getText();
					dao.ReNewPwd(id, pwd);
					JOptionPane.showMessageDialog(null, "비밀번호 변경이 완료되었습니다.\n다시 로그인 시 새 비밀번호를 입력해주세요.");
					rePd.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "새 비밀번호와 확인이 일치하지 않습니다.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "현재 비밀번호가 일치하지 않습니다.");

			}
		}
	}
}