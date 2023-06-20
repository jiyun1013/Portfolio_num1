package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class NewMember extends WindowAdapter implements ActionListener {
	private JFrame NewMem_f;
	private JLabel nwId, nwPw, nwNa, nwBi, nwEm, MsId, MsPw, MsBi;
	private JTextField neId, nePw, neNa, neBi, neEm;
	private JButton same, join;
	private Icon logo;
	private MemberDAO dao = new MemberDAO();

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public NewMember() {
		NewMem_f = new JFrame("회원가입");
	}

	public void startFrame() {
		NewMem_f.setSize(800, 850);
		NewMem_f.setLayout(null);
		NewMem_f.setResizable(false);
		NewMem_f.setLocationRelativeTo(null);
		NewMem_f.getContentPane().setBackground(Color.white);

		logo = new ImageIcon("C:\\Users\\Class01\\Desktop\\logo.png");
		JLabel imglogo = new JLabel(logo);
		imglogo.setBounds(208, 73, 400, 130);

		nwId = new JLabel("아이디");
		nwId.setBounds(114, 254, 75, 27);
		nwId.setFont(new Font("맑은 고딕", 0, 24));
		neId = new JTextField();
		neId.setBounds(245, 240, 365, 50);
		neId.setFont(new Font("맑은 고딕", 0, 24));
		MsId = new JLabel("※ 20글자 이하의 영어+숫자 조합으로 작성해주세요.");
		MsId.setBounds(320, 290, 285, 16);
		MsId.setForeground(Color.red);

		same = new JButton("중복확인");
		same.setBounds(635, 240, 108, 50);
		same.setFont(new Font("맑은 고딕", 0, 18));
		same.setContentAreaFilled(false);
		same.addActionListener(this);

		nwPw = new JLabel("비밀번호");
		nwPw.setBounds(114, 339, 96, 27);
		nwPw.setFont(new Font("맑은 고딕", 0, 24));
		nePw = new JTextField();
		nePw.setBounds(245, 327, 365, 50);
		nePw.setFont(new Font("맑은 고딕", 0, 24));
		MsPw = new JLabel("※ 10글자 이상의 20글자 이하 영어+숫자 조합으로 작성해주세요.");
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

		NewMem_f.add(imglogo);
		NewMem_f.add(nwId);
		NewMem_f.add(neId);
		NewMem_f.add(same);
		NewMem_f.add(nwPw);
		NewMem_f.add(nePw);
		NewMem_f.add(nwNa);
		NewMem_f.add(neNa);
		NewMem_f.add(nwBi);
		NewMem_f.add(neBi);
		NewMem_f.add(nwEm);
		NewMem_f.add(neEm);
		NewMem_f.add(join);
		NewMem_f.add(MsId);
		NewMem_f.add(MsPw);
		NewMem_f.add(MsBi);

		NewMem_f.setVisible(true);
	}

	public static void main(String[] args) {
		NewMember NewMem_f = new NewMember();
		NewMem_f.startFrame();
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

		join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dao.Newlist(NewId, NewPd, NewNm, NewBh, NewEm);
			}
		});
//		if (e.getActionCommand().equals("회원가입")) {
//			ArrayList<MemberVo> Newlist = dao.Newlist(NewId, NewPd, NewNm, NewBh, NewEm);
//		}
	}
}