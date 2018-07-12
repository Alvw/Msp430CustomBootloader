package com.biorecorder.comport;

import java.util.ArrayList;
import java.util.List;

public class TmpUtils {
    public static int APP_START_ADDRESS = 0x8003;
    public static int APP_END_ADDRESS = 0xF9FF;
    List<AddressSegment> appData = new ArrayList<AddressSegment>();

    public TmpUtils() {
        appData.add(new AddressSegment1());
        appData.add(new AddressSegment2());
//        appData.add(new AddressSegment3());
//        appData.add(new AddressSegment4());
    }
    
    public int getAppCrc(){
        int crc = 0xFFFF;
        for (int addr = APP_START_ADDRESS; addr <= APP_END_ADDRESS; addr++) {
            int i;
            for (i = 0; i < appData.size(); i++) {
                AddressSegment addressSegment =  appData.get(i);
                int segmentStartAddr = addressSegment.getStartAdress();
                int segmentSize = addressSegment.getData().length;
                if((addr>=segmentStartAddr)&&(addr<(segmentStartAddr + segmentSize))){
                    crc = CrcCalculator.crcAddByte(addressSegment.getData()[addr - segmentStartAddr],crc);
                    break;
                }
            }
            if(i==appData.size()){
                 crc = CrcCalculator.crcAddByte(0xFF,crc);
            }
        }
        return crc;
    }

    public static void main(String[] args) {
        TmpUtils tmpUtils = new TmpUtils();
        int appCrc = tmpUtils.getAppCrc();
        System.out.println(appCrc);
        System.out.printf("val=%x \n",appCrc);//61852
    }

}
