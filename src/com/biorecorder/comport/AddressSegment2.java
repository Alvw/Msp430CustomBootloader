package com.biorecorder.comport;

public class AddressSegment2 implements AddressSegment{

    public final int startAdress = 0xF9CE;

    public final int[] data = new int[]{
            0X30, 0X40, 0X86, 0X80, 0X30, 0X40, 0X86, 0X80, 0X30, 0X40, 0X86, 0X80, 0X30, 0X40, 0X86, 0X80,
            0X30, 0X40, 0X86, 0X80, 0X30, 0X40, 0X86, 0X80, 0X30, 0X40, 0X70, 0X80, 0X30, 0X40, 0X86, 0X80,
            0X30, 0X40, 0X86, 0X80, 0X30, 0X40, 0X86, 0X80, 0X30, 0X40, 0X86, 0X80, 0X30, 0X40, 0X86, 0X80,
            0X04, 0X80};

    public int getStartAdress() {
        return startAdress;
    }

    public int[] getData() {
        return data;
    }
}
