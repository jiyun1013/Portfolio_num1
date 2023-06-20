package Main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ReRes extends WindowAdapter implements ActionListener {
	private JFrame re_Res;
	private JButton Change, Cancle;

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public ReRes() {
		re_Res = new JFrame("예약 변경");
	}

	public void startFrame() {
		re_Res.setSize(550, 240);
		re_Res.setLayout(null);
		re_Res.setResizable(false);
		re_Res.setLocationRelativeTo(null);
		re_Res.getContentPane().setBackground(Color.white);

		Change = new JButton("예약 변경");
		Change.setBounds(100, 91, 155, 55);
		Change.setContentAreaFilled(false);
		Change.setFont(new Font("맑은 고딕", 0, 24));
		Change.addActionListener(this);

		Cancle = new JButton("예약 취소");
		Cancle.setBounds(296, 91, 155, 55);
		Cancle.setContentAreaFilled(false);
		Cancle.setFont(new Font("맑은 고딕", 0, 24));
		Cancle.addActionListener(this);

		re_Res.add(Change);
		re_Res.add(Cancle);

		re_Res.setVisible(true);
		re_Res.addWindowListener(this);
	}

	public static void main(String[] args) {
		ReRes reReser = new ReRes();
		reReser.startFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}