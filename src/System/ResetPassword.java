package System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Control.RegisterControl;
import Model.RegisterModel;
import Model.StudentsModel;
import Operation.RegisterOperation;

@SuppressWarnings("serial")
public class ResetPassword extends JFrame {
	private JFrame frame = new JFrame();
	private JPanel jpl = new JPanel();
	JTextField text1;
	JPasswordField text2 = new JPasswordField();
	private JButton ensure = new JButton("确定");
	private JButton exit = new JButton("返回");
	JLabel lab1, lab2, lab3, lab4, lab5;

	public ResetPassword() {

		lab1 = new JLabel("重置密码");
		lab1.setFont(new Font("华文彩云", Font.BOLD, 25));
		lab1.setBounds(270, 20, 150, 50);
		frame.add(lab1);

		lab2 = new JLabel("身份:");
		jpl.add(lab2);
		lab2.setBounds(30, 120, 100, 50);
		lab2.setFont(new Font("隶书", Font.BOLD, 20));
		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(120, 130, 150, 30);
		comboBox.addItem("管理员");
		comboBox.addItem("宿    管");
		comboBox.addItem("学    生");
		comboBox.setFont(new Font("华文行楷", Font.PLAIN, 20));
		jpl.add(comboBox);
		jpl.setLayout(null);

		lab3 = new JLabel("账号:");
		lab3.setFont(new Font("隶书", Font.BOLD, 20));
		lab3.setBounds(30, 220, 100, 50);
		frame.add(lab3);

		lab4 = new JLabel("新密码:");
		lab4.setFont(new Font("隶书", Font.BOLD, 20));
		lab4.setBounds(30, 320, 100, 50);
		frame.add(lab4);

		lab5 = new JLabel("密码3-12位，可为数字、字母");
		lab5.setFont(new Font("黑体", Font.BOLD, 13));
		lab5.setBounds(290, 320, 300, 50);
		lab5.setForeground(Color.red);
		lab5.setVisible(false);
		frame.add(lab5);

		text1 = new JTextField();
		text1.setBounds(120, 230, 150, 30);
		text1.setFont(new Font("黑体", Font.BOLD, 18));
		frame.add(text1);

		text2 = new JPasswordField();
		text2.setBounds(120, 330, 150, 30);
		text2.setFont(new Font("", Font.BOLD, 24));
		text2.setEchoChar('*');
		text2.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
				lab5.setVisible(true);
			}
		});

		frame.add(text2);

		ensure.setBounds(150, 400, 80, 30); // 设置按钮大小
		ensure.setBackground(Color.WHITE);
		ensure.setFont(new Font("宋体", Font.BOLD, 22));
		ensure.setVisible(true);
		ensure.setLayout(null);
		frame.add(ensure);

		ensure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterControl rc = new RegisterControl();
				RegisterModel rm = null;
				boolean b = false;
				RegisterOperation re = new RegisterOperation();

				if (text1.getText().length() == 0 || text2.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "账号或密码为空", "系统提示", JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					try {
						rm = rc.get(Integer.parseInt(text1.getText()));

					} catch (Exception e1) {
						e1.printStackTrace();
					}
					if (rm != null) {
						b = rm.getAccountt().equals(Integer.parseInt(text1.getText()));
						if (text2.getText().length() != 0) {
							RegisterModel regismodel = new RegisterModel();                 //Pattern 要符合的模式，Matcher 用这种模式匹配字符串之后产生的结果（内容）
							Pattern ContactPattern = Pattern.compile("[a-zA-Z\\d]{3,12}");   //Pattern的Compile编译字符串
							Matcher ContactMatcher = ContactPattern.matcher(text2.getText());
							if (ContactMatcher.matches()) {				                     //matches返回是否匹配
								regismodel.setPassword(text2.getText());
							} else {
								JOptionPane.showMessageDialog(null, "密码格式不正确", "系统提示", JOptionPane.ERROR_MESSAGE);
								text2.setText("");
								return;
							}
								
							}else{
								JOptionPane.showMessageDialog(null, "请输入密码", "系统提示", JOptionPane.ERROR_MESSAGE);
						}
					}
					if (b) {
						// 弹出一个确认消息框
						String[] options = new String[] { "是", "否" };
						int n = JOptionPane.showOptionDialog(null, "确认此密码?", "提示", JOptionPane.DEFAULT_OPTION,
								JOptionPane.WARNING_MESSAGE, null, options, options[0]);
						// 点击是的话
						if (n == JOptionPane.YES_OPTION) {
							JOptionPane.showMessageDialog(null, "重置密码成功！！！", "提示", JOptionPane.INFORMATION_MESSAGE);
							setVisible(false);
							
							try {
								re.Update(text2, text1);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							frame.dispose();
							return;
						}
						// 点击否的话，返回
						else if (n == JOptionPane.NO_OPTION) {
							frame.dispose();
						}
					}
					JOptionPane.showMessageDialog(null, "身份有误！！！", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		exit.setBounds(400, 400, 80, 30); // 设置按钮大小
		exit.setBackground(Color.WHITE);
		exit.setFont(new Font("宋体", Font.BOLD, 22));
		exit.setVisible(true);
		exit.setLayout(null);
		frame.add(exit);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == exit) {
					frame.dispose();
				}
			}
		});

		JLabel label = new JLabel(new ImageIcon("image\\Passwordback.jpg"));
		label.setSize(800, 600);
		Image image = this.getToolkit().getImage("image\\icon.png");

		jpl.add(label);
		jpl.setLayout(null);

		frame.add(jpl);
		frame.setIconImage(image);
		frame.setTitle("宿舍管理系统");
		frame.setSize(640, 480);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
