package com.biorecorder.comport;

public class AddressSegment1 implements AddressSegment{
    public final int startAdress = 0xc004;

    public final int[] data = new int[]{
            0xb2,0x40,0x80,0x5a,0x20,0x01,0xd2,0xd3,0x22,0x00,0xd2,0xd3,0x21,0x00,0x0d,0x12,
            0x0e,0x12,0x3d,0x40,0x44,0x28,0x1e,0x43,0x1d,0x83,0x0e,0x73,0xfd,0x23,0x0d,0x93,
            0xfb,0x23,0x3e,0x41,0x3d,0x41,0x00,0x3c,0x03,0x43,0xd2,0xc3,0x21,0x00,0x0d,0x12,
            0x0e,0x12,0x3d,0x40,0x44,0x28,0x1e,0x43,0x1d,0x83,0x0e,0x73,0xfd,0x23,0x0d,0x93,
            0xfb,0x23,0x3e,0x41,0x3d,0x41,0x00,0x3c,0x03,0x43,0xd2,0xd3,0x21,0x00,0x0d,0x12,
            0x0e,0x12,0x3d,0x40,0x44,0x28,0x1e,0x43,0x1d,0x83,0x0e,0x73,0xfd,0x23,0x0d,0x93,
            0xfb,0x23,0x3e,0x41,0x3d,0x41,0x00,0x3c,0x03,0x43,0xd2,0xc3,0x21,0x00,0xf2,0xd2,
            0x21,0x00,0xf2,0xd2,0x27,0x00,0xf2,0xd2,0x24,0x00,0xf2,0xd2,0x25,0x00,0xb2,0x40,
            0x10,0x00,0x62,0x01,0xb2,0x40,0xe7,0x03,0x72,0x01,0xb2,0x40,0x10,0x01,0x60,0x01,
            0x32,0xd0,0xd8,0x00,0x0c,0x43,0x30,0x41,0x0a,0x12,0x09,0x12,0x3f,0x40,0x00,0x00,
            0x3f,0x90,0x01,0x00,0x19,0x28,0x3f,0x40,0x00,0x00,0x3f,0x90,0x01,0x00,0x14,0x28,
            0x3a,0x40,0x00,0x00,0x3a,0x80,0x00,0x00,0x3a,0x50,0x03,0x00,0x0a,0x11,0x0a,0x11,
            0x39,0x40,0x00,0x00,0x3c,0x49,0x7f,0x4c,0x4f,0x4f,0x0f,0x5f,0x1f,0x4f,0x00,0x00,
            0x3d,0x49,0x8f,0x12,0x1a,0x83,0xf6,0x23,0x3f,0x40,0x00,0x00,0x3f,0x90,0x00,0x00,
            0x08,0x24,0x3a,0x40,0x00,0x00,0x02,0x3c,0x3f,0x4a,0x8f,0x12,0x3a,0x90,0x00,0x00,
            0xfb,0x23,0x30,0x40,0x52,0xc1,0x0f,0x12,0x0e,0x12,0x0d,0x12,0x0c,0x12,0x0b,0x12,
            0xc2,0x43,0x23,0x00,0xb0,0x12,0x32,0xc1,0x3b,0x41,0x3c,0x41,0x3d,0x41,0x3e,0x41,
            0x3f,0x41,0x00,0x13,0x31,0x40,0x00,0x04,0xb0,0x12,0x62,0xc1,0x0c,0x93,0x02,0x24,
            0xb0,0x12,0x9c,0xc0,0x0c,0x43,0xb0,0x12,0x04,0xc0,0xb0,0x12,0x66,0xc1,0xb2,0x40,
            0xde,0xc0,0x00,0x02,0xd2,0xd3,0x02,0x02,0x32,0xc2,0x03,0x43,0xb2,0x40,0x0b,0x5a,
            0x20,0x01,0xff,0x3f,0x34,0x41,0x35,0x41,0x36,0x41,0x37,0x41,0x38,0x41,0x39,0x41,
            0x3a,0x41,0x30,0x41,0xd2,0xe3,0x21,0x00,0x92,0xc3,0x62,0x01,0x00,0x13,0x1c,0x43,
            0x30,0x41,0x03,0x43,0xff,0x3f,0xff,0x3f};

    public int getStartAdress() {
        return startAdress;
    }

    public int[] getData() {
        return data;
    }
}
