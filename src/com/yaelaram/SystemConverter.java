package com.yaelaram;

import javax.swing.*;
import java.awt.event.*;

public class SystemConverter implements MouseListener, FocusListener, ActionListener {

    private final JFrame f;
    private JTextField fromTextField, toTextField;
    private JButton convertButton, cleanButton;
    private JComboBox<String> fromUnit, toUnit;
    private JLabel alertDialog;
    private final ColorStyle colorStyle = new ColorStyle();
    private final int[] constValues = {10, 2, 4, 8, 16};

    public SystemConverter(){
        f = new JFrame();
        f.setBounds(180, 10, 765, 260);
        f.setLayout(null);
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.setTitle("Convertir Base");
        f.setLocationRelativeTo(null);
        f.getContentPane().setBackground(colorStyle.getGreyLight());
        start();
        f.setVisible(true);
    }

    private void start(){
        JLabel title = new JLabel("Convertir Base");
        title.setBounds(300, 10, 250, 30);
        colorStyle.labelStyle(title, ColorStyle.PRIMARY_LABEL_FLAG);
        f.add(title);

        String[] units = {"Decimal", "Binario", "Cuaternario", "Octal", "Hexadecimal"};

        fromUnit = new JComboBox<>(units);
        fromUnit.setBounds(50, 65, 130, 30);
        colorStyle.comboBoxStyle(fromUnit);
        f.add(fromUnit);

        toUnit = new JComboBox<>(units);
        toUnit.setBounds(230, 65, 130, 30);
        colorStyle.comboBoxStyle(toUnit);
        f.add(toUnit);

        convertButton = new JButton("Convertir");
        convertButton.setBounds(380, 60, 150, 35);
        convertButton.addMouseListener(this);
        convertButton.addActionListener(this);
        colorStyle.buttonStyle(convertButton, ColorStyle.INACTIVE_BUTTON_FLAG);
        f.add(convertButton);

        cleanButton = new JButton("Limpiar");
        cleanButton.setBounds(550, 60, 150, 35);
        cleanButton.addActionListener(this);
        cleanButton.addMouseListener(this);
        colorStyle.buttonStyle(cleanButton, ColorStyle.INACTIVE_BUTTON_FLAG);
        f.add(cleanButton);

        JLabel fromLabel = new JLabel("De:");
        fromLabel.setBounds(20, 105, 40, 30);
        colorStyle.labelStyle(fromLabel, ColorStyle.SECONDARY_LABEL_FLAG);
        f.add(fromLabel);

        JLabel toLabel = new JLabel("A:");
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
        try{
            if(evt.getSource() == cleanButton){
                fromTextField.setText("");
                toTextField.setText("");
                colorStyle.alertDialogStyle(alertDialog, "");
                fromUnit.setSelectedIndex(0);
                toUnit.setSelectedIndex(0);
            }
            else if(evt.getSource() == convertButton){
                if(!fromTextField.getText().isBlank() || !fromTextField.getText().isEmpty()){
                    colorStyle.alertDialogStyle(alertDialog, "");
                    String fromUnitString = String.valueOf(fromUnit.getSelectedItem());
                    String toUnitString = String.valueOf(toUnit.getSelectedItem());
                    Converter baseConverter = new Converter();
                    try{
                        long number = Long.parseLong(fromTextField.getText());
                        if(fromUnitString.equals(toUnitString)){
                            toTextField.setText(String.valueOf(number));
                        }
                        else if(number == 0){
                            toTextField.setText("0");
                        }
                        else if(number < 0){
                            colorStyle.alertDialogStyle(alertDialog, "Solo numeros enteros positivos.");
                            toTextField.setText("0");
                        }
                        else{
                            if(fromUnitString.equalsIgnoreCase("Decimal")){
                                String result = baseConverter.fromDecimal(number, constValues[toUnit.getSelectedIndex()]);
                                if(result.equalsIgnoreCase("ERROR")){
                                    colorStyle.alertDialogStyle(alertDialog, "Por favor revisa los datos.");
                                }
                                else{
                                    toTextField.setText(result);
                                }
                            }
                            else if(toUnitString.equalsIgnoreCase("Decimal")){
                                long result = baseConverter.toDecimal(fromTextField.getText(), constValues[fromUnit.getSelectedIndex()]);
                                if(result != -1){
                                    toTextField.setText(String.valueOf(result));
                                }
                                else{
                                    colorStyle.alertDialogStyle(alertDialog, "Por favor revisa los datos.");
                                }
                            }
                            else{
                                String result = baseConverter.converterBase(fromTextField.getText(), constValues[fromUnit.getSelectedIndex()], constValues[toUnit.getSelectedIndex()]);
                                if(result.equalsIgnoreCase("ERROR")){
                                    colorStyle.alertDialogStyle(alertDialog, "Por favor revisa los datos.");
                                }
                                else{
                                    toTextField.setText(result);
                                }
                            }
                        }
                    }
                    catch(NumberFormatException error){
                        if(fromUnitString.equalsIgnoreCase("Hexadecimal")){
                            if(toUnitString.equalsIgnoreCase("Decimal")){
                                long result = baseConverter.toDecimal(fromTextField.getText().toUpperCase(), constValues[fromUnit.getSelectedIndex()]);
                                if(result != -1){
                                    toTextField.setText(String.valueOf(result));
                                }
                                else{
                                    colorStyle.alertDialogStyle(alertDialog, "Por favor revisa los datos.");
                                }
                            }
                            else{
                                String result = baseConverter.converterBase(fromTextField.getText().toUpperCase(), 16, constValues[toUnit.getSelectedIndex()]);
                                if(result.equalsIgnoreCase("ERROR")){
                                    colorStyle.alertDialogStyle(alertDialog, "Por favor revisa los datos.");
                                }
                                else{
                                    toTextField.setText(result);
                                }
                            }
                        }
                        else{
                            colorStyle.alertDialogStyle(alertDialog, "Please enter a int number. Max value: 9.223372e+18 or 2^63-1");
                            System.out.println("System converter class converter button: " + error.getMessage());
                            fromTextField.setText("");
                        }
                    }
                }
                else{
                    colorStyle.alertDialogStyle(alertDialog, "Please enter a number at " + fromUnit.getSelectedItem() + " field.");
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
            colorStyle.textFieldStyle(jTextField, ColorStyle.ACTIVE_TEXT_FIELD_FLAG);
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
            colorStyle.textFieldStyle(jTextField, ColorStyle.INACTIVE_TEXT_FIELD_FLAG);
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
            colorStyle.buttonStyle(jButton, ColorStyle.ACTIVE_BUTTON_FLAG);
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
            colorStyle.buttonStyle(jButton, ColorStyle.INACTIVE_BUTTON_FLAG);
        }
        catch (Exception e){
            System.out.println("System Converter Class Mouse Exited: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
