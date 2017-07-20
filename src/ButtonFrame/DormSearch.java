package ButtonFrame;

import java.awt.Color;
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

import Control.DormControl;
import Control.ManagerControl;
import Model.DormModel;
import Model.ManagersModel;
import Operation.DormOperation;
import Operation.ManagerOperation;

public class DormSearch extends JFrame {
	JTextField text, text1, text2, text3;
	JLabel lab, lab0;
	JPanel jp = new JPanel();
	JButton ok, search, change;

	public DormSearch() {
		JLabel label = new JLabel(new ImageIcon("image\\background.jpg"));
		label.setSize(640, 480);
		Image image = this.getToolkit().getImage("image\\icon.png");

		lab0 = new JLabel("宿舍信息查询");
		lab0.setBounds(140, 0, 150, 30);
		lab0.setFont(new Font("华文彩云", Font.BOLD, 23));
		this.add(lab0);

		lab = new JLabel("宿舍号:");
		lab.setBounds(20, 40, 150, 50);
		lab.setFont(new Font("华文行楷", Font.BOLD, 23));
		this.add(lab);

		text = new JTextField();
		text.setBounds(120, 50, 150, 30);
		text.setFont(new Font("黑体", Font.BOLD, 18));
		this.add(text);

		// 标签
		JLabel lab1 = new JLabel("宿舍号:");
		jp.add(lab1);
		lab1.setBounds(20, 150, 100, 50);
		lab1.setFont(new Font("隶书", Font.BOLD, 20));

		JLabel label2 = new JLabel("床位:");
		label2.setBounds(20, 210, 100, 50);
		label2.setFont(new Font("隶书", Font.BOLD, 20));
		this.add(label2);

		JLabel label3 = new JLabel("人数");
		label3.setBounds(20, 270, 100, 50);
		label3.setFont(new Font("隶书", Font.BOLD, 20));
		this.add(label3);

		// 宿舍号
		text1 = new JTextField();
		text1.setBounds(120, 165, 150, 30);
		text1.setFont(new Font("宋体", Font.BOLD, 18));
		text1.setEditable(false);
		this.add(text1);

		// 床位
		text2 = new JTextField();
		text2.setBounds(120, 220, 150, 30);
		text2.setFont(new Font("黑体", Font.BOLD, 18));
		text2.setEditable(false);
		this.add(text2);

		// 人数
		text3 = new JTextField();
		text3.setBounds(120, 280, 150, 30);
		text3.setFont(new Font("黑体", Font.BOLD, 18));
		text3.setEditable(false);
		this.add(text3);

		ImageIcon ic = new ImageIcon("image\\search.png");
		search = new JButton(ic);
		search.setBounds(300, 52, 80, 25);
		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DormControl r = new DormControl();
				DormModel rr = null;
				boolean bb = false;
				if (e.getSource() == search) {
					try {
						if (text.getText().length() == 0) {
							JOptionPane.showMessageDialog(null, "宿舍号不能为空", "系统提示", JOptionPane.ERROR_MESSAGE);
							return;
						} else {
							rr = r.get(text.getText());
						}
						if (rr != null) {
							bb = rr.getDorm_id().equals(text.getText());
							//System.out.println(rr.getDorm_id() + "shujiku");
							//System.out.println(text.getText() + "shuru");
						} else {
							JOptionPane.showMessageDialog(null, "宿舍号不正确", "系统提示", JOptionPane.ERROR_MESSAGE);
						}
						if (bb) {
							new DormOperation();
							DormOperation.selectone(text.getText());
							text1.setText(DormOperation.live.getDorm_id());
							text2.setText(DormOperation.live.getBed_num() + "");
							text3.setText(DormOperation.live.getPeople_num() + "");
						}
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (Exception e1) {
						e1.printStackTrace();
					}

					//System.out.println("查询");

				}

			}
		});
		this.add(search);

		// 面板
		jp.setLayout(null);
		// jp.add(ok);
		jp.add(label);

		// 窗体
		this.add(jp);
		this.setIconImage(image);
		// this.setTitle("");
		this.setSize(400, 400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		// ActionListener ok = new ActionListener() {
		//
		// @Override
		// public void actionPerformed(ActionEvent e) {
		//
		// }
		// };
	}

	public JTextField gettext() {
		return text;
	}
}
