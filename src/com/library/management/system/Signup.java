package com.library.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import javax.swing.border.*;

public class Signup extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton b1, b2;
    private JComboBox<String> comboBox;

    public Signup() {

        setTitle("SignUp Form");
        setBounds(360, 150, 610, 410);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);

        JLabel lblUsername = new JLabel("Username :");
        lblUsername.setForeground(Color.DARK_GRAY);
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblUsername.setBounds(99, 86, 92, 26);
        contentPane.add(lblUsername);

        JLabel lblName = new JLabel("Name :");
        lblName.setForeground(Color.DARK_GRAY);
        lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblName.setBounds(99, 123, 92, 26);
        contentPane.add(lblName);

        JLabel lblPassword = new JLabel("Password :");
        lblPassword.setForeground(Color.DARK_GRAY);
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPassword.setBounds(99, 160, 92, 26);
        contentPane.add(lblPassword);

        JLabel lblAnswer = new JLabel("Answer :");
        lblAnswer.setForeground(Color.DARK_GRAY);
        lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAnswer.setBounds(99, 234, 92, 26);
        contentPane.add(lblAnswer);

        String [] securityQuestions={ "Your NickName?", "Your Lucky Number?",
                "Your child SuperHero?", "Your childhood Name ?" ,
                "Name of your Cat?","Favourite Colour?"};

        comboBox = new JComboBox<>(securityQuestions);
        comboBox.setBounds(265, 202, 148, 20);

        contentPane.add(comboBox);

        JLabel lblSecurityQuestion = new JLabel("Security Question :");
        lblSecurityQuestion.setForeground(Color.DARK_GRAY);
        lblSecurityQuestion.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblSecurityQuestion.setBounds(99, 197, 140, 26);
        contentPane.add(lblSecurityQuestion);

        textField1 = new JTextField();
        textField1.setBounds(265, 91, 148, 20);
        contentPane.add(textField1);
        textField1.setColumns(10);

        textField2 = new JTextField();
        textField2.setColumns(10);
        textField2.setBounds(265, 128, 148, 20);
        contentPane.add(textField2);

        textField3 = new JTextField();
        textField3.setColumns(10);
        textField3.setBounds(265, 165, 148, 20);
        contentPane.add(textField3);

        textField4 = new JTextField();
        textField4.setColumns(10);
        textField4.setBounds(265, 239, 148, 20);
        contentPane.add(textField4);

        b1 = new JButton("Create");
        b1.addActionListener(this);
        b1.setFont(new Font("Tahoma", Font.BOLD, 13));
        b1.setBounds(140, 289, 100, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFocusable(false);
        contentPane.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setFont(new Font("Tahoma", Font.BOLD, 13));
        b2.setBounds(300, 289, 100, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setFocusable(false);
        contentPane.add(b2);

        JPanel panel = new JPanel();
        panel.setForeground(new Color(34, 139, 34));
        panel.setBorder(new TitledBorder(
                            new LineBorder(
                                new Color(128, 128, 0), 2),
                            "Create-Account",
                                TitledBorder.LEADING,
                                TitledBorder.TOP,
                                null,
                                new Color(34, 139, 34))
        );
        panel.setBounds(31, 46, 476, 296);
        panel.setBackground(Color.WHITE);
        contentPane.add(panel);
    }

    public void actionPerformed(ActionEvent ae) {
        try{
            Conn con = new Conn();

            if(ae.getSource() == b1){
                String sql = "insert into account(username, name, password, sec_q, sec_ans) values(?, ?, ?, ?, ?)";
                PreparedStatement st = con.c.prepareStatement(sql);


                st.setString(1, textField1.getText());
                st.setString(2, textField2.getText());
                st.setString(3, textField3.getText());
                st.setString(4, (String) comboBox.getSelectedItem());
                st.setString(5, textField4.getText());

                try{
                    int i = st.executeUpdate();
                    if (i > 0){
                        JOptionPane.showMessageDialog(null, " Account Successfully Created");
                    }
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null,"Username not Available!!");
                }

                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
            }
            if(ae.getSource() == b2){
                this.setVisible(false);
                this.dispose();
                new Login_User().setVisible(true);

            }
        }catch(Exception e){
            System.out.println(e);
        }

    }

    public static void main(String[] args) { new Signup().setVisible(true); }
}
