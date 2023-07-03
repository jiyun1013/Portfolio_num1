package Main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class Reservation extends WindowAdapter implements ActionListener {
	private JFrame rsn;
	private JLabel lId, lDate, lTime, lPeople, lmemo, lPM, lMM;
	private JTextField fId, fPe, fme;
	private Choice time;
	private JButton res;
	private String ID;
	private MemberDAO2 dao;

	UtilDateModel model = new UtilDateModel();
	JDatePanelImpl datePanel = new JDatePanelImpl(model);
	JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public Reservation(String ID) {
		this.ID = ID;
		rsn = new JFrame("예약하기");

		rsn.setSize(450, 550);
		rsn.setLayout(null);
		rsn.setResizable(false);
		rsn.setLocationRelativeTo(null);
		rsn.getContentPane().setBackground(Color.white);

		lId = new JLabel("아이디");
		lId.setBounds(53, 38, 72, 29);
		lId.setFont(new Font("맑은 고딕", 0, 24));
		fId = new JTextField(ID);
		fId.setBounds(149, 34, 214, 38);
		fId.setFont(new Font("맑은 고딕", 0, 24));
		fId.setEditable(false);
		fId.setBackground(Color.white);

		lDate = new JLabel("날짜");
		lDate.setBounds(63, 103, 50, 29);
		lDate.setFont(new Font("맑은 고딕", 0, 24));

		datePicker.setBounds(149, 98, 244, 38);
		datePicker.setVisible(true);
		datePicker.setFont(new Font("맑은 고딕", 0, 24));
		datePicker.setBackground(Color.white);

		lTime = new JLabel("시간");
		lTime.setBounds(63, 168, 50, 29);
		lTime.setFont(new Font("맑은 고딕", 0, 24));
		time = new Choice();
		time.setBounds(149, 163, 214, 38);
		time.setFont(new Font("맑은 고딕", 0, 24));
		time.add("17:00");
		time.add("18:30");
		time.add("19:00");
		time.add("20:30");

		lPeople = new JLabel("인원(명)");
		lPeople.setBounds(44, 230, 87, 29);
		lPeople.setFont(new Font("맑은 고딕", 0, 24));
		fPe = new JTextField("");
		fPe.setBounds(149, 228, 214, 38);
		fPe.setFont(new Font("맑은 고딕", 0, 24));
		lPM = new JLabel("※ 6명 이상 단체 예약 시 전화 먼저 부탁드립니다.");
		lPM.setBounds(155, 266, 300, 16);
		lPM.setForeground(Color.red);

		lmemo = new JLabel("요청사항");
		lmemo.setBounds(42, 294, 96, 29);
		lmemo.setFont(new Font("맑은 고딕", 0, 24));
		fme = new JTextField("");
		fme.setBounds(149, 293, 214, 38);
		fme.setFont(new Font("맑은 고딕", 0, 24));
		lMM = new JLabel("※ 요청사항이 있으시면 기재해주세요.");
		lMM.setBounds(155, 325, 215, 29);
		lMM.setForeground(Color.red);

		res = new JButton("예약하기");
		res.setBounds(151, 397, 148, 59);
		res.setFont(new Font("맑은 고딕", 0, 24));
		res.setContentAreaFilled(false);
		res.addActionListener(this);

		rsn.add(lId);
		rsn.add(fId);
		rsn.add(lDate);
		rsn.add(time);
		rsn.add(datePicker);
		rsn.add(lTime);
		rsn.add(lPeople);
		rsn.add(fPe);
		rsn.add(lPM);
		rsn.add(lmemo);
		rsn.add(fme);
		rsn.add(lMM);
		rsn.add(res);

		rsn.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dao = new MemberDAO2();
		int Y = model.getYear();
		int M = (model.getMonth() + 1);
		int D = model.getDay();

		String GDay = "" + Y + "-" + M + "-" + D;
		String GTime = time.getSelectedItem();
		String GPeople = fPe.getText();
		String GMemo = fme.getText();

		System.out.println(GDay);

		if (e.getActionCommand().equals("예약하기")) {
			dao.Reslist(ID, GDay, GTime, GPeople, GMemo);
			rsn.dispose();
		}
	}
}