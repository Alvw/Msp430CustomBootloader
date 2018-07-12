package com.biorecorder.comport;

public class AddressSegment4 implements AddressSegment{

    public final int startAdress = 0xF9CE;

    public final int[] data = new int[]{
            0X30, 0X40, 0X8E, 0X8A, 0X30, 0X40, 0X28, 0X8F, 0X30, 0X40, 0X28, 0X8F, 0X30, 0X40, 0X36, 0X8A,
            0X30, 0X40, 0X7A, 0X89, 0X30, 0X40, 0X28, 0X8F, 0X30, 0X40, 0X62, 0X85, 0X30, 0X40, 0X28, 0X8F,
            0X30, 0X40, 0X28, 0X8F, 0X30, 0X40, 0X28, 0X8F, 0X30, 0X40, 0X28, 0X8F, 0X30, 0X40, 0X28, 0X8F,
            0X70, 0X80};

    public int getStartAdress() {
        return startAdress;
    }

    public int[] getData() {
        return data;
    }
}
