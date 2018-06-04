package com.biorecorder.comport;


import jssc.SerialPortException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;

public class CallBackManager implements ComPortListener{
    private ComPort comPort;
    private int rxCntr;
    private byte[] rxData = new byte[50];
    private List<ComPortPacket> commandsSet = new ArrayList<ComPortPacket>();
    private int comandCounter = 0;
    private int delay;
    private static Log LOG = LogFactory.getLog(CallBackManager.class);

    public CallBackManager(){
        int cmd = 0x19;
        int crc = CrcCalculator.crcAddByte(cmd,0xFFFF);
        int crc_h = crc>>8;
        int crc_l = crc & 0xFF;
        byte[] bytes = new byte[]{((byte)0x80),((byte)0x01),((byte)cmd),((byte)crc_h),((byte)crc_l)};
        commandsSet.add(new ComPortPacket(bytesToBiteList(bytes),100));
        try {
            comPort = new ComPort("COM32", 9600);
        } catch (SerialPortException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        comPort.setComPortListener(this);
    }

    public void onExit(){
        comPort.disconnect();
    }

    @Override
    public void onByteReceived(byte inByte) {
        rxData[rxCntr++] = inByte;
        System.out.println(inByte );
        /*if(inByte == '\n'){
            onResponceReceived(rxCntr);
            rxCntr = 0;
        }*/
    }

    private void onResponceReceived(int rxCntr) {
        String resp = new String(rxData, 0, rxCntr);


        LOG.info("In: " + resp);
        if("OK\r\n".equals(resp)) {
            sendCommand();
        }
    }



    public void startProgramming() {
        sendCommand();
    }

    private void sendCommand(){
        if(comandCounter < commandsSet.size()) {
            ComPortPacket command = commandsSet.get(comandCounter++);
            if(delay != 0){
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            delay = command.getDelay();
            List<Byte>  bytеList = command.getPacket();
            LOG.info("Out: " + bytеList);
            comPort.writeToPort(bytеList);
        }  else{
            LOG.info("End of the command set");
        }
    }

    private static List<Byte> bytesToBiteList(byte[] b){
        List<Byte> result = new ArrayList<Byte>();
        for (int i = 0; i < b.length; i++) {
            byte aByte = b[i];
            result.add(aByte);
        }
        return result;
    }


}
