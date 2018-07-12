package com.biorecorder.comport;

public class AddressSegmentCrc implements AddressSegment{
    public final int startAdress = 0x8000;
    //public final int[] data = new int[]{0x9C,0xF1};
    public final int[] data = new int[]{0x08,0x72};
    public int getStartAdress() {
        return startAdress;
    }

    public int[] getData() {
        return data;
    }

}
