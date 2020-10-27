package com.yaelaram;

import javax.swing.*;
import java.awt.event.*;

public class UnitConverter implements MouseListener, FocusListener, ActionListener {

    private final JFrame f;
    private JTextField fromTextField, toTextField;
    private JButton convertButton, cleanButton;
    private JLabel alertDialog;
    private JComboBox<String> fromUnit, toUnit;
    private final ColorStyle colorStyle = new ColorStyle();
    private final int[] constantValues = {0, 0, 0, 3, 6, 9, 12, 15, 18, 21, 24};

    public UnitConverter(){
        f = new JFrame();
        f.setBounds(180, 10, 765, 260);
        f.setLayout(null);
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.setTitle("Unit Converter");
        f.setLocationRelativeTo(null);
        f.getContentPane().setBackground(colorStyle.getGreyLight());
        start();
        f.setVisible(true);
    }

    private void start(){
        JLabel title = new JLabel("Unit Converter");
        title.setBounds(315, 10, 250, 30);
        colorStyle.labelStyle(title, ColorStyle.PRIMARY_LABEL_FLAG);
        f.add(title);

        String[] units = {"Bit", "Nibble", "Byte", "Kilobyte", "Megabyte", "Gigabyte", "Terabyte", "Petabyte", "Exabyte", "Zettabyte", "Yottabyte"};

        fromUnit = new JComboBox<>(units);
        fromUnit.setBounds(70, 65, 130, 30);
        colorStyle.comboBoxStyle(fromUnit);
        f.add(fromUnit);

        toUnit = new JComboBox<>(units);
        toUnit.setBounds(250, 65, 130, 30);
        colorStyle.comboBoxStyle(toUnit);
        f.add(toUnit);

        convertButton = new JButton("Convert");
        convertButton.setBounds(410, 60, 150, 35);
        convertButton.addMouseListener(this);
        convertButton.addActionListener(this);
        colorStyle.buttonStyle(convertButton, ColorStyle.INACTIVE_BUTTON_FLAG);
        f.add(convertButton);

        cleanButton = new JButton("Clean");
        cleanButton.setBounds(580, 60, 150, 35);
        cleanButton.addActionListener(this);
        cleanButton.addMouseListener(this);
        colorStyle.buttonStyle(cleanButton, ColorStyle.INACTIVE_BUTTON_FLAG);
        f.add(cleanButton);

        JLabel fromLabel = new JLabel("From:");
        fromLabel.setBounds(20, 105, 40, 30);
        colorStyle.labelStyle(fromLabel, ColorStyle.SECONDARY_LABEL_FLAG);
        f.add(fromLabel);

        JLabel toLabel = new JLabel("To:");
        toLabel.setBounds(390, 105, 40, 30);
        colorStyle.labelStyle(toLabel, ColorStyle.SECONDARY_LABEL_FLAG);
        f.add(toLabel);

        fromTextField = new JTextField();
        fromTextField.setBounds(20, 130, 330, 30);
        fromTextField.addFocusListener(this);
        fromTextField.addActionListener(this);
        colorStyle.textFieldStyle(fromTextField, ColorStyle.INACTIVE_TEXT_FIELD_FLAG);
        f.add(fromTextField);
        
        toTextField = new JTextField();
        toTextField.setBounds(390, 130, 330, 30);
        toTextField.addFocusListener(this);
        toTextField.addActionListener(this);
        colorStyle.textFieldStyle(toTextField, ColorStyle.INACTIVE_TEXT_FIELD_FLAG);
        f.add(toTextField);

        alertDialog = new JLabel();
        alertDialog.setBounds(20, 175, 600, 30);
        colorStyle.alertDialogStyle(alertDialog, "");
        f.add(alertDialog);
    }

    //OnClick Event
    @Override
    public void actionPerformed(ActionEvent evt) {
        if(evt.getSource() == cleanButton){
            fromTextField.setText("");
            toTextField.setText("");
            colorStyle.alertDialogStyle(alertDialog, "");
            fromUnit.setSelectedIndex(0);
            toUnit.setSelectedIndex(0);
        }
        else if(evt.getSource() == convertButton){
            if(!fromTextField.getText().isEmpty() || !fromTextField.getText().isBlank()){
                colorStyle.alertDialogStyle(alertDialog, "");
                try{
                    double fromValue = Double.parseDouble(fromTextField.getText());
                    String stringFrom = String.valueOf(fromUnit.getSelectedItem());
                    String stringTo = String.valueOf(toUnit.getSelectedItem());
                    if(fromValue == 0.0){
                        toTextField.setText("0");
                    }
                    else if(stringFrom.equals(stringTo)){
                        toTextField.setText(fromTextField.getText());
                    }
                    else{
                        int superIndexFrom = constantValues[fromUnit.getSelectedIndex()];
                        int superIndexTo = constantValues[toUnit.getSelectedIndex()];
                        Converter converter = new Converter();
                        String result = converter.unitConverter(fromValue, stringFrom, stringTo, superIndexFrom, superIndexTo);
                        toTextField.setText(result);
                    }
                }
                catch (NumberFormatException error){
                    colorStyle.alertDialogStyle(alertDialog, "Please introduce a number.");
                    fromTextField.setText("");
                    System.out.println("Unit Converter class converter button: " + error.getMessage());
                }
            }
            else{
                colorStyle.alertDialogStyle(alertDialog, "Please enter a value at " + fromUnit.getSelectedItem() + " field.");
            }
        }
    }

    //Focus Event
    @Override
    public void focusGained(FocusEvent evt) {
        try{
            JTextField jTextField = (JTextField)evt.getSource();
            colorStyle.textFieldStyle(jTextField, ColorStyle.ACTIVE_TEXT_FIELD_FLAG);
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
            colorStyle.textFieldStyle(jTextField, ColorStyle.INACTIVE_TEXT_FIELD_FLAG);
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
            colorStyle.buttonStyle(jButton, ColorStyle.ACTIVE_BUTTON_FLAG);
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
            colorStyle.buttonStyle(jButton, ColorStyle.INACTIVE_BUTTON_FLAG);
        }
        catch (Exception e){
            System.out.println("UnitConverter Class Mouse Exited: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
