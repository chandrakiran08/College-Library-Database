
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class AddBook extends JFrame {
	private static final long serialVersionUID = 1L;
	static AddBook frame;
	private JPanel contentPane;
	private JTextField TextField;
	private JTextField TextField_1;
	private JTextField TextField_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AddBook();
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
	public AddBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(110, 95, 650, 400);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        TextField = new JTextField();
        TextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextField.setBounds(290, 125, 326, 40);
        contentPane.add(TextField);
        TextField.setColumns(10);

        TextField_1 = new JTextField();
        TextField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextField_1.setBounds(290, 175, 326, 40);
        contentPane.add(TextField_1);
        TextField_1.setColumns(10);
        
        TextField_2 = new JTextField();
        TextField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextField_2.setBounds(290, 225, 326, 40);
        contentPane.add(TextField_2);
        TextField_2.setColumns(10);
        
        TextField.setText("");
		TextField_1.setText("");
		TextField_2.setText("");
		
		JLabel lblAddBooks = new JLabel("Add Books");
        lblAddBooks.setFont(new Font("Courier New", Font.BOLD, 36));
        lblAddBooks.setForeground(Color.BLACK);
        lblAddBooks.setBounds(275, 27, 200, 40);
        contentPane.add(lblAddBooks);
        
		JLabel lblbookid = new JLabel("Book ID :");
        lblbookid.setFont(new Font("Big Calson", Font.PLAIN, 18));
        lblbookid.setBounds(45, 125, 326, 40);
        contentPane.add(lblbookid);
		
		JLabel lblName = new JLabel("Title :");
        lblName.setFont(new Font("Big Calson", Font.PLAIN, 18));
        lblName.setBounds(45, 175, 326, 40);
        contentPane.add(lblName);
		JLabel lblAuthor = new JLabel("Author :");
        lblAuthor.setFont(new Font("Big Calson", Font.PLAIN, 18));
        lblAuthor.setBounds(45, 225, 326, 40);
        contentPane.add(lblAuthor);
		JButton btnAddBooks = new JButton("Submit");
		btnAddBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String id=TextField.getText();
			String name=TextField_1.getText();
			String author=TextField_2.getText();
			boolean checkid =Pattern.matches("0L[0-9][0-9][0-9][0-9][0-9]",id);
			if(checkid) {
			if(id.equals("") || name.equals("")|| author.equals("") ) {
				JOptionPane.showMessageDialog(AddBook.this,"Error !!\n Kindly Fill all the fields ");
			}
			else {
			if(Bookdetails.checkbook(id)) {
				JOptionPane.showMessageDialog(AddBook.this,"Duplication Error !!\n Inserton Failed");
			}
			else {
			int i=Bookdetails.insertbook(id, name, author);
			if(i>0){
				JOptionPane.showMessageDialog(AddBook.this,"Books added successfully!");
			}else{
				JOptionPane.showMessageDialog(AddBook.this,"Unknown Error !!!\n Insertion not completed");
			}
			}
			}}
			else
				JOptionPane.showMessageDialog(AddBook.this,"Format Error !!\nBook ID - 0LXXXXX");
			}
		});
		btnAddBooks.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnAddBooks.setBackground(new Color(0,0, 0));
        btnAddBooks.setBounds(300, 300, 130, 50);
        contentPane.add(btnAddBooks);

		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				Book.main(new String[]{});
				frame.dispose();
			}
			});
		  btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        btnBack.setBackground(new Color(240, 240, 240));
	        btnBack.setBounds(450, 300, 130, 50);
	        contentPane.add(btnBack);
	}

}
