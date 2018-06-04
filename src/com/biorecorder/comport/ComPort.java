package com.biorecorder.comport;


import jssc.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.List;

public class ComPort implements SerialPortEventListener {

    private static Log log = LogFactory.getLog(ComPort.class);
    SerialPort comPort;
    private ComPortListener comPortListener;
    private String comPortName;

    public ComPort(String comPortName, int speed) throws SerialPortException {
        boolean isComPortExist = false;
        this.comPortName = comPortName;
        comPortName.trim();
        String[] portNames = SerialPortList.getPortNames();
        for (int i = 0; i < portNames.length; i++) {
            if (comPortName != null && comPortName.equalsIgnoreCase(portNames[i])) {
                isComPortExist = true;
            }
        }

        if (!isComPortExist) {
            String msg = "No port with the name " + comPortName;
            throw new ComPortException(msg);
        }
        comPort = new SerialPort(comPortName);
        if (!comPort.isOpened()) {
            comPort.openPort();//Open serial port
            comPort.setParams(speed,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
            comPort.setEventsMask(SerialPort.MASK_RXCHAR);
            comPort.addEventListener(this);
//            comPort.setRTS(false);

        }
    }



    public String getComPortName(){
        return comPortName;
    }

    public boolean isConnected(){
        return comPort.isOpened();
    }

    public void disconnect() {
        if (comPort.isOpened()) {
            try {
                comPort.closePort();

            } catch (SerialPortException e) {
                log.error(e);
            }
        }
    }

    public void writeToPort(List<Byte> bytes) {
        if (comPort.isOpened()) {
                final byte[] bytesArray = new byte[bytes.size()];
                for (int i = 0; i < bytes.size(); i++) {
                    bytesArray[i] = bytes.get(i);
                }
            Runnable rnbl = new Runnable() {
                @Override
                public void run() {
                    try {
                        comPort.writeBytes(bytesArray);
                    } catch (SerialPortException ex) {
                        log.error(ex);
                    }
                }
            };
            Thread thrd = new Thread(rnbl);
            thrd.start();
        } else {
            log.warn("Com port disconnected. Can't write to port.");
        }
    }

    public void setComPortListener(ComPortListener comPortListener) {
        this.comPortListener = comPortListener;
    }

    @Override
    public void serialEvent(SerialPortEvent event) {
        if (event.isRXCHAR() && event.getEventValue() > 0) {
            try {
                byte[] buffer = comPort.readBytes();
                for (int i = 0; i < buffer.length; i++) {
                    if (comPortListener != null) {
                        comPortListener.onByteReceived((buffer[i]));
                    }
                }
            } catch (SerialPortException ex) {
                log.error(ex);
            }
        }
    }

    public static  String[] getportNames() {
        return SerialPortList.getPortNames();
    }
}
