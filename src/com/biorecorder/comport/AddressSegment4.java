package com.biorecorder.comport;

public class AddressSegment4 implements AddressSegment{

    public final int startAdress = 0xF9CE;

    public final int[] data = new int[]{
            0X30, 0X40, 0X7E, 0X8B, 0X30, 0X40, 0XF4, 0X8E, 0X30, 0X40, 0XF4, 0X8E, 0X30, 0X40, 0X16, 0X8B,
            0X30, 0X40, 0XBA, 0X8A, 0X30, 0X40, 0XC4, 0X85, 0X30, 0X40, 0XF4, 0X8E, 0X30, 0X40, 0XF4, 0X8E,
            0X30, 0X40, 0XF4, 0X8E, 0X30, 0X40, 0XF4, 0X8E, 0X30, 0X40, 0XF4, 0X8E, 0X30, 0X40, 0XF4, 0X8E,
            0X70, 0X80};

    public int getStartAdress() {
        return startAdress;
    }

    public int[] getData() {
        return data;
    }
}
