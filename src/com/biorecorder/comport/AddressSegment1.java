package com.biorecorder.comport;

//\s(\S\S) заменить на  0X$1,
public class AddressSegment1 implements AddressSegment{
    public final int startAdress = 0x8003;

    public final int[] data = new int[]{
            0X02, 0XE3, 0X10, 0X05, 0X05, 0X20, 0X00, 0X40, 0X02, 0X03, 0XAA, 0XA5, 0X05, 0XA5, 0X55, 0X00,
            0XAA, 0XA5, 0X05, 0XA0, 0X55, 0X00, 0XAA, 0XA5, 0X07, 0XA1, 0X02, 0X01, 0X55, 0X00, 0XAA, 0XA5,
            0X07, 0XA4, 0X02, 0X01, 0X55, 0X00, 0XAA, 0XA5, 0X07, 0XA2, 0X00, 0X02, 0X55, 0X00, 0XAA, 0XA5,
            0X07, 0XA2, 0X00, 0X03, 0X55, 0X00, 0XAA, 0XA5, 0X07, 0XA2, 0X00, 0X00, 0X55, 0X00, 0XAA, 0XA5,
            0X07, 0XA3, 0X00, 0X01, 0X55, 0X00, 0XAA, 0XA5, 0X07, 0XA2, 0X00, 0X01, 0X55, 0X00, 0XAA, 0XA5,
            0X07, 0XA2, 0X00, 0X04, 0X55, 0X00,};

    public int getStartAdress() {
        return startAdress;
    }

    public int[] getData() {
        return data;
    }
}
