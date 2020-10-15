package com.yaelaram;

import javax.swing.*;
import java.awt.event.*;

public class SystemConverter implements MouseListener, FocusListener, ActionListener {

    private final JFrame f;
    private JTextField fromTextField, toTextField, fromUnitTextField, toUnitTextField;
    private JButton convertButton, cleanButton;
    private JLabel alertDialog;
    private final ColorStyle colorStyle = new ColorStyle();

    public SystemConverter(){
        f = new JFrame();
        f.setBounds(180, 10, 750, 280);
        f.setLayout(null);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setTitle("System Converter");
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

        JLabel fromLabel = new JLabel("From:");
        fromLabel.setBounds(20, 95, 40, 30);
        labelStyle(fromLabel, ColorStyle.SECONDARY_LABEL_FLAG);
        f.add(fromLabel);

        fromUnitTextField = new JTextField();
        fromUnitTextField.setBounds(70, 55, 130, 30);
        fromUnitTextField.setEditable(false);
        fromUnitTextField.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldStyle(fromUnitTextField, ColorStyle.INACTIVE_TEXT_FIELD_FLAG);
        f.add(fromUnitTextField);

        JLabel toLabel = new JLabel("To:");
        toLabel.setBounds(220, 95, 40, 30);
        labelStyle(toLabel, ColorStyle.SECONDARY_LABEL_FLAG);
        f.add(toLabel);

        toUnitTextField = new JTextField();
        toUnitTextField.setBounds(250, 55, 130, 30);
        toUnitTextField.setEditable(false);
        toUnitTextField.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldStyle(toUnitTextField, ColorStyle.INACTIVE_TEXT_FIELD_FLAG);
        f.add(toUnitTextField);

        fromTextField = new JTextField();
        fromTextField.setBounds(70, 90, 130, 30);
        fromTextField.addFocusListener(this);
        fromTextField.addActionListener(this);
        fromTextField.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldStyle(fromTextField, ColorStyle.INACTIVE_TEXT_FIELD_FLAG);
        f.add(fromTextField);

        toTextField = new JTextField();
        toTextField.setBounds(250, 90, 130, 30);
        toTextField.addFocusListener(this);
        toTextField.addActionListener(this);
        toTextField.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldStyle(toTextField, ColorStyle.INACTIVE_TEXT_FIELD_FLAG);
        f.add(toTextField);

        convertButton = new JButton("Convert");
        convertButton.setBounds(425, 50, 220, 35);
        convertButton.addMouseListener(this);
        convertButton.addActionListener(this);
        buttonStyle(convertButton, ColorStyle.INACTIVE_BUTTON_FLAG);
        f.add(convertButton);

        cleanButton = new JButton("Clean");
        cleanButton.setBounds(425, 95, 220, 35);
        cleanButton.addActionListener(this);
        cleanButton.addMouseListener(this);
        buttonStyle(cleanButton, ColorStyle.INACTIVE_BUTTON_FLAG);
        f.add(cleanButton);

        alertDialog = new JLabel();
        alertDialog.setBounds(20, 190, 600, 30);
        alertDialogStyle(alertDialog, "");
        f.add(alertDialog);

        JButton decimalButton = new JButton("Decimal");
        decimalButton.setBounds(20, 140, 130, 35);
        decimalButton.addMouseListener(this);
        decimalButton.addActionListener(this);
        decimalButton.setName("DECIMAL");
        buttonStyle(decimalButton, ColorStyle.INACTIVE_BUTTON_FLAG);
        f.add(decimalButton);

        JButton binaryButton = new JButton("Binary");
        binaryButton.setBounds(160, 140, 130, 35);
        binaryButton.addMouseListener(this);
        binaryButton.addActionListener(this);
        binaryButton.setName("BINARY");
        buttonStyle(binaryButton, ColorStyle.INACTIVE_BUTTON_FLAG);
        f.add(binaryButton);

        JButton quarterButton = new JButton("Quaternary");
        quarterButton.setBounds(300, 140, 130, 35);
        quarterButton.addMouseListener(this);
        quarterButton.addActionListener(this);
        quarterButton.setName("QUATERNARY");
        buttonStyle(quarterButton, ColorStyle.INACTIVE_BUTTON_FLAG);
        f.add(quarterButton);

        JButton octaButton = new JButton("Octal");
        octaButton.setBounds(440, 140, 130, 35);
        octaButton.addMouseListener(this);
        octaButton.addActionListener(this);
        octaButton.setName("OCTAL");
        buttonStyle(octaButton, ColorStyle.INACTIVE_BUTTON_FLAG);
        f.add(octaButton);

        JButton hexButton = new JButton("Hexadecimal");
        hexButton.setBounds(580, 140, 140, 35);
        hexButton.addMouseListener(this);
        hexButton.addActionListener(this);
        hexButton.setName("HEXADECIMAL");
        buttonStyle(hexButton, ColorStyle.INACTIVE_BUTTON_FLAG);
        f.add(hexButton);
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
            if(evt.getSource() == cleanButton){
                fromTextField.setText("");
                fromUnitTextField.setText("");
                toTextField.setText("");
                toUnitTextField.setText("");
                alertDialogStyle(alertDialog, "");
                textFieldStyle(fromUnitTextField, ColorStyle.INACTIVE_TEXT_FIELD_FLAG);
                textFieldStyle(toUnitTextField, ColorStyle.INACTIVE_TEXT_FIELD_FLAG);
            }
            else if(evt.getSource() == convertButton){
                alertDialogStyle(alertDialog, "Solving...");
            }
            else{
                JButton jButton = (JButton)evt.getSource();
                if(fromUnitTextField.getText().isEmpty() || fromUnitTextField.getText().isBlank()){
                    fromUnitTextField.setText(jButton.getName());
                    textFieldStyle(fromUnitTextField, ColorStyle.ACTIVE_TEXT_FIELD_FLAG);
                }
                else if(toUnitTextField.getText().isEmpty() || toUnitTextField.getText().isBlank()){
                    toUnitTextField.setText(jButton.getName());
                    textFieldStyle(toUnitTextField, ColorStyle.ACTIVE_TEXT_FIELD_FLAG);
                }
                else{
                    alertDialogStyle(alertDialog, "Clean the fields of units.");
                }
            }
        }
        catch (Exception e){
            System.out.println("System Converter Class Action Performed: " + e.getMessage());
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
            System.out.println("System Converter Class Focus Gained: " + e.getMessage());
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
            System.out.println("System Converter Class Focus Lost: " + e.getMessage());
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
            System.out.println("System Converter Class Mouse Entered: " + e.getMessage());
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
            System.out.println("System Converter Class Mouse Exited: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
