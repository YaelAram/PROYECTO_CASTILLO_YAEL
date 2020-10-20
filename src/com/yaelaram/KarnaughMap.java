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

    public KarnaughMap(){
        f = new JFrame();
        f.setBounds(180, 10, 920, 720);
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
        numVariable.setBounds(20, 65, 60, 30);
        numVariable.addFocusListener(this);
        numVariable.addActionListener(this);
        textFieldStyle(numVariable, ColorStyle.INACTIVE_TEXT_FIELD_FLAG);
        f.add(numVariable);

        createTable = new JButton("Create Table");
        createTable.setBounds(190, 60, 150, 40);
        createTable.setFocusable(false);
        createTable.addMouseListener(this);
        createTable.addActionListener(this);
        buttonStyle(createTable, ColorStyle.INACTIVE_BUTTON_FLAG);
        f.add(createTable);

        calculate = new JButton("Calculate");
        calculate.setBounds(440, 60, 150, 40);
        calculate.setFocusable(false);
        calculate.setEnabled(false);
        calculate.addMouseListener(this);
        calculate.addActionListener(this);
        buttonStyle(calculate, ColorStyle.INACTIVE_BUTTON_FLAG);
        f.add(calculate);

        clean = new JButton("Clean");
        clean.setBounds(690, 60, 150, 40);
        clean.setFocusable(false);
        clean.addMouseListener(this);
        clean.addActionListener(this);
        buttonStyle(clean, ColorStyle.INACTIVE_BUTTON_FLAG);
        f.add(clean);

        alertDialog = new JLabel();
        alertDialog.setBounds(20, 110, 900, 30);
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

    //solveMap Method
    private String solveMap(int numRow, int[] outputValues){
        StringBuilder stringBuilder = new StringBuilder();
        String divider = " + ";
        for(int i = 0 ; i<numRow ; i++){
            if(outputValues[i] == 1){
                if(i != 0){
                    stringBuilder.append(divider);
                }
                String values = rowTruthTable[i].getText();
                for(int j = 0 ; j<values.length() ; j++){
                    if(j == 0){
                        if(values.charAt(j) == '1'){
                            stringBuilder.append("A");
                        }
                        else{
                            stringBuilder.append("\u0100");
                        }
                    }
                    else if(j == 1){
                        if(values.charAt(j) == '1'){
                            stringBuilder.append("E");
                        }
                        else{
                            stringBuilder.append("\u0112");
                        }
                    }
                    else if(j == 2){
                        if(values.charAt(j) == '1'){
                            stringBuilder.append("O");
                        }
                        else{
                            stringBuilder.append("\u014C");
                        }
                    }
                    else{
                        if(values.charAt(j) == '1'){
                            stringBuilder.append("U");
                        }
                        else{
                            stringBuilder.append("\u016A");
                        }
                    }
                }
            }
        }
        return stringBuilder.toString();
    }

    private int[][] createKarnaughMap(int numColumn, int numRow, int[] outputValues){
        int[][] resultArray;
        if(numColumn == 2){
            resultArray = new int[numColumn][numColumn];
            for(int i = 0 ; i<numRow ; i++){
                if(outputValues[i] == 1){
                    String values = rowTruthTable[i].getText();
                    String aColumn = String.valueOf(values.charAt(0));
                    String eRow = String.valueOf(values.charAt(1));
                    resultArray[Integer.parseInt(eRow)][Integer.parseInt(aColumn)] = 1;
                }
            }
        }
        else if(numColumn == 3){
            resultArray = new int[numColumn - 1][numColumn + 1];
            Converter converter = new Converter();
            for(int i = 0 ; i<numRow ; i++){
                if(outputValues[i] == 1){
                    String values = rowTruthTable[i].getText();
                    String aColumn = String.valueOf(values.charAt(0));
                    String eColumn = String.valueOf(values.charAt(1));
                    String oRow = String.valueOf(values.charAt(2));
                    long column = converter.toDecimal((aColumn + eColumn), 2);
                    if(column == 3){
                        column = 2;
                    }
                    else if(column == 2){
                        column = 3;
                    }
                    resultArray[Integer.parseInt(oRow)][(int) column] = 1;
                }
            }
        }
        else{
            resultArray = new int[numColumn + 1][numColumn + 1];
            Converter converter = new Converter();
            for(int i = 0 ; i<numRow ; i++){
                if(outputValues[i] == 1){
                    String values = rowTruthTable[i].getText();
                    String aColumn = String.valueOf(values.charAt(0));
                    String eColumn = String.valueOf(values.charAt(1));
                    String oRow = String.valueOf(values.charAt(2));
                    String uRow = String.valueOf(values.charAt(3));
                    long column = converter.toDecimal((aColumn + eColumn), 2);
                    long row = converter.toDecimal((oRow + uRow), 2);
                    if(column == 3){
                        column = 2;
                    }
                    else if(column == 2){
                        column = 3;
                    }
                    if(row == 3){
                        row = 2;
                    }
                    else if(row == 2){
                        row = 3;
                    }
                    resultArray[(int)row][(int) column] = 1;
                }
            }
        }
        return resultArray;
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
                        alertDialogStyle(alertDialog, "");
                        if(numColumn <= 1 || numColumn > 4){
                            alertDialogStyle(alertDialog, "Please only numbers from 2 to 4");
                            calculate.setEnabled(false);
                        }
                        else{
                            int numRow = (int) Math.pow(2, numColumn);
                            rowTruthTable = new JTextField[numRow];
                            outputTruthTable = new JTextField[numRow];
                            Converter converter = new Converter();
                            JLabel[] horizontalTitle, verticalTitle;
                            for(int i = 0 ; i<numRow ; i++){
                                StringBuilder stringBuilder = new StringBuilder(converter.fromDecimal(i, 2));
                                while(stringBuilder.length() < numColumn){
                                    stringBuilder.insert(0, "0");
                                }
                                rowTruthTable[i] = new JTextField(stringBuilder.toString());
                                rowTruthTable[i].setBounds(20, (140 + (32 * i)), 70, 30);
                                textFieldStyle(rowTruthTable[i], ColorStyle.ACTIVE_TEXT_FIELD_FLAG);
                                rowTruthTable[i].setEditable(false);
                                rowTruthTable[i].setFocusable(false);
                                rowTruthTable[i].setHorizontalAlignment(SwingConstants.CENTER);
                                f.add(rowTruthTable[i]);
                                outputTruthTable[i] = new JTextField();
                                outputTruthTable[i].setBounds(110, (140 + (32 * i)), 30, 30);
                                textFieldStyle(outputTruthTable[i], ColorStyle.INACTIVE_TEXT_FIELD_FLAG);
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
                                        labelStyle(horizontalTitle[j], ColorStyle.ACTIVE_TEXT_FIELD_FLAG);
                                        f.add(horizontalTitle[j]);
                                        verticalTitle[j] = new JLabel("E - " + j);
                                        verticalTitle[j].setBounds(260, (220 + (65 * j)), 30, 30);
                                        labelStyle(verticalTitle[j], ColorStyle.ACTIVE_TEXT_FIELD_FLAG);
                                        f.add(verticalTitle[j]);
                                        karnaughMapLabel[i][j] = new JTextField();
                                        karnaughMapLabel[i][j].setBounds((320 + (70 * j)), (220 + (60 * i)), 30, 30);
                                        karnaughMapLabel[i][j].setFocusable(false);
                                        karnaughMapLabel[i][j].setEditable(false);
                                        karnaughMapLabel[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                                        textFieldStyle(karnaughMapLabel[i][j], ColorStyle.ACTIVE_TEXT_FIELD_FLAG);
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
                                        labelStyle(horizontalTitle[j], ColorStyle.ACTIVE_TEXT_FIELD_FLAG);
                                        f.add(horizontalTitle[j]);
                                        verticalTitle[i] = new JLabel("O - " + i);
                                        verticalTitle[i].setBounds(260, (225 + (60 * i)), 35, 30);
                                        labelStyle(verticalTitle[i], ColorStyle.ACTIVE_TEXT_FIELD_FLAG);
                                        f.add(verticalTitle[i]);
                                        karnaughMapLabel[i][j] = new JTextField();
                                        karnaughMapLabel[i][j].setBounds((320 + (70 * j)), (220 + (60 * i)), 50, 30);
                                        karnaughMapLabel[i][j].setFocusable(false);
                                        karnaughMapLabel[i][j].setEditable(false);
                                        karnaughMapLabel[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                                        textFieldStyle(karnaughMapLabel[i][j], ColorStyle.ACTIVE_TEXT_FIELD_FLAG);
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
                                        labelStyle(horizontalTitle[j], ColorStyle.ACTIVE_TEXT_FIELD_FLAG);
                                        f.add(horizontalTitle[j]);
                                        verticalTitle[j] = new JLabel(titleVertical[j]);
                                        verticalTitle[j].setBounds(250, (225 + (60 * j)), 50, 30);
                                        labelStyle(verticalTitle[j], ColorStyle.ACTIVE_TEXT_FIELD_FLAG);
                                        f.add(verticalTitle[j]);
                                        karnaughMapLabel[i][j] = new JTextField();
                                        karnaughMapLabel[i][j].setBounds((320 + (70 * j)), (220 + (60 * i)), 50, 30);
                                        karnaughMapLabel[i][j].setFocusable(false);
                                        karnaughMapLabel[i][j].setEditable(false);
                                        karnaughMapLabel[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                                        textFieldStyle(karnaughMapLabel[i][j], ColorStyle.ACTIVE_TEXT_FIELD_FLAG);
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
                        alertDialogStyle(alertDialog, "Please only int numbers (2 - 4).");
                    }
                }
                else{
                    alertDialogStyle(alertDialog, "Please enter a number.");
                }
            }
            if(evt.getSource() == calculate){
                int flag = 0;
                int numColumn = Integer.parseInt(numVariable.getText());
                int numRow = (int) Math.pow(2, numColumn);
                int[] outputValues = new int[numRow];
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
                if(flag == 0){
                    alertDialogStyle(alertDialog, solveMap(numRow, outputValues));
                    int[][] karnaughMap = createKarnaughMap(numColumn, numRow, outputValues);
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
                    alertDialogStyle(alertDialog, "Please enter all fields and only numbers from 0 to 1.");
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
