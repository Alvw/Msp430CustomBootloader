package com.biorecorder.comport;

import java.util.ArrayList;
import java.util.List;

public class Bsl {

    public static int CRC16_POLY = 0x1021;



    public List<ComPortPacket> BSL_programMemorySegment(AddressSegment addressSegment){

        List<ComPortPacket> packets = new ArrayList<ComPortPacket>();
        BslPacket tPacket  = new BslPacket();
        tPacket.tPayload = new BslPacketPayload();
        int len = addressSegment .getData().length;
        int xferLen;
        int addr = addressSegment.getStartAdress();
        int dataInd  = 0;
        int result = 1;
        while (len > 0){
            if (len > 16)
            {
                xferLen = 16;
            } else
            {
                xferLen = len;
            }
            tPacket.tPayload.data = addressSegment .getData();
            tPacket.tPayload.dataIndex = dataInd;
            tPacket.ui8Length = xferLen + 3;
            tPacket.tPayload.ui8Addr_H = (addr >> 8);
            tPacket.tPayload.ui8Addr_L = (addr & 0xFF);
            tPacket.ui16Checksum = crc16MakeBitwise(tPacket);
            packets.add(new ComPortPacket(bsl_sendPacket(tPacket),100));

            len -= xferLen;
            addr += xferLen;
            dataInd += xferLen;
        }
        return packets;
    }

    private int crc16MakeBitwise(BslPacket tPacket) {
        int i;
        int crc = 0xFFFF;
        int dataIndex = tPacket.tPayload.dataIndex;

        int msg_size = tPacket.ui8Length;

        for(i = 0 ; i < msg_size ; i ++){
            if(i == 0) {
                crc = crc16AddByte(tPacket.tPayload.command, crc);
            }else if(i==1){
                crc = crc16AddByte(tPacket.tPayload.ui8Addr_L, crc);
            }else if(i==2){
                crc = crc16AddByte(tPacket.tPayload.ui8Addr_H, crc);
            }else if(i > 2){
                crc = crc16AddByte(tPacket.tPayload.data[i+dataIndex-3], crc);
            }
        }
        return(crc);
    }

    private int crc16AddByte(int dataByte, int crc){
        int msg = dataByte << 8;
        for (int j = 0; j < 8; j++) {
            if(((msg ^ crc)>>15)== 1){
                crc = ((crc << 1) ^ CRC16_POLY)&0xFFFF;
            }else {
                crc = (crc << 1) & 0xFFFF;
            }
            msg = (msg << 1) & 0xFFFF;
        }
        return crc;
    }

    private int[] bsl_sendPacket(BslPacket tPacket){
        int[] bytes = new int[tPacket.ui8Length+4];
        bytes[0] = (0x80);
        bytes[1] = (tPacket.ui8Length);
        bytes[2] = (tPacket.tPayload.command);
        bytes[3] = (tPacket.tPayload.ui8Addr_L);
        bytes[4] = (tPacket.tPayload.ui8Addr_H);
        for (int ii=0; ii < (tPacket.ui8Length-3); ii++){
            bytes [5+ii]=tPacket.tPayload.data[tPacket.tPayload.dataIndex+ii];
        }
        bytes[tPacket.ui8Length +2] = (tPacket.ui16Checksum & 0xFF);
        bytes[tPacket.ui8Length +3] = (tPacket.ui16Checksum >> 8);
        /*for (int i = 0; i < bytes.length; i++) {
            System.out.printf("val=%x \n",bytes[i]);
        }*/
        return bytes;
    }

}
