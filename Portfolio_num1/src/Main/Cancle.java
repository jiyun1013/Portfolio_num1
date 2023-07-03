package Main;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class Cancle extends WindowAdapter implements ActionListener {
	private JFrame cancleF;
	private JLabel mainMes, subMes;
	private JButton no, ok;
	private MemberDAO2 dao;
	private String ID;

	public Cancle(String ID) {
		this.ID = ID;
		dao = new MemberDAO2();
		cancleF = new JFrame("예약 취소");
		cancleF.setLayout(null);
		cancleF.setSize(570, 300);
		cancleF.setResizable(false);
		cancleF.setLocationRelativeTo(null);
		cancleF.getContentPane().setBackground(Color.white);

		mainMes = new JLabel("<html><center>예약을 삭제하시겠습니까?</center></html>");
		mainMes.setBounds(140, 72, 298, 29);
		mainMes.setFont(new Font("맑은 고딕", 0, 24));
		subMes = new JLabel("<html><center>※ 예약 취소 후 번복이 불가능합니다.</center></html>");
		subMes.setBounds(171, 119, 262, 19);
		subMes.setForeground(Color.red);

		no = new JButton("취소");
		no.setBounds(109, 155, 150, 50);
		no.setFont(new Font("맑은 고딕", 0, 24));
		no.setContentAreaFilled(false);
		no.addActionListener(this);

		ok = new JButton("삭제");
		ok.setBounds(311, 155, 150, 50);
		ok.setFont(new Font("맑은 고딕", 0, 24));
		ok.setContentAreaFilled(false);
		ok.addActionListener(this);

		cancleF.add(mainMes);
		cancleF.add(subMes);
		cancleF.add(no);
		cancleF.add(ok);

		cancleF.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("취소")) {
			cancleF.dispose();
		}
		if(e.getActionCommand().equals("삭제")) {
			dao.ReCancle(ID);
			JOptionPane.showMessageDialog(null, "삭제가 완료되었습니다.");
			cancleF.dispose();
		}
	}
}
