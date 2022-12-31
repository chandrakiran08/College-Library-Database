import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {
	private static final long serialVersionUID = 1L;
	static Login frame;
	private JPanel contentPane;
	private JTextField TextField;
	private JPasswordField PasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Login();
					frame.setTitle("College Library DataBase");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(103, 95, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ImageIcon i = new ImageIcon("src/vl.png");
		JLabel lbllogo = new JLabel(i);
		lbllogo.setForeground(Color.GRAY);
		lbllogo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbllogo.setBounds(150, 30, 400, 300);
		contentPane.add(lbllogo);
		
		JLabel lblName = new JLabel("Login ID : ");
        lblName.setFont(new Font("Courier New", Font.BOLD, 20));
        lblName.setBounds(155, 375, 200, 40);
        contentPane.add(lblName);
		
    	JLabel lblName1 = new JLabel("Password : ");
        lblName1.setFont(new Font("Courier New", Font.BOLD, 20));
        lblName1.setBounds(155, 425, 200, 40);
        contentPane.add(lblName1);
		
        TextField = new JTextField();
	     TextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
	        TextField.setBounds(290, 375, 250, 40);
	        contentPane.add(TextField);
	        TextField.setColumns(10);
	        
	        PasswordField = new JPasswordField();
	        PasswordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
	        PasswordField.setBounds(290, 425, 250, 40);
		        contentPane.add(PasswordField);
		        PasswordField.setColumns(10);
			
		
		JButton btnClose = new JButton("Close");
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 frame.dispose();
            }});
        btnClose.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnClose.setBackground(new Color(240, 240, 240));
        btnClose.setBounds(450, 500, 130, 50);
        contentPane.add(btnClose);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String name=TextField.getText();
			String password=String.valueOf(PasswordField.getPassword());
			if(Logindetails.checklogin(name)){
				if(Logindetails.checkpassword(name,password)){
				Menu.main(new String[]{});
				Menu.id(name);
				frame.dispose();
			}
				else{
					JOptionPane.showMessageDialog(Login.this, "Login Error !!\n Password was Incorrect");
					PasswordField.setText("");
					}
				}
				else{
					JOptionPane.showMessageDialog(Login.this,"User Error !!\n User doesn't exist ");
				TextField.setText("");
				PasswordField.setText("");
			}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnLogin.setBackground(new Color(240, 240, 240));
        btnLogin.setBounds(250, 500, 130, 50);
        contentPane.add(btnLogin);
		
	}
}
