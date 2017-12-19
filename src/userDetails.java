import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class userDetails  extends JFrame{
    private JPanel panel1;
    private JTextField txtame;
    private JTextField textcon;
    private JTextField txtEmail;
    private JTextField textgpa;
    private JButton colse;
    private JButton logout;
    private JLabel lblemail;
    private JLabel lblcontact;
    private JLabel lblgpa;
    private JLabel txtname;

    userDetails(){
        colse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public userDetails(String userName){
        setContentPane(panel1);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        txtname.setText(userName);

        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new KLN_FIS_Students().setVisible(true);
                setVisible(false);
            }
        });
    }

    /*public void insertDB(){
        String username = txtame.getText();
        String email =txtEmail.getText();
        String contactno = textcon.getText();
        String gpa = textgpa.getText();

    }*/
}
