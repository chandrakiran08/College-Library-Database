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

public class Menu extends JFrame {
	private static final long serialVersionUID = 1L;
	static Menu frame;
	private JPanel contentPane;
	static String idd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Menu();
					frame.setTitle("College Library Database");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
     public static void id(String id) {
    	idd=id;
     }
	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 650);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLibrarianSection = new JLabel("Welcome, Librarian - "+idd);
		lblLibrarianSection.setFont(new Font("Academy Engraved LET", Font.BOLD , 40));
		lblLibrarianSection.setBounds(75, 50, 500, 60);
		contentPane.add(lblLibrarianSection);
		
		JButton btnBInfo = new JButton("Books Info");
		btnBInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Book.main(new String[]{});
			frame.dispose();
			}
		});
		btnBInfo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnBInfo.setBackground(new Color(0,0, 0));
        btnBInfo.setBounds(100, 150, 200, 50);
        contentPane.add(btnBInfo);
		
		JButton btnSInfo = new JButton("Students Info");
		btnSInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Student.main(new String[]{});
				frame.dispose();
			}
		});
		btnSInfo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSInfo.setBackground(new Color(0,0, 0));
		btnSInfo.setBounds(335, 150, 200, 50);
        contentPane.add(btnSInfo);
		
		JButton btnIssueBook = new JButton("Issue Books");
		btnIssueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Issue.main(new String[]{});
				frame.dispose();
			}
		});
		btnIssueBook.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnIssueBook.setBackground(new Color(0,0, 0));
		btnIssueBook.setBounds(100, 250, 200, 50);
        contentPane.add(btnIssueBook);
		
		
		JButton btnChange = new JButton("Change Password");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePassword.frame = new ChangePassword(idd);
				ChangePassword.frame.setTitle("College Library Datbase");
				ChangePassword.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnChange.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnChange.setBackground(new Color(0,0, 0));
		btnChange.setBounds(215, 485, 200, 50);
        contentPane.add(btnChange);
		
        JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search.main(new String[]{});
				frame.dispose();
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSearch.setBackground(new Color(0,0, 0));
		btnSearch.setBounds(215, 335, 200, 50);
        contentPane.add(btnSearch);
		
        JButton btnStat = new JButton("Statistics");
        btnStat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statistics.main(new String[]{});
				frame.dispose();
			}
		});
        btnStat.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnStat.setBackground(new Color(0,0, 0));
        btnStat.setBounds(215, 410, 200, 50);
        contentPane.add(btnStat);
		
        
		JButton btnReturnBook = new JButton("Return Books");
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Return.main(new String[]{});
				frame.dispose();
			}
		});
		btnReturnBook.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReturnBook.setBackground(new Color(0,0, 0));
		btnReturnBook.setBounds(335, 250, 200, 50);
        contentPane.add(btnReturnBook);
		
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(new String[]{});
				frame.dispose();
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogout.setBackground(new Color(0,0, 0));
		btnLogout.setBounds(215, 555, 200, 50);
        contentPane.add(btnLogout);
		
	}

}
