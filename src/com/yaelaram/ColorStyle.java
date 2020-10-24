package com.yaelaram;

import javax.swing.*;
import java.awt.*;

public class ColorStyle {
    private final Color greyCool = new Color(130, 130, 130);
    private final Color greyDarkCool = new Color(0, 0, 0);
    private final Color white = new Color(255, 255, 255);
    private final Color orange = new Color(221, 44, 0);
    private final Font primaryFont = new Font("Roboto", Font.BOLD, 22);
    private final Font secondaryFont = new Font("Roboto", Font.BOLD, 14);
    public final static int PRIMARY_LABEL_FLAG = 1;
    public final static int SECONDARY_LABEL_FLAG = 2;
    public final static int ACTIVE_TEXT_FIELD_FLAG = 3;
    public static final int INACTIVE_TEXT_FIELD_FLAG = 4;
    public static final int ACTIVE_BUTTON_FLAG = 5;
    public static final int INACTIVE_BUTTON_FLAG = 6;

    public Color getOrange() {
        return orange;
    }

    public Color getGreyCool() {
        return greyCool;
    }

    public Color getGreyDarkCool() {
        return greyDarkCool;
    }

    public Color getWhite() {
        return white;
    }

    public Font getPrimaryFont() {
        return primaryFont;
    }

    public Font getSecondaryFont() {
        return secondaryFont;
    }

    //Styling Methods
    public void labelStyle(JLabel jLabel, int flag){
        jLabel.setForeground(getWhite());
        if(ColorStyle.PRIMARY_LABEL_FLAG == flag){
            jLabel.setFont(getPrimaryFont());
        }
        else{
            jLabel.setFont(getSecondaryFont());
        }
    }

    public void textFieldStyle(JTextField jTextField, int flag){
        jTextField.setFont(getSecondaryFont());
        jTextField.setBackground(getGreyDarkCool());
        if(ColorStyle.INACTIVE_TEXT_FIELD_FLAG == flag){
            jTextField.setForeground(getGreyCool());
            jTextField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, getGreyCool()));
        }
        else{
            jTextField.setForeground(getWhite());
            jTextField.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, getOrange()));
        }
    }

    public void passwordFieldStyle(JPasswordField jPasswordField, int flag){
        jPasswordField.setFont(getSecondaryFont());
        jPasswordField.setBackground(getGreyDarkCool());
        if(ColorStyle.INACTIVE_TEXT_FIELD_FLAG == flag){
            jPasswordField.setForeground(getGreyCool());
            jPasswordField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, getGreyCool()));
        }
        else{
            jPasswordField.setForeground(getWhite());
            jPasswordField.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, getOrange()));
        }
    }

    public void buttonStyle(JButton jButton, int flag){
        jButton.setFocusable(false);
        jButton.setFont(getPrimaryFont());
        jButton.setForeground(getWhite());
        if(ColorStyle.INACTIVE_BUTTON_FLAG == flag){
            jButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, getOrange()));
            jButton.setBackground(getGreyDarkCool());
        }
        else{
            jButton.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, getOrange()));
            jButton.setBackground(getOrange());
        }
    }

    public void alertDialogStyle(JLabel jLabel, String message){
        jLabel.setFont(getSecondaryFont());
        jLabel.setForeground(getWhite());
        jLabel.setText(message);
    }

    public void comboBoxStyle(JComboBox<String> jComboBox){
        jComboBox.setBackground(getGreyDarkCool());
        jComboBox.setFont(getSecondaryFont());
        jComboBox.setForeground(getWhite());
        jComboBox.setFocusable(false);
        jComboBox.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, getOrange()));
    }
}
