import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

import DBConnect.*;

public class KLN_FIS_Students extends userDetails {
    private JPanel panel1;
    private JTextField textusername;
    private JTextField textEmail;
    private JTextField textuserid;
    private JButton btnexit;
    private JButton btninsert;
    private JPasswordField txtpw;

    public KLN_FIS_Students(){
        setContentPane(panel1);
        pack();
        btnexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });




        btninsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertDB();
            }
        });
    }

    public KLN_FIS_Students(String userName) {
        super(userName);
    }


    public void insertDB(){
        String username = textusername.getText();
        String email =textEmail.getText();
        String pw= String.valueOf(txtpw.getPassword());
        String userID = textuserid.getText();
        System.out.println("values "+username+" "+email+" "+pw+" "+userID);
        String query="Insert into userdetails values("+userID+","+username+","+email+","+pw+",5)";
        System.out.println(query);

        dbConnect DB =new dbConnect();
        Statement stmt = null;
        try {
            stmt = DB.Conn2DB();
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Data stored Successfully");
        }catch (SQLException se)
        {
            se.printStackTrace();
        }
    }
}
