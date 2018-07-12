package com.biorecorder.comport;

public class AddressSegment2 implements AddressSegment{

    public final int startAdress = 0x805A;

    public final int[] data = new int[]{
            0X01, 0X00, 0X40, 0X1F, 0X28, 0X02, 0X8C, 0X02, 0X40, 0X1F, 0XF0, 0X02, 0XF2, 0X02, 0X01, 0X01,
            0X0A, 0X0A, 0X0A, 0X00, 0X01, };

    public int getStartAdress() {
        return startAdress;
    }

    public int[] getData() {
        return data;
    }
}
