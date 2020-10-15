package com.yaelaram;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Menu implements MouseListener, ActionListener {
    private final JFrame f;
    private final ColorStyle colorStyle = new ColorStyle();
    private JButton convertScreen, convertNumberScreen, karnaughMapScreen;

    public Menu(){
        f = new JFrame();
        f.setBounds(100, 10, 340, 320);
        f.setLayout(null);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setTitle("Menu");
        f.setLocationRelativeTo(null);
        f.getContentPane().setBackground(colorStyle.getGreyDarkCool());
        start();
        f.setVisible(true);
    }

    private void start(){
        JLabel title = new JLabel("Please select an option");
        title.setBounds(50, 10, 250, 30);
        title.setForeground(colorStyle.getWhite());
        title.setFont(colorStyle.getPrimaryFont());
        f.add(title);

        convertScreen = new JButton("Unit Converter");
        convertScreen.setBounds(35, 80, 250, 45);
        convertScreen.addMouseListener(this);
        convertScreen.addActionListener(this);
        buttonStyle(convertScreen, ColorStyle.INACTIVE_BUTTON_FLAG);
        f.add(convertScreen);

        convertNumberScreen = new JButton("System Converter");
        convertNumberScreen.setBounds(35, 150, 250, 45);
        convertNumberScreen.addMouseListener(this);
        convertNumberScreen.addActionListener(this);
        buttonStyle(convertNumberScreen, ColorStyle.INACTIVE_BUTTON_FLAG);
        f.add(convertNumberScreen);

        karnaughMapScreen = new JButton("Karnaugh Map");
        karnaughMapScreen.setBounds(35, 220, 250, 45);
        karnaughMapScreen.addMouseListener(this);
        karnaughMapScreen.addActionListener(this);
        buttonStyle(karnaughMapScreen, ColorStyle.INACTIVE_BUTTON_FLAG);
        f.add(karnaughMapScreen);
    }

    //Styling Method
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

    //OnClick Event
    @Override
    public void actionPerformed(ActionEvent evt) {
        try{
            if(evt.getSource() == convertScreen){
                System.out.println("Opening convert screen...");
                new UnitConverter();
            }
            else if(evt.getSource() == convertNumberScreen){
                System.out.println("Opening convert number screen...");
                new SystemConverter();
            }
            else if(evt.getSource() == karnaughMapScreen){
                System.out.println("Opening karnaugh map screen...");
            }
        }
        catch (Exception e){
            System.out.println("Menu class Action Performed: " + e.getMessage());
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
        }
        catch(Exception e){
            System.out.println("Menu Class Mouse Entered: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void mouseExited(MouseEvent evt) {
        try{
            JButton jButton = (JButton)evt.getSource();
            buttonStyle(jButton, ColorStyle.INACTIVE_BUTTON_FLAG);
        }
        catch(Exception e){
            System.out.println("Menu Class Mouse Exited: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
