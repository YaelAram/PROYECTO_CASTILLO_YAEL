package com.yaelaram;

public class Converter {

    //System Converter
    public String fromDecimal(long number, int flag){
        StringBuilder stringBuilder = new StringBuilder();
        while(number > 0){
            long rest = number % flag;
            if(rest >= 10 && rest <= 15){
                stringBuilder.insert(0, (char)(55 + rest));
            }
            else if(rest <= 9){
                stringBuilder.insert(0, rest);
            }
            else{
                return "ERROR";
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
            if((int)actualDigit >= 65 && (int)actualDigit <= 70){
                aux = (int)actualDigit - 55;
            }
            else if((int)actualDigit >= 48 && (int)actualDigit <= 57){
                aux = Integer.parseInt(String.valueOf(actualDigit));
            }
            else{
                return -1;
            }
            if(aux > (flag - 1)){
                return -1;
            }
            else {
                double power = Math.pow(flag, (number.length() - (i + 1)));
                cont += (aux * power);
            }
        }
        return cont;
    }
    public String converterBase(String number, int fromBase, int toBase){
        long toDecimalValue = toDecimal(number, fromBase);
        if(toDecimalValue != -1){
            String result = fromDecimal(toDecimalValue, toBase);
            if(result.equalsIgnoreCase("ERROR")){
                return "ERROR";
            }
            else{
                return result;
            }
        }
        else{
            return "ERROR";
        }
    }

    //Unit Converter
    public String unitConverter(double fromValue, String stringFrom, String stringTo, int superIndexFrom, int superIndexTo){
        if(stringFrom.equalsIgnoreCase("Bit")){
            fromValue /= 8.0;
        }
        else if(stringFrom.equalsIgnoreCase("Nibble")){
            fromValue /= 2.0;
        }
        int superIndex = superIndexFrom - superIndexTo;
        if(stringTo.equalsIgnoreCase("Bit")){
            return String.valueOf(fromValue * Math.pow(10, superIndex) * 8);
        }
        else if(stringTo.equalsIgnoreCase("Nibble")){
            return String.valueOf(fromValue * Math.pow(10, superIndex) * 2);
        }
        else{
            return String.valueOf(fromValue * Math.pow(10, superIndex));
        }
    }

    //solveMap Method
    public String solveMap(int numRow, int[] outputValues, String[] outputValuesString){
        StringBuilder stringBuilder = new StringBuilder();
        String divider = " + ";
        String[] positiveCharacter = {"A", "E", "O", "U"};
        String[] negativeCharacter = {"\u0100", "\u0112", "\u014C", "\u016A"};
        for(int i = 0 ; i<numRow ; i++){
            if(outputValues[i] == 1){
                if(stringBuilder.length() > 0){
                    stringBuilder.append(divider);
                }
                String values = outputValuesString[i];
                for(int j = 0 ; j<values.length() ; j++){
                    stringBuilder.append(values.substring(j).startsWith("1") ? positiveCharacter[j] : negativeCharacter[j]);
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
            resultArray = new int[numColumn][numColumn];
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
