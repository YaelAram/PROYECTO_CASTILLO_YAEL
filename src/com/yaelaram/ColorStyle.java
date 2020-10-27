package com.yaelaram;

import javax.swing.*;
import java.awt.*;

public class ColorStyle {
    private final Color greyLight = new Color(230, 230, 230);
    private final Color grey = new Color(212, 212, 212);
    private final Color greyDark = new Color(55, 58, 64);
    private final Color black = new Color(0, 0, 0);
    private final Font primaryFont = new Font("Roboto", Font.BOLD, 22);
    private final Font secondaryFont = new Font("Roboto", Font.BOLD, 14);
    public final static int PRIMARY_LABEL_FLAG = 1;
    public final static int SECONDARY_LABEL_FLAG = 2;
    public final static int ACTIVE_TEXT_FIELD_FLAG = 3;
    public static final int INACTIVE_TEXT_FIELD_FLAG = 4;
    public static final int ACTIVE_BUTTON_FLAG = 5;
    public static final int INACTIVE_BUTTON_FLAG = 6;

    public Color getGreyLight() {
        return greyLight;
    }

    public Color getGrey() {
        return grey;
    }

    public Color getBlack() {
        return black;
    }

    public Color getGreyDark() {
        return greyDark;
    }

    public Font getPrimaryFont() {
        return primaryFont;
    }

    public Font getSecondaryFont() {
        return secondaryFont;
    }

    //Styling Methods
    public void labelStyle(JLabel jLabel, int flag){
        jLabel.setForeground(getBlack());
        if(ColorStyle.PRIMARY_LABEL_FLAG == flag){
            jLabel.setFont(getPrimaryFont());
        }
        else{
            jLabel.setFont(getSecondaryFont());
        }
    }

    public void textFieldStyle(JTextField jTextField, int flag){
        jTextField.setFont(getSecondaryFont());
        jTextField.setForeground(getBlack());
        if(ColorStyle.INACTIVE_TEXT_FIELD_FLAG == flag){
            jTextField.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
            jTextField.setBackground(getGrey());
        }
        else{
            jTextField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, getGreyDark()));
            jTextField.setBackground(getGreyLight());
        }
    }

    public void passwordFieldStyle(JPasswordField jPasswordField, int flag){
        jPasswordField.setFont(getSecondaryFont());
        jPasswordField.setForeground(getBlack());
        if(ColorStyle.INACTIVE_TEXT_FIELD_FLAG == flag){
            jPasswordField.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
            jPasswordField.setBackground(getGrey());
        }
        else{
            jPasswordField.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, getGreyDark()));
            jPasswordField.setBackground(getGreyLight());
        }
    }

    public void buttonStyle(JButton jButton, int flag){
        jButton.setFocusable(false);
        jButton.setFont(getPrimaryFont());
        if(ColorStyle.INACTIVE_BUTTON_FLAG == flag){
            jButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, getGreyDark()));
            jButton.setBackground(getGreyLight());
            jButton.setForeground(getGreyDark());
        }
        else{
            jButton.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, getGreyDark()));
            jButton.setBackground(getGreyDark());
            jButton.setForeground(getGreyLight());
        }
    }

    public void alertDialogStyle(JLabel jLabel, String message){
        jLabel.setFont(getSecondaryFont());
        jLabel.setForeground(getBlack());
        jLabel.setText(message);
    }

    public void comboBoxStyle(JComboBox<String> jComboBox){
        jComboBox.setBackground(getGreyLight());
        jComboBox.setFont(getSecondaryFont());
        jComboBox.setForeground(getBlack());
        jComboBox.setFocusable(false);
        jComboBox.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, getGreyDark()));
    }
}
