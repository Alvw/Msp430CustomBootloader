package com.biorecorder.comport;

import java.util.List;

public class ComPortPacket {
    private List<Byte> packet;
    private int delay;

    public ComPortPacket(List<Byte> packet, int delay) {
        this.packet = packet;
        this.delay = delay;
    }

    public List<Byte> getPacket() {
        return packet;
    }

    public void setPacket(List<Byte> packet) {
        this.packet = packet;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
}
