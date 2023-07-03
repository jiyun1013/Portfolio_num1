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
	private JFrame changeF;
	private JLabel cDay, cTime, cMemo, cText;
	private Choice chcTime;
	private JTextField tcMemo;
	private JButton bChange;
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
		changeF = new JFrame("예약 변경");
		changeF.setSize(450, 400);
		changeF.setLayout(null);
		changeF.setResizable(false);
		changeF.setLocationRelativeTo(null);
		changeF.getContentPane().setBackground(Color.white);

		cDay = new JLabel("날짜");
		cDay.setBounds(63, 55, 48, 29);
		cDay.setFont(new Font("맑은 고딕", 0, 24));

		datePicker.setBounds(149, 57, 244, 38);
		datePicker.setVisible(true);
		datePicker.setBackground(Color.white);

		cTime = new JLabel("시간");
		cTime.setBounds(63, 120, 48, 29);
		cTime.setFont(new Font("맑은 고딕", 0, 24));

		chcTime = new Choice();
		chcTime.setBounds(149, 112, 214, 38);
		chcTime.setFont(new Font("맑은 고딕", 0, 24));
		chcTime.add("17:00");
		chcTime.add("18:30");
		chcTime.add("19:00");
		chcTime.add("20:30");

		cMemo = new JLabel("변경사항");
		cMemo.setBounds(39, 185, 96, 29);
		cMemo.setFont(new Font("맑은 고딕", 0, 24));
		tcMemo = new JTextField();
		tcMemo.setBounds(149, 180, 214, 38);
		tcMemo.setFont(new Font("맑은 고딕", 0, 24));
		cText = new JLabel("※ 변경사항이 있으시면 기재해주세요.");
		cText.setBounds(153, 219, 210, 16);
		cText.setForeground(Color.red);

		bChange = new JButton("변경하기");
		bChange.setBounds(144, 260, 162, 59);
		bChange.setFont(new Font("맑은 고딕", 0, 24));
		bChange.setContentAreaFilled(false);
		bChange.addActionListener(this);

		changeF.add(cDay);
		changeF.add(datePicker);
		changeF.add(cTime);
		changeF.add(chcTime);
		changeF.add(cMemo);
		changeF.add(tcMemo);
		changeF.add(bChange);
		changeF.add(cText);

		changeF.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dao = new MemberDAO2();

		int Y = model.getYear();
		int M = (model.getMonth() + 1);
		int D = model.getDay();

		String cDay = "" + Y + "-" + M + "-" + D;
		String cTime = chcTime.getSelectedItem();
		String cMemo = tcMemo.getText();
		
		if (e.getActionCommand().equals("변경하기")) {
			dao.ChReser(ID, cDay, cTime, cMemo);
			changeF.dispose();
		}
	}
}