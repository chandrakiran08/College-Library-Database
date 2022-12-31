import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Return extends JFrame {
	private static final long serialVersionUID = 1L;
	static Return frame;
	private JPanel contentPane;
	private JTextField TextField;
	private JTextField TextField1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Return();
					frame.setTitle("Returning Book");
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
	public Return() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 650, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReturn = new JLabel("Return Book ");
		lblReturn.setFont(new Font("Courier New", Font.BOLD, 42));
		lblReturn.setForeground(Color.DARK_GRAY);
		lblReturn.setBounds(225, 27, 326, 40);
		contentPane.add(lblReturn);
	        
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

		    JLabel lblrollno = new JLabel("Student Roll Number :");
	        lblrollno.setFont(new Font("Big Calson", Font.PLAIN, 18));
	        lblrollno.setBounds(45, 175, 326, 40);
	        contentPane.add(lblrollno);
	        
	        JLabel lblbid = new JLabel("Book-ID :");
	        lblbid.setFont(new Font("Big Calson", Font.PLAIN, 18));
	        lblbid.setBounds(45, 125, 326, 40);
	        contentPane.add(lblbid);
	        
	        JLabel lbldate = new JLabel("Returning Date :");
	        lbldate.setFont(new Font("Big Calson", Font.PLAIN, 18));
	        lbldate.setBounds(45, 225, 326, 40);
	        contentPane.add(lbldate);
	        
	        JLabel lblnote = new JLabel("Note: Please check Condition of Book before returning book!");
			lblnote.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblnote.setForeground(Color.RED);
			lblnote.setBounds(100, 400,550 , 40);
	        contentPane.add(lblnote);
		
	        String[] da = {"Day"}; 
		    JComboBox<String> d = new JComboBox<>(da);
		    for (int dayCount = 01; dayCount <= 31; dayCount++)
	            d.addItem(Integer.toString(dayCount));
		    d.setBounds(290, 225, 100, 60);
		    contentPane.add(d);
		    
		    String[] m = {"Month"}; 
		    JComboBox<String> mo = new JComboBox<>(m);
		    for (int dayCount = 01; dayCount <= 12; dayCount++)
	            mo.addItem(Integer.toString(dayCount));
		    mo.setBounds(390, 225, 100, 60);
		    contentPane.add(mo);
		    
		    String[] y = {"Year"}; 
		    JComboBox<String> ye = new JComboBox<>(y);
		    for (int dayCount = 2022; dayCount >=1990; dayCount--)
	            ye.addItem(Integer.toString(dayCount));
		    ye.setBounds(490, 225, 100, 60);
		    contentPane.add(ye);
	        
		JButton btnReturnBook = new JButton("Return Book");
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			String bookid=TextField.getText();
			String studentid=TextField1.getText();
			String date= ye.getItemAt(ye.getSelectedIndex())+"-"+mo.getItemAt(mo.getSelectedIndex())+"-"+d.getItemAt(d.getSelectedIndex());
			if(Bookdetails.checkbook(bookid) ){
				if(Studentdetails.checkstudent(studentid) ) {
					if(ye.getItemAt(ye.getSelectedIndex()).equals("Year") || mo.getItemAt(mo.getSelectedIndex()).equals("Month") ||d.getItemAt(d.getSelectedIndex()).equals("Day") ) 
					{
						JOptionPane.showMessageDialog(Return.this,"Date Error !!\nSelect a valid date");
					}
					else {
					Bookdetails.returnbook(date,bookid,studentid);
					JOptionPane.showMessageDialog(Return.this,"Book Returned successfully!");
					System.out.println("Book-ID : "+bookid+" returned by "+studentid+" successfully");
					}
				}
				else {
					JOptionPane.showMessageDialog(Return.this,"Error !!\nEnter a valid Roll Number");
				}

			}else{
				JOptionPane.showMessageDialog(Return.this,"Error !!\nEnter a valid Book-ID");
			}//end of checkbook if-else
			
			}
		});
		
		 JButton btnview = new JButton("View Returned Books");
	        btnview.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	 Viewreturn.main(new String[]{});
	            }});
	        btnview.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        btnview.setBackground(new Color(240, 240, 240));
	        btnview.setBounds(100, 305, 200, 50);
	        contentPane.add(btnview);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Menu.main(new String[]{});
				frame.dispose();
			}
		});
		
		btnReturnBook.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    btnReturnBook.setBackground(new Color(240, 240, 240));
	    btnReturnBook.setBounds(330, 305, 130, 50);
	    contentPane.add(btnReturnBook);
		
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    btnBack.setBackground(new Color(240, 240, 240));
	    btnBack.setBounds(490, 305, 130, 50);
	    contentPane.add(btnBack);
		
	}
}