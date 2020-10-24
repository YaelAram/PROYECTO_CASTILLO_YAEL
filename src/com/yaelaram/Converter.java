package com.yaelaram;

public class Converter {

    //System Converter
    public String fromDecimal(long number, int flag){
        StringBuilder stringBuilder = new StringBuilder();
        while(number > 0){
            long rest = number % flag;
            if(rest == 10){
                stringBuilder.insert(0, "A");
            }
            else if(rest == 11){
                stringBuilder.insert(0, "B");
            }
            else if(rest == 12){
                stringBuilder.insert(0, "C");
            }
            else if(rest == 13){
                stringBuilder.insert(0, "D");
            }
            else if(rest == 14){
                stringBuilder.insert(0, "E");
            }
            else if(rest == 15){
                stringBuilder.insert(0, "F");
            }
            else{
                stringBuilder.insert(0, rest);
            }
            number /= flag;
        }
        return stringBuilder.toString();
    }
    public long toDecimal(String number, int flag){
        long cont = 0;
        for(int i = 0 ; i<number.length() ; i++){
            char actualDigit = number.charAt(i);
            int aux;
            if(actualDigit == 'A' || actualDigit == 'a'){
                aux = 10;
            }
            else if(actualDigit == 'B' || actualDigit == 'b'){
                aux = 11;
            }
            else if(actualDigit == 'C' || actualDigit == 'c'){
                aux = 12;
            }
            else if(actualDigit == 'D' || actualDigit == 'd'){
                aux = 13;
            }
            else if(actualDigit == 'E' || actualDigit == 'e'){
                aux = 14;
            }
            else if(actualDigit == 'F' || actualDigit == 'f'){
                aux = 15;
            }
            else{
                aux = Integer.parseInt(String.valueOf(actualDigit));
            }
            double power = Math.pow(flag, (number.length() - (i + 1)));
            cont += (aux * power);
        }
        return cont;
    }
    public String converterBase(String number, int fromBase, int toBase){
        long toDecimalValue = toDecimal(number, fromBase);
        return fromDecimal(toDecimalValue, toBase);
    }

    //Unit Converter
    public String unitConverter(double fromValue, String stringFrom, String stringTo, int superIndexFrom, int superIndexTo){
        if(stringFrom.equalsIgnoreCase("Bit") && stringTo.equalsIgnoreCase("Nibble")){
            return String.valueOf(fromValue / 4.0);
        }
        else if(stringFrom.equalsIgnoreCase("Bit") && stringTo.equalsIgnoreCase("Byte")){
            return String.valueOf(fromValue / 8.0);
        }
        else if(stringFrom.equalsIgnoreCase("Nibble") && stringTo.equalsIgnoreCase("Bit")){
            return String.valueOf(fromValue * 4.0);
        }
        else if(stringFrom.equalsIgnoreCase("Nibble") && stringTo.equalsIgnoreCase("Byte")){
            return String.valueOf(fromValue / 2.0);
        }
        else if(stringFrom.equalsIgnoreCase("Byte") && stringTo.equalsIgnoreCase("Bit")){
            return String.valueOf(fromValue * 8.0);
        }
        else if(stringFrom.equalsIgnoreCase("Byte") && stringTo.equalsIgnoreCase("Nibble")){
            return String.valueOf(fromValue * 2.0);
        }
        else{
            if(stringFrom.equalsIgnoreCase("Bit")){
                fromValue /= 8.0;
            }
            else if(stringFrom.equalsIgnoreCase("Nibble")){
                fromValue /= 2.0;
            }
            int superIndex = superIndexFrom - superIndexTo;
            if(stringTo.equals("Bit")){
                return String.valueOf(fromValue * Math.pow(10, superIndex) * 8);
            }
            else if(stringTo.equals("Nibble")){
                return String.valueOf(fromValue * Math.pow(10, superIndex) * 2);
            }
            else{
                return String.valueOf(fromValue * Math.pow(10, superIndex));
            }
        }
    }

    //solveMap Method
    public String solveMap(int numRow, int[] outputValues, String[] outputValuesString){
        StringBuilder stringBuilder = new StringBuilder();
        String divider = " + ";
        for(int i = 0 ; i<numRow ; i++){
            if(outputValues[i] == 1){
                if(i != 0){
                    stringBuilder.append(divider);
                }
                String values = outputValuesString[i];
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
    public int[][] createKarnaughMap(int numColumn, int numRow, int[] outputValues, String[] outputValuesString){
        int[][] resultArray;
        if(numColumn == 2){
            resultArray = new int[numColumn][numColumn];
            for(int i = 0 ; i<numRow ; i++){
                if(outputValues[i] == 1){
                    String values = outputValuesString[i];
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
                    String values = outputValuesString[i];
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
                    String values = outputValuesString[i];
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
}
