import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class S1 extends JFrame {//implements ActionListener{
    JLabel L1,L2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;
    JPanel p1;
            
    public S1()
    {
        setVisible(true);
        setSize(350,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        L1 = new JLabel("User Name");
        L2 = new JLabel("Password");
        
        t1 = new JTextField(20);
        t2 = new JPasswordField(20);
        b1 = new JButton("Login");
        b2 = new JButton("Cancel");
        p1 = new JPanel();
        p1.add(L1);
        p1.add(t1);
        p1.add(L2);
        p1.add(t2);
        p1.add(b1);
        p1.add(b2);
        getContentPane().add(p1);
        
        setSize(351,150);
        setResizable(false);
        
        setTitle("Login Window");
        setBounds(100, 100, 351, 150);
    
    b1.addActionListener(e -> actionb1(e));
    b2.addActionListener(e -> actionb2(e));
    }
    public void actionb1(ActionEvent e)
    {
       try
       {
           RandomAccessFile file = new RandomAccessFile(
                   "e:\\userlog.txt", "rw");
           String msg = "user :"+t1.getText()+" logged in "
                   +   new java.util.Date();
           file.seek(file.length());
           file.writeBytes(msg);
           file.close();
       }
       catch(IOException ex)
       {
       } 
    }
    
    public void actionb2(ActionEvent e)
    {
      System.exit(0);
    }
    
  /*  public void actionPerformed(ActionEvent e)
    {if(e.getSource()==b1){
        System.out.println("Login");
    }
    else
    {
        System.exit(0);
    }
    }*/
    public static void main(String args[])
    {
        new S1();
    }
}
