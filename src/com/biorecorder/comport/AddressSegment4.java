package com.biorecorder.comport;

public class AddressSegment4 implements AddressSegment{

    public final int startAdress = 0xF9CE;

    public final int[] data = new int[]{
            0X30, 0X40, 0X9A, 0X8A, 0X30, 0X40, 0X4A, 0X8F, 0X30, 0X40, 0X4A, 0X8F, 0X30, 0X40, 0X42, 0X8A,
            0X30, 0X40, 0X86, 0X89, 0X30, 0X40, 0X62, 0X85, 0X30, 0X40, 0X4A, 0X8F, 0X30, 0X40, 0X4A, 0X8F,
            0X30, 0X40, 0X4A, 0X8F, 0X30, 0X40, 0X4A, 0X8F, 0X30, 0X40, 0X4A, 0X8F, 0X30, 0X40, 0X4A, 0X8F,
            0X70, 0X80,};

    public int getStartAdress() {
        return startAdress;
    }

    public int[] getData() {
        return data;
    }
}
