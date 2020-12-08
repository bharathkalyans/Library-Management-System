package com.library.management.system;

import javax.swing.*;
import java.awt.*;

public class readME extends JFrame{

   public  readME(){
       super("READ ME!!!");
       setBackground(new Color(173, 216, 230));
       setBounds(300, 140, 620, 500);
       setDefaultCloseOperation(EXIT_ON_CLOSE);

       JPanel contentPane = new JPanel();
       setContentPane(contentPane);
       contentPane.setLayout(null);


       JTextArea textArea=new JTextArea();
       textArea.setFont(new Font("MV Boli",Font.BOLD,16));
       textArea.setBounds(20,20,620,500);
       textArea.setText("Functionalities Provided by the Library Management System::\n" +
               "1. Provides the searching facilities based on various factors .Such as Student \n" +
               " Issues , Librarian’s and Books Issued.\n" +
               "2. Tracks all the information of Books and Librarians.\n" +
               "3. Manages the information of Books.\n" +
               "4. Shows the information and description of the Student and Issues.\n" +
               "5. Editing, Adding and Updating of Records is Improved which results in \n" +
               " proper Resource Management of Student Data.\n" +
               "6. Integration of all Records.\n ");
       contentPane.add(textArea);

       contentPane.setBackground(Color.WHITE);
    }


    public static void main(String[] args) { new readME().setVisible(true); }

}
