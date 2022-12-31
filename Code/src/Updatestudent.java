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

public class Updatestudent extends JFrame {

    private static final long serialVersionUID = 1L;
    static Updatestudent frame;
    private JPanel contentPane;
    private JTextField TextField;
    private JTextField TextField1;
    private JTextField TextField2;
    private JTextField TextField3;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Updatestudent();
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
    public Updatestudent() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(110, 95, 650, 480);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblUpdateStudents = new JLabel("Modify Details");
		lblUpdateStudents.setFont(new Font("Courier New", Font.BOLD, 42));
		lblUpdateStudents.setForeground(Color.BLACK);
		lblUpdateStudents.setBounds(150, 27, 500, 60);
		contentPane.add(lblUpdateStudents);
		    
		JLabel lblname = new JLabel("Name :");  
		lblname.setFont(new Font("Big Calson", Font.PLAIN, 18));    
		lblname.setBounds(45, 175, 326, 40); 
		contentPane.add(lblname);
				
		JLabel lblrollno = new JLabel("Roll Number :");
		lblrollno.setFont(new Font("Big Calson", Font.PLAIN, 18));
		lblrollno.setBounds(45, 125, 326, 40);
		contentPane.add(lblrollno);
		    
		JLabel lblcourse = new JLabel("Course :");
		lblcourse.setFont(new Font("Big Calson", Font.PLAIN, 18));
		lblcourse.setBounds(45, 225, 326, 40);
		contentPane.add(lblcourse);
		JLabel lblbranch = new JLabel("Branch :");
		lblbranch.setFont(new Font("Big Calson", Font.PLAIN, 18));
		lblbranch.setBounds(45, 275, 326, 40);
		contentPane.add(lblbranch);

        TextField = new JTextField();
        TextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextField.setBounds(290, 125, 326, 40);
        contentPane.add(TextField);
        TextField.setColumns(10);

        TextField1 = new JTextField();
        TextField1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextField1.setBounds(290, 175, 326, 40);
        contentPane.add(TextField1);
        TextField.setColumns(10);
        
        TextField2 = new JTextField();
        TextField2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextField2.setBounds(290, 225, 326, 40);
        contentPane.add(TextField2);
        TextField2.setColumns(10);
        
        TextField3 = new JTextField();
        TextField3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextField3.setBounds(290, 275, 326, 40);
        contentPane.add(TextField3);
        TextField3.setColumns(10);
        
        TextField.setText("");
		TextField1.setText("");
		TextField2.setText("");

		 Connection con = SQLCon.getConnection();
		 
		 JButton btnBack = new JButton("Back");
	        btnBack.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	frame.dispose();
	            	Student.main(new String[]{});
	            }});
	        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        btnBack.setBackground(new Color(240, 240, 240));
	        btnBack.setBounds(450, 375, 130, 50);
	        contentPane.add(btnBack);
        JButton btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	  String r = TextField.getText();
                  String n = TextField1.getText();
                  String b = TextField3.getText();
                  String c = TextField2.getText();
                if(Studentdetails.checkstudent(r)) {
                try {

                    PreparedStatement st = con.prepareStatement("Update students set Name=?,branch = ?,course=? where rollno=?");

                    st.setString(1, n);
                    st.setString(3, c);
                    st.setString(2, b);
                    st.setString(4, r);
                    st.executeUpdate();
                  System.out.println("Updated Info for Roll No. : " + r);
                    JOptionPane.showMessageDialog(btnSave, "Data Updated Successfully :)");

                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }}
				else{
					JOptionPane.showMessageDialog(Updatestudent.this,"Student ID is Invalid !!!");
				TextField.setText("");
				TextField1.setText("");
				TextField2.setText("");
				TextField3.setText("");
            }
 

            }
        });
        btnSave.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnSave.setBackground(new Color(240, 240, 240));
        btnSave.setBounds(300, 375, 130, 50);
        contentPane.add(btnSave);

        JButton btnLoad = new JButton("Load");
        btnLoad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	  String roll = TextField.getText();
                  String name = TextField1.getText();
                  String branch = TextField3.getText();
                  String course = TextField2.getText();
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
			TextField3.setText(rs.getString(3));
			TextField2.setText(rs.getString(4));
			}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}}else {
				JOptionPane.showMessageDialog(Updatestudent.this,"Student ID is Invalid !!!");
				TextField.setText("");
				TextField1.setText("");
				TextField2.setText("");
				TextField3.setText("");
			}

            }});
        btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnLoad.setBackground(new Color(240, 240, 240));
        btnLoad.setBounds(150, 375, 130, 50);
        contentPane.add(btnLoad);
        
    }
}