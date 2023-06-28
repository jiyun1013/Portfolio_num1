package Main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class Reservation extends WindowAdapter implements ActionListener {
	private JFrame Rsn;
	private JLabel RId, RDate, RTime, RPeople, Rmemo, PM, MM;
	private JTextField RtId, RtPe, Rtme;
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
		Rsn = new JFrame("예약하기");

		Rsn.setSize(450, 550);
		Rsn.setLayout(null);
		Rsn.setResizable(false);
		Rsn.setLocationRelativeTo(null);
		Rsn.getContentPane().setBackground(Color.white);

		RId = new JLabel("아이디");
		RId.setBounds(53, 38, 72, 29);
		RId.setFont(new Font("맑은 고딕", 0, 24));
		RtId = new JTextField(ID);
		RtId.setBounds(149, 34, 214, 38);
		RtId.setFont(new Font("맑은 고딕", 0, 24));
		RtId.setEditable(false);
		RtId.setBackground(Color.white);

		RDate = new JLabel("날짜");
		RDate.setBounds(63, 103, 50, 29);
		RDate.setFont(new Font("맑은 고딕", 0, 24));

		datePicker.setBounds(149, 98, 244, 38);
		datePicker.setVisible(true);
		datePicker.setFont(new Font("맑은 고딕", 0, 24));
		datePicker.setBackground(Color.white);

		RTime = new JLabel("시간");
		RTime.setBounds(63, 168, 50, 29);
		RTime.setFont(new Font("맑은 고딕", 0, 24));
		time = new Choice();
		time.setBounds(149, 163, 214, 38);
		time.setFont(new Font("맑은 고딕", 0, 24));
		time.add("17:00");
		time.add("18:30");
		time.add("19:00");
		time.add("20:30");

		RPeople = new JLabel("인원(명)");
		RPeople.setBounds(44, 230, 87, 29);
		RPeople.setFont(new Font("맑은 고딕", 0, 24));
		RtPe = new JTextField("");
		RtPe.setBounds(149, 228, 214, 38);
		RtPe.setFont(new Font("맑은 고딕", 0, 24));
		PM = new JLabel("※ 6명 이상 단체 예약 시 전화 먼저 부탁드립니다.");
		PM.setBounds(155, 266, 300, 16);
		PM.setForeground(Color.red);

		Rmemo = new JLabel("요청사항");
		Rmemo.setBounds(42, 294, 96, 29);
		Rmemo.setFont(new Font("맑은 고딕", 0, 24));
		Rtme = new JTextField("");
		Rtme.setBounds(149, 293, 214, 38);
		Rtme.setFont(new Font("맑은 고딕", 0, 24));
		MM = new JLabel("※ 요청사항이 있으시면 기재해주세요.");
		MM.setBounds(155, 325, 215, 29);
		MM.setForeground(Color.red);

		res = new JButton("예약하기");
		res.setBounds(151, 397, 148, 59);
		res.setFont(new Font("맑은 고딕", 0, 24));
		res.setContentAreaFilled(false);
		res.addActionListener(this);

		Rsn.add(RId);
		Rsn.add(RtId);
		Rsn.add(RDate);
		Rsn.add(time);
		Rsn.add(datePicker);
		Rsn.add(RTime);

		Rsn.add(RPeople);
		Rsn.add(RtPe);
		Rsn.add(PM);
		Rsn.add(Rmemo);
		Rsn.add(Rtme);
		Rsn.add(MM);
		Rsn.add(res);

		Rsn.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dao = new MemberDAO2();
		int Y = model.getYear();
		int M = (model.getMonth() + 1);
		int D = model.getDay();

		String GDay = "" + Y + "-" + M + "-" + D;
		String GTime = time.getSelectedItem();
		String GPeople = RtPe.getText();
		String GMemo = Rtme.getText();

		System.out.println(GDay);

		if (e.getActionCommand().equals("예약하기")) {
			dao.Reslist(ID, GDay, GTime, GPeople, GMemo);
			Rsn.dispose();
		}
	}
}