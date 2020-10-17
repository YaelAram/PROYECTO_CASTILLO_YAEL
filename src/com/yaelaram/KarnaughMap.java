package com.yaelaram;

import javax.swing.*;
import java.awt.event.*;

public class KarnaughMap implements MouseListener, FocusListener, ActionListener {

    private final JFrame f;
    private JTextField numVariable;
    private JButton createTable, clean, calculate;
    private JLabel alertDialog;
    private final ColorStyle colorStyle = new ColorStyle();

    public KarnaughMap(){
        f = new JFrame();
        f.setBounds(180, 10, 720, 700);
        f.setLayout(null);
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.setTitle("Karnaugh Map");
        f.setLocationRelativeTo(null);
        f.getContentPane().setBackground(colorStyle.getGreyDarkCool());
        start();
        f.setVisible(true);
    }

    private void start(){
        JLabel title = new JLabel("System Converter");
        title.setBounds(250, 10, 250, 30);
        labelStyle(title, ColorStyle.PRIMARY_LABEL_FLAG);
        f.add(title);

        JLabel numVariableLabel = new JLabel("#Variables");
        numVariableLabel.setBounds(20, 40, 100, 30);
        labelStyle(numVariableLabel, ColorStyle.SECONDARY_LABEL_FLAG);
        f.add(numVariableLabel);

        numVariable = new JTextField();
        numVariable.setBounds(20, 65, 100, 30);
        numVariable.addFocusListener(this);
        textFieldStyle(numVariable, ColorStyle.INACTIVE_TEXT_FIELD_FLAG);
        f.add(numVariable);

        createTable = new JButton("Create Table");
        createTable.setBounds(160, 60, 150, 40);
        createTable.setFocusable(false);
        createTable.addMouseListener(this);
        createTable.addActionListener(this);
        buttonStyle(createTable, ColorStyle.INACTIVE_BUTTON_FLAG);
        f.add(createTable);

        calculate = new JButton("Calculate");
        calculate.setBounds(340, 60, 150, 40);
        calculate.setFocusable(false);
        calculate.addMouseListener(this);
        calculate.addActionListener(this);
        buttonStyle(calculate, ColorStyle.INACTIVE_BUTTON_FLAG);
        f.add(calculate);

        clean = new JButton("Clean");
        clean.setBounds(520, 60, 150, 40);
        clean.setFocusable(false);
        clean.addMouseListener(this);
        clean.addActionListener(this);
        buttonStyle(clean, ColorStyle.INACTIVE_BUTTON_FLAG);
        f.add(clean);

        alertDialog = new JLabel();
        alertDialog.setBounds(20, 120, 680, 30);
        alertDialogStyle(alertDialog, "");
        f.add(alertDialog);
    }

    //Styling Method
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

    //OnClick Event
    @Override
    public void actionPerformed(ActionEvent evt) {
        try{
            if(evt.getSource() == clean){
                numVariable.setText("");
                alertDialogStyle(alertDialog, "");
            }
            if(evt.getSource() == createTable){
                alertDialogStyle(alertDialog,"Creating table with " + numVariable.getText() + " variables...");
            }
            if(evt.getSource() == calculate){
                alertDialogStyle(alertDialog, "Solving...");
            }
        }
        catch (Exception e){
            System.out.println("Karnaugh Map Class Action Performed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //Focus Events
    @Override
    public void focusGained(FocusEvent evt) {
        try{
            JTextField jTextField = (JTextField)evt.getSource();
            textFieldStyle(jTextField, ColorStyle.ACTIVE_TEXT_FIELD_FLAG);
        }
        catch (Exception e){
            System.out.println("Karnaugh Map Class Focus Gained: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void focusLost(FocusEvent evt) {
        try{
            JTextField jTextField = (JTextField)evt.getSource();
            textFieldStyle(jTextField, ColorStyle.INACTIVE_TEXT_FIELD_FLAG);
        }
        catch (Exception e){
            System.out.println("Karnaugh Map Class Focus Lost: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //Mouse Events
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
        }
        catch (Exception e){
            System.out.println("Karnaugh Map Class Mouse Enter: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void mouseExited(MouseEvent evt) {
        try{
            JButton jButton = (JButton)evt.getSource();
            buttonStyle(jButton, ColorStyle.INACTIVE_BUTTON_FLAG);
        }
        catch (Exception e){
            System.out.println("Karnaugh Map Class Mouse Exited: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
