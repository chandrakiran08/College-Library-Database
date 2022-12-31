import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Updatebook extends JFrame {

    private static final long serialVersionUID = 1L;
    static Updatebook frame;
    private JPanel contentPane;
    private JTextField TextField;
    private JLabel lblBookId;
    private JTextField TextField1;
    private JLabel lblTitle;
    private JTextField TextField2;
    private JLabel lblAuthor;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Updatebook();
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
    public Updatebook() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(110, 95, 650, 450);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
		JLabel lblUpdateBooks = new JLabel("Modify Details");
		lblUpdateBooks.setFont(new Font("Courier New", Font.BOLD, 42));
		lblUpdateBooks.setForeground(Color.BLACK);
		lblUpdateBooks.setBounds(150, 27, 500, 60);
        contentPane.add(lblUpdateBooks);

        TextField = new JTextField();
        TextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextField.setBounds(290, 137, 326, 40);
        contentPane.add(TextField);
        TextField.setColumns(10);

        TextField1 = new JTextField();
        TextField1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextField1.setBounds(290, 187, 326, 40);
        contentPane.add(TextField1);
        TextField.setColumns(10);
        
        TextField2 = new JTextField();
        TextField2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextField2.setBounds(290, 237, 326, 40);
        contentPane.add(TextField2);
        TextField2.setColumns(10);
        
        TextField.setText("");
		TextField1.setText("");
		TextField2.setText("");

		 Connection con = SQLCon.getConnection();
		 
		 JButton btnBack = new JButton("Back");
	        btnBack.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	frame.dispose();
	            	Book.main(new String[]{});
	            }});
	        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        btnBack.setBackground(new Color(240, 240, 240));
	        btnBack.setBounds(450, 325, 130, 50);
	        contentPane.add(btnBack);
        JButton btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	  String b = TextField.getText();
                  String t = TextField1.getText();
                  String a = TextField2.getText();
                if(Bookdetails.checkbook(b)) {
                try {

                    PreparedStatement st = con.prepareStatement("Update book set title=?, author = ? where bookid=?");

                    st.setString(1, t);
                    st.setString(2, a);
                    st.setString(3, b);
                    st.executeUpdate();
                  System.out.println("Updated Info for Book-ID : " + b);
                    JOptionPane.showMessageDialog(btnSave, "Data Updated Successfully :)");

                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }}
				else{
					JOptionPane.showMessageDialog(Updatebook.this,"Book ID is Invalid !!!");
				TextField.setText("");
				TextField1.setText("");
				TextField2.setText("");
            }
 

            }
        });
        btnSave.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnSave.setBackground(new Color(240, 240, 240));
        btnSave.setBounds(300, 325, 130, 50);
        contentPane.add(btnSave);

        lblBookId = new JLabel("Book ID :");
        lblBookId.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblBookId.setBounds(45, 137, 326, 40);
        contentPane.add(lblBookId);
        
        lblTitle = new JLabel("Title :");
        lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblTitle.setBounds(45, 187, 326, 40);
        contentPane.add(lblTitle);
        
        lblAuthor = new JLabel("Author :");
        lblAuthor.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblAuthor.setBounds(45, 237, 326, 40);
        contentPane.add(lblAuthor);
        
        JButton btnLoad = new JButton("Load");
        btnLoad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	  String book = TextField.getText();
                  String title = TextField1.getText();
                  String author = TextField2.getText();
            	Connection con = SQLCon.getConnection();
            	if(Bookdetails.checkbook(book)) {
            	Statement st;
				try {
					PreparedStatement stmt = con.prepareStatement("select * from book where bookid=?");
					stmt.setString(1,book);
					ResultSet rs = stmt.executeQuery();
					while(rs.next())   
					{	TextField.setText(rs.getString(1));
			TextField1.setText(rs.getString(2));
			TextField2.setText(rs.getString(3));}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}}else {
				JOptionPane.showMessageDialog(Updatebook.this,"Book ID is Invalid !!");
				TextField.setText("");
				TextField1.setText("");
				TextField2.setText("");
			}

            }});
        btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnLoad.setBackground(new Color(240, 240, 240));
        btnLoad.setBounds(150, 325, 130, 50);
        contentPane.add(btnLoad);
        
    }
}