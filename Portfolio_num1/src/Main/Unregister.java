package Main;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Unregister extends WindowAdapter implements ActionListener {
	private JFrame unreg;
	private String ID;
	private JLabel mainText, subText;
	private JButton no, ok;
	private MemberDAO dao;

	public Unregister(String ID) {
		this.ID = ID;
		dao = new MemberDAO();

		unreg = new JFrame("탈퇴하기");
		unreg.setSize(500, 300);
		unreg.setLayout(null);
		unreg.setResizable(false);
		unreg.setLocationRelativeTo(null);
		unreg.getContentPane().setBackground(Color.white);

		mainText = new JLabel("<html><center>사용하고 계신 아이디는 탈퇴할 경우<br>재사용 및 복구가 불가능합니다.</center></html>");
		mainText.setBounds(70, 44, 450, 58);
		mainText.setFont(new Font("맑은 고딕", 0, 20));
		subText = new JLabel("<html><center>※ 신중하게 선택하시기 바랍니다.</center></html>");
		subText.setBounds(145, 113, 230, 20);
		subText.setForeground(Color.red);

		no = new JButton("취소");
		no.setBounds(70, 160, 150, 50);
		no.setFont(new Font("맑은 고딕", 0, 20));
		no.setContentAreaFilled(false);
		no.addActionListener(this);

		ok = new JButton("탈퇴");
		ok.setBounds(280, 160, 150, 50);
		ok.setFont(new Font("맑은 고딕", 0, 20));
		ok.setContentAreaFilled(false);
		ok.addActionListener(this);

		unreg.add(mainText);
		unreg.add(subText);
		unreg.add(no);
		unreg.add(ok);

		unreg.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("취소")) {
			unreg.dispose();
		}

		if (e.getActionCommand().equals("탈퇴")) {
			System.out.println(ID);
			dao.Unrelist(ID);
			JOptionPane.showMessageDialog(null, "탈퇴가 완료되었습니다.");
			unreg.dispose();
		}
	}
}
