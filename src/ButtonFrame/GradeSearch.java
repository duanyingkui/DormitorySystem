package ButtonFrame;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Control.ManagerControl;
import Model.ManagersModel;
import Operation.ManagerOperation;

public class GradeSearch extends JFrame {
	JTextField text1, text2, text3;
	JLabel lab0, lab1, lab2, lab3;
	JPanel jp = new JPanel();
	JButton search1, search2, search3;

	public GradeSearch() {
		JLabel label = new JLabel(new ImageIcon("image\\background.jpg"));
		label.setSize(640, 480);
		Image image = this.getToolkit().getImage("image\\icon.png");

		lab0 = new JLabel("宿舍评比查询");
		lab0.setBounds(140, 0, 150, 30);
		lab0.setFont(new Font("华文彩云", Font.BOLD, 23));
		this.add(lab0);

		lab1 = new JLabel("宿舍号:");
		lab1.setBounds(20, 50, 150, 50);
		lab1.setFont(new Font("隶书", Font.BOLD, 20));
		this.add(lab1);

		lab2 = new JLabel("评分时间:");
		lab2.setBounds(20, 150, 100, 50);
		lab2.setFont(new Font("隶书", Font.BOLD, 20));
		this.add(lab2);

		lab3 = new JLabel("评分人:");
		lab3.setBounds(20, 250, 100, 50);
		lab3.setFont(new Font("隶书", Font.BOLD, 20));
		this.add(lab3);

		text1 = new JTextField();
		text1.setBounds(120, 60, 150, 30);
		text1.setFont(new Font("宋体", Font.BOLD, 18));
		this.add(text1);

		text2 = new JTextField();
		text2.setBounds(120, 160, 150, 30);
		text2.setFont(new Font("黑体", Font.BOLD, 18));
		this.add(text2);

		text3 = new JTextField();
		text3.setBounds(120, 260, 150, 30);
		text3.setFont(new Font("黑体", Font.BOLD, 18));
		this.add(text3);

		ImageIcon isearch1 = new ImageIcon("image\\search.png");
		search1 = new JButton(isearch1);
		search1.setBounds(300, 62, 80, 25);
		search1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		this.add(search1);

		ImageIcon isearch2 = new ImageIcon("image\\search.png");
		search2 = new JButton(isearch2);
		search2.setBounds(300, 162, 80, 25);
		this.add(search2);

		ImageIcon isearch3 = new ImageIcon("image\\search.png");
		search3 = new JButton(isearch3);
		search3.setBounds(300, 262, 80, 25);
		this.add(search3);

		// 面板
		jp.setLayout(null);
		jp.add(label);

		// 窗体
		this.add(jp);
		this.setIconImage(image);
		this.setSize(400, 400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
