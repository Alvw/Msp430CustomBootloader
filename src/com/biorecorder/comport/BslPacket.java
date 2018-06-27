package com.biorecorder.comport;

public class BslPacket {
    int ui8Length;
    BslPacketPayload tPayload;
    int ui16Checksum;
}
