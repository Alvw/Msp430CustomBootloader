package com.biorecorder.comport;

public class CrcCalculator {
    public static int CRC16_POLY = 0x1021;


    public static int crcAddByte(int dataByte, int crc) {
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



    public static void main(String[] args) {
        int crc = 0xFFFF;
        int crcResult = crcAddByte(0x19,crc);
        System.out.printf("val=%x \n",crcResult);
//0x62e8
    }
}
