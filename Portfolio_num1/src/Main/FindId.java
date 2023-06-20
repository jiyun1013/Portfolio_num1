package Main;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class FindId extends WindowAdapter implements ActionListener {
	private JFrame FiIdF;
	private JLabel FIN, FIB, FIE;
	private JTextField FDN, FDB, FDE;
	private JButton FindId;
	private MemberDAO dao;

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	
	public void startFrame() {
		dao = new MemberDAO();
		
		FiIdF = new JFrame("아이디 찾기");
		FiIdF.setSize(600, 420);
		FiIdF.setLayout(null);
		FiIdF.setResizable(false);
		FiIdF.setLocationRelativeTo(null);
		FiIdF.getContentPane().setBackground(Color.white);

		FIN = new JLabel("이름");
		FIN.setBounds(45, 66, 50, 29);
		FIN.setFont(new Font("맑은 고딕", 0, 24));
		FDN = new JTextField();
		FDN.setBounds(177, 55, 365, 50);
		FDN.setFont(new Font("맑은 고딕", 0, 24));
		
		FIB = new JLabel("생년월일");
		FIB.setBounds(45, 137, 100, 29);
		FIB.setFont(new Font("맑은 고딕", 0, 24));
		FDB = new JTextField();
		FDB.setBounds(177, 126, 365, 50);
		FDB.setFont(new Font("맑은 고딕", 0, 24));
		
		FIE = new JLabel("이메일");
		FIE.setBounds(45, 208, 72, 29);
		FIE.setFont(new Font("맑은 고딕", 0, 24));
		FDE = new JTextField();
		FDE.setBounds(177, 197, 365, 50);
		FDE.setFont(new Font("맑은 고딕", 0, 24));
		
		FindId = new JButton("아이디 찾기");
		FindId.setBounds(200, 276, 200, 50);
		FindId.setFont(new Font("맑은 고딕", 0, 24));
		FindId.setContentAreaFilled(false);
		FindId.addActionListener(this);

		FiIdF.add(FIN);
		FiIdF.add(FDN);
		FiIdF.add(FIB);
		FiIdF.add(FDB);
		FiIdF.add(FIE);
		FiIdF.add(FDE);
		FiIdF.add(FindId);
		
		FiIdF.setVisible(true);
	}

	public static void main(String[] args) {
		FindId FD = new FindId();
		FD.startFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(FDN.getText() + FDB.getText() + FDE.getText());

		String strNa = FDN.getText();
		String strBi = FDB.getText();
		String strEm = FDE.getText();

		ArrayList<MemberVo> Idlist = dao.Idlist(strNa, strBi, strEm);
		
		for(int i = 0; i < Idlist.size();i++) {
			MemberVo FDd = (MemberVo) Idlist.get(i);
			
			if(strNa.equals(strNa) && strBi.equals(strBi) && strEm.equals(strEm)) {
//				System.out.println("아이디는 [ "+(FDd.getCI())+" ] 입니다.");
				JOptionPane.showMessageDialog(null, "아이디는 ["+(FDd.getCI())+"] 입니다.");
			}
		}
	}
}