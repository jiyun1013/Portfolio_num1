package Main;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Unregister extends WindowAdapter implements ActionListener {
	private JFrame Unreg;
	private String ID;
	private JLabel mainText, subText;
	private JButton No, Ok;
	private MemberDAO dao;

	public Unregister(String ID) {
		this.ID = ID;
		dao = new MemberDAO();

		Unreg = new JFrame("탈퇴하기");
		Unreg.setSize(500, 300);
		Unreg.setLayout(null);
		Unreg.setResizable(false);
		Unreg.setLocationRelativeTo(null);
		Unreg.getContentPane().setBackground(Color.white);

		mainText = new JLabel("<html><center>사용하고 계신 아이디는 탈퇴할 경우<br>재사용 및 복구가 불가능합니다.</center></html>");
		mainText.setBounds(70, 44, 450, 58);
		mainText.setFont(new Font("맑은 고딕", 0, 20));
		subText = new JLabel("<html><center>※ 신중하게 선택하시기 바랍니다.</center></html>");
		subText.setBounds(145, 113, 230, 20);
		subText.setForeground(Color.red);

		No = new JButton("취소");
		No.setBounds(70, 160, 150, 50);
		No.setFont(new Font("맑은 고딕", 0, 20));
		No.setContentAreaFilled(false);
		No.addActionListener(this);

		Ok = new JButton("탈퇴");
		Ok.setBounds(280, 160, 150, 50);
		Ok.setFont(new Font("맑은 고딕", 0, 20));
		Ok.setContentAreaFilled(false);
		Ok.addActionListener(this);

		Unreg.add(mainText);
		Unreg.add(subText);
		Unreg.add(No);
		Unreg.add(Ok);

		Unreg.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("취소")) {
			Unreg.dispose();
		}

		if (e.getActionCommand().equals("탈퇴")) {
			System.out.println(ID);
			dao.Unrelist(ID);
			JOptionPane.showMessageDialog(null, "탈퇴가 완료되었습니다.");
			Unreg.dispose();
		}
	}
}
