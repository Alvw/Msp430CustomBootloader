package com.biorecorder.comport;

import java.util.List;

public class ComPortPacket {
    private int[] packet;
    private int delay;

    public ComPortPacket(int[] packet, int delay) {
        this.packet = packet;
        this.delay = delay;
    }

    public int[] getPacket() {
        return packet;
    }

    public void setPacket(int[] packet) {
        this.packet = packet;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
}
