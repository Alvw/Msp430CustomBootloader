package com.biorecorder.comport;

public class AddressSegmentCrc implements AddressSegment{
    public final int startAdress = 0x8000;
    //public final int[] data = new int[]{0x9C,0xF1};
    public final int[] data = new int[]{0x33,0xab};
    public int getStartAdress() {
        return startAdress;
    }

    public int[] getData() {
        return data;
    }

}
