package com.yaelaram;

public class Converter {

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
}
