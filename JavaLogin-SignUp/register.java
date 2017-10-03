import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;


class Register{
     public static void main(String[] args) {
        

        JFrame frame = new JFrame();
        frame.setBounds(300,100,750,500);
        frame.setTitle("Register");
        frame.setLayout(null);

        //ImageIcon icon = new ImageIcon("./icon1.jpg");
        //frame.setIconImage(icon.getImage());

        JLabel label1 = new JLabel("Create UserName:");
        label1.setBounds(100,50,150,30);
        frame.add(label1);

        JLabel label2 = new JLabel("Create Password:");
        label2.setBounds(100,85,150,30);
        frame.add(label2);


        JTextField t1 = new JTextField();
        t1.setBounds(250,50,200,30);
        frame.add(t1);

        JPasswordField pass = new JPasswordField();
        pass.setBounds(250,85,200,30);
        frame.add(pass);

        JButton btn = new JButton("Register");
        btn.setBounds(200,130,100,30);
        frame.add(btn);
        btn.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                
                 String url = "jdbc:mysql://localhost:3306/practicals";
                 String user = "root";
                 String password = "Saraswat@123";
                 String s1 = t1.getText();
                 String s2 = pass.getText();
                  try {
                         Connection con = DriverManager.getConnection(url, user, password);
                         System.out.println("Success");
                         PreparedStatement ps = con.prepareStatement("insert into register values(?,?)");
                         ps.setString(1, s1);
                         ps.setString(2, s2);
                         ps.executeUpdate();
                         JOptionPane.showMessageDialog(null,"Register successfull");

                      } catch (Exception e1) {
                                                 e1.printStackTrace();

                                             }  
          }
          });     
          
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
     }
    
}