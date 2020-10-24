package com.yaelaram;

import javax.swing.*;
import java.awt.event.*;

public class LogIn implements FocusListener, MouseListener, ActionListener {

    private final JFrame f;
    private final ColorStyle colorStyle = new ColorStyle();
    private JTextField userNameTextField;
    private JPasswordField userPasswordField;
    private JLabel alertDialog;

    public LogIn(){
        f = new JFrame();
        f.setBounds(100, 10, 340, 400);
        f.setLayout(null);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setTitle("Log In");
        f.setLocationRelativeTo(null);
        f.getContentPane().setBackground(colorStyle.getGreyDarkCool());
        start();
        f.setVisible(true);
    }

    //Initialize Method
    private void start(){
        JLabel title = new JLabel("Welcome to the LogIn");
        title.setBounds(50, 10, 250, 30);
        colorStyle.labelStyle(title, ColorStyle.PRIMARY_LABEL_FLAG);
        f.add(title);

        JLabel userNameLabel = new JLabel("UserName");
        userNameLabel.setBounds(35, 70, 150, 30);
        colorStyle.labelStyle(userNameLabel, ColorStyle.SECONDARY_LABEL_FLAG);
        f.add(userNameLabel);

        userNameTextField = new JTextField();
        userNameTextField.setBounds(35, 100, 250, 30);
        userNameTextField.addFocusListener(this);
        colorStyle.textFieldStyle(userNameTextField, ColorStyle.INACTIVE_TEXT_FIELD_FLAG);
        f.add(userNameTextField);

        JLabel userPasswordLabel = new JLabel("Password");
        userPasswordLabel.setBounds(35, 160, 150, 30);
        colorStyle.labelStyle(userPasswordLabel, ColorStyle.SECONDARY_LABEL_FLAG);
        f.add(userPasswordLabel);

        userPasswordField = new JPasswordField();
        userPasswordField.setBounds(35, 190, 250, 30);
        userPasswordField.addFocusListener(this);
        userPasswordField.addActionListener(this);
        colorStyle.passwordFieldStyle(userPasswordField, ColorStyle.INACTIVE_TEXT_FIELD_FLAG);
        f.add(userPasswordField);

        alertDialog = new JLabel();
        alertDialog.setBounds(35, 250, 250, 30);
        f.add(alertDialog);

        JButton logIn = new JButton("Log In");
        logIn.setBounds(35, 300, 250, 45);
        logIn.addMouseListener(this);
        logIn.addActionListener(this);
        colorStyle.buttonStyle(logIn, ColorStyle.INACTIVE_BUTTON_FLAG);
        f.add(logIn);
    }

    //Focus Event
    @Override
    public void focusGained(FocusEvent evt) {
        try{
            if(evt.getSource() == userNameTextField){
                JTextField jTextField = (JTextField) evt.getSource();
                colorStyle.textFieldStyle(jTextField, ColorStyle.ACTIVE_TEXT_FIELD_FLAG);
            }
            else{
                JPasswordField jPasswordField = (JPasswordField)evt.getSource();
                colorStyle.passwordFieldStyle(jPasswordField, ColorStyle.ACTIVE_TEXT_FIELD_FLAG);
            }
        }catch (Exception e){
            System.out.println("Error LogIn Class Focus Gained: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void focusLost(FocusEvent evt) {
        try{
            if(evt.getSource() == userNameTextField){
                JTextField jTextField = (JTextField)evt.getSource();
                colorStyle.textFieldStyle(jTextField, ColorStyle.INACTIVE_TEXT_FIELD_FLAG);
            }
            else{
                JPasswordField jPasswordField = (JPasswordField)evt.getSource();
                colorStyle.passwordFieldStyle(jPasswordField, ColorStyle.INACTIVE_TEXT_FIELD_FLAG);
            }
        }catch (Exception e){
            System.out.println("Error LogIn Class Focus Lost: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //Mouse Event
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent evt) {
        try{
            JButton jButton = (JButton)evt.getSource();
            colorStyle.buttonStyle(jButton, ColorStyle.ACTIVE_BUTTON_FLAG);
        }catch(Exception e){
            System.out.println("Error LogIn Class Mouse Entered: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void mouseExited(MouseEvent evt) {
        try{
            JButton jButton = (JButton)evt.getSource();
            colorStyle.buttonStyle(jButton, ColorStyle.INACTIVE_BUTTON_FLAG);
        }catch(Exception e){
            System.out.println("Error LogIn Class Mouse Exited: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //OnClick Event
    @Override
    public void actionPerformed(ActionEvent evt) {
        try{
            String userNameString = userNameTextField.getText();
            String userPasswordString = String.valueOf(userPasswordField.getPassword());
            if(!userNameString.isBlank() && !userNameString.isEmpty()){
                if(!userPasswordString.isBlank() && !userPasswordString.isEmpty()){
                    if(userNameString.equalsIgnoreCase("Manager")){
                        if(userPasswordString.equalsIgnoreCase("manager")){
                            f.dispose();
                            new Menu();
                        }
                        else{
                            colorStyle.alertDialogStyle(alertDialog, "Password is wrong.");
                        }
                    }
                    else{
                        colorStyle.alertDialogStyle(alertDialog, "Name user is wrong.");
                    }
                }
                else{
                    colorStyle.alertDialogStyle(alertDialog, "Please enter a password.");
                }
            }
            else {
                colorStyle.alertDialogStyle(alertDialog, "Please enter a user name.");
            }
        }
        catch (Exception e){
            System.out.println("Error Log In Class Action Performed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
