/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas_login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author ASUS
 */
public class GUI extends JFrame {
    JLabel lusername = new JLabel("Username: "); 
    JTextField fusername = new JTextField (15);
    JLabel lpassword = new JLabel("Password: ");
    JPasswordField fpassword = new JPasswordField(15);
    JButton blogin = new JButton("Login");
    JButton bcancel = new JButton("Cancel");
    JLabel lreguname = new JLabel ("Username: ");
    JTextField freguname = new JTextField (15);
    JLabel lregpassword = new JLabel("Password: ");
    JPasswordField fregpassword = new JPasswordField(15);
    JButton bregister = new JButton("Register");
    
    public GUI() {
       setTitle("Login");
       setSize(450, 150);
       
       setLayout(null);
       
       add(lusername);
       add(fusername);
       add(lpassword);
       add(fpassword);
       add(blogin);

       add(freguname);
       add(lreguname);
       add(lregpassword);
       add(fregpassword);
       add(bregister);
       
       lusername.setBounds(10, 10, 80, 20);
       fusername.setBounds(90, 10, 90, 20);
       lpassword.setBounds(10, 40, 80, 20);
       fpassword.setBounds(90, 40, 90, 20);
       blogin.setBounds(50, 70, 80, 20);
       lreguname.setBounds(230, 10, 80, 20);
       freguname.setBounds(310, 10, 90, 20);
       lregpassword.setBounds(230, 40, 80, 20);
       fregpassword.setBounds(310, 40, 90, 20);
       bregister.setBounds(270, 70, 100, 20);
       
       blogin.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent arg0) {
               Connector con = new Connector();
               String uname = fusername.getText();
               System.out.println(uname);
               if(con.chekUsername(uname) && uname != "" && con.chekLogin(uname ,String.valueOf(fpassword.getPassword()))){
                   JOptionPane.showMessageDialog(null, "Login Success");
               }else if(uname.isEmpty() || String.valueOf(fpassword.getPassword()).isEmpty()){
                   JOptionPane.showMessageDialog(null, "Tidak Boleh Kosong");
               }
               else if(!con.chekUsername(uname)){
                   JOptionPane.showMessageDialog(null, "Username Salah");
               }
               else{
                   JOptionPane.showMessageDialog(null, "Password Salah");
               }
           }
       });
       
       bregister.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent arg0) {
               Connector con = new Connector();
               String reguname = freguname.getText();
               String regpass = String.valueOf(fregpassword.getPassword());
               if(!reguname.isEmpty() && !regpass.isEmpty()){
                   con.insertData(reguname, regpass);
               }
               else if(reguname.isEmpty() || regpass.isEmpty()){
                   JOptionPane.showMessageDialog(null, "Tidak Boleh Kosong");
               }
           }
           
       });
       
       setVisible(true);
    }
}
