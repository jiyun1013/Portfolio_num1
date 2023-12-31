package Main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ReRes extends WindowAdapter implements ActionListener {
	private JFrame re_Res;
	private JButton change, cancle;
	private String ID;

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public ReRes(String ID) {
		this.ID=ID;
		re_Res = new JFrame("예약 변경");
		re_Res.setSize(550, 240);
		re_Res.setLayout(null);
		re_Res.setResizable(false);
		re_Res.setLocationRelativeTo(null);
		re_Res.getContentPane().setBackground(Color.white);

		change = new JButton("예약 변경");
		change.setBounds(100, 91, 155, 55);
		change.setContentAreaFilled(false);
		change.setFont(new Font("맑은 고딕", 0, 24));
		change.addActionListener(this);

		cancle = new JButton("예약 취소");
		cancle.setBounds(296, 91, 155, 55);
		cancle.setContentAreaFilled(false);
		cancle.setFont(new Font("맑은 고딕", 0, 24));
		cancle.addActionListener(this);

		re_Res.add(change);
		re_Res.add(cancle);

		re_Res.setVisible(true);
		re_Res.addWindowListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("예약 변경")) {
			Change Cg = new Change(ID);
			re_Res.dispose();
		}
		
		if(e.getActionCommand().equals("예약 취소")) {
			Cancle Cc = new Cancle(ID);
			re_Res.dispose();
		}
	}
}
