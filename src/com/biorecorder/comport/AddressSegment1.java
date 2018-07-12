package com.biorecorder.comport;

//\s(\S\S) заменить на  0X$1,
public class AddressSegment1 implements AddressSegment{
    public final int startAdress = 0x8004;

    public final int[] data = new int[]{
            0X31, 0X40, 0X00, 0X06, 0XB0, 0X12, 0X10, 0X80, 0XB0, 0X12, 0X80, 0X80, 0XB2, 0X40, 0X80, 0X5A,
            0X20, 0X01, 0XF2, 0XD0, 0X80, 0X00, 0X22, 0X00, 0X0F, 0X43, 0X3F, 0X90, 0X05, 0X00, 0X0C, 0X34,
            0X3E, 0X40, 0X46, 0XE8, 0X03, 0X43, 0X1D, 0X43, 0X3E, 0X53, 0X3D, 0X63, 0XFD, 0X2F, 0XF2, 0XE0,
            0X80, 0X00, 0X21, 0X00, 0X1F, 0X53, 0XF1, 0X3F, 0XF2, 0XC0, 0X80, 0X00, 0X21, 0X00, 0XB2, 0X40,
            0X10, 0X00, 0X62, 0X01, 0XB2, 0X40, 0XE7, 0X03, 0X72, 0X01, 0XB2, 0X40, 0X10, 0X01, 0X60, 0X01,
            0X32, 0XD0, 0XD8, 0X00, 0X03, 0X43, 0X0C, 0X43, 0X30, 0X41, 0X21, 0X83, 0X0A, 0X4C, 0X81, 0X4A,
            0X00, 0X00, 0X0D, 0X41, 0X5C, 0X43, 0XB0, 0X12, 0X84, 0X80, 0XF9, 0X3F, 0XF2, 0XE0, 0X80, 0X00,
            0X21, 0X00, 0X92, 0XC3, 0X62, 0X01, 0X00, 0X13, 0X30, 0X40, 0X5E, 0X80, 0X30, 0X40, 0X7C, 0X80,
            0X30, 0X41, 0XFF, 0X3F};

    public int getStartAdress() {
        return startAdress;
    }

    public int[] getData() {
        return data;
    }
}
