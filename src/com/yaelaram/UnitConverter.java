package com.yaelaram;

import javax.swing.*;
import java.awt.event.*;

public class UnitConverter implements MouseListener, FocusListener, ActionListener {

    private final JFrame f;
    private JTextField fromTextField, toTextField, fromUnitTextField, toUnitTextField;
    private JButton convertButton, cleanButton;
    private JLabel alertDialog;
    private final ColorStyle colorStyle = new ColorStyle();

    public UnitConverter(){
        f = new JFrame();
        f.setBounds(180, 10, 700, 280);
        f.setLayout(null);
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.setTitle("Unit Converter");
        f.setLocationRelativeTo(null);
        f.getContentPane().setBackground(colorStyle.getGreyDarkCool());
        start();
        f.setVisible(true);
    }

    private void start(){
        JLabel title = new JLabel("Unit Converter");
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

        JButton bitButton = new JButton("Bit");
        bitButton.setBounds(20, 140, 50, 35);
        bitButton.addMouseListener(this);
        bitButton.addActionListener(this);
        bitButton.setName("BIT");
        buttonStyle(bitButton, ColorStyle.INACTIVE_BUTTON_FLAG);
        f.add(bitButton);

        JButton nibbleButton = new JButton("Nib");
        nibbleButton.setBounds(80, 140, 50, 35);
        nibbleButton.addMouseListener(this);
        nibbleButton.addActionListener(this);
        nibbleButton.setName("Nibble");
        buttonStyle(nibbleButton, ColorStyle.INACTIVE_BUTTON_FLAG);
        f.add(nibbleButton);

        JButton byteButton = new JButton("B");
        byteButton.setBounds(140, 140, 50, 35);
        byteButton.addMouseListener(this);
        byteButton.addActionListener(this);
        byteButton.setName("Bit");
        buttonStyle(byteButton, ColorStyle.INACTIVE_BUTTON_FLAG);
        f.add(byteButton);

        JButton kbButton = new JButton("KB");
        kbButton.setBounds(200, 140, 50, 35);
        kbButton.addMouseListener(this);
        kbButton.addActionListener(this);
        kbButton.setName("KILOBYTE");
        buttonStyle(kbButton, ColorStyle.INACTIVE_BUTTON_FLAG);
        f.add(kbButton);

        JButton mbButton = new JButton("MB");
        mbButton.setBounds(260, 140, 50, 35);
        mbButton.addMouseListener(this);
        mbButton.addActionListener(this);
        mbButton.setName("MEGABYTE");
        buttonStyle(mbButton, ColorStyle.INACTIVE_BUTTON_FLAG);
        f.add(mbButton);

        JButton gbButton = new JButton("GB");
        gbButton.setBounds(320, 140, 50, 35);
        gbButton.addMouseListener(this);
        gbButton.addActionListener(this);
        gbButton.setName("GIGABYTE");
        buttonStyle(gbButton, ColorStyle.INACTIVE_BUTTON_FLAG);
        f.add(gbButton);

        JButton tbButton = new JButton("TB");
        tbButton.setBounds(380, 140, 50, 35);
        tbButton.addMouseListener(this);
        tbButton.addActionListener(this);
        tbButton.setName("TERABYTE");
        buttonStyle(tbButton, ColorStyle.INACTIVE_BUTTON_FLAG);
        f.add(tbButton);

        JButton pbButton = new JButton("PB");
        pbButton.setBounds(440, 140, 50, 35);
        pbButton.addMouseListener(this);
        pbButton.addActionListener(this);
        pbButton.setName("PETABYTE");
        buttonStyle(pbButton, ColorStyle.INACTIVE_BUTTON_FLAG);
        f.add(pbButton);

        JButton ebButton = new JButton("EB");
        ebButton.setBounds(500, 140, 50, 35);
        ebButton.addMouseListener(this);
        ebButton.addActionListener(this);
        ebButton.setName("EXABYTE");
        buttonStyle(ebButton, ColorStyle.INACTIVE_BUTTON_FLAG);
        f.add(ebButton);

        JButton zbButton = new JButton("ZB");
        zbButton.setBounds(560, 140, 50, 35);
        zbButton.addMouseListener(this);
        zbButton.addActionListener(this);
        zbButton.setName("ZETTABYTE");
        buttonStyle(zbButton, ColorStyle.INACTIVE_BUTTON_FLAG);
        f.add(zbButton);

        JButton ybButton = new JButton("YB");
        ybButton.setBounds(620, 140, 50, 35);
        ybButton.addMouseListener(this);
        ybButton.addActionListener(this);
        ybButton.setName("YOTTABYTE");
        buttonStyle(ybButton, ColorStyle.INACTIVE_BUTTON_FLAG);
        f.add(ybButton);
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
            alertDialogStyle(alertDialog, "Calculating...");
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
                alertDialogStyle(alertDialog, "Clear the fields of units.");
            }
        }
    }

    //Focus Event
    @Override
    public void focusGained(FocusEvent evt) {
        try{
            JTextField jTextField = (JTextField)evt.getSource();
            textFieldStyle(jTextField, ColorStyle.ACTIVE_TEXT_FIELD_FLAG);
        }
        catch (Exception e){
            System.out.println("UnitConverter Class Focus Gained: " + e.getMessage());
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
            System.out.println("UnitConverter Class Focus Lost: " + e.getMessage());
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
            System.out.println("UnitConverter Class Mouse Entered: " + e.getMessage());
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
            System.out.println("UnitConverter Class Mouse Exited: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
