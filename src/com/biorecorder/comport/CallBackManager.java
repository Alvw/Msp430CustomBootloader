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
    public static final int DEL_APP_CMD = 0x15;
    public static final int TX_VERSION_CMD = 0x19;
    public static final int JUMP2APP_CMD = 0x1c;
    private static Log LOG = LogFactory.getLog(CallBackManager.class);

    public CallBackManager(){

         //commandsSet.add(createBslCommand(TX_VERSION_CMD));
       commandsSet.add(createBslCommand(DEL_APP_CMD));
       /*.   commandsSet.addAll(new Bsl().BSL_programMemorySegment(new AddressSegment1()));
        commandsSet.addAll(new Bsl().BSL_programMemorySegment(new AddressSegment2()));
        commandsSet.addAll(new Bsl().BSL_programMemorySegment(new AddressSegmentCrc()));
        commandsSet.add(createBslCommand(JUMP2APP_CMD));*/
        try {
            comPort = new ComPort("COM21", 460800);
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
        System.out.printf("val=%x \n",inByte);
        if(inByte == 0){
            sendCommand();
        }else {
            System.out.printf("send command fail. inByte = " + inByte );
        }
    }

    /*private void onResponceReceived(int rxCntr) {
        String resp = new String(rxData, 0, rxCntr);


        LOG.info("In: " + resp);
        if("OK\r\n".equals(resp)) {
            sendCommand();
        }
    }*/


    private ComPortPacket createBslCommand(int cmd){
        int crc = CrcCalculator.crcAddByte(cmd,0xFFFF);
        int[] bslPacket = new int[]{0x80,0x01,cmd,crc&0xFF,crc>>8};
        return new ComPortPacket(bslPacket,100);
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
            List<Byte>  bytеList = bytesToBiteList(command.getPacket());
            LOG.info("Out: " + bytеList);
            for (int i = 0; i < bytеList.size(); i++) {
                byte aByte = bytеList.get(i);
                System.out.printf("val=%x \n",aByte&0xFF);
            }
            comPort.writeToPort(bytеList);
        }  else{
            LOG.info("End of the command set");
        }
    }

    private static List<Byte> bytesToBiteList(int[] b){
        List<Byte> result = new ArrayList<Byte>();
        for (int i = 0; i < b.length; i++) {
            byte aByte = (byte)b[i];
            result.add(aByte);
        }
        return result;
    }


}
