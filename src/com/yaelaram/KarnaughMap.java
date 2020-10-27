package com.yaelaram;

import javax.swing.*;
import java.awt.event.*;

public class KarnaughMap implements MouseListener, FocusListener, ActionListener {

    private final JFrame f;
    private JTextField numVariable;
    private JButton createTable, clean, calculate;
    private JLabel alertDialog;
    private final ColorStyle colorStyle = new ColorStyle();
    private JTextField[] rowTruthTable;
    private JTextField[] outputTruthTable;
    private JTextField[][] karnaughMapLabel;
    private final Converter converter = new Converter();

    public KarnaughMap(){
        f = new JFrame();
        f.setBounds(180, 10, 920, 720);
        f.setLayout(null);
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.setTitle("Mapas de Karnaugh");
        f.setLocationRelativeTo(null);
        f.getContentPane().setBackground(colorStyle.getGreyLight());
        start();
        f.setVisible(true);
    }

    private void start(){
        JLabel title = new JLabel("Mapas de Karnaugh");
        title.setBounds(360, 10, 250, 30);
        colorStyle.labelStyle(title, ColorStyle.PRIMARY_LABEL_FLAG);
        f.add(title);

        JLabel numVariableLabel = new JLabel("#Variables");
        numVariableLabel.setBounds(20, 40, 100, 30);
        colorStyle.labelStyle(numVariableLabel, ColorStyle.SECONDARY_LABEL_FLAG);
        f.add(numVariableLabel);

        numVariable = new JTextField();
        numVariable.setBounds(20, 65, 60, 30);
        numVariable.addFocusListener(this);
        numVariable.addActionListener(this);
        colorStyle.textFieldStyle(numVariable, ColorStyle.INACTIVE_TEXT_FIELD_FLAG);
        f.add(numVariable);

        createTable = new JButton("Crear Tabla");
        createTable.setBounds(190, 60, 150, 40);
        createTable.setFocusable(false);
        createTable.addMouseListener(this);
        createTable.addActionListener(this);
        colorStyle.buttonStyle(createTable, ColorStyle.INACTIVE_BUTTON_FLAG);
        f.add(createTable);

        calculate = new JButton("Calcular");
        calculate.setBounds(440, 60, 150, 40);
        calculate.setFocusable(false);
        calculate.setEnabled(false);
        calculate.addMouseListener(this);
        calculate.addActionListener(this);
        colorStyle.buttonStyle(calculate, ColorStyle.INACTIVE_BUTTON_FLAG);
        f.add(calculate);

        clean = new JButton("Limpiar");
        clean.setBounds(690, 60, 150, 40);
        clean.setFocusable(false);
        clean.addMouseListener(this);
        clean.addActionListener(this);
        colorStyle.buttonStyle(clean, ColorStyle.INACTIVE_BUTTON_FLAG);
        f.add(clean);

        alertDialog = new JLabel();
        alertDialog.setBounds(20, 110, 900, 30);
        colorStyle.alertDialogStyle(alertDialog, "");
        f.add(alertDialog);
    }

    //OnClick Event
    @Override
    public void actionPerformed(ActionEvent evt) {
        try{
            if(evt.getSource() == clean){
                f.dispose();
                new KarnaughMap();
            }
            if(evt.getSource() == createTable || evt.getSource() == numVariable){
                if(!numVariable.getText().isEmpty() || !numVariable.getText().isBlank()){
                    try{
                        int numColumn = Integer.parseInt(numVariable.getText());
                        colorStyle.alertDialogStyle(alertDialog, "");
                        if(numColumn <= 1 || numColumn > 4){
                            colorStyle.alertDialogStyle(alertDialog, "Por favor solo numeros enteros entre dos y cuatro.");
                            calculate.setEnabled(false);
                        }
                        else{
                            int numRow = (int) Math.pow(2, numColumn);
                            rowTruthTable = new JTextField[numRow];
                            outputTruthTable = new JTextField[numRow];
                            JLabel[] horizontalTitle, verticalTitle;
                            for(int i = 0 ; i<numRow ; i++){
                                StringBuilder stringBuilder = new StringBuilder(converter.fromDecimal(i, 2));
                                while(stringBuilder.length() < numColumn){
                                    stringBuilder.insert(0, "0");
                                }
                                rowTruthTable[i] = new JTextField(stringBuilder.toString());
                                rowTruthTable[i].setBounds(20, (140 + (32 * i)), 70, 30);
                                colorStyle.textFieldStyle(rowTruthTable[i], ColorStyle.ACTIVE_TEXT_FIELD_FLAG);
                                rowTruthTable[i].setEditable(false);
                                rowTruthTable[i].setFocusable(false);
                                rowTruthTable[i].setHorizontalAlignment(SwingConstants.CENTER);
                                f.add(rowTruthTable[i]);
                                outputTruthTable[i] = new JTextField();
                                outputTruthTable[i].setBounds(110, (140 + (32 * i)), 30, 30);
                                colorStyle.textFieldStyle(outputTruthTable[i], ColorStyle.INACTIVE_TEXT_FIELD_FLAG);
                                outputTruthTable[i].setHorizontalAlignment(SwingConstants.CENTER);
                                outputTruthTable[i].addFocusListener(this);
                                f.add(outputTruthTable[i]);
                            }
                            if(numColumn == 2){
                                karnaughMapLabel = new JTextField[2][2];
                                horizontalTitle = new JLabel[2];
                                verticalTitle = new JLabel[2];
                                for(int i = 0 ; i<2 ; i++){
                                    for(int j = 0 ; j<2 ; j++){
                                        horizontalTitle[j] = new JLabel("A - " + j);
                                        horizontalTitle[j].setBounds((320 + (70 * j)), 190, 30, 30);
                                        colorStyle.labelStyle(horizontalTitle[j], ColorStyle.ACTIVE_TEXT_FIELD_FLAG);
                                        f.add(horizontalTitle[j]);
                                        verticalTitle[j] = new JLabel("E - " + j);
                                        verticalTitle[j].setBounds(260, (220 + (65 * j)), 30, 30);
                                        colorStyle.labelStyle(verticalTitle[j], ColorStyle.ACTIVE_TEXT_FIELD_FLAG);
                                        f.add(verticalTitle[j]);
                                        karnaughMapLabel[i][j] = new JTextField();
                                        karnaughMapLabel[i][j].setBounds((320 + (70 * j)), (220 + (60 * i)), 30, 30);
                                        karnaughMapLabel[i][j].setFocusable(false);
                                        karnaughMapLabel[i][j].setEditable(false);
                                        karnaughMapLabel[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                                        colorStyle.textFieldStyle(karnaughMapLabel[i][j], ColorStyle.ACTIVE_TEXT_FIELD_FLAG);
                                        f.add(karnaughMapLabel[i][j]);
                                    }
                                }
                            }
                            else if(numColumn == 3){
                                horizontalTitle = new JLabel[4];
                                verticalTitle = new JLabel[2];
                                karnaughMapLabel = new JTextField[2][4];
                                String[] title = {"AE-00", "AE-01", "AE-11", "AE-10"};
                                for(int i = 0 ; i<2 ; i++){
                                    for(int j = 0 ; j<4 ; j++){
                                        horizontalTitle[j] = new JLabel(title[j]);
                                        horizontalTitle[j].setBounds((320 + (70 * j)), 190, 50, 30);
                                        horizontalTitle[j].setHorizontalAlignment(SwingConstants.CENTER);
                                        colorStyle.labelStyle(horizontalTitle[j], ColorStyle.ACTIVE_TEXT_FIELD_FLAG);
                                        f.add(horizontalTitle[j]);
                                        verticalTitle[i] = new JLabel("O - " + i);
                                        verticalTitle[i].setBounds(260, (225 + (60 * i)), 35, 30);
                                        colorStyle.labelStyle(verticalTitle[i], ColorStyle.ACTIVE_TEXT_FIELD_FLAG);
                                        f.add(verticalTitle[i]);
                                        karnaughMapLabel[i][j] = new JTextField();
                                        karnaughMapLabel[i][j].setBounds((320 + (70 * j)), (220 + (60 * i)), 50, 30);
                                        karnaughMapLabel[i][j].setFocusable(false);
                                        karnaughMapLabel[i][j].setEditable(false);
                                        karnaughMapLabel[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                                        colorStyle.textFieldStyle(karnaughMapLabel[i][j], ColorStyle.ACTIVE_TEXT_FIELD_FLAG);
                                        f.add(karnaughMapLabel[i][j]);
                                    }
                                }
                            }
                            else{
                                horizontalTitle = new JLabel[4];
                                verticalTitle = new JLabel[4];
                                String[] titleHorizontal = {"AE-00", "AE-01", "AE-11", "AE-10"};
                                String[] titleVertical = {"OU-00", "OU-01", "OU-11", "OU-10"};
                                karnaughMapLabel = new JTextField[4][4];
                                for(int i = 0 ; i<4 ; i++){
                                    for(int j = 0 ; j<4 ; j++){
                                        horizontalTitle[j] = new JLabel(titleHorizontal[j]);
                                        horizontalTitle[j].setBounds((320 + (70 * j)), 190, 50, 30);
                                        horizontalTitle[j].setHorizontalAlignment(SwingConstants.CENTER);
                                        colorStyle.labelStyle(horizontalTitle[j], ColorStyle.ACTIVE_TEXT_FIELD_FLAG);
                                        f.add(horizontalTitle[j]);
                                        verticalTitle[j] = new JLabel(titleVertical[j]);
                                        verticalTitle[j].setBounds(250, (225 + (60 * j)), 50, 30);
                                        colorStyle.labelStyle(verticalTitle[j], ColorStyle.ACTIVE_TEXT_FIELD_FLAG);
                                        f.add(verticalTitle[j]);
                                        karnaughMapLabel[i][j] = new JTextField();
                                        karnaughMapLabel[i][j].setBounds((320 + (70 * j)), (220 + (60 * i)), 50, 30);
                                        karnaughMapLabel[i][j].setFocusable(false);
                                        karnaughMapLabel[i][j].setEditable(false);
                                        karnaughMapLabel[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                                        colorStyle.textFieldStyle(karnaughMapLabel[i][j], ColorStyle.ACTIVE_TEXT_FIELD_FLAG);
                                        f.add(karnaughMapLabel[i][j]);
                                    }
                                }
                            }
                            f.update(f.getGraphics());
                            createTable.setEnabled(false);
                            calculate.setEnabled(true);
                        }
                    }
                    catch (NumberFormatException error){
                        System.out.println("Karnaugh class calculate button: " + error.getMessage());
                        colorStyle.alertDialogStyle(alertDialog, "Por favor solo numeros enteros entre dos y cuatro.");
                    }
                }
                else{
                    colorStyle.alertDialogStyle(alertDialog, "Por favor ingresa solo numeros.");
                }
            }
            if(evt.getSource() == calculate){
                int flag = 0;
                int numColumn = Integer.parseInt(numVariable.getText());
                int numRow = (int) Math.pow(2, numColumn);
                int[] outputValues = new int[numRow];
                String[] outputValuesString = new String[numRow];
                for(int i = 0 ; i<numRow ; i++){
                    if(outputTruthTable[i].getText().isBlank() || outputTruthTable[i].getText().isEmpty()){
                        flag++;
                    }
                    else{
                        try{
                            outputValues[i] = Integer.parseInt(outputTruthTable[i].getText());
                            if(outputValues[i] != 0 && outputValues[i] != 1){
                                flag++;
                            }
                        }
                        catch(NumberFormatException error){
                            System.out.println("Karnaugh map class calculate button: " + error.getMessage());
                            flag++;
                        }
                    }
                }
                for(int i = 0 ; i<numRow ; i++){
                    outputValuesString[i] = rowTruthTable[i].getText();
                }
                if(flag == 0){
                    colorStyle.alertDialogStyle(alertDialog, converter.solveMap(numRow, outputValues, outputValuesString));
                    int[][] karnaughMap = converter.createKarnaughMap(numColumn, numRow, outputValues, outputValuesString);
                    if(numColumn == 2){
                        for(int i = 0 ; i<2 ; i++){
                            for(int j = 0 ; j<2 ; j++){
                                karnaughMapLabel[i][j].setText(String.valueOf(karnaughMap[i][j]));
                            }
                        }
                    }
                    else if(numColumn == 3){
                        for(int i = 0 ; i<2 ; i++){
                            for(int j = 0 ; j<4 ; j++){
                                karnaughMapLabel[i][j].setText(String.valueOf(karnaughMap[i][j]));
                            }
                        }
                    }
                    else{
                        for(int i = 0 ; i<4 ; i++){
                            for(int j = 0 ; j<4 ; j++){
                                karnaughMapLabel[i][j].setText(String.valueOf(karnaughMap[i][j]));
                            }
                        }
                    }
                }
                else{
                    colorStyle.alertDialogStyle(alertDialog, "Por favor ingresa como valor de salida solo 1 ó 0.");
                }
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
            colorStyle.textFieldStyle(jTextField, ColorStyle.ACTIVE_TEXT_FIELD_FLAG);
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
            colorStyle.textFieldStyle(jTextField, ColorStyle.INACTIVE_TEXT_FIELD_FLAG);
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
            colorStyle.buttonStyle(jButton, ColorStyle.ACTIVE_BUTTON_FLAG);
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
            colorStyle.buttonStyle(jButton, ColorStyle.INACTIVE_BUTTON_FLAG);
        }
        catch (Exception e){
            System.out.println("Karnaugh Map Class Mouse Exited: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
