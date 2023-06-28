package Main;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class Cancle extends WindowAdapter implements ActionListener {
	private JFrame CancleF;
	private JLabel MainMes, SubMes;
	private JButton No, Ok;
	private MemberDAO2 dao;
	private String ID;

	public Cancle(String ID) {
		this.ID = ID;
		dao = new MemberDAO2();
		CancleF = new JFrame("예약 취소");
		CancleF.setLayout(null);
		CancleF.setSize(570, 300);
		CancleF.setResizable(false);
		CancleF.setLocationRelativeTo(null);
		CancleF.getContentPane().setBackground(Color.white);

		MainMes = new JLabel("<html><center>예약을 삭제하시겠습니까?</center></html>");
		MainMes.setBounds(140, 72, 298, 29);
		MainMes.setFont(new Font("맑은 고딕", 0, 24));
		SubMes = new JLabel("<html><center>※ 예약 취소 후 번복이 불가능합니다.</center></html>");
		SubMes.setBounds(171, 119, 262, 19);
		SubMes.setForeground(Color.red);

		No = new JButton("취소");
		No.setBounds(109, 155, 150, 50);
		No.setFont(new Font("맑은 고딕", 0, 24));
		No.setContentAreaFilled(false);
		No.addActionListener(this);

		Ok = new JButton("삭제");
		Ok.setBounds(311, 155, 150, 50);
		Ok.setFont(new Font("맑은 고딕", 0, 24));
		Ok.setContentAreaFilled(false);
		Ok.addActionListener(this);

		CancleF.add(MainMes);
		CancleF.add(SubMes);
		CancleF.add(No);
		CancleF.add(Ok);

		CancleF.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("취소")) {
			CancleF.dispose();
		}
		if(e.getActionCommand().equals("삭제")) {
			dao.ReCancle(ID);
			JOptionPane.showMessageDialog(null, "삭제가 완료되었습니다.");
			CancleF.dispose();
		}
	}
}
