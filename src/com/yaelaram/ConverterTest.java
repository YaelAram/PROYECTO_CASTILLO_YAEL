package com.yaelaram;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
//assertEquals() Compares value expected and value returned by the function, true if are equal
//assertNotEquals() Compares value expected and value returned by the function, true if aren't equal
//assertArrayEqual() Compares array element by element
//assertNull() and assertNotNull(), only parameter returned
//assertSame and assertNotSame, check if both instances are equal
//assertThat() Compares the value with a matcher

public class ConverterTest {

    Converter converter = new Converter();

    //fromDecimal method test
    @org.junit.Test
    public void fromDecimal_toBinary() {
        assertEquals("111010", converter.fromDecimal(58, 2));
        assertEquals("110101111", converter.fromDecimal(431, 2));
        assertEquals("1111011", converter.fromDecimal(123, 2));
        assertEquals("1101100111", converter.fromDecimal(871, 2));
        assertEquals("1000110111", converter.fromDecimal(567, 2));
    }

    @org.junit.Test
    public void fromDecimal_toQuaternary(){
        assertEquals("12130", converter.fromDecimal(412,4));
        assertEquals("20011", converter.fromDecimal(517,4));
        assertEquals("11121", converter.fromDecimal(345,4));
        assertEquals("33221", converter.fromDecimal(1001,4));
        assertEquals("3222", converter.fromDecimal(234,4));
    }

    @org.junit.Test
    public void fromDecimal_toOctal(){
        assertEquals("173", converter.fromDecimal(123, 8));
        assertEquals("645", converter.fromDecimal(421, 8));
        assertEquals("1512", converter.fromDecimal(842, 8));
        assertEquals("613", converter.fromDecimal(395, 8));
        assertEquals("137", converter.fromDecimal(95, 8));
    }

    @org.junit.Test
    public void fromDecimal_toHexadecimal(){
        assertEquals("2AE", converter.fromDecimal(686,16));
        assertEquals("321", converter.fromDecimal(801,16));
        assertEquals("4", converter.fromDecimal(4,16));
        assertEquals("C0", converter.fromDecimal(192,16));
        assertEquals("32F", converter.fromDecimal(815,16));
    }

    //toDecimal method test
    @org.junit.Test
    public void fromBinary_toDecimal() {
        assertEquals(408, converter.toDecimal("110011000", 2));
        assertEquals(968, converter.toDecimal("1111001000", 2));
        assertEquals(832, converter.toDecimal("1101000000", 2));
        assertEquals(803, converter.toDecimal("1100100011", 2));
        assertEquals(681, converter.toDecimal("1010101001", 2));
    }

    @org.junit.Test
    public void fromQuaternary_toDecimal() {
        assertEquals(116, converter.toDecimal("1310", 4));
        assertEquals(490, converter.toDecimal("13222", 4));
        assertEquals(93, converter.toDecimal("1131", 4));
        assertEquals(214, converter.toDecimal("3112", 4));
        assertEquals(290, converter.toDecimal("10202", 4));
    }

    @org.junit.Test
    public void fromOctal_toDecimal() {
        assertEquals(77, converter.toDecimal("115", 8));
        assertEquals(293, converter.toDecimal("445", 8));
        assertEquals(754, converter.toDecimal("1362", 8));
        assertEquals(740, converter.toDecimal("1344", 8));
        assertEquals(152, converter.toDecimal("230", 8));
    }

    @org.junit.Test
    public void fromHexadecimal_toDecimal() {
        assertEquals(857, converter.toDecimal("359", 16));
        assertEquals(619, converter.toDecimal("26B", 16));
        assertEquals(129, converter.toDecimal("81", 16));
        assertEquals(280, converter.toDecimal("118", 16));
        assertEquals(808, converter.toDecimal("328", 16));
    }

    //converterBase method test
    //fromBinary
    @org.junit.Test
    public void fromBinary_toQuaternary() {
        assertEquals("10022", converter.converterBase("100001010", 2, 4));
        assertEquals("310", converter.converterBase("110100", 2, 4));
        assertEquals("2332", converter.converterBase("10111110", 2, 4));
        assertEquals("3303", converter.converterBase("11110011", 2, 4));
        assertEquals("22020", converter.converterBase("1010001000", 2, 4));
    }

    @org.junit.Test
    public void fromBinary_toOctal() {
        assertEquals("423", converter.converterBase("100010011", 2, 8));
        assertEquals("1745", converter.converterBase("1111100101", 2, 8));
        assertEquals("1706", converter.converterBase("1111000110", 2, 8));
        assertEquals("115", converter.converterBase("1001101", 2, 8));
        assertEquals("603", converter.converterBase("110000011", 2, 8));
    }

    @org.junit.Test
    public void fromBinary_toHexadecimal() {
        assertEquals("CC", converter.converterBase("11001100", 2, 16));
        assertEquals("B2", converter.converterBase("10110010", 2, 16));
        assertEquals("AD", converter.converterBase("10101101", 2, 16));
        assertEquals("1F4", converter.converterBase("111110100", 2, 16));
        assertEquals("195", converter.converterBase("110010101", 2, 16));
    }

    //fromQuaternary
    @org.junit.Test
    public void fromQuaternary_toBinary(){
        assertEquals("1110110010", converter.converterBase("32302", 4, 2));
        assertEquals("1011101001", converter.converterBase("23221", 4, 2));
        assertEquals("1110001", converter.converterBase("1301", 4, 2));
        assertEquals("1011000", converter.converterBase("1120", 4, 2));
        assertEquals("1011101101", converter.converterBase("23231", 4, 2));
    }

    @org.junit.Test
    public void fromQuaternary_toOctal(){
        assertEquals("1574", converter.converterBase("31330", 4, 8));
        assertEquals("1161", converter.converterBase("21301", 4, 8));
        assertEquals("535", converter.converterBase("11131", 4, 8));
        assertEquals("705", converter.converterBase("13011", 4, 8));
        assertEquals("1602", converter.converterBase("32002", 4, 8));
    }

    @org.junit.Test
    public void fromQuaternary_toHexadecimal(){
        assertEquals("2A1", converter.converterBase("22201", 4, 16));
        assertEquals("1FC", converter.converterBase("13330", 4, 16));
        assertEquals("31B", converter.converterBase("30123", 4, 16));
        assertEquals("57", converter.converterBase("1113", 4, 16));
        assertEquals("115", converter.converterBase("10111", 4, 16));
    }

    //fromOctal
    @org.junit.Test
    public void fromOctal_toBinary(){
        assertEquals("100000110", converter.converterBase("406", 8, 2));
        assertEquals("1101010010", converter.converterBase("1522", 8, 2));
        assertEquals("110011010", converter.converterBase("632", 8, 2));
        assertEquals("1000011110", converter.converterBase("1036", 8, 2));
        assertEquals("100011100", converter.converterBase("434", 8, 2));
    }

    @org.junit.Test
    public void fromOctal_toQuaternary(){
        assertEquals("23222", converter.converterBase("1352", 8, 4));
        assertEquals("22123", converter.converterBase("1233", 8, 4));
        assertEquals("23220", converter.converterBase("1350", 8, 4));
        assertEquals("13312", converter.converterBase("766", 8, 4));
        assertEquals("13310", converter.converterBase("764", 8, 4));
    }

    @org.junit.Test
    public void fromOctal_toHexadecimal(){
        assertEquals("16E", converter.converterBase("556", 8, 16));
        assertEquals("372", converter.converterBase("1562", 8, 16));
        assertEquals("24B", converter.converterBase("1113", 8, 16));
        assertEquals("1B4", converter.converterBase("664", 8, 16));
        assertEquals("AD", converter.converterBase("255", 8, 16));
    }

    //fromHexadecimal
    @org.junit.Test
    public void fromHexadecimal_toBinary(){
        assertEquals("1000010011", converter.converterBase("213", 16, 2));
        assertEquals("10001110", converter.converterBase("8E", 16, 2));
        assertEquals("100011001011", converter.converterBase("8CB", 16, 2));
        assertEquals("1101100", converter.converterBase("6C", 16, 2));
        assertEquals("111001010", converter.converterBase("1CA", 16, 2));
    }

    @org.junit.Test
    public void fromHexadecimal_toQuaternary(){
        assertEquals("11101", converter.converterBase("151", 16, 4));
        assertEquals("20000", converter.converterBase("200", 16, 4));
        assertEquals("330", converter.converterBase("3C", 16, 4));
        assertEquals("31012", converter.converterBase("346", 16, 4));
        assertEquals("12230", converter.converterBase("1AC", 16, 4));
    }

    @org.junit.Test
    public void fromHexadecimal_toOctal(){
        assertEquals("1567", converter.converterBase("377", 16, 8));
        assertEquals("1520", converter.converterBase("350", 16, 8));
        assertEquals("103", converter.converterBase("43", 16, 8));
        assertEquals("346", converter.converterBase("E6", 16, 8));
        assertEquals("412", converter.converterBase("10A", 16, 8));
    }

    //unitConverter method test
    //fromBit
    @org.junit.Test
    public void fromBit_toNibble() {
        double result = Double.parseDouble(converter.unitConverter(210053, "Bit", "Nibble", 0, 0));
        assertEquals(52513.25, result, 0.01);
        result = Double.parseDouble(converter.unitConverter(368725, "Bit", "Nibble", 0, 0));
        assertEquals(92181.25, result, 0.01);
        result = Double.parseDouble(converter.unitConverter(140014, "Bit", "Nibble", 0, 0));
        assertEquals(35003.5, result, 0.01);
        result = Double.parseDouble(converter.unitConverter(291791, "Bit", "Nibble", 0, 0));
        assertEquals(72947.75, result, 0.01);
        result = Double.parseDouble(converter.unitConverter(91828, "Bit", "Nibble", 0, 0));
        assertEquals(22957, result, 0.01);
    }

    @org.junit.Test
    public void fromBit_toByte(){
        double result = Double.parseDouble(converter.unitConverter(483500, "Bit", "Byte", 0, 0));
        assertEquals(60437.5, result, 0.01);
        result = Double.parseDouble(converter.unitConverter(323320, "Bit", "Byte", 0, 0));
        assertEquals(40415, result, 0.01);
        result = Double.parseDouble(converter.unitConverter(829840, "Bit", "Byte", 0, 0));
        assertEquals(103730, result, 0.01);
        result = Double.parseDouble(converter.unitConverter(462631, "Bit", "Byte", 0, 0));
        assertEquals(57828.875, result, 0.01);
        result = Double.parseDouble(converter.unitConverter(900079, "Bit", "Byte", 0, 0));
        assertEquals(112509.875, result, 0.01);
    }

    @org.junit.Test
    public void fromBit_toKilobyte(){
        double result = Double.parseDouble(converter.unitConverter(496202, "Bit", "Kilobyte", 0, 3));
        assertEquals(62.02525, result, 0.01);
        result = Double.parseDouble(converter.unitConverter(330539, "Bit", "Kilobyte", 0, 3));
        assertEquals(41.317375, result, 0.01);
        result = Double.parseDouble(converter.unitConverter(512415, "Bit", "Kilobyte", 0, 3));
        assertEquals(64.051875, result, 0.01);
        result = Double.parseDouble(converter.unitConverter(984151, "Bit", "Kilobyte", 0, 3));
        assertEquals(123.018875, result, 0.01);
        result = Double.parseDouble(converter.unitConverter(174743, "Bit", "Kilobyte", 0, 3));
        assertEquals(21.842875, result, 0.01);
    }

    @org.junit.Test
    public void fromBit_toMegabyte(){
        double result = Double.parseDouble(converter.unitConverter(963848, "Bit", "Megabyte", 0, 6));
        assertEquals(0.120481, result, 0.01);
        result = Double.parseDouble(converter.unitConverter(786597, "Bit", "Megabyte", 0, 6));
        assertEquals(0.098324625, result, 0.01);
        result = Double.parseDouble(converter.unitConverter(59175, "Bit", "Megabyte", 0, 6));
        assertEquals(0.007396875, result, 0.01);
        result = Double.parseDouble(converter.unitConverter(17391, "Bit", "Megabyte", 0, 6));
        assertEquals(0.002173875, result, 0.01);
        result = Double.parseDouble(converter.unitConverter(73667, "Bit", "Megabyte", 0, 6));
        assertEquals(0.009208375, result, 0.01);
    }

    @org.junit.Test
    public void fromBit_toGigabyte(){
        double result = Double.parseDouble(converter.unitConverter(30075403, "Bit", "Gigabyte", 0, 9));
        assertEquals(0.003759425375, result, 1e-4);
        result = Double.parseDouble(converter.unitConverter(72544657, "Bit", "Gigabyte", 0, 9));
        assertEquals(0.009068082125, result, 1e-4);
        result = Double.parseDouble(converter.unitConverter(28055555, "Bit", "Gigabyte", 0, 9));
        assertEquals(0.003506944375, result, 1e-4);
        result = Double.parseDouble(converter.unitConverter(32379630, "Bit", "Gigabyte", 0, 9));
        assertEquals(0.00404745375, result, 1e-4);
        result = Double.parseDouble(converter.unitConverter(86688731, "Bit", "Gigabyte", 0, 9));
        assertEquals(0.010836091375, result, 1e-4);
    }

    @org.junit.Test
    public void fromBit_toTerabyte(){
        double result = Double.parseDouble(converter.unitConverter(927584655, "Bit", "Terabyte", 0, 12));
        assertEquals(0.000115948081875, result, 1e-5);
        result = Double.parseDouble(converter.unitConverter(643615425, "Bit", "Terabyte", 0, 12));
        assertEquals(8.0451928125e-5, result, 1e-6);
        result = Double.parseDouble(converter.unitConverter(669845032, "Bit", "Terabyte", 0, 12));
        assertEquals(8.3730629e-5, result, 1e-6);
        result = Double.parseDouble(converter.unitConverter(774595157, "Bit", "Terabyte", 0, 12));
        assertEquals(9.6824394625e-5, result, 1e-6);
        result = Double.parseDouble(converter.unitConverter(968440841, "Bit", "Terabyte", 0, 12));
        assertEquals(0.000121055105125, result, 1e-5);
    }

    @org.junit.Test
    public void fromBit_toPetabyte(){
        double result = Double.parseDouble(converter.unitConverter(833116215, "Bit", "Petabyte", 0, 15));
        assertEquals(1.0413952687e-7, result, 1e-8);
        result = Double.parseDouble(converter.unitConverter(946590559, "Bit", "Petabyte", 0, 15));
        assertEquals(1.1832381988e-7, result, 1e-8);
        result = Double.parseDouble(converter.unitConverter(578186588, "Bit", "Petabyte", 0, 15));
        assertEquals(7.22733235e-8, result, 1e-9);
        result = Double.parseDouble(converter.unitConverter(923612606, "Bit", "Petabyte", 0, 15));
        assertEquals(1.1545157575e-7, result, 1e-8);
        result = Double.parseDouble(converter.unitConverter(588297620, "Bit", "Petabyte", 0, 15));
        assertEquals(7.35372025e-8, result, 1e-9);
    }

    @org.junit.Test
    public void fromBit_toExabyte(){
        double result = Double.parseDouble(converter.unitConverter(608782229, "Bit", "Exabyte", 0, 18));
        assertEquals(7.6097778625e-11, result, 1e-12);
        result = Double.parseDouble(converter.unitConverter(736435221, "Bit", "Exabyte", 0, 18));
        assertEquals(9.2054402625e-11, result, 1e-12);
        result = Double.parseDouble(converter.unitConverter(558729407, "Bit", "Exabyte", 0, 18));
        assertEquals(6.9841175875e-11, result, 1e-12);
        result = Double.parseDouble(converter.unitConverter(762515339, "Bit", "Exabyte", 0, 18));
        assertEquals(9.5314417375e-11, result, 1e-12);
        result = Double.parseDouble(converter.unitConverter(591528223, "Bit", "Exabyte", 0, 18));
        assertEquals(7.3941027875e-11, result, 1e-12);
    }

    @org.junit.Test
    public void fromBit_toZettabyte(){
        double result = Double.parseDouble(converter.unitConverter(691867413, "Bit", "Zettabyte", 0, 21));
        assertEquals(8.6483426625e-14, result, 1e-15);
        result = Double.parseDouble(converter.unitConverter(999812690, "Bit", "Zettabyte", 0, 21));
        assertEquals(1.2497658625e-13, result, 1e-14);
        result = Double.parseDouble(converter.unitConverter(774382527, "Bit", "Zettabyte", 0, 21));
        assertEquals(9.6797815875e-14, result, 1e-15);
        result = Double.parseDouble(converter.unitConverter(891759726, "Bit", "Zettabyte", 0, 21));
        assertEquals(1.1146996575e-13, result, 1e-14);
        result = Double.parseDouble(converter.unitConverter(870963469, "Bit", "Zettabyte", 0, 21));
        assertEquals(1.0887043363e-13, result, 1e-14);
    }

    @org.junit.Test
    public void fromBit_toYottabyte(){
        double result = Double.parseDouble(converter.unitConverter(622996876, "Bit", "Yottabyte", 0, 24));
        assertEquals(7.78746095e-17, result, 1e-18);
        result = Double.parseDouble(converter.unitConverter(616269730, "Bit", "Yottabyte", 0, 24));
        assertEquals(7.703371625e-17, result, 1e-18);
        result = Double.parseDouble(converter.unitConverter(836609768, "Bit", "Yottabyte", 0, 24));
        assertEquals(1.04576221e-16, result, 1e-17);
        result = Double.parseDouble(converter.unitConverter(797135566, "Bit", "Yottabyte", 0, 24));
        assertEquals(9.964194575e-17, result, 1e-18);
        result = Double.parseDouble(converter.unitConverter(585739889, "Bit", "Yottabyte", 0, 24));
        assertEquals(7.3217486125e-17, result, 1e-18);
    }

    //fromNibble
    @org.junit.Test
    public void fromNibble_toBit(){
        double result = Double.parseDouble(converter.unitConverter(626868, "Nibble", "Bit", 0, 0));
        assertEquals(2507472, result, 0);
        result = Double.parseDouble(converter.unitConverter(698692, "Nibble", "Bit", 0, 0));
        assertEquals(2794768, result, 0);
        result = Double.parseDouble(converter.unitConverter(830694, "Nibble", "Bit", 0, 0));
        assertEquals(3322776, result, 0);
        result = Double.parseDouble(converter.unitConverter(829044, "Nibble", "Bit", 0, 0));
        assertEquals(3316176, result, 0);
        result = Double.parseDouble(converter.unitConverter(797325, "Nibble", "Bit", 0, 0));
        assertEquals(3189300, result, 0);
    }

    @org.junit.Test
    public void fromNibble_toByte(){
        double result = Double.parseDouble(converter.unitConverter(944779, "Nibble", "Byte", 0, 0));
        assertEquals(472389.5, result, 0);
        result = Double.parseDouble(converter.unitConverter(701430, "Nibble", "Byte", 0, 0));
        assertEquals(350715, result, 0);
        result = Double.parseDouble(converter.unitConverter(611676, "Nibble", "Byte", 0, 0));
        assertEquals(305838, result, 0);
        result = Double.parseDouble(converter.unitConverter(593517, "Nibble", "Byte", 0, 0));
        assertEquals(296758.5, result, 0);
        result = Double.parseDouble(converter.unitConverter(920166, "Nibble", "Byte", 0, 0));
        assertEquals(460083, result, 0);
    }

    @org.junit.Test
    public void fromNibble_toKilobyte(){
        double result = Double.parseDouble(converter.unitConverter(739667, "Nibble", "Kilobyte", 0, 3));
        assertEquals(369.8335, result, 0.001);
        result = Double.parseDouble(converter.unitConverter(561960, "Nibble", "Kilobyte", 0, 3));
        assertEquals(280.98, result, 0.001);
        result = Double.parseDouble(converter.unitConverter(949433, "Nibble", "Kilobyte", 0, 3));
        assertEquals(474.7165, result, 0.001);
        result = Double.parseDouble(converter.unitConverter(992512, "Nibble", "Kilobyte", 0, 3));
        assertEquals(496.256, result, 0.001);
        result = Double.parseDouble(converter.unitConverter(850245, "Nibble", "Kilobyte", 0, 3));
        assertEquals(425.1225, result, 0.001);
    }

    @org.junit.Test
    public void fromNibble_toMegabyte(){
        double result = Double.parseDouble(converter.unitConverter(604021, "Nibble", "Megabyte", 0, 6));
        assertEquals(0.3020105, result, 0.001);
        result = Double.parseDouble(converter.unitConverter(955232, "Nibble", "Megabyte", 0, 6));
        assertEquals(0.477616, result, 0.001);
        result = Double.parseDouble(converter.unitConverter(824007, "Nibble", "Megabyte", 0, 6));
        assertEquals(0.4120035, result, 0.001);
        result = Double.parseDouble(converter.unitConverter(959768, "Nibble", "Megabyte", 0, 6));
        assertEquals(0.479884, result, 0.001);
        result = Double.parseDouble(converter.unitConverter(637443, "Nibble", "Megabyte", 0, 6));
        assertEquals(0.3187215, result, 0.001);
    }

    @org.junit.Test
    public void fromNibble_toGigabyte(){
        double result = Double.parseDouble(converter.unitConverter(800051, "Nibble", "Gigabyte", 0, 9));
        assertEquals(0.0004000255, result, 1e-5);
        result = Double.parseDouble(converter.unitConverter(979084, "Nibble", "Gigabyte", 0, 9));
        assertEquals(0.000489542, result, 1e-5);
        result = Double.parseDouble(converter.unitConverter(680174, "Nibble", "Gigabyte", 0, 9));
        assertEquals(0.000340087, result, 1e-5);
        result = Double.parseDouble(converter.unitConverter(616357, "Nibble", "Gigabyte", 0, 9));
        assertEquals(0.0003081785, result, 1e-5);
        result = Double.parseDouble(converter.unitConverter(960478, "Nibble", "Gigabyte", 0, 9));
        assertEquals(0.000480239, result, 1e-5);
    }

    @org.junit.Test
    public void fromNibble_toTerabyte(){
        double result = Double.parseDouble(converter.unitConverter(722108, "Nibble", "Terabyte", 0, 12));
        assertEquals(3.61054e-7, result, 1e-8);
        result = Double.parseDouble(converter.unitConverter(571759, "Nibble", "Terabyte", 0, 12));
        assertEquals(2.858795e-7, result, 1e-8);
        result = Double.parseDouble(converter.unitConverter(888108, "Nibble", "Terabyte", 0, 12));
        assertEquals(4.44054e-7, result, 1e-8);
        result = Double.parseDouble(converter.unitConverter(730785, "Nibble", "Terabyte", 0, 12));
        assertEquals(3.653925e-7, result, 1e-8);
        result = Double.parseDouble(converter.unitConverter(951287, "Nibble", "Terabyte", 0, 12));
        assertEquals(4.756435e-7, result, 1e-8);
    }

    @org.junit.Test
    public void fromNibble_toPetabyte(){
        double result = Double.parseDouble(converter.unitConverter(798288, "Nibble", "Petabyte", 0, 15));
        assertEquals(3.99144e-10, result, 1e-11);
        result = Double.parseDouble(converter.unitConverter(717723, "Nibble", "Petabyte", 0, 15));
        assertEquals(3.588615e-10, result, 1e-11);
        result = Double.parseDouble(converter.unitConverter(846872, "Nibble", "Petabyte", 0, 15));
        assertEquals(4.23436e-10, result, 1e-11);
        result = Double.parseDouble(converter.unitConverter(561829, "Nibble", "Petabyte", 0, 15));
        assertEquals(2.809145e-10, result, 1e-11);
        result = Double.parseDouble(converter.unitConverter(815784, "Nibble", "Petabyte", 0, 15));
        assertEquals(4.07892e-10, result, 1e-11);
    }

    @org.junit.Test
    public void fromNibble_toExabyte(){
        double result = Double.parseDouble(converter.unitConverter(70773259, "Nibble", "Exabyte", 0, 18));
        assertEquals(3.53866295e-11, result, 1e-12);
        result = Double.parseDouble(converter.unitConverter(95315502, "Nibble", "Exabyte", 0, 18));
        assertEquals(4.7657751e-11, result, 1e-12);
        result = Double.parseDouble(converter.unitConverter(65652945, "Nibble", "Exabyte", 0, 18));
        assertEquals(3.28264725e-11, result, 1e-12);
        result = Double.parseDouble(converter.unitConverter(76399361, "Nibble", "Exabyte", 0, 18));
        assertEquals(3.81996805e-11, result, 1e-12);
        result = Double.parseDouble(converter.unitConverter(79270163, "Nibble", "Exabyte", 0, 18));
        assertEquals(3.96350815e-11, result, 1e-12);
    }

    @org.junit.Test
    public void fromNibble_toZettabyte(){
        double result = Double.parseDouble(converter.unitConverter(688973743, "Nibble", "Zettabyte", 0, 21));
        assertEquals(3.444868715e-13, result, 1e-14);
        result = Double.parseDouble(converter.unitConverter(754158603, "Nibble", "Zettabyte", 0, 21));
        assertEquals(3.770793015e-13, result, 1e-14);
        result = Double.parseDouble(converter.unitConverter(653765255, "Nibble", "Zettabyte", 0, 21));
        assertEquals(3.268826275e-13, result, 1e-14);
        result = Double.parseDouble(converter.unitConverter(903951512, "Nibble", "Zettabyte", 0, 21));
        assertEquals(4.51975756e-13, result, 1e-14);
        result = Double.parseDouble(converter.unitConverter(843342957, "Nibble", "Zettabyte", 0, 21));
        assertEquals(4.216714785e-13, result, 1e-14);
    }

    @org.junit.Test
    public void fromNibble_toYottabyte(){
        double result = Double.parseDouble(converter.unitConverter(805541932, "Nibble", "Yottabyte", 0, 24));
        assertEquals(4.02770966e-16, result, 1e-17);
        result = Double.parseDouble(converter.unitConverter(623503528, "Nibble", "Yottabyte", 0, 24));
        assertEquals(3.11751764e-16, result, 1e-17);
        result = Double.parseDouble(converter.unitConverter(775827134, "Nibble", "Yottabyte", 0, 24));
        assertEquals(3.87913567e-16, result, 1e-17);
        result = Double.parseDouble(converter.unitConverter(563124569, "Nibble", "Yottabyte", 0, 24));
        assertEquals(2.815622845e-16, result, 1e-17);
        result = Double.parseDouble(converter.unitConverter(631042179, "Nibble", "Yottabyte", 0, 24));
        assertEquals(3.155210895e-16, result, 1e-17);
    }

    //fromByte
    @org.junit.Test
    public void fromByte_toBit(){
        double result = Double.parseDouble(converter.unitConverter(576055, "Byte", "Bit", 0, 0));
        assertEquals(4608440, result, 0);
        result = Double.parseDouble(converter.unitConverter(930695, "Byte", "Bit", 0, 0));
        assertEquals(7445560, result, 0);
        result = Double.parseDouble(converter.unitConverter(906170, "Byte", "Bit", 0, 0));
        assertEquals(7249360, result, 0);
        result = Double.parseDouble(converter.unitConverter(655319, "Byte", "Bit", 0, 0));
        assertEquals(5242552, result, 0);
        result = Double.parseDouble(converter.unitConverter(959089, "Byte", "Bit", 0, 0));
        assertEquals(7672712, result, 0);
    }

    @org.junit.Test
    public void fromByte_toNibble(){
        double result = Double.parseDouble(converter.unitConverter(565286, "Byte", "Nibble", 0, 0));
        assertEquals(1130572, result, 0);
        result = Double.parseDouble(converter.unitConverter(903327, "Byte", "Nibble", 0, 0));
        assertEquals(1806654, result, 0);
        result = Double.parseDouble(converter.unitConverter(723838, "Byte", "Nibble", 0, 0));
        assertEquals(1447676, result, 0);
        result = Double.parseDouble(converter.unitConverter(718680, "Byte", "Nibble", 0, 0));
        assertEquals(1437360, result, 0);
        result = Double.parseDouble(converter.unitConverter(643736, "Byte", "Nibble", 0, 0));
        assertEquals(1287472, result, 0);
    }

    @org.junit.Test
    public void fromByte_toKilobyte(){
        double result = Double.parseDouble(converter.unitConverter(806506, "Byte", "Kilobyte", 0, 3));
        assertEquals(806.506, result, 0.01);
        result = Double.parseDouble(converter.unitConverter(684532, "Byte", "Kilobyte", 0, 3));
        assertEquals(684.532, result, 0.01);
        result = Double.parseDouble(converter.unitConverter(733521, "Byte", "Kilobyte", 0, 3));
        assertEquals(733.521, result, 0.01);
        result = Double.parseDouble(converter.unitConverter(657416, "Byte", "Kilobyte", 0, 3));
        assertEquals(657.416, result, 0.01);
        result = Double.parseDouble(converter.unitConverter(628513, "Byte", "Kilobyte", 0, 3));
        assertEquals(628.513, result, 0.01);
    }

    @org.junit.Test
    public void fromByte_toMegabyte(){
        double result = Double.parseDouble(converter.unitConverter(828073, "Byte", "Megabyte", 0, 6));
        assertEquals(0.828073, result, 1e-4);
        result = Double.parseDouble(converter.unitConverter(937157, "Byte", "Megabyte", 0, 6));
        assertEquals(0.937157, result, 1e-4);
        result = Double.parseDouble(converter.unitConverter(610468, "Byte", "Megabyte", 0, 6));
        assertEquals(0.610468, result, 1e-4);
        result = Double.parseDouble(converter.unitConverter(908210, "Byte", "Megabyte", 0, 6));
        assertEquals(0.90821, result, 1e-4);
        result = Double.parseDouble(converter.unitConverter(819616, "Byte", "Megabyte", 0, 6));
        assertEquals(0.819616, result, 1e-4);
    }

    @org.junit.Test
    public void fromByte_toGigabyte(){
        double result = Double.parseDouble(converter.unitConverter(591503846, "Byte", "Gigabyte", 0, 9));
        assertEquals(0.591503846, result, 1e-4);
        result = Double.parseDouble(converter.unitConverter(673092566, "Byte", "Gigabyte", 0, 9));
        assertEquals(0.673092566, result, 1e-4);
        result = Double.parseDouble(converter.unitConverter(980636683, "Byte", "Gigabyte", 0, 9));
        assertEquals(0.980636683, result, 1e-4);
        result = Double.parseDouble(converter.unitConverter(561047590, "Byte", "Gigabyte", 0, 9));
        assertEquals(0.56104759, result, 1e-4);
        result = Double.parseDouble(converter.unitConverter(715598565, "Byte", "Gigabyte", 0, 9));
        assertEquals(0.715598565, result, 1e-4);
    }

    @org.junit.Test
    public void fromByte_toTerabyte(){
        double result = Double.parseDouble(converter.unitConverter(747077527, "Byte", "Terabyte", 0, 12));
        assertEquals(0.000747077527, result, 1e-5);
        result = Double.parseDouble(converter.unitConverter(855361229, "Byte", "Terabyte", 0, 12));
        assertEquals(0.000855361229, result, 1e-5);
        result = Double.parseDouble(converter.unitConverter(762458573, "Byte", "Terabyte", 0, 12));
        assertEquals(0.000762458573, result, 1e-5);
        result = Double.parseDouble(converter.unitConverter(947962401, "Byte", "Terabyte", 0, 12));
        assertEquals(0.000947962401, result, 1e-5);
        result = Double.parseDouble(converter.unitConverter(721654138, "Byte", "Terabyte", 0, 12));
        assertEquals(0.000721654138, result, 1e-5);
    }

    @org.junit.Test
    public void fromByte_toPetabyte(){
        double result = Double.parseDouble(converter.unitConverter(962208554, "Byte", "Petabyte", 0, 15));
        assertEquals(9.62208554e-7, result, 1e-8);
        result = Double.parseDouble(converter.unitConverter(631605286, "Byte", "Petabyte", 0, 15));
        assertEquals(6.31605286e-7, result, 1e-8);
        result = Double.parseDouble(converter.unitConverter(719816876, "Byte", "Petabyte", 0, 15));
        assertEquals(7.19816876e-7, result, 1e-8);
        result = Double.parseDouble(converter.unitConverter(937515346, "Byte", "Petabyte", 0, 15));
        assertEquals(9.37515346e-7, result, 1e-8);
        result = Double.parseDouble(converter.unitConverter(776627751, "Byte", "Petabyte", 0, 15));
        assertEquals(7.76627751e-7, result, 1e-8);
    }

    @org.junit.Test
    public void fromByte_toExabyte(){
        double result = Double.parseDouble(converter.unitConverter(794125830, "Byte", "Exabyte", 0, 18));
        assertEquals(7.9412583e-10, result, 1e-11);
        result = Double.parseDouble(converter.unitConverter(984789689, "Byte", "Exabyte", 0, 18));
        assertEquals(9.84789689e-10, result, 1e-11);
        result = Double.parseDouble(converter.unitConverter(644067265, "Byte", "Exabyte", 0, 18));
        assertEquals(6.44067265e-10, result, 1e-11);
        result = Double.parseDouble(converter.unitConverter(827518725, "Byte", "Exabyte", 0, 18));
        assertEquals(8.27518725e-10, result, 1e-11);
        result = Double.parseDouble(converter.unitConverter(789385538, "Byte", "Exabyte", 0, 18));
        assertEquals(7.89385538e-10, result, 1e-11);
    }

    @org.junit.Test
    public void fromByte_toZettabyte(){
        double result = Double.parseDouble(converter.unitConverter(687641373, "Byte", "Zettabyte", 0, 21));
        assertEquals(6.87641373e-13, result, 1e-14);
        result = Double.parseDouble(converter.unitConverter(629143602, "Byte", "Zettabyte", 0, 21));
        assertEquals(6.29143602e-13, result, 1e-14);
        result = Double.parseDouble(converter.unitConverter(584644394, "Byte", "Zettabyte", 0, 21));
        assertEquals(5.84644394e-13, result, 1e-14);
        result = Double.parseDouble(converter.unitConverter(749151512, "Byte", "Zettabyte", 0, 21));
        assertEquals(7.49151512e-13, result, 1e-14);
        result = Double.parseDouble(converter.unitConverter(658082551, "Byte", "Zettabyte", 0, 21));
        assertEquals(6.58082551e-13, result, 1e-14);
    }

    @org.junit.Test
    public void fromByte_toYottabyte(){
        double result = Double.parseDouble(converter.unitConverter(760481311, "Byte", "Yottabyte", 0, 24));
        assertEquals(7.60481311e-16, result, 1e-17);
        result = Double.parseDouble(converter.unitConverter(650809313, "Byte", "Yottabyte", 0, 24));
        assertEquals(6.50809313e-16, result, 1e-17);
        result = Double.parseDouble(converter.unitConverter(557023908, "Byte", "Yottabyte", 0, 24));
        assertEquals(5.57023908e-16, result, 1e-17);
        result = Double.parseDouble(converter.unitConverter(606601829, "Byte", "Yottabyte", 0, 24));
        assertEquals(6.06601829e-16, result, 1e-17);
        result = Double.parseDouble(converter.unitConverter(635291850, "Byte", "Yottabyte", 0, 24));
        assertEquals(6.3529185e-16, result, 1e-17);
    }

    //fromKilobyte
    @org.junit.Test
    public void fromKilobyte_toBit(){
        double result = Double.parseDouble(converter.unitConverter(845117, "Kilobyte", "Bit", 3, 0));
        assertEquals(6.760936e+9, result, 0);
        result = Double.parseDouble(converter.unitConverter(610657, "Kilobyte", "Bit", 3, 0));
        assertEquals(4.885256e+9, result, 0);
        result = Double.parseDouble(converter.unitConverter(729973, "Kilobyte", "Bit", 3, 0));
        assertEquals(5.839784e+9, result, 0);
        result = Double.parseDouble(converter.unitConverter(925677, "Kilobyte", "Bit", 3, 0));
        assertEquals(7.405416e+9, result, 0);
        result = Double.parseDouble(converter.unitConverter(809920, "Kilobyte", "Bit", 3, 0));
        assertEquals(6.47936e+9, result, 0);
    }

    @org.junit.Test
    public void fromKilobyte_toNibble(){
        double result = Double.parseDouble(converter.unitConverter(849983, "Kilobyte", "Nibble", 3, 0));
        assertEquals(1.699966e+9, result, 0);
        result = Double.parseDouble(converter.unitConverter(953651, "Kilobyte", "Nibble", 3, 0));
        assertEquals(1.907302e+9, result, 0);
        result = Double.parseDouble(converter.unitConverter(629355, "Kilobyte", "Nibble", 3, 0));
        assertEquals(1.25871e+9, result, 0);
        result = Double.parseDouble(converter.unitConverter(775071, "Kilobyte", "Nibble", 3, 0));
        assertEquals(1.550142e+9, result, 0);
        result = Double.parseDouble(converter.unitConverter(710189, "Kilobyte", "Nibble", 3, 0));
        assertEquals(1.420378e+9, result, 0);
    }

    @org.junit.Test
    public void fromKilobyte_toMegabyte(){
        double result = Double.parseDouble(converter.unitConverter(793858, "Kilobyte", "Megabyte", 3, 6));
        assertEquals(793.858, result, 0.01);
        result = Double.parseDouble(converter.unitConverter(879204, "Kilobyte", "Megabyte", 3, 6));
        assertEquals(879.204, result, 0.01);
        result = Double.parseDouble(converter.unitConverter(659321, "Kilobyte", "Megabyte", 3, 6));
        assertEquals(659.321, result, 0.01);
        result = Double.parseDouble(converter.unitConverter(555860, "Kilobyte", "Megabyte", 3, 6));
        assertEquals(555.86, result, 0.01);
        result = Double.parseDouble(converter.unitConverter(792246, "Kilobyte", "Megabyte", 3, 6));
        assertEquals(792.246, result, 0.01);
    }

    @org.junit.Test
    public void fromKilobyte_toGigabyte(){
        double result = Double.parseDouble(converter.unitConverter(806516, "Kilobyte", "Gigabyte", 3, 9));
        assertEquals(0.806516, result, 0.001);
        result = Double.parseDouble(converter.unitConverter(688290, "Kilobyte", "Gigabyte", 3, 9));
        assertEquals(0.68829, result, 0.001);
        result = Double.parseDouble(converter.unitConverter(593093, "Kilobyte", "Gigabyte", 3, 9));
        assertEquals(0.593093, result, 0.001);
        result = Double.parseDouble(converter.unitConverter(965655, "Kilobyte", "Gigabyte", 3, 9));
        assertEquals(0.965655, result, 0.001);
        result = Double.parseDouble(converter.unitConverter(834152, "Kilobyte", "Gigabyte", 3, 9));
        assertEquals(0.834152, result, 0.001);
    }

    @org.junit.Test
    public void fromKilobyte_toTerabyte(){
        double result = Double.parseDouble(converter.unitConverter(657208, "Kilobyte", "Terabyte", 3, 12));
        assertEquals(0.000657208, result, 1e-5);
        result = Double.parseDouble(converter.unitConverter(890256, "Kilobyte", "Terabyte", 3, 12));
        assertEquals(0.000890256, result, 1e-5);
        result = Double.parseDouble(converter.unitConverter(758006, "Kilobyte", "Terabyte", 3, 12));
        assertEquals(0.000758006, result, 1e-5);
        result = Double.parseDouble(converter.unitConverter(678735, "Kilobyte", "Terabyte", 3, 12));
        assertEquals(0.000678735, result, 1e-5);
        result = Double.parseDouble(converter.unitConverter(910939, "Kilobyte", "Terabyte", 3, 12));
        assertEquals(0.000910939, result, 1e-5);
    }

    @org.junit.Test
    public void fromKilobyte_toPetabyte(){
        double result = Double.parseDouble(converter.unitConverter(971138180, "Kilobyte", "Petabyte", 3, 15));
        assertEquals(0.00097113818, result, 1e-5);
        result = Double.parseDouble(converter.unitConverter(771024776, "Kilobyte", "Petabyte", 3, 15));
        assertEquals(0.000771024776, result, 1e-5);
        result = Double.parseDouble(converter.unitConverter(780090017, "Kilobyte", "Petabyte", 3, 15));
        assertEquals(0.000780090017, result, 1e-5);
        result = Double.parseDouble(converter.unitConverter(829661018, "Kilobyte", "Petabyte", 3, 15));
        assertEquals(0.000829661018, result, 1e-5);
        result = Double.parseDouble(converter.unitConverter(577957209, "Kilobyte", "Petabyte", 3, 15));
        assertEquals(0.000577957209, result, 1e-5);
    }

    @org.junit.Test
    public void fromKilobyte_toExabyte(){
        double result = Double.parseDouble(converter.unitConverter(885517023, "Kilobyte", "Exabyte", 3, 18));
        assertEquals(8.85517023e-7, result, 1e-8);
        result = Double.parseDouble(converter.unitConverter(606791002, "Kilobyte", "Exabyte", 3, 18));
        assertEquals(6.06791002e-7, result, 1e-8);
        result = Double.parseDouble(converter.unitConverter(677752118, "Kilobyte", "Exabyte", 3, 18));
        assertEquals(6.77752118e-7, result, 1e-8);
        result = Double.parseDouble(converter.unitConverter(589099898, "Kilobyte", "Exabyte", 3, 18));
        assertEquals(5.89099898e-7, result, 1e-8);
        result = Double.parseDouble(converter.unitConverter(574991774, "Kilobyte", "Exabyte", 3, 18));
        assertEquals(5.74991774e-7, result, 1e-8);
    }

    @org.junit.Test
    public void fromKilobyte_toZettabyte(){
        double result = Double.parseDouble(converter.unitConverter(715654863, "Kilobyte", "Zettabyte", 3, 21));
        assertEquals(7.15654863e-10, result, 1e-11);
        result = Double.parseDouble(converter.unitConverter(905420706, "Kilobyte", "Zettabyte", 3, 21));
        assertEquals(9.05420706e-10, result, 1e-11);
        result = Double.parseDouble(converter.unitConverter(810970890, "Kilobyte", "Zettabyte", 3, 21));
        assertEquals(8.1097089e-10, result, 1e-11);
        result = Double.parseDouble(converter.unitConverter(922112387, "Kilobyte", "Zettabyte", 3, 21));
        assertEquals(9.22112387e-10, result, 1e-11);
        result = Double.parseDouble(converter.unitConverter(669529967, "Kilobyte", "Zettabyte", 3, 21));
        assertEquals(6.69529967e-10, result, 1e-11);
    }

    @org.junit.Test
    public void fromKilobyte_toYottabyte(){
        double result = Double.parseDouble(converter.unitConverter(887976020, "Kilobyte", "Yottabyte", 3, 24));
        assertEquals(8.8797602e-13, result, 1e-14);
        result = Double.parseDouble(converter.unitConverter(862718704, "Kilobyte", "Yottabyte", 3, 24));
        assertEquals(8.62718704e-13, result, 1e-14);
        result = Double.parseDouble(converter.unitConverter(851209780, "Kilobyte", "Yottabyte", 3, 24));
        assertEquals(8.5120978e-13, result, 1e-14);
        result = Double.parseDouble(converter.unitConverter(848260545, "Kilobyte", "Yottabyte", 3, 24));
        assertEquals(8.48260545e-13, result, 1e-14);
        result = Double.parseDouble(converter.unitConverter(667203545, "Kilobyte", "Yottabyte", 3, 24));
        assertEquals(6.67203545e-13, result, 1e-14);
    }

    //fromMegabyte
    @org.junit.Test
    public void fromMegabyte_toBit(){
        double result = Double.parseDouble(converter.unitConverter(921701, "Megabyte", "Bit", 6, 0));
        assertEquals(7.373608e+12, result, 0);
        result = Double.parseDouble(converter.unitConverter(864930, "Megabyte", "Bit", 6, 0));
        assertEquals(6.91944e+12, result, 0);
        result = Double.parseDouble(converter.unitConverter(570609, "Megabyte", "Bit", 6, 0));
        assertEquals(4.564872e+12, result, 0);
        result = Double.parseDouble(converter.unitConverter(973602, "Megabyte", "Bit", 6, 0));
        assertEquals(7.788816e+12, result, 0);
        result = Double.parseDouble(converter.unitConverter(582310, "Megabyte", "Bit", 6, 0));
        assertEquals(4.65848e+12, result, 0);
    }

    @org.junit.Test
    public void fromMegabyte_toNibble(){
        double result = Double.parseDouble(converter.unitConverter(897490, "Megabyte", "Nibble", 6, 0));
        assertEquals(1.79498e+12, result, 0);
        result = Double.parseDouble(converter.unitConverter(677023, "Megabyte", "Nibble", 6, 0));
        assertEquals(1.354046e+12, result, 0);
        result = Double.parseDouble(converter.unitConverter(689129, "Megabyte", "Nibble", 6, 0));
        assertEquals(1.378258e+12, result, 0);
        result = Double.parseDouble(converter.unitConverter(620152, "Megabyte", "Nibble", 6, 0));
        assertEquals(1.240304e+12, result, 0);
        result = Double.parseDouble(converter.unitConverter(791919, "Megabyte", "Nibble", 6, 0));
        assertEquals(1.583838e+12, result, 0);
    }

    @org.junit.Test
    public void fromMegabyte_toByte(){
        double result = Double.parseDouble(converter.unitConverter(611980, "Megabyte", "Byte", 6, 0));
        assertEquals(6.1198e+11, result, 0);
        result = Double.parseDouble(converter.unitConverter(677023, "Megabyte", "Byte", 6, 0));
        assertEquals(6.77023e+11, result, 0);
        result = Double.parseDouble(converter.unitConverter(750872, "Megabyte", "Byte", 6, 0));
        assertEquals(7.50872e+11, result, 0);
        result = Double.parseDouble(converter.unitConverter(724518, "Megabyte", "Byte", 6, 0));
        assertEquals(7.24518e+11, result, 0);
        result = Double.parseDouble(converter.unitConverter(608191, "Megabyte", "Byte", 6, 0));
        assertEquals(6.08191e+11, result, 0);
    }

    @org.junit.Test
    public void fromMegabyte_toKilobyte(){
        double result = Double.parseDouble(converter.unitConverter(611980, "Megabyte", "Kilobyte", 6, 3));
        assertEquals(611980000, result, 0);
        result = Double.parseDouble(converter.unitConverter(677023, "Megabyte", "Kilobyte", 6, 3));
        assertEquals(677023000, result, 0);
        result = Double.parseDouble(converter.unitConverter(750872, "Megabyte", "Kilobyte", 6, 3));
        assertEquals(750872000, result, 0);
        result = Double.parseDouble(converter.unitConverter(724518, "Megabyte", "Kilobyte", 6, 3));
        assertEquals(724518000, result, 0);
        result = Double.parseDouble(converter.unitConverter(608191, "Megabyte", "Kilobyte", 6, 3));
        assertEquals(608191000, result, 0);
    }

    @org.junit.Test
    public void fromMegabyte_toGigabyte(){
        double result = Double.parseDouble(converter.unitConverter(611980, "Megabyte", "Gigabyte", 6, 9));
        assertEquals(611.98, result, 0.001);
        result = Double.parseDouble(converter.unitConverter(677023, "Megabyte", "Gigabyte", 6, 9));
        assertEquals(677.023, result, 0.001);
        result = Double.parseDouble(converter.unitConverter(750872, "Megabyte", "Gigabyte", 6, 9));
        assertEquals(750.872, result, 0.001);
        result = Double.parseDouble(converter.unitConverter(724518, "Megabyte", "Gigabyte", 6, 9));
        assertEquals(724.518, result, 0.001);
        result = Double.parseDouble(converter.unitConverter(608191, "Megabyte", "Gigabyte", 6, 9));
        assertEquals(608.191, result, 0.001);
    }

    @org.junit.Test
    public void fromMegabyte_toTerabyte(){
        double result = Double.parseDouble(converter.unitConverter(611980, "Megabyte", "Terabyte", 6, 12));
        assertEquals(0.61198, result, 0.0001);
        result = Double.parseDouble(converter.unitConverter(677023, "Megabyte", "Terabyte", 6, 12));
        assertEquals(0.677023, result, 0.0001);
        result = Double.parseDouble(converter.unitConverter(750872, "Megabyte", "Terabyte", 6, 12));
        assertEquals(0.750872, result, 0.0001);
        result = Double.parseDouble(converter.unitConverter(724518, "Megabyte", "Terabyte", 6, 12));
        assertEquals(0.724518, result, 0.0001);
        result = Double.parseDouble(converter.unitConverter(608191, "Megabyte", "Terabyte", 6, 12));
        assertEquals(0.608191, result, 0.0001);
    }

    @org.junit.Test
    public void fromMegabyte_toPetabyte(){
        double result = Double.parseDouble(converter.unitConverter(611980, "Megabyte", "Petabyte", 6, 15));
        assertEquals(0.00061198, result, 1e-5);
        result = Double.parseDouble(converter.unitConverter(677023, "Megabyte", "Petabyte", 6, 15));
        assertEquals(0.000677023, result, 1e-5);
        result = Double.parseDouble(converter.unitConverter(750872, "Megabyte", "Petabyte", 6, 15));
        assertEquals(0.000750872, result, 1e-5);
        result = Double.parseDouble(converter.unitConverter(724518, "Megabyte", "Petabyte", 6, 15));
        assertEquals(0.000724518, result, 1e-5);
        result = Double.parseDouble(converter.unitConverter(608191, "Megabyte", "Petabyte", 6, 15));
        assertEquals(0.000608191, result, 1e-5);
    }

    @org.junit.Test
    public void fromMegabyte_toExabyte(){
        double result = Double.parseDouble(converter.unitConverter(894295307, "Megabyte", "Exabyte", 6, 18));
        assertEquals(0.000894295307, result, 1e-7);
        result = Double.parseDouble(converter.unitConverter(832302371, "Megabyte", "Exabyte", 6, 18));
        assertEquals(0.000832302371, result, 1e-7);
        result = Double.parseDouble(converter.unitConverter(618251242, "Megabyte", "Exabyte", 6, 18));
        assertEquals(0.000618251242, result, 1e-7);
        result = Double.parseDouble(converter.unitConverter(892349268, "Megabyte", "Exabyte", 6, 18));
        assertEquals(0.000892349268, result, 1e-7);
        result = Double.parseDouble(converter.unitConverter(557238042, "Megabyte", "Exabyte", 6, 18));
        assertEquals(0.000557238042, result, 1e-7);
    }

    @org.junit.Test
    public void fromMegabyte_toZettabyte(){
        double result = Double.parseDouble(converter.unitConverter(894295307, "Megabyte", "Zettabyte", 6, 21));
        assertEquals(8.94295307e-7, result, 1e-8);
        result = Double.parseDouble(converter.unitConverter(832302371, "Megabyte", "Zettabyte", 6, 21));
        assertEquals(8.32302371e-7, result, 1e-8);
        result = Double.parseDouble(converter.unitConverter(618251242, "Megabyte", "Zettabyte", 6, 21));
        assertEquals(6.18251242e-7, result, 1e-8);
        result = Double.parseDouble(converter.unitConverter(892349268, "Megabyte", "Zettabyte", 6, 21));
        assertEquals(8.92349268e-7, result, 1e-8);
        result = Double.parseDouble(converter.unitConverter(557238042, "Megabyte", "Zettabyte", 6, 21));
        assertEquals(5.57238042e-7, result, 1e-8);
    }

    @org.junit.Test
    public void fromMegabyte_toYottabyte(){
        double result = Double.parseDouble(converter.unitConverter(894295307, "Megabyte", "Yottabyte", 6, 24));
        assertEquals(8.94295307e-10, result, 1e-11);
        result = Double.parseDouble(converter.unitConverter(832302371, "Megabyte", "Yottabyte", 6, 24));
        assertEquals(8.32302371e-10, result, 1e-11);
        result = Double.parseDouble(converter.unitConverter(618251242, "Megabyte", "Yottabyte", 6, 24));
        assertEquals(6.18251242e-10, result, 1e-11);
        result = Double.parseDouble(converter.unitConverter(892349268, "Megabyte", "Yottabyte", 6, 24));
        assertEquals(8.92349268e-10, result, 1e-11);
        result = Double.parseDouble(converter.unitConverter(557238042, "Megabyte", "Yottabyte", 6, 24));
        assertEquals(5.57238042e-10, result, 1e-11);
    }

    //fromGigabyte
    @org.junit.Test
    public void fromGigabyte_toBit(){
        double result = Double.parseDouble(converter.unitConverter(994868, "Gigabyte", "Bit", 9, 0));
        assertEquals(7.958944e+15, result, 0);
        result = Double.parseDouble(converter.unitConverter(659490, "Gigabyte", "Bit", 9, 0));
        assertEquals(5.27592e+15, result, 0);
        result = Double.parseDouble(converter.unitConverter(695108, "Gigabyte", "Bit", 9, 0));
        assertEquals(5.560864e+15, result, 0);
        result = Double.parseDouble(converter.unitConverter(850884, "Gigabyte", "Bit", 9, 0));
        assertEquals(6.807072e+15, result, 0);
        result = Double.parseDouble(converter.unitConverter(598112, "Gigabyte", "Bit", 9, 0));
        assertEquals(4.784896e+15, result, 0);
    }

    @org.junit.Test
    public void fromGigabyte_toNibble(){
        double result = Double.parseDouble(converter.unitConverter(994868, "Gigabyte", "Nibble", 9, 0));
        assertEquals(1.989736e+15, result, 0);
        result = Double.parseDouble(converter.unitConverter(659490, "Gigabyte", "Nibble", 9, 0));
        assertEquals(1.31898e+15, result, 0);
        result = Double.parseDouble(converter.unitConverter(695108, "Gigabyte", "Nibble", 9, 0));
        assertEquals(1.390216e+15, result, 0);
        result = Double.parseDouble(converter.unitConverter(850884, "Gigabyte", "Nibble", 9, 0));
        assertEquals(1.701768e+15, result, 0);
        result = Double.parseDouble(converter.unitConverter(598112, "Gigabyte", "Nibble", 9, 0));
        assertEquals(1.196224e+15, result, 0);
    }

    @org.junit.Test
    public void fromGigabyte_toByte(){
        double result = Double.parseDouble(converter.unitConverter(994868, "Gigabyte", "Byte", 9, 0));
        assertEquals(9.94868e+14, result, 0);
        result = Double.parseDouble(converter.unitConverter(659490, "Gigabyte", "Byte", 9, 0));
        assertEquals(6.5949e+14, result, 0);
        result = Double.parseDouble(converter.unitConverter(695108, "Gigabyte", "Byte", 9, 0));
        assertEquals(6.95108e+14, result, 0);
        result = Double.parseDouble(converter.unitConverter(850884, "Gigabyte", "Byte", 9, 0));
        assertEquals(8.50884e+14, result, 0);
        result = Double.parseDouble(converter.unitConverter(598112, "Gigabyte", "Byte", 9, 0));
        assertEquals(5.98112e+14, result, 0);
    }

    @org.junit.Test
    public void fromGigabyte_toKilobyte(){
        double result = Double.parseDouble(converter.unitConverter(994868, "Gigabyte", "Kilobyte", 9, 3));
        assertEquals(9.94868e+11, result, 0);
        result = Double.parseDouble(converter.unitConverter(659490, "Gigabyte", "Kilobyte", 9, 3));
        assertEquals(6.5949e+11, result, 0);
        result = Double.parseDouble(converter.unitConverter(695108, "Gigabyte", "Kilobyte", 9, 3));
        assertEquals(6.95108e+11, result, 0);
        result = Double.parseDouble(converter.unitConverter(850884, "Gigabyte", "Kilobyte", 9, 3));
        assertEquals(8.50884e+11, result, 0);
        result = Double.parseDouble(converter.unitConverter(598112, "Gigabyte", "Kilobyte", 9, 3));
        assertEquals(5.98112e+11, result, 0);
    }

    @org.junit.Test
    public void fromGigabyte_toMegabyte(){
        double result = Double.parseDouble(converter.unitConverter(994868, "Gigabyte", "Megabyte", 9, 6));
        assertEquals(994868000, result, 0);
        result = Double.parseDouble(converter.unitConverter(659490, "Gigabyte", "Megabyte", 9, 6));
        assertEquals(659490000, result, 0);
        result = Double.parseDouble(converter.unitConverter(695108, "Gigabyte", "Megabyte", 9, 6));
        assertEquals(695108000, result, 0);
        result = Double.parseDouble(converter.unitConverter(850884, "Gigabyte", "Megabyte", 9, 6));
        assertEquals(850884000, result, 0);
        result = Double.parseDouble(converter.unitConverter(598112, "Gigabyte", "Megabyte", 9, 6));
        assertEquals(598112000, result, 0);
    }

    @org.junit.Test
    public void fromGigabyte_toTerabyte(){
        double result = Double.parseDouble(converter.unitConverter(994868, "Gigabyte", "Terabyte", 9, 12));
        assertEquals(994.868, result, 0.001);
        result = Double.parseDouble(converter.unitConverter(659490, "Gigabyte", "Terabyte", 9, 12));
        assertEquals(659.49, result, 0.001);
        result = Double.parseDouble(converter.unitConverter(695108, "Gigabyte", "Terabyte", 9, 12));
        assertEquals(695.108, result, 0.001);
        result = Double.parseDouble(converter.unitConverter(850884, "Gigabyte", "Terabyte", 9, 12));
        assertEquals(850.884, result, 0.001);
        result = Double.parseDouble(converter.unitConverter(598112, "Gigabyte", "Terabyte", 9, 12));
        assertEquals(598.112, result, 0.001);
    }

    @org.junit.Test
    public void fromGigabyte_toPetabyte(){
        double result = Double.parseDouble(converter.unitConverter(994868, "Gigabyte", "Petabyte", 9, 15));
        assertEquals(0.994868, result, 0.0001);
        result = Double.parseDouble(converter.unitConverter(659490, "Gigabyte", "Petabyte", 9, 15));
        assertEquals(0.65949, result, 0.0001);
        result = Double.parseDouble(converter.unitConverter(695108, "Gigabyte", "Petabyte", 9, 15));
        assertEquals(0.695108, result, 0.0001);
        result = Double.parseDouble(converter.unitConverter(850884, "Gigabyte", "Petabyte", 9, 15));
        assertEquals(0.850884, result, 0.0001);
        result = Double.parseDouble(converter.unitConverter(598112, "Gigabyte", "Petabyte", 9, 15));
        assertEquals(0.598112, result, 0.0001);
    }

    @org.junit.Test
    public void fromGigabyte_toExabyte(){
        double result = Double.parseDouble(converter.unitConverter(994868, "Gigabyte", "Exabyte", 9, 18));
        assertEquals(0.000994868, result, 0.00001);
        result = Double.parseDouble(converter.unitConverter(659490, "Gigabyte", "Exabyte", 9, 18));
        assertEquals(0.00065949, result, 0.00001);
        result = Double.parseDouble(converter.unitConverter(695108, "Gigabyte", "Exabyte", 9, 18));
        assertEquals(0.000695108, result, 0.00001);
        result = Double.parseDouble(converter.unitConverter(850884, "Gigabyte", "Exabyte", 9, 18));
        assertEquals(0.000850884, result, 0.00001);
        result = Double.parseDouble(converter.unitConverter(598112, "Gigabyte", "Exabyte", 9, 18));
        assertEquals(0.000598112, result, 0.00001);
    }

    @org.junit.Test
    public void fromGigabyte_toZettabyte(){
        double result = Double.parseDouble(converter.unitConverter(994868, "Gigabyte", "Zettabyte", 9, 21));
        assertEquals(9.94868e-7, result, 1e-8);
        result = Double.parseDouble(converter.unitConverter(659490, "Gigabyte", "Zettabyte", 9, 21));
        assertEquals(6.5949e-7, result, 1e-8);
        result = Double.parseDouble(converter.unitConverter(695108, "Gigabyte", "Zettabyte", 9, 21));
        assertEquals(6.95108e-7, result, 1e-8);
        result = Double.parseDouble(converter.unitConverter(850884, "Gigabyte", "Zettabyte", 9, 21));
        assertEquals(8.50884e-7, result, 1e-8);
        result = Double.parseDouble(converter.unitConverter(598112, "Gigabyte", "Zettabyte", 9, 21));
        assertEquals(5.98112e-7, result, 1e-8);
    }

    @org.junit.Test
    public void fromGigabyte_toYottabyte(){
        double result = Double.parseDouble(converter.unitConverter(994868, "Gigabyte", "Yottabyte", 9, 24));
        assertEquals(9.94868e-10, result, 1e-11);
        result = Double.parseDouble(converter.unitConverter(659490, "Gigabyte", "Yottabyte", 9, 24));
        assertEquals(6.5949e-10, result, 1e-11);
        result = Double.parseDouble(converter.unitConverter(695108, "Gigabyte", "Yottabyte", 9, 24));
        assertEquals(6.95108e-10, result, 1e-11);
        result = Double.parseDouble(converter.unitConverter(850884, "Gigabyte", "Yottabyte", 9, 24));
        assertEquals(8.50884e-10, result, 1e-11);
        result = Double.parseDouble(converter.unitConverter(598112, "Gigabyte", "Yottabyte", 9, 24));
        assertEquals(5.98112e-10, result, 1e-11);
    }

    //fromTerabyte
    @org.junit.Test
    public void fromTerabyte_toBit(){
        double result = Double.parseDouble(converter.unitConverter(994868, "Terabyte", "Bit", 12, 0));
        assertEquals(7.958944e+18, result, 0);
        result = Double.parseDouble(converter.unitConverter(659490, "Terabyte", "Bit", 12, 0));
        assertEquals(5.27592e+18, result, 0);
        result = Double.parseDouble(converter.unitConverter(695108, "Terabyte", "Bit", 12, 0));
        assertEquals(5.560864e+18, result, 0);
        result = Double.parseDouble(converter.unitConverter(850884, "Terabyte", "Bit", 12, 0));
        assertEquals(6.807072e+18, result, 0);
        result = Double.parseDouble(converter.unitConverter(598112, "Terabyte", "Bit", 12, 0));
        assertEquals(4.784896e+18, result, 0);
    }

    @org.junit.Test
    public void fromTerabyte_toNibble(){
        double result = Double.parseDouble(converter.unitConverter(994868, "Terabyte", "Nibble", 12, 0));
        assertEquals(1.989736e+18, result, 0);
        result = Double.parseDouble(converter.unitConverter(659490, "Terabyte", "Nibble", 12, 0));
        assertEquals(1.31898e+18, result, 0);
        result = Double.parseDouble(converter.unitConverter(695108, "Terabyte", "Nibble", 12, 0));
        assertEquals(1.390216e+18, result, 0);
        result = Double.parseDouble(converter.unitConverter(850884, "Terabyte", "Nibble", 12, 0));
        assertEquals(1.701768e+18, result, 0);
        result = Double.parseDouble(converter.unitConverter(598112, "Terabyte", "Nibble", 12, 0));
        assertEquals(1.196224e+18, result, 0);
    }

    @org.junit.Test
    public void fromTerabyte_toByte(){
        double result = Double.parseDouble(converter.unitConverter(994868, "Terabyte", "Byte", 12, 0));
        assertEquals(9.94868e+17, result, 0);
        result = Double.parseDouble(converter.unitConverter(659490, "Terabyte", "Byte", 12, 0));
        assertEquals(6.5949e+17, result, 0);
        result = Double.parseDouble(converter.unitConverter(695108, "Terabyte", "Byte", 12, 0));
        assertEquals(6.95108e+17, result, 0);
        result = Double.parseDouble(converter.unitConverter(850884, "Terabyte", "Byte", 12, 0));
        assertEquals(8.50884e+17, result, 0);
        result = Double.parseDouble(converter.unitConverter(598112, "Terabyte", "Byte", 12, 0));
        assertEquals(5.98112e+17, result, 0);
    }

    @org.junit.Test
    public void fromTerabyte_toKilobyte(){
        double result = Double.parseDouble(converter.unitConverter(994868, "Terabyte", "Kilobyte", 12, 3));
        assertEquals(9.94868e+14, result, 0);
        result = Double.parseDouble(converter.unitConverter(659490, "Terabyte", "Kilobyte", 12, 3));
        assertEquals(6.5949e+14, result, 0);
        result = Double.parseDouble(converter.unitConverter(695108, "Terabyte", "Kilobyte", 12, 3));
        assertEquals(6.95108e+14, result, 0);
        result = Double.parseDouble(converter.unitConverter(850884, "Terabyte", "Kilobyte", 12, 3));
        assertEquals(8.50884e+14, result, 0);
        result = Double.parseDouble(converter.unitConverter(598112, "Terabyte", "Kilobyte", 12, 3));
        assertEquals(5.98112e+14, result, 0);
    }

    @org.junit.Test
    public void fromTerabyte_toMegabyte(){
        double result = Double.parseDouble(converter.unitConverter(994868, "Terabyte", "Megabyte", 12, 6));
        assertEquals(9.94868e+11, result, 0);
        result = Double.parseDouble(converter.unitConverter(659490, "Terabyte", "Megabyte", 12, 6));
        assertEquals(6.5949e+11, result, 0);
        result = Double.parseDouble(converter.unitConverter(695108, "Terabyte", "Megabyte", 12, 6));
        assertEquals(6.95108e+11, result, 0);
        result = Double.parseDouble(converter.unitConverter(850884, "Terabyte", "Megabyte", 12, 6));
        assertEquals(8.50884e+11, result, 0);
        result = Double.parseDouble(converter.unitConverter(598112, "Terabyte", "Megabyte", 12, 6));
        assertEquals(5.98112e+11, result, 0);
    }

    @org.junit.Test
    public void fromTerabyte_toGigabyte(){
        double result = Double.parseDouble(converter.unitConverter(994868, "Terabyte", "Gigabyte", 12, 9));
        assertEquals(994868000, result, 0);
        result = Double.parseDouble(converter.unitConverter(659490, "Terabyte", "Gigabyte", 12, 9));
        assertEquals(659490000, result, 0);
        result = Double.parseDouble(converter.unitConverter(695108, "Terabyte", "Gigabyte", 12, 9));
        assertEquals(695108000, result, 0);
        result = Double.parseDouble(converter.unitConverter(850884, "Terabyte", "Gigabyte", 12, 9));
        assertEquals(850884000, result, 0);
        result = Double.parseDouble(converter.unitConverter(598112, "Terabyte", "Gigabyte", 12, 9));
        assertEquals(598112000, result, 0);
    }

    @org.junit.Test
    public void fromTerabyte_toPetabyte(){
        double result = Double.parseDouble(converter.unitConverter(994868, "Terabyte", "Petabyte", 12, 15));
        assertEquals(994.868, result, 0.01);
        result = Double.parseDouble(converter.unitConverter(659490, "Terabyte", "Petabyte", 12, 15));
        assertEquals(659.490, result, 0.01);
        result = Double.parseDouble(converter.unitConverter(695108, "Terabyte", "Petabyte", 12, 15));
        assertEquals(695.108, result, 0.01);
        result = Double.parseDouble(converter.unitConverter(850884, "Terabyte", "Petabyte", 12, 15));
        assertEquals(850.884, result, 0.01);
        result = Double.parseDouble(converter.unitConverter(598112, "Terabyte", "Petabyte", 12, 15));
        assertEquals(598.112, result, 0.01);
    }

    @org.junit.Test
    public void fromTerabyte_toExabyte(){
        double result = Double.parseDouble(converter.unitConverter(994868, "Terabyte", "Exabyte", 12, 18));
        assertEquals(0.994868, result, 0.0001);
        result = Double.parseDouble(converter.unitConverter(659490, "Terabyte", "Exabyte", 12, 18));
        assertEquals(0.659490, result, 0.0001);
        result = Double.parseDouble(converter.unitConverter(695108, "Terabyte", "Exabyte", 12, 18));
        assertEquals(0.695108, result, 0.0001);
        result = Double.parseDouble(converter.unitConverter(850884, "Terabyte", "Exabyte", 12, 18));
        assertEquals(0.850884, result, 0.0001);
        result = Double.parseDouble(converter.unitConverter(598112, "Terabyte", "Exabyte", 12, 18));
        assertEquals(0.598112, result, 0.0001);
    }

    @org.junit.Test
    public void fromTerabyte_toZettabyte(){
        double result = Double.parseDouble(converter.unitConverter(994868, "Terabyte", "Zettabyte", 12, 21));
        assertEquals(0.000994868, result, 1e-5);
        result = Double.parseDouble(converter.unitConverter(659490, "Terabyte", "Zettabyte", 12, 21));
        assertEquals(0.000659490, result, 1e-5);
        result = Double.parseDouble(converter.unitConverter(695108, "Terabyte", "Zettabyte", 12, 21));
        assertEquals(0.000695108, result, 1e-5);
        result = Double.parseDouble(converter.unitConverter(850884, "Terabyte", "Zettabyte", 12, 21));
        assertEquals(0.000850884, result, 1e-5);
        result = Double.parseDouble(converter.unitConverter(598112, "Terabyte", "Zettabyte", 12, 21));
        assertEquals(0.000598112, result, 1e-5);
    }

    @org.junit.Test
    public void fromTerabyte_toYottabyte(){
        double result = Double.parseDouble(converter.unitConverter(994868, "Terabyte", "Yottabyte", 12, 24));
        assertEquals(9.94868e-7, result, 1e-8);
        result = Double.parseDouble(converter.unitConverter(659490, "Terabyte", "Yottabyte", 12, 24));
        assertEquals(6.59490e-7, result, 1e-8);
        result = Double.parseDouble(converter.unitConverter(695108, "Terabyte", "Yottabyte", 12, 24));
        assertEquals(6.95108e-7, result, 1e-8);
        result = Double.parseDouble(converter.unitConverter(850884, "Terabyte", "Yottabyte", 12, 24));
        assertEquals(8.50884e-7, result, 1e-8);
        result = Double.parseDouble(converter.unitConverter(598112, "Terabyte", "Yottabyte", 12, 24));
        assertEquals(5.98112e-7, result, 1e-8);
    }

    //fromPetabyte
    @org.junit.Test
    public void fromPetabyte_toBit(){
        double result = Double.parseDouble(converter.unitConverter(8111, "Petabyte", "Bit", 15, 0));
        assertEquals(6.4888e+19, result, 0);
        result = Double.parseDouble(converter.unitConverter(6396, "Petabyte", "Bit", 15, 0));
        assertEquals(5.1168e+19, result, 0);
        result = Double.parseDouble(converter.unitConverter(6094, "Petabyte", "Bit", 15, 0));
        assertEquals(4.8752e+19, result, 0);
        result = Double.parseDouble(converter.unitConverter(7487, "Petabyte", "Bit", 15, 0));
        assertEquals(5.9896e+19, result, 0);
        result = Double.parseDouble(converter.unitConverter(9816, "Petabyte", "Bit", 15, 0));
        assertEquals(7.8528e+19, result, 0);
    }

    @org.junit.Test
    public void fromPetabyte_toNibble(){
        double result = Double.parseDouble(converter.unitConverter(8111, "Petabyte", "Nibble", 15, 0));
        assertEquals(1.6222e+19, result, 0);
        result = Double.parseDouble(converter.unitConverter(6396, "Petabyte", "Nibble", 15, 0));
        assertEquals(1.2792e+19, result, 0);
        result = Double.parseDouble(converter.unitConverter(6094, "Petabyte", "Nibble", 15, 0));
        assertEquals(1.2188e+19, result, 0);
        result = Double.parseDouble(converter.unitConverter(7487, "Petabyte", "Nibble", 15, 0));
        assertEquals(1.4974e+19, result, 0);
        result = Double.parseDouble(converter.unitConverter(9816, "Petabyte", "Nibble", 15, 0));
        assertEquals(1.9632e+19, result, 0);
    }

    @org.junit.Test
    public void fromPetabyte_toByte(){
        double result = Double.parseDouble(converter.unitConverter(8111, "Petabyte", "Byte", 15, 0));
        assertEquals(8.111e+18, result, 0);
        result = Double.parseDouble(converter.unitConverter(6396, "Petabyte", "Byte", 15, 0));
        assertEquals(6.396e+18, result, 0);
        result = Double.parseDouble(converter.unitConverter(6094, "Petabyte", "Byte", 15, 0));
        assertEquals(6.094e+18, result, 0);
        result = Double.parseDouble(converter.unitConverter(7487, "Petabyte", "Byte", 15, 0));
        assertEquals(7.487e+18, result, 0);
        result = Double.parseDouble(converter.unitConverter(9816, "Petabyte", "Byte", 15, 0));
        assertEquals(9.816e+18, result, 0);
    }

    @org.junit.Test
    public void fromPetabyte_toKilobyte(){
        double result = Double.parseDouble(converter.unitConverter(8111, "Petabyte", "Kilobyte", 15, 3));
        assertEquals(8.111e+15, result, 0);
        result = Double.parseDouble(converter.unitConverter(6396, "Petabyte", "Kilobyte", 15, 3));
        assertEquals(6.396e+15, result, 0);
        result = Double.parseDouble(converter.unitConverter(6094, "Petabyte", "Kilobyte", 15, 3));
        assertEquals(6.094e+15, result, 0);
        result = Double.parseDouble(converter.unitConverter(7487, "Petabyte", "Kilobyte", 15, 3));
        assertEquals(7.487e+15, result, 0);
        result = Double.parseDouble(converter.unitConverter(9816, "Petabyte", "Kilobyte", 15, 3));
        assertEquals(9.816e+15, result, 0);
    }

    @org.junit.Test
    public void fromPetabyte_toMegabyte(){
        double result = Double.parseDouble(converter.unitConverter(8111, "Petabyte", "Megabyte", 15, 6));
        assertEquals(8.111e+12, result, 0);
        result = Double.parseDouble(converter.unitConverter(6396, "Petabyte", "Megabyte", 15, 6));
        assertEquals(6.396e+12, result, 0);
        result = Double.parseDouble(converter.unitConverter(6094, "Petabyte", "Megabyte", 15, 6));
        assertEquals(6.094e+12, result, 0);
        result = Double.parseDouble(converter.unitConverter(7487, "Petabyte", "Megabyte", 15, 6));
        assertEquals(7.487e+12, result, 0);
        result = Double.parseDouble(converter.unitConverter(9816, "Petabyte", "Megabyte", 15, 6));
        assertEquals(9.816e+12, result, 0);
    }

    @org.junit.Test
    public void fromPetabyte_toGigabyte(){
        double result = Double.parseDouble(converter.unitConverter(8111, "Petabyte", "Gigabyte", 15, 9));
        assertEquals(8.111e+9, result, 0);
        result = Double.parseDouble(converter.unitConverter(6396, "Petabyte", "Gigabyte", 15, 9));
        assertEquals(6.396e+9, result, 0);
        result = Double.parseDouble(converter.unitConverter(6094, "Petabyte", "Gigabyte", 15, 9));
        assertEquals(6.094e+9, result, 0);
        result = Double.parseDouble(converter.unitConverter(7487, "Petabyte", "Gigabyte", 15, 9));
        assertEquals(7.487e+9, result, 0);
        result = Double.parseDouble(converter.unitConverter(9816, "Petabyte", "Gigabyte", 15, 9));
        assertEquals(9.816e+9, result, 0);
    }

    @org.junit.Test
    public void fromPetabyte_toTerabyte(){
        double result = Double.parseDouble(converter.unitConverter(8111, "Petabyte", "Terabyte", 15, 12));
        assertEquals(8111000, result, 0);
        result = Double.parseDouble(converter.unitConverter(6396, "Petabyte", "Terabyte", 15, 12));
        assertEquals(6396000, result, 0);
        result = Double.parseDouble(converter.unitConverter(6094, "Petabyte", "Terabyte", 15, 12));
        assertEquals(6094000, result, 0);
        result = Double.parseDouble(converter.unitConverter(7487, "Petabyte", "Terabyte", 15, 12));
        assertEquals(7487000, result, 0);
        result = Double.parseDouble(converter.unitConverter(9816, "Petabyte", "Terabyte", 15, 12));
        assertEquals(9816000, result, 0);
    }

    @org.junit.Test
    public void fromPetabyte_toExabyte(){
        double result = Double.parseDouble(converter.unitConverter(8111, "Petabyte", "Exabyte", 15, 18));
        assertEquals(8.111, result, 0.001);
        result = Double.parseDouble(converter.unitConverter(6396, "Petabyte", "Exabyte", 15, 18));
        assertEquals(6.396, result, 0.001);
        result = Double.parseDouble(converter.unitConverter(6094, "Petabyte", "Exabyte", 15, 18));
        assertEquals(6.094, result, 0.001);
        result = Double.parseDouble(converter.unitConverter(7487, "Petabyte", "Exabyte", 15, 18));
        assertEquals(7.487, result, 0.001);
        result = Double.parseDouble(converter.unitConverter(9816, "Petabyte", "Exabyte", 15, 18));
        assertEquals(9.816, result, 0.001);
    }

    @org.junit.Test
    public void fromPetabyte_toZettabyte(){
        double result = Double.parseDouble(converter.unitConverter(8111, "Petabyte", "Zettabyte", 15, 21));
        assertEquals(0.008111, result, 1e-4);
        result = Double.parseDouble(converter.unitConverter(6396, "Petabyte", "Zettabyte", 15, 21));
        assertEquals(0.006396, result, 1e-4);
        result = Double.parseDouble(converter.unitConverter(6094, "Petabyte", "Zettabyte", 15, 21));
        assertEquals(0.006094, result, 1e-4);
        result = Double.parseDouble(converter.unitConverter(7487, "Petabyte", "Zettabyte", 15, 21));
        assertEquals(0.007487, result, 1e-4);
        result = Double.parseDouble(converter.unitConverter(9816, "Petabyte", "Zettabyte", 15, 21));
        assertEquals(0.009816, result, 1e-4);
    }

    @org.junit.Test
    public void fromPetabyte_toYottabyte(){
        double result = Double.parseDouble(converter.unitConverter(8111, "Petabyte", "Yottabyte", 15, 24));
        assertEquals(8.111e-6, result, 1e-4);
        result = Double.parseDouble(converter.unitConverter(6396, "Petabyte", "Yottabyte", 15, 24));
        assertEquals(6.396e-6, result, 1e-4);
        result = Double.parseDouble(converter.unitConverter(6094, "Petabyte", "Yottabyte", 15, 24));
        assertEquals(6.094e-6, result, 1e-4);
        result = Double.parseDouble(converter.unitConverter(7487, "Petabyte", "Yottabyte", 15, 24));
        assertEquals(7.487e-6, result, 1e-4);
        result = Double.parseDouble(converter.unitConverter(9816, "Petabyte", "Yottabyte", 15, 24));
        assertEquals(9.816e-6, result, 1e-4);
    }

    //fromExabyte
    @org.junit.Test
    public void fromExabyte_toBit(){
        double result = Double.parseDouble(converter.unitConverter(729, "Exabyte", "Bit", 18, 0));
        assertEquals(5.832e+21, result, 0);
        result = Double.parseDouble(converter.unitConverter(977, "Exabyte", "Bit", 18, 0));
        assertEquals(7.816e+21, result, 0);
        result = Double.parseDouble(converter.unitConverter(955, "Exabyte", "Bit", 18, 0));
        assertEquals(7.64e+21, result, 0);
        result = Double.parseDouble(converter.unitConverter(769, "Exabyte", "Bit", 18, 0));
        assertEquals(6.152e+21, result, 0);
        result = Double.parseDouble(converter.unitConverter(662, "Exabyte", "Bit", 18, 0));
        assertEquals(5.296e+21, result, 0);
    }

    @org.junit.Test
    public void fromExabyte_toNibble(){
        double result = Double.parseDouble(converter.unitConverter(729, "Exabyte", "Nibble", 18, 0));
        assertEquals(1.458e+21, result, 0);
        result = Double.parseDouble(converter.unitConverter(977, "Exabyte", "Nibble", 18, 0));
        assertEquals(1.954e+21, result, 0);
        result = Double.parseDouble(converter.unitConverter(955, "Exabyte", "Nibble", 18, 0));
        assertEquals(1.91e+21, result, 0);
        result = Double.parseDouble(converter.unitConverter(769, "Exabyte", "Nibble", 18, 0));
        assertEquals(1.538e+21, result, 0);
        result = Double.parseDouble(converter.unitConverter(662, "Exabyte", "Nibble", 18, 0));
        assertEquals(1.324e+21, result, 0);
    }

    @org.junit.Test
    public void fromExabyte_toByte(){
        double result = Double.parseDouble(converter.unitConverter(729, "Exabyte", "Byte", 18, 0));
        assertEquals(7.29e+20, result, 0);
        result = Double.parseDouble(converter.unitConverter(977, "Exabyte", "Byte", 18, 0));
        assertEquals(9.77e+20, result, 0);
        result = Double.parseDouble(converter.unitConverter(955, "Exabyte", "Byte", 18, 0));
        assertEquals(9.55e+20, result, 0);
        result = Double.parseDouble(converter.unitConverter(769, "Exabyte", "Byte", 18, 0));
        assertEquals(7.69e+20, result, 0);
        result = Double.parseDouble(converter.unitConverter(662, "Exabyte", "Byte", 18, 0));
        assertEquals(6.62e+20, result, 0);
    }

    @org.junit.Test
    public void fromExabyte_toKilobyte(){
        double result = Double.parseDouble(converter.unitConverter(729, "Exabyte", "Kilobyte", 18, 3));
        assertEquals(7.29e+17, result, 0);
        result = Double.parseDouble(converter.unitConverter(977, "Exabyte", "Kilobyte", 18, 3));
        assertEquals(9.77e+17, result, 0);
        result = Double.parseDouble(converter.unitConverter(955, "Exabyte", "Kilobyte", 18, 3));
        assertEquals(9.55e+17, result, 0);
        result = Double.parseDouble(converter.unitConverter(769, "Exabyte", "Kilobyte", 18, 3));
        assertEquals(7.69e+17, result, 0);
        result = Double.parseDouble(converter.unitConverter(662, "Exabyte", "Kilobyte", 18, 3));
        assertEquals(6.62e+17, result, 0);
    }

    @org.junit.Test
    public void fromExabyte_toMegabyte(){
        double result = Double.parseDouble(converter.unitConverter(729, "Exabyte", "Megabyte", 18, 6));
        assertEquals(7.29e+14, result, 0);
        result = Double.parseDouble(converter.unitConverter(977, "Exabyte", "Megabyte", 18, 6));
        assertEquals(9.77e+14, result, 0);
        result = Double.parseDouble(converter.unitConverter(955, "Exabyte", "Megabyte", 18, 6));
        assertEquals(9.55e+14, result, 0);
        result = Double.parseDouble(converter.unitConverter(769, "Exabyte", "Megabyte", 18, 6));
        assertEquals(7.69e+14, result, 0);
        result = Double.parseDouble(converter.unitConverter(662, "Exabyte", "Megabyte", 18, 6));
        assertEquals(6.62e+14, result, 0);
    }

    @org.junit.Test
    public void fromExabyte_toGigabyte(){
        double result = Double.parseDouble(converter.unitConverter(729, "Exabyte", "Gigabyte", 18, 9));
        assertEquals(7.29e+11, result, 0);
        result = Double.parseDouble(converter.unitConverter(977, "Exabyte", "Gigabyte", 18, 9));
        assertEquals(9.77e+11, result, 0);
        result = Double.parseDouble(converter.unitConverter(955, "Exabyte", "Gigabyte", 18, 9));
        assertEquals(9.55e+11, result, 0);
        result = Double.parseDouble(converter.unitConverter(769, "Exabyte", "Gigabyte", 18, 9));
        assertEquals(7.69e+11, result, 0);
        result = Double.parseDouble(converter.unitConverter(662, "Exabyte", "Gigabyte", 18, 9));
        assertEquals(6.62e+11, result, 0);
    }

    @org.junit.Test
    public void fromExabyte_toTerabyte(){
        double result = Double.parseDouble(converter.unitConverter(729, "Exabyte", "Terabyte", 18, 12));
        assertEquals(7.29e+8, result, 0);
        result = Double.parseDouble(converter.unitConverter(977, "Exabyte", "Terabyte", 18, 12));
        assertEquals(9.77e+8, result, 0);
        result = Double.parseDouble(converter.unitConverter(955, "Exabyte", "Terabyte", 18, 12));
        assertEquals(9.55e+8, result, 0);
        result = Double.parseDouble(converter.unitConverter(769, "Exabyte", "Terabyte", 18, 12));
        assertEquals(7.69e+8, result, 0);
        result = Double.parseDouble(converter.unitConverter(662, "Exabyte", "Terabyte", 18, 12));
        assertEquals(6.62e+8, result, 0);
    }

    @org.junit.Test
    public void fromExabyte_toPetabyte(){
        double result = Double.parseDouble(converter.unitConverter(729, "Exabyte", "Petabyte", 18, 15));
        assertEquals(729000, result, 0);
        result = Double.parseDouble(converter.unitConverter(977, "Exabyte", "Petabyte", 18, 15));
        assertEquals(977000, result, 0);
        result = Double.parseDouble(converter.unitConverter(955, "Exabyte", "Petabyte", 18, 15));
        assertEquals(955000, result, 0);
        result = Double.parseDouble(converter.unitConverter(769, "Exabyte", "Petabyte", 18, 15));
        assertEquals(769000, result, 0);
        result = Double.parseDouble(converter.unitConverter(662, "Exabyte", "Petabyte", 18, 15));
        assertEquals(662000, result, 0);
    }

    @org.junit.Test
    public void fromExabyte_toZettabyte(){
        double result = Double.parseDouble(converter.unitConverter(729, "Exabyte", "Zettabyte", 18, 21));
        assertEquals(0.729, result, 0.01);
        result = Double.parseDouble(converter.unitConverter(977, "Exabyte", "Zettabyte", 18, 21));
        assertEquals(0.977, result, 0.01);
        result = Double.parseDouble(converter.unitConverter(955, "Exabyte", "Zettabyte", 18, 21));
        assertEquals(0.955, result, 0.01);
        result = Double.parseDouble(converter.unitConverter(769, "Exabyte", "Zettabyte", 18, 21));
        assertEquals(0.769, result, 0.01);
        result = Double.parseDouble(converter.unitConverter(662, "Exabyte", "Zettabyte", 18, 21));
        assertEquals(0.662, result, 0.01);
    }

    @org.junit.Test
    public void fromExabyte_toYottabyte(){
        double result = Double.parseDouble(converter.unitConverter(729, "Exabyte", "Yottabyte", 18, 24));
        assertEquals(0.000729, result, 1e-5);
        result = Double.parseDouble(converter.unitConverter(977, "Exabyte", "Yottabyte", 18, 24));
        assertEquals(0.000977, result, 1e-5);
        result = Double.parseDouble(converter.unitConverter(955, "Exabyte", "Yottabyte", 18, 24));
        assertEquals(0.000955, result, 1e-5);
        result = Double.parseDouble(converter.unitConverter(769, "Exabyte", "Yottabyte", 18, 24));
        assertEquals(0.000769, result, 1e-5);
        result = Double.parseDouble(converter.unitConverter(662, "Exabyte", "Yottabyte", 18, 24));
        assertEquals(0.000662, result, 1e-5);
    }

    //fromZettabyte
    @org.junit.Test
    public void fromZettabyte_toBit(){
        double result = Double.parseDouble(converter.unitConverter(729, "Zettabyte", "Bit", 21, 0));
        assertEquals(5.832e+24, result, 0);
        result = Double.parseDouble(converter.unitConverter(977, "Zettabyte", "Bit", 21, 0));
        assertEquals(7.816e+24, result, 0);
        result = Double.parseDouble(converter.unitConverter(955, "Zettabyte", "Bit", 21, 0));
        assertEquals(7.64e+24, result, 0);
        result = Double.parseDouble(converter.unitConverter(769, "Zettabyte", "Bit", 21, 0));
        assertEquals(6.152e+24, result, 0);
        result = Double.parseDouble(converter.unitConverter(662, "Zettabyte", "Bit", 21, 0));
        assertEquals(5.296e+24, result, 0);
    }

    @org.junit.Test
    public void fromZettabyte_toNibble(){
        double result = Double.parseDouble(converter.unitConverter(729, "Zettabyte", "Nibble", 21, 0));
        assertEquals(1.458e+24, result, 0);
        result = Double.parseDouble(converter.unitConverter(977, "Zettabyte", "Nibble", 21, 0));
        assertEquals(1.954e+24, result, 0);
        result = Double.parseDouble(converter.unitConverter(955, "Zettabyte", "Nibble", 21, 0));
        assertEquals(1.91e+24, result, 0);
        result = Double.parseDouble(converter.unitConverter(769, "Zettabyte", "Nibble", 21, 0));
        assertEquals(1.538e+24, result, 0);
        result = Double.parseDouble(converter.unitConverter(662, "Zettabyte", "Nibble", 21, 0));
        assertEquals(1.324e+24, result, 0);
    }

    @org.junit.Test
    public void fromZettabyte_toByte(){
        double result = Double.parseDouble(converter.unitConverter(729, "Zettabyte", "Byte", 21, 0));
        assertEquals(7.29e+23, result, 0);
        result = Double.parseDouble(converter.unitConverter(977, "Zettabyte", "Byte", 21, 0));
        assertEquals(9.77e+23, result, 0);
        result = Double.parseDouble(converter.unitConverter(955, "Zettabyte", "Byte", 21, 0));
        assertEquals(9.55e+23, result, 0);
        result = Double.parseDouble(converter.unitConverter(769, "Zettabyte", "Byte", 21, 0));
        assertEquals(7.69e+23, result, 0);
        result = Double.parseDouble(converter.unitConverter(662, "Zettabyte", "Byte", 21, 0));
        assertEquals(6.62e+23, result, 0);
    }

    @org.junit.Test
    public void fromZettabyte_toKilobyte(){
        double result = Double.parseDouble(converter.unitConverter(729, "Zettabyte", "Kilobyte", 21, 3));
        assertEquals(7.29e+20, result, 0);
        result = Double.parseDouble(converter.unitConverter(977, "Zettabyte", "Kilobyte", 21, 3));
        assertEquals(9.77e+20, result, 0);
        result = Double.parseDouble(converter.unitConverter(955, "Zettabyte", "Kilobyte", 21, 3));
        assertEquals(9.55e+20, result, 0);
        result = Double.parseDouble(converter.unitConverter(769, "Zettabyte", "Kilobyte", 21, 3));
        assertEquals(7.69e+20, result, 0);
        result = Double.parseDouble(converter.unitConverter(662, "Zettabyte", "Kilobyte", 21, 3));
        assertEquals(6.62e+20, result, 0);
    }

    @org.junit.Test
    public void fromZettabyte_toMegabyte(){
        double result = Double.parseDouble(converter.unitConverter(729, "Zettabyte", "Megabyte", 21, 6));
        assertEquals(7.29e+17, result, 0);
        result = Double.parseDouble(converter.unitConverter(977, "Zettabyte", "Megabyte", 21, 6));
        assertEquals(9.77e+17, result, 0);
        result = Double.parseDouble(converter.unitConverter(955, "Zettabyte", "Megabyte", 21, 6));
        assertEquals(9.55e+17, result, 0);
        result = Double.parseDouble(converter.unitConverter(769, "Zettabyte", "Megabyte", 21, 6));
        assertEquals(7.69e+17, result, 0);
        result = Double.parseDouble(converter.unitConverter(662, "Zettabyte", "Megabyte", 21, 6));
        assertEquals(6.62e+17, result, 0);
    }

    @org.junit.Test
    public void fromZettabyte_toGigabyte(){
        double result = Double.parseDouble(converter.unitConverter(729, "Zettabyte", "Gigabyte", 21, 9));
        assertEquals(7.29e+14, result, 0);
        result = Double.parseDouble(converter.unitConverter(977, "Zettabyte", "Gigabyte", 21, 9));
        assertEquals(9.77e+14, result, 0);
        result = Double.parseDouble(converter.unitConverter(955, "Zettabyte", "Gigabyte", 21, 9));
        assertEquals(9.55e+14, result, 0);
        result = Double.parseDouble(converter.unitConverter(769, "Zettabyte", "Gigabyte", 21, 9));
        assertEquals(7.69e+14, result, 0);
        result = Double.parseDouble(converter.unitConverter(662, "Zettabyte", "Gigabyte", 21, 9));
        assertEquals(6.62e+14, result, 0);
    }

    @org.junit.Test
    public void fromZettabyte_toTerabyte(){
        double result = Double.parseDouble(converter.unitConverter(729, "Zettabyte", "Terabyte", 21, 12));
        assertEquals(7.29e+11, result, 0);
        result = Double.parseDouble(converter.unitConverter(977, "Zettabyte", "Terabyte", 21, 12));
        assertEquals(9.77e+11, result, 0);
        result = Double.parseDouble(converter.unitConverter(955, "Zettabyte", "Terabyte", 21, 12));
        assertEquals(9.55e+11, result, 0);
        result = Double.parseDouble(converter.unitConverter(769, "Zettabyte", "Terabyte", 21, 12));
        assertEquals(7.69e+11, result, 0);
        result = Double.parseDouble(converter.unitConverter(662, "Zettabyte", "Terabyte", 21, 12));
        assertEquals(6.62e+11, result, 0);
    }

    @org.junit.Test
    public void fromZettabyte_toPetabyte(){
        double result = Double.parseDouble(converter.unitConverter(729, "Zettabyte", "Petabyte", 21, 15));
        assertEquals(7.29e+8, result, 0);
        result = Double.parseDouble(converter.unitConverter(977, "Zettabyte", "Petabyte", 21, 15));
        assertEquals(9.77e+8, result, 0);
        result = Double.parseDouble(converter.unitConverter(955, "Zettabyte", "Petabyte", 21, 15));
        assertEquals(9.55e+8, result, 0);
        result = Double.parseDouble(converter.unitConverter(769, "Zettabyte", "Petabyte", 21, 15));
        assertEquals(7.69e+8, result, 0);
        result = Double.parseDouble(converter.unitConverter(662, "Zettabyte", "Petabyte", 21, 15));
        assertEquals(6.62e+8, result, 0);
    }

    @org.junit.Test
    public void fromZettabyte_toExabyte(){
        double result = Double.parseDouble(converter.unitConverter(729, "Zettabyte", "Exabyte", 21, 18));
        assertEquals(729000, result, 0);
        result = Double.parseDouble(converter.unitConverter(977, "Zettabyte", "Exabyte", 21, 18));
        assertEquals(977000, result, 0);
        result = Double.parseDouble(converter.unitConverter(955, "Zettabyte", "Exabyte", 21, 18));
        assertEquals(955000, result, 0);
        result = Double.parseDouble(converter.unitConverter(769, "Zettabyte", "Exabyte", 21, 18));
        assertEquals(769000, result, 0);
        result = Double.parseDouble(converter.unitConverter(662, "Zettabyte", "Exabyte", 21, 18));
        assertEquals(662000, result, 0);
    }

    @org.junit.Test
    public void fromZettabyte_toYottabyte(){
        double result = Double.parseDouble(converter.unitConverter(729, "Zettabyte", "Yottabyte", 21, 24));
        assertEquals(0.729, result, 0.01);
        result = Double.parseDouble(converter.unitConverter(977, "Zettabyte", "Yottabyte", 21, 24));
        assertEquals(0.977, result, 0.01);
        result = Double.parseDouble(converter.unitConverter(955, "Zettabyte", "Yottabyte", 21, 24));
        assertEquals(0.955, result, 0.01);
        result = Double.parseDouble(converter.unitConverter(769, "Zettabyte", "Yottabyte", 21, 24));
        assertEquals(0.769, result, 0.01);
        result = Double.parseDouble(converter.unitConverter(662, "Zettabyte", "Yottabyte", 21, 24));
        assertEquals(0.662, result, 0.01);
    }

    //fromYottabyte
    @org.junit.Test
    public void fromYottabyte_toBit(){
        double result = Double.parseDouble(converter.unitConverter(729, "Yottabyte", "Bit", 24, 0));
        assertEquals(5.832e+27, result, 0);
        result = Double.parseDouble(converter.unitConverter(977, "Yottabyte", "Bit", 24, 0));
        assertEquals(7.816e+27, result, 0);
        result = Double.parseDouble(converter.unitConverter(955, "Yottabyte", "Bit", 24, 0));
        assertEquals(7.64e+27, result, 0);
        result = Double.parseDouble(converter.unitConverter(123, "Yottabyte", "Bit", 24, 0));
        assertEquals(9.84e+26, result, 0);
        result = Double.parseDouble(converter.unitConverter(662, "Yottabyte", "Bit", 24, 0));
        assertEquals(5.296e+27, result, 0);
    }

    @org.junit.Test
    public void fromYottabyte_toNibble(){
        double result = Double.parseDouble(converter.unitConverter(729, "Yottabyte", "Nibble", 24, 0));
        assertEquals(1.458e+27, result, 0);
        result = Double.parseDouble(converter.unitConverter(977, "Yottabyte", "Nibble", 24, 0));
        assertEquals(1.954e+27, result, 0);
        result = Double.parseDouble(converter.unitConverter(955, "Yottabyte", "Nibble", 24, 0));
        assertEquals(1.91e+27, result, 0);
        result = Double.parseDouble(converter.unitConverter(123, "Yottabyte", "Nibble", 24, 0));
        assertEquals(2.46e+26, result, 0);
        result = Double.parseDouble(converter.unitConverter(662, "Yottabyte", "Nibble", 24, 0));
        assertEquals(1.324e+27, result, 0);
    }

    @org.junit.Test
    public void fromYottabyte_toByte(){
        double result = Double.parseDouble(converter.unitConverter(729, "Yottabyte", "Byte", 24, 0));
        assertEquals(7.29e+26, result, 0);
        result = Double.parseDouble(converter.unitConverter(977, "Yottabyte", "Byte", 24, 0));
        assertEquals(9.77e+26, result, 0);
        result = Double.parseDouble(converter.unitConverter(955, "Yottabyte", "Byte", 24, 0));
        assertEquals(9.55e+26, result, 0);
        result = Double.parseDouble(converter.unitConverter(123, "Yottabyte", "Byte", 24, 0));
        assertEquals(1.23e+26, result, 0);
        result = Double.parseDouble(converter.unitConverter(662, "Yottabyte", "Byte", 24, 0));
        assertEquals(6.62e+26, result, 0);
    }

    @org.junit.Test
    public void fromYottabyte_toKilobyte(){
        double result = Double.parseDouble(converter.unitConverter(729, "Yottabyte", "Kilobyte", 24, 3));
        assertEquals(7.29e+23, result, 0);
        result = Double.parseDouble(converter.unitConverter(977, "Yottabyte", "Kilobyte", 24, 3));
        assertEquals(9.77e+23, result, 0);
        result = Double.parseDouble(converter.unitConverter(955, "Yottabyte", "Kilobyte", 24, 3));
        assertEquals(9.55e+23, result, 0);
        result = Double.parseDouble(converter.unitConverter(769, "Yottabyte", "Kilobyte", 24, 3));
        assertEquals(7.69e+23, result, 0);
        result = Double.parseDouble(converter.unitConverter(662, "Yottabyte", "Kilobyte", 24, 3));
        assertEquals(6.62e+23, result, 0);
    }

    @org.junit.Test
    public void fromYottabyte_toMegabyte(){
        double result = Double.parseDouble(converter.unitConverter(729, "Yottabyte", "Megabyte", 24, 6));
        assertEquals(7.29e+20, result, 0);
        result = Double.parseDouble(converter.unitConverter(977, "Yottabyte", "Megabyte", 24, 6));
        assertEquals(9.77e+20, result, 0);
        result = Double.parseDouble(converter.unitConverter(955, "Yottabyte", "Megabyte", 24, 6));
        assertEquals(9.55e+20, result, 0);
        result = Double.parseDouble(converter.unitConverter(769, "Yottabyte", "Megabyte", 24, 6));
        assertEquals(7.69e+20, result, 0);
        result = Double.parseDouble(converter.unitConverter(662, "Yottabyte", "Megabyte", 24, 6));
        assertEquals(6.62e+20, result, 0);
    }

    @org.junit.Test
    public void fromYottabyte_toGigabyte(){
        double result = Double.parseDouble(converter.unitConverter(729, "Yottabyte", "Gigabyte", 24, 9));
        assertEquals(7.29e+17, result, 0);
        result = Double.parseDouble(converter.unitConverter(977, "Yottabyte", "Gigabyte", 24, 9));
        assertEquals(9.77e+17, result, 0);
        result = Double.parseDouble(converter.unitConverter(955, "Yottabyte", "Gigabyte", 24, 9));
        assertEquals(9.55e+17, result, 0);
        result = Double.parseDouble(converter.unitConverter(769, "Yottabyte", "Gigabyte", 24, 9));
        assertEquals(7.69e+17, result, 0);
        result = Double.parseDouble(converter.unitConverter(662, "Yottabyte", "Gigabyte", 24, 9));
        assertEquals(6.62e+17, result, 0);
    }

    @org.junit.Test
    public void fromYottabyte_toTerabyte(){
        double result = Double.parseDouble(converter.unitConverter(729, "Yottabyte", "Terabyte", 24, 12));
        assertEquals(7.29e+14, result, 0);
        result = Double.parseDouble(converter.unitConverter(977, "Yottabyte", "Terabyte", 24, 12));
        assertEquals(9.77e+14, result, 0);
        result = Double.parseDouble(converter.unitConverter(955, "Yottabyte", "Terabyte", 24, 12));
        assertEquals(9.55e+14, result, 0);
        result = Double.parseDouble(converter.unitConverter(769, "Yottabyte", "Terabyte", 24, 12));
        assertEquals(7.69e+14, result, 0);
        result = Double.parseDouble(converter.unitConverter(662, "Yottabyte", "Terabyte", 24, 12));
        assertEquals(6.62e+14, result, 0);
    }

    @org.junit.Test
    public void fromYottabyte_toPetabyte(){
        double result = Double.parseDouble(converter.unitConverter(729, "Yottabyte", "Petabyte", 24, 15));
        assertEquals(7.29e+11, result, 0);
        result = Double.parseDouble(converter.unitConverter(977, "Yottabyte", "Petabyte", 24, 15));
        assertEquals(9.77e+11, result, 0);
        result = Double.parseDouble(converter.unitConverter(955, "Yottabyte", "Petabyte", 24, 15));
        assertEquals(9.55e+11, result, 0);
        result = Double.parseDouble(converter.unitConverter(769, "Yottabyte", "Petabyte", 24, 15));
        assertEquals(7.69e+11, result, 0);
        result = Double.parseDouble(converter.unitConverter(662, "Yottabyte", "Petabyte", 24, 15));
        assertEquals(6.62e+11, result, 0);
    }

    @org.junit.Test
    public void fromYottabyte_toExabyte(){
        double result = Double.parseDouble(converter.unitConverter(729, "Yottabyte", "Exabyte", 24, 18));
        assertEquals(7.29e+8, result, 0);
        result = Double.parseDouble(converter.unitConverter(977, "Yottabyte", "Exabyte", 24, 18));
        assertEquals(9.77e+8, result, 0);
        result = Double.parseDouble(converter.unitConverter(955, "Yottabyte", "Exabyte", 24, 18));
        assertEquals(9.55e+8, result, 0);
        result = Double.parseDouble(converter.unitConverter(769, "Yottabyte", "Exabyte", 24, 18));
        assertEquals(7.69e+8, result, 0);
        result = Double.parseDouble(converter.unitConverter(662, "Yottabyte", "Exabyte", 24, 18));
        assertEquals(6.62e+8, result, 0);
    }

    @org.junit.Test
    public void fromYottabyte_toZettabyte(){
        double result = Double.parseDouble(converter.unitConverter(729, "Yottabyte", "Zettabyte", 24, 21));
        assertEquals(729000, result, 0);
        result = Double.parseDouble(converter.unitConverter(977, "Yottabyte", "Zettabyte", 24, 21));
        assertEquals(977000, result, 0);
        result = Double.parseDouble(converter.unitConverter(955, "Yottabyte", "Zettabyte", 24, 21));
        assertEquals(955000, result, 0);
        result = Double.parseDouble(converter.unitConverter(769, "Yottabyte", "Zettabyte", 24, 21));
        assertEquals(769000, result, 0);
        result = Double.parseDouble(converter.unitConverter(662, "Yottabyte", "Zettabyte", 24, 21));
        assertEquals(662000, result, 0);
    }

    //solveMap method test
    @org.junit.Test
    public void solveMap_TwoVariables() {
        int numRow = 4;
        String[] outputValuesString = {"00", "01", "10", "11"};
        int[] outputValues = {1, 0, 1, 0};
        assertEquals("\u0100\u0112 + A\u0112", converter.solveMap(numRow, outputValues, outputValuesString));
        outputValues = new int[]{0, 1, 0, 1};
        assertEquals("\u0100E + AE", converter.solveMap(numRow, outputValues, outputValuesString));
        outputValues = new int[]{0, 0, 0, 0};
        assertEquals("", converter.solveMap(numRow, outputValues, outputValuesString));
        outputValues = new int[]{1, 1, 1, 1};
        assertEquals("\u0100\u0112 + \u0100E + A\u0112 + AE", converter.solveMap(numRow, outputValues, outputValuesString));
        outputValues = new int[]{1, 1, 0, 0};
        assertEquals("\u0100\u0112 + \u0100E", converter.solveMap(numRow, outputValues, outputValuesString));
    }

    @org.junit.Test
    public void solveMap_ThreeVariables() {
        int numRow = 8;
        String[] outputValuesString = {"000", "001", "010", "011", "100", "101", "110", "111"};
        int[] outputValues = {1, 0, 1, 0, 1, 0, 1, 0};
        assertEquals("\u0100\u0112\u014C + \u0100E\u014C + A\u0112\u014C + AE\u014C", converter.solveMap(numRow, outputValues, outputValuesString));
        outputValues = new int[]{0, 1, 0, 1, 0, 1, 0, 1};
        assertEquals("\u0100\u0112O + \u0100EO + A\u0112O + AEO", converter.solveMap(numRow, outputValues, outputValuesString));
        outputValues = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        assertEquals("", converter.solveMap(numRow, outputValues, outputValuesString));
        outputValues = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
        assertEquals("\u0100\u0112\u014C + \u0100\u0112O + \u0100E\u014C + \u0100EO + A\u0112\u014C + A\u0112O + AE\u014C + AEO", converter.solveMap(numRow, outputValues, outputValuesString));
        outputValues = new int[]{1, 1, 0, 0, 1, 1, 0, 0};
        assertEquals("\u0100\u0112\u014C + \u0100\u0112O + A\u0112\u014C + A\u0112O", converter.solveMap(numRow, outputValues, outputValuesString));
    }

    @org.junit.Test
    public void solveMap_FourVariables() {
        int numRow = 16;
        String[] outputValuesString = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};
        int[] outputValues = {1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0};
        assertEquals("\u0100\u0112\u014C\u016A + \u0100E\u014C\u016A + \u0100EO\u016A + AE\u014C\u016A + AEO\u016A", converter.solveMap(numRow, outputValues, outputValuesString));
        outputValues = new int[]{0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1};
        assertEquals("\u0100\u0112\u014CU + \u0100E\u014CU + A\u0112OU + AEOU", converter.solveMap(numRow, outputValues, outputValuesString));
        outputValues = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertEquals("", converter.solveMap(numRow, outputValues, outputValuesString));
        outputValues = new int[]{1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertEquals("\u0100\u0112\u014C\u016A + \u0100\u0112\u014CU + \u0100\u0112O\u016A + \u0100\u0112OU + \u0100E\u014C\u016A + \u0100E\u014CU", converter.solveMap(numRow, outputValues, outputValuesString));
        outputValues = new int[]{1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0};
        assertEquals("\u0100\u0112\u014C\u016A + \u0100\u0112\u014CU + \u0100E\u014C\u016A + \u0100E\u014CU + AE\u014C\u016A + AE\u014CU", converter.solveMap(numRow, outputValues, outputValuesString));
    }

    //createKarnaughMap method test
    @org.junit.Test
    public void createKarnaughMap_TwoVariables() {
        int numRow = 4;
        int numColumn = 2;
        String[] outputValuesString = {"00", "01", "10", "11"};
        int[] outputValues = {1, 0, 1, 0};
        int[][] proof = {{1, 1}, {0, 0}};
        int[][] result = converter.createKarnaughMap(numColumn, numRow, outputValues, outputValuesString);
        assertArrayEquals(proof, result);
        outputValues = new int[]{0, 1, 0, 1};
        proof = new int[][]{{0, 0}, {1, 1}};
        result = converter.createKarnaughMap(numColumn, numRow, outputValues, outputValuesString);
        assertArrayEquals(proof, result);
        outputValues = new int[]{1, 1, 1, 0};
        proof = new int[][]{{1, 1}, {1, 0}};
        result = converter.createKarnaughMap(numColumn, numRow, outputValues, outputValuesString);
        assertArrayEquals(proof, result);
    }

    @org.junit.Test
    public void createKarnaughMap_ThreeVariables() {
        int numRow = 8;
        int numColumn = 3;
        String[] outputValuesString = {"000", "001", "010", "011", "100", "101", "110", "111"};
        int[] outputValues = {1, 0, 1, 0, 1, 0, 1, 0};
        int[][] proof = {{1, 1, 1, 1}, {0, 0, 0, 0}};
        int[][] result = converter.createKarnaughMap(numColumn, numRow, outputValues, outputValuesString);
        assertArrayEquals(proof, result);
        outputValues = new int[]{0, 1, 0, 1, 0, 1, 0, 1};
        proof = new int[][]{{0, 0, 0, 0}, {1, 1, 1, 1}};
        result = converter.createKarnaughMap(numColumn, numRow, outputValues, outputValuesString);
        assertArrayEquals(proof, result);
        outputValues = new int[]{1, 1, 1, 0, 0, 0, 0, 1};
        proof = new int[][]{{1, 1, 0, 0}, {1, 0, 1, 0}};
        result = converter.createKarnaughMap(numColumn, numRow, outputValues, outputValuesString);
        assertArrayEquals(proof, result);
    }

    @org.junit.Test
    public void createKarnaughMap_FourVariables() {
        int numRow = 16;
        int numColumn = 4;
        String[] outputValuesString = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};
        int[] outputValues = {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0};
        int[][] proof = {{1, 1, 1, 1}, {0, 0, 0, 0}, {0, 0, 0, 0}, {1, 1, 1, 1}};
        int[][] result = converter.createKarnaughMap(numColumn, numRow, outputValues, outputValuesString);
        assertArrayEquals(proof, result);
        outputValues = new int[]{0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1};
        proof = new int[][]{{0, 0, 0, 0}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 0, 0}};
        result = converter.createKarnaughMap(numColumn, numRow, outputValues, outputValuesString);
        assertArrayEquals(proof, result);
        outputValues = new int[]{1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1};
        proof = new int[][]{{1, 0, 0, 1}, {1, 0, 0, 1}, {0, 1, 1, 0}, {1, 0, 0, 1}};
        result = converter.createKarnaughMap(numColumn, numRow, outputValues, outputValuesString);
        assertArrayEquals(proof, result);
    }
}
