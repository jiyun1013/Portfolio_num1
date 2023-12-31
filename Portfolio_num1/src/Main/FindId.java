package Main;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class FindId extends WindowAdapter implements ActionListener {
	private JFrame fiIdF;
	private JLabel lN, lB, lE;
	private JTextField fN, fB, fE;
	private JButton findId;
	private MemberDAO dao;

	public void startFrame() {
		dao = new MemberDAO();

		fiIdF = new JFrame("아이디 찾기");
		fiIdF.setSize(600, 420);
		fiIdF.setLayout(null);
		fiIdF.setResizable(false);
		fiIdF.setLocationRelativeTo(null);
		fiIdF.getContentPane().setBackground(Color.white);

		lN = new JLabel("이름");
		lN.setBounds(45, 66, 50, 29);
		lN.setFont(new Font("맑은 고딕", 0, 24));
		fN = new JTextField();
		fN.setBounds(177, 55, 365, 50);
		fN.setFont(new Font("맑은 고딕", 0, 24));

		lB = new JLabel("생년월일");
		lB.setBounds(45, 137, 100, 29);
		lB.setFont(new Font("맑은 고딕", 0, 24));
		fB = new JTextField();
		fB.setBounds(177, 126, 365, 50);
		fB.setFont(new Font("맑은 고딕", 0, 24));

		lE = new JLabel("이메일");
		lE.setBounds(45, 208, 72, 29);
		lE.setFont(new Font("맑은 고딕", 0, 24));
		fE = new JTextField();
		fE.setBounds(177, 197, 365, 50);
		fE.setFont(new Font("맑은 고딕", 0, 24));

		findId = new JButton("아이디 찾기");
		findId.setBounds(200, 276, 200, 50);
		findId.setFont(new Font("맑은 고딕", 0, 24));
		findId.setContentAreaFilled(false);
		findId.addActionListener(this);

		fiIdF.add(lN);
		fiIdF.add(fN);
		fiIdF.add(lB);
		fiIdF.add(fB);
		fiIdF.add(lE);
		fiIdF.add(fE);
		fiIdF.add(findId);

		fiIdF.setVisible(true);
		fiIdF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		FindId FD = new FindId();
		FD.startFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String strNa = fN.getText();
		String strBi = fB.getText();
		String strEm = fE.getText();

		ArrayList<MemberVo> Idlist = dao.Idlist(strNa, strBi, strEm);

		if (Idlist.size() == 0) {
			JOptionPane.showMessageDialog(null, "일치하는 정보가 없습니다.", " ERROR", JOptionPane.WARNING_MESSAGE);
		} else {
			MemberVo FDd = (MemberVo) Idlist.get(0);
			JOptionPane.showMessageDialog(null, "아이디는 [" + (FDd.getCI()) + "] 입니다.");
		}
	}
}