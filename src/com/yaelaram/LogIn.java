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
        labelStyle(title, ColorStyle.PRIMARY_LABEL_FLAG);
        f.add(title);

        JLabel userNameLabel = new JLabel("UserName");
        userNameLabel.setBounds(35, 70, 150, 30);
        labelStyle(userNameLabel, ColorStyle.SECONDARY_LABEL_FLAG);
        f.add(userNameLabel);

        userNameTextField = new JTextField();
        userNameTextField.setBounds(35, 100, 250, 30);
        userNameTextField.addFocusListener(this);
        textFieldStyle(userNameTextField, ColorStyle.INACTIVE_TEXT_FIELD_FLAG);
        f.add(userNameTextField);

        JLabel userPasswordLabel = new JLabel("Password");
        userPasswordLabel.setBounds(35, 160, 150, 30);
        labelStyle(userPasswordLabel, ColorStyle.SECONDARY_LABEL_FLAG);
        f.add(userPasswordLabel);

        userPasswordField = new JPasswordField();
        userPasswordField.setBounds(35, 190, 250, 30);
        userPasswordField.addFocusListener(this);
        passwordFieldStyle(userPasswordField, ColorStyle.INACTIVE_TEXT_FIELD_FLAG);
        f.add(userPasswordField);

        alertDialog = new JLabel();
        alertDialog.setBounds(35, 250, 250, 30);
        f.add(alertDialog);

        JButton logIn = new JButton("Log In");
        logIn.setBounds(35, 300, 250, 45);
        logIn.addMouseListener(this);
        logIn.addActionListener(this);
        buttonStyle(logIn, ColorStyle.INACTIVE_BUTTON_FLAG);
        f.add(logIn);
    }

    //Styling Methods
    private void labelStyle(JLabel jLabel, int flag){
        jLabel.setForeground(colorStyle.getWhite());
        if(ColorStyle.PRIMARY_LABEL_FLAG == flag){
            jLabel.setFont(colorStyle.getPrimaryFont());
        }
        else{
            jLabel.setFont(colorStyle.getSecondaryFont());
        }
    }

    private void textFieldStyle(JTextField jTextField, int flag){
        jTextField.setFont(colorStyle.getSecondaryFont());
        jTextField.setBackground(colorStyle.getGreyDarkCool());
        if(ColorStyle.INACTIVE_TEXT_FIELD_FLAG == flag){
            jTextField.setForeground(colorStyle.getGreyCool());
            jTextField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, colorStyle.getGreyCool()));
        }
        else{
            jTextField.setForeground(colorStyle.getWhite());
            jTextField.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, colorStyle.getOrange()));
        }
    }

    private void passwordFieldStyle(JPasswordField jPasswordField, int flag){
        jPasswordField.setFont(colorStyle.getSecondaryFont());
        jPasswordField.setBackground(colorStyle.getGreyDarkCool());
        if(ColorStyle.INACTIVE_TEXT_FIELD_FLAG == flag){
            jPasswordField.setForeground(colorStyle.getGreyCool());
            jPasswordField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, colorStyle.getGreyCool()));
        }
        else{
            jPasswordField.setForeground(colorStyle.getWhite());
            jPasswordField.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, colorStyle.getOrange()));
        }
    }

    private void buttonStyle(JButton jButton, int flag){
        if(ColorStyle.INACTIVE_BUTTON_FLAG == flag){
            jButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, colorStyle.getOrange()));
            jButton.setFont(colorStyle.getPrimaryFont());
            jButton.setForeground(colorStyle.getWhite());
            jButton.setBackground(colorStyle.getGreyDarkCool());
        }
        else{
            jButton.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, colorStyle.getOrange()));
            jButton.setFont(colorStyle.getPrimaryFont());
            jButton.setForeground(colorStyle.getWhite());
            jButton.setBackground(colorStyle.getOrange());
        }
    }

    private void alertDialogStyle(JLabel jLabel, String message){
        jLabel.setFont(colorStyle.getSecondaryFont());
        jLabel.setForeground(colorStyle.getWhite());
        jLabel.setText(message);
    }

    //Focus Event
    @Override
    public void focusGained(FocusEvent evt) {
        try{
            if(evt.getSource() == userNameTextField){
                JTextField jTextField = (JTextField) evt.getSource();
                textFieldStyle(jTextField, ColorStyle.ACTIVE_TEXT_FIELD_FLAG);
            }
            else{
                JPasswordField jPasswordField = (JPasswordField)evt.getSource();
                passwordFieldStyle(jPasswordField, ColorStyle.ACTIVE_TEXT_FIELD_FLAG);
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
                textFieldStyle(jTextField, ColorStyle.INACTIVE_TEXT_FIELD_FLAG);
            }
            else{
                JPasswordField jPasswordField = (JPasswordField)evt.getSource();
                passwordFieldStyle(jPasswordField, ColorStyle.INACTIVE_TEXT_FIELD_FLAG);
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
            buttonStyle(jButton, ColorStyle.ACTIVE_BUTTON_FLAG);
        }catch(Exception e){
            System.out.println("Error LogIn Class Mouse Entered: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void mouseExited(MouseEvent evt) {
        try{
            JButton jButton = (JButton)evt.getSource();
            buttonStyle(jButton, ColorStyle.INACTIVE_BUTTON_FLAG);
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
                    if(userNameString.equals("Manager")){
                        if(userPasswordString.equals("manager")){
                            f.dispose();
                            new Menu();
                        }
                        else{
                            alertDialogStyle(alertDialog, "Password is wrong.");
                        }
                    }
                    else{
                        alertDialogStyle(alertDialog, "Name user is wrong.");
                    }
                }
                else{
                    alertDialogStyle(alertDialog, "Please enter a password.");
                }
            }
            else {
                alertDialogStyle(alertDialog, "Please enter a user name.");
            }
        }
        catch (Exception e){
            System.out.println("Error Log In Class Action Performed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
