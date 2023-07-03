package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class NewMember extends WindowAdapter implements ActionListener {
	private JFrame newMem_f;
	private JLabel nwId, nwPw, nwNa, nwBi, nwEm, MsId, MsPw, MsBi;
	private JTextField neId, nePw, neNa, neBi, neEm;
	private JButton same, join;
	private Icon logo;
	private MemberDAO dao = new MemberDAO();

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public NewMember() {
		newMem_f = new JFrame("회원가입");
	}

	public void startFrame() {
		newMem_f.setSize(800, 850);
		newMem_f.setLayout(null);
		newMem_f.setResizable(false);
		newMem_f.setLocationRelativeTo(null);
		newMem_f.getContentPane().setBackground(Color.white);

		logo = new ImageIcon("C:\\Users\\Class01\\Desktop\\logo.png");
		JLabel imglogo = new JLabel(logo);
		imglogo.setBounds(208, 73, 400, 130);

		nwId = new JLabel("아이디");
		nwId.setBounds(114, 254, 75, 27);
		nwId.setFont(new Font("맑은 고딕", 0, 24));
		neId = new JTextField();
		neId.setBounds(245, 240, 365, 50);
		neId.setFont(new Font("맑은 고딕", 0, 24));
		MsId = new JLabel("※ 20글자 이하로 작성해주세요.");
		MsId.setBounds(320, 290, 285, 16);
		MsId.setForeground(Color.red);

//		same = new JButton("중복확인");
//		same.setBounds(635, 240, 108, 50);
//		same.setFont(new Font("맑은 고딕", 0, 18));
//		same.setContentAreaFilled(false);
//		same.addActionListener(this);

		nwPw = new JLabel("비밀번호");
		nwPw.setBounds(114, 339, 96, 27);
		nwPw.setFont(new Font("맑은 고딕", 0, 24));
		nePw = new JTextField();
		nePw.setBounds(245, 327, 365, 50);
		nePw.setFont(new Font("맑은 고딕", 0, 24));
		MsPw = new JLabel("※ 20글자 이하로 작성해주세요.");
		MsPw.setBounds(250, 377, 357, 16);
		MsPw.setForeground(Color.red);

		nwNa = new JLabel("이름");
		nwNa.setBounds(114, 424, 48, 27);
		nwNa.setFont(new Font("맑은 고딕", 0, 24));
		neNa = new JTextField();
		neNa.setBounds(245, 414, 365, 50);
		neNa.setFont(new Font("맑은 고딕", 0, 24));

		nwBi = new JLabel("생년월일");
		nwBi.setBounds(114, 509, 96, 27);
		nwBi.setFont(new Font("맑은 고딕", 0, 24));
		neBi = new JTextField();
		neBi.setBounds(245, 501, 365, 50);
		neBi.setFont(new Font("맑은 고딕", 0, 24));
		MsBi = new JLabel("※ 8자리 숫자로 입력해주세요.");
		MsBi.setForeground(Color.red);
		MsBi.setBounds(438, 551, 170, 16);

		nwEm = new JLabel("이메일");
		nwEm.setBounds(114, 594, 75, 27);
		nwEm.setFont(new Font("맑은 고딕", 0, 24));
		neEm = new JTextField();
		neEm.setBounds(245, 588, 365, 50);
		neEm.setFont(new Font("맑은 고딕", 0, 24));

		join = new JButton("회원가입");
		join.setFont(new Font("맑은 고딕", 0, 24));
		join.setBounds(300, 685, 200, 50);
		join.setContentAreaFilled(false);
		join.addActionListener(this);

		newMem_f.add(imglogo);
		newMem_f.add(nwId);
		newMem_f.add(neId);
//		newMem_f.add(same);
		newMem_f.add(nwPw);
		newMem_f.add(nePw);
		newMem_f.add(nwNa);
		newMem_f.add(neNa);
		newMem_f.add(nwBi);
		newMem_f.add(neBi);
		newMem_f.add(nwEm);
		newMem_f.add(neEm);
		newMem_f.add(join);
		newMem_f.add(MsId);
		newMem_f.add(MsPw);
		newMem_f.add(MsBi);

		newMem_f.setVisible(true);
	}

	public static void main(String[] args) {
		NewMember newMem_f = new NewMember();
		newMem_f.startFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String NewId = neId.getText();
		String NewPd = nePw.getText();
		String NewNm = neNa.getText();
		String NewBh = neBi.getText();
		String NewEm = neEm.getText();
//
//		if (e.getActionCommand().equals("중복확인")) {
//			if (NewId.length() <= 20 && NewId.length() > 0) {
//				System.out.println("글자수맞음");
//			} else {
//				JOptionPane.showMessageDialog(null, "20글자 이하로 입력해주세요.", " ERROR", JOptionPane.WARNING_MESSAGE);
//			}
////				if (dao.MEMBER.CSM_ID != neId) {
////					JOptionPane.showMessageDialog(null, "사용 가능한 아이디입니다.");
////				} else {
////					JOptionPane.showMessageDialog(null, "중복된 아이디입니다.", " ERROR", JOptionPane.WARNING_MESSAGE);
////				}
//		} else {
//
//		}

		if(e.getActionCommand().equals("회원가입")) {
			dao.Newlist(NewId, NewPd, NewNm, NewBh, NewEm);
			JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
		}
	}
}