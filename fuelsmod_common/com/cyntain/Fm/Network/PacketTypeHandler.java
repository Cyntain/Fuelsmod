package com.cyntain.Fm.Network;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import com.cyntain.Fm.Network.packet.PacketFm;
import com.cyntain.Fm.Network.packet.PacketTileUpdate;
import com.cyntain.Fm.lib.Reference;

import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;

public enum PacketTypeHandler {
     
    TILE(PacketTileUpdate.class);
   
    
    private Class<? extends PacketFm> clazz;

    PacketTypeHandler(Class<? extends PacketFm> clazz) {

        this.clazz = clazz;
    }

    public static PacketFm buildPacket(byte[] data) {

        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        int selector = bis.read();
        DataInputStream dis = new DataInputStream(bis);

        PacketFm packet = null;

        try {
            packet = values()[selector].clazz.newInstance();
        }
        catch (Exception e) {
            e.printStackTrace(System.err);
        }

        packet.readPopulate(dis);

        return packet;
    }

    public static PacketFm buildPacket(PacketTypeHandler type) {

        PacketFm packet = null;

        try {
            packet = values()[type.ordinal()].clazz.newInstance();
        }
        catch (Exception e) {
            e.printStackTrace(System.err);
        }

        return packet;
    }

    public static Packet populatePacket(PacketFm packetEE) {

        byte[] data = packetEE.populate();

        Packet250CustomPayload packet250 = new Packet250CustomPayload();
        packet250.channel = Reference.CHANNEL_NAME;
        packet250.data = data;
        packet250.length = data.length;
        packet250.isChunkDataPacket = packetEE.isChunkDataPacket;

        return packet250;
    }
}