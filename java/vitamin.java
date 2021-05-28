package hi;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public class vitamin {

	private JFrame frame;
	private DAO dao = new DAO();
	
	public vitamin(String choice) {
		initialize(choice);
		frame.setVisible(true);
	}

	private void initialize(String choice) {
		frame = new JFrame();
		frame.setBounds(100, 100, 410, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 394, 501);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lbl_efficacy = new JLabel("\uD6A8\uACFC");
		lbl_efficacy.setBounds(12, 55, 60, 30);
		lbl_efficacy.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_efficacy.setFont(new Font("«‘√ ∑“πŸ≈¡", Font.PLAIN, 18));
		panel.add(lbl_efficacy);

		JButton btn_close = new JButton("\uB2EB\uAE30");
		btn_close.setBounds(149, 461, 97, 30);
		btn_close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				∏ﬁ∑’∏ﬁ∑’.main(null);
			}
		});
		btn_close.setFont(new Font("«‘√ ∑“πŸ≈¡", Font.PLAIN, 15));
		panel.add(btn_close);
		
		// º∫∫–∏Ì
		JPanel panel_title = new JPanel();
		panel_title.setBackground(Color.WHITE);
		panel_title.setBounds(84, 10, 298, 47);
		panel.add(panel_title);
		String t = dao.select_title(choice);
		panel_title.setLayout(null);
		JTextPane txt_title = new JTextPane();
		txt_title.setFont(new Font("«‘√ ∑“πŸ≈¡", Font.PLAIN, 14));
		txt_title.setBounds(0, 14, 274, 30);
		txt_title.setText(t);
		panel_title.add(txt_title);
		
		System.out.println(choice);
//		String e = dao.select_efficacy(choice);

		// »ø∞˙
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 95, 370, 125);
		panel.add(scrollPane_1);
		String e = dao.select_efficacy(choice);
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setFont(new Font("«‘√ ∑“πŸ≈¡", Font.PLAIN, 14));
		textPane_1.setText(e);
		scrollPane_1.setViewportView(textPane_1);

		// ∫Œ¿€øÎ
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 265, 370, 185);
		panel.add(scrollPane);
		String p = dao.select_precautions(choice);
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("«‘√ ∑“πŸ≈¡", Font.PLAIN, 14));
		textPane.setText(p);
		scrollPane.setViewportView(textPane);
		
		JLabel lblNewLabel = new JLabel("\uD2B9\uC9D5");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("«‘√ ∑“πŸ≈¡", Font.PLAIN, 18));
		lblNewLabel.setBounds(12, 230, 57, 30);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC131\uBD84\uBA85");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("«‘√ ∑“πŸ≈¡", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(19, 20, 60, 35);
		panel.add(lblNewLabel_1);
		
		
	
	


//		lbl_etxt.setVisible(false);
//		panel_1.setLayout(null);

	}
}
