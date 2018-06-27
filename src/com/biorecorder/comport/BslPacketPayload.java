package com.biorecorder.comport;

public class BslPacketPayload {
    int command = 0x10; //RX_Data_block
    int ui8Addr_H;
    int ui8Addr_L;
    int dataIndex;
    int[] data;
}
