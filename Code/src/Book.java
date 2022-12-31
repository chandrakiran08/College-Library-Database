
import java.awt.BorderLayout;
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

public class Book extends JFrame {
	private static final long serialVersionUID = 1L;
	static Book frame;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Book();
					frame.setTitle("Book Info.");
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
	public Book() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 440);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInfo = new JLabel("--  Books   --");
		lblInfo.setFont(new Font("American Typewriter", Font.BOLD, 42));
		lblInfo.setForeground(Color.DARK_GRAY);
		lblInfo.setBounds(200, 50, 410, 60);
		contentPane.add(lblInfo);
		
		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AddBook.main(new String[]{});
			frame.dispose();
			}
		});
		btnAddBook.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnAddBook.setBackground(new Color(0,0, 0));
        btnAddBook.setBounds(100, 150, 200, 50);
        contentPane.add(btnAddBook);
		
		JButton btnUpdateBook = new JButton("Modify Book Details");
		btnUpdateBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Updatebook.main(new String[]{});
				frame.dispose();
			}
		});
		btnUpdateBook.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnUpdateBook.setBackground(new Color(0,0, 0));
        btnUpdateBook.setBounds(335, 150, 200, 50);
        contentPane.add(btnUpdateBook);
		
		JButton btnDeleteBook = new JButton("Delete Book");
		btnDeleteBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteBook.main(new String[]{});
				frame.dispose();
			}
		});
		btnDeleteBook.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnDeleteBook.setBackground(new Color(0,0, 0));
        btnDeleteBook.setBounds(100, 250, 200, 50);
        contentPane.add(btnDeleteBook);
		
		JButton btnView = new JButton("View All Books");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewBook.main(new String[]{});
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