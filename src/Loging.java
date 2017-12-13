import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import DBConnect.*;

public class Loging {
    private JPanel panel1;
    private JTextField userField1;
    private JPasswordField pwField1;
    private JButton exitButton;
    private JButton loginButton;

    public static JFrame loginFR= new JFrame("Loging");


    public Loging() {
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField1.getText();
                String pw= String.valueOf(pwField1.getPassword());
               // JOptionPane.showMessageDialog(null,username+"System not ready yet");
            logincheck(username,pw);
            }
        });
    }

    public static void main(String[] args){
        loginFR.setContentPane(new Loging().panel1);
        loginFR.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        loginFR.pack();
        loginFR.setVisible(true);
    }
    private void logincheck(String frUsername,String frPW){
        String inPW=null;
        String inUsername=null;
        dbConnect dbcon = new dbConnect();
        Statement stml=null;
        try{
            String query="Select * from userdetails where UserName='"+frUsername+"'";
            stml =dbcon.Conn2DB();
            ResultSet Rs= stml.executeQuery(query);
            Rs.first();
            inUsername=frUsername;
            inPW= Rs.getString("Password");

        }catch (SQLException e) {
            e.printStackTrace();
        }

        //String inUsername="COSC";
       // String inPw="22035";
        if(frUsername.equals(inUsername)&& frPW.equals(inPW)) {
            JOptionPane.showMessageDialog(null, "Username and password is correct");
            loginFR.setVisible(false);
            new userDetails(frUsername);

        } else JOptionPane.showMessageDialog(null,"password or username incorrect");
    }
}
