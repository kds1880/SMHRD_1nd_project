package hi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class 메롱메롱 {

	private JFrame frame;
	private boolean check = false;
	private JScrollPane scroll1;
	private JScrollPane scroll2;
	private JScrollPane scroll3;
	private JScrollPane scroll4;
	private JScrollPane scroll5;
	private JTable table1, table2, table3, table4, table5;
	private DAO dao = new DAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					메롱메롱 window = new 메롱메롱();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public 메롱메롱() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 410, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setToolTipText("\uD5C8\uD5C8");
		panel.setBounds(0, 0, 394, 501);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lbl_title = new JLabel("\uC601\uC591\uC81C \uC131\uBD84 \uD6A8\uACFC");
		lbl_title.setBounds(12, 10, 370, 50);
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("함초롬바탕", Font.BOLD, 30));
		panel.add(lbl_title);
		
		// 비타민
		JButton btn_vitamin = new JButton("\uBE44\uD0C0\uBBFC");
		btn_vitamin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// 마우스 위로 올렸을 때는 보여주게 하기
				scroll1.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// 마우스를 밖으로 뺐을 때 안보여지게 하는 코드인데 -> 클릭을 했을 때는 보여지게 만들어줌!
				scroll1.setVisible(check);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// 마우스 클릭하면 check가 true, false 바뀌게 되는 공간
				check = !check;
			}
		});

		btn_vitamin.setFont(new Font("함초롬바탕", Font.PLAIN, 20));
		btn_vitamin.setBounds(12, 90, 150, 40);
		panel.add(btn_vitamin);
		// DB로부터 데이터를 가져오는 부분
		ArrayList<String> list1 = dao.select("비타민");
		String[] column1 = { "성분명" };
		String[][] data1 = new String[list1.size()][1];
		for (int i = 0; i < list1.size(); i++) {
			data1[i][0] = list1.get(i);
		}
		DefaultTableModel model1 = new DefaultTableModel(data1, column1);
		table1 = new JTable(model1);
		table1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String choice1 = (String) table1.getValueAt(table1.getSelectedRow(), table1.getSelectedColumn());
				vitamin 비타민 = new vitamin(choice1);
			}
		});
		scroll1 = new JScrollPane(table1);
		scroll1.setBounds(174, 90, 208, 280);
		panel.add(scroll1);
		scroll1.setVisible(false);

		// 미네랄
		JButton btn_mineral = new JButton("\uBBF8\uB124\uB784");
		btn_mineral.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// 마우스 위로 올렸을 때는 보여주게 하기
				scroll2.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// 마우스를 밖으로 뺐을 때 안보여지게 하는 코드인데 -> 클릭을 했을 때는 보여지게 만들어줌!
				scroll2.setVisible(check);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// 마우스 클릭하면 check가 true, false 바뀌게 되는 공간
				check = !check;
			}
		});

		btn_mineral.setBounds(12, 150, 150, 40);
		btn_mineral.setFont(new Font("함초롬바탕", Font.PLAIN, 20));
		panel.add(btn_mineral);
		// DB로부터 데이터를 가져오는 부분
		ArrayList<String> list2 = dao.select("미네랄");
		String[] column2 = { "성분명" };
		String[][] data2 = new String[list2.size()][1];
		for (int i = 0; i < list2.size(); i++) {
			data2[i][0] = list2.get(i);
		}
		DefaultTableModel model2 = new DefaultTableModel(data2, column2);
		table2 = new JTable(model2);
		table2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String choice2 = (String) table3.getValueAt(table2.getSelectedRow(), table2.getSelectedColumn());
				mineral 미네랄 = new mineral(choice2);
			}
		});
		scroll2 = new JScrollPane(table2);
		scroll2.setBounds(174, 90, 208, 280);
		panel.add(scroll2);
		scroll2.setVisible(false);

		
		// 아미노산
		JButton btn_amino = new JButton("\uC544\uBBF8\uB178\uC0B0");
		btn_amino.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// 마우스 위로 올렸을 때는 보여주게 하기
				scroll3.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// 마우스를 밖으로 뺐을 때 안보여지게 하는 코드인데 -> 클릭을 했을 때는 보여지게 만들어줌!
				scroll3.setVisible(check);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// 마우스 클릭하면 check가 true, false 바뀌게 되는 공간
				check = !check;
			}
		});

		btn_amino.setBounds(12, 330, 150, 40);
		btn_amino.setFont(new Font("함초롬바탕", Font.PLAIN, 20));
		panel.add(btn_amino);
		// DB로부터 데이터를 가져오는 부분
		ArrayList<String> list3 = dao.select("아미노산");
		String[] column3 = { "성분명" };
		String[][] data3 = new String[list3.size()][1];
		for (int i = 0; i < list3.size(); i++) {
			data3[i][0] = list3.get(i);
		}
		DefaultTableModel model3 = new DefaultTableModel(data3, column3);
		table3 = new JTable(model3);
		table3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String choice3 = (String) table3.getValueAt(table3.getSelectedRow(), table3.getSelectedColumn());
				amino 아미노산 = new amino(choice3);
			}
		});
		scroll3 = new JScrollPane(table3);
		scroll3.setBounds(174, 90, 208, 280);
		panel.add(scroll3);
		scroll3.setVisible(false);

		// 지방산
		JButton btn_fa = new JButton("\uC9C0\uBC29\uC0B0");
		btn_fa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// 마우스 위로 올렸을 때는 보여주게 하기
				scroll4.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// 마우스를 밖으로 뺐을 때 안보여지게 하는 코드인데 -> 클릭을 했을 때는 보여지게 만들어줌!
				scroll4.setVisible(check);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// 마우스 클릭하면 check가 true, false 바뀌게 되는 공간
				check = !check;
			}
		});

		btn_fa.setBounds(12, 210, 150, 40);
		btn_fa.setFont(new Font("함초롬바탕", Font.PLAIN, 20));
		panel.add(btn_fa);
		ArrayList<String> list4 = dao.select("지방산");
		String[] column4 = { "성분명" };
		String[][] data4 = new String[list4.size()][1];
		for (int i = 0; i < list4.size(); i++) {
			data4[i][0] = list4.get(i);
		}
		DefaultTableModel model4 = new DefaultTableModel(data4, column4);
		table4 = new JTable(model4);
		table4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String choice4 = (String) table4.getValueAt(table4.getSelectedRow(), table4.getSelectedColumn());
				fa 지방산 = new fa(choice4);
			}
		});
		scroll4 = new JScrollPane(table4);
		scroll4.setBounds(174, 90, 208, 280);
		panel.add(scroll4);
		scroll4.setVisible(false);

		// 섬유질
		JButton btn_rou = new JButton("\uC12C\uC720\uC9C8");
		btn_rou.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// 마우스 위로 올렸을 때는 보여주게 하기
				scroll5.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// 마우스를 밖으로 뺐을 때 안보여지게 하는 코드인데 -> 클릭을 했을 때는 보여지게 만들어줌!
				scroll5.setVisible(check);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// 마우스 클릭하면 check가 true, false 바뀌게 되는 공간
				check = !check;
			}
		});
		btn_rou.setBounds(12, 270, 150, 40);
		btn_rou.setFont(new Font("함초롬바탕", Font.PLAIN, 20));
		panel.add(btn_rou);
		// DB로부터 데이터를 가져오는 부분
		ArrayList<String> list5 = dao.select("섬유질");
		String[] column5 = { "성분명" };
		String[][] data5 = new String[list5.size()][1];
		for (int i = 0; i < list5.size(); i++) {
			data5[i][0] = list5.get(i);
		}
		DefaultTableModel model5 = new DefaultTableModel(data5, column5);
		table5 = new JTable(model5);
		table5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String choice5 = (String) table5.getValueAt(table5.getSelectedRow(), table5.getSelectedColumn());
				rou 섬유질 = new rou(choice5);
			}
		});
		scroll5 = new JScrollPane(table5);
		scroll5.setBounds(174, 90, 208, 280);
		panel.add(scroll5);
		scroll5.setVisible(false);

		// 닫기버튼을 부르면 닫아짐
		JButton btn_close = new JButton("\uB2EB\uAE30");
		btn_close.setFont(new Font("함초롬바탕", Font.PLAIN, 15));
		btn_close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btn_close.setBounds(149, 461, 97, 30);
		panel.add(btn_close);

	}
}
