import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class DeleteBook extends JFrame {
	private static final long serialVersionUID = 1L;
	static DeleteBook frame;
	private JPanel contentPane;
    private JTextField TextField;
    private JLabel lblEnterOldPassword;
    private JTextField TextField1;
    private JLabel lblEnterNewPassword;
    private JTextField TextField2;
    private JLabel lblReEnterNewPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new DeleteBook();
					frame.setTitle("Delete book Info.");
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
	public DeleteBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(110, 95, 650, 420);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JLabel lblAdSQLConooks = new JLabel("Delete Book");
        lblAdSQLConooks.setFont(new Font("Courier New", Font.BOLD, 36));
        lblAdSQLConooks.setForeground(Color.BLACK);
        lblAdSQLConooks.setBounds(275, 27, 350, 40);
        contentPane.add(lblAdSQLConooks);

        TextField = new JTextField();
        TextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextField.setBounds(290, 125, 326, 40);
        contentPane.add(TextField);
        TextField.setColumns(10);

        TextField1 = new JTextField();
        TextField1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextField1.setBounds(290, 175, 350, 40);
        TextField1.setEditable(false);
        contentPane.add(TextField1);
        TextField.setColumns(20);
        
        TextField2 = new JTextField();
        TextField2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextField2.setBounds(290, 225, 350, 40);
        contentPane.add(TextField2);
        TextField2.setEditable(false);
        TextField2.setColumns(20);
        
        TextField.setText("");
		TextField1.setText("");
		TextField2.setText("");
		
	    lblEnterOldPassword = new JLabel("Book ID :");
        lblEnterOldPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblEnterOldPassword.setBounds(45, 125, 326, 40);
        contentPane.add(lblEnterOldPassword);
        
        lblEnterNewPassword = new JLabel("Title :");
        lblEnterNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblEnterNewPassword.setBounds(45, 175, 326, 40);
        contentPane.add(lblEnterNewPassword);
        
        lblReEnterNewPassword = new JLabel("Author :");
        lblReEnterNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblReEnterNewPassword.setBounds(45, 225, 326, 40);
        contentPane.add(lblReEnterNewPassword);

		 Connection con = SQLCon.getConnection();
		 
		 JButton btnBack = new JButton("Back");
	        btnBack.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	frame.dispose();
	            	Book.main(new String[]{});
	            }});
	        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        btnBack.setBackground(new Color(240, 240, 240));
	        btnBack.setBounds(450, 300, 130, 50);
	        contentPane.add(btnBack);
        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sid=TextField.getText();
				if(sid==null||sid.trim().equals("")){
					JOptionPane.showMessageDialog(DeleteBook.this,"Id can't be blank");
				}else{
					
					int i=Bookdetails.deletebook(sid);
					if(i>0){
						JOptionPane.showMessageDialog(DeleteBook.this,"Book Record deleted successfully!");
						System.out.println("Deleted record of Book-id : "+sid);
					}else{
						JOptionPane.showMessageDialog(DeleteBook.this,"Unable to delete given id!");
					}
				}
				TextField.setText("");
				TextField1.setText("");
				TextField2.setText("");
			}
		});
        btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnDelete.setBackground(new Color(240, 240, 240));
        btnDelete.setBounds(300, 300, 130, 50);
        contentPane.add(btnDelete);
        
        TextField.addKeyListener((KeyListener) new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                	String roll = TextField.getText();
                    
                	Connection con = SQLCon.getConnection();
                	if(Bookdetails.checkbook(roll)) {
                	Statement st;
    				try {
    					PreparedStatement stmt = con.prepareStatement("select * from book where bookid=?");
    					stmt.setString(1,roll);
    					ResultSet rs = stmt.executeQuery();
    					while(rs.next())   
    					{	TextField.setText(rs.getString(1));
    			TextField1.setText(rs.getString(2));
    			TextField2.setText(rs.getString(3));
    			}
    			} catch (SQLException e1) {
    				e1.printStackTrace();
    			}}else {
    				JOptionPane.showMessageDialog(DeleteBook.this,"book ID is Invalid !!!");
    				TextField.setText("");
    				TextField1.setText("");
    				TextField2.setText("");
    			}

                }}});
        
        
        JButton btnLoad = new JButton("Load");
        btnLoad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	  String roll = TextField.getText();
                 
            	Connection con = SQLCon.getConnection();
            	if(Bookdetails.checkbook(roll)) {
            	Statement st;
				try {
					PreparedStatement stmt = con.prepareStatement("select * from book where bookid=?");
					stmt.setString(1,roll);
					ResultSet rs = stmt.executeQuery();
					while(rs.next())   
					{	TextField.setText(rs.getString(1));
			TextField1.setText(rs.getString(2));
			TextField2.setText(rs.getString(3));
			}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}}else {
				JOptionPane.showMessageDialog(DeleteBook.this,"book ID is Invalid !!!");
				TextField.setText("");
				TextField1.setText("");
				TextField2.setText("");
			}

            }});
        btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnLoad.setBackground(new Color(240, 240, 240));
        btnLoad.setBounds(150, 300, 130, 50);
        contentPane.add(btnLoad);
        
    }
}
