import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*; 

class Login{
     public static void main(String[] args) {
        

        JFrame frame = new JFrame();
        frame.setBounds(300,100,750,500);
        frame.setTitle("Login");
        frame.setLayout(null);

        JLabel label1 = new JLabel("UserName :");
        label1.setBounds(100,50,100,30);
        frame.add(label1);

        JLabel label2 = new JLabel("Password  :");
        label2.setBounds(100,85,100,30);
        frame.add(label2);


        JTextField t1 = new JTextField();
        t1.setBounds(200,50,200,30);
        frame.add(t1);

        JPasswordField pass = new JPasswordField();
        pass.setBounds(200,85,200,30);
        frame.add(pass);

        JButton btn = new JButton("LOGIN");
        btn.setBounds(180,130,80,30);
        btn.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                   
                   String url = "jdbc:mysql://localhost:3306/practicals";
                   String user = "root";
                   String password = "***********"; 
                   String s1 = t1.getText();
                   String s2 = pass.getText(); 
                   try {
                         Connection con = DriverManager.getConnection(url, user, password);
                         System.out.println("Success");
                         PreparedStatement ps = con.prepareStatement("select * from register where username = ? ");
                         ps.setString(1, s1);
                         ResultSet rs = ps.executeQuery();

                         if(rs.next()){
                         	if(s2.equals(rs.getString(2))){
                         		JOptionPane.showMessageDialog(null,"login successfull");
                         	}else{
                         		JOptionPane.showMessageDialog(null,"login UNsuccessfull");
                         	}
                         	
                         }

                      } catch (Exception e1) {
                                                 e1.printStackTrace();

                                             } 

        }  
      });     
        frame.add(btn);
        

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
     }
	
}
