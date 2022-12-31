import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class DeleteStudent extends JFrame {
	private static final long serialVersionUID = 1L;
	static DeleteStudent frame;
	private JPanel contentPane;
    private JTextField TextField;
    private JLabel lblrollno;
    private JLabel lblDeleteStudents;
    private JTextField TextField1;
    private JLabel lblName;
    private JTextField TextField2;
    private JLabel lblcourse;
    private JTextField TextField3;
    private JLabel lblbranch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new DeleteStudent();
					frame.setTitle("Delete Student Info.");
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
	public DeleteStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(110, 95, 650, 450);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        lblDeleteStudents = new JLabel("Delete Student");
		lblDeleteStudents.setFont(new Font("Courier New", Font.BOLD, 42));
		lblDeleteStudents.setForeground(Color.BLACK);
		lblDeleteStudents.setBounds(200, 27, 400, 40);
		contentPane.add(lblDeleteStudents);
        
        TextField = new JTextField();
        TextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextField.setBounds(290, 125, 326, 40);
        contentPane.add(TextField);
        TextField.setColumns(10);

        TextField1 = new JTextField();
        TextField1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextField1.setBounds(290, 175, 326, 40);
        TextField1.setEditable(false);
        contentPane.add(TextField1);
        TextField.setColumns(10);
        
        TextField2 = new JTextField();
        TextField2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextField2.setBounds(290, 225, 326, 40);
        contentPane.add(TextField2);
        TextField2.setEditable(false);
        TextField2.setColumns(10);
        
        TextField3 = new JTextField();
        TextField3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextField3.setBounds(290, 275, 326, 40);
        contentPane.add(TextField3);
        TextField3.setEditable(false);
        TextField3.setColumns(10);
        
        TextField.setText("");
		TextField1.setText("");
		TextField2.setText("");
		
	    lblrollno = new JLabel("Roll No. :");
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblrollno.setBounds(45, 125, 326, 40);
        contentPane.add(lblrollno);
        
        lblName = new JLabel("Name :");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblName.setBounds(45, 175, 326, 40);
        contentPane.add(lblName);
        
        lblcourse = new JLabel("Course :");
        lblcourse.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblcourse.setBounds(45, 225, 326, 40);
        contentPane.add(lblcourse);
        
        lblbranch = new JLabel("Branch :");
        lblbranch.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblbranch.setBounds(45, 275, 326, 40);
        contentPane.add(lblbranch);

		 Connection con = SQLCon.getConnection();
		 
		 JButton btnBack = new JButton("Back");
	        btnBack.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	frame.dispose();
	            	Student.main(new String[]{});
	            }});
	        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        btnBack.setBackground(new Color(240, 240, 240));
	        btnBack.setBounds(500, 350, 100, 50);
	        contentPane.add(btnBack);
        JButton btnSave = new JButton("Delete");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	  String r = TextField.getText();
                if(Studentdetails.checkstudent(r)) {
                try {

                	int i=Studentdetails.deletestudent(r);
					if(i>0){
						JOptionPane.showMessageDialog(DeleteStudent.this,"Student Record deleted successfully!");
						System.out.println("Deleted Record of Student ID : "+r);
					}else{
						JOptionPane.showMessageDialog(DeleteStudent.this,"Unable to delete given rollno.!");
					}

                } catch (Exception sqlException) {
                    sqlException.printStackTrace();
                }}
				else{
					JOptionPane.showMessageDialog(DeleteStudent.this,"Student ID is Invalid !!!");
            }
 
                TextField.setText("");
				TextField1.setText("");
				TextField2.setText("");
				TextField3.setText("");
            }
        });
        btnSave.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnSave.setBackground(new Color(240, 240, 240));
        btnSave.setBounds(350, 350, 100, 50);
        contentPane.add(btnSave);
        
        TextField.addKeyListener((KeyListener) new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                	String roll = TextField.getText();
                    
                	Connection con = SQLCon.getConnection();
                	if(Studentdetails.checkstudent(roll)) {
                	Statement st;
    				try {
    					PreparedStatement stmt = con.prepareStatement("select * from students where rollno=?");
    					stmt.setString(1,roll);
    					ResultSet rs = stmt.executeQuery();
    					while(rs.next())   
    					{	TextField1.setText(rs.getString(1));
    			TextField.setText(rs.getString(2));
    			TextField2.setText(rs.getString(3));
    			TextField3.setText(rs.getString(4));
    			}
    			} catch (SQLException e1) {
    				e1.printStackTrace();
    			}}else {
    				JOptionPane.showMessageDialog(DeleteStudent.this,"Student ID is Invalid !!!");
    				TextField.setText("");
    				TextField1.setText("");
    				TextField2.setText("");
    				TextField3.setText("");
    			}

                }}});
        
        
        JButton btnLoad = new JButton("Load");
        btnLoad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	  String roll = TextField.getText();
                 
            	Connection con = SQLCon.getConnection();
            	if(Studentdetails.checkstudent(roll)) {
            	Statement st;
				try {
					PreparedStatement stmt = con.prepareStatement("select * from students where rollno=?");
					stmt.setString(1,roll);
					ResultSet rs = stmt.executeQuery();
					while(rs.next())   
					{	TextField1.setText(rs.getString(1));
			TextField.setText(rs.getString(2));
			TextField2.setText(rs.getString(3));
			TextField3.setText(rs.getString(4));
			}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}}else {
				JOptionPane.showMessageDialog(DeleteStudent.this,"Student ID is Invalid !!!");
				TextField.setText("");
				TextField1.setText("");
				TextField2.setText("");
				TextField3.setText("");
			}

            }});
        btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnLoad.setBackground(new Color(240, 240, 240));
        btnLoad.setBounds(200, 350, 100, 50);
        contentPane.add(btnLoad);
        
    }
}
