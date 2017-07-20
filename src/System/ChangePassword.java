package System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import Operation.ManagerOperation;
import Operation.RegisterOperation;

@SuppressWarnings("serial")
public class ChangePassword extends JFrame {
	private JFrame frame = new JFrame();
	private JPanel jpl = new JPanel();
	JTextField text0;
	JPasswordField text1,text2, text3;
	private JButton ensure = new JButton("确定");
	private JButton exit = new JButton("返回");

	@SuppressWarnings("unchecked")
	public ChangePassword() {
		JLabel lab1 = new JLabel("修改密码");
		lab1.setFont(new Font("华文彩云", Font.BOLD, 25));
		lab1.setBounds(270, 5, 150, 50);
		frame.add(lab1);
		
		JLabel lab2 = new JLabel("账号:");
		lab2.setFont(new Font("隶书", Font.BOLD, 20));
		lab2.setBounds(30, 50, 100, 50);
		frame.add(lab2);

		JLabel lab3 = new JLabel("旧密码:");
		lab3.setFont(new Font("隶书", Font.BOLD, 20));
		lab3.setBounds(30, 130, 100, 50);
		frame.add(lab3);

		JLabel lab4 = new JLabel("新密码:");
		lab4.setFont(new Font("隶书", Font.BOLD, 20));
		lab4.setBounds(30, 210, 100, 50);
		frame.add(lab4);

		JLabel lab5 = new JLabel("确认密码:");
		lab5.setFont(new Font("隶书", Font.BOLD, 20));
		lab5.setBounds(30, 290, 100, 50);
		frame.add(lab5);

		JLabel lab6 = new JLabel("密码为3~12位，可为数字、字母");
		lab6.setFont(new Font("黑体", Font.BOLD, 13));
		lab6.setBounds(300, 290, 300, 50);
		lab6.setForeground(Color.red);
		frame.add(lab6);
		
		text0 = new JTextField();
		text0.setBounds(130, 60, 150, 30);
		text0.setText(Login.text1.getText());
		text0.setEditable(false);
		text0.setFont(new Font("黑体", Font.BOLD, 18));
		frame.add(text0);

		text1 = new JPasswordField();
		text1.setBounds(130, 140, 150, 30);
		text1.setFont(new Font("", Font.BOLD, 24));
		text1.setEchoChar('*');
		frame.add(text1);

		text2 = new JPasswordField();
		text2.setBounds(130, 220, 150, 30);
		text2.setFont(new Font("", Font.BOLD, 24));
		text2.setEchoChar('*');
		frame.add(text2);

		text3 = new JPasswordField();
		text3.setBounds(130, 300, 150, 30);
		text3.setFont(new Font("", Font.BOLD, 24));
		text3.setEchoChar('*');
		frame.add(text3);

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

				if (text1.getText().length() == 0 || text2.getText().length() == 0 || text3.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "密码为空", "系统提示", JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					try {
						rm = rc.get(Integer.parseInt(text0.getText()));
					
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					if (rm != null) {
						
						b = rm.getPassword().equals(text1.getText());
						if (text2.getText().length() != 0||text3.getText().length()!=0) {
							RegisterModel regismodel = new RegisterModel();                 //Pattern 要符合的模式，Matcher 用这种模式匹配字符串之后产生的结果（内容）
							Pattern ContactPattern = Pattern.compile("[a-zA-Z\\d]{3,12}");   //Pattern的Compile编译字符串
							Matcher ContactMatcher = ContactPattern.matcher(text2.getText());
							if (ContactMatcher.matches()) {				                     //matches返回是否匹配
								if (text2.getText().equals(text3.getText())) {
									regismodel.setPassword(text3.getText());									
								}
								else {
									JOptionPane.showMessageDialog(null, "密码不一致", "系统提示", JOptionPane.ERROR_MESSAGE);
									return;
								}
							}else {
								JOptionPane.showMessageDialog(null, "密码格式不正确", "系统提示", JOptionPane.ERROR_MESSAGE);
								text2.setText("");
								return;
							}
						}else{
							JOptionPane.showMessageDialog(null, "请输入新密码", "系统提示", JOptionPane.ERROR_MESSAGE);
					}
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
							re.Update(text3, text0);
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
						return;
					}
				}
				JOptionPane.showMessageDialog(null, "旧密码有误！！！", "提示", JOptionPane.INFORMATION_MESSAGE);
			}
		
	});

		exit.setBounds(400, 400, 80, 30); // 设置按钮大小
		exit.setBackground(Color.WHITE);
		exit.setFont(new Font("宋体", Font.BOLD, 22));
		exit.setVisible(true);
		exit.setLayout(null);
		frame.add(exit);
		exit.addActionListener(new ActionListener() {

			@Override
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
