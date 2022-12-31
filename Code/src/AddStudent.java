import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class AddStudent extends JFrame {
	private static final long serialVersionUID = 1L;
	static AddStudent frame;
	private JPanel contentPane;
	private JTextField TextField;
	private JTextField TextField_1;
	private JRadioButton rb1;
	private JRadioButton rb2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AddStudent();
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
	public AddStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddStudents = new JLabel("Add Students");
		lblAddStudents.setFont(new Font("Courier New", Font.BOLD, 42));
		lblAddStudents.setForeground(Color.BLACK);
		lblAddStudents.setBounds(225, 27, 326, 40);
		contentPane.add(lblAddStudents);
		    
		JLabel lblname = new JLabel("Name :");  
		lblname.setFont(new Font("Big Calson", Font.PLAIN, 18));    
		lblname.setBounds(45, 125, 326, 40); 
		contentPane.add(lblname);
				
		JLabel lblrollno = new JLabel("Roll Number :");
		lblrollno.setFont(new Font("Big Calson", Font.PLAIN, 18));
		lblrollno.setBounds(45, 175, 326, 40);
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
	    TextField.setFont(new Font("Big Calson", Font.PLAIN, 18));
	    TextField.setBounds(290, 125, 326, 40);
	    contentPane.add(TextField);
	    TextField.setColumns(10);

	    TextField_1 = new JTextField();
	    TextField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    TextField_1.setBounds(290, 175, 326, 40);
	    contentPane.add(TextField_1);
	    TextField_1.setColumns(10);
	    
		rb1 = new JRadioButton("B.E");
	    rb1.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    rb1.setBounds(290, 225, 100, 40);
	    contentPane.add(rb1);
	    
	    rb2 = new JRadioButton("M.E");
	    rb2.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    rb2.setBounds(400, 225, 100, 40);
	    contentPane.add(rb2);
	    
	    ButtonGroup bg=new ButtonGroup();    
	    bg.add(rb1);bg.add(rb2);
	    
	    String[] be = {"      ---- Select ----"}; ;
	    JComboBox<String> jComboBox = new JComboBox<>(be);
	    jComboBox.setBounds(290, 275, 200, 60);
	    contentPane.add(jComboBox);
	        
	    rb1.addItemListener(new ItemListener() 
	    {        
	    	public void itemStateChanged(ItemEvent e) 
	    	{
	                if (e.getStateChange() == ItemEvent.SELECTED) {
	                	jComboBox.removeAllItems();
	                	jComboBox.addItem("      ---- Select ----");
	                	jComboBox.addItem("Civil");
	                	jComboBox.addItem("CSE");
	                	jComboBox.addItem("EEE");
	                	jComboBox.addItem("ECE");
	                	jComboBox.addItem("Mechanical");
	                	jComboBox.addItem("IT");
	                }
	                else if (e.getStateChange() == ItemEvent.DESELECTED) {
	                	jComboBox.removeAllItems();
	                }
	        }
	    });
	    
	    rb2.addItemListener(new ItemListener() {        
	    	public void itemStateChanged(ItemEvent e) {
	                if (e.getStateChange() == ItemEvent.SELECTED) {
	                jComboBox.removeAllItems();
	                jComboBox.addItem("      ---- Select ----");
	                jComboBox.addItem("ADM");
	                jComboBox.addItem("ESVLSID");
	                jComboBox.addItem("PSPE");
	                }
	                else if (e.getStateChange() == ItemEvent.DESELECTED) {
	                	jComboBox.removeAllItems();
	                }
	            }
	    });
	    
		JButton btnAdd = new JButton("Submit");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String name=TextField.getText();
			String rollno=TextField_1.getText();
			String branch = null;
			if(rb1.isSelected()) {
				branch = rb1.getText();
			}
			if(rb2.isSelected()) {
				branch = rb2.getText();
			}
			String course = jComboBox.getItemAt(jComboBox.getSelectedIndex());
			boolean check = Pattern.matches("1602-[0-9][0-9]-[0-9][0-9][0-9]-[0-9][0-9][0-9]", rollno);
			if(check) {
			if(rollno.equals("") || name.equals("")|| course.equals("      ---- Select ----")|| branch.equals(null)) {
				JOptionPane.showMessageDialog(AddStudent.this,"Error !!\n Kindly Fill all fields");
			}
			else {
			if(Studentdetails.checkstudent(rollno)) {
				JOptionPane.showMessageDialog(AddStudent.this,"Duplication Error !!\nInsertion Failed");
			}
			else {
			int i=Studentdetails.insertstudent(name, rollno, branch, course);
			System.out.println(branch);
			if(i>0){
				JOptionPane.showMessageDialog(AddStudent.this,"Added Student successfully!");
			}else{
				JOptionPane.showMessageDialog(AddStudent.this,"Unknown Error !!\nInsertion Failed");
			}
			}
			}
			}
			else
				JOptionPane.showMessageDialog(AddStudent.this,"Format Error !!\nRoll Number : 1602-XX-XXX-XXX ");
			}
		});		
		
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnAdd.setBackground(new Color(0,0, 0));
        btnAdd.setBounds(300, 375, 130, 50);
        contentPane.add(btnAdd);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				Student.main(new String[]{});
				frame.dispose();
			}
			});

		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    btnBack.setBackground(new Color(240, 240, 240));
	    btnBack.setBounds(475, 375, 130, 50);
	    contentPane.add(btnBack);
	}

}
