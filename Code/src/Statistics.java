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

public class Statistics extends JFrame{
	private static final long serialVersionUID = 1L;
	static Statistics frame;
	private JPanel contentPane;
	private JTextField TextField_1;
	private JTextArea TextField_2;
	
	public static void main(String [] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
					try {
							frame = new Statistics();
							frame.setTitle("Statistics");
							frame.setVisible(true);
						}
					catch(Exception e){
							e.printStackTrace();
					}
			}
	});
	}
	public Statistics() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(110, 95, 670, 600);
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
        TextField_1.setBounds(240, 260, 400, 40);
        contentPane.add(TextField_1);
        TextField_1.setColumns(10);
        TextField_1.setVisible(false);
        TextField_1.setEditable(false);
        
        TextField_2 = new JTextArea();
        TextField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextField_2.setBounds(240, 320, 400, 100);
        contentPane.add(TextField_2);
        TextField_2.setColumns(10);
        TextField_2.setVisible(false);
        TextField_2.setEditable(false);
        
		TextField_1.setText("");
		TextField_2.setText("");
		
		
		
		JLabel lblStatisticss = new JLabel("-- Statistics --");
        lblStatisticss.setFont(new Font("American Typewriter", Font.BOLD, 42));
        lblStatisticss.setForeground(Color.DARK_GRAY);
        lblStatisticss.setBounds(180, 30, 326, 60);
        contentPane.add(lblStatisticss);
        
        JLabel lblName = new JLabel();
        lblName.setFont(new Font("Big Calson", Font.PLAIN, 18));
        lblName.setBounds(45, 260, 326, 40);
        contentPane.add(lblName);
		JLabel lblAuthor = new JLabel();
        lblAuthor.setFont(new Font("Big Calson", Font.PLAIN, 18));
        lblAuthor.setBounds(45, 310, 326, 40);
        contentPane.add(lblAuthor);
        
		JLabel lblbookid = new JLabel("Show By : ");
        lblbookid.setFont(new Font("Big Calson", Font.PLAIN, 18));
        lblbookid.setBounds(45, 125, 326, 40);
        contentPane.add(lblbookid);
		
        JButton btnBac = new JButton("Clear");
   			btnBac.addActionListener(new ActionListener() {
   				public void actionPerformed(ActionEvent e1) {
   					TextField_1.setText("");
   					TextField_2.setText("");
   					TextField_1.setVisible(false);
   				    jComboBox.setSelectedIndex(0);
   					TextField_2.setVisible(false);
   					lblAuthor.setVisible(false);
   					lblName.setVisible(false);
   					btnBac.setVisible(false);
   				}
   				});
   			  btnBac.setFont(new Font("Tahoma", Font.PLAIN, 20));
   		        btnBac.setBackground(new Color(240, 240, 240));
   		        btnBac.setBounds(450, 500, 130, 50);
   		        contentPane.add(btnBac);
   		     btnBac.setVisible(false);
   		        
        
		JButton btnStatistics = new JButton("Submit");
		btnStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = jComboBox.getItemAt(jComboBox.getSelectedIndex());
				if(item.equals("      ---- Select ----")) {
					JOptionPane.showMessageDialog(Statistics.this,"Error !!\n Please Select an Option !");
				}
				else {
					if(item.equals("Book")) {
				        lblName.setText("Most Lended Book :");
						lblAuthor.setText("Lended By :");
						TextField_1.setVisible(true);
						TextField_2.setText("");
						TextField_2.setVisible(true);
						btnBac.setVisible(true);
						try{  
							Connection con=SQLCon.getConnection();
							PreparedStatement ps=con.prepareStatement("select title from book where bookid = (SELECT bookid FROM issue  GROUP BY bookid  ORDER BY count(*) DESC LIMIT 1)",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
							//step4 execute query  
							ResultSet rs=ps.executeQuery();  
							String r = null;
							while(rs.next())  
								TextField_1.setText(rs.getString(1));  
							String S = TextField_1.getText();
						PreparedStatement ps2=con.prepareStatement("select bookid from book where title ='"+S+"'",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
						//step4 execute query  
						ResultSet rs2=ps2.executeQuery();  
							while(rs2.next())  
								r = rs2.getString(1);  
							PreparedStatement ps1=con.prepareStatement("select name from students where rollno in (SELECT rollno from issue where bookid = '"+r+"')",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
							//step4 execute query  
							ResultSet rs1=ps1.executeQuery();  
							while(rs1.next())  
									TextField_2.append(rs1.getString(1)+"\n");  
							con.close();  
							  
							}catch(Exception e1){ System.out.println(e1);}  
							  
					        
					}
					else {
						lblName.setText("Most Active Student :");
						lblAuthor.setText("Books Lended :");
						TextField_1.setVisible(true);
						TextField_2.setVisible(true);
						btnBac.setVisible(true);
						TextField_2.setText("");
						try{  
							Connection con=SQLCon.getConnection();
							PreparedStatement ps=con.prepareStatement("select name from students where rollno = (SELECT rollno FROM issue  GROUP BY rollno  ORDER BY count(*) DESC LIMIT 1)",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
							//step4 execute query  
							ResultSet rs=ps.executeQuery();  
							String r = null;
							while(rs.next())  
								TextField_1.setText(rs.getString(1));  
							String S = TextField_1.getText();
						PreparedStatement ps2=con.prepareStatement("select rollno from students  where name ='"+S+"'",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
						//step4 execute query  
						ResultSet rs2=ps2.executeQuery();  
							while(rs2.next())  
								r = rs2.getString(1);  
							PreparedStatement ps1=con.prepareStatement("select title from book where bookid in (SELECT bookid from issue where rollno = '"+r+"')",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
							//step4 execute query  
							ResultSet rs1=ps1.executeQuery();  
							while(rs1.next())  
									TextField_2.append(rs1.getString(1)+"\n");  
							con.close();  
							  
							}catch(Exception e1){ System.out.println(e1);}    
						}
					}
			}
		});
		btnStatistics.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnStatistics.setBackground(new Color(0,0, 0));
        btnStatistics.setBounds(300, 200, 130, 50);
        contentPane.add(btnStatistics);

		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				Menu.main(new String[]{});
				frame.dispose();
			}
			});
		  btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        btnBack.setBackground(new Color(240, 240, 240));
	        btnBack.setBounds(450, 200, 130, 50);
	        contentPane.add(btnBack);
	    
	}

}
