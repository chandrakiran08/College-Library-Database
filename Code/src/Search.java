import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Search extends JFrame{
	private static final long serialVersionUID = 1L;
	static Search frame;
	private JPanel contentPane;
	private JTextField TextField_1;
	private JTextField TextField_2;
	private JTextField TextField_3;
	private JTextArea TextField_5;
	private JTextArea TextField_4;
	
	public static void main(String [] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
					try {
							frame = new Search();
							frame.setTitle("Search");
							frame.setVisible(true);
						}
					catch(Exception e){
							e.printStackTrace();
					}
			}
	});
	}
	public Search() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(110, 30, 700, 900);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        

	    String[] op = {"      ---- Select ----","Book","Student"}; ;
	    JComboBox<String> jComboBox = new JComboBox<>(op);
	    jComboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    jComboBox.setSelectedIndex(0);
	    jComboBox.setBounds(240, 100, 326, 100);
	    contentPane.add(jComboBox);
	    
        TextField_1 = new JTextField();
        TextField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextField_1.setBounds(240, 200, 400, 40);
        contentPane.add(TextField_1);
        TextField_1.setColumns(10);

        TextField_2 = new JTextField();
        TextField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextField_2.setBounds(240, 370, 400, 40);
        contentPane.add(TextField_2);
        TextField_2.setColumns(10);
        TextField_2.setVisible(false);
        
        TextField_3 = new JTextField();
        TextField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextField_3.setBounds(240, 430, 400, 40);
        contentPane.add(TextField_3);
        TextField_3.setColumns(10);
        TextField_3.setVisible(false);
        
        TextField_4 = new JTextArea();
        TextField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextField_4.setBounds(240, 490, 400, 100);
        contentPane.add(TextField_4);
        TextField_4.setColumns(10);
       TextField_4.setVisible(false);
        
        TextField_5 = new JTextArea();
        TextField_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextField_5.setBounds(240, 640, 400, 100);
        contentPane.add(TextField_5);
        TextField_5.setColumns(10);
       TextField_5.setVisible(false);

		TextField_1.setText("");
		TextField_2.setText("");
		TextField_3.setText("");
		TextField_4.setText("");
		TextField_5.setText("");
		
		
		
		JLabel lblSearchs = new JLabel("-- Search --");
        lblSearchs.setFont(new Font("American Typewriter", Font.BOLD, 42));
        lblSearchs.setForeground(Color.DARK_GRAY);
        lblSearchs.setBounds(180, 50, 326, 60);
        contentPane.add(lblSearchs);
        
        JLabel lblName = new JLabel("ID : ");
        lblName.setFont(new Font("Big Calson", Font.PLAIN, 18));
        lblName.setBounds(45, 200, 326, 40);
        contentPane.add(lblName);
        
        JLabel lblNam = new JLabel();
        lblNam.setFont(new Font("Big Calson", Font.PLAIN, 18));
        lblNam.setBounds(45, 370, 326, 40);
        contentPane.add(lblNam);
        
        JLabel lblAuthor = new JLabel();
        lblAuthor.setFont(new Font("Big Calson", Font.PLAIN, 18));
        lblAuthor.setBounds(45, 430, 326, 40);
        contentPane.add(lblAuthor);
        
        JLabel lblissue = new JLabel();
        lblissue.setFont(new Font("Big Calson", Font.PLAIN, 18));
        lblissue.setBounds(45, 490, 326, 40);
        contentPane.add(lblissue);
        
        JLabel lblreturn = new JLabel();
        lblreturn.setFont(new Font("Big Calson", Font.PLAIN, 18));
        lblreturn.setBounds(45, 640, 326, 40);
        contentPane.add(lblreturn);
        
		JLabel lblbookid = new JLabel("Search By : ");
        lblbookid.setFont(new Font("Big Calson", Font.PLAIN, 18));
        lblbookid.setBounds(45, 125, 326, 40);
        contentPane.add(lblbookid);
		
        JButton btnBac = new JButton("Clear");
   			btnBac.addActionListener(new ActionListener() {
   				public void actionPerformed(ActionEvent e1) {
   					TextField_2.setText("");
   					TextField_3.setText("");
   					TextField_4.setText("");
   					TextField_5.setText("");
   					TextField_1.setText("");
   				    jComboBox.setSelectedIndex(0);
   					TextField_2.setVisible(false);
   					TextField_3.setVisible(false);
   					TextField_4.setVisible(false);
   					TextField_5.setVisible(false);
   					lblAuthor.setText("");
   					btnBac.setVisible(false);
   					lblreturn.setText("");
   					lblissue.setText("");
   					lblNam.setText("");
   				}
   				});
   			  btnBac.setFont(new Font("Tahoma", Font.PLAIN, 20));
   		        btnBac.setBackground(new Color(240, 240, 240));
   		        btnBac.setBounds(450, 780, 130, 50);
   		        contentPane.add(btnBac);
   		    btnBac.setVisible(false);
   		        
        
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = jComboBox.getItemAt(jComboBox.getSelectedIndex());
				if(item.equals("      ---- Select ----" ) || TextField_1.getText().equals("")){
					JOptionPane.showMessageDialog(Search.this,"Error !!\n Please Select an Option !");
				}
				else {
					if(item.equals("Book")) {
						if(Bookdetails.checkbook(TextField_1.getText())) {
						lblAuthor.setText("Author :");
						lblNam.setText("Title :");
						lblissue.setText("Lended By : ");
						lblreturn.setText("Returned By : ");
						TextField_2.setVisible(true);
						TextField_3.setVisible(true);
						TextField_4.setVisible(true);
						TextField_5.setVisible(true);
						TextField_4.setText("");
						TextField_5.setText("");
						btnBac.setVisible(true);
						try{  
							Connection con=SQLCon.getConnection();
							PreparedStatement ps=con.prepareStatement("select title,author from book where bookid = '"+TextField_1.getText()+"'",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
							ResultSet rs=ps.executeQuery();  
							String r = null;
							while(rs.next())  {
								TextField_2.setText(rs.getString(1));
								TextField_3.setText(rs.getString(2));  
							}
							String S = TextField_1.getText();
							PreparedStatement ps1=con.prepareStatement("select name from students where rollno in (SELECT rollno from issue where bookid = '"+S+"')",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE); 
							ResultSet rs1=ps1.executeQuery();  
							while(rs1.next())  
									TextField_4.append(rs1.getString(1)+"\n");  
							PreparedStatement ps2=con.prepareStatement("select name from students where rollno in (SELECT rollno from breturn where bookid = '"+S+"')",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
							ResultSet rs2=ps2.executeQuery();  
							while(rs2.next())  
									TextField_5.append(rs2.getString(1)+"\n");  
							
							con.close();  
							  
							}catch(Exception e1){ System.out.println(e1);}  
							  
						}else {
							JOptionPane.showMessageDialog(Search.this,"Error !!\n Book-ID not found !");
						} 
					}
					else {
						if(Studentdetails.checkstudent(TextField_1.getText())){
							lblAuthor.setText("Branch :");
							lblNam.setText("Name :");
							lblissue.setText("Books Lended : ");
							lblreturn.setText("Books Returned : ");
							TextField_2.setVisible(true);
							TextField_3.setVisible(true);
							TextField_4.setVisible(true);
							TextField_5.setVisible(true);
							TextField_4.setText("");
							TextField_5.setText("");
							btnBac.setVisible(true);
							try{  
								Connection con=SQLCon.getConnection();
								PreparedStatement ps=con.prepareStatement("select name,branch from students where rollno = '"+TextField_1.getText()+"'",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
								ResultSet rs=ps.executeQuery();  
								String r = null;
								while(rs.next())  {
									TextField_2.setText(rs.getString(1));
									TextField_3.setText(rs.getString(2));  
								}
								String S = TextField_1.getText();
								PreparedStatement ps1=con.prepareStatement("select title from book where bookid in (SELECT bookid from issue where rollno = '"+S+"')",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE); 
								ResultSet rs1=ps1.executeQuery();  
								while(rs1.next())  
										TextField_4.append(rs1.getString(1)+"\n");  
								PreparedStatement ps2=con.prepareStatement("select title from book where bookid in (SELECT bookid from breturn where rollno = '"+S+"')",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
								ResultSet rs2=ps2.executeQuery();  
								while(rs2.next())  
										TextField_5.append(rs2.getString(1)+"\n");  
								
								con.close();  
							  
							}catch(Exception e1){ System.out.println(e1);}    
						}else {
							JOptionPane.showMessageDialog(Search.this,"Error !!\n Student-ID not Found !");
						}
						}
					
					}
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnSearch.setBackground(new Color(0,0, 0));
        btnSearch.setBounds(300, 290, 130, 50);
        contentPane.add(btnSearch);

		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				Menu.main(new String[]{});
				frame.dispose();
			}
			});
		  btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        btnBack.setBackground(new Color(240, 240, 240));
	        btnBack.setBounds(450, 290, 130, 50);
	        contentPane.add(btnBack);
	    
	}

}
