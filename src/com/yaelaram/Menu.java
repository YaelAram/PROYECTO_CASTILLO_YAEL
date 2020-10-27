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
        f.setTitle("Menu de Opciones");
        f.setLocationRelativeTo(null);
        f.getContentPane().setBackground(colorStyle.getGreyLight());
        start();
        f.setVisible(true);
    }

    private void start(){
        JLabel title = new JLabel("Selecciona una opción.");
        title.setBounds(40, 10, 250, 30);
        title.setFont(colorStyle.getPrimaryFont());
        f.add(title);

        convertScreen = new JButton("Convertir Unidades Digitales");
        convertScreen.setBounds(14, 80, 300, 45);
        convertScreen.addMouseListener(this);
        convertScreen.addActionListener(this);
        colorStyle.buttonStyle(convertScreen, ColorStyle.INACTIVE_BUTTON_FLAG);
        f.add(convertScreen);

        convertNumberScreen = new JButton("Convertir Base");
        convertNumberScreen.setBounds(14, 150, 300, 45);
        convertNumberScreen.addMouseListener(this);
        convertNumberScreen.addActionListener(this);
        colorStyle.buttonStyle(convertNumberScreen, ColorStyle.INACTIVE_BUTTON_FLAG);
        f.add(convertNumberScreen);

        karnaughMapScreen = new JButton("Mapa de Karnaugh");
        karnaughMapScreen.setBounds(14, 220, 300, 45);
        karnaughMapScreen.addMouseListener(this);
        karnaughMapScreen.addActionListener(this);
        colorStyle.buttonStyle(karnaughMapScreen, ColorStyle.INACTIVE_BUTTON_FLAG);
        f.add(karnaughMapScreen);
    }

    //OnClick Event
    @Override
    public void actionPerformed(ActionEvent evt) {
        try{
            if(evt.getSource() == convertScreen){
                new UnitConverter();
            }
            else if(evt.getSource() == convertNumberScreen){
                new SystemConverter();
            }
            else if(evt.getSource() == karnaughMapScreen){
                new KarnaughMap();
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
            colorStyle.buttonStyle(jButton, ColorStyle.ACTIVE_BUTTON_FLAG);
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
            colorStyle.buttonStyle(jButton, ColorStyle.INACTIVE_BUTTON_FLAG);
        }
        catch(Exception e){
            System.out.println("Menu Class Mouse Exited: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
