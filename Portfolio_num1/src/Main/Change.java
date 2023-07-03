package Main;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class Change extends WindowAdapter implements ActionListener {
	private JFrame ChangeF;
	private JLabel CDay, CTime, CMemo, CText;
	private Choice ChCTime;
	private JTextField TCMemo;
	private JButton BChange;
	private String ID;
	private MemberDAO2 dao;

	UtilDateModel model = new UtilDateModel();
	JDatePanelImpl datePanel = new JDatePanelImpl(model);
	JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public Change(String ID) {
		this.ID = ID;
		ChangeF = new JFrame("예약 변경");
		ChangeF.setSize(450, 400);
		ChangeF.setLayout(null);
		ChangeF.setResizable(false);
		ChangeF.setLocationRelativeTo(null);
		ChangeF.getContentPane().setBackground(Color.white);

		CDay = new JLabel("날짜");
		CDay.setBounds(63, 55, 48, 29);
		CDay.setFont(new Font("맑은 고딕", 0, 24));

		datePicker.setBounds(149, 57, 244, 38);
		datePicker.setVisible(true);
		datePicker.setBackground(Color.white);

		CTime = new JLabel("시간");
		CTime.setBounds(63, 120, 48, 29);
		CTime.setFont(new Font("맑은 고딕", 0, 24));

		ChCTime = new Choice();
		ChCTime.setBounds(149, 112, 214, 38);
		ChCTime.setFont(new Font("맑은 고딕", 0, 24));
		ChCTime.add("17:00");
		ChCTime.add("18:30");
		ChCTime.add("19:00");
		ChCTime.add("20:30");

		CMemo = new JLabel("변경사항");
		CMemo.setBounds(39, 185, 96, 29);
		CMemo.setFont(new Font("맑은 고딕", 0, 24));
		TCMemo = new JTextField();
		TCMemo.setBounds(149, 180, 214, 38);
		TCMemo.setFont(new Font("맑은 고딕", 0, 24));
		CText = new JLabel("※ 변경사항이 있으시면 기재해주세요.");
		CText.setBounds(153, 219, 210, 16);
		CText.setForeground(Color.red);

		BChange = new JButton("변경하기");
		BChange.setBounds(144, 260, 162, 59);
		BChange.setFont(new Font("맑은 고딕", 0, 24));
		BChange.setContentAreaFilled(false);
		BChange.addActionListener(this);

		ChangeF.add(CDay);
		ChangeF.add(datePicker);
		ChangeF.add(CTime);
		ChangeF.add(ChCTime);
		ChangeF.add(CMemo);
		ChangeF.add(TCMemo);
		ChangeF.add(BChange);
		ChangeF.add(CText);

		ChangeF.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dao = new MemberDAO2();

		int Y = model.getYear();
		int M = (model.getMonth() + 1);
		int D = model.getDay();

		String CDay = "" + Y + "-" + M + "-" + D;
		String CTime = ChCTime.getSelectedItem();
		String CMemo = TCMemo.getText();
		
		if (e.getActionCommand().equals("변경하기")) {
			dao.ChReser(ID, CDay, CTime, CMemo);
			ChangeF.dispose();
		}
	}
}