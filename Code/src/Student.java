import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Student extends JFrame {
	private static final long serialVersionUID = 1L;
	static Student frame;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Student();
					frame.setTitle("Student Info.");
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
	public Student() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 440);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInfo = new JLabel("--  Students  --");
		lblInfo.setFont(new Font("American Typewriter", Font.BOLD, 42));
		lblInfo.setForeground(Color.DARK_GRAY);
		lblInfo.setBounds(180, 50, 326, 60);
		contentPane.add(lblInfo);
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AddStudent.main(new String[]{});
			frame.dispose();
			}
		});
		btnAddStudent.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnAddStudent.setBackground(new Color(0,0, 0));
        btnAddStudent.setBounds(100, 150, 200, 50);
        contentPane.add(btnAddStudent);
		
		JButton btnUpdateStudent = new JButton("Modify Details");
		btnUpdateStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Updatestudent.main(new String[]{});
				frame.dispose();
			}
		});
		btnUpdateStudent.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnUpdateStudent.setBackground(new Color(0,0, 0));
        btnUpdateStudent.setBounds(335, 150, 200, 50);
        contentPane.add(btnUpdateStudent);
		
		JButton btnDeleteStudent = new JButton("Delete Student");
		btnDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteStudent.main(new String[]{});
				frame.dispose();
			}
		});
		btnDeleteStudent.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnDeleteStudent.setBackground(new Color(0,0, 0));
        btnDeleteStudent.setBounds(100, 250, 200, 50);
        contentPane.add(btnDeleteStudent);
		
		JButton btnView = new JButton("View Students");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewStudent.main(new String[]{});
			}
		});
		btnView.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnView.setBackground(new Color(0,0, 0));
        btnView.setBounds(335, 250, 200, 50);
        contentPane.add(btnView);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.main(new String[]{});
				frame.dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnBack.setBackground(new Color(0,0, 0));
        btnBack.setBounds(215, 335, 200, 50);
        contentPane.add(btnBack);
			
}
}
